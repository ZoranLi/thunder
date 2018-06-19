package com.ali.auth.third.core.j;

import android.widget.Toast;
import com.ali.auth.third.core.c.a;

final class f implements Runnable {
    final /* synthetic */ String a;

    f(String str) {
        this.a = str;
    }

    public final void run() {
        Toast.makeText(a.c, e.a(this.a), 0).show();
    }
}
