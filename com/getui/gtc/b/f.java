package com.getui.gtc.b;

import com.getui.gtc.e.e;
import com.getui.gtc.e.h;
import com.getui.gtc.e.j;
import com.getui.gtc.entity.a.a;
import com.getui.gtc.entity.a.b;
import com.getui.gtc.entity.d;
import java.io.File;
import java.io.IOException;
import java.util.List;

final class f implements b {
    final /* synthetic */ d a;
    final /* synthetic */ List b;
    final /* synthetic */ boolean[] c;
    final /* synthetic */ c d;

    f(c cVar, d dVar, List list, boolean[] zArr) {
        this.d = cVar;
        this.a = dVar;
        this.b = list;
        this.c = zArr;
    }

    public final void a(int i, a aVar) {
        boolean z;
        a aVar2 = aVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.b);
        stringBuilder.append(File.separator);
        stringBuilder.append(aVar2.c);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        boolean a;
        if (!file.exists() || file.isDirectory()) {
            z = true;
            if (r1.d.c != null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(r1.d.c);
                stringBuilder3.append(File.separator);
                stringBuilder3.append(aVar2.c);
                File file2 = new File(stringBuilder3.toString());
                if (file2.exists() && aVar2.e.equals(j.b(file2.getAbsolutePath()))) {
                    boolean createNewFile;
                    try {
                        createNewFile = file.createNewFile();
                    } catch (IOException e) {
                        new String[z][0] = e.toString();
                        createNewFile = false;
                    }
                    if (createNewFile) {
                        if (e.a(file2, file, aVar2.e)) {
                            a = r1.d.a(r1.d.a, stringBuilder2, aVar2.d, aVar2.f, aVar2.c, r1.d.d, r1.a, aVar2.e);
                            if (!aVar2.j) {
                                if (a && aVar2.g == 0) {
                                    aVar2.g = System.currentTimeMillis();
                                    r1.c[0] = z;
                                }
                                return;
                            }
                        } else {
                            e.a(aVar2.c);
                        }
                    }
                }
                if (h.a(r1.d.a)) {
                    c.a(r1.d, r1.a, aVar2);
                }
            }
            return;
        }
        int i2;
        if (aVar2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2.h == 0 || currentTimeMillis < aVar2.g + aVar2.h) {
                i2 = 1;
                if (i2 != 0) {
                    z = true;
                    a = r1.d.a(r1.d.a, stringBuilder2, aVar2.d, aVar2.f, aVar2.c, r1.d.d, r1.a, aVar2.e);
                    if (!aVar2.j) {
                        if (a && aVar2.g != 0) {
                            aVar2.g = System.currentTimeMillis();
                            r1.c[0] = z;
                        }
                        return;
                    }
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            z = true;
            a = r1.d.a(r1.d.a, stringBuilder2, aVar2.d, aVar2.f, aVar2.c, r1.d.d, r1.a, aVar2.e);
            if (aVar2.j) {
                aVar2.g = System.currentTimeMillis();
                r1.c[0] = z;
                return;
            }
        }
        e.a(aVar2.c);
        r1.b.add(Integer.valueOf(i));
    }
}
