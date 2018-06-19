package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants.PLUGIN;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request.Method;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final Pattern a = Pattern.compile(".*plugin\\.dex-(\\d+)\\.jar.*");
    private final Context b;
    private PM$a$a c;

    class a implements NetworkCallBack {
        private final String a;
        private final int b;
        private /* synthetic */ a c;

        public a(a aVar, String str, int i) {
            this.c = aVar;
            this.a = str;
            this.b = i;
        }

        private static String a(Response response, File file) {
            InputStream streamContent;
            OutputStream fileOutputStream;
            Throwable e;
            String str;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                streamContent = response.getStreamContent();
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                    str = "IOException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    fileOutputStream = null;
                    try {
                        str = "MD5SUMException While Update Plugin";
                        GDTLogger.e(str, e);
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        FileUtil.tryClose(streamContent);
                        FileUtil.tryClose(fileOutputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    throw e;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = streamContent.read(bArr);
                        if (read > 0) {
                            instance.update(bArr, 0, read);
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            FileUtil.tryClose(streamContent);
                            FileUtil.tryClose(fileOutputStream);
                            String byteArrayToHexString = Md5Util.byteArrayToHexString(instance.digest());
                            FileUtil.tryClose(streamContent);
                            FileUtil.tryClose(fileOutputStream);
                            return byteArrayToHexString;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    str = "IOException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    str = "MD5SUMException While Update Plugin";
                    GDTLogger.e(str, e);
                    FileUtil.tryClose(streamContent);
                    FileUtil.tryClose(fileOutputStream);
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
                streamContent = null;
                fileOutputStream = streamContent;
                str = "IOException While Update Plugin";
                GDTLogger.e(str, e);
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                streamContent = null;
                fileOutputStream = streamContent;
                str = "MD5SUMException While Update Plugin";
                GDTLogger.e(str, e);
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                return null;
            } catch (Throwable th3) {
                e = th3;
                streamContent = null;
                fileOutputStream = streamContent;
                FileUtil.tryClose(streamContent);
                FileUtil.tryClose(fileOutputStream);
                throw e;
            }
        }

        private void a() {
            if (this.c.c != null) {
                this.c.c.b();
            }
        }

        private boolean a(File file) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("#####");
            stringBuilder.append(this.a);
            try {
                StringUtil.writeTo(stringBuilder.toString(), file);
                return true;
            } catch (Throwable e) {
                GDTLogger.e("IOException While Update Plugin", e);
                return false;
            }
        }

        public final void onException(Exception exception) {
            GDTLogger.w("Exception While Update Plugin", exception);
            a();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onResponse(com.qq.e.comm.net.rr.Request r5, com.qq.e.comm.net.rr.Response r6) {
            /*
            r4 = this;
            r5 = r6.getStatusCode();
            r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r5 != r0) goto L_0x0112;
        L_0x0008:
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.b;	 Catch:{ Throwable -> 0x00c9 }
            r0 = new java.io.File;	 Catch:{ Throwable -> 0x00c9 }
            r1 = "e_qq_com_plugin";
            r2 = 0;
            r5 = r5.getDir(r1, r2);	 Catch:{ Throwable -> 0x00c9 }
            r1 = "gdt_plugin.tmp";
            r0.<init>(r5, r1);	 Catch:{ Throwable -> 0x00c9 }
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.b;	 Catch:{ Throwable -> 0x00c9 }
            r1 = new java.io.File;	 Catch:{ Throwable -> 0x00c9 }
            r3 = "e_qq_com_plugin";
            r5 = r5.getDir(r3, r2);	 Catch:{ Throwable -> 0x00c9 }
            r3 = "gdt_plugin.tmp.sig";
            r1.<init>(r5, r3);	 Catch:{ Throwable -> 0x00c9 }
            r5 = a(r6, r0);	 Catch:{ Throwable -> 0x00c9 }
            r6 = com.qq.e.comm.util.a.a();	 Catch:{ Throwable -> 0x00c9 }
            r3 = r4.a;	 Catch:{ Throwable -> 0x00c9 }
            r6 = r6.b(r3, r5);	 Catch:{ Throwable -> 0x00c9 }
            r3 = 1;
            if (r6 == 0) goto L_0x008f;
        L_0x0040:
            r5 = r4.a(r1);	 Catch:{ Throwable -> 0x00c9 }
            if (r5 == 0) goto L_0x006c;
        L_0x0046:
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.b;	 Catch:{ Throwable -> 0x00c9 }
            r5 = com.qq.e.comm.managers.plugin.PM$1.b(r5);	 Catch:{ Throwable -> 0x00c9 }
            r5 = com.qq.e.comm.util.FileUtil.renameTo(r0, r5);	 Catch:{ Throwable -> 0x00c9 }
            if (r5 == 0) goto L_0x0068;
        L_0x0056:
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.b;	 Catch:{ Throwable -> 0x00c9 }
            r5 = com.qq.e.comm.managers.plugin.PM$1.d(r5);	 Catch:{ Throwable -> 0x00c9 }
            r5 = com.qq.e.comm.util.FileUtil.renameTo(r1, r5);	 Catch:{ Throwable -> 0x00c9 }
            if (r5 == 0) goto L_0x0068;
        L_0x0066:
            r5 = r3;
            goto L_0x0069;
        L_0x0068:
            r5 = r2;
        L_0x0069:
            if (r5 == 0) goto L_0x006c;
        L_0x006b:
            r2 = r3;
        L_0x006c:
            r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00c9 }
            r6 = "PluginUpdateSucc:";
            r5.<init>(r6);	 Catch:{ Throwable -> 0x00c9 }
            r5.append(r2);	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.toString();	 Catch:{ Throwable -> 0x00c9 }
            com.qq.e.comm.util.GDTLogger.d(r5);	 Catch:{ Throwable -> 0x00c9 }
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.c;	 Catch:{ Throwable -> 0x00c9 }
            if (r5 == 0) goto L_0x00a7;
        L_0x0085:
            r5 = r4.c;	 Catch:{ Throwable -> 0x00c9 }
            r5 = r5.c;	 Catch:{ Throwable -> 0x00c9 }
            r5.a();	 Catch:{ Throwable -> 0x00c9 }
            goto L_0x00a7;
        L_0x008f:
            r0.delete();	 Catch:{ Throwable -> 0x00c9 }
            r6 = "Fail to update plugin while verifying,sig=%s,md5=%s";
            r0 = 2;
            r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00c9 }
            r1 = r4.a;	 Catch:{ Throwable -> 0x00c9 }
            r0[r2] = r1;	 Catch:{ Throwable -> 0x00c9 }
            r0[r3] = r5;	 Catch:{ Throwable -> 0x00c9 }
            r5 = java.lang.String.format(r6, r0);	 Catch:{ Throwable -> 0x00c9 }
            com.qq.e.comm.util.GDTLogger.report(r5);	 Catch:{ Throwable -> 0x00c9 }
            r4.a();	 Catch:{ Throwable -> 0x00c9 }
        L_0x00a7:
            r5 = new java.lang.StringBuilder;
            r6 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r5.<init>(r6);
            r0 = java.lang.System.nanoTime();
            r5.append(r0);
            r6 = ";sig=";
            r5.append(r6);
            r6 = r4.a;
            r5.append(r6);
            r5 = r5.toString();
            com.qq.e.comm.util.GDTLogger.d(r5);
            return;
        L_0x00c7:
            r5 = move-exception;
            goto L_0x00f2;
        L_0x00c9:
            r5 = move-exception;
            r6 = "UnknownException While Update Plugin";
            com.qq.e.comm.util.GDTLogger.e(r6, r5);	 Catch:{ all -> 0x00c7 }
            r4.a();	 Catch:{ all -> 0x00c7 }
            r5 = new java.lang.StringBuilder;
            r6 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r5.<init>(r6);
            r0 = java.lang.System.nanoTime();
            r5.append(r0);
            r6 = ";sig=";
            r5.append(r6);
            r6 = r4.a;
            r5.append(r6);
            r5 = r5.toString();
            com.qq.e.comm.util.GDTLogger.d(r5);
            return;
        L_0x00f2:
            r6 = new java.lang.StringBuilder;
            r0 = "TIMESTAMP_AFTER_DOWNPLUGIN:";
            r6.<init>(r0);
            r0 = java.lang.System.nanoTime();
            r6.append(r0);
            r0 = ";sig=";
            r6.append(r0);
            r0 = r4.a;
            r6.append(r0);
            r6 = r6.toString();
            com.qq.e.comm.util.GDTLogger.d(r6);
            throw r5;
        L_0x0112:
            r5 = new java.lang.StringBuilder;
            r0 = "DownLoad Plugin Jar Status error,response status code=";
            r5.<init>(r0);
            r6 = r6.getStatusCode();
            r5.append(r6);
            r5 = r5.toString();
            com.qq.e.comm.util.GDTLogger.report(r5);
            r4.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.a.a.onResponse(com.qq.e.comm.net.rr.Request, com.qq.e.comm.net.rr.Response):void");
        }
    }

    public a(Context context) {
        this.b = context.getApplicationContext();
    }

    public final void a(PM$a$a pM$a$a) {
        this.c = pM$a$a;
    }

    public final void a(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            String str3 = "0";
            Matcher matcher = a.matcher(str2);
            if (matcher.matches()) {
                str3 = matcher.group(1);
            }
            int i = 0;
            int parseInteger = StringUtil.parseInteger(str3, 0);
            if (parseInteger < PLUGIN.ASSET_PLUGIN_VERSION) {
                StringBuilder stringBuilder = new StringBuilder("online plugin version is smaller than asset plugin version");
                stringBuilder.append(parseInteger);
                stringBuilder.append(",559.download give up");
                GDTLogger.i(stringBuilder.toString());
            } else {
                i = 1;
            }
            if (i != 0) {
                StringBuilder stringBuilder2 = new StringBuilder("TIMESTAP_BEFORE_OWN_PLUGIN:");
                stringBuilder2.append(System.nanoTime());
                GDTLogger.d(stringBuilder2.toString());
                NetworkClientImpl.getInstance().submit(new PlainRequest(str2, Method.GET, null), Priority.High, new a(this, str, parseInteger));
            }
        }
    }
}
