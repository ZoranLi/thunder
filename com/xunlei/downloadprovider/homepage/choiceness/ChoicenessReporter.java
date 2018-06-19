package com.xunlei.downloadprovider.homepage.choiceness;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.g;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.h;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.i;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.o;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

public final class ChoicenessReporter {
    private static List<e> a = new ArrayList();
    private static Set<e> b = new HashSet();
    private static int c = d.a().b.r();

    public static boolean a(RefreshType refreshType) {
        return refreshType == RefreshType.auto_pull ? true : null;
    }

    public static void a(boolean z, e eVar) {
        if (eVar != null) {
            if (!eVar.d()) {
                String b = eVar.b();
                if (!z || !b.contains(eVar)) {
                    a h;
                    try {
                        h = eVar.h();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                        h = eVar;
                    }
                    int indexOf = com.xunlei.downloadprovider.homepage.choiceness.a.a.a(BrothersApplication.getApplicationInstance()).e.indexOf(eVar);
                    h.h = indexOf;
                    StringBuilder stringBuilder = new StringBuilder("tryReportChoicenessExposure--home_collect_content_show--id=");
                    stringBuilder.append(b);
                    stringBuilder.append("|shouldDistinct=");
                    stringBuilder.append(z);
                    stringBuilder.append("|positionInList=");
                    stringBuilder.append(indexOf);
                    a.add(h);
                    b.add(eVar);
                    if (a.size() >= true) {
                        a();
                    }
                }
            }
        }
    }

