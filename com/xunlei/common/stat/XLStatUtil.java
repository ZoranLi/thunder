package com.xunlei.common.stat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLPhoneInfo;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.device.a.a;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.common.stat.base.a.b;
import com.xunlei.common.stat.base.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
public final class XLStatUtil implements b {
    private static int MSG_REPORT_ERROR_OPERATION = -268431324;
    private static final String PLATFORM = "10";
    private static final String REPORT_BASE_URL = "http://stat.login.xunlei.com/loginstat";
    private static final int REPORT_ONCE_NUM = 3;
    private static int REPORT_REMOVE_BASE = 251662626;
    private static int REPORT_TIMER_BASE = 252269168;
    private static final int REPORT_TIME_EXPIRE = 30000;
    private static final int XL_BASE_PTL_VER = 200;
    public static boolean mAcceptPhoneCode = false;
    private static XLStatUtil mInstance;
    private String TAG = XLStatUtil.class.getSimpleName();
    private String mAppName = "";
    private int mBusinessType = -1;
    private String mClientVersion = "";
    private Context mContext = null;
    private int mCurrentRemoveMsgId = 0;
    private int mCurrentStatTimerId = 0;
    private String mDeviceMacAddress = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            XLStatUtil.this.handleMessage(message);
        }
    };
    private HttpClient mHttpClient = null;
    private boolean mIsMoudleInit = false;
    private c mLocker = new c();
    private XLStatItem mLoginFastPhoneCode = null;
    private int mLoginProtocolVersion = 0;
    private String mPeerId = "";
    private String mRegisterFrom = "";
    private XLStatItem mRegisterPhoneCode = null;
    private volatile boolean mReportThreadFin = false;
    private Runnable mRunner = new Runnable() {
        public void run() {
            while (true) {
                XLStatUtil.this.mLocker.a(0);
                XLLog.v(XLStatUtil.this.TAG, "wait lock release");
                if (XLStatUtil.this.mReportThreadFin) {
                    XLLog.v(XLStatUtil.this.TAG, "report thread finish!");
                    return;
                } else if (XLStatUtil.this.mXLReportStatList.size() >= 3) {
                    XLStatUtil.this.reportStatToServer(XLStatUtil.this.packReportStatUrl(), XLStatUtil.this.getReportBody());
                }
            }
        }
    };
    private String mSDKVersion = "";
    private a mStatDBManager$797505f8 = null;
    private Thread mThread = null;
    private boolean mTimerStarted = false;
    private List<XLStatPack> mXLReportStatList = new ArrayList();
    private Map<Integer, XLStatItem> mXLStatRequestMap = new HashMap();

    private String getThirdType(int i) {
        return i == XLStatCommandID.XLCID_WX_LOGIN_BIND ? "21" : i == XLStatCommandID.XLCID_SINA_LOGIN_BIND ? "1" : i == XLStatCommandID.XLCID_XM_LOGIN_BIND ? "8" : i == XLStatCommandID.XLCID_ALIPAY_LOGIN_BIND ? "4" : i == XLStatCommandID.XLCID_QQ_LOGIN_BIND ? "15" : "";
    }

    private void reportStatToServer(java.lang.String r4, org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r3.TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "reportStatToServer url = ";
        r1.<init>(r2);
        r1.append(r4);
        r2 = "# content = ";
        r1.append(r2);
        r2 = r5.toString();
        r1.append(r2);
        r1 = r1.toString();
        com.xunlei.common.base.XLLog.d(r0, r1);
        r0 = 0;
        r1 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0042 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0042 }
        r4 = new org.apache.http.entity.StringEntity;	 Catch:{ Exception -> 0x0040 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0040 }
        r0 = "UTF-8";	 Catch:{ Exception -> 0x0040 }
        r4.<init>(r5, r0);	 Catch:{ Exception -> 0x0040 }
        r5 = "application/json";	 Catch:{ Exception -> 0x0040 }
        r4.setContentType(r5);	 Catch:{ Exception -> 0x0040 }
        r1.setEntity(r4);	 Catch:{ Exception -> 0x0040 }
        goto L_0x005b;
    L_0x0040:
        r4 = move-exception;
        goto L_0x0044;
    L_0x0042:
        r4 = move-exception;
        r1 = r0;
    L_0x0044:
        r5 = r3.TAG;
        r0 = new java.lang.StringBuilder;
        r2 = "report stat to server error = ";
        r0.<init>(r2);
        r4 = r4.getMessage();
        r0.append(r4);
        r4 = r0.toString();
        com.xunlei.common.base.XLLog.e(r5, r4);
    L_0x005b:
        if (r1 != 0) goto L_0x006b;
    L_0x005d:
        r4 = r3.mHandler;
        r5 = r3.mHandler;
        r0 = r3.mCurrentRemoveMsgId;
        r5 = r5.obtainMessage(r0);
        r4.sendMessage(r5);
        return;
    L_0x006b:
        r4 = r3.mHttpClient;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r4.execute(r1);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r4.getStatusLine();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r5.getStatusCode();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r4.getEntity();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        org.apache.http.util.EntityUtils.toString(r4);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        if (r5 != r4) goto L_0x0092;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
    L_0x0084:
        r4 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0 = r3.mCurrentRemoveMsgId;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r5.obtainMessage(r0);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4.sendMessage(r5);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        goto L_0x00b2;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
    L_0x0092:
        r4 = r3.TAG;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r2 = "reportStatToServer error code = ";	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0.append(r5);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r0.toString();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        com.xunlei.common.base.XLLog.e(r4, r5);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0 = MSG_REPORT_ERROR_OPERATION;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r5.obtainMessage(r0);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4.sendMessage(r5);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
    L_0x00b2:
        if (r1 == 0) goto L_0x00e8;
    L_0x00b4:
        r1.abort();
        return;
    L_0x00b8:
        r4 = move-exception;
        goto L_0x00e9;
    L_0x00ba:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r3.TAG;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r2 = "reportStatToServer error desc = ";	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r4.getMessage();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0.append(r4);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        com.xunlei.common.base.XLLog.e(r5, r4);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r3.mHandler;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r0 = MSG_REPORT_ERROR_OPERATION;	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r5 = r5.obtainMessage(r0);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        r4.sendMessage(r5);	 Catch:{ Exception -> 0x00ba, all -> 0x00b8 }
        if (r1 == 0) goto L_0x00e8;
    L_0x00e4:
        r1.abort();
        return;
    L_0x00e8:
        return;
    L_0x00e9:
        if (r1 == 0) goto L_0x00ee;
    L_0x00eb:
        r1.abort();
    L_0x00ee:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.stat.XLStatUtil.reportStatToServer(java.lang.String, org.json.JSONObject):void");
    }

    private XLStatUtil() {
    }

    public static XLStatUtil getInstance() {
        if (mInstance == null) {
            mInstance = new XLStatUtil();
        }
        return mInstance;
    }

    public final void init(Context context, int i, String str, String str2, String str3) {
        if (!this.mIsMoudleInit) {
            String str4 = this.TAG;
            StringBuilder stringBuilder = new StringBuilder("init stat moudle id = ");
            stringBuilder.append(hashCode());
            XLLog.d(str4, stringBuilder.toString());
            this.mBusinessType = i;
            this.mClientVersion = str;
            this.mSDKVersion = str2;
            this.mPeerId = str3;
            this.mXLStatRequestMap.clear();
            this.mContext = context;
            this.mHttpClient = new DefaultHttpClient();
            this.mDeviceMacAddress = getDeviceMac();
            this.mAppName = this.mContext.getApplicationInfo().packageName;
            context = REPORT_TIMER_BASE;
            REPORT_TIMER_BASE = context + 1;
            this.mCurrentStatTimerId = context;
            REPORT_REMOVE_BASE += 100;
            this.mCurrentRemoveMsgId = REPORT_REMOVE_BASE;
            com.xunlei.common.stat.base.a.a(this.mContext);
            this.mThread = new Thread(this.mRunner);
            this.mThread.start();
            this.mReportThreadFin = null;
            this.mStatDBManager$797505f8 = new a(this.mContext);
            loadReportsFromDataBase();
            if (this.mXLReportStatList.size() >= 3) {
                startStatTimer();
            }
            this.mIsMoudleInit = true;
        }
    }

    public final void uninit() {
        if (this.mIsMoudleInit) {
            com.xunlei.common.stat.base.a.a();
            saveReportsToDataBase();
            this.mReportThreadFin = true;
            this.mLocker.a();
            this.mStatDBManager$797505f8.c();
            this.mXLStatRequestMap.clear();
            this.mIsMoudleInit = false;
        }
    }

    public final int getBusinessType() {
        return this.mBusinessType;
    }

    public final void setLoginProtocolVersion(int i) {
        if (i > 0) {
            this.mLoginProtocolVersion = i;
        }
    }

    public final void setRegisterFrom(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mRegisterFrom = str;
        }
    }

    public final synchronized void clearStatItems() {
        this.mXLReportStatList.clear();
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("xunlei-reportlist:clear all stat items size = ");
        stringBuilder.append(this.mXLReportStatList.size());
        XLLog.v(str, stringBuilder.toString());
    }

    public final synchronized void registerStatReq(int i) {
        XLStatItem xLStatItem = new XLStatItem();
        xLStatItem.mTaskCookie = i;
        xLStatItem.mRequestTime = getCurrentTime();
        this.mXLStatRequestMap.put(Integer.valueOf(i), xLStatItem);
    }

    public final synchronized void registerStatReq(int i, int i2) {
        XLStatItem xLStatItem = new XLStatItem();
        xLStatItem.mTaskCookie = i;
        xLStatItem.mRequestTime = getCurrentTime();
        xLStatItem.mRequestCommandID = i2;
        this.mXLStatRequestMap.put(Integer.valueOf(i), xLStatItem);
    }

    public final synchronized void registerSpecialStatReq(int i, int i2) {
        XLStatItem xLStatItem = new XLStatItem();
        xLStatItem.mTaskCookie = i;
        xLStatItem.mRequestTime = getCurrentTime();
        if (i2 == 1) {
            this.mRegisterPhoneCode = xLStatItem;
        } else {
            this.mLoginFastPhoneCode = xLStatItem;
        }
    }

    public final synchronized void reportSpecialStat(int i, XLStatPack xLStatPack) {
        XLStatItem xLStatItem = this.mLoginFastPhoneCode;
        if (i == 1) {
            xLStatItem = this.mRegisterPhoneCode;
        }
        if (xLStatItem != null) {
            xLStatPack.mRespTime = (double) (getCurrentTime() - xLStatItem.mRequestTime);
            xLStatPack.mReportDate = getReportDate();
            this.mXLReportStatList.add(0, xLStatPack);
            if (i == 1) {
                this.mRegisterPhoneCode = null;
            } else {
                this.mLoginFastPhoneCode = null;
            }
            if (this.mXLReportStatList.size() >= 3) {
                startStatTimer();
            }
            i = this.TAG;
            StringBuilder stringBuilder = new StringBuilder("report command id = ");
            stringBuilder.append(xLStatPack.mCommandID);
            XLLog.d(i, stringBuilder.toString());
            i = this.TAG;
            xLStatPack = new StringBuilder("xunlei-reportlist:report add stat item current size = ");
            xLStatPack.append(this.mXLReportStatList.size());
            XLLog.v(i, xLStatPack.toString());
        }
    }

    private synchronized void unRegisterStatReq(int i) {
        this.mXLStatRequestMap.remove(Integer.valueOf(i));
    }

    public final synchronized void report(int i, XLStatPack xLStatPack) {
        XLStatItem statReq = getStatReq(i);
        if (statReq != null) {
            xLStatPack.mRespTime = (double) (getCurrentTime() - statReq.mRequestTime);
            xLStatPack.mReportDate = getReportDate();
            this.mXLReportStatList.add(0, xLStatPack);
            unRegisterStatReq(i);
            if (this.mXLReportStatList.size() >= 3) {
                startStatTimer();
            }
            i = this.TAG;
            StringBuilder stringBuilder = new StringBuilder("report command id = ");
            stringBuilder.append(xLStatPack.mCommandID);
            XLLog.d(i, stringBuilder.toString());
            i = this.TAG;
            xLStatPack = new StringBuilder("xunlei-reportlist:report add stat item current size = ");
            xLStatPack.append(this.mXLReportStatList.size());
            XLLog.v(i, xLStatPack.toString());
        }
    }

    public final synchronized void report(XLStatPack xLStatPack) {
        xLStatPack.mReportDate = getReportDate();
        this.mXLReportStatList.add(0, xLStatPack);
        if (this.mXLReportStatList.size() >= 3) {
            startStatTimer();
        }
        xLStatPack = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("xunlei-reportlist:report add stat item current size = ");
        stringBuilder.append(this.mXLReportStatList.size());
        XLLog.v(xLStatPack, stringBuilder.toString());
    }

    public final synchronized void report(int i, XLStatPack xLStatPack, boolean z) {
        XLStatItem statReq = getStatReq(i);
        if (statReq != null) {
            xLStatPack.mRespTime = (double) (getCurrentTime() - statReq.mRequestTime);
            xLStatPack.mReportDate = getReportDate();
            if (z) {
                xLStatPack.mCommandID = statReq.mRequestCommandID;
            }
            this.mXLReportStatList.add(0, xLStatPack);
            unRegisterStatReq(i);
            if (this.mXLReportStatList.size() >= true) {
                startStatTimer();
            }
            i = this.TAG;
            z = new StringBuilder("report command id = ");
            z.append(xLStatPack.mCommandID);
            XLLog.d(i, z.toString());
            i = this.TAG;
            xLStatPack = new StringBuilder("xunlei-reportlist:report add stat item current size = ");
            xLStatPack.append(this.mXLReportStatList.size());
            XLLog.v(i, xLStatPack.toString());
        }
    }

    public final void onTimerTick(int i) {
        if (this.mCurrentStatTimerId == i) {
            String str = this.TAG;
            StringBuilder stringBuilder = new StringBuilder("onTimerTick mXLReportStatList.size = ");
            stringBuilder.append(this.mXLReportStatList.size());
            stringBuilder.append(" timerid = ");
            stringBuilder.append(i);
            XLLog.d(str, stringBuilder.toString());
            if (this.mXLReportStatList.size() >= 3) {
                this.mLocker.a();
                return;
            }
            killStatTimer();
        }
    }

    private long getCurrentTime() {
        return new Date().getTime();
    }

    private synchronized XLStatItem getStatReq(int i) {
        return (XLStatItem) this.mXLStatRequestMap.get(Integer.valueOf(i));
    }

    protected final String integer2String(int i) {
        return String.valueOf(i);
    }

    protected final String long2String(long j) {
        return String.valueOf(j);
    }

    private synchronized JSONObject getReportBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocolVersion", integer2String(200));
            jSONObject.put(DispatchConstants.PLATFORM_VERSION, "10");
            jSONObject.put("businessType", integer2String(getBusinessType()));
            jSONObject.put("clientVersion", this.mClientVersion);
            StringBuilder stringBuilder = new StringBuilder("ANDROID-");
            stringBuilder.append(this.mAppName);
            jSONObject.put("appName", stringBuilder.toString());
            jSONObject.put(Constants.KEY_SDK_VERSION, integer2String(extraSDKVersionBuild()));
            jSONObject.put("loginProtocolVersion", integer2String(this.mLoginProtocolVersion));
            jSONObject.put("registerFrom", this.mRegisterFrom);
            jSONObject.put("deviceId", XLDeviceGen.getInstance().getDeviceId());
            jSONObject.put("osVersion", VERSION.RELEASE);
            jSONObject.put("deviceModel", Build.MODEL);
            jSONObject.put("deviceName", com.xunlei.common.stat.base.b.c());
            int size = this.mXLReportStatList.size();
            String str = this.TAG;
            StringBuilder stringBuilder2 = new StringBuilder("packReportStatUrl report list size = ");
            stringBuilder2.append(size);
            XLLog.v(str, stringBuilder2.toString());
            if (size < 3) {
                return jSONObject;
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (i < 3) {
                i++;
                XLStatPack xLStatPack = (XLStatPack) this.mXLReportStatList.get(size - i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reqCommand", XLStatCommandID.getReportCommand(xLStatPack.mCommandID));
                jSONObject2.put("errorCode", integer2String(xLStatPack.mErrorCode));
                jSONObject2.put("respTime", integer2String((int) xLStatPack.mRespTime));
                jSONObject2.put("retryNum", integer2String(xLStatPack.mRetryNum + 1));
                jSONObject2.put(DispatchConstants.DOMAIN, xLStatPack.mSvrDomain);
                jSONObject2.put("serverIp", xLStatPack.mSvrIp);
                jSONObject2.put("reqFinal", integer2String(xLStatPack.mFinal));
                jSONObject2.put("flowID", long2String(xLStatPack.mFlowId / 1000));
                jSONObject2.put("netWorkType", xLStatPack.mNetType);
                jSONObject2.put("providerName", xLStatPack.mISP);
                if (!TextUtils.isEmpty(xLStatPack.mErrorMessage)) {
                    jSONObject2.put("errorMsg", xLStatPack.mErrorMessage);
                }
                CharSequence thirdType = getThirdType(xLStatPack.mCommandID);
                if (!TextUtils.isEmpty(thirdType)) {
                    jSONObject2.put("extParam", thirdType);
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("statList", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private synchronized String packReportStatUrl() {
        return REPORT_BASE_URL;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void handleMessage(android.os.Message r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mCurrentRemoveMsgId;	 Catch:{ all -> 0x0058 }
        r1 = r5.what;	 Catch:{ all -> 0x0058 }
        if (r0 != r1) goto L_0x0043;
    L_0x0007:
        r5 = 0;
    L_0x0008:
        r0 = 3;
        if (r5 >= r0) goto L_0x001d;
    L_0x000b:
        r0 = r4.mXLReportStatList;	 Catch:{ all -> 0x0058 }
        r0 = r0.size();	 Catch:{ all -> 0x0058 }
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x001a;
    L_0x0015:
        r1 = r4.mXLReportStatList;	 Catch:{ all -> 0x0058 }
        r1.remove(r0);	 Catch:{ all -> 0x0058 }
    L_0x001a:
        r5 = r5 + 1;
        goto L_0x0008;
    L_0x001d:
        r5 = r4.mXLReportStatList;	 Catch:{ all -> 0x0058 }
        r5 = r5.size();	 Catch:{ all -> 0x0058 }
        r1 = r4.TAG;	 Catch:{ all -> 0x0058 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0058 }
        r3 = "xunlei-reportlist:remove stat items current size = ";
        r2.<init>(r3);	 Catch:{ all -> 0x0058 }
        r3 = r4.mXLReportStatList;	 Catch:{ all -> 0x0058 }
        r3 = r3.size();	 Catch:{ all -> 0x0058 }
        r2.append(r3);	 Catch:{ all -> 0x0058 }
        r2 = r2.toString();	 Catch:{ all -> 0x0058 }
        com.xunlei.common.base.XLLog.v(r1, r2);	 Catch:{ all -> 0x0058 }
        if (r5 >= r0) goto L_0x0041;
    L_0x003e:
        r4.killStatTimer();	 Catch:{ all -> 0x0058 }
    L_0x0041:
        monitor-exit(r4);
        return;
    L_0x0043:
        r0 = MSG_REPORT_ERROR_OPERATION;	 Catch:{ all -> 0x0058 }
        r5 = r5.what;	 Catch:{ all -> 0x0058 }
        if (r0 != r5) goto L_0x0056;
    L_0x0049:
        r5 = "XLStatUtil";
        r0 = "stat error, kill stat timer, save data to database";
        com.xunlei.common.base.XLLog.v(r5, r0);	 Catch:{ all -> 0x0058 }
        r4.killStatTimer();	 Catch:{ all -> 0x0058 }
        r4.saveReportsToDataBase();	 Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r4);
        return;
    L_0x0058:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.stat.XLStatUtil.handleMessage(android.os.Message):void");
    }

    private synchronized void loadReportsFromDataBase() {
        Collection b = this.mStatDBManager$797505f8.b();
        if (b.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder("loadReportsFromDataBase size = ");
            stringBuilder.append(b.size());
            XLLog.v("XLStatUtil", stringBuilder.toString());
            this.mXLReportStatList.addAll(b);
            String str = this.TAG;
            StringBuilder stringBuilder2 = new StringBuilder("xunlei-reportlist:load stat items from data base current size = ");
            stringBuilder2.append(this.mXLReportStatList.size());
            XLLog.v(str, stringBuilder2.toString());
            this.mStatDBManager$797505f8.a();
        }
    }

    private void saveReportsToDataBase() {
        XLLog.v("XLStatUtil", "save report list to database.");
        this.mStatDBManager$797505f8.a(this.mXLReportStatList);
        this.mXLReportStatList.clear();
    }

    private String getReportDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    private String getDeviceMac() {
        return XLPhoneInfo.getDeviceMacInfo(this.mContext);
    }

    private synchronized void startStatTimer() {
        if (!this.mTimerStarted) {
            this.mTimerStarted = true;
            com.xunlei.common.stat.base.a.b().a(this.mCurrentStatTimerId, 30000, true, this);
            XLLog.v(this.TAG, "startStatTimer");
        }
    }

    private synchronized void killStatTimer() {
        if (this.mTimerStarted) {
            this.mTimerStarted = false;
            com.xunlei.common.stat.base.a.b().a(this.mCurrentStatTimerId);
            XLLog.v(this.TAG, "killStatTimer");
        }
    }

    private int extraSDKVersionBuild() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "extraSDKVersionBuild Raw SDKVersion = ";
        r1.<init>(r2);
        r2 = r4.mSDKVersion;
        r1.append(r2);
        r1 = r1.toString();
        com.xunlei.common.base.XLLog.v(r0, r1);
        r0 = r4.mSDKVersion;
        r1 = ".";
        r0 = r0.lastIndexOf(r1);
        r1 = -1;
        if (r0 == r1) goto L_0x0044;
    L_0x0020:
        r1 = r4.mSDKVersion;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0044 }
        r1 = r4.TAG;	 Catch:{ Exception -> 0x0044 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044 }
        r3 = "extraSDKVersionBuild build SDKVersion = ";	 Catch:{ Exception -> 0x0044 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0044 }
        r2.append(r0);	 Catch:{ Exception -> 0x0044 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0044 }
        com.xunlei.common.base.XLLog.v(r1, r2);	 Catch:{ Exception -> 0x0044 }
        return r0;
    L_0x0044:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.stat.XLStatUtil.extraSDKVersionBuild():int");
    }
}
