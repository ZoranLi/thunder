package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dx.util.Hex;
import java.util.HashSet;
import java.util.Set;

/* compiled from: BUGLY */
public abstract class InstructionComparator {
    private final InstructionHolder[] insnHolders1;
    private final InstructionHolder[] insnHolders2;
    private final short[] insns1;
    private final short[] insns2;
    private final Set<String> visitedInsnAddrPairs;

    /* compiled from: BUGLY */
    private static class InstructionHolder {
        int a;
        int address;
        int b;
        int c;
        int d;
        int e;
        int index;
        int insnFormat;
        long literal;
        int opcode;
        int registerCount;
        int target;

        private InstructionHolder() {
            this.insnFormat = 0;
            this.address = -1;
            this.opcode = -1;
            this.index = 0;
            this.target = 0;
            this.literal = 0;
            this.registerCount = 0;
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
        }
    }

    /* compiled from: BUGLY */
    private static class FillArrayDataPayloadInstructionHolder extends InstructionHolder {
        Object data;
        int elementWidth;
        int size;

        private FillArrayDataPayloadInstructionHolder() {
            super();
            this.data = null;
            this.size = 0;
            this.elementWidth = 0;
        }
    }

    /* compiled from: BUGLY */
    private static class PackedSwitchPayloadInsntructionHolder extends InstructionHolder {
        int firstKey;
        int[] targets;

        private PackedSwitchPayloadInsntructionHolder() {
            super();
            this.firstKey = 0;
            this.targets = null;
        }
    }

    /* compiled from: BUGLY */
    private static class SparseSwitchPayloadInsntructionHolder extends InstructionHolder {
        int[] keys;
        int[] targets;

        private SparseSwitchPayloadInsntructionHolder() {
            super();
            this.keys = null;
            this.targets = null;
        }
    }

    protected abstract boolean compareField(int i, int i2);

    protected abstract boolean compareMethod(int i, int i2);

    protected abstract boolean compareString(int i, int i2);

    protected abstract boolean compareType(int i, int i2);

