package com.xunlei.downloadprovider.download.tasklist.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.ad.recommend.view.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.LOAD_TAG;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.a.g;
import com.xunlei.downloadprovider.download.tasklist.list.download.TaskDownloadCardViewHolder;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.h;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.l;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.o;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.p;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.q;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.t;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.v;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: TaskListAdapter */
public class a extends Adapter<f> {
    private static final String n = "a";
    public e a = new e();
    protected final int b;
    protected Context c;
    public boolean d = false;
    public long e = 0;
    public b f;
    public TaskListPageFragment g;
    public e h;
    public e i;
    public e j;
    public int k;
    public com.xunlei.downloadprovider.download.control.a l;
    public RecyclerView m;
    private e o;
    private com.xunlei.downloadprovider.download.tasklist.list.feed.d.a p = null;
    private int q;

    /* compiled from: TaskListAdapter */
    private static class a {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.ArrayList<com.xunlei.downloadprovider.download.tasklist.list.a.e> a(java.util.List<com.xunlei.downloadprovider.download.tasklist.list.a.e> r14, java.util.List<com.xunlei.downloadprovider.download.tasklist.list.a.e> r15) {
            /*
            r0 = android.os.SystemClock.elapsedRealtime();
            r2 = new java.util.ArrayList;
            r2.<init>(r14);
            r14 = new java.util.ArrayList;
            r14.<init>(r15);
            r15 = new java.util.HashSet;
            r3 = 10;
            r15.<init>(r3);
            r3 = new java.util.HashSet;
            r3.<init>(r14);
            r4 = a(r3);
            r14.removeAll(r2);
            r5 = r14.isEmpty();
            if (r5 != 0) goto L_0x0080;
        L_0x0027:
            r5 = r14.iterator();
        L_0x002b:
            r6 = r5.hasNext();
            if (r6 == 0) goto L_0x0080;
        L_0x0031:
            r6 = r5.next();
            r6 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r6;
            r7 = r2.contains(r6);
            if (r7 != 0) goto L_0x002b;
        L_0x003d:
            r7 = r6.b();
            r8 = -1;
            r9 = 0;
            r10 = r9;
            r11 = r10;
        L_0x0045:
            r12 = r2.size();
            r13 = 1;
            if (r10 >= r12) goto L_0x006c;
        L_0x004c:
            r12 = r2.get(r10);
            r12 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r12;
            r12 = r12.a;
            if (r12 != 0) goto L_0x0069;
        L_0x0056:
            r11 = r2.get(r10);
            r11 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r11;
            r11 = r11.b();
            r11 = com.xunlei.downloadprovider.download.tasklist.task.b.a(r7, r11);
            if (r11 > 0) goto L_0x0068;
        L_0x0066:
            r8 = r10;
            goto L_0x006d;
        L_0x0068:
            r11 = r13;
        L_0x0069:
            r10 = r10 + 1;
            goto L_0x0045;
        L_0x006c:
            r13 = r11;
        L_0x006d:
            if (r8 < 0) goto L_0x0073;
        L_0x006f:
            r2.add(r8, r6);
            goto L_0x007c;
        L_0x0073:
            if (r13 == 0) goto L_0x0079;
        L_0x0075:
            r2.add(r6);
            goto L_0x007c;
        L_0x0079:
            r2.add(r9, r6);
        L_0x007c:
            com.xunlei.downloadprovider.download.tasklist.list.a.n;
            goto L_0x002b;
        L_0x0080:
            r5 = r2.isEmpty();
            if (r5 != 0) goto L_0x00c4;
        L_0x0086:
            r5 = r2.iterator();
        L_0x008a:
            r6 = r5.hasNext();
            if (r6 == 0) goto L_0x00c4;
        L_0x0090:
            r6 = r5.next();
            r6 = (com.xunlei.downloadprovider.download.tasklist.list.a.e) r6;
            r7 = r6.a;
            if (r7 != 0) goto L_0x008a;
        L_0x009a:
            r7 = r6.b();
            if (r7 == 0) goto L_0x00c0;
        L_0x00a0:
            r7 = r6.b();
            r7 = r7.getTaskId();
            r7 = java.lang.Long.valueOf(r7);
            r7 = r4.contains(r7);
            if (r7 != 0) goto L_0x00b6;
        L_0x00b2:
            r15.add(r6);
            goto L_0x008a;
        L_0x00b6:
            r7 = r3.contains(r6);
            if (r7 != 0) goto L_0x008a;
        L_0x00bc:
            r15.add(r6);
            goto L_0x008a;
        L_0x00c0:
            r15.add(r6);
            goto L_0x008a;
        L_0x00c4:
            r3 = r15.isEmpty();
            if (r3 != 0) goto L_0x00cd;
        L_0x00ca:
            r2.removeAll(r15);
        L_0x00cd:
            r3 = android.os.SystemClock.elapsedRealtime();
            r5 = r3 - r0;
            com.xunlei.downloadprovider.download.tasklist.list.a.n;
            r0 = new java.lang.StringBuilder;
            r1 = "Merge List Cost: ";
            r0.<init>(r1);
            r0.append(r5);
            r1 = "ms - ";
            r0.append(r1);
            r14 = r14.size();
            r0.append(r14);
            r14 = " added ";
            r0.append(r14);
            r14 = r15.size();
            r0.append(r14);
            r14 = " removed";
            r0.append(r14);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.a.a.a(java.util.List, java.util.List):java.util.ArrayList<com.xunlei.downloadprovider.download.tasklist.list.a.e>");
        }

        private static HashSet<Long> a(Collection<e> collection) {
            HashSet<Long> hashSet = new HashSet();
            for (e eVar : collection) {
                if (eVar.b() != null) {
                    hashSet.add(Long.valueOf(eVar.b().getTaskId()));
                }
            }
            return hashSet;
        }
    }

    /* compiled from: TaskListAdapter */
    public interface b {
        void a();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        f fVar = (f) viewHolder;
        StringBuilder stringBuilder = new StringBuilder("onBindViewHolder.position: ");
        stringBuilder.append(i);
        stringBuilder.append(" mpageIndex: ");
        stringBuilder.append(this.b);
        if (fVar.getDownloadCenterControl() == null) {
            fVar.setDownloadCenterControl(this.l);
        }
        if (fVar instanceof g) {
            ((g) fVar).a = this.k;
        }
        e a = this.a.a(i);
        fVar.setEditMode(this.a.c);
        TaskListPageFragment taskListPageFragment = this.g;
        boolean z = taskListPageFragment.isResumed() && taskListPageFragment.getUserVisibleHint();
        fVar.setVisibleToUser(z);
        fVar.fillData(a);
        if (l() == null && getItemViewType(i) == 305) {
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a((m) a.c, b(a), this.b);
        }
    }

    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        f fVar = (f) viewHolder;
        super.onViewAttachedToWindow(fVar);
        if (fVar != null) {
            fVar.onViewAttachedToWindow();
        }
    }

    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        f fVar = (f) viewHolder;
        super.onViewDetachedFromWindow(fVar);
        if (fVar != null) {
            fVar.onViewDetachedFromWindow();
        }
    }

