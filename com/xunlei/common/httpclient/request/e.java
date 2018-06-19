package com.xunlei.common.httpclient.request;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: SimpleMultipartEntity */
final class e implements HttpEntity {
    private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String b = null;
    private ByteArrayOutputStream c = new ByteArrayOutputStream();
    private boolean d;
    private boolean e;

    public final Header getContentEncoding() {
        return null;
    }

    public final boolean isChunked() {
        return false;
    }

    public final boolean isRepeatable() {
        return false;
    }

    public final boolean isStreaming() {
        return false;
    }

    public e() {
        int i = 0;
        this.d = false;
        this.e = false;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while (i < 30) {
            stringBuffer.append(a[random.nextInt(a.length)]);
            i++;
        }
        this.b = stringBuffer.toString();
    }

    private void a() {
        if (!this.e) {
            b();
        }
        this.e = true;
    }

    private void b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.c;
            StringBuilder stringBuilder = new StringBuilder("--");
            stringBuilder.append(this.b);
            stringBuilder.append("\r\n");
            byteArrayOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        if (!this.d) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.c;
                StringBuilder stringBuilder = new StringBuilder("--");
                stringBuilder.append(this.b);
                stringBuilder.append("--\r\n");
                byteArrayOutputStream.write(stringBuilder.toString().getBytes());
                this.c.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.d = true;
        }
    }

    private void a(String str, String str2, String str3) {
        b();
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.c;
            StringBuilder stringBuilder = new StringBuilder("Content-Disposition: form-data; name=\"");
            stringBuilder.append(str);
            stringBuilder.append("\"\r\n");
            byteArrayOutputStream.write(stringBuilder.toString().getBytes());
            str = this.c;
            StringBuilder stringBuilder2 = new StringBuilder("Content-Type: ");
            stringBuilder2.append(str3);
            stringBuilder2.append("\r\n\r\n");
            str.write(stringBuilder2.toString().getBytes());
            this.c.write(str2.getBytes());
            this.c.write("\r\n".getBytes());
        } catch (String str4) {
            str4.printStackTrace();
        }
    }

    public final void a(String str, String str2, InputStream inputStream, boolean z) {
        a(str, str2, inputStream, "application/octet-stream");
    }

    public final void a(String str, String str2, InputStream inputStream, String str3) {
        b();
        try {
            StringBuilder stringBuilder = new StringBuilder("Content-Type: ");
            stringBuilder.append(str3);
            stringBuilder.append("\r\n");
            str3 = stringBuilder.toString();
            ByteArrayOutputStream byteArrayOutputStream = this.c;
            StringBuilder stringBuilder2 = new StringBuilder("Content-Disposition: form-data; name=\"");
            stringBuilder2.append(str);
            stringBuilder2.append("\"; filename=\"");
            stringBuilder2.append(str2);
            stringBuilder2.append("\"\r\n");
            byteArrayOutputStream.write(stringBuilder2.toString().getBytes());
            this.c.write(str3.getBytes());
            this.c.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
            str = new byte[4096];
            while (true) {
                str2 = inputStream.read(str);
                if (str2 == -1) {
                    break;
                }
                this.c.write(str, 0, str2);
            }
            this.c.write("\r\n".getBytes());
        } catch (String str4) {
            str4.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (String str22) {
                str22.printStackTrace();
            }
        }
    }

    private void a(String str, File file, boolean z) {
        try {
            a(str, file.getName(), new FileInputStream(file), z);
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    public final long getContentLength() {
        c();
        return (long) this.c.toByteArray().length;
    }

    public final Header getContentType() {
        StringBuilder stringBuilder = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder.append(this.b);
        return new BasicHeader("Content-Type", stringBuilder.toString());
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        c();
        outputStream.write(this.c.toByteArray());
    }

    public final void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public final InputStream getContent() throws IOException, UnsupportedOperationException {
        c();
        return new ByteArrayInputStream(this.c.toByteArray());
    }

    public final void a(String str, String str2) {
        String str3 = "text/plain; charset=UTF-8";
        b();
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.c;
            StringBuilder stringBuilder = new StringBuilder("Content-Disposition: form-data; name=\"");
            stringBuilder.append(str);
            stringBuilder.append("\"\r\n");
            byteArrayOutputStream.write(stringBuilder.toString().getBytes());
            str = this.c;
            StringBuilder stringBuilder2 = new StringBuilder("Content-Type: ");
            stringBuilder2.append(str3);
            stringBuilder2.append("\r\n\r\n");
            str.write(stringBuilder2.toString().getBytes());
            this.c.write(str2.getBytes());
            this.c.write("\r\n".getBytes());
        } catch (String str4) {
            str4.printStackTrace();
        }
    }
}
