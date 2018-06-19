package com.xunlei.downloadprovider.personal.playrecord;

/* compiled from: PlayRecordDataManager */
final class ae implements Runnable {
    final /* synthetic */ v$a a;
    final /* synthetic */ String b;
    final /* synthetic */ v c;

    ae(v vVar, v$a com_xunlei_downloadprovider_personal_playrecord_v_a, String str) {
        this.c = vVar;
        this.a = com_xunlei_downloadprovider_personal_playrecord_v_a;
        this.b = str;
    }

    public final void run() {
        if (this.a != null) {
            this.a.a(af.c(this.b));
        }
    }
}
