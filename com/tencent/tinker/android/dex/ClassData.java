package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class ClassData extends Item<ClassData> {
    public Method[] directMethods;
    public Field[] instanceFields;
    public Field[] staticFields;
    public Method[] virtualMethods;

    /* compiled from: BUGLY */
    public static class Field implements Comparable<Field> {
        public int accessFlags;
        public int fieldIndex;

        public Field(int i, int i2) {
            this.fieldIndex = i;
            this.accessFlags = i2;
        }

        public int compareTo(Field field) {
            int uCompare = CompareUtils.uCompare(this.fieldIndex, field.fieldIndex);
            if (uCompare != 0) {
                return uCompare;
            }
            return CompareUtils.sCompare(this.accessFlags, field.accessFlags);
        }
    }

    /* compiled from: BUGLY */
    public static class Method implements Comparable<Method> {
        public int accessFlags;
        public int codeOffset;
        public int methodIndex;

        public Method(int i, int i2, int i3) {
            this.methodIndex = i;
            this.accessFlags = i2;
            this.codeOffset = i3;
        }

        public int compareTo(Method method) {
            int uCompare = CompareUtils.uCompare(this.methodIndex, method.methodIndex);
            if (uCompare != 0) {
                return uCompare;
            }
            uCompare = CompareUtils.sCompare(this.accessFlags, method.accessFlags);
            if (uCompare != 0) {
                return uCompare;
            }
            return CompareUtils.sCompare(this.codeOffset, method.codeOffset);
        }
    }

    public ClassData(int i, Field[] fieldArr, Field[] fieldArr2, Method[] methodArr, Method[] methodArr2) {
        super(i);
        this.staticFields = fieldArr;
        this.instanceFields = fieldArr2;
        this.directMethods = methodArr;
        this.virtualMethods = methodArr2;
    }

    public final int compareTo(ClassData classData) {
        int aArrCompare = CompareUtils.aArrCompare(this.staticFields, classData.staticFields);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        aArrCompare = CompareUtils.aArrCompare(this.instanceFields, classData.instanceFields);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        aArrCompare = CompareUtils.aArrCompare(this.directMethods, classData.directMethods);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        return CompareUtils.aArrCompare(this.virtualMethods, classData.virtualMethods);
    }

    public final int byteCountInDex() {
        return ((((((Leb128.unsignedLeb128Size(this.staticFields.length) + Leb128.unsignedLeb128Size(this.instanceFields.length)) + Leb128.unsignedLeb128Size(this.directMethods.length)) + Leb128.unsignedLeb128Size(this.virtualMethods.length)) + calcFieldsSize(this.staticFields)) + calcFieldsSize(this.instanceFields)) + calcMethodsSize(this.directMethods)) + calcMethodsSize(this.virtualMethods);
    }

    private int calcFieldsSize(Field[] fieldArr) {
        int i = 0;
        int length = fieldArr.length;
        int i2 = 0;
        int i3 = i2;
        while (i < length) {
            Field field = fieldArr[i];
            int i4 = field.fieldIndex - i2;
            i2 = field.fieldIndex;
            i3 += Leb128.unsignedLeb128Size(i4) + Leb128.unsignedLeb128Size(field.accessFlags);
            i++;
        }
        return i3;
    }

    private int calcMethodsSize(Method[] methodArr) {
        int i = 0;
        int length = methodArr.length;
        int i2 = 0;
        int i3 = i2;
        while (i < length) {
            Method method = methodArr[i];
            int i4 = method.methodIndex - i2;
            i2 = method.methodIndex;
            i3 += (Leb128.unsignedLeb128Size(i4) + Leb128.unsignedLeb128Size(method.accessFlags)) + Leb128.unsignedLeb128Size(method.codeOffset);
            i++;
        }
        return i3;
    }
}
