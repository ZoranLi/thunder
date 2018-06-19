package com.xunlei.downloadprovider.download.util.a.a;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.xunlei.downloadprovider.download.engine.kernel.i;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SnapshotDataFetcher */
final class d implements DataFetcher<InputStream> {
    private static ConcurrentHashMap<String, Object> j = new ConcurrentHashMap();
    private String a;
    private String b;
    private long c;
    private File d;
    private InputStream e;
    private boolean f = false;
    private int g;
    private int h;
    private e i;

    public final /* synthetic */ Object loadData(Priority priority) throws Exception {
        return a();
    }

    d(String str, int i, int i2, e eVar) {
        this.b = str;
        this.a = a(str);
        this.c = 120000;
        this.d = c.a();
        this.g = i;
        this.h = i2;
        this.i = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream a() throws java.lang.Exception {
        /*
        r12 = this;
        r0 = r12.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r0 = r12.e;
        return r0;
    L_0x000b:
        r0 = "_full.jpg";
        r1 = r12.b;
        r1 = a(r1);
        r2 = r12.d;
        r1 = r1.getBytes();
        r1 = com.xunlei.xllib.b.g.a(r1);
        r3 = new java.io.File;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r1);
        r4.append(r0);
        r0 = r4.toString();
        r3.<init>(r2, r0);
        r0 = r3.exists();
        if (r0 == 0) goto L_0x0041;
    L_0x0037:
        r0 = new java.io.FileInputStream;
        r0.<init>(r3);
        r12.e = r0;
        r0 = r12.e;
        return r0;
    L_0x0041:
        r0 = r12.i;
        if (r0 == 0) goto L_0x00dc;
    L_0x0045:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r12.i;
        r4 = r2.a;
        if (r4 == 0) goto L_0x0054;
    L_0x004f:
        r2 = r2.a;
        r4 = r2.mSnapshotCheckLMT;
        goto L_0x0056;
    L_0x0054:
        r4 = 0;
    L_0x0056:
        r6 = r0 - r4;
        r0 = r12.i;
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r4 = r0.b;
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r5 = 16;
        r10 = 4;
        r11 = 1;
        if (r4 == 0) goto L_0x0073;
    L_0x0066:
        r0 = r0.b;
        r0 = r0.mTaskStatus;
        if (r0 == r11) goto L_0x0071;
    L_0x006c:
        if (r0 == r10) goto L_0x0071;
    L_0x006e:
        if (r0 == r5) goto L_0x0071;
    L_0x0070:
        goto L_0x0083;
    L_0x0071:
        r1 = r8;
        goto L_0x0083;
    L_0x0073:
        r4 = r0.a;
        if (r4 == 0) goto L_0x0083;
    L_0x0077:
        r0 = r0.a;
        r0 = r0.getTaskStatus();
        if (r0 == r11) goto L_0x0071;
    L_0x007f:
        if (r0 == r10) goto L_0x0071;
    L_0x0081:
        if (r0 == r5) goto L_0x0071;
    L_0x0083:
        r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x008a;
    L_0x0087:
        r0 = r12.e;
        return r0;
    L_0x008a:
        r0 = r12.i;
        r1 = r0.b;
        r2 = 8;
        if (r1 == 0) goto L_0x00b2;
    L_0x0092:
        r1 = r0.b;
        r1 = r1.mTaskStatus;
        if (r1 == r2) goto L_0x00d7;
    L_0x0098:
        r1 = r0.b;
        r1 = r1.mDownloadedSize;
        r4 = r0.b;
        r4 = r4.mFileSize;
        r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r6 < 0) goto L_0x00a5;
    L_0x00a4:
        goto L_0x00d7;
    L_0x00a5:
        r1 = r0.b;
        r1 = r1.mDownloadedSize;
        r0 = r0.b;
        r4 = r0.mFileSize;
        r11 = com.xunlei.downloadprovider.download.util.a.a.e.a(r1, r4);
        goto L_0x00d7;
    L_0x00b2:
        r1 = r0.a;
        if (r1 == 0) goto L_0x00d7;
    L_0x00b6:
        r1 = r0.a;
        r1 = r1.getTaskStatus();
        if (r1 == r2) goto L_0x00d7;
    L_0x00be:
        r1 = r0.a;
        r1 = r1.mDownloadedSize;
        r4 = r0.a;
        r4 = r4.mFileSize;
        r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r6 < 0) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00d7;
    L_0x00cb:
        r1 = r0.a;
        r1 = r1.mDownloadedSize;
        r0 = r0.a;
        r4 = r0.mFileSize;
        r11 = com.xunlei.downloadprovider.download.util.a.a.e.a(r1, r4);
    L_0x00d7:
        if (r11 != 0) goto L_0x00dc;
    L_0x00d9:
        r0 = r12.e;
        return r0;
    L_0x00dc:
        r0 = j;
        r1 = r12.a;
        r0 = r0.containsKey(r1);
        if (r0 == 0) goto L_0x0127;
    L_0x00e6:
        r0 = new java.lang.StringBuilder;
        r1 = "Wait Snapshot for ";
        r0.<init>(r1);
        r1 = r12.a;
        r0.append(r1);
        r1 = " object: ";
        r0.append(r1);
        r0.append(r12);
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r0);
        r0 = new java.lang.StringBuilder;
        r1 = "Leave Snapshot for ";
        r0.<init>(r1);
        r1 = r12.a;
        r0.append(r1);
        r1 = " object: ";
        r0.append(r1);
        r0.append(r12);
        r0 = r12.f;
        if (r0 != 0) goto L_0x0124;
    L_0x0117:
        r0 = r3.exists();
        if (r0 == 0) goto L_0x0124;
    L_0x011d:
        r0 = new java.io.FileInputStream;
        r0.<init>(r3);
        r12.e = r0;
    L_0x0124:
        r0 = r12.e;
        return r0;
    L_0x0127:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r1 = "Get Snapshot for ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r12.a;	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = " into ";
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r3.getName();	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = " form ";
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r12.b;	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r0 = j;	 Catch:{ Throwable -> 0x028b }
        r1 = r12.a;	 Catch:{ Throwable -> 0x028b }
        r0.put(r1, r12);	 Catch:{ Throwable -> 0x028b }
        r0 = r12.b;	 Catch:{ Throwable -> 0x028b }
        r1 = r12.c;	 Catch:{ Throwable -> 0x028b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r5 = "cutFrame--mediaPath=";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x028b }
        r4.append(r0);	 Catch:{ Throwable -> 0x028b }
        r5 = "|timeMs=";
        r4.append(r5);	 Catch:{ Throwable -> 0x028b }
        r4.append(r1);	 Catch:{ Throwable -> 0x028b }
        r5 = "|width=0|height=0";
        r4.append(r5);	 Catch:{ Throwable -> 0x028b }
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x028b }
        r5 = 0;
        if (r4 == 0) goto L_0x0174;
    L_0x0172:
        r1 = r5;
        goto L_0x01c5;
    L_0x0174:
        r0 = com.xunlei.downloadprovider.player.xmp.b.a.a.a(r0, r1);	 Catch:{ Throwable -> 0x028b }
        if (r0 == 0) goto L_0x01ba;
    L_0x017a:
        r1 = r0.bitMap;	 Catch:{ Throwable -> 0x028b }
        if (r1 == 0) goto L_0x01ba;
    L_0x017e:
        r1 = r0.bitMap;	 Catch:{ Throwable -> 0x028b }
        r1 = r1.length;	 Catch:{ Throwable -> 0x028b }
        if (r1 != 0) goto L_0x0184;
    L_0x0183:
        goto L_0x01ba;
    L_0x0184:
        r1 = new com.xunlei.downloadprovider.player.xmp.b.a$b;	 Catch:{ Throwable -> 0x028b }
        r1.<init>();	 Catch:{ Throwable -> 0x028b }
        r2 = r0.width;	 Catch:{ Throwable -> 0x028b }
        r1.a = r2;	 Catch:{ Throwable -> 0x028b }
        r2 = r0.height;	 Catch:{ Throwable -> 0x028b }
        r1.b = r2;	 Catch:{ Throwable -> 0x028b }
        r6 = r0.show_ms;	 Catch:{ Throwable -> 0x028b }
        r1.d = r6;	 Catch:{ Throwable -> 0x028b }
        r6 = r0.duration_ms;	 Catch:{ Throwable -> 0x028b }
        r1.c = r6;	 Catch:{ Throwable -> 0x028b }
        r2 = r0.is_key_frame;	 Catch:{ Throwable -> 0x028b }
        r1.e = r2;	 Catch:{ Throwable -> 0x028b }
        r2 = r0.avg_luma;	 Catch:{ Throwable -> 0x028b }
        r1.f = r2;	 Catch:{ Throwable -> 0x028b }
        r0 = r0.bitMap;	 Catch:{ Throwable -> 0x028b }
        r0 = com.aplayer.aplayerandroid.APlayerAndroid.MediaInfo.byteArray2BitMap(r0);	 Catch:{ Throwable -> 0x028b }
        r1.g = r0;	 Catch:{ Throwable -> 0x028b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r2 = "cutFrame--result=";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = r1.g;	 Catch:{ Throwable -> 0x028b }
        r2 = r2.getByteCount();	 Catch:{ Throwable -> 0x028b }
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        goto L_0x01c5;
    L_0x01ba:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r1 = "cutFrame--result=";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x028b }
        r0.append(r5);	 Catch:{ Throwable -> 0x028b }
        goto L_0x0172;
    L_0x01c5:
        r0 = r12.f;	 Catch:{ Throwable -> 0x028b }
        if (r0 == 0) goto L_0x01cf;
    L_0x01c9:
        r0 = r3.exists();	 Catch:{ Throwable -> 0x028b }
        if (r0 != 0) goto L_0x0276;
    L_0x01cf:
        if (r1 == 0) goto L_0x0254;
    L_0x01d1:
        r0 = r1.g;	 Catch:{ Throwable -> 0x028b }
        if (r0 == 0) goto L_0x0254;
    L_0x01d5:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r2 = "Done - Get Snapshot for ";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = r12.a;	 Catch:{ Throwable -> 0x028b }
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = " into ";
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = r3.getName();	 Catch:{ Throwable -> 0x028b }
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = " form ";
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = r12.b;	 Catch:{ Throwable -> 0x028b }
        r0.append(r2);	 Catch:{ Throwable -> 0x028b }
        r0 = r12.d;	 Catch:{ Throwable -> 0x028b }
        r0 = r0.exists();	 Catch:{ Throwable -> 0x028b }
        if (r0 != 0) goto L_0x0204;
    L_0x01ff:
        r0 = r12.d;	 Catch:{ Throwable -> 0x028b }
        r0.mkdirs();	 Catch:{ Throwable -> 0x028b }
    L_0x0204:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x028b }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r2.<init>();	 Catch:{ Throwable -> 0x028b }
        r4 = r3.getAbsolutePath();	 Catch:{ Throwable -> 0x028b }
        r2.append(r4);	 Catch:{ Throwable -> 0x028b }
        r4 = ".";
        r2.append(r4);	 Catch:{ Throwable -> 0x028b }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x028b }
        r2.append(r6);	 Catch:{ Throwable -> 0x028b }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x028b }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x028b }
        r2 = r1.g;	 Catch:{ Throwable -> 0x028b }
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Throwable -> 0x028b }
        com.xunlei.common.androidutil.BitmapUtil.saveBitmapToFile(r0, r2, r4);	 Catch:{ Throwable -> 0x028b }
        r1.g = r5;	 Catch:{ Throwable -> 0x028b }
        r1 = r0.exists();	 Catch:{ Throwable -> 0x028b }
        if (r1 == 0) goto L_0x023c;
    L_0x0234:
        r1 = r12.f;	 Catch:{ Throwable -> 0x028b }
        if (r1 != 0) goto L_0x023c;
    L_0x0238:
        r0.renameTo(r3);	 Catch:{ Throwable -> 0x028b }
        goto L_0x0276;
    L_0x023c:
        r1 = r0.exists();	 Catch:{ Throwable -> 0x028b }
        if (r1 == 0) goto L_0x0276;
    L_0x0242:
        r1 = r12.f;	 Catch:{ Throwable -> 0x028b }
        if (r1 == 0) goto L_0x0276;
    L_0x0246:
        r1 = r3.exists();	 Catch:{ Throwable -> 0x028b }
        if (r1 != 0) goto L_0x0250;
    L_0x024c:
        r0.renameTo(r3);	 Catch:{ Throwable -> 0x028b }
        goto L_0x0276;
    L_0x0250:
        r0.delete();	 Catch:{ Throwable -> 0x028b }
        goto L_0x0276;
    L_0x0254:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x028b }
        r1 = "Fail - Get Snapshot for ";
        r0.<init>(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r12.a;	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = " into ";
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r3.getName();	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = " form ";
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
        r1 = r12.b;	 Catch:{ Throwable -> 0x028b }
        r0.append(r1);	 Catch:{ Throwable -> 0x028b }
    L_0x0276:
        r0 = r12.i;	 Catch:{ Throwable -> 0x028b }
        if (r0 == 0) goto L_0x028f;
    L_0x027a:
        r0 = r12.i;	 Catch:{ Throwable -> 0x028b }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x028b }
        r4 = r0.a;	 Catch:{ Throwable -> 0x028b }
        if (r4 == 0) goto L_0x028f;
    L_0x0284:
        r0 = r0.a;	 Catch:{ Throwable -> 0x028b }
        r0.mSnapshotCheckLMT = r1;	 Catch:{ Throwable -> 0x028b }
        goto L_0x028f;
    L_0x0289:
        r0 = move-exception;
        goto L_0x02aa;
    L_0x028b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0289 }
    L_0x028f:
        r0 = j;
        r1 = r12.a;
        r0.remove(r1);
        r0 = r12.f;
        if (r0 != 0) goto L_0x02a7;
    L_0x029a:
        r0 = r3.exists();
        if (r0 == 0) goto L_0x02a7;
    L_0x02a0:
        r0 = new java.io.FileInputStream;
        r0.<init>(r3);
        r12.e = r0;
    L_0x02a7:
        r0 = r12.e;
        return r0;
    L_0x02aa:
        r1 = j;
        r2 = r12.a;
        r1.remove(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.a.a.d.a():java.io.InputStream");
    }

    private static String a(String str) {
        if (!str.contains("http://127.0.0.1")) {
            return str;
        }
        Object a = i.a(str);
        return TextUtils.isEmpty(a) ? str : a;
    }

    public final void cleanup() {
        if (this.e != null) {
            try {
                this.e.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final String getId() {
        return this.a;
    }

    public final void cancel() {
        this.f = true;
    }
}
