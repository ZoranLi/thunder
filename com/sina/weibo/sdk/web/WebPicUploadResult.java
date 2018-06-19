package com.sina.weibo.sdk.web;

public class WebPicUploadResult {
    public static final String RESP_UPLOAD_PIC_PARAM_CODE = "code";
    public static final String RESP_UPLOAD_PIC_PARAM_DATA = "data";
    public static final int RESP_UPLOAD_PIC_SUCC_CODE = 1;
    private int code = -2;
    private String picId;

    private WebPicUploadResult() {
    }

    public int getCode() {
        return this.code;
    }

    public String getPicId() {
        return this.picId;
    }

    public static com.sina.weibo.sdk.web.WebPicUploadResult parse(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r3 = 0;
        return r3;
    L_0x0008:
        r0 = new com.sina.weibo.sdk.web.WebPicUploadResult;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0025 }
        r1.<init>(r3);	 Catch:{ JSONException -> 0x0025 }
        r3 = "code";	 Catch:{ JSONException -> 0x0025 }
        r2 = -2;	 Catch:{ JSONException -> 0x0025 }
        r3 = r1.optInt(r3, r2);	 Catch:{ JSONException -> 0x0025 }
        r0.code = r3;	 Catch:{ JSONException -> 0x0025 }
        r3 = "data";	 Catch:{ JSONException -> 0x0025 }
        r2 = "";	 Catch:{ JSONException -> 0x0025 }
        r3 = r1.optString(r3, r2);	 Catch:{ JSONException -> 0x0025 }
        r0.picId = r3;	 Catch:{ JSONException -> 0x0025 }
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.WebPicUploadResult.parse(java.lang.String):com.sina.weibo.sdk.web.WebPicUploadResult");
    }
}
