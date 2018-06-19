package com.baidu.mobads.production;

import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.utils.d;
import com.baidu.mobads.utils.l;

class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Uri b;
    final /* synthetic */ b c;

    m(b bVar, String str, Uri uri) {
        this.c = bVar;
        this.a = str;
        this.b = uri;
    }

    public void run() {
        try {
            Class[] clsArr = new Class[]{Context.class, String.class, Uri.class, Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView$OnBoostListener", false, a.a(this.c.f))};
            Object[] objArr = new Object[]{this.c.getApplicationContext(), this.a, this.b, null};
            d.a(Class.forName("com.baidu.mobads_vr.vrplayer.VrImageView", false, a.a(this.c.f)), "boost", clsArr, objArr);
        } catch (Throwable e) {
            l.a().d(e);
        }
    }
}
