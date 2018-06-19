package com.bumptech.glide.gifencoder;

import com.taobao.accs.data.Message;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.IOException;
import java.io.OutputStream;

class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    byte[] accum = new byte[256];
    boolean clear_flg = false;
    int[] codetab = new int[5003];
    private int curPixel;
    int cur_accum = 0;
    int cur_bits = 0;
    int free_ent = 0;
    int g_init_bits;
    int hsize = 5003;
    int[] htab = new int[5003];
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int[] masks = new int[]{0, 1, 3, 7, 15, 31, 63, Opcodes.NEG_FLOAT, 255, 511, Message.EXT_HEADER_VALUE_MAX_LEN, 2047, 4095, 8191, 16383, 32767, 65535};
    int maxbits = 12;
    int maxcode;
    int maxmaxcode = 4096;
    int n_bits;
    private byte[] pixAry;
    private int remaining;

    final int MAXCODE(int i) {
        return (1 << i) - 1;
    }

    LZWEncoder(int i, int i2, byte[] bArr, int i3) {
        this.imgW = i;
        this.imgH = i2;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i3);
    }

    void char_out(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.accum;
        int i = this.a_count;
        this.a_count = i + 1;
        bArr[i] = b;
        if (this.a_count >= (byte) -2) {
            flush_char(outputStream);
        }
    }

    void cl_block(OutputStream outputStream) throws IOException {
        cl_hash(this.hsize);
        this.free_ent = this.ClearCode + 2;
        this.clear_flg = true;
        output(this.ClearCode, outputStream);
    }

    void cl_hash(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.htab[i2] = -1;
        }
    }

    void compress(int i, OutputStream outputStream) throws IOException {
        int i2;
        this.g_init_bits = i;
        int i3 = 0;
        this.clear_flg = false;
        this.n_bits = this.g_init_bits;
        this.maxcode = MAXCODE(this.n_bits);
        this.ClearCode = 1 << (i - 1);
        this.EOFCode = this.ClearCode + 1;
        this.free_ent = this.ClearCode + 2;
        this.a_count = 0;
        i = nextPixel();
        for (i2 = this.hsize; i2 < 65536; i2 *= 2) {
            i3++;
        }
        i3 = 8 - i3;
        i2 = this.hsize;
        cl_hash(i2);
        output(this.ClearCode, outputStream);
        while (true) {
            int nextPixel = nextPixel();
            if (nextPixel != -1) {
                int i4 = (nextPixel << this.maxbits) + i;
                int i5 = (nextPixel << i3) ^ i;
                if (this.htab[i5] == i4) {
                    i = this.codetab[i5];
                } else if (this.htab[i5] >= 0) {
                    r6 = i2 - i5;
                    if (i5 == 0) {
                        r6 = 1;
                    }
                    do {
                        i5 -= r6;
                        if (i5 < 0) {
                            i5 += i2;
                        }
                        if (this.htab[i5] == i4) {
                            i = this.codetab[i5];
                            break;
                        }
                    } while (this.htab[i5] >= 0);
                    output(i, outputStream);
                    if (this.free_ent >= this.maxmaxcode) {
                        i = this.codetab;
                        r6 = this.free_ent;
                        this.free_ent = r6 + 1;
                        i[i5] = r6;
                        this.htab[i5] = i4;
                    } else {
                        cl_block(outputStream);
                    }
                    i = nextPixel;
                } else {
                    output(i, outputStream);
                    if (this.free_ent >= this.maxmaxcode) {
                        cl_block(outputStream);
                    } else {
                        i = this.codetab;
                        r6 = this.free_ent;
                        this.free_ent = r6 + 1;
                        i[i5] = r6;
                        this.htab[i5] = i4;
                    }
                    i = nextPixel;
                }
            } else {
                output(i, outputStream);
                output(this.EOFCode, outputStream);
                return;
            }
        }
    }

    void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    void flush_char(OutputStream outputStream) throws IOException {
        if (this.a_count > 0) {
            outputStream.write(this.a_count);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    private int nextPixel() {
        if (this.remaining == 0) {
            return -1;
        }
        this.remaining--;
        byte[] bArr = this.pixAry;
        int i = this.curPixel;
        this.curPixel = i + 1;
        return bArr[i] & 255;
    }

    void output(int i, OutputStream outputStream) throws IOException {
        this.cur_accum &= this.masks[this.cur_bits];
        if (this.cur_bits > 0) {
            this.cur_accum |= i << this.cur_bits;
        } else {
            this.cur_accum = i;
        }
        this.cur_bits += this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i2 = this.g_init_bits;
                this.n_bits = i2;
                this.maxcode = MAXCODE(i2);
                this.clear_flg = false;
            } else {
                this.n_bits++;
                if (this.n_bits == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(this.n_bits);
                }
            }
        }
        if (i == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
