package com.xunlei.downloadprovider.launch.d;

import android.text.TextUtils;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.R;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ThunderConfig */
public class a {
    private static final String a = "a";
    private static final Set<String> b;

    static {
        Set hashSet = new HashSet();
        b = hashSet;
        hashSet.add("0x10800022");
        b.add("0x10800012");
        b.add("0x10800028");
        b.add("0x10800009");
        b.add("0x10810179");
        b.add("0x10810180");
        b.add("0x10800011");
        b.add("0x10800066");
        b.add("0x10810207");
        b.add("0x10800037");
        b.add("0x10810338");
        b.add("0x10810355");
        b.add("0x10810356");
        b.add("0x10810360");
        b.add("0x10800002");
        b.add("0x10810573");
        b.add("0x10810393");
    }

    public static boolean a() {
        return b.contains(AndroidConfig.getPartnerId());
    }

    public static int b() {
        String partnerId = AndroidConfig.getPartnerId();
        if (TextUtils.isEmpty(partnerId)) {
            return -1;
        }
        int i;
        int hashCode = partnerId.hashCode();
        if (hashCode != 2103986216) {
            if (hashCode == 2103986241) {
                if (partnerId.equals("0x10800013")) {
                    i = 1;
                    switch (i) {
                        case 0:
                            return R.drawable.loading_anzhi;
                        case 1:
                            return R.drawable.loading_360;
                        default:
                            return -1;
                    }
                }
            }
        } else if (partnerId.equals("0x10800009")) {
            i = 0;
            switch (i) {
                case 0:
                    return R.drawable.loading_anzhi;
                case 1:
                    return R.drawable.loading_360;
                default:
                    return -1;
            }
        }
        i = -1;
        switch (i) {
            case 0:
                return R.drawable.loading_anzhi;
            case 1:
                return R.drawable.loading_360;
            default:
                return -1;
        }
    }
}
