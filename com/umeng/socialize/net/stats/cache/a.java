package com.umeng.socialize.net.stats.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AtomicFile */
public class a {
    private final File a;
    private final File b;

    public a(File file) {
        this.a = file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        this.b = new File(stringBuilder.toString());
    }

    public File a() {
        return this.a;
    }

    public void b() {
        this.a.delete();
        this.b.delete();
    }

    public java.io.FileOutputStream a(boolean r3) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.a;
        r0 = r0.exists();
        if (r0 == 0) goto L_0x003e;
    L_0x0008:
        r0 = r2.b;
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0039;
    L_0x0010:
        r0 = r2.a;
        r1 = r2.b;
        r0 = r0.renameTo(r1);
        if (r0 != 0) goto L_0x0031;
    L_0x001a:
        r0 = new java.lang.StringBuilder;
        r1 = "Couldn't rename file ";
        r0.<init>(r1);
        r1 = r2.a;
        r0.append(r1);
        r1 = " to backup file ";
        r0.append(r1);
        r1 = r2.b;
        r0.append(r1);
        goto L_0x003e;
    L_0x0031:
        r0 = r2.b;
        r1 = r2.a;
        a(r0, r1);
        goto L_0x003e;
    L_0x0039:
        r0 = r2.a;
        r0.delete();
    L_0x003e:
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0046 }
        r1 = r2.a;	 Catch:{ FileNotFoundException -> 0x0046 }
        r0.<init>(r1, r3);	 Catch:{ FileNotFoundException -> 0x0046 }
        goto L_0x006f;
    L_0x0046:
        r0 = r2.a;
        r0 = r0.getParentFile();
        r0 = r0.mkdirs();
        if (r0 != 0) goto L_0x0068;
    L_0x0052:
        r3 = new java.io.IOException;
        r0 = new java.lang.StringBuilder;
        r1 = "Couldn't create directory ";
        r0.<init>(r1);
        r1 = r2.a;
        r0.append(r1);
        r0 = r0.toString();
        r3.<init>(r0);
        throw r3;
    L_0x0068:
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0070 }
        r1 = r2.a;	 Catch:{ FileNotFoundException -> 0x0070 }
        r0.<init>(r1, r3);	 Catch:{ FileNotFoundException -> 0x0070 }
    L_0x006f:
        return r0;
    L_0x0070:
        r3 = new java.io.IOException;
        r0 = new java.lang.StringBuilder;
        r1 = "Couldn't create ";
        r0.<init>(r1);
        r1 = r2.a;
        r0.append(r1);
        r0 = r0.toString();
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.stats.cache.a.a(boolean):java.io.FileOutputStream");
    }

    private static void a(File file, File file2) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                file = new FileOutputStream(file2);
            } catch (Throwable th) {
                file2 = th;
                file = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file != null) {
                    file.close();
                }
                throw file2;
            }
            try {
                file2 = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(file2);
                    if (read > 0) {
                        file.write(file2, 0, read);
                        new StringBuilder().append(read);
                    } else {
                        fileInputStream.close();
                        file.close();
                        new StringBuilder("comsum time:").append(System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                }
            } catch (Throwable th2) {
                file2 = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file != null) {
                    file.close();
                }
                throw file2;
            }
        } catch (Throwable th3) {
            file2 = th3;
            file = null;
            fileInputStream = file;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (file != null) {
                file.close();
            }
            throw file2;
        }
    }

    public void a(java.io.FileOutputStream r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x000e;
    L_0x0002:
        c(r1);
        r1.close();	 Catch:{ IOException -> 0x000e }
        r1 = r0.b;	 Catch:{ IOException -> 0x000e }
        r1.delete();	 Catch:{ IOException -> 0x000e }
        return;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.stats.cache.a.a(java.io.FileOutputStream):void");
    }

    public void b(java.io.FileOutputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        if (r2 == 0) goto L_0x0015;
    L_0x0002:
        c(r2);
        r2.close();	 Catch:{ IOException -> 0x0015 }
        r2 = r1.a;	 Catch:{ IOException -> 0x0015 }
        r2.delete();	 Catch:{ IOException -> 0x0015 }
        r2 = r1.b;	 Catch:{ IOException -> 0x0015 }
        r0 = r1.a;	 Catch:{ IOException -> 0x0015 }
        r2.renameTo(r0);	 Catch:{ IOException -> 0x0015 }
        return;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.stats.cache.a.b(java.io.FileOutputStream):void");
    }

    public FileInputStream c() throws FileNotFoundException {
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public byte[] d() throws IOException {
        FileInputStream c = c();
        try {
            byte[] bArr = new byte[c.available()];
            int i = 0;
            while (true) {
                int read = c.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    break;
                }
                i += read;
                read = c.available();
                if (read > bArr.length - i) {
                    Object obj = new byte[(read + i)];
                    System.arraycopy(bArr, 0, obj, 0, i);
                    bArr = obj;
                }
            }
            return bArr;
        } finally {
            c.close();
        }
    }

    static boolean c(java.io.FileOutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x000c;
    L_0x0002:
        r0 = r0.getFD();	 Catch:{ IOException -> 0x000a }
        r0.sync();	 Catch:{ IOException -> 0x000a }
        goto L_0x000c;
    L_0x000a:
        r0 = 0;
        return r0;
    L_0x000c:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.stats.cache.a.c(java.io.FileOutputStream):boolean");
    }
}
