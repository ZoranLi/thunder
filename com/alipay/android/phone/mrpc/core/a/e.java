package com.alipay.android.phone.mrpc.core.a;

import com.alipay.a.a.f;
import com.alipay.android.phone.mrpc.core.RpcException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class e extends b {
    private int c;
    private Object d;

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final byte[] a() {
        StringBuilder stringBuilder;
        try {
            List arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", f.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.a));
            String str = AgooConstants.MESSAGE_ID;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            arrayList.add(new BasicNameValuePair(str, stringBuilder.toString()));
            new StringBuilder("mParams is:").append(this.b);
            arrayList.add(new BasicNameValuePair("requestData", this.b == null ? "[]" : f.a(this.b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Throwable e) {
            Integer valueOf = Integer.valueOf(9);
            stringBuilder = new StringBuilder("request  =");
            stringBuilder.append(this.b);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(e);
            throw new RpcException(valueOf, stringBuilder.toString() == null ? "" : e.getMessage(), e);
        }
    }
}
