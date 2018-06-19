package me.iwf.photopicker.fragment;

import android.view.View;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.R;
import me.iwf.photopicker.c.b;

/* compiled from: PhotoPickerFragment */
final class f implements b {
    final /* synthetic */ PhotoPickerFragment a;

    f(PhotoPickerFragment photoPickerFragment) {
        this.a = photoPickerFragment;
    }

    public final void onClick(View view, int i, boolean z) {
        if (z) {
            i--;
        }
        z = this.a.a.e();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view = ImagePagerFragment.a(z, i, iArr, view.getWidth(), view.getHeight());
        PhotoPickerActivity photoPickerActivity = (PhotoPickerActivity) this.a.getActivity();
        photoPickerActivity.a = view;
        photoPickerActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container, photoPickerActivity.a).addToBackStack(0).commit();
    }
}
