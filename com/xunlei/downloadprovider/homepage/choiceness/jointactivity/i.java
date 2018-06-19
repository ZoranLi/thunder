package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: JointActivityHelper */
final class i implements c<Integer> {
    final /* synthetic */ g a;

    public final void a(b bVar) {
    }

    i(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void a(Object obj) {
        Integer num = (Integer) obj;
        g gVar = this.a;
        boolean z = true;
        obj = num.intValue() == 1 ? 1 : 2;
        if (obj != 1) {
            z = false;
        }
        gVar.b = z;
        gVar.b().edit().putInt(SocializeConstants.TENCENT_UID, obj).apply();
        this.a.a();
    }
}
