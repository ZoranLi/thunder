package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;

/* compiled from: Taobao */
class a implements ISecurity {
    private String a = null;

    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        return null;
    }

    public byte[] getBytes(Context context, String str) {
        return null;
    }

    public boolean isSecOff() {
        return true;
    }

    public boolean saveBytes(Context context, String str, byte[] bArr) {
        return false;
    }

    a(String str) {
        this.a = str;
    }

    public String sign(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(this.a) == null && ISecurity.SIGN_ALGORITHM_HMAC_SHA1.equalsIgnoreCase(str) != null) {
            return HMacUtil.hmacSha1Hex(this.a.getBytes(), str3.getBytes());
        }
        return null;
    }
}
