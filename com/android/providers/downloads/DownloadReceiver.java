package com.android.providers.downloads;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.widget.Toast;
import com.igexin.sdk.PushConsts;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.proguard.ah;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.c;
import com.xunlei.download.proguard.n;
import com.xunlei.download.proguard.o;
import com.xunlei.download.proguard.r;
import java.util.List;

public class DownloadReceiver extends BroadcastReceiver {
    private static final String b = "DownloadReceiver";
    private static Handler c;
    r a = null;

    static {
        HandlerThread handlerThread = new HandlerThread(b);
        handlerThread.start();
        c = new Handler(handlerThread.getLooper());
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a == null) {
            this.a = new o(context);
        }
        String action = intent.getAction();
        if (PushConsts.ACTION_BROADCAST_TO_BOOT.equals(action)) {
            a(context);
        } else if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            a(context);
        } else if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
            intent = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            StringBuilder stringBuilder = new StringBuilder("network changed. ");
            stringBuilder.append(intent);
            an.e("DownloadManager", stringBuilder.toString());
            if (!(intent == null || intent.isConnected() == null)) {
                a(context);
            }
        } else {
            if (!"android.intent.action.UID_REMOVED".equals(action)) {
                if (c.h.equals(action)) {
                    a(context);
                } else if (c.i.equals(action) || c.j.equals(action) || c.k.equals(action)) {
                    b(context, intent);
                }
            }
        }
    }

    private void a(Context context, Intent intent) {
        ContentResolver contentResolver = context.getContentResolver();
        intent = intent.getIntExtra("android.intent.extra.UID", -1);
        try {
            context = DownloadManager.getInstanceFor(context).getDownloadUri();
            StringBuilder stringBuilder = new StringBuilder("uid=");
            stringBuilder.append(intent);
            context = contentResolver.delete(context, stringBuilder.toString(), null);
        } catch (Context context2) {
            context2.printStackTrace();
            an.a(context2);
            context2 = null;
        }
        if (context2 > null) {
            String str = b;
            stringBuilder = new StringBuilder("Deleted ");
            stringBuilder.append(context2);
            stringBuilder.append(" downloads owned by UID ");
            stringBuilder.append(intent);
            an.b(str, stringBuilder.toString());
        }
    }

    private void b(Context context, Intent intent) {
        String action = intent.getAction();
        if (c.j.equals(action)) {
            a(context, intent.getLongArrayExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS));
        } else if (c.i.equals(action)) {
            long parseId = ContentUris.parseId(intent.getData());
            b(context, parseId);
            a(context, parseId);
        } else {
            if (c.k.equals(action)) {
                a(context, ContentUris.parseId(intent.getData()));
            }
        }
    }

    private void a(Context context, long j) {
        Cursor query;
        int b;
        Throwable e;
        Uri downloadUri = DownloadManager.getInstanceFor(context).getDownloadUri(j);
        try {
            query = context.getContentResolver().query(downloadUri, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    j = b(query, "status");
                    try {
                        b = b(query, Impl.COLUMN_VISIBILITY);
                        if (query != null) {
                            query.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            an.a(e);
                            if (query != null) {
                                query.close();
                            }
                            b = 1;
                            j = new ContentValues();
                            j.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(0));
                            try {
                                context.getContentResolver().update(downloadUri, j, null, null);
                            } catch (Context context2) {
                                context2.printStackTrace();
                                an.a(context2);
                            }
                        } catch (Throwable th) {
                            context2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw context2;
                        }
                    }
                    if (Impl.isStatusCompleted(j) != null && (r13 == 1 || r13 == 3)) {
                        j = new ContentValues();
                        j.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(0));
                        context2.getContentResolver().update(downloadUri, j, null, null);
                    }
                    return;
                }
                String str = b;
                StringBuilder stringBuilder = new StringBuilder("Missing details for download ");
                stringBuilder.append(j);
                an.c(str, stringBuilder.toString());
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                j = 190;
                e.printStackTrace();
                an.a(e);
                if (query != null) {
                    query.close();
                }
                b = 1;
                j = new ContentValues();
                j.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(0));
                context2.getContentResolver().update(downloadUri, j, null, null);
            }
        } catch (Exception e4) {
            e = e4;
            query = null;
            j = 190;
            e.printStackTrace();
            an.a(e);
            if (query != null) {
                query.close();
            }
            b = 1;
            j = new ContentValues();
            j.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(0));
            context2.getContentResolver().update(downloadUri, j, null, null);
        } catch (Throwable th2) {
            context2 = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw context2;
        }
    }

    private void b(Context context, long j) {
        if (n.a(context, j, 268435456) == null) {
            Toast.makeText(context, ah.a(context).d("download_no_application_title"), 0).show();
        }
    }

    private void a(Context context, long[] jArr) {
        Cursor query;
        String a;
        Throwable e;
        Intent intent;
        List queryBroadcastReceivers;
        ResolveInfo resolveActivity;
        Intent intent2;
        Uri withAppendedId = ContentUris.withAppendedId(DownloadManager.getInstanceFor(context).getDownloadUri(), jArr[0]);
        String str = null;
        try {
            query = context.getContentResolver().query(withAppendedId, null, null, null, null);
            try {
                if (query.moveToFirst()) {
                    a = a(query, Impl.COLUMN_NOTIFICATION_PACKAGE);
                    try {
                        String a2 = a(query, Impl.COLUMN_NOTIFICATION_CLASS);
                        if (query != null) {
                            query.close();
                        }
                        str = a2;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            an.a(e);
                            if (query != null) {
                                query.close();
                            }
                            if (TextUtils.isEmpty(a)) {
                                an.c(b, "Missing package; skipping broadcast");
                            }
                            if (TextUtils.isEmpty(str)) {
                                intent = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                                queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent.setPackage(a), 0);
                                if (queryBroadcastReceivers != null) {
                                }
                                try {
                                    resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").setPackage(a), 0);
                                    if (resolveActivity != null) {
                                        str = resolveActivity.activityInfo.name;
                                    }
                                } catch (Context context2) {
                                    context2.printStackTrace();
                                    an.a(context2);
                                    return;
                                }
                            }
                            try {
                                intent2 = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                                intent2.setClassName(a, str);
                                intent2.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
                                intent2.setFlags(268435456);
                                context2.startActivity(intent2);
                            } catch (Throwable e3) {
                                e3.printStackTrace();
                                an.a(e3);
                                intent2 = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                                intent2.setPackage(a);
                                intent2.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
                                if (jArr.length == 1) {
                                    intent2.setData(withAppendedId);
                                } else {
                                    intent2.setData(DownloadManager.getInstanceFor(context2).getDownloadUri());
                                }
                                this.a.a(intent2);
                                return;
                            }
                        } catch (Throwable th) {
                            context2 = th;
                            if (query != null) {
                                query.close();
                            }
                            throw context2;
                        }
                    }
                    if (TextUtils.isEmpty(a)) {
                        an.c(b, "Missing package; skipping broadcast");
                    }
                    if (TextUtils.isEmpty(str)) {
                        intent = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                        queryBroadcastReceivers = context2.getPackageManager().queryBroadcastReceivers(intent.setPackage(a), 0);
                        if (queryBroadcastReceivers != null || queryBroadcastReceivers.isEmpty()) {
                            resolveActivity = context2.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").setPackage(a), 0);
                            if (resolveActivity != null) {
                                str = resolveActivity.activityInfo.name;
                            }
                        } else {
                            intent.setClassName(a, ((ResolveInfo) queryBroadcastReceivers.get(0)).activityInfo.name);
                            intent.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
                            context2.sendBroadcast(intent);
                            return;
                        }
                    }
                    intent2 = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                    intent2.setClassName(a, str);
                    intent2.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
                    intent2.setFlags(268435456);
                    context2.startActivity(intent2);
                }
                a = b;
                StringBuilder stringBuilder = new StringBuilder("Missing details for download ");
                stringBuilder.append(jArr[0]);
                an.c(a, stringBuilder.toString());
                if (query != null) {
                    query.close();
                }
            } catch (Exception e4) {
                e = e4;
                a = null;
                e.printStackTrace();
                an.a(e);
                if (query != null) {
                    query.close();
                }
                if (TextUtils.isEmpty(a)) {
                    if (TextUtils.isEmpty(str)) {
                        intent = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                        queryBroadcastReceivers = context2.getPackageManager().queryBroadcastReceivers(intent.setPackage(a), 0);
                        if (queryBroadcastReceivers != null) {
                        }
                        resolveActivity = context2.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").setPackage(a), 0);
                        if (resolveActivity != null) {
                            str = resolveActivity.activityInfo.name;
                        }
                    }
                    intent2 = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
                    intent2.setClassName(a, str);
                    intent2.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
                    intent2.setFlags(268435456);
                    context2.startActivity(intent2);
                }
                an.c(b, "Missing package; skipping broadcast");
            }
        } catch (Exception e5) {
            e = e5;
            query = null;
            a = query;
            e.printStackTrace();
            an.a(e);
            if (query != null) {
                query.close();
            }
            if (TextUtils.isEmpty(a)) {
                an.c(b, "Missing package; skipping broadcast");
            }
            if (TextUtils.isEmpty(str)) {
                intent = new Intent("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED");
                queryBroadcastReceivers = context2.getPackageManager().queryBroadcastReceivers(intent.setPackage(a), 0);
                if (queryBroadcastReceivers != null) {
                }
                resolveActivity = context2.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").setPackage(a), 0);
                if (resolveActivity != null) {
                    str = resolveActivity.activityInfo.name;
                }
            }
            intent2 = new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS);
            intent2.setClassName(a, str);
            intent2.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, jArr);
            intent2.setFlags(268435456);
            context2.startActivity(intent2);
        } catch (Throwable th2) {
            context2 = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw context2;
        }
    }

    private static String a(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndexOrThrow(str));
    }

    private static int b(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(str));
    }

    private void a(Context context) {
        context.startService(new Intent(context, DownloadService.class));
    }
}
