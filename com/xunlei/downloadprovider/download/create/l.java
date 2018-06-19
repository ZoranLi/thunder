package com.xunlei.downloadprovider.download.create;

import android.net.Uri;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.widget.FileManagerListView.c;
import java.io.File;

/* compiled from: BaseCreateBtTaskActivity */
final class l implements c {
    final /* synthetic */ BaseCreateBtTaskActivity a;

    l(BaseCreateBtTaskActivity baseCreateBtTaskActivity) {
        this.a = baseCreateBtTaskActivity;
    }

    public final boolean a(String str) {
        if (this.a.i != 2) {
            File file = new File(str);
            if (file.exists()) {
                str = Uri.fromFile(new File(str)).toString();
                if (this.a.i == 0) {
                    this.a.a(str, this.a.i);
                    SettingStateController.getInstance().setLastTorrentOpenPath(file.getParent());
                } else {
                    this.a.a(str, this.a.i);
                }
            } else {
                XLToast.showToast(this.a.getApplicationContext(), this.a.getString(R.string.bt_create_new_file_nonexist));
            }
        }
        return true;
    }
}
