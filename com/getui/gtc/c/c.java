package com.getui.gtc.c;

import com.getui.gtc.a.a;
import java.io.File;

public class c {
    private static c b;
    public String a;

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    c cVar = new c();
                    b = cVar;
                    cVar.a = a.f;
                }
            }
        }
        return b;
    }

    public static void a(String str, File file, b bVar) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                bVar.e = str;
                d.a.a.a(new a(bVar));
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
        }
    }
}
