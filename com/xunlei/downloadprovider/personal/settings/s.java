package com.xunlei.downloadprovider.personal.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.xllib.android.e.a;

/* compiled from: PathChooserActivity */
final class s implements OnClickListener {
    final /* synthetic */ PathChooserActivity a;

    s(PathChooserActivity pathChooserActivity) {
        this.a = pathChooserActivity;
    }

    public final void onClick(View view) {
        int i;
        String substring;
        view = this.a.a;
        new StringBuilder("choosed path:").append(this.a.f.getCurrentPath());
        String currentPath = this.a.f.getCurrentPath();
        if (PathChooserActivity.a(currentPath)) {
            i = 1;
            substring = currentPath.substring(a.a().length());
        } else {
            i = 2;
            substring = currentPath.substring(a.b().length());
        }
        DownloadConfig.setRealDownloadPath(i, substring);
        n.a();
        n.a(currentPath);
        SettingStateController.getInstance().setHadCreateTask();
        this.a.finish();
    }
}
