package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class StaticValueSectionPatchAlgorithm extends DexSectionPatchAlgorithm<EncodedValue> {
    private Section patchedEncodedValueSec = null;
    private TableOfContents.Section patchedEncodedValueTocSec = null;

    public StaticValueSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedEncodedValueTocSec = dex2.getTableOfContents().encodedArrays;
            this.patchedEncodedValueSec = dex2.openSection(this.patchedEncodedValueTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().encodedArrays;
    }

    protected EncodedValue nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readEncodedArray();
    }

    protected int getItemSize(EncodedValue encodedValue) {
        return encodedValue.byteCountInDex();
    }

    protected EncodedValue adjustItem(AbstractIndexMap abstractIndexMap, EncodedValue encodedValue) {
        return abstractIndexMap.adjust(encodedValue);
    }

    protected int writePatchedItem(EncodedValue encodedValue) {
        TableOfContents.Section section = this.patchedEncodedValueTocSec;
        section.size++;
        return this.patchedEncodedValueSec.writeEncodedArray(encodedValue);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapStaticValuesOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markStaticValuesDeleted(i2);
    }
}
