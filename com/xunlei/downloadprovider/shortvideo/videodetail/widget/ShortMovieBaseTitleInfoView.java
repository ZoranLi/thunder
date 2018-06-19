package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.VideoTagView;
import com.xunlei.downloadprovider.publiser.campaign.p;
import com.xunlei.downloadprovider.shortvideo.entity.AudioInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.LocationInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;

public class ShortMovieBaseTitleInfoView extends LinearLayout {
    private TextView a;
    private ImageView b;
    private VideoTagView c;
    private View d;
    private boolean e = false;
    private boolean f = false;
    private b g;
    private a h;
    private boolean i;
    private int j;
    @ColorInt
    private int k = p.a;

    public ShortMovieBaseTitleInfoView(@NonNull Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public ShortMovieBaseTitleInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ShortMovieBaseTitleInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        this.i = false;
        this.j = 2;
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShortMovieBaseTitleInfoView);
            this.i = attributeSet.getBoolean(0, false);
            this.j = attributeSet.getInt(1, 2);
            attributeSet.recycle();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_base_title_info, this);
        setOrientation(1);
        this.a = (TextView) findViewById(R.id.tv_title);
        this.b = (ImageView) findViewById(R.id.iv_toggle_title);
        this.d = findViewById(R.id.lyt_base_info);
        this.c = (VideoTagView) findViewById(R.id.video_tag_view);
        this.c.setFrom("SHORT_VIDEO_DETAIL");
        if (this.i != null) {
            this.a.getViewTreeObserver().addOnPreDrawListener(new g(this));
            this.b.setOnClickListener(new h(this));
            this.a.setOnClickListener(new i(this));
            this.b.setRotation(0.0f);
            this.b.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
    }

    public final void a(b bVar) {
        this.g = bVar;
        this.e = false;
        if (this.i) {
            this.a.setMaxLines(Integer.MAX_VALUE);
            this.b.setRotation(0.0f);
        } else {
            this.a.setMaxLines(this.j);
        }
        TextView textView = this.a;
        BaseVideoInfo a = this.g.a();
        Object title = a.getTitle();
        AudioInfo audioInfo = a.getAudioInfo();
        if (TextUtils.isEmpty(title) && audioInfo == null) {
            textView.setVisibility(8);
        } else {
            p.a(textView, title, audioInfo, "SHORT_VIDEO_DETAIL", this.k);
            textView.setVisibility(0);
        }
        this.g.a().getTitle();
        bVar = this.c;
        p.a();
        LocationInfo locationInfo = this.g.a().getLocationInfo();
        this.g.a().getAudioInfo();
        bVar.setTags$6ba6a892(locationInfo);
    }

    public void setListener(a aVar) {
        this.h = aVar;
    }

    public void setTitleTextColor(@ColorRes int i) {
        this.a.setTextColor(getResources().getColor(i));
    }

    public void setTopicColor(@ColorRes int i) {
        this.k = getResources().getColor(i);
    }

    public void setLBSColorMode(int i) {
        this.c.setLBSColorMode(i);
    }

    protected void onMeasure(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("onMeasure. heightMode: ");
        stringBuilder.append(MeasureSpec.getMode(i2));
        stringBuilder.append(" heightSize: ");
        stringBuilder.append(MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    static /* synthetic */ void e(ShortMovieBaseTitleInfoView shortMovieBaseTitleInfoView) {
        shortMovieBaseTitleInfoView.b.animate().rotation(shortMovieBaseTitleInfoView.f ? 0.0f : 180.0f);
        shortMovieBaseTitleInfoView.a.setMaxLines(shortMovieBaseTitleInfoView.f ? 2 : Integer.MAX_VALUE);
        shortMovieBaseTitleInfoView.f ^= 1;
    }
}
