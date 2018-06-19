package com.xunlei.downloadprovider.publiser.common.view;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

public class UserInfoTagView extends LinearLayout {
    protected ImageView a;
    protected ImageView b;
    protected ImageView c;
    protected TextView d;

    protected boolean b() {
        return true;
    }

    protected int getBigVImageResId() {
        return R.drawable.user_info_tag_big_v_mini;
    }

    @DrawableRes
    protected int getGenderFemaleImageResId() {
        return R.drawable.user_info_tag_gender_female_mini;
    }

    @DrawableRes
    protected int getGenderMaleImageResId() {
        return R.drawable.user_info_tag_gender_male_mini;
    }

    public int getLayoutId() {
        return R.layout.user_info_tag_view;
    }

    protected int getLiveImageResId() {
        return R.drawable.user_info_tag_live_mini;
    }

    protected int getYLDaRenImageResId() {
        return R.drawable.user_info_tag_yl_daren_mini;
    }

    protected int getYLNanShenImageResId() {
        return R.drawable.user_info_tag_yl_nanshen_mini;
    }

    protected int getYLNvShenImageResId() {
        return R.drawable.user_info_tag_yl_nvshen_mini;
    }

    public UserInfoTagView(Context context) {
        super(context);
        a();
    }

    public UserInfoTagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public UserInfoTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a() {
        setGravity(16);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.a = (ImageView) findViewById(R.id.iv_big_v);
        this.b = (ImageView) findViewById(R.id.iv_gender);
        this.c = (ImageView) findViewById(R.id.iv_kind);
        this.d = (TextView) findViewById(R.id.tv_vip);
        if (this.a != null) {
            this.a.setVisibility(8);
            this.a.setImageResource(getBigVImageResId());
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        if (this.c != null) {
            this.c.setVisibility(8);
        }
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        if (this.a != null) {
            this.a.setImageResource(getBigVImageResId());
        }
        setVisibility(0);
    }

    protected void setVip(VideoUserInfo videoUserInfo) {
        videoUserInfo = videoUserInfo.getVipInfo();
        if (videoUserInfo.a) {
            TextView textView = this.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(videoUserInfo.b);
            textView.setText(stringBuilder.toString());
            videoUserInfo = videoUserInfo.b();
            if (videoUserInfo == 1) {
                this.d.setBackgroundResource(R.drawable.ic_super_vip_level);
            } else if (videoUserInfo == 2) {
                this.d.setBackgroundResource(R.drawable.ic_kuainiao_vip_level);
            } else {
                this.d.setBackgroundResource(R.drawable.ic_normal_vip_level);
            }
            this.d.setVisibility(0);
            setVisibility(0);
            return;
        }
        this.d.setVisibility(8);
    }

    public void setUserInfo(VideoUserInfo videoUserInfo) {
        if (videoUserInfo == null) {
            setVisibility(8);
        } else if (videoUserInfo.isAuthPub()) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
            if ("pub".equals(videoUserInfo.getKind())) {
                this.b.setVisibility(8);
            } else {
                if (videoUserInfo.getGender() == Gender.MALE) {
                    this.b.setImageResource(getGenderMaleImageResId());
                    this.b.setVisibility(0);
                } else if (videoUserInfo.getGender() == Gender.FEMALE) {
                    this.b.setImageResource(getGenderFemaleImageResId());
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                if (!TextUtils.isEmpty(videoUserInfo.getKind())) {
                    int i;
                    String kind = videoUserInfo.getKind();
                    int hashCode = kind.hashCode();
                    if (hashCode != -153325523) {
                        if (hashCode != 112661) {
                            if (hashCode != 307926738) {
                                if (hashCode == 1261512242) {
                                    if (kind.equals("yl_nvshen")) {
                                        i = 2;
                                        switch (i) {
                                            case 0:
                                                this.c.setImageResource(getLiveImageResId());
                                                this.c.setVisibility(0);
                                                break;
                                            case 1:
                                                this.c.setImageResource(getYLNanShenImageResId());
                                                this.c.setVisibility(0);
                                                break;
                                            case 2:
                                                this.c.setImageResource(getYLNvShenImageResId());
                                                this.c.setVisibility(0);
                                                break;
                                            case 3:
                                                this.c.setImageResource(getYLDaRenImageResId());
                                                this.c.setVisibility(0);
                                                break;
                                            default:
                                                this.c.setVisibility(8);
                                                break;
                                        }
                                        if (b()) {
                                            setVip(videoUserInfo);
                                        }
                                    }
                                }
                            } else if (kind.equals("yl_daren")) {
                                i = 3;
                                switch (i) {
                                    case 0:
                                        this.c.setImageResource(getLiveImageResId());
                                        this.c.setVisibility(0);
                                        break;
                                    case 1:
                                        this.c.setImageResource(getYLNanShenImageResId());
                                        this.c.setVisibility(0);
                                        break;
                                    case 2:
                                        this.c.setImageResource(getYLNvShenImageResId());
                                        this.c.setVisibility(0);
                                        break;
                                    case 3:
                                        this.c.setImageResource(getYLDaRenImageResId());
                                        this.c.setVisibility(0);
                                        break;
                                    default:
                                        this.c.setVisibility(8);
                                        break;
                                }
                                if (b()) {
                                    setVip(videoUserInfo);
                                }
                            }
                        } else if (kind.equals("rad")) {
                            i = 0;
                            switch (i) {
                                case 0:
                                    this.c.setImageResource(getLiveImageResId());
                                    this.c.setVisibility(0);
                                    break;
                                case 1:
                                    this.c.setImageResource(getYLNanShenImageResId());
                                    this.c.setVisibility(0);
                                    break;
                                case 2:
                                    this.c.setImageResource(getYLNvShenImageResId());
                                    this.c.setVisibility(0);
                                    break;
                                case 3:
                                    this.c.setImageResource(getYLDaRenImageResId());
                                    this.c.setVisibility(0);
                                    break;
                                default:
                                    this.c.setVisibility(8);
                                    break;
                            }
                            if (b()) {
                                setVip(videoUserInfo);
                            }
                        }
                    } else if (kind.equals("yl_nanshen")) {
                        i = 1;
                        switch (i) {
                            case 0:
                                this.c.setImageResource(getLiveImageResId());
                                this.c.setVisibility(0);
                                break;
                            case 1:
                                this.c.setImageResource(getYLNanShenImageResId());
                                this.c.setVisibility(0);
                                break;
                            case 2:
                                this.c.setImageResource(getYLNvShenImageResId());
                                this.c.setVisibility(0);
                                break;
                            case 3:
                                this.c.setImageResource(getYLDaRenImageResId());
                                this.c.setVisibility(0);
                                break;
                            default:
                                this.c.setVisibility(8);
                                break;
                        }
                        if (b()) {
                            setVip(videoUserInfo);
                        }
                    }
                    i = -1;
                    switch (i) {
                        case 0:
                            this.c.setImageResource(getLiveImageResId());
                            this.c.setVisibility(0);
                            break;
                        case 1:
                            this.c.setImageResource(getYLNanShenImageResId());
                            this.c.setVisibility(0);
                            break;
                        case 2:
                            this.c.setImageResource(getYLNvShenImageResId());
                            this.c.setVisibility(0);
                            break;
                        case 3:
                            this.c.setImageResource(getYLDaRenImageResId());
                            this.c.setVisibility(0);
                            break;
                        default:
                            this.c.setVisibility(8);
                            break;
                    }
                    if (b()) {
                        setVip(videoUserInfo);
                    }
                }
            }
            this.c.setVisibility(8);
            if (b()) {
                setVip(videoUserInfo);
            }
        }
    }
}
