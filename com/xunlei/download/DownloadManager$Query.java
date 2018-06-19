package com.xunlei.download;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.android.providers.downloads.DownloadProvider.b;
import com.umeng.message.proguard.k;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.proguard.an;
import java.util.ArrayList;

public class DownloadManager$Query {
    public static final int ORDER_ASCENDING = 1;
    public static final int ORDER_DESCENDING = 2;
    private long[] a = null;
    private Integer b = null;
    private String c = Impl.COLUMN_LAST_MODIFICATION;
    private int d = 2;
    private boolean e = false;
    private boolean f = false;
    private String[] g = null;

    public DownloadManager$Query setFilterById(long... jArr) {
        this.a = jArr;
        return this;
    }

    public DownloadManager$Query setProjection(String... strArr) {
        this.g = strArr;
        return this;
    }

    public String[] getProjection() {
        if (this.g == null) {
            return DownloadManager.UNDERLYING_COLUMNS;
        }
        return this.g;
    }

    public DownloadManager$Query setFilterByStatus(int i) {
        if ((i & 31) != 0) {
            this.b = Integer.valueOf(i);
            return this;
        }
        throw new IllegalArgumentException("invaild status.");
    }

    public DownloadManager$Query setOnlyIncludeVisibleInDownloadsUi(boolean z) {
        this.e = z;
        return this;
    }

    public DownloadManager$Query setOnlyIncludeMainTasks(boolean z) {
        this.f = z;
        return this;
    }

    public DownloadManager$Query orderBy(String str, int i) {
        if (i == 1 || i == 2) {
            if (str.equals(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP)) {
                this.c = Impl.COLUMN_LAST_MODIFICATION;
            } else if (str.equals(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)) {
                this.c = "total_bytes";
            } else if (str.equals("_id")) {
                this.c = "_id";
            } else {
                this.c = str;
            }
            this.d = i;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid direction: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    Cursor a(ContentResolver contentResolver, Uri uri) {
        try {
            return contentResolver.query(uri, getProjection(), getSelection(), getSelectionArgs(), getSortOrder());
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
            return null;
        }
    }

    public String getSelection() {
        Iterable arrayList = new ArrayList();
        if (this.a != null) {
            arrayList.add(DownloadManager.a(this.a));
        }
        if (this.b != null) {
            Iterable arrayList2 = new ArrayList();
            if ((this.b.intValue() & 1) != 0) {
                arrayList2.add(a("=", 190));
            }
            if ((this.b.intValue() & 2) != 0) {
                arrayList2.add(a("=", 192));
            }
            if ((this.b.intValue() & 4) != 0) {
                arrayList2.add(a("=", 193));
                arrayList2.add(a("=", 194));
                arrayList2.add(a("=", 195));
                arrayList2.add(a("=", 196));
            }
            if ((this.b.intValue() & 8) != 0) {
                arrayList2.add(a("=", 200));
            }
            if ((this.b.intValue() & 16) != 0) {
                arrayList2.add(a(">=", 400));
                arrayList2.add(a("=", 198));
                arrayList2.add(a("=", 199));
            }
            arrayList.add(a(b.d, arrayList2));
        }
        if (this.e) {
            arrayList.add("is_visible_in_downloads_ui != '0'");
        }
        if (this.f) {
            arrayList.add("group_id = '0'");
        }
        arrayList.add("deleted != '1'");
        return a(b.c, arrayList);
    }

    public String getSortOrder() {
        String str = this.d == 1 ? "ASC" : "DESC";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public String[] getSelectionArgs() {
        return this.a != null ? DownloadManager.b(this.a) : new String[0];
    }

    private String a(String str, Iterable<String> iterable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.s);
        Object obj = 1;
        for (String str2 : iterable) {
            if (obj == null) {
                stringBuilder.append(str);
            }
            stringBuilder.append(str2);
            obj = null;
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    private String a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("status");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(i);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }
}
