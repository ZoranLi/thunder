package com.xiaomi.mipush.sdk;

class s implements Runnable {
    final /* synthetic */ MiTinyDataClient$a$a a;

    s(MiTinyDataClient$a$a miTinyDataClient$a$a) {
        this.a = miTinyDataClient$a$a;
    }

    public void run() {
        if (this.a.a.size() != 0) {
            this.a.b();
            return;
        }
        if (this.a.d != null) {
            this.a.d.cancel(false);
            this.a.d = null;
        }
    }
}
