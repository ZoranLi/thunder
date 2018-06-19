package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.a;
import com.tencent.bugly.beta.download.b;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class f {
    public static f a = new f();
    final Map<String, DownloadTask> b = Collections.synchronizedMap(new HashMap());
    Handler c = new Handler(Looper.getMainLooper());
    private List<Runnable> d = new ArrayList();

    public synchronized void a(Runnable runnable, int i) {
        if (this.b.size() == 0) {
            runnable.run();
            return;
        }
        Runnable dVar = new d(6, Boolean.valueOf(false), runnable);
        this.c.postDelayed(dVar, (long) i);
        a(dVar);
    }

    public synchronized void a(Runnable runnable) {
        if (this.b.size() == 0) {
            runnable.run();
        } else {
            this.d.add(runnable);
        }
    }

    public void a(b bVar, Map<String, String> map) {
        if (bVar != null) {
            if (map != null) {
                if (!map.isEmpty()) {
                    for (DownloadTask delete : this.b.values()) {
                        delete.delete(true);
                    }
                    this.b.clear();
                    DownloadListener aVar = new a(1, this, this.b);
                    String[] strArr = ResBean.b;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str = strArr[i];
                        if (map.containsKey(str)) {
                            String str2 = (String) map.get(str);
                            if (str.startsWith("IMG_")) {
                                if (!TextUtils.isEmpty(str2)) {
                                    ResBean.a.a(str, "");
                                    for (DownloadTask downloadTask : this.b.values()) {
                                        if (downloadTask.getDownloadUrl().equals(str2)) {
                                            break;
                                        }
                                    }
                                    DownloadTask downloadTask2 = null;
                                    if (downloadTask2 == null) {
                                        downloadTask2 = bVar.a(str2, e.E.r.getAbsolutePath(), null, null);
                                    }
                                    if (downloadTask2 != null) {
                                        downloadTask2.addListener(aVar);
                                        downloadTask2.setNeededNotify(false);
                                        this.b.put(str, downloadTask2);
                                    }
                                    i++;
                                }
                            }
                            ResBean.a.a(str, str2);
                            i++;
                        } else {
                            this.b.clear();
                            ResBean.a = new ResBean();
                            a.a("rb.bch", ResBean.a);
                            return;
                        }
                    }
                    a.a("rb.bch", ResBean.a);
                    if (this.b.isEmpty() == null) {
                        for (DownloadTask download : this.b.values()) {
                            download.download();
                        }
                    }
                    return;
                }
            }
            this.b.clear();
            ResBean.a = new ResBean();
            a.a("rb.bch", ResBean.a);
        }
    }

    public void a() {
        List<String> arrayList = new ArrayList();
        for (String str : ResBean.b) {
            CharSequence a = ResBean.a.a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(a)) {
                arrayList.add(a);
            }
        }
        File[] listFiles = e.E.r.listFiles();
        if (listFiles != null) {
            if (listFiles.length > 0) {
                for (File file : listFiles) {
                    int i = 1;
                    for (String equals : arrayList) {
                        if (file.getAbsolutePath().equals(equals)) {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        p.a.b(file.getAbsolutePath());
                        if (!file.delete()) {
                            an.e("cannot deleteCache file:%s", file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            for (Runnable run : this.d) {
                run.run();
            }
            for (DownloadTask delete : this.b.values()) {
                delete.delete(false);
            }
            this.d.clear();
            this.b.clear();
        }
    }
}
