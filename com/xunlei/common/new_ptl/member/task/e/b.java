package com.xunlei.common.new_ptl.member.task.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserMobileSendMessageTask */
public final class b extends a {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;

    public final void a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void f(int i) {
        this.d = i;
    }

    public b(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        JSONObject i = i();
        try {
            i.put("mobile", this.c);
            i.put("register", String.valueOf(this.d));
            if (!(TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b))) {
                i.put("verifyKey", this.a);
                i.put("verifyCode", this.b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder("send message request");
        stringBuilder.append(i.toString());
        XLLog.v("UserMobileSendMessageTask", stringBuilder.toString());
        d().k().a(i.toString().getBytes(), 9, new 1(this), g());
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userMobileSendMessageTask") {
                return xLOnUserListener.onUserMobileSendMessage(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.e, f(), g());
            }
        }
        return null;
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userMobileSendMessageTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.f)) {
            this.f = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.f);
        d().a((a) this, bundle);
    }

    static /* synthetic */ void a(b bVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userMobileSendMessageTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(bVar.f)) {
            bVar.f = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", bVar.f);
        bVar.d().a((a) bVar, bundle);
    }
}
