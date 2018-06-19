package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.slim.b;
import com.xiaomi.smack.d;
import com.xiaomi.smack.f;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a implements com.xiaomi.smack.debugger.a {
    public static boolean a;
    private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
    private com.xiaomi.smack.a c = null;
    private a d = null;
    private a e = null;
    private d f = null;
    private final String g = "[Slim] ";

    class a implements f, com.xiaomi.smack.filter.a {
        String a;
        final /* synthetic */ a b;

        a(a aVar, boolean z) {
            this.b = aVar;
            this.a = z ? " RCV " : " Sent ";
        }

        public void a(b bVar) {
            StringBuilder stringBuilder;
            String bVar2;
            if (a.a) {
                stringBuilder = new StringBuilder("[Slim] ");
                stringBuilder.append(this.b.b.format(new Date()));
                stringBuilder.append(this.a);
                bVar2 = bVar.toString();
            } else {
                stringBuilder = new StringBuilder("[Slim] ");
                stringBuilder.append(this.b.b.format(new Date()));
                stringBuilder.append(this.a);
                stringBuilder.append(" Blob [");
                stringBuilder.append(bVar.a());
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(bVar.c());
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(bVar.h());
                bVar2 = "]";
            }
            stringBuilder.append(bVar2);
            com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
        }

        public boolean a(com.xiaomi.smack.packet.d dVar) {
            return true;
        }

        public void b(com.xiaomi.smack.packet.d dVar) {
            StringBuilder stringBuilder;
            String c;
            if (a.a) {
                stringBuilder = new StringBuilder("[Slim] ");
                stringBuilder.append(this.b.b.format(new Date()));
                stringBuilder.append(this.a);
                stringBuilder.append(" PKT ");
                c = dVar.c();
            } else {
                stringBuilder = new StringBuilder("[Slim] ");
                stringBuilder.append(this.b.b.format(new Date()));
                stringBuilder.append(this.a);
                stringBuilder.append(" PKT [");
                stringBuilder.append(dVar.l());
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append(dVar.k());
                c = "]";
            }
            stringBuilder.append(c);
            com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
        }
    }

    static {
        boolean z = true;
        if (h.c() != 1) {
            z = false;
        }
        a = z;
    }

    public a(com.xiaomi.smack.a aVar) {
        this.c = aVar;
        a();
    }

    private void a() {
        this.d = new a(this, true);
        this.e = new a(this, false);
        this.c.a(this.d, this.d);
        this.c.b(this.e, this.e);
        this.f = new b(this);
    }
}
