package com.xunlei.downloadprovider.d;

import com.xunlei.downloadprovider.d.a.j;

/* compiled from: RegionConfigure */
public class l extends j {
    private static l a;

    public static l a() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    private l() {
        super("region_configure.json", "http://api-shoulei-ssl.xunlei.com/location_conf");
    }

    public final boolean b() {
        return a("play_on_download", true);
    }

    public final boolean c() {
        return a("share_on_download_detail", true);
    }

    public final boolean d() {
        return a("is_show_browser_bottom_share_btn", true);
    }

    public final boolean e() {
        return a("is_show_website_guide_after_favorite", true);
    }

    public final boolean f() {
        return a("is_publish_after_record", true);
    }
}
