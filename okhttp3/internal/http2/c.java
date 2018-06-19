package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

/* compiled from: Http2 */
public final class c {
    static final ByteString a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final String[] b = new String[64];
    static final String[] c = new String[256];
    private static final String[] d;

    static {
        r0 = new String[10];
        int i = 0;
        r0[0] = "DATA";
        r0[1] = "HEADERS";
        r0[2] = "PRIORITY";
        r0[3] = "RST_STREAM";
        r0[4] = "SETTINGS";
        r0[5] = "PUSH_PROMISE";
        r0[6] = "PING";
        r0[7] = "GOAWAY";
        r0[8] = "WINDOW_UPDATE";
        r0[9] = "CONTINUATION";
        d = r0;
        for (int i2 = 0; i2 < c.length; i2++) {
            c[i2] = okhttp3.internal.c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
        }
        b[0] = "";
        b[1] = "END_STREAM";
        int[] iArr = new int[]{1};
        b[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr = b;
            int i5 = i4 | 8;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b[i4]);
            stringBuilder.append("|PADDED");
            strArr[i5] = stringBuilder.toString();
        }
        b[4] = "END_HEADERS";
        b[32] = "PRIORITY";
        b[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = new int[]{4, 32, 36};
        for (i4 = 0; i4 < 3; i4++) {
            int i6 = iArr2[i4];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr2 = b;
                int i9 = i8 | i6;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b[i8]);
                stringBuilder2.append('|');
                stringBuilder2.append(b[i6]);
                strArr2[i9] = stringBuilder2.toString();
                strArr2 = b;
                i9 |= 8;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b[i8]);
                stringBuilder2.append('|');
                stringBuilder2.append(b[i6]);
                stringBuilder2.append("|PADDED");
                strArr2[i9] = stringBuilder2.toString();
            }
        }
        while (i < b.length) {
            if (b[i] == null) {
                b[i] = c[i];
            }
            i++;
        }
    }

    private c() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.internal.c.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.internal.c.a(str, objArr));
    }

    static String a(boolean z, int i, int i2, byte b, byte b2) {
        String a = b < d.length ? d[b] : okhttp3.internal.c.a("0x%02x", Byte.valueOf(b));
        if (b2 != (byte) 0) {
            switch (b) {
                case (byte) 2:
                case (byte) 3:
                case (byte) 7:
                case (byte) 8:
                    b = c[b2];
                    break;
                case (byte) 4:
                case (byte) 6:
                    if (b2 != (byte) 1) {
                        b = c[b2];
                        break;
                    }
                    b = "ACK";
                    break;
                default:
                    String str;
                    if (b2 < b.length) {
                        str = b[b2];
                    } else {
                        str = c[b2];
                    }
                    if (b != (byte) 5 || (b2 & 4) == 0) {
                        if (b == (byte) 0 && (b2 & 32) != (byte) 0) {
                            b = str.replace("PRIORITY", "COMPRESSED");
                            break;
                        }
                        b = str;
                        break;
                    }
                    b = str.replace("HEADERS", "PUSH_PROMISE");
                    break;
                    break;
            }
        }
        b = "";
        String str2 = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[true] = Integer.valueOf(i2);
        objArr[true] = a;
        objArr[true] = b;
        return okhttp3.internal.c.a(str2, objArr);
    }
}
