package com.igexin.push.e;

import android.content.Context;
import com.igexin.b.a.b.c;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.g;
import com.igexin.push.d.b;
import com.igexin.push.d.c.a;
import com.igexin.push.d.c.d;
import com.igexin.push.d.c.e;
import com.igexin.push.d.c.f;
import com.igexin.push.d.c.i;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.m;
import com.igexin.push.d.c.n;
import com.igexin.push.d.c.o;
import com.igexin.push.d.c.p;
import com.igexin.push.d.c.q;
import com.igexin.push.d.h;

public class j {
    private static String a = "com.igexin.push.e.j";
    private c b;
    private k c;
    private boolean d;
    private long e = 0;
    private long f = 0;
    private boolean g;

    private String b(e eVar) {
        StringBuilder stringBuilder;
        String a;
        String str = "";
        if (eVar instanceof f) {
            stringBuilder = new StringBuilder("R-");
            a = ((f) eVar).a();
        } else if (eVar instanceof q) {
            stringBuilder = new StringBuilder("R-");
            a = ((q) eVar).b;
        } else {
            long j;
            if (eVar instanceof k) {
                stringBuilder = new StringBuilder("S-");
                j = ((k) eVar).a;
            } else {
                if (eVar instanceof m) {
                    m mVar = (m) eVar;
                    if (mVar.e != 0) {
                        stringBuilder = new StringBuilder("S-");
                        j = mVar.e;
                    }
                } else if (eVar instanceof n) {
                    stringBuilder = new StringBuilder("S-");
                    j = ((n) eVar).a;
                } else if (eVar instanceof o) {
                    stringBuilder = new StringBuilder("S-");
                    j = ((o) eVar).e;
                } else if (eVar instanceof d) {
                    stringBuilder = new StringBuilder("C-");
                    a = ((d) eVar).g;
                } else if (eVar instanceof p) {
                    stringBuilder = new StringBuilder("C-");
                    a = ((p) eVar).g;
                } else if (eVar instanceof a) {
                    stringBuilder = new StringBuilder("C-");
                    a = ((a) eVar).d;
                } else if (eVar instanceof com.igexin.push.d.c.c) {
                    stringBuilder = new StringBuilder("C-");
                    a = ((com.igexin.push.d.c.c) eVar).d;
                }
                return str;
            }
            a = String.valueOf(j);
        }
        stringBuilder.append(a);
        return stringBuilder.toString();
    }

    private boolean c() {
        if (com.igexin.push.config.m.n && this.e + this.f >= com.igexin.push.config.m.o) {
            a aVar = new a();
            aVar.a(com.igexin.push.core.c.check);
            com.igexin.push.core.f.a().h().a(aVar);
        }
        return false;
    }

    public int a(String str, e eVar) {
        return a(str, eVar, false);
    }

    public int a(String str, e eVar, boolean z) {
        if (str != null) {
            if (eVar != null) {
                if (!g.l && !(eVar instanceof i) && !(eVar instanceof k) && !(eVar instanceof f)) {
                    StringBuilder stringBuilder = new StringBuilder("snl|sendData|not online|");
                    stringBuilder.append(eVar.getClass().getName());
                    com.igexin.b.a.c.a.a(stringBuilder.toString());
                    return -3;
                } else if (!this.d) {
                    return com.igexin.push.core.f.a().h().a(str, eVar);
                } else {
                    if (z) {
                        int i = 10;
                        if (com.igexin.push.config.m.e > 0) {
                            i = com.igexin.push.config.m.e;
                        }
                        if (this.b.a(SDKUrlConfig.getCmAddress(), 3, com.igexin.push.core.f.a().f(), eVar, true, i, new h()) == null) {
                            return -2;
                        }
                    } else if (this.b.a(SDKUrlConfig.getCmAddress(), 3, com.igexin.push.core.f.a().f(), eVar, true) == null) {
                        return -2;
                    }
                    byte[] d = eVar.d();
                    if (d != null) {
                        this.f += ((long) d.length) + 8;
                    } else {
                        this.f += 8;
                    }
                    c();
                    return 0;
                }
            }
        }
        return -1;
    }

    public void a(Context context, c cVar, k kVar) {
        this.b = cVar;
        this.c = kVar;
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (this.d) {
                String b = b(eVar);
                if (!b.equals("S-") && !b.equals("R-")) {
                    byte[] d;
                    if (b.length() > 0 && !b.equals("C-")) {
                        StringBuilder stringBuilder = new StringBuilder("C-");
                        stringBuilder.append(g.r);
                        if (!b.equals(stringBuilder.toString())) {
                            stringBuilder = new StringBuilder("R-");
                            stringBuilder.append(g.B);
                            if (!b.equals(stringBuilder.toString())) {
                                stringBuilder = new StringBuilder("S-");
                                stringBuilder.append(g.q);
                                if (!b.equals(stringBuilder.toString())) {
                                    com.igexin.push.core.f.a().h().b(b, eVar);
                                    d = eVar.d();
                                    if (d == null) {
                                        this.e += ((long) d.length) + 8;
                                    } else {
                                        this.e += 8;
                                    }
                                    c();
                                    return;
                                }
                            }
                        }
                    }
                    if (this.c != null) {
                        this.c.a(eVar);
                    }
                    d = eVar.d();
                    if (d == null) {
                        this.e += 8;
                    } else {
                        this.e += ((long) d.length) + 8;
                    }
                    c();
                    return;
                }
                return;
            }
            if (this.c != null) {
                this.c.a(eVar);
            }
        }
    }

    public void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|call setASNL, param isASNL = ");
        stringBuilder.append(z);
        stringBuilder.append("; this.isASNL = ");
        stringBuilder.append(this.d);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (this.d != z) {
            this.d = z;
            this.g = false;
            StringBuilder stringBuilder2;
            if (z) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("|commit reconnectCheckNotify");
                com.igexin.b.a.c.a.b(stringBuilder2.toString());
                this.f = 0;
                this.e = 0;
                com.igexin.push.core.a.f.a().d(true);
                return;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|isASNL = false, this.isASNL = true, disconnect tcp !!!");
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            com.igexin.push.core.a.f.a().f();
        }
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        g.E = 0;
        if (!this.d && this.c != null) {
            this.c.b();
        }
    }

    public void b(boolean z) {
        if (g.l) {
            g.l = false;
            com.igexin.push.core.a.f.a().l();
        }
        com.igexin.push.c.a e = com.igexin.push.c.i.a().e();
        StringBuilder stringBuilder;
        if (z) {
            e.i();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|disconnected by user ####");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|disconnected by network ####");
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            com.igexin.push.core.i.a().a(com.igexin.push.core.k.NETWORK_ERROR);
            e.i();
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|autoReconnect notifyNetworkDisconnected");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            com.igexin.push.core.a.f.a().d(true);
        }
        if (this.d) {
            com.igexin.push.core.f.a().h().b();
            return;
        }
        if (this.c != null) {
            this.c.a(z);
        }
    }

    public void c(boolean z) {
        g.E = b.a().c().a(z);
        com.igexin.push.c.i.a().e().c();
        com.igexin.push.f.b.g.g().h();
    }
}
