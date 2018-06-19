package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class MethodIdSectionPatchAlgorithm extends DexSectionPatchAlgorithm<MethodId> {
    private Section patchedMethodIdSec = null;
    private TableOfContents.Section patchedMethodIdTocSec = null;

    public MethodIdSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedMethodIdTocSec = dex2.getTableOfContents().methodIds;
            this.patchedMethodIdSec = dex2.openSection(this.patchedMethodIdTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().methodIds;
    }

    protected MethodId nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readMethodId();
    }

    protected int getItemSize(MethodId methodId) {
        return methodId.byteCountInDex();
    }

    protected MethodId adjustItem(AbstractIndexMap abstractIndexMap, MethodId methodId) {
        return abstractIndexMap.adjust(methodId);
    }

    protected int writePatchedItem(MethodId methodId) {
        TableOfContents.Section section = this.patchedMethodIdTocSec;
        section.size++;
        return this.patchedMethodIdSec.writeMethodId(methodId);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapMethodIds(i, i3);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markMethodIdDeleted(i);
    }
}
