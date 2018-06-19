package com.xunlei.downloadprovider.homepage.download;

import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: DownloadTabFragment */
final class q implements OnDismissListener {
    final /* synthetic */ DownloadTabFragment a;

    q(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onDismiss() {
        LayoutParams attributes = this.a.getActivity().getWindow().getAttributes();
        attributes.alpha = 1.0f;
        this.a.getActivity().getWindow().setAttributes(attributes);
    }
}
