package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class FollowBtnView extends FrameLayout {
    private VideoUserInfo a;
    private ImageView b;
    private a c;
    private aa d = new d(this);

    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        LoginFrom b();
    }

    public FollowBtnView(@NonNull Context context) {
        super(context);
        b();
    }

    public FollowBtnView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public FollowBtnView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.short_video_card_follow_btn_view, this);
        this.b = (ImageView) findViewById(R.id.follow_btn);
    }

    public void setDrawableId(int i) {
        this.b.setBackgroundResource(i);
    }

    public final void a() {
        if (this.b.isEnabled() && (this.b.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.b.getBackground();
            animationDrawable.stop();
            animationDrawable.start();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.b.setEnabled(z);
    }

    public void setFollowListener(a aVar) {
        this.c = aVar;
        this.b.setOnClickListener(new a(this));
    }

    public void setUserInfo(VideoUserInfo videoUserInfo) {
        this.a = videoUserInfo;
        videoUserInfo = videoUserInfo.getUid();
        boolean isEmpty = TextUtils.isEmpty(videoUserInfo);
        if (!isEmpty) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            if (videoUserInfo.equals(stringBuilder.toString())) {
                setVisibility(8);
                return;
            }
        }
        boolean z = false;
        if (isEmpty) {
            videoUserInfo = null;
        } else {
            videoUserInfo = b.a().b(Long.valueOf(videoUserInfo).longValue());
        }
        if (videoUserInfo == null) {
            z = true;
        }
        setEnabled(z);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ab.a().b(this.d);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            ab.a().a(this.d);
        }
        if (this.a == 0 || this.a.isFollowed() == 0) {
            this.b.setEnabled(true);
        } else {
            this.b.setEnabled(false);
        }
    }

    static /* synthetic */ void a(FollowBtnView followBtnView, VideoUserInfo videoUserInfo) {
        followBtnView.setEnabled(false);
        b.a().a(Long.parseLong(videoUserInfo.getUid()), true, new b(followBtnView));
    }
}
