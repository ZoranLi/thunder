package com.android.volley.toolbox;

import java.io.Serializable;

/* compiled from: BasicNameValuePair */
public class e implements al, Serializable, Cloneable {
    private final String a;
    private final String b;

    public e(String str, String str2) {
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
        if (this.b == null) {
            return this.a;
        }
        StringBuilder stringBuilder = new StringBuilder((this.a.length() + 1) + this.b.length());
        stringBuilder.append(this.a);
        stringBuilder.append("=");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a.equals(eVar.a)) {
            String str = this.b;
            obj = eVar.b;
            obj = str == null ? obj == null ? 1 : null : str.equals(obj);
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ai.a(ai.a(17, this.a), this.b);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
