package com.xunlei.downloadprovider.vod.speeduptrial;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.d.b.i;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: BubbleTipBarControl */
public final class f {
    public BubbleTipBar a;
    public boolean b = false;
    public l c;
    public m d;
    public l e;
    public TaskInfo f;
    public a g;
    private boolean h;
    private Handler i;

    /* compiled from: BubbleTipBarControl */
    public interface a {
        boolean a();
    }

    final void a() {
        this.a.setFirstTextColor(Color.argb(255, 35, Opcodes.REM_LONG, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK));
        this.a.setSecondTextColor(-1);
    }

    public f(Context context, BubbleTipBar bubbleTipBar) {
        this.a = bubbleTipBar;
        bubbleTipBar = d.a().h;
        this.h = i.f();
        this.i = new Handler(Looper.getMainLooper());
        this.e = new g(this, this.i);
        this.c = new h(this, this.i);
        this.d = new m();
        this.a.setExitAnimRightMargin(10.0f);
        this.a.setOnClickListener(new i(this, context));
        this.a.setCallBack(new j(this));
        Looper.myQueue().addIdleHandler(new k(this));
        this.a.setVisibility(8);
        a();
    }

    public final boolean b() {
        return ((this.g != null && this.g.a()) || this.f == null || this.d.b(32) || !this.h || LoginHelper.a().l()) ? false : true;
    }

    public final void c() {
        this.a.clearAnimation();
        this.a.setVisibility(8);
    }

    public final void a(String str, String str2) {
        this.a.setFirstText(str);
        this.a.setSecondText(str2);
    }
}
