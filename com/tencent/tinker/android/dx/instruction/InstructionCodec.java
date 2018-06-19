package com.tencent.tinker.android.dx.instruction;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.util.Hex;

/* compiled from: BUGLY */
public final class InstructionCodec {
    public static final int INDEX_TYPE_FIELD_REF = 5;
    public static final int INDEX_TYPE_METHOD_REF = 4;
    public static final int INDEX_TYPE_NONE = 1;
    public static final int INDEX_TYPE_STRING_REF = 3;
    public static final int INDEX_TYPE_TYPE_REF = 2;
    public static final int INDEX_TYPE_UNKNOWN = 0;
    public static final int INSN_FORMAT_00X = 1;
    public static final int INSN_FORMAT_10T = 2;
    public static final int INSN_FORMAT_10X = 3;
    public static final int INSN_FORMAT_11N = 4;
    public static final int INSN_FORMAT_11X = 5;
    public static final int INSN_FORMAT_12X = 6;
    public static final int INSN_FORMAT_20T = 7;
    public static final int INSN_FORMAT_21C = 8;
    public static final int INSN_FORMAT_21H = 9;
    public static final int INSN_FORMAT_21S = 10;
    public static final int INSN_FORMAT_21T = 11;
    public static final int INSN_FORMAT_22B = 12;
    public static final int INSN_FORMAT_22C = 13;
    public static final int INSN_FORMAT_22S = 14;
    public static final int INSN_FORMAT_22T = 15;
    public static final int INSN_FORMAT_22X = 16;
    public static final int INSN_FORMAT_23X = 17;
    public static final int INSN_FORMAT_30T = 18;
    public static final int INSN_FORMAT_31C = 19;
    public static final int INSN_FORMAT_31I = 20;
    public static final int INSN_FORMAT_31T = 21;
    public static final int INSN_FORMAT_32X = 22;
    public static final int INSN_FORMAT_35C = 23;
    public static final int INSN_FORMAT_3RC = 24;
    public static final int INSN_FORMAT_51L = 25;
    public static final int INSN_FORMAT_FILL_ARRAY_DATA_PAYLOAD = 26;
    public static final int INSN_FORMAT_PACKED_SWITCH_PAYLOAD = 27;
    public static final int INSN_FORMAT_SPARSE_SWITCH_PAYLOAD = 28;
    public static final int INSN_FORMAT_UNKNOWN = 0;

    public static int byte0(int i) {
        return i & 255;
    }

