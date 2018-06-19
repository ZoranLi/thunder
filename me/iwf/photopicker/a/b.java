package me.iwf.photopicker.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoGridAdapter */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.c != null) {
            this.a.c.onClick(view);
        }
    }
}
