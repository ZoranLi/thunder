package com.tencent.tinker.commons.dexpatcher.util;

import com.tencent.tinker.android.utils.SparseBoolArray;
import com.tencent.tinker.android.utils.SparseIntArray;

/* compiled from: BUGLY */
public class SparseIndexMap extends AbstractIndexMap {
    private final SparseIntArray annotationOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationSetOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationSetRefListOffsetsMap = new SparseIntArray();
    private final SparseIntArray annotationsDirectoryOffsetsMap = new SparseIntArray();
    private final SparseIntArray classDataOffsetsMap = new SparseIntArray();
    private final SparseIntArray codeOffsetsMap = new SparseIntArray();
    private final SparseIntArray debugInfoItemOffsetsMap = new SparseIntArray();
    private final SparseBoolArray deletedAnnotationOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationSetOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationSetRefListOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedAnnotationsDirectoryOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedClassDataOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedCodeOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedDebugInfoItemOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedFieldIds = new SparseBoolArray();
    private final SparseBoolArray deletedMethodIds = new SparseBoolArray();
    private final SparseBoolArray deletedProtoIds = new SparseBoolArray();
    private final SparseBoolArray deletedStaticValuesOffsets = new SparseBoolArray();
    private final SparseBoolArray deletedStringIds = new SparseBoolArray();
    private final SparseBoolArray deletedTypeIds = new SparseBoolArray();
    private final SparseBoolArray deletedTypeListOffsets = new SparseBoolArray();
    private final SparseIntArray fieldIdsMap = new SparseIntArray();
    private final SparseIntArray methodIdsMap = new SparseIntArray();
    private final SparseIntArray protoIdsMap = new SparseIntArray();
    private final SparseIntArray staticValuesOffsetsMap = new SparseIntArray();
    private final SparseIntArray stringIdsMap = new SparseIntArray();
    private final SparseIntArray typeIdsMap = new SparseIntArray();
    private final SparseIntArray typeListOffsetsMap = new SparseIntArray();

    public void mapStringIds(int i, int i2) {
        this.stringIdsMap.put(i, i2);
    }

    public void markStringIdDeleted(int i) {
        if (i >= 0) {
            this.deletedStringIds.put(i, true);
        }
    }

    public void mapTypeIds(int i, int i2) {
        this.typeIdsMap.put(i, i2);
    }

    public void markTypeIdDeleted(int i) {
        if (i >= 0) {
            this.deletedTypeIds.put(i, true);
        }
    }

    public void mapProtoIds(int i, int i2) {
        this.protoIdsMap.put(i, i2);
    }

    public void markProtoIdDeleted(int i) {
        if (i >= 0) {
            this.deletedProtoIds.put(i, true);
        }
    }

    public void mapFieldIds(int i, int i2) {
        this.fieldIdsMap.put(i, i2);
    }

    public void markFieldIdDeleted(int i) {
        if (i >= 0) {
            this.deletedFieldIds.put(i, true);
        }
    }

    public void mapMethodIds(int i, int i2) {
        this.methodIdsMap.put(i, i2);
    }

    public void markMethodIdDeleted(int i) {
        if (i >= 0) {
            this.deletedMethodIds.put(i, true);
        }
    }

    public void mapTypeListOffset(int i, int i2) {
        this.typeListOffsetsMap.put(i, i2);
    }

    public void markTypeListDeleted(int i) {
        if (i >= 0) {
            this.deletedTypeListOffsets.put(i, true);
        }
    }

    public void mapAnnotationOffset(int i, int i2) {
        this.annotationOffsetsMap.put(i, i2);
    }

    public void markAnnotationDeleted(int i) {
        if (i >= 0) {
            this.deletedAnnotationOffsets.put(i, true);
        }
    }

    public void mapAnnotationSetOffset(int i, int i2) {
        this.annotationSetOffsetsMap.put(i, i2);
    }

