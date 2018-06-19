package com.xunlei.downloadprovider.ad.common;

import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: ADChecker */
public final class a {
    public static boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        if (lVar.v == null) {
            new StringBuilder("wtf, model's styleInfo is null. model.positionId: ").append(lVar.A());
            return false;
        }
        switch (b.a[lVar.v.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (TextUtils.isEmpty(lVar.m()) || TextUtils.isEmpty(lVar.k()) != null) {
                    return false;
                }
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
                if (TextUtils.isEmpty(lVar.m()) || TextUtils.isEmpty(lVar.l()) != null) {
                    return false;
                }
                return true;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                if (TextUtils.isEmpty(lVar.j()) || TextUtils.isEmpty(lVar.m()) || TextUtils.isEmpty(lVar.k()) != null) {
                    return false;
                }
                return true;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                if (TextUtils.isEmpty(lVar.j()) || TextUtils.isEmpty(lVar.m()) || TextUtils.isEmpty(lVar.l()) != null) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }
}
