package com.xunlei.downloadprovider.broadcast;

/* compiled from: XLBroadcastManager */
class a$a$a {
    b a;

    a$a$a(b bVar) {
        this.a = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                a$a$a com_xunlei_downloadprovider_broadcast_a_a_a = (a$a$a) obj;
                if (this.a != null) {
                    return this.a.equals(com_xunlei_downloadprovider_broadcast_a_a_a.a);
                }
                return com_xunlei_downloadprovider_broadcast_a_a_a.a == null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a != null ? this.a.hashCode() : 0;
    }
}
