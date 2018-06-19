package com.baidu.android.common.security;

public class RC4 {
    private static final int STATE_LENGTH = 256;
    private byte[] engineState = null;
    private byte[] workingKey = null;
    private int x = 0;
    private int y = 0;

    public RC4(String str) {
        this.workingKey = str.getBytes();
    }

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        } else if (i3 + i2 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                this.x = (this.x + 1) & 255;
                this.y = (this.engineState[this.x] + this.y) & 255;
                byte b = this.engineState[this.x];
                this.engineState[this.x] = this.engineState[this.y];
                this.engineState[this.y] = b;
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ this.engineState[(this.engineState[this.x] + this.engineState[this.y]) & 255]);
            }
        }
    }

    private void reset() {
        setKey(this.workingKey);
    }

    private void setKey(byte[] bArr) {
        int i;
        int i2 = 0;
        this.x = 0;
        this.y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (i = 0; i < 256; i++) {
            this.engineState[i] = (byte) i;
        }
        i = 0;
        int i3 = i;
        while (i2 < 256) {
            i3 = (((bArr[i] & 255) + this.engineState[i2]) + i3) & 255;
            byte b = this.engineState[i2];
            this.engineState[i2] = this.engineState[i3];
            this.engineState[i3] = b;
            i = (i + 1) % bArr.length;
            i2++;
        }
    }

    public byte[] decrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public byte[] encrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }
}
