package com.xunlei.downloadprovider.download.engine.task.a;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.z;
import java.util.List;

/* compiled from: CoreTaskWrapper */
public class k extends z implements r<z> {
    @NonNull
    protected volatile z a;

    public void a(z zVar, String str) {
    }

    public final long[] a(int i) {
        return null;
    }

    public k(@NonNull z zVar) {
        this.a = zVar;
        if ((this.a instanceof a) != null) {
            ((a) this.a).a(this);
        }
    }

    public long a() {
        return this.a.a();
    }

    public int b() {
        return this.a.b();
    }

    public TaskInfo c() {
        return this.a.c();
    }

    public boolean d() {
        return this.a.d();
    }

    public long f() {
        return this.a.f();
    }

    public final List<BTSubTaskInfo> g() {
        return this.a.g();
    }

    public final BTSubTaskInfo b(int i) {
        return this.a.b(i);
    }

    public final void h() {
        this.a.h();
    }
}
