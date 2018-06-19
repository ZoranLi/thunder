package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.ClassData.Method;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.android.dex.util.FileUtils;
import com.tencent.tinker.android.dx.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.zip.Adler32;

/* compiled from: BUGLY */
public final class Dex {
    private static final int CHECKSUM_OFFSET = 8;
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private static final int SIGNATURE_OFFSET = 12;
    private final ClassDefTable classDefs;
    private ByteBuffer data;
    private final FieldIdTable fieldIds;
    private final MethodIdTable methodIds;
    private int nextSectionStart;
    private final ProtoIdTable protoIds;
    private byte[] signature;
    private final StringTable strings;
    private final TableOfContents tableOfContents;
    private final TypeIndexToDescriptorIndexTable typeIds;
    private final TypeIndexToDescriptorTable typeNames;

    /* compiled from: BUGLY */
    private final class ClassDefIterable implements Iterable<ClassDef> {
        private ClassDefIterable() {
        }

        public final Iterator<ClassDef> iterator() {
            return !Dex.this.tableOfContents.classDefs.exists() ? Collections.emptySet().iterator() : new ClassDefIterator();
        }
    }

    /* compiled from: BUGLY */
    private final class ClassDefIterator implements Iterator<ClassDef> {
        private int count;
        private final Section in;

        private ClassDefIterator() {
            this.in = Dex.this.openSection(Dex.this.tableOfContents.classDefs);
            this.count = null;
        }

        public final boolean hasNext() {
            return this.count < Dex.this.tableOfContents.classDefs.size;
        }

        public final ClassDef next() {
            if (hasNext()) {
                this.count++;
                return this.in.readClassDef();
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: BUGLY */
    private final class ClassDefTable extends AbstractList<ClassDef> implements RandomAccess {
        private ClassDefTable() {
        }

        public final ClassDef get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.classDefs.size);
            return Dex.this.openSection(Dex.this.tableOfContents.classDefs.off + (32 * i)).readClassDef();
        }

        public final int size() {
            return Dex.this.tableOfContents.classDefs.size;
        }
    }

    /* compiled from: BUGLY */
    private final class FieldIdTable extends AbstractList<FieldId> implements RandomAccess {
        private FieldIdTable() {
        }

        public final FieldId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.fieldIds.size);
            return Dex.this.openSection(Dex.this.tableOfContents.fieldIds.off + (8 * i)).readFieldId();
        }

