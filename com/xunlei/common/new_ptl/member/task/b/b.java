package com.xunlei.common.new_ptl.member.task.b;

import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserCheckBindOtherAccountTask */
public final class b extends a {
    private XLBindedOtherAccountItem[] a = new XLBindedOtherAccountItem[null];

    static /* synthetic */ int a(b bVar, int i) {
        return i == 200 ? 0 : i == 600 ? 13 : i == 502 ? 20000 : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 600 ? 13 : i == 502 ? 20000 : XLErrorCode.UNKNOWN_ERROR;
    }

    public b(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("module=bind_list&session_id=");
            stringBuffer.append(e().getStringValue(USERINFOKEY.SessionID));
            stringBuffer.append("&uid=");
            stringBuffer.append(e().getLongValue(USERINFOKEY.UserID));
            stringBuffer.append("&business_id=");
            stringBuffer.append(d().d());
            d().l().post(d().h(), "http://login.i.xunlei.com/thirdlogin4/entrance.php", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new 1(this));
            return false;
        }
        XLLog.v(getClass().getSimpleName(), "user is not login!");
        f(XLErrorCode.OPERATION_INVALID);
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserGetBindedOtherAccount(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.a, f(), g());
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

    private static int a(String str) {
        if (Token.WX_TOKEN_PLATFORMID_VALUE.equals(str)) {
            return 21;
        }
        if ("sina".equals(str)) {
            return 1;
        }
        if ("qq".equals(str)) {
            return 15;
        }
        if ("alipay".equals(str)) {
            return 4;
        }
        return "xm".equals(str) != null ? 8 : -1;
    }

    static /* synthetic */ int a(b bVar, String str) {
        if (Token.WX_TOKEN_PLATFORMID_VALUE.equals(str) != null) {
            return 21;
        }
        if ("sina".equals(str) != null) {
            return 1;
        }
        if ("qq".equals(str) != null) {
            return 15;
        }
        if ("alipay".equals(str) != null) {
            return 4;
        }
        return "xm".equals(str) != null ? 8 : -1;
    }
}
