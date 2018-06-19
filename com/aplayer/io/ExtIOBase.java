package com.aplayer.io;

import java.nio.ByteBuffer;

public interface ExtIOBase {
    int close(String str);

    int open(String str);

    int read(ByteBuffer byteBuffer);

    long seek(int i, int i2);
}
