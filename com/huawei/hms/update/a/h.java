package com.huawei.hms.update.a;

import com.huawei.hms.c.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* compiled from: RandomFileOutputStream */
public class h extends OutputStream {
    private RandomAccessFile a;

    public h(File file, int i) throws FileNotFoundException, IOException {
        try {
            this.a = new RandomAccessFile(file, "rwd");
            this.a.setLength((long) i);
        } catch (File file2) {
            throw file2;
        } catch (File file22) {
            c.a(this.a);
            throw file22;
        }
    }

    public void close() throws IOException {
        this.a.close();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void a(long j) throws IOException {
        this.a.seek(j);
    }
}
