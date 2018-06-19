package com.xunlei.downloadprovider.ad.a;

/* compiled from: DownloadCenterADHelper */
public final class d {
    public static boolean a(int i) {
        if (!(i == 0 || i == 1)) {
            if (i != 2) {
                return false;
            }
        }
        return true;
    }

    public static int b(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                StringBuilder stringBuilder = new StringBuilder("this pageIndex can not be convert to downloadCenterADIndex. pageIndex: ");
                stringBuilder.append(i);
                stringBuilder.append(", you should check with method isThisPageIndexHasAD() first.");
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
