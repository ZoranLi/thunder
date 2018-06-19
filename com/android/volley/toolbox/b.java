package com.android.volley.toolbox;

import java.io.Serializable;

/* compiled from: BasicHeader */
public class b implements ag, Serializable, Cloneable {
    private final String a;
    private final String b;

    public b(String str, String str2) {
        this.a = (String) ac.a(str, "Name");
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String toString() {
        ae aeVar = ae.b;
        return ae.a(this).toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
