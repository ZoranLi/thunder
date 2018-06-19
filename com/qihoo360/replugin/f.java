package com.qihoo360.replugin;

import com.qihoo360.replugin.RePlugin.a;
import java.io.File;

/* compiled from: RePluginConfig */
public final class f {
    public d a;
    public RePluginEventCallbacks b;
    public File c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = true;
    public boolean g = false;
    public int h = 4;
    private boolean i = true;
    private String j = "";
    private String k = "";
    private boolean l = false;

    public final f a(d dVar) {
        if (!a()) {
            return this;
        }
        this.a = dVar;
        return this;
    }

    public static boolean a() {
        if (!a.a) {
            return true;
        }
        Throwable th = new Throwable();
        return false;
    }
}
