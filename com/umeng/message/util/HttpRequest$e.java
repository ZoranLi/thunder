package com.umeng.message.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class HttpRequest$e extends BufferedOutputStream {
    private final CharsetEncoder a;

    public HttpRequest$e(OutputStream outputStream, String str, int i) {
        super(outputStream, i);
        this.a = Charset.forName(HttpRequest.access$000(str)).newEncoder();
    }

    public HttpRequest$e a(String str) throws IOException {
        str = this.a.encode(CharBuffer.wrap(str));
        super.write(str.array(), 0, str.limit());
        return this;
    }
}
