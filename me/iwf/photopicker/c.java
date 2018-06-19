package me.iwf.photopicker;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PhotoPagerActivity */
final class c implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ PhotoPagerActivity b;

    c(PhotoPagerActivity photoPagerActivity, int i) {
        this.b = photoPagerActivity;
        this.a = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.a.a.remove(this.a);
        this.b.a.b.getAdapter().notifyDataSetChanged();
        this.b.onBackPressed();
    }
}
