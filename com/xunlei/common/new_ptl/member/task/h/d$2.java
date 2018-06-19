package com.xunlei.common.new_ptl.member.task.h;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserWxLoginTask */
final class d$2 extends b {
    private /* synthetic */ d a;

    d$2(d dVar) {
        this.a = dVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        headerArr = new StringBuilder("login request response = ");
        headerArr.append(str);
        XLLog.v("UserWxLoginTask", headerArr.toString());
        d.a(this.a, str);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserWxLoginTask", stringBuilder.toString());
        d.a(this.a, a.a(th));
    }
}
