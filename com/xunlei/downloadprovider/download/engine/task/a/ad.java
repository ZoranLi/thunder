package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UITaskListUpdater */
public class ad extends z {
    private ArrayList<z> a = new ArrayList(1);

    public void a(List<z> list) {
    }

    protected final List<z> b(List<z> list) {
        this.a.clear();
        if (!list.isEmpty()) {
            for (z zVar : list) {
                if (!zVar.d()) {
                    this.a.add(zVar);
                }
            }
        }
        return this.a;
    }
}
