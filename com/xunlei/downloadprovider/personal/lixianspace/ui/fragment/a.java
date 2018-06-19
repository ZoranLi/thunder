package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import com.xunlei.downloadprovider.member.payment.external.i;
import java.util.Observable;

/* compiled from: LXDownloadEntryFragment */
final class a extends i {
    final /* synthetic */ LXDownloadEntryFragment a;

    a(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void update(Observable observable, Object obj) {
        if (this.a.isAlive() != null) {
            if (this.a.getActivity().isFinishing() == null) {
                if (((PayResultBean) obj).isSuccess() != null) {
                    LXDownloadEntryFragment.a(this.a);
                }
            }
        }
    }
}
