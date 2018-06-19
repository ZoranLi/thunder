package com.xunlei.downloadprovider.player.xmp.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.player.xmp.a;

/* compiled from: PlayerNetworkDialogHelper */
public final class d implements OnClickListener {
    final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.a != null) {
            this.a.b();
        }
    }
}
