package anetwork.channel.e;

import anet.channel.request.Request;
import anetwork.channel.entity.f;
import anetwork.channel.entity.j;

/* compiled from: Taobao */
final class i {
    g a;

    /* compiled from: Taobao */
    class a {
        int a = null;
        final /* synthetic */ i b;
        private Request c = null;
        private anetwork.channel.d.a d = null;

        a(i iVar, int i, Request request, anetwork.channel.d.a aVar) {
            this.b = iVar;
            this.a = i;
            this.c = request;
            this.d = aVar;
        }
    }

    public i(j jVar, f fVar) {
        fVar.b = jVar.g;
        this.a = new g(jVar, fVar);
        jVar.f.start = System.currentTimeMillis();
    }
}
