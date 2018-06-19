package com.android.volley.toolbox;

import android.text.TextUtils;
import com.android.volley.g;
import com.android.volley.q;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DiskBasedCache */
public final class i implements com.android.volley.a {
    private final Map<String, a> a;
    private long b;
    private final File c;
    private final int d;

    /* compiled from: DiskBasedCache */
    static class a {
        long a;
        final String b;
        final String c;
        final long d;
        final long e;
        final long f;
        final long g;
        final List<g> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<g> list) {
            this.b = str;
            if ("".equals(str2) != null) {
                str2 = null;
            }
            this.c = str2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        a(String str, com.android.volley.a.a aVar) {
            List list;
            String str2 = aVar.b;
            long j = aVar.c;
            long j2 = aVar.d;
            long j3 = aVar.e;
            long j4 = aVar.f;
            if (aVar.h != null) {
                list = aVar.h;
            } else {
                list = k.b(aVar.g);
            }
            this(str, str2, j, j2, j3, j4, list);
            this.a = (long) aVar.a.length;
        }

        static a a(b bVar) throws IOException {
            if (i.a((InputStream) bVar) == 538247942) {
                return new a(i.a(bVar), i.a(bVar), i.b((InputStream) bVar), i.b((InputStream) bVar), i.b((InputStream) bVar), i.b((InputStream) bVar), i.b(bVar));
            }
            throw new IOException();
        }

        final boolean a(OutputStream outputStream) {
            try {
                i.a(outputStream, 538247942);
                i.a(outputStream, this.b);
                i.a(outputStream, this.c == null ? "" : this.c);
                i.a(outputStream, this.d);
                i.a(outputStream, this.e);
                i.a(outputStream, this.f);
                i.a(outputStream, this.g);
                List<g> list = this.h;
                if (list != null) {
                    i.a(outputStream, list.size());
                    for (g gVar : list) {
                        i.a(outputStream, gVar.a);
                        i.a(outputStream, gVar.b);
                    }
                } else {
                    i.a(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (OutputStream outputStream2) {
                q.b("%s", outputStream2.toString());
                return false;
            }
        }
    }

    /* compiled from: DiskBasedCache */
    static class b extends FilterInputStream {
        private final long a;
        private long b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.a = j;
        }

        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.b++;
            }
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            bArr = super.read(bArr, i, i2);
            if (bArr != -1) {
                this.b += (long) bArr;
            }
            return bArr;
        }

        final long a() {
            return this.a - this.b;
        }
    }

