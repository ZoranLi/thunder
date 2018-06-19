package com.xunlei.downloadprovider.download.engine.task;

/* compiled from: TaskRequest */
public class x<T> {
    private final a<T> a;
    public boolean e;

    /* compiled from: TaskRequest */
    public interface a<T> {
        void a(T t);
    }

    public x(a<T> aVar) {
        this.a = aVar;
    }

    public final void a(T t) {
        if (this.a != null) {
            this.a.a(t);
        }
    }
}
