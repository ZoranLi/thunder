package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.mpcd.b;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.u;

public class e implements b {
    private Context a;

    public e(Context context) {
        this.a = context;
    }

    public String a() {
        return c.a(this.a).f();
    }

    public void a(ai aiVar, a aVar, u uVar) {
        ac.a(this.a).a((org.apache.thrift.a) aiVar, aVar, uVar);
    }
}
