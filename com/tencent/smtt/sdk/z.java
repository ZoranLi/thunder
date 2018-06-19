package com.tencent.smtt.sdk;

import android.content.Intent;
import android.webkit.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

class z extends FileChooserParams {
    final /* synthetic */ WebChromeClient.FileChooserParams a;
    final /* synthetic */ SystemWebChromeClient b;

    z(SystemWebChromeClient systemWebChromeClient, WebChromeClient.FileChooserParams fileChooserParams) {
        this.b = systemWebChromeClient;
        this.a = fileChooserParams;
    }

    public Intent createIntent() {
        return this.a.createIntent();
    }

    public String[] getAcceptTypes() {
        return this.a.getAcceptTypes();
    }

    public String getFilenameHint() {
        return this.a.getFilenameHint();
    }

    public int getMode() {
        return this.a.getMode();
    }

    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public boolean isCaptureEnabled() {
        return this.a.isCaptureEnabled();
    }
}
