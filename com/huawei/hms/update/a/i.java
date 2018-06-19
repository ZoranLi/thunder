package com.huawei.hms.update.a;

import android.content.Context;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ThreadWrapper */
public class i implements a {
    private static final Executor b = Executors.newSingleThreadExecutor();
    private final a a;

    public i(a aVar) {
        com.huawei.hms.c.a.a(aVar, "update must not be null.");
        this.a = aVar;
    }

    public Context a() {
        return this.a.a();
    }

    public void b() {
        this.a.b();
    }

    public void a(b bVar) {
        b.execute(new j(this, bVar));
    }

    public void a(b bVar, c cVar) {
        b.execute(new k(this, bVar, cVar));
    }

    private static b c(b bVar) {
        return new l(bVar);
    }
}
