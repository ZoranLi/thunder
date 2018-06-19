package me.iwf.photopicker.fragment;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoPickerFragment */
final class h implements OnClickListener {
    final /* synthetic */ PhotoPickerFragment a;

    h(PhotoPickerFragment photoPickerFragment) {
        this.a = photoPickerFragment;
    }

    public final void onClick(View view) {
        if (this.a.i.isShowing() != null) {
            this.a.i.dismiss();
            return;
        }
        if (this.a.getActivity().isFinishing() == null) {
            this.a.a();
            this.a.i.show();
        }
    }
}
