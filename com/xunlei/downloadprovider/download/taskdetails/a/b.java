package com.xunlei.downloadprovider.download.taskdetails.a;

import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DetailsDataSourceBTBase */
public abstract class b extends a {
    public ArrayList<a> l = new ArrayList();
    public ArrayList<BTSubTaskItem> m = new ArrayList();

    public final List<BTSubTaskItem> a() {
        List arrayList = new ArrayList();
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) it.next();
            if (bTSubTaskItem.isSelected()) {
                arrayList.add(bTSubTaskItem);
            }
        }
        return arrayList;
    }

    public final List<BTSubTaskItem> b() {
        List arrayList = new ArrayList();
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) it.next();
            if (!bTSubTaskItem.isSelected()) {
                arrayList.add(bTSubTaskItem);
            }
        }
        return arrayList;
    }

    public final List<BTSubTaskItem> c() {
        List<BTSubTaskItem> arrayList = new ArrayList();
        arrayList.addAll(this.m);
        return arrayList;
    }

    public final boolean d() {
        ArrayList arrayList = new ArrayList(this.m);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((BTSubTaskItem) it.next()).isSelected()) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(boolean z) {
        Object arrayList = new ArrayList(this.m);
        boolean z2 = false;
        if (!d.a(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((BTSubTaskItem) it.next()).setSelected(z);
                z2 = true;
            }
        }
        return z2;
    }
}
