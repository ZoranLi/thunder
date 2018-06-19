package com.xunlei.downloadprovider.download.tasklist.list.feed;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.home.a;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

/* compiled from: FeedReporter */
public final class b {
    public static final Map<Integer, Set<String>> a = new HashMap();
    private static SparseArray<List<m>> b = new SparseArray();
    private static SparseArray<Set<m>> c = new SparseArray();

    public static boolean a(int i, String str) {
        return a.get(Integer.valueOf(i)) != null ? ((Set) a.get(Integer.valueOf(i))).contains(str) : false;
    }

    public static void b(int i, String str) {
        Set set = (Set) a.get(Integer.valueOf(i));
        if (set == null) {
            set = new HashSet();
            a.put(Integer.valueOf(i), set);
        }
        set.add(str);
    }

    public static void a() {
        a.clear();
    }

    public static void a(String str, int i, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("contentid", str);
        hashMap.put("tabid", c(i));
        hashMap.put("content_type", str2);
        a.a().a(str, "position", str5, i);
        hashMap.put("contentlist", a.a().a(str, i));
        hashMap.put("tag", str3);
        hashMap.put("source", str4);
        a.a("adv_dlflow_show", hashMap);
    }

    public static void a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Map hashMap = new HashMap();
        hashMap.put("contentid", str);
        hashMap.put("tabid", c(i));
        hashMap.put("content_type", str2);
        a.a().a(str, "position", str5, i);
        hashMap.put("contentlist", a.a().a(str, i));
        hashMap.put("tag", str3);
        hashMap.put("source", str4);
        hashMap.put("advid", str6);
        hashMap.put("ad_type", str7);
        hashMap.put("material", str8);
        hashMap.put("position_id", str9);
        hashMap.put("styleid", str10);
        hashMap.put("searchId", str11);
        a.a("adv_dlflow_show", hashMap);
    }

    public static void a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("error_code", str);
        hashMap.put("error_info", str2);
        a.a("request_feed_fail", hashMap);
    }

    public static void b(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Map hashMap = new HashMap();
        hashMap.put("contentid", str);
        hashMap.put("tabid", c(i));
        hashMap.put("content_type", str2);
        hashMap.put("tag", str3);
        hashMap.put("source", str4);
        a.a().a(str, "position", str5, i);
        hashMap.put("contentlist", a.a().a(str, i));
        hashMap.put("advid", str6);
        hashMap.put("ad_type", str7);
        hashMap.put("material", str8);
        hashMap.put("position_id", str9);
        hashMap.put("styleid", str10);
        hashMap.put("searchId", str11);
        a.a("adv_dlflow_click", hashMap);
    }

    public static void b(String str, int i, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("contentid", str);
        hashMap.put("tabid", c(i));
        hashMap.put("content_type", str2);
        hashMap.put("tag", str3);
        hashMap.put("source", str4);
        a.a().a(str, "position", str5, i);
        hashMap.put("contentlist", a.a().a(str, i));
        a.a("adv_dlflow_click", hashMap);
    }

    public static void a(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map hashMap = new HashMap();
        hashMap.put("contentid", str);
        hashMap.put("tabid", c(i));
        hashMap.put("content_type", str2);
        hashMap.put("playid", str3);
        hashMap.put("enter_time", str4);
        hashMap.put("exit_time", str5);
        hashMap.put("tag", str6);
        hashMap.put("source", str7);
        a.a("adv_dlflow_detail", hashMap);
    }

    public static void a(int i) {
        Map hashMap = new HashMap();
        hashMap.put("tabid", c(i));
        a.a("to_top_show", hashMap);
    }

    public static void b(int i) {
        Map hashMap = new HashMap();
        hashMap.put("tabid", c(i));
        a.a("to_top_click", hashMap);
    }

    public static String c(int i) {
        if (com.xunlei.downloadprovider.download.b.b.c()) {
            return "dl_home";
        }
        switch (i) {
            case 0:
                return "dl_all";
            case 1:
                return "dl_dloading";
            case 2:
                return "dl_complete";
            default:
                return "dl_all";
        }
    }

    public static void a(m mVar, int i, int i2) {
        if (mVar != null) {
            List list = (List) b.get(i2);
            if (list == null) {
                b.put(i2, new ArrayList());
                list = (List) b.get(i2);
            }
            Set set = (Set) c.get(i2);
            if (set == null) {
                c.put(i2, new HashSet());
                set = (Set) c.get(i2);
            }
            if (!set.contains(mVar)) {
                if (!list.contains(mVar)) {
                    a.a().a(mVar.b(), "position", String.valueOf(i), i2);
                    list.add(mVar);
                    set.add(mVar);
                    if (list.size() >= 5) {
                        d(i2);
                    }
                }
            }
        }
    }

    public static void d(int i) {
        List list = (List) b.get(i);
        if (list == null) {
            b.put(i, new ArrayList());
            list = (List) b.get(i);
        }
        if (!r0.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (m mVar : r0) {
                if (mVar.k == 7) {
                    stringBuilder2.append(mVar.b.getVideoId());
                    stringBuilder2.append('_');
                } else {
                    stringBuilder.append(mVar.b.getVideoId());
                    stringBuilder.append('_');
                }
            }
            a(stringBuilder2);
            a(stringBuilder);
            StatEvent build = HubbleEventBuilder.build("dl_tab", "dl_tab_content_show");
            build.add("tabid", c(i));
            build.add("dl_tab_video_list", stringBuilder.toString());
            build.add("dl_tab_video_big_pic", stringBuilder2.toString());
            build.add("rec_params", a((Collection) r0));
            build.add("contentlist", a.a().a((List) r0, i));
            ThunderReport.reportEvent(build);
            r0.clear();
        }
    }

    private static java.lang.String a(java.util.Collection<com.xunlei.downloadprovider.homepage.choiceness.a.a.m> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r5 == 0) goto L_0x0049;
    L_0x0002:
        r0 = r5.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x0049;
    L_0x0009:
        r0 = new org.json.JSONArray;
        r0.<init>();
        r5 = r5.iterator();
    L_0x0012:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0044;
    L_0x0018:
        r1 = r5.next();
        r1 = (com.xunlei.downloadprovider.homepage.choiceness.a.a.m) r1;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0012 }
        r2.<init>();	 Catch:{ JSONException -> 0x0012 }
        r3 = "movieid";	 Catch:{ JSONException -> 0x0012 }
        r4 = r1.b();	 Catch:{ JSONException -> 0x0012 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0012 }
        r3 = "params";	 Catch:{ JSONException -> 0x0012 }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0012 }
        r1 = r1.m;	 Catch:{ JSONException -> 0x0012 }
        r4.<init>(r1);	 Catch:{ JSONException -> 0x0012 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x0012 }
        r1 = r2.toString();	 Catch:{ JSONException -> 0x0012 }
        r1 = android.net.Uri.encode(r1);	 Catch:{ JSONException -> 0x0012 }
        r0.put(r1);	 Catch:{ JSONException -> 0x0012 }
        goto L_0x0012;
    L_0x0044:
        r5 = r0.toString();
        return r5;
    L_0x0049:
        r5 = "";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(java.util.Collection):java.lang.String");
    }

    private static java.lang.String a(com.xunlei.downloadprovider.homepage.choiceness.a.a.e r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0023 }
        r0.<init>();	 Catch:{ JSONException -> 0x0023 }
        r1 = "movieid";	 Catch:{ JSONException -> 0x0023 }
        r2 = r3.b();	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0023 }
        r1 = "params";	 Catch:{ JSONException -> 0x0023 }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0023 }
        r3 = r3.m;	 Catch:{ JSONException -> 0x0023 }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0023 }
        r3 = r0.toString();	 Catch:{ JSONException -> 0x0023 }
        r3 = android.net.Uri.encode(r3);	 Catch:{ JSONException -> 0x0023 }
        return r3;
    L_0x0023:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(com.xunlei.downloadprovider.homepage.choiceness.a.a.e):java.lang.String");
    }

    private static void a(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void b() {
        ThunderReport.reportEvent(StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "request_feed"));
    }

    public static void a(String str) {
        if (f.a()) {
            Map hashMap = new HashMap();
            hashMap.put("request_type", str);
            a.a("toutiao_request", hashMap);
        }
    }

    public static void a(String str, int i, String str2) {
        if (f.a()) {
            Map hashMap = new HashMap();
            hashMap.put("request_type", str);
            hashMap.put("error_code", String.valueOf(i));
            hashMap.put("error_info", str2);
            a.a("toutiao_request_fail", hashMap);
        }
    }

    public static void a(m mVar, String str, int i) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("dl_tab", "dl_tab_content_click").add("tabid", c(i)).add(AgooConstants.MESSAGE_ID, mVar.b()).add("format_type", str).add("rec_params", mVar.m).add("contentlist", a.a().a(mVar.b(), i)));
    }

    public static void a(n nVar, int i, int i2) {
        WebsiteInfo websiteInfo = nVar.a;
        StatEvent build = HubbleEventBuilder.build("dl_tab", "dl_tab_web_show");
        build.add("tabid", c(i2));
        build.add(AgooConstants.MESSAGE_ID, nVar.b());
        build.add("host", nVar.b.getUid());
        build.add("haspic", TextUtils.isEmpty(websiteInfo.g) ? "nopic" : SocializeConstants.KEY_PIC);
        build.add("url", Uri.encode(websiteInfo.f));
        build.add(Constants.KEY_MODEL, "single_line");
        StringBuilder stringBuilder = new StringBuilder("website");
        stringBuilder.append(nVar.b());
        String stringBuilder2 = stringBuilder.toString();
        a.a().a(stringBuilder2, "position", String.valueOf(i), i2);
        build.add("contentlist", a.a().a(stringBuilder2, i2));
        build.add("rec_params", a((e) nVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(n nVar, String str, int i, int i2) {
        WebsiteInfo websiteInfo = nVar.a;
        StatEvent build = HubbleEventBuilder.build("dl_tab", "dl_tab_web_click");
        build.add("tabid", c(i2));
        build.add(AgooConstants.MESSAGE_ID, nVar.b());
        build.add("host", nVar.b.getUid());
        build.add("haspic", TextUtils.isEmpty(websiteInfo.g) ? "nopic" : SocializeConstants.KEY_PIC);
        build.add("jump_to", str);
        build.add("url", Uri.encode(websiteInfo.f));
        build.add(Constants.KEY_MODEL, "single_line");
        str = new StringBuilder("website");
        str.append(nVar.b());
        str = str.toString();
        a.a().a(str, "position", String.valueOf(i), i2);
        build.add("contentlist", a.a().a(str, i2));
        build.add("rec_params", a((e) nVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(c cVar, String str, int i, int i2) {
        StatEvent build = HubbleEventBuilder.build("dl_tab", "dl_tab_news_show");
        PhotoArticleInfo photoArticleInfo = cVar.a;
        build.add("tabid", str);
        build.add("news_id", photoArticleInfo.a);
        build.add("author_id", photoArticleInfo.f);
        str = cVar.a.e;
        build.add("pictures", str == null ? true : str.size());
        build.add("template", cVar.k);
        build.add("rec_params", a((e) cVar));
        str = new StringBuilder("photo_article");
        str.append(cVar.b());
        String stringBuilder = str.toString();
        a.a().a(stringBuilder, "position", String.valueOf(i), i2);
        build.add("contentlist", a.a().a(stringBuilder, i2));
        ThunderReport.reportEvent(build);
    }

    public static void b(c cVar, String str, int i, int i2) {
        StatEvent build = HubbleEventBuilder.build("dl_tab", "dl_tab_news_content_click");
        build.add("tabid", str);
        build.add("news_id", cVar.b());
        build.add("author_id", cVar.a.f);
        str = cVar.a.e;
        build.add("pictures", str == null ? true : str.size());
        build.add("template", cVar.k);
        build.add("rec_params", a((e) cVar));
        str = new StringBuilder("photo_article");
        str.append(cVar.b());
        String stringBuilder = str.toString();
        a.a().a(stringBuilder, "position", String.valueOf(i), i2);
        build.add("contentlist", a.a().a(stringBuilder, i2));
        ThunderReport.reportEvent(build);
    }
}
