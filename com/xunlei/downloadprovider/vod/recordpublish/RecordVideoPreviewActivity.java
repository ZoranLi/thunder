package com.xunlei.downloadprovider.vod.recordpublish;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.vod.a.a;
import com.xunlei.xllib.android.b;

public class RecordVideoPreviewActivity extends BaseActivity implements OnClickListener {
    private static final String a = "RecordVideoPreviewActivity";
    private a c;
    private String d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private SurfaceView i;
    private Handler j;
    private CardView k;
    private View l;
    private int m = 0;
    private int n;
    private p o = new g(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(16777216);
        setContentView(R.layout.activity_record_video_preview);
        this.k = (CardView) findViewById(R.id.fyt_surface_parent);
        this.l = findViewById(R.id.upload_button);
        this.l.setOnClickListener(this);
        if (l.a().f() == null) {
            this.l.setVisibility(8);
        }
        if (VERSION.SDK_INT >= 21) {
            this.k.setElevation((float) DipPixelUtil.dip2px(26.0f));
        }
        this.i = (SurfaceView) findViewById(R.id.sfv_record_preview);
        this.c = new a(this.i);
        DipPixelUtil.dip2px(60.0f);
        this.e = (TextView) findViewById(R.id.cancel);
        this.e.setOnClickListener(this);
        this.g = (TextView) findViewById(R.id.tv_save);
        this.g.setOnClickListener(this);
        this.h = (TextView) findViewById(R.id.tv_duration);
        this.f = (TextView) findViewById(R.id.tv_error);
        this.f.setVisibility(8);
        this.j = new b(this);
        this.n = getResources().getInteger(R.integer.max_record_time) * 1000;
        this.d = getIntent().getStringExtra("play_url");
        if (TextUtils.isEmpty(this.d) != null) {
            this.f.setVisibility(0);
            this.f.setText(R.string.tips_preview_open_fail);
            this.f.postDelayed(new f(this), 2000);
        }
        this.c.d = new c(this);
        this.c.e = new d(this);
        b();
        com.xunlei.downloadprovider.download.player.a.b(this);
    }

    protected void onResume() {
        super.onResume();
        getWindow().addFlags(128);
        if (!(this.c == null || this.c.d())) {
            this.c.a();
        }
        this.j.removeMessages(1234);
        this.j.sendEmptyMessage(1234);
    }

    protected void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        if (this.c != null && this.c.d()) {
            a aVar = this.c;
            aVar.c = false;
            if (aVar.a != null && aVar.a.isPlaying()) {
                aVar.a.pause();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.b();
        }
        if (this.j != null) {
            this.j.removeMessages(1234);
        }
    }

    private void b() {
        try {
            this.c.a(this.d);
            this.c.c();
            this.c.a();
            c();
            this.j.removeMessages(1234);
            this.j.sendEmptyMessage(1234);
        } catch (Exception e) {
            e.printStackTrace();
            this.f.setVisibility(0);
            this.f.setText(R.string.tips_preview_open_fail);
        }
    }

    private void c() {
        if (this.c != null) {
            if (this.c.d()) {
                a aVar;
                int duration;
                int i = 0;
                if (this.m <= 0) {
                    aVar = this.c;
                    duration = (aVar.a == null || !aVar.b) ? 0 : aVar.a.getDuration();
                    this.m = duration;
                    new StringBuilder("mDuration : ").append(a(this.m));
                }
                aVar = this.c;
                if (aVar.a != null && aVar.b) {
                    i = aVar.a.getCurrentPosition();
                }
                duration = this.m > this.n ? this.n : this.m;
                i = (int) ((((float) i) / ((float) this.m)) * ((float) duration));
                String a = a(duration);
                String a2 = a(i);
                TextView textView = this.h;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a2);
                stringBuilder.append("/");
                stringBuilder.append(a);
                textView.setText(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder("durationStr : ");
                stringBuilder2.append(a);
                stringBuilder2.append(" positionStr : ");
                stringBuilder2.append(a2);
            }
        }
    }

    private String a(int i) {
        if (i < 0) {
            return getString(R.string.preview_time_default);
        }
        i /= 1000;
        int i2 = i / DateTimeUtil.HOUR_SECOND;
        int i3 = (i / 60) % 60;
        i %= 60;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        if (i2 > 0 && i2 < 10) {
            stringBuilder.append(0);
        }
        if (i3 < 10) {
            stringBuilder2.append(0);
        }
        if (i < 10) {
            stringBuilder3.append(0);
        }
        if (i2 > 0) {
            stringBuilder.append(i2);
        }
        stringBuilder2.append(i3);
        stringBuilder3.append(i);
        if (i2 > 0) {
            return String.format(getString(R.string.vod_time_format), new Object[]{stringBuilder, stringBuilder2.toString(), stringBuilder3.toString()});
        }
        return String.format(getString(R.string.preview_time_format), new Object[]{stringBuilder2.toString(), stringBuilder3.toString()});
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
        Bundle bundle = new Bundle(1);
        bundle.putInt("Key_Click_Event", 0);
        c.a(this, "Action_Broadcast_RecordVideoPreviewActivity", bundle);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.cancel) {
            switch (view) {
                case R.id.tv_save:
                    view = new Bundle(1);
                    view.putInt("Key_Click_Event", 1);
                    c.a(this, "Action_Broadcast_RecordVideoPreviewActivity", view);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                case R.id.upload_button:
                    if (b.a(this) == null) {
                        XLToast.showToast(this, "无网络连接");
                    } else if (r.a().a(this, LoginFrom.SHORTVIDEO_RECORD_PUBLISH, this.o) == null) {
                        d();
                    }
                    view = new Bundle(1);
                    view.putInt("Key_Click_Event", 2);
                    c.a(this, "Action_Broadcast_RecordVideoPreviewActivity", view);
                    break;
                default:
                    break;
            }
            return;
        }
        onBackPressed();
    }

    private void d() {
        Intent intent = new Intent(this, VodPlayerPublishActivity.class);
        intent.putExtra("play_url", this.d);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    static /* synthetic */ void a(RecordVideoPreviewActivity recordVideoPreviewActivity, int i, int i2) {
        int dimensionPixelSize = recordVideoPreviewActivity.getResources().getDimensionPixelSize(R.dimen.preview_rect_width);
        int dimensionPixelSize2 = recordVideoPreviewActivity.getResources().getDimensionPixelSize(R.dimen.preview_rect_height);
        i = (((float) i) * 1065353216) / ((float) i2);
        i2 = (float) dimensionPixelSize;
        float f = (float) dimensionPixelSize2;
        if (i > (1.0f * i2) / f) {
            dimensionPixelSize2 = (int) (i2 / i);
        } else {
            dimensionPixelSize = (int) (f * i);
        }
        i = recordVideoPreviewActivity.k.getLayoutParams();
        if (i != 0) {
            i.width = dimensionPixelSize;
            i.height = dimensionPixelSize2;
            recordVideoPreviewActivity.k.requestLayout();
        }
    }
}
