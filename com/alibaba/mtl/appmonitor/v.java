package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.c;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.e.i;

/* compiled from: TransactionDelegate */
public final class v {
    public static void a(Transaction transaction, String str) {
        try {
            if (q.b && transaction != null) {
                i.a("TransactionDelegate", "statEvent begin. module: ", transaction.b, " monitorPoint: ", transaction.c, " measureName: ", str);
                if (f.STAT.isOpen() && (q.a || j.a(f.STAT, transaction.b, transaction.c))) {
                    e.a().a(transaction.e, transaction.a, transaction.b, transaction.c, str);
                    a(transaction);
                }
            }
        } catch (Transaction transaction2) {
            b.a(transaction2);
        }
    }

    private static void a(Transaction transaction) {
        if (!(transaction == null || transaction.d == null)) {
            c cVar;
            e a = e.a();
            String str = transaction.e;
            Integer num = transaction.a;
            String str2 = transaction.b;
            String str3 = transaction.c;
            DimensionValueSet a2 = DimensionValueSet.a().a(transaction.d);
            synchronized (c.class) {
                cVar = (c) a.a.get(str);
                if (cVar == null) {
                    cVar = (c) a.a().a(c.class, num, str2, str3);
                    a.a.put(str, cVar);
                }
            }
            if (cVar.c == null) {
                cVar.c = a2;
                return;
            }
            cVar.c.a(a2);
        }
    }

    public static void b(Transaction transaction, String str) {
        try {
            if (q.b && transaction != null) {
                i.a("TransactionDelegate", "statEvent end. module: ", transaction.b, " monitorPoint: ", transaction.c, " measureName: ", str);
                if (f.STAT.isOpen() && (q.a || j.a(f.STAT, transaction.b, transaction.c))) {
                    a(transaction);
                    e.a().a(transaction.e, str, false);
                }
            }
        } catch (Transaction transaction2) {
            b.a(transaction2);
        }
    }
}
