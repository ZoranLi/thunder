package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public class AnnotationSet extends Item<AnnotationSet> {
    public int[] annotationOffsets;

    public AnnotationSet(int i, int[] iArr) {
        super(i);
        this.annotationOffsets = iArr;
    }

    public int compareTo(AnnotationSet annotationSet) {
        int length = this.annotationOffsets.length;
        int length2 = annotationSet.annotationOffsets.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        for (int i = 0; i < length; i++) {
            if (this.annotationOffsets[i] != annotationSet.annotationOffsets[i]) {
                return CompareUtils.uCompare(this.annotationOffsets[i], annotationSet.annotationOffsets[i]);
            }
        }
        return 0;
    }

    public int byteCountInDex() {
        return 4 * (1 + this.annotationOffsets.length);
    }
}
