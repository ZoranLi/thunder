package com.baidu.mobads.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Base64;
import com.baidu.mobads.g.g.a;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class b extends File {
    private static DexClassLoader f;
    private e a;
    private Class<?> b;
    private Context c;
    private PublicKey d;
    private IXAdLogger e;

    public b(String str, Context context) {
        this(str, context, null);
    }

    public b(java.lang.String r2, android.content.Context r3, com.baidu.mobads.g.e r4) {
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
        r1 = this;
        r1.<init>(r2);
        r2 = 0;
        r1.b = r2;
        r1.c = r2;
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getAdLogger();
        r1.e = r0;
        r1.c = r3;
        r1.a = r4;
        if (r4 == 0) goto L_0x0023;
    L_0x0018:
        r3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB";	 Catch:{ Exception -> 0x0021 }
        r3 = c(r3);	 Catch:{ Exception -> 0x0021 }
        r1.d = r3;	 Catch:{ Exception -> 0x0021 }
        return;
    L_0x0021:
        r1.d = r2;
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.b.<init>(java.lang.String, android.content.Context, com.baidu.mobads.g.e):void");
    }

    protected void a() {
        if (this.a != null) {
            String a = a(new File(getAbsolutePath()));
            String b = b(this.a.d());
            if (!b.equalsIgnoreCase(a)) {
                StringBuilder stringBuilder = new StringBuilder("doCheckApkIntegrity failed, md5sum: ");
                stringBuilder.append(a);
                stringBuilder.append(", checksum in json info: ");
                stringBuilder.append(b);
                throw new a(stringBuilder.toString());
            }
        }
    }

    protected java.lang.Class<?> b() {
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
        r0 = r2.b;
        if (r0 != 0) goto L_0x0017;
    L_0x0004:
        r0 = new java.io.File;
        r1 = r2.getAbsolutePath();
        r0.<init>(r1);
        r1 = r2.b(r0);	 Catch:{ Exception -> 0x0014 }
        r2.b = r1;	 Catch:{ Exception -> 0x0014 }
        goto L_0x0017;
    L_0x0014:
        r0.delete();
    L_0x0017:
        r0 = r2.b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.b.b():java.lang.Class<?>");
    }

    protected void a(String str) {
        renameTo(new File(str));
    }

    protected double c() {
        return this.a == null ? 0.0d : this.a.b();
    }

    private String b(String str) {
        if (this.d != null) {
            str = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(2, this.d);
                return new String(instance.doFinal(str), "UTF-8").trim();
            } catch (String str2) {
                this.e.e("ErrorWhileVerifySigNature", str2);
            }
        }
        return null;
    }

    private static java.security.PublicKey c(java.lang.String r2) {
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
        r2 = android.util.Base64.decode(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r0 = "RSA";	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r0 = java.security.KeyFactory.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r1 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r1.<init>(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r2 = r0.generatePublic(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        return r2;
    L_0x0015:
        r2 = new java.lang.Exception;
        r0 = "NullPointerException";
        r2.<init>(r0);
        throw r2;
    L_0x001d:
        r2 = new java.lang.Exception;
        r0 = "InvalidKeySpecException";
        r2.<init>(r0);
        throw r2;
    L_0x0025:
        r2 = new java.lang.Exception;
        r0 = "NoSuchAlgorithmException";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.g.b.c(java.lang.String):java.security.PublicKey");
    }

    private String a(File file) {
        String str = "";
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                file = MessageDigest.getInstance("MD5");
                do {
                } while (new DigestInputStream(fileInputStream, file).read(new byte[4096]) != -1);
                file = file.digest();
                String str2 = str;
                for (byte b : file) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
                    str2 = stringBuilder.toString();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (File file2) {
                        this.e.e("XAdLocalApkFile", file2.getMessage());
                    }
                }
                return str2;
            } catch (Exception e) {
                file2 = e;
                inputStream = fileInputStream;
                try {
                    this.e.e("XAdLocalApkFile", file2.getMessage());
                    file2 = "";
                    if (inputStream != null) {
                        return file2;
                    }
                    try {
                        inputStream.close();
                        return file2;
                    } catch (Exception e2) {
                        this.e.e("XAdLocalApkFile", e2.getMessage());
                        return file2;
                    }
                } catch (Throwable th) {
                    file2 = th;
                    fileInputStream = inputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e22) {
                            this.e.e("XAdLocalApkFile", e22.getMessage());
                        }
                    }
                    throw file2;
                }
            } catch (Throwable th2) {
                file2 = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw file2;
            }
        } catch (Exception e3) {
            file2 = e3;
            this.e.e("XAdLocalApkFile", file2.getMessage());
            file2 = "";
            if (inputStream != null) {
                return file2;
            }
            inputStream.close();
            return file2;
        }
    }

    @TargetApi(14)
    private Class<?> b(File file) {
        StringBuilder stringBuilder = new StringBuilder("Android version:");
        stringBuilder.append(VERSION.RELEASE);
        this.e.d("XAdLocalApkFile", stringBuilder.toString());
        Class<?> cls = null;
        try {
            Class<?> cls2;
            synchronized (g.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.c.getFilesDir().getAbsolutePath();
                com.baidu.mobads.a.a.o = System.currentTimeMillis();
                ClassLoader dexClassLoader = new DexClassLoader(absolutePath, absolutePath2, null, classLoader);
                com.baidu.mobads.a.a.p = System.currentTimeMillis();
                f = dexClassLoader;
                StringBuilder stringBuilder2 = new StringBuilder("dexPath=");
                stringBuilder2.append(absolutePath);
                stringBuilder2.append(", cl=");
                stringBuilder2.append(classLoader);
                stringBuilder2.append(", dir=");
                stringBuilder2.append(absolutePath2);
                stringBuilder2.append(", loader=");
                stringBuilder2.append(dexClassLoader);
                stringBuilder2.append(", len=");
                stringBuilder2.append(file.length());
                stringBuilder2.append(", list=");
                stringBuilder2.append(file.list());
                this.e.i("XAdLocalApkFile", stringBuilder2.toString());
                cls2 = Class.forName("com.baidu.mobads.container.AllInOneXAdContainerFactory", true, dexClassLoader);
            }
            cls = cls2;
        } catch (Exception e) {
            String message = e.getMessage();
            this.e.e("XAdLocalApkFile", message);
        }
        StringBuilder stringBuilder3 = new StringBuilder("jar.path=");
        stringBuilder3.append(file.getAbsolutePath());
        stringBuilder3.append(", clz=");
        stringBuilder3.append(cls);
        this.e.i("XAdLocalApkFile", stringBuilder3.toString());
        return cls;
    }

    public static DexClassLoader d() {
        return f;
    }
}
