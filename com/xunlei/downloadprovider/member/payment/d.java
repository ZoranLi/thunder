package com.xunlei.downloadprovider.member.payment;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;

/* compiled from: PayReporter */
public final class d {
    private static long a = System.currentTimeMillis();
    private static String b = "";

    /* compiled from: PayReporter */
    public static class a {
        public String a = "0";
        public int b = 0;
        public String c = "";
        public String d = "";
    }

    private static int a(boolean z, int i) {
        return (i == Integer.MAX_VALUE && z) ? -2 : i;
    }

    private static int c(int i) {
        if (i == 204) {
            return 5;
        }
        switch (i) {
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            default:
                return 0;
        }
    }

    private static String d(int i) {
        return i == 1 ? "alipay" : i == 2 ? "wechart" : "";
    }

    public static void a() {
        a = System.currentTimeMillis();
    }

    public static void a(String str) {
        ThunderReport.reportEvent(g("pay_show").add("aidfrom", b).add("vip_from", str));
    }

    public static void a(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2) {
        ThunderReport.reportEvent(g("pay_show_fail").add("errorcode", str).add("default_product_type", c(i)).add("default_product", b(payUtil$OrderType)).add("tab_type", i2));
    }

    public static void a(int i, PayUtil$OrderType payUtil$OrderType, boolean z, String str, int i2) {
        Object obj = payUtil$OrderType == PayUtil$OrderType.UPGRADE ? 1 : null;
        i = g("pay_back").add("aidfrom", b).add("default_product_type", c(i)).add("default_product", b(payUtil$OrderType)).add("default_auto_pay", z);
        z = true;
        i = i.add("default_month", obj != null ? -1 : i2);
        payUtil$OrderType = "default_day";
        if (obj != null) {
            z = i2;
        }
        ThunderReport.reportEvent(i.add(payUtil$OrderType, z).add("vip_from", str));
    }

    public static void b(String str) {
        ThunderReport.reportEvent(g("pay_backAlert_show").add("aidfrom", b).add("activity_type", -1).add("vip_from", str));
    }

    public static void a(String str, boolean z) {
        ThunderReport.reportEvent(g("pay_backAlert_click").add("aidfrom", b).add("activity_type", -1).add("clickid", z).add("vip_from", str));
    }

    public static void a(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2, int i3, PayUtil$OrderType payUtil$OrderType2, int i4, float f, String str2, int i5, boolean z, String str3, int i6, boolean z2, long j) {
        int i7;
        int i8;
        boolean z3 = z;
        int i9 = 1;
        PayUtil$OrderType payUtil$OrderType3 = payUtil$OrderType2;
        int i10 = payUtil$OrderType3 == PayUtil$OrderType.UPGRADE ? 1 : 0;
        int i11 = -1;
        StatEvent add = g("pay_submit").add("aidfrom", b).add("vip_from", str).add("default_product_type", c(i)).add("default_month", i10 != 0 ? -1 : i2).add("default_day", i10 != 0 ? i2 : -1).add("default_product", b(payUtil$OrderType)).add("isrenew", a(payUtil$OrderType3)).add("product_type", c(i3));
        String str4 = "month";
        if (i10 != 0) {
            i7 = i4;
            i8 = -1;
        } else {
            i7 = i4;
            i8 = a(z3, i7);
        }
        add = add.add(str4, i8);
        str4 = "day";
        if (i10 == 0) {
            i7 = -1;
        }
        StatEvent add2 = add.add(str4, i7).add("amount", PayUtil.a(f)).add("version", str2);
        String str5 = "voucher";
        if (i5 > 0) {
            i11 = i5;
        }
        StatEvent add3 = add2.add(str5, i11).add("pay_auto", z3);
        String str6 = "act_info";
        str5 = i5 > 0 ? "99" : TextUtils.isEmpty(str3) ? "0" : str3;
        add3 = add3.add(str6, str5);
        str6 = "is_join_act";
        if (i5 <= 0) {
            i9 = i6;
        }
        ThunderReport.reportEvent(add3.add(str6, i9).add("taskid", j).add("default_auto_pay", z2));
    }

    public static void a(String str, int i, float f) {
        String str2 = "alipay";
        if (i == 2) {
            str2 = "wechart";
        }
        ThunderReport.reportEvent(g("pay_type_click").add("aidfrom", b).add("vip_from", str).add("pay_channel", str2).add("amount", PayUtil.a(f)));
    }

