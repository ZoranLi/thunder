package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class l implements OnItemClickListener {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    l(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar = (c) this.a.i.get(i);
        view = cVar.mFileIndex;
        i = 0;
        for (j = 0; j < this.a.j.size(); j++) {
            if (((c) this.a.j.get(j)).mFileIndex == view) {
                this.a.j.remove(cVar);
                i = 1;
                break;
            }
        }
        if (i == 0) {
            this.a.j.add(cVar);
        }
        if (this.a.f != null) {
            this.a.f.notifyDataSetChanged();
        }
    }
}
