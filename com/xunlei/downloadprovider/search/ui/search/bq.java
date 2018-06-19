package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.d.d;
import java.util.List;
import java.util.Random;

/* compiled from: SearchWordHelper */
public class bq {
    public static boolean b = false;
    private static bq c;
    public String a = "";
    private List<String> d;

    private bq() {
    }

    public static bq a() {
        if (c == null) {
            synchronized (bq.class) {
                if (c == null) {
                    c = new bq();
                }
            }
        }
        return c;
    }

    public final List<String> b() {
        this.d = d.a().m.a();
        return this.d;
    }

    public final void a(String str) {
        if (this.d == null || this.d.size() == 0) {
            b();
        }
        if (this.d != null) {
            if (this.d.size() != 0) {
                if (this.d.size() == 1) {
                    this.a = (String) this.d.get(0);
                    return;
                }
                b = true;
                Random random = new Random(System.currentTimeMillis());
                String str2 = (String) this.d.get(random.nextInt(this.d.size()));
                while (str2.equals(str)) {
                    str2 = (String) this.d.get(random.nextInt(this.d.size()));
                }
                this.a = str2;
                return;
            }
        }
        this.a = "搜索或输入网址";
    }
}
