package com.xunlei.downloadprovider.homepage.redpacket;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.xunlei.downloadprovider.personal.redenvelope.f;

/* compiled from: RedPacketGuideDlg */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        f.a(Token.WX_TOKEN_PLATFORMID_VALUE);
        a.b(this.a);
    }
}
