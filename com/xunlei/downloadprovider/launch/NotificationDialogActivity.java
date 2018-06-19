package com.xunlei.downloadprovider.launch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.pushmessage.b.b;
import com.xunlei.xllib.android.XLIntent;

public class NotificationDialogActivity extends FragmentActivity implements OnClickListener {
    private int a = 1;

    public static void a(Context context, int i) {
        Intent xLIntent = new XLIntent(context, NotificationDialogActivity.class);
        xLIntent.putExtra("dialog_type", i);
        xLIntent.addFlags(268435456);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.a = getIntent().getIntExtra("dialog_type", 0);
        if (this.a == null) {
            setContentView(R.layout.layout_dialognotification_open_setting);
            findViewById(R.id.noti_root_view).setOnClickListener(new c(this));
            bundle = getWindow();
            bundle.setGravity(80);
            bundle.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = bundle.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            bundle.setAttributes(attributes);
            return;
        }
        setContentView(R.layout.xl_alert_dialog);
        findViewById(R.id.dlg_cancel_btn).setOnClickListener(this);
        findViewById(R.id.dlg_confirm_btn).setOnClickListener(this);
        ((TextView) findViewById(R.id.dlg_content)).setText(getResources().getText(R.string.noti_open_dialog_content));
    }

    public void onClick(android.view.View r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = r5.getId();
        r0 = 2131886519; // 0x7f1201b7 float:1.940762E38 double:1.05329189E-314;
        if (r5 == r0) goto L_0x008c;
    L_0x0009:
        r0 = 2131886521; // 0x7f1201b9 float:1.9407623E38 double:1.053291891E-314;
        if (r5 == r0) goto L_0x0010;
    L_0x000e:
        goto L_0x008b;
    L_0x0010:
        r5 = com.xunlei.downloadprovider.h.l.e();
        r0 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        if (r5 == 0) goto L_0x004d;
    L_0x0018:
        r5 = new android.content.Intent;
        r1 = "android.intent.action.MAIN";
        r5.<init>(r1);
        r1 = "android.intent.category.LAUNCHER";
        r5.addCategory(r1);
        r5.addFlags(r0);
        r1 = "pkg_name";
        r2 = r4.getPackageName();
        r5.putExtra(r1, r2);
        r1 = "app_name";
        r2 = r4.getResources();
        r3 = 2131362016; // 0x7f0a00e0 float:1.83438E38 double:1.053032751E-314;
        r2 = r2.getString(r3);
        r5.putExtra(r1, r2);
        r1 = "com.coloros.notificationmanager/.AppDetailPreferenceActivity";
        r1 = android.content.ComponentName.unflattenFromString(r1);
        r5.setComponent(r1);
        r4.startActivity(r5);	 Catch:{ Throwable -> 0x004d }
        goto L_0x0075;
    L_0x004d:
        r5 = new java.lang.StringBuilder;
        r1 = "package:";
        r5.<init>(r1);
        r1 = r4.getPackageName();
        r5.append(r1);
        r5 = r5.toString();
        r5 = android.net.Uri.parse(r5);
        r1 = new com.xunlei.xllib.android.XLIntent;
        r2 = "android.settings.APPLICATION_DETAILS_SETTINGS";
        r1.<init>(r2, r5);
        r5 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r1.addFlags(r5);
        r1.addFlags(r0);
        r4.startActivity(r1);
    L_0x0075:
        r5 = new android.os.Handler;
        r5.<init>();
        r0 = new com.xunlei.downloadprovider.launch.d;
        r0.<init>(r4);
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r5.postDelayed(r0, r1);
        r5 = 1;
        com.xunlei.downloadprovider.launch.guide.k.a(r5);
        r4.finish();
    L_0x008b:
        return;
    L_0x008c:
        r5 = 0;
        com.xunlei.downloadprovider.launch.guide.k.a(r5);
        r4.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.launch.NotificationDialogActivity.onClick(android.view.View):void");
    }

    public void finish() {
        super.finish();
        if (this.a == 1) {
            LaunchActivity.c = true;
            b.a().a("push_notification_tips_time", b.a().b("push_notification_tips_time", 0) + 1);
        }
    }
}
