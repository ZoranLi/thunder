package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.j;

/* compiled from: ChoicenessLiveStoryItemView */
final class n extends ImageViewTarget<Bitmap> {
    final /* synthetic */ j a;
    final /* synthetic */ b b;

    n(b bVar, ImageView imageView, j jVar) {
        this.b = bVar;
        this.a = jVar;
        super(imageView);
    }

    protected final /* synthetic */ void setResource(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ((ImageView) this.view).setImageDrawable(new BitmapDrawable(((ImageView) this.view).getResources(), bitmap));
            if (this.b.a(this.a.e()) == null) {
                this.b.j.setVisibility(0);
                this.b.k.start();
            }
        }
    }
}
