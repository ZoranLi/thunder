package com.xunlei.downloadprovider.homepage.redpacket;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: RedPacketShareHeaderView */
final class q implements c<com.xunlei.downloadprovider.homepage.redpacket.a.c> {
    final /* synthetic */ RedPacketShareHeaderView a;

    q(RedPacketShareHeaderView redPacketShareHeaderView) {
        this.a = redPacketShareHeaderView;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        obj = ((com.xunlei.downloadprovider.homepage.redpacket.a.c) obj).a;
        if (obj > null) {
            RedPacketShareHeaderView.a(this.a, true);
            j.a();
            obj = j.a(obj);
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(10.0f)), 0, 4, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(13.0f)), 4, obj.length(), 33);
            this.a.c.setText(spannableString);
            return;
        }
        RedPacketShareHeaderView.a(this.a, false);
    }

    public final void onFail(String str) {
        RedPacketShareHeaderView.a(this.a, false);
    }
}
