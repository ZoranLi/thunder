package com.xunlei.common.new_ptl.member.task.d;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import org.apache.http.Header;

/* compiled from: UserLogoutTask */
final class c$1 extends b {
    private /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        super.a(i, headerArr, str);
        i = c.a(this.a);
        headerArr = new StringBuilder("on logout success body = ");
        headerArr.append(str);
        XLLog.v(i, headerArr.toString());
    }

    public final void a(Throwable th) {
        super.a(th);
        String b = c.b(this.a);
        StringBuilder stringBuilder = new StringBuilder("on logout error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(b, stringBuilder.toString());
    }
}
