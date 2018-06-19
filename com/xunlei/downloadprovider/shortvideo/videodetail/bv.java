package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShortMovieDetailReporter */
public final class bv {
    private static String A = "videoDetail_play_button_show";
    private static String a = "android_videodetail";
    private static String b = "videoDetail_show";
    private static String c = "videoDetail_zan";
    private static String d = "videoDetail_discuss_zan";
    private static String e = "videoDetail_discuss_alter";
    private static String f = "videoDetail_discuss_show";
    private static String g = "videoDetail_discuss_area_show";
    private static String h = "videoDetail_defaultdiscuss_show";
    private static String i = "videoDetail_discuss_click";
    private static String j = "videoDetail_discuss_submit";
    private static String k = "videoDetail_defaultdiscuss_submit";
    private static String l = "videoDetail_discuss_result";
    private static String m = "videoDetial_discuss_error";
    private static String n = "videoDetail_recommend_click";
    private static String o = "videoDetail_recommend_more_click";
    private static String p = "videoDetail_share_click";
    private static String q = "videoDetail_share_to";
    private static String r = "videoDetail_share_result";
    private static String s = "videoDetail_recommend_show";
    private static String t = "videoDetail_autoplay_next_close";
    private static String u = "videoDetail_common_click";
    private static String v = "videotag_click";
    private static String w = "videoDetail_follow_click";
    private static String x = "videoDetail_follow_click_result";
    private static String y = "videoDetail_head_click";
    private static String z = "videoDetail_zan_animation";

    /* compiled from: ShortMovieDetailReporter */
    public static class a {
        String a;
        int b;
        int c;

        public a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != null) {
                return this.a.equals(aVar.a);
            }
            return aVar.a == null;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("RecommendReportInfo{mVideoId='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", rn=");
            stringBuilder.append(this.b);
            stringBuilder.append(", refreshNum=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final int hashCode() {
            return this.a != null ? this.a.hashCode() : 0;
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build(a, b);
        build.add("from", str2);
        build.add("is_play", 1);
        build.add("movieid", str);
        build.add("is_shot", z ? "yes" : "no");
        build.add("is_youliao", z2 ? "yes" : "no");
        a(build);
    }

    public static void a(List<a> list, String str, String[] strArr) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(strArr[2]) ? new JSONObject(strArr[2]) : null;
            for (a aVar : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("rn", String.valueOf(aVar.b));
                hashMap.put(AgooConstants.MESSAGE_ID, aVar.a);
                hashMap.put("refreshnum", String.valueOf(aVar.c));
                arrayList.add(hashMap);
                arrayList2.add(aVar.a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("movieid", aVar.a);
                jSONObject2.put("params", jSONObject == null ? "" : jSONObject);
                jSONArray.put(jSONObject2);
            }
        } catch (List<a> list2) {
            list2.printStackTrace();
        }
        list2 = HubbleEventBuilder.build(a, s);
        list2.addString("from", str);
        list2.addString("movielist", arrayList2.toString());
        list2.addString("s_ab", strArr[0]);
        list2.addString("rec_params", jSONArray.toString());
        list2.addString("platformModel", strArr[3]);
        list2.addString(c.a, strArr[4]);
        list2.addString("contentlist", ThunderReport.getContentList(arrayList));
        new StringBuilder("report new result=>").append(list2.getExtraData());
        ThunderReport.reportEvent(list2);
    }

    public static void a(String str, String str2, boolean z) {
        StatEvent build = HubbleEventBuilder.build(a, c);
        build.add("movieid", str);
        build.add("position", str2);
        build.add("is_animation_show", z ? "yes" : "no");
        a(build);
    }

    public static void a(String str, long j, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build(a, d);
        build.add("movieid", str);
        build.add("discussid", String.valueOf(j));
        build.add("type", z ? "hot" : "com/xunlei/downloadprovider/ad/common");
        build.add("is_login", z2 ? "1" : "0");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build(a, e);
        build.add("to", str);
        a(build);
    }

