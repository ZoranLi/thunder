package com.android.volley.toolbox;

import java.util.BitSet;

/* compiled from: BasicHeaderValueParser */
public final class ad {
    @Deprecated
    public static final ad a = new ad();
    public static final ad b = new ad();
    private static final BitSet c = an.a(61, 59, 44);
    private static final BitSet d = an.a(59, 44);
    private final an e = an.a;

    @Deprecated
    public static al a(f fVar, am amVar, char[] cArr) {
        ac.a(fVar, "Char array buffer");
        ac.a(amVar, "Parser cursor");
        BitSet bitSet = new BitSet();
        if (cArr != null) {
            for (char c : cArr) {
                bitSet.set(c);
            }
        }
        bitSet.set(61);
        String a = an.a(fVar, amVar, bitSet);
        if (amVar.a()) {
            return new e(a, null);
        }
        char charAt = fVar.charAt(amVar.b);
        amVar.a(amVar.b + 1);
        if (charAt != '=') {
            return a(a, null);
        }
        bitSet.clear(61);
        fVar = an.b(fVar, amVar, bitSet);
        if (amVar.a() == null) {
            amVar.a(amVar.b + 1);
        }
        return a(a, fVar);
    }

    private static al a(String str, String str2) {
        return new e(str, str2);
    }
}
