package com.xunlei.downloadprovider.vod.audiotrack;

import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AudioTrackManager */
public final class b {
    final String a = h.b;

    public final List<a> a(c cVar) {
        List arrayList = new ArrayList();
        if (cVar != null) {
            cVar = cVar.b(402);
            if (!TextUtils.isEmpty(cVar)) {
                cVar = cVar.split(h.b);
                if (cVar != null && cVar.length > 0) {
                    for (int i = 0; i < cVar.length; i++) {
                        a aVar = new a();
                        aVar.a = i;
                        aVar.b = cVar[i];
                        aVar.c = cVar[i];
                        arrayList.add(aVar);
                    }
                    a(arrayList);
                }
            }
        }
        return arrayList;
    }

    private void a(List<a> list) {
        if (list.size() > 0) {
            d dVar = new d();
            String str = "音轨";
            int i = 0;
            for (a aVar : list) {
                Object obj = aVar.b;
                Object[] objArr = new Object[2];
                objArr[0] = str;
                i++;
                objArr[1] = Integer.valueOf(i);
                aVar.c = String.format("%s%d", objArr);
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split != null && split.length >= 2) {
                        Object obj2 = split[0];
                        obj = split[1];
                        if (!"unknown".equals(obj) && !"unkown".equals(obj)) {
                            aVar.c = String.format("%s%d - %s", new Object[]{str, Integer.valueOf(i), obj});
                        } else if (!("unknown".equals(obj2) || "unkown".equals(obj2))) {
                            if (!TextUtils.isEmpty(obj2 != null ? (String) dVar.a.get(obj2) : null)) {
                                aVar.c = String.format("%s%d - %s", new Object[]{str, Integer.valueOf(i), obj2 != null ? (String) dVar.a.get(obj2) : null});
                            }
                        }
                    }
                }
            }
            Collections.sort(list, new c(this));
        }
    }

    public static boolean a(c cVar, int i) {
        return cVar.a(403, String.format("%d", new Object[]{Integer.valueOf(i)})) == null;
    }
}
