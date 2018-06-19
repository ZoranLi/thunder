package com.xunlei.downloadprovider.download.create;

import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseBtFileExplorerActivity */
final class b implements Runnable {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    b(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void run() {
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < BaseBtFileExplorerActivity.b(this.a).getAdapter().getCount(); i2++) {
            BaseBtFileExplorerActivity$c baseBtFileExplorerActivity$c = (BaseBtFileExplorerActivity$c) BaseBtFileExplorerActivity.d(this.a).get(i2);
            if (BaseBtFileExplorerActivity.e(this.a).contains(baseBtFileExplorerActivity$c) || BaseBtFileExplorerActivity.a(this.a, baseBtFileExplorerActivity$c.mFileIndex)) {
                arrayList.add(Long.valueOf((long) baseBtFileExplorerActivity$c.mFileIndex));
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        while (i < size) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
            i++;
        }
        this.a.a(jArr);
    }
}