    public static void a() {
        if (!a.isEmpty()) {
            List arrayList = new ArrayList();
            for (a aVar : a) {
                a aVar2;
                String str = aVar2.l;
                if (aVar2.e()) {
                    arrayList.add(aVar2);
                } else {
                    int i = 1;
                    StatEvent build;
                    if (aVar2.g()) {
                        aVar2 = (i) aVar2;
                        build = HubbleEventBuilder.build("android_hometab", "home_collect_caomei_show");
                        build.add("type", TextUtils.isEmpty(aVar2.z) ? "normal" : "window");
                        build.add("area", 1);
                        build.add("hostid", aVar2.a);
                        build.add("viewernum", aVar2.v);
                        build.add("grayid", aVar2.o);
                        build.add("hosttype", aVar2.c);
                        build.add("recommend", aVar2.q);
                        build.add("sign", aVar2.y);
                        build.add("livestat", aVar2.n);
                        build.add("roomid", aVar2.w);
                        build.add("is_gif", 1 ^ TextUtils.isEmpty(aVar2.s));
                        build.add("contentlist", a(aVar2));
                        build.add("from", aVar2.d);
                        ThunderReport.reportEvent(build);
                    } else if ("photo_article".equals(str)) {
                        aVar2 = (c) aVar2;
                        build = HubbleEventBuilder.build("android_hometab", "home_news_show");
                        PhotoArticleInfo photoArticleInfo = aVar2.a;
                        build.add("news_id", photoArticleInfo.a);
                        build.add("author_id", photoArticleInfo.f);
                        List list = aVar2.a.e;
                        String str2 = "pictures";
                        if (list != null) {
                            i = list.size();
                        }
                        build.add(str2, i);
                        build.add("template", aVar2.k);
                        build.add("rec_params", aVar2.m);
                        build.add("contentlist", a(aVar2));
                        ThunderReport.reportEvent(build);
                    } else if ("cinecism".equals(str)) {
                        aVar2 = (com.xunlei.downloadprovider.homepage.choiceness.a.a.d) aVar2;
                        build = HubbleEventBuilder.build("android_hometab", "home_cinecism_show");
                        CinecismInfo cinecismInfo = aVar2.a;
                        build.add("cinecism_id", cinecismInfo.a);
                        build.add("author_id", cinecismInfo.e);
                        build.add("template", aVar2.k);
                        build.add("rec_params", aVar2.m);
                        build.add("contentlist", a(aVar2));
                        ThunderReport.reportEvent(build);
                    } else if ("recommend_user".equals(str)) {
                        c(aVar2);
                    } else if ("website".equals(str)) {
                        if (aVar2 instanceof n) {
                            WebsiteInfo websiteInfo = ((n) aVar2).a;
                            StatEvent build2 = HubbleEventBuilder.build("android_hometab", "home_web_show");
                            build2.add(AgooConstants.MESSAGE_ID, websiteInfo.a);
                            build2.add("host", websiteInfo.b);
                            build2.add("haspic", TextUtils.isEmpty(websiteInfo.g) ? "nopic" : SocializeConstants.KEY_PIC);
                            build2.add("url", Uri.encode(websiteInfo.f));
                            build2.add(Constants.KEY_MODEL, "single_line");
                            build2.add("contentlist", a(aVar2));
                            build2.add("card_type", c);
                            build2.add("rec_params", b(aVar2));
                            ThunderReport.reportEvent(build2);
                        }
                    } else if ("website_topic".equals(str)) {
                        aVar2 = (o) aVar2;
                        build = HubbleEventBuilder.build("android_hometab", "home_linksubject_show");
                        build.add("linksubject_id", aVar2.a);
                        build.add("template", aVar2.k);
                        build.add("rec_params", aVar2.m);
                        build.add("contentlist", a(aVar2));
                        ThunderReport.reportEvent(build);
                    } else {
                        int i2 = 2;
                        if ("live_pool".equals(str)) {
                            f fVar = (f) aVar2;
                            if (fVar.a.size() <= 2) {
                                i2 = fVar.a.size() - 1;
                            }
                            a(0, i2, fVar);
                        } else if ("live_box_left".equals(str) || "live_box_right".equals(str)) {
                            e eVar = (h) aVar2;
                            str = "live_box_left".equals(str) ? "left3" : "right3";
                            a(eVar.a, eVar, str, 0);
                            a(eVar.b, eVar, str, 1);
                            a(eVar.c, eVar, str, 2);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                StatEvent a = a("home_collect_content_show", a);
                String c = b.c(BrothersApplication.getApplicationInstance());
                a.add("rec_params", a((Collection) arrayList));
                a.addString("platformModel", AndroidConfig.getPhoneModel());
                a.addString(com.alipay.sdk.app.statistic.c.a, c);
                a.add("contentlist", a(arrayList, com.xunlei.downloadprovider.homepage.choiceness.a.a.a(BrothersApplication.getApplicationInstance()).e));
                ThunderReport.reportEvent(a);
            }
            a.clear();
        }
    }

    private static java.lang.String a(java.util.Collection<com.xunlei.downloadprovider.homepage.choiceness.a.a.e> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r5 = "";
        return r5;
    L_0x0009:
        r0 = new org.json.JSONArray;
        r0.<init>();
        r5 = r5.iterator();
    L_0x0012:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x004a;
    L_0x0018:
        r1 = r5.next();
        r1 = (com.xunlei.downloadprovider.homepage.choiceness.a.a.e) r1;
        r2 = r1.e();
        if (r2 == 0) goto L_0x0012;
    L_0x0024:
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
    L_0x004a:
        r5 = r0.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter.a(java.util.Collection):java.lang.String");
    }

    private static java.lang.String b(com.xunlei.downloadprovider.homepage.choiceness.a.a.e r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter.b(com.xunlei.downloadprovider.homepage.choiceness.a.a.e):java.lang.String");
    }

    private static java.lang.String a(com.xunlei.downloadprovider.homepage.choiceness.a.a.m r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002c }
        r0.<init>();	 Catch:{ JSONException -> 0x002c }
        r1 = "id";	 Catch:{ JSONException -> 0x002c }
        r2 = r3.b;	 Catch:{ JSONException -> 0x002c }
        r2 = r2.getVideoId();	 Catch:{ JSONException -> 0x002c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x002c }
        r1 = "reason";	 Catch:{ JSONException -> 0x002c }
        r2 = r3.o;	 Catch:{ JSONException -> 0x002c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x002c }
        r1 = "extData";	 Catch:{ JSONException -> 0x002c }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002c }
        r3 = r3.m;	 Catch:{ JSONException -> 0x002c }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x002c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x002c }
        r3 = r0.toString();	 Catch:{ JSONException -> 0x002c }
        r3 = android.net.Uri.encode(r3);	 Catch:{ JSONException -> 0x002c }
        return r3;
    L_0x002c:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter.a(com.xunlei.downloadprovider.homepage.choiceness.a.a.m):java.lang.String");
    }

