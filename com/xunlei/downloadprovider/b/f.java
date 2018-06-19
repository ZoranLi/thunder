package com.xunlei.downloadprovider.b;

import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.a.j;
import com.xunlei.downloadprovider.homepage.follow.ae;
import com.xunlei.downloadprovider.homepage.follow.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppPraiseDlgConfig */
public final class f extends j {
    private static f m;
    String a;
    String b;
    String c;
    String d;
    int e;
    int f;
    int g;
    int h;
    int i;
    List<String> j;
    private int l;

    private f() {
        super("config_json", "http://api-shoulei-ssl.xunlei.com/pss/static/config_json_56a0/nice_comment_pop_config.json");
    }

    public static f a() {
        if (m == null) {
            m = new f();
        }
        return m;
    }

    protected final void a(boolean z, JSONObject jSONObject) {
        super.a(z, jSONObject);
        if (jSONObject != null) {
            if (jSONObject.length()) {
                z = jSONObject.optJSONObject("pop_word");
                if (z) {
                    this.a = z.optString("pop_img");
                    if (!TextUtils.isEmpty(this.a)) {
                        ae a = ae.a();
                        Glide.with(BrothersApplication.getApplicationInstance()).load(this.a).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new af(a)).into(500, 500);
                    }
                    this.b = z.optString("pop_desc");
                    this.c = z.optString("left_btn_desc");
                    this.d = z.optString("right_btn_desc");
                }
                z = jSONObject.optJSONObject("pop_time");
                if (z) {
                    this.e = z.optInt("download_speed");
                    this.f = z.optInt("video_play_minutes");
                    this.g = z.optInt("video_like_number");
                }
                z = jSONObject.optJSONObject("pop_other");
                if (z) {
                    this.l = z.optInt("good_comment_seconds");
                    this.h = (((z.optInt("pop_next_show_days") * 24) * 60) * 60) * 1000;
                    this.i = z.optInt("cancel_praise_times");
                    z = z.optJSONArray("app_shops");
                    this.j = new ArrayList();
                    if (z) {
                        for (jSONObject = null; jSONObject < z.length(); jSONObject++) {
                            try {
                                this.j.add(z.getString(jSONObject));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
