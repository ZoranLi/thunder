package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Parcelable;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.ay;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.bb;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.m;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

/* compiled from: BUGLY */
public class b {
    public static int a;
    protected final Context b;
    protected final ak c;
    protected final ae d;
    protected final a e;
    protected f f;
    protected BuglyStrategy.a g;

    public b(int i, Context context, ak akVar, ae aeVar, a aVar, BuglyStrategy.a aVar2, f fVar) {
        a = i;
        this.b = context;
        this.c = akVar;
        this.d = aeVar;
        this.e = aVar;
        this.g = aVar2;
        this.f = fVar;
    }

    protected List<a> a(List<a> list) {
        if (list != null) {
            if (list.size() != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                List<a> arrayList = new ArrayList();
                for (a aVar : list) {
                    if (aVar.d && aVar.b <= currentTimeMillis - 86400000) {
                        arrayList.add(aVar);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    protected CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        if (list != null) {
            if (list.size() != 0) {
                CrashDetailBean crashDetailBean2 = null;
                List arrayList = new ArrayList(10);
                for (a aVar : list) {
                    if (aVar.e) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() > 0) {
                    arrayList = b(arrayList);
                    if (arrayList != null && arrayList.size() > 0) {
                        Collections.sort(arrayList);
                        CrashDetailBean crashDetailBean3 = null;
                        for (int i = 0; i < arrayList.size(); i++) {
                            CrashDetailBean crashDetailBean4 = (CrashDetailBean) arrayList.get(i);
                            if (i == 0) {
                                crashDetailBean3 = crashDetailBean4;
                            } else if (crashDetailBean4.s != null) {
                                String[] split = crashDetailBean4.s.split("\n");
                                if (split != null) {
                                    for (Object obj : split) {
                                        if (!crashDetailBean3.s.contains(obj)) {
                                            crashDetailBean3.t++;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append(crashDetailBean3.s);
                                            stringBuilder.append(obj);
                                            stringBuilder.append("\n");
                                            crashDetailBean3.s = stringBuilder.toString();
                                        }
                                    }
                                }
                            }
                        }
                        crashDetailBean2 = crashDetailBean3;
                    }
                }
                if (crashDetailBean2 == null) {
                    crashDetailBean.j = true;
                    crashDetailBean.t = 0;
                    crashDetailBean.s = "";
                    crashDetailBean2 = crashDetailBean;
                }
                for (a aVar2 : list) {
                    if (!(aVar2.e || aVar2.d)) {
                        String str = crashDetailBean2.s;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(aVar2.b);
                        if (!str.contains(stringBuilder2.toString())) {
                            crashDetailBean2.t++;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(crashDetailBean2.s);
                            stringBuilder3.append(aVar2.b);
                            stringBuilder3.append("\n");
                            crashDetailBean2.s = stringBuilder3.toString();
                        }
                    }
                }
                if (crashDetailBean2.r != crashDetailBean.r) {
                    list = crashDetailBean2.s;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(crashDetailBean.r);
                    if (list.contains(stringBuilder4.toString()) == null) {
                        crashDetailBean2.t += 1;
                        list = new StringBuilder();
                        list.append(crashDetailBean2.s);
                        list.append(crashDetailBean.r);
                        list.append("\n");
                        crashDetailBean2.s = list.toString();
                    }
                }
                return crashDetailBean2;
            }
        }
        return crashDetailBean;
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    public boolean a(CrashDetailBean crashDetailBean, int i) {
        b bVar = this;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return true;
        }
        if (!(c.m == null || c.m.isEmpty())) {
            an.c("Crash filter for crash stack is: %s", c.m);
            if (crashDetailBean2.q.contains(c.m)) {
                an.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (!(c.n == null || c.n.isEmpty())) {
            an.c("Crash regular filter for crash stack is: %s", c.n);
            if (Pattern.compile(c.n).matcher(crashDetailBean2.q).find()) {
                an.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        boolean z = crashDetailBean2.b == 1;
        String str = crashDetailBean2.n;
        String str2 = crashDetailBean2.p;
        String str3 = crashDetailBean2.q;
        long j = crashDetailBean2.r;
        String str4 = crashDetailBean2.m;
        String str5 = crashDetailBean2.e;
        String str6 = crashDetailBean2.c;
        if (bVar.f == null || bVar.f.a(z, str, str2, str3, i, j, str4, str5, str6, crashDetailBean2.z)) {
            if (crashDetailBean2.b != 2) {
                ag agVar = new ag();
                agVar.b = 1;
                agVar.c = crashDetailBean2.z;
                agVar.d = crashDetailBean2.A;
                agVar.e = crashDetailBean2.r;
                bVar.d.b(1);
                bVar.d.a(agVar);
                an.b("[crash] a crash occur, handling...", new Object[0]);
            } else {
                an.b("[crash] a caught exception occur, handling...", new Object[0]);
            }
            List<a> b = b();
            List list = null;
            if (b != null && b.size() > 0) {
                list = new ArrayList(10);
                List<a> arrayList = new ArrayList(10);
                list.addAll(a((List) b));
                b.removeAll(list);
                if (!com.tencent.bugly.b.c && c.d) {
                    z = false;
                    for (a aVar : b) {
                        if (crashDetailBean2.u.equals(aVar.c)) {
                            if (aVar.e) {
                                z = true;
                            }
                            arrayList.add(aVar);
                        }
                    }
                    if (z || arrayList.size() >= c.c) {
                        an.a("same crash occur too much do merged!", new Object[0]);
                        crashDetailBean2 = a((List) arrayList, crashDetailBean2);
                        for (a aVar2 : arrayList) {
                            if (aVar2.a != crashDetailBean2.a) {
                                list.add(aVar2);
                            }
                        }
                        e(crashDetailBean2);
                        c(list);
                        an.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                        return true;
                    }
                }
            }
            e(crashDetailBean);
            if (!(list == null || list.isEmpty())) {
                c(list);
            }
            an.b("[crash] save crash success", new Object[0]);
            return false;
        }
        an.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
        return true;
    }

    public List<CrashDetailBean> a() {
        StrategyBean c = a.a().c();
        if (c == null) {
            an.d("have not synced remote!", new Object[0]);
            return null;
        } else if (c.g) {
            long currentTimeMillis = System.currentTimeMillis();
            long b = ap.b();
            List b2 = b();
            if (b2 != null) {
                if (b2.size() > 0) {
                    List arrayList = new ArrayList();
                    Iterator it = b2.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (aVar.b < b - c.g) {
                            it.remove();
                            arrayList.add(aVar);
                        } else if (aVar.d) {
                            if (aVar.b >= currentTimeMillis - 86400000) {
                                it.remove();
                            } else if (!aVar.e) {
                                it.remove();
                                arrayList.add(aVar);
                            }
                        } else if (((long) aVar.f) >= 3 && aVar.b < currentTimeMillis - 86400000) {
                            it.remove();
                            arrayList.add(aVar);
                        }
                    }
                    if (arrayList.size() > 0) {
                        c(arrayList);
                    }
                    arrayList = new ArrayList();
                    List<CrashDetailBean> b3 = b(b2);
                    if (b3 != null && b3.size() > 0) {
                        String str = com.tencent.bugly.crashreport.common.info.a.b().o;
                        Iterator it2 = b3.iterator();
                        while (it2.hasNext()) {
                            CrashDetailBean crashDetailBean = (CrashDetailBean) it2.next();
                            if (!str.equals(crashDetailBean.f)) {
                                it2.remove();
                                arrayList.add(crashDetailBean);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        d(arrayList);
                    }
                    return b3;
                }
            }
            return null;
        } else {
            an.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            an.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
    }

    public void b(CrashDetailBean crashDetailBean) {
        if (this.f != null) {
            f fVar = this.f;
            boolean z = true;
            if (crashDetailBean.b != 1) {
                z = false;
            }
            fVar.b(z);
        }
    }

    public void a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (c.l) {
            boolean z2 = false;
            an.a("try to upload right now", new Object[0]);
            List arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            if (crashDetailBean.b == 7) {
                z2 = true;
            }
            a(arrayList, j, z, z2, z);
        }
    }

    public void a(List<CrashDetailBean> list, long j, boolean z, boolean z2, boolean z3) {
        final List list2 = list;
        if (!com.tencent.bugly.crashreport.common.info.a.a(this.b).g || r1.c == null) {
            return;
        }
        if (z3 || r1.c.b(c.a)) {
            StrategyBean c = r1.e.c();
            if (c.g) {
                if (list2 != null) {
                    if (list.size() != 0) {
                        try {
                            String str = r1.c.b ? c.s : c.t;
                            String str2 = r1.c.b ? StrategyBean.c : StrategyBean.a;
                            int i = r1.c.b ? 830 : 630;
                            m a = a(r1.b, list2, com.tencent.bugly.crashreport.common.info.a.b());
                            if (a == null) {
                                an.d("create eupPkg fail!", new Object[0]);
                                return;
                            }
                            byte[] a2 = ah.a(a);
                            if (a2 == null) {
                                an.d("send encode fail!", new Object[0]);
                                return;
                            }
                            bd a3 = ah.a(r1.b, i, a2);
                            if (a3 == null) {
                                an.d("request package is null.", new Object[0]);
                                return;
                            }
                            aj anonymousClass1 = new aj(r1) {
                                final /* synthetic */ b b;

                                public void a(int i) {
                                }

                                public void a(int i, be beVar, long j, long j2, boolean z, String str) {
                                    this.b.a(z, list2);
                                }
                            };
                            if (z) {
                                r1.c.a(a, a3, str, str2, anonymousClass1, j, z2);
                                return;
                            } else {
                                r1.c.a(a, a3, str, str2, anonymousClass1, false);
                                return;
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            an.e("req cr error %s", th2.toString());
                            if (!an.b(th2)) {
                                th2.printStackTrace();
                            }
                            return;
                        }
                    }
                }
                return;
            }
            an.d("remote report is disable!", new Object[0]);
            an.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
        }
    }

    public void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            an.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                an.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
                crashDetailBean.l++;
                crashDetailBean.d = z;
                an.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                c.a().a(crashDetailBean2);
            }
            an.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            an.b("[crash] upload fail.", new Object[0]);
        }
    }

    public void c(CrashDetailBean crashDetailBean) {
        b bVar = this;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            if (bVar.g != null || bVar.f != null) {
                try {
                    int i;
                    long j;
                    String str;
                    String str2;
                    String str3;
                    Map map;
                    int i2;
                    an.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
                    switch (crashDetailBean2.b) {
                        case 0:
                            i = 0;
                            break;
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 1;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 3;
                            break;
                        case 5:
                            i = 5;
                            break;
                        case 6:
                            i = 6;
                            break;
                        case 7:
                            i = 7;
                            break;
                        default:
                            return;
                    }
                    boolean z = crashDetailBean2.b == 1;
                    String str4 = crashDetailBean2.n;
                    String str5 = crashDetailBean2.p;
                    String str6 = crashDetailBean2.q;
                    long j2 = crashDetailBean2.r;
                    byte[] bArr = null;
                    if (bVar.f != null) {
                        Map hashMap;
                        bVar.f.a(z);
                        j = j2;
                        str = str6;
                        str2 = str4;
                        str3 = str5;
                        String b = bVar.f.b(z, str4, str5, str6, -1234567890, j);
                        if (b != null) {
                            hashMap = new HashMap(1);
                            hashMap.put("userData", b);
                        } else {
                            hashMap = null;
                        }
                        map = hashMap;
                    } else {
                        j = j2;
                        str = str6;
                        str2 = str4;
                        str3 = str5;
                        map = bVar.g != null ? bVar.g.onCrashHandleStart(i, crashDetailBean2.n, crashDetailBean2.o, crashDetailBean2.q) : null;
                    }
                    if (map != null && map.size() > 0) {
                        crashDetailBean2.O = new LinkedHashMap(map.size());
                        for (Entry entry : map.entrySet()) {
                            if (!ap.a((String) entry.getKey())) {
                                String stringBuilder;
                                Object obj = (String) entry.getKey();
                                if (obj.length() > 100) {
                                    obj = obj.substring(0, 100);
                                    an.d("setted key length is over limit %d substring to %s", Integer.valueOf(100), obj);
                                }
                                if (ap.a((String) entry.getValue()) || ((String) entry.getValue()).length() <= BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append((String) entry.getValue());
                                    stringBuilder = stringBuilder2.toString();
                                } else {
                                    stringBuilder = ((String) entry.getValue()).substring(((String) entry.getValue()).length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                                    an.d("setted %s value length is over limit %d substring", obj, Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                                }
                                crashDetailBean2.O.put(obj, stringBuilder);
                                an.a("add setted key %s value size:%d", obj, Integer.valueOf(stringBuilder.length()));
                            }
                        }
                    }
                    an.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
                    if (bVar.f != null) {
                        i2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                        bArr = bVar.f.a(z, str2, str3, str, -1234567890, j);
                    } else {
                        i2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                        if (bVar.g != null) {
                            bArr = bVar.g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean2.n, crashDetailBean2.o, crashDetailBean2.q);
                        }
                    }
                    crashDetailBean2.T = bArr;
                    if (crashDetailBean2.T != null) {
                        if (crashDetailBean2.T.length > i2) {
                            an.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(crashDetailBean2.T.length), Integer.valueOf(i2));
                        }
                        an.a("add extra bytes %d ", Integer.valueOf(crashDetailBean2.T.length));
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    an.d("crash handle callback somthing wrong! %s", th2.getClass().getName());
                    if (!an.a(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    protected ContentValues d(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ap.a((Parcelable) crashDetailBean));
            return contentValues;
        } catch (CrashDetailBean crashDetailBean2) {
            if (!an.a(crashDetailBean2)) {
                crashDetailBean2.printStackTrace();
            }
            return null;
        }
    }

    protected CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j;
            }
            return crashDetailBean;
        } catch (Cursor cursor2) {
            if (!an.a(cursor2)) {
                cursor2.printStackTrace();
            }
            return null;
        }
    }

    public void e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues d = d(crashDetailBean);
            if (d != null) {
                long a = ae.a().a("t_cr", d, null, true);
                if (a >= 0) {
                    an.c("insert %s success!", "t_cr");
                    crashDetailBean.a = a;
                }
            }
            if (c.i) {
                f(crashDetailBean);
            }
        }
    }

    public java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> b(java.util.List<com.tencent.bugly.crashreport.crash.a> r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = 0;
        if (r13 == 0) goto L_0x00d6;
    L_0x0003:
        r1 = r13.size();
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00d6;
    L_0x000b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r13 = r13.iterator();
    L_0x0014:
        r2 = r13.hasNext();
        if (r2 == 0) goto L_0x002b;
    L_0x001a:
        r2 = r13.next();
        r2 = (com.tencent.bugly.crashreport.crash.a) r2;
        r3 = " or _id = ";
        r1.append(r3);
        r2 = r2.a;
        r1.append(r2);
        goto L_0x0014;
    L_0x002b:
        r13 = r1.toString();
        r2 = r13.length();
        r3 = 4;
        if (r2 <= 0) goto L_0x003a;
    L_0x0036:
        r13 = r13.substring(r3);
    L_0x003a:
        r7 = r13;
        r13 = 0;
        r1.setLength(r13);
        r4 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r5 = "t_cr";	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r6 = 0;	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r8 = 0;	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r9 = 0;	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r10 = 1;	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        r2 = r4.a(r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00be, all -> 0x00bb }
        if (r2 != 0) goto L_0x0055;
    L_0x004f:
        if (r2 == 0) goto L_0x0054;
    L_0x0051:
        r2.close();
    L_0x0054:
        return r0;
    L_0x0055:
        r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00b9 }
        r4.<init>();	 Catch:{ Throwable -> 0x00b9 }
    L_0x005a:
        r5 = r2.moveToNext();	 Catch:{ Throwable -> 0x00b9 }
        if (r5 == 0) goto L_0x0085;	 Catch:{ Throwable -> 0x00b9 }
    L_0x0060:
        r5 = r12.a(r2);	 Catch:{ Throwable -> 0x00b9 }
        if (r5 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x00b9 }
    L_0x0066:
        r4.add(r5);	 Catch:{ Throwable -> 0x00b9 }
        goto L_0x005a;
    L_0x006a:
        r5 = "_id";	 Catch:{ Throwable -> 0x007d }
        r5 = r2.getColumnIndex(r5);	 Catch:{ Throwable -> 0x007d }
        r5 = r2.getLong(r5);	 Catch:{ Throwable -> 0x007d }
        r7 = " or _id = ";	 Catch:{ Throwable -> 0x007d }
        r1.append(r7);	 Catch:{ Throwable -> 0x007d }
        r1.append(r5);	 Catch:{ Throwable -> 0x007d }
        goto L_0x005a;
    L_0x007d:
        r5 = "unknown id!";	 Catch:{ Throwable -> 0x00b9 }
        r6 = new java.lang.Object[r13];	 Catch:{ Throwable -> 0x00b9 }
        com.tencent.bugly.proguard.an.d(r5, r6);	 Catch:{ Throwable -> 0x00b9 }
        goto L_0x005a;	 Catch:{ Throwable -> 0x00b9 }
    L_0x0085:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00b9 }
        r5 = r1.length();	 Catch:{ Throwable -> 0x00b9 }
        if (r5 <= 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00b9 }
    L_0x008f:
        r8 = r1.substring(r3);	 Catch:{ Throwable -> 0x00b9 }
        r6 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x00b9 }
        r7 = "t_cr";	 Catch:{ Throwable -> 0x00b9 }
        r9 = 0;	 Catch:{ Throwable -> 0x00b9 }
        r10 = 0;	 Catch:{ Throwable -> 0x00b9 }
        r11 = 1;	 Catch:{ Throwable -> 0x00b9 }
        r1 = r6.a(r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x00b9 }
        r3 = "deleted %s illegle data %d";	 Catch:{ Throwable -> 0x00b9 }
        r5 = 2;	 Catch:{ Throwable -> 0x00b9 }
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00b9 }
        r6 = "t_cr";	 Catch:{ Throwable -> 0x00b9 }
        r5[r13] = r6;	 Catch:{ Throwable -> 0x00b9 }
        r13 = 1;	 Catch:{ Throwable -> 0x00b9 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00b9 }
        r5[r13] = r1;	 Catch:{ Throwable -> 0x00b9 }
        com.tencent.bugly.proguard.an.d(r3, r5);	 Catch:{ Throwable -> 0x00b9 }
    L_0x00b3:
        if (r2 == 0) goto L_0x00b8;
    L_0x00b5:
        r2.close();
    L_0x00b8:
        return r4;
    L_0x00b9:
        r13 = move-exception;
        goto L_0x00c0;
    L_0x00bb:
        r13 = move-exception;
        r2 = r0;
        goto L_0x00d0;
    L_0x00be:
        r13 = move-exception;
        r2 = r0;
    L_0x00c0:
        r1 = com.tencent.bugly.proguard.an.a(r13);	 Catch:{ all -> 0x00cf }
        if (r1 != 0) goto L_0x00c9;	 Catch:{ all -> 0x00cf }
    L_0x00c6:
        r13.printStackTrace();	 Catch:{ all -> 0x00cf }
    L_0x00c9:
        if (r2 == 0) goto L_0x00ce;
    L_0x00cb:
        r2.close();
    L_0x00ce:
        return r0;
    L_0x00cf:
        r13 = move-exception;
    L_0x00d0:
        if (r2 == 0) goto L_0x00d5;
    L_0x00d2:
        r2.close();
    L_0x00d5:
        throw r13;
    L_0x00d6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b(java.util.List):java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean>");
    }

    protected a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            aVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            aVar.e = z;
            aVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Cursor cursor2) {
            if (!an.a(cursor2)) {
                cursor2.printStackTrace();
            }
            return null;
        }
    }

