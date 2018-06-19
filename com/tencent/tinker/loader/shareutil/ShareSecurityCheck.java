package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.HashMap;

/* compiled from: BUGLY */
public class ShareSecurityCheck {
    private static final String TAG = "Tinker.SecurityCheck";
    private static String mPublicKeyMd5;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap();
    private final HashMap<String, String> packageProperties = new HashMap();

    public ShareSecurityCheck(Context context) {
        this.mContext = context;
        if (mPublicKeyMd5 == null) {
            init(this.mContext);
        }
    }

    public HashMap<String, String> getMetaContentMap() {
        return this.metaContentMap;
    }

    public HashMap<String, String> getPackagePropertiesIfPresent() {
        if (!this.packageProperties.isEmpty()) {
            return this.packageProperties;
        }
        String str = (String) this.metaContentMap.get(ShareConstants.PACKAGE_META_FILE);
        if (str == null) {
            return null;
        }
        for (String str2 : str.split("\n")) {
            if (!(str2 == null || str2.length() <= 0 || str2.startsWith("#"))) {
                String[] split = str2.split("=", 2);
                if (split != null && split.length >= 2) {
                    this.packageProperties.put(split[0].trim(), split[1].trim());
                }
            }
        }
        return this.packageProperties;
    }

    public boolean verifyPatchMetaSignature(java.io.File r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.isLegalFile(r11);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = 0;
        r2 = 1;
        r3 = new java.util.jar.JarFile;	 Catch:{ Exception -> 0x0060, all -> 0x005c }
        r3.<init>(r11);	 Catch:{ Exception -> 0x0060, all -> 0x005c }
        r0 = r3.entries();	 Catch:{ Exception -> 0x005a }
    L_0x0013:
        r4 = r0.hasMoreElements();	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x005a }
    L_0x0019:
        r4 = r0.nextElement();	 Catch:{ Exception -> 0x005a }
        r4 = (java.util.jar.JarEntry) r4;	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x005a }
    L_0x0021:
        r5 = r4.getName();	 Catch:{ Exception -> 0x005a }
        r6 = "META-INF/";	 Catch:{ Exception -> 0x005a }
        r6 = r5.startsWith(r6);	 Catch:{ Exception -> 0x005a }
        if (r6 != 0) goto L_0x0013;	 Catch:{ Exception -> 0x005a }
    L_0x002d:
        r6 = "meta.txt";	 Catch:{ Exception -> 0x005a }
        r6 = r5.endsWith(r6);	 Catch:{ Exception -> 0x005a }
        if (r6 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x005a }
    L_0x0035:
        r6 = r10.metaContentMap;	 Catch:{ Exception -> 0x005a }
        r7 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.loadDigestes(r3, r4);	 Catch:{ Exception -> 0x005a }
        r6.put(r5, r7);	 Catch:{ Exception -> 0x005a }
        r4 = r4.getCertificates();	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x004a;	 Catch:{ Exception -> 0x005a }
    L_0x0044:
        r4 = r10.check(r11, r4);	 Catch:{ Exception -> 0x005a }
        if (r4 != 0) goto L_0x0013;
    L_0x004a:
        r3.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0051;
    L_0x004e:
        r11.getAbsolutePath();
    L_0x0051:
        return r1;
    L_0x0052:
        r3.close();	 Catch:{ IOException -> 0x0056 }
        goto L_0x0059;
    L_0x0056:
        r11.getAbsolutePath();
    L_0x0059:
        return r2;
    L_0x005a:
        r0 = move-exception;
        goto L_0x0064;
    L_0x005c:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
        goto L_0x0084;
    L_0x0060:
        r3 = move-exception;
        r9 = r3;
        r3 = r0;
        r0 = r9;
    L_0x0064:
        r4 = new com.tencent.tinker.loader.TinkerRuntimeException;	 Catch:{ all -> 0x0083 }
        r5 = "ShareSecurityCheck file %s, size %d verifyPatchMetaSignature fail";	 Catch:{ all -> 0x0083 }
        r6 = 2;	 Catch:{ all -> 0x0083 }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0083 }
        r7 = r11.getAbsolutePath();	 Catch:{ all -> 0x0083 }
        r6[r1] = r7;	 Catch:{ all -> 0x0083 }
        r7 = r11.length();	 Catch:{ all -> 0x0083 }
        r1 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x0083 }
        r6[r2] = r1;	 Catch:{ all -> 0x0083 }
        r1 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x0083 }
        r4.<init>(r1, r0);	 Catch:{ all -> 0x0083 }
        throw r4;	 Catch:{ all -> 0x0083 }
    L_0x0083:
        r0 = move-exception;
    L_0x0084:
        if (r3 == 0) goto L_0x008d;
    L_0x0086:
        r3.close();	 Catch:{ IOException -> 0x008a }
        goto L_0x008d;
    L_0x008a:
        r11.getAbsolutePath();
    L_0x008d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareSecurityCheck.verifyPatchMetaSignature(java.io.File):boolean");
    }

    private boolean check(java.io.File r5, java.security.cert.Certificate[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r6.length;
        if (r0 <= 0) goto L_0x0021;
    L_0x0003:
        r0 = 1;
        r1 = r6.length;
        r1 = r1 - r0;
    L_0x0006:
        if (r1 < 0) goto L_0x0021;
    L_0x0008:
        r2 = mPublicKeyMd5;	 Catch:{ Exception -> 0x001b }
        r3 = r6[r1];	 Catch:{ Exception -> 0x001b }
        r3 = r3.getEncoded();	 Catch:{ Exception -> 0x001b }
        r3 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(r3);	 Catch:{ Exception -> 0x001b }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x001b }
        if (r2 == 0) goto L_0x001e;
    L_0x001a:
        return r0;
    L_0x001b:
        r5.getAbsolutePath();
    L_0x001e:
        r1 = r1 + -1;
        goto L_0x0006;
    L_0x0021:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareSecurityCheck.check(java.io.File, java.security.cert.Certificate[]):boolean");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private void init(Context context) {
        try {
            context = SharePatchFileUtil.getMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            mPublicKeyMd5 = context;
            if (context == null) {
                throw new TinkerRuntimeException("get public key md5 is null");
            }
            SharePatchFileUtil.closeQuietly(null);
        } catch (Context context2) {
            throw new TinkerRuntimeException("ShareSecurityCheck init public key fail", context2);
        } catch (Throwable th) {
            SharePatchFileUtil.closeQuietly(null);
        }
    }
}
