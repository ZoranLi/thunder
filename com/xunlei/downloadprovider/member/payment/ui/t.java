package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.personal.settings.HelpActivity;

/* compiled from: BasePayPageFragment */
final class t implements OnClickListener {
    final /* synthetic */ BasePayPageFragment a;

    t(BasePayPageFragment basePayPageFragment) {
        this.a = basePayPageFragment;
    }

    public final void onClick(View view) {
        HelpActivity.a(this.a.getActivity(), PayBaseConstants.ASSET_SERVICE_PROTOCOL_INDEX_V2, this.a.getResources().getString(R.string.member_service_agreement));
        d.d();
    }
}
