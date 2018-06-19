package com.xunlei.downloadprovider.ad.common.adget.c;

/* compiled from: GDTHelper */
public final class a {
    public static int a(int i) {
        int i2 = 4;
        if (i == 4) {
            i2 = 2;
        } else if (i == 8) {
            i2 = 3;
        } else if (i == 16) {
            return 1;
        } else {
            switch (i) {
                case 0:
                case 2:
                    return 1;
                case 1:
                    break;
                default:
                    return 1;
            }
        }
        return i2;
    }
}
