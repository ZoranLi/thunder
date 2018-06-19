package com.xunlei.common.new_ptl.member.task.b;

import android.os.Bundle;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserUnBindOtherAccountTask */
public final class d extends a {
    private int a = -1;

    static /* synthetic */ int a(d dVar, int i) {
        if (i == 200) {
            return 0;
        }
        if (i == 407) {
            return 20001;
        }
        return i == 600 ? 13 : i == 501 ? 20002 : XLErrorCode.UNBIND_ERROR;
    }

    private static int h(int i) {
        if (i == 200) {
            return 0;
        }
        if (i == 407) {
            return 20001;
        }
        return i == 600 ? 13 : i == 501 ? 20002 : XLErrorCode.UNBIND_ERROR;
    }

    public d(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("module=unbind&session_id=");
            stringBuffer.append(e().getStringValue(USERINFOKEY.SessionID));
            stringBuffer.append("&uid=");
            stringBuffer.append(e().getLongValue(USERINFOKEY.UserID));
            stringBuffer.append("&business_id=");
            stringBuffer.append(d().d());
            stringBuffer.append("&third_type=");
            int i = -1;
            if (this.a == 21) {
                i = 21;
            } else if (this.a == 1) {
                i = 1;
            } else if (this.a == 15) {
                i = 15;
            } else if (this.a == 4) {
                i = 4;
            } else {
                int i2 = this.a;
            }
            stringBuffer.append(i);
            d().l().post(d().h(), "http://login.i.xunlei.com/thirdlogin4/entrance.php", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new 1(this));
            return false;
        }
        XLLog.v(getClass().getSimpleName(), "user is not login!");
        g(XLErrorCode.OPERATION_INVALID);
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserUnBindeOtherAccount(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.a, f(), g());
            }
        }
        return null;
    }

    public final void f(int i) {
        this.a = i;
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    private int m() {
        if (this.a == 21) {
            return 21;
        }
        if (this.a == 1) {
            return 1;
        }
        if (this.a == 15) {
            return 15;
        }
        if (this.a == 4) {
            return 4;
        }
        int i = this.a;
        return -1;
    }
}
