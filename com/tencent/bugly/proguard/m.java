package com.tencent.bugly.proguard;

import java.io.Serializable;

/* compiled from: BUGLY */
public abstract class m implements Serializable {
    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(StringBuilder stringBuilder, int i);

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, 0);
        return stringBuilder.toString();
    }
}
