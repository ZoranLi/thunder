package com.xunlei.downloadprovider.member.b.a;

import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataPool */
public final class a {
    private static long a = -1;
    private static HashMap<String, f> b = new HashMap();

    public static synchronized String a(String str) throws JSONException {
        String str2;
        synchronized (a.class) {
            f fVar = new f();
            str2 = "";
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            str = jSONObject.has("result") != null ? jSONObject.getInt("result") : null;
            if (jSONObject.has("style")) {
                str2 = jSONObject.getString("style");
            }
            if (str == 200) {
                if (jSONObject.has("bubble_list") != null) {
                    str2 = b(jSONObject);
                } else {
                    f fVar2 = new f();
                    if (jSONObject.has("result")) {
                        fVar2.b = jSONObject.getInt("result");
                    }
                    if (jSONObject.has("msg")) {
                        fVar2.c = jSONObject.getString("msg");
                    }
                    if (jSONObject.has("bubbleid")) {
                        fVar2.d = jSONObject.getString("bubbleid");
                    }
                    if (jSONObject.has("text")) {
                        String string = jSONObject.getString("text");
                        if (!TextUtils.isEmpty(string)) {
                            if (string.contains("&")) {
                                String[] split = string.split("&");
                                fVar2.e = split[0];
                                fVar2.f = split[1];
                            } else {
                                fVar2.e = string;
                            }
                        }
                    }
                    if (jSONObject.has("button_text")) {
                        fVar2.g = jSONObject.getString("button_text");
                    }
                    if (jSONObject.has("url")) {
                        fVar2.l = e(jSONObject.getString("url"));
                    }
                    if (jSONObject.has("show_time")) {
                        fVar2.i = jSONObject.getString("show_time");
                    }
                    if (jSONObject.has("style")) {
                        fVar2.j = jSONObject.getString("style");
                    }
                    if (jSONObject.has("expire_days")) {
                        fVar2.k = jSONObject.getInt("expire_days");
                    }
                    a(fVar2);
                }
            } else if (str == 404) {
                if (jSONObject.has("bubble_list") != null) {
                    str2 = a(jSONObject);
                    str = str2.split(h.b);
                    int length = str.length;
                    while (i < length) {
                        f(str[i]);
                        i++;
                    }
                } else {
                    f(str2);
                }
            }
        }
        return str2;
    }

    private static String a(JSONObject jSONObject) throws JSONException {
        jSONObject = jSONObject.getJSONArray("bubble_list");
        String str = "";
        for (int i = 0; i < jSONObject.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(i);
            if (jSONObject2.has("style")) {
                String string = jSONObject2.getString("style");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(string);
                stringBuilder.append(h.b);
                str = stringBuilder.toString();
            }
        }
        return str.endsWith(h.b) != null ? str.substring(0, str.length() - 1) : str;
    }

    private static String b(JSONObject jSONObject) throws JSONException {
        String str = "";
        String str2 = "";
        int i = jSONObject.has("result") ? jSONObject.getInt("result") : 0;
        if (jSONObject.has("msg")) {
            str2 = jSONObject.getString("msg");
        }
        int i2 = jSONObject.has("expire_days") ? jSONObject.getInt("expire_days") : 10000;
        jSONObject = jSONObject.getJSONArray("bubble_list");
        String str3 = str;
        for (int i3 = 0; i3 < jSONObject.length(); i3++) {
            f fVar = new f();
            fVar.b = i;
            fVar.c = str2;
            fVar.k = i2;
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(i3);
            if (jSONObject2.has("bubbleid")) {
                fVar.d = jSONObject2.getString("bubbleid");
            }
            if (jSONObject2.has("url")) {
                fVar.l = new c();
                fVar.l = e(jSONObject2.getString("url"));
            }
            if (jSONObject2.has("text")) {
                String string = jSONObject2.getString("text");
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("&")) {
                        String[] split = string.split("&");
                        fVar.e = split[0];
                        fVar.f = split[1];
                    } else {
                        fVar.e = string;
                    }
                }
            }
            if (jSONObject2.has("button_text")) {
                fVar.g = jSONObject2.getString("button_text");
            }
            if (jSONObject2.has("show_time")) {
                fVar.i = jSONObject2.getString("show_time");
            }
            if (jSONObject2.has("style")) {
                String string2 = jSONObject2.getString("style");
                fVar.j = string2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(string2);
                stringBuilder.append(h.b);
                str3 = stringBuilder.toString();
            }
            a(fVar);
        }
        return str3.endsWith(h.b) != null ? str3.substring(0, str3.length() - 1) : str3;
    }

    private static c e(String str) {
        c cVar = new c();
        try {
            if (str.startsWith("\"") || str.startsWith("'")) {
                str = str.substring(1, str.length() - 1);
            }
            cVar.a = new JSONObject(str).getString("aidfrom");
        } catch (String str2) {
            str2.printStackTrace();
            cVar.a = "";
        }
        return cVar;
    }

    protected static synchronized f b(String str) {
        f fVar;
        synchronized (a.class) {
            fVar = (f) b.get(str);
        }
        return fVar;
    }

    private static synchronized void a(f fVar) {
        synchronized (a.class) {
            long c = LoginHelper.a().g.c();
            if (a != c) {
                a();
            }
            a = c;
            b.put(fVar.j, fVar);
        }
    }

    protected static synchronized void c(String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str)) {
                str = str.split(h.b);
                new StringBuilder("deleteVipRenewalTip:").append(str);
                for (Object remove : str) {
                    b.remove(remove);
                }
            }
        }
    }

    protected static synchronized boolean d(String str) {
        boolean z;
        synchronized (a.class) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                if (a != LoginHelper.a().g.c()) {
                    a();
                } else {
                    str = str.split(h.b);
                    new StringBuilder("hasTheVipnewalTip:").append(str);
                    int length = str.length;
                    boolean z2 = false;
                    int i;
                    while (i < length) {
                        z2 = b.containsKey(str[i]);
                        i++;
                    }
                    z = z2;
                }
            }
        }
        return z;
    }

    private static void f(String str) {
        c(str);
        f fVar = new f();
        fVar.j = str;
        fVar.b = 404;
        a(fVar);
    }

    protected static synchronized void a() {
        synchronized (a.class) {
            b.clear();
        }
    }
}
