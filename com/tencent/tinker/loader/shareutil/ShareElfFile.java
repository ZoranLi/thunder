package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class ShareElfFile implements Closeable {
    public static final int FILE_TYPE_ELF = 1;
    public static final int FILE_TYPE_ODEX = 0;
    public static final int FILE_TYPE_OTHERS = -1;
    public ElfHeader elfHeader = null;
    private final FileInputStream fis;
    public ProgramHeader[] programHeaders = null;
    public SectionHeader[] sectionHeaders = null;
    private final Map<String, SectionHeader> sectionNameToHeaderMap = new HashMap();

    /* compiled from: BUGLY */
    public static class ElfHeader {
        public static final int EI_CLASS = 4;
        public static final int EI_DATA = 5;
        private static final int EI_NINDENT = 16;
        public static final int EI_VERSION = 6;
        public static final int ELFCLASS32 = 1;
        public static final int ELFCLASS64 = 2;
        public static final int ELFDATA2LSB = 1;
        public static final int ELFDATA2MSB = 2;
        public static final int ET_CORE = 4;
        public static final int ET_DYN = 3;
        public static final int ET_EXEC = 2;
        public static final int ET_HIPROC = 65535;
        public static final int ET_LOPROC = 65280;
        public static final int ET_NONE = 0;
        public static final int ET_REL = 1;
        public static final int EV_CURRENT = 1;
        public final short eEhSize;
        public final long eEntry;
        public final int eFlags;
        public final byte[] eIndent;
        public final short eMachine;
        public final short ePhEntSize;
        public final short ePhNum;
        public final long ePhOff;
        public final short eShEntSize;
        public final short eShNum;
        public final long eShOff;
        public final short eShStrNdx;
        public final short eType;
        public final int eVersion;

        private ElfHeader(FileChannel fileChannel) throws IOException {
            this.eIndent = new byte[16];
            fileChannel.position(0);
            fileChannel.read(ByteBuffer.wrap(this.eIndent));
            if (this.eIndent[0] == Byte.MAX_VALUE && this.eIndent[1] == (byte) 69 && this.eIndent[2] == (byte) 76) {
                if (this.eIndent[3] == (byte) 70) {
                    byte b = this.eIndent[4];
                    StringBuilder stringBuilder = new StringBuilder("bad elf class: ");
                    stringBuilder.append(this.eIndent[4]);
                    ShareElfFile.assertInRange(b, 1, 2, stringBuilder.toString());
                    b = this.eIndent[5];
                    StringBuilder stringBuilder2 = new StringBuilder("bad elf data encoding: ");
                    stringBuilder2.append(this.eIndent[5]);
                    ShareElfFile.assertInRange(b, 1, 2, stringBuilder2.toString());
                    ByteBuffer allocate = ByteBuffer.allocate(this.eIndent[4] == (byte) 1 ? 36 : 48);
                    allocate.order(this.eIndent[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                    ShareElfFile.readUntilLimit(fileChannel, allocate, "failed to read rest part of ehdr.");
                    this.eType = allocate.getShort();
                    this.eMachine = allocate.getShort();
                    this.eVersion = allocate.getInt();
                    fileChannel = this.eVersion;
                    stringBuilder = new StringBuilder("bad elf version: ");
                    stringBuilder.append(this.eVersion);
                    ShareElfFile.assertInRange(fileChannel, 1, 1, stringBuilder.toString());
                    switch (this.eIndent[4]) {
                        case 1:
                            this.eEntry = (long) allocate.getInt();
                            this.ePhOff = (long) allocate.getInt();
                            this.eShOff = (long) allocate.getInt();
                            break;
                        case 2:
                            this.eEntry = allocate.getLong();
                            this.ePhOff = allocate.getLong();
                            this.eShOff = allocate.getLong();
                            break;
                        default:
                            StringBuilder stringBuilder3 = new StringBuilder("Unexpected elf class: ");
                            stringBuilder3.append(this.eIndent[4]);
                            throw new IOException(stringBuilder3.toString());
                    }
                    this.eFlags = allocate.getInt();
                    this.eEhSize = allocate.getShort();
                    this.ePhEntSize = allocate.getShort();
                    this.ePhNum = allocate.getShort();
                    this.eShEntSize = allocate.getShort();
                    this.eShNum = allocate.getShort();
                    this.eShStrNdx = allocate.getShort();
                    return;
                }
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(this.eIndent[0]), Byte.valueOf(this.eIndent[1]), Byte.valueOf(this.eIndent[2]), Byte.valueOf(this.eIndent[3])}));
        }
    }

    /* compiled from: BUGLY */
    public static class ProgramHeader {
        public static final int PF_R = 4;
        public static final int PF_W = 2;
        public static final int PF_X = 1;
        public static final int PT_DYNAMIC = 2;
        public static final int PT_HIPROC = Integer.MAX_VALUE;
        public static final int PT_INTERP = 3;
        public static final int PT_LOAD = 1;
        public static final int PT_LOPROC = 1879048192;
        public static final int PT_NOTE = 4;
        public static final int PT_NULL = 0;
        public static final int PT_PHDR = 6;
        public static final int PT_SHLIB = 5;
        public final long pAlign;
        public final long pFileSize;
        public final int pFlags;
        public final long pMemSize;
        public final long pOffset;
        public final long pPddr;
        public final int pType;
        public final long pVddr;

        private ProgramHeader(ByteBuffer byteBuffer, int i) throws IOException {
            switch (i) {
                case 1:
                    this.pType = byteBuffer.getInt();
                    this.pOffset = (long) byteBuffer.getInt();
                    this.pVddr = (long) byteBuffer.getInt();
                    this.pPddr = (long) byteBuffer.getInt();
                    this.pFileSize = (long) byteBuffer.getInt();
                    this.pMemSize = (long) byteBuffer.getInt();
                    this.pFlags = byteBuffer.getInt();
                    this.pAlign = (long) byteBuffer.getInt();
                    return;
                case 2:
                    this.pType = byteBuffer.getInt();
                    this.pFlags = byteBuffer.getInt();
                    this.pOffset = byteBuffer.getLong();
                    this.pVddr = byteBuffer.getLong();
                    this.pPddr = byteBuffer.getLong();
                    this.pFileSize = byteBuffer.getLong();
                    this.pMemSize = byteBuffer.getLong();
                    this.pAlign = byteBuffer.getLong();
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unexpected elf class: ");
                    stringBuilder.append(i);
                    throw new IOException(stringBuilder.toString());
            }
        }
    }

    /* compiled from: BUGLY */
    public static class SectionHeader {
        public static final int SHF_ALLOC = 2;
        public static final int SHF_EXECINSTR = 4;
        public static final int SHF_MASKPROC = -268435456;
        public static final int SHF_WRITE = 1;
        public static final int SHN_ABS = 65521;
        public static final int SHN_COMMON = 65522;
        public static final int SHN_HIPROC = 65311;
        public static final int SHN_HIRESERVE = 65535;
        public static final int SHN_LOPROC = 65280;
        public static final int SHN_LORESERVE = 65280;
        public static final int SHN_UNDEF = 0;
        public static final int SHT_DYNAMIC = 6;
        public static final int SHT_DYNSYM = 11;
        public static final int SHT_HASH = 5;
        public static final int SHT_HIPROC = Integer.MAX_VALUE;
        public static final int SHT_HIUSER = -1;
        public static final int SHT_LOPROC = 1879048192;
        public static final int SHT_LOUSER = Integer.MIN_VALUE;
        public static final int SHT_NOBITS = 8;
        public static final int SHT_NOTE = 7;
        public static final int SHT_NULL = 0;
        public static final int SHT_PROGBITS = 1;
        public static final int SHT_REL = 9;
        public static final int SHT_RELA = 4;
        public static final int SHT_SHLIB = 10;
        public static final int SHT_STRTAB = 3;
        public static final int SHT_SYMTAB = 2;
        public final long shAddr;
        public final long shAddrAlign;
        public final long shEntSize;
        public final long shFlags;
        public final int shInfo;
        public final int shLink;
        public final int shName;
        public String shNameStr;
        public final long shOffset;
        public final long shSize;
        public final int shType;

        private SectionHeader(ByteBuffer byteBuffer, int i) throws IOException {
            switch (i) {
                case 1:
                    this.shName = byteBuffer.getInt();
                    this.shType = byteBuffer.getInt();
                    this.shFlags = (long) byteBuffer.getInt();
                    this.shAddr = (long) byteBuffer.getInt();
                    this.shOffset = (long) byteBuffer.getInt();
                    this.shSize = (long) byteBuffer.getInt();
                    this.shLink = byteBuffer.getInt();
                    this.shInfo = byteBuffer.getInt();
                    this.shAddrAlign = (long) byteBuffer.getInt();
                    this.shEntSize = (long) byteBuffer.getInt();
                    break;
                case 2:
                    this.shName = byteBuffer.getInt();
                    this.shType = byteBuffer.getInt();
                    this.shFlags = byteBuffer.getLong();
                    this.shAddr = byteBuffer.getLong();
                    this.shOffset = byteBuffer.getLong();
                    this.shSize = byteBuffer.getLong();
                    this.shLink = byteBuffer.getInt();
                    this.shInfo = byteBuffer.getInt();
                    this.shAddrAlign = byteBuffer.getLong();
                    this.shEntSize = byteBuffer.getLong();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unexpected elf class: ");
                    stringBuilder.append(i);
                    throw new IOException(stringBuilder.toString());
            }
            this.shNameStr = null;
        }
    }

    public ShareElfFile(File file) throws IOException {
        int i;
        this.fis = new FileInputStream(file);
        file = this.fis.getChannel();
        this.elfHeader = new ElfHeader(file);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.elfHeader.ePhEntSize);
        allocate.order(this.elfHeader.eIndent[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        file.position(this.elfHeader.ePhOff);
        this.programHeaders = new ProgramHeader[this.elfHeader.ePhNum];
        int i2 = 0;
        for (i = 0; i < this.programHeaders.length; i++) {
            readUntilLimit(file, allocate, "failed to read phdr.");
            this.programHeaders[i] = new ProgramHeader(allocate, this.elfHeader.eIndent[4]);
        }
        file.position(this.elfHeader.eShOff);
        allocate.limit(this.elfHeader.eShEntSize);
        this.sectionHeaders = new SectionHeader[this.elfHeader.eShNum];
        for (i = 0; i < this.sectionHeaders.length; i++) {
            readUntilLimit(file, allocate, "failed to read shdr.");
            this.sectionHeaders[i] = new SectionHeader(allocate, this.elfHeader.eIndent[4]);
        }
        if (this.elfHeader.eShStrNdx > null) {
            file = getSection(this.sectionHeaders[this.elfHeader.eShStrNdx]);
            SectionHeader[] sectionHeaderArr = this.sectionHeaders;
            int length = sectionHeaderArr.length;
            while (i2 < length) {
                SectionHeader sectionHeader = sectionHeaderArr[i2];
                file.position(sectionHeader.shName);
                sectionHeader.shNameStr = readCString(file);
                this.sectionNameToHeaderMap.put(sectionHeader.shNameStr, sectionHeader);
                i2++;
            }
        }
    }

    private static void assertInRange(int i, int i2, int i3, String str) throws IOException {
        if (i >= i2) {
            if (i <= i3) {
                return;
            }
        }
        throw new IOException(str);
    }

    public static int getFileTypeByMagic(java.io.File r7) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 4;
        r1 = 0;
        r0 = new byte[r0];	 Catch:{ all -> 0x004f }
        r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x004f }
        r2.<init>(r7);	 Catch:{ all -> 0x004f }
        r2.read(r0);	 Catch:{ all -> 0x004d }
        r7 = 0;	 Catch:{ all -> 0x004d }
        r1 = r0[r7];	 Catch:{ all -> 0x004d }
        r3 = 100;	 Catch:{ all -> 0x004d }
        r4 = 3;	 Catch:{ all -> 0x004d }
        r5 = 2;	 Catch:{ all -> 0x004d }
        r6 = 1;	 Catch:{ all -> 0x004d }
        if (r1 != r3) goto L_0x002c;	 Catch:{ all -> 0x004d }
    L_0x0016:
        r1 = r0[r6];	 Catch:{ all -> 0x004d }
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;	 Catch:{ all -> 0x004d }
        if (r1 != r3) goto L_0x002c;	 Catch:{ all -> 0x004d }
    L_0x001c:
        r1 = r0[r5];	 Catch:{ all -> 0x004d }
        r3 = 121; // 0x79 float:1.7E-43 double:6.0E-322;	 Catch:{ all -> 0x004d }
        if (r1 != r3) goto L_0x002c;	 Catch:{ all -> 0x004d }
    L_0x0022:
        r1 = r0[r4];	 Catch:{ all -> 0x004d }
        r3 = 10;
        if (r1 != r3) goto L_0x002c;
    L_0x0028:
        r2.close();	 Catch:{ Throwable -> 0x002b }
    L_0x002b:
        return r7;
    L_0x002c:
        r7 = r0[r7];	 Catch:{ all -> 0x004d }
        r1 = 127; // 0x7f float:1.78E-43 double:6.27E-322;	 Catch:{ all -> 0x004d }
        if (r7 != r1) goto L_0x0048;	 Catch:{ all -> 0x004d }
    L_0x0032:
        r7 = r0[r6];	 Catch:{ all -> 0x004d }
        r1 = 69;	 Catch:{ all -> 0x004d }
        if (r7 != r1) goto L_0x0048;	 Catch:{ all -> 0x004d }
    L_0x0038:
        r7 = r0[r5];	 Catch:{ all -> 0x004d }
        r1 = 76;	 Catch:{ all -> 0x004d }
        if (r7 != r1) goto L_0x0048;	 Catch:{ all -> 0x004d }
    L_0x003e:
        r7 = r0[r4];	 Catch:{ all -> 0x004d }
        r0 = 70;
        if (r7 != r0) goto L_0x0048;
    L_0x0044:
        r2.close();	 Catch:{ Throwable -> 0x0047 }
    L_0x0047:
        return r6;
    L_0x0048:
        r2.close();	 Catch:{ Throwable -> 0x004b }
    L_0x004b:
        r7 = -1;
        return r7;
    L_0x004d:
        r7 = move-exception;
        goto L_0x0051;
    L_0x004f:
        r7 = move-exception;
        r2 = r1;
    L_0x0051:
        if (r2 == 0) goto L_0x0056;
    L_0x0053:
        r2.close();	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareElfFile.getFileTypeByMagic(java.io.File):int");
    }

    public static void readUntilLimit(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        fileChannel = fileChannel.read(byteBuffer);
        if (fileChannel != byteBuffer.limit()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" Rest bytes insufficient, expect to read ");
            stringBuilder.append(byteBuffer.limit());
            stringBuilder.append(" bytes but only ");
            stringBuilder.append(fileChannel);
            stringBuilder.append(" bytes were read.");
            throw new IOException(stringBuilder.toString());
        }
        byteBuffer.flip();
    }

    public static String readCString(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != (byte) 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public FileChannel getChannel() {
        return this.fis.getChannel();
    }

    public boolean is32BitElf() {
        return this.elfHeader.eIndent[4] == (byte) 1;
    }

    public ByteOrder getDataOrder() {
        return this.elfHeader.eIndent[5] == (byte) 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
    }

    public SectionHeader getSectionHeaderByName(String str) {
        return (SectionHeader) this.sectionNameToHeaderMap.get(str);
    }

    public ByteBuffer getSection(SectionHeader sectionHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) sectionHeader.shSize);
        this.fis.getChannel().position(sectionHeader.shOffset);
        FileChannel channel = this.fis.getChannel();
        StringBuilder stringBuilder = new StringBuilder("failed to read section: ");
        stringBuilder.append(sectionHeader.shNameStr);
        readUntilLimit(channel, allocate, stringBuilder.toString());
        return allocate;
    }

    public ByteBuffer getSegment(ProgramHeader programHeader) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate((int) programHeader.pFileSize);
        this.fis.getChannel().position(programHeader.pOffset);
        FileChannel channel = this.fis.getChannel();
        StringBuilder stringBuilder = new StringBuilder("failed to read segment (type: ");
        stringBuilder.append(programHeader.pType);
        stringBuilder.append(").");
        readUntilLimit(channel, allocate, stringBuilder.toString());
        return allocate;
    }

    public void close() throws IOException {
        this.fis.close();
        this.sectionNameToHeaderMap.clear();
        this.programHeaders = null;
        this.sectionHeaders = null;
    }
}
