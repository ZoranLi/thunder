package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.xunlei.downloadprovider.ad.home.ui.u;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessLiveGroupItemView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessLiveGroupSecondItemView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessLivestreamItemView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessRecommendUserView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessTopicItemView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ar;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.at;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.y;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: HomeChoicenessAdapter */
public final class i extends Adapter<a> {
    public List<e> a = new ArrayList();
    public Set<a> b = new HashSet();
    public boolean c = true;
    private XRecyclerView d;
    private Context e;
    private a f;
    private int g = 0;
    private boolean h;
    private long i;
    private y j;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        int itemViewType = getItemViewType(i);
        e b = b(i);
        StringBuilder stringBuilder = new StringBuilder("onBindViewHolder--position=");
        stringBuilder.append(i);
        stringBuilder.append("|");
        stringBuilder.append(b);
        if (aVar.itemView instanceof b) {
            ((b) aVar.itemView).a(i, aVar.a, itemViewType, aVar.itemView, b);
        }
        if (d() == null && this.h != null) {
            viewHolder = null;
            if (System.currentTimeMillis() - this.i <= 1000) {
                viewHolder = true;
            }
            this.j.a(viewHolder, b);
        }
    }

    public i(Context context, XRecyclerView xRecyclerView, a aVar, y yVar) {
        this.e = context;
        this.d = xRecyclerView;
        this.f = aVar;
        this.j = yVar;
    }

    public final int getItemViewType(int i) {
        return b(i).k;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    private e b(int i) {
        return (e) this.a.get(i);
    }

    public final void a(List<e> list) {
        this.a.clear();
        if (!d.a(list)) {
            this.a.addAll(list);
        }
        c();
    }

    public final boolean a() {
        return getItemCount() == 0;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<e> list = this.a;
            if (list != null) {
                for (e eVar : list) {
                    if (eVar != null && eVar.e() && TextUtils.equals(eVar.b(), str)) {
                        m mVar = (m) eVar;
                        mVar.b.setShareCount(mVar.b.getShareCount() + 1);
                        c();
                        return;
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        this.h = true;
        this.c = true;
        if (!z) {
            b(false);
        }
        z = this.b.iterator();
        while (z.hasNext()) {
            z.next();
        }
    }

    public final void b() {
        this.h = false;
        if (this.c) {
            ak.a().c(PlayerTag.HOME);
        }
        this.j.a();
        this.j.b();
        for (a f : this.b) {
            f.f();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r5);
        return;
    L_0x0009:
        r0 = r5.a;	 Catch:{ all -> 0x0032 }
        r1 = -1;
        r2 = 0;
    L_0x000d:
        r3 = r0.size();	 Catch:{ all -> 0x0032 }
        if (r2 >= r3) goto L_0x002b;
    L_0x0013:
        r3 = r0.get(r2);	 Catch:{ all -> 0x0032 }
        r3 = (com.xunlei.downloadprovider.homepage.choiceness.a.a.e) r3;	 Catch:{ all -> 0x0032 }
        r4 = r3.b();	 Catch:{ all -> 0x0032 }
        r4 = r6.equals(r4);	 Catch:{ all -> 0x0032 }
        if (r4 == 0) goto L_0x0028;
    L_0x0023:
        r0.remove(r3);	 Catch:{ all -> 0x0032 }
        r1 = r2;
        goto L_0x002b;
    L_0x0028:
        r2 = r2 + 1;
        goto L_0x000d;
    L_0x002b:
        if (r1 <= 0) goto L_0x0030;
    L_0x002d:
        r5.notifyItemRemoved(r1);	 Catch:{ all -> 0x0032 }
    L_0x0030:
        monitor-exit(r5);
        return;
    L_0x0032:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.ui.i.b(java.lang.String):void");
    }

    public final void a(a aVar) {
        this.b.add(aVar);
    }

    private boolean d() {
        return this.g == 2;
    }

    public final void a(int i) {
        if (d() && this.g != i) {
            b(true);
            e();
        }
        this.g = i;
    }

    public final void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && d() == null) {
            e();
        }
    }

    private void e() {
        if (this.d != null) {
            int childCount = this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.d.getChildAt(i);
                if (childAt instanceof z) {
                    ((z) childAt).a();
                }
            }
        }
    }

    public final void c() {
        this.i = System.currentTimeMillis();
        super.notifyDataSetChanged();
    }

    private void b(boolean z) {
        if (this.d != null) {
            if (this.d.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - this.d.getHeaderViewsCount();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() - this.d.getHeaderViewsCount();
                int itemCount = getItemCount();
                while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                    if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < itemCount) {
                        this.j.a(z, b(findFirstVisibleItemPosition));
                    }
                    findFirstVisibleItemPosition++;
                }
            }
        }
    }

    public final boolean b(e eVar) {
        eVar = c(eVar);
        if (eVar != -1) {
            if (this.d != null) {
                if (this.d.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.d.getLayoutManager();
                    int headerViewsCount = this.d.getHeaderViewsCount();
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - headerViewsCount;
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() - headerViewsCount;
                    if (eVar >= findFirstVisibleItemPosition && eVar <= findLastVisibleItemPosition) {
                        eVar = 1;
                        if (eVar != null) {
                        }
                    }
                }
            }
            eVar = null;
            return eVar != null;
        }
    }

    public final int c(e eVar) {
        return this.a == null ? -1 : this.a.indexOf(eVar);
    }

    public final void a(e eVar) {
        List list = this.a;
        if (list != null) {
            if (!list.isEmpty()) {
                eVar = list.indexOf(eVar);
                if (eVar >= null) {
                    notifyItemChanged(eVar);
                }
            }
        }
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup = u.a(this.e, this.f);
        } else if (i != 20) {
            if (i != 22) {
                if (i == 26) {
                    viewGroup = new ChoicenessTopicItemView(this.e);
                } else if (i == 28) {
                    viewGroup = new ChoicenessRecommendUserView(this.e);
                } else if (i != 36) {
                    if (i != 49) {
                        switch (i) {
                            case 5:
                            case 6:
                            case 9:
                                viewGroup = u.a(this.e);
                                break;
                            case 7:
                            case 8:
                                break;
                            default:
                                switch (i) {
                                    case 16:
                                        viewGroup = u.b(this.e, this.f);
                                        break;
                                    case 17:
                                        viewGroup = new ChoicenessLivestreamItemView(this.e, this.f);
                                        break;
                                    case 18:
                                        break;
                                    default:
                                        switch (i) {
                                            case 43:
                                                viewGroup = new ChoicenessLiveGroupSecondItemView(this.e, true);
                                                break;
                                            case 44:
                                                viewGroup = new ChoicenessLiveGroupSecondItemView(this.e, false);
                                                break;
                                            case 45:
                                                viewGroup = new ChoicenessLiveGroupItemView(this.e);
                                                break;
                                            case 46:
                                                viewGroup = new ar(this.e);
                                                break;
                                            case 47:
                                                break;
                                            default:
                                                viewGroup = null;
                                                break;
                                        }
                                }
                        }
                    }
                    viewGroup = new com.xunlei.downloadprovider.homepage.choiceness.ui.items.a(this.e);
                } else {
                    viewGroup = new at(this.e);
                }
            }
            viewGroup = new com.xunlei.downloadprovider.homepage.choiceness.ui.items.ak(this.e, this, this.f);
        } else {
            viewGroup = new y(this.e, this);
        }
        if (viewGroup != null) {
            viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        }
        return new a(viewGroup, this);
    }
}
