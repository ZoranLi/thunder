package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.d.a;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.a.b;
import com.baidu.mobads.openad.a.c;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class d implements IOAdDownloaderManager {
    private static d b;
    protected Context a;
    private HashMap<String, IOAdDownloader> c = new HashMap();
    private c d;
    private AtomicBoolean e = new AtomicBoolean(false);

    protected d(Context context) {
        this.a = context;
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
        return Boolean.valueOf(true);
    }

    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.c) {
            iOAdDownloader = (IOAdDownloader) this.c.get(str);
        }
        return iOAdDownloader;
    }

    public void a(String str, IOAdDownloader iOAdDownloader) {
        synchronized (this.c) {
            this.c.put(str, iOAdDownloader);
        }
    }

    public void removeAllAdsApkDownloaderes() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IOAdDownloader> arrayList;
        synchronized (this.c) {
            Collection<IOAdDownloader> values = this.c.values();
            if (values.size() > 0) {
                arrayList = new ArrayList();
                for (IOAdDownloader add : values) {
                    arrayList.add(add);
                }
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }

    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        IOAdDownloader aVar;
        aVar = new a(this.a, url, str, str2, i, str3, str4);
        a(str4, aVar);
        try {
            if (this.d == null) {
                this.d = new c(this.a);
                this.d.a(new b(this.d));
                this.d.addEventListener("network_changed", new e(this));
                this.d.a();
            }
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
        }
        return aVar;
    }

    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new f(this.a, url, str, str2, z);
    }

    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return new a(this.a, url, str, str2);
    }

    public void resumeUndownloadedAfterRestartApp(long j) {
        if (!this.e.getAndSet(true)) {
            j = com.baidu.mobads.command.a.a(this.a, j);
            if (j != null && j.size() > 0) {
                int i = 0;
                while (i < j.size()) {
                    try {
                        StringBuilder stringBuilder;
                        String str = (String) j.get(i);
                        if (b.a(str) == null) {
                            if (getAdsApkDownloader(str) == null) {
                                com.baidu.mobads.command.a a = com.baidu.mobads.command.a.a(this.a, str);
                                if (a == null) {
                                    stringBuilder = new StringBuilder("pack[");
                                    stringBuilder.append(str);
                                    stringBuilder.append("] has no local data, continue");
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", stringBuilder.toString());
                                } else {
                                    IOAdDownloader createAdsApkDownloader = createAdsApkDownloader(new URL(a.j), a.c, a.b, 1, a.a, a.i);
                                    createAdsApkDownloader.addObserver(new b(this.a, a));
                                    createAdsApkDownloader.start();
                                }
                                i++;
                            }
                        }
                        stringBuilder = new StringBuilder("pack[");
                        stringBuilder.append(str);
                        stringBuilder.append("] has been stated before, continue");
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", stringBuilder.toString());
                        i++;
                    } catch (Throwable e) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
                    }
                }
            }
        }
    }
}
