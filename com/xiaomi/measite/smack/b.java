package com.xiaomi.measite.smack;

import com.umeng.message.proguard.k;
import com.xiaomi.smack.a;
import com.xiaomi.smack.d;
import java.util.Date;

class b implements d {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("[Slim] ");
        stringBuilder.append(this.a.b.format(new Date()));
        stringBuilder.append(" Connection reconnected (");
        stringBuilder.append(this.a.c.hashCode());
        stringBuilder.append(k.t);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
    }

    public void a(a aVar, int i, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("[Slim] ");
        stringBuilder.append(this.a.b.format(new Date()));
        stringBuilder.append(" Connection closed (");
        stringBuilder.append(this.a.c.hashCode());
        stringBuilder.append(k.t);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
    }

    public void a(a aVar, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("[Slim] ");
        stringBuilder.append(this.a.b.format(new Date()));
        stringBuilder.append(" Reconnection failed due to an exception (");
        stringBuilder.append(this.a.c.hashCode());
        stringBuilder.append(k.t);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
        exception.printStackTrace();
    }

    public void b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("[Slim] ");
        stringBuilder.append(this.a.b.format(new Date()));
        stringBuilder.append(" Connection started (");
        stringBuilder.append(this.a.c.hashCode());
        stringBuilder.append(k.t);
        com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
    }
}
