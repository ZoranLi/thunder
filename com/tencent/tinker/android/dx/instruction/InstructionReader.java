package com.tencent.tinker.android.dx.instruction;

/* compiled from: BUGLY */
public final class InstructionReader {
    private final ShortArrayCodeInput codeIn;

    public InstructionReader(ShortArrayCodeInput shortArrayCodeInput) {
        this.codeIn = shortArrayCodeInput;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(com.tencent.tinker.android.dx.instruction.InstructionVisitor r15) throws java.io.EOFException {
        /*
        r14 = this;
        r0 = r14.codeIn;
        r0.reset();
    L_0x0005:
        r0 = r14.codeIn;
        r0 = r0.hasMore();
        if (r0 == 0) goto L_0x0455;
    L_0x000d:
        r0 = r14.codeIn;
        r2 = r0.cursor();
        r0 = r14.codeIn;
        r3 = r0.read();
        r0 = com.tencent.tinker.android.dx.instruction.Opcodes.extractOpcodeFromUnit(r3);
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r4 = 0;
        if (r0 == r1) goto L_0x042e;
    L_0x0022:
        r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 == r1) goto L_0x03fd;
    L_0x0026:
        r1 = 768; // 0x300 float:1.076E-42 double:3.794E-321;
        if (r0 == r1) goto L_0x0367;
    L_0x002a:
        switch(r0) {
            case -1: goto L_0x035c;
            case 0: goto L_0x0349;
            case 1: goto L_0x0331;
            case 2: goto L_0x0317;
            case 3: goto L_0x02f8;
            case 4: goto L_0x0331;
            case 5: goto L_0x0317;
            case 6: goto L_0x02f8;
            case 7: goto L_0x0331;
            case 8: goto L_0x0317;
            case 9: goto L_0x02f8;
            case 10: goto L_0x02e4;
            case 11: goto L_0x02e4;
            case 12: goto L_0x02e4;
            case 13: goto L_0x02e4;
            case 14: goto L_0x0349;
            case 15: goto L_0x02e4;
            case 16: goto L_0x02e4;
            case 17: goto L_0x02e4;
            case 18: goto L_0x02c9;
            case 19: goto L_0x02af;
            case 20: goto L_0x0296;
            case 21: goto L_0x0271;
            case 22: goto L_0x02af;
            case 23: goto L_0x0296;
            case 24: goto L_0x0259;
            case 25: goto L_0x0271;
            case 26: goto L_0x023d;
            case 27: goto L_0x0221;
            case 28: goto L_0x023d;
            case 29: goto L_0x02e4;
            case 30: goto L_0x02e4;
            case 31: goto L_0x023d;
            case 32: goto L_0x0201;
            case 33: goto L_0x0331;
            case 34: goto L_0x023d;
            case 35: goto L_0x0201;
            case 36: goto L_0x017e;
            case 37: goto L_0x015c;
            case 38: goto L_0x0136;
            case 39: goto L_0x02e4;
            case 40: goto L_0x0120;
            case 41: goto L_0x0105;
            case 42: goto L_0x00eb;
            case 43: goto L_0x0136;
            case 44: goto L_0x0136;
            case 45: goto L_0x00c9;
            case 46: goto L_0x00c9;
            case 47: goto L_0x00c9;
            case 48: goto L_0x00c9;
            case 49: goto L_0x00c9;
            case 50: goto L_0x00a9;
            case 51: goto L_0x00a9;
            case 52: goto L_0x00a9;
            case 53: goto L_0x00a9;
            case 54: goto L_0x00a9;
            case 55: goto L_0x00a9;
            case 56: goto L_0x008d;
            case 57: goto L_0x008d;
            case 58: goto L_0x008d;
            case 59: goto L_0x008d;
            case 60: goto L_0x008d;
            case 61: goto L_0x008d;
            default: goto L_0x002d;
        };
    L_0x002d:
        switch(r0) {
            case 68: goto L_0x00c9;
            case 69: goto L_0x00c9;
            case 70: goto L_0x00c9;
            case 71: goto L_0x00c9;
            case 72: goto L_0x00c9;
            case 73: goto L_0x00c9;
            case 74: goto L_0x00c9;
            case 75: goto L_0x00c9;
            case 76: goto L_0x00c9;
            case 77: goto L_0x00c9;
            case 78: goto L_0x00c9;
            case 79: goto L_0x00c9;
            case 80: goto L_0x00c9;
            case 81: goto L_0x00c9;
            case 82: goto L_0x0201;
            case 83: goto L_0x0201;
            case 84: goto L_0x0201;
            case 85: goto L_0x0201;
            case 86: goto L_0x0201;
            case 87: goto L_0x0201;
            case 88: goto L_0x0201;
            case 89: goto L_0x0201;
            case 90: goto L_0x0201;
            case 91: goto L_0x0201;
            case 92: goto L_0x0201;
            case 93: goto L_0x0201;
            case 94: goto L_0x0201;
            case 95: goto L_0x0201;
            case 96: goto L_0x023d;
            case 97: goto L_0x023d;
            case 98: goto L_0x023d;
            case 99: goto L_0x023d;
            case 100: goto L_0x023d;
            case 101: goto L_0x023d;
            case 102: goto L_0x023d;
            case 103: goto L_0x023d;
            case 104: goto L_0x023d;
            case 105: goto L_0x023d;
            case 106: goto L_0x023d;
            case 107: goto L_0x023d;
            case 108: goto L_0x023d;
            case 109: goto L_0x023d;
            case 110: goto L_0x017e;
            case 111: goto L_0x017e;
            case 112: goto L_0x017e;
            case 113: goto L_0x017e;
            case 114: goto L_0x017e;
            default: goto L_0x0030;
        };
    L_0x0030:
        switch(r0) {
            case 116: goto L_0x015c;
            case 117: goto L_0x015c;
            case 118: goto L_0x015c;
            case 119: goto L_0x015c;
            case 120: goto L_0x015c;
            default: goto L_0x0033;
        };
    L_0x0033:
        switch(r0) {
            case 123: goto L_0x0331;
            case 124: goto L_0x0331;
            case 125: goto L_0x0331;
            case 126: goto L_0x0331;
            case 127: goto L_0x0331;
            case 128: goto L_0x0331;
            case 129: goto L_0x0331;
            case 130: goto L_0x0331;
            case 131: goto L_0x0331;
            case 132: goto L_0x0331;
            case 133: goto L_0x0331;
            case 134: goto L_0x0331;
            case 135: goto L_0x0331;
            case 136: goto L_0x0331;
            case 137: goto L_0x0331;
            case 138: goto L_0x0331;
            case 139: goto L_0x0331;
            case 140: goto L_0x0331;
            case 141: goto L_0x0331;
            case 142: goto L_0x0331;
            case 143: goto L_0x0331;
            case 144: goto L_0x00c9;
            case 145: goto L_0x00c9;
            case 146: goto L_0x00c9;
            case 147: goto L_0x00c9;
            case 148: goto L_0x00c9;
            case 149: goto L_0x00c9;
            case 150: goto L_0x00c9;
            case 151: goto L_0x00c9;
            case 152: goto L_0x00c9;
            case 153: goto L_0x00c9;
            case 154: goto L_0x00c9;
            case 155: goto L_0x00c9;
            case 156: goto L_0x00c9;
            case 157: goto L_0x00c9;
            case 158: goto L_0x00c9;
            case 159: goto L_0x00c9;
            case 160: goto L_0x00c9;
            case 161: goto L_0x00c9;
            case 162: goto L_0x00c9;
            case 163: goto L_0x00c9;
            case 164: goto L_0x00c9;
            case 165: goto L_0x00c9;
            case 166: goto L_0x00c9;
            case 167: goto L_0x00c9;
            case 168: goto L_0x00c9;
            case 169: goto L_0x00c9;
            case 170: goto L_0x00c9;
            case 171: goto L_0x00c9;
            case 172: goto L_0x00c9;
            case 173: goto L_0x00c9;
            case 174: goto L_0x00c9;
            case 175: goto L_0x00c9;
            case 176: goto L_0x0331;
            case 177: goto L_0x0331;
            case 178: goto L_0x0331;
            case 179: goto L_0x0331;
            case 180: goto L_0x0331;
            case 181: goto L_0x0331;
            case 182: goto L_0x0331;
            case 183: goto L_0x0331;
            case 184: goto L_0x0331;
            case 185: goto L_0x0331;
            case 186: goto L_0x0331;
            case 187: goto L_0x0331;
            case 188: goto L_0x0331;
            case 189: goto L_0x0331;
            case 190: goto L_0x0331;
            case 191: goto L_0x0331;
            case 192: goto L_0x0331;
            case 193: goto L_0x0331;
            case 194: goto L_0x0331;
            case 195: goto L_0x0331;
            case 196: goto L_0x0331;
            case 197: goto L_0x0331;
            case 198: goto L_0x0331;
            case 199: goto L_0x0331;
            case 200: goto L_0x0331;
            case 201: goto L_0x0331;
            case 202: goto L_0x0331;
            case 203: goto L_0x0331;
            case 204: goto L_0x0331;
            case 205: goto L_0x0331;
            case 206: goto L_0x0331;
            case 207: goto L_0x0331;
            case 208: goto L_0x006f;
            case 209: goto L_0x006f;
            case 210: goto L_0x006f;
            case 211: goto L_0x006f;
            case 212: goto L_0x006f;
            case 213: goto L_0x006f;
            case 214: goto L_0x006f;
            case 215: goto L_0x006f;
            case 216: goto L_0x004e;
            case 217: goto L_0x004e;
            case 218: goto L_0x004e;
            case 219: goto L_0x004e;
            case 220: goto L_0x004e;
            case 221: goto L_0x004e;
            case 222: goto L_0x004e;
            case 223: goto L_0x004e;
            case 224: goto L_0x004e;
            case 225: goto L_0x004e;
            case 226: goto L_0x004e;
            default: goto L_0x0036;
        };
    L_0x0036:
        r15 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unknown opcode: ";
        r1.<init>(r2);
        r0 = com.tencent.tinker.android.dx.util.Hex.u4(r0);
        r1.append(r0);
        r0 = r1.toString();
        r15.<init>(r0);
        throw r15;
    L_0x004e:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r1);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r1);
        r1 = (byte) r1;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x006f:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x008d:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r4 = 0;
        r5 = 1;
        r6 = r2 + r1;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x00a9:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r4 = 0;
        r5 = 1;
        r6 = r2 + r1;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x00c9:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r1);
        r11 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r1);
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitThreeRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10, r11);
        goto L_0x0005;
    L_0x00eb:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r3 = r14.codeIn;
        r3 = r3.readInt();
        r4 = 0;
        r5 = 1;
        r6 = r2 + r3;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x0105:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r3 = r14.codeIn;
        r3 = r3.read();
        r3 = (short) r3;
        r4 = 0;
        r5 = 1;
        r6 = r2 + r3;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x0120:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = (byte) r1;
        r4 = 0;
        r5 = 1;
        r6 = r2 + r1;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x0136:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.readInt();
        r6 = r2 + r1;
        switch(r0) {
            case 43: goto L_0x014a;
            case 44: goto L_0x014a;
            default: goto L_0x0149;
        };
    L_0x0149:
        goto L_0x0151;
    L_0x014a:
        r1 = r14.codeIn;
        r3 = r6 + 1;
        r1.setBaseAddress(r3, r2);
    L_0x0151:
        r4 = 0;
        r5 = 1;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x015c:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r4 = r1.read();
        r1 = r14.codeIn;
        r9 = r1.read();
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(r0);
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitRegisterRangeInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x017e:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r13 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r3 = r14.codeIn;
        r4 = r3.read();
        r3 = r14.codeIn;
        r3 = r3.read();
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble0(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble1(r3);
        r11 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r12 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(r0);
        switch(r1) {
            case 0: goto L_0x01f7;
            case 1: goto L_0x01ed;
            case 2: goto L_0x01e3;
            case 3: goto L_0x01d9;
            case 4: goto L_0x01cf;
            case 5: goto L_0x01c5;
            default: goto L_0x01ad;
        };
    L_0x01ad:
        r15 = new com.tencent.tinker.android.dex.DexException;
        r0 = new java.lang.StringBuilder;
        r2 = "bogus registerCount: ";
        r0.<init>(r2);
        r1 = com.tencent.tinker.android.dx.util.Hex.uNibble(r1);
        r0.append(r1);
        r0 = r0.toString();
        r15.<init>(r0);
        throw r15;
    L_0x01c5:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitFiveRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13);
        goto L_0x0005;
    L_0x01cf:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitFourRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12);
        goto L_0x0005;
    L_0x01d9:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitThreeRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10, r11);
        goto L_0x0005;
    L_0x01e3:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x01ed:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x01f7:
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x0201:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r1 = r14.codeIn;
        r4 = r1.read();
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(r0);
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x0221:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r4 = r1.readInt();
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(r0);
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x023d:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r4 = r1.read();
        r5 = com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(r0);
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x0259:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r7 = r1.readLong();
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x0271:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r3 = (long) r1;
        r1 = 21;
        if (r0 != r1) goto L_0x0288;
    L_0x0285:
        r1 = 16;
        goto L_0x028a;
    L_0x0288:
        r1 = 48;
    L_0x028a:
        r7 = r3 << r1;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x0296:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.readInt();
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x02af:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x02c9:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r1 = r1 << 28;
        r1 = r1 >> 28;
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x02e4:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitOneRegisterInsn(r2, r3, r4, r5, r6, r7, r9);
        goto L_0x0005;
    L_0x02f8:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r3 = r14.codeIn;
        r9 = r3.read();
        r3 = r14.codeIn;
        r10 = r3.read();
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x0317:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r1 = r14.codeIn;
        r10 = r1.read();
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x0331:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r9 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble2(r3);
        r10 = com.tencent.tinker.android.dx.instruction.InstructionCodec.nibble3(r3);
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r3 = r0;
        r1.visitTwoRegisterInsn(r2, r3, r4, r5, r6, r7, r9, r10);
        goto L_0x0005;
    L_0x0349:
        r0 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte0(r3);
        r1 = com.tencent.tinker.android.dx.instruction.InstructionCodec.byte1(r3);
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = (long) r1;
        r1 = r15;
        r3 = r0;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x035c:
        r4 = 0;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = r15;
        r1.visitZeroRegisterInsn(r2, r3, r4, r5, r6, r7);
        goto L_0x0005;
    L_0x0367:
        r0 = r14.codeIn;
        r0 = r0.read();
        r1 = r14.codeIn;
        r5 = r1.readInt();
        r1 = 4;
        if (r0 == r1) goto L_0x03e6;
    L_0x0376:
        r1 = 8;
        if (r0 == r1) goto L_0x03ce;
    L_0x037a:
        switch(r0) {
            case 1: goto L_0x03ad;
            case 2: goto L_0x0395;
            default: goto L_0x037d;
        };
    L_0x037d:
        r15 = new com.tencent.tinker.android.dex.DexException;
        r1 = new java.lang.StringBuilder;
        r2 = "bogus element_width: ";
        r1.<init>(r2);
        r0 = com.tencent.tinker.android.dx.util.Hex.u2(r0);
        r1.append(r0);
        r0 = r1.toString();
        r15.<init>(r0);
        throw r15;
    L_0x0395:
        r0 = new short[r5];
    L_0x0397:
        if (r4 >= r5) goto L_0x03a5;
    L_0x0399:
        r1 = r14.codeIn;
        r1 = r1.read();
        r1 = (short) r1;
        r0[r4] = r1;
        r4 = r4 + 1;
        goto L_0x0397;
    L_0x03a5:
        r6 = 2;
        r1 = r15;
        r4 = r0;
        r1.visitFillArrayDataPayloadInsn(r2, r3, r4, r5, r6);
        goto L_0x0005;
    L_0x03ad:
        r0 = new byte[r5];
        r6 = 1;
        r7 = r4;
    L_0x03b1:
        if (r4 >= r5) goto L_0x03c6;
    L_0x03b3:
        if (r6 == 0) goto L_0x03bb;
    L_0x03b5:
        r7 = r14.codeIn;
        r7 = r7.read();
    L_0x03bb:
        r8 = r7 & 255;
        r8 = (byte) r8;
        r0[r4] = r8;
        r7 = r7 >> r1;
        r4 = r4 + 1;
        r6 = r6 ^ 1;
        goto L_0x03b1;
    L_0x03c6:
        r6 = 1;
        r1 = r15;
        r4 = r0;
        r1.visitFillArrayDataPayloadInsn(r2, r3, r4, r5, r6);
        goto L_0x0005;
    L_0x03ce:
        r0 = new long[r5];
    L_0x03d0:
        if (r4 >= r5) goto L_0x03dd;
    L_0x03d2:
        r1 = r14.codeIn;
        r6 = r1.readLong();
        r0[r4] = r6;
        r4 = r4 + 1;
        goto L_0x03d0;
    L_0x03dd:
        r6 = 8;
        r1 = r15;
        r4 = r0;
        r1.visitFillArrayDataPayloadInsn(r2, r3, r4, r5, r6);
        goto L_0x0005;
    L_0x03e6:
        r0 = new int[r5];
    L_0x03e8:
        if (r4 >= r5) goto L_0x03f5;
    L_0x03ea:
        r1 = r14.codeIn;
        r1 = r1.readInt();
        r0[r4] = r1;
        r4 = r4 + 1;
        goto L_0x03e8;
    L_0x03f5:
        r6 = 4;
        r1 = r15;
        r4 = r0;
        r1.visitFillArrayDataPayloadInsn(r2, r3, r4, r5, r6);
        goto L_0x0005;
    L_0x03fd:
        r0 = r14.codeIn;
        r0 = r0.baseAddressForCursor();
        r1 = r14.codeIn;
        r1 = r1.read();
        r5 = new int[r1];
        r6 = new int[r1];
        r7 = r4;
    L_0x040e:
        if (r7 >= r1) goto L_0x041b;
    L_0x0410:
        r8 = r14.codeIn;
        r8 = r8.readInt();
        r5[r7] = r8;
        r7 = r7 + 1;
        goto L_0x040e;
    L_0x041b:
        if (r4 >= r1) goto L_0x0429;
    L_0x041d:
        r7 = r14.codeIn;
        r7 = r7.readInt();
        r7 = r7 + r0;
        r6[r4] = r7;
        r4 = r4 + 1;
        goto L_0x041b;
    L_0x0429:
        r15.visitSparseSwitchPayloadInsn(r2, r3, r5, r6);
        goto L_0x0005;
    L_0x042e:
        r0 = r14.codeIn;
        r0 = r0.baseAddressForCursor();
        r1 = r14.codeIn;
        r1 = r1.read();
        r5 = r14.codeIn;
        r5 = r5.readInt();
        r6 = new int[r1];
    L_0x0442:
        if (r4 >= r1) goto L_0x0450;
    L_0x0444:
        r7 = r14.codeIn;
        r7 = r7.readInt();
        r7 = r7 + r0;
        r6[r4] = r7;
        r4 = r4 + 1;
        goto L_0x0442;
    L_0x0450:
        r15.visitPackedSwitchPayloadInsn(r2, r3, r5, r6);
        goto L_0x0005;
    L_0x0455:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionReader.accept(com.tencent.tinker.android.dx.instruction.InstructionVisitor):void");
    }
}
