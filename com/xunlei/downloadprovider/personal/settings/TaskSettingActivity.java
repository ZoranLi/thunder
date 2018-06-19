package com.xunlei.downloadprovider.personal.settings;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.list.banner.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

public class TaskSettingActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {
    public static final String a = "TaskSettingActivity";
    private TextView c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private RelativeLayout h;
    private CheckBox i;
    private CheckBox j;
    private View k;
    private CheckBox l;
    private View m;
    private View n;
    private CheckBox o;
    private int p;
    private View q;
    private CheckBox r;

    static /* synthetic */ void a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onCreate(android.os.Bundle r3) {
        /*
        r2 = this;
        super.onCreate(r3);
        r3 = 2130968660; // 0x7f040054 float:1.754598E38 double:1.0528384073E-314;
        r2.setContentView(r3);
        r3 = 2131886974; // 0x7f12037e float:1.9408542E38 double:1.0532921147E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.TextView) r3;
        r2.c = r3;
        r3 = r2.c;
        r0 = 2131362858; // 0x7f0a042a float:1.8345508E38 double:1.053033167E-314;
        r3.setText(r0);
        r3 = 2131886972; // 0x7f12037c float:1.9408538E38 double:1.0532921137E-314;
        r3 = r2.findViewById(r3);
        r2.d = r3;
        r3 = r2.d;
        r3.setOnClickListener(r2);
        r3 = new com.xunlei.common.commonview.TitleBar;
        r3.<init>(r2);
        r3 = r3.mRight;
        r0 = 4;
        r3.setVisibility(r0);
        r3 = 2131886627; // 0x7f120223 float:1.9407838E38 double:1.053291943E-314;
        r3 = r2.findViewById(r3);
        r2.e = r3;
        r3 = r2.e;
        r3.setOnClickListener(r2);
        r3 = 2131886629; // 0x7f120225 float:1.9407842E38 double:1.053291944E-314;
        r3 = r2.findViewById(r3);
        r2.f = r3;
        r3 = r2.f;
        r3.setOnClickListener(r2);
        r3 = 2131886628; // 0x7f120224 float:1.940784E38 double:1.0532919437E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.TextView) r3;
        r2.g = r3;
        r3 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r3 = r3.getTaskNum();
        r2.p = r3;
        r3 = r2.p;
        if (r3 <= 0) goto L_0x0075;
    L_0x006a:
        r3 = r2.p;
        com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e();
        if (r3 <= r0) goto L_0x0081;
    L_0x0075:
        r3 = 3;
        r2.p = r3;
        r3 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r0 = r2.p;
        r3.setTaskNum(r0);
    L_0x0081:
        r3 = r2.g;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r2.p;
        r0.append(r1);
        r0 = r0.toString();
        r3.setText(r0);
        r3 = 2131886630; // 0x7f120226 float:1.9407844E38 double:1.0532919447E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.RelativeLayout) r3;
        r2.h = r3;
        r3 = 2131886631; // 0x7f120227 float:1.9407846E38 double:1.053291945E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.CheckBox) r3;
        r2.i = r3;
        r3 = 2131886633; // 0x7f120229 float:1.940785E38 double:1.053291946E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.CheckBox) r3;
        r2.j = r3;
        r3 = 2131886632; // 0x7f120228 float:1.9407848E38 double:1.0532919457E-314;
        r3 = r2.findViewById(r3);
        r2.k = r3;
        r3 = r2.i;
        r3.setOnCheckedChangeListener(r2);
        r3 = r2.h;
        r3.setOnClickListener(r2);
        r3 = r2.i;
        r0 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r0 = r0.getAutoApkInstall();
        r3.setChecked(r0);
        r3 = r2.j;
        r3.setOnCheckedChangeListener(r2);
        r3 = r2.k;
        r3.setOnClickListener(r2);
        r3 = r2.j;
        r0 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r0 = r0.getAutoApkDelete();
        r3.setChecked(r0);
        r3 = 2131886640; // 0x7f120230 float:1.9407865E38 double:1.0532919497E-314;
        r3 = r2.findViewById(r3);
        r2.m = r3;
        r3 = 2131886642; // 0x7f120232 float:1.9407869E38 double:1.0532919506E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.CheckBox) r3;
        r2.l = r3;
        r3 = com.xunlei.downloadprovider.download.a.b.b.a;
        r3 = r2.l;
        r0 = 8;
        r3.setVisibility(r0);
        r3 = r2.m;
        r3.setVisibility(r0);
        r3 = 2131886634; // 0x7f12022a float:1.9407852E38 double:1.0532919467E-314;
        r3 = r2.findViewById(r3);
        r2.n = r3;
        r3 = 2131886636; // 0x7f12022c float:1.9407856E38 double:1.0532919477E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.CheckBox) r3;
        r2.o = r3;
        r3 = r2.o;
        r1 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r1 = r1.getAutoHighSpeedChannel();
        r3.setChecked(r1);
        r3 = r2.n;
        r3.setOnClickListener(r2);
        r3 = r2.o;
        r3.setOnCheckedChangeListener(r2);
        r3 = 2131886637; // 0x7f12022d float:1.9407858E38 double:1.053291948E-314;
        r3 = r2.findViewById(r3);
        r2.q = r3;
        r3 = 2131886639; // 0x7f12022f float:1.9407863E38 double:1.053291949E-314;
        r3 = r2.findViewById(r3);
        r3 = (android.widget.CheckBox) r3;
        r2.r = r3;
        r3 = r2.r;
        r1 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r1 = r1.getAutoSyncToLixianSpaceFlag();
        r3.setChecked(r1);
        r3 = r2.r;
        r3.setOnCheckedChangeListener(r2);
        com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r3 = com.xunlei.downloadprovider.member.login.b.l.c();
        if (r3 == 0) goto L_0x0179;
    L_0x0168:
        r3 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r3 = r3.l();
        if (r3 != 0) goto L_0x0179;
    L_0x0172:
        r3 = r2.q;
        r0 = 0;
        r3.setVisibility(r0);
        return;
    L_0x0179:
        r3 = r2.q;
        r3.setVisibility(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.settings.TaskSettingActivity.onCreate(android.os.Bundle):void");
    }

    public void onResume() {
        super.onResume();
        b();
        new Handler().postDelayed(new ad(this), 50);
        a aVar = b.a;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sett_task_num_minus:
                if (this.p - 1 > null) {
                    this.p--;
                    this.g.setText(String.valueOf(this.p));
                }
                b();
                return;
            case R.id.sett_task_num_plus:
                view = this.p + 1;
                d.a();
                if (view <= d.e()) {
                    this.p++;
                    this.g.setText(String.valueOf(this.p));
                }
                b();
                return;
            case R.id.sett_auto_install_layout:
                this.i.setChecked(this.i.isChecked() ^ 1);
                return;
            case R.id.sett_delete_packet_layout:
                this.j.setChecked(this.j.isChecked() ^ 1);
                return;
            case R.id.auto_accerate:
                this.o.setChecked(this.o.isChecked() ^ 1);
                return;
            case R.id.sett_ignore_battery_optimizations_layout:
                view = b.a;
                break;
            case R.id.titlebar_left:
                onBackPressed();
                return;
            default:
                break;
        }
    }

    private void b() {
        if (this.p <= 1) {
            this.e.setEnabled(false);
        } else {
            this.e.setEnabled(true);
        }
        d.a();
        int e = d.e();
        if (this.p >= e) {
            this.f.setEnabled(false);
        } else {
            this.f.setEnabled(true);
        }
        if (this.p <= e && this.p > 0) {
            n.a();
            n.a(this.p);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.sett_auto_install:
                SettingStateController.getInstance().setAutoApkInstallState(z);
                return;
            case R.id.sett_delete_packet:
                SettingStateController.getInstance().setAutoApkDelete(z);
                return;
            case R.id.sett_auto_accerate:
                SettingStateController.getInstance().setAutoHighSpeedChannel(z);
                if (z) {
                    LoginHelper.a();
                    if (l.b() != null && (LoginHelper.a().l() != null || LoginHelper.a().g.g > 0)) {
                        n.a();
                        n.g();
                        return;
                    }
                }
                break;
            case R.id.sett_auto_sync_to_lixian_space:
                SettingStateController.getInstance().setAutoSyncToLixianSpaceFlag(z);
                return;
            case R.id.sett_ignore_battery_optimizations_switch:
                compoundButton = b.a;
                break;
            default:
                break;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        i = b.a;
    }

    public void onPause() {
        try {
            if (this.p != SettingStateController.getInstance().getTaskNum()) {
                SettingStateController.getInstance().setTaskNum(this.p);
                n.a();
                n.a(this.p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }
}
