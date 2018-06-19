package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.anim.AnimationManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.create.widget.FileManagerListView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.e.a;
import java.io.File;

public class PathChooserActivity extends BaseActivity {
    protected String a = getClass().getSimpleName();
    private TitleBar c;
    private TextView d;
    private View e;
    private FileManagerListView f;

    public static void a(Activity activity, String str) {
        Intent xLIntent = new XLIntent(activity, PathChooserActivity.class);
        xLIntent.putExtra("path", str);
        activity.startActivity(xLIntent);
        AnimationManager.playStartBottomInAnimation(activity);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.path_chooser_activity);
        this.c = new TitleBar((Activity) this);
        this.c.mLeft.setImageResource(R.drawable.common_close_icon_selector);
        this.c.mLeft.setOnClickListener(new q(this));
        this.c.mTitle.setText(R.string.sett_choose_sdcard);
        this.c.mRightIv.setImageResource(R.drawable.common_add_icon_task_btn_selector);
        this.c.mRightIv.setVisibility(0);
        this.d = (TextView) findViewById(R.id.current_path);
        this.f = (FileManagerListView) findViewById(R.id.file_list);
        this.f.setPathView(this.d);
        this.e = findViewById(R.id.buttom_layout);
        this.f.setOnFileOperateListener(new r(this));
        this.e.setOnClickListener(new s(this));
        bundle = a.a();
        String b = a.b();
        this.f.setJustShowDir(true);
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("path") : null;
        if (stringExtra == null) {
            stringExtra = DownloadConfig.getRealDownloadPath(this);
            if (!stringExtra.endsWith(File.separator)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(stringExtra);
                stringBuilder.append(File.separator);
                stringExtra = stringBuilder.toString();
            }
        }
        if (a(stringExtra)) {
            this.f.setLimitInDirectory(bundle);
        } else {
            this.f.setLimitInDirectory(b);
        }
        this.f.a(stringExtra, null);
        this.f.a();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        Object b = a.b();
        String a = a.a();
        if ((TextUtils.isEmpty(b) || !str.startsWith(b)) && str.startsWith(a) != null) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        if ((this.f.b() ^ 1) != 0) {
            finish();
        }
    }

    public void finish() {
        super.finish();
        AnimationManager.playFinishBottomOutAnimation(this);
    }
}
