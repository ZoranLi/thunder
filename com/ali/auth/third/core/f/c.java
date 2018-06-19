package com.ali.auth.third.core.f;

import java.util.ArrayList;

public final class c {
    public String a;
    public String b;
    public ArrayList<String> c = new ArrayList();
    public ArrayList<Object> d = new ArrayList();

    public final void a(String str, Object obj) {
        this.c.add(str);
        this.d.add(obj);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RpcRequest [target=");
        stringBuilder.append(this.a);
        stringBuilder.append(", version=");
        stringBuilder.append(this.b);
        stringBuilder.append(", params=]");
        return stringBuilder.toString();
    }
}
