package com.xunlei.downloadprovider.personal.user.account;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.o;

/* compiled from: UserAccountReporter */
public final class k {
    public static String a(int i) {
        return i != 15 ? i != 21 ? "weibo" : Token.WX_TOKEN_PLATFORMID_VALUE : Constants.SOURCE_QQ;
    }

    public static void a(String str, String str2) {
        StatEvent build;
        int hashCode = str.hashCode();
        if (hashCode != 379101630) {
            if (hashCode == 397730471) {
                if (str.equals("account_center") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            build = HubbleEventBuilder.build("android_personal_account", "account_head_conf_click");
                            break;
                        case 1:
                            build = HubbleEventBuilder.build("android_personal_account", "register_head_conf_click");
                            break;
                        default:
                            build = null;
                            break;
                    }
                    if (build == null) {
                        build.add("source", str2);
                        a(build);
                    }
                }
            }
        } else if (str.equals("phone_register_login") != null) {
            str = true;
            switch (str) {
                case null:
                    build = HubbleEventBuilder.build("android_personal_account", "account_head_conf_click");
                    break;
                case 1:
                    build = HubbleEventBuilder.build("android_personal_account", "register_head_conf_click");
                    break;
                default:
                    build = null;
                    break;
            }
            if (build == null) {
                build.add("source", str2);
                a(build);
            }
        }
        str = -1;
        switch (str) {
            case null:
                build = HubbleEventBuilder.build("android_personal_account", "account_head_conf_click");
                break;
            case 1:
                build = HubbleEventBuilder.build("android_personal_account", "register_head_conf_click");
                break;
            default:
                build = null;
                break;
        }
        if (build == null) {
            build.add("source", str2);
            a(build);
        }
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build;
        int hashCode = str.hashCode();
        if (hashCode != 379101630) {
            if (hashCode == 397730471) {
                if (str.equals("account_center") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            build = HubbleEventBuilder.build("android_personal_account", "account_head_change_result");
                            break;
                        case 1:
                            build = HubbleEventBuilder.build("android_personal_account", "register_head_change_result");
                            break;
                        default:
                            build = null;
                            break;
                    }
                    if (build == null) {
                        build.add("source", str2);
                        build.add("result", str3);
                        a(build);
                    }
                }
            }
        } else if (str.equals("phone_register_login") != null) {
            str = true;
            switch (str) {
                case null:
                    build = HubbleEventBuilder.build("android_personal_account", "account_head_change_result");
                    break;
                case 1:
                    build = HubbleEventBuilder.build("android_personal_account", "register_head_change_result");
                    break;
                default:
                    build = null;
                    break;
            }
            if (build == null) {
                build.add("source", str2);
                build.add("result", str3);
                a(build);
            }
        }
        str = -1;
        switch (str) {
            case null:
                build = HubbleEventBuilder.build("android_personal_account", "account_head_change_result");
                break;
            case 1:
                build = HubbleEventBuilder.build("android_personal_account", "register_head_change_result");
                break;
            default:
                build = null;
                break;
        }
        if (build == null) {
            build.add("source", str2);
            build.add("result", str3);
            a(build);
        }
    }

    public static void b(String str, String str2) {
        StatEvent build;
        int hashCode = str.hashCode();
        if (hashCode != 379101630) {
            if (hashCode == 397730471) {
                if (str.equals("account_center") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            build = HubbleEventBuilder.build("android_personal_account", "account_name_change_result");
                            break;
                        case 1:
                            build = HubbleEventBuilder.build("android_personal_account", "register_name_change_result");
                            break;
                        default:
                            build = null;
                            break;
                    }
                    if (build == null) {
                        build.add("result", str2);
                        a(build);
                    }
                }
            }
        } else if (str.equals("phone_register_login") != null) {
            str = true;
            switch (str) {
                case null:
                    build = HubbleEventBuilder.build("android_personal_account", "account_name_change_result");
                    break;
                case 1:
                    build = HubbleEventBuilder.build("android_personal_account", "register_name_change_result");
                    break;
                default:
                    build = null;
                    break;
            }
            if (build == null) {
                build.add("result", str2);
                a(build);
            }
        }
        str = -1;
        switch (str) {
            case null:
                build = HubbleEventBuilder.build("android_personal_account", "account_name_change_result");
                break;
            case 1:
                build = HubbleEventBuilder.build("android_personal_account", "register_name_change_result");
                break;
            default:
                build = null;
                break;
        }
        if (build == null) {
            build.add("result", str2);
            a(build);
        }
    }

    public static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "register_name_gender_next");
        build.add("result", z ? "success" : "fail");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_birth_change_result");
        build.add("result", str);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_sign_change_result");
        build.add("result", str);
        a(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_place_change_result");
        build.add("result", str);
        a(build);
    }

    public static void c(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_gender_change_result");
        build.add("result", str);
        if (str.equals("success") != null) {
            build.add("gender", str2);
        }
        a(build);
    }

    public static void d(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_pwd_change_result");
        build.add("result", str);
        a(build);
    }

    public static void a(int i, String str, int i2) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_third_bind_result");
        build.add("account_type", a(i));
        build.add("result", str);
        build.add("errorcode", i2);
        a(build);
    }

    public static void b(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_phone_conf");
        build.add("is_bind", z);
        ThunderReport.reportEvent(build);
    }

    public static void a(boolean z, String str, String str2, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_safety_phone_finish");
        build.add("is_bind", z);
        build.add("from", str);
        build.add("result", str2);
        build.add("errorCode", i);
        ThunderReport.reportEvent(build);
    }

    public static void e(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_certification_show");
        if (TextUtils.isEmpty(str)) {
            build.add("from", LoginHelper.a().d ? "auto_login" : "manual_login");
        } else {
            build.add("from", str);
        }
        build.add("type", o.c(str) == 2 ? "force" : "recommend");
        a(build);
    }

    public static void a(String str, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_certification_cancel");
        build.add("from", str);
        build.add("type", z ? "force" : "recommend");
        a(build);
    }

    public static void a(boolean z, String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_certification_get_code");
        build.add("result", z ? "success" : "fail");
        build.add("errorcode", str);
        a(build);
    }

    public static void a(String str, String str2, boolean z, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_certification_result");
        build.add("result", z ? "success" : "fail");
        build.add("errorcode", str3);
        build.add("phone", str2);
        build.add("type", o.c(str) == true ? "force" : "recommend");
        a(build);
    }

    public static void c(boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_personal_account", "account_certification_force_pop_click");
        build.add("button", z ? "logout" : "cancel");
        a(build);
    }
}
