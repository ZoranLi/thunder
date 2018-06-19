package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class AnnotationSetSectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationSet> {
    private Section patchedAnnotationSetSec = null;
    private TableOfContents.Section patchedAnnotationSetTocSec = null;

    public AnnotationSetSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedAnnotationSetTocSec = dex2.getTableOfContents().annotationSets;
            this.patchedAnnotationSetSec = dex2.openSection(this.patchedAnnotationSetTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationSets;
    }

    protected AnnotationSet nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationSet();
    }

    protected int getItemSize(AnnotationSet annotationSet) {
        return annotationSet.byteCountInDex();
    }

    protected AnnotationSet adjustItem(AbstractIndexMap abstractIndexMap, AnnotationSet annotationSet) {
        return abstractIndexMap.adjust(annotationSet);
    }

    protected int writePatchedItem(AnnotationSet annotationSet) {
        TableOfContents.Section section = this.patchedAnnotationSetTocSec;
        section.size++;
        return this.patchedAnnotationSetSec.writeAnnotationSet(annotationSet);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationSetOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationSetDeleted(i2);
    }
}
