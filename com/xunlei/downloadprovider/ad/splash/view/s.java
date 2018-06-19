package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.splash.a.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: SplashWrapAdView */
public final class s extends b {
    private int A;
    private int B;
    private int C;
    private View q;
    private View r;
    private View s;
    private ImageView t;
    private RatingBar u;
    private ImageView v;
    private TextView w;
    private ImageView x;
    private ImageView y;
    private int z;

    public s(Context context) {
        super(context);
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.q = LayoutInflater.from(this.a).inflate(R.layout.layout_splash_wrap_ad, this);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.r = this.q.findViewById(R.id.splash_ad_bg);
        this.s = this.q.findViewById(R.id.splash_ad_content_bg);
        this.t = (ImageView) this.q.findViewById(R.id.splash_ad_title_iv);
        this.u = (RatingBar) this.q.findViewById(R.id.splash_ad_score_rb);
        this.v = (ImageView) this.q.findViewById(R.id.splash_ad_image_iv);
        this.w = (TextView) this.q.findViewById(R.id.splash_ad_desc_tv);
        this.x = (ImageView) this.q.findViewById(R.id.splash_ad_action_tv);
        this.y = (ImageView) this.q.findViewById(R.id.iv_ad_source_icon);
        s();
        String str = "background_9";
        Set hashSet = new HashSet();
        hashSet.add("background_2");
        hashSet.add("background_3");
        hashSet.add("background_7");
        hashSet.add("background_9");
        hashSet.add("background_13");
        hashSet.add("background_14");
        hashSet.add("background_18");
        hashSet.add("background_20");
        if (hashSet.contains(str)) {
            str = (String) f.a(a(str, hashSet), str);
            Object obj = -1;
            switch (str.hashCode()) {
                case -1893605677:
                    if (str.equals("background_13")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1893605676:
                    if (str.equals("background_14")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1893605672:
                    if (str.equals("background_18")) {
                        obj = 6;
                        break;
                    }
                    break;
                case -1893605649:
                    if (str.equals("background_20")) {
                        obj = 7;
                        break;
                    }
                    break;
                case -338178719:
                    if (str.equals("background_2")) {
                        obj = null;
                        break;
                    }
                    break;
                case -338178718:
                    if (str.equals("background_3")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -338178714:
                    if (str.equals("background_7")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -338178712:
                    if (str.equals("background_9")) {
                        obj = 3;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    setAdStyle("background_2");
                    setBackground(R.drawable.splash_ad_bg_blue);
                    setContentBackground(R.drawable.splash_ad_content_bg);
                    setTitle(R.drawable.splash_ad_title_recommend);
                    break;
                case 1:
                    setAdStyle("background_3");
                    setBackground(R.drawable.splash_ad_bg_orange);
                    setContentBackground(R.drawable.splash_ad_content_bg);
                    setTitle(R.drawable.splash_ad_title_recommend);
                    break;
                case 2:
                    setAdStyle("background_7");
                    setBackground(R.drawable.splash_ad_bg_sea);
                    setContentBackground(R.drawable.splash_ad_content_bg_pure);
                    setTitle(R.drawable.splash_ad_title_recommend);
                    break;
                case 3:
                    r();
                    break;
                case 4:
                    setAdStyle("background_13");
                    setBackground(R.drawable.splash_ad_bg_deer_forest);
                    setContentBackground(R.drawable.splash_ad_content_bg_deer_forest);
                    setTitle(R.drawable.splash_ad_title_find);
                    s();
                    break;
                case 5:
                    setAdStyle("background_14");
                    setBackground(R.drawable.splash_ad_bg_muti_color_blue);
                    setContentBackground(R.drawable.splash_ad_content_bg_muti_color);
                    setTitle(R.drawable.splash_ad_title_hot_recommend);
                    t();
                    break;
                case 6:
                    setAdStyle("background_18");
                    setBackground(R.drawable.splash_ad_bg_blue_leaf);
                    setContentBackground(R.drawable.splash_ad_content_bg_pure);
                    setTitle(R.drawable.splash_ad_title_find);
                    t();
                    break;
                case 7:
                    setAdStyle("background_20");
                    setBackground(R.drawable.splash_ad_bg_blue_tree);
                    setContentBackground(R.drawable.splash_ad_content_bg_pure);
                    setTitle(R.drawable.splash_ad_title_find);
                    t();
                    break;
                default:
                    r();
                    break;
            }
            a();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("styles must include defaultStyle: ");
        stringBuilder.append(str);
        throw new RuntimeException(stringBuilder.toString());
    }

    protected final void c() {
        super.c();
        this.i.setOnClickListener(new t(this));
        setOnClickListener(new u(this));
    }

    protected final void d() {
        this.h = (CountDownCircleProgressBar) this.q.findViewById(R.id.splash_ad_skip_count_down_pb);
        this.i = this.q.findViewById(R.id.splash_ad_skip_count_down_btn);
    }

    public final void a(@NonNull l lVar) {
        this.o = lVar;
        a();
        this.g = Math.max(3000, i.a());
        setCountDown$2566ab5(this.g);
        setScore(f.a(this.o.q()));
        setDesc(this.o.m());
        setImage(this.o.t);
        setActionBtn(this.o.w());
        setAdSourceIconIv(getAdSourceIconResId());
        o();
        e();
    }

    public final void setBackground(int i) {
        this.A = i;
        this.r.setBackgroundResource(this.A);
    }

    public final void setContentBackground(int i) {
        this.s.setBackgroundResource(i);
    }

    public final void setTitle(int i) {
        this.z = i;
        this.t.setImageResource(this.z);
    }

    public final void setScoreVisibility(int i) {
        this.u.setVisibility(i);
    }

    public final void setScore(float f) {
        this.u.setRating(f);
    }

    public final void setImage(Bitmap bitmap) {
        if (bitmap != null) {
            this.v.setImageBitmap(bitmap);
        } else {
            this.v.setImageResource(R.color.transparent);
        }
    }

    public final void setImage(int i) {
        this.v.setImageResource(i);
    }

    public final void setDesc(String str) {
        this.w.setText(str);
    }

    public final void setDescTextColor(int i) {
        this.w.setTextColor(i);
    }

    public final void setActionBtn(boolean z) {
        this.x.setBackgroundResource(z ? this.B : this.C);
    }

    private void a() {
        boolean z = false;
        this.h.setProgress(0);
        setImage((int) R.color.transparent);
        setScore(5.0f);
        setDesc("");
        if (this.o != null && this.o.w()) {
            z = true;
        }
        setActionBtn(z);
        this.y.setVisibility(8);
    }

    private void setAdSourceIconIv(Object obj) {
        c.a(getContext(), obj, this.y);
        this.y.setVisibility(0);
    }

    @NonNull
    private static Map<String, Integer> a(String str, Set<String> set) {
        Map<String, Integer> hashMap = new HashMap();
        int size = set.size();
        int i = 100 / size;
        int i2 = 100 - (size * i);
        for (String str2 : set) {
            hashMap.put(str2, Integer.valueOf(str2.equals(str) ? i + i2 : i));
        }
        for (Entry entry : hashMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder("key: ");
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(" value: ");
            stringBuilder.append(entry.getValue());
        }
        return hashMap;
    }

    private void r() {
        setAdStyle("background_9");
        setBackground(R.drawable.splash_ad_bg_whale);
        setContentBackground(R.drawable.splash_ad_content_bg_pure);
        setTitle(R.drawable.splash_ad_title_find);
        t();
    }

    private void s() {
        this.B = R.drawable.splash_ad_action_btn_app_immediately_selector;
        this.C = R.drawable.splash_ad_action_btn_web_immediately_selector;
    }

    private void t() {
        this.B = R.drawable.splash_ad_action_btn_app_one_click_selector;
        this.C = R.drawable.splash_ad_action_btn_web_flash_selector;
    }
}