    public static void b() {
        b.clear();
    }

    public static void a(RefreshType refreshType, List<e> list) {
        list = a("home_collect_refresh", (Collection) list);
        list.add("refresh_type", refreshType.name());
        ThunderReport.reportEvent(list);
    }

    private static StatEvent a(String str, Collection<e> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        StringBuilder stringBuilder5 = new StringBuilder();
        StringBuilder stringBuilder6 = new StringBuilder();
        StringBuilder stringBuilder7 = new StringBuilder();
        StringBuilder stringBuilder8 = new StringBuilder();
        StringBuilder stringBuilder9 = new StringBuilder();
        StringBuilder stringBuilder10 = new StringBuilder();
        if (collection != null) {
            for (e eVar : collection) {
                if (eVar.e()) {
                    stringBuilder9.append(eVar.b());
                    stringBuilder9.append('_');
                } else if (eVar.k == 26) {
                    stringBuilder8.append(eVar.b());
                    stringBuilder8.append('_');
                }
            }
            a(stringBuilder);
            a(stringBuilder2);
            a(stringBuilder3);
            a(stringBuilder4);
            a(stringBuilder);
            a(stringBuilder5);
            a(stringBuilder6);
            a(stringBuilder7);
            a(stringBuilder8);
            a(stringBuilder9);
            a(stringBuilder10);
        }
        return HubbleEventBuilder.build("android_hometab", str).add("kandan_list", stringBuilder.toString()).add("video_new1_list", stringBuilder3.toString()).add("video_new2_list", stringBuilder4.toString()).add("yingshi_list", stringBuilder2.toString()).add("video_mini2_list", stringBuilder5.toString()).add("video_autoplay", stringBuilder6.toString()).add("video_autoplay_sound", stringBuilder7.toString()).add("collect_set", stringBuilder8.toString()).add("video_autoplay_ugc", stringBuilder9.toString()).add("video_autoplay_center", stringBuilder10.toString());
    }

