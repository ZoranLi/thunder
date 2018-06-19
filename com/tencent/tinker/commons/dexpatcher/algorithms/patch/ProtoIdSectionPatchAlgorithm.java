package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.Dex.Section;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;

/* compiled from: BUGLY */
public class ProtoIdSectionPatchAlgorithm extends DexSectionPatchAlgorithm<ProtoId> {
    private Section patchedProtoIdSec = null;
    private TableOfContents.Section patchedProtoIdTocSec = null;

    public ProtoIdSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, Dex dex2, SparseIndexMap sparseIndexMap) {
        super(dexPatchFile, dex, sparseIndexMap);
        if (dex2 != null) {
            this.patchedProtoIdTocSec = dex2.getTableOfContents().protoIds;
            this.patchedProtoIdSec = dex2.openSection(this.patchedProtoIdTocSec);
        }
    }

    protected TableOfContents.Section getTocSection(Dex dex) {
        return dex.getTableOfContents().protoIds;
    }

    protected ProtoId nextItem(DexDataBuffer dexDataBuffer) {
        return dexDataBuffer.readProtoId();
    }

    protected int getItemSize(ProtoId protoId) {
        return protoId.byteCountInDex();
    }

    protected ProtoId adjustItem(AbstractIndexMap abstractIndexMap, ProtoId protoId) {
        return abstractIndexMap.adjust(protoId);
    }

    protected int writePatchedItem(ProtoId protoId) {
        TableOfContents.Section section = this.patchedProtoIdTocSec;
        section.size++;
        return this.patchedProtoIdSec.writeProtoId(protoId);
    }

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
        if (i != i3) {
            sparseIndexMap.mapProtoIds(i, i3);
        }
    }

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
        sparseIndexMap.markProtoIdDeleted(i);
    }
}
