package com.xunlei.common.net.thunderserver.signature;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xunlei.xllib.b.d;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.List;

public class SignatureUrlBuilder {
    public static final String ACCESS_KEY = "android.m.xunlei";
    static final String SECRET_KEY = "3c661997dc341cbafa661e7b7dca3d90";
    protected String mBaseUrl;
    protected String mMethod = "";
    protected String mRequestBody = null;
    private final String mRequestUrl;
    private final Signature mSignature = new Signature(SECRET_KEY);

    public SignatureUrlBuilder(String str, String str2, String str3) {
        this.mMethod = str.toUpperCase();
        this.mRequestUrl = str2;
        this.mBaseUrl = this.mRequestUrl;
        if (this.mRequestUrl.contains("?") != null) {
            this.mBaseUrl = this.mRequestUrl.substring(null, this.mRequestUrl.indexOf("?"));
        }
        this.mRequestBody = str3;
    }

    public String getSignatureRequestUrl() {
        return (String) signRequestUrl(this.mMethod, this.mRequestBody).get(0);
    }

    public String getSignatureBaseString() {
        return (String) signRequestUrl(this.mMethod, this.mRequestBody).get(1);
    }

    public String getRequestBody() {
        return !TextUtils.isEmpty(this.mRequestBody) ? this.mRequestBody : "";
    }

    private ArrayList<Parameter> extractQueryParameters() {
        ArrayList<Parameter> arrayList = new ArrayList();
        Object<String[]> g = k.g(this.mRequestUrl);
        if (!d.a(g)) {
            for (String[] strArr : g) {
                if (strArr != null && strArr.length == 2) {
                    String str = strArr[0];
                    String str2 = strArr[1];
                    if (!(str == null || str2 == null)) {
                        arrayList.add(new Parameter(str, str2, true));
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<String> signRequestUrl(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str3 = this.mBaseUrl;
        ArrayList<String> arrayList = new ArrayList();
        long generateTimestamp = Signature.generateTimestamp();
        String generateNonce = Signature.generateNonce();
        List extractQueryParameters = extractQueryParameters();
        extractQueryParameters.add(new Parameter("timestamp", String.valueOf(generateTimestamp)));
        extractQueryParameters.add(new Parameter("nonce", generateNonce));
        extractQueryParameters.add(new Parameter("accesskey", ACCESS_KEY));
        String baseString = this.mSignature.baseString(str, str3, extractQueryParameters, str2 == null ? "" : str2);
        Signature signature = this.mSignature;
        if (str2 == null) {
            str2 = "";
        }
        str = signature.sign(str, str3, extractQueryParameters, str2);
        str2 = new StringBuilder("timestamp=");
        str2.append(String.valueOf(generateTimestamp));
        str2.append("&nonce=");
        str2.append(generateNonce);
        str2.append("&accesskey=android.m.xunlei&sig=");
        str2.append(str);
        str = str2.toString();
        str2 = this.mRequestUrl.contains("?") != null ? "&" : "?";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mRequestUrl);
        stringBuilder.append(str2);
        stringBuilder.append(str);
        arrayList.add(stringBuilder.toString());
        arrayList.add(baseString);
        generateTimestamp = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            str2 = new StringBuilder("SignRequestUrl should not be called on main thread. ");
            str2.append(generateTimestamp);
            str2.append("ms");
            new IllegalStateException(str2.toString()).printStackTrace();
        }
        return arrayList;
    }
}
