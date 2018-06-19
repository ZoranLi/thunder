package me.iwf.photopicker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PhotoPagerActivity */
final class b implements OnClickListener {
    final /* synthetic */ PhotoPagerActivity a;

    b(PhotoPagerActivity photoPagerActivity) {
        this.a = photoPagerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
