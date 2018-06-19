package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.content.Context;
import android.graphics.Matrix;
import android.location.Location;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.youliao.YouliaoVideoFragment;
import com.xunlei.downloadprovider.homepage.youliao.data.YouliaoVideo;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.thunder.commonui.widget.CircleImageView;
import com.xunlei.xllib.android.d;
import java.text.DecimalFormat;

public class YouliaoVideoCardView extends FrameLayout {
    static int a;
    static int b;
    private ImageView c;
    private TextView d;
    private CircleImageView e;
    private ImageView f;
    private View g;
    private View h;
    private ImageView i;
    private TextView j;
    private OnClickListener k;
    private View l;
    private TextView m;
    private TextView n;
    private ImageView o;

    public YouliaoVideoCardView(Context context) {
        super(context);
        a();
    }

    public YouliaoVideoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YouliaoVideoCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setUserIconClickListener(OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    private void a() {
        this.g = LayoutInflater.from(getContext()).inflate(R.layout.layout_youliao_video_card_view, this, true);
        this.h = this.g.findViewById(R.id.item_card_content);
        LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams != null) {
            if (b == 0) {
                Context context = getContext();
                if (a == 0) {
                    int a = d.a(context);
                    int dip2px = DipPixelUtil.dip2px(140.0f);
                    a = (a - DipPixelUtil.dip2px(19.0f)) / 2;
                    a = a;
                    b = (a * 4) / 3;
                    if (dip2px <= b) {
                        dip2px = b;
                    }
                    b = dip2px;
                }
            }
            layoutParams.width = -1;
            layoutParams.height = b;
            this.h.setLayoutParams(layoutParams);
        }
        this.c = (ImageView) this.g.findViewById(R.id.item_poster);
        this.d = (TextView) this.g.findViewById(R.id.item_count_info);
        this.i = (ImageView) this.g.findViewById(R.id.item_count_image);
        this.j = (TextView) this.g.findViewById(R.id.item_user_name);
        this.e = (CircleImageView) this.g.findViewById(R.id.item_user_header);
        this.e.setBorderWidth(0);
        this.f = (ImageView) this.g.findViewById(R.id.item_user_vip);
        this.l = this.g.findViewById(R.id.item_bottom_mask);
        this.l.setVisibility(4);
        this.m = (TextView) this.g.findViewById(R.id.item_tag_info);
        this.n = (TextView) this.g.findViewById(R.id.item_lbs_info);
        this.o = (ImageView) this.g.findViewById(R.id.item_lbs_image);
        setBackgroundColor(getResources().getColor(R.color.white));
        this.e.setOnClickListener(new d(this));
        this.j.setOnClickListener(new e(this));
    }

    public void setPosition(int i) {
        if (this.g != null) {
            int dip2px = DipPixelUtil.dip2px(5.0f);
            int dip2px2 = DipPixelUtil.dip2px(7.0f);
            int dip2px3 = DipPixelUtil.dip2px(5.0f);
            int i2 = 0;
            if (i <= 1) {
                i2 = dip2px;
            }
            if (i % 2 != 0) {
                i = dip2px3 / 2;
            } else {
                int i3 = dip2px2;
                dip2px2 = dip2px3 / 2;
                i = i3;
            }
            this.g.setPadding(i, i2, dip2px2, dip2px);
            requestLayout();
        }
    }

