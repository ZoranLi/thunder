package com.xunlei.download;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.android.providers.downloads.DownloadProvider;
import com.android.providers.downloads.DownloadService;
import com.android.providers.downloads.XlTaskHelper;
import com.umeng.message.proguard.k;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.download.proguard.ab;
import com.xunlei.download.proguard.ad;
import com.xunlei.download.proguard.ai;
import com.xunlei.download.proguard.al;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.l;
import com.xunlei.download.proguard.p;
import com.xunlei.download.proguard.s;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.MaxDownloadSpeedParam;
import com.xunlei.downloadlib.parameter.XLTaskLocalUrl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;

public class DownloadManager {
    public static final String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    @Deprecated
    public static final String ACTION_DOWNLOAD_START_OR_COMPLETE = "android.intent.action.DOWNLOAD_START_OR_COMPLETE";
    public static final String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public static final String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    public static final String COLUMN_ADDITION_LX_SPEED = "addition_lx_speed";
    public static final String COLUMN_ADDITION_VIP_SPEED = "addition_vip_speed";
    public static final String COLUMN_ALLOW_WRITE = "allow_write";
    public static final String COLUMN_APK_PACKAGE = "apk_package";
    public static final String COLUMN_APK_VERSION = "apk_version";
    public static final String COLUMN_BT_PARENT_ID = "bt_parent_id";
    public static final String COLUMN_BT_SELECT_SET = "bt_select_set";
    public static final String COLUMN_BT_SUB_INDEX = "bt_sub_index";
    public static final String COLUMN_BT_SUB_IS_SELECTED = "bt_sub_is_selected";
    public static final String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    public static final String COLUMN_CID = "cid";
    public static final String COLUMN_CREATE_TIME = "create_time";
    public static final String COLUMN_DCDN_RECEIVE_SIZE = "dcdn_receive_size";
    public static final String COLUMN_DCDN_SPEED = "dcdn_speed";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DOWNLOAD_DURATION = "download_duration";
    public static final String COLUMN_DOWNLOAD_SPEED = "download_speed";
    public static final String COLUMN_ERROR_MSG = "errorMsg";
    public static final String COLUMN_GCID = "gcid";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IS_DCDN_SPEEDUP = "is_dcdn_speedup";
    public static final String COLUMN_IS_LX_SPEEDUP = "is_lx_speedup";
    public static final String COLUMN_IS_VIP_SPEEDUP = "is_vip_speedup";
    public static final String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    public static final String COLUMN_LOCAL_FILENAME = "local_filename";
    public static final String COLUMN_LOCAL_URI = "local_uri";
    public static final String COLUMN_LX_PROGRESS = "lx_progress";
    public static final String COLUMN_LX_RECEIVE_SIZE = "lx_receive_size";
    public static final String COLUMN_LX_STATUS = "lx_status";
    public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
    public static final String COLUMN_MEDIA_TYPE = "media_type";
    public static final String COLUMN_ORIGIN_RECEIVE_SIZE = "origin_receive_size";
    public static final String COLUMN_ORIGIN_SPEED = "origin_speed";
    public static final String COLUMN_P2P_RECEIVE_SIZE = "p2p_receive_size";
    public static final String COLUMN_P2P_SPEED = "p2p_speed";
    public static final String COLUMN_P2S_RECEIVE_SIZE = "p2s_receive_size";
    public static final String COLUMN_P2S_SPEED = "p2s_speed";
    public static final String COLUMN_REASON = "reason";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_STATUS_ORIGINAL = "status_original";
    public static final String COLUMN_TASK_TYPE = "task_type";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    public static final String COLUMN_URI = "uri";
    public static final String COLUMN_VIP_ERRNO = "vip_errno";
    public static final String COLUMN_VIP_RECEIVE_SIZE = "vip_receive_size";
    public static final String COLUMN_VIP_STATUS = "vip_status";
    public static final String COLUMN_XUNLEI_SPDY = "xunlei_spdy";
    public static final String DB_PATH_KEY = "db_path";
    public static final int ERROR_BLOCKED = 1010;
    public static final int ERROR_CANNOT_RESUME = 1008;
    public static final int ERROR_DEVICE_NOT_FOUND = 1007;
    public static final int ERROR_FILE_ALREADY_EXISTS = 1009;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_CLIENT_ERROR = 1012;
    public static final int ERROR_HTTP_DATA_ERROR = 1004;
    public static final int ERROR_HTTP_SERVER_ERROR = 1011;
    public static final int ERROR_INSUFFICIENT_SPACE = 1006;
    public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public static final int ERROR_UNKNOWN = 1000;
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_DOWNLOAD_STATE = "extra_download_state";
    public static final String EXTRA_DOWNLOAD_STATE_ORIGINAL = "extra_download_state_original";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    public static final String INTENT_EXTRAS_SORT_BY_SIZE = "android.app.DownloadManager.extra_sortBySize";
    public static final int INVAlID_TASK_ID = -1;
    public static final String KEY_APP_KEY = "com.xunlei.download.APP_KEY";
    public static final String KEY_DOWNLOAD_SPEED_LIMIT = "com.xunlei.download.DOWNLOAD_SPEED_LIMIT";
    public static final String KEY_MAX_BYTES_OVER_MOBILE = "com.xunlei.download.MAX_BYTES_OVER_MOBILE";
    public static final String KEY_MAX_CONCURRENT_DOWNLOADS = "com.xunlei.download.MAX_CONCURRENT_DOWNLOADS";
    public static final String KEY_PRODUCT_NAME = "com.xunlei.download.PRODUCT_NAME";
    public static final String KEY_RECOMMENDED_MAX_BYTES_OVER_MOBILE = "com.xunlei.download.RECOMMENDED_MAX_BYTES_OVER_MOBILE";
    public static final String KEY_RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS";
    public static final String KEY_RECOMMENDED_MAX_CONCURRENT_DOWNLOADS = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_DOWNLOADS";
    public static final String KEY_SHOW_NOTIFY = "com.xunlei.download.SHOW_NOTIFY";
    public static final String KEY_UPLOAD_SPEED_LIMIT = "com.xunlei.download.UPLOAD_SPEED_LIMIT";
    public static final String LOG_TAG = "DownloadManager";
    public static final long MAX_BYTES_OVER_MOBILE = 4194304;
    public static final int MAX_CONCURRENT_DOWNLOADS = 10;
    public static final int PAUSED_BY_APP = 5;
    public static final int PAUSED_QUEUED_FOR_WIFI = 3;
    public static final int PAUSED_UNKNOWN = 4;
    public static final int PAUSED_WAITING_FOR_NETWORK = 2;
    public static final int PAUSED_WAITING_TO_RETRY = 1;
    public static final long RECOMMENDED_MAX_BYTES_OVERMOBILE = 524288;
    public static final int RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS = 3;
    public static final int RECOMMENDED_MAX_CONCURRENT_DOWNLOADS = 5;
    public static final String SDK_VERSION = "1.0.0.9";
    public static final boolean SHOW_NOTIFY = true;
    public static final int STATUS_FAILED = 16;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_SUCCESSFUL = 8;
    public static final String TASK_GROUP_URI_PREFIX = "group://";
    public static final String[] UNDERLYING_COLUMNS = new String[]{"_id", Impl._DATA, "_data AS local_filename", "mediaprovider_uri", Impl.COLUMN_DESTINATION, "title", "description", "uri", "status", Impl.COLUMN_FILE_NAME_HINT, "mimetype", "mimetype AS media_type", "total_bytes", "total_bytes AS total_size", Impl.COLUMN_LAST_MODIFICATION, "lastmod AS last_modified_timestamp", Impl.COLUMN_CURRENT_BYTES, "current_bytes AS bytes_so_far", "download_speed", "origin_speed", "p2s_speed", "addition_vip_speed", "cid", "gcid", "errorMsg", "extra", "allow_write", Impl.COLUMN_ALLOW_AUTO_RESUME, "apk_version", "apk_package", "vip_receive_size", "vip_status", "vip_errno", "addition_lx_speed", "lx_receive_size", "lx_status", "lx_progress", "p2p_speed", "p2p_receive_size", "p2s_receive_size", "origin_receive_size", "task_type", Impl.COLUMN_GROUP_ID, Impl.COLUMN_RES_TOTAL, Impl.COLUMN_RES_USED_TOTAL, "etag", "xunlei_spdy", "bt_select_set", "is_vip_speedup", "is_lx_speedup", "create_time", "download_duration", "dcdn_speed", "dcdn_receive_size", Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "is_dcdn_speedup", Impl.COLUMN_CUSTOM_FLAGS, Impl.COLUMN_RANGE_INFO, "'placeholder' AS local_uri", "'placeholder' AS reason", "'placeholder' AS status_original"};
    static final /* synthetic */ boolean a = true;
    private static final int b = 31;
    private static long g = 524288;
    private static long h = 4194304;
    private static DownloadManager i = null;
    private static final String l = "non-dwnldmngr-download-dont-retry2download";
    private ContentResolver c;
    private Context d;
    private String e;
    private Uri f;
    private String j;
    private boolean k;

    public enum TaskType {
        UNKOWN,
        HTTP,
        FTP,
        MAGNET,
        BT,
        ED2K,
        CID,
        GROUP
    }

    public class DownloadManagerException extends p {
        public static final String DownloadSDKNotInit = "download sdk not init yet";
        public static final String DownloadlibInitFailed = "downloadlib engine init failed";
        final /* synthetic */ DownloadManager a;

        public DownloadManagerException(DownloadManager downloadManager, int i, String str) {
            this.a = downloadManager;
            super(i, str);
        }
    }

    private static long a(int i) {
        switch (i) {
            case 193:
                return 5;
            case 194:
                return 1;
            case 195:
                return 2;
            case 196:
                return 3;
            default:
                return 4;
        }
    }

    private static long b(int i) {
        if ((400 <= i && i < 488) || (500 <= i && i < 600)) {
            return (400 > i || i >= 488) ? 1011 : 1012;
        } else {
            switch (i) {
                case 198:
                    return 1006;
                case 199:
                    return 1007;
                case 488:
                    return 1009;
                case Impl.STATUS_CANNOT_RESUME /*489*/:
                    return 1008;
                case Impl.STATUS_FILE_ERROR /*492*/:
                    return 1001;
                case Impl.STATUS_UNHANDLED_REDIRECT /*493*/:
                case Impl.STATUS_UNHANDLED_HTTP_CODE /*494*/:
                    return 1002;
                case Impl.STATUS_HTTP_DATA_ERROR /*495*/:
                    return 1004;
                case Impl.STATUS_TOO_MANY_REDIRECTS /*497*/:
                    return 1005;
                default:
                    return 1000;
            }
        }
    }

    public String getDownloadlibPath() {
        return this.j;
    }

    public boolean isDownloadlibSDKInit() {
        return this.k;
    }

    public void setDownloadlibSDKInit(boolean z) {
        this.k = z;
    }

    public static synchronized DownloadManager getInstanceFor(Context context) {
        synchronized (DownloadManager.class) {
            context = getInstanceFor(context, DownloadProvider.class);
        }
        return context;
    }

