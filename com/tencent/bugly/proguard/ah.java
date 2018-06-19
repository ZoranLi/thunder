package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public class ah {
    public static bh a(UserInfoBean userInfoBean, a aVar) {
        if (userInfoBean == null) {
            return null;
        }
        StringBuilder stringBuilder;
        bh bhVar = new bh();
        bhVar.a = userInfoBean.e;
        bhVar.e = userInfoBean.j;
        bhVar.d = userInfoBean.c;
        bhVar.c = userInfoBean.d;
        bhVar.g = a.b().i();
        bhVar.h = userInfoBean.o == 1;
        switch (userInfoBean.b) {
            case 1:
                bhVar.b = (byte) 1;
                break;
            case 2:
                bhVar.b = (byte) 4;
                break;
            case 3:
                bhVar.b = (byte) 2;
                break;
            case 4:
                bhVar.b = (byte) 3;
                break;
            default:
                if (userInfoBean.b >= 10 && userInfoBean.b < 20) {
                    bhVar.b = (byte) userInfoBean.b;
                    break;
                }
                an.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
                return null;
        }
        bhVar.f = new HashMap();
        if (userInfoBean.p >= null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(userInfoBean.p);
            bhVar.f.put("C01", stringBuilder.toString());
        }
        if (userInfoBean.q >= null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(userInfoBean.q);
            bhVar.f.put("C02", stringBuilder.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > null) {
            for (Entry entry : userInfoBean.r.entrySet()) {
                Map map = bhVar.f;
                StringBuilder stringBuilder2 = new StringBuilder("C03_");
                stringBuilder2.append((String) entry.getKey());
                map.put(stringBuilder2.toString(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > null) {
            for (Entry entry2 : userInfoBean.s.entrySet()) {
                map = bhVar.f;
                stringBuilder2 = new StringBuilder("C04_");
                stringBuilder2.append((String) entry2.getKey());
                map.put(stringBuilder2.toString(), entry2.getValue());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.l ^ true);
        bhVar.f.put("A36", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.g);
        bhVar.f.put("F02", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.h);
        bhVar.f.put("F03", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.j);
        bhVar.f.put("F04", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.i);
        bhVar.f.put("F05", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.m);
        bhVar.f.put("F06", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.k);
        bhVar.f.put("F10", stringBuilder.toString());
        an.c("summary type %d vm:%d", new Object[]{Byte.valueOf(bhVar.b), Integer.valueOf(bhVar.f.size())});
        return bhVar;
    }

    public static bi a(List<UserInfoBean> list, int i) {
        if (list != null) {
            if (list.size() != 0) {
                a b = a.b();
                if (b == null) {
                    return null;
                }
                b.t();
                bi biVar = new bi();
                biVar.b = b.e;
                biVar.c = b.h();
                ArrayList arrayList = new ArrayList();
                for (UserInfoBean a : list) {
                    bh a2 = a(a, b);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                biVar.d = arrayList;
                biVar.e = new HashMap();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b.k);
                biVar.e.put("A7", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.s());
                biVar.e.put("A6", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.r());
                biVar.e.put("A5", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.p());
                biVar.e.put("A2", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.p());
                biVar.e.put("A1", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.m);
                biVar.e.put("A24", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.q());
                biVar.e.put("A17", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.w());
                biVar.e.put("A15", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.x());
                biVar.e.put("A13", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.A);
                biVar.e.put("F08", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.B);
                biVar.e.put("F09", stringBuilder.toString());
                list = b.G();
                if (list != null && list.size() > 0) {
                    list = list.entrySet().iterator();
                    while (list.hasNext()) {
                        Entry entry = (Entry) list.next();
                        Map map = biVar.e;
                        stringBuilder = new StringBuilder("C04_");
                        stringBuilder.append((String) entry.getKey());
                        map.put(stringBuilder.toString(), entry.getValue());
                    }
                }
                switch (i) {
                    case 1:
                        biVar.a = (byte) 1;
                        break;
                    case 2:
                        biVar.a = (byte) 2;
                        break;
                    default:
                        an.e("unknown up type %d ", new Object[]{Integer.valueOf(i)});
                        return null;
                }
                return biVar;
            }
        }
        return null;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                    m mVar = (m) cls.newInstance();
                    k kVar = new k(bArr);
                    kVar.a("utf-8");
                    mVar.a(kVar);
                    return mVar;
                } catch (byte[] bArr2) {
                    if (an.b(bArr2) == null) {
                        bArr2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public static bd a(Context context, int i, byte[] bArr) {
        a b = a.b();
        StrategyBean c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b != null) {
            if (c != null) {
                try {
                    bd bdVar = new bd();
                    synchronized (b) {
                        bdVar.a = b.c;
                        bdVar.b = b.f();
                        bdVar.c = b.d;
                        bdVar.d = b.o;
                        bdVar.e = b.q;
                        b.getClass();
                        bdVar.f = "2.6.5";
                        bdVar.g = i;
                        bdVar.h = bArr == null ? "".getBytes() : bArr;
                        bdVar.i = b.l;
                        bdVar.j = b.m;
                        bdVar.k = new HashMap();
                        bdVar.l = b.e();
                        bdVar.m = c.p;
                        bdVar.o = b.h();
                        bdVar.p = b.f(context);
                        bdVar.q = System.currentTimeMillis();
                        context = new StringBuilder();
                        context.append(b.k());
                        bdVar.r = context.toString();
                        bdVar.s = b.j();
                        context = new StringBuilder();
                        context.append(b.m());
                        bdVar.t = context.toString();
                        bdVar.u = b.l();
                        context = new StringBuilder();
                        context.append(b.n());
                        bdVar.v = context.toString();
                        bdVar.w = bdVar.p;
                        b.getClass();
                        bdVar.n = "com.tencent.bugly";
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(b.y());
                        bdVar.k.put("A26", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.z());
                        bdVar.k.put("A60", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.A());
                        bdVar.k.put("A61", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.E);
                        bdVar.k.put("F11", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.D);
                        bdVar.k.put("F12", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.u());
                        bdVar.k.put("G1", stringBuilder.toString());
                        if (b.G != null) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b.M());
                            bdVar.k.put("G2", stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b.N());
                            bdVar.k.put("G3", stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b.O());
                            bdVar.k.put("G4", stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b.P());
                            bdVar.k.put("G5", stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(b.Q());
                            bdVar.k.put("G6", stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(Long.toString(b.R()));
                            bdVar.k.put("G7", stringBuilder.toString());
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b.p);
                        bdVar.k.put("D3", stringBuilder.toString());
                        if (com.tencent.bugly.b.b != null) {
                            for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                                if (!(aVar.versionKey == null || aVar.version == null)) {
                                    bdVar.k.put(aVar.versionKey, aVar.version);
                                }
                            }
                        }
                        bdVar.k.put("G15", ap.c("G15", ""));
                        bdVar.k.put("D4", ap.c("D4", "0"));
                    }
                    context = ak.a();
                    if (!(context == null || context.b != null || bArr == null)) {
                        bdVar.h = ap.a(bdVar.h, 2, 1, c.u);
                        if (bdVar.h == null) {
                            an.e("reqPkg sbuffer error!", new Object[0]);
                            return null;
                        }
                    }
                    context = b.F();
                    if (context != null) {
                        for (Entry entry : context.entrySet()) {
                            bdVar.k.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return bdVar;
                } catch (Context context2) {
                    if (an.b(context2) == 0) {
                        context2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        an.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.a(1);
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", obj);
            return eVar.a();
        } catch (Object obj2) {
            if (!an.b(obj2)) {
                obj2.printStackTrace();
            }
            return null;
        }
    }

    public static be a(byte[] bArr, StrategyBean strategyBean, boolean z) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                bArr = eVar.b("detail", new be());
                bArr = be.class.isInstance(bArr) ? (be) be.class.cast(bArr) : null;
                if (!z && bArr != null && bArr.c && bArr.c.length <= false) {
                    an.c("resp buf %d", Integer.valueOf(bArr.c.length));
                    bArr.c = ap.b(bArr.c, 2, 1, StrategyBean.d);
                    if (!bArr.c) {
                        an.e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return bArr;
            } catch (byte[] bArr2) {
                if (!an.b(bArr2)) {
                    bArr2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            return lVar.b();
        } catch (m mVar2) {
            if (!an.b(mVar2)) {
                mVar2.printStackTrace();
            }
            return null;
        }
    }
}
