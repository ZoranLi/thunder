package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.common.security.RSAUtil;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AidTask4Plug {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    private static final int MAX_RETRY_NUM = 3;
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_ERR = 1002;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask4Plug sInstance;
    private String hash;
    private Map<String, AidInfo> mAidInfo = new HashMap(3);
    private String mAppKey;
    private Context mContext;
    private CallbackHandler mHandler;
    private String pkg;

    public static final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public final String getAid() {
            return this.mAid;
        }

        public final String getSubCookie() {
            return this.mSubCookie;
        }

        public static AidInfo parseJson(String str) throws WeiboException {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") == null) {
                    if (jSONObject.has("error_code") == null) {
                        aidInfo.mAid = jSONObject.optString("aid", "");
                        aidInfo.mSubCookie = jSONObject.optString("sub", "");
                        return aidInfo;
                    }
                }
                LogUtil.d(AidTask4Plug.TAG, "loadAidFromNet has error !!!");
                throw new WeiboException("loadAidFromNet has error !!!");
            } catch (String str2) {
                String str3 = AidTask4Plug.TAG;
                StringBuilder stringBuilder = new StringBuilder("loadAidFromNet JSONException Msg : ");
                stringBuilder.append(str2.getMessage());
                LogUtil.d(str3, stringBuilder.toString());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        final AidInfo cloneAidInfo() {
            AidInfo aidInfo = new AidInfo();
            aidInfo.mAid = this.mAid;
            aidInfo.mSubCookie = this.mSubCookie;
            return aidInfo;
        }
    }

    public interface AidResultCallBack {
        void onAidGenFailed(Exception exception);

        void onAidGenSuccessed(AidInfo aidInfo);
    }

    private static class CallbackHandler extends Handler {
        private WeakReference<AidResultCallBack> callBackReference;

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public void setCallback(AidResultCallBack aidResultCallBack) {
            if (this.callBackReference == null) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            } else if (((AidResultCallBack) this.callBackReference.get()) != aidResultCallBack) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            }
        }

        public void handleMessage(Message message) {
            AidResultCallBack aidResultCallBack = (AidResultCallBack) this.callBackReference.get();
            switch (message.what) {
                case 1001:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenSuccessed(((AidInfo) message.obj).cloneAidInfo());
                        return;
                    }
                    break;
                case 1002:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenFailed((WeiboException) message.obj);
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized void setAppkey(String str) {
        this.mAppKey = str;
    }

    private AidTask4Plug(Context context, final String str) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
        new Thread(new Runnable() {
            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r0 = 0;
                r1 = r0;
            L_0x0002:
                if (r1 > 0) goto L_0x0012;
            L_0x0004:
                r2 = com.sina.weibo.sdk.utils.AidTask4Plug.this;
                r3 = r4;
                r2 = r2.getAidInfoFile(r0, r3);
                r2.delete();	 Catch:{ Exception -> 0x000f }
            L_0x000f:
                r1 = r1 + 1;
                goto L_0x0002;
            L_0x0012:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.1.run():void");
            }
        }).start();
    }

    public static synchronized AidTask4Plug getInstance(Context context, String str) {
        synchronized (AidTask4Plug.class) {
            if (sInstance == null) {
                sInstance = new AidTask4Plug(context, str);
            }
            context = sInstance;
        }
        return context;
    }

    public void aidTaskInit(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "aidTaskInit ");
            initAidInfo(str);
        }
    }

    private AidInfo aidTaskInit(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "aidTaskInit ");
        return initAidInfo(str, str2, str3);
    }

    public AidInfo initAidInfo(String str, String str2, String str3) {
        WeiboException e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AidInfo parseJson;
        this.mAppKey = str;
        this.pkg = str2;
        this.hash = str3;
        str2 = loadAidInfoFromCache(str);
        if (str2 == null) {
            String str4 = str2;
            str2 = 1;
            while (true) {
                Object obj;
                str2 += 1;
                String loadAidFromNet;
                try {
                    loadAidFromNet = loadAidFromNet();
                    parseJson = AidInfo.parseJson(loadAidFromNet);
                    try {
                        cacheAidInfo(loadAidFromNet, str);
                        this.mAidInfo.put(str, parseJson);
                        break;
                    } catch (WeiboException e2) {
                        e = e2;
                    }
                } catch (WeiboException e3) {
                    parseJson = str4;
                    e = e3;
                    loadAidFromNet = TAG;
                    StringBuilder stringBuilder = new StringBuilder("AidTaskInit WeiboException Msg : ");
                    stringBuilder.append(e.getMessage());
                    LogUtil.e(loadAidFromNet, stringBuilder.toString());
                    if (str2 >= 3) {
                        return parseJson;
                    }
                    obj = parseJson;
                }
                obj = parseJson;
            }
        } else {
            this.mAidInfo.put(str, str2);
            parseJson = str2;
        }
        return parseJson;
    }

    private void initAidInfo(String str) {
        initAidInfo(str, null, null);
    }

    public AidInfo getAid4PlugSync(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "getAidSync ");
        if (this.mAidInfo.get(str) == null) {
            aidTaskInit(str, str2, str3);
        }
        return (AidInfo) this.mAidInfo.get(str);
    }

    protected synchronized com.sina.weibo.sdk.utils.AidTask4Plug.AidInfo loadAidInfoFromCache(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 1;
        r1 = 0;
        r4 = r3.getAidInfoFile(r0, r4);	 Catch:{ Exception -> 0x002d, all -> 0x0025 }
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x002d, all -> 0x0025 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x002d, all -> 0x0025 }
        r4 = r0.available();	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r4 = new byte[r4];	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r0.read(r4);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r4 = com.sina.weibo.sdk.utils.AidTask4Plug.AidInfo.parseJson(r2);	 Catch:{ Exception -> 0x002e, all -> 0x0023 }
        r0.close();	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        monitor-exit(r3);
        return r4;
    L_0x0023:
        r4 = move-exception;
        goto L_0x0027;
    L_0x0025:
        r4 = move-exception;
        r0 = r1;
    L_0x0027:
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r0.close();	 Catch:{ IOException -> 0x002c }
    L_0x002c:
        throw r4;	 Catch:{ all -> 0x0034 }
    L_0x002d:
        r0 = r1;
    L_0x002e:
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r0.close();	 Catch:{ IOException -> 0x0037 }
        goto L_0x0037;
    L_0x0034:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x0037:
        monitor-exit(r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.loadAidInfoFromCache(java.lang.String):com.sina.weibo.sdk.utils.AidTask4Plug$AidInfo");
    }

    public String loadAidFromCache(String str) {
        str = loadAidInfoFromCache(str);
        if (str != null) {
            return str.getAid() == null ? "" : str.getAid();
        } else {
            return "";
        }
    }

    private File getAidInfoFile(int i, String str) {
        File filesDir = this.mContext.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder(AID_FILE_NAME);
        stringBuilder.append(str);
        stringBuilder.append(i);
        return new File(filesDir, stringBuilder.toString());
    }

    private String loadAidFromNet() throws WeiboException {
        String packageName = this.pkg == null ? this.mContext.getPackageName() : this.pkg;
        String sign = this.hash == null ? Utility.getSign(this.mContext, packageName) : this.hash;
        String mfp = getMfp(this.mContext);
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put("appkey", this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        StringBuilder stringBuilder;
        try {
            packageName = HttpManager.openUrl(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", weiboParameters);
            sign = TAG;
            stringBuilder = new StringBuilder("loadAidFromNet response : ");
            stringBuilder.append(packageName);
            LogUtil.d(sign, stringBuilder.toString());
            return packageName;
        } catch (WeiboException e) {
            sign = TAG;
            stringBuilder = new StringBuilder("loadAidFromNet WeiboException Msg : ");
            stringBuilder.append(e.getMessage());
            LogUtil.d(sign, stringBuilder.toString());
            throw e;
        }
    }

    private synchronized void cacheAidInfo(java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);
        return;
    L_0x0009:
        r0 = 0;
        r1 = 1;
        r4 = r2.getAidInfoFile(r1, r4);	 Catch:{ Exception -> 0x002e, all -> 0x0027 }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x002e, all -> 0x0027 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x002e, all -> 0x0027 }
        r3 = r3.getBytes();	 Catch:{ Exception -> 0x0025, all -> 0x0022 }
        r1.write(r3);	 Catch:{ Exception -> 0x0025, all -> 0x0022 }
        r1.close();	 Catch:{ IOException -> 0x0020 }
        monitor-exit(r2);
        return;
    L_0x0020:
        monitor-exit(r2);
        return;
    L_0x0022:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0028;
    L_0x0025:
        r0 = r1;
        goto L_0x002e;
    L_0x0027:
        r3 = move-exception;
    L_0x0028:
        if (r0 == 0) goto L_0x002d;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002d }
    L_0x002d:
        throw r3;	 Catch:{ all -> 0x0039 }
    L_0x002e:
        if (r0 == 0) goto L_0x0037;
    L_0x0030:
        r0.close();	 Catch:{ IOException -> 0x0035 }
        monitor-exit(r2);
        return;
    L_0x0035:
        monitor-exit(r2);
        return;
    L_0x0037:
        monitor-exit(r2);
        return;
    L_0x0039:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.cacheAidInfo(java.lang.String, java.lang.String):void");
    }

    private static java.lang.String getMfp(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = genMfpString(r3);
        r0 = "";
        r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r3 = r3.getBytes();	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r1.<init>(r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x0012 }
        r0 = r1;
    L_0x0012:
        r3 = "AidTask";
        r1 = new java.lang.StringBuilder;
        r2 = "genMfpString() utf-8 string : ";
        r1.<init>(r2);
        r1.append(r0);
        r1 = r1.toString();
        com.sina.weibo.sdk.utils.LogUtil.d(r3, r1);
        r3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB";	 Catch:{ Exception -> 0x003f }
        r3 = encryptRsa(r0, r3);	 Catch:{ Exception -> 0x003f }
        r0 = "AidTask";	 Catch:{ Exception -> 0x003f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003f }
        r2 = "encryptRsa() string : ";	 Catch:{ Exception -> 0x003f }
        r1.<init>(r2);	 Catch:{ Exception -> 0x003f }
        r1.append(r3);	 Catch:{ Exception -> 0x003f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x003f }
        com.sina.weibo.sdk.utils.LogUtil.d(r0, r1);	 Catch:{ Exception -> 0x003f }
        return r3;
    L_0x003f:
        r3 = move-exception;
        r0 = "AidTask";
        r3 = r3.getMessage();
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r3);
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getMfp(android.content.Context):java.lang.String");
    }

    private static java.lang.String genMfpString(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = getOS();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x0014;	 Catch:{ JSONException -> 0x00eb }
    L_0x000f:
        r2 = "1";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x0014:
        r1 = getImei(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x0023;	 Catch:{ JSONException -> 0x00eb }
    L_0x001e:
        r2 = "2";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x0023:
        r1 = getMeid(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x0032;	 Catch:{ JSONException -> 0x00eb }
    L_0x002d:
        r2 = "3";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x0032:
        r1 = getImsi(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x0041;	 Catch:{ JSONException -> 0x00eb }
    L_0x003c:
        r2 = "4";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x0041:
        r1 = getMac(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x0050;	 Catch:{ JSONException -> 0x00eb }
    L_0x004b:
        r2 = "5";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x0050:
        r1 = getIccid(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x005f;	 Catch:{ JSONException -> 0x00eb }
    L_0x005a:
        r2 = "6";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x005f:
        r1 = getSerialNo();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x006e;	 Catch:{ JSONException -> 0x00eb }
    L_0x0069:
        r2 = "7";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x006e:
        r1 = getAndroidId(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x007d;	 Catch:{ JSONException -> 0x00eb }
    L_0x0078:
        r2 = "10";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x007d:
        r1 = getCpu();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x008c;	 Catch:{ JSONException -> 0x00eb }
    L_0x0087:
        r2 = "13";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x008c:
        r1 = getModel();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x009b;	 Catch:{ JSONException -> 0x00eb }
    L_0x0096:
        r2 = "14";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x009b:
        r1 = getSdSize();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x00aa;	 Catch:{ JSONException -> 0x00eb }
    L_0x00a5:
        r2 = "15";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x00aa:
        r1 = getResolution(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x00b9;	 Catch:{ JSONException -> 0x00eb }
    L_0x00b4:
        r2 = "16";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x00b9:
        r1 = getSsid(r3);	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x00c8;	 Catch:{ JSONException -> 0x00eb }
    L_0x00c3:
        r2 = "17";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x00c8:
        r1 = getDeviceName();	 Catch:{ JSONException -> 0x00eb }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00eb }
        if (r2 != 0) goto L_0x00d7;	 Catch:{ JSONException -> 0x00eb }
    L_0x00d2:
        r2 = "18";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00eb }
    L_0x00d7:
        r3 = getConnectType(r3);	 Catch:{ JSONException -> 0x00eb }
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ JSONException -> 0x00eb }
        if (r1 != 0) goto L_0x00e6;	 Catch:{ JSONException -> 0x00eb }
    L_0x00e1:
        r1 = "19";	 Catch:{ JSONException -> 0x00eb }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x00eb }
    L_0x00e6:
        r3 = r0.toString();	 Catch:{ JSONException -> 0x00eb }
        return r3;
    L_0x00eb:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.genMfpString(android.content.Context):java.lang.String");
    }

    private static java.lang.String encryptRsa(java.lang.String r7, java.lang.String r8) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "RSA/ECB/PKCS1Padding";
        r0 = javax.crypto.Cipher.getInstance(r0);
        r8 = getPublicKey(r8);
        r1 = 1;
        r0.init(r1, r8);
        r8 = "UTF-8";
        r7 = r7.getBytes(r8);
        r8 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x00b2 }
        r1.<init>();	 Catch:{ all -> 0x00b2 }
        r8 = 0;
    L_0x001b:
        r2 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r2 = splite(r7, r8, r2);	 Catch:{ all -> 0x00b0 }
        r3 = -1;	 Catch:{ all -> 0x00b0 }
        if (r2 == r3) goto L_0x0051;	 Catch:{ all -> 0x00b0 }
    L_0x0024:
        r3 = r0.doFinal(r7, r8, r2);	 Catch:{ all -> 0x00b0 }
        r1.write(r3);	 Catch:{ all -> 0x00b0 }
        r4 = "AidTask";	 Catch:{ all -> 0x00b0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r6 = "encryptRsa offset = ";	 Catch:{ all -> 0x00b0 }
        r5.<init>(r6);	 Catch:{ all -> 0x00b0 }
        r5.append(r8);	 Catch:{ all -> 0x00b0 }
        r6 = "     len = ";	 Catch:{ all -> 0x00b0 }
        r5.append(r6);	 Catch:{ all -> 0x00b0 }
        r5.append(r2);	 Catch:{ all -> 0x00b0 }
        r6 = "     enBytes len = ";	 Catch:{ all -> 0x00b0 }
        r5.append(r6);	 Catch:{ all -> 0x00b0 }
        r3 = r3.length;	 Catch:{ all -> 0x00b0 }
        r5.append(r3);	 Catch:{ all -> 0x00b0 }
        r3 = r5.toString();	 Catch:{ all -> 0x00b0 }
        com.sina.weibo.sdk.utils.LogUtil.d(r4, r3);	 Catch:{ all -> 0x00b0 }
        r8 = r8 + r2;	 Catch:{ all -> 0x00b0 }
        goto L_0x001b;	 Catch:{ all -> 0x00b0 }
    L_0x0051:
        r1.flush();	 Catch:{ all -> 0x00b0 }
        r7 = r1.toByteArray();	 Catch:{ all -> 0x00b0 }
        r8 = "AidTask";	 Catch:{ all -> 0x00b0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r2 = "encryptRsa total enBytes len = ";	 Catch:{ all -> 0x00b0 }
        r0.<init>(r2);	 Catch:{ all -> 0x00b0 }
        r2 = r7.length;	 Catch:{ all -> 0x00b0 }
        r0.append(r2);	 Catch:{ all -> 0x00b0 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b0 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00b0 }
        r7 = com.sina.weibo.sdk.utils.Base64.encodebyte(r7);	 Catch:{ all -> 0x00b0 }
        r8 = "AidTask";	 Catch:{ all -> 0x00b0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r2 = "encryptRsa total base64byte len = ";	 Catch:{ all -> 0x00b0 }
        r0.<init>(r2);	 Catch:{ all -> 0x00b0 }
        r2 = r7.length;	 Catch:{ all -> 0x00b0 }
        r0.append(r2);	 Catch:{ all -> 0x00b0 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b0 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00b0 }
        r8 = new java.lang.String;	 Catch:{ all -> 0x00b0 }
        r0 = "UTF-8";	 Catch:{ all -> 0x00b0 }
        r8.<init>(r7, r0);	 Catch:{ all -> 0x00b0 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r0 = "01";	 Catch:{ all -> 0x00b0 }
        r7.<init>(r0);	 Catch:{ all -> 0x00b0 }
        r7.append(r8);	 Catch:{ all -> 0x00b0 }
        r7 = r7.toString();	 Catch:{ all -> 0x00b0 }
        r8 = "AidTask";	 Catch:{ all -> 0x00b0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r2 = "encryptRsa total base64string : ";	 Catch:{ all -> 0x00b0 }
        r0.<init>(r2);	 Catch:{ all -> 0x00b0 }
        r0.append(r7);	 Catch:{ all -> 0x00b0 }
        r0 = r0.toString();	 Catch:{ all -> 0x00b0 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00b0 }
        r1.close();	 Catch:{ IOException -> 0x00af }
    L_0x00af:
        return r7;
    L_0x00b0:
        r7 = move-exception;
        goto L_0x00b4;
    L_0x00b2:
        r7 = move-exception;
        r1 = r8;
    L_0x00b4:
        if (r1 == 0) goto L_0x00b9;
    L_0x00b6:
        r1.close();	 Catch:{ IOException -> 0x00b9 }
    L_0x00b9:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.encryptRsa(java.lang.String, java.lang.String):java.lang.String");
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private static java.lang.String getOS() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0011 }
        r1 = "Android ";	 Catch:{ Exception -> 0x0011 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0011 }
        r1 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x0011 }
        r0.append(r1);	 Catch:{ Exception -> 0x0011 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getOS():java.lang.String");
    }

    private static java.lang.String getImei(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x000d }
        return r1;
    L_0x000d:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getImei(android.content.Context):java.lang.String");
    }

    private static java.lang.String getMeid(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x000d }
        return r1;
    L_0x000d:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getMeid(android.content.Context):java.lang.String");
    }

    private static java.lang.String getImsi(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSubscriberId();	 Catch:{ Exception -> 0x000d }
        return r1;
    L_0x000d:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getImsi(android.content.Context):java.lang.String");
    }

    private static java.lang.String getMac(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "wifi";	 Catch:{ Exception -> 0x001b }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x001b }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ Exception -> 0x001b }
        if (r1 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x001b }
    L_0x000a:
        r1 = "";	 Catch:{ Exception -> 0x001b }
        return r1;	 Catch:{ Exception -> 0x001b }
    L_0x000d:
        r1 = r1.getConnectionInfo();	 Catch:{ Exception -> 0x001b }
        if (r1 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x001b }
    L_0x0013:
        r1 = r1.getMacAddress();	 Catch:{ Exception -> 0x001b }
        return r1;	 Catch:{ Exception -> 0x001b }
    L_0x0018:
        r1 = "";	 Catch:{ Exception -> 0x001b }
        return r1;
    L_0x001b:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getMac(android.content.Context):java.lang.String");
    }

    private static java.lang.String getIccid(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x000d }
        r1 = r1.getSimSerialNumber();	 Catch:{ Exception -> 0x000d }
        return r1;
    L_0x000d:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getIccid(android.content.Context):java.lang.String");
    }

    private static java.lang.String getSerialNo() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = "android.os.SystemProperties";	 Catch:{ Exception -> 0x002c }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x002c }
        r2 = "get";	 Catch:{ Exception -> 0x002c }
        r3 = 2;	 Catch:{ Exception -> 0x002c }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x002c }
        r5 = java.lang.String.class;	 Catch:{ Exception -> 0x002c }
        r6 = 0;	 Catch:{ Exception -> 0x002c }
        r4[r6] = r5;	 Catch:{ Exception -> 0x002c }
        r5 = java.lang.String.class;	 Catch:{ Exception -> 0x002c }
        r7 = 1;	 Catch:{ Exception -> 0x002c }
        r4[r7] = r5;	 Catch:{ Exception -> 0x002c }
        r2 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x002c }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x002c }
        r4 = "ro.serialno";	 Catch:{ Exception -> 0x002c }
        r3[r6] = r4;	 Catch:{ Exception -> 0x002c }
        r4 = "unknown";	 Catch:{ Exception -> 0x002c }
        r3[r7] = r4;	 Catch:{ Exception -> 0x002c }
        r1 = r2.invoke(r1, r3);	 Catch:{ Exception -> 0x002c }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x002c }
        r0 = r1;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getSerialNo():java.lang.String");
    }

    private static java.lang.String getAndroidId(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x000b }
        r0 = "android_id";	 Catch:{ Exception -> 0x000b }
        r1 = android.provider.Settings.Secure.getString(r1, r0);	 Catch:{ Exception -> 0x000b }
        return r1;
    L_0x000b:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getAndroidId(android.content.Context):java.lang.String");
    }

    private static java.lang.String getCpu() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.CPU_ABI;	 Catch:{ Exception -> 0x0003 }
        return r0;
    L_0x0003:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getCpu():java.lang.String");
    }

    private static java.lang.String getModel() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x0003 }
        return r0;
    L_0x0003:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getModel():java.lang.String");
    }

    private static java.lang.String getSdSize() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x001d }
        r1 = new android.os.StatFs;	 Catch:{ Exception -> 0x001d }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x001d }
        r1.<init>(r0);	 Catch:{ Exception -> 0x001d }
        r0 = r1.getBlockSize();	 Catch:{ Exception -> 0x001d }
        r2 = (long) r0;	 Catch:{ Exception -> 0x001d }
        r0 = r1.getBlockCount();	 Catch:{ Exception -> 0x001d }
        r0 = (long) r0;	 Catch:{ Exception -> 0x001d }
        r0 = r0 * r2;	 Catch:{ Exception -> 0x001d }
        r0 = java.lang.Long.toString(r0);	 Catch:{ Exception -> 0x001d }
        return r0;
    L_0x001d:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getSdSize():java.lang.String");
    }

    private static java.lang.String getResolution(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.util.DisplayMetrics;	 Catch:{ Exception -> 0x0035 }
        r0.<init>();	 Catch:{ Exception -> 0x0035 }
        r1 = "window";	 Catch:{ Exception -> 0x0035 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0035 }
        r2 = (android.view.WindowManager) r2;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.getDefaultDisplay();	 Catch:{ Exception -> 0x0035 }
        r2.getMetrics(r0);	 Catch:{ Exception -> 0x0035 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0035 }
        r2.<init>();	 Catch:{ Exception -> 0x0035 }
        r1 = r0.widthPixels;	 Catch:{ Exception -> 0x0035 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0035 }
        r2.append(r1);	 Catch:{ Exception -> 0x0035 }
        r1 = "*";	 Catch:{ Exception -> 0x0035 }
        r2.append(r1);	 Catch:{ Exception -> 0x0035 }
        r0 = r0.heightPixels;	 Catch:{ Exception -> 0x0035 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0035 }
        r2.append(r0);	 Catch:{ Exception -> 0x0035 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0035 }
        return r2;
    L_0x0035:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getResolution(android.content.Context):java.lang.String");
    }

    private static java.lang.String getSsid(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "wifi";	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0013 }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getConnectionInfo();	 Catch:{ Exception -> 0x0013 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0013 }
    L_0x000e:
        r1 = r1.getSSID();	 Catch:{ Exception -> 0x0013 }
        return r1;
    L_0x0013:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getSsid(android.content.Context):java.lang.String");
    }

    private static java.lang.String getDeviceName() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.BRAND;	 Catch:{ Exception -> 0x0003 }
        return r0;
    L_0x0003:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getDeviceName():java.lang.String");
    }

    private static java.lang.String getConnectType(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "none";
        r1 = "connectivity";	 Catch:{ Exception -> 0x0033 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0033 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x0033 }
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0033 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0033 }
    L_0x0010:
        r1 = r2.getType();	 Catch:{ Exception -> 0x0033 }
        if (r1 != 0) goto L_0x0029;	 Catch:{ Exception -> 0x0033 }
    L_0x0016:
        r2 = r2.getSubtype();	 Catch:{ Exception -> 0x0033 }
        switch(r2) {
            case 1: goto L_0x0026;
            case 2: goto L_0x0026;
            case 3: goto L_0x0023;
            case 4: goto L_0x0026;
            case 5: goto L_0x0023;
            case 6: goto L_0x0023;
            case 7: goto L_0x0026;
            case 8: goto L_0x0023;
            case 9: goto L_0x0023;
            case 10: goto L_0x0023;
            case 11: goto L_0x0026;
            case 12: goto L_0x0023;
            case 13: goto L_0x0020;
            case 14: goto L_0x0023;
            case 15: goto L_0x0023;
            default: goto L_0x001d;
        };	 Catch:{ Exception -> 0x0033 }
    L_0x001d:
        r2 = "none";	 Catch:{ Exception -> 0x0033 }
        goto L_0x0034;	 Catch:{ Exception -> 0x0033 }
    L_0x0020:
        r2 = "4G";	 Catch:{ Exception -> 0x0033 }
        goto L_0x0034;	 Catch:{ Exception -> 0x0033 }
    L_0x0023:
        r2 = "3G";	 Catch:{ Exception -> 0x0033 }
        goto L_0x0034;	 Catch:{ Exception -> 0x0033 }
    L_0x0026:
        r2 = "2G";	 Catch:{ Exception -> 0x0033 }
        goto L_0x0034;	 Catch:{ Exception -> 0x0033 }
    L_0x0029:
        r2 = r2.getType();	 Catch:{ Exception -> 0x0033 }
        r1 = 1;	 Catch:{ Exception -> 0x0033 }
        if (r2 != r1) goto L_0x0033;	 Catch:{ Exception -> 0x0033 }
    L_0x0030:
        r2 = "wifi";	 Catch:{ Exception -> 0x0033 }
        r0 = r2;
    L_0x0033:
        r2 = r0;
    L_0x0034:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask4Plug.getConnectType(android.content.Context):java.lang.String");
    }
}
