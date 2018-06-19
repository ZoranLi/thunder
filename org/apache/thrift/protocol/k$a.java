package org.apache.thrift.protocol;

import org.apache.thrift.protocol.a.a;
import org.apache.thrift.transport.d;

public class k$a extends a {
    public k$a() {
        super(false, true);
    }

    public k$a(boolean z, boolean z2, int i) {
        super(z, z2, i);
    }

    public e a(d dVar) {
        e kVar = new k(dVar, this.a, this.b);
        if (this.c != 0) {
            kVar.c(this.c);
        }
        return kVar;
    }
}
