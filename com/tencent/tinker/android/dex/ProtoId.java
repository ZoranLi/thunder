package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class ProtoId extends Item<ProtoId> {
    public int parametersOffset;
    public int returnTypeIndex;
    public int shortyIndex;

    public final int byteCountInDex() {
        return 12;
    }

    public ProtoId(int i, int i2, int i3, int i4) {
        super(i);
        this.shortyIndex = i2;
        this.returnTypeIndex = i3;
        this.parametersOffset = i4;
    }

    public final int compareTo(ProtoId protoId) {
        int uCompare = CompareUtils.uCompare(this.shortyIndex, protoId.shortyIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.uCompare(this.returnTypeIndex, protoId.returnTypeIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        return CompareUtils.sCompare(this.parametersOffset, protoId.parametersOffset);
    }
}