    public /* bridge */ /* synthetic */ void onViewRecycled(ViewHolder viewHolder) {
        f fVar = (f) viewHolder;
        super.onViewRecycled(fVar);
        if (fVar != null) {
            fVar.onViewRecycled();
        }
    }

    public a(Context context, int i, TaskListPageFragment taskListPageFragment) {
        this.c = context;
        this.b = i;
        this.g = taskListPageFragment;
        this.p = new com.xunlei.downloadprovider.download.tasklist.list.feed.d.a(this.c, this, this.b);
    }

    public final int a() {
        return this.b;
    }

    public int getItemViewType(int i) {
        i = this.a.a(i);
        return i == 0 ? -1 : i.a;
    }

    public long getItemId(int i) {
        i = this.a.a(i);
        if (i == 0) {
            return -1;
        }
        long j = i.b;
        if (j != -1) {
            if (j <= 2147483647L) {
                return (((long) i.a) << 32) | (j & 2147483647L);
            }
        }
        return -1;
    }

    public int getItemCount() {
        return this.a.a();
    }

    public final void a(e eVar) {
        e eVar2 = this.a;
        eVar2.a.remove(eVar);
        eVar2.b.remove(eVar);
        notifyDataSetChanged();
    }

    public final int b(e eVar) {
        Object obj = this.a.b;
        return !d.a(obj) ? obj.indexOf(eVar) : null;
    }

