package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class Code extends Item<Code> {
    public CatchHandler[] catchHandlers;
    public int debugInfoOffset;
    public int insSize;
    public short[] instructions;
    public int outsSize;
    public int registersSize;
    public Try[] tries;

    /* compiled from: BUGLY */
    public static class CatchHandler implements Comparable<CatchHandler> {
        public int[] addresses;
        public int catchAllAddress;
        public int offset;
        public int[] typeIndexes;

        public CatchHandler(int[] iArr, int[] iArr2, int i, int i2) {
            this.typeIndexes = iArr;
            this.addresses = iArr2;
            this.catchAllAddress = i;
            this.offset = i2;
        }

        public int compareTo(CatchHandler catchHandler) {
            int sArrCompare = CompareUtils.sArrCompare(this.typeIndexes, catchHandler.typeIndexes);
            if (sArrCompare != 0) {
                return sArrCompare;
            }
            sArrCompare = CompareUtils.sArrCompare(this.addresses, catchHandler.addresses);
            if (sArrCompare != 0) {
                return sArrCompare;
            }
            return CompareUtils.sCompare(this.catchAllAddress, catchHandler.catchAllAddress);
        }
    }

    /* compiled from: BUGLY */
    public static class Try implements Comparable<Try> {
        public int catchHandlerIndex;
        public int instructionCount;
        public int startAddress;

        public Try(int i, int i2, int i3) {
            this.startAddress = i;
            this.instructionCount = i2;
            this.catchHandlerIndex = i3;
        }

        public int compareTo(Try tryR) {
            int sCompare = CompareUtils.sCompare(this.startAddress, tryR.startAddress);
            if (sCompare != 0) {
                return sCompare;
            }
            sCompare = CompareUtils.sCompare(this.instructionCount, tryR.instructionCount);
            if (sCompare != 0) {
                return sCompare;
            }
            return CompareUtils.sCompare(this.catchHandlerIndex, tryR.catchHandlerIndex);
        }
    }

    public Code(int i, int i2, int i3, int i4, int i5, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        super(i);
        this.registersSize = i2;
        this.insSize = i3;
        this.outsSize = i4;
        this.debugInfoOffset = i5;
        this.instructions = sArr;
        this.tries = tryArr;
        this.catchHandlers = catchHandlerArr;
    }

    public final int compareTo(Code code) {
        int sCompare = CompareUtils.sCompare(this.registersSize, code.registersSize);
        if (sCompare != 0) {
            return sCompare;
        }
        sCompare = CompareUtils.sCompare(this.insSize, code.insSize);
        if (sCompare != 0) {
            return sCompare;
        }
        sCompare = CompareUtils.sCompare(this.outsSize, code.outsSize);
        if (sCompare != 0) {
            return sCompare;
        }
        sCompare = CompareUtils.sCompare(this.debugInfoOffset, code.debugInfoOffset);
        if (sCompare != 0) {
            return sCompare;
        }
        sCompare = CompareUtils.uArrCompare(this.instructions, code.instructions);
        if (sCompare != 0) {
            return sCompare;
        }
        sCompare = CompareUtils.aArrCompare(this.tries, code.tries);
        if (sCompare != 0) {
            return sCompare;
        }
        return CompareUtils.aArrCompare(this.catchHandlers, code.catchHandlers);
    }

    public final int byteCountInDex() {
        int length = this.instructions.length;
        int i = 16 + (length * 2);
        if (this.tries.length <= 0) {
            return i;
        }
        if ((length & 1) == 1) {
            i += 2;
        }
        i = (i + (this.tries.length * 8)) + Leb128.unsignedLeb128Size(this.catchHandlers.length);
        CatchHandler[] catchHandlerArr = this.catchHandlers;
        int length2 = catchHandlerArr.length;
        int i2 = i;
        i = 0;
        while (i < length2) {
            CatchHandler catchHandler = catchHandlerArr[i];
            int length3 = catchHandler.typeIndexes.length;
            if (catchHandler.catchAllAddress != -1) {
                i2 += Leb128.signedLeb128Size(-length3) + Leb128.unsignedLeb128Size(catchHandler.catchAllAddress);
            } else {
                i2 += Leb128.signedLeb128Size(length3);
            }
            int i3 = i2;
            for (i2 = 0; i2 < length3; i2++) {
                i3 += Leb128.unsignedLeb128Size(catchHandler.typeIndexes[i2]) + Leb128.unsignedLeb128Size(catchHandler.addresses[i2]);
            }
            i++;
            i2 = i3;
        }
        return i2;
    }
}
