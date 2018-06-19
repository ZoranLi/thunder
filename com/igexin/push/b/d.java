package com.igexin.push.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.b.c;
import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import com.igexin.push.core.f;

public abstract class d extends e {
    private static final String a = l.a;
    protected SQLiteDatabase c;
    protected Cursor d;
    protected ContentValues e;
    public c f;

    public d() {
        super(1);
    }

    public d(ContentValues contentValues) {
        super(1);
        this.e = contentValues;
    }

    public abstract void a();

    public final int b() {
        return -2147483640;
    }

    public void b_() {
        super.b_();
        this.c = f.a().k().getWritableDatabase();
        a();
        if (this.f != null) {
            c.b().a((Object) this.f);
            c.b().c();
        }
    }

    public void c() {
        super.c();
        if (!(this.d == null || this.d.isClosed())) {
            try {
                this.d.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d() {
        this.n = true;
        this.I = true;
    }

    protected void e() {
    }
}
