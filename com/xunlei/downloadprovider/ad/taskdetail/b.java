package com.xunlei.downloadprovider.ad.taskdetail;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import java.util.ArrayList;

/* compiled from: AdSetter */
public final class b {
    private b a;
    private boolean b = false;
    private boolean c;
    private a d;

    public b(boolean z, @Nullable a aVar) {
        this.c = z;
        this.d = aVar;
    }

    public final b a(b bVar) {
        this.a = bVar;
        return this.a;
    }

    public final void a(ArrayList<a> arrayList, ArrayList<a> arrayList2, a aVar) {
        b bVar = this;
        while (true) {
            int size;
            int indexOf;
            boolean z = bVar.b;
            a aVar2 = bVar.d;
            ArrayList arrayList3 = bVar.c ? arrayList : arrayList2;
            Object obj = 1;
            if (aVar2 == null) {
                size = z ? 0 : arrayList3.size();
            } else {
                indexOf = arrayList3.indexOf(aVar2);
                int i = -1;
                if (indexOf != -1) {
                    if (!z) {
                        i = 1;
                    }
                    size = indexOf + i;
                } else {
                    size = -1000;
                }
            }
            if (size != -1000) {
                indexOf = arrayList3.size();
                if (size < 0) {
                    size = 0;
                } else if (size > indexOf) {
                    size = indexOf;
                }
                arrayList3.add(size, aVar);
            } else {
                obj = null;
            }
            if (obj == null && bVar.a != null) {
                bVar = bVar.a;
            } else {
                return;
            }
        }
    }
}
