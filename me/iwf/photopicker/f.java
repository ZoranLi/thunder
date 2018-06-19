package me.iwf.photopicker;

/* compiled from: PhotoPickerActivity */
final class f implements Runnable {
    final /* synthetic */ PhotoPickerActivity a;

    f(PhotoPickerActivity photoPickerActivity) {
        this.a = photoPickerActivity;
    }

    public final void run() {
        if (this.a.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            this.a.getSupportFragmentManager().popBackStack();
        }
    }
}
