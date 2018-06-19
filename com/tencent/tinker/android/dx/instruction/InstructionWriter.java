package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;

/* compiled from: BUGLY */
public final class InstructionWriter extends InstructionVisitor {
    private final ShortArrayCodeOutput codeOut;
    private final boolean hasPromoter;
    private final InstructionPromoter insnPromoter;

    public InstructionWriter(ShortArrayCodeOutput shortArrayCodeOutput, InstructionPromoter instructionPromoter) {
        super(null);
        this.codeOut = shortArrayCodeOutput;
        this.insnPromoter = instructionPromoter;
        this.hasPromoter = instructionPromoter != null ? true : null;
    }

    public final void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.hasPromoter != 0) {
            i5 = this.insnPromoter.getPromotedAddress(i5);
        }
        if (i2 != 14) {
            if (i2 != 36) {
                switch (i2) {
                    case -1:
                    case 0:
                        break;
                    default:
                        switch (i2) {
                            case 40:
                                if (this.hasPromoter != 0) {
                                    i3 = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                                    if (i3 != ((byte) i3)) {
                                        i2 = (short) i3;
                                        if (i3 != i2) {
                                            this.codeOut.write((short) 42, InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                            return;
                                        } else {
                                            this.codeOut.write(41, i2);
                                            return;
                                        }
                                    }
                                    this.codeOut.write(InstructionCodec.codeUnit(i2, i3 & 255));
                                    return;
                                }
                                this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.getTargetByte(i5, this.codeOut.cursor())));
                                return;
                            case 41:
                                if (this.hasPromoter != 0) {
                                    i3 = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                                    i4 = (short) i3;
                                    if (i3 != i4) {
                                        this.codeOut.write((short) 42, InstructionCodec.unit0(i3), InstructionCodec.unit1(i3));
                                        return;
                                    }
                                    this.codeOut.write((short) i2, i4);
                                    return;
                                }
                                i2 = (short) i2;
                                this.codeOut.write(i2, InstructionCodec.getTargetUnit(i5, this.codeOut.cursor()));
                                return;
                            case 42:
                                i = InstructionCodec.getTarget(i5, this.codeOut.cursor());
                                this.codeOut.write((short) i2, InstructionCodec.unit0(i), InstructionCodec.unit1(i));
                                return;
                            default:
                                switch (i2) {
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                        break;
                                    default:
                                        i3 = new StringBuilder("unexpected opcode: ");
                                        i3.append(Hex.u2or4(i2));
                                        throw new IllegalStateException(i3.toString());
                                }
                        }
                }
            }
            this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 0)), (short) i3, InstructionCodec.codeUnit(0, 0, 0, 0));
            return;
        }
        this.codeOut.write((short) i2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitOneRegisterInsn(int r7, int r8, int r9, int r10, int r11, long r12, int r14) {
        /*
        r6 = this;
        r7 = r6.hasPromoter;
        if (r7 == 0) goto L_0x000a;
    L_0x0004:
        r7 = r6.insnPromoter;
        r11 = r7.getPromotedAddress(r11);
    L_0x000a:
        r7 = 34;
        if (r8 == r7) goto L_0x0166;
    L_0x000e:
        r7 = 36;
        if (r8 == r7) goto L_0x0151;
    L_0x0012:
        switch(r8) {
            case 10: goto L_0x0147;
            case 11: goto L_0x0147;
            case 12: goto L_0x0147;
            case 13: goto L_0x0147;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r8) {
            case 15: goto L_0x0147;
            case 16: goto L_0x0147;
            case 17: goto L_0x0147;
            case 18: goto L_0x0134;
            case 19: goto L_0x0126;
            case 20: goto L_0x0110;
            case 21: goto L_0x00f9;
            case 22: goto L_0x0126;
            case 23: goto L_0x0110;
            case 24: goto L_0x00df;
            case 25: goto L_0x00f9;
            case 26: goto L_0x008d;
            case 27: goto L_0x007b;
            case 28: goto L_0x0166;
            case 29: goto L_0x0147;
            case 30: goto L_0x0147;
            case 31: goto L_0x0166;
            default: goto L_0x0018;
        };
    L_0x0018:
        switch(r8) {
            case 38: goto L_0x0050;
            case 39: goto L_0x0147;
            default: goto L_0x001b;
        };
    L_0x001b:
        switch(r8) {
            case 43: goto L_0x0050;
            case 44: goto L_0x0050;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r8) {
            case 56: goto L_0x003c;
            case 57: goto L_0x003c;
            case 58: goto L_0x003c;
            case 59: goto L_0x003c;
            case 60: goto L_0x003c;
            case 61: goto L_0x003c;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r8) {
            case 96: goto L_0x0166;
            case 97: goto L_0x0166;
            case 98: goto L_0x0166;
            case 99: goto L_0x0166;
            case 100: goto L_0x0166;
            case 101: goto L_0x0166;
            case 102: goto L_0x0166;
            case 103: goto L_0x0166;
            case 104: goto L_0x0166;
            case 105: goto L_0x0166;
            case 106: goto L_0x0166;
            case 107: goto L_0x0166;
            case 108: goto L_0x0166;
            case 109: goto L_0x0166;
            case 110: goto L_0x0151;
            case 111: goto L_0x0151;
            case 112: goto L_0x0151;
            case 113: goto L_0x0151;
            case 114: goto L_0x0151;
            default: goto L_0x0024;
        };
    L_0x0024:
        r7 = new java.lang.IllegalStateException;
        r9 = new java.lang.StringBuilder;
        r10 = "unexpected opcode: ";
        r9.<init>(r10);
        r8 = com.tencent.tinker.android.dx.util.Hex.u2or4(r8);
        r9.append(r8);
        r8 = r9.toString();
        r7.<init>(r8);
        throw r7;
    L_0x003c:
        r7 = r6.codeOut;
        r7 = r7.cursor();
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getTargetUnit(r11, r7);
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9.write(r8, r7);
        return;
    L_0x0050:
        switch(r8) {
            case 43: goto L_0x0054;
            case 44: goto L_0x0054;
            default: goto L_0x0053;
        };
    L_0x0053:
        goto L_0x005f;
    L_0x0054:
        r7 = r6.codeOut;
        r9 = r6.codeOut;
        r9 = r9.cursor();
        r7.setBaseAddress(r11, r9);
    L_0x005f:
        r7 = r6.codeOut;
        r7 = r7.cursor();
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getTarget(r11, r7);
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit0(r7);
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit1(r7);
        r9.write(r8, r10, r7);
        return;
    L_0x007b:
        r7 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit0(r9);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit1(r9);
        r7.write(r8, r10, r9);
        return;
    L_0x008d:
        r7 = r6.hasPromoter;
        r10 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r7 == 0) goto L_0x00b5;
    L_0x0094:
        if (r9 <= r10) goto L_0x00aa;
    L_0x0096:
        r7 = r6.codeOut;
        r8 = 27;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit0(r9);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit1(r9);
        r7.write(r8, r10, r9);
        return;
    L_0x00aa:
        r7 = (short) r9;
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9.write(r8, r7);
        return;
    L_0x00b5:
        if (r9 <= r10) goto L_0x00d4;
    L_0x00b7:
        r7 = new com.tencent.tinker.android.dex.DexException;
        r8 = new java.lang.StringBuilder;
        r10 = "string index out of bound: ";
        r8.<init>(r10);
        r9 = com.tencent.tinker.android.dx.util.Hex.u4(r9);
        r8.append(r9);
        r9 = ", perhaps you need to enable force jumbo mode.";
        r8.append(r9);
        r8 = r8.toString();
        r7.<init>(r8);
        throw r7;
    L_0x00d4:
        r7 = (short) r9;
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9.write(r8, r7);
        return;
    L_0x00df:
        r0 = r6.codeOut;
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit0(r12);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit1(r12);
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit2(r12);
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit3(r12);
        r0.write(r1, r2, r3, r4, r5);
        return;
    L_0x00f9:
        r7 = 21;
        if (r8 != r7) goto L_0x0100;
    L_0x00fd:
        r7 = 16;
        goto L_0x0102;
    L_0x0100:
        r7 = 48;
    L_0x0102:
        r9 = r12 >> r7;
        r7 = (int) r9;
        r7 = (short) r7;
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9.write(r8, r7);
        return;
    L_0x0110:
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getLiteralInt(r12);
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit0(r7);
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.unit1(r7);
        r9.write(r8, r10, r7);
        return;
    L_0x0126:
        r7 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getLiteralUnit(r12);
        r7.write(r8, r9);
        return;
    L_0x0134:
        r7 = (short) r8;
        r8 = r6.codeOut;
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getLiteralNibble(r12);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r14, r9);
        r7 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r7, r9);
        r8.write(r7);
        return;
    L_0x0147:
        r7 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r7.write(r8);
        return;
    L_0x0151:
        r7 = (short) r9;
        r9 = r6.codeOut;
        r10 = 1;
        r11 = 0;
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r11, r10);
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r10);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r14, r11, r11, r11);
        r9.write(r8, r7, r10);
        return;
    L_0x0166:
        r7 = (short) r9;
        r9 = r6.codeOut;
        r8 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r14);
        r9.write(r8, r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionWriter.visitOneRegisterInsn(int, int, int, int, int, long, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitTwoRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9) {
        /*
        r0 = this;
        r1 = r0.hasPromoter;
        if (r1 == 0) goto L_0x000a;
    L_0x0004:
        r1 = r0.insnPromoter;
        r5 = r1.getPromotedAddress(r5);
    L_0x000a:
        switch(r2) {
            case 1: goto L_0x00b7;
            case 2: goto L_0x00a9;
            case 3: goto L_0x009a;
            case 4: goto L_0x00b7;
            case 5: goto L_0x00a9;
            case 6: goto L_0x009a;
            case 7: goto L_0x00b7;
            case 8: goto L_0x00a9;
            case 9: goto L_0x009a;
            default: goto L_0x000d;
        };
    L_0x000d:
        switch(r2) {
            case 32: goto L_0x008b;
            case 33: goto L_0x00b7;
            default: goto L_0x0010;
        };
    L_0x0010:
        switch(r2) {
            case 35: goto L_0x008b;
            case 36: goto L_0x0076;
            default: goto L_0x0013;
        };
    L_0x0013:
        switch(r2) {
            case 50: goto L_0x005e;
            case 51: goto L_0x005e;
            case 52: goto L_0x005e;
            case 53: goto L_0x005e;
            case 54: goto L_0x005e;
            case 55: goto L_0x005e;
            default: goto L_0x0016;
        };
    L_0x0016:
        switch(r2) {
            case 82: goto L_0x008b;
            case 83: goto L_0x008b;
            case 84: goto L_0x008b;
            case 85: goto L_0x008b;
            case 86: goto L_0x008b;
            case 87: goto L_0x008b;
            case 88: goto L_0x008b;
            case 89: goto L_0x008b;
            case 90: goto L_0x008b;
            case 91: goto L_0x008b;
            case 92: goto L_0x008b;
            case 93: goto L_0x008b;
            case 94: goto L_0x008b;
            case 95: goto L_0x008b;
            default: goto L_0x0019;
        };
    L_0x0019:
        switch(r2) {
            case 110: goto L_0x0076;
            case 111: goto L_0x0076;
            case 112: goto L_0x0076;
            case 113: goto L_0x0076;
            case 114: goto L_0x0076;
            default: goto L_0x001c;
        };
    L_0x001c:
        switch(r2) {
            case 123: goto L_0x00b7;
            case 124: goto L_0x00b7;
            case 125: goto L_0x00b7;
            case 126: goto L_0x00b7;
            case 127: goto L_0x00b7;
            case 128: goto L_0x00b7;
            case 129: goto L_0x00b7;
            case 130: goto L_0x00b7;
            case 131: goto L_0x00b7;
            case 132: goto L_0x00b7;
            case 133: goto L_0x00b7;
            case 134: goto L_0x00b7;
            case 135: goto L_0x00b7;
            case 136: goto L_0x00b7;
            case 137: goto L_0x00b7;
            case 138: goto L_0x00b7;
            case 139: goto L_0x00b7;
            case 140: goto L_0x00b7;
            case 141: goto L_0x00b7;
            case 142: goto L_0x00b7;
            case 143: goto L_0x00b7;
            default: goto L_0x001f;
        };
    L_0x001f:
        switch(r2) {
            case 176: goto L_0x00b7;
            case 177: goto L_0x00b7;
            case 178: goto L_0x00b7;
            case 179: goto L_0x00b7;
            case 180: goto L_0x00b7;
            case 181: goto L_0x00b7;
            case 182: goto L_0x00b7;
            case 183: goto L_0x00b7;
            case 184: goto L_0x00b7;
            case 185: goto L_0x00b7;
            case 186: goto L_0x00b7;
            case 187: goto L_0x00b7;
            case 188: goto L_0x00b7;
            case 189: goto L_0x00b7;
            case 190: goto L_0x00b7;
            case 191: goto L_0x00b7;
            case 192: goto L_0x00b7;
            case 193: goto L_0x00b7;
            case 194: goto L_0x00b7;
            case 195: goto L_0x00b7;
            case 196: goto L_0x00b7;
            case 197: goto L_0x00b7;
            case 198: goto L_0x00b7;
            case 199: goto L_0x00b7;
            case 200: goto L_0x00b7;
            case 201: goto L_0x00b7;
            case 202: goto L_0x00b7;
            case 203: goto L_0x00b7;
            case 204: goto L_0x00b7;
            case 205: goto L_0x00b7;
            case 206: goto L_0x00b7;
            case 207: goto L_0x00b7;
            case 208: goto L_0x004c;
            case 209: goto L_0x004c;
            case 210: goto L_0x004c;
            case 211: goto L_0x004c;
            case 212: goto L_0x004c;
            case 213: goto L_0x004c;
            case 214: goto L_0x004c;
            case 215: goto L_0x004c;
            case 216: goto L_0x003a;
            case 217: goto L_0x003a;
            case 218: goto L_0x003a;
            case 219: goto L_0x003a;
            case 220: goto L_0x003a;
            case 221: goto L_0x003a;
            case 222: goto L_0x003a;
            case 223: goto L_0x003a;
            case 224: goto L_0x003a;
            case 225: goto L_0x003a;
            case 226: goto L_0x003a;
            default: goto L_0x0022;
        };
    L_0x0022:
        r1 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "unexpected opcode: ";
        r3.<init>(r4);
        r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2);
        r3.append(r2);
        r2 = r3.toString();
        r1.<init>(r2);
        throw r1;
    L_0x003a:
        r1 = r0.codeOut;
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r8);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getLiteralByte(r6);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r9, r3);
        r1.write(r2, r3);
        return;
    L_0x004c:
        r1 = r0.codeOut;
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r8, r9);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r3);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getLiteralUnit(r6);
        r1.write(r2, r3);
        return;
    L_0x005e:
        r1 = r0.codeOut;
        r1 = r1.cursor();
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getTargetUnit(r5, r1);
        r3 = r0.codeOut;
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r8, r9);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r4);
        r3.write(r2, r1);
        return;
    L_0x0076:
        r1 = (short) r3;
        r3 = r0.codeOut;
        r4 = 2;
        r5 = 0;
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r5, r4);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r4);
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r9, r5, r5);
        r3.write(r2, r1, r4);
        return;
    L_0x008b:
        r1 = (short) r3;
        r3 = r0.codeOut;
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r8, r9);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r4);
        r3.write(r2, r1);
        return;
    L_0x009a:
        r1 = (short) r2;
        r2 = r0.codeOut;
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getAUnit(r8);
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getBUnit(r9);
        r2.write(r1, r3, r4);
        return;
    L_0x00a9:
        r1 = r0.codeOut;
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r8);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getBUnit(r9);
        r1.write(r2, r3);
        return;
    L_0x00b7:
        r1 = (short) r2;
        r2 = r0.codeOut;
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r8, r9);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r1, r3);
        r2.write(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionWriter.visitTwoRegisterInsn(int, int, int, int, int, long, int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitThreeRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9, int r10) {
        /*
        r0 = this;
        r1 = 36;
        if (r2 == r1) goto L_0x0036;
    L_0x0004:
        switch(r2) {
            case 45: goto L_0x0028;
            case 46: goto L_0x0028;
            case 47: goto L_0x0028;
            case 48: goto L_0x0028;
            case 49: goto L_0x0028;
            default: goto L_0x0007;
        };
    L_0x0007:
        switch(r2) {
            case 68: goto L_0x0028;
            case 69: goto L_0x0028;
            case 70: goto L_0x0028;
            case 71: goto L_0x0028;
            case 72: goto L_0x0028;
            case 73: goto L_0x0028;
            case 74: goto L_0x0028;
            case 75: goto L_0x0028;
            case 76: goto L_0x0028;
            case 77: goto L_0x0028;
            case 78: goto L_0x0028;
            case 79: goto L_0x0028;
            case 80: goto L_0x0028;
            case 81: goto L_0x0028;
            default: goto L_0x000a;
        };
    L_0x000a:
        switch(r2) {
            case 110: goto L_0x0036;
            case 111: goto L_0x0036;
            case 112: goto L_0x0036;
            case 113: goto L_0x0036;
            case 114: goto L_0x0036;
            default: goto L_0x000d;
        };
    L_0x000d:
        switch(r2) {
            case 144: goto L_0x0028;
            case 145: goto L_0x0028;
            case 146: goto L_0x0028;
            case 147: goto L_0x0028;
            case 148: goto L_0x0028;
            case 149: goto L_0x0028;
            case 150: goto L_0x0028;
            case 151: goto L_0x0028;
            case 152: goto L_0x0028;
            case 153: goto L_0x0028;
            case 154: goto L_0x0028;
            case 155: goto L_0x0028;
            case 156: goto L_0x0028;
            case 157: goto L_0x0028;
            case 158: goto L_0x0028;
            case 159: goto L_0x0028;
            case 160: goto L_0x0028;
            case 161: goto L_0x0028;
            case 162: goto L_0x0028;
            case 163: goto L_0x0028;
            case 164: goto L_0x0028;
            case 165: goto L_0x0028;
            case 166: goto L_0x0028;
            case 167: goto L_0x0028;
            case 168: goto L_0x0028;
            case 169: goto L_0x0028;
            case 170: goto L_0x0028;
            case 171: goto L_0x0028;
            case 172: goto L_0x0028;
            case 173: goto L_0x0028;
            case 174: goto L_0x0028;
            case 175: goto L_0x0028;
            default: goto L_0x0010;
        };
    L_0x0010:
        r1 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "unexpected opcode: ";
        r3.<init>(r4);
        r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2);
        r3.append(r2);
        r2 = r3.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0028:
        r1 = r0.codeOut;
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r8);
        r3 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r9, r10);
        r1.write(r2, r3);
        return;
    L_0x0036:
        r1 = (short) r3;
        r3 = r0.codeOut;
        r4 = 3;
        r5 = 0;
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.makeByte(r5, r4);
        r2 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r2, r4);
        r4 = com.tencent.tinker.android.dx.instruction.InstructionCodec.codeUnit(r8, r9, r10, r5);
        r3.write(r2, r1, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionWriter.visitThreeRegisterInsn(int, int, int, int, int, long, int, int, int):void");
    }

    public final void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    i3 = new StringBuilder("unexpected opcode: ");
                    i3.append(Hex.u2or4(i2));
                    throw new IllegalStateException(i3.toString());
            }
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(0, 4)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }

    public final void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        if (i2 != 36) {
            switch (i2) {
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                    break;
                default:
                    i3 = new StringBuilder("unexpected opcode: ");
                    i3.append(Hex.u2or4(i2));
                    throw new IllegalStateException(i3.toString());
            }
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, InstructionCodec.makeByte(i10, 5)), (short) i3, InstructionCodec.codeUnit(i6, i7, i8, i9));
    }

    public final void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (i2 != 37) {
            switch (i2) {
                case 116:
                case 117:
                case 118:
                case Opcodes.INVOKE_STATIC_RANGE /*119*/:
                case 120:
                    break;
                default:
                    i3 = new StringBuilder("unexpected opcode: ");
                    i3.append(Hex.u2or4(i2));
                    throw new IllegalStateException(i3.toString());
            }
        }
        this.codeOut.write(InstructionCodec.codeUnit(i2, i7), (short) i3, InstructionCodec.getAUnit(i6));
    }

    public final void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        i = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        int i3 = 0;
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr2.length));
        for (int writeInt : iArr) {
            this.codeOut.writeInt(writeInt);
        }
        if (this.hasPromoter != 0) {
            i2 = iArr2.length;
            while (i3 < i2) {
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(iArr2[i3]) - i);
                i3++;
            }
            return;
        }
        i2 = iArr2.length;
        while (i3 < i2) {
            this.codeOut.writeInt(iArr2[i3] - i);
            i3++;
        }
    }

    public final void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        i = this.codeOut.baseAddressForCursor();
        this.codeOut.write((short) i2);
        int i4 = 0;
        this.codeOut.write(InstructionCodec.asUnsignedUnit(iArr.length));
        this.codeOut.writeInt(i3);
        if (this.hasPromoter != 0) {
            i2 = iArr.length;
            while (i4 < i2) {
                this.codeOut.writeInt(this.insnPromoter.getPromotedAddress(iArr[i4]) - i);
                i4++;
            }
            return;
        }
        i2 = iArr.length;
        while (i4 < i2) {
            this.codeOut.writeInt(iArr[i4] - i);
            i4++;
        }
    }

    public final void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        this.codeOut.write((short) i2);
        this.codeOut.write((short) i4);
        this.codeOut.writeInt(i3);
        if (i4 == 4) {
            this.codeOut.write((int[]) obj);
        } else if (i4 != 8) {
            switch (i4) {
                case 1:
                    this.codeOut.write((byte[]) obj);
                    return;
                case 2:
                    this.codeOut.write((short[]) obj);
                    return;
                default:
                    i2 = new StringBuilder("bogus element_width: ");
                    i2.append(Hex.u2(i4));
                    throw new DexException(i2.toString());
            }
        } else {
            this.codeOut.write((long[]) obj);
        }
    }
}
