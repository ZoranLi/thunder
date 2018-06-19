package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.VipExtra;

/* compiled from: TaskCommentVipConstants */
public final class ay {
    public static final int[] a = new int[]{R.drawable.ic_vip_1, R.drawable.ic_vip_2, R.drawable.ic_vip_3, R.drawable.ic_vip_4, R.drawable.ic_vip_5, R.drawable.ic_vip_6, R.drawable.ic_vip_7};
    private static final int[] b = new int[]{R.drawable.ic_svip_1, R.drawable.ic_svip_2, R.drawable.ic_svip_3, R.drawable.ic_svip_4, R.drawable.ic_svip_5, R.drawable.ic_svip_6, R.drawable.ic_svip_7};

    private static int a(int i, @NonNull int[] iArr) {
        if (i > 0) {
            if (i <= iArr.length) {
                return iArr[i - 1];
            }
        }
        return 0;
    }

    public static int a(VipExtra vipExtra) {
        int i = 1;
        int i2 = (vipExtra.a && vipExtra.d == 5) ? 1 : 0;
        if (i2 != 0) {
            return a(vipExtra.b, b);
        }
        if (!vipExtra.a || vipExtra.c != 2) {
            i = 0;
        }
        if (i != 0) {
            return a(vipExtra.b, a);
        }
        return 0;
    }
}
