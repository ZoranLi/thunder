package com.xunlei.common.new_ptl.member.task.h;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserSinaLoginTask */
final class c$2 extends b {
    private /* synthetic */ c a;

    c$2(c cVar) {
        this.a = cVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        headerArr = new StringBuilder("login request response = ");
        headerArr.append(str);
        XLLog.v("UserSinaLoginTask", headerArr.toString());
        c.b(this.a, str);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserWxLoginTask", stringBuilder.toString());
        c.a(this.a, a.a(th));
    }
}
