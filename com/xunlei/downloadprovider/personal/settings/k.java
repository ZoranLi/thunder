package com.xunlei.downloadprovider.personal.settings;

import com.xunlei.downloadprovider.personal.settings.ui.SDCardViewHolder.a;

/* compiled from: ChooseDownloadSDCardActivity */
final class k implements a {
    final /* synthetic */ ChooseDownloadSDCardActivity a;

    k(ChooseDownloadSDCardActivity chooseDownloadSDCardActivity) {
        this.a = chooseDownloadSDCardActivity;
    }

    public final void a(boolean z) {
        this.a.f.setSelected(z ^ 1);
        this.a.e.a();
    }
}
