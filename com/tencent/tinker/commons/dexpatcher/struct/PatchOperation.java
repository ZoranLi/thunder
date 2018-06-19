package com.tencent.tinker.commons.dexpatcher.struct;

/* compiled from: BUGLY */
public final class PatchOperation<T> {
    public static final int OP_ADD = 1;
    public static final int OP_DEL = 0;
    public static final int OP_REPLACE = 2;
    public int index;
    public T newItem;
    public int op;

    public static String translateOpToString(int i) {
        switch (i) {
            case 0:
                return "OP_DEL";
            case 1:
                return "OP_ADD";
            case 2:
                return "OP_REPLACE";
            default:
                return "OP_UNKNOWN";
        }
    }

    public PatchOperation(int i, int i2) {
        this(i, i2, null);
    }

    public PatchOperation(int i, int i2, T t) {
        this.op = i;
        this.index = i2;
        this.newItem = t;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String translateOpToString = translateOpToString(this.op);
        stringBuilder.append('{');
        stringBuilder.append("op: ");
        stringBuilder.append(translateOpToString);
        stringBuilder.append(", index: ");
        stringBuilder.append(this.index);
        stringBuilder.append(", newItem: ");
        stringBuilder.append(this.newItem);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
