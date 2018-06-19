package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public class AnnotationSetRefList extends Item<AnnotationSetRefList> {
    public int[] annotationSetRefItems;

    public AnnotationSetRefList(int i, int[] iArr) {
        super(i);
        this.annotationSetRefItems = iArr;
    }

    public int compareTo(AnnotationSetRefList annotationSetRefList) {
        int length = this.annotationSetRefItems.length;
        int length2 = annotationSetRefList.annotationSetRefItems.length;
        if (length != length2) {
            return CompareUtils.uCompare(length, length2);
        }
        for (int i = 0; i < length; i++) {
            if (this.annotationSetRefItems[i] != annotationSetRefList.annotationSetRefItems[i]) {
                return CompareUtils.uCompare(this.annotationSetRefItems[i], annotationSetRefList.annotationSetRefItems[i]);
            }
        }
        return 0;
    }

    public int byteCountInDex() {
        return 4 * (1 + this.annotationSetRefItems.length);
    }
}
