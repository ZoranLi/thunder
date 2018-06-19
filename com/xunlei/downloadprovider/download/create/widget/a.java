package com.xunlei.downloadprovider.download.create.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.download.create.av;

/* compiled from: FileManagerListView */
final class a implements OnItemClickListener {
    final /* synthetic */ FileManagerListView a;

    a(FileManagerListView fileManagerListView) {
        this.a = fileManagerListView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0) {
            if (i < this.a.j.size()) {
                av avVar = (av) this.a.j.get(i);
                String str = avVar.c;
                adapterView = avVar.f;
                j = new StringBuilder("mDir = ");
                j.append(this.a.h);
                j.append(", position = ");
                j.append(i);
                if (adapterView != EFileCategoryType.E_XLDIR_CATEGORY) {
                    if (adapterView != EFileCategoryType.E_XLFILE_UPPER) {
                        FileManagerListView.a(this.a, str);
                        return;
                    }
                }
                this.a.a(str);
            }
        }
    }
}
