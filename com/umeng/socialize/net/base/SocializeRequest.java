package com.umeng.socialize.net.base;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.a.a.a;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.AesHelper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.net.utils.URequest.FilePair;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public abstract class SocializeRequest extends URequest {
    private static final String BASE_URL = "http://log.umsns.com/";
    public static final int REQUEST_ANALYTIC = 1;
    public static final int REQUEST_API = 2;
    public static final int REQUEST_SOCIAL = 0;
    private static final String TAG = "SocializeRequest";
    private Map<String, FilePair> mFileMap = new HashMap();
    public int mOpId;
    private int mReqType = 1;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod = new int[RequestMethod.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.umeng.socialize.net.utils.URequest.RequestMethod.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod = r0;
            r0 = $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.umeng.socialize.net.utils.URequest.RequestMethod.POST;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.umeng.socialize.net.utils.URequest.RequestMethod.GET;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.base.SocializeRequest.1.<clinit>():void");
        }
    }

    public enum FILE_TYPE {
        IMAGE,
        VEDIO
    }

    public abstract String getPath();

    public JSONObject toJson() {
        return null;
    }

    public SocializeRequest(Context context, String str, Class<? extends SocializeReseponse> cls, int i, RequestMethod requestMethod) {
        super("");
        this.mResponseClz = cls;
        this.mOpId = i;
        this.mContext = context;
        this.mMethod = requestMethod;
        setBaseUrl(BASE_URL);
        AesHelper.setPassword(SocializeUtils.getAppkey(context));
    }

    public void setReqType(int i) {
        this.mReqType = i;
    }

    public void addFileParams(byte[] bArr, FILE_TYPE file_type, String str) {
        if (FILE_TYPE.IMAGE == file_type) {
            file_type = a.d(bArr);
            if (TextUtils.isEmpty(file_type)) {
                file_type = "png";
            }
            if (TextUtils.isEmpty(str)) {
                str = String.valueOf(System.currentTimeMillis());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(file_type);
            this.mFileMap.put(SocializeProtocolConstants.PROTOCOL_KEY_IMAGE, new FilePair(stringBuilder.toString(), bArr));
        }
    }

    public void addMediaParams(UMediaObject uMediaObject) {
        if (uMediaObject != null) {
            if (uMediaObject instanceof BaseMediaObject) {
                addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, ((BaseMediaObject) uMediaObject).getTitle());
            }
            if (uMediaObject.isUrlMedia()) {
                for (Entry entry : uMediaObject.toUrlExtraParams().entrySet()) {
                    addStringParams((String) entry.getKey(), entry.getValue().toString());
                }
                return;
            }
            uMediaObject = uMediaObject.toByte();
            if (uMediaObject != null) {
                addFileParams(uMediaObject, FILE_TYPE.IMAGE, null);
            }
        }
    }

    public Map<String, Object> getBodyPair() {
        Map<String, Object> buildParams = buildParams();
        String mapTostring = mapTostring(buildParams);
        if (mapTostring != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder("SocializeRequest body=");
                stringBuilder.append(mapTostring);
                Log.net(stringBuilder.toString());
                mapTostring = AesHelper.encryptNoPadding(URLEncoder.encode(mapTostring, "UTF-8"), "UTF-8");
                buildParams.clear();
                buildParams.put("ud_post", mapTostring);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return buildParams;
    }

    public Map<String, FilePair> getFilePair() {
        return this.mFileMap;
    }

    public String toGetUrl() {
        return generateGetURL(getBaseUrl(), buildParams());
    }

    public Map<String, Object> buildParams() {
        Map<String, Object> baseQuery = getBaseQuery(this.mContext);
        if (!TextUtils.isEmpty(Config.EntityKey)) {
            baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, Config.EntityKey);
        }
        if (!TextUtils.isEmpty(Config.SessionId)) {
            baseQuery.put("sid", Config.SessionId);
        }
        baseQuery.put("tp", Integer.valueOf(this.mReqType));
        baseQuery.put(SocializeProtocolConstants.PROTOCOL_KEY_OPID, Integer.valueOf(this.mOpId));
        baseQuery.put("uid", Config.UID);
        baseQuery.putAll(this.mParams);
        return baseQuery;
    }

    public void setBaseUrl(String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(getPath())) {
                str2 = new URL(new URL(str), getPath()).toString();
            }
            super.setBaseUrl(str2);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Can not generate correct url in SocializeRequest [");
            stringBuilder.append(str);
            stringBuilder.append("]");
            throw new SocializeException(stringBuilder.toString(), e);
        }
    }

    public void onPrepareRequest() {
        addStringParams("pcv", "2.0");
        addStringParams(SocializeConstants.USHARETYPE, Config.shareType);
        String deviceId = DeviceConfig.getDeviceId(this.mContext);
        addStringParams("imei", deviceId);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_MD5IMEI, AesHelper.md5(deviceId));
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DE, Build.MODEL);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_MAC, DeviceConfig.getMac(this.mContext));
        addStringParams("os", "Android");
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_EN, DeviceConfig.getNetworkAccessMode(this.mContext)[0]);
        addStringParams("uid", null);
        addStringParams("sdkv", "6.4.5");
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DT, String.valueOf(System.currentTimeMillis()));
    }

    private String mapTostring(Map<String, Object> map) {
        if (this.mParams.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map).toString();
        } catch (Map<String, Object> map2) {
            map2.printStackTrace();
            return null;
        }
    }

    protected String getHttpMethod() {
        if (AnonymousClass1.$SwitchMap$com$umeng$socialize$net$utils$URequest$RequestMethod[this.mMethod.ordinal()] != 1) {
            return GET;
        }
        return POST;
    }

    public String getEcryptString(String str) {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder("ud_get=");
            stringBuilder.append(AesHelper.encryptNoPadding(str, "UTF-8"));
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            stringBuilder = new StringBuilder("ud_get=");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    public String getDecryptString(String str) {
        try {
            return AesHelper.decryptNoPadding(str, "UTF-8").trim();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static java.util.Map<java.lang.String, java.lang.Object> getBaseQuery(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = com.umeng.socialize.utils.DeviceConfig.getDeviceId(r5);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x001d;
    L_0x000f:
        r2 = "imei";
        r0.put(r2, r1);
        r2 = "md5imei";
        r1 = com.umeng.socialize.net.utils.AesHelper.md5(r1);
        r0.put(r2, r1);
    L_0x001d:
        r1 = com.umeng.socialize.utils.DeviceConfig.getMac(r5);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0046;
    L_0x0027:
        r1 = "SocializeRequest";
        r2 = new java.lang.StringBuilder;
        r3 = "Get MacAddress failed. Check permission android.permission.ACCESS_WIFI_STATE [";
        r2.<init>(r3);
        r3 = "android.permission.ACCESS_WIFI_STATE";
        r3 = com.umeng.socialize.utils.DeviceConfig.checkPermission(r5, r3);
        r2.append(r3);
        r3 = "]";
        r2.append(r3);
        r2 = r2.toString();
        com.umeng.socialize.utils.Log.w(r1, r2);
        goto L_0x004b;
    L_0x0046:
        r2 = "mac";
        r0.put(r2, r1);
    L_0x004b:
        r1 = com.umeng.socialize.common.SocializeConstants.UID;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x005a;
    L_0x0053:
        r1 = "uid";
        r2 = com.umeng.socialize.common.SocializeConstants.UID;
        r0.put(r1, r2);
    L_0x005a:
        r1 = 0;
        r2 = com.umeng.socialize.utils.DeviceConfig.getNetworkAccessMode(r5);	 Catch:{ Exception -> 0x0067 }
        r3 = "en";	 Catch:{ Exception -> 0x0067 }
        r2 = r2[r1];	 Catch:{ Exception -> 0x0067 }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x0067 }
        goto L_0x006e;
    L_0x0067:
        r2 = "en";
        r3 = "Unknown";
        r0.put(r2, r3);
    L_0x006e:
        r2 = "de";
        r3 = android.os.Build.MODEL;
        r0.put(r2, r3);
        r2 = "sdkv";
        r3 = "6.4.5";
        r0.put(r2, r3);
        r2 = "os";
        r3 = "Android";
        r0.put(r2, r3);
        r2 = "android_id";
        r3 = com.umeng.socialize.utils.DeviceConfig.getAndroidID(r5);
        r0.put(r2, r3);
        r2 = "sn";
        r3 = com.umeng.socialize.utils.DeviceConfig.getDeviceSN();
        r0.put(r2, r3);
        r2 = "os_version";
        r3 = com.umeng.socialize.utils.DeviceConfig.getOsVersion();
        r0.put(r2, r3);
        r2 = "dt";
        r3 = java.lang.System.currentTimeMillis();
        r3 = java.lang.Long.valueOf(r3);
        r0.put(r2, r3);
        r5 = com.umeng.socialize.utils.SocializeUtils.getAppkey(r5);
        r2 = "ak";
        r0.put(r2, r5);
        r5 = com.umeng.socialize.net.utils.SocializeProtocolConstants.PROTOCOL_VERSION;
        r2 = "2.0";
        r0.put(r5, r2);
        r5 = "u_sharetype";
        r2 = com.umeng.socialize.Config.shareType;
        r0.put(r5, r2);
        r5 = com.umeng.socialize.Config.EntityKey;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x00d1;
    L_0x00ca:
        r5 = "ek";
        r2 = com.umeng.socialize.Config.EntityKey;
        r0.put(r5, r2);
    L_0x00d1:
        r5 = com.umeng.socialize.Config.SessionId;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x00e0;
    L_0x00d9:
        r5 = "sid";
        r2 = com.umeng.socialize.Config.SessionId;
        r0.put(r5, r2);
    L_0x00e0:
        r5 = "tp";	 Catch:{ Exception -> 0x00e9 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x00e9 }
        r0.put(r5, r1);	 Catch:{ Exception -> 0x00e9 }
    L_0x00e9:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.base.SocializeRequest.getBaseQuery(android.content.Context):java.util.Map<java.lang.String, java.lang.Object>");
    }
}
