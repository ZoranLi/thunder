package com.xunlei.downloadprovider.publiser.common.guide.follow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.a;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GuideFollowTagItemView */
public class c extends FrameLayout {
    static final int a = BrothersApplication.getApplicationInstance().getResources().getDimensionPixelSize(R.dimen.guide_follow_avatar_width);
    static final int b = BrothersApplication.getApplicationInstance().getResources().getDimensionPixelSize(R.dimen.guide_follow_avatar_height);
    static final int c = BrothersApplication.getApplicationInstance().getResources().getDimensionPixelSize(R.dimen.guide_follow_avatar_cover_width);
    private static final String j = "c";
    Context d = null;
    TextView e = null;
    TextView f = null;
    FrameLayout g = null;
    CheckBox h = null;
    a i = null;
    private View k = null;

    public c(Context context) {
        super(context);
        this.d = context;
        LayoutInflater.from(this.d).inflate(R.layout.guide_follow_tag_item, this);
        this.k = findViewById(R.id.root_view);
        this.e = (TextView) findViewById(R.id.tv_title);
        this.f = (TextView) findViewById(R.id.tv_desc);
        this.h = (CheckBox) findViewById(R.id.cb_follow);
        this.g = (FrameLayout) findViewById(R.id.fl_avatars);
    }

    public void setData(a aVar) {
        this.i = aVar;
    }

    public final boolean a() {
        return this.h.isChecked() && this.i != null;
    }

    public int getGroupId() {
        return a() ? this.i.b : -1;
    }

    @NonNull
    public List<Long> getFollowUids() {
        List<Long> arrayList = new ArrayList();
        if (a()) {
            new StringBuilder("getFollowUids isFollowed. title: ").append(this.i.d);
            List<m> list = this.i.a;
            if (list != null) {
                for (m mVar : list) {
                    if (mVar != null) {
                        if ((mVar.b != 0 ? 1 : null) != null) {
                            arrayList.add(Long.valueOf(mVar.b));
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("getFollowUids followUids.size: ");
                stringBuilder.append(arrayList.size());
                stringBuilder.append(" title: ");
                stringBuilder.append(this.i.d);
            }
        }
        return arrayList;
    }

    public void setBackgroundResource(int i) {
        this.k.setBackgroundResource(i);
    }

    final void b() {
        this.g.removeAllViews();
        if (this.i != null) {
            List list = this.i.a;
            if (list != null) {
                if (list.size() != 0) {
                    int size = list.size();
                    int min = Math.min(size, 4) - 1;
                    int i = min;
                    while (i >= 0 && i < size) {
                        View view;
                        if ((size > 4 ? 1 : 0) == 0 || i != min) {
                            m mVar = (m) list.get(i);
                            View imageView = new ImageView(this.d);
                            LayoutParams layoutParams = new FrameLayout.LayoutParams(a, b);
                            layoutParams.leftMargin = (a - c) * i;
                            imageView.setLayoutParams(layoutParams);
                            imageView.setBackgroundResource(R.drawable.stroke_guide_follow_tag_avatar);
                            imageView.setScaleType(ScaleType.FIT_XY);
                            com.xunlei.downloadprovider.ad.common.c.a(getContext(), mVar.f).transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.a(r9)}).placeholder(R.drawable.guide_follow_tag_avatar_default_icon).error(R.drawable.guide_follow_tag_avatar_default_icon).fallback(R.drawable.guide_follow_tag_avatar_default_icon).listener(null).into(imageView);
                            view = imageView;
                        } else {
                            view = new TextView(this.d);
                            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a, b);
                            layoutParams2.leftMargin = (a - c) * i;
                            view.setLayoutParams(layoutParams2);
                            view.setBackgroundResource(R.drawable.guide_follow_avatar_circle_translucent);
                            view.setTextSize(9.0f);
                            view.setGravity(17);
                            view.setTextColor(getResources().getColor(R.color.white));
                            view.setText(getResources().getString(R.string.guide_follow_translucent_avatar_text, new Object[]{Integer.valueOf(size)}));
                        }
                        this.g.addView(view);
                        i--;
                    }
                }
            }
        }
    }
}
