package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.widget.DetailCardUserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.c;

public class ShortMoviePublisherInfoView extends FrameLayout {
    public FollowBtnView a;
    private a b;
    private View c;
    private TextView d;
    private ImageView e;
    private DetailCardUserInfoTagView f;
    private VideoUserInfo g = null;
    private c h = null;
    private View i = null;
    private boolean j = false;
    private int k = 1;

    public ShortMoviePublisherInfoView(@NonNull Context context) {
        super(context);
        a(null);
    }

    public ShortMoviePublisherInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ShortMoviePublisherInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShortMoviePublisherInfoView);
            this.k = attributeSet.getInt(0, 1);
            attributeSet.recycle();
        }
        LayoutInflater.from(getContext()).inflate(this.k == 1 ? R.layout.layout_short_movie_detail_publisher_info : R.layout.layout_short_movie_detail_publisher_info_style_2, this);
        this.c = findViewById(R.id.lyt_channel);
        this.i = findViewById(R.id.line);
        this.e = (ImageView) findViewById(R.id.iv_channel_icon);
        this.d = (TextView) findViewById(R.id.tv_channel_title);
        this.a = (FollowBtnView) findViewById(R.id.btn_follow);
        this.a.setDrawableId(R.drawable.follow_btn_solid_animation_drawable);
        this.f = (DetailCardUserInfoTagView) findViewById(R.id.tv_from_youliao_shot);
        this.e.setOnClickListener(new k(this));
        this.a.setOnClickListener(new l(this));
    }

    public final void a(VideoUserInfo videoUserInfo) {
        this.g = videoUserInfo;
        if (this.g != null) {
            if (TextUtils.isEmpty(this.g.getPortraitUrl()) == null) {
                b.a();
                b.a(this.g.getPortraitUrl(), this.e, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
            }
            this.d.setText(this.g.getNickname());
            if (this.j == null) {
                this.f.setUserInfo(this.g);
            }
        }
    }

    public final void a(c cVar) {
        if (this.j) {
            this.a.setVisibility(8);
            return;
        }
        this.h = cVar;
        if (this.g != null) {
            this.a.setUserInfo(this.g);
            long parseLong = Long.parseLong(this.g.getUid());
            int i = 1;
            cVar = parseLong > 0 ? 1 : null;
            if (parseLong != LoginHelper.a().g.c()) {
                i = 0;
            }
            if ((cVar & i) != null) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
            }
            if (this.h != null) {
                this.a.setEnabled(this.h.c);
            }
        }
    }

    public void setDividerVisibility(int i) {
        if (this.i != null) {
            this.i.setVisibility(i);
        }
    }

    public void setListener(a aVar) {
        this.b = aVar;
    }

    public void setVideoUserInfo(VideoUserInfo videoUserInfo) {
        this.g = videoUserInfo;
    }

    public void setFollowInfo(c cVar) {
        this.h = cVar;
    }

    public void setFromAd(boolean z) {
        this.j = z;
    }

    public void setPublisherNameTextColor(@ColorInt int i) {
        this.d.setTextColor(i);
    }
}
