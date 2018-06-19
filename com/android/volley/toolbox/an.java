package com.android.volley.toolbox;

import java.util.BitSet;

/* compiled from: TokenParser */
public final class an {
    public static final an a = new an();

    private static boolean a(char c) {
        if (!(c == ' ' || c == '\t' || c == '\r')) {
            if (c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static BitSet a(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }

    public static String a(f fVar, am amVar, BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        loop0:
        while (true) {
            Object obj = null;
            while (!amVar.a()) {
                char charAt = fVar.charAt(amVar.b);
                if (bitSet.get(charAt)) {
                    break loop0;
                } else if (a(charAt)) {
                    a(fVar, amVar);
                    obj = 1;
                } else {
                    if (obj != null && stringBuilder.length() > 0) {
                        stringBuilder.append(' ');
                    }
                    a(fVar, amVar, bitSet, stringBuilder);
                }
            }
            break loop0;
        }
        return stringBuilder.toString();
    }

    public static String b(f fVar, am amVar, BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        loop0:
        while (true) {
            Object obj = null;
            while (!amVar.a()) {
                char charAt = fVar.charAt(amVar.b);
                if (bitSet.get(charAt)) {
                    break loop0;
                } else if (a(charAt)) {
                    a(fVar, amVar);
                    obj = 1;
                } else if (charAt == '\"') {
                    if (obj != null && stringBuilder.length() > 0) {
                        stringBuilder.append(' ');
                    }
                    a(fVar, amVar, stringBuilder);
                } else {
                    if (obj != null && stringBuilder.length() > 0) {
                        stringBuilder.append(' ');
                    }
                    b(fVar, amVar, bitSet, stringBuilder);
                }
            }
            break loop0;
        }
        return stringBuilder.toString();
    }

    private static void a(f fVar, am amVar, StringBuilder stringBuilder) {
        if (!amVar.a()) {
            int i = amVar.b;
            int i2 = amVar.b;
            int i3 = amVar.a;
            if (fVar.charAt(i) == '\"') {
                i2++;
                int i4 = i + 1;
                i = 0;
                while (i2 < i3) {
                    char charAt = fVar.charAt(i2);
                    if (i != 0) {
                        if (!(charAt == '\"' || charAt == '\\')) {
                            stringBuilder.append('\\');
                        }
                        stringBuilder.append(charAt);
                        i = 0;
                    } else if (charAt == '\"') {
                        i4++;
                        break;
                    } else if (charAt == '\\') {
                        i = 1;
                    } else if (!(charAt == '\r' || charAt == '\n')) {
                        stringBuilder.append(charAt);
                    }
                    i2++;
                    i4++;
                }
                amVar.a(i4);
            }
        }
    }

    private static void a(f fVar, am amVar) {
        int i = amVar.b;
        int i2 = amVar.b;
        int i3 = amVar.a;
        while (i2 < i3 && a(fVar.charAt(i2))) {
            i++;
            i2++;
        }
        amVar.a(i);
    }

    private static void a(f fVar, am amVar, BitSet bitSet, StringBuilder stringBuilder) {
        int i = amVar.b;
        int i2 = amVar.a;
        for (int i3 = amVar.b; i3 < i2; i3++) {
            char charAt = fVar.charAt(i3);
            if ((bitSet != null && bitSet.get(charAt)) || a(charAt)) {
                break;
            }
            i++;
            stringBuilder.append(charAt);
        }
        amVar.a(i);
    }

    private static void b(f fVar, am amVar, BitSet bitSet, StringBuilder stringBuilder) {
        int i = amVar.b;
        int i2 = amVar.a;
        for (int i3 = amVar.b; i3 < i2; i3++) {
            char charAt = fVar.charAt(i3);
            if ((bitSet != null && bitSet.get(charAt)) || a(charAt) || charAt == '\"') {
                break;
            }
            i++;
            stringBuilder.append(charAt);
        }
        amVar.a(i);
    }
}
