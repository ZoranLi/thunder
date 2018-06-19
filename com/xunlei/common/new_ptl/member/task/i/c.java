package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserGetHighSpeedCapacityTask */
public final class c extends a {
    private XLHspeedCapacity a = null;

    public c(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            a(a.a.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://dy.cdn.vip.xunlei.com:80/fcg-bin/cgi_query_capacity.fcg?userid=");
            stringBuilder.append(d().i().getStringValue(USERINFOKEY.UserID));
            d().l().get(d().h(), stringBuilder.toString(), null, new 1(this));
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "user_get_high_speed_capacity");
        bundle.putInt("errorCode", XLErrorCode.OPERATION_INVALID);
        d().a((a) this, bundle);
        return false;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "user_get_high_speed_capacity") {
                return xLOnUserListener.onHighSpeedCatched(bundle.getInt("errorCode"), XLErrorCode.getErrorDesc(bundle.getInt("errorCode")), "", e(), this.a, f(), g());
            }
        }
        return null;
    }
}
