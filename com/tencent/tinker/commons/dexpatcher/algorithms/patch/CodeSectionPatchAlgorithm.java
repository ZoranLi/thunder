package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class CodeSectionPatchAlgorithm extends DexSectionPatchAlgorithm<Code> {
    private Section patchedCodeSec = null;
    private TableOfContents.Section patchedCodeTocSec = null;

    public CodeSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedCodeTocSec = dex2.getTableOfContents().codes;
            this.patchedCodeSec = dex2.openSection(this.patchedCodeTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().codes;
    }

    protected Code nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readCode();
    }

    protected int getItemSize(Code code) {
        return code.byteCountInDex();
    }

    protected Code adjustItem(AbstractIndexMap abstractIndexMap, Code code) {
        return abstractIndexMap.adjust(code);
    }

    protected int writePatchedItem(Code code) {
        TableOfContents.Section section = this.patchedCodeTocSec;
        section.size++;
        return this.patchedCodeSec.writeCode(code);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapCodeOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markCodeDeleted(i2);
    }
}
