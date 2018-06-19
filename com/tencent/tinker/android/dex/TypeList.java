package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class TypeList extends Item<TypeList> {
    public static final TypeList EMPTY = new TypeList(0, Dex.EMPTY_SHORT_ARRAY);
    public short[] types;

    public TypeList(int i, short[] sArr) {
        super(i);
        this.types = sArr;
    }

    public final int compareTo(TypeList typeList) {
        return CompareUtils.uArrCompare(this.types, typeList.types);
    }

    public final int byteCountInDex() {
        return 4 + (this.types.length * 2);
    }
}
