package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class AnnotationSetRefListSectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationSetRefList> {
    private Section patchedAnnotationSetRefListSec = null;
    private TableOfContents.Section patchedAnnotationSetRefListTocSec = null;

    public AnnotationSetRefListSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedAnnotationSetRefListTocSec = dex2.getTableOfContents().annotationSetRefLists;
            this.patchedAnnotationSetRefListSec = dex2.openSection(this.patchedAnnotationSetRefListTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationSetRefLists;
    }

    protected AnnotationSetRefList nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationSetRefList();
    }

    protected int getItemSize(AnnotationSetRefList annotationSetRefList) {
        return annotationSetRefList.byteCountInDex();
    }

    protected AnnotationSetRefList adjustItem(AbstractIndexMap abstractIndexMap, AnnotationSetRefList annotationSetRefList) {
        return abstractIndexMap.adjust(annotationSetRefList);
    }

    protected int writePatchedItem(AnnotationSetRefList annotationSetRefList) {
        TableOfContents.Section section = this.patchedAnnotationSetRefListTocSec;
        section.size++;
        return this.patchedAnnotationSetRefListSec.writeAnnotationSetRefList(annotationSetRefList);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationSetRefListOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationSetRefListDeleted(i2);
    }
}
