package me.iwf.photopicker.a;

import android.view.View;
import android.view.View.OnClickListener;
import me.iwf.photopicker.a.a.a;

/* compiled from: PhotoGridAdapter */
final class c implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    c(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void onClick(View view) {
        if (this.b.b != null) {
            int adapterPosition = this.a.getAdapterPosition();
            if (this.b.e) {
                this.b.b.onClick(view, adapterPosition, this.b.b());
                return;
            }
            this.a.b.performClick();
        }
    }
}
