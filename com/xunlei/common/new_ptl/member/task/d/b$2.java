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

/* compiled from: UserLoginTask */
final class b$2 extends b {
    private /* synthetic */ b a;

    b$2(b bVar) {
        this.a = bVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        headerArr = new StringBuilder("login request response = ");
        headerArr.append(str);
        XLLog.v("UserLoginTask", headerArr.toString());
        try {
            i = new JSONObject(str);
            headerArr = i.getInt("errorCode");
            if (headerArr != null && headerArr < 10000) {
                b.a(this.a, XLUtilTools.transformUTF8String(i.optString("errorDesc")));
            }
            b.b(this.a, i.optString("errorDescUrl"));
            if (headerArr == null) {
                this.a.e().clearUserData();
                this.a.d().b(i.optString("secureKey"));
                this.a.e().a(i);
                d.a(new d(this.a.e().getLongValue(USERINFOKEY.UserID), "", "", i.optString("loginKey")), this.a.d().h(), a.a);
                this.a.e().a(this.a.d().h());
                if (this.a.c() != com.xunlei.common.new_ptl.member.task.a.a.d) {
                    this.a.d().a(1, 0);
                }
                b.a(this.a, 0);
                p.a().o();
            } else {
                if (headerArr == 6) {
                    i = i.optString("verifyType");
                    if (TextUtils.isEmpty(i) == null) {
                        this.a.d().c(i);
                    }
                    StringBuilder stringBuilder = new StringBuilder("need verify code type = ");
                    stringBuilder.append(i);
                    XLLog.v("UserLoginTask", stringBuilder.toString());
                } else if (headerArr == 17) {
                    str = i.optString("msgurl", null);
                    String a = b.a(this.a);
                    StringBuilder stringBuilder2 = new StringBuilder("verify mobile = ");
                    stringBuilder2.append(str);
                    XLLog.v(a, stringBuilder2.toString());
                    b.a(this.a, i.optLong("userID", 0));
                    if (TextUtils.isEmpty(str) == 0 && b.b(this.a) != 0) {
                        b.a(this.a, str, b.b(this.a));
                        return;
                    }
                }
                b.a(this.a, headerArr);
            }
        } catch (int i2) {
            i2.printStackTrace();
            b.a(this.a, 16781314);
        }
        this.a.a(com.xunlei.common.new_ptl.member.task.a.a.c);
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserLoginTask", stringBuilder.toString());
        b.a(this.a, com.xunlei.common.new_ptl.member.task.a.a(th));
        this.a.a(com.xunlei.common.new_ptl.member.task.a.a.c);
    }
}
