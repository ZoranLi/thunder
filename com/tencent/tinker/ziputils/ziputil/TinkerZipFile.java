package com.tencent.tinker.ziputils.ziputil;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* compiled from: BUGLY */
public class TinkerZipFile implements ZipConstants, Closeable {
    static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
    static final int GPBF_ENCRYPTED_FLAG = 1;
    static final int GPBF_UNSUPPORTED_MASK = 1;
    static final int GPBF_UTF8_FLAG = 2048;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private String comment;
    private final LinkedHashMap<String, TinkerZipEntry> entries;
    private File fileToDeleteOnClose;
    private final String filename;
    private RandomAccessFile raf;

    /* compiled from: BUGLY */
    static class EocdRecord {
        final long centralDirOffset;
        final int commentLength;
        final long numEntries;

        EocdRecord(long j, long j2, int i) {
            this.numEntries = j;
            this.centralDirOffset = j2;
            this.commentLength = i;
        }
    }

    /* compiled from: BUGLY */
    public static class RAFStream extends InputStream {
        private long endOffset;
        private long offset;
        private final RandomAccessFile sharedRaf;

        public RAFStream(RandomAccessFile randomAccessFile, long j, long j2) {
            this.sharedRaf = randomAccessFile;
            this.offset = j;
            this.endOffset = j2;
        }

        public RAFStream(RandomAccessFile randomAccessFile, long j) throws IOException {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public int available() throws IOException {
            return this.offset < this.endOffset ? 1 : 0;
        }

        public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.sharedRaf) {
                long j = this.endOffset - this.offset;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.sharedRaf.seek(this.offset);
                bArr = this.sharedRaf.read(bArr, i, i2);
                if (bArr > null) {
                    this.offset += (long) bArr;
                    return bArr;
                }
                return -1;
            }
        }

