package com.xunlei.androidvip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.util.Base64;
import com.igexin.sdk.PushConsts;
import com.xunlei.androidvip.parameter.AndroidVipGetTaskId;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedBillingReqParam;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedBillingResponse;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedFluxReqParam;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedFluxResponse;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedTaskReqParam;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedTaskResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtCommitReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtCommitResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtListReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtListResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineCommitReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineCommitResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineDeleteReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineDeleteResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineTaskReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineTaskResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineTasklistReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineTasklistResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineUserInfoReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineUserInfoResponse;
import com.xunlei.androidvip.parameter.VipTryCommitResult;
import com.xunlei.androidvip.parameter.VipTryParam;
import com.xunlei.androidvip.parameter.VipTryQueryResult;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.android.XLUtil;
import java.io.File;

public class XLAndroidVipManager {
    public static final int ALREADY_INIT = 7003;
    public static final int NET_TYPE_MOBILE = 3;
    public static final int NET_TYPE_UNKNOW = 1;
    public static final int NET_TYPE_WIFI = 2;
    public static final int NOT_INIT = 7004;
    public static final int PARAM_ERROR = 7001;
    public static final int RUNNING = 7002;
    public static final int SUCCESS = 0;
    private static final String TAG = "XLAndroidVipManager";
    public static final int TASK_NOT_EXIST = 7005;
    public static final int XL_JNI_ERROR = 7000;
    private static XLAndroidVipManager mInstance;
    private Context mContext;
    private XLAndroidVipLoader mLoader;
    private NetworkChangeReceiver mReceiver;

    class NetworkChangeReceiver extends BroadcastReceiver implements Runnable {
        private static final String TAG = "TAG_VipNetReceiver";
        int mNettype;
        Thread mThread;

