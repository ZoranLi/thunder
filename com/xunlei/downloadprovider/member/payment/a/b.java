package com.xunlei.downloadprovider.member.payment.a;

import android.os.Handler;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import org.json.JSONObject;

/* compiled from: ActivationBox */
final class b implements com.android.volley.n.b<JSONObject> {
    final /* synthetic */ Handler a;
    final /* synthetic */ a b;

    b(a aVar, Handler handler) {
        this.b = aVar;
        this.a = handler;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            int optInt = jSONObject.optInt("result");
            obj = jSONObject.optString("message");
            Message obtainMessage;
            if (optInt == 0) {
                obtainMessage = this.a.obtainMessage(SecExceptionCode.SEC_ERROR_UMID_SERVER_RESP_INVALID);
                obtainMessage.obj = obj;
                obtainMessage.sendToTarget();
                return;
            }
            obtainMessage = this.a.obtainMessage(SecExceptionCode.SEC_ERROR_UMID_ENVIRONMENT_CHANGED);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
    }
}
