package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnShowSubtitleListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.g;

/* compiled from: APlayerAndroidProxy */
final class d implements OnShowSubtitleListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onShowSubtitle(String str) {
        for (g a : this.a.m) {
            a.a(str);
        }
    }
}
