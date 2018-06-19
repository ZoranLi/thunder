package com.baidu.mobads.utils;

import android.net.Uri;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.a.b;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.c;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

public class s implements IXAdURIUitls {
    public HashMap<String, String> getAllQueryParameters(String str) {
        HashMap<String, String> hashMap = new HashMap();
        str = Uri.parse(str);
        for (String str2 : getQueryParameterNames(str)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, str.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.util.Set<java.lang.String> getQueryParameterNames(android.net.Uri r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.util.HashSet;
        r0.<init>();
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0051 }
        r2 = 11;	 Catch:{ Exception -> 0x0051 }
        if (r1 < r2) goto L_0x0010;	 Catch:{ Exception -> 0x0051 }
    L_0x000b:
        r7 = r7.getQueryParameterNames();	 Catch:{ Exception -> 0x0051 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0051 }
    L_0x0010:
        r7 = r7.getEncodedQuery();	 Catch:{ Exception -> 0x0051 }
        if (r7 != 0) goto L_0x001b;	 Catch:{ Exception -> 0x0051 }
    L_0x0016:
        r7 = java.util.Collections.emptySet();	 Catch:{ Exception -> 0x0051 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0051 }
    L_0x001b:
        r1 = new java.util.LinkedHashSet;	 Catch:{ Exception -> 0x0051 }
        r1.<init>();	 Catch:{ Exception -> 0x0051 }
        r2 = 0;	 Catch:{ Exception -> 0x0051 }
    L_0x0021:
        r3 = 38;	 Catch:{ Exception -> 0x0051 }
        r3 = r7.indexOf(r3, r2);	 Catch:{ Exception -> 0x0051 }
        r4 = -1;	 Catch:{ Exception -> 0x0051 }
        if (r3 != r4) goto L_0x002e;	 Catch:{ Exception -> 0x0051 }
    L_0x002a:
        r3 = r7.length();	 Catch:{ Exception -> 0x0051 }
    L_0x002e:
        r5 = 61;	 Catch:{ Exception -> 0x0051 }
        r5 = r7.indexOf(r5, r2);	 Catch:{ Exception -> 0x0051 }
        if (r5 > r3) goto L_0x0038;	 Catch:{ Exception -> 0x0051 }
    L_0x0036:
        if (r5 != r4) goto L_0x0039;	 Catch:{ Exception -> 0x0051 }
    L_0x0038:
        r5 = r3;	 Catch:{ Exception -> 0x0051 }
    L_0x0039:
        r2 = r7.substring(r2, r5);	 Catch:{ Exception -> 0x0051 }
        r2 = android.net.Uri.decode(r2);	 Catch:{ Exception -> 0x0051 }
        r1.add(r2);	 Catch:{ Exception -> 0x0051 }
        r2 = r3 + 1;	 Catch:{ Exception -> 0x0051 }
        r3 = r7.length();	 Catch:{ Exception -> 0x0051 }
        if (r2 < r3) goto L_0x0021;	 Catch:{ Exception -> 0x0051 }
    L_0x004c:
        r7 = java.util.Collections.unmodifiableSet(r1);	 Catch:{ Exception -> 0x0051 }
        goto L_0x0052;
    L_0x0051:
        r7 = r0;
    L_0x0052:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.s.getQueryParameterNames(android.net.Uri):java.util.Set<java.lang.String>");
    }

    public String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder;
        XAdSDKFoundationFacade instance = XAdSDKFoundationFacade.getInstance();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str2 : hashMap.keySet()) {
                i++;
                String str3 = (String) hashMap.get(str2);
                if (i == 1) {
                    stringBuilder2.append(str2);
                    stringBuilder2.append("=");
                    stringBuilder2.append(str3);
                } else {
                    stringBuilder2.append("&");
                    stringBuilder2.append(str2);
                    stringBuilder2.append("=");
                    stringBuilder2.append(str3);
                }
            }
        }
        if (b.a.booleanValue()) {
            if (hashMap != null) {
                for (String str4 : hashMap.keySet()) {
                    try {
                        String str5 = (String) hashMap.get(str4);
                        if (str5 != null) {
                            hashMap.put(str4, URLEncoder.encode(str5, "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(instance.getURIUitls().addParameters(str, hashMap));
            stringBuilder2.append("&b");
            stringBuilder2.append(System.currentTimeMillis());
            stringBuilder2.append("=1");
            str = stringBuilder2.toString();
        } else {
            hashMap = new StringBuilder();
            hashMap.append(str);
            hashMap.append("?code2=");
            str = instance.getBase64();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&b");
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("=1");
            hashMap.append(str.encode(stringBuilder.toString()));
            str = hashMap.toString();
        }
        hashMap = new StringBuilder();
        stringBuilder = new StringBuilder("&b");
        stringBuilder.append(System.currentTimeMillis());
        hashMap.append(stringBuilder.toString());
        hashMap.append("=1");
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(hashMap.toString());
        return stringBuilder.toString();
    }

    @Deprecated
    public String addParameter(String str, String str2, String str3) {
        String fixedString = getFixedString(str);
        str = getQueryString(str);
        if (XAdSDKFoundationFacade.getInstance().getCommonUtils().isStringAvailable(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&");
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append(str3);
            str = stringBuilder.toString();
        } else {
            str = new StringBuilder();
            str.append(str2);
            str.append("=");
            str.append(str3);
            str = str.toString();
        }
        str2 = new StringBuilder();
        str2.append(fixedString);
        str2.append("?");
        str2.append(str);
        return str2.toString();
    }

    public String addParameters(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (hashMap != null) {
            if (hashMap.isEmpty() == null) {
                stringBuilder.append("?");
                for (Entry entry : hashMap.entrySet()) {
                    try {
                        stringBuilder.append((String) entry.getKey());
                        stringBuilder.append("=");
                        stringBuilder.append((String) entry.getValue());
                        stringBuilder.append("&");
                    } catch (Throwable e) {
                        l.a().e(e);
                    }
                }
                str = stringBuilder.toString();
                return str.substring(null, str.length() - 1);
            }
        }
        return stringBuilder.toString();
    }

    public String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (String str2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public Boolean isHttpProtocol(String str) {
        return a(str, "http:");
    }

    public Boolean isHttpsProtocol(String str) {
        return a(str, "https:");
    }

    public String replaceURLWithSupportProtocol(String str) {
        return (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a()) && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str;
    }

    public Boolean a(String str) {
        if (!(a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue())) {
            if (a(str, "mms:").booleanValue() == null) {
                str = null;
                return Boolean.valueOf(str);
            }
        }
        str = true;
        return Boolean.valueOf(str);
    }

    private Boolean a(String str, String str2) {
        str = (str == null || str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) != null) ? null : true;
        return Boolean.valueOf(str);
    }

    public java.lang.String getFileName(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x001a }
        r0.<init>(r3);	 Catch:{ URISyntaxException -> 0x001a }
        r3 = r0.getPath();	 Catch:{ URISyntaxException -> 0x001a }
        r0 = 47;	 Catch:{ URISyntaxException -> 0x001a }
        r0 = r3.lastIndexOf(r0);	 Catch:{ URISyntaxException -> 0x001a }
        r0 = r0 + 1;	 Catch:{ URISyntaxException -> 0x001a }
        r1 = r3.length();	 Catch:{ URISyntaxException -> 0x001a }
        r3 = r3.substring(r0, r1);	 Catch:{ URISyntaxException -> 0x001a }
        return r3;
    L_0x001a:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.s.getFileName(java.lang.String):java.lang.String");
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public String getFixedString(String str) {
        if (str == null) {
            return null;
        }
        if (!isHttpProtocol(str).booleanValue()) {
            if (!isHttpsProtocol(str).booleanValue()) {
                return str;
            }
        }
        return str.split("\\?")[0];
    }

    public String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        if (!isHttpProtocol(str).booleanValue()) {
            if (!isHttpsProtocol(str).booleanValue()) {
                str = null;
                if (str == null && str.length >= 2) {
                    return str[1];
                }
            }
        }
        str = str.split("\\?");
        return str == null ? null : null;
    }

    public void pintHttpInNewThread(String str) {
        a aVar = new a();
        c cVar = new c(str, "");
        cVar.e = 1;
        aVar.a(cVar, Boolean.valueOf(true));
    }
}
