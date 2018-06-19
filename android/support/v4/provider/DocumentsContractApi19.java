package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;

@RequiresApi(19)
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isVirtual(Context context, Uri uri) {
        if (isDocumentUri(context, uri) && (getFlags(context, uri) & 512) != null) {
            return true;
        }
        return false;
    }

    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        context = getRawType(context, uri);
        return "vnd.android.document/directory".equals(context) != null ? null : context;
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, Constants.KEY_FLAGS, 0);
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        context = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(context) == null) {
            if (TextUtils.isEmpty(context) == null) {
                return true;
            }
        }
        return null;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0);
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && TextUtils.isEmpty(getRawType(context, uri)) == null;
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        CharSequence rawType = getRawType(context, uri);
        context = queryForInt(context, uri, Constants.KEY_FLAGS, 0);
        if (TextUtils.isEmpty(rawType) != null) {
            return false;
        }
        if ((context & 4) != null) {
            return true;
        }
        if ("vnd.android.document/directory".equals(rawType) != null && (context & 8) != null) {
            return true;
        }
        if (TextUtils.isEmpty(rawType) != null || (context & 2) == null) {
            return false;
        }
        return true;
    }

    public static boolean delete(android.content.Context r0, android.net.Uri r1) {
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
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x0009 }
        r0 = android.provider.DocumentsContract.deleteDocument(r0, r1);	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.DocumentsContractApi19.delete(android.content.Context, android.net.Uri):boolean");
    }

    public static boolean exists(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        context = true;
        AutoCloseable autoCloseable = null;
        try {
            uri = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
            try {
                if (uri.getCount() <= 0) {
                    context = null;
                }
                closeQuietly(uri);
                return context;
            } catch (Exception e) {
                context = e;
                autoCloseable = uri;
                try {
                    new StringBuilder("Failed query: ").append(context);
                    closeQuietly(autoCloseable);
                    return false;
                } catch (Throwable th) {
                    context = th;
                    closeQuietly(autoCloseable);
                    throw context;
                }
            } catch (Throwable th2) {
                context = th2;
                autoCloseable = uri;
                closeQuietly(autoCloseable);
                throw context;
            }
        } catch (Exception e2) {
            context = e2;
            new StringBuilder("Failed query: ").append(context);
            closeQuietly(autoCloseable);
            return false;
        }
    }

    private static String queryForString(Context context, Uri uri, String str, String str2) {
        AutoCloseable autoCloseable = null;
        try {
            uri = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (uri.moveToFirst() == null || uri.isNull(0) != null) {
                    closeQuietly(uri);
                    return str2;
                }
                context = uri.getString(0);
                closeQuietly(uri);
                return context;
            } catch (Exception e) {
                context = e;
                autoCloseable = uri;
                try {
                    new StringBuilder("Failed query: ").append(context);
                    closeQuietly(autoCloseable);
                    return str2;
                } catch (Throwable th) {
                    context = th;
                    closeQuietly(autoCloseable);
                    throw context;
                }
            } catch (Throwable th2) {
                context = th2;
                autoCloseable = uri;
                closeQuietly(autoCloseable);
                throw context;
            }
        } catch (Exception e2) {
            context = e2;
            new StringBuilder("Failed query: ").append(context);
            closeQuietly(autoCloseable);
            return str2;
        }
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, (long) i);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j) {
        AutoCloseable autoCloseable = null;
        try {
            uri = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (uri.moveToFirst() == null || uri.isNull(0) != null) {
                    closeQuietly(uri);
                    return j;
                }
                long j2 = uri.getLong(0);
                closeQuietly(uri);
                return j2;
            } catch (Exception e) {
                context = e;
                autoCloseable = uri;
                try {
                    new StringBuilder("Failed query: ").append(context);
                    closeQuietly(autoCloseable);
                    return j;
                } catch (Throwable th) {
                    context = th;
                    closeQuietly(autoCloseable);
                    throw context;
                }
            } catch (Throwable th2) {
                context = th2;
                autoCloseable = uri;
                closeQuietly(autoCloseable);
                throw context;
            }
        } catch (Exception e2) {
            context = e2;
            new StringBuilder("Failed query: ").append(context);
            closeQuietly(autoCloseable);
            return j;
        }
    }

    private static void closeQuietly(java.lang.AutoCloseable r0) {
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
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.DocumentsContractApi19.closeQuietly(java.lang.AutoCloseable):void");
    }
}
