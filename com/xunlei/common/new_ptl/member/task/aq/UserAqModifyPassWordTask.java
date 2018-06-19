package com.xunlei.common.new_ptl.member.task.aq;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.WebView;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.d;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask;
import java.lang.ref.WeakReference;

public final class UserAqModifyPassWordTask extends UserAqWebViewTask {
    private static final String d = "http://aq.xunlei.com/wap/changePwd.html";
    private static final String e = "https://login.xunlei.com/jump/?jump_key=%s&u1=%s&v=100&business_type=%d";
    private static final int f = 115;
    private XLOnUserListener g = new 1(this);

    protected final void a(String str) {
    }

    public UserAqModifyPassWordTask(p pVar) {
        super(pVar);
    }

    public final void a(@NonNull WebView webView) {
        this.b = "xlAQInstance";
        this.c = (WebView) new WeakReference(webView).get();
        if (this.c != null) {
            this.c.addJavascriptInterface(new XLModifyPassWordJSInterface(this, null), this.b);
        }
    }

    protected final String m() {
        XLUserInfo i = p.a().i();
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder("user id = ");
        stringBuilder.append(i.getLongValue(USERINFOKEY.UserID));
        stringBuilder.append("# jumpkey = ");
        stringBuilder.append(i.getJumpKey(115));
        XLLog.v(str, stringBuilder.toString());
        String format = String.format(e, new Object[]{i.getJumpKey(115), URLCoder.encode(d, "UTF-8"), Integer.valueOf(p.a().d())});
        str = this.a;
        stringBuilder = new StringBuilder("modify password url = ");
        stringBuilder.append(format);
        XLLog.v(str, stringBuilder.toString());
        return format;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    private void c(int i, String str, String str2) {
        b(i, str, str2);
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                String simpleName = getClass().getSimpleName();
                StringBuilder stringBuilder = new StringBuilder("fireEvent listener = ");
                stringBuilder.append(xLOnUserListener.toString());
                XLLog.v(simpleName, stringBuilder.toString());
                return xLOnUserListener.onUserModifyPassWord(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    public final void b(int i, String str, String str2) {
        String simpleName = getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder("receiveModifyResult error = ");
        stringBuilder.append(i);
        stringBuilder.append("#error desc = ");
        stringBuilder.append(str);
        XLLog.v(simpleName, stringBuilder.toString());
        if (((i == 0 ? 1 : 0) & (TextUtils.isEmpty(str2) ^ 1)) != 0) {
            d.a(new d(e().getLongValue(USERINFOKEY.UserID), "", "", str2), d().h(), d.a.a);
            e().clearUserData();
            d().a(true, this.g, (Object) "xl-modify-psw-auto-login");
            return;
        }
        f(i);
    }
}
