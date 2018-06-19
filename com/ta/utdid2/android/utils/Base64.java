package com.ta.utdid2.android.utils;

import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.aplayer.aplayerandroid.FF2AndroidMapper;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.android.dx.instruction.Opcodes;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);

        Coder() {
        }
    }

    static class Decoder extends Coder {
        private static final int[] DECODE;
        private static final int[] DECODE_WEBSAFE;
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        static {
            int[] iArr = new int[256];
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            iArr[6] = -1;
            iArr[7] = -1;
            iArr[8] = -1;
            iArr[9] = -1;
            iArr[10] = -1;
            iArr[11] = -1;
            iArr[12] = -1;
            iArr[13] = -1;
            iArr[14] = -1;
            iArr[15] = -1;
            iArr[16] = -1;
            iArr[17] = -1;
            iArr[18] = -1;
            iArr[19] = -1;
            iArr[20] = -1;
            iArr[21] = -1;
            iArr[22] = -1;
            iArr[23] = -1;
            iArr[24] = -1;
            iArr[25] = -1;
            iArr[26] = -1;
            iArr[27] = -1;
            iArr[28] = -1;
            iArr[29] = -1;
            iArr[30] = -1;
            iArr[31] = -1;
            iArr[32] = -1;
            iArr[33] = -1;
            iArr[34] = -1;
            iArr[35] = -1;
            iArr[36] = -1;
            iArr[37] = -1;
            iArr[38] = -1;
            iArr[39] = -1;
            iArr[40] = -1;
            iArr[41] = -1;
            iArr[42] = -1;
            iArr[43] = 62;
            iArr[44] = -1;
            iArr[45] = -1;
            iArr[46] = -1;
            iArr[47] = 63;
            iArr[48] = 52;
            iArr[49] = 53;
            iArr[50] = 54;
            iArr[51] = 55;
            iArr[52] = 56;
            iArr[53] = 57;
            iArr[54] = 58;
            iArr[55] = 59;
            iArr[56] = 60;
            iArr[57] = 61;
            iArr[58] = -1;
            iArr[59] = -1;
            iArr[60] = -1;
            iArr[61] = -2;
            iArr[62] = -1;
            iArr[63] = -1;
            iArr[64] = -1;
            iArr[66] = 1;
            iArr[67] = 2;
            iArr[68] = 3;
            iArr[69] = 4;
            iArr[70] = 5;
            iArr[71] = 6;
            iArr[72] = 7;
            iArr[73] = 8;
            iArr[74] = 9;
            iArr[75] = 10;
            iArr[76] = 11;
            iArr[77] = 12;
            iArr[78] = 13;
            iArr[79] = 14;
            iArr[80] = 15;
            iArr[81] = 16;
            iArr[82] = 17;
            iArr[83] = 18;
            iArr[84] = 19;
            iArr[85] = 20;
            iArr[86] = 21;
            iArr[87] = 22;
            iArr[88] = 23;
            iArr[89] = 24;
            iArr[90] = 25;
            iArr[91] = -1;
            iArr[92] = -1;
            iArr[93] = -1;
            iArr[94] = -1;
            iArr[95] = -1;
            iArr[96] = -1;
            iArr[97] = 26;
            iArr[98] = 27;
            iArr[99] = 28;
            iArr[100] = 29;
            iArr[101] = 30;
            iArr[102] = 31;
            iArr[103] = 32;
            iArr[104] = 33;
            iArr[105] = 34;
            iArr[106] = 35;
            iArr[107] = 36;
            iArr[108] = 37;
            iArr[109] = 38;
            iArr[110] = 39;
            iArr[111] = 40;
            iArr[112] = 41;
            iArr[113] = 42;
            iArr[114] = 43;
            iArr[115] = 44;
            iArr[116] = 45;
            iArr[117] = 46;
            iArr[118] = 47;
            iArr[Opcodes.INVOKE_STATIC_RANGE] = 48;
            iArr[120] = 49;
            iArr[121] = 50;
            iArr[122] = 51;
            iArr[123] = -1;
            iArr[124] = -1;
            iArr[125] = -1;
            iArr[Opcodes.NOT_LONG] = -1;
            iArr[Opcodes.NEG_FLOAT] = -1;
            iArr[128] = -1;
            iArr[Opcodes.INT_TO_LONG] = -1;
            iArr[130] = -1;
            iArr[Opcodes.INT_TO_DOUBLE] = -1;
            iArr[Opcodes.LONG_TO_INT] = -1;
            iArr[Opcodes.LONG_TO_FLOAT] = -1;
            iArr[Opcodes.LONG_TO_DOUBLE] = -1;
            iArr[Opcodes.FLOAT_TO_INT] = -1;
            iArr[Opcodes.FLOAT_TO_LONG] = -1;
            iArr[Opcodes.FLOAT_TO_DOUBLE] = -1;
            iArr[Opcodes.DOUBLE_TO_INT] = -1;
            iArr[Opcodes.DOUBLE_TO_LONG] = -1;
            iArr[Opcodes.DOUBLE_TO_FLOAT] = -1;
            iArr[Opcodes.INT_TO_BYTE] = -1;
            iArr[Opcodes.INT_TO_CHAR] = -1;
            iArr[Opcodes.INT_TO_SHORT] = -1;
            iArr[144] = -1;
            iArr[Opcodes.SUB_INT] = -1;
            iArr[Opcodes.MUL_INT] = -1;
            iArr[Opcodes.DIV_INT] = -1;
            iArr[Opcodes.REM_INT] = -1;
            iArr[Opcodes.AND_INT] = -1;
            iArr[150] = -1;
            iArr[151] = -1;
            iArr[152] = -1;
            iArr[153] = -1;
            iArr[154] = -1;
            iArr[155] = -1;
            iArr[156] = -1;
            iArr[157] = -1;
            iArr[158] = -1;
            iArr[Opcodes.REM_LONG] = -1;
            iArr[Opcodes.AND_LONG] = -1;
            iArr[Opcodes.OR_LONG] = -1;
            iArr[Opcodes.XOR_LONG] = -1;
            iArr[Opcodes.SHL_LONG] = -1;
            iArr[Opcodes.SHR_LONG] = -1;
            iArr[Opcodes.USHR_LONG] = -1;
            iArr[Opcodes.ADD_FLOAT] = -1;
            iArr[Opcodes.SUB_FLOAT] = -1;
            iArr[Opcodes.MUL_FLOAT] = -1;
            iArr[Opcodes.DIV_FLOAT] = -1;
            iArr[Opcodes.REM_FLOAT] = -1;
            iArr[Opcodes.ADD_DOUBLE] = -1;
            iArr[Opcodes.SUB_DOUBLE] = -1;
            iArr[Opcodes.MUL_DOUBLE] = -1;
            iArr[Opcodes.DIV_DOUBLE] = -1;
            iArr[Opcodes.REM_DOUBLE] = -1;
            iArr[Opcodes.ADD_INT_2ADDR] = -1;
            iArr[Opcodes.SUB_INT_2ADDR] = -1;
            iArr[Opcodes.MUL_INT_2ADDR] = -1;
            iArr[Opcodes.DIV_INT_2ADDR] = -1;
            iArr[180] = -1;
            iArr[181] = -1;
            iArr[182] = -1;
            iArr[183] = -1;
            iArr[184] = -1;
            iArr[Opcodes.SHR_INT_2ADDR] = -1;
            iArr[Opcodes.USHR_INT_2ADDR] = -1;
            iArr[Opcodes.ADD_LONG_2ADDR] = -1;
            iArr[Opcodes.SUB_LONG_2ADDR] = -1;
            iArr[Opcodes.MUL_LONG_2ADDR] = -1;
            iArr[190] = -1;
            iArr[191] = -1;
            iArr[192] = -1;
            iArr[193] = -1;
            iArr[194] = -1;
            iArr[195] = -1;
            iArr[196] = -1;
            iArr[Opcodes.USHR_LONG_2ADDR] = -1;
            iArr[198] = -1;
            iArr[199] = -1;
            iArr[200] = -1;
            iArr[201] = -1;
            iArr[202] = -1;
            iArr[203] = -1;
            iArr[204] = -1;
            iArr[205] = -1;
            iArr[206] = -1;
            iArr[207] = -1;
            iArr[208] = -1;
            iArr[209] = -1;
            iArr[210] = -1;
            iArr[211] = -1;
            iArr[212] = -1;
            iArr[213] = -1;
            iArr[214] = -1;
            iArr[215] = -1;
            iArr[216] = -1;
            iArr[217] = -1;
            iArr[218] = -1;
            iArr[219] = -1;
            iArr[220] = -1;
            iArr[221] = -1;
            iArr[222] = -1;
            iArr[223] = -1;
            iArr[224] = -1;
            iArr[225] = -1;
            iArr[226] = -1;
            iArr[ErrorCode.HOST_CONTEXT_IS_NULL] = -1;
            iArr[228] = -1;
            iArr[229] = -1;
            iArr[CONFIGID.HW_DECODER_ENABLE] = -1;
            iArr[CONFIGID.HW_DECODER_DETEC] = -1;
            iArr[232] = -1;
            iArr[233] = -1;
            iArr[234] = -1;
            iArr[235] = -1;
            iArr[236] = -1;
            iArr[237] = -1;
            iArr[238] = -1;
            iArr[239] = -1;
            iArr[240] = -1;
            iArr[241] = -1;
            iArr[242] = -1;
            iArr[243] = -1;
            iArr[FF2AndroidMapper.FF_PROFILE_H264_HIGH_444_PREDICTIVE] = -1;
            iArr[245] = -1;
            iArr[246] = -1;
            iArr[247] = -1;
            iArr[248] = -1;
            iArr[249] = -1;
            iArr[250] = -1;
            iArr[TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION] = -1;
            iArr[TinkerReport.KEY_LOADED_EXCEPTION_DEX] = -1;
            iArr[TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK] = -1;
            iArr[254] = -1;
            iArr[255] = -1;
            DECODE = iArr;
            iArr = new int[256];
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            iArr[6] = -1;
            iArr[7] = -1;
            iArr[8] = -1;
            iArr[9] = -1;
            iArr[10] = -1;
            iArr[11] = -1;
            iArr[12] = -1;
            iArr[13] = -1;
            iArr[14] = -1;
            iArr[15] = -1;
            iArr[16] = -1;
            iArr[17] = -1;
            iArr[18] = -1;
            iArr[19] = -1;
            iArr[20] = -1;
            iArr[21] = -1;
            iArr[22] = -1;
            iArr[23] = -1;
            iArr[24] = -1;
            iArr[25] = -1;
            iArr[26] = -1;
            iArr[27] = -1;
            iArr[28] = -1;
            iArr[29] = -1;
            iArr[30] = -1;
            iArr[31] = -1;
            iArr[32] = -1;
            iArr[33] = -1;
            iArr[34] = -1;
            iArr[35] = -1;
            iArr[36] = -1;
            iArr[37] = -1;
            iArr[38] = -1;
            iArr[39] = -1;
            iArr[40] = -1;
            iArr[41] = -1;
            iArr[42] = -1;
            iArr[43] = -1;
            iArr[44] = -1;
            iArr[45] = 62;
            iArr[46] = -1;
            iArr[47] = -1;
            iArr[48] = 52;
            iArr[49] = 53;
            iArr[50] = 54;
            iArr[51] = 55;
            iArr[52] = 56;
            iArr[53] = 57;
            iArr[54] = 58;
            iArr[55] = 59;
            iArr[56] = 60;
            iArr[57] = 61;
            iArr[58] = -1;
            iArr[59] = -1;
            iArr[60] = -1;
            iArr[61] = -2;
            iArr[62] = -1;
            iArr[63] = -1;
            iArr[64] = -1;
            iArr[66] = 1;
            iArr[67] = 2;
            iArr[68] = 3;
            iArr[69] = 4;
            iArr[70] = 5;
            iArr[71] = 6;
            iArr[72] = 7;
            iArr[73] = 8;
            iArr[74] = 9;
            iArr[75] = 10;
            iArr[76] = 11;
            iArr[77] = 12;
            iArr[78] = 13;
            iArr[79] = 14;
            iArr[80] = 15;
            iArr[81] = 16;
            iArr[82] = 17;
            iArr[83] = 18;
            iArr[84] = 19;
            iArr[85] = 20;
            iArr[86] = 21;
            iArr[87] = 22;
            iArr[88] = 23;
            iArr[89] = 24;
            iArr[90] = 25;
            iArr[91] = -1;
            iArr[92] = -1;
            iArr[93] = -1;
            iArr[94] = -1;
            iArr[95] = 63;
            iArr[96] = -1;
            iArr[97] = 26;
            iArr[98] = 27;
            iArr[99] = 28;
            iArr[100] = 29;
            iArr[101] = 30;
            iArr[102] = 31;
            iArr[103] = 32;
            iArr[104] = 33;
            iArr[105] = 34;
            iArr[106] = 35;
            iArr[107] = 36;
            iArr[108] = 37;
            iArr[109] = 38;
            iArr[110] = 39;
            iArr[111] = 40;
            iArr[112] = 41;
            iArr[113] = 42;
            iArr[114] = 43;
            iArr[115] = 44;
            iArr[116] = 45;
            iArr[117] = 46;
            iArr[118] = 47;
            iArr[Opcodes.INVOKE_STATIC_RANGE] = 48;
            iArr[120] = 49;
            iArr[121] = 50;
            iArr[122] = 51;
            iArr[123] = -1;
            iArr[124] = -1;
            iArr[125] = -1;
            iArr[Opcodes.NOT_LONG] = -1;
            iArr[Opcodes.NEG_FLOAT] = -1;
            iArr[128] = -1;
            iArr[Opcodes.INT_TO_LONG] = -1;
            iArr[130] = -1;
            iArr[Opcodes.INT_TO_DOUBLE] = -1;
            iArr[Opcodes.LONG_TO_INT] = -1;
            iArr[Opcodes.LONG_TO_FLOAT] = -1;
            iArr[Opcodes.LONG_TO_DOUBLE] = -1;
            iArr[Opcodes.FLOAT_TO_INT] = -1;
            iArr[Opcodes.FLOAT_TO_LONG] = -1;
            iArr[Opcodes.FLOAT_TO_DOUBLE] = -1;
            iArr[Opcodes.DOUBLE_TO_INT] = -1;
            iArr[Opcodes.DOUBLE_TO_LONG] = -1;
            iArr[Opcodes.DOUBLE_TO_FLOAT] = -1;
            iArr[Opcodes.INT_TO_BYTE] = -1;
            iArr[Opcodes.INT_TO_CHAR] = -1;
            iArr[Opcodes.INT_TO_SHORT] = -1;
            iArr[144] = -1;
            iArr[Opcodes.SUB_INT] = -1;
            iArr[Opcodes.MUL_INT] = -1;
            iArr[Opcodes.DIV_INT] = -1;
            iArr[Opcodes.REM_INT] = -1;
            iArr[Opcodes.AND_INT] = -1;
            iArr[150] = -1;
            iArr[151] = -1;
            iArr[152] = -1;
            iArr[153] = -1;
            iArr[154] = -1;
            iArr[155] = -1;
            iArr[156] = -1;
            iArr[157] = -1;
            iArr[158] = -1;
            iArr[Opcodes.REM_LONG] = -1;
            iArr[Opcodes.AND_LONG] = -1;
            iArr[Opcodes.OR_LONG] = -1;
            iArr[Opcodes.XOR_LONG] = -1;
            iArr[Opcodes.SHL_LONG] = -1;
            iArr[Opcodes.SHR_LONG] = -1;
            iArr[Opcodes.USHR_LONG] = -1;
            iArr[Opcodes.ADD_FLOAT] = -1;
            iArr[Opcodes.SUB_FLOAT] = -1;
            iArr[Opcodes.MUL_FLOAT] = -1;
            iArr[Opcodes.DIV_FLOAT] = -1;
            iArr[Opcodes.REM_FLOAT] = -1;
            iArr[Opcodes.ADD_DOUBLE] = -1;
            iArr[Opcodes.SUB_DOUBLE] = -1;
            iArr[Opcodes.MUL_DOUBLE] = -1;
            iArr[Opcodes.DIV_DOUBLE] = -1;
            iArr[Opcodes.REM_DOUBLE] = -1;
            iArr[Opcodes.ADD_INT_2ADDR] = -1;
            iArr[Opcodes.SUB_INT_2ADDR] = -1;
            iArr[Opcodes.MUL_INT_2ADDR] = -1;
            iArr[Opcodes.DIV_INT_2ADDR] = -1;
            iArr[180] = -1;
            iArr[181] = -1;
            iArr[182] = -1;
            iArr[183] = -1;
            iArr[184] = -1;
            iArr[Opcodes.SHR_INT_2ADDR] = -1;
            iArr[Opcodes.USHR_INT_2ADDR] = -1;
            iArr[Opcodes.ADD_LONG_2ADDR] = -1;
            iArr[Opcodes.SUB_LONG_2ADDR] = -1;
            iArr[Opcodes.MUL_LONG_2ADDR] = -1;
            iArr[190] = -1;
            iArr[191] = -1;
            iArr[192] = -1;
            iArr[193] = -1;
            iArr[194] = -1;
            iArr[195] = -1;
            iArr[196] = -1;
            iArr[Opcodes.USHR_LONG_2ADDR] = -1;
            iArr[198] = -1;
            iArr[199] = -1;
            iArr[200] = -1;
            iArr[201] = -1;
            iArr[202] = -1;
            iArr[203] = -1;
            iArr[204] = -1;
            iArr[205] = -1;
            iArr[206] = -1;
            iArr[207] = -1;
            iArr[208] = -1;
            iArr[209] = -1;
            iArr[210] = -1;
            iArr[211] = -1;
            iArr[212] = -1;
            iArr[213] = -1;
            iArr[214] = -1;
            iArr[215] = -1;
            iArr[216] = -1;
            iArr[217] = -1;
            iArr[218] = -1;
            iArr[219] = -1;
            iArr[220] = -1;
            iArr[221] = -1;
            iArr[222] = -1;
            iArr[223] = -1;
            iArr[224] = -1;
            iArr[225] = -1;
            iArr[226] = -1;
            iArr[ErrorCode.HOST_CONTEXT_IS_NULL] = -1;
            iArr[228] = -1;
            iArr[229] = -1;
            iArr[CONFIGID.HW_DECODER_ENABLE] = -1;
            iArr[CONFIGID.HW_DECODER_DETEC] = -1;
            iArr[232] = -1;
            iArr[233] = -1;
            iArr[234] = -1;
            iArr[235] = -1;
            iArr[236] = -1;
            iArr[237] = -1;
            iArr[238] = -1;
            iArr[239] = -1;
            iArr[240] = -1;
            iArr[241] = -1;
            iArr[242] = -1;
            iArr[243] = -1;
            iArr[FF2AndroidMapper.FF_PROFILE_H264_HIGH_444_PREDICTIVE] = -1;
            iArr[245] = -1;
            iArr[246] = -1;
            iArr[247] = -1;
            iArr[248] = -1;
            iArr[249] = -1;
            iArr[250] = -1;
            iArr[TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION] = -1;
            iArr[TinkerReport.KEY_LOADED_EXCEPTION_DEX] = -1;
            iArr[TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK] = -1;
            iArr[254] = -1;
            iArr[255] = -1;
            DECODE_WEBSAFE = iArr;
        }

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        public int maxOutputSize(int i) {
            return ((i * 3) / 4) + 10;
        }

        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            if (this.state == 6) {
                return false;
            }
            i2 += i;
            int i3 = this.state;
            int i4 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i5 = 0;
            while (i < i2) {
                int i6;
                if (i3 == 0) {
                    while (true) {
                        i6 = i + 4;
                        if (i6 <= i2) {
                            i4 = (((iArr[bArr[i] & 255] << 18) | (iArr[bArr[i + 1] & 255] << 12)) | (iArr[bArr[i + 2] & 255] << 6)) | iArr[bArr[i + 3] & 255];
                            if (i4 >= 0) {
                                bArr2[i5 + 2] = (byte) i4;
                                bArr2[i5 + 1] = (byte) (i4 >> 8);
                                bArr2[i5] = (byte) (i4 >> 16);
                                i5 += 3;
                                i = i6;
                            }
                        }
                        if (i >= i2) {
                            if (z) {
                                this.state = i3;
                                this.value = i4;
                                this.op = i5;
                                return true;
                            }
                            switch (i3) {
                                case 0:
                                    break;
                                case 1:
                                    this.state = 6;
                                    return false;
                                case 2:
                                    i = i5 + 1;
                                    bArr2[i5] = (byte) (i4 >> 4);
                                    i5 = i;
                                    break;
                                case 3:
                                    i = i5 + 1;
                                    bArr2[i5] = (byte) (i4 >> 10);
                                    i5 = i + 1;
                                    bArr2[i] = (byte) (i4 >> 2);
                                    break;
                                case 4:
                                    this.state = 6;
                                    return false;
                                default:
                                    break;
                            }
                            this.state = i3;
                            this.op = i5;
                            return true;
                        }
                    }
                }
                i6 = i + 1;
                i = iArr[bArr[i] & 255];
                switch (i3) {
                    case 0:
                        if (i < 0) {
                            if (i == -1) {
                                break;
                            }
                            this.state = 6;
                            return false;
                        }
                        i3++;
                        i4 = i;
                        break;
                    case 1:
                        if (i < 0) {
                            if (i == -1) {
                                break;
                            }
                            this.state = 6;
                            return false;
                        }
                        i4 = (i4 << 6) | i;
                        i3++;
                        break;
                    case 2:
                        if (i < 0) {
                            if (i != -2) {
                                if (i == -1) {
                                    break;
                                }
                                this.state = 6;
                                return false;
                            }
                            i = i5 + 1;
                            bArr2[i5] = (byte) (i4 >> 4);
                            i5 = i;
                            i3 = 4;
                            break;
                        }
                        i4 = (i4 << 6) | i;
                        i3++;
                        break;
                    case 3:
                        if (i < 0) {
                            if (i != -2) {
                                if (i == -1) {
                                    break;
                                }
                                this.state = 6;
                                return false;
                            }
                            bArr2[i5 + 1] = (byte) (i4 >> 2);
                            bArr2[i5] = (byte) (i4 >> 10);
                            i5 += 2;
                            i3 = 5;
                            break;
                        }
                        i4 = (i4 << 6) | i;
                        bArr2[i5 + 2] = (byte) i4;
                        bArr2[i5 + 1] = (byte) (i4 >> 8);
                        bArr2[i5] = (byte) (i4 >> 16);
                        i5 += 3;
                        i3 = 0;
                        break;
                    case 4:
                        if (i != -2) {
                            if (i == -1) {
                                break;
                            }
                            this.state = 6;
                            return false;
                        }
                        i3++;
                        break;
                    case 5:
                        if (i == -1) {
                            break;
                        }
                        this.state = 6;
                        return false;
                    default:
                        break;
                }
                i = i6;
            }
            if (z) {
                switch (i3) {
                    case 0:
                        break;
                    case 1:
                        this.state = 6;
                        return false;
                    case 2:
                        i = i5 + 1;
                        bArr2[i5] = (byte) (i4 >> 4);
                        i5 = i;
                        break;
                    case 3:
                        i = i5 + 1;
                        bArr2[i5] = (byte) (i4 >> 10);
                        i5 = i + 1;
                        bArr2[i] = (byte) (i4 >> 2);
                        break;
                    case 4:
                        this.state = 6;
                        return false;
                    default:
                        break;
                }
                this.state = i3;
                this.op = i5;
                return true;
            }
            this.state = i3;
            this.value = i4;
            this.op = i5;
            return true;
        }
    }

    static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            Class cls = Base64.class;
        }

        public Encoder(int i, byte[] bArr) {
            this.output = bArr;
            boolean z = true;
            this.do_padding = (i & 1) == null ? 1 : null;
            this.do_newline = (i & 2) == null ? 1 : null;
            if ((i & 4) == null) {
                z = false;
            }
            this.do_cr = z;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline != 0 ? 19 : -1;
        }

        public int maxOutputSize(int i) {
            return ((i * 8) / 5) + 10;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r19, int r20, int r21, boolean r22) {
            /*
            r18 = this;
            r0 = r18;
            r3 = r0.alphabet;
            r4 = r0.output;
            r5 = r0.count;
            r6 = r21 + r20;
            r7 = r0.tailLen;
            r8 = -1;
            r9 = 0;
            r10 = 1;
            switch(r7) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0030;
                case 2: goto L_0x0013;
                default: goto L_0x0012;
            };
        L_0x0012:
            goto L_0x004f;
        L_0x0013:
            r7 = r20 + 1;
            if (r7 > r6) goto L_0x004f;
        L_0x0017:
            r11 = r0.tail;
            r11 = r11[r9];
            r11 = r11 & 255;
            r11 = r11 << 16;
            r12 = r0.tail;
            r12 = r12[r10];
            r12 = r12 & 255;
            r12 = r12 << 8;
            r11 = r11 | r12;
            r2 = r19[r20];
            r2 = r2 & 255;
            r2 = r2 | r11;
            r0.tailLen = r9;
            goto L_0x0052;
        L_0x0030:
            r7 = r20 + 2;
            if (r7 > r6) goto L_0x004f;
        L_0x0034:
            r7 = r0.tail;
            r7 = r7[r9];
            r7 = r7 & 255;
            r7 = r7 << 16;
            r11 = r20 + 1;
            r2 = r19[r20];
            r2 = r2 & 255;
            r2 = r2 << 8;
            r2 = r2 | r7;
            r7 = r11 + 1;
            r11 = r19[r11];
            r11 = r11 & 255;
            r2 = r2 | r11;
            r0.tailLen = r9;
            goto L_0x0052;
        L_0x004f:
            r7 = r20;
            r2 = r8;
        L_0x0052:
            r12 = 4;
            r13 = 13;
            r14 = 10;
            r15 = 2;
            if (r2 == r8) goto L_0x0090;
        L_0x005a:
            r8 = r2 >> 18;
            r8 = r8 & 63;
            r8 = r3[r8];
            r4[r9] = r8;
            r8 = r2 >> 12;
            r8 = r8 & 63;
            r8 = r3[r8];
            r4[r10] = r8;
            r8 = r2 >> 6;
            r8 = r8 & 63;
            r8 = r3[r8];
            r4[r15] = r8;
            r2 = r2 & 63;
            r2 = r3[r2];
            r8 = 3;
            r4[r8] = r2;
            r5 = r5 + -1;
            if (r5 != 0) goto L_0x008d;
        L_0x007d:
            r2 = r0.do_cr;
            if (r2 == 0) goto L_0x0085;
        L_0x0081:
            r2 = 5;
            r4[r12] = r13;
            goto L_0x0086;
        L_0x0085:
            r2 = r12;
        L_0x0086:
            r5 = r2 + 1;
            r4[r2] = r14;
            r2 = 19;
            goto L_0x0092;
        L_0x008d:
            r2 = r5;
            r5 = r12;
            goto L_0x0092;
        L_0x0090:
            r2 = r5;
            r5 = r9;
        L_0x0092:
            r8 = r7 + 3;
            if (r8 <= r6) goto L_0x01a5;
        L_0x0096:
            if (r22 == 0) goto L_0x0173;
        L_0x0098:
            r8 = r0.tailLen;
            r8 = r7 - r8;
            r11 = r6 + -1;
            if (r8 != r11) goto L_0x00e9;
        L_0x00a0:
            r6 = r0.tailLen;
            if (r6 <= 0) goto L_0x00aa;
        L_0x00a4:
            r1 = r0.tail;
            r1 = r1[r9];
            r9 = r10;
            goto L_0x00ac;
        L_0x00aa:
            r1 = r19[r7];
        L_0x00ac:
            r1 = r1 & 255;
            r1 = r1 << r12;
            r6 = r0.tailLen;
            r6 = r6 - r9;
            r0.tailLen = r6;
            r6 = r5 + 1;
            r7 = r1 >> 6;
            r7 = r7 & 63;
            r7 = r3[r7];
            r4[r5] = r7;
            r5 = r6 + 1;
            r1 = r1 & 63;
            r1 = r3[r1];
            r4[r6] = r1;
            r1 = r0.do_padding;
            if (r1 == 0) goto L_0x00d4;
        L_0x00ca:
            r1 = r5 + 1;
            r3 = 61;
            r4[r5] = r3;
            r5 = r1 + 1;
            r4[r1] = r3;
        L_0x00d4:
            r1 = r0.do_newline;
            if (r1 == 0) goto L_0x01a0;
        L_0x00d8:
            r1 = r0.do_cr;
            if (r1 == 0) goto L_0x00e1;
        L_0x00dc:
            r1 = r5 + 1;
            r4[r5] = r13;
            goto L_0x00e2;
        L_0x00e1:
            r1 = r5;
        L_0x00e2:
            r3 = r1 + 1;
            r4[r1] = r14;
        L_0x00e6:
            r5 = r3;
            goto L_0x01a0;
        L_0x00e9:
            r8 = r0.tailLen;
            r8 = r7 - r8;
            r6 = r6 - r15;
            if (r8 != r6) goto L_0x0159;
        L_0x00f0:
            r6 = r0.tailLen;
            if (r6 <= r10) goto L_0x00fa;
        L_0x00f4:
            r6 = r0.tail;
            r6 = r6[r9];
            r9 = r10;
            goto L_0x0103;
        L_0x00fa:
            r6 = r7 + 1;
            r7 = r19[r7];
            r17 = r7;
            r7 = r6;
            r6 = r17;
        L_0x0103:
            r6 = r6 & 255;
            r6 = r6 << r14;
            r8 = r0.tailLen;
            if (r8 <= 0) goto L_0x0112;
        L_0x010a:
            r1 = r0.tail;
            r7 = r9 + 1;
            r1 = r1[r9];
            r9 = r7;
            goto L_0x0114;
        L_0x0112:
            r1 = r19[r7];
        L_0x0114:
            r1 = r1 & 255;
            r1 = r1 << r15;
            r1 = r1 | r6;
            r6 = r0.tailLen;
            r6 = r6 - r9;
            r0.tailLen = r6;
            r6 = r5 + 1;
            r7 = r1 >> 12;
            r7 = r7 & 63;
            r7 = r3[r7];
            r4[r5] = r7;
            r5 = r6 + 1;
            r7 = r1 >> 6;
            r7 = r7 & 63;
            r7 = r3[r7];
            r4[r6] = r7;
            r6 = r5 + 1;
            r1 = r1 & 63;
            r1 = r3[r1];
            r4[r5] = r1;
            r1 = r0.do_padding;
            if (r1 == 0) goto L_0x0144;
        L_0x013d:
            r1 = r6 + 1;
            r3 = 61;
            r4[r6] = r3;
            goto L_0x0145;
        L_0x0144:
            r1 = r6;
        L_0x0145:
            r3 = r0.do_newline;
            if (r3 == 0) goto L_0x0157;
        L_0x0149:
            r3 = r0.do_cr;
            if (r3 == 0) goto L_0x0152;
        L_0x014d:
            r3 = r1 + 1;
            r4[r1] = r13;
            r1 = r3;
        L_0x0152:
            r3 = r1 + 1;
            r4[r1] = r14;
            goto L_0x00e6;
        L_0x0157:
            r5 = r1;
            goto L_0x01a0;
        L_0x0159:
            r1 = r0.do_newline;
            if (r1 == 0) goto L_0x01a0;
        L_0x015d:
            if (r5 <= 0) goto L_0x01a0;
        L_0x015f:
            r11 = 19;
            if (r2 == r11) goto L_0x01a0;
        L_0x0163:
            r1 = r0.do_cr;
            if (r1 == 0) goto L_0x016c;
        L_0x0167:
            r1 = r5 + 1;
            r4[r5] = r13;
            goto L_0x016d;
        L_0x016c:
            r1 = r5;
        L_0x016d:
            r3 = r1 + 1;
            r4[r1] = r14;
            goto L_0x00e6;
        L_0x0173:
            r3 = r6 + -1;
            if (r7 != r3) goto L_0x0184;
        L_0x0177:
            r3 = r0.tail;
            r4 = r0.tailLen;
            r6 = r4 + 1;
            r0.tailLen = r6;
            r1 = r19[r7];
            r3[r4] = r1;
            goto L_0x01a0;
        L_0x0184:
            r6 = r6 - r15;
            if (r7 != r6) goto L_0x01a0;
        L_0x0187:
            r3 = r0.tail;
            r4 = r0.tailLen;
            r6 = r4 + 1;
            r0.tailLen = r6;
            r6 = r19[r7];
            r3[r4] = r6;
            r3 = r0.tail;
            r4 = r0.tailLen;
            r6 = r4 + 1;
            r0.tailLen = r6;
            r7 = r7 + r10;
            r1 = r19[r7];
            r3[r4] = r1;
        L_0x01a0:
            r0.op = r5;
            r0.count = r2;
            return r10;
        L_0x01a5:
            r11 = 19;
            r9 = r19[r7];
            r9 = r9 & 255;
            r9 = r9 << 16;
            r16 = r7 + 1;
            r10 = r19[r16];
            r10 = r10 & 255;
            r10 = r10 << 8;
            r9 = r9 | r10;
            r7 = r7 + 2;
            r7 = r19[r7];
            r7 = r7 & 255;
            r7 = r7 | r9;
            r9 = r7 >> 18;
            r9 = r9 & 63;
            r9 = r3[r9];
            r4[r5] = r9;
            r9 = r5 + 1;
            r10 = r7 >> 12;
            r10 = r10 & 63;
            r10 = r3[r10];
            r4[r9] = r10;
            r9 = r5 + 2;
            r10 = r7 >> 6;
            r10 = r10 & 63;
            r10 = r3[r10];
            r4[r9] = r10;
            r9 = r5 + 3;
            r7 = r7 & 63;
            r7 = r3[r7];
            r4[r9] = r7;
            r5 = r5 + 4;
            r2 = r2 + -1;
            if (r2 != 0) goto L_0x01f8;
        L_0x01e7:
            r2 = r0.do_cr;
            if (r2 == 0) goto L_0x01f0;
        L_0x01eb:
            r2 = r5 + 1;
            r4[r5] = r13;
            goto L_0x01f1;
        L_0x01f0:
            r2 = r5;
        L_0x01f1:
            r5 = r2 + 1;
            r4[r2] = r14;
            r7 = r8;
            r2 = r11;
            goto L_0x01f9;
        L_0x01f8:
            r7 = r8;
        L_0x01f9:
            r9 = 0;
            r10 = 1;
            goto L_0x0092;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        Decoder decoder = new Decoder(i3, new byte[((i2 * 3) / 4)]);
        if (decoder.process(bArr, i, i2, 1) == null) {
            throw new IllegalArgumentException("bad base-64");
        } else if (decoder.op == decoder.output.length) {
            return decoder.output;
        } else {
            bArr = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr, 0, decoder.op);
            return bArr;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (byte[] bArr2) {
            throw new AssertionError(bArr2);
        }
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i3) {
        try {
            return new String(encode(bArr, i, i2, i3), "US-ASCII");
        } catch (byte[] bArr2) {
            throw new AssertionError(bArr2);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        Encoder encoder = new Encoder(i3, null);
        i3 = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i3 += 2;
                    break;
                case 2:
                    i3 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i3 += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            i3 += (((i2 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i3];
        encoder.process(bArr, i, i2, true);
        return encoder.output;
    }

    private Base64() {
    }
}
