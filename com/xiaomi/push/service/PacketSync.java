package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.util.h;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.protobuf.b.i;
import com.xiaomi.push.protobuf.b.j;
import com.xiaomi.push.protobuf.b.k;
import com.xiaomi.push.service.ap.c;
import com.xiaomi.smack.b;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;
import com.xunlei.download.DownloadManager;
import java.util.Date;

public class PacketSync {
    private XMPushService a;

    public interface PacketReceiveHandler extends Parcelable {
    }

    PacketSync(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(a aVar) {
        Object c = aVar.c();
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(h.b);
            Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(b.b(), false);
            if (fallbacksByHost != null && split.length > 0) {
                fallbacksByHost.a(split);
                this.a.a(20, null);
                this.a.a(true);
            }
        }
    }

    private void b(d dVar) {
        Object m = dVar.m();
        Object l = dVar.l();
        if (!TextUtils.isEmpty(m) && !TextUtils.isEmpty(l)) {
            ap.b b = ap.a().b(l, m);
            if (b != null) {
                g.a(this.a, b.a, (long) g.a(dVar.c()), true, System.currentTimeMillis());
            }
        }
    }

    private void c(com.xiaomi.slim.b bVar) {
        Object j = bVar.j();
        Object num = Integer.toString(bVar.c());
        if (!TextUtils.isEmpty(j) && !TextUtils.isEmpty(num)) {
            ap.b b = ap.a().b(num, j);
            if (b != null) {
                g.a(this.a, b.a, (long) bVar.l(), true, System.currentTimeMillis());
            }
        }
    }

