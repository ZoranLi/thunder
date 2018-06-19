package com.igexin.push.core;

import com.igexin.sdk.aidl.a;

final class p extends a {
    p() {
    }

    public final byte[] extFunction(byte[] bArr) {
        return null;
    }

    public final int isStarted(String str) {
        return 1;
    }

    public final int onASNLConnected(String str, String str2, String str3, long j) {
        return f.a() != null ? f.a().h().a(str3) : -1;
    }

    public final int onASNLNetworkConnected() {
        if (f.a().g().a()) {
            return -1;
        }
        f.a().g().b();
        return 0;
    }

    public final int onASNLNetworkDisconnected() {
        if (f.a().g().a()) {
            return -1;
        }
        f.a().g().b(false);
        return 0;
    }

    public final int onPSNLConnected(String str, String str2, String str3, long j) {
        return (f.a() == null || str.equals("") || str2.equals("")) ? -1 : f.a().h().a(str, str2);
    }

    public final int receiveToPSNL(String str, String str2, byte[] bArr) {
        return (str2 == null || bArr == null || f.a().g().a()) ? -1 : f.a().h().b(str, str2, bArr);
    }

    public final int sendByASNL(String str, String str2, byte[] bArr) {
        return (str2 == null || bArr == null || !f.a().g().a()) ? -1 : f.a().h().a(str, str2, bArr);
    }

    public final int setSilentTime(int i, int i2, String str) {
        return 1;
    }

    public final int startService(String str) {
        return 1;
    }

    public final int stopService(String str) {
        return 1;
    }
}
