package com.xunlei.downloadprovider.d.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a;

/* compiled from: YouLiaoConfig */
public final class s extends a {
    public final int a() {
        int a = a("banner_operation_type", -1);
        Object obj = 1;
        if (a != 1) {
            if (a != 2) {
                obj = null;
            }
        }
        return obj != null ? a : -1;
    }

    public final String b() {
        return a("banner_operation_content", "");
    }

    public final String c() {
        return a("banner_poster_url", "");
    }

    public final int d() {
        return a("nearby_distance_threshold_value", 50);
    }

    public final int e() {
        return a("tag_distance_threshold_value", 20);
    }

    public final boolean f() {
        return a("newest_tag_opened", false);
    }

    public final boolean g() {
        return a("nearby_tag_opened", false);
    }

    public final int h() {
        return a("community_card_count", 12);
    }

    public final boolean i() {
        return a("from_youliao_tag_is_clickable", false);
    }

    public final boolean j() {
        return a("is_detail_youliao_show", false);
    }

    public final String k() {
        Object a = a("youliao_download_url", "");
        return TextUtils.isEmpty(a) ? "http://m.down.sandai.net/kuaipan/static/android_client/youliao_v6.1.1_shoulei.apk" : a;
    }
}
