package okio;

import java.io.IOException;

/* compiled from: BufferedSink */
public interface f extends u {
    long a(v vVar) throws IOException;

    e b();

    f b(String str) throws IOException;

    f b(ByteString byteString) throws IOException;

    f c(byte[] bArr) throws IOException;

    f c(byte[] bArr, int i, int i2) throws IOException;

    f f(int i) throws IOException;

    void flush() throws IOException;

    f g(int i) throws IOException;

    f h(int i) throws IOException;

    f i(long j) throws IOException;

    f j(long j) throws IOException;

    f p() throws IOException;
}