    public void setYouliaoVideo(YouliaoVideo youliaoVideo) {
        YouliaoVideoCardView youliaoVideoCardView = this;
        YouliaoVideo youliaoVideo2 = youliaoVideo;
        if (youliaoVideo2 != null) {
            float f;
            Object posterUrl = youliaoVideo.getPosterUrl();
            ImageView imageView = youliaoVideoCardView.c;
            if (TextUtils.isEmpty(posterUrl)) {
                imageView.setImageResource(R.drawable.youliao_video_round_corner_poster_default);
            } else {
                Glide.with(getContext()).load(posterUrl).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).fallback(R.drawable.youliao_video_round_corner_poster_default).placeholder(R.drawable.choiceness_icon_default).dontAnimate().into(new f(youliaoVideoCardView, imageView));
            }
            b.a();
            b.a(youliaoVideo.getPublisherInfo().getAvatarUrl(), youliaoVideoCardView.e, R.drawable.youliao_video_user_icon_default, R.drawable.youliao_video_user_icon_default, R.drawable.youliao_video_user_icon_default);
            m.a(youliaoVideoCardView.f, youliaoVideo.getPublisherInfo().isV(), youliaoVideo.getPublisherInfo().getUserKind());
            if (TextUtils.isEmpty(youliaoVideo.getTitle())) {
                youliaoVideoCardView.j.setText(youliaoVideo.getPublisherInfo().getPublisherName());
            } else {
                youliaoVideoCardView.j.setText(youliaoVideo.getTitle());
            }
            if (YouliaoVideoFragment.a == -1.0d || YouliaoVideoFragment.b == -1.0d || youliaoVideo.getVideoLatitude() == -1.0d || youliaoVideo.getVideoLongitude() == -1.0d) {
                f = -1.0f;
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(YouliaoVideoFragment.a, YouliaoVideoFragment.b, youliaoVideo.getVideoLatitude(), youliaoVideo.getVideoLongitude(), fArr);
                f = fArr[0] / 1000.0f;
            }
            StringBuilder stringBuilder = new StringBuilder("userLatitude:");
            stringBuilder.append(YouliaoVideoFragment.a);
            stringBuilder.append(",userLongitude:");
            stringBuilder.append(YouliaoVideoFragment.b);
            stringBuilder.append(",videoLatitude:");
            stringBuilder.append(youliaoVideo.getVideoLatitude());
            stringBuilder.append(",videoLongitude");
            stringBuilder.append(youliaoVideo.getVideoLongitude());
            stringBuilder.append(",distance");
            stringBuilder.append(f);
            CharSequence videoAddress = youliaoVideo.getVideoAddress();
            if (f != -1.0f && f < ((float) com.xunlei.downloadprovider.d.d.a().r.d())) {
                CharSequence stringBuilder2;
                TextView textView = youliaoVideoCardView.n;
                String format = new DecimalFormat("#.00").format((double) f);
                String substring;
                StringBuilder stringBuilder3;
                if (format.charAt(format.length() - 1) == '0' && format.charAt(format.length() - 2) == '0') {
                    substring = format.substring(0, format.length() - 3);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(substring);
                    stringBuilder3.append("km");
                    stringBuilder2 = stringBuilder3.toString();
                } else if (format.charAt(format.length() - 1) == '0') {
                    substring = format.substring(0, format.length() - 1);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(substring);
                    stringBuilder3.append("km");
                    stringBuilder2 = stringBuilder3.toString();
                } else {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(format);
                    stringBuilder4.append("km");
                    stringBuilder2 = stringBuilder4.toString();
                }
                textView.setText(stringBuilder2);
                youliaoVideoCardView.n.setVisibility(0);
                youliaoVideoCardView.o.setVisibility(0);
            } else if (videoAddress == null || videoAddress.equals("")) {
                youliaoVideoCardView.n.setVisibility(8);
                youliaoVideoCardView.o.setVisibility(8);
            } else {
                youliaoVideoCardView.n.setText(videoAddress);
                youliaoVideoCardView.n.setVisibility(0);
                youliaoVideoCardView.o.setVisibility(0);
            }
            if (com.xunlei.downloadprovider.d.d.a().r.g() && f != -1.0f && f < ((float) com.xunlei.downloadprovider.d.d.a().r.e())) {
                youliaoVideoCardView.m.setText("附近");
                youliaoVideoCardView.m.setBackgroundResource(R.drawable.youliao_near_background);
                youliaoVideo2.setRecommendTag("near");
                youliaoVideoCardView.m.setVisibility(0);
            } else if (com.xunlei.downloadprovider.d.d.a().r.f() && "new".equals(youliaoVideo.getRecommendTag())) {
                youliaoVideoCardView.m.setText("最新");
                youliaoVideoCardView.m.setBackgroundResource(R.drawable.youliao_new_background);
                youliaoVideoCardView.m.setVisibility(0);
            } else {
                youliaoVideoCardView.m.setVisibility(8);
            }
            a(youliaoVideo.getLikeInfo().getLikeCount());
        }
    }

    final void a(int i) {
        this.d.setText(j.a((long) i));
        this.d.setVisibility(0);
        this.i.setVisibility(0);
    }

    static Matrix a(View view, int i, int i2) {
        float f;
        int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
        int height = (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
        view = new Matrix();
        if (i * height > width * i2) {
            f = ((float) height) / ((float) i2);
            i = ((float) width) - (((float) i) * f);
        } else {
            f = ((float) width) / ((float) i);
            i = 0;
        }
        view.setScale(f, f);
        view.postTranslate((float) Math.round(i), (float) Math.round(0.0f));
        return view;
    }
}
