package com.xunlei.downloadprovider.homepage.redpacket;

import android.os.Message;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.redpacket.a.b;
import com.xunlei.downloadprovider.homepage.redpacket.a.d.a;

/* compiled from: RedPacketGuideDlg */
final class h implements a {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.l.sendEmptyMessage(1004);
    }

    public final void a(b bVar) {
        if (ITagManager.SUCCESS.equals(bVar.a) && bVar.c > 0.0f) {
            Message message = new Message();
            message.what = 1003;
            message.obj = Float.valueOf(bVar.c / 1000.0f);
            this.a.l.sendMessage(message);
        } else if (bVar.d == 101102) {
            this.a.l.sendEmptyMessage(1005);
        } else {
            this.a.l.sendEmptyMessage(1004);
        }
    }
}