        private NetworkChangeReceiver() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r3, android.content.Intent r4) {
            /*
            r2 = this;
            r0 = "TAG_VipNetReceiver";
            r1 = "call onReceive";
            com.xunlei.downloadlib.android.XLLog.d(r0, r1);
            r4 = r4.getAction();
            r0 = "android.net.conn.CONNECTIVITY_CHANGE";
            r4 = r4.equals(r0);
            if (r4 == 0) goto L_0x0044;
        L_0x0013:
            r3 = com.xunlei.downloadlib.android.XLUtil.getNetworkTypeSimple(r3);
            r4 = "TAG_VipNetReceiver";
            r0 = new java.lang.StringBuilder;
            r1 = "onReceive nettype=";
            r0.<init>(r1);
            r0.append(r3);
            r0 = r0.toString();
            com.xunlei.downloadlib.android.XLLog.d(r4, r0);
            monitor-enter(r2);
            r2.mNettype = r3;	 Catch:{ all -> 0x0041 }
            r3 = r2.mThread;	 Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0033;
        L_0x0031:
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0033:
            r3 = new java.lang.Thread;	 Catch:{ all -> 0x0041 }
            r3.<init>(r2);	 Catch:{ all -> 0x0041 }
            r2.mThread = r3;	 Catch:{ all -> 0x0041 }
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            r3 = r2.mThread;
            r3.start();
            goto L_0x0044;
        L_0x0041:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            throw r3;
        L_0x0044:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.androidvip.XLAndroidVipManager.NetworkChangeReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }

        public void run() {
            while (true) {
                int i = this.mNettype;
                XLAndroidVipManager.this.AndroidVipSetNetWorkType(i);
                synchronized (this) {
                    if (i == this.mNettype) {
                        this.mThread = null;
                        return;
                    }
                }
            }
        }
    }

    public static synchronized XLAndroidVipManager getInstance() {
        XLAndroidVipManager xLAndroidVipManager;
        synchronized (XLAndroidVipManager.class) {
            if (mInstance == null) {
                mInstance = new XLAndroidVipManager();
            }
            xLAndroidVipManager = mInstance;
        }
        return xLAndroidVipManager;
    }

    public static synchronized XLAndroidVipManager getInstance(Context context) {
        synchronized (XLAndroidVipManager.class) {
            if (mInstance == null) {
                mInstance = new XLAndroidVipManager(context);
            }
            context = mInstance;
        }
        return context;
    }

    public static synchronized XLAndroidVipManager getInstance(String str) {
        synchronized (XLAndroidVipManager.class) {
            if (mInstance == null) {
                mInstance = new XLAndroidVipManager(str);
            }
            str = mInstance;
        }
        return str;
    }

    private XLAndroidVipManager() {
        this.mReceiver = null;
        this.mContext = null;
        this.mLoader = new XLAndroidVipLoader();
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    private XLAndroidVipManager(Context context) {
        this.mReceiver = null;
        this.mContext = null;
        this.mLoader = new XLAndroidVipLoader(context);
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    private XLAndroidVipManager(String str) {
        this.mReceiver = null;
        this.mContext = null;
        this.mLoader = new XLAndroidVipLoader(str);
        XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
    }

    public int AndroidVipInit(Context context, int i, String str) {
        if (context == null) {
            context = TAG;
            str = new StringBuilder("AndroidVipInit context is null, thunder_flag=[");
            str.append(i);
            str.append("]");
            XLLog.e(context, str.toString());
            return PARAM_ERROR;
        }
        this.mContext = context;
        String peerid = getPeerid();
        String path = context.getFilesDir().getPath();
        String str2 = new String(Base64.encode(peerid.getBytes(), 0));
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder("AndroidVipInit beg, thunder_flag=[");
        stringBuilder.append(i);
        stringBuilder.append("] Peerid=[");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        XLLog.d(str3, stringBuilder.toString());
        str = this.mLoader.AndroidVipInit(peerid, path, i, str);
        if (str != null) {
            context = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("AndroidVipInit AndroidVipInit failed, thunder_flag=[");
            stringBuilder2.append(i);
            stringBuilder2.append("] errno=[");
            stringBuilder2.append(str);
            stringBuilder2.append("]");
            XLLog.e(context, stringBuilder2.toString());
            return str;
        }
        AndroidVipSetNetWorkType(XLUtil.getNetworkTypeSimple(context));
        doMonitorNetworkChange();
        context = TAG;
        str = new StringBuilder("AndroidVipInit end, thunder_flag=[");
        str.append(i);
        str.append("] Peerid=[");
        str.append(str2);
        str.append("]");
        XLLog.d(context, str.toString());
        return 0;
    }

    public int AndroidVipUninit() {
        XLLog.d(TAG, "AndroidVipUninit beg");
        undoMonitorNetworkChange();
        int AndroidVipUninit = this.mLoader.AndroidVipUninit();
        if (AndroidVipUninit != 0) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("AndroidVipUninit end, errno=[");
            stringBuilder.append(AndroidVipUninit);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return AndroidVipUninit;
        }
        XLLog.d(TAG, "AndroidVipUninit end");
        return AndroidVipUninit;
    }

    public int AndroidVipOfflineTasklistReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineTasklistReqParam androidVipOfflineTasklistReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineTasklistReqParam != null) {
                return this.mLoader.AndroidVipOfflineTasklistReq(androidVipGetTaskId, androidVipOfflineTasklistReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineTasklistResp(long j, AndroidVipOfflineTasklistResponse androidVipOfflineTasklistResponse) {
        if (j != 0) {
            if (androidVipOfflineTasklistResponse != null) {
                return this.mLoader.AndroidVipGetOfflineTasklistResp(j, androidVipOfflineTasklistResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyOfflineTasklistReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineTasklistReq(j);
    }

    public int AndroidVipOfflineCommitReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineCommitReqParam androidVipOfflineCommitReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineCommitReqParam != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipOfflineCommitReq beg, TaskId=[");
                stringBuilder.append(androidVipGetTaskId.getTaskId());
                stringBuilder.append("] mUserId=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mUserId);
                stringBuilder.append("] mKey=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mKey);
                stringBuilder.append("] mVipLevel=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mVipLevel);
                stringBuilder.append("] mAutoCharge=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mAutoCharge);
                stringBuilder.append("] mUrl=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mUrl);
                stringBuilder.append("] mRefUrl=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mRefUrl);
                stringBuilder.append("] mCookie=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mCookie);
                stringBuilder.append("] mTaskName=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mTaskName);
                stringBuilder.append("] mCid=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mCid.length());
                stringBuilder.append("] mGcid=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mGcid.length());
                stringBuilder.append("] mFileSize=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mFileSize);
                stringBuilder.append("] mFileType=[");
                stringBuilder.append(androidVipOfflineCommitReqParam.mFileType);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                androidVipGetTaskId = this.mLoader.AndroidVipOfflineCommitReq(androidVipGetTaskId, androidVipOfflineCommitReqParam);
                if (androidVipGetTaskId != null) {
                    androidVipOfflineCommitReqParam = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("AndroidVipOfflineCommitReq AndroidVipOfflineCommitReq failed, errno=[");
                    stringBuilder2.append(androidVipGetTaskId);
                    stringBuilder2.append("]");
                    XLLog.e(androidVipOfflineCommitReqParam, stringBuilder2.toString());
                    return androidVipGetTaskId;
                }
                XLLog.d(TAG, "AndroidVipOfflineCommitReq end success");
                return androidVipGetTaskId;
            }
        }
        XLLog.e(TAG, "AndroidVipOfflineCommitReq param is null");
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineCommitResp(long j, AndroidVipOfflineCommitResponse androidVipOfflineCommitResponse) {
        if (j != 0) {
            if (androidVipOfflineCommitResponse != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipGetOfflineCommitResp beg, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                int AndroidVipGetOfflineCommitResp = this.mLoader.AndroidVipGetOfflineCommitResp(j, androidVipOfflineCommitResponse);
                StringBuilder stringBuilder2;
                if (RUNNING == AndroidVipGetOfflineCommitResp) {
                    androidVipOfflineCommitResponse = TAG;
                    stringBuilder2 = new StringBuilder("AndroidVipGetOfflineCommitResp AndroidVipGetOfflineCommitResp end is running, TaskId=[");
                    stringBuilder2.append(j);
                    stringBuilder2.append("] errno=[");
                    stringBuilder2.append(AndroidVipGetOfflineCommitResp);
                    stringBuilder2.append("]");
                    XLLog.d(androidVipOfflineCommitResponse, stringBuilder2.toString());
                    return RUNNING;
                } else if (AndroidVipGetOfflineCommitResp != 0) {
                    androidVipOfflineCommitResponse = TAG;
                    stringBuilder = new StringBuilder("AndroidVipGetOfflineCommitResp AndroidVipGetOfflineCommitResp failed, TaskId=[");
                    stringBuilder.append(j);
                    stringBuilder.append("] errno=[");
                    stringBuilder.append(AndroidVipGetOfflineCommitResp);
                    stringBuilder.append("]");
                    XLLog.e(androidVipOfflineCommitResponse, stringBuilder.toString());
                    return AndroidVipGetOfflineCommitResp;
                } else {
                    String str2 = TAG;
                    stringBuilder2 = new StringBuilder("AndroidVipGetOfflineCommitResp end success, TaskId=[");
                    stringBuilder2.append(j);
                    stringBuilder2.append("] mResult=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mResult);
                    stringBuilder2.append("] mMessage=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mMessage);
                    stringBuilder2.append("] mAvailableSpace=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mAvailableSpace);
                    stringBuilder2.append("] mMaxStore=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mMaxStore);
                    stringBuilder2.append("] mMaxTaskNum=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mMaxTaskNum);
                    stringBuilder2.append("] mCurrentTaskNum=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mCurrentTaskNum);
                    stringBuilder2.append("] mTaskNum=[");
                    stringBuilder2.append(androidVipOfflineCommitResponse.mTaskNum);
                    stringBuilder2.append("]");
                    XLLog.d(str2, stringBuilder2.toString());
                    return AndroidVipGetOfflineCommitResp;
                }
            }
        }
        XLLog.e(TAG, "AndroidVipGetOfflineCommitResp param is null");
        return 7001;
    }

    public int AndroidVipDestroyOfflineCommitReq(long j) {
        if (j == 0) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("AndroidVipDestroyOfflineCommitReq TaskId is invalid, TaskId=[");
            stringBuilder.append(j);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 7001;
        }
        str = TAG;
        stringBuilder = new StringBuilder("AndroidVipDestroyOfflineCommitReq beg, TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        int AndroidVipDestroyOfflineCommitReq = this.mLoader.AndroidVipDestroyOfflineCommitReq(j);
        if (AndroidVipDestroyOfflineCommitReq != 0) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("AndroidVipDestroyOfflineCommitReq AndroidVipDestroyOfflineCommitReq failed, TaskId=[");
            stringBuilder2.append(j);
            stringBuilder2.append("] errno=[");
            stringBuilder2.append(AndroidVipDestroyOfflineCommitReq);
            stringBuilder2.append("]");
            XLLog.e(str2, stringBuilder2.toString());
            return AndroidVipDestroyOfflineCommitReq;
        }
        str = TAG;
        stringBuilder = new StringBuilder("AndroidVipDestroyOfflineCommitReq end, TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        return 0;
    }

    public int AndroidVipOfflineBtCommitReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineBtCommitReqParam androidVipOfflineBtCommitReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineBtCommitReqParam != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipOfflineBtCommitReq beg, vipTaskId=[");
                stringBuilder.append(androidVipGetTaskId.getTaskId());
                stringBuilder.append("] mKey=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mKey);
                stringBuilder.append("] mUserId=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mUserId);
                stringBuilder.append("] mVipLevel=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mVipLevel);
                stringBuilder.append("] mAutoCharge=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mAutoCharge);
                stringBuilder.append("] mInfoHash=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mInfoHash);
                stringBuilder.append("] mBtTitle=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mBtTitle);
                stringBuilder.append("] mRefUrl=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mRefUrl);
                stringBuilder.append("] mFilePath=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mFilePath);
                stringBuilder.append("] mFileListNum=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mFileListNum);
                stringBuilder.append("] mMainTaskId=[");
                stringBuilder.append(androidVipOfflineBtCommitReqParam.mMainTaskId);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                androidVipOfflineBtCommitReqParam = this.mLoader.AndroidVipOfflineBtCommitReq(androidVipGetTaskId, androidVipOfflineBtCommitReqParam);
                if (androidVipOfflineBtCommitReqParam != null) {
                    str = TAG;
                    stringBuilder = new StringBuilder("AndroidVipOfflineBtCommitReq AndroidVipOfflineBtCommitReq failed, vipTaskId=[");
                    stringBuilder.append(androidVipGetTaskId.getTaskId());
                    stringBuilder.append("] errno=[");
                    stringBuilder.append(androidVipOfflineBtCommitReqParam);
                    stringBuilder.append("]");
                    XLLog.e(str, stringBuilder.toString());
                    return androidVipOfflineBtCommitReqParam;
                }
                androidVipOfflineBtCommitReqParam = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("AndroidVipOfflineBtCommitReq end success, vipTaskId=[");
                stringBuilder2.append(androidVipGetTaskId.getTaskId());
                stringBuilder2.append("]");
                XLLog.d(androidVipOfflineBtCommitReqParam, stringBuilder2.toString());
                return null;
            }
        }
        XLLog.e(TAG, "AndroidVipOfflineBtCommitReq param is null");
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineBtCommitResp(long j, AndroidVipOfflineBtCommitResponse androidVipOfflineBtCommitResponse) {
        if (0 != j) {
            if (androidVipOfflineBtCommitResponse != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipGetOfflineBtCommitResp beg, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                int AndroidVipGetOfflineBtCommitResp = this.mLoader.AndroidVipGetOfflineBtCommitResp(j, androidVipOfflineBtCommitResponse);
                if (AndroidVipGetOfflineBtCommitResp != 0) {
                    androidVipOfflineBtCommitResponse = TAG;
                    stringBuilder = new StringBuilder("AndroidVipGetOfflineBtCommitResp AndroidVipGetOfflineBtCommitResp failed, TaskId=[");
                    stringBuilder.append(j);
                    stringBuilder.append("] errno=[");
                    stringBuilder.append(AndroidVipGetOfflineBtCommitResp);
                    stringBuilder.append("]");
                    XLLog.e(androidVipOfflineBtCommitResponse, stringBuilder.toString());
                    return AndroidVipGetOfflineBtCommitResp;
                }
                str = TAG;
                stringBuilder = new StringBuilder("AndroidVipGetOfflineBtCommitResp end success, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("] mResult=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mResult);
                stringBuilder.append("] mMessage=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mMessage);
                stringBuilder.append("] mInfoHash=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mInfoHash);
                stringBuilder.append("] mAvailableSpace=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mAvailableSpace);
                stringBuilder.append("] mMaxStore=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mMaxStore);
                stringBuilder.append("] mFileSize=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mFileSize);
                stringBuilder.append("] mMaxTaskNum=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mMaxTaskNum);
                stringBuilder.append("] mCurrentTaskNum=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mCurrentTaskNum);
                stringBuilder.append("] mMainTaskId=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mMainTaskId);
                stringBuilder.append("] mTaskIdListNum=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mTaskIdListNum);
                stringBuilder.append("] mTaskNum=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mTaskNum);
                stringBuilder.append("] mClassValue=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mClassValue);
                stringBuilder.append("] mLeftLiveTime=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mLeftLiveTime);
                stringBuilder.append("] mCommitTime=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mCommitTime);
                stringBuilder.append("] mFileAttr=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mFileAttr);
                stringBuilder.append("] mProgress=[");
                stringBuilder.append(androidVipOfflineBtCommitResponse.mProgress);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                return 0;
            }
        }
        androidVipOfflineBtCommitResponse = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("AndroidVipGetOfflineBtCommitResp param is invalid, TaskId=[");
        stringBuilder2.append(j);
        stringBuilder2.append("]");
        XLLog.e(androidVipOfflineBtCommitResponse, stringBuilder2.toString());
        return 7001;
    }

    public int AndroidVipDestroyOfflineBtCommitReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineBtCommitReq(j);
    }

    public int AndroidVipOfflineDeleteReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineDeleteReqParam androidVipOfflineDeleteReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineDeleteReqParam != null) {
                return this.mLoader.AndroidVipOfflineDeleteReq(androidVipGetTaskId, androidVipOfflineDeleteReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineDeleteResp(long j, AndroidVipOfflineDeleteResponse androidVipOfflineDeleteResponse) {
        if (j != 0) {
            if (androidVipOfflineDeleteResponse != null) {
                return this.mLoader.AndroidVipGetOfflineDeleteResp(j, androidVipOfflineDeleteResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyOfflineDeleteReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineDeleteReq(j);
    }

    public int AndroidVipOfflineBtListReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineBtListReqParam androidVipOfflineBtListReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineBtListReqParam != null) {
                return this.mLoader.AndroidVipOfflineBtListReq(androidVipGetTaskId, androidVipOfflineBtListReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineBtListResp(long j, AndroidVipOfflineBtListResponse androidVipOfflineBtListResponse) {
        if (j != 0) {
            if (androidVipOfflineBtListResponse != null) {
                return this.mLoader.AndroidVipGetOfflineBtListResp(j, androidVipOfflineBtListResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyOfflineBtListReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineBtListReq(j);
    }

    public int AndroidVipOfflineUserInfoReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineUserInfoReqParam androidVipOfflineUserInfoReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineUserInfoReqParam != null) {
                return this.mLoader.AndroidVipOfflineUserInfoReq(androidVipGetTaskId, androidVipOfflineUserInfoReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineUserInfoResp(long j, AndroidVipOfflineUserInfoResponse androidVipOfflineUserInfoResponse) {
        if (j != 0) {
            if (androidVipOfflineUserInfoResponse != null) {
                return this.mLoader.AndroidVipGetOfflineUserInfoResp(j, androidVipOfflineUserInfoResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyOfflineUserInfoReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineUserInfoReq(j);
    }

    public int AndroidVipOfflineTaskReq(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipOfflineTaskReqParam androidVipOfflineTaskReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipOfflineTaskReqParam != null) {
                return this.mLoader.AndroidVipOfflineTaskReq(androidVipGetTaskId, androidVipOfflineTaskReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetOfflineTaskResp(long j, AndroidVipOfflineTaskResponse androidVipOfflineTaskResponse) {
        if (j != 0) {
            if (androidVipOfflineTaskResponse != null) {
                return this.mLoader.AndroidVipGetOfflineTaskResp(j, androidVipOfflineTaskResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyOfflineTaskReq(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyOfflineTaskReq(j);
    }

    public int AndroidVipCreateEnterHighSpeedTask(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipHighSpeedTaskReqParam androidVipHighSpeedTaskReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipHighSpeedTaskReqParam != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipCreateEnterHighSpeedTask beg,  mUserId=[");
                stringBuilder.append(androidVipHighSpeedTaskReqParam.mUserId);
                stringBuilder.append("] mGcid=[");
                stringBuilder.append(androidVipHighSpeedTaskReqParam.mGcid.length());
                stringBuilder.append("] mCid=[");
                stringBuilder.append(androidVipHighSpeedTaskReqParam.mCid.length());
                stringBuilder.append("] mFileSize=[");
                stringBuilder.append(androidVipHighSpeedTaskReqParam.mFileSize);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                androidVipHighSpeedTaskReqParam = this.mLoader.AndroidVipCreateEnterHighSpeedTask(androidVipGetTaskId, androidVipHighSpeedTaskReqParam);
                StringBuilder stringBuilder2;
                if (androidVipHighSpeedTaskReqParam != null) {
                    androidVipGetTaskId = TAG;
                    stringBuilder2 = new StringBuilder("AndroidVipCreateEnterHighSpeedTask AndroidVipCreateEnterHighSpeedTask failed, errno=[");
                    stringBuilder2.append(androidVipHighSpeedTaskReqParam);
                    stringBuilder2.append("]");
                    XLLog.e(androidVipGetTaskId, stringBuilder2.toString());
                    return androidVipHighSpeedTaskReqParam;
                }
                androidVipHighSpeedTaskReqParam = TAG;
                stringBuilder2 = new StringBuilder("AndroidVipCreateEnterHighSpeedTask end success, vipTaskId=[");
                stringBuilder2.append(androidVipGetTaskId.getTaskId());
                stringBuilder2.append("]");
                XLLog.d(androidVipHighSpeedTaskReqParam, stringBuilder2.toString());
                return null;
            }
        }
        XLLog.e(TAG, "AndroidVipCreateEnterHighSpeedTask param is null");
        return PARAM_ERROR;
    }

    public int AndroidVipGetHighSpeedTaskResp(long j, AndroidVipHighSpeedTaskResponse androidVipHighSpeedTaskResponse) {
        if (j != 0) {
            if (androidVipHighSpeedTaskResponse != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipGetHighSpeedTaskResp beg, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                int AndroidVipGetHighSpeedTaskResp = this.mLoader.AndroidVipGetHighSpeedTaskResp(j, androidVipHighSpeedTaskResponse);
                if (AndroidVipGetHighSpeedTaskResp != 0) {
                    androidVipHighSpeedTaskResponse = TAG;
                    stringBuilder = new StringBuilder("AndroidVipGetHighSpeedTaskResp AndroidVipGetHighSpeedTaskResp failed, TaskId=[");
                    stringBuilder.append(j);
                    stringBuilder.append("] errno=[");
                    stringBuilder.append(AndroidVipGetHighSpeedTaskResp);
                    stringBuilder.append("]");
                    XLLog.e(androidVipHighSpeedTaskResponse, stringBuilder.toString());
                    return AndroidVipGetHighSpeedTaskResp;
                }
                str = TAG;
                stringBuilder = new StringBuilder("AndroidVipGetHighSpeedTaskResp end success, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("] mResult=[");
                stringBuilder.append(androidVipHighSpeedTaskResponse.mResult);
                stringBuilder.append("] mPeerCount=[");
                stringBuilder.append(androidVipHighSpeedTaskResponse.mPeerCount);
                stringBuilder.append("] mServerCount=[");
                stringBuilder.append(androidVipHighSpeedTaskResponse.mServerCount);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                return 0;
            }
        }
        androidVipHighSpeedTaskResponse = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("AndroidVipGetHighSpeedTaskResp param is invalid, TaskId=[");
        stringBuilder2.append(j);
        stringBuilder2.append("]");
        XLLog.e(androidVipHighSpeedTaskResponse, stringBuilder2.toString());
        return 7001;
    }

    public int AndroidVipDestroyHighSpeedTask(long j) {
        if (j == 0) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("AndroidVipDestroyHighSpeedTask TaskId is invalid, TaskId=[");
            stringBuilder.append(j);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 7001;
        }
        str = TAG;
        stringBuilder = new StringBuilder("AndroidVipDestroyHighSpeedTask beg, TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        int AndroidVipDestroyHighSpeedTask = this.mLoader.AndroidVipDestroyHighSpeedTask(j);
        if (AndroidVipDestroyHighSpeedTask != 0) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("AndroidVipDestroyHighSpeedTask AndroidVipDestroyHighSpeedTask failed, TaskId=[");
            stringBuilder2.append(j);
            stringBuilder2.append("] errno=[");
            stringBuilder2.append(AndroidVipDestroyHighSpeedTask);
            stringBuilder2.append("]");
            XLLog.e(str2, stringBuilder2.toString());
            return AndroidVipDestroyHighSpeedTask;
        }
        str2 = TAG;
        stringBuilder2 = new StringBuilder("AndroidVipDestroyHighSpeedTask end, TaskId=[");
        stringBuilder2.append(j);
        stringBuilder2.append("]");
        XLLog.d(str2, stringBuilder2.toString());
        return AndroidVipDestroyHighSpeedTask;
    }

    public int AndroidVipCreateFluxQueryTask(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipHighSpeedFluxReqParam androidVipHighSpeedFluxReqParam) {
        if (androidVipGetTaskId != null) {
            if (androidVipHighSpeedFluxReqParam != null) {
                return this.mLoader.AndroidVipCreateFluxQueryTask(androidVipGetTaskId, androidVipHighSpeedFluxReqParam);
            }
        }
        return PARAM_ERROR;
    }

    public int AndroidVipGetFluxQueryTaskResp(long j, AndroidVipHighSpeedFluxResponse androidVipHighSpeedFluxResponse) {
        if (j != 0) {
            if (androidVipHighSpeedFluxResponse != null) {
                return this.mLoader.AndroidVipGetFluxQueryTaskResp(j, androidVipHighSpeedFluxResponse);
            }
        }
        return 7001;
    }

    public int AndroidVipDestroyFluxQueryTask(long j) {
        return j == 0 ? 7001 : this.mLoader.AndroidVipDestroyFluxQueryTask(j);
    }

    public int AndroidVipCreateHighSpeedBillingTask(AndroidVipGetTaskId androidVipGetTaskId, AndroidVipHighSpeedBillingReqParam androidVipHighSpeedBillingReqParam) {
        StringBuilder stringBuilder;
        if (androidVipGetTaskId != null) {
            if (androidVipHighSpeedBillingReqParam != null) {
                String str = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("AndroidVipCreateHighSpeedBillingTask beg, vipTaskId=[");
                stringBuilder2.append(androidVipGetTaskId.getTaskId());
                stringBuilder2.append("] mUserId=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mUserId);
                stringBuilder2.append("] mKey=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mKey);
                stringBuilder2.append("] mResType=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mResType);
                stringBuilder2.append("] mResId=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mResId);
                stringBuilder2.append("] mGcid=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mGcid.length());
                stringBuilder2.append("] mCid=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mCid.length());
                stringBuilder2.append("] mFileSize=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mFileSize);
                stringBuilder2.append("] mFileIndex=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mFileIndex);
                stringBuilder2.append("] mFileName=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mFileName);
                stringBuilder2.append("] mBussinessFlag=[");
                stringBuilder2.append(androidVipHighSpeedBillingReqParam.mBussinessFlag);
                stringBuilder2.append("]");
                XLLog.d(str, stringBuilder2.toString());
                androidVipHighSpeedBillingReqParam = this.mLoader.AndroidVipCreateHighSpeedBillingTask(androidVipGetTaskId, androidVipHighSpeedBillingReqParam);
                if (androidVipHighSpeedBillingReqParam != null) {
                    str = TAG;
                    stringBuilder2 = new StringBuilder("AndroidVipCreateHighSpeedBillingTask AndroidVipCreateHighSpeedBillingTask failed, vipTaskId=[");
                    stringBuilder2.append(androidVipGetTaskId.getTaskId());
                    stringBuilder2.append("] errno=[");
                    stringBuilder2.append(androidVipHighSpeedBillingReqParam);
                    stringBuilder2.append("]");
                    XLLog.e(str, stringBuilder2.toString());
                    return androidVipHighSpeedBillingReqParam;
                }
                androidVipHighSpeedBillingReqParam = TAG;
                stringBuilder = new StringBuilder("AndroidVipCreateHighSpeedBillingTask end success, vipTaskId=[");
                stringBuilder.append(androidVipGetTaskId.getTaskId());
                stringBuilder.append("]");
                XLLog.d(androidVipHighSpeedBillingReqParam, stringBuilder.toString());
                return null;
            }
        }
        androidVipHighSpeedBillingReqParam = TAG;
        stringBuilder = new StringBuilder("AndroidVipCreateHighSpeedBillingTask param is null, vipTaskId=[");
        stringBuilder.append(androidVipGetTaskId.getTaskId());
        stringBuilder.append("]");
        XLLog.e(androidVipHighSpeedBillingReqParam, stringBuilder.toString());
        return PARAM_ERROR;
    }

    public int AndroidVipGetHighSpeedBillingTaskResp(long j, AndroidVipHighSpeedBillingResponse androidVipHighSpeedBillingResponse) {
        if (j != 0) {
            if (androidVipHighSpeedBillingResponse != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("AndroidVipGetHighSpeedBillingTaskResp beg, TaskId=[");
                stringBuilder.append(j);
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                int AndroidVipGetHighSpeedBillingTaskResp = this.mLoader.AndroidVipGetHighSpeedBillingTaskResp(j, androidVipHighSpeedBillingResponse);
                if (RUNNING == AndroidVipGetHighSpeedBillingTaskResp) {
                    androidVipHighSpeedBillingResponse = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("AndroidVipGetHighSpeedBillingTaskResp AndroidVipGetHighSpeedBillingTaskResp end is running, TaskId=[");
                    stringBuilder2.append(j);
                    stringBuilder2.append("] errno=[");
                    stringBuilder2.append(AndroidVipGetHighSpeedBillingTaskResp);
                    stringBuilder2.append("]");
                    XLLog.d(androidVipHighSpeedBillingResponse, stringBuilder2.toString());
                    return RUNNING;
                } else if (AndroidVipGetHighSpeedBillingTaskResp != 0) {
                    androidVipHighSpeedBillingResponse = TAG;
                    stringBuilder = new StringBuilder("AndroidVipGetHighSpeedBillingTaskResp AndroidVipGetHighSpeedBillingTaskResp failed, TaskId=[");
                    stringBuilder.append(j);
                    stringBuilder.append("] errno=[");
                    stringBuilder.append(AndroidVipGetHighSpeedBillingTaskResp);
                    stringBuilder.append("]");
                    XLLog.e(androidVipHighSpeedBillingResponse, stringBuilder.toString());
                    return AndroidVipGetHighSpeedBillingTaskResp;
                } else {
                    str = TAG;
                    stringBuilder = new StringBuilder("AndroidVipGetHighSpeedBillingTaskResp end success, TaskId=[");
                    stringBuilder.append(j);
                    stringBuilder.append("] mResult=[");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mResult);
                    stringBuilder.append("] mMessage=[");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mMessage);
                    stringBuilder.append("] mCapacity=[");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mCapacity);
                    stringBuilder.append("] mRemain=[");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mRemain);
                    stringBuilder.append("] mNeeded=[");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mNeeded);
                    stringBuilder.append("]");
                    XLLog.d(str, stringBuilder.toString());
                    return 0;
                }
            }
        }
        androidVipHighSpeedBillingResponse = TAG;
        StringBuilder stringBuilder3 = new StringBuilder("AndroidVipGetHighSpeedBillingTaskResp param is null, TaskId=[");
        stringBuilder3.append(j);
        stringBuilder3.append("]");
        XLLog.e(androidVipHighSpeedBillingResponse, stringBuilder3.toString());
        return 7001;
    }

    public int AndroidVipDestroyHighSpeedBillingTask(long j) {
        if (j == 0) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("AndroidVipDestroyHighSpeedBillingTask TaskId is invalid, TaskId=[");
            stringBuilder.append(j);
            stringBuilder.append("]");
            XLLog.e(str, stringBuilder.toString());
            return 7001;
        }
        str = TAG;
        stringBuilder = new StringBuilder("AndroidVipDestroyHighSpeedBillingTask beg, TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        int AndroidVipDestroyHighSpeedBillingTask = this.mLoader.AndroidVipDestroyHighSpeedBillingTask(j);
        if (AndroidVipDestroyHighSpeedBillingTask != 0) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("AndroidVipDestroyHighSpeedBillingTask AndroidVipDestroyHighSpeedBillingTask failed, TaskId=[");
            stringBuilder2.append(j);
            stringBuilder2.append("] errno=[");
            stringBuilder2.append(AndroidVipDestroyHighSpeedBillingTask);
            stringBuilder2.append("]");
            XLLog.e(str2, stringBuilder2.toString());
            return AndroidVipDestroyHighSpeedBillingTask;
        }
        str = TAG;
        stringBuilder = new StringBuilder("AndroidVipDestroyHighSpeedBillingTask end, TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        return 0;
    }

    public int vipCreateHighSpeedTryTask(VipTryParam vipTryParam, AndroidVipGetTaskId androidVipGetTaskId) {
        if (!(vipTryParam == null || androidVipGetTaskId == null)) {
            if (vipTryParam.checkMemberVar()) {
                if (vipTryParam.mResType == 1) {
                    StringBuilder stringBuilder = new StringBuilder("bt://");
                    stringBuilder.append(vipTryParam.mResId);
                    stringBuilder.append("/");
                    stringBuilder.append(vipTryParam.mFileIndex);
                    vipTryParam.mUrl = stringBuilder.toString();
                    String str = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("BT Url: ");
                    stringBuilder2.append(vipTryParam.mUrl);
                    XLLog.i(str, stringBuilder2.toString());
                }
                return this.mLoader.AndroidVipCreateHighSpeedTryTask(vipTryParam, androidVipGetTaskId);
            }
        }
        return -1;
    }

    public int vipGetHighSpeedTryResult(long j, VipTryQueryResult vipTryQueryResult) {
        return vipTryQueryResult != null ? this.mLoader.AndroidVipGetHighSpeedTryResult(j, vipTryQueryResult) : -1;
    }

    public int vipDestoryHighSpeedTryTask(long j) {
        return this.mLoader != null ? this.mLoader.AndroidVipDestoryHighSpeedTryTask(j) : -1;
    }

    public int vipCreateHighSpeedTryCommitTask(VipTryParam vipTryParam, AndroidVipGetTaskId androidVipGetTaskId) {
        int i = -1;
        if (!(vipTryParam == null || androidVipGetTaskId == null)) {
            if (vipTryParam.checkMemberVar()) {
                if (this.mLoader != null) {
                    if (vipTryParam.mResType == 1) {
                        StringBuilder stringBuilder = new StringBuilder("bt://");
                        stringBuilder.append(vipTryParam.mResId);
                        stringBuilder.append("/");
                        stringBuilder.append(vipTryParam.mFileIndex);
                        vipTryParam.mUrl = stringBuilder.toString();
                        String str = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder("BT Url: ");
                        stringBuilder2.append(vipTryParam.mUrl);
                        XLLog.i(str, stringBuilder2.toString());
                    }
                    i = this.mLoader.AndroidVipCreateHighSpeedTryCommitTask(vipTryParam, androidVipGetTaskId);
                }
                return i;
            }
        }
        return -1;
    }

    public int vipGetHighSpeedTryCommitResult(long j, VipTryCommitResult vipTryCommitResult) {
        return vipTryCommitResult != null ? this.mLoader.AndroidVipGetHighSpeedTryCommitResult(j, vipTryCommitResult) : -1;
    }

    public int vipDestoryHighSpeedTryCommitTask(long j) {
        return this.mLoader.AndroidVipDestoryHighSpeedTryCommitTask(j);
    }

    public int vipSetTaskRetryFlag(long j, int i) {
        int AndroidVipSetTaskRetryFlag = this.mLoader.AndroidVipSetTaskRetryFlag(j, i);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("AndroidVipSetTaskRetryFlag TaskId=[");
        stringBuilder.append(j);
        stringBuilder.append("], flag=[");
        stringBuilder.append(i);
        stringBuilder.append("], ret=[");
        stringBuilder.append(AndroidVipSetTaskRetryFlag);
        stringBuilder.append("]");
        XLLog.d(str, stringBuilder.toString());
        return AndroidVipSetTaskRetryFlag;
    }

    public int AndroidVipSetNetWorkType(int i) {
        if (i > 0) {
            if (i <= 3) {
                return this.mLoader.AndroidVipSetNetWorkType(i);
            }
        }
        return PARAM_ERROR;
    }

    private String getPeerid() {
        String peerid = XLUtil.getPeerid(this.mContext);
        return peerid == null ? "000000000000000V" : peerid;
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
        XLLog.i(TAG, "undoMonitorNetworkChange()");
        if (this.mContext != null && this.mReceiver != null) {
            this.mContext.unregisterReceiver(this.mReceiver);
            XLLog.i(TAG, "unregister Receiver");
            this.mReceiver = null;
        }
    }
}
