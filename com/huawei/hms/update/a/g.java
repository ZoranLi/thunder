package com.huawei.hms.update.a;

import java.io.File;
import java.io.IOException;

/* compiled from: OtaUpdateDownload */
class g extends h {
    final /* synthetic */ int a;
    final /* synthetic */ f b;
    private long c = null;
    private int d = this.b.e.b();

    g(f fVar, File file, int i, int i2) {
        this.b = fVar;
        this.a = i2;
        super(file, i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
        this.d += i2;
        bArr = System.currentTimeMillis();
        if (Math.abs(bArr - this.c) > 1000) {
            this.c = bArr;
            a(this.d);
        }
        if (this.d == this.a) {
            a(this.d);
        }
    }

    private void a(int i) {
        this.b.e.a(this.b.a(), i);
        this.b.a(2100, i, this.a);
    }
}
