package com.qq.e.comm.managers.plugin;

import android.content.Context;
import java.io.File;

class PM$1 implements PM$a$a {
    private /* synthetic */ PM a;

    PM$1(PM pm) {
        this.a = pm;
    }

    static File a(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar");
    }

    static File b(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next");
    }

    static File c(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.jar.sig");
    }

    static File d(Context context) {
        return new File(context.getDir("e_qq_com_plugin", 0), "gdt_plugin.next.sig");
    }

    public final void a() {
        PM.a(this.a);
    }

    public final void b() {
        PM.b(this.a);
    }
}
