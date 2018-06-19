package com.tencent.tinker.ziputils.ziputil;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

/* compiled from: BUGLY */
public class TinkerZipOutputStream extends FilterOutputStream implements ZipConstants {
    public static final byte[] BYTE = new byte[0];
    public static final int DEFLATED = 8;
    static final int MOD_DATE_CONST = 18698;
    public static final int STORED = 0;
    static final int TIME_CONST = 40691;
    private static final byte[] ZIP64_PLACEHOLDER_BYTES = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private static final int ZIP_VERSION_2_0 = 20;
    private boolean archiveNeedsZip64EocdRecord;
    private ByteArrayOutputStream cDir;
    private byte[] commentBytes;
    private TinkerZipEntry currentEntry;
    private boolean currentEntryNeedsZip64;
    private int defaultCompressionMethod;
    private final HashSet<String> entries;
    private byte[] entryCommentBytes;
    private final boolean forceZip64;
    private byte[] nameBytes;
    private long offset;

    public TinkerZipOutputStream(OutputStream outputStream) {
        this(outputStream, false);
    }

    public TinkerZipOutputStream(OutputStream outputStream, boolean z) {
        super(outputStream);
        this.entries = new HashSet();
        this.commentBytes = BYTE;
        this.defaultCompressionMethod = 8;
        this.cDir = new ByteArrayOutputStream();
        this.offset = 0;
        this.forceZip64 = z;
    }

    static long writeLongAsUint32(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (j & 255));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    static long writeLongAsUint64(OutputStream outputStream, long j) throws IOException {
        int i = (int) j;
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
        i = (int) (j >> 32);
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
        return j;
    }

