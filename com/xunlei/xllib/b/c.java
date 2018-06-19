package com.xunlei.xllib.b;

/* compiled from: ChineseNumberUtil */
public final class c {
    private static a a = new a();

    /* compiled from: ChineseNumberUtil */
    static class a {
        private static final char[] c = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
        private static final char[] d = new char[]{'十', '百', '千', '万', '亿', '兆', '京'};
        private static final char[] e = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
        private static final char[] f = new char[]{'拾', '佰', '仟', '万', '亿', '兆', '京'};
        final char[] a = c;
        final char[] b = d;

        final String a(int i) {
            a aVar = this;
            int i2 = i;
            String str = "";
            if (i2 < 0) {
                i2 = -i2;
            }
            i2 %= 10000;
            String valueOf = String.valueOf(aVar.b[0]);
            String valueOf2 = String.valueOf(aVar.b[1]);
            String valueOf3 = String.valueOf(aVar.b[2]);
            char[] cArr = aVar.a;
            String valueOf4 = String.valueOf(cArr[0]);
            if (i2 < 10) {
                return String.valueOf(cArr[i2]);
            }
            if (i2 < 100) {
                int i3 = (i2 / 10) % 10;
                if (i3 == 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(valueOf);
                    str = stringBuilder.toString();
                } else if (i3 > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(String.valueOf(cArr[i3]));
                    stringBuilder2.append(valueOf);
                    str = stringBuilder2.toString();
                }
                i2 %= 10;
                if (i2 > 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(String.valueOf(cArr[i2]));
                    str = stringBuilder3.toString();
                }
                return str;
            }
            int[] iArr = new int[4];
            int i4 = i2;
            for (int i5 = 3; i5 >= 0; i5--) {
                iArr[i5] = i4 % 10;
                i4 /= 10;
            }
            if (iArr[0] > 0) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str);
                stringBuilder4.append(String.valueOf(cArr[iArr[0]]));
                stringBuilder4.append(valueOf3);
                str = stringBuilder4.toString();
            }
            i2 %= 1000;
            if (i2 == 0) {
                return str;
            }
            if (i2 < 100) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(valueOf4);
                str = stringBuilder.toString();
            }
            if (iArr[1] > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(String.valueOf(cArr[iArr[1]]));
                stringBuilder.append(valueOf2);
                str = stringBuilder.toString();
            }
            i2 %= 100;
            if (i2 == 0) {
                return str;
            }
            String stringBuilder5;
            StringBuilder stringBuilder6;
            if (i2 < 10) {
                if (iArr[1] > 0) {
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(str);
                    stringBuilder6.append(valueOf4);
                    str = stringBuilder6.toString();
                }
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append(str);
                stringBuilder6.append(String.valueOf(cArr[iArr[3]]));
                stringBuilder5 = stringBuilder6.toString();
            } else {
                if (iArr[2] > 0) {
                    stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(str);
                    stringBuilder6.append(String.valueOf(cArr[iArr[2]]));
                    stringBuilder6.append(valueOf);
                    str = stringBuilder6.toString();
                }
                stringBuilder5 = str;
                if (iArr[3] > 0) {
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(stringBuilder5);
                    stringBuilder7.append(String.valueOf(cArr[iArr[3]]));
                    stringBuilder5 = stringBuilder7.toString();
                }
            }
            return stringBuilder5;
        }
    }

    public static String a(int i) {
        a aVar = a;
        StringBuilder stringBuilder = new StringBuilder();
        if (i < 0) {
            i = -i;
            stringBuilder.append("负");
        }
        if (i < 10000) {
            return aVar.a(i);
        }
        int i2 = i % 10000;
        i /= 10000;
        int i3 = i % 10000;
        i = (i / 10000) % 10000;
        String valueOf = String.valueOf(aVar.a[0]);
        String valueOf2 = String.valueOf(aVar.b[4]);
        String valueOf3 = String.valueOf(aVar.b[3]);
        if (i > 0) {
            stringBuilder.append(aVar.a(i));
            stringBuilder.append(valueOf2);
        }
        if (!(i3 == 0 && i == 0)) {
            if (i3 > 0) {
                if (i3 < 1000 && i > 0) {
                    stringBuilder.append(valueOf);
                }
                stringBuilder.append(aVar.a(i3));
                stringBuilder.append(valueOf3);
            } else if (i > 0) {
                stringBuilder.append(valueOf);
            }
            if (i2 > 0) {
                if (i2 < 1000 && i > 0) {
                    stringBuilder.append(valueOf);
                }
                stringBuilder.append(aVar.a(i2));
            }
        }
        return stringBuilder.toString();
    }
}
