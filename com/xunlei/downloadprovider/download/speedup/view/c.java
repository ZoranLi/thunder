package com.xunlei.downloadprovider.download.speedup.view;

import com.alipay.sdk.util.h;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProgressCache */
public final class c {
    private static HashMap<String, ArrayList<Float>> a = new HashMap();

    public static ArrayList<Float> a(String str) {
        ArrayList<Float> arrayList = (ArrayList) a.get(str);
        if (arrayList != null) {
            return arrayList;
        }
        arrayList = new ArrayList();
        a.put(str, arrayList);
        return arrayList;
    }

    public static ArrayList<Float> b(String str) {
        return (ArrayList) a.remove(str);
    }

    public static String c(String str) {
        ArrayList arrayList = (ArrayList) a.get(str);
        StringBuilder stringBuilder = new StringBuilder();
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(arrayList.get(i));
                stringBuilder.append(h.b);
            }
        }
        return stringBuilder.toString();
    }
}
