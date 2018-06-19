package com.xunlei.downloadprovider.download;

import android.net.Uri;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.widget.FileManagerListView.c;
import java.io.File;

/* compiled from: XLFileExploreActivity */
final class e implements c {
    final /* synthetic */ XLFileExploreActivity a;

    e(XLFileExploreActivity xLFileExploreActivity) {
        this.a = xLFileExploreActivity;
    }

    public final boolean a(String str) {
        if (this.a.j != 2) {
            if (new File(str).exists()) {
                str = Uri.fromFile(new File(str)).toString();
                XLFileExploreActivity xLFileExploreActivity;
                if (this.a.j == 0) {
                    xLFileExploreActivity = this.a;
                    this.a.j;
                    xLFileExploreActivity.a(str);
                } else {
                    xLFileExploreActivity = this.a;
                    this.a.j;
                    xLFileExploreActivity.a(str);
                }
            } else {
                XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.bt_create_new_file_nonexist));
            }
        }
        return true;
    }
}
