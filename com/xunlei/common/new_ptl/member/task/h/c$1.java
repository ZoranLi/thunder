package com.xunlei.common.new_ptl.member.task.h;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.new_ptl.member.XLErrorCode;

/* compiled from: UserSinaLoginTask */
final class c$1 implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ c b;

    c$1(c cVar, int i) {
        this.b = cVar;
        this.a = i;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", this.a);
        if (TextUtils.isEmpty(c.a(this.b))) {
            c.a(this.b, XLErrorCode.getErrorDesc(this.a));
        }
        bundle.putString("errorDesc", c.a(this.b));
        this.b.d().a(this.b, bundle);
        this.b.d().b(this.b.g());
    }
}
