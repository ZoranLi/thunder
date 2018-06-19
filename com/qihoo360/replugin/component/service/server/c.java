package com.qihoo360.replugin.component.service.server;

import android.content.Intent.FilterComparison;
import android.os.IBinder;
import com.qihoo360.replugin.utils.a.a;

/* compiled from: IntentBindRecord */
final class c {
    final i a;
    final FilterComparison b;
    final a<h, g> c = new a();
    IBinder d;
    boolean e;
    String f;

    c(i iVar, FilterComparison filterComparison) {
        this.a = iVar;
        this.b = filterComparison;
    }

    private int a() {
        int i = 0;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            com.qihoo360.replugin.utils.a.c cVar = ((g) this.c.b(size)).d;
            for (int size2 = cVar.size() - 1; size2 >= 0; size2--) {
                i |= ((a) cVar.f[size2]).c;
            }
        }
        return i;
    }

    public final String toString() {
        if (this.f != null) {
            return this.f;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("IntentBindRecord{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(' ');
        if ((a() & 1) != 0) {
            stringBuilder.append("CR ");
        }
        stringBuilder.append(this.a.k);
        stringBuilder.append(':');
        if (this.b != null) {
            stringBuilder.append(this.b.getIntent().toString());
        }
        stringBuilder.append(':');
        if (this.c.size() > 0) {
            stringBuilder.append(this.c.toString());
        }
        stringBuilder.append('}');
        this.f = stringBuilder.toString();
        return this.f;
    }
}
