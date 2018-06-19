package com.baidu.mobads.production;

import com.baidu.mobads.c.a;
import com.baidu.mobads.g.g.c;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.utils.l;

class k implements c {
    final /* synthetic */ b a;

    k(b bVar) {
        this.a = bVar;
    }

    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader) {
                    z = BaiduXAdSDKContext.mApkLoader.h();
                    b.a = z;
                    if (z) {
                        this.a.r();
                        return;
                    }
                }
            } catch (Throwable e) {
                l.a().e(e);
                a a = a.a();
                StringBuilder stringBuilder = new StringBuilder("async apk on load exception: ");
                stringBuilder.append(e.toString());
                a.a(stringBuilder.toString());
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = false;
        this.a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR));
    }
}
