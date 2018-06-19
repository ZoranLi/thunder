package com.xunlei.downloadprovider.d.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a;

/* compiled from: RedEnvelopeConfig */
public final class n extends a {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;

    public final boolean a() {
        return a("show_slider", false);
    }

    public final int b() {
        return a("red_packet_share_type", a);
    }

    public final String c() {
        String a = a("red_packet_share_url", "https://h5-m-ssl.xunlei.com/h5/page/wx-short-video/index.html?pageType=red3");
        if (TextUtils.isEmpty(a)) {
            a = "https://h5-m-ssl.xunlei.com/h5/page/wx-short-video/index.html?pageType=red3";
        }
        StringBuilder stringBuilder;
        if (!a.contains("?")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("?");
            return stringBuilder.toString();
        } else if (a.charAt(a.length() - 1) == '&') {
            return a;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("&");
            return stringBuilder.toString();
        }
    }

    public final boolean d() {
        if (b() != b) {
            if (b() != c) {
                return false;
            }
        }
        return true;
    }

    public final String e() {
        String a = a("red_packet_share_title", "迅雷送你一个现金红包，戳我领取～");
        return TextUtils.isEmpty(a) ? "迅雷送你一个现金红包，戳我领取～" : a;
    }

    public final int f() {
        return a("anim_show_after_play_position", 5);
    }

    public final String g() {
        String a = a("share_platform_header_desc", "迅雷送你一个现金红包，戳我领取");
        return TextUtils.isEmpty(a) ? "迅雷送你一个现金红包，戳我领取" : a;
    }

    public final String h() {
        String a = a("share_platform_header_title", "分享视频赚取现金");
        return TextUtils.isEmpty(a) ? "分享视频赚取现金" : a;
    }

    public final int i() {
        return a("video_detail_complete_show_time", 5);
    }
}
