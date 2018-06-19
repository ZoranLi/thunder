package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class StringDataSectionPatchAlgorithm extends DexSectionPatchAlgorithm<StringData> {
    private Section patchedStringDataSec = null;
    private TableOfContents.Section patchedStringDataTocSec = null;
    private Section patchedStringIdSec = null;
    private TableOfContents.Section patchedStringIdTocSec = null;

    public StringDataSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedStringDataTocSec = dex2.getTableOfContents().stringDatas;
            this.patchedStringIdTocSec = dex2.getTableOfContents().stringIds;
            this.patchedStringDataSec = dex2.openSection(this.patchedStringDataTocSec);
            this.patchedStringIdSec = dex2.openSection(this.patchedStringIdTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().stringDatas;
    }

    protected StringData nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readStringData();
    }

    protected int getItemSize(StringData stringData) {
        return stringData.byteCountInDex();
    }

    protected int writePatchedItem(StringData stringData) {
        stringData = this.patchedStringDataSec.writeStringData(stringData);
        this.patchedStringIdSec.writeInt(stringData);
        TableOfContents.Section section = this.patchedStringDataTocSec;
        section.size++;
        section = this.patchedStringIdTocSec;
        section.size++;
        return stringData;
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapStringIds(i, i3);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markStringIdDeleted(i);
    }
}
