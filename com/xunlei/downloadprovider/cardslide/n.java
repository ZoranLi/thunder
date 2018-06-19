package com.xunlei.downloadprovider.cardslide;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cardslide.d.c;
import com.xunlei.downloadprovider.cardslide.slide.a;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.youliao.YouliaoVideoFragment;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.xllib.android.d;

/* compiled from: CardSlideActivity */
final class n extends a {
    final /* synthetic */ CardSlideActivity a;

    n(CardSlideActivity cardSlideActivity) {
        this.a = cardSlideActivity;
    }

    public final int a() {
        int b = d.b(BrothersApplication.getApplicationInstance());
        int a = d.a(BrothersApplication.getApplicationInstance());
        String str = Build.MODEL;
        StringBuilder stringBuilder = new StringBuilder("phoneModel, screenHeight, screenWidth = ");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(b);
        stringBuilder.append(", ");
        stringBuilder.append(a);
        if (b < WBConstants.SDK_NEW_PAY_VERSION) {
            return R.layout.card_item_1;
        }
        return c.c() ? R.layout.card_item_2 : R.layout.card_item;
    }

    public final int b() {
        return this.a.a.size();
    }

    public final void a(View view, int i) {
        com.xunlei.downloadprovider.cardslide.b.a aVar;
        Object tag = view.getTag();
        if (tag != null) {
            aVar = (com.xunlei.downloadprovider.cardslide.b.a) tag;
        } else {
            aVar = new com.xunlei.downloadprovider.cardslide.b.a(this.a, view);
            view.setTag(aVar);
        }
        if (i < this.a.a.size()) {
            com.xunlei.downloadprovider.cardslide.c.a aVar2 = (com.xunlei.downloadprovider.cardslide.c.a) this.a.a.get(i);
            aVar.j = aVar2;
            BaseVideoInfo baseVideoInfo = aVar2.b;
            view = aVar2.a;
            b.a().a(baseVideoInfo.getCoverUrl(), aVar.b, null);
            b.a();
            b.a(view.getPortraitUrl(), aVar.e);
            aVar.f.setUserInfo(view);
            aVar.c.setText(view.getNickname());
            aVar.g.setText(String.valueOf(i + 1));
            view = new StringBuilder("/");
            i = aVar.a;
            view.append(i.a != null ? i.a.size() : 0);
            aVar.i.setText(view.toString());
            view = baseVideoInfo.getLocationInfo();
            if (view != null) {
                view = c.a(YouliaoVideoFragment.a, YouliaoVideoFragment.b, view.d, view.c);
                if (view <= 0 || YouliaoVideoFragment.a == -1.0d || YouliaoVideoFragment.b == -1.0d) {
                    aVar.h.setText("");
                } else {
                    i = new StringBuilder();
                    i.append(view);
                    i.append("km");
                    aVar.h.setText(i.toString());
                }
            } else {
                aVar.h.setText("");
            }
            new StringBuilder("bindData resId = ").append(baseVideoInfo.getVideoId());
            aVar.d.setOnClickListener(new com.xunlei.downloadprovider.cardslide.b.b(aVar));
        }
    }

    public final Rect a(View view) {
        View findViewById = view.findViewById(R.id.card_item_content);
        View findViewById2 = view.findViewById(R.id.card_top_layout);
        return new Rect((view.getLeft() + findViewById.getPaddingLeft()) + findViewById2.getPaddingLeft(), (view.getTop() + findViewById.getPaddingTop()) + findViewById2.getPaddingTop(), (view.getRight() - findViewById.getPaddingRight()) - findViewById2.getPaddingRight(), (view.getBottom() - findViewById.getPaddingBottom()) - view.findViewById(R.id.card_bottom_layout).getPaddingBottom());
    }
}
