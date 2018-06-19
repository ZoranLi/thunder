package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class DownloadCenterBottomView extends FrameLayout {
    private TextView a;
    private TextView b;
    private View c;
    private ImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    private View h;
    private TextView i;
    private ImageView j;
    private Animation k;
    private Animation l;
    private boolean m;

    public DownloadCenterBottomView(Context context) {
        super(context);
        a(context);
    }

    public DownloadCenterBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DownloadCenterBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.download_center_bottom_view, this);
        this.a = (TextView) findViewById(R.id.download_center_bottom_view_title);
        this.b = (TextView) findViewById(R.id.start_task);
        this.d = (ImageView) findViewById(R.id.icon_start);
        this.f = (TextView) findViewById(R.id.pause_tasks);
        this.g = (ImageView) findViewById(R.id.icon_pause);
        this.i = (TextView) findViewById(R.id.delete_tasks);
        this.j = (ImageView) findViewById(R.id.icon_delete);
        this.c = findViewById(R.id.start_contain);
        this.e = findViewById(R.id.pause_contain);
        this.h = findViewById(R.id.delete_contain);
        this.k = AnimationUtils.loadAnimation(context, R.anim.delete_bottom_in);
        this.l = AnimationUtils.loadAnimation(context, R.anim.delete_bottom_out);
        this.k.setAnimationListener(new h(this));
        this.l.setAnimationListener(new i(this));
        setOnClickListener(new g(this));
    }

    public final void a() {
        this.m = true;
        setVisibility(0);
        startAnimation(this.k);
        b();
    }

    public final void a(boolean z) {
        this.m = false;
        if (z) {
            startAnimation(this.l);
        } else {
            setVisibility(true);
        }
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }

    public void setDeleteTasksListener(OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
    }

    public void setPauseTasksListener(OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setStartTasksListener(OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public final void b() {
        this.c.setClickable(false);
        this.h.setClickable(false);
        this.e.setClickable(false);
        this.d.setEnabled(false);
        this.g.setEnabled(false);
        this.j.setEnabled(false);
        this.b.setTextColor(getResources().getColor(R.color.download_list_bottom_disable));
        this.f.setTextColor(getResources().getColor(R.color.download_list_bottom_disable));
        this.i.setTextColor(getResources().getColor(R.color.download_list_bottom_disable));
    }

    public final void c() {
        this.c.setClickable(true);
        this.e.setClickable(true);
        this.h.setClickable(true);
        this.d.setEnabled(true);
        this.g.setEnabled(true);
        this.j.setEnabled(true);
        this.b.setTextColor(getResources().getColor(R.color.download_list_bottom_enable));
        this.f.setTextColor(getResources().getColor(R.color.download_list_bottom_enable));
        this.i.setTextColor(getResources().getColor(R.color.download_list_bottom_enable));
    }
}
