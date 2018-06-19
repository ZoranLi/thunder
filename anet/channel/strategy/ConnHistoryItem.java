package anet.channel.strategy;

import java.io.Serializable;

/* compiled from: Taobao */
class ConnHistoryItem implements Serializable {
    byte a = (byte) 0;
    long b = 0;
    long c = 0;

    ConnHistoryItem() {
    }

    void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z ? this.b : this.c) > 10000) {
            this.a = (byte) ((this.a << 1) | (z ^ 1));
            if (z) {
                this.b = currentTimeMillis;
                return;
            }
            this.c = currentTimeMillis;
        }
    }

    int a() {
        int i = 0;
        for (int i2 = this.a; i2 > 0; i2 >>= 1) {
            i += i2 & 1;
        }
        return i;
    }

    boolean b() {
        return (this.a & 1) == 1;
    }

    boolean c() {
        if (a() >= 3 && System.currentTimeMillis() - this.c <= 300000) {
            return true;
        }
        return false;
    }

    boolean d() {
        long j = this.b > this.c ? this.b : this.c;
        return j != 0 && System.currentTimeMillis() - j > 86400000;
    }
}
