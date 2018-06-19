package com.tencent.tinker.ziputils.ziputil;

import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipException;

/* compiled from: BUGLY */
public class TinkerZipEntry implements ZipConstants, Cloneable {
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    String comment;
    long compressedSize = -1;
    int compressionMethod = -1;
    long crc = -1;
    long dataOffset = -1;
    byte[] extra;
    long localHeaderRelOffset = -1;
    int modDate = -1;
    String name;
    long size = -1;
    int time = -1;

    public TinkerZipEntry(String str, String str2, long j, long j2, long j3, int i, int i2, int i3, byte[] bArr, long j4, long j5) {
        this.name = str;
        this.comment = str2;
        this.crc = j;
        this.compressedSize = j2;
        this.size = j3;
        this.compressionMethod = i;
        this.time = i2;
        this.modDate = i3;
        this.extra = bArr;
        this.localHeaderRelOffset = j4;
        this.dataOffset = j5;
    }

    public TinkerZipEntry(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        validateStringLength("Name", str);
        this.name = str;
    }

    public TinkerZipEntry(TinkerZipEntry tinkerZipEntry) {
        this.name = tinkerZipEntry.name;
        this.comment = tinkerZipEntry.comment;
        this.time = tinkerZipEntry.time;
        this.size = tinkerZipEntry.size;
        this.compressedSize = tinkerZipEntry.compressedSize;
        this.crc = tinkerZipEntry.crc;
        this.compressionMethod = tinkerZipEntry.compressionMethod;
        this.modDate = tinkerZipEntry.modDate;
        this.extra = tinkerZipEntry.extra;
        this.localHeaderRelOffset = tinkerZipEntry.localHeaderRelOffset;
        this.dataOffset = tinkerZipEntry.dataOffset;
    }

    public TinkerZipEntry(TinkerZipEntry tinkerZipEntry, String str) {
        this.name = str;
        this.comment = tinkerZipEntry.comment;
        this.time = tinkerZipEntry.time;
        this.size = tinkerZipEntry.size;
        this.compressedSize = tinkerZipEntry.compressedSize;
        this.crc = tinkerZipEntry.crc;
        this.compressionMethod = tinkerZipEntry.compressionMethod;
        this.modDate = tinkerZipEntry.modDate;
        this.extra = tinkerZipEntry.extra;
        this.localHeaderRelOffset = tinkerZipEntry.localHeaderRelOffset;
        this.dataOffset = tinkerZipEntry.dataOffset;
    }

    TinkerZipEntry(byte[] bArr, InputStream inputStream, Charset charset, boolean z) throws IOException {
        Streams.readFully(inputStream, bArr, 0, bArr.length);
        bArr = HeapBufferIterator.iterator(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
        int readInt = bArr.readInt();
        if (((long) readInt) != ZipConstants.CENSIG) {
            TinkerZipFile.throwZipException("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        bArr.seek(8);
        int readShort = bArr.readShort() & 65535;
        if ((readShort & 1) != 0) {
            inputStream = new StringBuilder("Invalid General Purpose Bit Flag: ");
            inputStream.append(readShort);
            throw new ZipException(inputStream.toString());
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.compressionMethod = bArr.readShort() & 65535;
        this.time = bArr.readShort() & 65535;
        this.modDate = bArr.readShort() & 65535;
        this.crc = ((long) bArr.readInt()) & 4294967295L;
        this.compressedSize = ((long) bArr.readInt()) & 4294967295L;
        this.size = ((long) bArr.readInt()) & 4294967295L;
        readShort = bArr.readShort() & 65535;
        int readShort2 = bArr.readShort() & 65535;
        int readShort3 = 65535 & bArr.readShort();
        bArr.seek(42);
        this.localHeaderRelOffset = ((long) bArr.readInt()) & 4294967295L;
        bArr = new byte[readShort];
        Streams.readFully(inputStream, bArr, 0, bArr.length);
        if (containsNulByte(bArr)) {
            charset = new StringBuilder("Filename contains NUL byte: ");
            charset.append(Arrays.toString(bArr));
            throw new ZipException(charset.toString());
        }
        this.name = new String(bArr, 0, bArr.length, charset);
        if (readShort2 > 0) {
            this.extra = new byte[readShort2];
            Streams.readFully(inputStream, this.extra, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr = new byte[readShort3];
            Streams.readFully(inputStream, bArr, 0, readShort3);
            this.comment = new String(bArr, 0, bArr.length, charset);
        }
    }

    private static boolean containsNulByte(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return 1;
            }
        }
        return false;
    }

    private static void validateStringLength(String str, String str2) {
        str2 = str2.getBytes(Charset.forName("UTF-8"));
        if (str2.length > 65535) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" too long: ");
            stringBuilder.append(str2.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        if (str == null) {
            this.comment = null;
            return;
        }
        validateStringLength("Comment", str);
        this.comment = str;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public long getCrc() {
        return this.crc;
    }

    public void setCrc(long j) {
        if (j < 0 || j > 4294967295L) {
            StringBuilder stringBuilder = new StringBuilder("Bad CRC32: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.crc = j;
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public void setExtra(byte[] bArr) {
        if (bArr == null || bArr.length <= 65535) {
            this.extra = bArr;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Extra data too long: ");
        stringBuilder.append(bArr.length);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int getMethod() {
        return this.compressionMethod;
    }

    public void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.compressionMethod = i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Bad method: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("Bad size: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.size = j;
    }

    public long getTime() {
        if (this.time == -1) {
            return -1;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(1980 + ((this.modDate >> 9) & Opcodes.NEG_FLOAT), ((this.modDate >> 5) & 15) - 1, this.modDate & 31, (this.time >> 11) & 31, (this.time >> 5) & 63, (this.time & 31) << 1);
        return gregorianCalendar.getTime().getTime();
    }

    public void setTime(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date(j));
        if (gregorianCalendar.get(1) < 1980) {
            this.modDate = 33;
            this.time = 0;
            return;
        }
        this.modDate = gregorianCalendar.get(5);
        this.modDate = ((gregorianCalendar.get(2) + 1) << 5) | this.modDate;
        this.modDate = ((gregorianCalendar.get(1) - 1980) << 9) | this.modDate;
        this.time = gregorianCalendar.get(13) >> 1;
        this.time = (gregorianCalendar.get(12) << 5) | this.time;
        this.time = (gregorianCalendar.get(11) << 11) | this.time;
    }

    public boolean isDirectory() {
        return this.name.charAt(this.name.length() - 1) == '/';
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public void setDataOffset(long j) {
        this.dataOffset = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("name:");
        stringBuilder.append(this.name);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ncomment:");
        stringBuilder.append(this.comment);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ntime:");
        stringBuilder.append(this.time);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\nsize:");
        stringBuilder.append(this.size);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ncompressedSize:");
        stringBuilder.append(this.compressedSize);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ncrc:");
        stringBuilder.append(this.crc);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ncompressionMethod:");
        stringBuilder.append(this.compressionMethod);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\nmodDate:");
        stringBuilder.append(this.modDate);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\nextra length:");
        stringBuilder.append(this.extra.length);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\nlocalHeaderRelOffset:");
        stringBuilder.append(this.localHeaderRelOffset);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("\ndataOffset:");
        stringBuilder.append(this.dataOffset);
        stringBuffer.append(stringBuilder.toString());
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            TinkerZipEntry tinkerZipEntry = (TinkerZipEntry) super.clone();
            tinkerZipEntry.extra = this.extra != null ? (byte[]) this.extra.clone() : null;
            return tinkerZipEntry;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
