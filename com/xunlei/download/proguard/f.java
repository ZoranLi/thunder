package com.xunlei.download.proguard;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemClock;
import com.xunlei.download.DownloadManager;
import java.util.HashMap;

/* compiled from: DownloadScanner */
public class f implements MediaScannerConnectionClient {
    private static final long a = 60000;
    private final Context b;
    private final MediaScannerConnection c;
    private HashMap<String, a> d = new HashMap();

    /* compiled from: DownloadScanner */
    static class a {
        public final long a;
        public final String b;
        public final String c;
        public final long d = SystemClock.elapsedRealtime();

        public a(long j, String str, String str2) {
            this.a = j;
            this.b = str;
            this.c = str2;
        }

        public void a(MediaScannerConnection mediaScannerConnection) {
            mediaScannerConnection.scanFile(this.b, this.c);
        }
    }

    public f(Context context) {
        this.b = context;
        this.c = new MediaScannerConnection(context, this);
    }

    public boolean a() {
        synchronized (this.c) {
            if (this.d.isEmpty()) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (a aVar : this.d.values()) {
                if (elapsedRealtime < aVar.d + a) {
                    return true;
                }
            }
            return false;
        }
    }

    public void a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder("requestScan() for ");
        stringBuilder.append(dVar.g);
        an.e("DownloadManager", stringBuilder.toString());
        synchronized (this.c) {
            a aVar = new a(dVar.c, dVar.g, dVar.h);
            this.d.put(aVar.b, aVar);
            if (this.c.isConnected() != null) {
                aVar.a(this.c);
            } else {
                this.c.connect();
            }
        }
    }

    public void b() {
        this.c.disconnect();
    }

    public void onMediaScannerConnected() {
        synchronized (this.c) {
            for (a a : this.d.values()) {
                a.a(this.c);
            }
        }
    }

    public void onScanCompleted(String str, Uri uri) {
        synchronized (this.c) {
            a aVar = (a) this.d.remove(str);
        }
        if (aVar == null) {
            StringBuilder stringBuilder = new StringBuilder("Missing request for path ");
            stringBuilder.append(str);
            an.c("DownloadManager", stringBuilder.toString());
            return;
        }
        str = new ContentValues();
        str.put("scanned", Integer.valueOf(1));
        if (uri != null) {
            str.put("mediaprovider_uri", uri.toString());
        }
        Binder.clearCallingIdentity();
        ContentResolver contentResolver = this.b.getContentResolver();
        try {
            if (contentResolver.update(ContentUris.withAppendedId(DownloadManager.getInstanceFor(this.b).getDownloadUri(), aVar.a), str, null, null) == null) {
                contentResolver.delete(uri, null, null);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
    }
}
