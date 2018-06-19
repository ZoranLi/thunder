package com.umeng.message;

class UTrack$5 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ long d;
    final /* synthetic */ UTrack e;

    UTrack$5(UTrack uTrack, String str, String str2, String str3, long j) {
        this.e = uTrack;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    public void run() {
        this.e.sendMsgLogForAgoo(this.a, this.b, this.c, this.d);
    }
}
