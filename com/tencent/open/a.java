package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public class a {
    protected HashMap<String, b> a = new HashMap();

    /* compiled from: ProGuard */
    public static class a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public a(WebView webView, long j, String str) {
            this.a = new WeakReference(webView);
            this.b = j;
            this.c = str;
        }

        public void a(Object obj) {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                String str = "'undefined'";
                if (obj instanceof String) {
                    obj = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                    StringBuilder stringBuilder = new StringBuilder("'");
                    stringBuilder.append(obj);
                    stringBuilder.append("'");
                    str = stringBuilder.toString();
                } else {
                    if (!((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double))) {
                        if (!(obj instanceof Float)) {
                            if (obj instanceof Boolean) {
                                str = obj.toString();
                            }
                        }
                    }
                    str = obj.toString();
                }
                obj = new StringBuilder("javascript:window.JsBridge&&JsBridge.callback(");
                obj.append(this.b);
                obj.append(",{'r':0,'result':");
                obj.append(str);
                obj.append("});");
                webView.loadUrl(obj.toString());
            }
        }

        public void a() {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                StringBuilder stringBuilder = new StringBuilder("javascript:window.JsBridge&&JsBridge.callback(");
                stringBuilder.append(this.b);
                stringBuilder.append(",{'r':1,'result':'no such method'})");
                webView.loadUrl(stringBuilder.toString());
            }
        }

        public void a(String str) {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                StringBuilder stringBuilder = new StringBuilder("javascript:");
                stringBuilder.append(str);
                webView.loadUrl(stringBuilder.toString());
            }
        }
    }

    /* compiled from: ProGuard */
    public static class b {
        public boolean customCallback() {
            return false;
        }

        public void call(String str, List<String> list, a aVar) {
            Method method;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                String str2 = null;
                if (i >= length) {
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i++;
                if (method == null) {
                    try {
                        switch (list.size()) {
                            case null:
                                str = method.invoke(this, new Object[0]);
                                break;
                            case 1:
                                str = method.invoke(this, new Object[]{list.get(0)});
                                break;
                            case 2:
                                str = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                                break;
                            case 3:
                                str = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                                break;
                            case 4:
                                str = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                                break;
                            case 5:
                                str = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                                break;
                            default:
                                str = new Object[6];
                                str[0] = list.get(0);
                                str[1] = list.get(1);
                                str[2] = list.get(2);
                                str[3] = list.get(3);
                                str[4] = list.get(4);
                                str[5] = list.get(5);
                                str = method.invoke(this, str);
                                break;
                        }
                        list = method.getReturnType();
                        StringBuilder stringBuilder = new StringBuilder("-->call, result: ");
                        stringBuilder.append(str);
                        stringBuilder.append(" | ReturnType: ");
                        stringBuilder.append(list.getName());
                        f.b("openSDK_LOG.JsBridge", stringBuilder.toString());
                        if (!"void".equals(list.getName())) {
                            if (list == Void.class) {
                                if (!(aVar == null || customCallback() == null)) {
                                    if (str != null) {
                                        str2 = str.toString();
                                    }
                                    aVar.a(str2);
                                }
                            }
                        }
                        if (aVar != null) {
                            aVar.a(null);
                        }
                    } catch (String str3) {
                        StringBuilder stringBuilder2 = new StringBuilder("-->handler call mehtod ex. targetMethod: ");
                        stringBuilder2.append(method);
                        f.b("openSDK_LOG.JsBridge", stringBuilder2.toString(), str3);
                        if (aVar != null) {
                            aVar.a();
                        }
                        return;
                    }
                }
                if (aVar != null) {
                    aVar.a();
                }
                return;
            }
            method = null;
            if (method == null) {
                if (aVar != null) {
                    aVar.a();
                }
                return;
            }
            switch (list.size()) {
                case null:
                    str3 = method.invoke(this, new Object[0]);
                    break;
                case 1:
                    str3 = method.invoke(this, new Object[]{list.get(0)});
                    break;
                case 2:
                    str3 = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                    break;
                case 3:
                    str3 = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                    break;
                case 4:
                    str3 = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                    break;
                case 5:
                    str3 = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                    break;
                default:
                    str3 = new Object[6];
                    str3[0] = list.get(0);
                    str3[1] = list.get(1);
                    str3[2] = list.get(2);
                    str3[3] = list.get(3);
                    str3[4] = list.get(4);
                    str3[5] = list.get(5);
                    str3 = method.invoke(this, str3);
                    break;
            }
            list = method.getReturnType();
            StringBuilder stringBuilder3 = new StringBuilder("-->call, result: ");
            stringBuilder3.append(str3);
            stringBuilder3.append(" | ReturnType: ");
            stringBuilder3.append(list.getName());
            f.b("openSDK_LOG.JsBridge", stringBuilder3.toString());
            if ("void".equals(list.getName())) {
                if (list == Void.class) {
                    if (str3 != null) {
                        str2 = str3.toString();
                    }
                    aVar.a(str2);
                }
            }
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        StringBuilder stringBuilder = new StringBuilder("getResult---objName = ");
        stringBuilder.append(str);
        stringBuilder.append(" methodName = ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.JsBridge", stringBuilder.toString());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = (b) this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        StringBuilder stringBuilder = new StringBuilder("-->canHandleUrl---url = ");
        stringBuilder.append(str);
        f.a("openSDK_LOG.JsBridge", stringBuilder.toString());
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/#");
        ArrayList arrayList = new ArrayList(Arrays.asList(stringBuilder.toString().split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4, str);
        webView.getUrl();
        a(str2, str3, subList, aVar);
        return true;
    }
}