        public long skip(long j) throws IOException {
            if (j > this.endOffset - this.offset) {
                j = this.endOffset - this.offset;
            }
            this.offset += j;
            return j;
        }
    }

    public TinkerZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public TinkerZipFile(String str) throws IOException {
        this(new File(str), 1);
    }

    public TinkerZipFile(File file, int i) throws IOException {
        this.entries = new LinkedHashMap();
        this.filename = file.getPath();
        if (i == 1 || i == 5) {
            if ((i & 4) != 0) {
                this.fileToDeleteOnClose = file;
                this.fileToDeleteOnClose.deleteOnExit();
            } else {
                this.fileToDeleteOnClose = null;
            }
            this.raf = new RandomAccessFile(this.filename, "r");
            readCentralDir();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Bad mode: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() != null) {
                return null;
            }
        }
        return true;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence.length();
            if (length == charSequence2.length()) {
                if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
                    return charSequence.equals(charSequence2);
                }
                for (int i = 0; i < length; i++) {
                    if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static EocdRecord parseEocdRecord(RandomAccessFile randomAccessFile, long j, boolean z) throws IOException {
        long j2;
        long j3;
        randomAccessFile.seek(j);
        byte[] bArr = new byte[18];
        randomAccessFile.readFully(bArr);
        BufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
        if (z) {
            it.skip(16);
            j2 = -1;
            j3 = j2;
        } else {
            int readShort = it.readShort() & 65535;
            int readShort2 = it.readShort() & 65535;
            long readShort3 = (long) (it.readShort() & 65535);
            int readShort4 = it.readShort() & 65535;
            it.skip(4);
            long readInt = ((long) it.readInt()) & 4294967295L;
            if (readShort3 == ((long) readShort4) && readShort == 0) {
                if (readShort2 == 0) {
                    j2 = readShort3;
                    j3 = readInt;
                }
            }
            throw new ZipException("Spanned archives not supported");
        }
        return new EocdRecord(j2, j3, it.readShort() & 65535);
    }

    static void throwZipException(String str, long j, String str2, long j2, String str3, int i) throws ZipException {
        i = Integer.toHexString(i);
        StringBuilder stringBuilder = new StringBuilder("file name:");
        stringBuilder.append(str);
        stringBuilder.append(", file size");
        stringBuilder.append(j);
        stringBuilder.append(", entry name:");
        stringBuilder.append(str2);
        stringBuilder.append(", entry localHeaderRelOffset:");
        stringBuilder.append(j2);
        stringBuilder.append(", ");
        stringBuilder.append(str3);
        stringBuilder.append(" signature not found; was ");
        stringBuilder.append(i);
        throw new ZipException(stringBuilder.toString());
    }

    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.raf = null;
                randomAccessFile.close();
            }
            if (this.fileToDeleteOnClose != null) {
                this.fileToDeleteOnClose.delete();
                this.fileToDeleteOnClose = null;
            }
        }
    }

    private void checkNotClosed() {
        if (this.raf == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public Enumeration<? extends TinkerZipEntry> entries() {
        checkNotClosed();
        final Iterator it = this.entries.values().iterator();
        return new Enumeration<TinkerZipEntry>() {
            public boolean hasMoreElements() {
                TinkerZipFile.this.checkNotClosed();
                return it.hasNext();
            }

            public TinkerZipEntry nextElement() {
                TinkerZipFile.this.checkNotClosed();
                return (TinkerZipEntry) it.next();
            }
        };
    }

    public String getComment() {
        checkNotClosed();
        return this.comment;
    }

    public TinkerZipEntry getEntry(String str) {
        checkNotClosed();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        TinkerZipEntry tinkerZipEntry = (TinkerZipEntry) this.entries.get(str);
        if (tinkerZipEntry != null) {
            return tinkerZipEntry;
        }
        LinkedHashMap linkedHashMap = this.entries;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        return (TinkerZipEntry) linkedHashMap.get(stringBuilder.toString());
    }

    public InputStream getInputStream(TinkerZipEntry tinkerZipEntry) throws IOException {
        tinkerZipEntry = getEntry(tinkerZipEntry.getName());
        if (tinkerZipEntry == null) {
            return null;
        }
        InputStream rAFStream;
        RandomAccessFile randomAccessFile = this.raf;
        synchronized (randomAccessFile) {
            rAFStream = new RAFStream(randomAccessFile, tinkerZipEntry.localHeaderRelOffset);
            DataInputStream dataInputStream = new DataInputStream(rAFStream);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != ZipConstants.LOCSIG) {
                throwZipException(this.filename, randomAccessFile.length(), tinkerZipEntry.getName(), tinkerZipEntry.localHeaderRelOffset, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                StringBuilder stringBuilder = new StringBuilder("Invalid General Purpose Bit Flag: ");
                stringBuilder.append(reverseBytes2);
                throw new ZipException(stringBuilder.toString());
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = 65535 & Short.reverseBytes(dataInputStream.readShort());
            dataInputStream.close();
            rAFStream.skip((long) (reverseBytes2 + reverseBytes3));
            if (tinkerZipEntry.compressionMethod == 0) {
                rAFStream.endOffset = rAFStream.offset + tinkerZipEntry.size;
            } else {
                rAFStream.endOffset = rAFStream.offset + tinkerZipEntry.compressedSize;
            }
        }
        return rAFStream;
    }

    public String getName() {
        return this.filename;
    }

    public int size() {
        checkNotClosed();
        return this.entries.size();
    }

    private void readCentralDir() throws IOException {
        long length = this.raf.length() - 22;
        long j = 0;
        if (length < 0) {
            StringBuilder stringBuilder = new StringBuilder("File too short to be a zip file: ");
            stringBuilder.append(this.raf.length());
            throw new ZipException(stringBuilder.toString());
        }
        this.raf.seek(0);
        if (((long) Integer.reverseBytes(this.raf.readInt())) != ZipConstants.LOCSIG) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (j2 >= 0) {
            j = j2;
        }
        while (true) {
            this.raf.seek(length);
            if (((long) Integer.reverseBytes(this.raf.readInt())) == ZipConstants.ENDSIG) {
                break;
            }
            j2 = length - 1;
            if (j2 < j) {
                throw new ZipException("End Of Central Directory signature not found");
            }
            length = j2;
        }
        byte[] bArr = new byte[18];
        this.raf.readFully(bArr);
        BufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
        int readShort = it.readShort() & 65535;
        int readShort2 = it.readShort() & 65535;
        int readShort3 = it.readShort() & 65535;
        int readShort4 = it.readShort() & 65535;
        it.skip(4);
        long readInt = ((long) it.readInt()) & 4294967295L;
        int readShort5 = it.readShort() & 65535;
        if (readShort3 == readShort4 && readShort == 0) {
            if (readShort2 == 0) {
                byte[] bArr2;
                if (readShort5 > 0) {
                    bArr2 = new byte[readShort5];
                    this.raf.readFully(bArr2);
                    this.comment = new String(bArr2, 0, bArr2.length, StandardCharsets.UTF_8);
                }
                InputStream bufferedInputStream = new BufferedInputStream(new RAFStream(this.raf, readInt), 4096);
                bArr2 = new byte[46];
                for (int i = 0; i < readShort3; i++) {
                    TinkerZipEntry tinkerZipEntry = new TinkerZipEntry(bArr2, bufferedInputStream, StandardCharsets.UTF_8, false);
                    if (tinkerZipEntry.localHeaderRelOffset >= readInt) {
                        throw new ZipException("Local file header offset is after central directory");
                    }
                    String name = tinkerZipEntry.getName();
                    if (this.entries.put(name, tinkerZipEntry) != null) {
                        stringBuilder = new StringBuilder("Duplicate entry name: ");
                        stringBuilder.append(name);
                        throw new ZipException(stringBuilder.toString());
                    }
                }
                return;
            }
        }
        throw new ZipException("Spanned archives not supported");
    }
}
