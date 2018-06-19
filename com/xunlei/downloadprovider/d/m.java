package com.xunlei.downloadprovider.d;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.a.j;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.launch.a.a;
import com.xunlei.xllib.b.d;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: SniffConfigure */
public final class m extends j {
    private static m a = null;
    private static String b = "http://m.baidu.com/s?word=%s";
    private ArrayList<String> c = null;
    private boolean d = false;
    private boolean e = false;

    private m() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/snf_config?rd=");
        stringBuilder.append(System.currentTimeMillis());
        super("sniff_config_default.json", stringBuilder.toString(), "sniff_config_default.json");
    }

    public static m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    @Nullable
    public final ArrayList<String> b() {
        if (!(this.e || this.d)) {
            super.h();
        }
        if (d.a(this.c)) {
            this.c = new ArrayList();
            this.c.add("下载");
            this.c.add("magnet");
            this.c.add("mp4");
            this.c.add("ftp");
            this.c.add("ed2k");
        }
        return new ArrayList(this.c);
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            b = "http://m.baidu.com/s?word=%s";
            return;
        }
        CharSequence optString = jSONObject.optString("search_url");
        b = optString;
        if (TextUtils.isEmpty(optString)) {
            b = "http://m.baidu.com/s?word=%s";
        }
        if (!d.a(this.c)) {
            this.c.clear();
            this.c = null;
        }
        try {
            jSONObject = jSONObject.optJSONArray("keyword_suffix");
            if (jSONObject != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONObject.length(); i++) {
                    arrayList.add(jSONObject.getString(i));
                }
                this.c = arrayList;
            }
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    public final void c() {
        if (f.b(BrothersApplication.getApplicationInstance(), "sniff_config_updated_flag", -1) != ((long) a.a()) && !f.b(BrothersApplication.getApplicationInstance(), "sniff_config_updating_flag", false)) {
            StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/snf_config?rd=");
            stringBuilder.append(System.currentTimeMillis());
            f(stringBuilder.toString());
            f.a(BrothersApplication.getApplicationInstance(), "sniff_config_updating_flag", true);
            i();
        }
    }

    protected final void a(boolean z, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("sniff_config");
            if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString("search_url"))) {
                b(jSONObject.optJSONObject("default_sniff_config"));
            } else {
                b(optJSONObject);
            }
            this.e = true;
        }
        if (z) {
            this.d = true;
        }
        if (!z) {
            if (jSONObject != null) {
                f.a(BrothersApplication.getApplicationInstance(), "sniff_config_updated_flag", (long) a.a());
            }
            f.a(BrothersApplication.getApplicationInstance(), "sniff_config_updating_flag", false);
        }
    }

    public static String d(String str) {
        String str2;
        if (TextUtils.isEmpty(b)) {
            str2 = "http://m.baidu.com/s?word=%s";
        } else {
            str2 = b;
        }
        str = str == null ? "" : k.c(str, "UTF-8");
        if (str2.contains("%s")) {
            return str2.replace("%s", str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
