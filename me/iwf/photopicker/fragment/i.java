package me.iwf.photopicker.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: PhotoPickerFragment */
final class i extends OnScrollListener {
    final /* synthetic */ PhotoPickerFragment a;

    i(PhotoPickerFragment photoPickerFragment) {
        this.a = photoPickerFragment;
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (Math.abs(i2) > this.a.h) {
            this.a.j.pauseRequests();
        } else {
            PhotoPickerFragment.h(this.a);
        }
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            PhotoPickerFragment.h(this.a);
        }
    }
}