    private static void a(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void b(e eVar, String str) {
        if (eVar != null) {
            String a = a(eVar);
            if (!TextUtils.isEmpty(a)) {
                ThunderReport.reportEvent(HubbleEventBuilder.build("android_hometab", "home_collect_click").add(AgooConstants.MESSAGE_ID, eVar.b()).add("format_type", a).add("areaid", str).add("platformModel", AndroidConfig.getPhoneModel()).add(com.alipay.sdk.app.statistic.c.a, b.c(BrothersApplication.getApplicationInstance())).add("rec_params", eVar.m).add("contentlist", a((a) eVar)));
            }
        }
    }

    public static void a(e eVar, VideoUserInfo videoUserInfo, String str, boolean z, String str2, String str3, int i) {
        String kind = videoUserInfo.getKind();
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_follow_click_result");
        build.add("content_id", eVar.b());
        build.add("author_id", videoUserInfo.getUid());
        build.add("content_type", str);
        build.add("author_type", kind);
        build.add("contentlist", a((a) eVar));
        build.add("login_type", (int) z);
        build.add("result", str2);
        build.add("error", str3);
        build.add("hasanim", i);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3) {
        a(str, str2, str3, null);
    }

    public static void a(boolean z, m mVar, p[] pVarArr, String str) {
        if (pVarArr != null) {
            if (pVarArr.length > 0) {
                StatEvent build = HubbleEventBuilder.build("android_hometab", "collect_defaultdiscuss_show");
                build.add("author_type", mVar.a.getKind());
                StringBuilder stringBuilder = new StringBuilder();
                for (p pVar : pVarArr) {
                    stringBuilder.append(Uri.encode(pVar.a));
                    stringBuilder.append("|");
                }
                a(stringBuilder);
                build.add("wordid", stringBuilder.toString());
                build.add("is_login", (int) z);
                build.add("position", str);
                ThunderReport.reportEvent(build);
            }
        }
    }

    public static String a(a aVar) {
        List list = com.xunlei.downloadprovider.homepage.choiceness.a.a.a(BrothersApplication.getApplicationInstance()).e;
        List arrayList = new ArrayList(1);
        arrayList.add(aVar);
        return a(arrayList, list);
    }

    private static String a(List<? extends a> list, List<? extends a> list2) {
        if (list.isEmpty()) {
            return "";
        }
        List arrayList = new ArrayList();
        for (a aVar : list) {
            HashMap hashMap = new HashMap();
            hashMap.put(AgooConstants.MESSAGE_ID, aVar.b());
            int i = aVar.h;
            if (!(i >= 0 || list2 == null || list2.isEmpty())) {
                i = list2.indexOf(aVar);
            }
            hashMap.put(AgooConstants.MESSAGE_ID, aVar.b());
            hashMap.put("refreshid", aVar.f);
            hashMap.put("position", String.valueOf(aVar.e + 1));
            hashMap.put("refreshnum", String.valueOf(aVar.g));
            hashMap.put("sessionid", com.xunlei.downloadprovider.homepage.choiceness.a.a.a());
            hashMap.put("rn", String.valueOf(i + 1));
            RefreshType refreshType = aVar.j;
            if (refreshType != null) {
                hashMap.put("retype", refreshType.isAutoRefresh() ? NotificationCompat.CATEGORY_SYSTEM : "manual");
            }
            if (aVar instanceof m) {
                m mVar = (m) aVar;
                Object obj = "none";
                if (mVar.b.isFromYouLiaoShot()) {
                    obj = "youliao";
                }
                hashMap.put("transform", obj);
                hashMap.put("replace_times", String.valueOf(mVar.n));
                hashMap.put("tag", mVar.o);
                hashMap.put("rec_params", a(mVar));
            }
            arrayList.add(hashMap);
        }
        return a(arrayList);
    }

    private static String a(List<HashMap<String, String>> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (HashMap hashMap : list) {
            for (String str : hashMap.keySet()) {
                String str2 = (String) hashMap.get(str);
                stringBuilder.append(str);
                stringBuilder.append('=');
                stringBuilder.append(str2);
                stringBuilder.append(',');
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(';');
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return Uri.encode(stringBuilder.toString());
    }

    public static void a(RefreshType refreshType, int i) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_refresh_fail");
        build.add("refresh_type", refreshType.name());
        build.add("nettype", b.c(BrothersApplication.getApplicationInstance()));
        build.add("errorcode", i);
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_zan_click");
        build.add("movieid", eVar.b());
        build.add("content_type", str2);
        str2 = "action";
        if (TextUtils.isEmpty(str)) {
            str = "bottom";
        }
        build.add(str2, str);
        build.add("contentlist", a((a) eVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, String str) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_discuss_click");
        build.add("movieid", eVar.b());
        build.add("contentlist", a((a) eVar));
        build.add("content_type", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, boolean z, String str) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_share_click");
        build.add("movieid", eVar.b());
        build.add("content_type", str);
        build.add("isanim", z ? "yes" : "no");
        build.add("contentlist", a((a) eVar));
        ThunderReport.reportEvent(build);
    }

    public static void b(e eVar, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_share_to");
        build.add("to", str);
        build.add("movieid", eVar.b());
        build.add("content_type", str2);
        build.add("contentlist", a((a) eVar));
        LoginHelper.a();
        build.add("if_login", l.b());
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, String str, String str2, int i, boolean z, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_share_result");
        build.add("to", str);
        build.add("result", str2);
        build.add("errorcode", i);
        build.add("movieid", eVar.b());
        build.add("contentlist", a((a) eVar));
        build.add("content_type", str3);
        LoginHelper.a();
        build.add("if_login", l.b());
        if (eVar.e() != null) {
            eVar = d.a().l;
            if (eVar.d() != null) {
                build.add("shareType", eVar.b() == com.xunlei.downloadprovider.d.b.n.b ? SocializeConstants.KEY_PIC : "link");
            }
        }
        build.add("isanim", z ? "yes" : "no");
        ThunderReport.reportEvent(build);
    }

    public static String a(e eVar) {
        int i = eVar.k;
        if (eVar.e() != null) {
            return "video_autoplay_ugc";
        }
        return i != 26 ? null : "collect_set";
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_icon_click");
        build.add("icon_type", str);
        build.add("content_type", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a(int i, i iVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_caomei_click");
        build.add("type", TextUtils.isEmpty(iVar.z) ? "normal" : "window");
        build.add("area", 1);
        build.add("rn", i);
        build.add("hostid", iVar.a);
        build.add("viewernum", iVar.v);
        build.add("grayid", iVar.o);
        build.add("hosttype", iVar.c);
        build.add("recommend", iVar.q);
        build.add("sign", iVar.y);
        build.add("livestat", iVar.n);
        build.add("roomid", iVar.w);
        build.add("is_gif", TextUtils.isEmpty(iVar.s) ^ 1);
        build.add("contentlist", a((a) iVar));
        build.add("from", iVar.d);
        ThunderReport.reportEvent(build);
    }

    public static void a(int i, int i2, f fVar) {
        if (fVar != null && fVar.a.size() > i2) {
            while (i <= i2) {
                a((g) fVar.a.get(i), (e) fVar, "slide", i);
                i++;
            }
        }
    }

    private static void a(g gVar, e eVar, String str, int i) {
        if (gVar != null) {
            StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_caomei_show");
            build.add("type", str);
            build.add("area", i);
            build.add("hostid", gVar.a);
            build.add("viewernum", gVar.j);
            build.add("grayid", gVar.d);
            build.add("hosttype", gVar.b);
            build.add("recommend", gVar.f);
            build.add("sign", gVar.m);
            build.add("livestat", gVar.c);
            build.add("roomid", gVar.k);
            build.add("is_gif", TextUtils.isEmpty(gVar.h) ^ 1);
            build.add("contentlist", a((a) eVar));
            ThunderReport.reportEvent(build);
        }
    }

    public static void a(int i, int i2, String str, g gVar, e eVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_caomei_click");
        build.add("rn", i);
        build.add("type", str);
        build.add("area", i2);
        build.add("hostid", gVar.a);
        build.add("viewernum", gVar.j);
        build.add("grayid", gVar.d);
        build.add("hosttype", gVar.b);
        build.add("recommend", gVar.f);
        build.add("sign", gVar.m);
        build.add("livestat", gVar.c);
        build.add("roomid", gVar.k);
        build.add("is_gif", TextUtils.isEmpty(gVar.h) ^ 1);
        build.add("contentlist", a((a) eVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(c cVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_news_content_click");
        build.add("news_id", cVar.b());
        build.add("author_id", cVar.a.f);
        List list = cVar.a.e;
        build.add("pictures", list == null ? 1 : list.size());
        build.add("template", cVar.k);
        build.add("rec_params", cVar.m);
        build.add("contentlist", a((a) cVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(com.xunlei.downloadprovider.homepage.choiceness.a.a.d dVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_cinecism_click");
        build.add("cinecism_id", dVar.b());
        build.add("author_id", dVar.a.e);
        build.add("template", dVar.k);
        build.add("rec_params", dVar.m);
        build.add("contentlist", a((a) dVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(n nVar, String str) {
        WebsiteInfo websiteInfo = nVar.a;
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_web_click");
        build.add(AgooConstants.MESSAGE_ID, websiteInfo.a);
        build.add("host", websiteInfo.b);
        build.add("haspic", TextUtils.isEmpty(websiteInfo.g) ? "nopic" : SocializeConstants.KEY_PIC);
        build.add("url", Uri.encode(websiteInfo.f));
        build.add("jump_to", str);
        build.add(Constants.KEY_MODEL, "single_line");
        build.add("contentlist", a((a) nVar));
        build.add("card_type", c);
        build.add("rec_params", b(nVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(o oVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_linksubject_click");
        build.add("linksubject_id", oVar.a);
        build.add("template", oVar.k);
        build.add("rec_params", oVar.m);
        build.add("contentlist", a((a) oVar));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_autoplay_open_volume");
        build.add("movieid", str);
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, VideoUserInfo videoUserInfo, String str, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_follow_click");
        build.add("content_id", eVar.b());
        build.add("author_id", videoUserInfo.getUid());
        build.add("content_type", str);
        build.add("author_type", videoUserInfo.getKind());
        build.add("contentlist", a((a) eVar));
        build.add("login_type", (int) z);
        build.add("is_guide_bar", z2);
        ThunderReport.reportEvent(build);
    }

    private static void c(e eVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_recfollow_show");
        build.add("card_id", eVar.b());
        build.add("contentlist", a((a) eVar));
        if (eVar instanceof com.xunlei.downloadprovider.homepage.choiceness.a.a.l) {
            eVar = ((com.xunlei.downloadprovider.homepage.choiceness.a.a.l) eVar).a;
            if (!(eVar == null || eVar.isEmpty())) {
                List arrayList = new ArrayList();
                int i = 0;
                while (i < eVar.size()) {
                    HashMap hashMap = new HashMap();
                    com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar = (com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a) eVar.get(i);
                    hashMap.put(AgooConstants.MESSAGE_ID, aVar.a);
                    i++;
                    hashMap.put("rn", String.valueOf(i));
                    hashMap.put(DownloadManager.COLUMN_REASON, Uri.encode(aVar.b));
                    arrayList.add(hashMap);
                }
                build.add("recids", a(arrayList));
            }
            ThunderReport.reportEvent(build);
        }
    }

    public static void a(String str, String str2, String str3, @Nullable String str4) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_common_click");
        build.add("movieid", str);
        build.add("clickid", str2);
        build.add("tabid", str3);
        build.add("click_value", str4);
        ThunderReport.reportEvent(build);
    }

    public static void a(List<Long> list, boolean z, String str, String str2) {
        String stringBuilder;
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_rec_followAll_click_result");
        String str3 = "id_list";
        if (list != null) {
            if (!list.isEmpty()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (Long append : list) {
                    stringBuilder2.append(append);
                    stringBuilder2.append('_');
                }
                if (stringBuilder2.length() > null) {
                    stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                }
                stringBuilder = stringBuilder2.toString();
                build.add(str3, stringBuilder);
                build.add("result", str);
                build.add("login_type", (int) z);
                build.add("error", str2);
                ThunderReport.reportEvent(build);
            }
        }
        stringBuilder = "";
        build.add(str3, stringBuilder);
        build.add("result", str);
        build.add("login_type", (int) z);
        build.add("error", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a(boolean z, m mVar, p pVar, String str) {
        if (pVar != null) {
            StatEvent build = HubbleEventBuilder.build("android_hometab", "collect_defaultdiscuss_submit");
            build.add("author_type", mVar.a.getKind());
            build.add("wordid", Uri.encode(pVar.a));
            build.add("is_login", (int) z);
            build.add("position", str);
            ThunderReport.reportEvent(build);
        }
    }

    public static void a(m mVar, p pVar, boolean z, long j, int i) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "collect_discuss_result");
        build.add("result", z ? "success" : "fail");
        build.add("errorcode", i);
        build.add("movieid", mVar.b());
        build.add("new_discussid", j);
        build.add("is_vip", LoginHelper.a().g.e());
        build.add("author_type", mVar.a.getKind());
        build.add("if_default", (int) true);
        build.add("wordid", pVar.a);
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, boolean z, int i, com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_rec_follow_click");
        build.add("is_login", (int) z);
        build.add("hostid", aVar.a);
        build.add("author_type", aVar.c.getKind());
        build.add("groupid", eVar.b());
        build.add("rn", i);
        build.add("recommend_reason", Uri.encode(aVar.b));
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, int i, com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_rec_follow_click_result");
        String str = !z ? "skip_login" : z2 ? "success" : "fail";
        build.add("result", str);
        build.add("hostid", aVar.a);
        build.add("author_type", aVar.c.getKind());
        build.add("groupid", eVar.b());
        build.add("rn", i);
        build.add("recommend_reason", Uri.encode(aVar.b));
        ThunderReport.reportEvent(build);
    }

    public static void a(e eVar, int i, com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_recfollow_head_click");
        build.add("hostid", aVar.a);
        build.add("cardid", eVar.b());
        build.add("rn", i);
        build.add("recommend_reason", Uri.encode(aVar.b));
        ThunderReport.reportEvent(build);
    }

    public static void b(e eVar, int i, com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar) {
        StatEvent build = HubbleEventBuilder.build("android_hometab", "home_collect_recfollow_explode");
        build.add("hostid", aVar.a);
        build.add("cardid", eVar.b());
        build.add("rn", i);
        build.add("recommend_reason", Uri.encode(aVar.b));
        ThunderReport.reportEvent(build);
    }
}