    public InstructionComparator(short[] sArr, short[] sArr2) {
        this.insns1 = sArr;
        this.insns2 = sArr2;
        if (sArr != null) {
            this.insnHolders1 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr), sArr.length);
        } else {
            this.insnHolders1 = null;
        }
        if (sArr2 != null) {
            this.insnHolders2 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr2), sArr2.length);
        } else {
            this.insnHolders2 = null;
        }
        this.visitedInsnAddrPairs = new HashSet();
    }

    private InstructionHolder[] readInstructionsIntoHolders(ShortArrayCodeInput shortArrayCodeInput, int i) {
        shortArrayCodeInput.reset();
        i = new InstructionHolder[i];
        try {
            new InstructionReader(shortArrayCodeInput).accept(new InstructionVisitor(null) {
                public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i[i] = i4;
                }

                public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = 1;
                    i4.a = i6;
                    i[i] = i4;
                }

                public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = 2;
                    i4.a = i6;
                    i4.b = i7;
                    i[i] = i4;
                }

                public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = 3;
                    i4.a = i6;
                    i4.b = i7;
                    i4.c = i8;
                    i[i] = i4;
                }

                public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = 4;
                    i4.a = i6;
                    i4.b = i7;
                    i4.c = i8;
                    i4.d = i9;
                    i[i] = i4;
                }

                public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = 5;
                    i4.a = i6;
                    i4.b = i7;
                    i4.c = i8;
                    i4.d = i9;
                    i4.e = i10;
                    i[i] = i4;
                }

                public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
                    i4 = new InstructionHolder();
                    i4.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    i4.address = i;
                    i4.opcode = i2;
                    i4.index = i3;
                    i4.target = i5;
                    i4.literal = j;
                    i4.registerCount = i7;
                    i4.a = i6;
                    i[i] = i4;
                }

                public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
                    SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = new SparseSwitchPayloadInsntructionHolder();
                    sparseSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    sparseSwitchPayloadInsntructionHolder.address = i;
                    sparseSwitchPayloadInsntructionHolder.opcode = i2;
                    sparseSwitchPayloadInsntructionHolder.keys = iArr;
                    sparseSwitchPayloadInsntructionHolder.targets = iArr2;
                    i[i] = sparseSwitchPayloadInsntructionHolder;
                }

                public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
                    PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = new PackedSwitchPayloadInsntructionHolder();
                    packedSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    packedSwitchPayloadInsntructionHolder.address = i;
                    packedSwitchPayloadInsntructionHolder.opcode = i2;
                    packedSwitchPayloadInsntructionHolder.firstKey = i3;
                    packedSwitchPayloadInsntructionHolder.targets = iArr;
                    i[i] = packedSwitchPayloadInsntructionHolder;
                }

                public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
                    FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = new FillArrayDataPayloadInstructionHolder();
                    fillArrayDataPayloadInstructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i2);
                    fillArrayDataPayloadInstructionHolder.address = i;
                    fillArrayDataPayloadInstructionHolder.opcode = i2;
                    fillArrayDataPayloadInstructionHolder.data = obj;
                    fillArrayDataPayloadInstructionHolder.size = i3;
                    fillArrayDataPayloadInstructionHolder.elementWidth = i4;
                    i[i] = fillArrayDataPayloadInstructionHolder;
                }
            });
            return i;
        } catch (ShortArrayCodeInput shortArrayCodeInput2) {
            throw new RuntimeException(shortArrayCodeInput2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean compare() {
        /*
        r11 = this;
        r0 = r11.visitedInsnAddrPairs;
        r0.clear();
        r0 = r11.insnHolders1;
        r1 = 1;
        if (r0 != 0) goto L_0x000f;
    L_0x000a:
        r0 = r11.insnHolders2;
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = r11.insnHolders1;
        r2 = 0;
        if (r0 == 0) goto L_0x00b0;
    L_0x0014:
        r0 = r11.insnHolders2;
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        goto L_0x00b0;
    L_0x001a:
        r0 = r2;
        r3 = r0;
        r4 = r3;
        r5 = r4;
    L_0x001e:
        r6 = r11.insnHolders1;
        r6 = r6.length;
        if (r0 >= r6) goto L_0x008c;
    L_0x0023:
        r6 = r11.insnHolders2;
        r6 = r6.length;
        if (r3 >= r6) goto L_0x008c;
    L_0x0028:
        r6 = 0;
        r7 = r6;
    L_0x002a:
        r8 = r11.insnHolders1;
        r8 = r8.length;
        if (r0 >= r8) goto L_0x0039;
    L_0x002f:
        if (r7 != 0) goto L_0x0039;
    L_0x0031:
        r7 = r11.insnHolders1;
        r8 = r0 + 1;
        r7 = r7[r0];
        r0 = r8;
        goto L_0x002a;
    L_0x0039:
        if (r7 == 0) goto L_0x008c;
    L_0x003b:
        r4 = r4 + 1;
    L_0x003d:
        r8 = r11.insnHolders2;
        r8 = r8.length;
        if (r3 >= r8) goto L_0x004c;
    L_0x0042:
        if (r6 != 0) goto L_0x004c;
    L_0x0044:
        r6 = r11.insnHolders2;
        r8 = r3 + 1;
        r6 = r6[r3];
        r3 = r8;
        goto L_0x003d;
    L_0x004c:
        if (r6 == 0) goto L_0x008c;
    L_0x004e:
        r5 = r5 + 1;
        r8 = r7.opcode;
        r9 = r6.opcode;
        if (r8 == r9) goto L_0x0081;
    L_0x0056:
        r8 = r7.opcode;
        r9 = 27;
        r10 = 26;
        if (r8 != r10) goto L_0x006d;
    L_0x005e:
        r8 = r6.opcode;
        if (r8 != r9) goto L_0x006d;
    L_0x0062:
        r7 = r7.index;
        r6 = r6.index;
        r6 = r11.compareString(r7, r6);
        if (r6 != 0) goto L_0x001e;
    L_0x006c:
        return r2;
    L_0x006d:
        r8 = r7.opcode;
        if (r8 != r9) goto L_0x0080;
    L_0x0071:
        r8 = r6.opcode;
        if (r8 != r10) goto L_0x0080;
    L_0x0075:
        r7 = r7.index;
        r6 = r6.index;
        r6 = r11.compareString(r7, r6);
        if (r6 != 0) goto L_0x001e;
    L_0x007f:
        return r2;
    L_0x0080:
        return r2;
    L_0x0081:
        r7 = r7.address;
        r6 = r6.address;
        r6 = r11.isSameInstruction(r7, r6);
        if (r6 != 0) goto L_0x001e;
    L_0x008b:
        return r2;
    L_0x008c:
        r6 = r11.insnHolders1;
        r6 = r6.length;
        if (r0 >= r6) goto L_0x009c;
    L_0x0091:
        r6 = r11.insnHolders1;
        r7 = r0 + 1;
        r0 = r6[r0];
        if (r0 == 0) goto L_0x009a;
    L_0x0099:
        return r2;
    L_0x009a:
        r0 = r7;
        goto L_0x008c;
    L_0x009c:
        r0 = r11.insnHolders2;
        r0 = r0.length;
        if (r3 >= r0) goto L_0x00ac;
    L_0x00a1:
        r0 = r11.insnHolders2;
        r6 = r3 + 1;
        r0 = r0[r3];
        if (r0 == 0) goto L_0x00aa;
    L_0x00a9:
        return r2;
    L_0x00aa:
        r3 = r6;
        goto L_0x009c;
    L_0x00ac:
        if (r4 != r5) goto L_0x00af;
    L_0x00ae:
        return r1;
    L_0x00af:
        return r2;
    L_0x00b0:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionComparator.compare():boolean");
    }

    public boolean isSameInstruction(int i, int i2) {
        InstructionHolder instructionHolder = this.insnHolders1[i];
        InstructionHolder instructionHolder2 = this.insnHolders2[i2];
        if (instructionHolder == null && instructionHolder2 == null) {
            return true;
        }
        if (instructionHolder != null) {
            if (instructionHolder2 != null) {
                if (instructionHolder.opcode != instructionHolder2.opcode) {
                    return false;
                }
                int i3 = instructionHolder.opcode;
                switch (instructionHolder.insnFormat) {
                    case 2:
                    case 7:
                    case 11:
                    case 15:
                    case 18:
                    case 21:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i);
                        stringBuilder.append("-");
                        stringBuilder.append(i2);
                        if (this.visitedInsnAddrPairs.add(stringBuilder.toString()) != 0) {
                            return isSameInstruction(instructionHolder.target, instructionHolder2.target);
                        }
                        return true;
                    case 8:
                    case 13:
                    case 19:
                    case 23:
                    case 24:
                        return compareIndex(i3, instructionHolder.index, instructionHolder2.index);
                    case 26:
                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = (FillArrayDataPayloadInstructionHolder) instructionHolder;
                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder2 = (FillArrayDataPayloadInstructionHolder) instructionHolder2;
                        if (fillArrayDataPayloadInstructionHolder.elementWidth != fillArrayDataPayloadInstructionHolder2.elementWidth || fillArrayDataPayloadInstructionHolder.size != fillArrayDataPayloadInstructionHolder2.size) {
                            return false;
                        }
                        i = fillArrayDataPayloadInstructionHolder.elementWidth;
                        if (i == 4) {
                            return CompareUtils.uArrCompare((int[]) fillArrayDataPayloadInstructionHolder.data, (int[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                        } else {
                            if (i == 8) {
                                return CompareUtils.sArrCompare((long[]) fillArrayDataPayloadInstructionHolder.data, (long[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                            } else {
                                switch (i) {
                                    case 1:
                                        return CompareUtils.uArrCompare((byte[]) fillArrayDataPayloadInstructionHolder.data, (byte[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                    case 2:
                                        return CompareUtils.uArrCompare((short[]) fillArrayDataPayloadInstructionHolder.data, (short[]) fillArrayDataPayloadInstructionHolder2.data) == 0;
                                    default:
                                        StringBuilder stringBuilder2 = new StringBuilder("bogus element_width: ");
                                        stringBuilder2.append(Hex.u2(i));
                                        throw new DexException(stringBuilder2.toString());
                                }
                            }
                        }
                    case 27:
                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = (PackedSwitchPayloadInsntructionHolder) instructionHolder;
                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder2 = (PackedSwitchPayloadInsntructionHolder) instructionHolder2;
                        if (packedSwitchPayloadInsntructionHolder.firstKey != packedSwitchPayloadInsntructionHolder2.firstKey || packedSwitchPayloadInsntructionHolder.targets.length != packedSwitchPayloadInsntructionHolder2.targets.length) {
                            return false;
                        }
                        i = packedSwitchPayloadInsntructionHolder.targets.length;
                        for (i2 = 0; i2 < i; i2++) {
                            if (!isSameInstruction(packedSwitchPayloadInsntructionHolder.targets[i2], packedSwitchPayloadInsntructionHolder2.targets[i2])) {
                                return false;
                            }
                        }
                        return true;
                    case 28:
                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = (SparseSwitchPayloadInsntructionHolder) instructionHolder;
                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder2 = (SparseSwitchPayloadInsntructionHolder) instructionHolder2;
                        if (CompareUtils.uArrCompare(sparseSwitchPayloadInsntructionHolder.keys, sparseSwitchPayloadInsntructionHolder2.keys) != 0 || sparseSwitchPayloadInsntructionHolder.targets.length != sparseSwitchPayloadInsntructionHolder2.targets.length) {
                            return false;
                        }
                        i = sparseSwitchPayloadInsntructionHolder.targets.length;
                        for (i2 = 0; i2 < i; i2++) {
                            if (!isSameInstruction(sparseSwitchPayloadInsntructionHolder.targets[i2], sparseSwitchPayloadInsntructionHolder2.targets[i2])) {
                                return false;
                            }
                        }
                        return true;
                    default:
                        return instructionHolder.literal == instructionHolder2.literal && instructionHolder.registerCount == instructionHolder2.registerCount && instructionHolder.a == instructionHolder2.a && instructionHolder.b == instructionHolder2.b && instructionHolder.c == instructionHolder2.c && instructionHolder.d == instructionHolder2.d && instructionHolder.e == instructionHolder2.e;
                }
            }
        }
        return false;
    }

    private boolean compareIndex(int i, int i2, int i3) {
        switch (InstructionCodec.getInstructionIndexType(i)) {
            case 2:
                return compareType(i2, i3);
            case 3:
                return compareString(i2, i3);
            case 4:
                return compareMethod(i2, i3);
            case 5:
                return compareField(i2, i3);
            default:
                if (i2 == i3) {
                    return true;
                }
                return false;
        }
    }
}
