package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/* compiled from: MultipartEntity */
public final class aj implements ah {
    private static final char[] e = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    String a = null;
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    boolean c;
    boolean d;

    public aj() {
        int i = 0;
        this.c = false;
        this.d = false;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        while (i < 30) {
            stringBuffer.append(e[random.nextInt(e.length)]);
            i++;
        }
        this.a = stringBuffer.toString();
    }

    public final void b() {
        if (!this.d) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = this.b;
                StringBuilder stringBuilder = new StringBuilder("--");
                stringBuilder.append(this.a);
                stringBuilder.append("\r\n");
                byteArrayOutputStream.write(stringBuilder.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.d = true;
    }

    public final void a(String str, String str2, InputStream inputStream, boolean z) {
        a(str, str2, inputStream, "application/octet-stream", z);
    }

    public final void a(String str, String str2, InputStream inputStream, String str3, boolean z) {
        b();
        try {
            StringBuilder stringBuilder = new StringBuilder("Content-Type: ");
            stringBuilder.append(str3);
            stringBuilder.append("\r\n");
            str3 = stringBuilder.toString();
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            StringBuilder stringBuilder2 = new StringBuilder("Content-Disposition: form-data; name=\"");
            stringBuilder2.append(str);
            stringBuilder2.append("\"; filename=\"");
            stringBuilder2.append(str2);
            stringBuilder2.append("\"\r\n");
            byteArrayOutputStream.write(stringBuilder2.toString().getBytes());
            this.b.write(str3.getBytes());
            this.b.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
            str = new byte[4096];
            while (true) {
                str2 = inputStream.read(str);
                if (str2 == -1) {
                    break;
                }
                this.b.write(str, 0, str2);
            }
            if (!z) {
                str = this.b;
                str2 = new StringBuilder("\r\n--");
                str2.append(this.a);
                str2.append("\r\n");
                str.write(str2.toString().getBytes());
            } else if (this.c == null) {
                try {
                    str = this.b;
                    str2 = new StringBuilder("\r\n--");
                    str2.append(this.a);
                    str2.append("--\r\n");
                    str.write(str2.toString().getBytes());
                } catch (String str4) {
                    str4.printStackTrace();
                }
                this.c = true;
            }
            this.b.flush();
        } catch (String str42) {
            str42.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (String str22) {
                str22.printStackTrace();
            }
        }
    }

    public final ag a() {
        StringBuilder stringBuilder = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder.append(this.a);
        return new b("Content-Type", stringBuilder.toString());
    }

    public final void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.b.toByteArray());
    }
}
