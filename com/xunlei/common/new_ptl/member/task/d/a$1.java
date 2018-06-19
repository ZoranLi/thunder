package com.xunlei.common.new_ptl.member.task.d;

import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.a.d;
import com.xunlei.common.new_ptl.member.a.d.a;
import com.xunlei.common.new_ptl.member.a.p;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserKeyLoginTask */
final class a$1 extends b {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        XLLog.v("UserKeyLoginTask", str);
        try {
            i = new JSONObject(str);
            str = new StringBuilder("result json objet = ");
            str.append(i.toString());
            XLLog.v("UserKeyLoginTask", str.toString());
            headerArr = i.getInt("errorCode");
            if (headerArr != null && headerArr < 10000) {
                a.a(this.a, XLUtilTools.transformUTF8String(i.optString("errorDesc")));
            }
            a.b(this.a, i.optString("errorDescUrl"));
            if (headerArr == null) {
                this.a.e().clearUserData();
                this.a.d().b(i.optString("secureKey"));
                XLLog.v("UserKeyLoginTask", "start to obtain xl user info.");
                this.a.e().a(i);
                Object optString = i.optString("loginKey");
                if (TextUtils.isEmpty(optString) == 0) {
                    d.a(new d(this.a.e().getLongValue(USERINFOKEY.UserID), "", "", optString), this.a.d().h(), a.a);
                }
                this.a.e().a(this.a.d().h());
                a.a(this.a, 0);
                if (this.a.c() != com.xunlei.common.new_ptl.member.task.a.a.d) {
                    this.a.d().a(true, 0);
                }
                p.a().o();
            } else {
                if (!(a.b(this.a, headerArr) == 0 && a.c(this.a, headerArr) == 0)) {
                    if (a.d(this.a, headerArr) != 0) {
                        d.a(this.a.d().h(), a.b);
                    }
                    if (a.e(this.a, headerArr) != 0) {
                        this.a.e().clearUserData();
                    }
                }
                a.a(this.a, headerArr);
            }
        } catch (int i2) {
            i2.printStackTrace();
            a.a(this.a, 16781314);
        }
        this.a.a(com.xunlei.common.new_ptl.member.task.a.a.c);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserKeyLoginTask", stringBuilder.toString());
        a.a(this.a, com.xunlei.common.new_ptl.member.task.a.a(th));
        this.a.a(com.xunlei.common.new_ptl.member.task.a.a.c);
    }
}
