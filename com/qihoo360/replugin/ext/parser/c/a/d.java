package com.qihoo360.replugin.ext.parser.c.a;

/* compiled from: EntityArrays */
public final class d {
    private static final String[][] a;
    private static final String[][] b;

    static {
        r0 = new String[4][];
        r0[0] = new String[]{"\"", "&quot;"};
        r0[1] = new String[]{"&", "&amp;"};
        r0[2] = new String[]{"<", "&lt;"};
        r0[3] = new String[]{">", "&gt;"};
        a = r0;
        r0 = new String[1][];
        r0[0] = new String[]{"'", "&apos;"};
        b = r0;
    }

    public static String[][] a() {
        return (String[][]) a.clone();
    }

    public static String[][] b() {
        return (String[][]) b.clone();
    }
}
