package com.qiniu.android.b;

import java.net.URI;

/* compiled from: Zone */
public abstract class d {

    /* compiled from: Zone */
    public interface a {
        void a();

        void a(int i);
    }

    public abstract String a(String str, boolean z, String str2);

    public abstract void a(String str);

    public abstract void a(String str, a aVar);

    protected final synchronized String a(e eVar, boolean z, String str) {
        String str2;
        Object obj;
        if (str != null) {
            eVar.a(URI.create(str).getHost());
        }
        int i = 0;
        while (true) {
            str2 = null;
            if (i >= eVar.a.size()) {
                break;
            }
            obj = (String) eVar.a.get(i);
            long longValue = ((Long) eVar.b.get(obj)).longValue();
            if (longValue == 0) {
                break;
            } else if (longValue <= System.currentTimeMillis() / 1000) {
                break;
            } else {
                i++;
            }
        }
        obj = null;
        if (obj != null) {
            eVar.b.put(obj, Long.valueOf(0));
        } else {
            for (String put : eVar.a) {
                eVar.b.put(put, Long.valueOf(0));
            }
            if (eVar.a.size() > 0) {
                obj = (String) eVar.a.get(0);
            }
        }
        if (obj != null) {
            if (z) {
                str2 = String.format("https://%s", new Object[]{obj});
            } else {
                str2 = String.format("http://%s", new Object[]{obj});
            }
        }
        return str2;
    }
}
