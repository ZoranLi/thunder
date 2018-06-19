package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class DownloadTitleBarView extends FrameLayout {
    public View a;
    public ImageView b;
    public View c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private View k;
    private int l = 0;
    private int m = -1;
    private TextView n;
    private ImageView o;

    public DownloadTitleBarView(Context context) {
        super(context);
        a(context);
    }

    public DownloadTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DownloadTitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.download_center_title_bar, null);
        this.a = viewGroup.findViewById(R.id.content);
        this.g = (ImageView) viewGroup.findViewById(R.id.title_bar_left_iv);
        this.h = (ImageView) viewGroup.findViewById(R.id.title_bar_tip_icon);
        this.d = (LinearLayout) viewGroup.findViewById(R.id.center_title_layout);
        this.e = (TextView) viewGroup.findViewById(R.id.title_bar_center_title);
        this.f = (TextView) viewGroup.findViewById(R.id.view_4_touch_event);
        this.i = (ImageView) viewGroup.findViewById(R.id.title_bar_right_1_iv);
        this.j = (ImageView) viewGroup.findViewById(R.id.title_bar_right_2_iv);
        this.k = viewGroup.findViewById(R.id.icon_click_container);
        this.b = (ImageView) viewGroup.findViewById(R.id.title_bar_right_3_iv);
        this.n = (TextView) viewGroup.findViewById(R.id.titlebar_right_3_tv);
        this.c = viewGroup.findViewById(R.id.titlebar_right_3_layout);
        this.o = (ImageView) viewGroup.findViewById(R.id.title_bar_right_nav_search);
        addView(viewGroup);
    }

    public void setTipIcon(int i) {
        if (i == -1) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        if (this.m != i) {
            this.m = i;
            this.h.setImageResource(i);
        }
    }

    public void setTipIconVisibility(int i) {
        this.h.setVisibility(i);
    }

    public void setLeftImageViewClickListener(OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
    }

    public void setRightImageView1ClickListener(OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public void setRightImageView2ClickListener(OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
    }

    public void setRightImageView3ClickListner(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setRightNavSearchClickListener(OnClickListener onClickListener) {
        if (this.o != null) {
            this.o.setOnClickListener(onClickListener);
        }
    }

    public void setRightNavSearchShow(boolean z) {
        if (this.o != null) {
            this.o.setVisibility(z ? false : true);
        }
    }

    public final DownloadTitleBarView a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n.setVisibility(4);
        } else {
            this.n.setVisibility(0);
            this.n.setText(str);
        }
        return this;
    }

    public void setLeftImageViewImage(int i) {
        this.g.setImageResource(i);
    }

    public void setRightImageView1Image(int i) {
        this.i.setImageResource(i);
    }

    public void setRightImageView2Image(int i) {
        this.j.setImageResource(i);
    }

    public View getRightImageView2() {
        return this.j;
    }

    public int getRightImageView2Width() {
        return this.j.getWidth();
    }

    public int getRightImageView2Height() {
        return this.j.getHeight();
    }

    public void setTouchListener(OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
    }

    public void setCenterTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            a(8, true);
        } else {
            a(0, true);
        }
        this.e.setText(str);
    }

    public void setCenterTitle(int i) {
        if (i == -1) {
            a(8, true);
        } else {
            a(0, true);
        }
        this.e.setText(i);
    }

    public final boolean a(int i, boolean z) {
        boolean z2 = this.d.getVisibility() != i;
        if (z) {
            if (i == 0) {
                if (this.d.getVisibility()) {
                    z = this.d.getAnimation();
                    if (z && !z.hasEnded() && this.l) {
                        return z2;
                    }
                    z = AnimationUtils.loadAnimation(getContext(), R.anim.anim_dl_center_title_appear);
                    this.d.setVisibility(i);
                    if (z) {
                        z.setAnimationListener(new aq(this));
                        this.l = 0;
                        this.d.clearAnimation();
                        this.d.startAnimation(z);
                    }
                }
            } else if (!this.d.getVisibility()) {
                z = this.d.getAnimation();
                if (z && !z.hasEnded() && this.l) {
                    return z2;
                }
                this.d.clearAnimation();
                this.l = 0;
                z = AnimationUtils.loadAnimation(getContext(), R.anim.anim_dl_center_title_disappear);
                if (z) {
                    z.setAnimationListener(new ar(this, i));
                    this.d.startAnimation(z);
                } else {
                    this.d.setVisibility(i);
                }
            }
            return z2;
        }
        this.d.setVisibility(i);
        if (i != 0) {
            i = this.d.getAnimation();
            if (i == 0 || i.hasEnded() != 0 || this.l == 2) {
                return z2;
            }
        }
        return z2;
    }

    public void setIconContainerListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.k.setOnClickListener(onClickListener);
            this.k.setClickable(true);
            return;
        }
        this.k.setClickable(false);
    }
}
