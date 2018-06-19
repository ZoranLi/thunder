package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class TypeIdSectionPatchAlgorithm extends DexSectionPatchAlgorithm<Integer> {
    private Section patchedTypeIdSec = null;
    private TableOfContents.Section patchedTypeIdTocSec = null;

    protected int getItemSize(Integer num) {
        return 4;
    }

    public TypeIdSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedTypeIdTocSec = dex2.getTableOfContents().typeIds;
            this.patchedTypeIdSec = dex2.openSection(this.patchedTypeIdTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().typeIds;
    }

    protected Integer nextItem(DexDataBuffer dexDataBuffer) {
        return Integer.valueOf(dexDataBuffer.readInt());
    }

    protected Integer adjustItem(AbstractIndexMap abstractIndexMap, Integer num) {
        return Integer.valueOf(abstractIndexMap.adjustStringIndex(num.intValue()));
    }

    protected int writePatchedItem(Integer num) {
        int position = this.patchedTypeIdSec.position();
        this.patchedTypeIdSec.writeInt(num.intValue());
        num = this.patchedTypeIdTocSec;
        num.size++;
        return position;
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapTypeIds(i, i3);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markTypeIdDeleted(i);
    }
}
