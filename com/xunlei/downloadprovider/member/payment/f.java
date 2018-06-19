package com.xunlei.downloadprovider.member.payment;

import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: PaySourceHelper */
public final class f {
    public static String a(PayFrom payFrom) {
        if (payFrom == null) {
            return "v_an_shoulei_hytq_normal";
        }
        switch (g.a[payFrom.ordinal()]) {
            case 1:
                return "v_an_shoulei_hyzx_kt_ico";
            case 2:
                return "v_an_shoulei_hytq_dlcenter_kthy";
            case 3:
                return "v_an_shoulei_hytq_msion_detail";
            case 4:
                return "v_an_shoulei_hytq_kt_ds";
            case 5:
            case 6:
                return "v_an_shoulei_ggong_grzx_fast";
            case 7:
                return "v_an_shoulei_ggong_vip";
            case 8:
                return "v_an_shoulei_push_grzx";
            case 9:
                return "v_an_shoulei_hytq_noti";
            case 10:
                Object obj = 1;
                if (j.a().c() == null || j.a().d() <= 1) {
                    obj = null;
                }
                return obj != null ? "v_an_shoulei_ggong_tx_xf" : "v_an_shoulei_ggong_tx_kt";
            case 11:
                return "v_an_shoulei_push_bfjl";
            case 12:
                return "v_an_shoulei_push_xzzx";
            case 13:
                return "v_an_shoulei_hytq_kn_h5";
            case 14:
                return "v_an_shoulei_hytq_kn_popup";
            case 15:
                return "v_an_shoulei_hytq_tasklimit";
            case 16:
                return "v_an_shoulei_push_xz_ec";
            case 17:
                return "v_an_shoulei_hytq_prispace";
            case 18:
                return "v_an_shoulei_hytq_cjjs_try_kthy";
            case 19:
                return "v_an_shoulei_hytq_bxbb_endqp";
            case 20:
                return "v_an_shoulei_push_sy";
            case 21:
                return "v_an_shoulei_hytq_lx_off_dl";
            case 22:
                return "v_an_shoulei_hytq_bs";
            default:
                return "v_an_shoulei_hytq_normal";
        }
    }
}
