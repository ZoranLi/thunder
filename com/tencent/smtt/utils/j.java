package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.utils.e.a;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class j extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    j(String str, a aVar) {
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        OutputStream d;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.setConnectTimeout(ReaderCallback.GET_BAR_ANIMATING);
            httpURLConnection.connect();
            InputStream inputStream3 = httpURLConnection.getInputStream();
            try {
                d = k.d(new File(this.a));
            } catch (Throwable e) {
                d = null;
                inputStream2 = inputStream3;
                th = e;
                try {
                    th.printStackTrace();
                    this.b.a(th);
                    try {
                        inputStream2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        d.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        inputStream2.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                    }
                    try {
                        d.close();
                    } catch (Exception e2222) {
                        e2222.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable e3) {
                d = null;
                inputStream2 = inputStream3;
                th = e3;
                inputStream2.close();
                d.close();
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int read = inputStream3.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    i += read;
                    d.write(bArr, 0, read);
                    this.b.a((i * 100) / contentLength);
                }
                this.b.a();
                try {
                    inputStream3.close();
                } catch (Exception e22222) {
                    e22222.printStackTrace();
                }
                try {
                    d.close();
                } catch (Exception e222222) {
                    e222222.printStackTrace();
                }
            } catch (Throwable e4) {
                inputStream = inputStream3;
                th = e4;
                inputStream2 = inputStream;
                th.printStackTrace();
                this.b.a(th);
                inputStream2.close();
                d.close();
            } catch (Throwable e42) {
                inputStream = inputStream3;
                th = e42;
                inputStream2 = inputStream;
                inputStream2.close();
                d.close();
                throw th;
            }
        } catch (Exception e5) {
            th = e5;
            d = null;
            th.printStackTrace();
            this.b.a(th);
            inputStream2.close();
            d.close();
        } catch (Throwable th3) {
            th = th3;
            d = null;
            inputStream2.close();
            d.close();
            throw th;
        }
    }
}