    public final boolean b() {
        e eVar = this.a;
        if (eVar.a != null) {
            if (eVar.a.size() != 0) {
                Iterator it = eVar.a.iterator();
                while (it.hasNext()) {
                    if (((e) it.next()).a == 0) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final void c() {
        LOAD_TAG load_tag = LOAD_TAG.LOAD_LIST_AD;
        int[] iArr = new int[]{100, 101};
        String str = com.xunlei.downloadprovider.ad.downloadlist.d.a;
        new StringBuilder("removeAD page: ").append(this.b);
        this.g.f.remove(load_tag);
        Collection arrayList = new ArrayList();
        if (this.a.a != null) {
            Iterator it = this.a.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                for (int i = 0; i < 2; i++) {
                    if (eVar.a == iArr[i]) {
                        arrayList.add(eVar);
                        break;
                    }
                }
            }
            if (arrayList.size() != 0) {
                this.a.a.removeAll(arrayList);
                notifyDataSetChanged();
            }
        }
    }

    public final void d() {
        this.g.f.remove(LOAD_TAG.LOAD_RECOMMEND_AD);
        if (this.o != null && this.a.a.contains(this.o)) {
            a(this.o);
            this.o = null;
        }
    }

    public final void e() {
        String str = com.xunlei.downloadprovider.ad.downloadlist.d.a;
        new StringBuilder("removeListADs page: ").append(this.b);
        this.g.f.remove(LOAD_TAG.LOAD_LIST_AD);
        View view = this.g.getView();
        if (view != null) {
            view.post(new b(this));
        }
    }

    private void a(int i, List<e> list) {
        if (!list.isEmpty()) {
            Collection arrayList = new ArrayList();
            for (e eVar : list) {
                if (!this.a.a.contains(eVar)) {
                    arrayList.add(eVar);
                }
            }
            if (arrayList.isEmpty() == null) {
                this.a.a.addAll(i, arrayList);
            }
            g();
            notifyDataSetChanged();
        }
    }

    public final int a(long j) {
        for (int i = 0; i < this.a.a.size(); i++) {
            e eVar = (e) this.a.a.get(i);
            if (eVar.b() != null && eVar.b().getTaskId() == j) {
                return i;
            }
        }
        return -1;
    }

    public final void a(boolean z) {
        int i;
        e eVar = this.a;
        if (eVar.c != z) {
            eVar.c = z;
            i = 1;
        } else {
            i = false;
        }
        int i2;
        if (z) {
            boolean z2;
            if (eVar.a.size() == 0) {
                z2 = false;
            } else {
                if (eVar.d.size() > 0) {
                    eVar.d.clear();
                }
                eVar.d.addAll(eVar.a);
                i2 = 0;
                z2 = i2;
                while (i2 < eVar.a.size()) {
                    if (((e) eVar.a.get(i2)).a != 0) {
                        eVar.a.remove(i2);
                        i2--;
                        z2 = true;
                    }
                    i2++;
                }
            }
            if (z2) {
                i = 1;
            }
            if (!d.a(eVar.a)) {
                eVar.a.remove(eVar.e);
                eVar.a.add(eVar.e);
            }
            if (!z) {
                z = eVar.a.iterator();
                while (z.hasNext()) {
                    ((e) z.next()).a(false);
                }
                i = 1;
            }
            if (i == 0) {
                notifyDataSetChanged();
            }
        }
        boolean z3;
        if (eVar.d.size() == 0) {
            z3 = false;
        } else {
            i2 = 0;
            while (i2 < eVar.d.size()) {
                e eVar2 = (e) eVar.d.get(i2);
                if (eVar2.a == 0 && !eVar.a.contains(eVar2)) {
                    eVar.d.remove(eVar2);
                    i2--;
                }
                i2++;
            }
            eVar.a.clear();
            eVar.a.addAll(eVar.d);
            eVar.d.clear();
            z3 = true;
        }
        if (z3) {
            i = 1;
        }
        if (eVar.a.remove(eVar.e)) {
        }
        if (z) {
            z = eVar.a.iterator();
            while (z.hasNext()) {
                ((e) z.next()).a(false);
            }
            i = 1;
        }
        if (i == 0) {
            notifyDataSetChanged();
        }
        i = 1;
        if (z) {
            z = eVar.a.iterator();
            while (z.hasNext()) {
                ((e) z.next()).a(false);
            }
            i = 1;
        }
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    public final List<e> f() {
        e eVar = this.a;
        List arrayList = new ArrayList();
        Iterator it = eVar.a.iterator();
        while (it.hasNext()) {
            e eVar2 = (e) it.next();
            if (eVar2.a == 0 && eVar2.a()) {
                arrayList.add(eVar2);
            }
        }
        return arrayList;
    }

    public final void a(List<e> list) {
        if (list != null && !list.isEmpty()) {
            new StringBuilder("insertDownloadItems: ").append(list.size());
            for (e eVar : list) {
                TaskInfo b = eVar.b();
                if (!(this.a.a.contains(eVar) || b == null)) {
                    int i = -1;
                    int i2 = 0;
                    int i3 = i2;
                    while (i2 < this.a.a.size()) {
                        if (((e) this.a.a.get(i2)).a == 0) {
                            if (com.xunlei.downloadprovider.download.tasklist.task.b.a(b, ((e) this.a.a.get(i2)).b()) <= 0) {
                                i = i2;
                                i3 = 1;
                                break;
                            }
                            i3 = 1;
                        }
                        i2++;
                    }
                    if (i >= 0) {
                        this.a.a.add(i, eVar);
                    } else if (i3 != 0) {
                        this.a.a.add(eVar);
                    } else {
                        this.a.a.add(0, eVar);
                    }
                }
            }
            g();
            notifyDataSetChanged();
        }
    }

    public final void h() {
        if (!this.d) {
            this.d = true;
            new StringBuilder("onDownloadTaskLoaded - PageIndex = ").append(this.b);
            i();
            j();
            if (this.f != null) {
                this.f.a();
            }
        }
    }

    public final void i() {
        if (b()) {
            String str = com.xunlei.downloadprovider.ad.downloadlist.d.a;
            new StringBuilder("insertListAD ").append(this.b);
            if (com.xunlei.downloadprovider.ad.downloadlist.a.b(this.b) && !com.xunlei.downloadprovider.ad.downloadlist.a.a[this.b]) {
                com.xunlei.downloadprovider.d.e.a aVar;
                this.g.f.add(LOAD_TAG.LOAD_LIST_AD);
                ArrayList arrayList = new ArrayList();
                int i = 6;
                if (com.xunlei.downloadprovider.d.e.a().e != null) {
                    aVar = com.xunlei.downloadprovider.d.e.a().e;
                    if (aVar.a != null) {
                        i = aVar.a.optInt("downloadlist_ad_task_threshold", 6);
                    }
                }
                int i2 = 4;
                if (com.xunlei.downloadprovider.d.e.a().e != null) {
                    aVar = com.xunlei.downloadprovider.d.e.a().e;
                    if (aVar.a != null) {
                        i2 = aVar.a.optInt("ad_downloadlist_position", 4);
                    }
                }
                int i3 = 0;
                int size = this.a.a != null ? this.a.a.size() : 0;
                for (int i4 = 0; i4 < size; i4++) {
                    int i5 = (i2 - 1) + (i4 * i);
                    int i6 = size - 1;
                    if (i5 <= i6) {
                        arrayList.add(Integer.valueOf(i5));
                    } else if (arrayList.size() != 0) {
                        if (size - (arrayList.size() * i) > 0) {
                            arrayList.add(Integer.valueOf(i6));
                            break;
                        }
                    } else if (arrayList.size() == 0) {
                        if (size != 0) {
                            arrayList.add(Integer.valueOf(i6));
                        } else {
                            arrayList.add(Integer.valueOf(0));
                        }
                    }
                }
                if (size == 1) {
                    arrayList.clear();
                    arrayList.add(Integer.valueOf(1));
                }
                aVar = com.xunlei.downloadprovider.d.e.a().e;
                i2 = 2;
                if (aVar.a != null) {
                    i2 = aVar.a.optInt("downloadlist_ad_maximum", 2);
                }
                if (arrayList.size() <= i2) {
                    i2 = arrayList.size();
                }
                if (i2 > 1) {
                    com.xunlei.downloadprovider.ad.downloadlist.d.a().c();
                }
                while (i3 < i2) {
                    List arrayList2 = new ArrayList();
                    i = 100;
                    if (this.b == 1) {
                        i = 101;
                    }
                    arrayList2.add(new e(i, Integer.valueOf(i3), (long) i3));
                    a(((Integer) arrayList.get(i3)).intValue() + i3, arrayList2);
                    i3++;
                }
            }
        }
    }

    public final void j() {
        switch (this.b) {
            case 0:
            case 1:
            case 2:
                if (c.h()) {
                    this.g.f.add(LOAD_TAG.LOAD_RECOMMEND_AD);
                    e eVar = new e(150, null, 0);
                    new StringBuilder("addRecommendAdCard: ").append(this.b);
                    if (this.o != null) {
                        this.a.a.remove(this.o);
                    }
                    this.o = eVar;
                    if (this.o != null) {
                        this.a.a.remove(this.o);
                        this.a.a.add(this.o);
                    }
                    notifyDataSetChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final e a(int i) {
        return this.a.a(i);
    }

    public final void a(int i, int i2) {
        if (i >= 0 && i <= this.a.a.size() && i2 >= 0) {
            if (i2 <= this.a.a.size()) {
                e eVar = (e) this.a.a.remove(i);
                notifyItemChanged(i);
                if (eVar != null) {
                    this.a.a.add(i2, eVar);
                    notifyItemMoved(i, i2);
                }
            }
        }
    }

    private boolean l() {
        return this.q == 2;
    }

    public final void b(int i) {
        if (!(!l() || this.q == i || this.m == null)) {
            if (this.m.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.m.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int itemCount = getItemCount();
                while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                    if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < itemCount) {
                        e a = a(findFirstVisibleItemPosition);
                        Object obj = a.c;
                        if (obj instanceof m) {
                            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a((m) obj, b(a), this.b);
                        }
                    }
                    findFirstVisibleItemPosition++;
                }
            }
        }
        this.q = i;
    }

    public final void g() {
        if (!(this.a.c || this.o == null)) {
            this.a.a.remove(this.o);
            this.a.a.add(this.o);
        }
        if (!this.a.c && this.h != null) {
            this.a.a.remove(this.h);
            if (this.g.o && !this.g.p) {
                this.a.a.add(0, this.h);
            }
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return g.a(this.c, viewGroup);
        }
        if (i == 0) {
            viewGroup = TaskDownloadCardViewHolder.createViewHolderAndView(this.c, viewGroup, this.l, this, this.b);
        } else {
            if (i != 100) {
                if (i != 101) {
                    if (i != 150) {
                        if (i != 201) {
                            if (i != 200) {
                                if (i != 500) {
                                    com.xunlei.downloadprovider.download.tasklist.list.feed.d.a aVar = this.p;
                                    switch (i) {
                                        case 300:
                                            viewGroup = o.a(aVar.a, viewGroup, aVar.c, aVar.b);
                                            break;
                                        case 301:
                                            viewGroup = p.a(aVar.a, viewGroup, aVar.c, aVar.b);
                                            break;
                                        case 302:
                                            viewGroup = q.a(aVar.a, viewGroup, aVar.c, aVar.b);
                                            break;
                                        case 303:
                                            viewGroup = l.a(aVar.a, viewGroup, aVar.d);
                                            break;
                                        case 304:
                                            viewGroup = com.xunlei.downloadprovider.ad.a.a.a.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        case 305:
                                        case 306:
                                            viewGroup = t.a(aVar.a, i, viewGroup, aVar.c);
                                            break;
                                        case 307:
                                            viewGroup = com.xunlei.downloadprovider.download.tasklist.list.feed.view.a.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        case 308:
                                            viewGroup = v.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        case 309:
                                            viewGroup = com.xunlei.downloadprovider.download.tasklist.list.feed.view.f.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        case SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA /*310*/:
                                            viewGroup = h.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        case SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA /*311*/:
                                            viewGroup = com.xunlei.downloadprovider.download.tasklist.list.feed.view.g.a(aVar.a, viewGroup, aVar.c);
                                            break;
                                        default:
                                            viewGroup = null;
                                            break;
                                    }
                                }
                                viewGroup = com.xunlei.downloadprovider.download.tasklist.list.download.q.a(this.c);
                            } else {
                                viewGroup = com.xunlei.downloadprovider.download.tasklist.list.b.a.a(this.c, viewGroup, this.l, this);
                            }
                        } else {
                            viewGroup = com.xunlei.downloadprovider.download.tasklist.list.c.a.a(this.c, viewGroup, this.l, this);
                        }
                    } else {
                        ViewGroup viewGroup2 = viewGroup;
                        viewGroup = c.a(this.c, viewGroup2, this.l, this, new com.xunlei.downloadprovider.ad.recommend.b.b(com.xunlei.downloadprovider.ad.recommend.a.h.a()), this.b);
                    }
                }
            }
            viewGroup = com.xunlei.downloadprovider.ad.downloadlist.d.a.a(this.c, viewGroup, this);
        }
        return viewGroup;
    }
}
