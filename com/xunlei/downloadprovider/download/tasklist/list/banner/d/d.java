package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.util.LongSparseArray;
import android.util.Pair;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.b;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.i;
import java.util.HashSet;

/* compiled from: DownloadLimitPrivilegeHelper */
public class d {
    private static d f;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("download_limit_privilege", 0);
    Editor b = this.a.edit();
    public HashSet<String> c = new HashSet();
    public LongSparseArray<Boolean> d;
    public LongSparseArray<Boolean> e;

    public static d a() {
        if (f == null) {
            synchronized (d.class) {
                if (f == null) {
                    f = new d();
                }
            }
        }
        return f;
    }

    private d() {
        XLThreadPool.execute(new e(this));
    }

    public static Pair<Integer, Long> b() {
        if (!com.xunlei.downloadprovider.d.d.a().h.b()) {
            return null;
        }
        b b = h.e().b(1);
        if (b == null) {
            return null;
        }
        Object<e> c = b.c();
        if (com.xunlei.xllib.b.d.a(c)) {
            return null;
        }
        int i = 0;
        long j = 0;
        for (e eVar : c) {
            if (!(eVar == null || eVar.a == 100 || eVar.b() == null)) {
                DownloadTaskInfo b2 = eVar.b();
                if (b2.getTaskStatus() == 2) {
                    i++;
                }
                if (j == 0 && b2.getTaskStatus() == 1) {
                    j = b2.getTaskId();
                }
            }
        }
        return Pair.create(Integer.valueOf(i), Long.valueOf(j));
    }

    final void c() {
        this.c.add(f());
        this.b.putBoolean(f(), false).commit();
    }

    public static boolean d() {
        int d = j.a().d();
        boolean z = j.a().c() && (i.b(d) || i.a(d) || 2 == d);
        StringBuilder stringBuilder = new StringBuilder("[isLegalVip] ");
        stringBuilder.append(z);
        stringBuilder.append(" ,memberType=");
        stringBuilder.append(d);
        return z;
    }

    public static int e() {
        if (!com.xunlei.downloadprovider.d.d.a().h.b()) {
            return 5;
        }
        if (d()) {
            return com.xunlei.downloadprovider.d.d.a().h.c();
        }
        return com.xunlei.downloadprovider.d.d.a().h.d();
    }

    public static String f() {
        StringBuilder stringBuilder = new StringBuilder("setting_");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public static String g() {
        StringBuilder stringBuilder = new StringBuilder("open_vip_");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }
}
