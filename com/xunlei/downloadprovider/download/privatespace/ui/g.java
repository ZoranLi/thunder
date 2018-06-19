package com.xunlei.downloadprovider.download.privatespace.ui;

import android.os.Message;
import com.xunlei.downloadprovider.member.e;
import com.xunlei.downloadprovider.member.e.a;

/* compiled from: PrivateSpaceFindPwdActivity */
final class g implements Runnable {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    g(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void run() {
        a a = new e().a();
        Message obtainMessage = this.a.r.obtainMessage(4097);
        obtainMessage.obj = a;
        this.a.r.sendMessage(obtainMessage);
    }
}
