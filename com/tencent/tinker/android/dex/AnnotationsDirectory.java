package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public class AnnotationsDirectory extends Item<AnnotationsDirectory> {
    public int classAnnotationsOffset;
    public int[][] fieldAnnotations;
    public int[][] methodAnnotations;
    public int[][] parameterAnnotations;

    public AnnotationsDirectory(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.classAnnotationsOffset = i2;
        this.fieldAnnotations = iArr;
        this.methodAnnotations = iArr2;
        this.parameterAnnotations = iArr3;
    }

    public int compareTo(AnnotationsDirectory annotationsDirectory) {
        if (this.classAnnotationsOffset != annotationsDirectory.classAnnotationsOffset) {
            return CompareUtils.uCompare(this.classAnnotationsOffset, annotationsDirectory.classAnnotationsOffset);
        }
        int length = this.fieldAnnotations.length;
        int length2 = this.methodAnnotations.length;
        int length3 = this.parameterAnnotations.length;
        int length4 = annotationsDirectory.fieldAnnotations.length;
        int length5 = annotationsDirectory.methodAnnotations.length;
        int length6 = annotationsDirectory.parameterAnnotations.length;
        if (length != length4) {
            return CompareUtils.sCompare(length, length4);
        }
        if (length2 != length5) {
            return CompareUtils.sCompare(length2, length5);
        }
        if (length3 != length6) {
            return CompareUtils.sCompare(length3, length6);
        }
        for (length5 = 0; length5 < length; length5++) {
            int i = this.fieldAnnotations[length5][0];
            int i2 = this.fieldAnnotations[length5][1];
            int i3 = annotationsDirectory.fieldAnnotations[length5][0];
            length6 = annotationsDirectory.fieldAnnotations[length5][1];
            if (i != i3) {
                return CompareUtils.uCompare(i, i3);
            }
            if (i2 != length6) {
                return CompareUtils.sCompare(i2, length6);
            }
        }
        for (length = 0; length < length2; length++) {
            length5 = this.methodAnnotations[length][0];
            i = this.methodAnnotations[length][1];
            i2 = annotationsDirectory.methodAnnotations[length][0];
            i3 = annotationsDirectory.methodAnnotations[length][1];
            if (length5 != i2) {
                return CompareUtils.uCompare(length5, i2);
            }
            if (i != i3) {
                return CompareUtils.sCompare(i, i3);
            }
        }
        for (length = 0; length < length3; length++) {
            length2 = this.parameterAnnotations[length][0];
            length5 = this.parameterAnnotations[length][1];
            i = annotationsDirectory.parameterAnnotations[length][0];
            i2 = annotationsDirectory.parameterAnnotations[length][1];
            if (length2 != i) {
                return CompareUtils.uCompare(length2, i);
            }
            if (length5 != i2) {
                return CompareUtils.sCompare(length5, i2);
            }
        }
        return 0;
    }

    public int byteCountInDex() {
        return 4 * ((2 * ((this.fieldAnnotations.length + this.methodAnnotations.length) + this.parameterAnnotations.length)) + 4);
    }
}
