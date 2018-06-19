package com.xunlei.downloadprovider.member.payment.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.R;

/* compiled from: ActivationBox */
final class c implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ Handler b;
    final /* synthetic */ a c;

    c(a aVar, Context context, Handler handler) {
        this.c = aVar;
        this.a = context;
        this.b = handler;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("onFailure ").append(volleyError.getMessage());
        String string = this.a.getString(R.string.activation_fail);
        Message obtainMessage = this.b.obtainMessage(SecExceptionCode.SEC_ERROR_UMID_ENVIRONMENT_CHANGED);
        obtainMessage.obj = string;
        obtainMessage.sendToTarget();
        volleyError.printStackTrace();
    }
}
