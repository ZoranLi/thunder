package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

class j implements Callable {
    private static Context b;
    private static a hostManager = a.a();
    private String a;
    private int f7b = 1;

    j(String str) {
        this.a = str;
    }

    static void setContext(Context context) {
        b = context;
    }

    public String[] b() {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        int i;
        Throwable th2;
        BufferedReader bufferedReader;
        String[] a;
        try {
            if (!f.b()) {
                new Thread(new k(this)).start();
            }
            if (VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40965);
            }
            hostManager.a(this.a);
            StringBuilder stringBuilder = new StringBuilder("http://203.107.1.1:80/");
            stringBuilder.append(d.b);
            stringBuilder.append("/d?host=");
            stringBuilder.append(this.a);
            httpURLConnection = (HttpURLConnection) new URL(stringBuilder.toString()).openConnection();
            try {
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                if (httpURLConnection.getResponseCode() != 200) {
                    StringBuilder stringBuilder2 = new StringBuilder("response code is ");
                    stringBuilder2.append(httpURLConnection.getResponseCode());
                    stringBuilder2.append(" expect 200");
                    e.e(stringBuilder2.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    hostManager.b(this.a);
                    return d.f5b;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    try {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder3.append(readLine);
                        }
                        StringBuilder stringBuilder4 = new StringBuilder("resolve host: ");
                        stringBuilder4.append(this.a);
                        stringBuilder4.append(", return: ");
                        stringBuilder4.append(stringBuilder3.toString());
                        e.d(stringBuilder4.toString());
                        b bVar = new b(stringBuilder3.toString());
                        if (hostManager.a() < 100) {
                            hostManager.a(this.a, bVar);
                            hostManager.b(this.a);
                            a = bVar.a();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e) {
                                    e.a(e);
                                    return a;
                                }
                            }
                            bufferedReader.close();
                            return a;
                        }
                        throw new Exception("the total number of hosts is exceed 100");
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            e.a(th);
                            i = this.f7b;
                            this.f7b = i - 1;
                            if (i <= 0) {
                                a = b();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e2) {
                                        e.a(e2);
                                        return a;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    return a;
                                }
                                return a;
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th4) {
                                    e.a(th4);
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            hostManager.b(this.a);
                            return d.f5b;
                        } catch (Throwable th5) {
                            th4 = th5;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    e.a(e22);
                                    throw th4;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th4;
                        }
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    bufferedReader = null;
                    th4 = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th4;
                }
            } catch (Throwable th7) {
                bufferedReader = null;
                th4 = th7;
                inputStream = bufferedReader;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th4;
            }
        } catch (Throwable e222) {
            inputStream = null;
            bufferedReader = inputStream;
            th4 = e222;
            httpURLConnection = bufferedReader;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th4;
        }
    }

    public /* synthetic */ Object call() {
        return b();
    }
}
