package com.xunlei.downloadprovider.publiser.campaign.a;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.b.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: TopicReporter */
public final class m {
    private static List<n> a = new ArrayList();
    private static Set<n> b = new HashSet();

    public static void a(int i, String str, String str2, String str3, String str4, boolean z) {
        switch (i) {
            case 2:
                a.a(str, str2, str3, str4, z);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str, str2, str3, str4, z);
                return;
            default:
                if (str4.equals("pub") != 0) {
                    str4 = "channel";
                } else if (str4.equals("per") != 0) {
                    str4 = "personal";
                }
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_follow_click");
                build.add("movieid", str);
                build.add("author_id", str2);
                build.add("author_type", str4);
                build.add("login_type", z);
                build.add("tabid", str3);
                a(build);
                return;
        }
    }

    public static void a(int i, String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i2) {
        switch (i) {
            case 2:
                a.a(str, str2, str3, str4, z, str5, str6, i2);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str, str2, str3, str4, z, str5, str6, i2);
                return;
            default:
                if (str4.equals("pub") != 0) {
                    str4 = "channel";
                } else if (str4.equals("per") != 0) {
                    str4 = "personal";
                }
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_follow_click_result");
                build.add("movieid", str);
                build.add("author_id", str2);
                build.add("tabid", str3);
                build.add("author_type", str4);
                build.add("login_type", z);
                build.add("result", str5);
                build.add("error", str6);
                build.add("hasanim", i2);
                a(build);
                return;
        }
    }

    public static void a(int i, boolean z, n nVar, String str) {
        switch (i) {
            case 2:
                a.a(z, nVar, str);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(z, nVar, str);
                return;
            default:
                if (nVar != null) {
                    if (nVar.a == 0) {
                        if (!z || !b.contains(nVar)) {
                            a.add(nVar);
                            b.add(nVar);
                            if (a.size() >= true) {
                                a(i, str);
                            }
                            return;
                        }
                        return;
                    }
                }
                return;
        }
    }

    public static void a(int i) {
        switch (i) {
            case 2:
                a.a();
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a();
                return;
            default:
                b.clear();
                return;
        }
    }

    public static void a(int i, String str) {
        switch (i) {
            case 2:
                a.a(str);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str);
                return;
            default:
                if (a.isEmpty() == 0) {
                    i = new StringBuilder();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (n nVar : a) {
                        if (!TextUtils.isEmpty(nVar.b.getVideoId())) {
                            i.append(nVar.b.getVideoId());
                            i.append('_');
                            stringBuilder.append(nVar.b.isTop() ? "1" : "0");
                            stringBuilder.append('_');
                        }
                    }
                    if (i.length() > 0) {
                        i.deleteCharAt(i.length() - 1);
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_content_show");
                    build.addString("video_collect_video_auto_ugc", i.toString());
                    build.addString("tabid", str);
                    build.add("handtop", stringBuilder.toString());
                    a(build);
                    a.clear();
                    return;
                }
                return;
        }
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(int i, String str, String str2, String str3) {
        switch (i) {
            case 2:
                a.a(str, str3);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str2, str3);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_show");
                str = "from";
                str2 = -1;
                switch (str3.hashCode()) {
                    case -1540660761:
                        if (str3.equals("FOLLOW_TAB") != null) {
                            str2 = 2;
                            break;
                        }
                        break;
                    case -427179481:
                        if (str3.equals("PERSONAL_SPACE") != null) {
                            str2 = true;
                            break;
                        }
                        break;
                    case 75165:
                        if (str3.equals("LBS") != null) {
                            str2 = 4;
                            break;
                        }
                        break;
                    case 2223327:
                        if (str3.equals("HOME") != null) {
                            str2 = 3;
                            break;
                        }
                        break;
                    case 73725445:
                        if (str3.equals("MUSIC") != null) {
                            str2 = 5;
                            break;
                        }
                        break;
                    case 80008463:
                        if (str3.equals("TOPIC") != null) {
                            str2 = 6;
                            break;
                        }
                        break;
                    case 2072392632:
                        if (str3.equals("SHORT_VIDEO_DETAIL") != null) {
                            str2 = null;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (str2) {
                    case null:
                        str2 = "videoDetail";
                        break;
                    case 1:
                        str2 = "shortvideo_usercenter_videotag";
                        break;
                    case 2:
                        str2 = "home_followtab_videotag";
                        break;
                    case 3:
                        str2 = "home_collect_videotopic";
                        break;
                    case 4:
                        str2 = "shortvideo_LBS_videotag";
                        break;
                    case 5:
                        str2 = "shortvideo_music_videotag";
                        break;
                    default:
                        str2 = "shortvideo_topic_videotag";
                        break;
                }
                build.add(str, str2);
                a(build);
                return;
        }
    }

    public static void a(int i, String str, String str2) {
        switch (i) {
            case 2:
                a.b(str, str2);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.b(str, str2);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_content_click");
                build.add("movieid", str);
                build.add("format_type", "video_collect_video_auto_ugc");
                build.add("tabid", str2);
                a(build);
                return;
        }
    }

    public static void a(int i, String str, String str2, String str3, String str4) {
        switch (i) {
            case 2:
                a.a(str, str2, str3, str4);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str, str2, str3, str4);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_zan");
                build.add("movieid", str);
                build.add("author_id", str2);
                build.add("tabid", str3);
                build.add("action", str4);
                a(build);
                return;
        }
    }

    public static void b(int i, String str, String str2, String str3) {
        switch (i) {
            case 2:
                a.a(str, str2, str3);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str, str2, str3);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_discuss_click");
                build.add("movieid", str);
                build.add("author_id", str2);
                build.add("tabid", str3);
                a(build);
                return;
        }
    }

    public static void b(int i, String str, String str2, String str3, String str4) {
        switch (i) {
            case 2:
                a.b(str, str2, str3, str4);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.b(str, str2, str3, str4);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_share_to");
                build.add("to", str4);
                build.add("movieid", str);
                build.add("author_id", str2);
                build.add("tabid", str3);
                a(build);
                return;
        }
    }

    public static void a(int i, String str, String str2, String str3, int i2, String str4, String str5) {
        switch (i) {
            case 2:
                a.a(str, str2, str3, i2, str4, str5);
                return;
            case 3:
                com.xunlei.downloadprovider.publiser.a.a.a(str, str2, str3, i2, str4, str5);
                return;
            default:
                StatEvent build = HubbleEventBuilder.build("android_videoCollect", "videoCollect_share_result");
                build.add("to", str2);
                build.add("result", str3);
                build.add("errorcode", i2);
                build.add("movieid", str);
                build.add("author_id", str4);
                build.add("tabid", str5);
                str = "if_login";
                LoginHelper.a();
                build.add(str, l.b());
                a(build);
                return;
        }
    }
}
