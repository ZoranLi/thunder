package com.xunlei.downloadprovider.publiser.visitors.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.common.a.a;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class VisitUserInfoTagView extends UserInfoTagView {
    private TextView e;
    private TextView f;

    protected int getLayoutId() {
        return R.layout.visit_user_info_tag_view;
    }

    public VisitUserInfoTagView(Context context) {
        super(context);
    }

    public VisitUserInfoTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VisitUserInfoTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void a() {
        super.a();
        this.e = (TextView) findViewById(R.id.tv_location);
        this.f = (TextView) findViewById(R.id.tv_kind);
    }

    public void setUserInfo(VideoUserInfo videoUserInfo) {
        if (videoUserInfo == null) {
            setVisibility(8);
            return;
        }
        CharSequence charSequence;
        switch (h.a[videoUserInfo.getGender().ordinal()]) {
            case 1:
                this.b.setImageResource(R.drawable.user_info_tag_gender_male);
                this.b.setVisibility(0);
                break;
            case 2:
                this.b.setImageResource(R.drawable.user_info_tag_gender_female);
                this.b.setVisibility(0);
                break;
            default:
                this.b.setVisibility(8);
                break;
        }
        Object province = videoUserInfo.getProvince();
        String city = videoUserInfo.getCity();
        if (!a.c(province)) {
            province = city;
        }
        if (TextUtils.isEmpty(province)) {
            charSequence = "";
        } else {
            charSequence = a.a(province).replace("市", "");
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(charSequence);
            this.e.setVisibility(0);
        }
        String kind = videoUserInfo.getKind();
        if (videoUserInfo.isAuthPub()) {
            this.f.setBackgroundResource(R.drawable.user_info_tag_v_bg);
            this.f.setText("迅雷号认证");
            setVisibility(0);
        } else if ("rad".equals(kind)) {
            this.f.setBackgroundResource(R.drawable.user_info_tag_live_bg);
            this.f.setText("迅雷主播");
            setVisibility(0);
        } else if ("yl_daren".equals(kind)) {
            this.f.setBackgroundResource(R.drawable.user_info_tag_youliao_bg);
            this.f.setText("有料达人");
            setVisibility(0);
        } else if ("yl_nvshen".equals(kind)) {
            this.f.setBackgroundResource(R.drawable.user_info_tag_youliao_bg);
            this.f.setText("有料女神");
            setVisibility(0);
            this.b.setSelected(true);
        } else if ("yl_nanshen".equals(kind)) {
            this.f.setBackgroundResource(R.drawable.user_info_tag_youliao_bg);
            this.f.setText("有料男神");
            setVisibility(0);
            this.b.setSelected(false);
        } else {
            this.f.setVisibility(8);
        }
        setVip(videoUserInfo);
    }
}
