package com.baidu.mobads.openad;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alipay.sdk.cons.c;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.File;
import java.util.HashMap;

public class FileProvider extends ContentProvider {
    private static final String[] a = new String[]{"_display_name", "_size"};
    private static final File b = new File("/");
    private static HashMap<String, a> c = new HashMap();
    private a d;

    interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    static class b implements a {
        private final String a;
        private final HashMap<String, File> b = new HashMap();

        public b(String str) {
            this.a = str;
        }

        public void a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.b.put(str, file.getCanonicalFile());
            } catch (String str2) {
                StringBuilder stringBuilder = new StringBuilder("Failed to resolve canonical path for ");
                stringBuilder.append(file);
                throw new IllegalArgumentException(stringBuilder.toString(), str2);
            }
        }

        public android.net.Uri a(java.io.File r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = r6.getCanonicalPath();	 Catch:{ IOException -> 0x00bc }
            r6 = 0;
            r1 = r5.b;
            r1 = r1.entrySet();
            r1 = r1.iterator();
        L_0x000f:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x0043;
        L_0x0015:
            r2 = r1.next();
            r2 = (java.util.Map.Entry) r2;
            r3 = r2.getValue();
            r3 = (java.io.File) r3;
            r3 = r3.getPath();
            r4 = r0.startsWith(r3);
            if (r4 == 0) goto L_0x000f;
        L_0x002b:
            if (r6 == 0) goto L_0x0041;
        L_0x002d:
            r3 = r3.length();
            r4 = r6.getValue();
            r4 = (java.io.File) r4;
            r4 = r4.getPath();
            r4 = r4.length();
            if (r3 <= r4) goto L_0x000f;
        L_0x0041:
            r6 = r2;
            goto L_0x000f;
        L_0x0043:
            if (r6 != 0) goto L_0x0059;
        L_0x0045:
            r6 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to find configured root that contains ";
            r1.<init>(r2);
            r1.append(r0);
            r0 = r1.toString();
            r6.<init>(r0);
            throw r6;
        L_0x0059:
            r1 = r6.getValue();
            r1 = (java.io.File) r1;
            r1 = r1.getPath();
            r2 = "/";
            r2 = r1.endsWith(r2);
            if (r2 == 0) goto L_0x0074;
        L_0x006b:
            r1 = r1.length();
            r0 = r0.substring(r1);
            goto L_0x007e;
        L_0x0074:
            r1 = r1.length();
            r1 = r1 + 1;
            r0 = r0.substring(r1);
        L_0x007e:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r6 = r6.getKey();
            r6 = (java.lang.String) r6;
            r6 = android.net.Uri.encode(r6);
            r1.append(r6);
            r6 = 47;
            r1.append(r6);
            r6 = "/";
            r6 = android.net.Uri.encode(r0, r6);
            r1.append(r6);
            r6 = r1.toString();
            r0 = new android.net.Uri$Builder;
            r0.<init>();
            r1 = "content";
            r0 = r0.scheme(r1);
            r1 = r5.a;
            r0 = r0.authority(r1);
            r6 = r0.encodedPath(r6);
            r6 = r6.build();
            return r6;
        L_0x00bc:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to resolve canonical path for ";
            r1.<init>(r2);
            r1.append(r6);
            r6 = r1.toString();
            r0.<init>(r6);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.FileProvider.b.a(java.io.File):android.net.Uri");
        }

        public java.io.File a(android.net.Uri r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = r5.getEncodedPath();
            r1 = 1;
            r2 = 47;
            r2 = r0.indexOf(r2, r1);
            r3 = r0.substring(r1, r2);
            r3 = android.net.Uri.decode(r3);
            r2 = r2 + r1;
            r0 = r0.substring(r2);
            r0 = android.net.Uri.decode(r0);
            r1 = r4.b;
            r1 = r1.get(r3);
            r1 = (java.io.File) r1;
            if (r1 != 0) goto L_0x003a;
        L_0x0026:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Unable to find configured root for ";
            r1.<init>(r2);
            r1.append(r5);
            r5 = r1.toString();
            r0.<init>(r5);
            throw r0;
        L_0x003a:
            r5 = new java.io.File;
            r5.<init>(r1, r0);
            r0 = r5.getCanonicalFile();	 Catch:{ IOException -> 0x005a }
            r5 = r0.getPath();
            r1 = r1.getPath();
            r5 = r5.startsWith(r1);
            if (r5 != 0) goto L_0x0059;
        L_0x0051:
            r5 = new java.lang.SecurityException;
            r0 = "Resolved path jumped beyond configured root";
            r5.<init>(r0);
            throw r5;
        L_0x0059:
            return r0;
        L_0x005a:
            r0 = new java.lang.IllegalArgumentException;
            r1 = new java.lang.StringBuilder;
            r2 = "Failed to resolve canonical path for ";
            r1.<init>(r2);
            r1.append(r5);
            r5 = r1.toString();
            r0.<init>(r5);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.FileProvider.b.a(android.net.Uri):java.io.File");
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.d = a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return a(context, str).a(file);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        uri = this.d.a(uri);
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

    public String getType(Uri uri) {
        uri = this.d.a(uri);
        int lastIndexOf = uri.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            uri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri.getName().substring(lastIndexOf + 1));
            if (uri != null) {
                return uri;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.d.a(uri).delete() != null ? 1 : null;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.d.a(uri), a(str));
    }

    private static a a(Context context, String str) {
        a aVar;
        synchronized (c) {
            aVar = (a) c.get(str);
            if (aVar == null) {
                try {
                    aVar = b(context, str);
                    c.put(str, aVar);
                } catch (Context context2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", context2);
                } catch (Context context22) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", context22);
                }
            }
        }
        return aVar;
    }

    private static a b(Context context, String str) {
        a bVar = new b(str);
        str = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (str == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = str.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                String name = str.getName();
                File file = null;
                String attributeValue = str.getAttributeValue(null, c.e);
                String attributeValue2 = str.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = a(b, attributeValue2);
                } else if ("files-path".equals(name)) {
                    file = a(context.getFilesDir(), attributeValue2);
                } else if ("cache-path".equals(name)) {
                    file = a(context.getCacheDir(), attributeValue2);
                } else if ("external-path".equals(name)) {
                    file = a(Environment.getExternalStorageDirectory(), attributeValue2);
                } else if ("external-files-path".equals(name)) {
                    file = a(context.getExternalFilesDir(null), attributeValue2);
                }
                if (file != null) {
                    bVar.a(attributeValue, file);
                }
            }
        }
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

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
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
