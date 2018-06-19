package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.MessageActivty$MessageType;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.h.a;
import com.xunlei.downloadprovider.personal.message.data.s;
import com.xunlei.downloadprovider.personal.message.data.t;
import java.util.Observable;

/* compiled from: MessageCenterUnreadCountManager */
public final class j extends Observable {
    private static j d;
    public s a = null;
    public f b = null;
    public o c = null;
    private Handler e = new Handler(Looper.getMainLooper());
    private boolean f = false;
    private a g = new k(this);

    public static void a() {
        b();
    }

    public static j b() {
        if (d == null) {
            d = new j();
        }
        return d;
    }

    private j() {
        LoginHelper.a();
        if (l.c()) {
            f();
        }
        LoginHelper.a().a(new l(this));
        LoginHelper.a().a(new m(this));
    }

    private void f() {
        if (!this.f) {
            this.a = new s();
            this.b = new f();
            this.c = new o();
            b.b().a(this.g);
            this.f = true;
        }
    }

    public final void a(@NonNull s sVar) {
        if (!e()) {
            this.a.a(sVar);
            g();
        }
    }

    public final s c() {
        return e() ? new s() : this.a.b();
    }

    public final int d() {
        if (e()) {
            return 0;
        }
        s sVar = this.a;
        return ((sVar.a + sVar.b) + sVar.c) + sVar.e;
    }

    public final void a(MessageActivty$MessageType messageActivty$MessageType) {
        if (!e()) {
            s sVar = this.a;
            switch (t.a[messageActivty$MessageType.ordinal()]) {
                case 1:
                    sVar.c = 0;
                    break;
                case 2:
                    sVar.d = 0;
                    break;
                case 3:
                    sVar.a = 0;
                    break;
                case 4:
                    sVar.b = 0;
                    break;
                default:
                    break;
            }
            g();
        }
    }

    private void g() {
        if (!e()) {
            this.e.post(new n(this));
        }
    }

    public final boolean e() {
        return !this.f;
    }

    static /* synthetic */ void b(j jVar) {
        if (!jVar.e()) {
            if (!jVar.e()) {
                jVar.a.a();
                jVar.g();
            }
            f fVar = jVar.b;
            fVar.a.a();
            fVar.a(new s());
            fVar.b = false;
            o oVar = jVar.c;
            oVar.a.a();
            oVar.a(new s());
            jVar.deleteObservers();
            b.b().b(jVar.g);
            jVar.f = false;
        }
    }
}
