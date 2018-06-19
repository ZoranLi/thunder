package com.xunlei.downloadprovidershare.redpacket;

import android.os.Message;
import com.xunlei.downloadprovidershare.redpacket.b.a;

/* compiled from: RedPacketShareDlgView */
final class j implements a {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    public final void a(a aVar) {
        Message obtain = Message.obtain();
        obtain.what = 1001;
        obtain.arg1 = aVar.a;
        this.a.i.sendMessage(obtain);
    }

    public final void a() {
        this.a.c = false;
        this.a.i.sendEmptyMessage(1003);
    }
}