    public static void c(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, f);
        build.add("movieid", str);
        build.add("position", str2);
        build.add("author_type", str3);
        build.add("wordid", str4);
        a(build);
    }

    public static void a() {
        a(HubbleEventBuilder.build(a, g));
    }

    public static void a(String str, String str2, String str3, boolean z) {
        StatEvent build = HubbleEventBuilder.build(a, h);
        build.add("is_login", z);
        build.add("position", str);
        build.add("author_type", str2);
        build.add("wordid", str3);
        a(build);
    }

    public static void a(long j, boolean z, String str) {
        StatEvent build = HubbleEventBuilder.build(a, i);
        build.add("discussid", String.valueOf(j));
        build.add("type", z ? "hot" : "com/xunlei/downloadprovider/ad/common");
        build.add("clickid", str);
        a(build);
    }

    public static void a(String str, long j, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, j);
        build.add("movieid", str);
        build.add("discussid", String.valueOf(j));
        build.add("level", j == -1 ? "0" : "1");
        build.add("is_login", z ? "1" : "0");
        build.add("author_type", str2);
        build.add("position", str3);
        a(build);
    }

    public static void a(String str, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, k);
        build.add("wordid", str);
        build.add("is_login", z ? "1" : "0");
        build.add("author_type", str2);
        build.add("position", str3);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, m);
        build.add("discuss_type", str);
        str = "errorcode";
        if ("-1001".contentEquals(str2)) {
            str2 = "network_err";
        }
        build.add(str, str2);
        a(build);
    }

    public static void a(String str, boolean z, String str2, long j, long j2, boolean z2, String str3, boolean z3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, l);
        build.add("result", z ? "success" : "fail");
        z = "errorcode";
        if ("-1001".contentEquals(str2)) {
            str2 = "network_err";
        }
        build.add(z, str2);
        build.add("movieid", str);
        build.add("discussid", String.valueOf(j));
        build.add("new_discussid", String.valueOf(j2));
        build.add("level", j == true ? "0" : "1");
        build.add("if_pop_followrec", z2);
        build.add("author_type", str3);
        build.add("if_default", z3);
        build.add("wordid", str4);
        a(build);
    }

    public static void a(int i, String str, String str2, String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(strArr[2]);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("movieid", str2);
            jSONObject2.put("params", jSONObject);
            jSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StatEvent build = HubbleEventBuilder.build(a, n);
        build.add("rn", i);
        build.add("from", "detail_shortvideo");
        build.add("movieid", str);
        build.add("click_movieid", str2);
        build.add("s_ab", strArr[null]);
        build.add("rec_params", jSONArray.toString());
        build.add("platformModel", strArr[3]);
        build.add(c.a, strArr[4]);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build(a, o);
        build.add("movieid", str);
        a(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build(a, p);
        build.add("from", str);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, q);
        build.add("from", str3);
        build.add("to", str2);
        build.add("movieid", str);
        build.add("url", "android_client");
        LoginHelper.a();
        build.add("if_login", l.c());
        a(build);
    }

    public static void a(String str, String str2, String str3, int i, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, r);
        build.add("from", str4);
        build.add("to", str2);
        build.add("result", str3);
        build.add("errorcode", i);
        build.add("movieid", str);
        LoginHelper.a();
        build.add("if_login", l.c());
        build.add("sharetype", d.a().l.b() == n.b ? SocializeConstants.KEY_PIC : "link");
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, u);
        build.add("clickid", str);
        build.add("movieid", str2);
        a(build);
    }

    public static void c(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, y);
        build.add("zan_userid", str2);
        build.add("movieid", str);
        a(build);
    }

    public static void d(String str) {
        StatEvent build = HubbleEventBuilder.build(a, z);
        build.add("movieid", str);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build(a, w);
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("position", str4);
        build.add("login_type", z);
        build.add("is_guide_bar", z2);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i) {
        StatEvent build = HubbleEventBuilder.build(a, x);
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("login_type", z);
        build.add("position", str4);
        build.add("result", str5);
        build.add("error", str6);
        build.add("hasanim", i);
        a(build);
    }

    public static void e(String str) {
        StatEvent build = HubbleEventBuilder.build(a, A);
        build.add("movieid", str);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, "videoDetail_matchedlink_show");
        build.addString("movieid", str);
        build.addString("linkid", str2);
        build.addString("author_id", str3);
        build.addString("author_type", str4);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, "videoDetail_matchedlink_click");
        build.addString("movieid", str);
        build.addString("linkid", str2);
        build.addString("author_id", str3);
        build.addString("author_type", str4);
        ThunderReport.reportEvent(build);
    }
}
