package com.xiaomi.account.openauth;

import android.os.Bundle;
import android.text.TextUtils;

public class XiaomiOAuthResults {
    private final Bundle contentBundle;
    private final Error errorResult;
    private final Success successResult;

    public static class Error {
        public final int errorCode;
        public final String errorMessage;

        public Error(int i, String str) {
            this.errorCode = i;
            this.errorMessage = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("errorCode=");
            stringBuilder.append(this.errorCode);
            stringBuilder.append(",errorMessage=");
            stringBuilder.append(this.errorMessage);
            return stringBuilder.toString();
        }

        private static Error parseBundle(Bundle bundle) {
            return new Error(XiaomiOAuthResults.getIntCompatibly(bundle, "extra_error_code", "error"), XiaomiOAuthResults.getStringCompatibly(bundle, "extra_error_description", XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2));
        }
    }

    private static class Success {
        public final String accessToken;
        public final String code;
        public final String expiresIn;
        public final String macAlgorithm;
        public final String macKey;
        public final String scopes;
        public final String state;
        public final String tokenType;

        public Success(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.accessToken = str;
            this.expiresIn = str2;
            this.scopes = str3;
            this.state = str4;
            this.tokenType = str5;
            this.macKey = str6;
            this.macAlgorithm = str7;
            this.code = str8;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("accessToken=");
            stringBuilder.append(this.accessToken);
            stringBuilder.append(",expiresIn=");
            stringBuilder.append(this.expiresIn);
            stringBuilder.append(",scope=");
            stringBuilder.append(this.scopes);
            stringBuilder.append(",state=");
            stringBuilder.append(this.state);
            stringBuilder.append(",tokenType=");
            stringBuilder.append(this.tokenType);
            stringBuilder.append(",macKey=");
            stringBuilder.append(this.macKey);
            stringBuilder.append(",macAlogorithm=");
            stringBuilder.append(this.macAlgorithm);
            stringBuilder.append(",code=");
            stringBuilder.append(this.code);
            return stringBuilder.toString();
        }

        private static Success parseBundle(Bundle bundle) {
            return new Success(XiaomiOAuthResults.getStringCompatibly(bundle, "access_token", "extra_access_token"), XiaomiOAuthResults.getIntOrStringCompatibly(bundle, "expires_in", "extra_expires_in"), XiaomiOAuthResults.getStringCompatibly(bundle, "scope", "extra_scope"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_STATE_2, "extra_state"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, "extra_token_type"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_MAC_KEY_2, "extra_mac_key"), XiaomiOAuthResults.getStringCompatibly(bundle, XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, "extra_mac_algorithm"), XiaomiOAuthResults.getStringCompatibly(bundle, "code", XiaomiOAuthConstants.EXTRA_CODE));
        }
    }

    private XiaomiOAuthResults(Bundle bundle, Error error) {
        this.contentBundle = bundle;
        this.successResult = null;
        this.errorResult = error;
    }

    private XiaomiOAuthResults(Bundle bundle, Success success) {
        this.contentBundle = bundle;
        this.successResult = success;
        this.errorResult = null;
    }

    public Bundle getContentBundle() {
        return this.contentBundle;
    }

    public String getAccessToken() {
        return this.successResult != null ? this.successResult.accessToken : null;
    }

    public String getExpiresIn() {
        return this.successResult != null ? this.successResult.expiresIn : null;
    }

    public String getScopes() {
        return this.successResult != null ? this.successResult.scopes : null;
    }

    public String getState() {
        return this.successResult != null ? this.successResult.state : null;
    }

    public String getTokenType() {
        return this.successResult != null ? this.successResult.tokenType : null;
    }

    public String getMacKey() {
        return this.successResult != null ? this.successResult.macKey : null;
    }

    public String getMacAlgorithm() {
        return this.successResult != null ? this.successResult.macAlgorithm : null;
    }

    public String getCode() {
        return this.successResult != null ? this.successResult.code : null;
    }

    public int getErrorCode() {
        return this.errorResult != null ? this.errorResult.errorCode : 0;
    }

    public String getErrorMessage() {
        return this.errorResult != null ? this.errorResult.errorMessage : null;
    }

    public boolean hasError() {
        return this.errorResult != null;
    }

    private static String getStringCompatibly(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getString(str) : bundle.getString(str2);
    }

    private static int getIntCompatibly(Bundle bundle, String str, String str2) {
        return bundle.containsKey(str) ? bundle.getInt(str) : bundle.getInt(str2);
    }

    private static String getIntOrStringCompatibly(Bundle bundle, String str, String str2) {
        r1 = new String[2];
        int i = 0;
        r1[0] = str;
        r1[1] = str2;
        while (i < 2) {
            str = r1[i];
            if (TextUtils.isEmpty(str) == null && bundle.containsKey(str) != null) {
                str = bundle.get(str);
                if (str != null) {
                    if ((str instanceof Integer) != null) {
                        return ((Integer) str).toString();
                    }
                    return str.toString();
                }
            }
            i++;
        }
        return null;
    }

    public String toString() {
        if (this.successResult != null) {
            return this.successResult.toString();
        }
        if (this.errorResult != null) {
            return this.errorResult.toString();
        }
        throw new IllegalStateException("should not be here.");
    }

    public static XiaomiOAuthResults parseBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (getIntCompatibly(bundle, "extra_error_code", "error") != 0) {
            return new XiaomiOAuthResults(bundle, Error.parseBundle(bundle));
        }
        return new XiaomiOAuthResults(bundle, Success.parseBundle(bundle));
    }
}
