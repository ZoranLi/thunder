package com.xunlei.tdlive.modal;

import com.xunlei.tdlive.protocol.XLLiveGetPKIndexList;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.util.j;
import com.xunlei.tdlive.util.k;

/* compiled from: PKBannerProvider */
public class d {
    private static d a;
    private k<a> b = new k();
    private j c;
    private Runnable d = new Runnable(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public void run() {
            new XLLiveGetPKIndexList(0, 3).send(new JsonCallBack(this) {
                final /* synthetic */ AnonymousClass1 a;

                {
                    this.a = r1;
                }

                public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                    if (i == 0 && this.a.a.b != 0) {
                        this.a.a.b.a(new com.xunlei.tdlive.util.k.a<a>(this) {
                            final /* synthetic */ AnonymousClass1 a;

                            {
                                this.a = r1;
                            }

                            public void a(a aVar, Object... objArr) {
                                aVar.onDataChanged((JsonWrapper) objArr[0]);
                            }
                        }, jsonWrapper.getArray("data", "[]"));
                    }
                }
            });
        }
    };

    /* compiled from: PKBannerProvider */
    public interface a {
        void onDataChanged(JsonWrapper jsonWrapper);
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private d() {
    }

    public void a(a aVar) {
        this.b.a(aVar);
    }

    public void b(a aVar) {
        this.b.b(aVar);
    }

    public void b() {
        if (this.c == null) {
            this.c = new j(com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, this.d);
        }
        this.c.c();
        this.c.d();
    }

    public void c() {
        if (this.c != null) {
            this.c.b();
        }
    }
}
