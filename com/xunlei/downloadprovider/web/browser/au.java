package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.c.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: InputAutoCompleteView */
final class au implements Runnable {
    final /* synthetic */ InputAutoCompleteView a;

    au(InputAutoCompleteView inputAutoCompleteView) {
        this.a = inputAutoCompleteView;
    }

    public final void run() {
        List<d> a = b.a();
        try {
            List arrayList = new ArrayList();
            for (d dVar : a) {
                if (!(TextUtils.isEmpty(dVar.b) || TextUtils.isEmpty(dVar.c))) {
                    d dVar2 = new d();
                    dVar2.e = dVar.e;
                    dVar2.c = dVar.c;
                    dVar2.b = dVar.b;
                    dVar2.d = dVar.d;
                    arrayList.add(dVar2);
                }
            }
            this.a.d = (ArrayList) arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            this.a.d = new ArrayList();
        }
    }
}
