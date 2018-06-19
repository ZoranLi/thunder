package com.igexin.a.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class j implements c, Closeable {
    private final int a = 1179403647;
    private final FileChannel b;

    public j(File file) {
        if (file != null) {
            if (file.exists()) {
                this.b = new FileInputStream(file).getChannel();
                return;
            }
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long a(e eVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            f a = eVar.a(j3);
            if (a.a == 1 && a.c <= j2 && j2 <= a.c + a.d) {
                return (j2 - a.c) + a.b;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public e a() {
        this.b.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(allocate, 0) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short e = e(allocate, 4);
        boolean z = e(allocate, 5) == (short) 2;
        if (e == (short) 1) {
            return new h(z, this);
        }
        if (e == (short) 2) {
            return new i(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    protected String a(ByteBuffer byteBuffer, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            long j2 = j + 1;
            short e = e(byteBuffer, j);
            if (e == (short) 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) e);
            j = j2;
        }
    }

    protected void a(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.b.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 += (long) read;
        }
        byteBuffer.position(0);
    }

    protected long b(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public List<String> b() {
        long j;
        this.b.position(0);
        List<String> arrayList = new ArrayList();
        e a = a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) a.f;
        int i = 0;
        if (j2 == 65535) {
            j2 = a.a(0).a;
        }
        for (j = 0; j < j2; j++) {
            f a2 = a.a(j);
            if (a2.a == 2) {
                j = a2.b;
                break;
            }
        }
        j = 0;
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        List<Long> arrayList2 = new ArrayList();
        long j3 = 0;
        while (true) {
            d a3 = a.a(j, i);
            if (a3.a == 1) {
                arrayList2.add(Long.valueOf(a3.b));
            } else if (a3.a == 5) {
                j3 = a3.b;
            }
            i++;
            if (a3.a == 0) {
                break;
            }
            long j4 = 0;
        }
        if (j3 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long a4 = a(a, j2, j3);
        for (Long longValue : arrayList2) {
            arrayList.add(a(allocate, a4 + longValue.longValue()));
        }
        return arrayList;
    }

    protected long c(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public void close() {
        this.b.close();
    }

    protected int d(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    protected short e(ByteBuffer byteBuffer, long j) {
        a(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }
}
