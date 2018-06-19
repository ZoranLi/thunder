package com.xunlei.downloadprovider.homepage.recommend;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.app.statistic.c;
import com.taobao.accs.common.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.f;
import com.xunlei.downloadprovider.publiser.per.model.g;
import com.xunlei.downloadprovider.publiser.per.model.h;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChannelFeedReporter */
public final class a {
    private static Set<g> a = new HashSet();
    private static Set<g> b = new HashSet();

    public static void a(long j, String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("channelflow_discuss_show");
        build.addString("discussid", String.valueOf(j));
        build.addString("movieid", str);
        build.addString("content_type", str2);
        build.addString("author_type", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("channelflow_discuss_result");
        build.addString("discussid", str);
        build.addString("movieid", str2);
        build.addString("content_type", str3);
        build.addString("new_discussid", str4);
        build.add("levle", null);
        build.add("errorcode", str6);
        build.add("result", str5);
        ThunderReport.reportEvent(build);
    }

    public static void a(boolean z, g gVar, String str, String str2, String str3) {
        if (gVar != null) {
            if (!z || (!b.contains(gVar) && !a.contains(gVar))) {
                a.add(gVar);
                b.add(gVar);
                if (a.size() >= true) {
                    c(str, str2, str3);
                }
            }
        }
    }

    public static void a() {
        a.clear();
        b.clear();
    }

    public static void c(String str, String str2, String str3) {
        if (!a.isEmpty()) {
            StatEvent build;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            Collection arrayList = new ArrayList();
            for (g gVar : a) {
                if (gVar instanceof h) {
                    WebsiteInfo websiteInfo = ((h) gVar).a;
                    build = HubbleEventBuilder.build("android_channelflow", "channelflow_web_show");
                    build.add(AgooConstants.MESSAGE_ID, websiteInfo.a);
                    build.add("host", websiteInfo.b);
                    build.add("url", Uri.encode(websiteInfo.f, "UTF-8"));
                    build.add(Constants.KEY_MODEL, "single_line");
                    a(build);
                } else if (gVar instanceof f) {
                    f fVar = (f) gVar;
                    stringBuilder.append("cinecism:");
                    stringBuilder.append(fVar.a.a);
                    stringBuilder.append(',');
                    arrayList.add(fVar);
                } else {
                    PublishVideoFeedInfo publishVideoFeedInfo = (PublishVideoFeedInfo) gVar;
                    stringBuilder.append("video:");
                    stringBuilder.append(publishVideoFeedInfo.getRelatedVideoInfo().getVideoId());
                    stringBuilder.append(',');
                    if (publishVideoFeedInfo.getRelatedVideoInfo().isFromYouLiaoShot()) {
                        stringBuilder2.append(publishVideoFeedInfo.getRelatedVideoInfo().getVideoId());
                        stringBuilder2.append('_');
                    }
                    arrayList.add(publishVideoFeedInfo);
                }
            }
            if (arrayList.size() > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                }
                String c = b.c(BrothersApplication.getApplicationInstance());
                String a = a(arrayList);
                build = HubbleEventBuilder.build("android_channelflow", "channelflow_video_show");
                build.addString("movielist", stringBuilder.toString()).addString("movielist_finish", "");
                build.addString("from", str);
                build.addString("channelflow_id", str2);
                build.addString("platformModel", AndroidConfig.getPhoneModel());
                build.addString(c.a, c);
                build.addString("rec_params", a);
                build.add("formattype", 1);
                build.add("author_type", str3);
                build.add("tabid", "publish");
                build.add("transform_list", stringBuilder2.toString());
                a(build);
            }
            a.clear();
        }
    }

