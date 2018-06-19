package com.xunlei.downloadprovider.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cardslide.CardSlideActivity;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.dialog.i;
import com.xunlei.downloadprovider.homepage.follow.ae;

/* compiled from: AppPraiseDlg */
public final class a extends i {
    private static a h;
    private String a;
    private View b = LayoutInflater.from(this.i).inflate(R.layout.dialog_app_praise, null);
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;

    public final int b() {
        return 11;
    }

    private a(Context context, String str) {
        super(context);
        h = this;
        this.a = str;
        setContentView(this.b);
        this.c = (ImageView) this.b.findViewById(R.id.iv_close);
        this.c.setOnClickListener(new b(this));
        context = f.a();
        this.d = (ImageView) findViewById(R.id.iv_title);
        if (TextUtils.isEmpty(context.a) != null) {
            this.d.setImageResource(R.drawable.dialog_app_praise_title_img);
        } else {
            ae.a();
            str = context.a;
            ImageView imageView = this.d;
            Glide.with(imageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.dialog_app_praise_title_img).crossFade(200).into(imageView);
        }
        this.e = (TextView) findViewById(R.id.tv_msg);
        this.e.setText(TextUtils.isEmpty(context.b) ? BrothersApplication.getApplicationInstance().getString(R.string.app_praise_dlg_msg) : context.b);
        this.f = (TextView) this.b.findViewById(R.id.tv_praise);
        this.f.setText(TextUtils.isEmpty(context.d) ? BrothersApplication.getApplicationInstance().getString(R.string.app_praise_btn_text_praise) : context.d);
        this.f.setOnClickListener(new c(this));
        this.g = (TextView) this.b.findViewById(R.id.tv_dislike);
        this.g.setText(TextUtils.isEmpty(context.c) ? BrothersApplication.getApplicationInstance().getString(R.string.app_praise_btn_text_dislike) : context.c);
        this.g.setOnClickListener(new d(this));
        setOnCancelListener(new e(this));
    }

    public final void a() {
        super.a();
        String str = this.a;
        StatEvent build = HubbleEventBuilder.build("android_alert", "alert_guid_show");
        build.add("from", str);
        g.a(build);
    }

    public static void a(Activity activity, long j) {
        if (j != 0 && d()) {
            f a = f.a();
            if (a.e > 0 && ((int) (j / 1024)) >= a.e) {
                new a(activity, "dl_center").show();
            }
        }
    }

    public static void a(Context context, int i) {
        if (!(context instanceof CardSlideActivity) && d()) {
            f a = f.a();
            if (a.g > 0 && i >= a.g) {
                new a(context, "shortvideo_zan").show();
                context = h.a();
                context.d = 0;
                context.a.edit().putInt("like_count", 0).apply();
            }
        }
    }

    public static void a(Context context, long j) {
        if (d()) {
            f a = f.a();
            if (a.f > 0 && j / 60000 >= ((long) a.f)) {
                new a(context, "play_exit").show();
            }
        }
    }

    private static boolean d() {
        if (!d.a().b.l()) {
            return false;
        }
        if (h != null && h.isShowing()) {
            return false;
        }
        h a = h.a();
        if (a.b == -1) {
            a.b = a.a.getInt("is_praised", -1);
        }
        if (a.b == 1) {
            return false;
        }
        f a2 = f.a();
        if (a.c == -1) {
            a.c = a.a.getInt("show_count", 0);
        }
        if (a.c >= a2.i) {
            return false;
        }
        if (a.e == -1) {
            a.e = a.a.getLong("last_show_time", 0);
        }
        if (System.currentTimeMillis() - a.e < ((long) a2.h)) {
            return false;
        }
        return true;
    }
}
