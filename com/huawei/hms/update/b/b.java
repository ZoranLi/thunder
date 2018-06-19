package com.huawei.hms.update.b;

import com.huawei.hms.c.c;
import com.huawei.hms.support.log.a;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: HttpRequestHelper */
public class b implements d {
    private HttpURLConnection a;
    private volatile int b = -1;

    public void a() {
        this.b = -1;
        if (this.a != null) {
            this.a.disconnect();
        }
    }

    public void b() {
        this.b = 1;
    }

    public int a(String str, InputStream inputStream, OutputStream outputStream) throws IOException, a {
        InputStream inputStream2 = null;
        OutputStream outputStream2;
        try {
            a(str);
            this.a.setRequestMethod("POST");
            outputStream2 = this.a.getOutputStream();
            try {
                a(inputStream, outputStream2);
                outputStream2.flush();
                inputStream = this.a.getResponseCode();
                if (inputStream == 200) {
                    InputStream inputStream3 = this.a.getInputStream();
                    try {
                        a(new BufferedInputStream(inputStream3, 4096), outputStream);
                        outputStream.flush();
                        inputStream2 = inputStream3;
                    } catch (Throwable th) {
                        inputStream = th;
                        inputStream2 = inputStream3;
                        c.a(inputStream2);
                        c.a(outputStream2);
                        throw inputStream;
                    }
                }
                c.a(inputStream2);
                c.a(outputStream2);
                return inputStream;
            } catch (Throwable th2) {
                inputStream = th2;
                c.a(inputStream2);
                c.a(outputStream2);
                throw inputStream;
            }
        } catch (Throwable th3) {
            inputStream = th3;
            outputStream2 = null;
            c.a(inputStream2);
            c.a(outputStream2);
            throw inputStream;
        }
    }

    public int a(String str, OutputStream outputStream) throws IOException, a {
        return a(str, outputStream, 0, 0);
    }

    public int a(String str, OutputStream outputStream, int i, int i2) throws IOException, a {
        InputStream inputStream = null;
        try {
            InputStream inputStream2;
            a(str);
            this.a.setRequestMethod("GET");
            if (i > 0) {
                StringBuilder stringBuilder = new StringBuilder("bytes=");
                stringBuilder.append(i);
                stringBuilder.append("-");
                stringBuilder.append(i2);
                this.a.addRequestProperty("Range", stringBuilder.toString());
            }
            str = this.a.getResponseCode();
            if ((i <= 0 || str != 206) && (i > 0 || str != 200)) {
                inputStream2 = 0;
            } else {
                inputStream2 = this.a.getInputStream();
                try {
                    a(new BufferedInputStream(inputStream2, 4096), outputStream);
                    outputStream.flush();
                } catch (Throwable th) {
                    str = th;
                    inputStream = inputStream2;
                    c.a(inputStream);
                    throw str;
                }
            }
            c.a(inputStream2);
            return str;
        } catch (Throwable th2) {
            str = th2;
            c.a(inputStream);
            throw str;
        }
    }

    private void a(String str) throws IOException {
        if (this.b == 0) {
            a.d("HttpRequestHelper", "Not allowed to repeat open http(s) connection.");
        }
        this.a = (HttpURLConnection) new URL(str).openConnection();
        if ((this.a instanceof HttpsURLConnection) != null) {
            c.a((HttpsURLConnection) this.a);
        }
        this.a.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        this.a.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        this.a.setDoInput(true);
        this.a.setDoOutput(true);
        this.a.setUseCaches(false);
        this.b = 0;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws IOException, a {
        byte[] bArr = new byte[4096];
        do {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        } while (this.b != 1);
        throw new a("HTTP(s) request was canceled.");
    }
}
