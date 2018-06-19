package com.taobao.accs.net;

import com.taobao.accs.utl.UtilityImpl;
import org.android.spdy.AccsSSLCallback;

/* compiled from: Taobao */
class u implements AccsSSLCallback {
    final /* synthetic */ r a;

    u(r rVar) {
        this.a = rVar;
    }

    public byte[] getSSLPublicKey(int i, byte[] bArr) {
        return UtilityImpl.staticBinarySafeDecryptNoB64(this.a.d, this.a.m, this.a.b, bArr);
    }
}
