package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = (byte) 13;
    private static final byte LF = (byte) 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream != null) {
            if (charset != null) {
                if (i < 0) {
                    throw new IllegalArgumentException("capacity <= 0");
                } else if (charset.equals(Util.US_ASCII)) {
                    this.in = inputStream;
                    this.charset = charset;
                    this.buf = new byte[i];
                    return;
                } else {
                    throw new IllegalArgumentException("Unsupported encoding");
                }
            }
        }
        throw new NullPointerException();
    }

    public void close() throws IOException {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public String readLine() throws IOException {
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.pos >= this.end) {
                fillBuf();
            }
            for (int i2 = this.pos; i2 != this.end; i2++) {
                if (this.buf[i2] == LF) {
                    int i3;
                    String str;
                    if (i2 != this.pos) {
                        i3 = i2 - 1;
                        if (this.buf[i3] == CR) {
                            str = new String(this.buf, this.pos, i3 - this.pos, this.charset.name());
                            this.pos = i2 + 1;
                            return str;
                        }
                    }
                    i3 = i2;
                    str = new String(this.buf, this.pos, i3 - this.pos, this.charset.name());
                    this.pos = i2 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream anonymousClass1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != StrictLineReader.CR) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, StrictLineReader.this.charset.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                anonymousClass1.write(this.buf, this.pos, this.end - this.pos);
                this.end = -1;
                fillBuf();
                i = this.pos;
                while (i != this.end) {
                    if (this.buf[i] == LF) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.pos) {
                anonymousClass1.write(this.buf, this.pos, i - this.pos);
            }
            this.pos = i + 1;
            String byteArrayOutputStream = anonymousClass1.toString();
            return byteArrayOutputStream;
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    private void fillBuf() throws IOException {
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }
}
