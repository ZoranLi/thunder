package com.igexin.push.a.a;

import android.os.Message;
import com.igexin.push.core.f;
import com.igexin.push.f.b.d;

public class a implements d {
    private long a = 0;

    public void a() {
        Message obtain = Message.obtain();
        obtain.what = com.igexin.push.core.a.i;
        f.a().a(obtain);
    }

    public void a(long j) {
        this.a = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.a > 360000;
    }
}
