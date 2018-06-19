package com.xunlei.downloadprovider.vodnew.a.b;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.d;
import com.umeng.message.proguard.k;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.net.volley.BaseJsonObjectRequest;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleInfo;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.g;
import com.xunlei.downloadprovider.vod.subtitle.g.c;
import com.xunlei.downloadprovider.vod.subtitle.h;
import com.xunlei.downloadprovider.vod.subtitle.l;
import com.xunlei.downloadprovider.vod.subtitle.m;
import com.xunlei.downloadprovider.vod.subtitle.q;
import com.xunlei.downloadprovider.vodnew.a.d.b;
import com.xunlei.downloadprovider.vodnew.a.d.b.a;
import com.xunlei.downloadprovider.vodnew.a.e.aa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PlayerSubtitleDecorator */
public class j extends aa implements b {
    private static final String a = "j";
    private g b = new g(BrothersApplication.getApplicationInstance());
    private SubtitleManifest c;
    private SubtitleInfo d = null;
    private long e = -1;
    private long f = -1;
    private a g;
    private g.b h;
    private c j;

    public j(com.xunlei.downloadprovider.vodnew.a.d.c cVar) {
        super(cVar);
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a(g.b bVar) {
        this.h = bVar;
    }

    public final void a(c cVar) {
        this.j = cVar;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            g gVar = this.b;
            SubtitleManifest subtitleManifest = null;
            if (gVar.j != null && (TextUtils.equals(str, gVar.j.getRelatedGcid()) || TextUtils.equals(str2, gVar.j.getRelatedName()))) {
                subtitleManifest = gVar.j;
            }
            if (subtitleManifest == null) {
                gVar.j = gVar.a(str, str2);
                subtitleManifest = gVar.j;
            }
            if (subtitleManifest != null) {
                if (gVar.h != null) {
                    gVar.h.a(gVar.j);
                }
            } else if (!(TextUtils.isEmpty(str) && TextUtils.isEmpty(str2))) {
                Request baseJsonObjectRequest = new BaseJsonObjectRequest(0, String.format("http://api-shoulei-ssl.xunlei.com/oracle/subtitle?cid=%s", new Object[]{str}), null, new h(gVar, str, str2), new com.xunlei.downloadprovider.vod.subtitle.j(gVar));
                baseJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
                baseJsonObjectRequest.setTag(g.a);
                gVar.c.a(baseJsonObjectRequest);
            }
        }
    }

