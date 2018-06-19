package com.xunlei.common.new_ptl.pay.b.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.a.i;
import org.apache.http.Header;

/* compiled from: AsyncHttpProxy */
public class a {
    private static final String a;
    private static final a b = new a();
    private boolean c = false;
    private Context d = null;

    /* compiled from: AsyncHttpProxy */
    class a {
        private byte[] a = null;
        private Header[] b = null;
        private int c = 0;
        private b d = null;
        private String e;
        private /* synthetic */ a f;

        static /* synthetic */ int b(a aVar) {
            int i = aVar.c + 1;
            aVar.c = i;
            return i;
        }

        public a(a aVar) {
            this.f = aVar;
        }

        public final void a(byte[] bArr) {
            this.a = bArr;
        }

        public final void a(Header[] headerArr) {
            this.b = headerArr;
        }

        public final void a(b bVar) {
            this.d = bVar;
        }

        public final void a(@NonNull String str) {
            this.e = str;
        }

        private void b() {
            String b = a.a;
            StringBuilder stringBuilder = new StringBuilder("xunlei pay request count = ");
            stringBuilder.append(this.c + 1);
            XLLog.v(b, stringBuilder.toString());
            i.a().e().post(this.f.d, this.e, this.b, this.a, new 1(this));
        }

        public final void a() {
            String b = a.a;
            StringBuilder stringBuilder = new StringBuilder("xunlei pay request count = ");
            stringBuilder.append(this.c + 1);
            XLLog.v(b, stringBuilder.toString());
            i.a().e().post(this.f.d, this.e, this.b, this.a, new 1(this));
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.class.getSimpleName());
        stringBuilder.append("Pay");
        a = stringBuilder.toString();
    }

    private a() {
    }

    public final void a(Context context) {
        if (!this.c) {
            this.c = true;
            this.d = context;
        }
    }

    private void c() {
        if (this.c) {
            this.c = false;
        }
    }

    public static a a() {
        return b;
    }

    public final void a(String str, byte[] bArr, Header[] headerArr, b bVar) {
        a aVar = new a(this);
        aVar.a(str);
        aVar.a(bArr);
        aVar.a(headerArr);
        aVar.a(bVar);
        aVar.a();
    }
}
