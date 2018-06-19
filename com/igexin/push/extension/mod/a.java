package com.igexin.push.extension.mod;

import com.igexin.a.f;

final class a implements f {
    a() {
    }

    public final void a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SecurityUtils.a);
        stringBuilder.append("|load so by new success ^_^");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        SecurityUtils.b = true;
        SecurityUtils.c = "";
    }

    public final void a(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SecurityUtils.a);
        stringBuilder.append("|load so by new error = ");
        stringBuilder.append(th.getMessage());
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        SecurityUtils.b = false;
        stringBuilder = new StringBuilder();
        stringBuilder.append(SecurityUtils.c);
        stringBuilder.append(th.toString());
        stringBuilder.append(" + ");
        stringBuilder.append(th.getMessage());
        SecurityUtils.c = stringBuilder.toString();
    }
}
