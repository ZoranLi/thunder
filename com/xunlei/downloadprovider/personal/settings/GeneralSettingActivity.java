package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.player.a.c;
import com.xunlei.downloadprovider.pushmessage.a.a;
import com.xunlei.xllib.android.XLIntent;

public class GeneralSettingActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {
    private View a;
    private TextView c;
    private RelativeLayout d;
    private CheckBox e;
    private RelativeLayout f;
    private CheckBox g;
    private RelativeLayout h;
    private TextView i;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.settings_general_setting_activity);
        this.a = findViewById(R.id.titlebar_left);
        this.a.setOnClickListener(this);
        this.c = (TextView) findViewById(R.id.titlebar_title);
        this.c.setText(getString(R.string.sett_general));
        new TitleBar((Activity) this).mRight.setVisibility(4);
        this.d = (RelativeLayout) findViewById(R.id.sett_push_layout);
        this.e = (CheckBox) findViewById(R.id.sett_push);
        this.e.setChecked(a.a(this));
        this.d.setOnClickListener(this);
        this.e.setOnCheckedChangeListener(this);
        this.f = (RelativeLayout) findViewById(R.id.sett_nf_sound_layout);
        this.g = (CheckBox) findViewById(R.id.sett_nf_sound);
        this.g.setChecked(SettingStateController.getInstance().isSoundOn());
        this.f.setOnClickListener(this);
        this.g.setOnCheckedChangeListener(this);
        this.h = (RelativeLayout) findViewById(R.id.sett_auto_play_short_video_rl);
        this.i = (TextView) findViewById(R.id.sett_auto_play_option_tv);
        this.h.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.titlebar_left) {
            finish();
        } else if (view == R.id.sett_push_layout) {
            view = this.e.isChecked() ^ 1;
            this.e.setChecked(view);
            a.a(this, view);
            a(view);
        } else if (view != R.id.sett_nf_sound_layout) {
            if (view == R.id.sett_auto_play_short_video_rl) {
                startActivity(new XLIntent(this, AutoPlaySettingActivity.class));
            }
        } else {
            view = this.g.isChecked() ^ 1;
            this.g.setChecked(view);
            SettingStateController.getInstance().setSound(view);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onResume() {
        int i;
        super.onResume();
        TextView textView = this.i;
        switch (c.a().a(c.c)) {
            case 1:
                i = R.string.sett_auto_play_mobile_wifi;
                break;
            case 2:
                i = R.string.sett_auto_play_only_wifi;
                break;
            case 3:
                i = R.string.sett_auto_play_close;
                break;
            default:
                i = -1;
                break;
        }
        textView.setText(i);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void a(boolean z) {
        if (l.b()) {
            if (z) {
                MiPushClient.registerPush(this, "2882303761517301192", "5171730196192");
                Logger.setLogger(this, new m(this));
                return;
            }
            MiPushClient.unregisterPush(getApplicationContext());
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton = compoundButton.getId();
        if (compoundButton != R.id.sett_push) {
            if (compoundButton == R.id.sett_nf_sound) {
                SettingStateController.getInstance().setSound(z);
            }
            return;
        }
        a.a(this, z);
        a(z);
    }
}
