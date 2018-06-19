package com.getui.gtc.a;

import android.content.ContentValues;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.getui.gtc.d.a.c;
import com.getui.gtc.d.a.d;
import com.getui.gtc.e.i;
import com.getui.gtc.entity.a;
import org.android.agoo.common.AgooConstants;

public class b {
    private static b b;
    public c a;

    private b() {
    }

    public static void a() {
        if (b != null) {
            synchronized (b.class) {
                if (b != null) {
                    try {
                        c cVar = b.a;
                        if (cVar.a != null) {
                            cVar.a.close();
                        }
                        b = null;
                    } catch (Throwable th) {
                        new String[1][0] = th.toString();
                    }
                    b = null;
                }
            }
        }
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public final String a(int i) {
        try {
            return (String) this.a.b.c.get(i, "");
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return null;
        }
    }

    public final void a(int i, a aVar) {
        this.a.b.a(i, 1001, i.a(aVar.toString().getBytes(), h.b));
    }

    public final void a(int i, String str) {
        d dVar = this.a.c;
        if (dVar.b != null) {
            com.getui.gtc.entity.d dVar2 = (com.getui.gtc.entity.d) dVar.b.get(i);
            if (dVar2 != null) {
                dVar2.e = str;
                dVar.b.put(i, dVar2);
            }
        }
        dVar.a(i, 10, i.a(str.getBytes(), h.b));
    }

    final void a(Context context) {
        try {
            SparseArray sparseArray = this.a.c.b;
            SparseArray sparseArray2 = this.a.b.b;
            SparseArray sparseArray3 = this.a.b.c;
            for (int i = 0; i < sparseArray.size(); i++) {
                com.getui.gtc.entity.d dVar = (com.getui.gtc.entity.d) sparseArray.get(sparseArray.keyAt(i));
                int i2 = dVar.a;
                Object obj = dVar.g;
                CharSequence charSequence = dVar.f;
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(charSequence) || !obj.equals(charSequence)) {
                    if (sparseArray2 != null) {
                        a aVar = (a) sparseArray2.get(dVar.a);
                        if (aVar != null) {
                            aVar.a(new c(this, context));
                            this.a.a(i2);
                        }
                    }
                    if (!TextUtils.isEmpty((String) sparseArray3.get(i2))) {
                        sparseArray3.remove(i2);
                        this.a.b.a(i2);
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        d dVar2 = this.a.c;
                        if (dVar2.b != null) {
                            dVar2.b.remove(i2);
                        }
                        dVar2.a("id=?", new String[]{String.valueOf(i2)});
                    } else {
                        dVar.c = "";
                        e c = e.c();
                        Message obtain = Message.obtain();
                        obtain.obj = dVar;
                        obtain.what = 3;
                        c.a(obtain);
                    }
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public final void a(com.getui.gtc.entity.d dVar) {
        this.a.c.a(dVar);
    }

    public final a b(int i) {
        return (a) this.a.b.b.get(i, null);
    }

    public final void b(int i, String str) {
        d dVar = this.a.c;
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("a", Integer.valueOf(7));
        contentValues.put(com.xunlei.downloadprovider.ad.common.adget.b.b.a, str);
        dVar.a(contentValues);
    }

    public final String c() {
        return this.a.c.e;
    }
}
