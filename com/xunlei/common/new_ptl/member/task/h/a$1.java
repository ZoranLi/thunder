package com.xunlei.common.new_ptl.member.task.h;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserAlipayLoginTask */
final class a$1 extends b {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        headerArr = new StringBuilder("login request response = ");
        headerArr.append(str);
        XLLog.v("UserAlipayLoginTask", headerArr.toString());
        a.a(this.a, str);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserAlipayLoginTask", stringBuilder.toString());
        a.a(this.a, a.a(th));
    }
}
