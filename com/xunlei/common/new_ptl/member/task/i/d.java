package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserGetLixianCapacityTask */
public final class d extends a {
    private XLLixianCapacity a = null;

    private boolean a(String str) {
        boolean z = true;
        if (str != null) {
            try {
                this.a = new XLLixianCapacity();
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    return false;
                }
                String substring = str.substring(0, indexOf);
                this.a.total_capacity = Double.valueOf(substring).doubleValue();
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    return false;
                }
                substring = str.substring(0, indexOf);
                this.a.used_capacity = Double.valueOf(substring).doubleValue();
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    return false;
                }
                substring = str.substring(0, indexOf);
                this.a.finished_task = Integer.valueOf(substring).intValue();
                str = str.substring(indexOf + 1);
                int indexOf2 = str.indexOf(44);
                if (indexOf2 == -1) {
                    return false;
                }
                String substring2 = str.substring(0, indexOf2);
                this.a.expired_task = Integer.valueOf(substring2).intValue();
                str = str.substring(indexOf2 + 1);
                this.a.once_task = Integer.valueOf(str).intValue();
            } catch (String str2) {
                str2.printStackTrace();
                return false;
            }
        }
        z = false;
        return z;
    }

    public d(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            a(a.a.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://dynamic.cloud.vip.xunlei.com/interface/query_user_info?uid=");
            stringBuilder.append(d().i().getStringValue(USERINFOKEY.UserID));
            d().l().get(d().h(), stringBuilder.toString(), null, new 1(this));
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "user_get_lixian_capacity");
        bundle.putInt("errorCode", XLErrorCode.OPERATION_INVALID);
        d().a((a) this, bundle);
        return false;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "user_get_lixian_capacity") {
                return xLOnUserListener.onLixianCatched(bundle.getInt("errorCode"), XLErrorCode.getErrorDesc(bundle.getInt("errorCode")), "", e(), this.a, f(), g());
            }
        }
        return null;
    }
}
