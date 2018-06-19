package com.qihoo360.replugin.ext.parser.c.a;

import com.tencent.tinker.android.dex.DexFormat;
import com.tencent.tinker.android.dx.instruction.Opcodes;

/* compiled from: XmlEscaper */
public final class h {
    public static final b a;

    static {
        r2 = new b[6];
        r6 = new String[31][];
        r6[0] = new String[]{DexFormat.MAGIC_SUFFIX, ""};
        r6[1] = new String[]{"\u0001", ""};
        r6[2] = new String[]{"\u0002", ""};
        r6[3] = new String[]{"\u0003", ""};
        r6[4] = new String[]{"\u0004", ""};
        r6[5] = new String[]{"\u0005", ""};
        r6[6] = new String[]{"\u0006", ""};
        r6[7] = new String[]{"\u0007", ""};
        r6[8] = new String[]{"\b", ""};
        r6[9] = new String[]{"\u000b", ""};
        r6[10] = new String[]{"\f", ""};
        r6[11] = new String[]{"\u000e", ""};
        r6[12] = new String[]{"\u000f", ""};
        r6[13] = new String[]{"\u0010", ""};
        r6[14] = new String[]{"\u0011", ""};
        r6[15] = new String[]{"\u0012", ""};
        r6[16] = new String[]{"\u0013", ""};
        r6[17] = new String[]{"\u0014", ""};
        r6[18] = new String[]{"\u0015", ""};
        r6[19] = new String[]{"\u0016", ""};
        r6[20] = new String[]{"\u0017", ""};
        r6[21] = new String[]{"\u0018", ""};
        r6[22] = new String[]{"\u0019", ""};
        r6[23] = new String[]{"\u001a", ""};
        r6[24] = new String[]{"\u001b", ""};
        r6[25] = new String[]{"\u001c", ""};
        r6[26] = new String[]{"\u001d", ""};
        r6[27] = new String[]{"\u001e", ""};
        r6[28] = new String[]{"\u001f", ""};
        r6[29] = new String[]{"￾", ""};
        r6[30] = new String[]{"￿", ""};
        r2[2] = new e(r6);
        r2[3] = f.a((int) Opcodes.NEG_FLOAT, (int) Opcodes.LONG_TO_INT);
        r2[4] = f.a((int) Opcodes.LONG_TO_DOUBLE, (int) Opcodes.REM_LONG);
        r2[5] = new g();
        a = new a(r2);
    }

    public static String a(String str) {
        return a.a(str);
    }
}
