package com.xunlei.downloadprovider.ad.d.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ShortMovieDetailAdReportManager */
public final class a {
    private static a b;
    public Map<Integer, Boolean> a;

    private a() {
        this.a = null;
        this.a = new HashMap();
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public static void b() {
        b = null;
    }

    public static int a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1306084975) {
            if (hashCode == 93997959) {
                if (str.equals("brand") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            return 0;
                        case 1:
                            return 2;
                        default:
                            return -1;
                    }
                }
            }
        } else if (str.equals("effect") != null) {
            str = true;
            switch (str) {
                case null:
                    return 0;
                case 1:
                    return 2;
                default:
                    return -1;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return 0;
            case 1:
                return 2;
            default:
                return -1;
        }
    }

    public final void a(int i) {
        this.a.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public final boolean b(int i) {
        Boolean bool = (Boolean) this.a.get(Integer.valueOf(i));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
