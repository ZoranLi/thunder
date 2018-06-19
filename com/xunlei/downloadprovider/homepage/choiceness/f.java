package com.xunlei.downloadprovider.homepage.choiceness;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.launch.b.a;
import java.util.ArrayList;

/* compiled from: ChoicenessLiveExposureHelper */
public final class f {
    private static ArrayList<String> a = new ArrayList();

    public static void a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!a.contains(str)) {
                    stringBuilder.append(str);
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    a.add(str);
                }
            }
        }
        if (stringBuilder.toString().length() > null) {
            a.a().reportedExposureCards(null, stringBuilder.toString());
        }
    }
}
