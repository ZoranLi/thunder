package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class MethodId extends Item<MethodId> {
    public int declaringClassIndex;
    public int nameIndex;
    public int protoIndex;

    public final int byteCountInDex() {
        return 8;
    }

    public MethodId(int i, int i2, int i3, int i4) {
        super(i);
        this.declaringClassIndex = i2;
        this.protoIndex = i3;
        this.nameIndex = i4;
    }

    public final int compareTo(MethodId methodId) {
        if (this.declaringClassIndex != methodId.declaringClassIndex) {
            return CompareUtils.uCompare(this.declaringClassIndex, methodId.declaringClassIndex);
        }
        if (this.nameIndex != methodId.nameIndex) {
            return CompareUtils.uCompare(this.nameIndex, methodId.nameIndex);
        }
        return CompareUtils.uCompare(this.protoIndex, methodId.protoIndex);
    }
}
