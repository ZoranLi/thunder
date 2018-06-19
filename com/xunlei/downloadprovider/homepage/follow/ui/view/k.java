package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.f;
import com.xunlei.downloadprovider.homepage.follow.i;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;
import java.util.Calendar;

/* compiled from: FollowingViewHolder */
public final class k extends ViewHolder {
    private Context a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;

    public final void a(ap apVar) {
        a aVar = (a) apVar.b;
        b.a();
        b.a(aVar.f, this.b);
        m.a(this.c, aVar.d, aVar.c);
        this.d.setText(aVar.e);
        long j = aVar.g;
        long j2 = aVar.h;
        if (j > j2) {
            this.f.setText(a(j));
        } else {
            this.f.setText(a(j2));
        }
        this.e.setText(aVar.a());
        int i = aVar.i;
        if (i > 0 && i < 100) {
            this.g.setText(String.valueOf(i));
            if (i >= 10) {
                this.g.setWidth(DipPixelUtil.dip2px(23.0f));
            } else {
                this.g.setWidth(DipPixelUtil.dip2px(16.0f));
            }
            this.g.setVisibility(0);
            this.h.setVisibility(8);
        } else if (i >= 100) {
            this.g.setVisibility(8);
            this.h.setVisibility(0);
        } else {
            a();
        }
        this.itemView.setOnClickListener(new l(this, apVar));
    }

    private void a() {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
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

    public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.following_item, viewGroup, false));
        this.a = viewGroup.getContext();
        layoutInflater = this.itemView;
        this.b = (ImageView) layoutInflater.findViewById(R.id.iv_avatar);
        this.c = (ImageView) layoutInflater.findViewById(R.id.iv_v_status);
        this.d = (TextView) layoutInflater.findViewById(R.id.tv_title);
        this.e = (TextView) layoutInflater.findViewById(R.id.tv_latest_res_title);
        this.f = (TextView) layoutInflater.findViewById(R.id.tv_update_time);
        this.g = (TextView) layoutInflater.findViewById(R.id.tv_update_count);
        this.h = (ImageView) layoutInflater.findViewById(R.id.iv_update_count);
        a();
    }

    static /* synthetic */ void a(k kVar, a aVar) {
        long j = aVar.b;
        if ("rad".equals(aVar.c) && aVar.j) {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(kVar.a, aVar.n, XLLiveRoomPlayFrom.FOLLOW_TAB_LIST_FOLLOW_ITEM);
        } else {
            m.a(kVar.a, aVar.b, aVar.c, aVar.e, aVar.f, From.FOLLOW_TAB_LIST);
            if ("rad".equals(aVar.c) == null && aVar.i > null) {
                kVar = com.xunlei.downloadprovider.homepage.follow.b.a();
                long j2 = aVar.b;
                int a = aVar.i + kVar.a(j2);
                f fVar = (f) kVar.j.get(Long.valueOf(j2));
                if (fVar != null) {
                    fVar.d = a;
                } else {
                    kVar.j.put(Long.valueOf(j2), new f(j2, a, a));
                }
                fVar = (f) kVar.j.get(Long.valueOf(j2));
                for (a aVar2 : kVar.h) {
                    if (aVar2.b == j2) {
                        aVar2.i = 0;
                    }
                }
                aVar.i = 0;
                com.xunlei.downloadprovider.homepage.follow.b.a(new i(kVar, fVar));
            }
        }
        ad.a(ViewHolder.From.MY_FOLLOWING_LIST.toString(), j, aVar.c, aVar.j);
    }
}
