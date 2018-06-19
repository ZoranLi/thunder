package com.tencent.tinker.android.dx.instruction;

import java.io.EOFException;

/* compiled from: BUGLY */
public final class ShortArrayCodeInput extends CodeCursor {
    private final short[] array;

    public ShortArrayCodeInput(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.array = sArr;
    }

    public final boolean hasMore() {
        return cursor() < this.array.length;
    }

    public final int read() throws java.io.EOFException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.array;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0011 }
        r1 = r2.cursor();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0011 }
        r0 = r0[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0011 }
        r1 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0011 }
        r2.advance(r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0011 }
        r1 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r0 = r0 & r1;
        return r0;
    L_0x0011:
        r0 = new java.io.EOFException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.ShortArrayCodeInput.read():int");
    }

    public final int readInt() throws EOFException {
        return read() | (read() << 16);
    }

    public final long readLong() throws EOFException {
        return ((((long) read()) | (((long) read()) << 16)) | (((long) read()) << 32)) | (((long) read()) << 48);
    }
}
