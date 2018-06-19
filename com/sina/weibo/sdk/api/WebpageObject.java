package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class WebpageObject extends BaseMediaObject {
    public static final Creator<WebpageObject> CREATOR = new Creator<WebpageObject>() {
        public final WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        public final WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String defaultText;

    public int getObjType() {
        return 5;
    }

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public boolean checkArgs() {
        return super.checkArgs();
    }

    protected com.sina.weibo.sdk.api.BaseMediaObject toExtraMediaObject(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0013;
    L_0x0006:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0013 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0013 }
        r2 = "extra_key_defaulttext";	 Catch:{ JSONException -> 0x0013 }
        r2 = r0.optString(r2);	 Catch:{ JSONException -> 0x0013 }
        r1.defaultText = r2;	 Catch:{ JSONException -> 0x0013 }
    L_0x0013:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.WebpageObject.toExtraMediaObject(java.lang.String):com.sina.weibo.sdk.api.BaseMediaObject");
    }

    protected java.lang.String toExtraMediaString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0019 }
        r0.<init>();	 Catch:{ JSONException -> 0x0019 }
        r1 = r3.defaultText;	 Catch:{ JSONException -> 0x0019 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x0019 }
        if (r1 != 0) goto L_0x0014;	 Catch:{ JSONException -> 0x0019 }
    L_0x000d:
        r1 = "extra_key_defaulttext";	 Catch:{ JSONException -> 0x0019 }
        r2 = r3.defaultText;	 Catch:{ JSONException -> 0x0019 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0019 }
    L_0x0014:
        r0 = r0.toString();	 Catch:{ JSONException -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.WebpageObject.toExtraMediaString():java.lang.String");
    }
}
