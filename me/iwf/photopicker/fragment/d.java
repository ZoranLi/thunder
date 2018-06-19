package me.iwf.photopicker.fragment;

import java.util.List;
import me.iwf.photopicker.d.d.b;

/* compiled from: PhotoPickerFragment */
final class d implements b {
    final /* synthetic */ PhotoPickerFragment a;

    d(PhotoPickerFragment photoPickerFragment) {
        this.a = photoPickerFragment;
    }

    public final void a(List<me.iwf.photopicker.b.b> list) {
        this.a.f.clear();
        this.a.f.addAll(list);
        this.a.a.notifyDataSetChanged();
        this.a.e.notifyDataSetChanged();
        this.a.a();
    }
}
