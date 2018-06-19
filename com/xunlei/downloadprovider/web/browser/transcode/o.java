package com.xunlei.downloadprovider.web.browser.transcode;

import java.io.PipedOutputStream;
import java.util.TimerTask;

/* compiled from: BrowserTranscodeHelper */
final class o extends TimerTask {
    final /* synthetic */ PipedOutputStream a;
    final /* synthetic */ BrowserTranscodeHelper b;

    o(BrowserTranscodeHelper browserTranscodeHelper, PipedOutputStream pipedOutputStream) {
        this.b = browserTranscodeHelper;
        this.a = pipedOutputStream;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a;	 Catch:{ IOException -> 0x0006 }
        r0.close();	 Catch:{ IOException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.transcode.o.run():void");
    }
}
