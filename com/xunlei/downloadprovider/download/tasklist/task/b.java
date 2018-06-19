package com.xunlei.downloadprovider.download.tasklist.task;

import android.database.Observable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TaskDataSource */
public final class b {
    public final int a;
    protected final ConcurrentHashMap<Long, e> b = new ConcurrentHashMap();
    protected final List<e> c = new ArrayList();
    protected b d = new a(new Handler(Looper.getMainLooper()));
    public boolean e = false;
    boolean f;
    private long g = 0;
    private boolean h = true;

    /* compiled from: TaskDataSource */
    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b();
            }
        }

        public void a(List<e> list) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a((List) list);
            }
        }

        public void a(Collection<e> collection) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a((Collection) collection);
            }
        }
    }

    /* compiled from: TaskDataSource */
    public static abstract class c {
        public void a() {
        }

        public void a(Collection<e> collection) {
        }

        public void a(List<e> list) {
        }

        public void b() {
        }
    }

    /* compiled from: TaskDataSource */
    private static class a extends b {
        protected Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        public final void a() {
            if (this.a == null) {
                super.a();
            } else {
                this.a.post(new d(this));
            }
        }

        public final void b() {
            if (this.a == null) {
                super.b();
            } else {
                this.a.post(new e(this));
            }
        }

        public final void a(List<e> list) {
            if (this.a == null) {
                super.a((List) list);
            } else {
                this.a.post(new f(this, list));
            }
        }

        public final void a(Collection<e> collection) {
            if (this.a == null) {
                super.a((Collection) collection);
            } else {
                this.a.post(new g(this, collection));
            }
        }
    }

    public b(int i) {
        this.a = i;
    }

    public final synchronized long a() {
        return this.g;
    }

    private synchronized void e() {
        this.g++;
    }

    public final int b() {
        return this.b.size();
    }

    private void f() {
        if (this.b.isEmpty()) {
            synchronized (this.c) {
                this.c.clear();
                e();
                this.h = false;
            }
            return;
        }
        List arrayList = new ArrayList(this.b.values());
        a(arrayList);
        synchronized (this.c) {
            this.c.clear();
            this.c.addAll(arrayList);
            e();
            this.h = false;
        }
    }

    public static void a(List<e> list) {
        if (list.size() > 1) {
            Collections.sort(list, new c());
        }
    }

    public static int a(@NonNull TaskInfo taskInfo, @NonNull TaskInfo taskInfo2) {
        if (taskInfo == taskInfo2) {
            return 0;
        }
        if ((taskInfo.getCustomFlags() != 300 || taskInfo2.getCustomFlags() != 300) && (taskInfo.getCustomFlags() == 300 || taskInfo2.getCustomFlags() == 300)) {
            return taskInfo.getCustomFlags() == 300 ? -1 : 1;
        } else {
            long j = taskInfo.mCreateTime;
            taskInfo = taskInfo2.mCreateTime;
            if (j == taskInfo) {
                return 0;
            }
            return j > taskInfo ? -1 : 1;
        }
    }

    public final void d() {
        if (this.a != 0) {
            Collection<e> arrayList = new ArrayList();
            Collection<e> values = this.b.values();
            HashSet hashSet = new HashSet();
            if (!values.isEmpty()) {
                for (e eVar : values) {
                    if (eVar.a == 0) {
                        DownloadTaskInfo b = eVar.b();
                        if (b != null) {
                            if (this.a == 1) {
                                if (b.getTaskStatus() == 8) {
                                    arrayList.add(eVar);
                                }
                            } else if (this.a == 2 && b.getTaskStatus() != 8) {
                                arrayList.add(eVar);
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    for (e eVar2 : arrayList) {
                        if (eVar2.b() != null) {
                            this.b.remove(Long.valueOf(eVar2.b().getTaskId()));
                        }
                    }
                    e();
                    this.h = true;
                    this.d.a((Collection) arrayList);
                    if (this.f) {
                        this.d.b();
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.List<com.xunlei.downloadprovider.download.tasklist.task.s> r12, boolean r13) {
        /*
        r11 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = 0;
        r3 = 1;
        if (r12 == 0) goto L_0x007f;
    L_0x000e:
        r4 = r12.isEmpty();
        if (r4 != 0) goto L_0x007f;
    L_0x0014:
        r12 = r12.iterator();
        r4 = r2;
    L_0x0019:
        r5 = r12.hasNext();
        if (r5 == 0) goto L_0x007d;
    L_0x001f:
        r4 = r12.next();
        r4 = (com.xunlei.downloadprovider.download.tasklist.task.s) r4;
        r5 = r4.a();
        r7 = r11.b;
        r8 = java.lang.Long.valueOf(r5);
        r7 = r7.get(r8);
        r7 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r7;
        if (r7 != 0) goto L_0x004b;
    L_0x0037:
        r7 = new com.xunlei.downloadprovider.download.tasklist.list.a.e;
        r7.<init>(r2, r4, r5);
        r0.add(r7);
        r8 = r11.b;
        r9 = java.lang.Long.valueOf(r5);
        r8.put(r9, r7);
        r11.h = r3;
        goto L_0x004d;
    L_0x004b:
        r7.c = r4;
    L_0x004d:
        r8 = r11.a;
        r9 = 8;
        if (r8 != r3) goto L_0x005b;
    L_0x0053:
        r4 = r4.b();
        if (r4 != r9) goto L_0x0067;
    L_0x0059:
        r4 = r3;
        goto L_0x0068;
    L_0x005b:
        r8 = r11.a;
        r10 = 2;
        if (r8 != r10) goto L_0x0067;
    L_0x0060:
        r4 = r4.b();
        if (r4 == r9) goto L_0x0067;
    L_0x0066:
        goto L_0x0059;
    L_0x0067:
        r4 = r2;
    L_0x0068:
        if (r4 == 0) goto L_0x007b;
    L_0x006a:
        r4 = r11.b;
        r5 = java.lang.Long.valueOf(r5);
        r4.remove(r5);
        r11.h = r3;
        r0.remove(r7);
        r1.add(r7);
    L_0x007b:
        r4 = r3;
        goto L_0x0019;
    L_0x007d:
        r2 = r4;
        goto L_0x00b8;
    L_0x007f:
        if (r12 == 0) goto L_0x00b8;
    L_0x0081:
        r12 = r12.isEmpty();
        if (r12 == 0) goto L_0x00b8;
    L_0x0087:
        r12 = r11.b;
        monitor-enter(r12);
        r4 = r11.b;	 Catch:{ all -> 0x00b5 }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x00b5 }
        if (r4 != 0) goto L_0x00b3;
    L_0x0092:
        r4 = r11.b;	 Catch:{ all -> 0x00b5 }
        r4 = r4.values();	 Catch:{ all -> 0x00b5 }
        r4 = r4.iterator();	 Catch:{ all -> 0x00b5 }
    L_0x009c:
        r5 = r4.hasNext();	 Catch:{ all -> 0x00b5 }
        if (r5 == 0) goto L_0x00ac;
    L_0x00a2:
        r5 = r4.next();	 Catch:{ all -> 0x00b5 }
        r5 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r5;	 Catch:{ all -> 0x00b5 }
        r1.add(r5);	 Catch:{ all -> 0x00b5 }
        goto L_0x009c;
    L_0x00ac:
        r4 = r11.b;	 Catch:{ all -> 0x00b5 }
        r4.clear();	 Catch:{ all -> 0x00b5 }
        r11.h = r3;	 Catch:{ all -> 0x00b5 }
    L_0x00b3:
        monitor-exit(r12);	 Catch:{ all -> 0x00b5 }
        goto L_0x00b8;
    L_0x00b5:
        r13 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x00b5 }
        throw r13;
    L_0x00b8:
        if (r13 == 0) goto L_0x00c5;
    L_0x00ba:
        r12 = r11.b;
        r12 = r12.isEmpty();
        if (r12 != 0) goto L_0x00c5;
    L_0x00c2:
        r11.d();
    L_0x00c5:
        r12 = r11.h;
        if (r12 == 0) goto L_0x00cc;
    L_0x00c9:
        r11.f();
    L_0x00cc:
        r12 = r1.isEmpty();
        if (r12 != 0) goto L_0x00db;
    L_0x00d2:
        r11.e();
        r12 = r11.d;
        r12.a(r1);
        r2 = r3;
    L_0x00db:
        r12 = r0.isEmpty();
        if (r12 != 0) goto L_0x00ed;
    L_0x00e1:
        r11.e();
        a(r0);
        r12 = r11.d;
        r12.a(r0);
        r2 = r3;
    L_0x00ed:
        if (r2 == 0) goto L_0x00f8;
    L_0x00ef:
        r12 = r11.f;
        if (r12 == 0) goto L_0x00f8;
    L_0x00f3:
        r12 = r11.d;
        r12.b();
    L_0x00f8:
        r12 = r11.e;
        if (r12 != 0) goto L_0x0103;
    L_0x00fc:
        r11.e = r3;
        r12 = r11.d;
        r12.a();
    L_0x0103:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.task.b.a(java.util.List, boolean):boolean");
    }

    public final List<e> b(List<TaskInfo> list) {
        List<e> emptyList = Collections.emptyList();
        if (!(list == null || list.isEmpty())) {
            if (this.b != null) {
                Collection arrayList = new ArrayList();
                for (TaskInfo taskId : list) {
                    e eVar = (e) this.b.remove(Long.valueOf(taskId.getTaskId()));
                    this.h = true;
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                if (arrayList.isEmpty() == null) {
                    e();
                    this.d.a(arrayList);
                    if (this.f != null) {
                        this.d.b();
                    }
                    emptyList = arrayList;
                }
                return emptyList;
            }
        }
        return Collections.emptyList();
    }

    public final List<e> a(Collection<Long> collection) {
        List<e> emptyList = Collections.emptyList();
        if (!(collection == null || collection.isEmpty())) {
            if (this.b != null) {
                Collection arrayList = new ArrayList();
                for (Long remove : collection) {
                    e eVar = (e) this.b.remove(remove);
                    this.h = true;
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                if (arrayList.isEmpty() == null) {
                    e();
                    this.d.a(arrayList);
                    if (this.f != null) {
                        this.d.b();
                    }
                    emptyList = arrayList;
                }
                return emptyList;
            }
        }
        return Collections.emptyList();
    }

    public final void a(c cVar) {
        this.d.registerObserver(cVar);
    }

    public final void b(c cVar) {
        this.d.unregisterObserver(cVar);
    }

    public final List<e> c() {
        if (this.h) {
            f();
        }
        return new ArrayList(this.c);
    }
}
