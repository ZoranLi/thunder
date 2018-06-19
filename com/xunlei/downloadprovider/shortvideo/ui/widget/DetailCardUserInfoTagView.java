package com.xunlei.downloadprovider.shortvideo.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;

public class DetailCardUserInfoTagView extends VideoCardUserInfoTagView {
    protected final boolean b() {
        return false;
    }

    protected int getBigVImageResId() {
        return R.drawable.user_info_tag_big_v_3;
    }

    protected int getGenderFemaleImageResId() {
        return R.drawable.user_info_tag_gender_female_3;
    }

    protected int getGenderMaleImageResId() {
        return R.drawable.user_info_tag_gender_male_3;
    }

    protected int getLayoutId() {
        return R.layout.user_info_tag_view_for_video_card;
    }

    protected int getLiveImageResId() {
        return R.drawable.user_info_tag_live_3;
    }

    protected int getYLDaRenImageResId() {
        return R.drawable.user_info_tag_yl_daren_3;
    }

    protected int getYLNanShenImageResId() {
        return R.drawable.user_info_tag_yl_nanshen_3;
    }

    protected int getYLNvShenImageResId() {
        return R.drawable.user_info_tag_yl_nvshen_3;
    }

    public DetailCardUserInfoTagView(Context context) {
        super(context);
    }

    public DetailCardUserInfoTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DetailCardUserInfoTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
