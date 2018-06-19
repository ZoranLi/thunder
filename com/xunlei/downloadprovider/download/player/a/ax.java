package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.g.a.b;
import com.xunlei.downloadprovider.member.payment.a.e$b;

/* compiled from: RecordPublishController */
final class ax implements e$b {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ aq e;

    ax(aq aqVar, long j, String str, String str2, String str3) {
        this.e = aqVar;
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void a() {
        aq.b(this.e, "success");
        if (!(this.e.o() == null || this.e.o().isFinishing())) {
            XLToast.showToast(this.e.o(), "发布成功");
        }
        b.a("play_record", this.a, this.b, (this.e.m - this.e.j) / 1000, URLCoder.encode(this.c, null), URLCoder.encode(this.d, null), "success");
    }

    public final void a(int i) {
        aq.b(this.e, String.valueOf(i));
        if (!(this.e.o() == null || this.e.o().isFinishing())) {
            XLToast.showToast(this.e.o(), "发布失败");
        }
        b.a("play_record", this.a, this.b, (this.e.m - this.e.j) / 1000, URLCoder.encode(this.c, null), URLCoder.encode(this.d, null), String.valueOf(i));
    }
}
