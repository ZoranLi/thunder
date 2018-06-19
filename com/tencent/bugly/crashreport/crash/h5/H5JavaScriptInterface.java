package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.alipay.sdk.cons.c;
import com.tencent.bugly.crashreport.CrashReport.WebViewInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet();
    private String b = null;
    private Thread c = null;
    private String d = null;
    private Map<String, String> e = null;

    private H5JavaScriptInterface() {
    }

    public static H5JavaScriptInterface getInstance(WebViewInterface webViewInterface) {
        if (webViewInterface != null) {
            if (!a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
                H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
                a.add(Integer.valueOf(webViewInterface.hashCode()));
                h5JavaScriptInterface.c = Thread.currentThread();
                h5JavaScriptInterface.d = a(h5JavaScriptInterface.c);
                h5JavaScriptInterface.e = a(webViewInterface);
                return h5JavaScriptInterface;
            }
        }
        return null;
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 2; i < thread.getStackTrace().length; i++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i];
            if (!stackTraceElement.toString().contains("crashreport")) {
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static Map<String, String> a(WebViewInterface webViewInterface) {
        Map<String, String> hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", stringBuilder.toString());
        return hashMap;
    }

    private a a(String str) {
        if (str != null) {
            if (str.length() > 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    str = new a();
                    str.a = jSONObject.getString("projectRoot");
                    if (str.a == null) {
                        return null;
                    }
                    str.b = jSONObject.getString("context");
                    if (str.b == null) {
                        return null;
                    }
                    str.c = jSONObject.getString("url");
                    if (str.c == null) {
                        return null;
                    }
                    str.d = jSONObject.getString("userAgent");
                    if (str.d == null) {
                        return null;
                    }
                    str.e = jSONObject.getString("language");
                    if (str.e == null) {
                        return null;
                    }
                    str.f = jSONObject.getString(c.e);
                    if (str.f != null) {
                        if (!str.f.equals("null")) {
                            String string = jSONObject.getString("stacktrace");
                            if (string == null) {
                                return null;
                            }
                            int indexOf = string.indexOf("\n");
                            if (indexOf < 0) {
                                an.d("H5 crash stack's format is wrong!", new Object[0]);
                                return null;
                            }
                            str.h = string.substring(indexOf + 1);
                            str.g = string.substring(0, indexOf);
                            int indexOf2 = str.g.indexOf(Constants.COLON_SEPARATOR);
                            if (indexOf2 > 0) {
                                str.g = str.g.substring(indexOf2 + 1);
                            }
                            str.i = jSONObject.getString("file");
                            if (str.f == null) {
                                return null;
                            }
                            str.j = jSONObject.getLong("lineNumber");
                            if (str.j < 0) {
                                return null;
                            }
                            str.k = jSONObject.getLong("columnNumber");
                            if (str.k < 0) {
                                return null;
                            }
                            an.a("H5 crash information is following: ", new Object[0]);
                            StringBuilder stringBuilder = new StringBuilder("[projectRoot]: ");
                            stringBuilder.append(str.a);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[context]: ");
                            stringBuilder.append(str.b);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[url]: ");
                            stringBuilder.append(str.c);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[userAgent]: ");
                            stringBuilder.append(str.d);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[language]: ");
                            stringBuilder.append(str.e);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[name]: ");
                            stringBuilder.append(str.f);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[message]: ");
                            stringBuilder.append(str.g);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[stacktrace]: \n");
                            stringBuilder.append(str.h);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[file]: ");
                            stringBuilder.append(str.i);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[lineNumber]: ");
                            stringBuilder.append(str.j);
                            an.a(stringBuilder.toString(), new Object[0]);
                            stringBuilder = new StringBuilder("[columnNumber]: ");
                            stringBuilder.append(str.k);
                            an.a(stringBuilder.toString(), new Object[0]);
                            return str;
                        }
                    }
                    return null;
                } catch (String str2) {
                    if (!an.a(str2)) {
                        str2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f, aVar.g, aVar.h, map);
        }
    }

    @JavascriptInterface
    public void printLog(String str) {
        an.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            an.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b = ap.b(str.getBytes());
        if (this.b == null || !this.b.equals(b)) {
            this.b = b;
            an.d("Handling JS exception ...", new Object[0]);
            str = a(str);
            if (str == null) {
                an.d("Failed to parse payload.", new Object[0]);
                return;
            }
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(str.a());
            linkedHashMap.putAll(this.e);
            linkedHashMap.put("Java Stack", this.d);
            a(str, this.c, linkedHashMap);
            return;
        }
        an.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
