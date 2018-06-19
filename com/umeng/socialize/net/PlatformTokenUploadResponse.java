package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import org.json.JSONObject;

public class PlatformTokenUploadResponse extends SocializeReseponse {
    public String mExpiresIn;
    public String mTencentUid;

    private void b() {
    }

    public PlatformTokenUploadResponse(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public void parseJsonObject() {
        super.parseJsonObject();
        a();
        b();
    }

    private void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonData;
        if (r0 == 0) goto L_0x001d;
    L_0x0004:
        r0 = r2.mJsonData;	 Catch:{ JSONException -> 0x001d }
        r1 = "tencent";	 Catch:{ JSONException -> 0x001d }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x001d }
        if (r0 == 0) goto L_0x001c;	 Catch:{ JSONException -> 0x001d }
    L_0x000e:
        r1 = "user_id";	 Catch:{ JSONException -> 0x001d }
        r0 = r0.optString(r1);	 Catch:{ JSONException -> 0x001d }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ JSONException -> 0x001d }
        if (r1 != 0) goto L_0x001c;	 Catch:{ JSONException -> 0x001d }
    L_0x001a:
        r2.mTencentUid = r0;	 Catch:{ JSONException -> 0x001d }
    L_0x001c:
        return;
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.PlatformTokenUploadResponse.a():void");
    }
}
