package com.igexin.push.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.b.c;
import com.igexin.b.a.d.e;
import com.igexin.push.core.f;
import java.util.LinkedList;
import java.util.List;

public class a extends e {
    private static final String e = "com.igexin.push.b.a";
    protected SQLiteDatabase a;
    protected Cursor b;
    List<com.igexin.push.core.b.a> c = new LinkedList();
    boolean d;

    public a() {
        super(1);
    }

    public void a(com.igexin.push.core.b.a aVar) {
        this.c.add(aVar);
    }

    public final int b() {
        return -2147483639;
    }

    public void b_() {
        super.b_();
        this.a = f.a().k().getWritableDatabase();
        this.a.setVersion(3);
        for (com.igexin.push.core.b.a a : this.c) {
            a.a(this.a);
        }
        for (com.igexin.push.core.b.a a2 : this.c) {
            if (this.d) {
                a2.c(this.a);
            } else {
                a2.b(this.a);
            }
        }
        c.b().a((Object) new c(-980948));
        c.b().c();
    }

    public void c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        super.c();
        r0 = r1.b;
        if (r0 == 0) goto L_0x000c;
    L_0x0007:
        r0 = r1.b;	 Catch:{ Exception -> 0x000c }
        r0.close();	 Catch:{ Exception -> 0x000c }
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.a.c():void");
    }

    public void d() {
        super.d();
        this.n = true;
        this.I = true;
    }

    protected void e() {
    }
}
