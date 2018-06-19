package com.xunlei.downloadprovider.download.create;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: BaseBtFileExplorerActivity */
final class f implements OnItemClickListener {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    f(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BaseBtFileExplorerActivity$c baseBtFileExplorerActivity$c = (BaseBtFileExplorerActivity$c) BaseBtFileExplorerActivity.d(this.a).get(i);
        view = baseBtFileExplorerActivity$c.mFileIndex;
        i = 0;
        for (j = 0; j < BaseBtFileExplorerActivity.e(this.a).size(); j++) {
            if (((BaseBtFileExplorerActivity$c) BaseBtFileExplorerActivity.e(this.a).get(j)).mFileIndex == view) {
                BaseBtFileExplorerActivity.e(this.a).remove(baseBtFileExplorerActivity$c);
                i = 1;
                break;
            }
        }
        if (i == 0) {
            BaseBtFileExplorerActivity.e(this.a).add(baseBtFileExplorerActivity$c);
        }
        BaseBtFileExplorerActivity.h(this.a);
        if (BaseBtFileExplorerActivity.g(this.a) != null) {
            BaseBtFileExplorerActivity.g(this.a).notifyDataSetChanged();
        }
    }
}
