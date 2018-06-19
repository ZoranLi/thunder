package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class DebugInfoItemSectionPatchAlgorithm extends DexSectionPatchAlgorithm<DebugInfoItem> {
    private Section patchedDebugInfoItemSec = null;
    private TableOfContents.Section patchedDebugInfoItemTocSec = null;

    public DebugInfoItemSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedDebugInfoItemTocSec = dex2.getTableOfContents().debugInfos;
            this.patchedDebugInfoItemSec = dex2.openSection(this.patchedDebugInfoItemTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().debugInfos;
    }

    protected DebugInfoItem nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readDebugInfoItem();
    }

    protected int getItemSize(DebugInfoItem debugInfoItem) {
        return debugInfoItem.byteCountInDex();
    }

    protected DebugInfoItem adjustItem(AbstractIndexMap abstractIndexMap, DebugInfoItem debugInfoItem) {
        return abstractIndexMap.adjust(debugInfoItem);
    }

    protected int writePatchedItem(DebugInfoItem debugInfoItem) {
        TableOfContents.Section section = this.patchedDebugInfoItemTocSec;
        section.size++;
        return this.patchedDebugInfoItemSec.writeDebugInfoItem(debugInfoItem);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapDebugInfoItemOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markDebugInfoItemDeleted(i2);
    }
}
