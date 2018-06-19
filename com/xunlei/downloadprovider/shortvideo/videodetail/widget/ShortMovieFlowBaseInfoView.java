package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;

public class ShortMovieFlowBaseInfoView extends FrameLayout {
    public int a = 0;
    public int b = 0;
    public ShortMoviePublisherInfoView c = null;
    public boolean d = false;
    public a e = null;
    private OnLayoutChangeListener f;
    private View g;
    private ShortMovieBaseTitleInfoView h = null;
    private boolean i = true;
    private int j = 0;
    private int k;
    private boolean l = false;

    public interface a {
        void a(boolean z);
    }

    public ShortMovieFlowBaseInfoView(@NonNull Context context) {
        super(context);
        c();
    }

    public ShortMovieFlowBaseInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public ShortMovieFlowBaseInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public final void a(b bVar) {
        this.h.a(bVar);
        if (bVar != null) {
            a(bVar.b());
        }
    }

    public final void a(VideoUserInfo videoUserInfo) {
        this.c.a(videoUserInfo);
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_flow_base_info, this);
        this.h = (ShortMovieBaseTitleInfoView) findViewById(R.id.short_movie_base_title_info_view);
        this.h.setLBSColorMode(2);
        this.h.setTitleTextColor(R.color.white);
        this.h.setTopicColor(R.color.short_movie_flow_base_info_view_topic_color);
        this.c = (ShortMoviePublisherInfoView) findViewById(R.id.short_movie_publisher_info_view);
        this.f = new j(this);
        setVisibility(8);
    }

    public void setListener(com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a aVar) {
        this.h.setListener(aVar);
        this.c.setListener(aVar);
    }

    public ShortMovieBaseTitleInfoView getBaseTitleInfoView() {
        return this.h;
    }

    public ShortMoviePublisherInfoView getPublisherInfoView() {
        return this.c;
    }

    public final void a() {
        this.d = false;
        b();
    }

    public final void b() {
        if (this.g != null) {
            int left = this.g.getLeft();
            int top = this.g.getTop();
            int right = this.g.getRight();
            int bottom = this.g.getBottom();
            if (!this.d) {
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2 = new StringBuilder("onLayoutChange. left: ");
                stringBuilder2.append(left);
                stringBuilder2.append(" top: ");
                stringBuilder2.append(top);
                stringBuilder2.append(" right: ");
                stringBuilder2.append(right);
                stringBuilder2.append(" bottom: ");
                stringBuilder2.append(bottom);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.g.getLayoutParams();
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
                if (Math.abs(marginLayoutParams.topMargin) > 50) {
                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                    new StringBuilder("adjustFlowBaseInfoView. topMargin: ").append(marginLayoutParams.topMargin);
                    requestLayout();
                }
                left = getMeasuredHeight();
                this.j = Math.max(this.j, bottom);
                right = 8;
                if (bottom < this.a) {
                    setY((float) bottom);
                } else if (bottom >= this.b) {
                    setY((float) ((this.a - left) - this.k));
                    setAlpha(1.0f);
                    if (this.i) {
                        right = 0;
                    }
                } else if (this.j <= this.a) {
                    setY((float) bottom);
                } else {
                    float min = (((float) (bottom - this.a)) * 1.0f) / ((float) (Math.min(this.j, this.b) - this.a));
                    setY((float) (((this.a - left) - this.k) - (this.b - bottom)));
                    setAlpha(min);
                    if (this.i) {
                        right = 0;
                    }
                    setVisibility(right);
                    stringBuilder = new StringBuilder("onLayoutChange--finish. top: ");
                    stringBuilder.append(getTop());
                    stringBuilder.append(" bottom: ");
                    stringBuilder.append(getBottom());
                    stringBuilder.append(" y: ");
                    stringBuilder.append(getY());
                }
                setVisibility(right);
                stringBuilder = new StringBuilder("onLayoutChange--finish. top: ");
                stringBuilder.append(getTop());
                stringBuilder.append(" bottom: ");
                stringBuilder.append(getBottom());
                stringBuilder.append(" y: ");
                stringBuilder.append(getY());
            }
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.l != (i == 0)) {
            this.l ^= 1;
            i = this.l;
            if (this.e != null) {
                this.e.a(i);
            }
        }
    }

    public void setOnVisibleChangedListener(a aVar) {
        this.e = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        z = new StringBuilder("onLayout. left: ");
        z.append(i);
        z.append(" top: ");
        z.append(i2);
        z.append(" right: ");
        z.append(i3);
        z.append(" bottom: ");
        z.append(i4);
        z.append(" x: ");
        z.append(getX());
        z.append(" y: ");
        z.append(getY());
        b();
    }

    public void setShow(boolean z) {
        this.i = z;
        b();
    }

    public void setTopAreaView(View view) {
        if (this.g != null) {
            this.g.removeOnLayoutChangeListener(this.f);
        }
        this.g = view;
        this.g.addOnLayoutChangeListener(this.f);
    }

    public void setMarginBottom(int i) {
        this.k = i;
        b();
    }
}
