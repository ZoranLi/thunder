package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: LXSpaceExpansionDlg */
final class h implements RequestListener<String, GlideDrawable> {
    final /* synthetic */ c a;

    public final /* bridge */ /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        return false;
    }

    h(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        GlideDrawable glideDrawable = (GlideDrawable) obj;
        c.a;
        new StringBuilder("onResourceReady drawable = ").append(glideDrawable.getCurrent().toString());
        this.a.b.setColumnSelectIcon(glideDrawable.getCurrent());
        return null;
    }
}
