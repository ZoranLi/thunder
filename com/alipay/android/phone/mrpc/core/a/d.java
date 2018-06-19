package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.e;
import com.alipay.android.phone.mrpc.core.RpcException;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    public final Object a() {
        try {
            String str = new String(this.b);
            StringBuilder stringBuilder = new StringBuilder("threadid = ");
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append("; rpc response:  ");
            stringBuilder.append(str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                return this.a == String.class ? jSONObject.optString("result") : e.a(jSONObject.optString("result"), this.a);
            } else {
                throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
            }
        } catch (Exception e) {
            Integer valueOf = Integer.valueOf(10);
            StringBuilder stringBuilder2 = new StringBuilder("response  =");
            stringBuilder2.append(new String(this.b));
            stringBuilder2.append(Constants.COLON_SEPARATOR);
            stringBuilder2.append(e);
            throw new RpcException(valueOf, stringBuilder2.toString() == null ? "" : e.getMessage());
        }
    }
}
