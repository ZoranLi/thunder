package com.xunlei.tdlive.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.b;
import com.xunlei.tdlive.util.b.c;
import com.xunlei.tdlive.util.d;
import com.xunlei.tdlive.util.g;

public class PkListInnerItemView extends FrameLayout {
    protected int a = null;
    private View b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private RoundImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private RoundImageView j;

    public PkListInnerItemView(@NonNull Context context) {
        super(context);
    }

    public PkListInnerItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PkListInnerItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.b = findViewById(R.id.xllive_list_mask);
        this.e = (ImageView) findViewById(R.id.tag);
        this.c = (ImageView) findViewById(R.id.pc_flag);
        this.d = (ImageView) findViewById(R.id.pk_flag);
        this.f = (RoundImageView) findViewById(R.id.useravatar);
        this.g = (TextView) findViewById(R.id.username);
        this.h = (TextView) findViewById(R.id.title);
        this.j = (RoundImageView) findViewById(R.id.playthumb);
        this.i = (TextView) findViewById(R.id.count);
        float a = d.a(getContext(), 5.0f);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -1862270976});
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, a, a, a, a});
        g.a(this.b, gradientDrawable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAni();
    }

    public void setGap(float f, float f2) {
        setGap(f, f2, f2);
    }

    public void setGap(float f, float f2, float f3) {
        if (this.a == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.a = displayMetrics.widthPixels;
        }
        int a = (this.a - ((int) d.a(getContext(), (f + f2) + f3))) / 2;
        setLayoutParams(new LayoutParams(a, a));
        this.j.setType(Float.MIN_VALUE);
        this.j.setBorderRadius(7.0E-45f);
    }

    public void bind(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null) {
            setTag(jsonWrapper);
            CharSequence string = jsonWrapper.getObject("userinfo", "{}").getString("nickname", jsonWrapper.getString("userid", ""));
            String string2 = jsonWrapper.getObject("userinfo", "{}").getString("avatar", "");
            String string3 = jsonWrapper.getString("image", string2);
            if (TextUtils.isEmpty(string3)) {
                string3 = string2;
            }
            this.b.setVisibility(0);
            this.i.setText(jsonWrapper.getString("onlinenum", "0"));
            this.g.setText(string);
            String string4 = jsonWrapper.getObject("player_info", "{}").getObject("level_info", "{}").getString("image_leve", "");
            if (TextUtils.isEmpty(string4)) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.g.setCompoundDrawablesWithIntrinsicBounds(R.drawable.xllive_user_grade_zero_sq, 0, 0, 0);
                b.a(getContext()).a(this.g, string4);
            }
            string = jsonWrapper.getString("title", "");
            if (TextUtils.isEmpty(string)) {
                this.h.setVisibility(8);
            } else {
                this.h.setText(string);
                this.h.setVisibility(0);
            }
            this.c.setVisibility(8);
            String string5 = jsonWrapper.getString("tag", "");
            if (string5.length() > 0) {
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                final int a = (int) d.a(getContext(), 20.0f);
                b.a(getContext()).a(this.e, string5, new c<ImageView>(this) {
                    final /* synthetic */ PkListInnerItemView b;

                    public void a(ImageView imageView, String str, Drawable drawable) {
                    }

                    public void a(ImageView imageView, String str, Bitmap bitmap, b.b bVar) {
                        imageView.setVisibility(null);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = (int) (((((float) a) * 1.0f) / ((float) bitmap.getHeight())) * ((float) bitmap.getWidth()));
                            layoutParams.height = a;
                            imageView.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
            b.a(getContext()).a(this.f, string2, b.a(getContext(), R.drawable.xllive_avatar_default));
            b.a(getContext()).a(this.j, string3, b.a(getContext(), R.drawable.xllive_img_loding));
            this.d.setImageResource(R.drawable.xllive_icon_pk_ani);
            ((AnimationDrawable) this.d.getDrawable()).start();
            return;
        }
        stopAni();
    }

    public void stopAni() {
        if (this.d != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.d.getDrawable();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }
}
