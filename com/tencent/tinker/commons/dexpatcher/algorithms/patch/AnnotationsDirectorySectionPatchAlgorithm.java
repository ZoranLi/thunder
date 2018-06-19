package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class AnnotationsDirectorySectionPatchAlgorithm extends DexSectionPatchAlgorithm<AnnotationsDirectory> {
    private Section patchedAnnotationsDirectorySec = null;
    private TableOfContents.Section patchedAnnotationsDirectoryTocSec = null;

    public AnnotationsDirectorySectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedAnnotationsDirectoryTocSec = dex2.getTableOfContents().annotationsDirectories;
            this.patchedAnnotationsDirectorySec = dex2.openSection(this.patchedAnnotationsDirectoryTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().annotationsDirectories;
    }

    protected AnnotationsDirectory nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readAnnotationsDirectory();
    }

    protected int getItemSize(AnnotationsDirectory annotationsDirectory) {
        return annotationsDirectory.byteCountInDex();
    }

    protected AnnotationsDirectory adjustItem(AbstractIndexMap abstractIndexMap, AnnotationsDirectory annotationsDirectory) {
        return abstractIndexMap.adjust(annotationsDirectory);
    }

    protected int writePatchedItem(AnnotationsDirectory annotationsDirectory) {
        TableOfContents.Section section = this.patchedAnnotationsDirectoryTocSec;
        section.size++;
        return this.patchedAnnotationsDirectorySec.writeAnnotationsDirectory(annotationsDirectory);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            sparseIndexMap.mapAnnotationsDirectoryOffset(i2, i4);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markAnnotationsDirectoryDeleted(i2);
    }
}
