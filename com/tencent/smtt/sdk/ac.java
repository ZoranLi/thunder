package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.WebResourceError;

class ac extends WebResourceError {
    final /* synthetic */ android.webkit.WebResourceError a;
    final /* synthetic */ aa b;

    ac(aa aaVar, android.webkit.WebResourceError webResourceError) {
        this.b = aaVar;
        this.a = webResourceError;
    }

    public CharSequence getDescription() {
        return this.a.getDescription();
    }

    public int getErrorCode() {
        return this.a.getErrorCode();
    }
}
