package com.qihoo360.replugin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* compiled from: IOUtils */
public final class d {
    public static String a(InputStream inputStream, Charset charset) throws IOException {
        Writer stringBuilderWriter = new StringBuilderWriter();
        a(new InputStreamReader(inputStream, a.a(charset)), stringBuilderWriter, new char[4096]);
        return stringBuilderWriter.toString();
    }

    private static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
        if (j > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) j;
    }
}
