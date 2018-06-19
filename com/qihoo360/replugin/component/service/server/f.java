package com.qihoo360.replugin.component.service.server;

import java.util.concurrent.Callable;

/* compiled from: PluginServiceServer */
final class f implements Callable<Boolean> {
    final /* synthetic */ i a;
    final /* synthetic */ d b;

    f(d dVar, i iVar) {
        this.b = dVar;
        this.a = iVar;
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf(this.b.c(this.a));
    }
}
