package com.umeng.socialize.net.base;

import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.UResponse;
import com.umeng.socialize.utils.Log;
import org.json.JSONObject;

public class SocializeReseponse extends UResponse {
    protected static final String TAG = "SocializeReseponse";
    private int mHttpCode;
    protected JSONObject mJsonData;
    public String mMsg;
    public int mStCode;

    public void parseJsonObject() {
    }

    public SocializeReseponse(JSONObject jSONObject) {
        super(jSONObject);
        this.mStCode = -103;
        this.mJsonData = parseStatus(jSONObject);
        parseJsonObject();
    }

    public SocializeReseponse(Integer num, JSONObject jSONObject) {
        this(jSONObject);
        if (num == null) {
            num = -1;
        } else {
            num = num.intValue();
        }
        this.mHttpCode = num;
    }

    public boolean isHttpOK() {
        return this.mHttpCode == 200;
    }

    public boolean isOk() {
        String str = "umeng_share_response";
        StringBuilder stringBuilder = new StringBuilder("is http 200:");
        stringBuilder.append(this.mStCode == 200);
        Log.d(str, stringBuilder.toString());
        return this.mStCode == 200;
    }

    public JSONObject getJsonData() {
        return this.mJsonData;
    }

    private JSONObject parseStatus(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            this.mStCode = jSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_ST, SocializeConstants.SERVER_RETURN_PARAMS_ILLEGAL);
            if (this.mStCode == 0) {
                Log.e(TAG, "no status code in response.");
                return null;
            }
            this.mMsg = jSONObject.optString("msg", "");
            jSONObject = jSONObject.optString("data", null);
            if (TextUtils.isEmpty(jSONObject)) {
                return null;
            }
            if (this.mStCode != 200) {
                parseErrorMsg(jSONObject);
            }
            return new JSONObject(jSONObject);
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
            Log.e(TAG, "Data body can`t convert to json ");
            return null;
        }
    }

    private void parseErrorMsg(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x003a }
        r0.<init>(r6);	 Catch:{ Exception -> 0x003a }
        r6 = r0.keys();	 Catch:{ Exception -> 0x003a }
    L_0x0009:
        r1 = r6.hasNext();	 Catch:{ Exception -> 0x003a }
        if (r1 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x003a }
    L_0x000f:
        r1 = r6.next();	 Catch:{ Exception -> 0x003a }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x003a }
        r2 = r0.getJSONObject(r1);	 Catch:{ Exception -> 0x003a }
        r3 = "msg";	 Catch:{ Exception -> 0x003a }
        r3 = r2.getString(r3);	 Catch:{ Exception -> 0x003a }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x003a }
        if (r4 != 0) goto L_0x0029;	 Catch:{ Exception -> 0x003a }
    L_0x0025:
        r5.printLog(r1, r3);	 Catch:{ Exception -> 0x003a }
        goto L_0x0009;	 Catch:{ Exception -> 0x003a }
    L_0x0029:
        r3 = "data";	 Catch:{ Exception -> 0x003a }
        r2 = r2.getJSONObject(r3);	 Catch:{ Exception -> 0x003a }
        r3 = "platform_error";	 Catch:{ Exception -> 0x003a }
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x003a }
        r5.printLog(r1, r2);	 Catch:{ Exception -> 0x003a }
        goto L_0x0009;
    L_0x0039:
        return;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.base.SocializeReseponse.parseErrorMsg(java.lang.String):void");
    }

    private void printLog(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder("error message -> ");
        stringBuilder.append(str);
        stringBuilder.append(" : ");
        stringBuilder.append(str2);
        Log.e(str3, stringBuilder.toString());
    }
}
