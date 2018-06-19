package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.LocationInfo;

public class VideoTagView extends FrameLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private String d;
    private String e;

    public VideoTagView(@NonNull Context context) {
        super(context);
        a();
    }

    public VideoTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public VideoTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        if (!isInEditMode()) {
            setVisibility(8);
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.video_tag_view, this);
        this.a = (TextView) inflate.findViewById(R.id.tv_topic);
        this.b = (TextView) inflate.findViewById(R.id.tv_lbs);
        this.c = (TextView) inflate.findViewById(R.id.tv_music);
        if (!isInEditMode()) {
            this.a.setVisibility(8);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
        setLBSColorMode(1);
    }

    public void setLBSColorMode(int i) {
        if (i == 2) {
            setLBSColor(R.color.white);
            setLBSIcon(R.drawable.tag_icon_lbs_white);
            return;
        }
        setLBSColor(R.color.title_topic);
        setLBSIcon(R.drawable.tag_icon_lbs);
    }

    private void setLBSColor(@ColorRes int i) {
        this.b.setTextColor(getResources().getColor(i));
    }

    private void setLBSIcon(@DrawableRes int i) {
        i = getResources().getDrawable(i);
        i.setBounds(0, 0, i.getMinimumWidth(), i.getMinimumHeight());
        this.b.setCompoundDrawables(i, null, null, null);
    }

    public void setFrom(String str) {
        this.d = str;
    }

    public String getFrom() {
        return this.d;
    }

    public void setLbsDetailLocationCode(String str) {
        this.e = str;
    }

    public final void setTags$6ba6a892(LocationInfo locationInfo) {
        if (locationInfo == null || TextUtils.isEmpty(locationInfo.b)) {
            this.b.setVisibility(8);
            locationInfo = null;
        } else {
            this.b.setText(locationInfo.b);
            this.b.setVisibility(0);
            this.b.setOnClickListener(new g(this, locationInfo));
            locationInfo = true;
        }
        if (locationInfo != null) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
