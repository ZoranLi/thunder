package com.huawei.hms.update.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.File;
import java.io.FileNotFoundException;

public class UpdateProvider extends ContentProvider {
    public static final String AUTHORITIES_SUFFIX = ".hms.update.provider";
    private static final String[] a = new String[]{"_display_name", "_size"};
    private static a b = new a();

    public boolean onCreate() {
        return true;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        b.a(context);
        return b.a(file, str);
    }

    public static File getLocalFile(Context context, String str) {
        b.a(context);
        return b.a(str);
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions == null) {
            throw new SecurityException("Provider must grant uri permissions");
        } else {
            b.a(context);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public String getType(Uri uri) {
        uri = b.a(uri).getName();
        int lastIndexOf = uri.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            uri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri.substring(lastIndexOf + 1));
            if (!TextUtils.isEmpty(uri)) {
                return uri;
            }
        }
        return "application/octet-stream";
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        uri = b.a(uri);
        if (strArr == null) {
            strArr = a;
        }
        str = null;
        strArr2 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        while (str < length) {
            int i2;
            Object obj = strArr[str];
            if ("_display_name".equals(obj)) {
                strArr2[i] = "_display_name";
                i2 = i + 1;
                objArr[i] = uri.getName();
            } else if ("_size".equals(obj)) {
                strArr2[i] = "_size";
                i2 = i + 1;
                objArr[i] = Long.valueOf(uri.length());
            } else {
                str++;
            }
            i = i2;
            str++;
        }
        uri = a(strArr2, i);
        strArr = a(objArr, i);
        str = new MatrixCursor(uri, 1);
        str.addRow(strArr);
        return str;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return b.a(uri).delete() != null ? 1 : null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(b.a(uri), a(str));
    }

    private static int a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (!IXAdRequestInfo.WIDTH.equals(str)) {
            if (!"wt".equals(str)) {
                if ("wa".equals(str)) {
                    return 704643072;
                }
                if ("rw".equals(str)) {
                    return 939524096;
                }
                if ("rwt".equals(str)) {
                    return 1006632960;
                }
                StringBuilder stringBuilder = new StringBuilder("Invalid mode: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return 738197504;
    }

    private static String[] a(String[] strArr, int i) {
        Object obj = new String[i];
        System.arraycopy(strArr, 0, obj, 0, i);
        return obj;
    }

    private static Object[] a(Object[] objArr, int i) {
        Object obj = new Object[i];
        System.arraycopy(objArr, 0, obj, 0, i);
        return obj;
    }
}
