package com.getui.gtc.e;

import java.io.OutputStream;

public final class d extends OutputStream {
    private OutputStream a = null;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    public d(OutputStream outputStream) {
        this.a = outputStream;
        this.e = 0;
    }

    protected final void a() {
        if (this.c > 0) {
            if (this.e > 0 && this.d == this.e) {
                this.a.write("\r\n".getBytes());
                this.d = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 14) >>> 26);
            int i = 61;
            int charAt3 = this.c < 2 ? 61 : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 20) >>> 26);
            if (this.c >= 3) {
                i = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 26) >>> 26);
            }
            this.a.write(charAt);
            this.a.write(charAt2);
            this.a.write(charAt3);
            this.a.write(i);
            this.d += 4;
            this.c = 0;
            this.b = 0;
        }
    }

    public final void close() {
        a();
        this.a.close();
    }

    public final void write(int i) {
        this.b = ((i & 255) << (16 - (this.c * 8))) | this.b;
        this.c++;
        if (this.c == 3) {
            a();
        }
    }
}