    static int writeIntAsUint16(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public void close() throws IOException {
        if (this.out != null) {
            finish();
            this.out.close();
            this.out = null;
        }
    }

    public void closeEntry() throws IOException {
        checkOpen();
        if (this.currentEntry != null) {
            long compressedSize;
            long j = 30;
            if (this.currentEntry.getMethod() != 0) {
                j = 46;
                writeLongAsUint32(this.out, ZipConstants.EXTSIG);
                writeLongAsUint32(this.out, this.currentEntry.crc);
                writeLongAsUint32(this.out, this.currentEntry.compressedSize);
                writeLongAsUint32(this.out, this.currentEntry.size);
            }
            int i = (this.currentEntry.getMethod() == 0 ? 0 : 8) | 2048;
            writeLongAsUint32(this.cDir, ZipConstants.CENSIG);
            writeIntAsUint16(this.cDir, 20);
            writeIntAsUint16(this.cDir, 20);
            writeIntAsUint16(this.cDir, i);
            writeIntAsUint16(this.cDir, this.currentEntry.getMethod());
            writeIntAsUint16(this.cDir, this.currentEntry.time);
            writeIntAsUint16(this.cDir, this.currentEntry.modDate);
            writeLongAsUint32(this.cDir, this.currentEntry.crc);
            if (this.currentEntry.getMethod() == 8) {
                compressedSize = j + this.currentEntry.getCompressedSize();
            } else {
                compressedSize = j + this.currentEntry.getSize();
            }
            writeLongAsUint32(this.cDir, this.currentEntry.getCompressedSize());
            writeLongAsUint32(this.cDir, this.currentEntry.getSize());
            long writeIntAsUint16 = compressedSize + ((long) writeIntAsUint16(this.cDir, this.nameBytes.length));
            if (this.currentEntry.extra != null) {
                writeIntAsUint16 += (long) writeIntAsUint16(this.cDir, this.currentEntry.extra.length);
            } else {
                writeIntAsUint16(this.cDir, 0);
            }
            writeIntAsUint16(this.cDir, this.entryCommentBytes.length);
            writeIntAsUint16(this.cDir, 0);
            writeIntAsUint16(this.cDir, 0);
            writeLongAsUint32(this.cDir, 0);
            writeLongAsUint32(this.cDir, this.currentEntry.localHeaderRelOffset);
            this.cDir.write(this.nameBytes);
            this.nameBytes = null;
            if (this.currentEntry.extra != null) {
                this.cDir.write(this.currentEntry.extra);
            }
            this.offset += writeIntAsUint16;
            if (this.entryCommentBytes.length > 0) {
                this.cDir.write(this.entryCommentBytes);
                this.entryCommentBytes = BYTE;
            }
            this.currentEntry = null;
        }
    }

    public void finish() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream is closed");
        } else if (this.cDir != null) {
            if (this.entries.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.currentEntry != null) {
                closeEntry();
            }
            int size = this.cDir.size();
            writeLongAsUint32(this.cDir, ZipConstants.ENDSIG);
            writeIntAsUint16(this.cDir, 0);
            writeIntAsUint16(this.cDir, 0);
            if (this.archiveNeedsZip64EocdRecord) {
                writeIntAsUint16(this.cDir, 65535);
                writeIntAsUint16(this.cDir, 65535);
                writeLongAsUint32(this.cDir, -1);
                writeLongAsUint32(this.cDir, -1);
            } else {
                writeIntAsUint16(this.cDir, this.entries.size());
                writeIntAsUint16(this.cDir, this.entries.size());
                writeLongAsUint32(this.cDir, (long) size);
                writeLongAsUint32(this.cDir, this.offset);
            }
            writeIntAsUint16(this.cDir, this.commentBytes.length);
            if (this.commentBytes.length > 0) {
                this.cDir.write(this.commentBytes);
            }
            this.cDir.writeTo(this.out);
            this.cDir = null;
        }
    }

    public void putNextEntry(TinkerZipEntry tinkerZipEntry) throws IOException {
        if (this.currentEntry != null) {
            closeEntry();
        }
        int method = tinkerZipEntry.getMethod();
        if (method == -1) {
            method = this.defaultCompressionMethod;
        }
        if (method == 0) {
            if (tinkerZipEntry.getCompressedSize() == -1) {
                tinkerZipEntry.setCompressedSize(tinkerZipEntry.getSize());
            } else if (tinkerZipEntry.getSize() == -1) {
                tinkerZipEntry.setSize(tinkerZipEntry.getCompressedSize());
            }
            if (tinkerZipEntry.getCrc() == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (tinkerZipEntry.getSize() == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (tinkerZipEntry.size != tinkerZipEntry.compressedSize) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        checkOpen();
        tinkerZipEntry.comment = null;
        tinkerZipEntry.extra = null;
        tinkerZipEntry.time = TIME_CONST;
        tinkerZipEntry.modDate = MOD_DATE_CONST;
        this.nameBytes = tinkerZipEntry.name.getBytes(StandardCharsets.UTF_8);
        checkSizeIsWithinShort("Name", this.nameBytes);
        this.entryCommentBytes = BYTE;
        if (tinkerZipEntry.comment != null) {
            this.entryCommentBytes = tinkerZipEntry.comment.getBytes(StandardCharsets.UTF_8);
            checkSizeIsWithinShort("Comment", this.entryCommentBytes);
        }
        tinkerZipEntry.setMethod(method);
        this.currentEntry = tinkerZipEntry;
        this.currentEntry.localHeaderRelOffset = this.offset;
        this.entries.add(this.currentEntry.name);
        int i = (method == 0 ? 0 : 8) | 2048;
        writeLongAsUint32(this.out, ZipConstants.LOCSIG);
        writeIntAsUint16(this.out, 20);
        writeIntAsUint16(this.out, i);
        writeIntAsUint16(this.out, method);
        writeIntAsUint16(this.out, this.currentEntry.time);
        writeIntAsUint16(this.out, this.currentEntry.modDate);
        if (method == 0) {
            writeLongAsUint32(this.out, this.currentEntry.crc);
            writeLongAsUint32(this.out, this.currentEntry.size);
            writeLongAsUint32(this.out, this.currentEntry.size);
        } else {
            writeLongAsUint32(this.out, 0);
            writeLongAsUint32(this.out, 0);
            writeLongAsUint32(this.out, 0);
        }
        writeIntAsUint16(this.out, this.nameBytes.length);
        if (this.currentEntry.extra != null) {
            writeIntAsUint16(this.out, this.currentEntry.extra.length);
        } else {
            writeIntAsUint16(this.out, 0);
        }
        this.out.write(this.nameBytes);
        if (this.currentEntry.extra != null) {
            this.out.write(this.currentEntry.extra);
        }
    }

    public void setComment(String str) {
        if (str == null) {
            this.commentBytes = BYTE;
            return;
        }
        str = str.getBytes(StandardCharsets.UTF_8);
        checkSizeIsWithinShort("Comment", str);
        this.commentBytes = str;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (this.currentEntry == null) {
            throw new ZipException("No active entry");
        }
        this.currentEntry.getMethod();
        this.out.write(bArr, i, i2);
    }

    private void checkOpen() throws IOException {
        if (this.cDir == null) {
            throw new IOException("Stream is closed");
        }
    }

    private void checkSizeIsWithinShort(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" too long in UTF-8:");
            stringBuilder.append(bArr.length);
            stringBuilder.append(" bytes");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
