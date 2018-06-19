package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.utils.SparseIntArray;

/* compiled from: BUGLY */
public abstract class CodeCursor {
    private final SparseIntArray baseAddressMap = new SparseIntArray();
    private int cursor = 0;

    public final int cursor() {
        return this.cursor;
    }

    public final int baseAddressForCursor() {
        int indexOfKey = this.baseAddressMap.indexOfKey(this.cursor);
        if (indexOfKey < 0) {
            return this.cursor;
        }
        return this.baseAddressMap.valueAt(indexOfKey);
    }

    public final void setBaseAddress(int i, int i2) {
        this.baseAddressMap.put(i, i2);
    }

    public void reset() {
        this.baseAddressMap.clear();
        this.cursor = 0;
    }

    protected final void advance(int i) {
        this.cursor += i;
    }
}
