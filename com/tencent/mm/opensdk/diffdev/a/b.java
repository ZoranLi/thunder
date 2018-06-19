package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

final class b implements OAuthListener {
    final /* synthetic */ a ac;

    b(a aVar) {
        this.ac = aVar;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str});
        this.ac.aa = null;
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ac.Z);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ac.Z);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        if (this.ac.handler != null) {
            this.ac.handler.post(new c(this));
        }
    }
}
