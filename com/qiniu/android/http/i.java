package com.qiniu.android.http;

import com.qiniu.android.d.b;
import java.io.IOException;
import okhttp3.aa;
import okhttp3.ag;
import okio.e;
import okio.f;
import okio.h;
import okio.m;
import okio.u;

/* compiled from: CountingRequestBody */
public final class i extends ag {
    final l a;
    final long b;
    final CancellationHandler c;
    private final ag d;

    /* compiled from: CountingRequestBody */
    protected final class a extends h {
        final /* synthetic */ i a;
        private int b = null;

        public a(i iVar, u uVar) {
            this.a = iVar;
            super(uVar);
        }

        public final void a_(e eVar, long j) throws IOException {
            if (this.a.c == null && this.a.a == null) {
                super.a_(eVar, j);
                return;
            }
            super.a_(eVar, j);
            this.b = (int) (((long) this.b) + j);
            if (this.a.a != null) {
                b.a(new j(this));
            }
        }
    }

    public i(ag agVar, l lVar, long j, CancellationHandler cancellationHandler) {
        this.d = agVar;
        this.a = lVar;
        this.b = j;
        this.c = cancellationHandler;
    }

    public final long a() throws IOException {
        return this.d.a();
    }

    public final aa b() {
        return this.d.b();
    }

    public final void a(f fVar) throws IOException {
        fVar = m.a(new a(this, fVar));
        this.d.a(fVar);
        fVar.flush();
    }
}
