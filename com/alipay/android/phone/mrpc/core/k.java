package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {
    private static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    private static class a {
        int a;
        int b;
        int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static long a(String str) {
        int b;
        int c;
        a e;
        int i;
        int i2;
        int i3;
        int i4;
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            b = b(matcher.group(1));
            c = c(matcher.group(2));
            int d = d(matcher.group(3));
            e = e(matcher.group(4));
            i = c;
            c = b;
            b = d;
        } else {
            Matcher matcher2 = b.matcher(str);
            if (matcher2.find()) {
                c = c(matcher2.group(1));
                int b2 = b(matcher2.group(2));
                a e2 = e(matcher2.group(3));
                b = d(matcher2.group(4));
                i = c;
                c = b2;
                e = e2;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (b >= 2038) {
            i2 = 0;
            i3 = 2038;
            i4 = 1;
        } else {
            i3 = b;
            i4 = c;
            i2 = i;
        }
        Time time = new Time("UTC");
        time.set(e.c, e.b, e.a, i4, i2, i3);
        return time.toMillis(false);
    }

    private static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - 48) * 10) + (str.charAt(1) - 48) : str.charAt(0) - 48;
    }

    private static int c(String str) {
        int toLowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (toLowerCase == 22) {
            return 0;
        }
        if (toLowerCase == 26) {
            return 7;
        }
        if (toLowerCase == 29) {
            return 2;
        }
        if (toLowerCase == 32) {
            return 3;
        }
        if (toLowerCase == 40) {
            return 6;
        }
        if (toLowerCase == 42) {
            return 5;
        }
        if (toLowerCase == 48) {
            return 10;
        }
        switch (toLowerCase) {
            case 9:
                return 11;
            case 10:
                return 1;
            default:
                switch (toLowerCase) {
                    case 35:
                        return 9;
                    case 36:
                        return 4;
                    case 37:
                        return 8;
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    private static int d(String str) {
        if (str.length() != 2) {
            return str.length() == 3 ? ((((str.charAt(0) - 48) * 100) + ((str.charAt(1) - 48) * 10)) + (str.charAt(2) - 48)) + 1900 : str.length() == 4 ? ((((str.charAt(0) - 48) * 1000) + ((str.charAt(1) - 48) * 100)) + ((str.charAt(2) - 48) * 10)) + (str.charAt(3) - 48) : 1970;
        } else {
            int charAt = ((str.charAt(0) - 48) * 10) + (str.charAt(1) - 48);
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        }
    }

    private static a e(String str) {
        int i;
        int charAt = str.charAt(0) - 48;
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - 48);
        } else {
            i = 1;
        }
        i++;
        int i2 = i + 1;
        int i3 = (i2 + 1) + 1;
        return new a(charAt, ((str.charAt(i) - 48) * 10) + (str.charAt(i2) - 48), ((str.charAt(i3) - 48) * 10) + (str.charAt(i3 + 1) - 48));
    }
}
