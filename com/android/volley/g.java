package com.android.volley;

import android.text.TextUtils;

/* compiled from: Header */
public final class g {
    public final String a;
    public final String b;

    public g(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                g gVar = (g) obj;
                return TextUtils.equals(this.a, gVar.a) && TextUtils.equals(this.b, gVar.b) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * this.a.hashCode()) + this.b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Header[name=");
        stringBuilder.append(this.a);
        stringBuilder.append(",value=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
