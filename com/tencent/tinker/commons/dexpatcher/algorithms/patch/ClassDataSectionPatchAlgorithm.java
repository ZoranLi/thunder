package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class ClassDataSectionPatchAlgorithm extends DexSectionPatchAlgorithm<ClassData> {
    private Section patchedClassDataSec = null;
    private TableOfContents.Section patchedClassDataTocSec = null;

    public ClassDataSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedClassDataTocSec = dex2.getTableOfContents().classDatas;
            this.patchedClassDataSec = dex2.openSection(this.patchedClassDataTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().classDatas;
    }

    protected ClassData nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readClassData();
    }

    protected int getItemSize(ClassData classData) {
        return classData.byteCountInDex();
    }

    protected ClassData adjustItem(AbstractIndexMap abstractIndexMap, ClassData classData) {
        return abstractIndexMap.adjust(classData);
    }

    protected int writePatchedItem(ClassData classData) {
        TableOfContents.Section section = this.patchedClassDataTocSec;
        section.size++;
        return this.patchedClassDataSec.writeClassData(classData);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapClassDataOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markClassDataDeleted(i2);
    }
}
