package com.xunlei.downloadprovider.vod.recordpublish;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.taobao.accs.AccsClientConfig;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.g.a.b;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.vod.a.a;
import com.xunlei.xllib.android.d;

public class VodPlayerPublishActivity extends BaseActivity implements OnClickListener {
    private static final String a = "VodPlayerPublishActivity";
    private View c;
    private EditText d;
    private TextView e;
    private CheckBox f;
    private View g;
    private String h;
    private a i;
    private SurfaceView j;
    private TextView k;
    private String l = "";
    private String m = "";
    private int n = 0;
    private Handler o;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        setContentView(R.layout.vod_activity_player_publish);
        this.c = findViewById(R.id.title_topic_layout);
        this.d = (EditText) findViewById(R.id.title_edit_text);
        this.e = (TextView) findViewById(R.id.topic_textview);
        this.g = findViewById(R.id.back_btn);
        this.c.setOnClickListener(this);
        findViewById(R.id.back_btn).setOnClickListener(this);
        findViewById(R.id.cancel_btn).setOnClickListener(this);
        findViewById(R.id.publish_btn).setOnClickListener(this);
        findViewById(R.id.topic_textview).setOnClickListener(this);
        this.f = (CheckBox) findViewById(R.id.check_box);
        findViewById(R.id.checkbox_layout).setOnClickListener(this);
        this.j = (SurfaceView) findViewById(R.id.sfv_record_preview);
        this.k = (TextView) findViewById(R.id.tv_error);
        this.k.setVisibility(8);
        this.o = new Handler();
        bundle = new l(this);
        this.d.setFilters(new InputFilter[]{new a(30, bundle)});
        this.d.addTextChangedListener(new m(this));
        this.h = getIntent().getStringExtra("play_url");
        if (TextUtils.isEmpty(this.h)) {
            this.k.setVisibility(0);
            this.k.setText(R.string.tips_preview_open_fail);
            this.k.postDelayed(new h(this), 2000);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new n(this, displayMetrics.heightPixels, d.a(this, 70.0f)));
        a("电影片段", 0);
        b.a("play_record");
    }

    protected void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        this.d.requestFocus();
        this.d.setCursorVisible(true);
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
        this.i = new a(this.j);
        this.i.d = new i(this);
        this.i.e = new j(this);
        b();
    }

    protected void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        if (this.i != null) {
            this.i.b();
            this.i = null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.b();
        }
    }

    private void b() {
        try {
            this.i.a(this.h);
            this.i.c();
            this.i.a();
        } catch (Exception e) {
            e.printStackTrace();
            this.k.setVisibility(0);
            this.k.setText(R.string.tips_preview_open_fail);
        }
    }

    private void c() {
        if (VERSION.SDK_INT >= 19) {
            getWindow().setFlags(67108864, 67108864);
        }
        Point point = new Point();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        defaultDisplay.getSize(point);
        Point point2 = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point2);
        }
        Object obj = point2.y > point.y ? 1 : null;
        if (VERSION.SDK_INT >= 19) {
            if (obj != null) {
                getWindow().getDecorView().setSystemUiVisibility(7430);
                return;
            }
        }
        getWindow().addFlags(128);
        getWindow().setFlags(1024, 1024);
    }

    private static Bundle a(int i) {
        Bundle bundle = new Bundle(9);
        bundle.putInt("Key_Click_Event", i);
        return bundle;
    }

    public void onBackPressed() {
        super.onBackPressed();
        c.a(this, "Action_Broadcast_VodPlayerPublishActivity", a(0));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_topic_layout:
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
                return;
            case R.id.cancel_btn:
                c.a(this, "Action_Broadcast_VodPlayerPublishActivity", a(0));
                b.a("play_record", "cancel", AccsClientConfig.DEFAULT_CONFIGTAG);
                finish();
                return;
            case R.id.publish_btn:
                view = com.xunlei.downloadprovider.d.d.a().i.f();
                if (this.l != null) {
                    this.l = this.l.trim();
                }
                if (view == null || TextUtils.isEmpty(this.l) == null) {
                    view = this.f.isChecked();
                    Bundle a = a(1);
                    a.putString("title", this.l);
                    a.putString("topic", this.m);
                    a.putBoolean("isSaveLocal", view);
                    c.a(this, "Action_Broadcast_VodPlayerPublishActivity", a);
                    b.a("play_record", "publish", "publish");
                    finish();
                    return;
                }
                XLToast.showToast(this, "请输入标题", 1);
                b.a("play_record", "publish", "unpublish");
                return;
            case R.id.topic_textview:
                VodPlayerTopicSelectActivity.a((Activity) this, "");
                b.a("play_record", "tag", AccsClientConfig.DEFAULT_CONFIGTAG);
                return;
            case R.id.checkbox_layout:
                this.f.setChecked(true ^ this.f.isChecked());
                b.a("play_record", "save", this.f.isChecked() != null ? "on" : "off");
                break;
            case R.id.back_btn:
                c.a(this, "Action_Broadcast_VodPlayerPublishActivity", a(0));
                b.a("play_record", "back", AccsClientConfig.DEFAULT_CONFIGTAG);
                finish();
                return;
            default:
                break;
        }
    }

    private void a(String str, int i) {
        this.m = str;
        this.n = i;
        this.e.setText(this.m);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("topic");
            i2 = intent.getIntExtra("ylvalue", -1);
            intent = new StringBuilder("topic : ");
            intent.append(stringExtra);
            intent.append(" ylvalue : ");
            intent.append(i2);
            if (TextUtils.isEmpty(stringExtra) == null) {
                a(stringExtra, i2);
            }
        }
    }

    static /* synthetic */ void a(VodPlayerPublishActivity vodPlayerPublishActivity, int i, int i2) {
        int i3;
        int dimensionPixelSize = vodPlayerPublishActivity.getResources().getDimensionPixelSize(R.dimen.public_video_rect_width_height);
        vodPlayerPublishActivity.getResources().getDimensionPixelSize(R.dimen.public_video_rect_width_height);
        i = ((float) i) / ((float) i2);
        LayoutParams layoutParams = (LayoutParams) vodPlayerPublishActivity.j.getLayoutParams();
        if (i > 1065353216) {
            i3 = (int) (((float) dimensionPixelSize) / i);
        } else {
            dimensionPixelSize = AndroidConfig.getScreenWidth();
            i3 = (int) (((float) dimensionPixelSize) / i);
            if (i3 > AndroidConfig.getScreenHeight()) {
                i3 = AndroidConfig.getScreenHeight();
            }
        }
        if (layoutParams != null) {
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = i3;
            layoutParams.addRule(i > 1065353216 ? 13 : 14);
            vodPlayerPublishActivity.j.setLayoutParams(layoutParams);
        }
        i = vodPlayerPublishActivity.k.getLayoutParams();
        if (i != 0) {
            i.width = dimensionPixelSize;
            i.height = i3;
            vodPlayerPublishActivity.k.requestLayout();
        }
    }
}
