package com.xunlei.downloadprovider.shortvideo.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;

public class VideoCardUserInfoTagView extends UserInfoTagView {
    protected boolean b() {
        return false;
    }

    protected int getBigVImageResId() {
        return R.drawable.user_info_tag_big_v;
    }

    protected int getGenderFemaleImageResId() {
        return R.drawable.user_info_tag_gender_female;
    }

    protected int getGenderMaleImageResId() {
        return R.drawable.user_info_tag_gender_male;
    }

    protected int getLayoutId() {
        return R.layout.user_info_tag_view_for_video_card;
    }

    protected int getLiveImageResId() {
        return R.drawable.user_info_tag_live;
    }

    protected int getYLDaRenImageResId() {
        return R.drawable.user_info_tag_yl_daren;
    }

    protected int getYLNanShenImageResId() {
        return R.drawable.user_info_tag_yl_nanshen;
    }

    protected int getYLNvShenImageResId() {
        return R.drawable.user_info_tag_yl_nvshen;
    }

    public VideoCardUserInfoTagView(Context context) {
        super(context);
    }

    public VideoCardUserInfoTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoCardUserInfoTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
