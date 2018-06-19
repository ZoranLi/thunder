package com.xunlei.downloadprovider.search.ui.widget;

import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.search.b.i;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.a;
import com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c;
import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SearchHistoryListView */
public final class g implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ SearchHistoryListView b;

    public g(SearchHistoryListView searchHistoryListView, a aVar) {
        this.b = searchHistoryListView;
        this.a = aVar;
    }

    public final void run() {
        SearchHistoryListView searchHistoryListView;
        Runnable hVar;
        List<d> a = b.a();
        Map hashMap = new HashMap();
        List<com.xunlei.downloadprovider.search.a.b> b;
        Object arrayList;
        c cVar;
        StringBuilder stringBuilder;
        try {
            for (d dVar : a) {
                hashMap.put(dVar.b, dVar.c);
            }
            b = i.a().b();
            arrayList = new ArrayList();
            for (com.xunlei.downloadprovider.search.a.b bVar : b) {
                cVar = new c();
                cVar.d = k.a.d(bVar.a) ^ 1;
                if (cVar.d != 0) {
                    cVar.a = bVar.a;
                    cVar.c = bVar.d;
                } else if (bVar.d.equals("")) {
                    cVar.a = SearchHistoryListView.b(bVar.a, hashMap);
                    cVar.b = bVar.a;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bVar.a);
                    stringBuilder.append(" ");
                    stringBuilder.append(bVar.d);
                    cVar.a = stringBuilder.toString();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bVar.a);
                    stringBuilder.append(" ");
                    stringBuilder.append(bVar.d);
                    cVar.b = stringBuilder.toString();
                }
                cVar.e = bVar.c;
                arrayList.add(cVar);
            }
            com.xunlei.downloadprovider.search.b.c.a().a = arrayList;
            searchHistoryListView = this.b;
            hVar = new h(this, arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            b = i.a().b();
            arrayList = new ArrayList();
            for (com.xunlei.downloadprovider.search.a.b bVar2 : b) {
                cVar = new c();
                cVar.d = k.a.d(bVar2.a) ^ 1;
                if (cVar.d != 0) {
                    cVar.a = bVar2.a;
                    cVar.c = bVar2.d;
                } else if (bVar2.d.equals("")) {
                    cVar.a = SearchHistoryListView.b(bVar2.a, hashMap);
                    cVar.b = bVar2.a;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bVar2.a);
                    stringBuilder.append(" ");
                    stringBuilder.append(bVar2.d);
                    cVar.a = stringBuilder.toString();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(bVar2.a);
                    stringBuilder.append(" ");
                    stringBuilder.append(bVar2.d);
                    cVar.b = stringBuilder.toString();
                }
                cVar.e = bVar2.c;
                arrayList.add(cVar);
            }
            com.xunlei.downloadprovider.search.b.c.a().a = arrayList;
            searchHistoryListView = this.b;
            hVar = new h(this, arrayList);
        } catch (Throwable th) {
            List<com.xunlei.downloadprovider.search.a.b> b2 = i.a().b();
            Object arrayList2 = new ArrayList();
            for (com.xunlei.downloadprovider.search.a.b bVar3 : b2) {
                c cVar2 = new c();
                cVar2.d = k.a.d(bVar3.a) ^ 1;
                if (cVar2.d != 0) {
                    cVar2.a = bVar3.a;
                    cVar2.c = bVar3.d;
                } else if (bVar3.d.equals("")) {
                    cVar2.a = SearchHistoryListView.b(bVar3.a, hashMap);
                    cVar2.b = bVar3.a;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(bVar3.a);
                    stringBuilder2.append(" ");
                    stringBuilder2.append(bVar3.d);
                    cVar2.a = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(bVar3.a);
                    stringBuilder2.append(" ");
                    stringBuilder2.append(bVar3.d);
                    cVar2.b = stringBuilder2.toString();
                }
                cVar2.e = bVar3.c;
                arrayList2.add(cVar2);
            }
            com.xunlei.downloadprovider.search.b.c.a().a = arrayList2;
            this.b.post(new h(this, arrayList2));
        }
        searchHistoryListView.post(hVar);
    }
}
