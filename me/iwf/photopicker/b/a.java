package me.iwf.photopicker.b;

/* compiled from: Photo */
public final class a {
    public String a;
    private int b;

    public a(int i, String str) {
        this.b = i;
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.b == ((a) obj).b;
    }

    public final int hashCode() {
        return this.b;
    }
}
