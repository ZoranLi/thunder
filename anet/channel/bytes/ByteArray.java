package anet.channel.bytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public class ByteArray implements Comparable<ByteArray> {
    final byte[] buffer;
    int bufferLength;
    int dataLength;

    private ByteArray(byte[] bArr, int i) {
        if (bArr == null) {
            bArr = new byte[i];
        }
        this.buffer = bArr;
        this.bufferLength = this.buffer.length;
        this.dataLength = i;
    }

    public static ByteArray create(int i) {
        return new ByteArray(null, i);
    }

    public static ByteArray wrap(byte[] bArr, int i) {
        if (bArr != null) {
            if (i > 0) {
                return new ByteArray(bArr, i);
            }
        }
        return null;
    }

    public static ByteArray wrap(byte[] bArr) {
        return bArr == null ? null : wrap(bArr, bArr.length);
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getBufferLength() {
        return this.bufferLength;
    }

    public int getDataLength() {
        return this.dataLength;
    }

    public void setDataLength(int i) {
        this.dataLength = i;
    }

    public void recycle() {
        if (this.bufferLength != 0) {
            a.a.a(this);
        }
    }

    public int readFrom(InputStream inputStream) throws IOException {
        int i = 0;
        inputStream = inputStream.read(this.buffer, 0, this.bufferLength);
        if (inputStream != -1) {
            i = inputStream;
        }
        this.dataLength = i;
        return inputStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buffer, 0, this.dataLength);
    }

    public int compareTo(ByteArray byteArray) {
        if (this.bufferLength != byteArray.bufferLength) {
            return this.bufferLength - byteArray.bufferLength;
        }
        if (this.buffer == null) {
            return -1;
        }
        if (byteArray.buffer == null) {
            return 1;
        }
        return hashCode() - byteArray.hashCode();
    }
}
