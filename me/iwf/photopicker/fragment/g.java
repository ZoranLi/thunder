package me.iwf.photopicker.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import me.iwf.photopicker.d.f;

/* compiled from: PhotoPickerFragment */
final class g implements OnClickListener {
    final /* synthetic */ PhotoPickerFragment a;

    g(PhotoPickerFragment photoPickerFragment) {
        this.a = photoPickerFragment;
    }

    public final void onClick(View view) {
        if (f.b(this.a) != null && f.a(this.a) != null) {
            this.a.b();
        }
    }
}
