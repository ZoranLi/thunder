package com.xunlei.downloadprovider.cardslide;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.slide.CardItemView;
import com.xunlei.downloadprovider.cardslide.slide.CardSlidePanel.a;

/* compiled from: CardSlideActivity */
final class m implements a {
    final /* synthetic */ CardSlideActivity a;

    m(CardSlideActivity cardSlideActivity) {
        this.a = cardSlideActivity;
    }

    public final void a(int i, View view) {
        CardSlideActivity.b(this.a);
        if (i < this.a.a.size()) {
            StringBuilder stringBuilder = new StringBuilder("正在显示 index = ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(((com.xunlei.downloadprovider.cardslide.c.a) this.a.a.get(i)).c);
            stringBuilder.append(", mDataListSize=");
            stringBuilder.append(this.a.a.size());
            CardSlideActivity.a(this.a, i, (CardItemView) view);
        }
    }

    public final void a(boolean z, int i, int i2) {
        CardSlideActivity.b(this.a);
        if (i2 == 1) {
            CardSlideActivity.d(this.a);
        }
        if (i < this.a.a.size()) {
            StringBuilder stringBuilder = new StringBuilder("正在消失 index = ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(((com.xunlei.downloadprovider.cardslide.c.a) this.a.a.get(i)).c);
            stringBuilder.append(", 消失type=");
            stringBuilder.append(i2);
            stringBuilder.append(", mDataListSize=");
            stringBuilder.append(this.a.a.size());
            CardSlideActivity.a(this.a, z, i, i2);
        }
    }

    public final void a(int i, float f) {
        float f2 = 1.14f;
        if (i == 0) {
            if (f == 0.0f) {
                this.a.m.setBackgroundResource(R.drawable.ic_card_btn_del_gray);
            } else {
                this.a.m.setBackgroundResource(R.drawable.ic_card_btn_left_blue);
            }
            this.a.m.setRotation((-f) * 180.0f);
            if (((double) f) <= 0.14d) {
                f2 = f + 1.0f;
            }
            this.a.m.setScaleX(f2);
            this.a.m.setScaleY(f2);
            this.a.k.setScaleX(f2);
            this.a.k.setScaleY(f2);
            this.a.d();
        } else if (i == 1) {
            if (f == 0.0f) {
                this.a.d();
            }
            if (((double) f) <= 0.14d) {
                f2 = f + 1.0f;
            }
            this.a.n.setScaleX(f2);
            this.a.n.setScaleY(f2);
            this.a.l.setScaleX(f2);
            this.a.l.setScaleY(f2);
            this.a.g();
        }
        if (i == -1 || f == 0.0f) {
            CardSlideActivity.b(this.a);
        }
    }
}
