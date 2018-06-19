package com.alibaba.fastjson.b;

/* compiled from: Type */
public final class h {
    public static final h a = new h(0, null, 1443168256, 1);
    public static final h b = new h(1, null, 1509950721, 1);
    public static final h c = new h(2, null, 1124075009, 1);
    public static final h d = new h(3, null, 1107297537, 1);
    public static final h e = new h(4, null, 1392510721, 1);
    public static final h f = new h(5, null, 1224736769, 1);
    public static final h g = new h(6, null, 1174536705, 1);
    public static final h h = new h(7, null, 1241579778, 1);
    public static final h i = new h(8, null, 1141048066, 1);
    protected final int j;
    final char[] k;
    final int l;
    final int m;

    private h(int i, char[] cArr, int i2, int i3) {
        this.j = i;
        this.k = cArr;
        this.l = i2;
        this.m = i3;
    }

    public static h a(String str) {
        str = str.toCharArray();
        int i;
        switch (str[0]) {
            case 'B':
                return d;
            case 'C':
                return c;
            case 'D':
                return i;
            case 'F':
                return g;
            case 'I':
                return f;
            case 'J':
                return h;
            case 'S':
                return e;
            case 'V':
                return a;
            case 'Z':
                return b;
            case '[':
                i = 1;
                while (true) {
                    int i2 = 0 + i;
                    if (str[i2] == '[') {
                        i++;
                    } else {
                        if (str[i2] == 'L') {
                            i++;
                            while (str[0 + i] != ';') {
                                i++;
                            }
                        }
                        return new h(9, str, 0, i + 1);
                    }
                }
            default:
                i = 1;
                while (str[0 + i] != ';') {
                    i++;
                }
                return new h(10, str, 1, i - 1);
        }
    }

    public static int b(String str) {
        int i;
        int i2 = 1;
        int i3 = 1;
        int i4 = i3;
        while (true) {
            i = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == ')') {
                break;
            } else if (charAt == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                if (charAt != 'D') {
                    if (charAt != 'J') {
                        i4++;
                        i3 = i;
                    }
                }
                i4 += 2;
                i3 = i;
            }
        }
        str = str.charAt(i);
        i4 <<= 2;
        if (str == 86) {
            i2 = 0;
        } else if (str == 68 || str == 74) {
            i2 = 2;
        }
        return i4 | i2;
    }
}
