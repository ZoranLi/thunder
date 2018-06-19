package me.iwf.photopicker;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoPagerActivity */
final class d implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ PhotoPagerActivity c;

    d(PhotoPagerActivity photoPagerActivity, int i, String str) {
        this.c = photoPagerActivity;
        this.a = i;
        this.b = str;
    }

    public final void onClick(View view) {
        if (this.c.a.a.size() > null) {
            this.c.a.a.add(this.a, this.b);
        } else {
            this.c.a.a.add(this.b);
        }
        this.c.a.b.getAdapter().notifyDataSetChanged();
        this.c.a.b.setCurrentItem(this.a, true);
    }
}
