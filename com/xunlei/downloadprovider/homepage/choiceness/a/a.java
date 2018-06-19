package com.xunlei.downloadprovider.homepage.choiceness.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.ad.home.a.h;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessDataHelper */
public class a {
    private static a g;
    private static String k;
    public j a;
    public long b;
    public long c;
    public LinkedList<e> d = new LinkedList();
    public List<e> e = new ArrayList();
    private Context f;
    private t h = t.a();
    private Handler i = new Handler(Looper.getMainLooper());
    private long j = -1;

    /* compiled from: ChoicenessDataHelper */
    public interface a {
        void a(List<e> list, k kVar);
    }

    /* compiled from: ChoicenessDataHelper */
    private class b implements Runnable {
        com.xunlei.downloadprovider.search.b.a<e> a;
        final /* synthetic */ a b;

        public b(a aVar, com.xunlei.downloadprovider.search.b.a<e> aVar2) {
            this.b = aVar;
            this.a = aVar2;
        }

        public final void run() {
            if (this.a != null) {
                Object string = this.b.h.a.getString("last_page", "");
                if (TextUtils.isEmpty(string)) {
                    this.b.i.post(new e(this));
                    return;
                }
                k a;
                try {
                    a = k.a(true, new JSONObject(string));
                } catch (JSONException e) {
                    e.printStackTrace();
                    a = null;
                }
                if (!(a == null || a.a == null)) {
                    if (!a.a.isEmpty()) {
                        List<e> list = a.a;
                        for (e eVar : list) {
                            eVar.j = ChoicenessReporter$RefreshType.auto_pull;
                        }
                        this.b.i.post(new g(this, list));
                        return;
                    }
                }
                this.b.i.post(new f(this));
            }
        }
    }

    private a(Context context) {
        this.f = context.getApplicationContext();
        this.a = new j();
        this.a.b = this.h.a.getString("cursor", "");
        e();
    }

