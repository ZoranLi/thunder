package com.umeng.socialize.net.utils;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.Log;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class URequest {
    protected static String APPLICATION = "application/x-www-form-urlencoded";
    protected static String GET = "GET";
    protected static String MULTIPART = "multipart/form-data";
    protected static String POST = "POST";
    protected String mBaseUrl;
    public Context mContext;
    public Map<String, String> mHeaders;
    public RequestMethod mMethod;
    protected MIME mMimeType;
    public Map<String, String> mParams = new HashMap();
    public Class<? extends SocializeReseponse> mResponseClz;
    public PostStyle postStyle = PostStyle.MULTIPART;

    public static class FilePair {
        byte[] mBinaryData;
        String mFileName;

        public FilePair(String str, byte[] bArr) {
            this.mFileName = str;
            this.mBinaryData = bArr;
        }
    }

    protected enum MIME {
        DEFAULT("application/x-www-form-urlencoded;charset=utf-8"),
        JSON("application/json;charset=utf-8");
        
        private String mimeType;

        private MIME(String str) {
            this.mimeType = str;
        }

        public final String toString() {
            return this.mimeType;
        }
    }

    public enum PostStyle {
        MULTIPART {
            public final String toString() {
                return URequest.MULTIPART;
            }
        },
        APPLICATION {
            public final String toString() {
                return URequest.APPLICATION;
            }
        };
    }

    public enum RequestMethod {
        GET {
            public final String toString() {
                return URequest.GET;
            }
        },
        POST {
            public final String toString() {
                return URequest.POST;
            }
        };
    }

    public abstract Map<String, Object> buildParams();

    public Map<String, Object> getBodyPair() {
        return null;
    }

    public String getDecryptString(String str) {
        return str;
    }

    public String getEcryptString(String str) {
        return str;
    }

    public Map<String, FilePair> getFilePair() {
        return null;
    }

    public void onPrepareRequest() {
    }

    public abstract String toGetUrl();

    public abstract JSONObject toJson();

    public String getHttpMethod() {
        return this.mMethod.toString();
    }

    public URequest(String str) {
        this.mBaseUrl = str;
    }

    public void setBaseUrl(String str) {
        this.mBaseUrl = str;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public String generateGetURL(String str, Map<String, Object> map) {
        return buildGetUrl(str, map);
    }

    public String buildGetUrl(String str, Map<String, Object> map) {
        if (!(TextUtils.isEmpty(str) || map == null)) {
            if (map.size() != 0) {
                StringBuilder stringBuilder;
                if (!str.endsWith("?")) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("?");
                    str = stringBuilder.toString();
                }
                map = buildGetParams(map);
                stringBuilder = new StringBuilder("urlPath=");
                stringBuilder.append(str);
                stringBuilder.append("  SocializeNetUtils url=");
                stringBuilder.append(map);
                Log.net(stringBuilder.toString());
                try {
                    map = getEcryptString(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stringBuilder = new StringBuilder(str);
                stringBuilder.append(map);
                return stringBuilder.toString();
            }
        }
        return str;
    }

    public static String buildGetParams(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            if (map.get(str) != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("=");
                stringBuilder2.append(URLEncoder.encode(map.get(str).toString()));
                stringBuilder2.append("&");
                stringBuilder.append(stringBuilder2.toString());
            }
        }
        return stringBuilder.substring(null, stringBuilder.length() - 1).toString();
    }

    public void addStringParams(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mParams.put(str, str2);
        }
    }
}
