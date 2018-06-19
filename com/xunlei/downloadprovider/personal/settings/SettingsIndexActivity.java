package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.user.f;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.xllib.android.b;

public class SettingsIndexActivity extends BaseActivity implements OnClickListener {
    private static final String a = "SettingsIndexActivity";
    private TitleBar c;
    private View d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private View i;
    private View j;
    private View k;
    private TextView l;
    private View m;
    private View n;
    private ViewGroup o;
    private LinearLayout p;
    private XLAlertDialog q;
    private View r;
    private View s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frame_settings_index_fragment);
        this.c = new TitleBar((Activity) this);
        this.c.mLeft.setVisibility(0);
        this.c.mTitle.setText(R.string.setting);
        this.c.mLeft.setOnClickListener(new y(this));
        this.n = findViewById(R.id.sdcard_chooser_layout);
        this.n.setOnClickListener(this);
        this.d = findViewById(R.id.sett_network_check);
        this.e = findViewById(R.id.sett_network_check_layout);
        this.f = findViewById(R.id.sett_room_clean);
        this.g = findViewById(R.id.sett_room_clean_layout);
        this.h = (TextView) findViewById(R.id.tv_size);
        this.i = findViewById(R.id.sett_task_layout);
        this.i.setOnClickListener(this);
        this.p = (LinearLayout) findViewById(R.id.sett_feedback_layout);
        this.p.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.j = findViewById(R.id.sett_general_layout);
        this.j.setOnClickListener(this);
        this.k = findViewById(R.id.sett_more_layout);
        this.k.setOnClickListener(this);
        this.m = findViewById(R.id.sett_logout_layout);
        this.r = findViewById(R.id.sett_logout_layout_out);
        LoginHelper.a();
        if (l.c() != null) {
            this.m.setVisibility(0);
            this.r.setVisibility(0);
            this.m.setOnClickListener(this);
        } else {
            this.m.setVisibility(8);
            this.r.setVisibility(8);
        }
        this.l = (TextView) findViewById(R.id.sett_more_tips);
        bundle = getString(R.string.sett_about_xl);
        TextView textView = this.l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle);
        stringBuilder.append("5.60.2.5510");
        textView.setText(stringBuilder.toString());
        this.o = (ViewGroup) findViewById(R.id.bt_sett_about_check_update_layout);
        this.s = findViewById(R.id.tv_new);
        this.o.setOnClickListener(new z(this));
        this.o.setVisibility(0);
        if (Beta.getUpgradeInfo() != null) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        XLThreadPool.sendCommand(new w(this), new x(this));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sdcard_chooser_layout:
                ChooseDownloadSDCardActivity.a((Context) this);
                return;
            case R.id.sett_task_layout:
                f.a("download");
                startActivity(new Intent(this, TaskSettingActivity.class));
                return;
            case R.id.sett_general_layout:
                f.a("com/xunlei/downloadprovider/ad/common");
                startActivity(new Intent(this, GeneralSettingActivity.class));
                return;
            case R.id.sett_network_check_layout:
            case R.id.sett_network_check:
                f.a("net_test");
                q.a().a(this, "com.xunlei.plugin.speeddetector", new aa(this));
                return;
            case R.id.sett_room_clean_layout:
            case R.id.sett_room_clean:
                f.a("cache");
                RoomCleanActivity.a(getBaseContext(), "per_conf");
                return;
            case R.id.sett_more_layout:
                startActivity(new Intent(this, AboutBoxActivity.class));
                return;
            case R.id.sett_logout_layout:
                f.a("logout");
                if (this.q != null) {
                    try {
                        if (this.q.isShowing() != null) {
                            this.q.dismiss();
                        }
                        this.q = null;
                    } catch (View view2) {
                        view2.printStackTrace();
                    }
                }
                if ((this instanceof Activity) != null) {
                    this.q = new XLAlertDialog(this);
                    this.q.setTitle((CharSequence) "退出登录");
                    this.q.setConfirmButtonText((CharSequence) "退出");
                    this.q.setCancelButtonText((CharSequence) "取消");
                    this.q.setMessage((CharSequence) "退出登录后，您将不能进行评论、无法享受云端服务，确认退出？");
                    this.q.setOnClickConfirmButtonListener(new ab(this, this));
                    this.q.setOnClickCancelButtonListener(new ac(this));
                    this.q.show();
                    break;
                }
                break;
            default:
                break;
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    static /* synthetic */ void b(SettingsIndexActivity settingsIndexActivity) {
        if (b.a(settingsIndexActivity)) {
            Beta.checkUpgrade(true, false);
        } else {
            XLToast.showToast(settingsIndexActivity.getApplicationContext(), settingsIndexActivity.getString(R.string.sett_no_net), 2);
        }
    }

    static /* synthetic */ void c() {
        int taskNum = SettingStateController.getInstance().getTaskNum();
        int d = d.a().h.d();
        if (taskNum > d) {
            n.a();
            n.a(d);
        }
    }
}
