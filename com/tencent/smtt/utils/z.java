package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class z {
    private b a = null;
    private b b = null;

    class a {
        final /* synthetic */ z a;
        private String b;
        private long c;
        private long d;

        a(z zVar, String str, long j, long j2) {
            this.a = zVar;
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        long a() {
            return this.c;
        }

        long b() {
            return this.d;
        }
    }

    class b {
        final /* synthetic */ z a;
        private Map<String, a> b = new HashMap();

        b(z zVar, File file) {
            this.a = zVar;
            this.b.clear();
            a(file);
        }

        private void a(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File a : listFiles) {
                    a(a);
                }
                return;
            }
            if (file.isFile()) {
                a(file.getName(), file.length(), file.lastModified());
            }
        }

        private void a(String str, long j, long j2) {
            if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
                a aVar = new a(this.a, str, j, j2);
                if (!this.b.containsKey(str)) {
                    this.b.put(str, aVar);
                }
            }
        }

        Map<String, a> a() {
            return this.b;
        }
    }

    private boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            return false;
        }
        Map a = bVar.a();
        Map a2 = bVar2.a();
        for (Entry entry : a.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (a2.containsKey(str)) {
                a aVar2 = (a) a2.get(str);
                if (aVar.a() == aVar2.a()) {
                    if (aVar.b() != aVar2.b()) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void a(File file) {
        this.a = new b(this, file);
    }

    public boolean a() {
        return this.b != null && this.a != null && this.b.a().size() == this.a.a().size() && a(this.a, this.b);
    }

    public void b(File file) {
        this.b = new b(this, file);
    }
}
