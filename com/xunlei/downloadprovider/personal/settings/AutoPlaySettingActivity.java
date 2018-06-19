package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.player.a.c;
import com.xunlei.downloadprovider.publiser.per.br;

public class AutoPlaySettingActivity extends BaseActivity {
    private TitleBar a;
    private RadioGroup c;
    private RadioButton d;
    private RadioButton e;
    private RadioButton f;
    private int g = -1;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_auto_play_setting);
        this.a = new TitleBar((Activity) this);
        this.a.mTitle.setText(getResources().getString(R.string.sett_auto_play_short_video));
        this.c = (RadioGroup) findViewById(R.id.rg_auto_play_setting);
        this.d = (RadioButton) findViewById(R.id.rb_auto_play_mobile_wifi);
        this.e = (RadioButton) findViewById(R.id.rb_auto_play_only_wifi);
        this.f = (RadioButton) findViewById(R.id.rb_auto_play_close);
        this.g = c.a().a(c.c);
        switch (this.g) {
            case 1:
                this.d.setChecked(true);
                break;
            case 2:
                this.e.setChecked(true);
                break;
            case 3:
                this.f.setChecked(true);
                break;
            default:
                break;
        }
        this.a.mTitle.setOnClickListener(new i(this));
        this.c.setOnCheckedChangeListener(new j(this));
    }

    static /* synthetic */ void a(int i) {
        switch (i) {
            case 1:
            case 2:
                br.a(br.a);
                return;
            case 3:
                br.a(br.b);
                break;
            default:
                break;
        }
    }
}
