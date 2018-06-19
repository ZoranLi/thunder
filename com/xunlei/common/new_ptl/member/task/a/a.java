package com.xunlei.common.new_ptl.member.task.a;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;

/* compiled from: UserGetRecommendAvatarsTask */
public final class a extends com.xunlei.common.new_ptl.member.task.a {
    private final String a;
    private XLAvatarItem[] b;

    static /* synthetic */ int a(a aVar, int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    public a(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        String format = String.format("http://img.user.kanimg.com/avatar/get_recommend_avatars?sessionid=%s&userid=%d&businesstype=%d&recommendsize=300x300", new Object[]{e().getStringValue(USERINFOKEY.SessionID), Long.valueOf(e().getLongValue(USERINFOKEY.UserID)), Integer.valueOf(d().d())});
        String simpleName = getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder("UserGetRecommendAvatarsTask execute url = ");
        stringBuilder.append(format);
        XLLog.v(simpleName, stringBuilder.toString());
        d().l().get(d().h(), format, null, new 1(this));
        return false;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserGetRecommendAvatars(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.b, f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
    }

    static /* synthetic */ void b(a aVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        aVar.d().a((com.xunlei.common.new_ptl.member.task.a) aVar, bundle);
    }
}
