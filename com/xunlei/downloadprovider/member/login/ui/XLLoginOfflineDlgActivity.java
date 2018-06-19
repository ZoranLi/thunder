package com.xunlei.downloadprovider.member.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.dialog.XLBaseDialogActivity;
import com.xunlei.downloadprovider.dialog.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.xllib.android.XLIntent;

public class XLLoginOfflineDlgActivity extends XLBaseDialogActivity {
    public static int a = -1;
    d c = new ap(this);
    private XLAlertDialog d;
    private LoginHelper e = LoginHelper.a();

    protected final int a() {
        return 7;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new XLAlertDialog(this);
        if (c() != null) {
            this.d.setOnCancelListener(new ak(this));
        }
        bundle = getIntent();
        int intExtra = bundle.getIntExtra("error_type", 2);
        this.d.setTitle("掉线通知");
        this.d.setMessage(intExtra == 1 ? "您的帐号已在其他设备登录，当前帐号已掉线，请重新登录。" : "由于出现异常，您的帐号已掉线，建议重新登录继续享受各项服务。");
        this.d.setCanceledOnTouchOutside(false);
        switch (bundle.getIntExtra("type", 1)) {
            case 1:
                this.d.setOnClickConfirmButtonListener(new al(this));
                break;
            case 2:
                this.d.setOnClickConfirmButtonListener(new am(this));
                break;
            default:
                break;
        }
        this.d.setOnClickCancelButtonListener(new an(this));
        this.d.setOnCancelListener(new ao(this));
        this.d.setConfirmButtonText("重新登录");
        this.d.setCancelButtonText("退出登录");
    }

    protected void onResume() {
        super.onResume();
        this.e.a(this.c);
        this.d.show();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.e.b(this.c);
    }

    private static boolean c() {
        return com.xunlei.downloadprovider.d.d.a().e.a();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public static void a(Context context, int i, int i2) {
        if (!a.a().a(7)) {
            return;
        }
        if (AppStatusChgObserver.b().a) {
            Intent xLIntent = new XLIntent();
            xLIntent.setClass(context, XLLoginOfflineDlgActivity.class);
            xLIntent.addFlags(268435456);
            xLIntent.putExtra("type", i);
            xLIntent.putExtra("error_type", i2);
            context.startActivity(xLIntent);
            ai.a(HubbleEventBuilder.build("android_user_login", "login_try_alert"));
            return;
        }
        a = i;
    }

    public static void a(Context context) {
        a(context, 1, 2);
    }

    private static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_user_login", "login_try_click");
        build.add("clickid", str);
        ai.a(build);
    }

    static /* synthetic */ void b(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        if (c()) {
            xLLoginOfflineDlgActivity.e.a(LoginPageType.LOGIN_PAGE, (Context) xLLoginOfflineDlgActivity, null, LoginFrom.FORCE_LOGIN, -1, null);
            return;
        }
        xLLoginOfflineDlgActivity.e.a(null);
        i.j();
        xLLoginOfflineDlgActivity.finish();
        b("0");
    }
}
