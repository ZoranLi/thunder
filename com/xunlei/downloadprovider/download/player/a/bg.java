package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.vodnew.a.d.b.a;

/* compiled from: SubtitleController */
final class bg implements a {
    final /* synthetic */ ba a;

    bg(ba baVar) {
        this.a = baVar;
    }

    public final void a(boolean z) {
        if (!this.a.v()) {
            if (z) {
                if (this.a.w) {
                    XLToast.showToast(this.a.g, "字幕加载成功");
                }
                this.a.k = "open";
                this.a.l = "open";
                return;
            }
            if (this.a.w) {
                XLToast.showToast(this.a.g, "字幕加载失败");
            }
            this.a.o.a(-1, true);
            this.a.k = "set_fail";
            this.a.l = "close";
        }
    }
}
