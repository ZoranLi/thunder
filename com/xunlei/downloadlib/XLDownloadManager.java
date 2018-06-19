package com.xunlei.downloadlib;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.android.XLUtil;
import com.xunlei.downloadlib.android.XLUtil.GUID_TYPE;
import com.xunlei.downloadlib.android.XLUtil.GuidInfo;
import com.xunlei.downloadlib.android.XLUtil.NetWorkCarrier;
import com.xunlei.downloadlib.parameter.BtIndexSet;
import com.xunlei.downloadlib.parameter.BtSubTaskDetail;
import com.xunlei.downloadlib.parameter.BtTaskParam;
import com.xunlei.downloadlib.parameter.BtTaskStatus;
import com.xunlei.downloadlib.parameter.CIDTaskParam;
import com.xunlei.downloadlib.parameter.DcdnPeerResParam;
import com.xunlei.downloadlib.parameter.EmuleTaskParam;
import com.xunlei.downloadlib.parameter.ErrorCodeToMsg;
import com.xunlei.downloadlib.parameter.GetBooleanParam;
import com.xunlei.downloadlib.parameter.GetDownloadHead;
import com.xunlei.downloadlib.parameter.GetDownloadLibVersion;
import com.xunlei.downloadlib.parameter.GetFileName;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.InitParam;
import com.xunlei.downloadlib.parameter.MagnetTaskParam;
import com.xunlei.downloadlib.parameter.MaxDownloadSpeedParam;
import com.xunlei.downloadlib.parameter.P2spTaskParam;
import com.xunlei.downloadlib.parameter.PeerResourceParam;
import com.xunlei.downloadlib.parameter.ServerResourceParam;
import com.xunlei.downloadlib.parameter.ThunderUrlInfo;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.UrlQuickInfo;
import com.xunlei.downloadlib.parameter.XLConstant.XLErrorCode;
import com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus;
import com.xunlei.downloadlib.parameter.XLRangeInfo;
import com.xunlei.downloadlib.parameter.XLSessionInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfoEx;
import com.xunlei.downloadlib.parameter.XLTaskLocalUrl;
import java.io.File;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class XLDownloadManager {
    private static final int GET_GUID_FIRST_TIME = 5000;
    private static final int GET_GUID_INTERVAL_TIME = 60000;
    private static final int QUERY_GUID_COUNT = 5;
    private static final String TAG = "XLDownloadManager";
    private static boolean mAllowExecution = true;
    public static XLManagerStatus mDownloadManagerState = XLManagerStatus.MANAGER_UNINIT;
    private static Map<String, Object> mErrcodeStringMap = null;
    private static XLDownloadManager mInstance = null;
    private static boolean mIsLoadErrcodeMsg = false;
    private static int mRunningRefCount;
    private Context mContext;
    private Timer mGetGuidTimer;
    private TimerTask mGetGuidTimerTask;
    private XLLoader mLoader;
    private int mQueryGuidCount;
    private NetworkChangeReceiver mReceiver;

    class NetworkChangeHandlerThread implements Runnable {
        private boolean m_allow_execution = true;
        private Context m_context = null;
        private XLLoader m_loader = null;

        public NetworkChangeHandlerThread(Context context, XLLoader xLLoader, boolean z) {
            this.m_context = context;
            this.m_loader = xLLoader;
            this.m_allow_execution = z;
        }

        public void run() {
            if (this.m_allow_execution) {
                int networkTypeComplete = XLUtil.getNetworkTypeComplete(this.m_context);
                String str = XLDownloadManager.TAG;
                StringBuilder stringBuilder = new StringBuilder("NetworkChangeHandlerThread nettype=");
                stringBuilder.append(networkTypeComplete);
                XLLog.d(str, stringBuilder.toString());
                XLDownloadManager.this.notifyNetWorkType(networkTypeComplete, this.m_loader);
                String bssid = XLUtil.getBSSID(this.m_context);
                str = XLDownloadManager.TAG;
                stringBuilder = new StringBuilder("NetworkChangeHandlerThread bssid=");
                stringBuilder.append(bssid);
                XLLog.d(str, stringBuilder.toString());
                XLDownloadManager.this.notifyWifiBSSID(bssid, this.m_loader);
                NetWorkCarrier netWorkCarrier = XLUtil.getNetWorkCarrier(this.m_context);
                str = XLDownloadManager.TAG;
                stringBuilder = new StringBuilder("NetworkChangeHandlerThread NetWorkCarrier=");
                stringBuilder.append(netWorkCarrier);
                XLLog.d(str, stringBuilder.toString());
                XLDownloadManager.this.notifyNetWorkCarrier(netWorkCarrier.ordinal());
            }
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        private static final String TAG = "TAG_DownloadReceiver";

        public void onReceive(Context context, Intent intent) {
            intent = intent.getAction();
            if (intent != null && intent.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
                new Thread(new NetworkChangeHandlerThread(context, XLDownloadManager.this.mLoader, XLDownloadManager.mAllowExecution)).start();
            }
        }
    }

    public static Application getInitialApplication() {
        return null;
    }

    public static synchronized XLDownloadManager getInstance() {
        XLDownloadManager xLDownloadManager;
        synchronized (XLDownloadManager.class) {
            if (mInstance == null) {
                mInstance = new XLDownloadManager();
            }
            xLDownloadManager = mInstance;
        }
        return xLDownloadManager;
    }

    public static synchronized XLDownloadManager getInstance(String str) {
        synchronized (XLDownloadManager.class) {
            if (mInstance == null) {
                mInstance = new XLDownloadManager(str);
            }
            str = mInstance;
        }
        return str;
    }

    public static synchronized XLDownloadManager getInstance(Context context) {
        synchronized (XLDownloadManager.class) {
            if (mInstance == null) {
                mInstance = new XLDownloadManager(context);
            }
            context = mInstance;
        }
        return context;
    }

    private XLDownloadManager() {
        this.mLoader = null;
        this.mContext = null;
        this.mReceiver = null;
        this.mQueryGuidCount = 0;
        this.mLoader = new XLLoader();
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    private XLDownloadManager(String str) {
        this.mLoader = null;
        this.mContext = null;
        this.mReceiver = null;
        this.mQueryGuidCount = 0;
        this.mLoader = new XLLoader(str);
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    private XLDownloadManager(Context context) {
        this.mLoader = null;
        this.mContext = null;
        this.mReceiver = null;
        this.mQueryGuidCount = 0;
        this.mLoader = new XLLoader(context);
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    public XLManagerStatus getManagerStatus() {
        return mDownloadManagerState;
    }

    private void doMonitorNetworkChange() {
        XLLog.i(TAG, "doMonitorNetworkChange()");
        if (this.mContext != null && this.mReceiver == null) {
            this.mReceiver = new NetworkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            XLLog.i(TAG, "register Receiver");
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private void undoMonitorNetworkChange() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "XLDownloadManager";
        r1 = "undoMonitorNetworkChange()";
        com.xunlei.downloadlib.android.XLLog.i(r0, r1);
        r0 = r2.mContext;
        if (r0 == 0) goto L_0x0028;
    L_0x000b:
        r0 = r2.mReceiver;
        if (r0 == 0) goto L_0x0028;
    L_0x000f:
        r0 = r2.mContext;	 Catch:{ IllegalArgumentException -> 0x001e }
        r1 = r2.mReceiver;	 Catch:{ IllegalArgumentException -> 0x001e }
        r0.unregisterReceiver(r1);	 Catch:{ IllegalArgumentException -> 0x001e }
        r0 = "XLDownloadManager";	 Catch:{ IllegalArgumentException -> 0x001e }
        r1 = "unregister Receiver";	 Catch:{ IllegalArgumentException -> 0x001e }
        com.xunlei.downloadlib.android.XLLog.i(r0, r1);	 Catch:{ IllegalArgumentException -> 0x001e }
        goto L_0x0025;
    L_0x001e:
        r0 = "XLDownloadManager";
        r1 = "Receiver not registered";
        com.xunlei.downloadlib.android.XLLog.e(r0, r1);
    L_0x0025:
        r0 = 0;
        r2.mReceiver = r0;
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.XLDownloadManager.undoMonitorNetworkChange():void");
    }

    private synchronized void increRefCount() {
        mRunningRefCount++;
    }

    private synchronized void decreRefCount() {
        mRunningRefCount--;
    }

    public synchronized int init(Context context, InitParam initParam) {
        return init(context, initParam, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int init(android.content.Context r12, com.xunlei.downloadlib.parameter.InitParam r13, boolean r14) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = mIsLoadErrcodeMsg;	 Catch:{ all -> 0x00c3 }
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r11.loadErrcodeString(r12);	 Catch:{ all -> 0x00c3 }
        r0 = 1;
        mIsLoadErrcodeMsg = r0;	 Catch:{ all -> 0x00c3 }
    L_0x000b:
        r0 = 9900; // 0x26ac float:1.3873E-41 double:4.8912E-320;
        if (r12 == 0) goto L_0x00c1;
    L_0x000f:
        if (r13 == 0) goto L_0x00c1;
    L_0x0011:
        r1 = r13.checkMemberVar();	 Catch:{ all -> 0x00c3 }
        if (r1 != 0) goto L_0x0019;
    L_0x0017:
        goto L_0x00c1;
    L_0x0019:
        r11.mContext = r12;	 Catch:{ all -> 0x00c3 }
        mAllowExecution = r14;	 Catch:{ all -> 0x00c3 }
        r14 = mDownloadManagerState;	 Catch:{ all -> 0x00c3 }
        r1 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_RUNNING;	 Catch:{ all -> 0x00c3 }
        if (r14 != r1) goto L_0x002c;
    L_0x0023:
        r12 = "XLDownloadManager";
        r13 = "XLDownloadManager is already init";
        com.xunlei.downloadlib.android.XLLog.i(r12, r13);	 Catch:{ all -> 0x00c3 }
        monitor-exit(r11);
        return r0;
    L_0x002c:
        r14 = r11.mLoader;	 Catch:{ all -> 0x00c3 }
        if (r14 == 0) goto L_0x00bf;
    L_0x0030:
        r5 = r11.getPeerid();	 Catch:{ all -> 0x00c3 }
        r6 = r11.getGuid();	 Catch:{ all -> 0x00c3 }
        r14 = "XLDownloadManager";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r1 = "Peerid:";
        r0.<init>(r1);	 Catch:{ all -> 0x00c3 }
        r1 = new java.lang.String;	 Catch:{ all -> 0x00c3 }
        r2 = r5.getBytes();	 Catch:{ all -> 0x00c3 }
        r3 = 0;
        r2 = android.util.Base64.encode(r2, r3);	 Catch:{ all -> 0x00c3 }
        r1.<init>(r2);	 Catch:{ all -> 0x00c3 }
        r0.append(r1);	 Catch:{ all -> 0x00c3 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c3 }
        com.xunlei.downloadlib.android.XLLog.i(r14, r0);	 Catch:{ all -> 0x00c3 }
        r14 = "XLDownloadManager";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r1 = "Guid:";
        r0.<init>(r1);	 Catch:{ all -> 0x00c3 }
        r1 = new java.lang.String;	 Catch:{ all -> 0x00c3 }
        r2 = r6.getBytes();	 Catch:{ all -> 0x00c3 }
        r2 = android.util.Base64.encode(r2, r3);	 Catch:{ all -> 0x00c3 }
        r1.<init>(r2);	 Catch:{ all -> 0x00c3 }
        r0.append(r1);	 Catch:{ all -> 0x00c3 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c3 }
        com.xunlei.downloadlib.android.XLLog.i(r14, r0);	 Catch:{ all -> 0x00c3 }
        r14 = mAllowExecution;	 Catch:{ all -> 0x00c3 }
        if (r14 == 0) goto L_0x0083;
    L_0x007d:
        r14 = com.xunlei.downloadlib.android.XLUtil.getNetworkTypeComplete(r12);	 Catch:{ all -> 0x00c3 }
        r9 = r14;
        goto L_0x0084;
    L_0x0083:
        r9 = r3;
    L_0x0084:
        r1 = r11.mLoader;	 Catch:{ all -> 0x00c3 }
        r3 = r13.mAppVersion;	 Catch:{ all -> 0x00c3 }
        r4 = "";
        r7 = r13.mStatSavePath;	 Catch:{ all -> 0x00c3 }
        r8 = r13.mStatCfgSavePath;	 Catch:{ all -> 0x00c3 }
        r10 = r13.mPermissionLevel;	 Catch:{ all -> 0x00c3 }
        r2 = r12;
        r0 = r1.init(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x00c3 }
        r12 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
        if (r0 == r12) goto L_0x00b1;
    L_0x0099:
        r12 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_INIT_FAIL;	 Catch:{ all -> 0x00c3 }
        mDownloadManagerState = r12;	 Catch:{ all -> 0x00c3 }
        r12 = "XLDownloadManager";
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c3 }
        r14 = "XLDownloadManager init failed ret=";
        r13.<init>(r14);	 Catch:{ all -> 0x00c3 }
        r13.append(r0);	 Catch:{ all -> 0x00c3 }
        r13 = r13.toString();	 Catch:{ all -> 0x00c3 }
        com.xunlei.downloadlib.android.XLLog.e(r12, r13);	 Catch:{ all -> 0x00c3 }
        goto L_0x00bf;
    L_0x00b1:
        r12 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_RUNNING;	 Catch:{ all -> 0x00c3 }
        mDownloadManagerState = r12;	 Catch:{ all -> 0x00c3 }
        r11.doMonitorNetworkChange();	 Catch:{ all -> 0x00c3 }
        r12 = "PhoneModel";
        r13 = android.os.Build.MODEL;	 Catch:{ all -> 0x00c3 }
        r11.setLocalProperty(r12, r13);	 Catch:{ all -> 0x00c3 }
    L_0x00bf:
        monitor-exit(r11);
        return r0;
    L_0x00c1:
        monitor-exit(r11);
        return r0;
    L_0x00c3:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.XLDownloadManager.init(android.content.Context, com.xunlei.downloadlib.parameter.InitParam, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int uninit() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = mRunningRefCount;	 Catch:{ all -> 0x0035 }
        r1 = 9900; // 0x26ac float:1.3873E-41 double:4.8912E-320;
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = "XLDownloadManager";
        r2 = "some function of XLDownloadManager is running, uninit failed!";
        com.xunlei.downloadlib.android.XLLog.i(r0, r2);	 Catch:{ all -> 0x0035 }
        monitor-exit(r3);
        return r1;
    L_0x0010:
        r0 = mDownloadManagerState;	 Catch:{ all -> 0x0035 }
        r2 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_UNINIT;	 Catch:{ all -> 0x0035 }
        if (r0 == r2) goto L_0x0033;
    L_0x0016:
        r0 = r3.mLoader;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0033;
    L_0x001a:
        r0 = mDownloadManagerState;	 Catch:{ all -> 0x0035 }
        r1 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_RUNNING;	 Catch:{ all -> 0x0035 }
        if (r0 != r1) goto L_0x0023;
    L_0x0020:
        r3.undoMonitorNetworkChange();	 Catch:{ all -> 0x0035 }
    L_0x0023:
        r3.stopGetGuidTimer();	 Catch:{ all -> 0x0035 }
        r0 = r3.mLoader;	 Catch:{ all -> 0x0035 }
        r1 = r0.unInit();	 Catch:{ all -> 0x0035 }
        r0 = com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus.MANAGER_UNINIT;	 Catch:{ all -> 0x0035 }
        mDownloadManagerState = r0;	 Catch:{ all -> 0x0035 }
        r0 = 0;
        r3.mContext = r0;	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);
        return r1;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.XLDownloadManager.uninit():int");
    }

    int notifyNetWorkType(int i, XLLoader xLLoader) {
        if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && xLLoader != null) {
            try {
                return xLLoader.notifyNetWorkType(i);
            } catch (int i2) {
                xLLoader = TAG;
                StringBuilder stringBuilder = new StringBuilder("notifyNetWorkType failed,");
                stringBuilder.append(i2.getMessage());
                XLLog.e(xLLoader, stringBuilder.toString());
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int createP2spTask(P2spTaskParam p2spTaskParam, GetTaskId getTaskId) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (!(p2spTaskParam == null || getTaskId == null)) {
            if (p2spTaskParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) {
                    p2spTaskParam = TAG;
                    getTaskId = new StringBuilder("createP2spTask failed, mDownloadManagerState=");
                    getTaskId.append(mDownloadManagerState);
                    XLLog.e(p2spTaskParam, getTaskId.toString());
                } else {
                    i = this.mLoader.createP2spTask(p2spTaskParam.mUrl, p2spTaskParam.mRefUrl, p2spTaskParam.mCookie, p2spTaskParam.mUser, p2spTaskParam.mPass, p2spTaskParam.mFilePath, p2spTaskParam.mFileName, p2spTaskParam.mCreateMode, p2spTaskParam.mSeqId, getTaskId);
                    if (i != 9000) {
                        p2spTaskParam = TAG;
                        getTaskId = new StringBuilder("createP2spTask failed, ret=");
                        getTaskId.append(i);
                        XLLog.e(p2spTaskParam, getTaskId.toString());
                    }
                }
                decreRefCount();
                return i;
            }
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("createP2spTask failed, para=");
        stringBuilder.append(p2spTaskParam);
        stringBuilder.append(", cTaskId=");
        stringBuilder.append(getTaskId);
        XLLog.e(str, stringBuilder.toString());
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int releaseTask(long j) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.releaseTask(j);
        decreRefCount();
        return j;
    }

    public int setTaskAllowUseResource(long j, int i) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setTaskAllowUseResource(j, i);
        decreRefCount();
        return j;
    }

    public int setTaskUid(long j, int i) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setTaskUid(j, i);
        decreRefCount();
        return j;
    }

    public int startTask(long j, boolean z) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.startTask(j, z);
        decreRefCount();
        return j;
    }

    public int startTask(long j) {
        return startTask(j, false);
    }

    int switchOriginToAllResDownload(long j) {
        return (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? 9900 : this.mLoader.switchOriginToAllResDownload(j);
    }

    public int stopTask(long j) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.stopTask(j);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLStopTask()----- ret=");
        stringBuilder.append(j);
        XLLog.i(str, stringBuilder.toString());
        decreRefCount();
        return j;
    }

    public int stopTaskWithReason(long j, int i) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.stopTaskWithReason(j, i);
        String str = TAG;
        i = new StringBuilder("XLStopTask()----- ret=");
        i.append(j);
        XLLog.i(str, i.toString());
        decreRefCount();
        return j;
    }

    public int getTaskInfo(long j, int i, XLTaskInfo xLTaskInfo) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || xLTaskInfo == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getTaskInfo(j, i, xLTaskInfo);
        decreRefCount();
        return j;
    }

    public int getTaskInfoEx(long j, XLTaskInfoEx xLTaskInfoEx) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || xLTaskInfoEx == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getTaskInfoEx(j, xLTaskInfoEx);
        decreRefCount();
        return j;
    }

    public int getLocalUrl(String str, XLTaskLocalUrl xLTaskLocalUrl) {
        increRefCount();
        str = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || xLTaskLocalUrl == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getLocalUrl(str, xLTaskLocalUrl);
        decreRefCount();
        return str;
    }

    public int addServerResource(long j, ServerResourceParam serverResourceParam) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (serverResourceParam != null) {
            if (serverResourceParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder("respara.mUrl=");
                    stringBuilder.append(serverResourceParam.mUrl);
                    XLLog.i(str, stringBuilder.toString());
                    i = this.mLoader.addServerResource(j, serverResourceParam.mUrl, serverResourceParam.mRefUrl, serverResourceParam.mCookie, serverResourceParam.mResType, serverResourceParam.mStrategy);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int addPeerResource(long j, PeerResourceParam peerResourceParam) {
        XLDownloadManager xLDownloadManager = this;
        PeerResourceParam peerResourceParam2 = peerResourceParam;
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (peerResourceParam2 != null) {
            if (peerResourceParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && xLDownloadManager.mLoader != null) {
                    i = xLDownloadManager.mLoader.addPeerResource(j, peerResourceParam2.mPeerId, peerResourceParam2.mUserId, peerResourceParam2.mJmpKey, peerResourceParam2.mVipCdnAuth, peerResourceParam2.mInternalIp, peerResourceParam2.mTcpPort, peerResourceParam2.mUdpPort, peerResourceParam2.mResLevel, peerResourceParam2.mResPriority, peerResourceParam2.mCapabilityFlag, peerResourceParam2.mResType);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int addBatchDcdnPeerRes(long j, int i, long j2, DcdnPeerResParam[] dcdnPeerResParamArr) {
        if (dcdnPeerResParamArr == null) {
            return 9900;
        }
        increRefCount();
        j = this.mLoader.addBatchDcdnPeerRes(j, i, j2, dcdnPeerResParamArr);
        decreRefCount();
        return j;
    }

    public int removeServerResource(long j, int i) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.removeAddedServerResource(j, i);
        decreRefCount();
        return j;
    }

    int requeryTaskIndex(long j) {
        return (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? 9900 : this.mLoader.requeryIndex(j);
    }

    public int setOriginUserAgent(long j, String str) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setOriginUserAgent(j, str);
        decreRefCount();
        return j;
    }

    public int setUserId(String str) {
        if (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) {
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        try {
            return this.mLoader.setUserId(str);
        } catch (String str2) {
            reportLinkError();
            throw str2;
        }
    }

    private void reportLinkError() {
        if (this.mContext == null) {
            XLLog.e(TAG, "reportLinkError mContext==null");
            return;
        }
        String str = null;
        try {
            str = (String) ApplicationInfo.class.getField("nativeLibraryDir").get(this.mContext.getApplicationInfo());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        if (str == null) {
            XLLog.e(TAG, "reportLinkError native path not exist");
            return;
        }
        File file = new File(str, System.mapLibraryName("xl_thunder_iface"));
        if (file.exists()) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder("reportLinkError xl_thunder_iface size:");
            stringBuilder.append(file.length());
            XLLog.e(str, stringBuilder.toString());
            return;
        }
        str = TAG;
        stringBuilder = new StringBuilder("reportLinkError xl_thunder_iface not exist path:");
        stringBuilder.append(file.getPath());
        XLLog.e(str, stringBuilder.toString());
    }

    public int getDownloadHeader(long j, GetDownloadHead getDownloadHead) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || getDownloadHead == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getDownloadHeader(j, getDownloadHead);
        decreRefCount();
        return j;
    }

    public int setFileName(long j, String str) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setFileName(j, str);
        decreRefCount();
        return j;
    }

    int notifyNetWorkCarrier(int i) {
        if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
            try {
                return this.mLoader.setNotifyNetWorkCarrier(i);
            } catch (int i2) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("notifyNetWorkCarrier failed,");
                stringBuilder.append(i2.getMessage());
                XLLog.e(str, stringBuilder.toString());
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    int notifyWifiBSSID(String str, XLLoader xLLoader) {
        if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && xLLoader != null) {
            if (str == null || str.length() == 0 || str == "<unknown ssid>") {
                str = "";
            }
            try {
                return xLLoader.setNotifyWifiBSSID(str);
            } catch (String str2) {
                xLLoader = TAG;
                StringBuilder stringBuilder = new StringBuilder("setNotifyWifiBSSID failed,");
                stringBuilder.append(str2.getMessage());
                XLLog.e(xLLoader, stringBuilder.toString());
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int setDownloadTaskOrigin(long j, String str) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setDownloadTaskOrigin(j, str);
        decreRefCount();
        return j;
    }

    int setMac(String str) {
        return (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setMac(str);
    }

    int setImei(String str) {
        return (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setImei(str);
    }

    private int setLocalProperty(String str, String str2) {
        return (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null || str2 == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setLocalProperty(str, str2);
    }

    public int setOSVersion(String str) {
        increRefCount();
        str = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setMiUiVersion(str);
        decreRefCount();
        return str;
    }

    public int setHttpHeaderProperty(long j, String str, String str2) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || str == null || str2 == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setHttpHeaderProperty(j, str, str2);
        decreRefCount();
        return j;
    }

    public int getDownloadLibVersion(GetDownloadLibVersion getDownloadLibVersion) {
        increRefCount();
        getDownloadLibVersion = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || getDownloadLibVersion == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getDownloadLibVersion(getDownloadLibVersion);
        decreRefCount();
        return getDownloadLibVersion;
    }

    private String getPeerid() {
        if (!mAllowExecution) {
            return "000000000000000V";
        }
        String peerid = XLUtil.getPeerid(this.mContext);
        if (peerid == null) {
            peerid = "000000000000000V";
        }
        return peerid;
    }

    private String getGuid() {
        if (!mAllowExecution) {
            return "00000000000000_000000000000";
        }
        GuidInfo guidInfo = new GuidInfo();
        guidInfo = XLUtil.generateGuid(this.mContext);
        if (guidInfo.a != GUID_TYPE.d) {
            XLLog.i(TAG, "Start the GetGuidTimer");
            startGetGuidTimer();
        }
        return guidInfo.b;
    }

    private void startGetGuidTimer() {
        this.mGetGuidTimer = new Timer();
        this.mGetGuidTimerTask = new TimerTask() {
            public void run() {
                if (XLDownloadManager.this.mQueryGuidCount < 5) {
                    XLDownloadManager.this.mQueryGuidCount = XLDownloadManager.this.mQueryGuidCount + 1;
                    GuidInfo guidInfo = new GuidInfo();
                    guidInfo = XLUtil.generateGuid(XLDownloadManager.this.mContext);
                    if (guidInfo.a == GUID_TYPE.d) {
                        XLDownloadManager.this.stopGetGuidTimer();
                    }
                    if (guidInfo.a != GUID_TYPE.DEFAULT) {
                        XLDownloadManager.this.mLoader.setLocalProperty("Guid", guidInfo.b);
                    }
                    return;
                }
                XLDownloadManager.this.stopGetGuidTimer();
            }
        };
        this.mGetGuidTimer.schedule(this.mGetGuidTimerTask, 5000, 60000);
    }

    private void stopGetGuidTimer() {
        if (this.mGetGuidTimer instanceof Timer) {
            this.mGetGuidTimer.cancel();
            this.mGetGuidTimer.purge();
            this.mGetGuidTimer = null;
            XLLog.i(TAG, "stopGetGuidTimer");
        }
        if (this.mGetGuidTimerTask instanceof TimerTask) {
            this.mGetGuidTimerTask.cancel();
            this.mGetGuidTimerTask = null;
        }
    }

    public int enterPrefetchMode(long j) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.enterPrefetchMode(j);
        decreRefCount();
        return j;
    }

    public int setTaskLxState(long j, int i, int i2) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setTaskLxState(j, i, i2);
        decreRefCount();
        return j;
    }

    public int setTaskGsState(long j, int i, int i2) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.setTaskGsState(j, i, i2);
        decreRefCount();
        return j;
    }

    public int setReleaseLog(boolean z, String str, int i, int i2) {
        increRefCount();
        z = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? true : z ? this.mLoader.setReleaseLog(1, str, i, i2) : this.mLoader.setReleaseLog(0, null, 0, 0);
        decreRefCount();
        return z;
    }

    public int setReleaseLog(boolean z, String str) {
        return setReleaseLog(z, str, 0, 0);
    }

    public boolean isLogTurnOn() {
        increRefCount();
        boolean isLogTurnOn = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? false : this.mLoader.isLogTurnOn();
        decreRefCount();
        return isLogTurnOn;
    }

    public int setStatReportSwitch(boolean z) {
        increRefCount();
        z = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? true : this.mLoader.setStatReportSwitch(z);
        decreRefCount();
        return z;
    }

    public int createBtMagnetTask(MagnetTaskParam magnetTaskParam, GetTaskId getTaskId) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (!(magnetTaskParam == null || getTaskId == null)) {
            if (magnetTaskParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
                    i = this.mLoader.createBtMagnetTask(magnetTaskParam.mUrl, magnetTaskParam.mFilePath, magnetTaskParam.mFileName, getTaskId);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int createEmuleTask(EmuleTaskParam emuleTaskParam, GetTaskId getTaskId) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (!(emuleTaskParam == null || getTaskId == null)) {
            if (emuleTaskParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
                    i = this.mLoader.createEmuleTask(emuleTaskParam.mUrl, emuleTaskParam.mFilePath, emuleTaskParam.mFileName, emuleTaskParam.mCreateMode, emuleTaskParam.mSeqId, getTaskId);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int createBtTask(BtTaskParam btTaskParam, GetTaskId getTaskId) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (!(btTaskParam == null || getTaskId == null)) {
            if (btTaskParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
                    i = this.mLoader.createBtTask(btTaskParam.mTorrentPath, btTaskParam.mFilePath, btTaskParam.mMaxConcurrent, btTaskParam.mCreateMode, btTaskParam.mSeqId, getTaskId);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public int getTorrentInfo(String str, TorrentInfo torrentInfo) {
        increRefCount();
        str = (this.mLoader == null || str == null || torrentInfo == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getTorrentInfo(str, torrentInfo);
        decreRefCount();
        return str;
    }

    public int getBtSubTaskStatus(long j, BtTaskStatus btTaskStatus, int i, int i2) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || btTaskStatus == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getBtSubTaskStatus(j, btTaskStatus, i, i2);
        decreRefCount();
        return j;
    }

    public int getBtSubTaskInfo(long j, int i, BtSubTaskDetail btSubTaskDetail) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || btSubTaskDetail == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getBtSubTaskInfo(j, i, btSubTaskDetail);
        decreRefCount();
        return j;
    }

    public int selectBtSubTask(long j, BtIndexSet btIndexSet) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || btIndexSet == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.selectBtSubTask(j, btIndexSet);
        decreRefCount();
        return j;
    }

    public int deselectBtSubTask(long j, BtIndexSet btIndexSet) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || btIndexSet == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.deselectBtSubTask(j, btIndexSet);
        decreRefCount();
        return j;
    }

    public int btAddServerResource(long j, int i, ServerResourceParam serverResourceParam) {
        if (serverResourceParam == null) {
            serverResourceParam = TAG;
            StringBuilder stringBuilder = new StringBuilder("btAddServerResource serverResPara is null, task=[");
            stringBuilder.append(j);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(i);
            stringBuilder.append("]");
            XLLog.e(serverResourceParam, stringBuilder.toString());
            return 9112;
        }
        String str = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("btAddServerResource beg, task=[");
        stringBuilder2.append(j);
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(i);
        stringBuilder2.append("] mUrl=[");
        stringBuilder2.append(serverResourceParam.mUrl);
        stringBuilder2.append("] mRefUrl=[");
        stringBuilder2.append(serverResourceParam.mRefUrl);
        stringBuilder2.append("] mCookie=[");
        stringBuilder2.append(serverResourceParam.mCookie);
        stringBuilder2.append("] mResType=[");
        stringBuilder2.append(serverResourceParam.mResType);
        stringBuilder2.append("] mStrategy=[");
        stringBuilder2.append(serverResourceParam.mStrategy);
        stringBuilder2.append("]");
        XLLog.d(str, stringBuilder2.toString());
        int checkMemberVar = serverResourceParam.checkMemberVar();
        if (checkMemberVar != false) {
            try {
                increRefCount();
                XLLoader xLLoader = this.mLoader;
                checkMemberVar = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
                StringBuilder stringBuilder3;
                if (xLLoader == null) {
                    serverResourceParam = TAG;
                    stringBuilder3 = new StringBuilder("btAddServerResource mLoader is null, task=[");
                    stringBuilder3.append(j);
                    stringBuilder3.append(Constants.COLON_SEPARATOR);
                    stringBuilder3.append(i);
                    stringBuilder3.append("]");
                    XLLog.e(serverResourceParam, stringBuilder3.toString());
                    return checkMemberVar;
                } else if (XLManagerStatus.MANAGER_RUNNING != mDownloadManagerState) {
                    serverResourceParam = TAG;
                    stringBuilder3 = new StringBuilder("btAddServerResource mDownloadManagerState is invaild, task=[");
                    stringBuilder3.append(j);
                    stringBuilder3.append(Constants.COLON_SEPARATOR);
                    stringBuilder3.append(i);
                    stringBuilder3.append("] mDownloadManagerState=[");
                    stringBuilder3.append(mDownloadManagerState);
                    stringBuilder3.append("]");
                    XLLog.e(serverResourceParam, stringBuilder3.toString());
                    decreRefCount();
                    return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
                } else {
                    checkMemberVar = j;
                    serverResourceParam = this.mLoader.btAddServerResource(checkMemberVar, i, serverResourceParam.mUrl, serverResourceParam.mRefUrl, serverResourceParam.mCookie, serverResourceParam.mResType, serverResourceParam.mStrategy);
                    if (9000 != serverResourceParam) {
                        String str2 = TAG;
                        stringBuilder = new StringBuilder("btAddServerResource btAddServerResource failed, task=[");
                        stringBuilder.append(j);
                        stringBuilder.append(Constants.COLON_SEPARATOR);
                        stringBuilder.append(i);
                        stringBuilder.append("] errno=[");
                        stringBuilder.append(serverResourceParam);
                        stringBuilder.append("]");
                        XLLog.e(str2, stringBuilder.toString());
                        decreRefCount();
                        return serverResourceParam;
                    }
                    serverResourceParam = TAG;
                    checkMemberVar = new StringBuilder("btAddServerResource end success, task=[");
                    checkMemberVar.append(j);
                    checkMemberVar.append(Constants.COLON_SEPARATOR);
                    checkMemberVar.append(i);
                    checkMemberVar.append("]");
                    XLLog.d(serverResourceParam, checkMemberVar.toString());
                    decreRefCount();
                    return 9000;
                }
            } finally {
                decreRefCount();
            }
        } else {
            str = TAG;
            stringBuilder2 = new StringBuilder("btAddServerResource checkMemberVar failed, task=[");
            stringBuilder2.append(j);
            stringBuilder2.append(Constants.COLON_SEPARATOR);
            stringBuilder2.append(i);
            stringBuilder2.append("] mUrl=[");
            stringBuilder2.append(serverResourceParam.mUrl);
            stringBuilder2.append("] mRefUrl=[");
            stringBuilder2.append(serverResourceParam.mRefUrl);
            stringBuilder2.append("] mCookie=[");
            stringBuilder2.append(serverResourceParam.mCookie);
            stringBuilder2.append("]");
            XLLog.e(str, stringBuilder2.toString());
            return 9112;
        }
    }

    public int btAddPeerResource(long j, int i, PeerResourceParam peerResourceParam) {
        XLDownloadManager xLDownloadManager = this;
        long j2 = j;
        int i2 = i;
        PeerResourceParam peerResourceParam2 = peerResourceParam;
        if (peerResourceParam2 == null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("btAddPeerResource peerResPara is null, task=[");
            stringBuilder.append(j2);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(i2);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 9112;
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("btAddPeerResource beg, task=[");
        stringBuilder2.append(j2);
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(i2);
        stringBuilder2.append("] mPeerId=[");
        stringBuilder2.append(peerResourceParam2.mPeerId);
        stringBuilder2.append("] mUserId=[");
        stringBuilder2.append(peerResourceParam2.mUserId);
        stringBuilder2.append("] mJmpKey=[");
        stringBuilder2.append(peerResourceParam2.mJmpKey);
        stringBuilder2.append("] mVipCdnAuth=[");
        stringBuilder2.append(peerResourceParam2.mVipCdnAuth);
        stringBuilder2.append("] mInternalIp=[");
        stringBuilder2.append(peerResourceParam2.mInternalIp);
        stringBuilder2.append("] mTcpPort=[");
        stringBuilder2.append(peerResourceParam2.mTcpPort);
        stringBuilder2.append("] mUdpPort=[");
        stringBuilder2.append(peerResourceParam2.mUdpPort);
        stringBuilder2.append("] mResLevel=[");
        stringBuilder2.append(peerResourceParam2.mResLevel);
        stringBuilder2.append("] mResPriority=[");
        stringBuilder2.append(peerResourceParam2.mResPriority);
        stringBuilder2.append("] mCapabilityFlag=[");
        stringBuilder2.append(peerResourceParam2.mCapabilityFlag);
        stringBuilder2.append("] mResType=[");
        stringBuilder2.append(peerResourceParam2.mResType);
        stringBuilder2.append("]");
        XLLog.d(str2, stringBuilder2.toString());
        if (peerResourceParam.checkMemberVar()) {
            try {
                increRefCount();
                StringBuilder stringBuilder3;
                if (xLDownloadManager.mLoader == null) {
                    str = TAG;
                    stringBuilder3 = new StringBuilder("btAddPeerResource mLoader is null, task=[");
                    stringBuilder3.append(j2);
                    stringBuilder3.append(Constants.COLON_SEPARATOR);
                    stringBuilder3.append(i2);
                    stringBuilder3.append("]");
                    XLLog.e(str, stringBuilder3.toString());
                    decreRefCount();
                    return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
                } else if (XLManagerStatus.MANAGER_RUNNING != mDownloadManagerState) {
                    str = TAG;
                    stringBuilder3 = new StringBuilder("btAddPeerResource mDownloadManagerState is invaild, task=[");
                    stringBuilder3.append(j2);
                    stringBuilder3.append(Constants.COLON_SEPARATOR);
                    stringBuilder3.append(i2);
                    stringBuilder3.append("] mDownloadManagerState=[");
                    stringBuilder3.append(mDownloadManagerState);
                    stringBuilder3.append("]");
                    XLLog.e(str, stringBuilder3.toString());
                    decreRefCount();
                    return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
                } else {
                    XLLoader xLLoader = xLDownloadManager.mLoader;
                    String str3 = peerResourceParam2.mPeerId;
                    long j3 = peerResourceParam2.mUserId;
                    String str4 = peerResourceParam2.mJmpKey;
                    String str5 = peerResourceParam2.mVipCdnAuth;
                    int i3 = peerResourceParam2.mInternalIp;
                    int i4 = peerResourceParam2.mTcpPort;
                    int i5 = peerResourceParam2.mUdpPort;
                    int i6 = i5;
                    int btAddPeerResource = xLLoader.btAddPeerResource(j2, i2, str3, j3, str4, str5, i3, i4, i6, peerResourceParam2.mResLevel, peerResourceParam2.mResPriority, peerResourceParam2.mCapabilityFlag, peerResourceParam2.mResType);
                    if (9000 != btAddPeerResource) {
                        str = TAG;
                        stringBuilder3 = new StringBuilder("btAddPeerResource btAddPeerResource failed, task=[");
                        stringBuilder3.append(j);
                        stringBuilder3.append(Constants.COLON_SEPARATOR);
                        stringBuilder3.append(i);
                        stringBuilder3.append("] errno=[");
                        stringBuilder3.append(btAddPeerResource);
                        stringBuilder3.append("]");
                        XLLog.e(str, stringBuilder3.toString());
                        decreRefCount();
                        return btAddPeerResource;
                    }
                    long j4 = j;
                    int i7 = i;
                    String str6 = TAG;
                    stringBuilder3 = new StringBuilder("btAddPeerResource end success, task=[");
                    stringBuilder3.append(j4);
                    stringBuilder3.append(Constants.COLON_SEPARATOR);
                    stringBuilder3.append(i7);
                    stringBuilder3.append("]");
                    XLLog.d(str6, stringBuilder3.toString());
                    decreRefCount();
                    return 9000;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                decreRefCount();
            }
        } else {
            str = TAG;
            stringBuilder = new StringBuilder("btAddPeerResource peerResPara checkMemberVar failed, task=[");
            stringBuilder.append(j2);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(i2);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 9112;
        }
    }

    public int btRemoveAddedResource(long j, int i, int i2) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.btRemoveAddedResource(j, i, i2);
        decreRefCount();
        return j;
    }

    private void loadErrcodeString(Context context) {
        if (context == null) {
            XLLog.e(TAG, "loadErrcodeString, context invalid");
        } else {
            mErrcodeStringMap = XLUtil.parseJSONString(ErrorCodeToMsg.ErrCodeToMsg);
        }
    }

    public String getErrorCodeMsg(int i) {
        String num = Integer.toString(i);
        String str = null;
        if (!(mErrcodeStringMap == null || num == null)) {
            Object obj = mErrcodeStringMap.get(num);
            if (obj != null) {
                str = obj.toString().trim();
            }
            num = TAG;
            StringBuilder stringBuilder = new StringBuilder("errcode:");
            stringBuilder.append(i);
            stringBuilder.append(", errcodeMsg:");
            stringBuilder.append(str);
            XLLog.i(num, stringBuilder.toString());
        }
        return str;
    }

    public int getUrlQuickInfo(long j, UrlQuickInfo urlQuickInfo) {
        increRefCount();
        j = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null || urlQuickInfo == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getUrlQuickInfo(j, urlQuickInfo);
        decreRefCount();
        return j;
    }

    public int createCIDTask(CIDTaskParam cIDTaskParam, GetTaskId getTaskId) {
        int i = XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        if (!(cIDTaskParam == null || getTaskId == null)) {
            if (cIDTaskParam.checkMemberVar()) {
                increRefCount();
                if (mDownloadManagerState == XLManagerStatus.MANAGER_RUNNING && this.mLoader != null) {
                    i = this.mLoader.createCIDTask(cIDTaskParam.mCid, cIDTaskParam.mGcid, cIDTaskParam.mBcid, cIDTaskParam.mFilePath, cIDTaskParam.mFileName, cIDTaskParam.mFileSize, cIDTaskParam.mCreateMode, cIDTaskParam.mSeqId, getTaskId);
                }
                decreRefCount();
                return i;
            }
        }
        return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
    }

    public String parserThunderUrl(String str) {
        ThunderUrlInfo thunderUrlInfo = new ThunderUrlInfo();
        str = (this.mLoader == null || str == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.parserThunderUrl(str, thunderUrlInfo);
        return 9000 == str ? thunderUrlInfo.mUrl : null;
    }

    public int getFileNameFromUrl(String str, GetFileName getFileName) {
        return (this.mLoader == null || str == null || getFileName == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getFileNameFromUrl(str, getFileName);
    }

    public int getNameFromUrl(String str, String str2) {
        return (this.mLoader == null || str == null || str2 == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.getNameFromUrl(str, str2);
    }

    public int setSpeedLimit(long j, long j2) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("debug: XLDownloadManager::setSpeedLimit beg, maxDownloadSpeed=[");
        stringBuilder.append(j);
        stringBuilder.append("] maxUploadSpeed=[");
        stringBuilder.append(j2);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        if (this.mLoader == null) {
            str = TAG;
            stringBuilder = new StringBuilder("error: XLDownloadManager::setSpeedLimit mLoader is null, maxDownloadSpeed=[");
            stringBuilder.append(j);
            stringBuilder.append("] maxUploadSpeed=[");
            stringBuilder.append(j2);
            stringBuilder.append("] ret=[9900]");
            XLLog.e(str, stringBuilder.toString());
            return 9900;
        }
        int speedLimit = this.mLoader.setSpeedLimit(j, j2);
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("debug: XLDownloadManager::setSpeedLimit end, maxDownloadSpeed=[");
        stringBuilder2.append(j);
        stringBuilder2.append("] maxUploadSpeed=[");
        stringBuilder2.append(j2);
        stringBuilder2.append("] ret=[");
        stringBuilder2.append(speedLimit);
        stringBuilder2.append("]");
        XLLog.d(str2, stringBuilder2.toString());
        return speedLimit;
    }

    public int setBtPriorSubTask(long j, int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::setBtPriorSubTask beg, taskId=[");
        stringBuilder.append(j);
        stringBuilder.append("] fileIndex=[");
        stringBuilder.append(i);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        if (this.mLoader == null) {
            str = TAG;
            stringBuilder = new StringBuilder("XLDownloadManager::setBtPriorSubTask mLoader is null, taskId=[");
            stringBuilder.append(j);
            stringBuilder.append("] fileIndex=[");
            stringBuilder.append(i);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 9900;
        }
        int btPriorSubTask = this.mLoader.setBtPriorSubTask(j, i);
        if (9000 != btPriorSubTask) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("XLDownloadManager::setBtPriorSubTask end, taskId=[");
            stringBuilder2.append(j);
            stringBuilder2.append("] fileIndex=[");
            stringBuilder2.append(i);
            stringBuilder2.append("] ret=[");
            stringBuilder2.append(btPriorSubTask);
            stringBuilder2.append("]");
            XLLog.e(str2, stringBuilder2.toString());
            return btPriorSubTask;
        }
        str = TAG;
        stringBuilder2 = new StringBuilder(" XLDownloadManager::setBtPriorSubTask end, taskId=[");
        stringBuilder2.append(j);
        stringBuilder2.append("] fileIndex=[");
        stringBuilder2.append(i);
        stringBuilder2.append("]");
        XLLog.d(str, stringBuilder2.toString());
        return 9000;
    }

    public int getMaxDownloadSpeed(MaxDownloadSpeedParam maxDownloadSpeedParam) {
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::getMaxDownloadSpeed mLoader is null");
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        int maxDownloadSpeed = this.mLoader.getMaxDownloadSpeed(maxDownloadSpeedParam);
        if (9000 != maxDownloadSpeed) {
            maxDownloadSpeedParam = TAG;
            StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::getMaxDownloadSpeed end, ret=[");
            stringBuilder.append(maxDownloadSpeed);
            stringBuilder.append("]");
            XLLog.e(maxDownloadSpeedParam, stringBuilder.toString());
            return maxDownloadSpeed;
        }
        String str = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("XLDownloadManager::getMaxDownloadSpeed end, speed=[");
        stringBuilder2.append(maxDownloadSpeedParam.mSpeed);
        stringBuilder2.append("] ret=[");
        stringBuilder2.append(maxDownloadSpeed);
        stringBuilder2.append("]");
        XLLog.d(str, stringBuilder2.toString());
        return maxDownloadSpeed;
    }

    public int statExternalInfo(long j, int i, String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::statExternalInfo beg, taskId=[");
        stringBuilder.append(j);
        stringBuilder.append("] fileIndex=[");
        stringBuilder.append(i);
        stringBuilder.append("] key=[");
        stringBuilder.append(str);
        stringBuilder.append("] value=[");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        XLLog.d(str3, stringBuilder.toString());
        if (this.mLoader == null) {
            str = TAG;
            str2 = new StringBuilder("XLDownloadManager::statExternalInfo mLoader is null, taskId=[");
            str2.append(j);
            str2.append("] fileIndex=[");
            str2.append(i);
            str2.append("]");
            XLLog.e(str, str2.toString());
            return 9900;
        }
        str = this.mLoader.statExternalInfo(j, i, str, str2);
        if (9000 != str) {
            str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("XLDownloadManager::statExternalInfo end, taskId=[");
            stringBuilder2.append(j);
            stringBuilder2.append("] fileIndex=[");
            stringBuilder2.append(i);
            stringBuilder2.append("] ret=[");
            stringBuilder2.append(str);
            stringBuilder2.append("]");
            XLLog.e(str2, stringBuilder2.toString());
            return str;
        }
        str2 = TAG;
        stringBuilder2 = new StringBuilder("XLDownloadManager::statExternalInfo end, taskId=[");
        stringBuilder2.append(j);
        stringBuilder2.append("] fileIndex=[");
        stringBuilder2.append(i);
        stringBuilder2.append("] ret=[");
        stringBuilder2.append(str);
        stringBuilder2.append("]");
        XLLog.d(str2, stringBuilder2.toString());
        return str;
    }

    public int statExternalInfo(long j, int i, String str, int i2) {
        return statExternalInfo(j, i, str, String.valueOf(i2));
    }

    public int clearTaskFile(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::clearTaskFile filePath=[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        XLLog.d(str2, stringBuilder.toString());
        if (TextUtils.isEmpty(str)) {
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::clearTaskFile mLoader is null");
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        str = this.mLoader.clearTaskFile(str);
        if (9000 == str) {
            return 9000;
        }
        str2 = TAG;
        stringBuilder = new StringBuilder("XLDownloadManager::clearTaskFile end, ret=[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        XLLog.e(str2, stringBuilder.toString());
        return str;
    }

    public int startDcdn(long j, int i, String str, String str2, String str3) {
        increRefCount();
        int startDcdn = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.startDcdn(j, i, str, str2, str3);
        decreRefCount();
        XLLog.d(TAG, String.format("XLDownloadManager::startDcdn ret=[%d] taskId=[%d] subIndex=[%d] sessionId=[%s] productType=[%s] verifyInfo=[%s]", new Object[]{Integer.valueOf(startDcdn), Long.valueOf(j), Integer.valueOf(i), str, str2, str3}));
        return startDcdn;
    }

    public int stopDcdn(long j, int i) {
        increRefCount();
        int stopDcdn = (mDownloadManagerState != XLManagerStatus.MANAGER_RUNNING || this.mLoader == null) ? XLErrorCode.DOWNLOAD_MANAGER_ERROR : this.mLoader.stopDcdn(j, i);
        decreRefCount();
        XLLog.d(TAG, String.format("XLDownloadManager::stopDcdn ret=[%d] taskId=[%d] subIndex=[%d]", new Object[]{Integer.valueOf(stopDcdn), Long.valueOf(j), Integer.valueOf(i)}));
        return stopDcdn;
    }

    public int createShortVideoTask(String str, String str2, String str3, String str4, int i, int i2, int i3, GetTaskId getTaskId) {
        String str5 = str4;
        String str6 = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::createShortVideoTask beg, url=[");
        String str7 = str;
        stringBuilder.append(str7);
        stringBuilder.append("] path=[");
        String str8 = str2;
        stringBuilder.append(str8);
        stringBuilder.append("] filename=[");
        String str9 = str3;
        stringBuilder.append(str9);
        stringBuilder.append("] title=[");
        stringBuilder.append(str5);
        stringBuilder.append("]");
        XLLog.d(str6, stringBuilder.toString());
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::createShortVideoTask mLoader is null");
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        if (str5 == null) {
            str5 = "default Title";
        }
        int createShortVideoTask = r0.mLoader.createShortVideoTask(str7, str8, str9, str5, i, i2, i3, getTaskId);
        if (9000 != createShortVideoTask) {
            str6 = TAG;
            stringBuilder = new StringBuilder("XLDownloadManager::createShortVideoTask end, ret=[");
            stringBuilder.append(createShortVideoTask);
            stringBuilder.append("]");
            XLLog.e(str6, stringBuilder.toString());
            return createShortVideoTask;
        }
        str6 = TAG;
        stringBuilder = new StringBuilder("XLDownloadManager::createShortVideoTask end, taskId=[");
        stringBuilder.append(getTaskId.getTaskId());
        stringBuilder.append("] ret=[");
        stringBuilder.append(createShortVideoTask);
        stringBuilder.append("]");
        XLLog.d(str6, stringBuilder.toString());
        return createShortVideoTask;
    }

    public int playShortVideoBegin(long j) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::playShortVideoBegin beg, taskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::playShortVideoBegin mLoader is null");
            return 9900;
        }
        int playShortVideoBegin = this.mLoader.playShortVideoBegin(j);
        if (9000 != playShortVideoBegin) {
            j = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("XLDownloadManager::playShortVideoBegin end, ret=[");
            stringBuilder2.append(playShortVideoBegin);
            stringBuilder2.append("]");
            XLLog.e(j, stringBuilder2.toString());
            return playShortVideoBegin;
        }
        String str2 = TAG;
        StringBuilder stringBuilder3 = new StringBuilder("XLDownloadManager::playShortVideoBegin end, taskId=[");
        stringBuilder3.append(j);
        stringBuilder3.append("] ret=[");
        stringBuilder3.append(playShortVideoBegin);
        stringBuilder3.append("]");
        XLLog.d(str2, stringBuilder3.toString());
        return playShortVideoBegin;
    }

    public int getSessionInfoByUrl(String str, XLSessionInfo xLSessionInfo) {
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::getSessionInfoByUrl mLoader is null");
            return XLErrorCode.DOWNLOAD_MANAGER_ERROR;
        }
        str = this.mLoader.getSessionInfoByUrl(str, xLSessionInfo);
        if (9000 == str) {
            return str;
        }
        xLSessionInfo = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::getSessionInfoByUrl end, ret=[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        XLLog.e(xLSessionInfo, stringBuilder.toString());
        return str;
    }

    public boolean getSettingValue(String str, String str2, boolean z) {
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::getSettingValue mLoader is null");
            return z;
        }
        GetBooleanParam getBooleanParam = new GetBooleanParam();
        str = this.mLoader.getSettingBoolean(str, str2, getBooleanParam, z);
        if (9000 == str) {
            return getBooleanParam.getValue();
        }
        str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("XLDownloadManager::getSettingValue end, ret=[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        XLLog.e(str2, stringBuilder.toString());
        return z;
    }

    public int getDownloadRangeInfo(long j, int i, XLRangeInfo xLRangeInfo) {
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::getDownloadRangeInfo mLoader is null");
            return 9900;
        }
        j = this.mLoader.getDownloadRangeInfo(j, i, xLRangeInfo);
        if (9000 == j) {
            return j;
        }
        String str = TAG;
        i = new StringBuilder("XLDownloadManager::getDownloadRangeInfo end, ret=[");
        i.append(j);
        i.append("]");
        XLLog.e(str, i.toString());
        return j;
    }

    public int statExternalInfoU64(long j, int i, String str, long j2, int i2) {
        if (this.mLoader == null) {
            XLLog.e(TAG, "XLDownloadManager::statExternalInfoU64 mLoader is null");
            return 9900;
        }
        j = this.mLoader.statExternalInfoU64(j, i, str, j2, i2);
        if (9000 == j) {
            return j;
        }
        String str2 = TAG;
        i = new StringBuilder("XLDownloadManager::statExternalInfoU64 end, ret=[");
        i.append(j);
        i.append("]");
        XLLog.e(str2, i.toString());
        return j;
    }
}
