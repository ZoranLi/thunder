package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class al {

    public static class a {
        byte[] a;
        int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public static class b {
        public Bitmap a;
        public long b;

        public b(Bitmap bitmap, long j) {
            this.a = bitmap;
            this.b = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1) {
            if (options.outHeight != -1) {
                int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
                return (options.outWidth <= round || options.outHeight <= round) ? 1 : Math.min(options.outWidth / round, options.outHeight / round);
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a("decode dimension failed for bitmap.");
        return 1;
    }

    private static a a(String str) {
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2 = null;
        HttpURLConnection httpURLConnection2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(8000);
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.connect();
                int contentLength = httpURLConnection2.getContentLength();
                if (contentLength > ShareConstants.MD5_FILE_BUF_LENGTH) {
                    StringBuilder stringBuilder = new StringBuilder("Bitmap size is too big, max size is 102400  contentLen size is ");
                    stringBuilder.append(contentLength);
                    stringBuilder.append(" from url ");
                    stringBuilder.append(str);
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                    com.xiaomi.channel.commonutils.file.a.a(null);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    StringBuilder stringBuilder2 = new StringBuilder("Invalid Http Response Code ");
                    stringBuilder2.append(responseCode);
                    stringBuilder2.append(" received");
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
                    com.xiaomi.channel.commonutils.file.a.a(null);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                InputStream inputStream3 = httpURLConnection2.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    int i = ShareConstants.MD5_FILE_BUF_LENGTH;
                    while (i > 0) {
                        int read = inputStream3.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        i -= read;
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (i <= 0) {
                        com.xiaomi.channel.commonutils.logger.b.a("length 102400 exhausted.");
                        a aVar = new a(null, ShareConstants.MD5_FILE_BUF_LENGTH);
                        com.xiaomi.channel.commonutils.file.a.a(inputStream3);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return aVar;
                    }
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    a aVar2 = new a(toByteArray, toByteArray.length);
                    com.xiaomi.channel.commonutils.file.a.a(inputStream3);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return aVar2;
                } catch (Throwable e) {
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    inputStream = inputStream3;
                    th = e;
                    httpURLConnection = httpURLConnection3;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                        com.xiaomi.channel.commonutils.file.a.a(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        httpURLConnection2 = httpURLConnection;
                        com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    inputStream2 = inputStream3;
                    th = th4;
                    com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                th = e2;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                com.xiaomi.channel.commonutils.logger.b.a(th);
                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                com.xiaomi.channel.commonutils.file.a.a(inputStream2);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            th = e3;
            inputStream = null;
            httpURLConnection = inputStream;
            com.xiaomi.channel.commonutils.logger.b.a(th);
            com.xiaomi.channel.commonutils.file.a.a(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection2 = null;
            com.xiaomi.channel.commonutils.file.a.a(inputStream2);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static com.xiaomi.push.service.al.b a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:25:0x0046 in {5, 12, 14, 16, 18, 20, 21, 24, 27} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new com.xiaomi.push.service.al$b;
        r1 = 0;
        r2 = 0;
        r0.<init>(r1, r2);
        r5 = a(r5);	 Catch:{ Exception -> 0x0041 }
        if (r5 != 0) goto L_0x0012;
    L_0x000e:
        com.xiaomi.channel.commonutils.file.a.a(r1);
        return r0;
    L_0x0012:
        r2 = r5.b;	 Catch:{ Exception -> 0x0041 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0041 }
        r0.b = r2;	 Catch:{ Exception -> 0x0041 }
        r5 = r5.a;	 Catch:{ Exception -> 0x0041 }
        if (r5 == 0) goto L_0x003b;	 Catch:{ Exception -> 0x0041 }
    L_0x001b:
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0041 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0041 }
        r4 = a(r4, r2);	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r1 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r1.<init>();	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r1.inSampleSize = r4;	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r4 = 0;	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r3 = r5.length;	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r4 = android.graphics.BitmapFactory.decodeByteArray(r5, r4, r3, r1);	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r0.a = r4;	 Catch:{ Exception -> 0x0038, all -> 0x0035 }
        r1 = r2;
        goto L_0x003b;
    L_0x0035:
        r4 = move-exception;
        r1 = r2;
        goto L_0x0047;
    L_0x0038:
        r4 = move-exception;
        r1 = r2;
        goto L_0x0042;
    L_0x003b:
        com.xiaomi.channel.commonutils.file.a.a(r1);
        return r0;
    L_0x003f:
        r4 = move-exception;
        goto L_0x0047;
    L_0x0041:
        r4 = move-exception;
    L_0x0042:
        com.xiaomi.channel.commonutils.logger.b.a(r4);	 Catch:{ all -> 0x003f }
        goto L_0x003b;
        return r0;
    L_0x0047:
        com.xiaomi.channel.commonutils.file.a.a(r1);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.al.a(android.content.Context, java.lang.String):com.xiaomi.push.service.al$b");
    }

    public static Bitmap b(Context context, String str) {
        InputStream openInputStream;
        InputStream openInputStream2;
        Throwable e;
        Uri parse = Uri.parse(str);
        try {
            int a;
            openInputStream = context.getContentResolver().openInputStream(parse);
            try {
                a = a(context, openInputStream);
                openInputStream2 = context.getContentResolver().openInputStream(parse);
            } catch (IOException e2) {
                e = e2;
                openInputStream2 = null;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
                    com.xiaomi.channel.commonutils.file.a.a(openInputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
                    com.xiaomi.channel.commonutils.file.a.a(openInputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                openInputStream2 = null;
                com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
                com.xiaomi.channel.commonutils.file.a.a(openInputStream);
                throw e;
            }
            try {
                Options options = new Options();
                options.inSampleSize = a;
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
                com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
                com.xiaomi.channel.commonutils.file.a.a(openInputStream);
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
                com.xiaomi.channel.commonutils.file.a.a(openInputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            openInputStream2 = null;
            openInputStream = openInputStream2;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
            com.xiaomi.channel.commonutils.file.a.a(openInputStream);
            return null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream2 = null;
            openInputStream = openInputStream2;
            com.xiaomi.channel.commonutils.file.a.a(openInputStream2);
            com.xiaomi.channel.commonutils.file.a.a(openInputStream);
            throw e;
        }
    }
}
