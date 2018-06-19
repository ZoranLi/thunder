package com.alibaba.baichuan.android.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.b.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static final Map a = new ConcurrentHashMap();

    static class a {
        String a;
        ClassLoader b;

        a(String str, ClassLoader classLoader) {
            this.a = str;
            this.b = classLoader;
        }
    }

    public static void a(String str, Class cls) {
        if (!TextUtils.isEmpty(str)) {
            a.put(str, new a(cls.getName(), cls.getClassLoader()));
        }
    }

    public static a a(String str, Context context, d dVar) {
        a aVar = (a) a.get(str);
        if (aVar != null) {
            if (aVar.a != null) {
                String str2 = aVar.a;
                try {
                    ClassLoader classLoader = aVar.b;
                    Class cls = classLoader == null ? Class.forName(str2) : classLoader.loadClass(str2);
                    if (cls != null && a.class.isAssignableFrom(cls)) {
                        a aVar2 = (a) cls.newInstance();
                        if (aVar2.d != null) {
                            aVar2.a(context, dVar, aVar2.d);
                        } else {
                            aVar2.a(context, dVar);
                        }
                        return aVar2;
                    }
                } catch (Context context2) {
                    dVar = new StringBuilder("create plugin error: ");
                    dVar.append(str);
                    dVar.append(". ");
                    dVar.append(context2.getMessage());
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                }
                AlibcContext.b();
                return null;
            }
        }
        return null;
    }
}
