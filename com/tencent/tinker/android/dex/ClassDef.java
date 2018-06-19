package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class ClassDef extends Item<ClassDef> {
    public static final int NO_INDEX = -1;
    public static final int NO_OFFSET = 0;
    public int accessFlags;
    public int annotationsOffset;
    public int classDataOffset;
    public int interfacesOffset;
    public int sourceFileIndex;
    public int staticValuesOffset;
    public int supertypeIndex;
    public int typeIndex;

    public final int byteCountInDex() {
        return 32;
    }

    public ClassDef(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.typeIndex = i2;
        this.accessFlags = i3;
        this.supertypeIndex = i4;
        this.interfacesOffset = i5;
        this.sourceFileIndex = i6;
        this.annotationsOffset = i7;
        this.classDataOffset = i8;
        this.staticValuesOffset = i9;
    }

    public final int compareTo(ClassDef classDef) {
        int uCompare = CompareUtils.uCompare(this.typeIndex, classDef.typeIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.sCompare(this.accessFlags, classDef.accessFlags);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.uCompare(this.supertypeIndex, classDef.supertypeIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.sCompare(this.interfacesOffset, classDef.interfacesOffset);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.uCompare(this.sourceFileIndex, classDef.sourceFileIndex);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.sCompare(this.annotationsOffset, classDef.annotationsOffset);
        if (uCompare != 0) {
            return uCompare;
        }
        uCompare = CompareUtils.sCompare(this.classDataOffset, classDef.classDataOffset);
        if (uCompare != 0) {
            return uCompare;
        }
        return CompareUtils.sCompare(this.staticValuesOffset, classDef.staticValuesOffset);
    }
}
