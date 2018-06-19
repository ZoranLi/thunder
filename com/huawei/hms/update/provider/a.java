package com.huawei.hms.update.provider;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;

/* compiled from: ContentUriHelper */
class a {
    private Context a;
    private String b;

    a() {
    }

    public void a(Context context) {
        com.huawei.hms.c.a.a(context, "context nust not be null.");
        this.a = context;
    }

    public File a(String str) {
        String a = a();
        if (a == null) {
            return null;
        }
        return b(new File(a, str));
    }

    private String a() {
        String str;
        Context context = (Context) com.huawei.hms.c.a.b(this.a, "mContext is null, call setContext first.");
        synchronized (this) {
            if (this.b == null) {
                if (context.getExternalCacheDir() != null) {
                    this.b = a(context.getExternalCacheDir());
                } else {
                    this.b = a(context.getFilesDir());
                }
            }
            str = this.b;
        }
        return str;
    }

    public Uri a(File file, String str) {
        String a = a(file);
        if (a == null) {
            return null;
        }
        file = b(a);
        if (file == null) {
            return null;
        }
        return new Builder().scheme("content").authority(str).encodedPath(file).build();
    }

    private String b(String str) {
        String a = a();
        if (a == null || !str.startsWith(a)) {
            return null;
        }
        int length;
        if (a.endsWith("/")) {
            length = a.length();
        } else {
            length = a.length() + 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Uri.encode("ContentUriHelper"));
        stringBuilder.append('/');
        stringBuilder.append(str.substring(length));
        return stringBuilder.toString();
    }

    public File a(Uri uri) {
        uri = uri.getEncodedPath();
        if (uri == null) {
            return null;
        }
        uri = c(uri);
        if (uri == null) {
            return null;
        }
        return b(new File(uri));
    }

    private String c(String str) {
        String a = a();
        if (a == null) {
            return null;
        }
        int indexOf = str.indexOf(47, 1);
        if (indexOf < 0) {
            return null;
        }
        if (!"ContentUriHelper".equals(Uri.decode(str.substring(1, indexOf)))) {
            return null;
        }
        str = a(new File(a, Uri.decode(str.substring(indexOf + 1))));
        if (str != null && str.startsWith(a)) {
            return str;
        }
        return null;
    }

    private static java.lang.String a(java.io.File r1) {
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
        r0 = 0;
        if (r1 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r1.getCanonicalPath();	 Catch:{ IOException -> 0x0009 }
        return r1;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.provider.a.a(java.io.File):java.lang.String");
    }

    private static java.io.File b(java.io.File r1) {
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
        r0 = 0;
        if (r1 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r1.getCanonicalFile();	 Catch:{ IOException -> 0x0009 }
        return r1;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.provider.a.b(java.io.File):java.io.File");
    }
}