    private static String a(Collection<g> collection) {
        if (collection.isEmpty()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (g gVar : collection) {
            if (gVar instanceof PublishVideoFeedInfo) {
                Map hashMap = new HashMap();
                hashMap.put("movieid", ((PublishVideoFeedInfo) gVar).getRelatedVideoInfo().getVideoId());
                hashMap.put("params", "");
                jSONArray.put(new JSONObject(hashMap));
            }
        }
        return jSONArray.toString();
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void b() {
        if (a != null) {
            a.clear();
        }
    }

    public static void a(String str, String str2, long j) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_space_show");
        build.addString("from", str);
        str = "author_type";
        if (str2 == null) {
            str2 = "";
        }
        build.addString(str, str2);
        build.addLong("chanelflow_id", j);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_zan");
        build.add("movieid", str);
        build.add("content_type", str2);
        build.add("author_type", str3);
        build.add("tabid", str4);
        build.add("action", str5);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_discuss_click");
        build.add("movieid", str);
        build.add("author_type", str2);
        build.add("content_type", str3);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_share_to");
        build.add("to", str3);
        build.add("movieid", str);
        build.add("content_type", str2);
        build.add("position", str4);
        build.add("author_type", str5);
        build.add("tabid", str6);
        build.add("share_type", "source");
        LoginHelper.a();
        build.add("if_login", l.b());
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_share_result");
        build.add("to", str3);
        build.add("result", str4);
        build.add("errorcode", i);
        build.add("movieid", str);
        build.add("content_type", str2);
        build.add("position", str5);
        build.add("tabid", str7);
        build.add("author_type", str6);
        build.add("share_type", "source");
        LoginHelper.a();
        build.add("if_login", l.b());
        a(build);
    }

    public static void a(String str, long j, String str2, int i, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_follow_click");
        build.addString("position", str);
        build.addString("channelflow_id", String.valueOf(j));
        build.addString(AgooConstants.MESSAGE_ID, str2);
        build.addString("login_type", String.valueOf(i));
        build.addString("author_type", str3);
        build.add("tabid", str4);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, long j, int i, String str2, String str3, String str4, String str5, int i2) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_follow_click_result");
        build.addString("position", str);
        build.addString("channelflow_id", String.valueOf(j));
        build.addString("login_type", String.valueOf(i));
        build.addString("result", str2);
        build.addString("error", str3);
        build.addString("author_type", str4);
        if (TextUtils.isEmpty(str5) == null) {
            build.add("tabid", str5);
        }
        build.add("hasanim", i2);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, long j, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_unfollow_choose_click");
        build.addString("position", str);
        build.addString("channelflow_id", String.valueOf(j));
        build.addString("clickid", str2);
        build.addString("author_type", str3);
        if (TextUtils.isEmpty(str4) == null) {
            build.add("tabid", str4);
        }
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, long j, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_unfollow_click");
        build.addString("position", str);
        build.addString("channelflow_id", String.valueOf(j));
        build.addString("author_type", str2);
        if (TextUtils.isEmpty(str3) == null) {
            build.add("tabid", str3);
        }
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, long j, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_common_click");
        build.addString("clickid", str);
        build.addString("author_type", str2);
        build.addString("tabid", str3);
        build.addString("discussid", String.valueOf(j));
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_common_click");
        build.addString("clickid", str);
        build.addString("xl_id", str2);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_common_click");
        build.addString("clickid", str);
        build.addString("author_type", str2);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_common_click");
        build.addString("clickid", str);
        build.addString("author_type", str2);
        build.addString("tabid", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, int i, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_video_click");
        build.add("movieid", str);
        build.add("format_type", i);
        build.add("content_type", str2);
        build.add("author_type", str3);
        build.add("tabid", str4);
        build.add("active_type", str5);
        a(build);
    }

    public static void a(String str, boolean z, long j) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_space_tab_show");
        build.add("tabid", str);
        build.add("content", z ? "empty" : "content");
        build.add("num", j);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "report_page_show");
        String str5 = "from";
        if (TextUtils.isEmpty(str)) {
            str = DispatchConstants.OTHER;
        }
        build.add(str5, str);
        build.add("uid", str2);
        build.add(AgooConstants.MESSAGE_ID, str3);
        build.add("content_type", str4);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "report_page_report");
        build.add(DownloadManager.COLUMN_REASON, str3);
        build.add("uid", str);
        build.add(AgooConstants.MESSAGE_ID, str2);
        build.add("content_type", str4);
        a(build);
    }

    public static void a(WebsiteInfo websiteInfo, String str) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_web_click");
        build.add(AgooConstants.MESSAGE_ID, websiteInfo.a);
        build.add("host", websiteInfo.b);
        build.add("url", Uri.encode(websiteInfo.f, "UTF-8"));
        build.add(Constants.KEY_MODEL, "single_line");
        build.add("jump_to", str);
        a(build);
    }

    public static void d(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_share_to");
        build.add("to", str);
        build.add("author_type", o.a(str3));
        build.add("uid", str2);
        build.add("share_type", "personal_space");
        a(build);
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_share_result");
        build.add("to", str);
        build.add("result", str2);
        build.add("errorcode", i);
        build.add("author_type", o.a(str4));
        LoginHelper.a();
        build.add("if_login", l.b());
        build.add("uid", str3);
        build.add("share_type", "personal_space");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "follow_fun_list");
        build.add("from", str);
        a(build);
    }

    public static void a(long j, String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "follow_fun_follow_click");
        build.add("content_id", 0);
        build.add("author_id", j);
        build.add("content_type", null);
        build.add("author_type", str);
        build.add("login_type", i);
        build.add("is_guide_bar", 0);
        a(build);
    }

    public static void a(long j, String str, int i, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "follow_fun_follow_click_result");
        build.add("content_id", 0);
        build.add("author_id", j);
        build.add("content_type", null);
        build.add("author_type", str);
        build.add("login_type", i);
        build.add("result", str2);
        build.add("error", str3);
        a(build);
    }

    public static void a(long j, String str) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "followvisitor_list_show");
        build.add("hostid", j);
        build.add("from", str);
        a(build);
    }

    public static void a(long j, boolean z, String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "followvisitor_follow_click_result");
        build.add("author_id", j);
        build.add("login_type", z);
        build.add("result", str);
        build.add("from", str3);
        if (TextUtils.isEmpty(str2) == null) {
            build.add("error", str2);
        }
        a(build);
    }

    public static void c(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "followvisitor_lost_item");
        build.add("error", str);
        build.add("from", str2);
        a(build);
    }

    public static void e(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_video_delete");
        build.add("movieid", str);
        build.add("author_type", str2);
        build.add("content_type", str3);
        a(build);
    }

    public static void f(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_channelflow", "channelflow_video_delete_sure");
        build.add("movieid", str);
        build.add("author_type", str2);
        build.add("content_type", str3);
        a(build);
    }
}
