package com.tencent.tinker.commons.dexpatcher;

import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSetRefListSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSetSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationsDirectorySectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ClassDataSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ClassDefSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.CodeSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.DebugInfoItemSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.FieldIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.MethodIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ProtoIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.StaticValueSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.StringDataSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.TypeIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.TypeListSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: BUGLY */
public class DexPatchApplier {
    private DexSectionPatchAlgorithm<Annotation> annotationSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationSetRefList> annotationSetRefListSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationSet> annotationSetSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationsDirectory> annotationsDirectorySectionPatchAlg;
    private DexSectionPatchAlgorithm<ClassData> classDataSectionPatchAlg;
    private DexSectionPatchAlgorithm<ClassDef> classDefSectionPatchAlg;
    private DexSectionPatchAlgorithm<Code> codeSectionPatchAlg;
    private DexSectionPatchAlgorithm<DebugInfoItem> debugInfoSectionPatchAlg;
    private DexSectionPatchAlgorithm<EncodedValue> encodedArraySectionPatchAlg;
    private DexSectionPatchAlgorithm<FieldId> fieldIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<MethodId> methodIdSectionPatchAlg;
    private final Dex oldDex;
    private final SparseIndexMap oldToPatchedIndexMap;
    private final DexPatchFile patchFile;
    private final Dex patchedDex;
    private DexSectionPatchAlgorithm<ProtoId> protoIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<StringData> stringDataSectionPatchAlg;
    private DexSectionPatchAlgorithm<Integer> typeIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<TypeList> typeListSectionPatchAlg;

    public DexPatchApplier(File file, File file2) throws IOException {
        this(new Dex(file), new DexPatchFile(file2));
    }

    public DexPatchApplier(InputStream inputStream, InputStream inputStream2) throws IOException {
        this(new Dex(inputStream), new DexPatchFile(inputStream2));
    }

    public DexPatchApplier(Dex dex, DexPatchFile dexPatchFile) {
        this.oldDex = dex;
        this.patchFile = dexPatchFile;
        this.patchedDex = new Dex(dexPatchFile.getPatchedDexSize());
        this.oldToPatchedIndexMap = new SparseIndexMap();
    }

    public void executeAndSaveTo(OutputStream outputStream) throws IOException {
        byte[] computeSignature = this.oldDex.computeSignature(false);
        if (computeSignature == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.patchFile == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (CompareUtils.uArrCompare(computeSignature, this.patchFile.getOldDexSignature()) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(computeSignature), Arrays.toString(this.patchFile.getOldDexSignature())}));
            }
            TableOfContents tableOfContents = this.patchedDex.getTableOfContents();
            tableOfContents.header.off = 0;
            tableOfContents.header.size = 1;
            tableOfContents.mapList.size = 1;
            tableOfContents.stringIds.off = this.patchFile.getPatchedStringIdSectionOffset();
            tableOfContents.typeIds.off = this.patchFile.getPatchedTypeIdSectionOffset();
            tableOfContents.typeLists.off = this.patchFile.getPatchedTypeListSectionOffset();
            tableOfContents.protoIds.off = this.patchFile.getPatchedProtoIdSectionOffset();
            tableOfContents.fieldIds.off = this.patchFile.getPatchedFieldIdSectionOffset();
            tableOfContents.methodIds.off = this.patchFile.getPatchedMethodIdSectionOffset();
            tableOfContents.classDefs.off = this.patchFile.getPatchedClassDefSectionOffset();
            tableOfContents.mapList.off = this.patchFile.getPatchedMapListSectionOffset();
            tableOfContents.stringDatas.off = this.patchFile.getPatchedStringDataSectionOffset();
            tableOfContents.annotations.off = this.patchFile.getPatchedAnnotationSectionOffset();
            tableOfContents.annotationSets.off = this.patchFile.getPatchedAnnotationSetSectionOffset();
            tableOfContents.annotationSetRefLists.off = this.patchFile.getPatchedAnnotationSetRefListSectionOffset();
            tableOfContents.annotationsDirectories.off = this.patchFile.getPatchedAnnotationsDirectorySectionOffset();
            tableOfContents.encodedArrays.off = this.patchFile.getPatchedEncodedArraySectionOffset();
            tableOfContents.debugInfos.off = this.patchFile.getPatchedDebugInfoSectionOffset();
            tableOfContents.codes.off = this.patchFile.getPatchedCodeSectionOffset();
            tableOfContents.classDatas.off = this.patchFile.getPatchedClassDataSectionOffset();
            tableOfContents.fileSize = this.patchFile.getPatchedDexSize();
            Arrays.sort(tableOfContents.sections);
            tableOfContents.computeSizesFromOffsets();
            this.stringDataSectionPatchAlg = new StringDataSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.typeIdSectionPatchAlg = new TypeIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.protoIdSectionPatchAlg = new ProtoIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.fieldIdSectionPatchAlg = new FieldIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.methodIdSectionPatchAlg = new MethodIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.classDefSectionPatchAlg = new ClassDefSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.typeListSectionPatchAlg = new TypeListSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.annotationSetRefListSectionPatchAlg = new AnnotationSetRefListSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.annotationSetSectionPatchAlg = new AnnotationSetSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.classDataSectionPatchAlg = new ClassDataSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.codeSectionPatchAlg = new CodeSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.debugInfoSectionPatchAlg = new DebugInfoItemSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.annotationSectionPatchAlg = new AnnotationSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.encodedArraySectionPatchAlg = new StaticValueSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.annotationsDirectorySectionPatchAlg = new AnnotationsDirectorySectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
            this.stringDataSectionPatchAlg.execute();
            this.typeIdSectionPatchAlg.execute();
            this.typeListSectionPatchAlg.execute();
            this.protoIdSectionPatchAlg.execute();
            this.fieldIdSectionPatchAlg.execute();
            this.methodIdSectionPatchAlg.execute();
            this.annotationSectionPatchAlg.execute();
            this.annotationSetSectionPatchAlg.execute();
            this.annotationSetRefListSectionPatchAlg.execute();
            this.annotationsDirectorySectionPatchAlg.execute();
            this.debugInfoSectionPatchAlg.execute();
            this.codeSectionPatchAlg.execute();
            this.classDataSectionPatchAlg.execute();
            this.encodedArraySectionPatchAlg.execute();
            this.classDefSectionPatchAlg.execute();
            tableOfContents.writeHeader(this.patchedDex.openSection(tableOfContents.header.off));
            tableOfContents.writeMap(this.patchedDex.openSection(tableOfContents.mapList.off));
            this.patchedDex.writeHashes();
            this.patchedDex.writeTo(outputStream);
        }
    }

    public void executeAndSaveTo(java.io.File r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0015 }
        r2 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0015 }
        r2.<init>(r4);	 Catch:{ all -> 0x0015 }
        r1.<init>(r2);	 Catch:{ all -> 0x0015 }
        r3.executeAndSaveTo(r1);	 Catch:{ all -> 0x0012 }
        r1.close();	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        return;
    L_0x0012:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0016;
    L_0x0015:
        r4 = move-exception;
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.close();	 Catch:{ Exception -> 0x001b }
    L_0x001b:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.commons.dexpatcher.DexPatchApplier.executeAndSaveTo(java.io.File):void");
    }
}
