package com.getui.gtc.event.eventbus;

import java.lang.reflect.Method;

public final class l {
    public final Method a;
    final ThreadMode b;
    public final Class c;
    final int d;
    final boolean e;
    String f;

    public l(Method method, Class cls, ThreadMode threadMode, int i, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.a.getDeclaringClass().getName());
            stringBuilder.append('#');
            stringBuilder.append(this.a.getName());
            stringBuilder.append('(');
            stringBuilder.append(this.c.getName());
            this.f = stringBuilder.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f.equals(lVar.f);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