    private i(File file) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = UtilityImpl.TNET_FILE_SIZE;
    }

    public i(File file, byte b) {
        this(file);
    }

    public final synchronized com.android.volley.a.a a(String str) {
        b bVar;
        a aVar = (a) this.a.get(str);
        if (aVar == null) {
            return null;
        }
        File d = d(str);
        try {
            bVar = new b(new BufferedInputStream(a(d)), d.length());
            if (TextUtils.equals(str, a.a(bVar).b)) {
                byte[] a = a(bVar, bVar.a());
                com.android.volley.a.a aVar2 = new com.android.volley.a.a();
                aVar2.a = a;
                aVar2.b = aVar.c;
                aVar2.c = aVar.d;
                aVar2.d = aVar.e;
                aVar2.e = aVar.f;
                aVar2.f = aVar.g;
                aVar2.g = k.a(aVar.h);
                aVar2.h = Collections.unmodifiableList(aVar.h);
                bVar.close();
                return aVar2;
            }
            q.b("%s: key=%s, found=%s", d.getAbsolutePath(), str, a.a(bVar).b);
            e(str);
            bVar.close();
            return null;
        } catch (IOException e) {
            q.b("%s: %s", d.getAbsolutePath(), e.toString());
            b(str);
            return null;
        } catch (Throwable th) {
            bVar.close();
        }
    }

    public final synchronized void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.c;	 Catch:{ all -> 0x0061 }
        r0 = r0.exists();	 Catch:{ all -> 0x0061 }
        r1 = 0;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0024;	 Catch:{ all -> 0x0061 }
    L_0x000a:
        r0 = r9.c;	 Catch:{ all -> 0x0061 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0022;	 Catch:{ all -> 0x0061 }
    L_0x0012:
        r0 = "Unable to create cache dir %s";	 Catch:{ all -> 0x0061 }
        r2 = 1;	 Catch:{ all -> 0x0061 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0061 }
        r3 = r9.c;	 Catch:{ all -> 0x0061 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0061 }
        r2[r1] = r3;	 Catch:{ all -> 0x0061 }
        com.android.volley.q.c(r0, r2);	 Catch:{ all -> 0x0061 }
    L_0x0022:
        monitor-exit(r9);
        return;
    L_0x0024:
        r0 = r9.c;	 Catch:{ all -> 0x0061 }
        r0 = r0.listFiles();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return;
    L_0x002e:
        r2 = r0.length;	 Catch:{ all -> 0x0061 }
    L_0x002f:
        if (r1 >= r2) goto L_0x005f;	 Catch:{ all -> 0x0061 }
    L_0x0031:
        r3 = r0[r1];	 Catch:{ all -> 0x0061 }
        r4 = r3.length();	 Catch:{ IOException -> 0x0059 }
        r6 = new com.android.volley.toolbox.i$b;	 Catch:{ IOException -> 0x0059 }
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0059 }
        r8 = a(r3);	 Catch:{ IOException -> 0x0059 }
        r7.<init>(r8);	 Catch:{ IOException -> 0x0059 }
        r6.<init>(r7, r4);	 Catch:{ IOException -> 0x0059 }
        r7 = com.android.volley.toolbox.i.a.a(r6);	 Catch:{ all -> 0x0054 }
        r7.a = r4;	 Catch:{ all -> 0x0054 }
        r4 = r7.b;	 Catch:{ all -> 0x0054 }
        r9.a(r4, r7);	 Catch:{ all -> 0x0054 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x005c;	 Catch:{ IOException -> 0x0059 }
    L_0x0054:
        r4 = move-exception;	 Catch:{ IOException -> 0x0059 }
        r6.close();	 Catch:{ IOException -> 0x0059 }
        throw r4;	 Catch:{ IOException -> 0x0059 }
    L_0x0059:
        r3.delete();	 Catch:{ all -> 0x0061 }
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x002f;
    L_0x005f:
        monitor-exit(r9);
        return;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.i.a():void");
    }

    public final synchronized void a(java.lang.String r20, com.android.volley.a.a r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r3 = r21;
        monitor-enter(r19);
        r4 = r3.a;	 Catch:{ all -> 0x011b }
        r4 = r4.length;	 Catch:{ all -> 0x011b }
        r5 = r1.b;	 Catch:{ all -> 0x011b }
        r7 = (long) r4;	 Catch:{ all -> 0x011b }
        r9 = r5 + r7;	 Catch:{ all -> 0x011b }
        r4 = r1.d;	 Catch:{ all -> 0x011b }
        r4 = (long) r4;	 Catch:{ all -> 0x011b }
        r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));	 Catch:{ all -> 0x011b }
        r5 = 0;	 Catch:{ all -> 0x011b }
        if (r6 < 0) goto L_0x00c4;	 Catch:{ all -> 0x011b }
    L_0x0017:
        r6 = com.android.volley.q.b;	 Catch:{ all -> 0x011b }
        if (r6 == 0) goto L_0x0022;	 Catch:{ all -> 0x011b }
    L_0x001b:
        r6 = "Pruning old cache entries.";	 Catch:{ all -> 0x011b }
        r9 = new java.lang.Object[r5];	 Catch:{ all -> 0x011b }
        com.android.volley.q.a(r6, r9);	 Catch:{ all -> 0x011b }
    L_0x0022:
        r9 = r1.b;	 Catch:{ all -> 0x011b }
        r11 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x011b }
        r6 = r1.a;	 Catch:{ all -> 0x011b }
        r6 = r6.entrySet();	 Catch:{ all -> 0x011b }
        r6 = r6.iterator();	 Catch:{ all -> 0x011b }
        r13 = r5;	 Catch:{ all -> 0x011b }
    L_0x0033:
        r14 = r6.hasNext();	 Catch:{ all -> 0x011b }
        r15 = 2;	 Catch:{ all -> 0x011b }
        if (r14 == 0) goto L_0x0098;	 Catch:{ all -> 0x011b }
    L_0x003a:
        r14 = r6.next();	 Catch:{ all -> 0x011b }
        r14 = (java.util.Map.Entry) r14;	 Catch:{ all -> 0x011b }
        r14 = r14.getValue();	 Catch:{ all -> 0x011b }
        r14 = (com.android.volley.toolbox.i.a) r14;	 Catch:{ all -> 0x011b }
        r4 = r14.b;	 Catch:{ all -> 0x011b }
        r4 = r1.d(r4);	 Catch:{ all -> 0x011b }
        r4 = r4.delete();	 Catch:{ all -> 0x011b }
        if (r4 == 0) goto L_0x0061;	 Catch:{ all -> 0x011b }
    L_0x0052:
        r16 = r6;	 Catch:{ all -> 0x011b }
        r5 = r1.b;	 Catch:{ all -> 0x011b }
        r3 = r14.a;	 Catch:{ all -> 0x011b }
        r17 = r11;	 Catch:{ all -> 0x011b }
        r11 = r5 - r3;	 Catch:{ all -> 0x011b }
        r1.b = r11;	 Catch:{ all -> 0x011b }
    L_0x005e:
        r3 = r16;	 Catch:{ all -> 0x011b }
        goto L_0x007b;	 Catch:{ all -> 0x011b }
    L_0x0061:
        r16 = r6;	 Catch:{ all -> 0x011b }
        r17 = r11;	 Catch:{ all -> 0x011b }
        r3 = "Could not delete cache entry for key=%s, filename=%s";	 Catch:{ all -> 0x011b }
        r4 = new java.lang.Object[r15];	 Catch:{ all -> 0x011b }
        r5 = r14.b;	 Catch:{ all -> 0x011b }
        r6 = 0;	 Catch:{ all -> 0x011b }
        r4[r6] = r5;	 Catch:{ all -> 0x011b }
        r5 = r14.b;	 Catch:{ all -> 0x011b }
        r5 = c(r5);	 Catch:{ all -> 0x011b }
        r6 = 1;	 Catch:{ all -> 0x011b }
        r4[r6] = r5;	 Catch:{ all -> 0x011b }
        com.android.volley.q.b(r3, r4);	 Catch:{ all -> 0x011b }
        goto L_0x005e;	 Catch:{ all -> 0x011b }
    L_0x007b:
        r3.remove();	 Catch:{ all -> 0x011b }
        r13 = r13 + 1;	 Catch:{ all -> 0x011b }
        r4 = r1.b;	 Catch:{ all -> 0x011b }
        r11 = r4 + r7;	 Catch:{ all -> 0x011b }
        r4 = (float) r11;	 Catch:{ all -> 0x011b }
        r5 = r1.d;	 Catch:{ all -> 0x011b }
        r5 = (float) r5;	 Catch:{ all -> 0x011b }
        r6 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;	 Catch:{ all -> 0x011b }
        r5 = r5 * r6;	 Catch:{ all -> 0x011b }
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));	 Catch:{ all -> 0x011b }
        if (r4 >= 0) goto L_0x0091;	 Catch:{ all -> 0x011b }
    L_0x0090:
        goto L_0x009a;	 Catch:{ all -> 0x011b }
    L_0x0091:
        r6 = r3;	 Catch:{ all -> 0x011b }
        r11 = r17;	 Catch:{ all -> 0x011b }
        r3 = r21;	 Catch:{ all -> 0x011b }
        r5 = 0;	 Catch:{ all -> 0x011b }
        goto L_0x0033;	 Catch:{ all -> 0x011b }
    L_0x0098:
        r17 = r11;	 Catch:{ all -> 0x011b }
    L_0x009a:
        r3 = com.android.volley.q.b;	 Catch:{ all -> 0x011b }
        if (r3 == 0) goto L_0x00c4;	 Catch:{ all -> 0x011b }
    L_0x009e:
        r3 = "pruned %d files, %d bytes, %d ms";	 Catch:{ all -> 0x011b }
        r4 = 3;	 Catch:{ all -> 0x011b }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x011b }
        r5 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x011b }
        r6 = 0;	 Catch:{ all -> 0x011b }
        r4[r6] = r5;	 Catch:{ all -> 0x011b }
        r5 = r1.b;	 Catch:{ all -> 0x011b }
        r7 = r5 - r9;	 Catch:{ all -> 0x011b }
        r5 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x011b }
        r6 = 1;	 Catch:{ all -> 0x011b }
        r4[r6] = r5;	 Catch:{ all -> 0x011b }
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x011b }
        r7 = r5 - r17;	 Catch:{ all -> 0x011b }
        r5 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x011b }
        r4[r15] = r5;	 Catch:{ all -> 0x011b }
        com.android.volley.q.a(r3, r4);	 Catch:{ all -> 0x011b }
    L_0x00c4:
        r3 = r19.d(r20);	 Catch:{ all -> 0x011b }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0104 }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0104 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x0104 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0104 }
        r5 = new com.android.volley.toolbox.i$a;	 Catch:{ IOException -> 0x0104 }
        r6 = r21;	 Catch:{ IOException -> 0x0104 }
        r5.<init>(r2, r6);	 Catch:{ IOException -> 0x0104 }
        r7 = r5.a(r4);	 Catch:{ IOException -> 0x0104 }
        if (r7 != 0) goto L_0x00f7;	 Catch:{ IOException -> 0x0104 }
    L_0x00df:
        r4.close();	 Catch:{ IOException -> 0x0104 }
        r2 = "Failed to write header for %s";	 Catch:{ IOException -> 0x0104 }
        r4 = 1;	 Catch:{ IOException -> 0x0104 }
        r5 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0104 }
        r4 = r3.getAbsolutePath();	 Catch:{ IOException -> 0x0104 }
        r6 = 0;	 Catch:{ IOException -> 0x0104 }
        r5[r6] = r4;	 Catch:{ IOException -> 0x0104 }
        com.android.volley.q.b(r2, r5);	 Catch:{ IOException -> 0x0104 }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x0104 }
        r2.<init>();	 Catch:{ IOException -> 0x0104 }
        throw r2;	 Catch:{ IOException -> 0x0104 }
    L_0x00f7:
        r6 = r6.a;	 Catch:{ IOException -> 0x0104 }
        r4.write(r6);	 Catch:{ IOException -> 0x0104 }
        r4.close();	 Catch:{ IOException -> 0x0104 }
        r1.a(r2, r5);	 Catch:{ IOException -> 0x0104 }
        monitor-exit(r19);
        return;
    L_0x0104:
        r2 = r3.delete();	 Catch:{ all -> 0x011b }
        if (r2 != 0) goto L_0x0119;	 Catch:{ all -> 0x011b }
    L_0x010a:
        r2 = "Could not clean up file %s";	 Catch:{ all -> 0x011b }
        r4 = 1;	 Catch:{ all -> 0x011b }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x011b }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x011b }
        r5 = 0;	 Catch:{ all -> 0x011b }
        r4[r5] = r3;	 Catch:{ all -> 0x011b }
        com.android.volley.q.b(r2, r4);	 Catch:{ all -> 0x011b }
    L_0x0119:
        monitor-exit(r19);
        return;
    L_0x011b:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r19);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.i.a(java.lang.String, com.android.volley.a$a):void");
    }

    private synchronized void b(String str) {
        boolean delete = d(str).delete();
        e(str);
        if (!delete) {
            q.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    private static String c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(valueOf);
        stringBuilder.append(String.valueOf(str.substring(length).hashCode()));
        return stringBuilder.toString();
    }

    private File d(String str) {
        return new File(this.c, c(str));
    }

    private void a(String str, a aVar) {
        if (this.a.containsKey(str)) {
            this.b += aVar.a - ((a) this.a.get(str)).a;
        } else {
            this.b += aVar.a;
        }
        this.a.put(str, aVar);
    }

    private void e(String str) {
        a aVar = (a) this.a.remove(str);
        if (aVar != null) {
            this.b -= aVar.a;
        }
    }

    private static byte[] a(b bVar, long j) throws IOException {
        long a = bVar.a();
        if (j >= 0 && j <= a) {
            int i = (int) j;
            if (((long) i) == j) {
                j = new byte[i];
                new DataInputStream(bVar).readFully(j);
                return j;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("streamToBytes length=");
        stringBuilder.append(j);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(a);
        throw new IOException(stringBuilder.toString());
    }

    private static InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int c(InputStream inputStream) throws IOException {
        inputStream = inputStream.read();
        if (inputStream != -1) {
            return inputStream;
        }
        throw new EOFException();
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws IOException {
        return (c(inputStream) << 24) | ((((c(inputStream) << 0) | 0) | (c(inputStream) << 8)) | (c(inputStream) << 16));
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> null)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long b(InputStream inputStream) throws IOException {
        return (((((((0 | ((((long) c(inputStream)) & 255) << null)) | ((((long) c(inputStream)) & 255) << 8)) | ((((long) c(inputStream)) & 255) << 16)) | ((((long) c(inputStream)) & 255) << 24)) | ((((long) c(inputStream)) & 255) << 32)) | ((((long) c(inputStream)) & 255) << 40)) | ((((long) c(inputStream)) & 255) << 48)) | ((((long) c(inputStream)) & 255) << 56);
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        str = str.getBytes("UTF-8");
        a(outputStream, (long) str.length);
        outputStream.write(str, 0, str.length);
    }

    static String a(b bVar) throws IOException {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    static List<g> b(b bVar) throws IOException {
        int a = a((InputStream) bVar);
        List<g> emptyList = a == 0 ? Collections.emptyList() : new ArrayList(a);
        for (int i = 0; i < a; i++) {
            emptyList.add(new g(a(bVar).intern(), a(bVar).intern()));
        }
        return emptyList;
    }
}
