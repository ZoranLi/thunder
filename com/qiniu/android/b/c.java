package com.qiniu.android.b;

import com.qiniu.android.b.d.a;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FixedZone */
public final class c extends d {
    public static final d a = new c(new String[]{"upload.qiniup.com", "upload-nb.qiniup.com", "upload-xs.qiniup.com", "up.qiniup.com", "up-nb.qiniup.com", "up-xs.qiniup.com", "upload.qbox.me", "up.qbox.me"});
    public static final d b = new c(new String[]{"upload-z1.qiniup.com", "up-z1.qiniup.com", "upload-z1.qbox.me", "up-z1.qbox.me"});
    public static final d c = new c(new String[]{"upload-z2.qiniup.com", "upload-gz.qiniup.com", "upload-fs.qiniup.com", "up-z2.qiniup.com", "up-gz.qiniup.com", "up-fs.qiniup.com", "upload-z2.qbox.me", "up-z2.qbox.me"});
    public static final d d = new c(new String[]{"upload-na0.qiniu.com", "up-na0.qiniup.com", "upload-na0.qbox.me", "up-na0.qbox.me"});
    private e e;

    private c(String[] strArr) {
        List arrayList = new ArrayList();
        Map concurrentHashMap = new ConcurrentHashMap();
        for (Object obj : strArr) {
            arrayList.add(obj);
            concurrentHashMap.put(obj, Long.valueOf(0));
        }
        this.e = new e(0, arrayList, concurrentHashMap);
    }

    public final synchronized String a(String str, boolean z, String str2) {
        str = a((e) this.e, z, str2);
        for (Entry entry : this.e.b.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(", ");
            stringBuilder.append(entry.getValue());
        }
        return str;
    }

    public final void a(String str, a aVar) {
        aVar.a();
    }

    public final synchronized void a(String str) {
        if (str != null) {
            this.e.a(URI.create(str).getHost());
        }
    }
}