    public static void a(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2, int i3, float f, String str2, int i4, int i5, PayUtil$OrderType payUtil$OrderType2, int i6, boolean z, a aVar, long j) {
        int i7;
        int i8;
        boolean z2 = z;
        a aVar2 = aVar == null ? new a() : aVar;
        int i9 = 1;
        PayUtil$OrderType payUtil$OrderType3 = payUtil$OrderType;
        int i10 = payUtil$OrderType3 == PayUtil$OrderType.UPGRADE ? 1 : 0;
        StatEvent add = g("pay_success").add("pay_sessonid", a).add("aidfrom", b).add("vip_from", str).add("isrenew", a(payUtil$OrderType3)).add("product_type", c(i));
        String str3 = "month";
        int i11 = -1;
        if (i10 != 0) {
            i7 = i2;
            i8 = -1;
        } else {
            i7 = i2;
            i8 = a(z2, i7);
        }
        add = add.add(str3, i8);
        str3 = "day";
        if (i10 == 0) {
            i7 = -1;
        }
        StatEvent add2 = add.add(str3, i7).add("default_product_type", c(i4)).add("default_product", b(payUtil$OrderType2)).add("default_month", i10 != 0 ? -1 : i5).add("default_day", i10 != 0 ? i5 : -1).add("pay_channel", d(i3)).add("amount", PayUtil.a(f)).add("version", str2);
        String str4 = "voucher";
        if (i6 > 0) {
            i11 = i6;
        }
        StatEvent add3 = add2.add(str4, i11).add("pay_auto", z2);
        String str5 = "act_info";
        str4 = i6 > 0 ? "99" : TextUtils.isEmpty(aVar2.a) ? "0" : aVar2.a;
        add3 = add3.add(str5, str4);
        str5 = "is_join_act";
        if (i6 <= 0) {
            i9 = aVar2.b;
        }
        ThunderReport.reportEvent(add3.add(str5, i9).add("taskid", j));
    }

    public static void a(int i) {
        ThunderReport.reportEvent(g("pay_successPage_show").add("is_hongbao", 0).add("remaindays", com.xunlei.downloadprovider.personal.a.f.a.a(LoginHelper.a().o())).add("is_phone_bind", i));
    }

    public static void c(String str) {
        ThunderReport.reportEvent(g("pay_successPage_click").add("remaindays", com.xunlei.downloadprovider.personal.a.f.a.a(LoginHelper.a().o())).add("clickid", str));
    }

    public static void a(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2, int i3, int i4, int i5, String str2, String str3, boolean z) {
        int i6;
        Object obj = payUtil$OrderType == PayUtil$OrderType.UPGRADE ? 1 : null;
        i = g("pay_fail").add("pay_sessonid", a).add("aidfrom", b).add("isrenew", a(payUtil$OrderType)).add("product_type", c(i));
        payUtil$OrderType = "month";
        int i7 = -1;
        if (obj != null) {
            i6 = -1;
        } else {
            i6 = a(z, i2);
        }
        i = i.add(payUtil$OrderType, i6);
        payUtil$OrderType = "day";
        if (obj == null) {
            i2 = -1;
        }
        str = i.add(payUtil$OrderType, i2).add("pay_channel", d(i3)).add("vip_from", str).add("failtype", i4);
        i = "voucher";
        if (i5 > 0) {
            i7 = i5;
        }
        str = str.add(i, i7);
        i = "act_info";
        if (i5 > 0) {
            str3 = "99";
        } else if (TextUtils.isEmpty(str3) != null) {
            str3 = "0";
        }
        ThunderReport.reportEvent(str.add(i, str3).add("pay_auto", z).add("version", str2));
    }

    public static void a(int i, PayUtil$OrderType payUtil$OrderType, int i2, int i3, String str, int i4, String str2, boolean z) {
        int i5;
        Object obj = payUtil$OrderType == PayUtil$OrderType.UPGRADE ? 1 : null;
        i = g("pay_cancel").add("pay_sessonid", a).add("aidfrom", b).add("isrenew", a(payUtil$OrderType)).add("product_type", c(i));
        payUtil$OrderType = "month";
        int i6 = -1;
        if (obj != null) {
            i5 = -1;
        } else {
            i5 = a(z, i2);
        }
        i = i.add(payUtil$OrderType, i5);
        payUtil$OrderType = "day";
        if (obj == null) {
            i2 = -1;
        }
        i = i.add(payUtil$OrderType, i2).add("pay_channel", d(i3));
        payUtil$OrderType = "voucher";
        if (i4 > 0) {
            i6 = i4;
        }
        i = i.add(payUtil$OrderType, i6);
        payUtil$OrderType = "act_info";
        if (i4 > 0) {
            str2 = "99";
        } else if (TextUtils.isEmpty(str2) != 0) {
            str2 = "0";
        }
        ThunderReport.reportEvent(i.add(payUtil$OrderType, str2).add("pay_auto", z).add("vip_from", str));
    }

