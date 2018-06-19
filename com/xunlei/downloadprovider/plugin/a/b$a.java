package com.xunlei.downloadprovider.plugin.a;

import com.xunlei.a.c.a;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: IThunderMemberFacadeImpl */
class b$a extends c {
    a a;
    String b;

    b$a(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (this.a != null) {
            try {
                this.a.a(z, i, this.b);
            } catch (boolean z2) {
                z2.printStackTrace();
            }
        }
    }
}