    public final void a(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.d == null) {
                    this.e = currentTimeMillis;
                } else if (TextUtils.isEmpty(this.d.getFileUrl())) {
                    this.e = currentTimeMillis;
                } else if (this.f == -1 || currentTimeMillis - this.f >= 10000) {
                    int i2 = (int) (currentTimeMillis - this.e);
                    this.e = currentTimeMillis;
                    this.f = currentTimeMillis;
                    g gVar = this.b;
                    SubtitleInfo subtitleInfo = this.d;
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (subtitleInfo != null) {
                                String baseJsonObjectRequest = new BaseJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/oracle/vote", g.a(str, str2, i, subtitleInfo, i2), new l(gVar), new m(gVar));
                                baseJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
                                baseJsonObjectRequest.setTag(g.a);
                                gVar.c.a(baseJsonObjectRequest);
                            }
                        }
                    }
                    str = new StringBuilder("发起上报  ");
                    str.append(this.d.toString());
                    str.append("    useDuration = ");
                    str.append(i2);
                } else {
                    this.e = currentTimeMillis;
                }
            }
        }
    }

    public final void a(SubtitleInfo subtitleInfo, int i) {
        this.d = subtitleInfo;
        String str = null;
        boolean z = false;
        if (subtitleInfo != null) {
            g gVar = this.b;
            if (subtitleInfo != null) {
                if (subtitleInfo.getScid() != null) {
                    File file;
                    String fileName = subtitleInfo.getFileName();
                    Object localFilePath = subtitleInfo.getLocalFilePath();
                    if (TextUtils.isEmpty(localFilePath)) {
                        file = new File(gVar.b(), fileName);
                    } else {
                        file = new File(localFilePath);
                    }
                    if (file.exists()) {
                        str = file.getAbsolutePath();
                    } else {
                        localFilePath = subtitleInfo.getFileUrl();
                        subtitleInfo.getScid();
                        if (!TextUtils.isEmpty(localFilePath)) {
                            if (g.a(BrothersApplication.getApplicationInstance())) {
                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(localFilePath));
                                request.setNotificationVisibility(2);
                                request.setVisibleInDownloadsUi(false);
                                request.setDestinationUri(Uri.fromFile(file));
                                if (gVar.f == null) {
                                    gVar.f = (DownloadManager) gVar.e.getSystemService("download");
                                }
                                gVar.e.registerReceiver(gVar.k, new IntentFilter(com.xunlei.download.DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                gVar.f.enqueue(request);
                            } else {
                                XLToast.showToast(BrothersApplication.getApplicationInstance(), BrothersApplication.getApplicationInstance().getString(R.string.system_download_service_not_enable));
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                int a = a(str, subtitleInfo.getOffset());
                if (this.g != null) {
                    a aVar = this.g;
                    if (a == 0) {
                        z = true;
                    }
                    aVar.a(z);
                }
                if (this.c != null && a == 0) {
                    if (subtitleInfo.isDownload() != null) {
                        this.c.setDefaultIndex(i);
                        this.c.setLocalDefaultIndex(-1);
                        return;
                    }
                    this.c.setDefaultIndex(-1);
                    this.c.setLocalDefaultIndex(i);
                }
            }
            return;
        }
        if (this.c != null) {
            this.c.setDefaultIndex(-1);
            this.c.setLocalDefaultIndex(-1);
        }
        a(null, 0);
    }

    private int a(String str, int i) {
        new StringBuilder("subtitle exist : ").append(e.c(str));
        if (TextUtils.isEmpty(str)) {
            str = this.i.a(503, "");
            this.i.a(509, "0");
            this.i.a(506, "0");
        } else {
            str = this.i.a(503, str);
            this.i.a(509, String.valueOf(i));
        }
        new StringBuilder("PlayerConfig set config result=>").append(str == null);
        return str;
    }

    public final int a(String str, String str2, Uri uri) {
        String name;
        Object obj;
        int lastIndexOf;
        int b;
        SubtitleInfo subtitleInfo;
        StringBuilder stringBuilder;
        int i;
        g gVar = this.b;
        if (uri != null) {
            CharSequence scheme = uri.getScheme();
            if (TextUtils.equals(scheme, "file")) {
                uri = uri.getPath();
            } else if (TextUtils.equals(scheme, "content")) {
                scheme = gVar.a(uri);
                if (TextUtils.isEmpty(scheme)) {
                    uri = gVar.b(uri);
                    if (uri != null) {
                        return -1;
                    }
                    name = uri.getName();
                    obj = "";
                    lastIndexOf = name.lastIndexOf(".");
                    if (lastIndexOf != -1 && lastIndexOf < name.length()) {
                        obj = name.substring(lastIndexOf + 1);
                        name = name.substring(0, lastIndexOf);
                    }
                    b = gVar.b(name);
                    if (b < 0) {
                        return b;
                    }
                    subtitleInfo = new SubtitleInfo();
                    stringBuilder = new StringBuilder("本地字幕(");
                    stringBuilder.append(name);
                    stringBuilder.append(k.t);
                    subtitleInfo.setDisplayName(stringBuilder.toString());
                    subtitleInfo.setFileExtension(obj);
                    subtitleInfo.setScid(name);
                    subtitleInfo.setFileUrl(null);
                    subtitleInfo.setLocalFilePath(uri.getAbsolutePath());
                    if (TextUtils.isEmpty(obj) != null) {
                        subtitleInfo.setFileName(name);
                    } else {
                        uri = new StringBuilder();
                        uri.append(name);
                        uri.append(".");
                        uri.append(obj);
                        subtitleInfo.setFileName(uri.toString());
                    }
                    if (gVar.j == null) {
                        gVar.j = new SubtitleManifest();
                        if (TextUtils.isEmpty(str) != null) {
                            gVar.j.setRelatedGcid(str);
                        } else if (TextUtils.isEmpty(str2) == null) {
                            gVar.j.setRelatedName(str2);
                        }
                    }
                    str = gVar.j.getLocalSubCount();
                    gVar.j.addSubtitleInfo(str, subtitleInfo);
                    i = str + 1;
                    gVar.j.setLocalSubCount(i);
                    subtitleInfo.setUiDisplayName(String.format("本地字幕%s(%s)", new Object[]{g.a(i), name}));
                    if (gVar.g != null) {
                        gVar.d.post(new q(gVar));
                    }
                    return i - 1;
                }
                uri = scheme;
            } else {
                uri = null;
            }
            if (!TextUtils.isEmpty(uri)) {
                uri = new File(uri);
                if (uri != null) {
                    return -1;
                }
                name = uri.getName();
                obj = "";
                lastIndexOf = name.lastIndexOf(".");
                obj = name.substring(lastIndexOf + 1);
                name = name.substring(0, lastIndexOf);
                b = gVar.b(name);
                if (b < 0) {
                    return b;
                }
                subtitleInfo = new SubtitleInfo();
                stringBuilder = new StringBuilder("本地字幕(");
                stringBuilder.append(name);
                stringBuilder.append(k.t);
                subtitleInfo.setDisplayName(stringBuilder.toString());
                subtitleInfo.setFileExtension(obj);
                subtitleInfo.setScid(name);
                subtitleInfo.setFileUrl(null);
                subtitleInfo.setLocalFilePath(uri.getAbsolutePath());
                if (TextUtils.isEmpty(obj) != null) {
                    uri = new StringBuilder();
                    uri.append(name);
                    uri.append(".");
                    uri.append(obj);
                    subtitleInfo.setFileName(uri.toString());
                } else {
                    subtitleInfo.setFileName(name);
                }
                if (gVar.j == null) {
                    gVar.j = new SubtitleManifest();
                    if (TextUtils.isEmpty(str) != null) {
                        gVar.j.setRelatedGcid(str);
                    } else if (TextUtils.isEmpty(str2) == null) {
                        gVar.j.setRelatedName(str2);
                    }
                }
                str = gVar.j.getLocalSubCount();
                gVar.j.addSubtitleInfo(str, subtitleInfo);
                i = str + 1;
                gVar.j.setLocalSubCount(i);
                subtitleInfo.setUiDisplayName(String.format("本地字幕%s(%s)", new Object[]{g.a(i), name}));
                if (gVar.g != null) {
                    gVar.d.post(new q(gVar));
                }
                return i - 1;
            }
        }
        uri = null;
        if (uri != null) {
            return -1;
        }
        name = uri.getName();
        obj = "";
        lastIndexOf = name.lastIndexOf(".");
        obj = name.substring(lastIndexOf + 1);
        name = name.substring(0, lastIndexOf);
        b = gVar.b(name);
        if (b < 0) {
            return b;
        }
        subtitleInfo = new SubtitleInfo();
        stringBuilder = new StringBuilder("本地字幕(");
        stringBuilder.append(name);
        stringBuilder.append(k.t);
        subtitleInfo.setDisplayName(stringBuilder.toString());
        subtitleInfo.setFileExtension(obj);
        subtitleInfo.setScid(name);
        subtitleInfo.setFileUrl(null);
        subtitleInfo.setLocalFilePath(uri.getAbsolutePath());
        if (TextUtils.isEmpty(obj) != null) {
            subtitleInfo.setFileName(name);
        } else {
            uri = new StringBuilder();
            uri.append(name);
            uri.append(".");
            uri.append(obj);
            subtitleInfo.setFileName(uri.toString());
        }
        if (gVar.j == null) {
            gVar.j = new SubtitleManifest();
            if (TextUtils.isEmpty(str) != null) {
                gVar.j.setRelatedGcid(str);
            } else if (TextUtils.isEmpty(str2) == null) {
                gVar.j.setRelatedName(str2);
            }
        }
        str = gVar.j.getLocalSubCount();
        gVar.j.addSubtitleInfo(str, subtitleInfo);
        i = str + 1;
        gVar.j.setLocalSubCount(i);
        subtitleInfo.setUiDisplayName(String.format("本地字幕%s(%s)", new Object[]{g.a(i), name}));
        if (gVar.g != null) {
            gVar.d.post(new q(gVar));
        }
        return i - 1;
    }

    public final void a() {
        IOException e;
        Throwable th;
        g gVar = this.b;
        if (gVar.j != null) {
            if (gVar.j.getListCount() > 0) {
                SubtitleManifest subtitleManifest = gVar.j;
                if (subtitleManifest != null) {
                    String stringBuilder;
                    File a = gVar.a();
                    StringBuilder stringBuilder2;
                    if (!TextUtils.isEmpty(subtitleManifest.getRelatedGcid())) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(subtitleManifest.getRelatedGcid());
                        stringBuilder2.append(".manifest");
                        stringBuilder = stringBuilder2.toString();
                    } else if (!TextUtils.isEmpty(subtitleManifest.getRelatedName())) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(subtitleManifest.getRelatedName());
                        stringBuilder2.append(".manifest");
                        stringBuilder = stringBuilder2.toString();
                    } else {
                        return;
                    }
                    File file = new File(a, stringBuilder);
                    if (file.exists()) {
                        file.delete();
                    }
                    List arrayList = new ArrayList();
                    arrayList.addAll(subtitleManifest.getSubtitleList());
                    int a2 = g.a(subtitleManifest);
                    if (subtitleManifest.getListCount() <= 0) {
                        subtitleManifest.setSubtitleList(arrayList);
                        subtitleManifest.setLocalSubCount(a2);
                        return;
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        file.createNewFile();
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(file));
                        try {
                            objectOutputStream2.writeObject(subtitleManifest);
                            objectOutputStream2.flush();
                            try {
                                objectOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                new StringBuilder("serializeManifestData error=>").append(e2.getMessage());
                                e2.printStackTrace();
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                subtitleManifest.setSubtitleList(arrayList);
                                subtitleManifest.setLocalSubCount(a2);
                            } catch (Throwable th2) {
                                th = th2;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e2 = e5;
                        new StringBuilder("serializeManifestData error=>").append(e2.getMessage());
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        subtitleManifest.setSubtitleList(arrayList);
                        subtitleManifest.setLocalSubCount(a2);
                    }
                    subtitleManifest.setSubtitleList(arrayList);
                    subtitleManifest.setLocalSubCount(a2);
                }
            }
        }
    }

    public final boolean a(Uri uri) {
        g gVar = this.b;
        if (uri == null) {
            return false;
        }
        CharSequence scheme = uri.getScheme();
        String str = null;
        if (TextUtils.equals(scheme, "file")) {
            str = uri.getPath();
        } else if (TextUtils.equals(scheme, "content")) {
            str = gVar.a(uri);
            if (TextUtils.isEmpty(str)) {
                str = uri.toString();
            }
        }
        if (TextUtils.isEmpty(str) != null) {
            return false;
        }
        uri = str.lastIndexOf(".");
        if (uri >= null) {
            if (uri < str.length() - 1) {
                return g.a(str.substring(uri + 1));
            }
        }
        return false;
    }
}
