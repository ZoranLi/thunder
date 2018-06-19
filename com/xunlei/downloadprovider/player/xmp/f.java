package com.xunlei.downloadprovider.player.xmp;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/* compiled from: PlayerFrom */
public final class f {
    public static boolean a(@NonNull y yVar) {
        if (!TextUtils.isEmpty(yVar.k)) {
            yVar = yVar.k;
            int hashCode = yVar.hashCode();
            if (hashCode == -976011676) {
                if (yVar.equals("feed_ad") != null) {
                    yVar = 2;
                    switch (yVar) {
                        case null:
                        case 1:
                        case 2:
                            return true;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 174971131) {
                if (yVar.equals("splash_ad") != null) {
                    yVar = 1;
                    switch (yVar) {
                        case null:
                        case 1:
                        case 2:
                            return true;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 1440051732) {
                if (yVar.equals("homepage_ad") != null) {
                    yVar = null;
                    switch (yVar) {
                        case null:
                        case 1:
                        case 2:
                            return true;
                        default:
                            break;
                    }
                }
            }
            yVar = -1;
            switch (yVar) {
                case null:
                case 1:
                case 2:
                    return true;
                default:
                    break;
            }
        }
        return false;
    }
}
