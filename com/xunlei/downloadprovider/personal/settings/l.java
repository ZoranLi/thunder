package com.xunlei.downloadprovider.personal.settings;

import com.xunlei.downloadprovider.personal.settings.ui.SDCardViewHolder.a;

/* compiled from: ChooseDownloadSDCardActivity */
final class l implements a {
    final /* synthetic */ ChooseDownloadSDCardActivity a;

    l(ChooseDownloadSDCardActivity chooseDownloadSDCardActivity) {
        this.a = chooseDownloadSDCardActivity;
    }

    public final void a(boolean z) {
        this.a.e.setSelected(z ^ 1);
        this.a.f.a();
    }
}
