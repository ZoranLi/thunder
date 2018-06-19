package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class ClassDefSectionPatchAlgorithm extends DexSectionPatchAlgorithm<ClassDef> {
    private Section patchedClassDefSec = null;
    private TableOfContents.Section patchedClassDefTocSec = null;

    public ClassDefSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedClassDefTocSec = dex2.getTableOfContents().classDefs;
            this.patchedClassDefSec = dex2.openSection(this.patchedClassDefTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().classDefs;
    }

    protected ClassDef nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readClassDef();
    }

    protected int getItemSize(ClassDef classDef) {
        return classDef.byteCountInDex();
    }

    protected ClassDef adjustItem(AbstractIndexMap abstractIndexMap, ClassDef classDef) {
        return abstractIndexMap.adjust(classDef);
    }

    protected int writePatchedItem(ClassDef classDef) {
        TableOfContents.Section section = this.patchedClassDefTocSec;
        section.size++;
        return this.patchedClassDefSec.writeClassDef(classDef);
    }
}
