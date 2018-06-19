package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserGetHighSpeedCapacityTask */
final class c$1 implements BaseHttpClientListener {
    private /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        XLLog.v("UserGetHighSpeedCapacity result", i);
        try {
            headerArr = new JSONObject(i.toString());
            c.a(this.a, new XLHspeedCapacity());
            c.a(this.a).total_capacity = headerArr.optLong("total_capacity");
            c.a(this.a).used_capacity = headerArr.optLong("used_capacity");
            c.a(this.a).solidify_capacity = headerArr.optLong("solidify_capacity");
            c.a(this.a).fluxcard_total_capacity = headerArr.optLong("fluxcard_total_capacity");
            c.a(this.a).fluxcard_invalid_capacity = headerArr.optLong("fluxcard_invalid_capacity");
            c.a(this.a).fluxcard_pause_capacity = headerArr.optLong("fluxcard_pause_capacity");
            i = new Bundle();
            i.putInt("errorCode", null);
            i.putString("action", "user_get_high_speed_capacity");
            this.a.d().a(this.a, i);
        } catch (int i2) {
            i2.printStackTrace();
            i2 = new Bundle();
            i2.putInt("errorCode", 16781314);
            i2.putString("action", "user_get_high_speed_capacity");
            this.a.d().a(this.a, i2);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        XLLog.e("UserGetHighSpeedCapacity error", th.getMessage());
        th = new Bundle();
        th.putString("action", "user_get_high_speed_capacity");
        th.putInt("errorCode", XLErrorCode.UNKNOWN_ERROR);
        this.a.d().a(this.a, th);
    }
}
