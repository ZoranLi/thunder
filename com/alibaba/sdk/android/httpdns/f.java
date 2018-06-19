package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import com.ut.device.UTDevice;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class f {
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static boolean b = false;

    static void a(Context context) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        if (a.compareAndSet(false, true)) {
            OutputStream outputStream2 = null;
            try {
                if (VERSION.SDK_INT >= 14) {
                    TrafficStats.setThreadStatsTag(40965);
                }
                String utdid = UTDevice.getUtdid(context);
                StringBuilder stringBuilder = new StringBuilder("stat: ");
                stringBuilder.append(utdid);
                e.d(stringBuilder.toString());
                stringBuilder = new StringBuilder("HTTPDNS-");
                stringBuilder.append(utdid);
                utdid = stringBuilder.toString();
                stringBuilder = new StringBuilder("23356390Raw");
                stringBuilder.append(g.a(utdid));
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder("16594f72217bece5a457b4803a48f2da");
                stringBuilder3.append(g.a(stringBuilder2));
                stringBuilder3.append("16594f72217bece5a457b4803a48f2da");
                stringBuilder2 = g.b(stringBuilder3.toString());
                stringBuilder3 = new StringBuilder("http://adash.man.aliyuncs.com:80/man/api?ak=23356390&s=");
                stringBuilder3.append(stringBuilder2);
                httpURLConnection = (HttpURLConnection) new URL(stringBuilder3.toString()).openConnection();
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    stringBuilder3 = new StringBuilder("===");
                    stringBuilder3.append(System.currentTimeMillis());
                    stringBuilder3.append("===");
                    String stringBuilder4 = stringBuilder3.toString();
                    StringBuilder stringBuilder5 = new StringBuilder("multipart/form-data; boundary=");
                    stringBuilder5.append(stringBuilder4);
                    httpURLConnection.setRequestProperty("Content-Type", stringBuilder5.toString());
                    StringBuilder stringBuilder6 = new StringBuilder("--");
                    stringBuilder6.append(stringBuilder4);
                    stringBuilder6.append("\r\nContent-Disposition: form-data; name=\"Raw\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
                    stringBuilder6.append(utdid);
                    stringBuilder6.append("\r\n--");
                    stringBuilder6.append(stringBuilder4);
                    stringBuilder6.append("--\r\n");
                    utdid = stringBuilder6.toString();
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(utdid.getBytes());
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                            try {
                                StringBuilder stringBuilder7 = new StringBuilder();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = dataInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    stringBuilder7.append(new String(bArr, 0, read));
                                }
                                stringBuilder6 = new StringBuilder("get MAN response: ");
                                stringBuilder6.append(stringBuilder7.toString());
                                e.d(stringBuilder6.toString());
                                try {
                                    if (((String) new JSONObject(stringBuilder7.toString()).get("success")).equals("success")) {
                                        b = true;
                                    }
                                } catch (Throwable e) {
                                    e.a(e);
                                }
                            } catch (Throwable e2) {
                                dataInputStream2 = dataInputStream;
                                th = e2;
                                outputStream2 = outputStream;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (dataInputStream2 != null) {
                                    dataInputStream2.close();
                                }
                                a.set(false);
                                throw th;
                            }
                        }
                        StringBuilder stringBuilder8 = new StringBuilder("MAN API error: ");
                        stringBuilder8.append(responseCode);
                        e.d(stringBuilder8.toString());
                        dataInputStream = null;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                th = e3;
                                e.a(th);
                                a.set(false);
                            }
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream2 = null;
                        outputStream2 = outputStream;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (dataInputStream2 != null) {
                            dataInputStream2.close();
                        }
                        a.set(false);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream2 = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    a.set(false);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                dataInputStream2 = null;
                httpURLConnection = dataInputStream2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                a.set(false);
                throw th;
            }
            a.set(false);
        }
    }

    static boolean b() {
        return b;
    }
}
