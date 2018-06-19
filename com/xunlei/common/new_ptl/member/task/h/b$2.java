package com.xunlei.common.new_ptl.member.task.h;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserQQLoginTask */
final class b$2 extends b {
    private /* synthetic */ b a;

    b$2(b bVar) {
        this.a = bVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        headerArr = new StringBuilder("login request response = ");
        headerArr.append(str);
        XLLog.v("UserSinaLoginTask", headerArr.toString());
        b.a(this.a, str);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserWxLoginTask", stringBuilder.toString());
        b.a(this.a, a.a(th));
    }
}
