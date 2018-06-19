package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiTinyDataClient.a;
import com.xiaomi.push.service.be;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MiTinyDataClient$a$a {
    public final ArrayList<f> a = new ArrayList();
    final /* synthetic */ a b;
    private ScheduledThreadPoolExecutor c = new ScheduledThreadPoolExecutor(1);
    private ScheduledFuture<?> d;
    private final Runnable e = new s(this);

    public MiTinyDataClient$a$a(a aVar) {
        this.b = aVar;
    }

    private void a() {
        if (this.d == null) {
            this.d = this.c.scheduleAtFixedRate(this.e, 1000, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void b() {
        f fVar = (f) this.a.remove(0);
        for (ai aiVar : be.a(Arrays.asList(new f[]{fVar}), a.a(this.b).getPackageName(), c.a(a.a(this.b)).c(), 30720)) {
            StringBuilder stringBuilder = new StringBuilder("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification).");
            stringBuilder.append(fVar.d());
            b.c(stringBuilder.toString());
            ac.a(a.a(this.b)).a(aiVar, com.xiaomi.xmpush.thrift.a.i, true, null);
        }
    }

    public void a(f fVar) {
        this.c.execute(new r(this, fVar));
    }
}
