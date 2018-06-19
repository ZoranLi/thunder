package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public class DebugInfoItem extends Item<DebugInfoItem> {
    public static final byte DBG_ADVANCE_LINE = (byte) 2;
    public static final byte DBG_ADVANCE_PC = (byte) 1;
    public static final byte DBG_END_LOCAL = (byte) 5;
    public static final byte DBG_END_SEQUENCE = (byte) 0;
    public static final byte DBG_RESTART_LOCAL = (byte) 6;
    public static final byte DBG_SET_EPILOGUE_BEGIN = (byte) 8;
    public static final byte DBG_SET_FILE = (byte) 9;
    public static final byte DBG_SET_PROLOGUE_END = (byte) 7;
    public static final byte DBG_START_LOCAL = (byte) 3;
    public static final byte DBG_START_LOCAL_EXTENDED = (byte) 4;
    public byte[] infoSTM;
    public int lineStart;
    public int[] parameterNames;

    public DebugInfoItem(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.lineStart = i2;
        this.parameterNames = iArr;
        this.infoSTM = bArr;
    }

    public int compareTo(DebugInfoItem debugInfoItem) {
        int i = this.lineStart;
        int i2 = debugInfoItem.lineStart;
        if (i != i2) {
            return i - i2;
        }
        i = CompareUtils.uArrCompare(this.parameterNames, debugInfoItem.parameterNames);
        if (i != 0) {
            return i;
        }
        return CompareUtils.uArrCompare(this.infoSTM, debugInfoItem.infoSTM);
    }

    public int byteCountInDex() {
        int unsignedLeb128Size = Leb128.unsignedLeb128Size(this.lineStart) + Leb128.unsignedLeb128Size(this.parameterNames.length);
        for (int unsignedLeb128p1Size : this.parameterNames) {
            unsignedLeb128Size += Leb128.unsignedLeb128p1Size(unsignedLeb128p1Size);
        }
        return unsignedLeb128Size + (this.infoSTM.length * 1);
    }
}
