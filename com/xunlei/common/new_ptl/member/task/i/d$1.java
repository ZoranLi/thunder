package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;

/* compiled from: UserGetLixianCapacityTask */
final class d$1 implements BaseHttpClientListener {
    private /* synthetic */ d a;

    d$1(d dVar) {
        this.a = dVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new Bundle();
        headerArr = new String(bArr);
        XLLog.v("UserGetLixianCapacity result", headerArr);
        if (d.a(this.a, headerArr) != null) {
            i.putInt("errorCode", null);
        } else {
            i.putInt("errorCode", 16781312);
        }
        i.putString("action", "user_get_lixian_capacity");
        this.a.d().a(this.a, i);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserGetLixianCapacity", stringBuilder.toString());
        th = new Bundle();
        th.putString("action", "user_get_lixian_capacity");
        th.putInt("errorCode", XLErrorCode.UNKNOWN_ERROR);
        this.a.d().a(this.a, th);
    }
}
