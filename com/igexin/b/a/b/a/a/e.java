package com.igexin.b.a.b.a.a;

import android.os.Message;
import com.igexin.b.a.b.a.a.a.d;
import com.igexin.b.a.c.a;
import java.net.Socket;

class e implements d {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void a(com.igexin.b.a.b.e eVar) {
        this.a.n.sendEmptyMessage(3);
    }

    public void a(Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("S-SM|c ex = ");
        stringBuilder.append(exception.toString());
        a.b(stringBuilder.toString());
        this.a.b();
    }

    public void a(String str) {
        this.a.n.sendEmptyMessage(1);
    }

    public void a(Socket socket) {
        Message obtain = Message.obtain();
        obtain.obj = socket;
        obtain.what = 2;
        this.a.n.sendMessage(obtain);
    }
}
