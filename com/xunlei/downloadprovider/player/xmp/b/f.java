package com.xunlei.downloadprovider.player.xmp.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.WindowManager.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;

/* compiled from: PlayerNetworkDialogHelper */
public final class f implements OnShowListener {
    public final void onShow(DialogInterface dialogInterface) {
        Dialog dialog = (Dialog) dialogInterface;
        LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = DipPixelUtil.dip2px(314.0f);
        dialog.getWindow().setAttributes(attributes);
    }
}
