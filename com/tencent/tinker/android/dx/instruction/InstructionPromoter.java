package com.tencent.tinker.android.dx.instruction;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;
import com.tencent.tinker.android.utils.SparseIntArray;

/* compiled from: BUGLY */
public final class InstructionPromoter extends InstructionVisitor {
    private final SparseIntArray addressMap = new SparseIntArray();
    private int currentPromotedAddress = 0;

    public InstructionPromoter() {
        super(null);
    }

    private void mapAddressIfNeeded(int i) {
        if (i != this.currentPromotedAddress) {
            this.addressMap.append(i, this.currentPromotedAddress);
        }
    }

    public final int getPromotedAddress(int i) {
        int indexOfKey = this.addressMap.indexOfKey(i);
        if (indexOfKey < 0) {
            return i;
        }
        return this.addressMap.valueAt(indexOfKey);
    }

    public final int getPromotedAddressCount() {
        return this.addressMap.size();
    }

    public final void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        mapAddressIfNeeded(i);
        if (i2 != 14) {
            if (i2 != 36) {
                switch (i2) {
                    case -1:
                    case 0:
                        break;
                    default:
                        switch (i2) {
                            case 40:
                                i = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                                if (i == ((byte) i)) {
                                    this.currentPromotedAddress++;
                                    return;
                                } else if (i != ((short) i)) {
                                    this.currentPromotedAddress += 3;
                                    return;
                                } else {
                                    this.currentPromotedAddress += 2;
                                    return;
                                }
                            case 41:
                                i = InstructionCodec.getTarget(i5, this.currentPromotedAddress);
                                if (i != ((short) i)) {
                                    this.currentPromotedAddress += 3;
                                    return;
                                } else {
                                    this.currentPromotedAddress += 2;
                                    return;
                                }
                            case 42:
                                this.currentPromotedAddress += 3;
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
            this.currentPromotedAddress += 3;
            return;
        }
        this.currentPromotedAddress++;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitOneRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8) {
        /*
        r0 = this;
        r0.mapAddressIfNeeded(r1);
        r1 = 34;
        if (r2 == r1) goto L_0x0064;
    L_0x0007:
        r1 = 36;
        if (r2 == r1) goto L_0x005d;
    L_0x000b:
        switch(r2) {
            case 10: goto L_0x0056;
            case 11: goto L_0x0056;
            case 12: goto L_0x0056;
            case 13: goto L_0x0056;
            default: goto L_0x000e;
        };
    L_0x000e:
        switch(r2) {
            case 15: goto L_0x0056;
            case 16: goto L_0x0056;
            case 17: goto L_0x0056;
            case 18: goto L_0x0056;
            case 19: goto L_0x0064;
            case 20: goto L_0x005d;
            case 21: goto L_0x0064;
            case 22: goto L_0x0064;
            case 23: goto L_0x005d;
            case 24: goto L_0x004f;
            case 25: goto L_0x0064;
            case 26: goto L_0x003c;
            case 27: goto L_0x0035;
            case 28: goto L_0x0064;
            case 29: goto L_0x0056;
            case 30: goto L_0x0056;
            case 31: goto L_0x0064;
            default: goto L_0x0011;
        };
    L_0x0011:
        switch(r2) {
            case 38: goto L_0x005d;
            case 39: goto L_0x0056;
            default: goto L_0x0014;
        };
    L_0x0014:
        switch(r2) {
            case 43: goto L_0x005d;
            case 44: goto L_0x005d;
            default: goto L_0x0017;
        };
    L_0x0017:
        switch(r2) {
            case 56: goto L_0x0064;
            case 57: goto L_0x0064;
            case 58: goto L_0x0064;
            case 59: goto L_0x0064;
            case 60: goto L_0x0064;
            case 61: goto L_0x0064;
            default: goto L_0x001a;
        };
    L_0x001a:
        switch(r2) {
            case 96: goto L_0x0064;
            case 97: goto L_0x0064;
            case 98: goto L_0x0064;
            case 99: goto L_0x0064;
            case 100: goto L_0x0064;
            case 101: goto L_0x0064;
            case 102: goto L_0x0064;
            case 103: goto L_0x0064;
            case 104: goto L_0x0064;
            case 105: goto L_0x0064;
            case 106: goto L_0x0064;
            case 107: goto L_0x0064;
            case 108: goto L_0x0064;
            case 109: goto L_0x0064;
            case 110: goto L_0x005d;
            case 111: goto L_0x005d;
            case 112: goto L_0x005d;
            case 113: goto L_0x005d;
            case 114: goto L_0x005d;
            default: goto L_0x001d;
        };
    L_0x001d:
        r1 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "unexpected opcode: ";
        r3.<init>(r4);
        r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2);
        r3.append(r2);
        r2 = r3.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0035:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 3;
        r0.currentPromotedAddress = r1;
        return;
    L_0x003c:
        r1 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r3 <= r1) goto L_0x0048;
    L_0x0041:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 3;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0048:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 2;
        r0.currentPromotedAddress = r1;
        return;
    L_0x004f:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 5;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0056:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 1;
        r0.currentPromotedAddress = r1;
        return;
    L_0x005d:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 3;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0064:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 2;
        r0.currentPromotedAddress = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionPromoter.visitOneRegisterInsn(int, int, int, int, int, long, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitTwoRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9) {
        /*
        r0 = this;
        r0.mapAddressIfNeeded(r1);
        switch(r2) {
            case 1: goto L_0x0048;
            case 2: goto L_0x0041;
            case 3: goto L_0x003a;
            case 4: goto L_0x0048;
            case 5: goto L_0x0041;
            case 6: goto L_0x003a;
            case 7: goto L_0x0048;
            case 8: goto L_0x0041;
            case 9: goto L_0x003a;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r2) {
            case 32: goto L_0x0033;
            case 33: goto L_0x0048;
            default: goto L_0x0009;
        };
    L_0x0009:
        switch(r2) {
            case 35: goto L_0x0033;
            case 36: goto L_0x003a;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r2) {
            case 50: goto L_0x0033;
            case 51: goto L_0x0033;
            case 52: goto L_0x0033;
            case 53: goto L_0x0033;
            case 54: goto L_0x0033;
            case 55: goto L_0x0033;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r2) {
            case 82: goto L_0x0033;
            case 83: goto L_0x0033;
            case 84: goto L_0x0033;
            case 85: goto L_0x0033;
            case 86: goto L_0x0033;
            case 87: goto L_0x0033;
            case 88: goto L_0x0033;
            case 89: goto L_0x0033;
            case 90: goto L_0x0033;
            case 91: goto L_0x0033;
            case 92: goto L_0x0033;
            case 93: goto L_0x0033;
            case 94: goto L_0x0033;
            case 95: goto L_0x0033;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r2) {
            case 110: goto L_0x003a;
            case 111: goto L_0x003a;
            case 112: goto L_0x003a;
            case 113: goto L_0x003a;
            case 114: goto L_0x003a;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r2) {
            case 123: goto L_0x0048;
            case 124: goto L_0x0048;
            case 125: goto L_0x0048;
            case 126: goto L_0x0048;
            case 127: goto L_0x0048;
            case 128: goto L_0x0048;
            case 129: goto L_0x0048;
            case 130: goto L_0x0048;
            case 131: goto L_0x0048;
            case 132: goto L_0x0048;
            case 133: goto L_0x0048;
            case 134: goto L_0x0048;
            case 135: goto L_0x0048;
            case 136: goto L_0x0048;
            case 137: goto L_0x0048;
            case 138: goto L_0x0048;
            case 139: goto L_0x0048;
            case 140: goto L_0x0048;
            case 141: goto L_0x0048;
            case 142: goto L_0x0048;
            case 143: goto L_0x0048;
            default: goto L_0x0018;
        };
    L_0x0018:
        switch(r2) {
            case 176: goto L_0x0048;
            case 177: goto L_0x0048;
            case 178: goto L_0x0048;
            case 179: goto L_0x0048;
            case 180: goto L_0x0048;
            case 181: goto L_0x0048;
            case 182: goto L_0x0048;
            case 183: goto L_0x0048;
            case 184: goto L_0x0048;
            case 185: goto L_0x0048;
            case 186: goto L_0x0048;
            case 187: goto L_0x0048;
            case 188: goto L_0x0048;
            case 189: goto L_0x0048;
            case 190: goto L_0x0048;
            case 191: goto L_0x0048;
            case 192: goto L_0x0048;
            case 193: goto L_0x0048;
            case 194: goto L_0x0048;
            case 195: goto L_0x0048;
            case 196: goto L_0x0048;
            case 197: goto L_0x0048;
            case 198: goto L_0x0048;
            case 199: goto L_0x0048;
            case 200: goto L_0x0048;
            case 201: goto L_0x0048;
            case 202: goto L_0x0048;
            case 203: goto L_0x0048;
            case 204: goto L_0x0048;
            case 205: goto L_0x0048;
            case 206: goto L_0x0048;
            case 207: goto L_0x0048;
            case 208: goto L_0x0033;
            case 209: goto L_0x0033;
            case 210: goto L_0x0033;
            case 211: goto L_0x0033;
            case 212: goto L_0x0033;
            case 213: goto L_0x0033;
            case 214: goto L_0x0033;
            case 215: goto L_0x0033;
            case 216: goto L_0x0033;
            case 217: goto L_0x0033;
            case 218: goto L_0x0033;
            case 219: goto L_0x0033;
            case 220: goto L_0x0033;
            case 221: goto L_0x0033;
            case 222: goto L_0x0033;
            case 223: goto L_0x0033;
            case 224: goto L_0x0033;
            case 225: goto L_0x0033;
            case 226: goto L_0x0033;
            default: goto L_0x001b;
        };
    L_0x001b:
        r1 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "unexpected opcode: ";
        r3.<init>(r4);
        r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2);
        r3.append(r2);
        r2 = r3.toString();
        r1.<init>(r2);
        throw r1;
    L_0x0033:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 2;
        r0.currentPromotedAddress = r1;
        return;
    L_0x003a:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 3;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0041:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 2;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0048:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 1;
        r0.currentPromotedAddress = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionPromoter.visitTwoRegisterInsn(int, int, int, int, int, long, int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void visitThreeRegisterInsn(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9, int r10) {
        /*
        r0 = this;
        r0.mapAddressIfNeeded(r1);
        r1 = 36;
        if (r2 == r1) goto L_0x0032;
    L_0x0007:
        switch(r2) {
            case 45: goto L_0x002b;
            case 46: goto L_0x002b;
            case 47: goto L_0x002b;
            case 48: goto L_0x002b;
            case 49: goto L_0x002b;
            default: goto L_0x000a;
        };
    L_0x000a:
        switch(r2) {
            case 68: goto L_0x002b;
            case 69: goto L_0x002b;
            case 70: goto L_0x002b;
            case 71: goto L_0x002b;
            case 72: goto L_0x002b;
            case 73: goto L_0x002b;
            case 74: goto L_0x002b;
            case 75: goto L_0x002b;
            case 76: goto L_0x002b;
            case 77: goto L_0x002b;
            case 78: goto L_0x002b;
            case 79: goto L_0x002b;
            case 80: goto L_0x002b;
            case 81: goto L_0x002b;
            default: goto L_0x000d;
        };
    L_0x000d:
        switch(r2) {
            case 110: goto L_0x0032;
            case 111: goto L_0x0032;
            case 112: goto L_0x0032;
            case 113: goto L_0x0032;
            case 114: goto L_0x0032;
            default: goto L_0x0010;
        };
    L_0x0010:
        switch(r2) {
            case 144: goto L_0x002b;
            case 145: goto L_0x002b;
            case 146: goto L_0x002b;
            case 147: goto L_0x002b;
            case 148: goto L_0x002b;
            case 149: goto L_0x002b;
            case 150: goto L_0x002b;
            case 151: goto L_0x002b;
            case 152: goto L_0x002b;
            case 153: goto L_0x002b;
            case 154: goto L_0x002b;
            case 155: goto L_0x002b;
            case 156: goto L_0x002b;
            case 157: goto L_0x002b;
            case 158: goto L_0x002b;
            case 159: goto L_0x002b;
            case 160: goto L_0x002b;
            case 161: goto L_0x002b;
            case 162: goto L_0x002b;
            case 163: goto L_0x002b;
            case 164: goto L_0x002b;
            case 165: goto L_0x002b;
            case 166: goto L_0x002b;
            case 167: goto L_0x002b;
            case 168: goto L_0x002b;
            case 169: goto L_0x002b;
            case 170: goto L_0x002b;
            case 171: goto L_0x002b;
            case 172: goto L_0x002b;
            case 173: goto L_0x002b;
            case 174: goto L_0x002b;
            case 175: goto L_0x002b;
            default: goto L_0x0013;
        };
    L_0x0013:
        r1 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "unexpected opcode: ";
        r3.<init>(r4);
        r2 = com.tencent.tinker.android.dx.util.Hex.u2or4(r2);
        r3.append(r2);
        r2 = r3.toString();
        r1.<init>(r2);
        throw r1;
    L_0x002b:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 2;
        r0.currentPromotedAddress = r1;
        return;
    L_0x0032:
        r1 = r0.currentPromotedAddress;
        r1 = r1 + 3;
        r0.currentPromotedAddress = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionPromoter.visitThreeRegisterInsn(int, int, int, int, int, long, int, int, int):void");
    }

    public final void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        mapAddressIfNeeded(i);
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
        this.currentPromotedAddress += 3;
    }

    public final void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        mapAddressIfNeeded(i);
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
        this.currentPromotedAddress += 3;
    }

    public final void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        mapAddressIfNeeded(i);
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
        this.currentPromotedAddress += 3;
    }

    public final void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        mapAddressIfNeeded(i);
        this.currentPromotedAddress += 2;
        this.currentPromotedAddress += iArr.length * 2;
        this.currentPromotedAddress += iArr2.length * 2;
    }

    public final void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        mapAddressIfNeeded(i);
        this.currentPromotedAddress += 4;
        this.currentPromotedAddress += iArr.length * 2;
    }

    public final void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        mapAddressIfNeeded(i);
        this.currentPromotedAddress += 4;
        if (i4 == 4) {
            this.currentPromotedAddress += ((int[]) obj).length * 2;
        } else if (i4 != 8) {
            switch (i4) {
                case 1:
                    i = ((byte[]) obj).length;
                    this.currentPromotedAddress += (i >> 1) + (i & 1);
                    return;
                case 2:
                    this.currentPromotedAddress += ((short[]) obj).length * 1;
                    return;
                default:
                    i2 = new StringBuilder("bogus element_width: ");
                    i2.append(Hex.u2(i4));
                    throw new DexException(i2.toString());
            }
        } else {
            this.currentPromotedAddress += ((long[]) obj).length * 4;
        }
    }
}
