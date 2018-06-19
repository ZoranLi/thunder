package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class AnnotationSectionPatchAlgorithm extends DexSectionPatchAlgorithm<Annotation> {
    private Section patchedAnnotationSec = null;
    private TableOfContents.Section patchedAnnotationTocSec = null;

    public AnnotationSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedAnnotationTocSec = dex2.getTableOfContents().annotations;
            this.patchedAnnotationSec = dex2.openSection(this.patchedAnnotationTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotations;
    }

    protected Annotation nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotation();
    }

    protected int getItemSize(Annotation annotation) {
        return annotation.byteCountInDex();
    }

    protected Annotation adjustItem(AbstractIndexMap abstractIndexMap, Annotation annotation) {
        return abstractIndexMap.adjust(annotation);
    }

    protected int writePatchedItem(Annotation annotation) {
        TableOfContents.Section section = this.patchedAnnotationTocSec;
        section.size++;
        return this.patchedAnnotationSec.writeAnnotation(annotation);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationDeleted(i2);
    }
}
