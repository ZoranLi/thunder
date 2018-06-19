package com.xunlei.downloadlib.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.umeng.message.proguard.l;
import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.android.shortvideo.ShortVideoInterface.PlayerEvent;
import com.xunlei.android.shortvideo.ShortVideoTask;
import com.xunlei.android.shortvideo.ShortVideoTask.STATUS;
import com.xunlei.android.shortvideo.a.a;
import com.xunlei.android.shortvideo.a.c;
import com.xunlei.android.shortvideo.d;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.android.XLUtil;
import com.xunlei.downloadlib.parameter.InitParam;
import com.xunlei.downloadlib.parameter.XLConstant.XLManagerStatus;
import com.xunlei.downloadlib.parameter.XLSessionInfo;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ShortVideoMgr */
public class b implements Runnable {
    static final /* synthetic */ boolean d = true;
    private static final String e = "ShortVideoMgr";
    private static final int f = 2;
    private static final String u = "com.xunlei.download.APP_KEY";
    boolean a = false;
    long b = 0;
    boolean c = true;
    private Handler g;
    private Context h;
    private Map<String, ShortVideoTask> i = new TreeMap();
    private Map<Integer, ShortVideoTask> j = new TreeMap();
    private ArrayList<Integer> k;
    private long l = 314572800;
    private String m = null;
    private String n = null;
    private com.xunlei.android.shortvideo.ShortVideoInterface.b o;
    private a p;
    private String q;
    private long r = System.currentTimeMillis();
    private long s = System.currentTimeMillis();
    private boolean t = false;

    public b(Context context, long j, String str, String str2) {
        if (d || !TextUtils.isEmpty(str)) {
            this.t = Boolean.TRUE.equals(a(context, "DEBUG"));
            this.m = str;
            str = new File(this.m);
            if (!str.exists()) {
                str.mkdir();
            }
            if (TextUtils.isEmpty(str2) == null && str2.endsWith(File.separator) == null) {
                str = new StringBuilder();
                str.append(str2);
                str.append(File.separator);
                str2 = str.toString();
            }
            b(context, str2);
            this.k = new ArrayList();
            this.g = new Handler();
            this.h = context;
            this.l = j;
            this.p = new a("short_video", context, str2);
            context = new StringBuilder("ShortVideo.");
            context.append(this.h.getPackageName());
            this.q = context.toString();
            return;
        }
        throw new AssertionError("cachePath is Empty");
    }

