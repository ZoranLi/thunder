package com.xunlei.download.proguard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Query;
import java.io.File;

/* compiled from: OpenHelper */
public class n {
    public static boolean a(Context context, long j, int i) {
        StringBuilder stringBuilder;
        Intent a = a(context, j);
        if (a == null) {
            i = new StringBuilder("No intent built for ");
            i.append(j);
            an.c("DownloadManager", i.toString());
            return false;
        }
        a.addFlags(i);
        try {
            context.startActivity(a);
            return true;
        } catch (Context context2) {
            stringBuilder = new StringBuilder("Failed to start ");
            stringBuilder.append(a);
            stringBuilder.append(": ");
            stringBuilder.append(context2);
            an.c("DownloadManager", stringBuilder.toString());
            return false;
        } catch (Context context22) {
            stringBuilder = new StringBuilder("Open Faild");
            stringBuilder.append(a);
            stringBuilder.append(": ");
            stringBuilder.append(context22);
            an.c("DownloadManager", stringBuilder.toString());
            return false;
        }
    }

    private static Intent a(Context context, long j) {
        Cursor query = DownloadManager.getInstanceFor(context).query(new DownloadManager$Query().setFilterById(j));
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    b(query, DownloadManager.COLUMN_LOCAL_URI);
                    File c = c(query, DownloadManager.COLUMN_LOCAL_FILENAME);
                    String a = a(query, DownloadManager.COLUMN_MEDIA_TYPE);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (ApkHelper.MIME_TYPE_APK.equals(a)) {
                        intent.setDataAndType(Uri.fromFile(c), a);
                        intent.putExtra("android.intent.extra.ORIGINATING_URI", b(query, "uri"));
                        intent.putExtra("android.intent.extra.REFERRER", b(context, j));
                    } else {
                        intent.setDataAndType(Uri.fromFile(c), a);
                    }
                    if (query != null) {
                        query.close();
                    }
                    return intent;
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Uri b(android.content.Context r7, long r8) {
        /*
        r0 = com.xunlei.download.DownloadManager.getInstanceFor(r7);
        r8 = r0.getDownloadUri(r8);
        r9 = "headers";
        r1 = android.net.Uri.withAppendedPath(r8, r9);
        r8 = 0;
        r0 = r7.getContentResolver();	 Catch:{ Exception -> 0x0045, all -> 0x0040 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0045, all -> 0x0040 }
    L_0x001b:
        r9 = r7.moveToNext();	 Catch:{ Exception -> 0x003e }
        if (r9 == 0) goto L_0x003b;
    L_0x0021:
        r9 = "header";
        r9 = a(r7, r9);	 Catch:{ Exception -> 0x003e }
        r0 = "Referer";
        r9 = r0.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x003e }
        if (r9 == 0) goto L_0x001b;
    L_0x002f:
        r9 = "value";
        r9 = b(r7, r9);	 Catch:{ Exception -> 0x003e }
        if (r7 == 0) goto L_0x003a;
    L_0x0037:
        r7.close();
    L_0x003a:
        return r9;
    L_0x003b:
        if (r7 == 0) goto L_0x0052;
    L_0x003d:
        goto L_0x004f;
    L_0x003e:
        r9 = move-exception;
        goto L_0x0047;
    L_0x0040:
        r7 = move-exception;
        r6 = r8;
        r8 = r7;
        r7 = r6;
        goto L_0x0054;
    L_0x0045:
        r9 = move-exception;
        r7 = r8;
    L_0x0047:
        r9.printStackTrace();	 Catch:{ all -> 0x0053 }
        com.xunlei.download.proguard.an.a(r9);	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0052;
    L_0x004f:
        r7.close();
    L_0x0052:
        return r8;
    L_0x0053:
        r8 = move-exception;
    L_0x0054:
        if (r7 == 0) goto L_0x0059;
    L_0x0056:
        r7.close();
    L_0x0059:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.n.b(android.content.Context, long):android.net.Uri");
    }

    private static java.lang.String a(android.database.Cursor r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        r2 = r1.getColumnIndexOrThrow(r2);	 Catch:{ IllegalArgumentException -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        r2 = r0;
    L_0x0007:
        if (r2 == r0) goto L_0x000e;
    L_0x0009:
        r1 = r1.getString(r2);
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.n.a(android.database.Cursor, java.lang.String):java.lang.String");
    }

    private static Uri b(Cursor cursor, String str) {
        cursor = a(cursor, str);
        return TextUtils.isEmpty(cursor) == null ? Uri.parse(cursor) : null;
    }

    private static File c(Cursor cursor, String str) {
        cursor = a(cursor, str);
        return TextUtils.isEmpty(cursor) == null ? new File(cursor) : null;
    }
}