    public static int byte1(int i) {
        return (i >> 8) & 255;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getInstructionFormat(int r1) {
        /*
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r1 == r0) goto L_0x0064;
    L_0x0004:
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r1 == r0) goto L_0x0061;
    L_0x0008:
        r0 = 768; // 0x300 float:1.076E-42 double:3.794E-321;
        if (r1 == r0) goto L_0x005e;
    L_0x000c:
        switch(r1) {
            case -1: goto L_0x005c;
            case 0: goto L_0x005a;
            case 1: goto L_0x0058;
            case 2: goto L_0x0055;
            case 3: goto L_0x0052;
            case 4: goto L_0x0058;
            case 5: goto L_0x0055;
            case 6: goto L_0x0052;
            case 7: goto L_0x0058;
            case 8: goto L_0x0055;
            case 9: goto L_0x0052;
            case 10: goto L_0x0050;
            case 11: goto L_0x0050;
            case 12: goto L_0x0050;
            case 13: goto L_0x0050;
            case 14: goto L_0x005a;
            case 15: goto L_0x0050;
            case 16: goto L_0x0050;
            case 17: goto L_0x0050;
            case 18: goto L_0x004e;
            case 19: goto L_0x004b;
            case 20: goto L_0x0048;
            case 21: goto L_0x0045;
            case 22: goto L_0x004b;
            case 23: goto L_0x0048;
            case 24: goto L_0x0042;
            case 25: goto L_0x0045;
            case 26: goto L_0x003f;
            case 27: goto L_0x003c;
            case 28: goto L_0x003f;
            case 29: goto L_0x0050;
            case 30: goto L_0x0050;
            case 31: goto L_0x003f;
            case 32: goto L_0x0039;
            case 33: goto L_0x0058;
            case 34: goto L_0x003f;
            case 35: goto L_0x0039;
            case 36: goto L_0x0036;
            case 37: goto L_0x0033;
            case 38: goto L_0x0030;
            case 39: goto L_0x0050;
            case 40: goto L_0x002e;
            case 41: goto L_0x002c;
            case 42: goto L_0x0029;
            case 43: goto L_0x0030;
            case 44: goto L_0x0030;
            case 45: goto L_0x0026;
            case 46: goto L_0x0026;
            case 47: goto L_0x0026;
            case 48: goto L_0x0026;
            case 49: goto L_0x0026;
            case 50: goto L_0x0023;
            case 51: goto L_0x0023;
            case 52: goto L_0x0023;
            case 53: goto L_0x0023;
            case 54: goto L_0x0023;
            case 55: goto L_0x0023;
            case 56: goto L_0x0020;
            case 57: goto L_0x0020;
            case 58: goto L_0x0020;
            case 59: goto L_0x0020;
            case 60: goto L_0x0020;
            case 61: goto L_0x0020;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r1) {
            case 68: goto L_0x0026;
            case 69: goto L_0x0026;
            case 70: goto L_0x0026;
            case 71: goto L_0x0026;
            case 72: goto L_0x0026;
            case 73: goto L_0x0026;
            case 74: goto L_0x0026;
            case 75: goto L_0x0026;
            case 76: goto L_0x0026;
            case 77: goto L_0x0026;
            case 78: goto L_0x0026;
            case 79: goto L_0x0026;
            case 80: goto L_0x0026;
            case 81: goto L_0x0026;
            case 82: goto L_0x0039;
            case 83: goto L_0x0039;
            case 84: goto L_0x0039;
            case 85: goto L_0x0039;
            case 86: goto L_0x0039;
            case 87: goto L_0x0039;
            case 88: goto L_0x0039;
            case 89: goto L_0x0039;
            case 90: goto L_0x0039;
            case 91: goto L_0x0039;
            case 92: goto L_0x0039;
            case 93: goto L_0x0039;
            case 94: goto L_0x0039;
            case 95: goto L_0x0039;
            case 96: goto L_0x003f;
            case 97: goto L_0x003f;
            case 98: goto L_0x003f;
            case 99: goto L_0x003f;
            case 100: goto L_0x003f;
            case 101: goto L_0x003f;
            case 102: goto L_0x003f;
            case 103: goto L_0x003f;
            case 104: goto L_0x003f;
            case 105: goto L_0x003f;
            case 106: goto L_0x003f;
            case 107: goto L_0x003f;
            case 108: goto L_0x003f;
            case 109: goto L_0x003f;
            case 110: goto L_0x0036;
            case 111: goto L_0x0036;
            case 112: goto L_0x0036;
            case 113: goto L_0x0036;
            case 114: goto L_0x0036;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r1) {
            case 116: goto L_0x0033;
            case 117: goto L_0x0033;
            case 118: goto L_0x0033;
            case 119: goto L_0x0033;
            case 120: goto L_0x0033;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r1) {
            case 123: goto L_0x0058;
            case 124: goto L_0x0058;
            case 125: goto L_0x0058;
            case 126: goto L_0x0058;
            case 127: goto L_0x0058;
            case 128: goto L_0x0058;
            case 129: goto L_0x0058;
            case 130: goto L_0x0058;
            case 131: goto L_0x0058;
            case 132: goto L_0x0058;
            case 133: goto L_0x0058;
            case 134: goto L_0x0058;
            case 135: goto L_0x0058;
            case 136: goto L_0x0058;
            case 137: goto L_0x0058;
            case 138: goto L_0x0058;
            case 139: goto L_0x0058;
            case 140: goto L_0x0058;
            case 141: goto L_0x0058;
            case 142: goto L_0x0058;
            case 143: goto L_0x0058;
            case 144: goto L_0x0026;
            case 145: goto L_0x0026;
            case 146: goto L_0x0026;
            case 147: goto L_0x0026;
            case 148: goto L_0x0026;
            case 149: goto L_0x0026;
            case 150: goto L_0x0026;
            case 151: goto L_0x0026;
            case 152: goto L_0x0026;
            case 153: goto L_0x0026;
            case 154: goto L_0x0026;
            case 155: goto L_0x0026;
            case 156: goto L_0x0026;
            case 157: goto L_0x0026;
            case 158: goto L_0x0026;
            case 159: goto L_0x0026;
            case 160: goto L_0x0026;
            case 161: goto L_0x0026;
            case 162: goto L_0x0026;
            case 163: goto L_0x0026;
            case 164: goto L_0x0026;
            case 165: goto L_0x0026;
            case 166: goto L_0x0026;
            case 167: goto L_0x0026;
            case 168: goto L_0x0026;
            case 169: goto L_0x0026;
            case 170: goto L_0x0026;
            case 171: goto L_0x0026;
            case 172: goto L_0x0026;
            case 173: goto L_0x0026;
            case 174: goto L_0x0026;
            case 175: goto L_0x0026;
            case 176: goto L_0x0058;
            case 177: goto L_0x0058;
            case 178: goto L_0x0058;
            case 179: goto L_0x0058;
            case 180: goto L_0x0058;
            case 181: goto L_0x0058;
            case 182: goto L_0x0058;
            case 183: goto L_0x0058;
            case 184: goto L_0x0058;
            case 185: goto L_0x0058;
            case 186: goto L_0x0058;
            case 187: goto L_0x0058;
            case 188: goto L_0x0058;
            case 189: goto L_0x0058;
            case 190: goto L_0x0058;
            case 191: goto L_0x0058;
            case 192: goto L_0x0058;
            case 193: goto L_0x0058;
            case 194: goto L_0x0058;
            case 195: goto L_0x0058;
            case 196: goto L_0x0058;
            case 197: goto L_0x0058;
            case 198: goto L_0x0058;
            case 199: goto L_0x0058;
            case 200: goto L_0x0058;
            case 201: goto L_0x0058;
            case 202: goto L_0x0058;
            case 203: goto L_0x0058;
            case 204: goto L_0x0058;
            case 205: goto L_0x0058;
            case 206: goto L_0x0058;
            case 207: goto L_0x0058;
            case 208: goto L_0x001d;
            case 209: goto L_0x001d;
            case 210: goto L_0x001d;
            case 211: goto L_0x001d;
            case 212: goto L_0x001d;
            case 213: goto L_0x001d;
            case 214: goto L_0x001d;
            case 215: goto L_0x001d;
            case 216: goto L_0x001a;
            case 217: goto L_0x001a;
            case 218: goto L_0x001a;
            case 219: goto L_0x001a;
            case 220: goto L_0x001a;
            case 221: goto L_0x001a;
            case 222: goto L_0x001a;
            case 223: goto L_0x001a;
            case 224: goto L_0x001a;
            case 225: goto L_0x001a;
            case 226: goto L_0x001a;
            default: goto L_0x0018;
        };
    L_0x0018:
        r1 = 0;
        return r1;
    L_0x001a:
        r1 = 12;
        return r1;
    L_0x001d:
        r1 = 14;
        return r1;
    L_0x0020:
        r1 = 11;
        return r1;
    L_0x0023:
        r1 = 15;
        return r1;
    L_0x0026:
        r1 = 17;
        return r1;
    L_0x0029:
        r1 = 18;
        return r1;
    L_0x002c:
        r1 = 7;
        return r1;
    L_0x002e:
        r1 = 2;
        return r1;
    L_0x0030:
        r1 = 21;
        return r1;
    L_0x0033:
        r1 = 24;
        return r1;
    L_0x0036:
        r1 = 23;
        return r1;
    L_0x0039:
        r1 = 13;
        return r1;
    L_0x003c:
        r1 = 19;
        return r1;
    L_0x003f:
        r1 = 8;
        return r1;
    L_0x0042:
        r1 = 25;
        return r1;
    L_0x0045:
        r1 = 9;
        return r1;
    L_0x0048:
        r1 = 20;
        return r1;
    L_0x004b:
        r1 = 10;
        return r1;
    L_0x004e:
        r1 = 4;
        return r1;
    L_0x0050:
        r1 = 5;
        return r1;
    L_0x0052:
        r1 = 22;
        return r1;
    L_0x0055:
        r1 = 16;
        return r1;
    L_0x0058:
        r1 = 6;
        return r1;
    L_0x005a:
        r1 = 3;
        return r1;
    L_0x005c:
        r1 = 1;
        return r1;
    L_0x005e:
        r1 = 26;
        return r1;
    L_0x0061:
        r1 = 28;
        return r1;
    L_0x0064:
        r1 = 27;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionFormat(int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getInstructionIndexType(int r1) {
        /*
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r1 == r0) goto L_0x0022;
    L_0x0004:
        r0 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r1 == r0) goto L_0x0022;
    L_0x0008:
        r0 = 768; // 0x300 float:1.076E-42 double:3.794E-321;
        if (r1 == r0) goto L_0x0022;
    L_0x000c:
        switch(r1) {
            case -1: goto L_0x0022;
            case 0: goto L_0x0022;
            case 1: goto L_0x0022;
            case 2: goto L_0x0022;
            case 3: goto L_0x0022;
            case 4: goto L_0x0022;
            case 5: goto L_0x0022;
            case 6: goto L_0x0022;
            case 7: goto L_0x0022;
            case 8: goto L_0x0022;
            case 9: goto L_0x0022;
            case 10: goto L_0x0022;
            case 11: goto L_0x0022;
            case 12: goto L_0x0022;
            case 13: goto L_0x0022;
            case 14: goto L_0x0022;
            case 15: goto L_0x0022;
            case 16: goto L_0x0022;
            case 17: goto L_0x0022;
            case 18: goto L_0x0022;
            case 19: goto L_0x0022;
            case 20: goto L_0x0022;
            case 21: goto L_0x0022;
            case 22: goto L_0x0022;
            case 23: goto L_0x0022;
            case 24: goto L_0x0022;
            case 25: goto L_0x0022;
            case 26: goto L_0x0020;
            case 27: goto L_0x0020;
            case 28: goto L_0x001e;
            case 29: goto L_0x0022;
            case 30: goto L_0x0022;
            case 31: goto L_0x001e;
            case 32: goto L_0x001e;
            case 33: goto L_0x0022;
            case 34: goto L_0x001e;
            case 35: goto L_0x001e;
            case 36: goto L_0x001e;
            case 37: goto L_0x001e;
            case 38: goto L_0x0022;
            case 39: goto L_0x0022;
            case 40: goto L_0x0022;
            case 41: goto L_0x0022;
            case 42: goto L_0x0022;
            case 43: goto L_0x0022;
            case 44: goto L_0x0022;
            case 45: goto L_0x0022;
            case 46: goto L_0x0022;
            case 47: goto L_0x0022;
            case 48: goto L_0x0022;
            case 49: goto L_0x0022;
            case 50: goto L_0x0022;
            case 51: goto L_0x0022;
            case 52: goto L_0x0022;
            case 53: goto L_0x0022;
            case 54: goto L_0x0022;
            case 55: goto L_0x0022;
            case 56: goto L_0x0022;
            case 57: goto L_0x0022;
            case 58: goto L_0x0022;
            case 59: goto L_0x0022;
            case 60: goto L_0x0022;
            case 61: goto L_0x0022;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r1) {
            case 68: goto L_0x0022;
            case 69: goto L_0x0022;
            case 70: goto L_0x0022;
            case 71: goto L_0x0022;
            case 72: goto L_0x0022;
            case 73: goto L_0x0022;
            case 74: goto L_0x0022;
            case 75: goto L_0x0022;
            case 76: goto L_0x0022;
            case 77: goto L_0x0022;
            case 78: goto L_0x0022;
            case 79: goto L_0x0022;
            case 80: goto L_0x0022;
            case 81: goto L_0x0022;
            case 82: goto L_0x001c;
            case 83: goto L_0x001c;
            case 84: goto L_0x001c;
            case 85: goto L_0x001c;
            case 86: goto L_0x001c;
            case 87: goto L_0x001c;
            case 88: goto L_0x001c;
            case 89: goto L_0x001c;
            case 90: goto L_0x001c;
            case 91: goto L_0x001c;
            case 92: goto L_0x001c;
            case 93: goto L_0x001c;
            case 94: goto L_0x001c;
            case 95: goto L_0x001c;
            case 96: goto L_0x001c;
            case 97: goto L_0x001c;
            case 98: goto L_0x001c;
            case 99: goto L_0x001c;
            case 100: goto L_0x001c;
            case 101: goto L_0x001c;
            case 102: goto L_0x001c;
            case 103: goto L_0x001c;
            case 104: goto L_0x001c;
            case 105: goto L_0x001c;
            case 106: goto L_0x001c;
            case 107: goto L_0x001c;
            case 108: goto L_0x001c;
            case 109: goto L_0x001c;
            case 110: goto L_0x001a;
            case 111: goto L_0x001a;
            case 112: goto L_0x001a;
            case 113: goto L_0x001a;
            case 114: goto L_0x001a;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r1) {
            case 116: goto L_0x001a;
            case 117: goto L_0x001a;
            case 118: goto L_0x001a;
            case 119: goto L_0x001a;
            case 120: goto L_0x001a;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r1) {
            case 123: goto L_0x0022;
            case 124: goto L_0x0022;
            case 125: goto L_0x0022;
            case 126: goto L_0x0022;
            case 127: goto L_0x0022;
            case 128: goto L_0x0022;
            case 129: goto L_0x0022;
            case 130: goto L_0x0022;
            case 131: goto L_0x0022;
            case 132: goto L_0x0022;
            case 133: goto L_0x0022;
            case 134: goto L_0x0022;
            case 135: goto L_0x0022;
            case 136: goto L_0x0022;
            case 137: goto L_0x0022;
            case 138: goto L_0x0022;
            case 139: goto L_0x0022;
            case 140: goto L_0x0022;
            case 141: goto L_0x0022;
            case 142: goto L_0x0022;
            case 143: goto L_0x0022;
            case 144: goto L_0x0022;
            case 145: goto L_0x0022;
            case 146: goto L_0x0022;
            case 147: goto L_0x0022;
            case 148: goto L_0x0022;
            case 149: goto L_0x0022;
            case 150: goto L_0x0022;
            case 151: goto L_0x0022;
            case 152: goto L_0x0022;
            case 153: goto L_0x0022;
            case 154: goto L_0x0022;
            case 155: goto L_0x0022;
            case 156: goto L_0x0022;
            case 157: goto L_0x0022;
            case 158: goto L_0x0022;
            case 159: goto L_0x0022;
            case 160: goto L_0x0022;
            case 161: goto L_0x0022;
            case 162: goto L_0x0022;
            case 163: goto L_0x0022;
            case 164: goto L_0x0022;
            case 165: goto L_0x0022;
            case 166: goto L_0x0022;
            case 167: goto L_0x0022;
            case 168: goto L_0x0022;
            case 169: goto L_0x0022;
            case 170: goto L_0x0022;
            case 171: goto L_0x0022;
            case 172: goto L_0x0022;
            case 173: goto L_0x0022;
            case 174: goto L_0x0022;
            case 175: goto L_0x0022;
            case 176: goto L_0x0022;
            case 177: goto L_0x0022;
            case 178: goto L_0x0022;
            case 179: goto L_0x0022;
            case 180: goto L_0x0022;
            case 181: goto L_0x0022;
            case 182: goto L_0x0022;
            case 183: goto L_0x0022;
            case 184: goto L_0x0022;
            case 185: goto L_0x0022;
            case 186: goto L_0x0022;
            case 187: goto L_0x0022;
            case 188: goto L_0x0022;
            case 189: goto L_0x0022;
            case 190: goto L_0x0022;
            case 191: goto L_0x0022;
            case 192: goto L_0x0022;
            case 193: goto L_0x0022;
            case 194: goto L_0x0022;
            case 195: goto L_0x0022;
            case 196: goto L_0x0022;
            case 197: goto L_0x0022;
            case 198: goto L_0x0022;
            case 199: goto L_0x0022;
            case 200: goto L_0x0022;
            case 201: goto L_0x0022;
            case 202: goto L_0x0022;
            case 203: goto L_0x0022;
            case 204: goto L_0x0022;
            case 205: goto L_0x0022;
            case 206: goto L_0x0022;
            case 207: goto L_0x0022;
            case 208: goto L_0x0022;
            case 209: goto L_0x0022;
            case 210: goto L_0x0022;
            case 211: goto L_0x0022;
            case 212: goto L_0x0022;
            case 213: goto L_0x0022;
            case 214: goto L_0x0022;
            case 215: goto L_0x0022;
            case 216: goto L_0x0022;
            case 217: goto L_0x0022;
            case 218: goto L_0x0022;
            case 219: goto L_0x0022;
            case 220: goto L_0x0022;
            case 221: goto L_0x0022;
            case 222: goto L_0x0022;
            case 223: goto L_0x0022;
            case 224: goto L_0x0022;
            case 225: goto L_0x0022;
            case 226: goto L_0x0022;
            default: goto L_0x0018;
        };
    L_0x0018:
        r1 = 0;
        return r1;
    L_0x001a:
        r1 = 4;
        return r1;
    L_0x001c:
        r1 = 5;
        return r1;
    L_0x001e:
        r1 = 2;
        return r1;
    L_0x0020:
        r1 = 3;
        return r1;
    L_0x0022:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dx.instruction.InstructionCodec.getInstructionIndexType(int):int");
    }

    public static int getTarget(int i, int i2) {
        return i - i2;
    }

    public static int nibble0(int i) {
        return i & 15;
    }

    public static int nibble1(int i) {
        return (i >> 4) & 15;
    }

    public static int nibble2(int i) {
        return (i >> 8) & 15;
    }

    public static int nibble3(int i) {
        return (i >> 12) & 15;
    }

    public static short unit0(int i) {
        return (short) i;
    }

    public static short unit0(long j) {
        return (short) ((int) j);
    }

    public static short unit1(int i) {
        return (short) (i >> 16);
    }

    public static short unit1(long j) {
        return (short) ((int) (j >> 16));
    }

    public static short unit2(long j) {
        return (short) ((int) (j >> 32));
    }

    public static short unit3(long j) {
        return (short) ((int) (j >> 48));
    }

    private InstructionCodec() {
        throw new UnsupportedOperationException();
    }

    public static short codeUnit(int i, int i2) {
        if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        } else if ((i2 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) (i | (i2 << 8));
        } else {
            throw new IllegalArgumentException("bogus highByte");
        }
    }

    public static short codeUnit(int i, int i2, int i3, int i4) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        } else if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        } else if ((i3 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        } else if ((i4 & -16) == 0) {
            return (short) (((i | (i2 << 4)) | (i3 << 8)) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("bogus nibble3");
        }
    }

    public static int makeByte(int i, int i2) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        } else if ((i2 & -16) == 0) {
            return i | (i2 << 4);
        } else {
            throw new IllegalArgumentException("bogus highNibble");
        }
    }

    public static short asUnsignedUnit(int i) {
        if ((SupportMenu.CATEGORY_MASK & i) == 0) {
            return (short) i;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int getTargetByte(int i, int i2) {
        i = getTarget(i, i2);
        if (i == ((byte) i)) {
            return i & 255;
        }
        StringBuilder stringBuilder = new StringBuilder("Target out of range: ");
        stringBuilder.append(Hex.s4(i));
        stringBuilder.append(", perhaps you need to enable force jumbo mode.");
        throw new DexException(stringBuilder.toString());
    }

    public static short getTargetUnit(int i, int i2) {
        i = getTarget(i, i2);
        i2 = (short) i;
        if (i == i2) {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder("Target out of range: ");
        stringBuilder.append(Hex.s4(i));
        stringBuilder.append(", perhaps you need to enable force jumbo mode.");
        throw new DexException(stringBuilder.toString());
    }

    public static int getLiteralByte(long j) {
        int i = (int) j;
        if (j == ((long) ((byte) i))) {
            return i & 255;
        }
        StringBuilder stringBuilder = new StringBuilder("Literal out of range: ");
        stringBuilder.append(Hex.u8(j));
        throw new DexException(stringBuilder.toString());
    }

    public static short getLiteralUnit(long j) {
        short s = (short) ((int) j);
        if (j == ((long) s)) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder("Literal out of range: ");
        stringBuilder.append(Hex.u8(j));
        throw new DexException(stringBuilder.toString());
    }

    public static int getLiteralInt(long j) {
        int i = (int) j;
        if (j == ((long) i)) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder("Literal out of range: ");
        stringBuilder.append(Hex.u8(j));
        throw new DexException(stringBuilder.toString());
    }

    public static int getLiteralNibble(long j) {
        if (j >= -8) {
            if (j <= 7) {
                return ((int) j) & 15;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Literal out of range: ");
        stringBuilder.append(Hex.u8(j));
        throw new DexException(stringBuilder.toString());
    }

    public static short getAUnit(int i) {
        if ((SupportMenu.CATEGORY_MASK & i) == 0) {
            return (short) i;
        }
        StringBuilder stringBuilder = new StringBuilder("Register A out of range: ");
        stringBuilder.append(Hex.u8((long) i));
        throw new DexException(stringBuilder.toString());
    }

    public static short getBUnit(int i) {
        if ((SupportMenu.CATEGORY_MASK & i) == 0) {
            return (short) i;
        }
        StringBuilder stringBuilder = new StringBuilder("Register B out of range: ");
        stringBuilder.append(Hex.u8((long) i));
        throw new DexException(stringBuilder.toString());
    }
}
