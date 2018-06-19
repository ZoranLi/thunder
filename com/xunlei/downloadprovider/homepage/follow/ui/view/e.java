package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import java.util.Calendar;

/* compiled from: FollowingLiveViewHolder */
public final class e extends ViewHolder {
    private ImageView a;
    private TextView b;
    private TextView c;
    private View d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private From h;

    public final void a(ap apVar) {
        a aVar = (a) apVar.b;
        b.a();
        b.a(aVar.f, this.a);
        this.b.setText(aVar.e);
        if (aVar.j) {
            this.d.setVisibility(0);
            this.f.setVisibility(8);
            int i = aVar.l;
            if (i > 0) {
                this.g.setVisibility(0);
                CharSequence spannableString = new SpannableString(String.valueOf(i));
                spannableString.setSpan(new ForegroundColorSpan(Color.argb(255, 255, 44, 85)), 0, spannableString.length(), 33);
                this.g.setText(spannableString);
                this.g.append("人在看");
            } else {
                this.g.setVisibility(8);
            }
            this.c.setText(TextUtils.isEmpty(aVar.k) ? aVar.a() : aVar.k);
        } else {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            long j = aVar.g;
            long j2 = aVar.h;
            if (j > j2) {
                this.f.setText(a(j));
            } else {
                this.f.setText(a(j2));
            }
            this.c.setText(TextUtils.isEmpty(aVar.k) ? aVar.a() : aVar.k);
        }
        this.itemView.setOnClickListener(new f(this, aVar));
    }

    private static String a(long j) {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        if (currentTimeMillis <= 0) {
            return "刚刚";
        }
        if (currentTimeMillis < 60) {
            j = new StringBuilder();
            j.append(currentTimeMillis);
            j.append("秒前");
            return j.toString();
        }
        currentTimeMillis /= 60;
        if (currentTimeMillis < 60) {
            j = new StringBuilder();
            j.append(currentTimeMillis);
            j.append("分钟前");
            return j.toString();
        }
        int i = (int) (currentTimeMillis / 60);
        if (i < 24) {
            j = new StringBuilder();
            j.append(i);
            j.append("小时前");
            return j.toString();
        }
        i /= 24;
        if (i < 2) {
            j = new StringBuilder();
            j.append(i);
            j.append("天前");
            return j.toString();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        j = instance.get(2) + 1;
        int i2 = instance.get(5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("月");
        stringBuilder.append(i2);
        stringBuilder.append("日");
        return stringBuilder.toString();
    }

    public e(LayoutInflater layoutInflater, ViewGroup viewGroup, From from) {
        super(layoutInflater.inflate(R.layout.following_live_item, viewGroup, false));
        layoutInflater = this.itemView;
        this.a = (ImageView) layoutInflater.findViewById(R.id.iv_avatar);
        this.b = (TextView) layoutInflater.findViewById(R.id.tv_title);
        this.c = (TextView) layoutInflater.findViewById(R.id.tv_description);
        this.d = layoutInflater.findViewById(R.id.layout_live_status);
        this.e = (ImageView) layoutInflater.findViewById(R.id.iv_live_status_anim);
        ((AnimationDrawable) this.e.getDrawable()).start();
        this.f = (TextView) layoutInflater.findViewById(R.id.tv_update_time);
        this.g = (TextView) layoutInflater.findViewById(R.id.tv_online_num);
        this.h = from;
    }
}
