package com.xunlei.download.proguard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.android.providers.downloads.DownloadProvider;
import com.xunlei.download.DownloadManager;

@Deprecated
/* compiled from: XlDownloads */
public class aa {
    public static final int a = 491;
    public static final int b = 10;
    public static final String c = "download_speed";
    public static final String d = "p2s_speed";
    public static final String e = "origin_speed";
    public static final String f = "xunlei_spdy";
    public static final String g = "extra";
    public static final String h = "xunlei_spdy";
    public static final String i = "download_speed";
    public static final String j = "p2s_speed";
    public static final String k = "_key";
    public static final String l = "_value";
    public static final String m = "xl_config";

    @Deprecated
    /* compiled from: XlDownloads */
    public interface a {
        public static final String a = "xl_engine_state";
        public static final String b = "recommended_bytes_over_mobile";
    }

    @Deprecated
    /* compiled from: XlDownloads */
    public static class b {
        private ContentResolver a;

        public b(Context context) {
            this.a = context.getContentResolver();
        }

        private void a(String str, String str2) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_value", str2);
            try {
                this.a.update(DownloadProvider.d, contentValues, "_key = ?", new String[]{str});
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
            }
        }

        public String a(String str) {
            Throwable e;
            String str2 = "_key = ?";
            String[] strArr = new String[]{str};
            str = "";
            Cursor cursor = null;
            try {
                Cursor query = this.a.query(DownloadProvider.d, new String[]{"_value"}, str2, strArr, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str = query.getString(0);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        try {
                            e.printStackTrace();
                            an.a(e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return str;
                        } catch (Throwable th) {
                            str = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw str;
                        }
                    } catch (Throwable th2) {
                        str = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw str;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                an.a(e);
                if (cursor != null) {
                    cursor.close();
                }
                return str;
            }
            return str;
        }

        public void a(String str, long j) {
            a(str, String.valueOf(j));
        }

        public long b(String str) {
            return Long.parseLong(a(str));
        }

        public void a(String str, int i) {
            a(str, String.valueOf(i));
        }

        public int c(String str) {
            return Integer.parseInt(a(str));
        }
    }

    @Deprecated
    public static void a(Context context, long j) {
        DownloadManager.getInstanceFor(context).resumeDownload(new long[]{j});
    }

    @Deprecated
    public static void b(Context context, long j) {
        DownloadManager.getInstanceFor(context).pauseDownload(new long[]{j});
    }

    @Deprecated
    public static void c(Context context, long j) {
        DownloadManager.getInstanceFor(context).suspendDownload(new long[]{j});
    }
}
