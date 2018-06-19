package com.xunlei.downloadprovider.vod.speeduptrial;

import android.graphics.Color;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.vod.speeduptrial.BubbleTipBar.b;

/* compiled from: BubbleTipBarControl */
final class j extends b {
    final /* synthetic */ f a;

    public final void a(BubbleBarView bubbleBarView) {
    }

    public final void c(BubbleBarView bubbleBarView) {
    }

    j(f fVar) {
        this.a = fVar;
    }

    public final void b(BubbleBarView bubbleBarView) {
        this.a.a.a();
    }

    public final void f(BubbleBarView bubbleBarView) {
        if (this.a.d.b(4) != null) {
            this.a.e.c();
        } else {
            this.a.c.c();
        }
    }

    public final void d(BubbleBarView bubbleBarView) {
        this.a.d.a();
        this.a.a.setVisibility(8);
    }

    public final void i(BubbleBarView bubbleBarView) {
        bubbleBarView = this.a;
        bubbleBarView.a.setFirstTextColor(-1);
        bubbleBarView.a.setSecondTextColor(Color.argb(255, 35, Opcodes.REM_LONG, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK));
    }

    public final void j(BubbleBarView bubbleBarView) {
        this.a.a();
    }
}
