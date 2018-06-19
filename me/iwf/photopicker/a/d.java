package me.iwf.photopicker.a;

import android.view.View;
import android.view.View.OnClickListener;
import me.iwf.photopicker.a.a.a;

/* compiled from: PhotoGridAdapter */
final class d implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ me.iwf.photopicker.b.a b;
    final /* synthetic */ a c;

    d(a aVar, a aVar2, me.iwf.photopicker.b.a aVar3) {
        this.c = aVar;
        this.a = aVar2;
        this.b = aVar3;
    }

    public final void onClick(View view) {
        view = this.a.getAdapterPosition();
        int i = 1;
        if (this.c.a != null) {
            me.iwf.photopicker.c.a d = this.c.a;
            me.iwf.photopicker.b.a aVar = this.b;
            int size = this.c.f().size();
            if (this.c.a(this.b)) {
                i = -1;
            }
            i = d.a(aVar, size + i);
        }
        if (i != 0) {
            this.c.b(this.b);
            this.c.notifyItemChanged(view);
        }
    }
}
