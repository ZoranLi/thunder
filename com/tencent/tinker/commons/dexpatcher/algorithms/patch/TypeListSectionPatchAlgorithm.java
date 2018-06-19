package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class TypeListSectionPatchAlgorithm extends DexSectionPatchAlgorithm<TypeList> {
    private Section patchedTypeListSec = null;
    private TableOfContents.Section patchedTypeListTocSec = null;

    public TypeListSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedTypeListTocSec = dex2.getTableOfContents().typeLists;
            this.patchedTypeListSec = dex2.openSection(this.patchedTypeListTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().typeLists;
    }

    protected TypeList nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readTypeList();
    }

    protected int getItemSize(TypeList typeList) {
        return typeList.byteCountInDex();
    }

    protected TypeList adjustItem(AbstractIndexMap abstractIndexMap, TypeList typeList) {
        return abstractIndexMap.adjust(typeList);
    }

    protected int writePatchedItem(TypeList typeList) {
        TableOfContents.Section section = this.patchedTypeListTocSec;
        section.size++;
        return this.patchedTypeListSec.writeTypeList(typeList);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapTypeListOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markTypeListDeleted(i2);
    }
}
