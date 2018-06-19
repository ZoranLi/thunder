package com.xunlei.downloadprovider.download.create;

import android.net.Uri;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.io.File;

public class CreateBtTaskActivity extends BaseCreateBtTaskActivity implements OnClickListener {
    public void onResume() {
        super.onResume();
        n.a();
        if (n.b() && this.a != null && !this.c) {
            DownloadBtFileExplorerActivity.a(this, Uri.fromFile(new File(this.a)).toString(), 9);
            this.c = true;
        }
    }

    protected final void a(String str, int i) {
        if (i == 0) {
            DownloadBtFileExplorerActivity.a(this, str, 9);
        } else {
            DownloadBtFileExplorerActivity.a(this, str, 10);
        }
    }
}
