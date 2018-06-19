package com.xunlei.downloadprovider.publiser.common;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: AvatarActivity */
final class d implements RequestListener<String, GlideDrawable> {
    final /* synthetic */ AvatarActivity a;

    d(AvatarActivity avatarActivity) {
        this.a = avatarActivity;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        GlideDrawable glideDrawable = (GlideDrawable) obj;
        this.a.h = glideDrawable.getIntrinsicWidth();
        this.a.i = glideDrawable.getIntrinsicHeight();
        this.a.b();
        return null;
    }

    public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        this.a.b();
        return null;
    }
}
