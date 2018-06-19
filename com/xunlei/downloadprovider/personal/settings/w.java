package com.xunlei.downloadprovider.personal.settings;

import com.bumptech.glide.Glide;
import com.xunlei.common.concurrent.XLCommand;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.e;
import java.io.File;

/* compiled from: SettingsIndexActivity */
final class w extends XLCommand {
    final /* synthetic */ SettingsIndexActivity a;

    w(SettingsIndexActivity settingsIndexActivity) {
        this.a = settingsIndexActivity;
    }

    protected final Object execute() throws Exception {
        long a;
        File photoCacheDir = Glide.getPhotoCacheDir(BrothersApplication.getApplicationInstance());
        if (photoCacheDir != null) {
            SettingsIndexActivity.a;
            new StringBuilder("file path=").append(photoCacheDir.getAbsolutePath());
            a = e.a(photoCacheDir);
            SettingsIndexActivity.a;
        } else {
            a = 0;
        }
        return Long.valueOf(a);
    }
}
