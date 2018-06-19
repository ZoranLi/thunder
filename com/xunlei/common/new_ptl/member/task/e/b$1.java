package com.xunlei.common.new_ptl.member.task.e;

import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.member.a.b;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserMobileSendMessageTask */
final class b$1 extends b {
    private /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public final void a(int i, Header[] headerArr, String str) {
        if (TextUtils.isEmpty(str) == 0) {
            try {
                i = new JSONObject(str);
                headerArr = i.getInt("errorCode");
                if (headerArr == 6) {
                    str = i.optString("verifyType");
                    if (!TextUtils.isEmpty(str)) {
                        this.a.d().c(str);
                    }
                }
                if (headerArr < 10000) {
                    b.a(this.a, XLUtilTools.transformUTF8String(i.optString("errorDesc")));
                }
                if (headerArr == null) {
                    b.b(this.a, i.optString("token"));
                    str = new StringBuilder("message token = ");
                    str.append(b.a(this.a));
                    XLLog.v("UserMobileSendMessageTask", str.toString());
                }
                b.a(this.a, headerArr);
                return;
            } catch (int i2) {
                i2.printStackTrace();
            }
        }
        b.a(this.a, 32);
    }

    public final void a(Throwable th) {
        b.a(this.a, a.a(th));
    }
}
