package com.xiaomi.push.protobuf;

import com.google.protobuf.micro.b;
import com.google.protobuf.micro.c;
import com.google.protobuf.micro.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    public static final class a extends e {
        private boolean a;
        private int b = 0;
        private boolean c;
        private boolean d = false;
        private boolean e;
        private int f = 0;
        private boolean g;
        private boolean h = false;
        private List<String> i = Collections.emptyList();
        private int j = -1;

        public static a b(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a c(b bVar) {
            return new a().b(bVar);
        }

        public final int a() {
            if (this.j < 0) {
                b();
            }
            return this.j;
        }

        public final /* synthetic */ e a(b bVar) {
            return b(bVar);
        }

        public final a a(int i) {
            this.a = true;
            this.b = i;
            return this;
        }

        public final a a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.i.isEmpty()) {
                this.i = new ArrayList();
            }
            this.i.add(str);
            return this;
        }

        public final a a(boolean z) {
            this.c = true;
            this.d = z;
            return this;
        }

        public final void a(c cVar) {
            if (e()) {
                cVar.b(1, d());
            }
            if (g()) {
                cVar.a(2, f());
            }
            if (i()) {
                cVar.a(3, h());
            }
            if (k()) {
                cVar.a(4, j());
            }
            for (String a : l()) {
                cVar.a(5, a);
            }
        }

        public final int b() {
            int i = 0;
            int d = e() ? c.d(1, d()) + 0 : 0;
            if (g()) {
                d += c.b(2, f());
            }
            if (i()) {
                d += c.c(3, h());
            }
            if (k()) {
                d += c.b(4, j());
            }
            for (String b : l()) {
                i += c.b(b);
            }
            d = (d + i) + (1 * l().size());
            this.j = d;
            return d;
        }

        public final a b(int i) {
            this.e = true;
            this.f = i;
            return this;
        }

        public final a b(b bVar) {
            while (true) {
                int a = bVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(bVar.i());
                } else if (a == 16) {
                    a(bVar.f());
                } else if (a == 24) {
                    b(bVar.e());
                } else if (a == 32) {
                    b(bVar.f());
                } else if (a == 42) {
                    a(bVar.g());
                } else if (!a(bVar, a)) {
                    return this;
                }
            }
        }

        public final a b(boolean z) {
            this.g = true;
            this.h = z;
            return this;
        }

        public final int d() {
            return this.b;
        }

        public final boolean e() {
            return this.a;
        }

        public final boolean f() {
            return this.d;
        }

        public final boolean g() {
            return this.c;
        }

        public final int h() {
            return this.f;
        }

        public final boolean i() {
            return this.e;
        }

        public final boolean j() {
            return this.h;
        }

        public final boolean k() {
            return this.g;
        }

        public final List<String> l() {
            return this.i;
        }

        public final int m() {
            return this.i.size();
        }
    }
}
