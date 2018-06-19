package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;

class r extends FileChooserParams {
    final /* synthetic */ IX5WebChromeClient.FileChooserParams a;
    final /* synthetic */ n b;

    r(n nVar, IX5WebChromeClient.FileChooserParams fileChooserParams) {
        this.b = nVar;
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
