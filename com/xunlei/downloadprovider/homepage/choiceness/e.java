package com.xunlei.downloadprovider.homepage.choiceness;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.xunlei.downloadprovider.R;

/* compiled from: ChoicenessImageUtil */
final class e extends ImageViewTarget<GlideDrawable> {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    e(b bVar, ImageView imageView, String str) {
        this.b = bVar;
        this.a = str;
        super(imageView);
    }

    protected final /* synthetic */ void setResource(Object obj) {
        GlideDrawable glideDrawable = (GlideDrawable) obj;
        ((ImageView) this.view).setTag(R.id.tag_image_id, this.a);
        setDrawable(glideDrawable);
    }

    public final void onLoadStarted(Drawable drawable) {
        if (!"tag_for_error".equals(((ImageView) this.view).getTag(R.id.tag_image_id))) {
            super.onLoadStarted(drawable);
        }
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        super.onLoadFailed(exception, drawable);
        if (drawable != null) {
            ((ImageView) this.view).setTag(R.id.tag_image_id, "tag_for_error");
        }
    }

    public final void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
    }
}
