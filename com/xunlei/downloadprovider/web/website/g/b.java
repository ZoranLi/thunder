package com.xunlei.downloadprovider.web.website.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.bf;
import com.xunlei.downloadprovider.contentpublish.website.bg;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.d.a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebsiteHelper */
public final class b extends e {
    private static b a;
    private static PreferenceHelper b;
    private List<String> c;

    public static boolean h() {
        return false;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
        return a;
    }

    private b() {
    }

    public final void b() {
        XLThreadPool.execute(new c(this));
    }

    public final boolean a(String str) {
        if (!(TextUtils.isEmpty(str) || this.c == null)) {
            for (String equals : this.c) {
                if (TextUtils.equals(equals, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(String str, c cVar) {
        if (this.c == null) {
            XLThreadPool.execute(new d(this, str, cVar));
            return;
        }
        for (String equals : this.c) {
            if (TextUtils.equals(equals, str)) {
                cVar.a(true);
                return;
            }
        }
        cVar.a(null);
    }

    public final void a(String str, String str2, String str3, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new e(this, str, str2, str3, bVar));
        }
    }

    public final void a(String str, String str2, String str3, String str4, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new f(this, str, aVar, str2, str3, str4));
        }
    }

    public final void a(String str, boolean z) {
        if (z) {
            if (this.c && !this.c.contains(str)) {
                this.c.add(str);
            }
        } else if (this.c && this.c.size() <= false) {
            for (String str2 : this.c) {
                if (str2.equals(str)) {
                    this.c.remove(str2);
                    return;
                }
            }
        }
    }

    public final void a(String str, a aVar) {
        XLThreadPool.execute(new g(this, str, aVar));
    }

    public final void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.contains("about:blank")) {
                    if (!str2.contains(BrothersApplication.getApplicationInstance().getString(R.string.about_blank))) {
                        d dVar = new d();
                        dVar.c = str;
                        dVar.b = str2;
                        dVar.d = System.currentTimeMillis();
                        dVar.f = str3;
                        dVar.e = null;
                        XLThreadPool.execute(new h(this, str2, dVar));
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, a aVar) {
        if (!(context == null || TextUtils.isEmpty(str))) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    boolean z;
                    Object host = new URL(str).getHost();
                    if (TextUtils.isEmpty(host)) {
                        z = true;
                    } else {
                        PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
                        StringBuilder stringBuilder = new StringBuilder("collect_tip");
                        stringBuilder.append(host);
                        z = preferenceHelper.getBoolean(stringBuilder.toString(), false);
                    }
                    if (!z) {
                        new com.xunlei.downloadprovider.web.website.d.e(context, str, str2, str3, str4, aVar).show();
                        context = HubbleEventBuilder.build("android_download", "dl_create_collect_show");
                        str2 = "url";
                        if (str == null) {
                            str = "";
                        }
                        context.add(str2, str);
                        context.add("from", str4);
                        ThunderReport.reportEvent(context);
                        if (TextUtils.isEmpty(host) == null) {
                            context = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
                            str = new StringBuilder("collect_tip");
                            str.append(host);
                            context.putBoolean(str.toString(), true);
                        }
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            boolean a = com.xunlei.downloadprovider.d.d.a().j.a();
            boolean e = l.a().e();
            if (a) {
                if (e) {
                    e = true;
                    a = bg.a(str) && !new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collect_success_sp").getBoolean(str, false);
                    if (a) {
                        new a(context, str, str2, str3, str4).show();
                        bf.a(str4, str);
                        if (TextUtils.isEmpty(str) == null) {
                            new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collect_success_sp").putBoolean(str, true);
                        }
                    } else {
                        e = false;
                    }
                    if (!e) {
                        a(context, context.getString(R.string.thunder_browser_favorite_add_success));
                    }
                    return;
                }
            }
            a(context, context.getString(R.string.thunder_browser_favorite_add_success));
        }
    }

    private static void a(Context context, String str) {
        Toast toast = new Toast(context);
        context = LayoutInflater.from(context).inflate(R.layout.download_success_toast, null);
        ((TextView) context.findViewById(R.id.tv_title)).setText(str);
        toast.setView(context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.show();
    }

    public static void c() {
        if (b == null) {
            b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
        }
        b.putBoolean("collec_tab_red_point", true);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            if (b == null) {
                b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
            }
            Object string = b.getString("collec_update_url_click", "");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.equals(jSONArray.getString(i))) {
                    return true;
                }
            }
            return false;
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray;
                if (b == null) {
                    b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
                }
                Object string = b.getString("collec_update_url_click", "");
                if (TextUtils.isEmpty(string)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(string);
                }
                jSONArray.put(str);
                b.putString("collec_update_url_click", jSONArray.toString());
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }

    public static boolean d() {
        if (e()) {
            if (b == null) {
                b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
            }
            if (!b.getBoolean("collec_tab_red_point", false)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        a a = a.a();
        return (a.a == null && a.b == null) ? false : true;
    }

    public static void f() {
        b.putBoolean("collect_update_card_clicked", true);
    }

    public static boolean g() {
        return b.getBoolean("collect_update_card_clicked", false);
    }

    public static com.xunlei.downloadprovider.web.website.b.b d(String str) {
        com.xunlei.downloadprovider.web.website.b.b bVar = new com.xunlei.downloadprovider.web.website.b.b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.b = jSONObject.optString(PushResult.COLLECT_UPDATE_MAIN_URL);
            bVar.a = jSONObject.optString("collect_update_type");
            bVar.e = jSONObject.optInt("update_total_count");
            bVar.c = jSONObject.optString("title");
            str = jSONObject.getJSONArray("update_list");
            bVar.d = new ArrayList();
            for (int i = 0; i < str.length(); i++) {
                com.xunlei.downloadprovider.web.website.b.a aVar = new com.xunlei.downloadprovider.web.website.b.a();
                aVar.a = str.getJSONObject(i).optInt("count");
                aVar.b = str.getJSONObject(i).optString("image_url");
                aVar.c = str.getJSONObject(i).optString("website_name");
                aVar.d = str.getJSONObject(i).optString("website_url");
                bVar.d.add(aVar);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return bVar;
    }

    public static String a(boolean z) {
        if (b == null) {
            b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "collectionSP");
        }
        if (z) {
            return b.getString("collec_update_main_page_json", "");
        }
        return b.getString("collec_update_detaile_page_json", "");
    }

    public static com.xunlei.downloadprovider.web.website.b.b a(com.xunlei.downloadprovider.web.website.b.b bVar) {
        if (bVar == null) {
            return null;
        }
        if ("host".equals(bVar.a)) {
            return bVar;
        }
        if (!"url".equals(bVar.a)) {
            return null;
        }
        Collection arrayList = new ArrayList();
        if (bVar.d != null) {
            if (bVar.d.size() > 0) {
                for (com.xunlei.downloadprovider.web.website.b.a aVar : bVar.d) {
                    c b = com.xunlei.downloadprovider.web.website.c.a.b(aVar.d);
                    if (b != null) {
                        c cVar = new c();
                        cVar.a(System.currentTimeMillis());
                        cVar.d = b.d;
                        cVar.c = b.c;
                        cVar.b = b.b;
                        com.xunlei.downloadprovider.web.website.c.a.a(aVar.d);
                        com.xunlei.downloadprovider.web.website.c.a.a(cVar);
                        arrayList.add(aVar);
                    }
                }
                bVar.d.clear();
                bVar.d.addAll(arrayList);
                if (bVar.d.size() == 0) {
                    return null;
                }
                return bVar;
            }
        }
        return null;
    }
}