    public void a(ArrayList<ShortVideoInterface.a> arrayList, com.xunlei.android.shortvideo.ShortVideoInterface.b bVar) {
        if (arrayList != null) {
            if (true != arrayList.isEmpty()) {
                int i;
                String str;
                StringBuilder stringBuilder;
                int i2 = 0;
                for (i = 0; i < this.j.size(); i++) {
                    ShortVideoTask shortVideoTask = (ShortVideoTask) this.j.get(Integer.valueOf(i));
                    if (i == 0 && -1 == shortVideoTask.a.e) {
                        if (shortVideoTask.a.b.equals(((ShortVideoInterface.a) arrayList.get(0)).b)) {
                            if (shortVideoTask.a.a.equals(((ShortVideoInterface.a) arrayList.get(0)).a)) {
                            } else {
                                str = e;
                                stringBuilder = new StringBuilder("createTask same gcid but diffrent url gcid=");
                                stringBuilder.append(((ShortVideoInterface.a) arrayList.get(0)).b);
                                stringBuilder.append(" url=");
                                stringBuilder.append(((ShortVideoInterface.a) arrayList.get(0)).a);
                                stringBuilder.append("]");
                                XLLog.e(str, stringBuilder.toString());
                            }
                        } else if (shortVideoTask.a.a.equals(((ShortVideoInterface.a) arrayList.get(0)).a)) {
                            str = e;
                            stringBuilder = new StringBuilder("createTask same url but diffrent gcid gcid=");
                            stringBuilder.append(((ShortVideoInterface.a) arrayList.get(0)).b);
                            stringBuilder.append(" url=");
                            stringBuilder.append(((ShortVideoInterface.a) arrayList.get(0)).a);
                            stringBuilder.append("]");
                            XLLog.w(str, stringBuilder.toString());
                        }
                    }
                    shortVideoTask.a(193);
                }
                this.j.clear();
                this.k.clear();
                String str2 = ((ShortVideoInterface.a) arrayList.get(0)).b;
                for (i = 0; i < arrayList.size(); i++) {
                    ShortVideoInterface.a aVar = (ShortVideoInterface.a) arrayList.get(i);
                    if (!TextUtils.isEmpty(aVar.b)) {
                        if (!TextUtils.isEmpty(aVar.a)) {
                            if (i <= 0 || !aVar.b.equals(str2)) {
                                ShortVideoTask shortVideoTask2 = (ShortVideoTask) this.i.get(aVar.b);
                                String str3;
                                StringBuilder stringBuilder2;
                                if (shortVideoTask2 == null) {
                                    shortVideoTask2 = new ShortVideoTask(aVar, this.m, this.q);
                                    this.i.put(aVar.b, shortVideoTask2);
                                    str3 = e;
                                    stringBuilder2 = new StringBuilder("createTask new ShortVideoTask VideoId=[");
                                    stringBuilder2.append(shortVideoTask2.e);
                                    stringBuilder2.append("]");
                                    XLLog.d(str3, stringBuilder2.toString());
                                } else {
                                    shortVideoTask2.a.a = aVar.a;
                                    shortVideoTask2.b(aVar.e);
                                    str3 = e;
                                    stringBuilder2 = new StringBuilder("createTask setCacheDuration VideoId=[");
                                    stringBuilder2.append(shortVideoTask2.e);
                                    stringBuilder2.append("] mCacheDuration=[");
                                    stringBuilder2.append(aVar.e);
                                    stringBuilder2.append("]");
                                    XLLog.d(str3, stringBuilder2.toString());
                                }
                                this.j.put(Integer.valueOf(this.j.size()), this.i.get(aVar.b));
                                if (this.k.size() < 2) {
                                    this.k.add(Integer.valueOf(i));
                                }
                            } else {
                                XLLog.e(e, "createTask two task has same gcid");
                            }
                        }
                    }
                    str = e;
                    stringBuilder = new StringBuilder("createTask param null url:[");
                    stringBuilder.append(aVar.a);
                    stringBuilder.append("] gcid:[");
                    stringBuilder.append(aVar.b);
                    stringBuilder.append("]");
                    XLLog.e(str, stringBuilder.toString());
                }
                if (bVar != null) {
                    this.o = bVar;
                    a(PlayerEvent.CREATE_START, System.currentTimeMillis());
                    run();
                }
                if (this.t != null) {
                    ShortVideoTask shortVideoTask3;
                    arrayList = new StringBuilder("createTask mNeedDownloadMap[");
                    arrayList.append(this.j.size());
                    arrayList.append("] mTaskMap=[");
                    arrayList.append(this.i.size());
                    arrayList.append("]\n");
                    arrayList = arrayList.toString();
                    for (Entry entry : this.j.entrySet()) {
                        Integer num = (Integer) entry.getKey();
                        shortVideoTask3 = (ShortVideoTask) entry.getValue();
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(arrayList);
                        stringBuilder3.append("  mNeedDownloadMap[");
                        stringBuilder3.append(num);
                        stringBuilder3.append("] VideoId=[");
                        stringBuilder3.append(shortVideoTask3.e);
                        stringBuilder3.append("] title=[");
                        stringBuilder3.append(shortVideoTask3.a.c);
                        stringBuilder3.append("]\n");
                        arrayList = stringBuilder3.toString();
                    }
                    for (Entry entry2 : this.i.entrySet()) {
                        entry2.getKey();
                        shortVideoTask3 = (ShortVideoTask) entry2.getValue();
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(arrayList);
                        stringBuilder4.append("  mTaskMap[");
                        stringBuilder4.append(i2);
                        stringBuilder4.append("] VideoId=[");
                        stringBuilder4.append(shortVideoTask3.e);
                        stringBuilder4.append("] title=[");
                        stringBuilder4.append(shortVideoTask3.a.c);
                        stringBuilder4.append("]\n");
                        arrayList = stringBuilder4.toString();
                        i2++;
                    }
                    XLLog.d(e, arrayList);
                }
                return;
            }
        }
        arrayList = this.j.values().iterator();
        while (arrayList.hasNext() != null) {
            ((ShortVideoTask) arrayList.next()).a(193);
        }
        this.j.clear();
        this.k.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
        r12 = this;
        r0 = r12.k;
        r0 = r0.size();
        r1 = -1;
        if (r0 <= 0) goto L_0x0016;
    L_0x0009:
        r0 = r12.k;
        r0 = java.util.Collections.max(r0);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        goto L_0x0017;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        r2 = 0;
        r4 = r0;
        r0 = r2;
        r3 = r0;
    L_0x001b:
        r5 = r12.k;
        r5 = r5.size();
        if (r0 >= r5) goto L_0x0186;
    L_0x0023:
        r5 = r12.k;
        r5 = r5.get(r0);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
    L_0x002f:
        r6 = r12.j;
        r6 = r6.size();
        r7 = 1;
        if (r5 >= r6) goto L_0x0182;
    L_0x0038:
        r6 = r12.j;
        r8 = java.lang.Integer.valueOf(r5);
        r6 = r6.get(r8);
        r6 = (com.xunlei.android.shortvideo.ShortVideoTask) r6;
        r8 = r12.a;
        if (r8 != 0) goto L_0x0055;
    L_0x0048:
        r5 = 9102; // 0x238e float:1.2755E-41 double:4.497E-320;
        r6.k = r5;
        r5 = "ShortVideoMgr";
        r6 = "update running task SDK_NOT_INIT";
        com.xunlei.downloadlib.android.XLLog.e(r5, r6);
        goto L_0x0182;
    L_0x0055:
        if (r5 == 0) goto L_0x00af;
    L_0x0057:
        r8 = com.xunlei.android.shortvideo.d.a;
        r9 = r6.d;
        r9 = r9.ordinal();
        r8 = r8[r9];
        switch(r8) {
            case 2: goto L_0x00a3;
            case 3: goto L_0x0094;
            default: goto L_0x0064;
        };
    L_0x0064:
        r8 = "ShortVideoTask";
        r9 = new java.lang.StringBuilder;
        r10 = "update other continue VideoId=[";
        r9.<init>(r10);
        r10 = r6.e;
        r9.append(r10);
        r10 = "] status=[";
        r9.append(r10);
        r10 = r6.d;
        r9.append(r10);
        r10 = "] index=[";
        r9.append(r10);
        r9.append(r5);
        r10 = "]";
        r9.append(r10);
        r9 = r9.toString();
        com.xunlei.downloadlib.android.XLLog.d(r8, r9);
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x0094:
        r6.b();
        r8 = r6.d();
        if (r8 == 0) goto L_0x009f;
    L_0x009d:
        goto L_0x0132;
    L_0x009f:
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x00a3:
        r6.b();
        r8 = com.xunlei.android.shortvideo.ShortVideoTask.STATUS.PREDOWNLOADING;
        r6.d = r8;
        r6.c();
        goto L_0x0132;
    L_0x00af:
        r8 = com.xunlei.android.shortvideo.d.a;
        r9 = r6.d;
        r9 = r9.ordinal();
        r8 = r8[r9];
        switch(r8) {
            case 1: goto L_0x0116;
            case 2: goto L_0x010b;
            case 3: goto L_0x00f0;
            case 4: goto L_0x00e3;
            case 5: goto L_0x010b;
            default: goto L_0x00bc;
        };
    L_0x00bc:
        r8 = "ShortVideoTask";
        r9 = new java.lang.StringBuilder;
        r10 = "update first continue VideoId=[";
        r9.<init>(r10);
        r10 = r6.e;
        r9.append(r10);
        r10 = "] status=[";
        r9.append(r10);
        r10 = r6.d;
        r9.append(r10);
        r10 = "]";
        r9.append(r10);
        r9 = r9.toString();
        com.xunlei.downloadlib.android.XLLog.d(r8, r9);
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x00e3:
        r6.b();
        r8 = r6.d();
        if (r8 == 0) goto L_0x00ed;
    L_0x00ec:
        goto L_0x0132;
    L_0x00ed:
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x00f0:
        r8 = r6.a;
        r8 = r8.e;
        if (r1 == r8) goto L_0x00fe;
    L_0x00f6:
        r8 = 9410; // 0x24c2 float:1.3186E-41 double:4.649E-320;
        r6.a(r8);
        r6.b(r1);
    L_0x00fe:
        r6.b();
        r8 = r6.d();
        if (r8 == 0) goto L_0x0108;
    L_0x0107:
        goto L_0x0132;
    L_0x0108:
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x010b:
        r6.b(r1);
        r6.b();
        r8 = com.xunlei.android.shortvideo.ShortVideoTask.STATUS.PREDOWNLOADING;
        r6.d = r8;
        goto L_0x0132;
    L_0x0116:
        r8 = new java.io.File;
        r9 = r6.a();
        r8.<init>(r9);
        r8 = r8.exists();
        if (r8 == 0) goto L_0x0128;
    L_0x0125:
        r8 = r5 + 1;
        goto L_0x0133;
    L_0x0128:
        r6.b(r1);
        r6.b();
        r8 = com.xunlei.android.shortvideo.ShortVideoTask.STATUS.PREDOWNLOADING;
        r6.d = r8;
    L_0x0132:
        r8 = r5;
    L_0x0133:
        if (r5 != r8) goto L_0x0137;
    L_0x0135:
        r8 = r7;
        goto L_0x0138;
    L_0x0137:
        r8 = r2;
    L_0x0138:
        if (r5 != 0) goto L_0x013d;
    L_0x013a:
        r12.a(r6);
    L_0x013d:
        if (r8 == 0) goto L_0x0174;
    L_0x013f:
        r12.c = r7;
        r3 = "ShortVideoMgr";
        r5 = new java.lang.StringBuilder;
        r8 = "update running task VideoId=[";
        r5.<init>(r8);
        r8 = r6.e;
        r5.append(r8);
        r6 = "] mRunningTaskIndexes=";
        r5.append(r6);
        r6 = r12.k;
        r6 = r6.toString();
        r5.append(r6);
        r6 = " needDownload=";
        r5.append(r6);
        r6 = r12.j;
        r6 = r6.size();
        r5.append(r6);
        r5 = r5.toString();
        com.xunlei.downloadlib.android.XLLog.d(r3, r5);
        r3 = r7;
        goto L_0x0182;
    L_0x0174:
        r4 = r4 + 1;
        r5 = r12.k;
        r6 = java.lang.Integer.valueOf(r4);
        r5.set(r0, r6);
        r5 = r4;
        goto L_0x002f;
    L_0x0182:
        r0 = r0 + 1;
        goto L_0x001b;
    L_0x0186:
        if (r3 == 0) goto L_0x020c;
    L_0x0188:
        r0 = 9;
        r4 = r12.h;
        r4 = com.xunlei.downloadlib.android.XLUtil.getNetworkTypeComplete(r4);
        if (r0 == r4) goto L_0x01eb;
    L_0x0192:
        r0 = r12.j;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x019c:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x020c;
    L_0x01a2:
        r4 = r0.next();
        r4 = (java.util.Map.Entry) r4;
        r5 = r4.getKey();
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r4 = r4.getValue();
        r4 = (com.xunlei.android.shortvideo.ShortVideoTask) r4;
        if (r5 != 0) goto L_0x01e2;
    L_0x01ba:
        r5 = r12.k;
        r5 = r5.get(r2);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        if (r5 != 0) goto L_0x01dd;
    L_0x01c8:
        r5 = r4.a;
        r5 = r5.e;
        if (r5 != r1) goto L_0x01dd;
    L_0x01ce:
        r4 = r12.k;
        r4.clear();
        r4 = r12.k;
        r5 = java.lang.Integer.valueOf(r2);
        r4.add(r5);
        goto L_0x019c;
    L_0x01dd:
        r5 = r12.k;
        r5.clear();
    L_0x01e2:
        r5 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r4.a(r5);
        r0.remove();
        goto L_0x019c;
    L_0x01eb:
        r0 = r12.k;
        r0 = r0.get(r2);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x020c;
    L_0x01f9:
        r0 = r12.j;
        r4 = java.lang.Integer.valueOf(r2);
        r0 = r0.get(r4);
        r0 = (com.xunlei.android.shortvideo.ShortVideoTask) r0;
        r0 = r0.a;
        r0 = r0.e;
        if (r0 != r1) goto L_0x020c;
    L_0x020b:
        return;
    L_0x020c:
        r0 = r12.c;
        if (r0 == 0) goto L_0x022b;
    L_0x0210:
        r0 = java.lang.System.currentTimeMillis();
        r4 = r12.b;
        r6 = r0 - r4;
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r4 <= 0) goto L_0x022b;
    L_0x021e:
        r12.a();
        r0 = java.lang.System.currentTimeMillis();
        r12.b = r0;
        if (r3 != 0) goto L_0x022b;
    L_0x0229:
        r12.c = r2;
    L_0x022b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.proguard.b.c():void");
    }

    void a() {
        File[] listFiles = new File(this.m).listFiles();
        if (listFiles != null) {
            if (listFiles.length >= 2) {
                Map treeMap = new TreeMap();
                int i = 0;
                long j = 0;
                while (i < listFiles.length) {
                    File file = listFiles[i];
                    long length = j + file.length();
                    Object name = file.getName();
                    Matcher matcher = Pattern.compile("^\\.([\\w]+)\\.js$").matcher(name);
                    if (matcher.find()) {
                        name = matcher.group(1);
                    }
                    if (treeMap.containsKey(name)) {
                        treeMap.put(name, Long.valueOf(file.length() + ((Long) treeMap.get(name)).longValue()));
                    } else {
                        treeMap.put(name, Long.valueOf(file.length()));
                    }
                    i++;
                    j = length;
                }
                String str = e;
                StringBuilder stringBuilder = new StringBuilder("checkDiskSpaceSize totalSize=[");
                stringBuilder.append(j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                stringBuilder.append("] fileCount=[");
                stringBuilder.append(treeMap.size());
                stringBuilder.append("]");
                XLLog.d(str, stringBuilder.toString());
                if (j > this.l) {
                    Iterator it;
                    ShortVideoTask shortVideoTask;
                    for (ShortVideoTask shortVideoTask2 : this.j.values()) {
                        treeMap.remove(shortVideoTask2.a.b);
                    }
                    if (!treeMap.isEmpty()) {
                        Map treeMap2 = new TreeMap();
                        treeMap2.putAll(treeMap);
                        for (ShortVideoTask shortVideoTask3 : this.i.values()) {
                            treeMap.remove(shortVideoTask3.a.b);
                        }
                        if (!treeMap.isEmpty()) {
                            treeMap2 = treeMap;
                        }
                        Object arrayList = new ArrayList(treeMap2.entrySet());
                        Collections.sort(arrayList, new Comparator<Entry<String, Long>>(this) {
                            final /* synthetic */ b a;

                            {
                                this.a = r1;
                            }

                            public /* synthetic */ int compare(Object obj, Object obj2) {
                                return a((Entry) obj, (Entry) obj2);
                            }

                            public int a(Entry<String, Long> entry, Entry<String, Long> entry2) {
                                return (int) (((Long) entry2.getValue()).longValue() - ((Long) entry.getValue()).longValue());
                            }
                        });
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (j < this.l) {
                                break;
                            }
                            long longValue = j - ((Long) entry.getValue()).longValue();
                            shortVideoTask2 = (ShortVideoTask) this.i.get(entry.getKey());
                            if (shortVideoTask2 != null) {
                                shortVideoTask2.i = 0;
                                shortVideoTask2.d = STATUS.INIT;
                                shortVideoTask2.j.clearTaskFile(shortVideoTask2.a());
                                this.i.remove(entry.getKey());
                            } else {
                                try {
                                    XLDownloadManager.getInstance(this.h).clearTaskFile(new File(this.m, (String) entry.getKey()).getCanonicalPath());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            j = longValue;
                        }
                    }
                }
            }
        }
    }

    private void a(ShortVideoTask shortVideoTask) {
        if (this.o != null) {
            if (shortVideoTask.a.e == -1) {
                StringBuilder stringBuilder;
                String a;
                switch (d.a[shortVideoTask.d.ordinal()]) {
                    case 1:
                        stringBuilder = new StringBuilder("getPlayUrl mStatus SUCCESS VideoId=[");
                        stringBuilder.append(shortVideoTask.e);
                        stringBuilder.append("] getFullPath=[");
                        stringBuilder.append(shortVideoTask.a());
                        stringBuilder.append("]");
                        XLLog.d("ShortVideoTask", stringBuilder.toString());
                        a = shortVideoTask.a();
                        break;
                    case 2:
                    case 3:
                    case 4:
                        if (-1 != shortVideoTask.c) {
                            a = shortVideoTask.c();
                            StringBuilder stringBuilder2 = new StringBuilder("getPlayUrl getLocalUrl success VideoId=[");
                            stringBuilder2.append(shortVideoTask.e);
                            stringBuilder2.append("] url.mStrUrl=[");
                            stringBuilder2.append(a);
                            stringBuilder2.append("]");
                            XLLog.d("ShortVideoTask", stringBuilder2.toString());
                            break;
                        }
                        stringBuilder = new StringBuilder("getPlayUrl task paused VideoId=[");
                        stringBuilder.append(shortVideoTask.e);
                        stringBuilder.append("] mCreate.mUrl=[");
                        stringBuilder.append(shortVideoTask.a.a);
                        stringBuilder.append("]");
                        XLLog.d("ShortVideoTask", stringBuilder.toString());
                        a = shortVideoTask.a.a;
                        break;
                    default:
                        stringBuilder = new StringBuilder("getPlayUrl status invalid VideoId=[");
                        stringBuilder.append(shortVideoTask.e);
                        stringBuilder.append("] mStatus=[");
                        stringBuilder.append(shortVideoTask.d.toString());
                        stringBuilder.append("] mCreate.mUrl=[");
                        stringBuilder.append(shortVideoTask.a.a);
                        stringBuilder.append("]");
                        XLLog.d("ShortVideoTask", stringBuilder.toString());
                        a = shortVideoTask.a.a;
                        break;
                }
                this.n = a;
                a = e;
                stringBuilder = new StringBuilder("notifyPlayTask VideoId=[");
                stringBuilder.append(shortVideoTask.e);
                stringBuilder.append("] title=[");
                stringBuilder.append(shortVideoTask.a.c);
                stringBuilder.append("] status=[");
                stringBuilder.append(shortVideoTask.d);
                stringBuilder.append("] url=[");
                stringBuilder.append(this.n);
                stringBuilder.append("]");
                XLLog.d(a, stringBuilder.toString());
                this.o.a(this.n, shortVideoTask.d, shortVideoTask.k);
                a(PlayerEvent.CREATE_FINISH, System.currentTimeMillis());
            }
            this.o = null;
        }
    }

    public void a(PlayerEvent playerEvent, long j) {
        PlayerEvent playerEvent2 = playerEvent;
        long j2 = j;
        ShortVideoTask shortVideoTask = (ShortVideoTask) this.j.get(Integer.valueOf(0));
        if (shortVideoTask != null) {
            if (shortVideoTask.a.e == -1) {
                if (PlayerEvent.CREATE_START == playerEvent2) {
                    r1.s = j2;
                    r1.r = j2;
                } else if (r1.p.a(playerEvent.toString()) != null) {
                    XLLog.d(e, String.format("notifyPlayerEvent has record VideoId=[%d] event=[%16s] curTimeMs=[%d] old=[%d]", new Object[]{Long.valueOf(shortVideoTask.e), playerEvent2, Long.valueOf(j2 - r1.r), Long.valueOf(((Long) r1.p.a(playerEvent.toString())).longValue())}));
                    return;
                }
                r13 = new Object[6];
                r13[2] = Long.valueOf(j2 - r1.r);
                r13[3] = Long.valueOf(j2 - r1.s);
                r13[4] = shortVideoTask.d;
                r13[5] = shortVideoTask.a.c;
                XLLog.d(e, String.format("notifyPlayerEvent VideoId=[%d] event=[%16s] PastMs=[%5d] UsedMs=[%5d] Status=[%14s] title=[%.10s]", r13));
                StringBuilder stringBuilder;
                switch (playerEvent) {
                    case CREATE_START:
                        a aVar = r1.p;
                        if (aVar.b.size() != 0) {
                            ContentValues contentValues = aVar.b;
                            aVar.b = new ContentValues();
                            aVar.a.post(new c(aVar, contentValues));
                        }
                        r1.p.b("OSVersion", XLUtil.getOSVersion(r1.h));
                        r1.p.a("VideoId", Long.valueOf(shortVideoTask.e));
                        r1.p.b("Url", shortVideoTask.a.a);
                        r1.p.a("Gcid", shortVideoTask.a.b);
                        r1.p.b("Title", shortVideoTask.a.c);
                        r1.p.a("VideoDuration", Long.valueOf((long) shortVideoTask.a.d));
                        r1.p.a("CreateTime", r1.r);
                        r1.p.a("FileSize", Long.valueOf(shortVideoTask.h));
                        r1.p.a("DownloadSize", Long.valueOf(shortVideoTask.i));
                        r1.p.a("NetWorkCarrier", XLUtil.getNetWorkCarrier(r1.h).toString());
                        r1.p.a("NetWorkType", b(r1.h));
                        r1.p.a("MAC", XLUtil.getMAC(r1.h));
                        r1.p.a("BSSID", XLUtil.getBSSID(r1.h));
                        r1.p.a("CreateTaskCount", Long.valueOf((long) r1.j.size()));
                        r1.p.a("MaxCacheSize", Long.valueOf(r1.l));
                        r1.p.a(Impl.COLUMN_XL_ORIGIN, r1.q);
                        if (r1.j.size() > 1) {
                            r1.p.a("CacheDuration", Long.valueOf((long) ((ShortVideoTask) r1.j.get(Integer.valueOf(1))).a.e));
                            break;
                        }
                        break;
                    case CREATE_FINISH:
                        r1.p.a("STATUS", shortVideoTask.d.toString());
                        r1.p.a("ERROR_CODE", Long.valueOf((long) shortVideoTask.k));
                        String str = e;
                        stringBuilder = new StringBuilder("ERROR_CODE=");
                        stringBuilder.append(shortVideoTask.k);
                        XLLog.d(str, stringBuilder.toString());
                        break;
                    case PLAYER_READY:
                        XLSessionInfo xLSessionInfo = new XLSessionInfo();
                        if (shortVideoTask.a(r1.n, xLSessionInfo)) {
                            r1.p.a("SessionByte", Long.valueOf(xLSessionInfo.mSendByte));
                            r1.p.a("SessionStart", Long.valueOf(xLSessionInfo.mStartTime - r1.r));
                            String str2 = e;
                            StringBuilder stringBuilder2 = new StringBuilder("notifyPlayerEvent SessionByte:[");
                            stringBuilder2.append(xLSessionInfo.mSendByte);
                            stringBuilder2.append("] SessionStart:[");
                            stringBuilder2.append(xLSessionInfo.mStartTime - r1.r);
                            stringBuilder2.append("]");
                            XLLog.d(str2, stringBuilder2.toString());
                        }
                        if (-1 != shortVideoTask.c) {
                            stringBuilder = new StringBuilder("playBegin VideoId=[");
                            stringBuilder.append(shortVideoTask.e);
                            stringBuilder.append("] status=[");
                            stringBuilder.append(shortVideoTask.d);
                            stringBuilder.append("]");
                            XLLog.d("ShortVideoTask", stringBuilder.toString());
                            try {
                                shortVideoTask.j.playShortVideoBegin(shortVideoTask.c);
                                break;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                break;
                            }
                        }
                        break;
                    case PLAYER_BUFFERING:
                        if (shortVideoTask.h == 0) {
                            run();
                        }
                        r1.p.a("FileSize", Long.valueOf(shortVideoTask.h));
                        break;
                    default:
                        break;
                }
                if (j2 < r1.r) {
                    a aVar2 = r1.p;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(playerEvent.toString());
                    stringBuilder3.append(l.l);
                    aVar2.a(stringBuilder3.toString(), j2);
                }
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis > 500) {
                    r1.p.a(PlayerEvent.HANDLER_PENDING.toString(), Long.valueOf(currentTimeMillis));
                }
                r1.p.a(playerEvent.toString(), Long.valueOf(j2 - r1.r));
                r1.s = j2;
            }
        }
    }

    private void b(Context context, String str) {
        try {
            PackageInfo packageInfo;
            if (TextUtils.isEmpty(str)) {
                str = XLDownloadManager.getInstance(context);
            } else {
                Method declaredMethod = XLDownloadManager.class.getDeclaredMethod("getInstance", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                str = (XLDownloadManager) declaredMethod.invoke(XLDownloadManager.class, new Object[]{str});
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                packageInfo = null;
            }
            InitParam initParam = new InitParam();
            String str2 = (packageInfo == null || packageInfo.versionName == null) ? "1.0" : packageInfo.versionName;
            initParam.mAppVersion = str2;
            initParam.mStatSavePath = context.getFilesDir().getPath();
            initParam.mStatCfgSavePath = context.getFilesDir().getPath();
            initParam.mPermissionLevel = 2;
            try {
                context = str.init(context, initParam);
                if (context == 9000 || (context == 9900 && str.getManagerStatus() == XLManagerStatus.MANAGER_RUNNING)) {
                    context = str.setOSVersion(VERSION.INCREMENTAL);
                    if (context != 9000) {
                        str = e;
                        StringBuilder stringBuilder = new StringBuilder("setOSVersion() ret = ");
                        stringBuilder.append(context);
                        XLLog.d(str, stringBuilder.toString());
                        return;
                    }
                    this.a = true;
                    return;
                }
                str2 = e;
                StringBuilder stringBuilder2 = new StringBuilder("initXLEngine() ret = ");
                stringBuilder2.append(context);
                stringBuilder2.append(", status=");
                stringBuilder2.append(str.getManagerStatus());
                XLLog.e(str2, stringBuilder2.toString());
            } catch (Context context2) {
                context2.printStackTrace();
            }
        } catch (Context context22) {
            context22.printStackTrace();
        }
    }

    private void a(Context context) {
        this.a = false;
        try {
            context = XLDownloadManager.getInstance(context);
            if (context != null) {
                context.uninit();
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        XLLog.d(e, "uninitXLEngine()");
    }

    private static String a(Context context, String str, String str2) {
        Object obj = null;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context != null && context.containsKey(str)) {
                obj = context.get(str);
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return obj != null ? obj.toString() : str2;
    }

    void b() {
        this.g.post(this);
    }

    public void run() {
        this.g.removeCallbacks(this);
        this.g.postDelayed(this, 500);
        c();
    }

    private static String b(Context context) {
        context = XLUtil.getNetworkTypeComplete(context);
        if (context == null) {
            return "NO-CONNECTION";
        }
        if (context == 9) {
            return "WIFI";
        }
        switch (context) {
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            default:
                return "UnKown";
        }
    }

    public static Object a(Context context, String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(".BuildConfig");
            return Class.forName(stringBuilder.toString()).getField(str).get(null);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        } catch (Context context22) {
            context22.printStackTrace();
            return null;
        } catch (Context context222) {
            context222.printStackTrace();
            return null;
        }
    }
}