    public static a a(Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private static void e() {
        k = String.valueOf(System.currentTimeMillis());
    }

    public static String a() {
        return k;
    }

    private void a(e eVar, boolean z) {
        if (com.xunlei.downloadprovider.d.e.a().e.a().l != 0) {
            if (z) {
                this.d.addFirst(eVar);
                return;
            }
            this.d.add(eVar);
        }
    }

    public final List<e> b() {
        this.e.clear();
        this.e.addAll(this.d);
        return this.e;
    }

    public final boolean a(int i, e eVar) {
        if (eVar != null && i >= 0) {
            if (i <= this.d.size()) {
                this.d.set(i, eVar);
                b();
                return true;
            }
        }
        return false;
    }

    public final long c() {
        if (this.j < 0) {
            this.j = this.h.a.getLong(MsgConstant.KEY_TS, 0);
        }
        return this.j;
    }

    private static String a(e eVar) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(random.nextLong()));
        stringBuilder.append(eVar.k);
        return stringBuilder.toString();
    }

    public final void a(JSONObject jSONObject) {
        XLThreadPool.execute(new d(this, jSONObject));
    }

    public final boolean a(a aVar) {
        boolean a = com.xunlei.xllib.android.b.a(this.f);
        if (!a) {
            aVar.a(this.e, null);
        }
        return a;
    }

    static /* synthetic */ void a(a aVar, long j) {
        aVar.j = j;
        aVar.h.a.edit().putLong(MsgConstant.KEY_TS, j).apply();
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            aVar.h.a.edit().putString("cursor", str).apply();
        }
    }

    static /* synthetic */ void a(a aVar, boolean z, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                aVar = aVar.a.a;
                if (z) {
                    aVar--;
                }
                z = String.valueOf(System.currentTimeMillis());
                for (int i = 0; i < list.size(); i++) {
                    e eVar = (e) list.get(i);
                    eVar.g = aVar;
                    eVar.f = z;
                    eVar.e = i;
                }
            }
        }
    }

    static /* synthetic */ List a(a aVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, k kVar) {
        if (kVar != null) {
            kVar = kVar.a;
            if (!(kVar == null || kVar.isEmpty())) {
                if (d.a().b.q()) {
                    aVar.d.clear();
                    f a = f.a(aVar.f);
                    a.c.e = null;
                    com.xunlei.downloadprovider.ad.home.a.f.a aVar2 = a.c;
                    if (aVar2.a != null) {
                        aVar2.a.clear();
                    }
                    com.xunlei.downloadprovider.ad.home.a.b c = com.xunlei.downloadprovider.ad.home.a.b.c();
                    c.e();
                    c.b.clear();
                    c.g();
                    c.f();
                }
                List arrayList = new ArrayList();
                for (int size = kVar.size() - 1; size >= 0; size--) {
                    e eVar = (e) kVar.get(size);
                    eVar.j = choicenessReporter$RefreshType;
                    if (TextUtils.isEmpty(eVar.b())) {
                        eVar.i = a(eVar);
                    }
                    if (eVar.d() && (eVar instanceof com.xunlei.downloadprovider.homepage.choiceness.a.a.b)) {
                        arrayList.add((com.xunlei.downloadprovider.homepage.choiceness.a.a.b) eVar);
                        aVar.a(eVar, true);
                    } else {
                        aVar.d.addFirst(eVar);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    static /* synthetic */ void b(a aVar, long j) {
        aVar.b = j;
        aVar.h.a.edit().putLong("maxId", j).apply();
    }

    static /* synthetic */ void c(a aVar, long j) {
        aVar.c = j;
        aVar.h.a.edit().putLong("minId", j).apply();
    }

    static /* synthetic */ void b(a aVar, boolean z, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                aVar = f.a(aVar.f);
                for (com.xunlei.downloadprovider.homepage.choiceness.a.a.b bVar : list) {
                    aVar.e++;
                    if (d.a().p.c() && bVar.a != null) {
                        THUNDER_AD_INFO a = j.a(aVar.f, bVar.a);
                        if (a != null) {
                            aVar.f.remove(a);
                        } else if (!aVar.f.isEmpty()) {
                            a = (THUNDER_AD_INFO) aVar.f.pop();
                        }
                        if (a != null) {
                            l a2 = aVar.a(a, j.a(a, bVar.a));
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(aVar.b());
                            com.xunlei.downloadprovider.ad.home.a.a(stringBuilder.toString(), ChoicenessReporter.a(bVar));
                            if (a2 != null) {
                                f.a(z, bVar, a2, a);
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(aVar.b());
                                a2.A = stringBuilder2.toString();
                                aVar.c.a(bVar.b(), a2);
                            }
                        }
                    }
                    new Handler().postDelayed(new h(aVar, bVar), 500);
                }
            }
        }
    }

    static /* synthetic */ List b(a aVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, k kVar) {
        if (kVar != null) {
            k<e> kVar2 = kVar.a;
            if (!(kVar2 == null || kVar2.isEmpty())) {
                for (e eVar : kVar2) {
                    if (TextUtils.isEmpty(eVar.b())) {
                        eVar.i = a(eVar);
                    }
                }
                List arrayList = new ArrayList();
                for (int i = 0; i < kVar2.size(); i++) {
                    e eVar2 = (e) kVar2.get(i);
                    eVar2.j = choicenessReporter$RefreshType;
                    if (eVar2.d() && (eVar2 instanceof com.xunlei.downloadprovider.homepage.choiceness.a.a.b)) {
                        arrayList.add((com.xunlei.downloadprovider.homepage.choiceness.a.a.b) eVar2);
                        aVar.a(eVar2, false);
                    } else {
                        aVar.d.add(eVar2);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    static /* synthetic */ void a(a aVar, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                aVar.d.addAll(list);
            }
        }
    }
}
