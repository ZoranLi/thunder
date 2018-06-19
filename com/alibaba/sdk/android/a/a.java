package com.alibaba.sdk.android.a;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import com.ut.device.UTDevice;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class a {
    private static final ExecutorService a = Executors.newSingleThreadExecutor(new e());
    private static ConcurrentHashMap b = new ConcurrentHashMap();
    private static boolean c = false;
    private static Context d;
    private static g e = new g("AMSDevReporter");

    static {
        for (Object put : d.a()) {
            b.put(put, c.UNREPORTED);
        }
    }

    public static void a(Context context, d dVar) {
        if (context == null) {
            e.c("Context is null, return.");
            return;
        }
        d = context;
        g gVar = e;
        StringBuilder stringBuilder = new StringBuilder("Add [");
        stringBuilder.append(dVar.toString());
        stringBuilder.append("] to report queue.");
        gVar.b(stringBuilder.toString());
        c = false;
        a.execute(new b(dVar));
    }

    public static void a(boolean z) {
        e.a(z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.alibaba.sdk.android.a.d r8) {
        /*
        r0 = r8.toString();
        r1 = b;
        r1 = r1.get(r8);
        r2 = com.alibaba.sdk.android.a.c.UNREPORTED;
        if (r1 == r2) goto L_0x0027;
    L_0x000e:
        r8 = e;
        r1 = new java.lang.StringBuilder;
        r2 = "[";
        r1.<init>(r2);
        r1.append(r0);
        r0 = "] already reported, return.";
        r1.append(r0);
        r0 = r1.toString();
        r8.b(r0);
        return;
    L_0x0027:
        r1 = 60;
        r2 = 0;
        r3 = 5;
    L_0x002b:
        r4 = e;
        r5 = new java.lang.StringBuilder;
        r6 = "Report [";
        r5.<init>(r6);
        r5.append(r0);
        r6 = "], times: [";
        r5.append(r6);
        r6 = 1;
        r2 = r2 + r6;
        r5.append(r2);
        r7 = "].";
        r5.append(r7);
        r5 = r5.toString();
        r4.b(r5);
        r4 = c(r8);
        if (r4 != 0) goto L_0x00a3;
    L_0x0053:
        r4 = 10;
        if (r2 > r4) goto L_0x0081;
    L_0x0057:
        r4 = e;
        r5 = new java.lang.StringBuilder;
        r6 = "Report [";
        r5.<init>(r6);
        r5.append(r0);
        r6 = "] failed, wait for [";
        r5.append(r6);
        r5.append(r3);
        r6 = "] seconds.";
        r5.append(r6);
        r5 = r5.toString();
        r4.b(r5);
        r4 = (double) r3;
        com.alibaba.sdk.android.a.h.a(r4);
        r3 = r3 * 2;
        if (r3 < r1) goto L_0x002b;
    L_0x007f:
        r3 = r1;
        goto L_0x002b;
    L_0x0081:
        r1 = e;
        r2 = new java.lang.StringBuilder;
        r3 = "Report [";
        r2.<init>(r3);
        r2.append(r0);
        r3 = "] stat failed, exceed max retry times, return.";
        r2.append(r3);
        r2 = r2.toString();
        r1.c(r2);
        r1 = b;
        r2 = com.alibaba.sdk.android.a.c.UNREPORTED;
        r1.put(r8, r2);
        c = r6;
        goto L_0x00c2;
    L_0x00a3:
        r1 = e;
        r2 = new java.lang.StringBuilder;
        r3 = "Report [";
        r2.<init>(r3);
        r2.append(r0);
        r3 = "] stat success.";
        r2.append(r3);
        r2 = r2.toString();
        r1.b(r2);
        r1 = b;
        r2 = com.alibaba.sdk.android.a.c.REPORTED;
        r1.put(r8, r2);
    L_0x00c2:
        r8 = c;
        if (r8 == 0) goto L_0x00de;
    L_0x00c6:
        r8 = e;
        r1 = new java.lang.StringBuilder;
        r2 = "Report [";
        r1.<init>(r2);
        r1.append(r0);
        r0 = "] failed, clear remain report in queue.";
        r1.append(r0);
        r0 = r1.toString();
        r8.c(r0);
    L_0x00de:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.a.a.b(com.alibaba.sdk.android.a.d):void");
    }

    private static boolean c(d dVar) {
        HttpURLConnection httpURLConnection;
        Throwable e;
        HttpURLConnection httpURLConnection2;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        HttpURLConnection httpURLConnection3;
        OutputStream outputStream = null;
        OutputStream outputStream2;
        try {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if (VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40965);
            }
            String utdid = UTDevice.getUtdid(d);
            g gVar = e;
            StringBuilder stringBuilder3 = new StringBuilder("stat: ");
            stringBuilder3.append(utdid);
            gVar.b(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(dVar.toString());
            stringBuilder4.append("-");
            stringBuilder4.append(utdid);
            String stringBuilder5 = stringBuilder4.toString();
            StringBuilder stringBuilder6 = new StringBuilder("23356390Raw");
            stringBuilder6.append(h.b(stringBuilder5));
            utdid = stringBuilder6.toString();
            stringBuilder4 = new StringBuilder("16594f72217bece5a457b4803a48f2da");
            stringBuilder4.append(h.b(utdid));
            stringBuilder4.append("16594f72217bece5a457b4803a48f2da");
            utdid = h.c(stringBuilder4.toString());
            stringBuilder4 = new StringBuilder("http://adash.man.aliyuncs.com:80/man/api?ak=23356390&s=");
            stringBuilder4.append(utdid);
            httpURLConnection = (HttpURLConnection) new URL(stringBuilder4.toString()).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                stringBuilder3 = new StringBuilder("===");
                stringBuilder3.append(System.currentTimeMillis());
                stringBuilder3.append("===");
                String stringBuilder7 = stringBuilder3.toString();
                stringBuilder = new StringBuilder("multipart/form-data; boundary=");
                stringBuilder.append(stringBuilder7);
                httpURLConnection.setRequestProperty("Content-Type", stringBuilder.toString());
                stringBuilder2 = new StringBuilder("--");
                stringBuilder2.append(stringBuilder7);
                stringBuilder2.append("\r\nContent-Disposition: form-data; name=\"Raw\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
                stringBuilder2.append(stringBuilder5);
                stringBuilder2.append("\r\n--");
                stringBuilder2.append(stringBuilder7);
                stringBuilder2.append("--\r\n");
                stringBuilder5 = stringBuilder2.toString();
                outputStream2 = httpURLConnection.getOutputStream();
            } catch (Exception e2) {
                e = e2;
                outputStream2 = null;
                httpURLConnection2 = httpURLConnection;
                dataInputStream = outputStream2;
                try {
                    e.a(e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                        return false;
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    dataInputStream2 = dataInputStream;
                    httpURLConnection = httpURLConnection2;
                    outputStream = outputStream2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e3) {
                            e.a(e3);
                            throw e;
                        }
                    }
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                dataInputStream2 = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw e;
            }
            try {
                DataInputStream dataInputStream3;
                outputStream2.write(stringBuilder5.getBytes());
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    dataInputStream3 = new DataInputStream(httpURLConnection.getInputStream());
                    try {
                        StringBuilder stringBuilder8 = new StringBuilder();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream3.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            stringBuilder8.append(new String(bArr, 0, read));
                        }
                        g gVar2 = e;
                        stringBuilder = new StringBuilder("Get MAN response: ");
                        stringBuilder.append(stringBuilder8.toString());
                        gVar2.a(stringBuilder.toString());
                        try {
                            if (((String) new JSONObject(stringBuilder8.toString()).get("success")).equals("success")) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Throwable e4) {
                                        e.a(e4);
                                        return true;
                                    }
                                }
                                dataInputStream3.close();
                                return true;
                            }
                        } catch (Throwable e5) {
                            e.a(e5);
                        }
                    } catch (Throwable e52) {
                        httpURLConnection3 = httpURLConnection;
                        dataInputStream = dataInputStream3;
                        e4 = e52;
                        httpURLConnection2 = httpURLConnection3;
                        e.a(e4);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable e32) {
                        outputStream = outputStream2;
                        Throwable th3 = e32;
                        dataInputStream2 = dataInputStream3;
                        e4 = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (dataInputStream2 != null) {
                            dataInputStream2.close();
                        }
                        throw e4;
                    }
                }
                gVar = e;
                stringBuilder2 = new StringBuilder("MAN API error, response code: ");
                stringBuilder2.append(responseCode);
                gVar.c(stringBuilder2.toString());
                dataInputStream3 = null;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Throwable e42) {
                        e.a(e42);
                    }
                }
                if (dataInputStream3 != null) {
                    dataInputStream3.close();
                    return false;
                }
            } catch (Exception e6) {
                e42 = e6;
                httpURLConnection3 = httpURLConnection;
                dataInputStream = null;
                httpURLConnection2 = httpURLConnection3;
                e.a(e42);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                    return false;
                }
                return false;
            } catch (Throwable th4) {
                e42 = th4;
                dataInputStream2 = null;
                outputStream = outputStream2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw e42;
            }
        } catch (Exception e7) {
            e42 = e7;
            dataInputStream = null;
            outputStream2 = dataInputStream;
            e.a(e42);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (dataInputStream != null) {
                dataInputStream.close();
                return false;
            }
            return false;
        } catch (Throwable th5) {
            e42 = th5;
            dataInputStream2 = null;
            httpURLConnection = dataInputStream2;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw e42;
        }
        return false;
    }
}
