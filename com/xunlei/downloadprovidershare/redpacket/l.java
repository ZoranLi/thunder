package com.xunlei.downloadprovidershare.redpacket;

import android.widget.ImageView;

/* compiled from: RedPacketShareDlgView */
final class l implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ g b;

    l(g gVar, ImageView imageView) {
        this.b = gVar;
        this.a = imageView;
    }

    public final void run() {
        g gVar = this.b;
        String str = this.b.g.g;
        ImageView imageView = this.a;
        g.a(imageView.getContext(), str, gVar.a[(int) (Math.random() * 2.0d)]).override(Integer.MIN_VALUE, Integer.MIN_VALUE).into(new m(gVar, imageView));
    }
}