    public static void a(String str, String str2) {
        ThunderReport.reportEvent(g(str).add("aidfrom", b).add("vip_from", str2));
    }

    private static int a(PayUtil$OrderType payUtil$OrderType) {
        switch (e.a[payUtil$OrderType.ordinal()]) {
            case 1:
                return null;
            case 2:
                return 2;
            case 3:
                return 1;
            default:
                return -1;
        }
    }

    private static String b(PayUtil$OrderType payUtil$OrderType) {
        switch (e.a[payUtil$OrderType.ordinal()]) {
            case 1:
                return "开通";
            case 2:
                return "续费";
            case 3:
                return "升级";
            default:
                return "";
        }
    }

    public static void a(String str, int i, PayUtil$OrderType payUtil$OrderType, int i2, int i3, String str2, boolean z, PayUtil$OrderType payUtil$OrderType2) {
        int i4 = 1;
        payUtil$OrderType2 = payUtil$OrderType2 == PayUtil$OrderType.UPGRADE ? 1 : null;
        str = g("pay_show_success").add("aidfrom", b).add("vip_from", str).add("default_product_type", c(i)).add("default_product", b(payUtil$OrderType));
        payUtil$OrderType = -1;
        str = str.add("default_day", payUtil$OrderType2 != null ? i2 : -1);
        i = "default_month";
        if (payUtil$OrderType2 != null) {
            i2 = -1;
        }
        str = str.add(i, i2);
        i = "default_is_join_act";
        if (i3 <= 0) {
            if (TextUtils.isEmpty(str2) != 0) {
                i4 = 0;
            }
        }
        str = str.add(i, i4);
        i = "voucher";
        if (i3 > 0) {
            payUtil$OrderType = i3;
        }
        str = str.add(i, payUtil$OrderType);
        i = "default_act_info";
        if (i3 > 0) {
            str2 = "99";
        } else if (TextUtils.isEmpty(str2) != null) {
            str2 = "0";
        }
        ThunderReport.reportEvent(str.add(i, str2).add("default_auto_pay", z));
    }

    public static void a(int i, int i2) {
        int i3 = 3;
        i = i.b(i) ? 2 : i.a(i) != 0 ? 1 : 3;
        if (i.b(i2)) {
            i3 = 2;
        } else if (i.a(i2) != 0) {
            i3 = 1;
        }
        ThunderReport.reportEvent(g("pay_tab_alter").add("tab", i3).add("default_tab", i));
    }

    public static void b() {
        ThunderReport.reportEvent(g("pay_voucher_click"));
    }

    public static void c() {
        ThunderReport.reportEvent(g("pay_key_click"));
    }

    public static void d() {
        ThunderReport.reportEvent(g("pay_agreement_click"));
    }

    public static void e() {
        ThunderReport.reportEvent(g("pay_key_successPage_show").add("activity_type", -1));
    }

    public static void f() {
        ThunderReport.reportEvent(g("pay_custmer_faq"));
    }

    public static void b(int i) {
        ThunderReport.reportEvent(g("pay_cancel_autopay").add("cancel", i));
    }

    public static void d(String str) {
        ThunderReport.reportEvent(g("pay_savingalert_show").add("aidfrom", b).add("activity_type", -1).add("vip_from", str));
    }

    public static void b(String str, boolean z) {
        ThunderReport.reportEvent(g("pay_savingalert_click").add("aidfrom", b).add("activity_type", -1).add("clickid", z).add("vip_from", str));
    }

    private static StatEvent g(String str) {
        int i;
        str = HubbleEventBuilder.build("android_pay_event_v2", str);
        j.a();
        StatEvent add = str.add("is_login", l.b());
        String str2 = "is_vip";
        j a = j.a();
        if (a.b()) {
            i = a.a.g.h().a;
        } else {
            i = a.a.g.e();
        }
        add.add(str2, i).add("vip_type", j.a().d());
        return str;
    }

    public static void e(String str) {
        ThunderReport.reportEvent(g("continue_month_prompt_click").add("aidfrom", b).add("vip_from", str));
    }

    public static void f(String str) {
        b = str;
    }
}