    public static synchronized DownloadManager getInstanceFor(Context context, Class<? extends DownloadProvider> cls) {
        synchronized (DownloadManager.class) {
            context = getInstanceFor(context, cls, new File(""));
        }
        return context;
    }

    public static synchronized DownloadManager getInstanceFor(Context context, Class<? extends DownloadProvider> cls, File file) {
        synchronized (DownloadManager.class) {
            context = getInstanceFor(context, cls, file, null);
        }
        return context;
    }

    public static synchronized DownloadManager getInstanceFor(Context context, Class<? extends DownloadProvider> cls, File file, String str) {
        synchronized (DownloadManager.class) {
            if (i == null) {
                ProviderInfo[] providerInfoArr;
                StringBuilder stringBuilder = new StringBuilder("DownloadManager getInstanceFor,dbFilePath :");
                stringBuilder.append(file);
                stringBuilder.append(",downloadlibPath:");
                stringBuilder.append(str);
                an.b("DownloadManager", stringBuilder.toString());
                if (cls == null) {
                    cls = DownloadProvider.class;
                }
                String str2 = null;
                try {
                    providerInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 8).providers;
                } catch (Throwable e) {
                    an.a("DownloadManager", "Failed get Package info.", e);
                    providerInfoArr = null;
                }
                if (providerInfoArr != null) {
                    for (int i = 0; i < providerInfoArr.length; i++) {
                        if (TextUtils.equals(providerInfoArr[i].name, cls == null ? DownloadProvider.class.getName() : cls.getName())) {
                            cls = providerInfoArr[i];
                            break;
                        }
                    }
                }
                cls = null;
                if (!(cls == null || cls.authority == null)) {
                    if (cls.authority.length() > 0) {
                        DownloadProvider.a(cls.authority);
                        ContentResolver contentResolver = context.getContentResolver();
                        String packageName = context.getPackageName();
                        StringBuilder stringBuilder2 = new StringBuilder("content://");
                        stringBuilder2.append(cls.authority);
                        stringBuilder2.append("/my_downloads");
                        DownloadManager downloadManager = new DownloadManager(contentResolver, packageName, Uri.parse(stringBuilder2.toString()), str);
                        i = downloadManager;
                        downloadManager.d = context.getApplicationContext();
                        if (file == null || file.getPath().equals("") == null) {
                            cls = context.getSharedPreferences("DownloadManager", 0).edit();
                            str = DB_PATH_KEY;
                            if (file != null) {
                                str2 = file.getPath();
                            }
                            cls.putString(str, str2).commit();
                        }
                        try {
                            i.c.query(i.f, null, null, null, null).close();
                        } catch (Class<? extends DownloadProvider> cls2) {
                            an.a(cls2);
                        }
                        cls2 = Environment.getExternalStorageDirectory().getPath();
                        if (an.a(new File(cls2, "xunlei_ds_log.ini").getPath()) != null) {
                            al.a().a(context, new File(cls2, an.c()).getPath());
                        }
                    }
                }
                throw new IllegalArgumentException("Not found the definition for this Provider in AndroidManifest.xml.");
            }
            context = i;
        }
        return context;
    }

    public static synchronized DownloadManager getInstanceFor(Context context, Uri uri) {
        synchronized (DownloadManager.class) {
            if (i == null) {
                i = new DownloadManager(context.getContentResolver(), context.getPackageName(), uri);
                uri = Environment.getExternalStorageDirectory().getPath();
                if (an.a(new File(uri, "xunlei_ds_log.ini").getPath())) {
                    al.a().a(context, new File(uri, an.c()).getPath());
                }
            }
            context = i;
        }
        return context;
    }

    private DownloadManager(ContentResolver contentResolver, String str) {
        this.j = null;
        this.k = false;
        this.c = contentResolver;
        this.e = str;
        this.f = Impl.ALL_DOWNLOADS_CONTENT_URI;
    }

    private DownloadManager(ContentResolver contentResolver, String str, Uri uri) {
        this.j = null;
        this.k = false;
        if (!(uri == null || contentResolver == null)) {
            if (!TextUtils.isEmpty(str)) {
                this.f = uri;
                this.c = contentResolver;
                this.e = str;
                return;
            }
        }
        throw new IllegalArgumentException("input param can't be null");
    }

    private DownloadManager(ContentResolver contentResolver, String str, Uri uri, String str2) {
        this(contentResolver, str, uri);
        this.j = str2;
    }

    private DownloadManager(ContentResolver contentResolver, String str, Uri uri, long j, long j2) {
        this(contentResolver, str, uri);
        g = j;
        h = j2;
    }

    public File getTaskDBFile(Context context) {
        context = context.getSharedPreferences("DownloadManager", 0).getString(DB_PATH_KEY, null);
        if (context != null) {
            return new File(context);
        }
        return null;
    }

    public long enqueue(Request request) {
        if (!isDownloadlibSDKInit()) {
            an.d("DownloadManager", "enqueue error,download sdk not init yet");
            return -1;
        } else if (request instanceof GroupRequest) {
            return a((GroupRequest) request);
        } else {
            return a(request);
        }
    }

    private int c(long... jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Impl.COLUMN_DELETED, Integer.valueOf(1));
                List arrayList = new ArrayList();
                for (long j : jArr) {
                    arrayList.add(Long.valueOf(j));
                    s.a().a(j);
                }
                for (long j2 : c(arrayList)) {
                    arrayList.add(Long.valueOf(j2));
                    s.a().a(j2);
                }
                try {
                    if (arrayList.size() == 1) {
                        return this.c.update(ContentUris.withAppendedId(this.f, ((Long) arrayList.get(0)).longValue()), contentValues, null, null);
                    }
                    return this.c.update(this.f, contentValues, a(arrayList), b(arrayList));
                } catch (long[] jArr2) {
                    jArr2.printStackTrace();
                    an.a(jArr2);
                    return null;
                }
            }
        }
        throw new IllegalArgumentException("input param 'ids' can't be null");
    }

    public int remove(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("remove,ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            XlTaskHelper.a().b(jArr);
            return c(jArr);
        }
        an.d("DownloadManager", "remove error,download sdk not init yet");
        return null;
    }

    public int remove(boolean z, long... jArr) {
        return remove(z, true, jArr);
    }

    public int remove(boolean z, boolean z2, long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("remove remove,RecordOnly= ");
        stringBuilder.append(z);
        stringBuilder.append("deleteIfNotComplete=");
        stringBuilder.append(z2);
        stringBuilder.append("ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (!isDownloadlibSDKInit()) {
            an.d("DownloadManager", "remove error,download sdk not init yet");
            return 0;
        } else if (!z) {
            return c(jArr);
        } else {
            if (jArr != null) {
                if (jArr.length) {
                    String[] strArr = new String[]{"_id", "status", "task_type"};
                    z = false;
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.query(ContentUris.withAppendedId(this.f, jArr[0]), strArr, null, null, null);
                        } else {
                            jArr = this.c.query(this.f, strArr, d(jArr), e(jArr), null);
                        }
                        try {
                            int columnIndex = jArr.getColumnIndex("_id");
                            int columnIndex2 = jArr.getColumnIndex("status");
                            int columnIndex3 = jArr.getColumnIndex("task_type");
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            List arrayList3 = new ArrayList();
                            jArr.moveToFirst();
                            while (!jArr.isAfterLast()) {
                                long j = jArr.getLong(columnIndex);
                                if (TaskType.GROUP.ordinal() == jArr.getInt(columnIndex3)) {
                                    arrayList3.add(Long.valueOf(j));
                                } else {
                                    if (z2) {
                                        if (200 != jArr.getInt(columnIndex2)) {
                                            arrayList2.add(Long.valueOf(j));
                                        }
                                    }
                                    arrayList.add(Long.valueOf(j));
                                }
                                XlTaskHelper.a().b(j);
                                jArr.moveToNext();
                            }
                            if (arrayList.size() > 1) {
                                z = new long[arrayList.size()];
                                for (int i = 0; i < z.length; i++) {
                                    z[i] = ((Long) arrayList.get(i)).longValue();
                                }
                                z = this.c.delete(this.f, d(z), e(z)) + false;
                            } else {
                                z = arrayList.size() == 1 ? this.c.delete(ContentUris.withAppendedId(this.f, ((Long) arrayList.get(0)).longValue()), null, null) + false : false;
                            }
                            if (arrayList2.size() > 0) {
                                long[] jArr2 = new long[arrayList2.size()];
                                for (columnIndex = 0; columnIndex < jArr2.length; columnIndex++) {
                                    jArr2[columnIndex] = ((Long) arrayList2.get(columnIndex)).longValue();
                                }
                                z += c(jArr2);
                            }
                            if (arrayList3.size() > 0) {
                                a(z2, arrayList3);
                            }
                            if (jArr != null) {
                                jArr.close();
                            }
                            return z;
                        } catch (Exception e) {
                            z2 = e;
                            z = jArr;
                            try {
                                z2.printStackTrace();
                                an.a(z2);
                                if (z) {
                                    z.close();
                                }
                                return 0;
                            } catch (Throwable th) {
                                z2 = th;
                                jArr = z;
                                if (jArr != null) {
                                    jArr.close();
                                }
                                throw z2;
                            }
                        } catch (Throwable th2) {
                            z2 = th2;
                            if (jArr != null) {
                                jArr.close();
                            }
                            throw z2;
                        }
                    } catch (Exception e2) {
                        z2 = e2;
                        z2.printStackTrace();
                        an.a(z2);
                        if (z) {
                            z.close();
                        }
                        return 0;
                    }
                }
            }
            throw new IllegalArgumentException("input param 'ids' can't be null");
        }
    }

    @Deprecated
    private int a(boolean z, List<Long> list) {
        int i = 0;
        if (list != null) {
            if (list.size() != 0) {
                long[] c = c((List) list);
                z = (c == null || c.length <= 0) ? false : remove(true, z, c) + false;
                c = new long[list.size()];
                while (i < c.length) {
                    c[i] = ((Long) list.get(i)).longValue();
                    i++;
                }
                try {
                    z += this.c.delete(this.f, d(c), e(c));
                } catch (List<Long> list2) {
                    list2.printStackTrace();
                    an.a(list2);
                }
                return z;
            }
        }
        return 0;
    }

    public Cursor query(Query query) {
        query = query.a(this.c, this.f);
        if (query == null) {
            return null;
        }
        return new CursorTranslator(query, this.f);
    }

    @Deprecated
    public ParcelFileDescriptor openDownloadedFile(long j) throws FileNotFoundException {
        try {
            return this.c.openFileDescriptor(getDownloadUri(j), "r");
        } catch (long j2) {
            j2.printStackTrace();
            an.a(j2);
            return 0;
        }
    }

    public Uri getUriForDownloadedFile(long j) {
        Cursor query;
        try {
            query = query(new Query().setFilterById(new long[]{j}));
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToFirst() && 8 == query.getInt(query.getColumnIndexOrThrow("status"))) {
                    int i = query.getInt(query.getColumnIndexOrThrow(Impl.COLUMN_DESTINATION));
                    if (!(i == 1 || i == 5 || i == 3)) {
                        if (i != 2) {
                            j = Uri.fromFile(new File(query.getString(query.getColumnIndexOrThrow(COLUMN_LOCAL_FILENAME))));
                            if (query != null) {
                                query.close();
                            }
                            return j;
                        }
                    }
                    j = ContentUris.withAppendedId(this.f, j);
                    if (query != null) {
                        query.close();
                    }
                    return j;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th) {
                j = th;
                if (query != null) {
                    query.close();
                }
                throw j;
            }
        } catch (Throwable th2) {
            j = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw j;
        }
    }

    @Deprecated
    public String getMimeTypeForDownloadedFile(long j) {
        Throwable th;
        try {
            j = query(new Query().setFilterById(new long[]{j}));
            if (j == null) {
                if (j != null) {
                    j.close();
                }
                return null;
            }
            try {
                if (j.moveToFirst()) {
                    String string = j.getString(j.getColumnIndexOrThrow(COLUMN_MEDIA_TYPE));
                    if (j != null) {
                        j.close();
                    }
                    return string;
                }
                if (j != null) {
                    j.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (j != null) {
                    j.close();
                }
                throw th;
            }
        } catch (long j2) {
            th = j2;
            j2 = null;
            if (j2 != null) {
                j2.close();
            }
            throw th;
        }
    }

    public static Long getMaxBytesOverMobile(Context context) {
        return Long.valueOf(ad.a(context, KEY_MAX_BYTES_OVER_MOBILE, MAX_BYTES_OVER_MOBILE));
    }

    public static Long getRecommendedMaxBytesOverMobile(Context context) {
        return Long.valueOf(ad.a(context, KEY_RECOMMENDED_MAX_BYTES_OVER_MOBILE, 524288));
    }

    @Deprecated
    public long addCompletedDownload(String str, String str2, boolean z, String str3, String str4, long j, boolean z2) {
        return addCompletedDownload(l, str, str2, z, str3, str4, j, z2, false);
    }

    @Deprecated
    public long addCompletedDownload(String str, String str2, boolean z, String str3, String str4, long j, boolean z2, boolean z3) {
        return addCompletedDownload(l, str, str2, z, str3, str4, j, z2, z3);
    }

    @Deprecated
    public long addCompletedDownload(String str, String str2, String str3, boolean z, String str4, String str5, long j, boolean z2, boolean z3) {
        a("title", str2);
        a("description", str3);
        a("path", str5);
        a("mimeType", str4);
        if (j < 0) {
            throw new IllegalArgumentException(" invalid value for param: totalBytes");
        }
        str = new Request(str).setTitle(str2).setDescription(str3).setMimeType(str4).a(this.d, null);
        str.put(Impl.COLUMN_DESTINATION, Integer.valueOf(6));
        str.put(Impl._DATA, str5);
        str.put("status", Integer.valueOf(200));
        str.put("total_bytes", Long.valueOf(j));
        str.put("scanned", Integer.valueOf(z ? false : true));
        str.put(Impl.COLUMN_VISIBILITY, Integer.valueOf(z2));
        str.put("allow_write", Integer.valueOf(z3));
        try {
            str = this.c.insert(this.f, str);
        } catch (String str6) {
            str6.printStackTrace();
            an.a(str6);
            str6 = null;
        }
        if (str6 == null) {
            return -1;
        }
        return Long.parseLong(str6.getLastPathSegment());
    }

    @Deprecated
    public long addCompletedBtSubTask(long j, int i, String str, String str2, String str3, long j2) {
        a("title", str);
        a("path", str3);
        a("mimeType", str2);
        if (j2 < 0) {
            throw new IllegalArgumentException(" invalid value for param: totalBytes");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("bt_parent_id", Long.valueOf(j));
        contentValues.put("bt_sub_index", Integer.valueOf(i));
        contentValues.put("title", str);
        contentValues.put("mimetype", str2);
        contentValues.put(Impl._DATA, str3);
        contentValues.put("total_bytes", Long.valueOf(j2));
        contentValues.put("status", Integer.valueOf(200));
        contentValues.put("bt_sub_is_selected", Integer.valueOf(1));
        j = null;
        try {
            j = this.c.insert(getBtSubTaskUri(), contentValues);
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
        if (j == null) {
            return -1;
        }
        return Long.parseLong(j.getLastPathSegment());
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" can't be null");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public Uri getDownloadUri(long j) {
        return ContentUris.withAppendedId(this.f, j);
    }

    public Uri getDownloadUri() {
        return this.f;
    }

    public Uri getBtSubTaskUri() {
        return DownloadProvider.c;
    }

    @Deprecated
    public Uri getTaskGroupUri(long j) {
        StringBuilder stringBuilder = new StringBuilder("content://");
        stringBuilder.append(DownloadProvider.e);
        stringBuilder.append("/xl_task_group/%d");
        return Uri.parse(String.format(stringBuilder.toString(), new Object[]{Long.valueOf(j)}));
    }

    private static String d(long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.s);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuilder.append("OR ");
            }
            stringBuilder.append("_id");
            stringBuilder.append(" = ? ");
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    private static String a(List<Long> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.s);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append("OR ");
            }
            stringBuilder.append("_id");
            stringBuilder.append(" = ? ");
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    private static String[] e(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            strArr[i] = Long.toString(jArr[i]);
        }
        return strArr;
    }

    private static String[] b(List<Long> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = Long.toString(((Long) list.get(i)).longValue());
        }
        return strArr;
    }

    public static int translateStatus(int i) {
        if (i == 190) {
            return 1;
        }
        if (i == 200) {
            return 8;
        }
        switch (i) {
            case 192:
                return 2;
            case 193:
            case 194:
            case 195:
            case 196:
                return 4;
            default:
                if (a || Impl.isStatusError(i) != 0) {
                    return 16;
                }
                throw new AssertionError();
        }
    }

    public static long getReason(int i) {
        int translateStatus = translateStatus(i);
        if (translateStatus == 4) {
            return a(i);
        }
        if (translateStatus != 16) {
            return 0;
        }
        return b(i);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder("deleteFileIfExists() deleting ");
            stringBuilder.append(str);
            an.b("DownloadManager", stringBuilder.toString());
            XLDownloadManager.getInstance(this.d).clearTaskFile(str);
        }
    }

    private void a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    a(a);
                }
            }
            if (!file.delete()) {
                StringBuilder stringBuilder = new StringBuilder("deleteEmptyFolders() false file: ");
                stringBuilder.append(file.getPath());
                an.b("DownloadManager", stringBuilder.toString());
            }
        }
    }

    @Deprecated
    private ArrayList<String> a(int i, long j) {
        String[] strArr = new String[]{Impl._DATA};
        Cursor cursor = null;
        try {
            if (i == TaskType.GROUP.ordinal()) {
                i = this.c.query(this.f, strArr, "group_id = ?", new String[]{String.valueOf(j)}, null);
            } else if (i != TaskType.BT.ordinal()) {
                return null;
            } else {
                i = this.c.query(DownloadProvider.c, strArr, "bt_parent_id = ?", new String[]{String.valueOf(j)}, null);
            }
            try {
                j = new ArrayList();
                i.moveToFirst();
                while (!i.isAfterLast()) {
                    CharSequence string = i.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        j.add(string);
                    }
                    i.moveToNext();
                }
                if (i != 0) {
                    i.close();
                }
                return j;
            } catch (long j2) {
                Object obj = j2;
                j2 = i;
                i = obj;
                try {
                    i.printStackTrace();
                    an.a(i);
                    if (j2 != null) {
                        j2.close();
                    }
                    return null;
                } catch (Throwable th) {
                    i = th;
                    cursor = j2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw i;
                }
            } catch (long j22) {
                cursor = i;
                i = j22;
                if (cursor != null) {
                    cursor.close();
                }
                throw i;
            }
        } catch (Exception e) {
            i = e;
            j22 = 0;
            i.printStackTrace();
            an.a(i);
            if (j22 != null) {
                j22.close();
            }
            return null;
        } catch (Throwable th2) {
            i = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw i;
        }
    }

    public int restartDownload(long... jArr) {
        return restartDownload(false, false, jArr);
    }

    public int restartDownload(boolean z, long... jArr) {
        return restartDownload(z, false, jArr);
    }

    public int restartDownload(boolean z, boolean z2, long... jArr) {
        Throwable th;
        DownloadManager downloadManager = this;
        long[] jArr2 = jArr;
        if (isDownloadlibSDKInit()) {
            int i;
            int update;
            StringBuilder stringBuilder = new StringBuilder("restartDownload ids=");
            stringBuilder.append(Arrays.toString(jArr));
            an.b("DownloadManager", stringBuilder.toString());
            Query query = new Query();
            query.setFilterById(jArr2);
            query.setProjection(new String[]{"_id", "status", "task_type", Impl._DATA, "etag"});
            Cursor query2 = query(query);
            ArrayList arrayList = new ArrayList();
            if (query2 != null) {
                try {
                    int columnIndex = query2.getColumnIndex("_id");
                    int columnIndex2 = query2.getColumnIndex("status");
                    int columnIndex3 = query2.getColumnIndex("task_type");
                    int columnIndex4 = query2.getColumnIndex(Impl._DATA);
                    query2.getColumnIndex("etag");
                    query2.moveToFirst();
                    i = 0;
                    while (!query2.isAfterLast()) {
                        long j = query2.getLong(columnIndex);
                        int i2 = query2.getInt(columnIndex2);
                        int i3 = query2.getInt(columnIndex3);
                        if (i2 == 8 || i2 == 16) {
                            a(query2.getString(columnIndex4));
                            if (i3 == TaskType.GROUP.ordinal()) {
                                arrayList.add(Long.valueOf(j));
                            } else if (i3 == TaskType.BT.ordinal()) {
                                i = 1;
                            }
                            query2.moveToNext();
                        } else {
                            stringBuilder = new StringBuilder("Cannot restart incomplete download: ");
                            stringBuilder.append(query2.getLong(query2.getColumnIndex("_id")));
                            an.c("DownloadManager", stringBuilder.toString());
                            query2.close();
                            return 0;
                        }
                    }
                    query2.close();
                } catch (Throwable th2) {
                    th = th2;
                    query2.close();
                }
            } else {
                i = 0;
            }
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_CURRENT_BYTES, Integer.valueOf(0));
            contentValues.put("total_bytes", Integer.valueOf(-1));
            if (i == 0) {
                contentValues.putNull(Impl._DATA);
            }
            contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
            contentValues.put("status", Integer.valueOf(190));
            contentValues.put(Impl.COLUMN_FAILED_CONNECTIONS, Integer.valueOf(0));
            contentValues.put("vip_receive_size", Integer.valueOf(0));
            contentValues.put("lx_receive_size", Integer.valueOf(0));
            contentValues.put("p2p_receive_size", Integer.valueOf(0));
            contentValues.put("p2s_receive_size", Integer.valueOf(0));
            contentValues.put("origin_receive_size", Integer.valueOf(0));
            contentValues.put("download_duration", Integer.valueOf(0));
            if (z) {
                if (z2) {
                    contentValues.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(2));
                    XlTaskHelper.a().a(jArr2);
                } else {
                    contentValues.put(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, Integer.valueOf(1));
                }
            }
            try {
                update = downloadManager.c.update(downloadManager.f, contentValues, d(jArr), e(jArr));
            } catch (Throwable th22) {
                th = th22;
                th.printStackTrace();
                an.a(th);
                update = 0;
            }
            return update;
        }
        an.d("DownloadManager", "restartDownload error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    private int a(ArrayList<Long> arrayList) {
        arrayList = c((List) arrayList);
        if (arrayList == null || arrayList.length <= 0) {
            return 0;
        }
        return 0 + restartDownload(arrayList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int pauseDownload(long... r14) {
        /*
        r13 = this;
        r0 = "DownloadManager";
        r1 = new java.lang.StringBuilder;
        r2 = "pauseDownload ids=";
        r1.<init>(r2);
        r2 = java.util.Arrays.toString(r14);
        r1.append(r2);
        r1 = r1.toString();
        com.xunlei.download.proguard.an.b(r0, r1);
        r0 = 0;
        if (r14 == 0) goto L_0x00ff;
    L_0x001a:
        r1 = r14.length;
        if (r1 != 0) goto L_0x001f;
    L_0x001d:
        goto L_0x00ff;
    L_0x001f:
        r1 = 3;
        r4 = new java.lang.String[r1];
        r1 = "_id";
        r4[r0] = r1;
        r1 = "control";
        r8 = 1;
        r4[r8] = r1;
        r1 = "status";
        r9 = 2;
        r4[r9] = r1;
        r1 = 0;
        r10 = new java.util.ArrayList;
        r2 = r14.length;
        r10.<init>(r2);
        r2 = r13.c;	 Catch:{ Exception -> 0x00a2, all -> 0x009f }
        r3 = r13.f;	 Catch:{ Exception -> 0x00a2, all -> 0x009f }
        r5 = d(r14);	 Catch:{ Exception -> 0x00a2, all -> 0x009f }
        r6 = e(r14);	 Catch:{ Exception -> 0x00a2, all -> 0x009f }
        r7 = 0;
        r14 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00a2, all -> 0x009f }
        r1 = "_id";
        r1 = r14.getColumnIndex(r1);	 Catch:{ Exception -> 0x009d }
        r2 = "status";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x009d }
        r3 = "control";
        r3 = r14.getColumnIndex(r3);	 Catch:{ Exception -> 0x009d }
        r14.moveToFirst();	 Catch:{ Exception -> 0x009d }
    L_0x005d:
        r4 = r14.isAfterLast();	 Catch:{ Exception -> 0x009d }
        if (r4 != 0) goto L_0x009a;
    L_0x0063:
        r4 = r14.getLong(r1);	 Catch:{ Exception -> 0x009d }
        r6 = r14.getInt(r2);	 Catch:{ Exception -> 0x009d }
        r7 = r14.getInt(r3);	 Catch:{ Exception -> 0x009d }
        r6 = com.xunlei.download.Downloads.Impl.isStatusCompleted(r6);	 Catch:{ Exception -> 0x009d }
        if (r6 != 0) goto L_0x0080;
    L_0x0075:
        if (r7 != r8) goto L_0x0078;
    L_0x0077:
        goto L_0x0080;
    L_0x0078:
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x009d }
        r10.add(r4);	 Catch:{ Exception -> 0x009d }
        goto L_0x0096;
    L_0x0080:
        r7 = "pauseDownload meet %s task id=%d";
        r11 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x009d }
        if (r6 == 0) goto L_0x0089;
    L_0x0086:
        r6 = "completed";
        goto L_0x008b;
    L_0x0089:
        r6 = "paused";
    L_0x008b:
        r11[r0] = r6;	 Catch:{ Exception -> 0x009d }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x009d }
        r11[r8] = r4;	 Catch:{ Exception -> 0x009d }
        java.lang.String.format(r7, r11);	 Catch:{ Exception -> 0x009d }
    L_0x0096:
        r14.moveToNext();	 Catch:{ Exception -> 0x009d }
        goto L_0x005d;
    L_0x009a:
        if (r14 == 0) goto L_0x00b1;
    L_0x009c:
        goto L_0x00ae;
    L_0x009d:
        r1 = move-exception;
        goto L_0x00a6;
    L_0x009f:
        r0 = move-exception;
        r14 = r1;
        goto L_0x00f9;
    L_0x00a2:
        r14 = move-exception;
        r12 = r1;
        r1 = r14;
        r14 = r12;
    L_0x00a6:
        r1.printStackTrace();	 Catch:{ all -> 0x00f8 }
        com.xunlei.download.proguard.an.a(r1);	 Catch:{ all -> 0x00f8 }
        if (r14 == 0) goto L_0x00b1;
    L_0x00ae:
        r14.close();
    L_0x00b1:
        r14 = r10.size();
        if (r14 <= 0) goto L_0x00f7;
    L_0x00b7:
        r14 = new android.content.ContentValues;
        r14.<init>();
        r1 = "control";
        r2 = java.lang.Integer.valueOf(r8);
        r14.put(r1, r2);
        r1 = "status";
        r2 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r14.put(r1, r2);
        r1 = r13.c;	 Catch:{ Exception -> 0x00e2 }
        r2 = r13.f;	 Catch:{ Exception -> 0x00e2 }
        r3 = a(r10);	 Catch:{ Exception -> 0x00e2 }
        r4 = b(r10);	 Catch:{ Exception -> 0x00e2 }
        r14 = r1.update(r2, r14, r3, r4);	 Catch:{ Exception -> 0x00e2 }
        r0 = r14;
        goto L_0x00e9;
    L_0x00e2:
        r14 = move-exception;
        r14.printStackTrace();
        com.xunlei.download.proguard.an.a(r14);
    L_0x00e9:
        r14 = com.android.providers.downloads.XlTaskHelper.a();
        r14.b(r10);
        r14 = com.xunlei.download.proguard.s.a();
        r14.a(r10);
    L_0x00f7:
        return r0;
    L_0x00f8:
        r0 = move-exception;
    L_0x00f9:
        if (r14 == 0) goto L_0x00fe;
    L_0x00fb:
        r14.close();
    L_0x00fe:
        throw r0;
    L_0x00ff:
        r14 = "DownloadManager";
        r1 = "input param 'ids' can't be null";
        com.xunlei.download.proguard.an.c(r14, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.DownloadManager.pauseDownload(long[]):int");
    }

    public int resumeDownload(long... jArr) {
        return resumeDownload(false, false, jArr);
    }

    public int resumeDownload(boolean z, long... jArr) {
        return resumeDownload(z, false, jArr);
    }

    public int resumeDownload(boolean z, boolean z2, long... jArr) {
        Throwable th;
        Cursor cursor;
        DownloadManager downloadManager = this;
        boolean z3 = z;
        long[] jArr2 = jArr;
        StringBuilder stringBuilder = new StringBuilder("resumeDownload forceDownload=");
        stringBuilder.append(z3);
        stringBuilder.append(" ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        int i = 0;
        if (isDownloadlibSDKInit()) {
            if (jArr2 != null) {
                if (jArr2.length != 0) {
                    String[] strArr = new String[]{Impl.COLUMN_CONTROL, "status", "_id"};
                    List arrayList = new ArrayList();
                    Cursor query;
                    try {
                        query = downloadManager.c.query(downloadManager.f, strArr, d(jArr), e(jArr), null);
                        try {
                            int update;
                            int columnIndex = query.getColumnIndex("_id");
                            int columnIndex2 = query.getColumnIndex("status");
                            int columnIndex3 = query.getColumnIndex(Impl.COLUMN_CONTROL);
                            query.moveToFirst();
                            while (!query.isAfterLast()) {
                                long j = query.getLong(columnIndex);
                                int i2 = query.getInt(columnIndex2);
                                int i3 = query.getInt(columnIndex3);
                                if (!Impl.isStatusSuccess(i2)) {
                                    if (i3 == 0) {
                                        if (i2 != 190) {
                                            if (i2 == 192) {
                                            }
                                        }
                                    }
                                    arrayList.add(Long.valueOf(j));
                                    query.moveToNext();
                                }
                                StringBuilder stringBuilder2 = new StringBuilder("Cannot resume a completed task. download: ");
                                stringBuilder2.append(j);
                                stringBuilder2.append(", status = ");
                                stringBuilder2.append(i2);
                                stringBuilder2.append(", control = ");
                                stringBuilder2.append(i3);
                                query.moveToNext();
                            }
                            if (query != null) {
                                query.close();
                            }
                            s.a().b(arrayList);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
                            contentValues.put("status", Integer.valueOf(190));
                            contentValues.put(Impl.COLUMN_FAILED_CONNECTIONS, Integer.valueOf(0));
                            if (z3) {
                                if (z2) {
                                    contentValues.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(2));
                                    XlTaskHelper.a().a(arrayList);
                                } else {
                                    columnIndex = 1;
                                    contentValues.put(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, Integer.valueOf(1));
                                    if (arrayList.size() != columnIndex) {
                                        update = downloadManager.c.update(ContentUris.withAppendedId(downloadManager.f, ((Long) arrayList.get(0)).longValue()), contentValues, null, null);
                                    } else {
                                        if (arrayList.size() > 0) {
                                            update = downloadManager.c.update(downloadManager.f, contentValues, a(arrayList), b(arrayList));
                                        }
                                        return i;
                                    }
                                    i = update;
                                    return i;
                                }
                            }
                            columnIndex = 1;
                            try {
                                if (arrayList.size() != columnIndex) {
                                    if (arrayList.size() > 0) {
                                        update = downloadManager.c.update(downloadManager.f, contentValues, a(arrayList), b(arrayList));
                                    }
                                    return i;
                                }
                                update = downloadManager.c.update(ContentUris.withAppendedId(downloadManager.f, ((Long) arrayList.get(0)).longValue()), contentValues, null, null);
                                i = update;
                            } catch (Throwable e) {
                                th = e;
                                th.printStackTrace();
                                an.a(th);
                            }
                            return i;
                        } catch (Throwable e2) {
                            th = e2;
                            cursor = query;
                            try {
                                th.printStackTrace();
                                an.a(th);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return 0;
                            } catch (Throwable e22) {
                                th = e22;
                                query = cursor;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        } catch (Throwable e222) {
                            th = e222;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    } catch (Throwable e2222) {
                        th = e2222;
                        cursor = null;
                        th.printStackTrace();
                        an.a(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
                    } catch (Throwable e22222) {
                        th = e22222;
                        query = null;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "resumeDownload error,download sdk not init yet");
        return 0;
    }

    public int suspendDownload(long... jArr) {
        Throwable e;
        StringBuilder stringBuilder = new StringBuilder("suspendDownload  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        int i = 0;
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    String[] strArr = new String[]{Impl.COLUMN_CONTROL, "status", "_id"};
                    List arrayList = new ArrayList();
                    Cursor cursor = null;
                    try {
                        jArr = this.c.query(this.f, strArr, d(jArr), e(jArr), null);
                        try {
                            int columnIndex = jArr.getColumnIndex("_id");
                            int columnIndex2 = jArr.getColumnIndex("status");
                            int columnIndex3 = jArr.getColumnIndex(Impl.COLUMN_CONTROL);
                            jArr.moveToFirst();
                            while (!jArr.isAfterLast()) {
                                long j = jArr.getLong(columnIndex);
                                int i2 = jArr.getInt(columnIndex2);
                                int i3 = jArr.getInt(columnIndex3);
                                if (!Impl.isStatusCompleted(i2) && i3 == 0) {
                                    if (i2 == 190 || i2 == 192) {
                                        arrayList.add(Long.valueOf(j));
                                        jArr.moveToNext();
                                    }
                                }
                                StringBuilder stringBuilder2 = new StringBuilder("Cannot suspend a completed task. download: ");
                                stringBuilder2.append(j);
                                stringBuilder2.append(", status = ");
                                stringBuilder2.append(i2);
                                stringBuilder2.append(", control = ");
                                stringBuilder2.append(i3);
                                jArr.moveToNext();
                            }
                            if (jArr != null) {
                                jArr.close();
                            }
                            jArr = new ContentValues();
                            jArr.put(Impl.COLUMN_CONTROL, Integer.valueOf(10));
                            try {
                                if (arrayList.size() == 1) {
                                    jArr = this.c.update(ContentUris.withAppendedId(this.f, ((Long) arrayList.get(0)).longValue()), jArr, null, null);
                                } else {
                                    if (arrayList.size() > 0) {
                                        jArr = this.c.update(this.f, jArr, a(arrayList), b(arrayList));
                                    }
                                    return i;
                                }
                                i = jArr;
                            } catch (long[] jArr2) {
                                jArr2.printStackTrace();
                                an.a(jArr2);
                            }
                            return i;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = jArr2;
                            try {
                                e.printStackTrace();
                                an.a(e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return 0;
                            } catch (Throwable th) {
                                e = th;
                                jArr2 = cursor;
                                if (jArr2 != null) {
                                    jArr2.close();
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            if (jArr2 != null) {
                                jArr2.close();
                            }
                            throw e;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        an.a(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
                    }
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "suspendDownload error,download sdk not init yet");
        return 0;
    }

    public int openVIPSpeedUp(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("openVIPSpeedUp  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_vip_speedup", Integer.valueOf(1));
                    contentValues.put("is_dcdn_speedup", Integer.valueOf(1));
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                        } else {
                            jArr = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                        }
                    } catch (long[] jArr2) {
                        jArr2.printStackTrace();
                        an.a(jArr2);
                        jArr2 = null;
                    }
                    return jArr2;
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "openVIPSpeedUp error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int openLXSpeedUp(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("openLXSpeedUp  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_lx_speedup", Integer.valueOf(1));
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                        } else {
                            jArr = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                        }
                    } catch (long[] jArr2) {
                        jArr2.printStackTrace();
                        an.a(jArr2);
                        jArr2 = null;
                    }
                    return jArr2;
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "openLXSpeedUp error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int openVIPSpeedUpWithoutDCDN(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("openDCDNSpeedUp  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_vip_speedup", Integer.valueOf(1));
                    contentValues.put("is_dcdn_speedup", Integer.valueOf(0));
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                        } else {
                            jArr = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                        }
                    } catch (long[] jArr2) {
                        jArr2.printStackTrace();
                        an.a(jArr2);
                        jArr2 = null;
                    }
                    return jArr2;
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "openVIPSpeedUpWithoutDCDN error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int openSynchroLXTaskToServer(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("openSynchroLXTaskToServer  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER, Integer.valueOf(1));
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                        } else {
                            jArr = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                        }
                    } catch (long[] jArr2) {
                        jArr2.printStackTrace();
                        an.a(jArr2);
                        jArr2 = null;
                    }
                    return jArr2;
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "openSynchroLXTaskToServer error,download sdk not init yet");
        return 0;
    }

    public int selectBtSubTask(long j, long[] jArr) {
        Throwable e;
        StringBuilder stringBuilder = new StringBuilder("selectBtSubTask id=");
        stringBuilder.append(j);
        stringBuilder.append(", index=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length > 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    for (long append : jArr) {
                        stringBuilder2.append(append);
                        stringBuilder2.append(h.b);
                    }
                    jArr = new ContentValues();
                    jArr.put("bt_select_set", stringBuilder2.toString());
                    try {
                        j = this.c.update(ContentUris.withAppendedId(this.f, j), jArr, null, null);
                        try {
                            s.a().a(-1, -1);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            an.a(e);
                            return j;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        j = 0;
                        e.printStackTrace();
                        an.a(e);
                        return j;
                    }
                    return j;
                }
            }
            return -1;
        }
        an.d("DownloadManager", "selectBtSubTask error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int selectGroupSubTask(long j, long j2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("selectGroupSubTask id=");
        stringBuilder.append(j);
        stringBuilder.append(", subId=");
        stringBuilder.append(j2);
        stringBuilder.append(", selected=");
        stringBuilder.append(z);
        an.b("DownloadManager", stringBuilder.toString());
        int i = 0;
        if (isDownloadlibSDKInit()) {
            String[] strArr = new String[]{"bt_select_set"};
            j = ContentUris.withAppendedId(this.f, j);
            Cursor cursor = null;
            try {
                Cursor query = this.c.query(j, strArr, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("bt_select_set", z ? ai.a(string, j2) : ai.b(string, j2));
                        i = this.c.update(j, contentValues, null, null);
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e) {
                    j = e;
                    cursor = query;
                    try {
                        j.printStackTrace();
                        an.a(j);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return i;
                    } catch (Throwable th) {
                        j = th;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw j;
                    }
                } catch (Throwable th2) {
                    j = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw j;
                }
            } catch (Exception e2) {
                j = e2;
                j.printStackTrace();
                an.a(j);
                if (cursor != null) {
                    cursor.close();
                }
                return i;
            }
            return i;
        }
        an.d("DownloadManager", "selectGroupSubTask error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int selectGroupSubTask(long j, long[] jArr, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("selectGroupSubTask id=");
        stringBuilder.append(j);
        stringBuilder.append(", subIds=");
        stringBuilder.append(Arrays.toString(jArr));
        stringBuilder.append(", selected=");
        stringBuilder.append(z);
        an.b("DownloadManager", stringBuilder.toString());
        int i = 0;
        if (isDownloadlibSDKInit()) {
            String[] strArr = new String[]{"bt_select_set"};
            j = ContentUris.withAppendedId(this.f, j);
            Cursor cursor = null;
            try {
                Cursor query = this.c.query(j, strArr, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        HashSet a = ai.a(query.getString(0));
                        for (long j2 : jArr) {
                            if (z) {
                                a.add(Long.valueOf(j2));
                            } else {
                                a.remove(Long.valueOf(j2));
                            }
                        }
                        jArr = new ContentValues();
                        jArr.put("bt_select_set", ai.a(a));
                        i = this.c.update(j, jArr, null, null);
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e) {
                    j = e;
                    cursor = query;
                    try {
                        j.printStackTrace();
                        an.a(j);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return i;
                    } catch (Throwable th) {
                        j = th;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw j;
                    }
                } catch (Throwable th2) {
                    j = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw j;
                }
            } catch (Exception e2) {
                j = e2;
                j.printStackTrace();
                an.a(j);
                if (cursor != null) {
                    cursor.close();
                }
                return i;
            }
            return i;
        }
        an.d("DownloadManager", "selectGroupSubTask error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    private void a(String[] strArr, String str, String str2) throws RemoteException, OperationApplicationException {
        if (isDownloadlibSDKInit()) {
            if (str2 == null) {
                str2 = b(strArr);
            }
            Request request = new Request(a(strArr, str2));
            File file = new File(str, str2);
            request.setTitle(str2);
            request.setDestinationUri(Uri.fromFile(file));
            str = enqueue(request);
            ArrayList arrayList = new ArrayList();
            for (String str3 : strArr) {
                Builder newInsert = ContentProviderOperation.newInsert(getInstanceFor(this.d).getDownloadUri());
                Request request2 = new Request(Uri.parse(str3));
                request2.setTaskGroup(str);
                request2.setDestinationUri(file.getPath(), null);
                newInsert.withValues(request2.a(this.d, this.e));
                arrayList.add(newInsert.build());
            }
            try {
                this.d.getContentResolver().applyBatch(DownloadProvider.e, arrayList);
                return;
            } catch (String[] strArr2) {
                strArr2.printStackTrace();
                an.a(strArr2);
                return;
            }
        }
        an.d("DownloadManager", "createTaskGroup error,download sdk not init yet");
    }

    private int a(Request... requestArr) {
        int i = 0;
        int length = requestArr.length;
        int i2 = 0;
        while (i < length) {
            if (a(requestArr[i]) != -1) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    @Deprecated
    private long a(GroupRequest groupRequest) {
        ArrayList subList = groupRequest.getSubList();
        if (subList.size() == 0) {
            return -1;
        }
        long a = a((Request) groupRequest);
        if (a != -1) {
            String path = groupRequest.b != null ? Uri.withAppendedPath(groupRequest.b, groupRequest.d.toString()).getPath() : null;
            Iterator it = subList.iterator();
            while (it.hasNext()) {
                Request request = (Request) it.next();
                request.setTaskGroup(a);
                if (groupRequest.c) {
                    request.forceDownloadInMobileNetwork();
                }
                if (request.b == null && path != null) {
                    request.setDestinationUri(path, null);
                }
                if (request.e == null) {
                    request.e = groupRequest.e;
                }
            }
            if (a((Request[]) subList.toArray(new Request[subList.size()])) != null) {
                return a;
            }
            try {
                this.c.delete(this.f, "_id=?", new String[]{String.valueOf(a)});
            } catch (GroupRequest groupRequest2) {
                groupRequest2.printStackTrace();
                an.a(groupRequest2);
            }
        }
        return -1;
    }

    private long a(Request request) {
        Uri insert;
        try {
            insert = this.c.insert(this.f, request.a(this.d, this.e));
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
            insert = null;
        }
        if (insert == null) {
            return -1;
        }
        long parseLong = Long.parseLong(insert.getLastPathSegment());
        if (request.a() != null) {
            XlTaskHelper.a().a(parseLong);
        }
        return parseLong;
    }

    private static String b(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder("TaskGroup-");
        stringBuilder.append(strArr.length);
        stringBuilder.append("-");
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    private static Uri a(String[] strArr, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null) {
            stringBuilder.append(str);
        }
        stringBuilder.append(System.currentTimeMillis());
        for (String append : strArr) {
            stringBuilder.append(append);
        }
        strArr = new StringBuilder(TASK_GROUP_URI_PREFIX);
        strArr.append(stringBuilder.toString());
        return Uri.parse(strArr.toString());
    }

    private long[] c(List<Long> list) {
        Throwable e;
        if (list != null) {
            if (list.size() != 0) {
                try {
                    list = this.c.query(this.f, new String[]{"_id"}, a((List) list).replaceAll("_id", Impl.COLUMN_GROUP_ID), b((List) list), null);
                    try {
                        long[] jArr = new long[list.getCount()];
                        int i = 0;
                        while (list.moveToNext()) {
                            jArr[i] = list.getLong(0);
                            i++;
                        }
                        if (list != null) {
                            list.close();
                        }
                        return jArr;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            an.a(e);
                            if (list != null) {
                                list.close();
                            }
                            return new long[0];
                        } catch (Throwable th) {
                            e = th;
                            if (list != null) {
                                list.close();
                            }
                            throw e;
                        }
                    }
                } catch (List<Long> list2) {
                    e = list2;
                    list2 = null;
                    e.printStackTrace();
                    an.a(e);
                    if (list2 != null) {
                        list2.close();
                    }
                    return new long[0];
                } catch (List<Long> list22) {
                    e = list22;
                    list22 = null;
                    if (list22 != null) {
                        list22.close();
                    }
                    throw e;
                }
            }
        }
        return null;
    }

    @Deprecated
    public void setRecommandMaxConcurrentBtSubDownloads(int i) {
        StringBuilder stringBuilder = new StringBuilder("setRecommandMaxConcurrentBtSubDownloads count=");
        stringBuilder.append(i);
        an.b("DownloadManager", stringBuilder.toString());
        setMaxConcurrentSubDownloads(i);
    }

    @Deprecated
    public int getRecommandMaxConcurrentBtSubDownloads() {
        return getMaxConcurrentSubDownloads();
    }

    public int getMaxConcurrentSubDownloads() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.d;
        r1 = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS";
        r2 = 3;
        r0 = com.xunlei.download.proguard.ad.a(r0, r1, r2);
        r1 = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS";	 Catch:{ Exception -> 0x0018 }
        r2 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = r3.getProperty(r1, r2);	 Catch:{ Exception -> 0x0018 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0018 }
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.DownloadManager.getMaxConcurrentSubDownloads():int");
    }

    public int setMaxConcurrentSubDownloads(int i) {
        StringBuilder stringBuilder = new StringBuilder("setMaxConcurrentSubDownloads count=");
        stringBuilder.append(i);
        an.b("DownloadManager", stringBuilder.toString());
        return setProperty(KEY_RECOMMENDED_MAX_CONCURRENT_BT_SUB_DOWNLOADS, String.valueOf(i));
    }

    public int setRecommandMaxConcurrentDownloads(int i) {
        StringBuilder stringBuilder = new StringBuilder("setRecommandMaxConcurrentDownloads count=");
        stringBuilder.append(i);
        an.b("DownloadManager", stringBuilder.toString());
        return setProperty(KEY_RECOMMENDED_MAX_CONCURRENT_DOWNLOADS, String.valueOf(i));
    }

    public int getRecommandMaxConcurrentDownloads() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.d;
        r1 = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_DOWNLOADS";
        r2 = 5;
        r0 = com.xunlei.download.proguard.ad.a(r0, r1, r2);
        r1 = "com.xunlei.download.RECOMMENDED_MAX_CONCURRENT_DOWNLOADS";	 Catch:{ Exception -> 0x0018 }
        r2 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = r3.getProperty(r1, r2);	 Catch:{ Exception -> 0x0018 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0018 }
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.DownloadManager.getRecommandMaxConcurrentDownloads():int");
    }

    public String getProperty(String str, String str2) {
        Cursor cursor = null;
        try {
            str = this.c.query(DownloadProvider.d, null, "_key=?", new String[]{str}, null);
            if (str != null) {
                try {
                    if (str.moveToFirst()) {
                        str2 = str.getString(str.getColumnIndexOrThrow("_value"));
                    }
                } catch (Exception e) {
                    Exception exception = e;
                    cursor = str;
                    str = exception;
                    try {
                        str.printStackTrace();
                        an.a(str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return str2;
                    } catch (Throwable th) {
                        str2 = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw str2;
                    }
                } catch (Throwable th2) {
                    str2 = th2;
                    cursor = str;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str2;
                }
            }
            if (str != null) {
                str.close();
            }
        } catch (Exception e2) {
            str = e2;
            str.printStackTrace();
            an.a(str);
            if (cursor != null) {
                cursor.close();
            }
            return str2;
        }
        return str2;
    }

    public int setProperty(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("setProperty key=");
        stringBuilder.append(str);
        stringBuilder.append(", value=");
        stringBuilder.append(str2);
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (!(str == null || str.length() == 0)) {
                if (str2 != null) {
                    ContentValues contentValues;
                    if (str.equals(DownloadManager$Property.PROP_USER_ID)) {
                        if (TextUtils.isEmpty(str2)) {
                            XLDownloadManager.getInstance(this.d).setUserId("0");
                        } else {
                            XLDownloadManager.getInstance(this.d).setUserId(str2);
                        }
                        if (str2.equals("")) {
                            contentValues = new ContentValues();
                            contentValues.put("is_vip_speedup", Integer.valueOf(0));
                            contentValues.put("is_lx_speedup", Integer.valueOf(0));
                            contentValues.put("is_dcdn_speedup", Integer.valueOf(0));
                            contentValues.put("vip_status", Integer.valueOf(190));
                            contentValues.put("lx_status", Integer.valueOf(190));
                            try {
                                this.c.update(this.f, contentValues, null, null);
                            } catch (String str3) {
                                an.a(str3);
                                return -1;
                            }
                        }
                    }
                    contentValues = new ContentValues();
                    contentValues.put("_key", str3);
                    contentValues.put("_value", str2);
                    try {
                        if (this.c.update(DownloadProvider.d, contentValues, "_key=?", new String[]{str3}) > null || this.c.insert(DownloadProvider.d, contentValues) != null) {
                            return 1;
                        }
                        return 0;
                    } catch (String str32) {
                        str32.printStackTrace();
                        an.a(str32);
                        return 0;
                    }
                }
            }
            return 0;
        }
        an.d("DownloadManager", "setProperty error,download sdk not init yet");
        return 0;
    }

    public int setAllowedNetworkTypes(int i, long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("setAllowedNetworkTypes flag=");
        stringBuilder.append(i);
        stringBuilder.append(", ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        int i2 = 0;
        if (isDownloadlibSDKInit()) {
            if (i == 8) {
                i = 2;
                XlTaskHelper.a().a(jArr);
            } else if (i == 1) {
                an.d("DownloadManager", "must include Request.NETWORK_WIFI");
                return 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(i));
            try {
                if (jArr.length == 1) {
                    i = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                } else {
                    if (jArr.length > 0) {
                        i = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                    }
                    return i2;
                }
                i2 = i;
            } catch (int i3) {
                i3.printStackTrace();
                an.a(i3);
            }
            return i2;
        }
        an.d("DownloadManager", "setAllowedNetworkTypes error,download sdk not init yet");
        return 0;
    }

    public String getPlayUrl(String str) throws DownloadManagerException {
        StringBuilder stringBuilder = new StringBuilder("getPlayUrl path=");
        stringBuilder.append(str);
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (!TextUtils.isEmpty(str)) {
                if (new File(str).exists()) {
                    XLTaskLocalUrl xLTaskLocalUrl = new XLTaskLocalUrl();
                    str = XLDownloadManager.getInstance(this.d).getLocalUrl(str, xLTaskLocalUrl);
                    if (str == 9000) {
                        return xLTaskLocalUrl.mStrUrl;
                    }
                    stringBuilder = new StringBuilder("errcode:");
                    stringBuilder.append(str);
                    throw new DownloadManagerException(this, str, stringBuilder.toString());
                }
            }
            throw new DownloadManagerException(this, Impl.STATUS_FILE_ERROR, "file not exist");
        }
        an.d("DownloadManager", "getPlayUrl error, download sdk is not init");
        throw new DownloadManagerException(this, 502, DownloadManagerException.DownloadSDKNotInit);
    }

    public int setPlayTask(long j) {
        return setPlayTask(j, -1);
    }

    public int setPlayTask(long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder("setPlayTask id=");
        stringBuilder.append(j);
        stringBuilder.append(", index = ");
        stringBuilder.append(j2);
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (j >= 0) {
                Cursor cursor = null;
                if (j2 >= 0) {
                    try {
                        Cursor query = this.c.query(DownloadProvider.c, new String[]{"status"}, "bt_parent_id=? AND bt_sub_index=?", new String[]{String.valueOf(j), String.valueOf(j2)}, null);
                        try {
                            if (!query.moveToFirst()) {
                                if (query != null) {
                                    query.close();
                                }
                                return -6;
                            } else if (Impl.isStatusCompleted(query.getInt(query.getColumnIndex("status")))) {
                                if (query != null) {
                                    query.close();
                                }
                                return -5;
                            } else if (query != null) {
                                query.close();
                            }
                        } catch (Exception e) {
                            j = e;
                            cursor = query;
                            try {
                                j.printStackTrace();
                                an.a(j);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return -7;
                            } catch (Throwable th) {
                                j = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw j;
                            }
                        } catch (Throwable th2) {
                            j = th2;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw j;
                        }
                    } catch (Exception e2) {
                        j = e2;
                        j.printStackTrace();
                        an.a(j);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return -7;
                    }
                }
                String[] strArr = new String[]{Impl.COLUMN_CONTROL, "status"};
                try {
                    Uri withAppendedId = ContentUris.withAppendedId(this.f, j);
                    Cursor query2 = this.c.query(withAppendedId, strArr, null, null, null);
                    try {
                        int columnIndex = query2.getColumnIndex("status");
                        int columnIndex2 = query2.getColumnIndex(Impl.COLUMN_CONTROL);
                        if (query2.moveToFirst()) {
                            columnIndex = query2.getInt(columnIndex);
                            columnIndex2 = query2.getInt(columnIndex2);
                            if (Impl.isStatusCompleted(columnIndex)) {
                                if (query2 != null) {
                                    query2.close();
                                }
                                return -1;
                            }
                            if (!(columnIndex2 == 0 && (columnIndex == 190 || columnIndex == 192))) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
                                contentValues.put("status", Integer.valueOf(190));
                                if (this.c.update(withAppendedId, contentValues, null, null) != 1) {
                                    if (query2 != null) {
                                        query2.close();
                                    }
                                    return -2;
                                }
                            }
                            if (query2 != null) {
                                query2.close();
                            }
                        } else {
                            if (query2 != null) {
                                query2.close();
                            }
                            return -3;
                        }
                    } catch (Exception e3) {
                        j = e3;
                        cursor = query2;
                        try {
                            j.printStackTrace();
                            an.a(j);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return -4;
                        } catch (Throwable th3) {
                            j = th3;
                            query2 = cursor;
                            if (query2 != null) {
                                query2.close();
                            }
                            throw j;
                        }
                    } catch (Throwable th4) {
                        j = th4;
                        if (query2 != null) {
                            query2.close();
                        }
                        throw j;
                    }
                } catch (Exception e4) {
                    j = e4;
                    j.printStackTrace();
                    an.a(j);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -4;
                }
            }
            s.a().a(j, j2);
            s.a().a(this.d);
            return 1;
        }
        an.d("DownloadManager", "setPlayTask error,download sdk not init yet");
        return 0;
    }

    public boolean setSpeedLimit(long j, long j2) {
        if (isDownloadlibSDKInit()) {
            if (j < -1) {
                j = -1;
            }
            if (j2 < -1) {
                j2 = -1;
            }
            int property = (setProperty(KEY_DOWNLOAD_SPEED_LIMIT, String.valueOf(j)) + 0) + setProperty(KEY_UPLOAD_SPEED_LIMIT, String.valueOf(j2));
            if (j > 0) {
                j *= 1024;
            }
            if (j2 > 0) {
                j2 *= 1024;
            }
            XLDownloadManager.getInstance(this.d).setSpeedLimit(j, j2);
            if (property == 2) {
                return 1;
            }
            return false;
        }
        an.d("DownloadManager", "setSpeedLimit error,download sdk not init yet");
        return false;
    }

    public long getDownloadSpeedLimit() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = "com.xunlei.download.DOWNLOAD_SPEED_LIMIT";	 Catch:{ Exception -> 0x000d }
        r1 = "-1";	 Catch:{ Exception -> 0x000d }
        r0 = r2.getProperty(r0, r1);	 Catch:{ Exception -> 0x000d }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.DownloadManager.getDownloadSpeedLimit():long");
    }

    public long getUploadSpeedLimit() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = "com.xunlei.download.UPLOAD_SPEED_LIMIT";	 Catch:{ Exception -> 0x000d }
        r1 = "-1";	 Catch:{ Exception -> 0x000d }
        r0 = r2.getProperty(r0, r1);	 Catch:{ Exception -> 0x000d }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.DownloadManager.getUploadSpeedLimit():long");
    }

    public long setCustomFlags(long j, long j2) {
        if (isDownloadlibSDKInit()) {
            int update;
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_CUSTOM_FLAGS, Long.valueOf(j2));
            try {
                update = this.c.update(ContentUris.withAppendedId(this.f, j), contentValues, null, null);
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
                update = 0;
            }
            StringBuilder stringBuilder = new StringBuilder("setCustomFlags id=");
            stringBuilder.append(j);
            stringBuilder.append(" flags=");
            stringBuilder.append(Long.toHexString(j2));
            stringBuilder.append(" count=");
            stringBuilder.append(update);
            an.b("DownloadManager", stringBuilder.toString());
            return (long) update;
        }
        an.d("DownloadManager", "setCustomFlags error,download sdk not init yet");
        return 0;
    }

    @Deprecated
    public int checkHighSpeedTrialResource(long j) {
        int a = l.a().a(j);
        StringBuilder stringBuilder = new StringBuilder("checkHighSpeedTrialResource id=");
        stringBuilder.append(j);
        stringBuilder.append(", ret = ");
        stringBuilder.append(a);
        an.b("DownloadManager", stringBuilder.toString());
        return a;
    }

    public int getHighSpeedTrialTimes(long j) {
        int b = l.a().b(j);
        StringBuilder stringBuilder = new StringBuilder("getHighSpeedTrialTimes id=");
        stringBuilder.append(j);
        stringBuilder.append(", ret = ");
        stringBuilder.append(b);
        an.b("DownloadManager", stringBuilder.toString());
        return b;
    }

    public void enterHighSpeedTrial(long j) {
        l.a().c(j);
        StringBuilder stringBuilder = new StringBuilder("enterHighSpeedTrial id=");
        stringBuilder.append(j);
        an.b("DownloadManager", stringBuilder.toString());
    }

    public boolean isEnteredHighSpeedTrial(long j) {
        boolean e = l.a().e(j);
        StringBuilder stringBuilder = new StringBuilder("isEnteredHighSpeedTrial id=");
        stringBuilder.append(j);
        stringBuilder.append(", ret = ");
        stringBuilder.append(e);
        an.b("DownloadManager", stringBuilder.toString());
        return e;
    }

    public int getHighSpeedDuration(long j) {
        int f = l.a().f(j);
        StringBuilder stringBuilder = new StringBuilder("getHighSpeedDuration id=");
        stringBuilder.append(j);
        stringBuilder.append(", ret = ");
        stringBuilder.append(f);
        an.b("DownloadManager", stringBuilder.toString());
        return f;
    }

    public void stopHighSpeedTrial(long j) {
        StringBuilder stringBuilder = new StringBuilder("stopHighSpeedTrial, id=");
        stringBuilder.append(j);
        an.b("DownloadManager", stringBuilder.toString());
        l.a().d(j);
    }

    public long getMaxDownloadSpeed() throws DownloadManagerException {
        an.b("DownloadManager", "getMaxDownloadSpeed");
        if (isDownloadlibSDKInit()) {
            MaxDownloadSpeedParam maxDownloadSpeedParam = new MaxDownloadSpeedParam();
            int maxDownloadSpeed = XLDownloadManager.getInstance(this.d).getMaxDownloadSpeed(maxDownloadSpeedParam);
            if (maxDownloadSpeed == 9000) {
                return maxDownloadSpeedParam.mSpeed;
            }
            StringBuilder stringBuilder = new StringBuilder("errcode:");
            stringBuilder.append(maxDownloadSpeed);
            throw new DownloadManagerException(this, maxDownloadSpeed, stringBuilder.toString());
        }
        an.d("DownloadManager", "getMaxDownloadSpeed error,download sdk not init yet");
        throw new DownloadManagerException(this, 502, DownloadManagerException.DownloadSDKNotInit);
    }

    public void setHighSpeedTrialEnable(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("setHighSpeedTrialEnable enable=");
        stringBuilder.append(z);
        an.b("DownloadManager", stringBuilder.toString());
        l.a().a(z);
    }

    public boolean getHighSpeedTrialEnable() {
        boolean b = l.a().b();
        StringBuilder stringBuilder = new StringBuilder("getHighSpeedTrialEnable enable=");
        stringBuilder.append(b);
        an.b("DownloadManager", stringBuilder.toString());
        return b;
    }

    public int setHideTaskVisible(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("SetHideTaskVisible  ids=");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (jArr != null) {
                if (jArr.length != 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(true));
                    try {
                        if (jArr.length == 1) {
                            jArr = this.c.update(ContentUris.withAppendedId(this.f, jArr[0]), contentValues, null, null);
                        } else {
                            jArr = this.c.update(this.f, contentValues, d(jArr), e(jArr));
                        }
                    } catch (long[] jArr2) {
                        jArr2.printStackTrace();
                        an.a(jArr2);
                        jArr2 = null;
                    }
                    return jArr2;
                }
            }
            an.c("DownloadManager", "input param 'ids' can't be null");
            return 0;
        }
        an.d("DownloadManager", "setHideTaskVisible error,download sdk not init yet");
        return 0;
    }

    public int moveTask(long j, String str) {
        Throwable th;
        Throwable e;
        Cursor cursor;
        DownloadManager downloadManager = this;
        long j2 = j;
        String str2 = str;
        StringBuilder stringBuilder = new StringBuilder("moveTask id=");
        stringBuilder.append(j2);
        stringBuilder.append(", desFolder=");
        stringBuilder.append(str2);
        an.b("DownloadManager", stringBuilder.toString());
        if (!isDownloadlibSDKInit()) {
            an.d("DownloadManager", "moveTask error,download sdk not init yet");
            return 0;
        } else if (TextUtils.isEmpty(str)) {
            r5 = new StringBuilder("moveTask desFolder is empty id:");
            r5.append(j2);
            an.d("DownloadManager", r5.toString());
            return 400;
        } else if (new File(str2).isDirectory()) {
            String[] strArr = new String[]{"task_type", Impl._DATA, "status", "etag"};
            Uri withAppendedId = ContentUris.withAppendedId(downloadManager.f, j2);
            Cursor query;
            String parent;
            try {
                String str3 = null;
                try {
                    query = downloadManager.c.query(withAppendedId, strArr, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                TaskType taskType = TaskType.values()[query.getInt(query.getColumnIndex("task_type"))];
                                String string = query.getString(query.getColumnIndex(Impl._DATA));
                                int i = query.getInt(query.getColumnIndex("status"));
                                if (i != 200) {
                                    try {
                                        r5 = new StringBuilder("moveTask task not finish status:");
                                        r5.append(i);
                                        r5.append(" id:");
                                        r5.append(j2);
                                        an.d("DownloadManager", r5.toString());
                                        if (query != null) {
                                            query.close();
                                        }
                                        return 400;
                                    } catch (Throwable e2) {
                                        th = e2;
                                        cursor = str3;
                                        try {
                                            th.printStackTrace();
                                            an.a(th);
                                            if (query != null) {
                                                query.close();
                                            }
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            return 491;
                                        } catch (Throwable e22) {
                                            th = e22;
                                            if (query != null) {
                                                query.close();
                                            }
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable e222) {
                                        th = e222;
                                        cursor = str3;
                                        if (query != null) {
                                            query.close();
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                }
                                File file = new File(string);
                                File file2 = new File(str2, file.getName());
                                if (taskType == TaskType.BT) {
                                    ContentResolver contentResolver = downloadManager.c;
                                    ContentResolver contentResolver2 = contentResolver;
                                    String[] strArr2 = new String[]{"_id", Impl._DATA};
                                    cursor = contentResolver2.query(DownloadProvider.c, strArr2, "bt_parent_id=? ", new String[]{String.valueOf(j)}, null);
                                    if (cursor == null) {
                                        stringBuilder = new StringBuilder("moveTask bt subTask not found id:");
                                        stringBuilder.append(j2);
                                        an.d("DownloadManager", stringBuilder.toString());
                                        if (query != null) {
                                            query.close();
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return Impl.STATUS_CANCELED;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    cursor.moveToFirst();
                                    while (!cursor.isAfterLast()) {
                                        1BtInfo com_xunlei_download_DownloadManager_1BtInfo = new 1BtInfo(downloadManager);
                                        com_xunlei_download_DownloadManager_1BtInfo.a = cursor.getLong(cursor.getColumnIndex("_id"));
                                        com_xunlei_download_DownloadManager_1BtInfo.b = cursor.getString(cursor.getColumnIndex(Impl._DATA));
                                        try {
                                        } catch (Throwable e2222) {
                                            Throwable th2 = e2222;
                                            th2.printStackTrace();
                                            an.a(th2);
                                        }
                                        try {
                                            File file3 = new File(file2, com_xunlei_download_DownloadManager_1BtInfo.b.substring(file.getPath().length() + 1));
                                            if (file3.exists()) {
                                                stringBuilder = new StringBuilder("moveTask bt path already exist desSubFile:");
                                                stringBuilder.append(file3.getPath());
                                                stringBuilder.append(" id:");
                                                stringBuilder.append(j2);
                                                an.d("DownloadManager", stringBuilder.toString());
                                                if (query != null) {
                                                    query.close();
                                                }
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                return 488;
                                            }
                                            com_xunlei_download_DownloadManager_1BtInfo.c = file3.getPath();
                                            arrayList.add(com_xunlei_download_DownloadManager_1BtInfo);
                                            cursor.moveToNext();
                                        } catch (Throwable e22222) {
                                            th = e22222;
                                        }
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(Impl._DATA, file2.getPath());
                                    parent = file2.getParent();
                                    if (parent != null) {
                                        contentValues.put(Impl.COLUMN_FILE_NAME_HINT, Uri.fromFile(new File(parent, "{filename}")).toString());
                                    }
                                    contentValues.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(System.currentTimeMillis()));
                                    if (1 != downloadManager.c.update(withAppendedId, contentValues, null, null)) {
                                        stringBuilder = new StringBuilder("moveTask update failed id:");
                                        stringBuilder.append(j2);
                                        an.d("DownloadManager", stringBuilder.toString());
                                        if (query != null) {
                                            query.close();
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return Impl.STATUS_CANCELED;
                                    }
                                    String str4;
                                    StringBuilder stringBuilder2;
                                    File file4;
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        1BtInfo com_xunlei_download_DownloadManager_1BtInfo2 = (1BtInfo) it.next();
                                        contentValues = new ContentValues();
                                        contentValues.put(Impl._DATA, com_xunlei_download_DownloadManager_1BtInfo2.c);
                                        Iterator it2 = it;
                                        String[] strArr3 = new String[1];
                                        str4 = string;
                                        File file5 = file2;
                                        strArr3[0] = String.valueOf(com_xunlei_download_DownloadManager_1BtInfo2.a);
                                        if (1 != downloadManager.c.update(DownloadProvider.c, contentValues, "_id=?", strArr3)) {
                                            stringBuilder2 = new StringBuilder("moveTask update subTask Failed subId:");
                                            stringBuilder2.append(com_xunlei_download_DownloadManager_1BtInfo2.a);
                                            stringBuilder2.append(" id:");
                                            stringBuilder2.append(j2);
                                            an.d("DownloadManager", stringBuilder2.toString());
                                        } else if (new File(com_xunlei_download_DownloadManager_1BtInfo2.b).exists()) {
                                            file4 = new File(com_xunlei_download_DownloadManager_1BtInfo2.c);
                                            file4.getParentFile().mkdirs();
                                            if (!new File(com_xunlei_download_DownloadManager_1BtInfo2.b).renameTo(file4)) {
                                                stringBuilder2 = new StringBuilder("moveTask move subTask Failed src:");
                                                stringBuilder2.append(com_xunlei_download_DownloadManager_1BtInfo2.b);
                                                stringBuilder2.append(" des:");
                                                stringBuilder2.append(com_xunlei_download_DownloadManager_1BtInfo2.c);
                                                stringBuilder2.append(" id:");
                                                stringBuilder2.append(j2);
                                                an.d("DownloadManager", stringBuilder2.toString());
                                            }
                                        } else {
                                            stringBuilder2 = new StringBuilder("moveTask  move subTask srcSubFile not exist subId:");
                                            stringBuilder2.append(com_xunlei_download_DownloadManager_1BtInfo2.a);
                                            stringBuilder2.append(" id:");
                                            stringBuilder2.append(j2);
                                            an.d("DownloadManager", stringBuilder2.toString());
                                        }
                                        it = it2;
                                        string = str4;
                                        file2 = file5;
                                    }
                                    str4 = string;
                                    file4 = file2;
                                    file4.mkdirs();
                                    Object string2 = query.getString(query.getColumnIndex("etag"));
                                    if (TextUtils.isEmpty(string2)) {
                                        stringBuilder = new StringBuilder("moveTask torrent infoHash not exist id:");
                                        stringBuilder.append(j2);
                                        an.d("DownloadManager", stringBuilder.toString());
                                    } else {
                                        File file6 = new File(ab.a(str4, string2));
                                        if (file6.isFile()) {
                                            File file7 = new File(file4, file6.getName());
                                            if (file7.exists() && !file7.delete()) {
                                                StringBuilder stringBuilder3 = new StringBuilder("moveTask delete torrent faild file:");
                                                stringBuilder3.append(file7.getPath());
                                                stringBuilder3.append(" id:");
                                                stringBuilder3.append(j2);
                                                an.d("DownloadManager", stringBuilder3.toString());
                                            }
                                            if (file6.renameTo(file7)) {
                                                stringBuilder2 = new StringBuilder("moveTask move torrent File desTorrentFile:");
                                                stringBuilder2.append(file7.getPath());
                                                stringBuilder2.append(" id:");
                                                stringBuilder2.append(j2);
                                                an.b("DownloadManager", stringBuilder2.toString());
                                            } else {
                                                stringBuilder2 = new StringBuilder("moveTask move torrent file:");
                                                stringBuilder2.append(file7.getPath());
                                                stringBuilder2.append(" id:");
                                                stringBuilder2.append(j2);
                                                an.d("DownloadManager", stringBuilder2.toString());
                                            }
                                        } else {
                                            stringBuilder = new StringBuilder("moveTask torrent file not file:");
                                            stringBuilder.append(file6.getPath());
                                            stringBuilder.append(" id:");
                                            stringBuilder.append(j2);
                                            an.d("DownloadManager", stringBuilder.toString());
                                        }
                                    }
                                    a(file);
                                    if (query != null) {
                                        query.close();
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return 200;
                                } else if (!file.exists()) {
                                    r5 = new StringBuilder("moveTask srcFile not exist src:");
                                    r5.append(file.toString());
                                    r5.append("id:");
                                    r5.append(j2);
                                    an.d("DownloadManager", r5.toString());
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 1;
                                } else if (file2.exists()) {
                                    r5 = new StringBuilder("moveTask desFile already exist desFile:");
                                    r5.append(file2.toString());
                                    r5.append(" id:");
                                    r5.append(j2);
                                    an.d("DownloadManager", r5.toString());
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 488;
                                } else if (file.renameTo(file2)) {
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put(Impl._DATA, file2.getPath());
                                    String parent2 = file2.getParent();
                                    if (parent2 != null) {
                                        contentValues2.put(Impl.COLUMN_FILE_NAME_HINT, Uri.fromFile(new File(parent2, "{filename}")).toString());
                                    }
                                    contentValues2.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(System.currentTimeMillis()));
                                    if (1 != downloadManager.c.update(withAppendedId, contentValues2, str3, str3)) {
                                        r5 = new StringBuilder("moveTask update failed id:");
                                        r5.append(j2);
                                        an.d("DownloadManager", r5.toString());
                                        if (!file2.renameTo(file)) {
                                            r5 = new StringBuilder("moveTask update failed recover faild id:");
                                            r5.append(j2);
                                            an.d("DownloadManager", r5.toString());
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                        return Impl.STATUS_CANCELED;
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                    return 200;
                                } else {
                                    r5 = new StringBuilder("moveTask rename desFile:");
                                    r5.append(file2.toString());
                                    r5.append(" id:");
                                    r5.append(j2);
                                    an.d("DownloadManager", r5.toString());
                                    if (query != null) {
                                        query.close();
                                    }
                                    return Impl.STATUS_FILE_ERROR;
                                }
                            }
                        } catch (Exception e3) {
                            e22222 = e3;
                            parent = str3;
                            th = e22222;
                            cursor = parent;
                            th.printStackTrace();
                            an.a(th);
                            if (query != null) {
                                query.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return 491;
                        } catch (Throwable th3) {
                            e22222 = th3;
                            parent = str3;
                            th = e22222;
                            cursor = parent;
                            if (query != null) {
                                query.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    parent = str3;
                } catch (Exception e4) {
                    e22222 = e4;
                    parent = str3;
                    th = e22222;
                    cursor = parent;
                    query = cursor;
                    th.printStackTrace();
                    an.a(th);
                    if (query != null) {
                        query.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 491;
                } catch (Throwable th4) {
                    e22222 = th4;
                    parent = str3;
                    th = e22222;
                    cursor = parent;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
                try {
                    r5 = new StringBuilder("moveTask task not found id:");
                    r5.append(j2);
                    an.d("DownloadManager", r5.toString());
                    if (query != null) {
                        query.close();
                    }
                    return Impl.STATUS_CANCELED;
                } catch (Exception e5) {
                    e22222 = e5;
                    th = e22222;
                    cursor = parent;
                    th.printStackTrace();
                    an.a(th);
                    if (query != null) {
                        query.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 491;
                } catch (Throwable th5) {
                    e22222 = th5;
                    th = e22222;
                    cursor = parent;
                    if (query != null) {
                        query.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e22222 = e6;
                parent = null;
                th = e22222;
                cursor = parent;
                query = cursor;
                th.printStackTrace();
                an.a(th);
                if (query != null) {
                    query.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return 491;
            } catch (Throwable th6) {
                e22222 = th6;
                parent = null;
                th = e22222;
                cursor = parent;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            stringBuilder = new StringBuilder("moveTask desFolder not directory path:");
            stringBuilder.append(str2);
            stringBuilder.append(" id:");
            stringBuilder.append(j2);
            an.d("DownloadManager", stringBuilder.toString());
            return 488;
        }
    }

    public boolean setReleaseLog(boolean z, String str, int i, int i2) {
        if (isDownloadlibSDKInit()) {
            if (i < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (true == XLDownloadManager.getInstance(this.d).setReleaseLog(z, str, i, i2)) {
                return true;
            }
            return false;
        }
        an.d("DownloadManager", "moveTask error,download sdk not init yet");
        return false;
    }

    public void statExternalInfoU64(long j, int i, String str, long j2, int i2) {
        StringBuilder stringBuilder = new StringBuilder("statExternalInfoU64 id:");
        stringBuilder.append(j);
        stringBuilder.append(", subIndex:");
        stringBuilder.append(i);
        stringBuilder.append(", key:");
        stringBuilder.append(str);
        stringBuilder.append(", value:");
        stringBuilder.append(j2);
        stringBuilder.append(", statType:");
        stringBuilder.append(i2);
        an.b("DownloadManager", stringBuilder.toString());
        if (isDownloadlibSDKInit()) {
            if (i.d != null) {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(i.d);
                if (instance != null) {
                    Intent intent = new Intent(DownloadService.b);
                    Bundle bundle = new Bundle();
                    bundle.putString("cmdtype", DownloadService.c);
                    bundle.putLong(AgooConstants.MESSAGE_ID, j);
                    bundle.putInt("subIndex", i);
                    bundle.putString("key", str);
                    bundle.putLong(RequestHeaders.COLUMN_VALUE, j2);
                    bundle.putInt("statType", i2);
                    intent.putExtras(bundle);
                    instance.sendBroadcast(intent);
                }
            }
            return;
        }
        an.d("DownloadManager", "moveTask error,download sdk not init yet");
    }
}
