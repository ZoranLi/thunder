package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class FieldIdSectionPatchAlgorithm extends DexSectionPatchAlgorithm<FieldId> {
    private Section patchedFieldIdSec = null;
    private TableOfContents.Section patchedFieldIdTocSec = null;

    public FieldIdSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedFieldIdTocSec = dex2.getTableOfContents().fieldIds;
            this.patchedFieldIdSec = dex2.openSection(this.patchedFieldIdTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().fieldIds;
    }

    protected FieldId nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readFieldId();
    }

    protected int getItemSize(FieldId fieldId) {
        return fieldId.byteCountInDex();
    }

    protected FieldId adjustItem(AbstractIndexMap abstractIndexMap, FieldId fieldId) {
        return abstractIndexMap.adjust(fieldId);
    }

    protected int writePatchedItem(FieldId fieldId) {
        TableOfContents.Section section = this.patchedFieldIdTocSec;
        section.size++;
        return this.patchedFieldIdSec.writeFieldId(fieldId);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapFieldIds(i, i3);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markFieldIdDeleted(i);
    }
}
