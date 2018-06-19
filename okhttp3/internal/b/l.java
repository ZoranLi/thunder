package okhttp3.internal.b;

import okhttp3.Protocol;

/* compiled from: StatusLine */
public final class l {
    public final Protocol a;
    public final int b;
    public final String c;

    private l(Protocol protocol, int i, String str) {
        this.a = protocol;
        this.b = i;
        this.c = str;
    }

    public static okhttp3.internal.b.l a(java.lang.String r8) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "HTTP/1.";
        r0 = r8.startsWith(r0);
        r1 = 4;
        r2 = 32;
        r3 = 9;
        if (r0 == 0) goto L_0x0056;
    L_0x000d:
        r0 = r8.length();
        if (r0 < r3) goto L_0x0042;
    L_0x0013:
        r0 = 8;
        r0 = r8.charAt(r0);
        if (r0 == r2) goto L_0x001c;
    L_0x001b:
        goto L_0x0042;
    L_0x001c:
        r0 = 7;
        r0 = r8.charAt(r0);
        r0 = r0 + -48;
        if (r0 != 0) goto L_0x0028;
    L_0x0025:
        r0 = okhttp3.Protocol.HTTP_1_0;
        goto L_0x0061;
    L_0x0028:
        r4 = 1;
        if (r0 != r4) goto L_0x002e;
    L_0x002b:
        r0 = okhttp3.Protocol.HTTP_1_1;
        goto L_0x0061;
    L_0x002e:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0042:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x0056:
        r0 = "ICY ";
        r0 = r8.startsWith(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x005e:
        r0 = okhttp3.Protocol.HTTP_1_0;
        r3 = r1;
    L_0x0061:
        r4 = r8.length();
        r5 = r3 + 3;
        if (r4 >= r5) goto L_0x007d;
    L_0x0069:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x007d:
        r4 = r8.substring(r3, r5);	 Catch:{ NumberFormatException -> 0x00b2 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x00b2 }
        r6 = "";
        r7 = r8.length();
        if (r7 <= r5) goto L_0x00ac;
    L_0x008d:
        r5 = r8.charAt(r5);
        if (r5 == r2) goto L_0x00a7;
    L_0x0093:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00a7:
        r3 = r3 + r1;
        r6 = r8.substring(r3);
    L_0x00ac:
        r8 = new okhttp3.internal.b.l;
        r8.<init>(r0, r4, r6);
        return r8;
    L_0x00b2:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00c6:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected status line: ";
        r1.<init>(r2);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.b.l.a(java.lang.String):okhttp3.internal.b.l");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ');
        stringBuilder.append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.c);
        }
        return stringBuilder.toString();
    }
}
