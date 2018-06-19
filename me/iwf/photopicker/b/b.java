package me.iwf.photopicker.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PhotoDirectory */
public final class b {
    public String a;
    public String b;
    public String c;
    public long d;
    public List<a> e = new ArrayList();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof me.iwf.photopicker.b.b;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r5 = (me.iwf.photopicker.b.b) r5;
        r1 = r4.a;
        r1 = android.text.TextUtils.isEmpty(r1);
        r1 = r1 ^ r0;
        r3 = r5.a;
        r3 = android.text.TextUtils.isEmpty(r3);
        r0 = r0 ^ r3;
        if (r1 == 0) goto L_0x0032;
    L_0x001c:
        if (r0 == 0) goto L_0x0032;
    L_0x001e:
        r0 = r4.a;
        r1 = r5.a;
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        return r2;
    L_0x0029:
        r0 = r4.c;
        r5 = r5.c;
        r5 = android.text.TextUtils.equals(r0, r5);
        return r5;
    L_0x0032:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: me.iwf.photopicker.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        if (!TextUtils.isEmpty(this.a)) {
            int hashCode = this.a.hashCode();
            if (TextUtils.isEmpty(this.c)) {
                return hashCode;
            }
            return (31 * hashCode) + this.c.hashCode();
        } else if (TextUtils.isEmpty(this.c)) {
            return 0;
        } else {
            return this.c.hashCode();
        }
    }

    public final List<String> a() {
        List<String> arrayList = new ArrayList(this.e.size());
        for (a aVar : this.e) {
            arrayList.add(aVar.a);
        }
        return arrayList;
    }

    public final void a(int i, String str) {
        if (me.iwf.photopicker.d.b.a(str)) {
            this.e.add(new a(i, str));
        }
    }
}