    public void markAnnotationSetDeleted(int i) {
        if (i >= 0) {
            this.deletedAnnotationSetOffsets.put(i, true);
        }
    }

    public void mapAnnotationSetRefListOffset(int i, int i2) {
        this.annotationSetRefListOffsetsMap.put(i, i2);
    }

    public void markAnnotationSetRefListDeleted(int i) {
        if (i >= 0) {
            this.deletedAnnotationSetRefListOffsets.put(i, true);
        }
    }

    public void mapAnnotationsDirectoryOffset(int i, int i2) {
        this.annotationsDirectoryOffsetsMap.put(i, i2);
    }

    public void markAnnotationsDirectoryDeleted(int i) {
        if (i >= 0) {
            this.deletedAnnotationsDirectoryOffsets.put(i, true);
        }
    }

    public void mapStaticValuesOffset(int i, int i2) {
        this.staticValuesOffsetsMap.put(i, i2);
    }

    public void markStaticValuesDeleted(int i) {
        if (i >= 0) {
            this.deletedStaticValuesOffsets.put(i, true);
        }
    }

    public void mapClassDataOffset(int i, int i2) {
        this.classDataOffsetsMap.put(i, i2);
    }

    public void markClassDataDeleted(int i) {
        if (i >= 0) {
            this.deletedClassDataOffsets.put(i, true);
        }
    }

    public void mapDebugInfoItemOffset(int i, int i2) {
        this.debugInfoItemOffsetsMap.put(i, i2);
    }

    public void markDebugInfoItemDeleted(int i) {
        if (i >= 0) {
            this.deletedDebugInfoItemOffsets.put(i, true);
        }
    }

    public void mapCodeOffset(int i, int i2) {
        this.codeOffsetsMap.put(i, i2);
    }

    public void markCodeDeleted(int i) {
        if (i >= 0) {
            this.deletedCodeOffsets.put(i, true);
        }
    }

    public int adjustStringIndex(int i) {
        int indexOfKey = this.stringIdsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.stringIdsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedStringIds.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustTypeIdIndex(int i) {
        int indexOfKey = this.typeIdsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.typeIdsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedTypeIds.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustProtoIdIndex(int i) {
        int indexOfKey = this.protoIdsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.protoIdsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedProtoIds.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustFieldIdIndex(int i) {
        int indexOfKey = this.fieldIdsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.fieldIdsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedFieldIds.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustMethodIdIndex(int i) {
        int indexOfKey = this.methodIdsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.methodIdsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedMethodIds.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustTypeListOffset(int i) {
        int indexOfKey = this.typeListOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.typeListOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedTypeListOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustAnnotationOffset(int i) {
        int indexOfKey = this.annotationOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.annotationOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedAnnotationOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustAnnotationSetOffset(int i) {
        int indexOfKey = this.annotationSetOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.annotationSetOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedAnnotationSetOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustAnnotationSetRefListOffset(int i) {
        int indexOfKey = this.annotationSetRefListOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.annotationSetRefListOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedAnnotationSetRefListOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustAnnotationsDirectoryOffset(int i) {
        int indexOfKey = this.annotationsDirectoryOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.annotationsDirectoryOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedAnnotationsDirectoryOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustStaticValuesOffset(int i) {
        int indexOfKey = this.staticValuesOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.staticValuesOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedStaticValuesOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustClassDataOffset(int i) {
        int indexOfKey = this.classDataOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.classDataOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedClassDataOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustDebugInfoItemOffset(int i) {
        int indexOfKey = this.debugInfoItemOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.debugInfoItemOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedDebugInfoItemOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }

    public int adjustCodeOffset(int i) {
        int indexOfKey = this.codeOffsetsMap.indexOfKey(i);
        if (indexOfKey >= 0) {
            return this.codeOffsetsMap.valueAt(indexOfKey);
        }
        if (i >= 0 && this.deletedCodeOffsets.containsKey(i)) {
            i = -1;
        }
        return i;
    }
}
