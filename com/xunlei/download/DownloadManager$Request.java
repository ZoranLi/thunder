package com.xunlei.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.download.proguard.ab;
import com.xunlei.download.proguard.an;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.GetFileName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DownloadManager$Request {
    public static final int NETWORK_BLUETOOTH = 4;
    public static final int NETWORK_MOBILE = 1;
    public static final int NETWORK_MOBILE_ONCE = 8;
    public static final int NETWORK_WIFI = 2;
    public static final int VISIBILITY_HIDDEN = 2;
    public static final int VISIBILITY_VISIBLE = 0;
    public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
    public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    static final /* synthetic */ boolean f = true;
    private static final int y = 0;
    private static final int z = 2;
    private int A;
    protected Uri a;
    protected Uri b;
    boolean c;
    CharSequence d;
    String e;
    private List<Pair<String, String>> g;
    private CharSequence h;
    private String i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private String s;
    private String t;
    private boolean u;
    private long v;
    private boolean w;
    private long x;

    static {
        Class cls = DownloadManager.class;
    }

    public DownloadManager$Request(Uri uri) {
        this.c = false;
        this.g = new ArrayList();
        this.j = -1;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = true;
        this.v = 0;
        this.w = false;
        this.x = 0;
        this.e = null;
        this.A = 0;
        if (uri == null) {
            throw new NullPointerException();
        }
        this.a = uri;
    }

    DownloadManager$Request(String str) {
        this(Uri.parse(str));
    }

    public void setTaskGroup(long j) {
        this.v = j;
    }

    public DownloadManager$Request setDestinationUri(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = "{filename}";
        }
        setDestinationUri(Uri.fromFile(new File(str, str2)));
        return this;
    }

    public DownloadManager$Request setDestinationUri(Uri uri) {
        this.b = uri;
        return this;
    }

    public DownloadManager$Request setDestinationToSystemCache() {
        this.o = true;
        return this;
    }

    public DownloadManager$Request setDestinationInExternalFilesDir(Context context, String str, String str2) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            throw new IllegalStateException("Failed to get external storage files directory");
        }
        if (externalFilesDir.exists() != null) {
            if (externalFilesDir.isDirectory() == null) {
                str2 = new StringBuilder();
                str2.append(externalFilesDir.getAbsolutePath());
                str2.append(" already exists and is not a directory");
                throw new IllegalStateException(str2.toString());
            }
        } else if (externalFilesDir.mkdirs() == null) {
            str2 = new StringBuilder("Unable to create directory: ");
            str2.append(externalFilesDir.getAbsolutePath());
            throw new IllegalStateException(str2.toString());
        }
        a(externalFilesDir, str2);
        return this;
    }

    public DownloadManager$Request setDestinationInExternalPublicDir(String str, String str2) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
        if (externalStoragePublicDirectory == null) {
            throw new IllegalStateException("Failed to get external storage public directory");
        }
        StringBuilder stringBuilder;
        if (externalStoragePublicDirectory.exists()) {
            if (!externalStoragePublicDirectory.isDirectory()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(externalStoragePublicDirectory.getAbsolutePath());
                stringBuilder.append(" already exists and is not a directory");
                throw new IllegalStateException(stringBuilder.toString());
            }
        } else if (!externalStoragePublicDirectory.mkdirs()) {
            stringBuilder = new StringBuilder("Unable to create directory: ");
            stringBuilder.append(externalStoragePublicDirectory.getAbsolutePath());
            throw new IllegalStateException(stringBuilder.toString());
        }
        a(externalStoragePublicDirectory, str2);
        return this;
    }

    private void a(File file, String str) {
        if (str == null) {
            throw new NullPointerException("subPath cannot be null");
        }
        this.b = Uri.withAppendedPath(Uri.fromFile(file), str);
    }

    public void allowScanningByMediaScanner() {
        this.n = true;
    }

    public DownloadManager$Request addRequestHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("header cannot be null");
        } else if (str.contains(Constants.COLON_SEPARATOR)) {
            throw new IllegalArgumentException("header may not contain ':'");
        } else {
            if (str2 == null) {
                str2 = "";
            }
            this.g.add(Pair.create(str, str2));
            return this;
        }
    }

    public DownloadManager$Request setTitle(CharSequence charSequence) {
        this.d = charSequence.toString().trim();
        return this;
    }

    public DownloadManager$Request setDescription(CharSequence charSequence) {
        this.h = charSequence;
        return this;
    }

    public DownloadManager$Request setMimeType(String str) {
        this.i = str;
        return this;
    }

    @Deprecated
    public DownloadManager$Request setShowRunningNotification(boolean z) {
        if (z) {
            return setNotificationVisibility(false);
        }
        return setNotificationVisibility(true);
    }

    public DownloadManager$Request setNotificationVisibility(int i) {
        this.A = i;
        return this;
    }

    public DownloadManager$Request setAllowedNetworkTypes(int i) {
        if (i == 1) {
            an.d("DownloadManager", "must include NETWORK_WIFI");
            return this;
        }
        this.j = i;
        return this;
    }

    public DownloadManager$Request setAllowedOverRoaming(boolean z) {
        this.k = z;
        return this;
    }

    public DownloadManager$Request setAllowedOverMetered(boolean z) {
        this.l = z;
        return this;
    }

    public DownloadManager$Request setVisibleInDownloadsUi(boolean z) {
        this.m = z;
        return this;
    }

    public DownloadManager$Request setDownloadDelay(boolean z) {
        this.p = z;
        return this;
    }

    public DownloadManager$Request setDownloadSpdy(boolean z) {
        this.q = z;
        return this;
    }

    public DownloadManager$Request setSynchroLxTask2Server(boolean z) {
        this.r = z;
        return this;
    }

    public DownloadManager$Request setBtSelectSet(long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : jArr) {
            stringBuilder.append(append);
            stringBuilder.append(h.b);
        }
        this.s = stringBuilder.toString();
        return this;
    }

    public DownloadManager$Request setBtSelectSet(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int append : iArr) {
            stringBuilder.append(append);
            stringBuilder.append(h.b);
        }
        this.s = stringBuilder.toString();
        return this;
    }

    public DownloadManager$Request setBtInfoHash(String str) {
        this.t = str;
        return this;
    }

    public DownloadManager$Request setAllowedAutoResume(boolean z) {
        this.u = z;
        return this;
    }

    public DownloadManager$Request forceDownloadInMobileNetwork() {
        this.c = true;
        return this;
    }

    public DownloadManager$Request setDownloadTaskXLOrigin(String str) {
        this.e = str;
        return this;
    }

    public DownloadManager$Request setCustomFlags(long j) {
        this.x = j;
        return this;
    }

    ContentValues a(Context context, String str) {
        ContentValues contentValues = new ContentValues();
        if (f || this.a != null) {
            contentValues.put("uri", this.a.toString());
            contentValues.put(Impl.COLUMN_IS_PUBLIC_API, Boolean.valueOf(true));
            contentValues.put(Impl.COLUMN_NOTIFICATION_PACKAGE, str);
            contentValues.put(Impl.COLUMN_CUSTOM_FLAGS, Long.valueOf(this.x));
            if (this.b != null) {
                contentValues.put(Impl.COLUMN_DESTINATION, Integer.valueOf(4));
                contentValues.put(Impl.COLUMN_FILE_NAME_HINT, this.b.toString());
            } else {
                contentValues.put(Impl.COLUMN_DESTINATION, Integer.valueOf(this.o ? 5 : 2));
            }
            contentValues.put("scanned", Integer.valueOf(this.n ? 0 : 2));
            if (this.g.isEmpty() == null) {
                a(contentValues);
            }
            if (this.d == null) {
                str = new GetFileName();
                String b = ab.b(context, this.a.toString());
                if (!b.startsWith("file://")) {
                    if (XLDownloadManager.getInstance(context).getFileNameFromUrl(b, str) == 9000 && TextUtils.isEmpty(str.getFileName()) == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str.getFileName());
                        stringBuilder.append(" ");
                        contentValues.put("title", stringBuilder.toString());
                    } else {
                        contentValues.put("title", "download ");
                        str = new StringBuilder("getFileNameFromUrl Failed,url=");
                        str.append(b);
                        an.e("DownloadManager", str.toString());
                    }
                }
            } else {
                contentValues.put("title", this.d.toString());
            }
            a(contentValues, "description", this.h);
            a(contentValues, "mimetype", this.i);
            if (this.m != null) {
                contentValues.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(this.A));
            } else {
                contentValues.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(2));
            }
            contentValues.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.j));
            contentValues.put(Impl.COLUMN_ALLOW_ROAMING, Boolean.valueOf(this.k));
            contentValues.put(Impl.COLUMN_ALLOW_METERED, Boolean.valueOf(this.l));
            contentValues.put(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(this.m));
            if (this.p != null) {
                contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(1));
                contentValues.put("status", Integer.valueOf(193));
            }
            if (this.s != null) {
                contentValues.put("bt_select_set", this.s);
            }
            if (this.c != null) {
                contentValues.put(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, Integer.valueOf(1));
            }
            if (this.t != null) {
                contentValues.put("etag", this.t);
            }
            contentValues.put("xunlei_spdy", Boolean.valueOf(this.q));
            contentValues.put(Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER, Boolean.valueOf(this.r));
            contentValues.put(Impl.COLUMN_ALLOW_AUTO_RESUME, Boolean.valueOf(this.u));
            if (this.v != 0) {
                contentValues.put(Impl.COLUMN_GROUP_ID, Long.valueOf(this.v));
            } else if (contentValues.containsKey(Impl.COLUMN_ALLOWED_NETWORK_TYPES) != null && contentValues.getAsInteger(Impl.COLUMN_ALLOWED_NETWORK_TYPES).intValue() == 8) {
                contentValues.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(2));
                this.w = true;
            }
            a(contentValues, Impl.COLUMN_XL_ORIGIN, this.e);
            return contentValues;
        }
        throw new AssertionError();
    }

    boolean a() {
        return this.w;
    }

    private void a(ContentValues contentValues) {
        int i = 0;
        for (Pair pair : this.g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) pair.first);
            stringBuilder.append(": ");
            stringBuilder.append((String) pair.second);
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder(RequestHeaders.INSERT_KEY_PREFIX);
            stringBuilder.append(i);
            contentValues.put(stringBuilder.toString(), stringBuilder2);
            i++;
        }
    }

    private void a(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            contentValues.put(str, obj.toString());
        }
    }
}