        public final int size() {
            return Dex.this.tableOfContents.fieldIds.size;
        }
    }

    /* compiled from: BUGLY */
    private final class MethodIdTable extends AbstractList<MethodId> implements RandomAccess {
        private MethodIdTable() {
        }

        public final MethodId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.methodIds.size);
            return Dex.this.openSection(Dex.this.tableOfContents.methodIds.off + (8 * i)).readMethodId();
        }

        public final int size() {
            return Dex.this.tableOfContents.methodIds.size;
        }
    }

    /* compiled from: BUGLY */
    private final class ProtoIdTable extends AbstractList<ProtoId> implements RandomAccess {
        private ProtoIdTable() {
        }

        public final ProtoId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.protoIds.size);
            return Dex.this.openSection(Dex.this.tableOfContents.protoIds.off + (12 * i)).readProtoId();
        }

        public final int size() {
            return Dex.this.tableOfContents.protoIds.size;
        }
    }

    /* compiled from: BUGLY */
    private final class StringTable extends AbstractList<String> implements RandomAccess {
        private StringTable() {
        }

        public final String get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.stringIds.size);
            return Dex.this.openSection(Dex.this.openSection(Dex.this.tableOfContents.stringIds.off + (i * 4)).readInt()).readStringData().value;
        }

        public final int size() {
            return Dex.this.tableOfContents.stringIds.size;
        }
    }

    /* compiled from: BUGLY */
    private final class TypeIndexToDescriptorIndexTable extends AbstractList<Integer> implements RandomAccess {
        private TypeIndexToDescriptorIndexTable() {
        }

        public final Integer get(int i) {
            return Integer.valueOf(Dex.this.descriptorIndexFromTypeIndex(i));
        }

        public final int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }
    }

    /* compiled from: BUGLY */
    private final class TypeIndexToDescriptorTable extends AbstractList<String> implements RandomAccess {
        private TypeIndexToDescriptorTable() {
        }

        public final String get(int i) {
            return Dex.this.strings.get(Dex.this.descriptorIndexFromTypeIndex(i));
        }

        public final int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }
    }

    /* compiled from: BUGLY */
    public final class Section extends DexDataBuffer {
        private final String name;

        private Section(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }

        public final StringData readStringData() {
            ensureFourBytesAligned(Dex.this.tableOfContents.stringDatas, false);
            return super.readStringData();
        }

        public final TypeList readTypeList() {
            ensureFourBytesAligned(Dex.this.tableOfContents.typeLists, false);
            return super.readTypeList();
        }

        public final FieldId readFieldId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.fieldIds, false);
            return super.readFieldId();
        }

        public final MethodId readMethodId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.methodIds, false);
            return super.readMethodId();
        }

        public final ProtoId readProtoId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.protoIds, false);
            return super.readProtoId();
        }

        public final ClassDef readClassDef() {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDefs, false);
            return super.readClassDef();
        }

        public final Code readCode() {
            ensureFourBytesAligned(Dex.this.tableOfContents.codes, false);
            return super.readCode();
        }

        public final DebugInfoItem readDebugInfoItem() {
            ensureFourBytesAligned(Dex.this.tableOfContents.debugInfos, false);
            return super.readDebugInfoItem();
        }

        public final ClassData readClassData() {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDatas, false);
            return super.readClassData();
        }

        public final Annotation readAnnotation() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotations, false);
            return super.readAnnotation();
        }

        public final AnnotationSet readAnnotationSet() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSets, false);
            return super.readAnnotationSet();
        }

        public final AnnotationSetRefList readAnnotationSetRefList() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSetRefLists, false);
            return super.readAnnotationSetRefList();
        }

        public final AnnotationsDirectory readAnnotationsDirectory() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationsDirectories, false);
            return super.readAnnotationsDirectory();
        }

        public final EncodedValue readEncodedArray() {
            ensureFourBytesAligned(Dex.this.tableOfContents.encodedArrays, false);
            return super.readEncodedArray();
        }

        private void ensureFourBytesAligned(com.tencent.tinker.android.dex.TableOfContents.Section section, boolean z) {
            if (section.isElementFourByteAligned != null) {
                if (z) {
                    alignToFourBytesWithZeroFill();
                    return;
                }
                alignToFourBytes();
            }
        }

        public final int writeStringData(StringData stringData) {
            ensureFourBytesAligned(Dex.this.tableOfContents.stringDatas, true);
            return super.writeStringData(stringData);
        }

        public final int writeTypeList(TypeList typeList) {
            ensureFourBytesAligned(Dex.this.tableOfContents.typeLists, true);
            return super.writeTypeList(typeList);
        }

        public final int writeFieldId(FieldId fieldId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.fieldIds, true);
            return super.writeFieldId(fieldId);
        }

        public final int writeMethodId(MethodId methodId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.methodIds, true);
            return super.writeMethodId(methodId);
        }

        public final int writeProtoId(ProtoId protoId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.protoIds, true);
            return super.writeProtoId(protoId);
        }

        public final int writeClassDef(ClassDef classDef) {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDefs, true);
            return super.writeClassDef(classDef);
        }

        public final int writeCode(Code code) {
            ensureFourBytesAligned(Dex.this.tableOfContents.codes, true);
            return super.writeCode(code);
        }

        public final int writeDebugInfoItem(DebugInfoItem debugInfoItem) {
            ensureFourBytesAligned(Dex.this.tableOfContents.debugInfos, true);
            return super.writeDebugInfoItem(debugInfoItem);
        }

        public final int writeClassData(ClassData classData) {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDatas, true);
            return super.writeClassData(classData);
        }

        public final int writeAnnotation(Annotation annotation) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotations, true);
            return super.writeAnnotation(annotation);
        }

        public final int writeAnnotationSet(AnnotationSet annotationSet) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSets, true);
            return super.writeAnnotationSet(annotationSet);
        }

        public final int writeAnnotationSetRefList(AnnotationSetRefList annotationSetRefList) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSetRefLists, true);
            return super.writeAnnotationSetRefList(annotationSetRefList);
        }

        public final int writeAnnotationsDirectory(AnnotationsDirectory annotationsDirectory) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationsDirectories, true);
            return super.writeAnnotationsDirectory(annotationsDirectory);
        }

        public final int writeEncodedArray(EncodedValue encodedValue) {
            ensureFourBytesAligned(Dex.this.tableOfContents.encodedArrays, true);
            return super.writeEncodedArray(encodedValue);
        }
    }

    public Dex(byte[] bArr) throws IOException {
        this(ByteBuffer.wrap(bArr));
    }

    private Dex(ByteBuffer byteBuffer) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        this.data = byteBuffer;
        this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.readFrom(this);
    }

    public Dex(int i) {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        this.data = ByteBuffer.wrap(new byte[i]);
        this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.fileSize = i;
    }

    public Dex(InputStream inputStream) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        loadFrom(inputStream);
    }

    public Dex(InputStream inputStream, int i) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        loadFrom(inputStream, i);
    }

    public Dex(java.io.File r6) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r5.<init>();
        r0 = new com.tencent.tinker.android.dex.TableOfContents;
        r0.<init>();
        r5.tableOfContents = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$StringTable;
        r1 = 0;
        r0.<init>();
        r5.strings = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$TypeIndexToDescriptorIndexTable;
        r0.<init>();
        r5.typeIds = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$TypeIndexToDescriptorTable;
        r0.<init>();
        r5.typeNames = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$ProtoIdTable;
        r0.<init>();
        r5.protoIds = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$FieldIdTable;
        r0.<init>();
        r5.fieldIds = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$MethodIdTable;
        r0.<init>();
        r5.methodIds = r0;
        r0 = new com.tencent.tinker.android.dex.Dex$ClassDefTable;
        r0.<init>();
        r5.classDefs = r0;
        r0 = 0;
        r5.nextSectionStart = r0;
        r5.signature = r1;
        if (r6 != 0) goto L_0x004b;
    L_0x0043:
        r6 = new java.lang.IllegalArgumentException;
        r0 = "file is null.";
        r6.<init>(r0);
        throw r6;
    L_0x004b:
        r0 = r6.getName();
        r0 = com.tencent.tinker.android.dex.util.FileUtils.hasArchiveSuffix(r0);
        if (r0 == 0) goto L_0x00a1;
    L_0x0055:
        r0 = new java.util.zip.ZipFile;	 Catch:{ all -> 0x0099 }
        r0.<init>(r6);	 Catch:{ all -> 0x0099 }
        r2 = "classes.dex";	 Catch:{ all -> 0x0097 }
        r2 = r0.getEntry(r2);	 Catch:{ all -> 0x0097 }
        if (r2 == 0) goto L_0x0083;
    L_0x0062:
        r6 = r0.getInputStream(r2);	 Catch:{ all -> 0x0079 }
        r1 = r2.getSize();	 Catch:{ all -> 0x0077 }
        r1 = (int) r1;	 Catch:{ all -> 0x0077 }
        r5.loadFrom(r6, r1);	 Catch:{ all -> 0x0077 }
        if (r6 == 0) goto L_0x0073;
    L_0x0070:
        r6.close();	 Catch:{ all -> 0x0097 }
    L_0x0073:
        r0.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0076:
        return;
    L_0x0077:
        r1 = move-exception;
        goto L_0x007d;
    L_0x0079:
        r6 = move-exception;
        r4 = r1;
        r1 = r6;
        r6 = r4;
    L_0x007d:
        if (r6 == 0) goto L_0x0082;
    L_0x007f:
        r6.close();	 Catch:{ all -> 0x0097 }
    L_0x0082:
        throw r1;	 Catch:{ all -> 0x0097 }
    L_0x0083:
        r1 = new com.tencent.tinker.android.dex.DexException;	 Catch:{ all -> 0x0097 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r3 = "Expected classes.dex in ";	 Catch:{ all -> 0x0097 }
        r2.<init>(r3);	 Catch:{ all -> 0x0097 }
        r2.append(r6);	 Catch:{ all -> 0x0097 }
        r6 = r2.toString();	 Catch:{ all -> 0x0097 }
        r1.<init>(r6);	 Catch:{ all -> 0x0097 }
        throw r1;	 Catch:{ all -> 0x0097 }
    L_0x0097:
        r6 = move-exception;
        goto L_0x009b;
    L_0x0099:
        r6 = move-exception;
        r0 = r1;
    L_0x009b:
        if (r0 == 0) goto L_0x00a0;
    L_0x009d:
        r0.close();	 Catch:{ Exception -> 0x00a0 }
    L_0x00a0:
        throw r6;
    L_0x00a1:
        r0 = r6.getName();
        r2 = ".dex";
        r0 = r0.endsWith(r2);
        if (r0 == 0) goto L_0x00d8;
    L_0x00ad:
        r0 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x00cb }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00cb }
        r2.<init>(r6);	 Catch:{ Exception -> 0x00cb }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00cb }
        r1 = r6.length();	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        r6 = (int) r1;	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        r5.loadFrom(r0, r6);	 Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
        r0.close();	 Catch:{ Exception -> 0x00c2 }
    L_0x00c2:
        return;
    L_0x00c3:
        r6 = move-exception;
        r1 = r0;
        goto L_0x00d2;
    L_0x00c6:
        r6 = move-exception;
        r1 = r0;
        goto L_0x00cc;
    L_0x00c9:
        r6 = move-exception;
        goto L_0x00d2;
    L_0x00cb:
        r6 = move-exception;
    L_0x00cc:
        r0 = new com.tencent.tinker.android.dex.DexException;	 Catch:{ all -> 0x00c9 }
        r0.<init>(r6);	 Catch:{ all -> 0x00c9 }
        throw r0;	 Catch:{ all -> 0x00c9 }
    L_0x00d2:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r1.close();	 Catch:{ Exception -> 0x00d7 }
    L_0x00d7:
        throw r6;
    L_0x00d8:
        r0 = new com.tencent.tinker.android.dex.DexException;
        r1 = new java.lang.StringBuilder;
        r2 = "unknown output extension: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dex.Dex.<init>(java.io.File):void");
    }

    private static void checkBounds(int i, int i2) {
        if (i >= 0) {
            if (i < i2) {
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("index:");
        stringBuilder.append(i);
        stringBuilder.append(", length=");
        stringBuilder.append(i2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    private void loadFrom(InputStream inputStream) throws IOException {
        loadFrom(inputStream, 0);
    }

    private void loadFrom(InputStream inputStream, int i) throws IOException {
        this.data = ByteBuffer.wrap(FileUtils.readStream(inputStream, i));
        this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.readFrom(this);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data.array());
        outputStream.flush();
    }

    public final void writeTo(java.io.File r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x001a }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x001a }
        r2.<init>(r4);	 Catch:{ Exception -> 0x001a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x001a }
        r3.writeTo(r1);	 Catch:{ Exception -> 0x0015, all -> 0x0012 }
        r1.close();	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        return;
    L_0x0012:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0021;
    L_0x0015:
        r4 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x0018:
        r4 = move-exception;
        goto L_0x0021;
    L_0x001a:
        r4 = move-exception;
    L_0x001b:
        r1 = new com.tencent.tinker.android.dex.DexException;	 Catch:{ all -> 0x0018 }
        r1.<init>(r4);	 Catch:{ all -> 0x0018 }
        throw r1;	 Catch:{ all -> 0x0018 }
    L_0x0021:
        if (r0 == 0) goto L_0x0026;
    L_0x0023:
        r0.close();	 Catch:{ Exception -> 0x0026 }
    L_0x0026:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dex.Dex.writeTo(java.io.File):void");
    }

    public final TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public final Section openSection(int i) {
        if (i >= 0) {
            if (i < this.data.capacity()) {
                ByteBuffer duplicate = this.data.duplicate();
                duplicate.order(ByteOrder.LITTLE_ENDIAN);
                duplicate.position(i);
                duplicate.limit(this.data.capacity());
                return new Section("temp-section", duplicate);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("position=");
        stringBuilder.append(i);
        stringBuilder.append(" length=");
        stringBuilder.append(this.data.capacity());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Section openSection(com.tencent.tinker.android.dex.TableOfContents.Section section) {
        int i = section.off;
        if (i >= 0) {
            if (i < this.data.capacity()) {
                ByteBuffer duplicate = this.data.duplicate();
                duplicate.order(ByteOrder.LITTLE_ENDIAN);
                duplicate.position(i);
                duplicate.limit(i + section.byteCount);
                return new Section("section", duplicate);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("position=");
        stringBuilder.append(i);
        stringBuilder.append(" length=");
        stringBuilder.append(this.data.capacity());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Section appendSection(int i, String str) {
        int i2 = this.nextSectionStart + i;
        i = this.data.duplicate();
        i.order(ByteOrder.LITTLE_ENDIAN);
        i.position(this.nextSectionStart);
        i.limit(i2);
        Section section = new Section(str, i);
        this.nextSectionStart = i2;
        return section;
    }

    public final int getLength() {
        return this.data.capacity();
    }

    public final int getNextSectionStart() {
        return this.nextSectionStart;
    }

    public final byte[] getBytes() {
        ByteBuffer duplicate = this.data.duplicate();
        byte[] bArr = new byte[duplicate.capacity()];
        duplicate.position(0);
        duplicate.get(bArr);
        return bArr;
    }

    public final List<String> strings() {
        return this.strings;
    }

    public final List<Integer> typeIds() {
        return this.typeIds;
    }

    public final List<String> typeNames() {
        return this.typeNames;
    }

    public final List<ProtoId> protoIds() {
        return this.protoIds;
    }

    public final List<FieldId> fieldIds() {
        return this.fieldIds;
    }

    public final List<MethodId> methodIds() {
        return this.methodIds;
    }

    public final List<ClassDef> classDefs() {
        return this.classDefs;
    }

    public final Iterable<ClassDef> classDefIterable() {
        return new ClassDefIterable();
    }

    public final ClassData readClassData(ClassDef classDef) {
        int i = classDef.classDataOffset;
        if (i != null) {
            return openSection(i).readClassData();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public final Code readCode(Method method) {
        int i = method.codeOffset;
        if (i != null) {
            return openSection(i).readCode();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public final byte[] computeSignature(boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.signature;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        if (r6 != 0) goto L_0x0009;
    L_0x0006:
        r6 = r5.signature;
        return r6;
    L_0x0009:
        r6 = "SHA-1";	 Catch:{ NoSuchAlgorithmException -> 0x0042 }
        r6 = java.security.MessageDigest.getInstance(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0042 }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r1 = new byte[r0];
        r2 = r5.data;
        r2 = r2.duplicate();
        r3 = r2.capacity();
        r2.limit(r3);
        r3 = 32;
        r2.position(r3);
    L_0x0025:
        r3 = r2.hasRemaining();
        if (r3 == 0) goto L_0x003b;
    L_0x002b:
        r3 = r2.remaining();
        r3 = java.lang.Math.min(r0, r3);
        r4 = 0;
        r2.get(r1, r4, r3);
        r6.update(r1, r4, r3);
        goto L_0x0025;
    L_0x003b:
        r6 = r6.digest();
        r5.signature = r6;
        return r6;
    L_0x0042:
        r6 = new java.lang.AssertionError;
        r6.<init>();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dex.Dex.computeSignature(boolean):byte[]");
    }

    private String bytesToHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length << 1);
        for (byte u1 : bArr) {
            stringBuilder.append(Hex.u1(u1));
        }
        return stringBuilder.toString();
    }

    public final int computeChecksum() throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public final void writeHashes() throws IOException {
        openSection(12).write(computeSignature(true));
        openSection(8).writeInt(computeChecksum());
    }

    public final int nameIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getInt(((this.tableOfContents.fieldIds.off + (8 * i)) + 2) + 2);
    }

    public final int findStringIndex(String str) {
        return Collections.binarySearch(this.strings, str);
    }

    public final int findTypeIndex(String str) {
        return Collections.binarySearch(this.typeNames, str);
    }

    public final int findFieldIndex(FieldId fieldId) {
        return Collections.binarySearch(this.fieldIds, fieldId);
    }

    public final int findMethodIndex(MethodId methodId) {
        return Collections.binarySearch(this.methodIds, methodId);
    }

    public final int findClassDefIndexFromTypeIndex(int i) {
        checkBounds(i, this.tableOfContents.typeIds.size);
        if (!this.tableOfContents.classDefs.exists()) {
            return -1;
        }
        for (int i2 = 0; i2 < this.tableOfContents.classDefs.size; i2++) {
            if (typeIndexFromClassDefIndex(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    public final int typeIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getShort((this.tableOfContents.fieldIds.off + (8 * i)) + 2) & 65535;
    }

    public final int declaringClassIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getShort(this.tableOfContents.methodIds.off + (8 * i)) & 65535;
    }

    public final int nameIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getInt(((this.tableOfContents.methodIds.off + (8 * i)) + 2) + 2);
    }

    public final short[] parameterTypeIndicesFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        i = this.data.getShort((this.tableOfContents.methodIds.off + (8 * i)) + 2) & 65535;
        checkBounds(i, this.tableOfContents.protoIds.size);
        i = this.data.getInt(((this.tableOfContents.protoIds.off + (12 * i)) + 4) + 4);
        if (i == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i2 = this.data.getInt(i);
        if (i2 <= 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected parameter type list size: ");
            stringBuilder.append(i2);
            throw new AssertionError(stringBuilder.toString());
        }
        i += 4;
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = this.data.getShort(i);
            i += 2;
        }
        return sArr;
    }

    public final short[] parameterTypeIndicesFromMethodId(MethodId methodId) {
        methodId = methodId.protoIndex & 65535;
        checkBounds(methodId, this.tableOfContents.protoIds.size);
        methodId = this.data.getInt(((this.tableOfContents.protoIds.off + (12 * methodId)) + 4) + 4);
        if (methodId == null) {
            return EMPTY_SHORT_ARRAY;
        }
        int i = this.data.getInt(methodId);
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected parameter type list size: ");
            stringBuilder.append(i);
            throw new AssertionError(stringBuilder.toString());
        }
        methodId += 4;
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.data.getShort(methodId);
            methodId += 2;
        }
        return sArr;
    }

    public final int returnTypeIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        i = this.data.getShort((this.tableOfContents.methodIds.off + (8 * i)) + 2) & 65535;
        checkBounds(i, this.tableOfContents.protoIds.size);
        return this.data.getInt((this.tableOfContents.protoIds.off + (12 * i)) + 4);
    }

    public final int descriptorIndexFromTypeIndex(int i) {
        checkBounds(i, this.tableOfContents.typeIds.size);
        return this.data.getInt(this.tableOfContents.typeIds.off + (4 * i));
    }

    public final int typeIndexFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (32 * i));
    }

    public final int annotationDirectoryOffsetFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt((((((this.tableOfContents.classDefs.off + (32 * i)) + 4) + 4) + 4) + 4) + 4);
    }

    public final short[] interfaceTypeIndicesFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        i = this.data.getInt((((this.tableOfContents.classDefs.off + (32 * i)) + 4) + 4) + 4);
        if (i == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i2 = this.data.getInt(i);
        if (i2 <= 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected interfaces list size: ");
            stringBuilder.append(i2);
            throw new AssertionError(stringBuilder.toString());
        }
        i += 4;
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = this.data.getShort(i);
            i += 2;
        }
        return sArr;
    }

    public final short[] interfaceTypeIndicesFromClassDef(ClassDef classDef) {
        classDef = this.data.getInt(((classDef.off + 4) + 4) + 4);
        if (classDef == null) {
            return EMPTY_SHORT_ARRAY;
        }
        int i = this.data.getInt(classDef);
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected interfaces list size: ");
            stringBuilder.append(i);
            throw new AssertionError(stringBuilder.toString());
        }
        classDef += 4;
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = this.data.getShort(classDef);
            classDef += 2;
        }
        return sArr;
    }
}
