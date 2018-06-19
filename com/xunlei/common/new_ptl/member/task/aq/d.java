package com.xunlei.common.new_ptl.member.task.aq;

import android.os.Bundle;
import anet.channel.util.HttpConstant;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserAqSendMessageTask */
public final class d extends a {
    private String a = "";

    public d(p pVar) {
        super(pVar);
    }

    public final void a(String str) {
        this.a = str;
    }

    public final boolean h() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://dynamic.aq.xunlei.com/interface/script?m=third_set_mobile_send&mobile=");
        stringBuffer.append(this.a);
        stringBuffer.append("&bussnessid=");
        stringBuffer.append(d().d());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("userid=");
        stringBuffer2.append(e().getLongValue(USERINFOKEY.UserID));
        stringBuffer2.append(";sessionid=");
        stringBuffer2.append(e().getStringValue(USERINFOKEY.SessionID));
        d().l().get(d().h(), stringBuffer.toString(), new Header[]{new XLHttpHeader(HttpConstant.COOKIE, stringBuffer2.toString())}, new 1(this));
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserAqSendMessage(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    static /* synthetic */ void a(d dVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        dVar.d().a((a) dVar, bundle);
    }
}
