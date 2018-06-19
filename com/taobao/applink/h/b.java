package com.taobao.applink.h;

import android.os.AsyncTask;
import com.taobao.applink.util.f;

class b extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    protected Void a(Void... voidArr) {
        f.a(this.a);
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }
}
