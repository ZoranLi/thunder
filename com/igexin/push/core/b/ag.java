package com.igexin.push.core.b;

import android.content.ContentValues;
import com.igexin.push.b.d;
import com.igexin.push.core.f;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

class ag extends d {
    final /* synthetic */ ContentValues a;
    final /* synthetic */ af b;

    ag(af afVar, ContentValues contentValues) {
        this.b = afVar;
        this.a = contentValues;
    }

    public void a() {
        f.a().k().a(SocializeProtocolConstants.PROTOCOL_KEY_ST, this.a);
        this.b.d = this.b.d + 1;
    }
}
