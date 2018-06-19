package com.xunlei.downloadprovider.personal.lixianspace;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayAction;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXBtFileExplorerActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateBtTaskActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateTaskByMagnetUrlActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateUrlTaskActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LixianSpaceH5Activity;

/* compiled from: LXSpaceHelper */
public final class a {
    public static void a(Context context, String str, PayAction payAction) {
        PayEntryParam payEntryParam = new PayEntryParam(PayFrom.LIXIAN_SPACE);
        if (!TextUtils.isEmpty(str)) {
            payEntryParam.d = str;
        }
        if (j.a().d() == 204) {
            payAction = new PayAction(PayUtil$OrderType.UPGRADE);
        }
        if (payAction != null) {
            payEntryParam.e = payAction;
        }
        PaymentEntryActivity.a(context, payEntryParam);
    }

    public static boolean a() {
        return d.a().h.g();
    }

    public static int b() {
        boolean l = j.a().a.l();
        int d = j.a().d();
        int m = j.a().a.m();
        boolean e = j.a().e();
        if (!l) {
            d = 0;
        }
        return com.xunlei.downloadprovider.personal.lixianspace.expansion.a.a.b(d, m, e);
    }

    public static int c() {
        boolean l = j.a().a.l();
        int d = j.a().d();
        int m = j.a().a.m();
        boolean e = j.a().e();
        if (!l) {
            d = 0;
        }
        int b = com.xunlei.downloadprovider.personal.lixianspace.expansion.a.a.b(d, m, e);
        if (d == 5) {
            e = true;
        }
        d = com.xunlei.downloadprovider.personal.lixianspace.expansion.a.a.b(5, m, e) - b;
        if (d > 0) {
            return d;
        }
        return 0;
    }

    public static void a(Context context) {
        if (a()) {
            Activity c = AppStatusChgObserver.b().c();
            Object obj = null;
            if (c != null) {
                Class cls = c.getClass();
                if (LXSpaceActivity.class.isAssignableFrom(cls) || LXSpaceCreateUrlTaskActivity.class.isAssignableFrom(cls) || LXBtFileExplorerActivity.class.isAssignableFrom(cls) || LXSpaceCreateTaskByMagnetUrlActivity.class.isAssignableFrom(cls) || LXSpaceCreateBtTaskActivity.class.isAssignableFrom(cls)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                LXSpaceActivity.a(context);
            }
            return;
        }
        LixianSpaceH5Activity.a(context);
    }

    public static boolean d() {
        j.a();
        return l.b() && a() && j.a().a.l();
    }
}
