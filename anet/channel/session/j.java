package anet.channel.session;

import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* compiled from: Taobao */
class j implements AccsSSLCallback {
    final /* synthetic */ TnetSpdySession a;

    j(TnetSpdySession tnetSpdySession) {
        this.a = tnetSpdySession;
    }

    public byte[] getSSLPublicKey(int i, byte[] bArr) {
        Throwable th;
        try {
            bArr = this.a.iSecurity.decrypt(this.a.mContext, ISecurity.CIPHER_ALGORITHM_AES128, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
            if (bArr != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.i("getSSLPublicKey", null, "decrypt", new String(bArr));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
                    return bArr;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
            ALog.e("awcn.TnetSpdySession", "getSSLPublicKey", null, th, new Object[0]);
            return bArr;
        }
        return bArr;
    }
}
