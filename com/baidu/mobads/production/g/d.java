package com.baidu.mobads.production.g;

class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void run() {
        a aVar = this.a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.a.A);
        stringBuilder.append(this.a.a.B);
        aVar.f(stringBuilder.toString());
    }
}