    public java.util.List<com.tencent.bugly.crashreport.crash.a> b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r15 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 6;
        r2 = 0;
        r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = "_id";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r10 = 0;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r10] = r1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = "_tm";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r11 = 1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r11] = r1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = "_s1";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r12 = 2;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r12] = r1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = 3;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r3 = "_up";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r1] = r3;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = "_me";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r13 = 4;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r13] = r1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = 5;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r3 = "_uc";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r5[r1] = r3;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r3 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r4 = "t_cr";	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r6 = 0;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r7 = 0;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r8 = 0;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r9 = 1;	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        r1 = r3.a(r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x00a4, all -> 0x00a1 }
        if (r1 != 0) goto L_0x003d;
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();
    L_0x003c:
        return r2;
    L_0x003d:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009f }
        r2.<init>();	 Catch:{ Throwable -> 0x009f }
    L_0x0042:
        r3 = r1.moveToNext();	 Catch:{ Throwable -> 0x009f }
        if (r3 == 0) goto L_0x006d;	 Catch:{ Throwable -> 0x009f }
    L_0x0048:
        r3 = r15.b(r1);	 Catch:{ Throwable -> 0x009f }
        if (r3 == 0) goto L_0x0052;	 Catch:{ Throwable -> 0x009f }
    L_0x004e:
        r0.add(r3);	 Catch:{ Throwable -> 0x009f }
        goto L_0x0042;
    L_0x0052:
        r3 = "_id";	 Catch:{ Throwable -> 0x0065 }
        r3 = r1.getColumnIndex(r3);	 Catch:{ Throwable -> 0x0065 }
        r3 = r1.getLong(r3);	 Catch:{ Throwable -> 0x0065 }
        r5 = " or _id = ";	 Catch:{ Throwable -> 0x0065 }
        r2.append(r5);	 Catch:{ Throwable -> 0x0065 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0042;
    L_0x0065:
        r3 = "unknown id!";	 Catch:{ Throwable -> 0x009f }
        r4 = new java.lang.Object[r10];	 Catch:{ Throwable -> 0x009f }
        com.tencent.bugly.proguard.an.d(r3, r4);	 Catch:{ Throwable -> 0x009f }
        goto L_0x0042;	 Catch:{ Throwable -> 0x009f }
    L_0x006d:
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009f }
        r3 = r2.length();	 Catch:{ Throwable -> 0x009f }
        if (r3 <= 0) goto L_0x0099;	 Catch:{ Throwable -> 0x009f }
    L_0x0077:
        r6 = r2.substring(r13);	 Catch:{ Throwable -> 0x009f }
        r4 = com.tencent.bugly.proguard.ae.a();	 Catch:{ Throwable -> 0x009f }
        r5 = "t_cr";	 Catch:{ Throwable -> 0x009f }
        r7 = 0;	 Catch:{ Throwable -> 0x009f }
        r8 = 0;	 Catch:{ Throwable -> 0x009f }
        r9 = 1;	 Catch:{ Throwable -> 0x009f }
        r2 = r4.a(r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x009f }
        r3 = "deleted %s illegle data %d";	 Catch:{ Throwable -> 0x009f }
        r4 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x009f }
        r5 = "t_cr";	 Catch:{ Throwable -> 0x009f }
        r4[r10] = r5;	 Catch:{ Throwable -> 0x009f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x009f }
        r4[r11] = r2;	 Catch:{ Throwable -> 0x009f }
        com.tencent.bugly.proguard.an.d(r3, r4);	 Catch:{ Throwable -> 0x009f }
    L_0x0099:
        if (r1 == 0) goto L_0x009e;
    L_0x009b:
        r1.close();
    L_0x009e:
        return r0;
    L_0x009f:
        r2 = move-exception;
        goto L_0x00a8;
    L_0x00a1:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b8;
    L_0x00a4:
        r1 = move-exception;
        r14 = r2;
        r2 = r1;
        r1 = r14;
    L_0x00a8:
        r3 = com.tencent.bugly.proguard.an.a(r2);	 Catch:{ all -> 0x00b7 }
        if (r3 != 0) goto L_0x00b1;	 Catch:{ all -> 0x00b7 }
    L_0x00ae:
        r2.printStackTrace();	 Catch:{ all -> 0x00b7 }
    L_0x00b1:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b3:
        r1.close();
    L_0x00b6:
        return r0;
    L_0x00b7:
        r0 = move-exception;
    L_0x00b8:
        if (r1 == 0) goto L_0x00bd;
    L_0x00ba:
        r1.close();
    L_0x00bd:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.b():java.util.List<com.tencent.bugly.crashreport.crash.a>");
    }

    public void c(List<a> list) {
        if (list != null) {
            if (list.size() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (a aVar : list) {
                    stringBuilder.append(" or _id = ");
                    stringBuilder.append(aVar.a);
                }
                list = stringBuilder.toString();
                if (list.length() > 0) {
                    list = list.substring(4);
                }
                String str = list;
                stringBuilder.setLength(0);
                try {
                    int a = ae.a().a("t_cr", str, null, null, true);
                    an.c("deleted %s data %d", "t_cr", Integer.valueOf(a));
                } catch (List<a> list2) {
                    if (!an.a(list2)) {
                        list2.printStackTrace();
                    }
                }
            }
        }
    }

    public void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (CrashDetailBean crashDetailBean : list) {
                        stringBuilder.append(" or _id = ");
                        stringBuilder.append(crashDetailBean.a);
                    }
                    list = stringBuilder.toString();
                    if (list.length() > 0) {
                        list = list.substring(4);
                    }
                    String str = list;
                    stringBuilder.setLength(0);
                    int a = ae.a().a("t_cr", str, null, null, true);
                    an.c("deleted %s data %d", "t_cr", Integer.valueOf(a));
                }
            } catch (List<CrashDetailBean> list2) {
                if (!an.a(list2)) {
                    list2.printStackTrace();
                }
            }
        }
    }

    public static bb a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        boolean z = false;
        if (!(context == null || crashDetailBean == null)) {
            if (aVar != null) {
                ay ayVar;
                ba a;
                Map map;
                StringBuilder stringBuilder;
                bb bbVar = new bb();
                switch (crashDetailBean.b) {
                    case 0:
                        bbVar.a = crashDetailBean.j ? "200" : MessageService.MSG_DB_COMPLETE;
                        break;
                    case 1:
                        bbVar.a = crashDetailBean.j ? "201" : "101";
                        break;
                    case 2:
                        bbVar.a = crashDetailBean.j ? "202" : "102";
                        break;
                    case 3:
                        bbVar.a = crashDetailBean.j ? "203" : "103";
                        break;
                    case 4:
                        bbVar.a = crashDetailBean.j ? "204" : "104";
                        break;
                    case 5:
                        bbVar.a = crashDetailBean.j ? "207" : "107";
                        break;
                    case 6:
                        bbVar.a = crashDetailBean.j ? "206" : "106";
                        break;
                    case 7:
                        bbVar.a = crashDetailBean.j ? "208" : "108";
                        break;
                    default:
                        an.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                        break;
                }
                bbVar.b = crashDetailBean.r;
                bbVar.c = crashDetailBean.n;
                bbVar.d = crashDetailBean.o;
                bbVar.e = crashDetailBean.p;
                bbVar.g = crashDetailBean.q;
                bbVar.h = crashDetailBean.y;
                bbVar.i = crashDetailBean.c;
                bbVar.j = null;
                bbVar.l = crashDetailBean.m;
                bbVar.m = crashDetailBean.e;
                bbVar.f = crashDetailBean.A;
                bbVar.t = com.tencent.bugly.crashreport.common.info.a.b().i();
                bbVar.n = null;
                if (crashDetailBean.i != null && crashDetailBean.i.size() > 0) {
                    bbVar.o = new ArrayList();
                    for (Entry entry : crashDetailBean.i.entrySet()) {
                        ayVar = new ay();
                        ayVar.a = ((PlugInBean) entry.getValue()).a;
                        ayVar.c = ((PlugInBean) entry.getValue()).c;
                        ayVar.e = ((PlugInBean) entry.getValue()).b;
                        ayVar.b = aVar.r();
                        bbVar.o.add(ayVar);
                    }
                }
                if (crashDetailBean.h != null && crashDetailBean.h.size() > 0) {
                    bbVar.p = new ArrayList();
                    for (Entry entry2 : crashDetailBean.h.entrySet()) {
                        ayVar = new ay();
                        ayVar.a = ((PlugInBean) entry2.getValue()).a;
                        ayVar.c = ((PlugInBean) entry2.getValue()).c;
                        ayVar.e = ((PlugInBean) entry2.getValue()).b;
                        bbVar.p.add(ayVar);
                    }
                }
                if (crashDetailBean.j) {
                    bbVar.k = crashDetailBean.t;
                    if (crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
                        if (bbVar.q == null) {
                            bbVar.q = new ArrayList();
                        }
                        try {
                            bbVar.q.add(new ba((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            bbVar.q = null;
                        }
                    }
                    String str = "crashcount:%d sz:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(bbVar.k);
                    objArr[1] = Integer.valueOf(bbVar.q != null ? bbVar.q.size() : 0);
                    an.c(str, objArr);
                }
                if (crashDetailBean.w != null) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    try {
                        bbVar.q.add(new ba((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        bbVar.q = null;
                    }
                }
                if (!ap.a(crashDetailBean.U)) {
                    Object baVar;
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    try {
                        baVar = new ba((byte) 1, "crashInfos.txt", crashDetailBean.U.getBytes("utf-8"));
                    } catch (UnsupportedEncodingException e22) {
                        e22.printStackTrace();
                        baVar = null;
                    }
                    if (baVar != null) {
                        an.c("attach crash infos", new Object[0]);
                        bbVar.q.add(baVar);
                    }
                }
                if (crashDetailBean.V != null) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    a = a("backupRecord.zip", context, crashDetailBean.V);
                    if (a != null) {
                        an.c("attach backup record", new Object[0]);
                        bbVar.q.add(a);
                    }
                }
                if (crashDetailBean.x != null && crashDetailBean.x.length > 0) {
                    a = new ba((byte) 2, "buglylog.zip", crashDetailBean.x);
                    an.c("attach user log", new Object[0]);
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    bbVar.q.add(a);
                }
                if (crashDetailBean.b == 3) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    if (crashDetailBean.O != null && crashDetailBean.O.containsKey("BUGLY_CR_01")) {
                        try {
                            bbVar.q.add(new ba((byte) 1, "anrMessage.txt", ((String) crashDetailBean.O.get("BUGLY_CR_01")).getBytes("utf-8")));
                            an.c("attach anr message", new Object[0]);
                        } catch (UnsupportedEncodingException e222) {
                            e222.printStackTrace();
                            bbVar.q = null;
                        }
                        crashDetailBean.O.remove("BUGLY_CR_01");
                    }
                    if (crashDetailBean.v != null) {
                        a = a("trace.zip", context, crashDetailBean.v);
                        if (a != null) {
                            an.c("attach traces", new Object[0]);
                            bbVar.q.add(a);
                        }
                    }
                }
                if (crashDetailBean.b == 1) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    if (crashDetailBean.v != null) {
                        context = a("tomb.zip", context, crashDetailBean.v);
                        if (context != null) {
                            an.c("attach tombs", new Object[0]);
                            bbVar.q.add(context);
                        }
                    }
                }
                if (aVar.H != null && aVar.H.isEmpty() == null) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    context = new StringBuilder();
                    for (String append : aVar.H) {
                        context.append(append);
                    }
                    try {
                        bbVar.q.add(new ba((byte) 1, "martianlog.txt", context.toString().getBytes("utf-8")));
                        an.c("attach pageTracingList", new Object[0]);
                    } catch (Context context2) {
                        context2.printStackTrace();
                    }
                }
                if (crashDetailBean.T != null && crashDetailBean.T.length > null) {
                    if (bbVar.q == null) {
                        bbVar.q = new ArrayList();
                    }
                    bbVar.q.add(new ba((byte) 1, "userExtraByteData", crashDetailBean.T));
                    an.c("attach extraData", new Object[0]);
                }
                bbVar.r = new HashMap();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.B);
                bbVar.r.put("A9", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.C);
                bbVar.r.put("A11", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.D);
                bbVar.r.put("A10", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.f);
                bbVar.r.put("A23", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.k);
                bbVar.r.put("A7", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.s());
                bbVar.r.put("A6", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.r());
                bbVar.r.put("A5", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.h());
                bbVar.r.put("A22", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.F);
                bbVar.r.put("A2", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.E);
                bbVar.r.put("A1", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.m);
                bbVar.r.put("A24", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.G);
                bbVar.r.put("A17", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.k());
                bbVar.r.put("A3", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.m());
                bbVar.r.put("A16", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.n());
                bbVar.r.put("A25", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.l());
                bbVar.r.put("A14", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.w());
                bbVar.r.put("A15", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.x());
                bbVar.r.put("A13", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.z);
                bbVar.r.put("A34", stringBuilder2.toString());
                if (aVar.C != null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(aVar.C);
                    bbVar.r.put("productIdentify", stringBuilder2.toString());
                }
                try {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(crashDetailBean.H, "utf-8"));
                    bbVar.r.put("A26", stringBuilder2.toString());
                } catch (Context context22) {
                    context22.printStackTrace();
                }
                if (crashDetailBean.b == 1) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(crashDetailBean.K);
                    bbVar.r.put("A27", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(crashDetailBean.J);
                    bbVar.r.put("A28", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(crashDetailBean.k);
                    bbVar.r.put("A29", stringBuilder2.toString());
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.L);
                bbVar.r.put("A30", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.M);
                bbVar.r.put("A18", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashDetailBean.N ^ true);
                bbVar.r.put("A36", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.v);
                bbVar.r.put("F02", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.w);
                bbVar.r.put("F03", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.e());
                bbVar.r.put("F04", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.x);
                bbVar.r.put("F05", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.u);
                bbVar.r.put("F06", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.A);
                bbVar.r.put("F08", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.B);
                bbVar.r.put("F09", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aVar.y);
                bbVar.r.put("F10", stringBuilder2.toString());
                if (crashDetailBean.P >= null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(crashDetailBean.P);
                    bbVar.r.put("C01", stringBuilder2.toString());
                }
                if (crashDetailBean.Q >= null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(crashDetailBean.Q);
                    bbVar.r.put("C02", stringBuilder2.toString());
                }
                if (crashDetailBean.R != null && crashDetailBean.R.size() > null) {
                    for (Entry entry3 : crashDetailBean.R.entrySet()) {
                        map = bbVar.r;
                        stringBuilder = new StringBuilder("C03_");
                        stringBuilder.append((String) entry3.getKey());
                        map.put(stringBuilder.toString(), entry3.getValue());
                    }
                }
                if (crashDetailBean.S != null && crashDetailBean.S.size() > null) {
                    for (Entry entry32 : crashDetailBean.S.entrySet()) {
                        map = bbVar.r;
                        stringBuilder = new StringBuilder("C04_");
                        stringBuilder.append((String) entry32.getKey());
                        map.put(stringBuilder.toString(), entry32.getValue());
                    }
                }
                bbVar.s = null;
                if (crashDetailBean.O != null && crashDetailBean.O.size() > null) {
                    bbVar.s = crashDetailBean.O;
                    an.a("setted message size %d", Integer.valueOf(bbVar.s.size()));
                }
                context22 = "%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d";
                Object[] objArr2 = new Object[12];
                objArr2[0] = crashDetailBean.n;
                objArr2[1] = crashDetailBean.c;
                objArr2[2] = aVar.e();
                objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.M) / 1000);
                objArr2[4] = Boolean.valueOf(crashDetailBean.k);
                objArr2[5] = Boolean.valueOf(crashDetailBean.N);
                objArr2[6] = Boolean.valueOf(crashDetailBean.j);
                if (crashDetailBean.b == 1) {
                    z = true;
                }
                objArr2[7] = Boolean.valueOf(z);
                objArr2[8] = Integer.valueOf(crashDetailBean.t);
                objArr2[9] = crashDetailBean.s;
                objArr2[10] = Boolean.valueOf(crashDetailBean.d);
                objArr2[11] = Integer.valueOf(bbVar.r.size());
                an.c(context22, objArr2);
                return bbVar;
            }
        }
        an.d("enExp args == null", new Object[0]);
        return null;
    }

    public static bc a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (!(context == null || list == null || list.size() == 0)) {
            if (aVar != null) {
                bc bcVar = new bc();
                bcVar.a = new ArrayList();
                for (CrashDetailBean a : list) {
                    bcVar.a.add(a(context, a, aVar));
                }
                return bcVar;
            }
        }
        an.d("enEXPPkg args == null!", new Object[null]);
        return null;
    }

    public static ba a(String str, Context context, String str2) {
        if (str2 != null) {
            if (context != null) {
                an.c("zip %s", str2);
                File file = new File(str2);
                File file2 = new File(context.getCacheDir(), str);
                if (ap.a(file, file2, (int) ReaderCallback.GET_BAR_ANIMATING) == null) {
                    an.d("zip fail!", new Object[0]);
                    return null;
                }
                str = new ByteArrayOutputStream();
                try {
                    context = new FileInputStream(file2);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = context.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            str.write(bArr, 0, read);
                            str.flush();
                        }
                        an.c("read bytes :%d", Integer.valueOf(str.toByteArray().length));
                        ba baVar = new ba((byte) 2, file2.getName(), str);
                        try {
                            context.close();
                        } catch (String str3) {
                            if (an.a(str3) == null) {
                                str3.printStackTrace();
                            }
                        }
                        if (file2.exists() != null) {
                            an.c("del tmp", new Object[0]);
                            file2.delete();
                        }
                        return baVar;
                    } catch (Throwable th) {
                        str3 = th;
                        try {
                            if (!an.a(str3)) {
                                str3.printStackTrace();
                            }
                            if (context != null) {
                                try {
                                    context.close();
                                } catch (String str32) {
                                    if (an.a(str32) == null) {
                                        str32.printStackTrace();
                                    }
                                }
                            }
                            if (file2.exists() != null) {
                                an.c("del tmp", new Object[0]);
                                file2.delete();
                            }
                            return null;
                        } catch (Throwable th2) {
                            str32 = th2;
                            if (context != null) {
                                try {
                                    context.close();
                                } catch (Context context2) {
                                    if (!an.a(context2)) {
                                        context2.printStackTrace();
                                    }
                                }
                            }
                            if (file2.exists() != null) {
                                an.c("del tmp", new Object[0]);
                                file2.delete();
                            }
                            throw str32;
                        }
                    }
                } catch (Throwable th3) {
                    str32 = th3;
                    context2 = null;
                    if (context2 != null) {
                        context2.close();
                    }
                    if (file2.exists() != null) {
                        an.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw str32;
                }
            }
        }
        an.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    private boolean f(CrashDetailBean crashDetailBean) {
        try {
            StringBuilder stringBuilder;
            an.c("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
            String f = b.f();
            String str = b.o;
            String str2 = crashDetailBean.z;
            r8 = new Object[9];
            b.getClass();
            r8[2] = "2.6.5";
            r8[3] = str2;
            r8[4] = ap.a(new Date(crashDetailBean.r));
            r8[5] = crashDetailBean.n;
            r8[6] = crashDetailBean.o;
            r8[7] = crashDetailBean.q;
            r8[8] = crashDetailBean.c;
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", r8);
            String str3 = null;
            if (c.j != null) {
                File file = new File(c.j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str3 = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                str3 = Environment.getExternalStorageDirectory().getAbsolutePath();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append("/Tencent/");
                stringBuilder.append(this.b.getPackageName());
                str3 = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append("/euplog.txt");
            ap.a(this.b, stringBuilder.toString(), format, c.k);
            return true;
        } catch (CrashDetailBean crashDetailBean2) {
            an.d("rqdp{  save error} %s", crashDetailBean2.toString());
            if (!an.a(crashDetailBean2)) {
                crashDetailBean2.printStackTrace();
            }
            return false;
        }
    }

    public static void a(String str, String str2, String str3, Thread thread, String str4, CrashDetailBean crashDetailBean) {
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        if (b != null) {
            an.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            an.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            an.e("# PKG NAME: %s", b.d);
            an.e("# APP VER: %s", b.o);
            an.e("# LAUNCH TIME: %s", ap.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)));
            an.e("# CRASH TYPE: %s", str);
            an.e("# CRASH TIME: %s", str2);
            an.e("# CRASH PROCESS: %s", new Object[]{str3});
            if (thread != null) {
                an.e("# CRASH THREAD: %s", new Object[]{thread.getName()});
            }
            if (crashDetailBean != null) {
                an.e("# REPORT ID: %s", new Object[]{crashDetailBean.c});
                str = "# CRASH DEVICE: %s %s";
                str3 = new Object[2];
                str3[0] = b.l;
                str3[1] = b.x().booleanValue() != null ? "ROOTED" : "UNROOT";
                an.e(str, str3);
                an.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[]{Long.valueOf(crashDetailBean.B), Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D)});
                an.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[]{Long.valueOf(crashDetailBean.E), Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G)});
                if (ap.a(crashDetailBean.K) == null) {
                    an.e("# EXCEPTION FIRED BY %s %s", new Object[]{crashDetailBean.K, crashDetailBean.J});
                } else if (crashDetailBean.b == 3) {
                    str = "# EXCEPTION ANR MESSAGE:\n %s";
                    str2 = new Object[1];
                    if (crashDetailBean.O == null) {
                        str3 = "null";
                    } else {
                        str3 = new StringBuilder();
                        str3.append((String) crashDetailBean.O.get("BUGLY_CR_01"));
                        str3 = str3.toString();
                    }
                    str2[0] = str3;
                    an.e(str, str2);
                }
            }
            if (ap.a(str4) == null) {
                an.e("# CRASH STACK: ", new Object[0]);
                an.e(str4, new Object[0]);
            }
            an.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }
}
