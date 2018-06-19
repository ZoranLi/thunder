package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class DownloadCenterSelectFileTitleView extends FrameLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private b e;
    private a f;
    private boolean g = true;
    private Animation h = null;
    private Animation i = null;

    public interface a {
        void a();
    }

    public interface b {
        void a(boolean z);
    }

    public DownloadCenterSelectFileTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DownloadCenterSelectFileTitleView(Context context) {
        super(context);
        a(context);
    }

    public DownloadCenterSelectFileTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.download_center_select_file_view, this);
        this.a = (TextView) findViewById(R.id.title);
        this.b = (TextView) findViewById(R.id.cancel);
        this.c = (TextView) findViewById(R.id.select_all);
        this.c.setOnClickListener(new k(this));
        this.d = (TextView) findViewById(R.id.un_select_all);
        this.d.setOnClickListener(new l(this));
        setOnClickListener(new m(this));
        this.h = AnimationUtils.loadAnimation(context, R.anim.title_bar_top_in);
        this.i = AnimationUtils.loadAnimation(context, R.anim.title_bar_top_out);
        this.h.setAnimationListener(new n(this));
        this.i.setAnimationListener(new o(this));
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }

    public final void a(boolean z) {
        if (z) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public void setCancelListener(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setShowListener(a aVar) {
        this.f = aVar;
    }

    public void setSelectAllListener(b bVar) {
        this.e = bVar;
    }

    public final void b(boolean z) {
        this.a.setText(getResources().getString(R.string.download_list_select_title));
        a(true);
        setVisibility(0);
        if (z) {
            startAnimation(this.h);
        }
    }

    public final void c(boolean z) {
        if (z) {
            startAnimation(this.i);
        } else {
            setVisibility(true);
        }
    }
}
