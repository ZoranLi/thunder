package com.xunlei.downloadprovider.personal.message;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.tdlive.util.XLog;

/* compiled from: MessageActivty */
final class a implements OnPageChangeListener {
    final /* synthetic */ MessageActivty a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    a(MessageActivty messageActivty) {
        this.a = messageActivty;
    }

    public final void onPageSelected(int i) {
        String b = MessageActivty.a;
        StringBuilder stringBuilder = new StringBuilder("onPageSelected position=");
        stringBuilder.append(i);
        XLog.d(b, stringBuilder.toString());
        if (!(this.a.r == i || this.a.t == null || this.a.t.get(Integer.valueOf(this.a.r)) == null)) {
            ((MessageItemFragment) this.a.t.get(Integer.valueOf(this.a.r))).a();
        }
        this.a.r = i;
        this.a.a(i);
        if (this.a.t != 0 && this.a.t.get(Integer.valueOf(this.a.r)) != 0) {
            MessageItemFragment messageItemFragment = (MessageItemFragment) this.a.t.get(Integer.valueOf(this.a.r));
            if (messageItemFragment.b) {
                messageItemFragment.b = false;
            } else {
                messageItemFragment.a(false);
            }
            messageItemFragment.a = true;
        }
    }
}