    public void a(com.xiaomi.slim.b bVar) {
        if (5 != bVar.c()) {
            c(bVar);
        }
        try {
            b(bVar);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("handle Blob chid = ");
            stringBuilder.append(bVar.c());
            stringBuilder.append(" cmd = ");
            stringBuilder.append(bVar.a());
            stringBuilder.append(" packetid = ");
            stringBuilder.append(bVar.h());
            stringBuilder.append(" failure ");
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString(), e);
        }
    }

    public void a(d dVar) {
        if (!"5".equals(dVar.l())) {
            b(dVar);
        }
        String l = dVar.l();
        if (TextUtils.isEmpty(l)) {
            l = "1";
            dVar.l(l);
        }
        if (l.equals("0")) {
            StringBuilder stringBuilder = new StringBuilder("Received wrong packet with chid = 0 : ");
            stringBuilder.append(dVar.c());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        }
        if (dVar instanceof com.xiaomi.smack.packet.b) {
            a p = dVar.p("kick");
            if (p != null) {
                String m = dVar.m();
                String a = p.a("type");
                String a2 = p.a(DownloadManager.COLUMN_REASON);
                stringBuilder = new StringBuilder("kicked by server, chid=");
                stringBuilder.append(l);
                stringBuilder.append(" userid=");
                stringBuilder.append(m);
                stringBuilder.append(" type=");
                stringBuilder.append(a);
                stringBuilder.append(" reason=");
                stringBuilder.append(a2);
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                if ("wait".equals(a)) {
                    ap.b b = ap.a().b(l, m);
                    if (b != null) {
                        this.a.a(b);
                        b.a(c.unbind, 3, 0, a2, a);
                    }
                    return;
                }
                this.a.a(l, m, 3, a2, a);
                ap.a().a(l, m);
                return;
            }
        } else if (dVar instanceof com.xiaomi.smack.packet.c) {
            com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) dVar;
            if ("redir".equals(cVar.a())) {
                a p2 = cVar.p(DispatchConstants.HOSTS);
                if (p2 != null) {
                    a(p2);
                }
                return;
            }
        }
        this.a.e().a(this.a, l, dVar);
    }

    public void b(com.xiaomi.slim.b bVar) {
        String a = bVar.a();
        StringBuilder stringBuilder;
        if (bVar.c() != 0) {
            String num = Integer.toString(bVar.c());
            if ("SECMSG".equals(bVar.a())) {
                if (bVar.d()) {
                    stringBuilder = new StringBuilder("Recv SECMSG errCode = ");
                    stringBuilder.append(bVar.e());
                    stringBuilder.append(" errStr = ");
                    stringBuilder.append(bVar.f());
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                    return;
                }
                this.a.e().a(this.a, num, bVar);
            } else if ("BIND".equals(a)) {
                com.xiaomi.push.protobuf.b.d b = com.xiaomi.push.protobuf.b.d.b(bVar.k());
                String j = bVar.j();
                ap.b b2 = ap.a().b(num, j);
                if (b2 != null) {
                    if (b.d()) {
                        stringBuilder = new StringBuilder("SMACK: channel bind succeeded, chid=");
                        stringBuilder.append(bVar.c());
                        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                        b2.a(c.binded, 1, 0, null, null);
                        return;
                    }
                    StringBuilder stringBuilder2;
                    c cVar;
                    int i;
                    int i2;
                    String f = b.f();
                    if ("auth".equals(f)) {
                        if ("invalid-sig".equals(b.h())) {
                            stringBuilder2 = new StringBuilder("SMACK: bind error invalid-sig token = ");
                            stringBuilder2.append(b2.c);
                            stringBuilder2.append(" sec = ");
                            stringBuilder2.append(b2.i);
                            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
                            com.xiaomi.stats.h.a(0, com.xiaomi.push.thrift.a.BIND_INVALID_SIG.a(), 1, null, 0);
                        }
                        cVar = c.unbind;
                        i = 1;
                        i2 = 5;
                    } else if ("cancel".equals(f)) {
                        cVar = c.unbind;
                        i = 1;
                        i2 = 7;
                    } else {
                        if ("wait".equals(f)) {
                            this.a.a(b2);
                            b2.a(c.unbind, 1, 7, b.h(), f);
                        }
                        stringBuilder2 = new StringBuilder("SMACK: channel bind failed, chid=");
                        stringBuilder2.append(num);
                        stringBuilder2.append(" reason=");
                        stringBuilder2.append(b.h());
                        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
                    }
                    b2.a(cVar, i, i2, b.h(), f);
                    ap.a().a(num, j);
                    stringBuilder2 = new StringBuilder("SMACK: channel bind failed, chid=");
                    stringBuilder2.append(num);
                    stringBuilder2.append(" reason=");
                    stringBuilder2.append(b.h());
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
                }
            } else if ("KICK".equals(a)) {
                com.xiaomi.push.protobuf.b.g b3 = com.xiaomi.push.protobuf.b.g.b(bVar.k());
                String j2 = bVar.j();
                String d = b3.d();
                a = b3.f();
                StringBuilder stringBuilder3 = new StringBuilder("kicked by server, chid=");
                stringBuilder3.append(num);
                stringBuilder3.append(" userid=");
                stringBuilder3.append(j2);
                stringBuilder3.append(" type=");
                stringBuilder3.append(d);
                stringBuilder3.append(" reason=");
                stringBuilder3.append(a);
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder3.toString());
                if ("wait".equals(d)) {
                    ap.b b4 = ap.a().b(num, j2);
                    if (b4 != null) {
                        this.a.a(b4);
                        b4.a(c.unbind, 3, 0, a, d);
                    }
                    return;
                }
                this.a.a(num, j2, 3, a, d);
                ap.a().a(num, j2);
            }
        } else if ("PING".equals(a)) {
            byte[] k = bVar.k();
            if (k != null && k.length > 0) {
                j b5 = j.b(k);
                if (b5.f()) {
                    az.a().a(b5.g());
                }
            }
            if ("1".equals(bVar.h())) {
                this.a.a();
            } else {
                com.xiaomi.stats.h.b();
            }
            this.a.i();
        } else if ("SYNC".equals(a)) {
            if ("CONF".equals(bVar.b())) {
                az.a().a(com.xiaomi.push.protobuf.b.b.b(bVar.k()));
            } else if (TextUtils.equals("U", bVar.b())) {
                k b6 = k.b(bVar.k());
                com.xiaomi.push.log.b.a(this.a).a(b6.d(), b6.f(), new Date(b6.h()), new Date(b6.j()), b6.n() * 1024, b6.l());
                com.xiaomi.slim.b bVar2 = new com.xiaomi.slim.b();
                bVar2.a(0);
                bVar2.a(bVar.a(), "UCA");
                bVar2.a(bVar.h());
                this.a.a(new ay(this.a, bVar2));
            } else if (TextUtils.equals("P", bVar.b())) {
                i b7 = i.b(bVar.k());
                com.xiaomi.slim.b bVar3 = new com.xiaomi.slim.b();
                bVar3.a(0);
                bVar3.a(bVar.a(), "PCA");
                bVar3.a(bVar.h());
                i iVar = new i();
                if (b7.e()) {
                    iVar.a(b7.d());
                }
                bVar3.a(iVar.c(), null);
                this.a.a(new ay(this.a, bVar3));
                stringBuilder = new StringBuilder("ACK msgP: id = ");
                stringBuilder.append(bVar.h());
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            }
        } else if ("NOTIFY".equals(bVar.a())) {
            com.xiaomi.push.protobuf.b.h b8 = com.xiaomi.push.protobuf.b.h.b(bVar.k());
            stringBuilder = new StringBuilder("notify by server err = ");
            stringBuilder.append(b8.d());
            stringBuilder.append(" desc = ");
            stringBuilder.append(b8.f());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        }
    }
}
