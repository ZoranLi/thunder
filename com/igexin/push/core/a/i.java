package com.igexin.push.core.a;

import android.content.Intent;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import com.igexin.push.f.b.h;
import com.igexin.sdk.GActivity;

class i extends h {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    i(f fVar, long j, String str, String str2) {
        this.c = fVar;
        this.a = str;
        this.b = str2;
        super(j);
    }

    protected void a() {
        Object obj = null;
        try {
            Intent intent = new Intent();
            intent.setClassName(this.a, GActivity.TAG);
            intent.setFlags(268435456);
            g.f.startActivity(intent);
            obj = 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.l);
            stringBuilder.append("|startActivity success pkg = ");
            stringBuilder.append(this.a);
            stringBuilder.append(" activityName = com.igexin.sdk.GActivity");
            a.b(stringBuilder.toString());
        } catch (Exception e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.l);
            stringBuilder2.append("|startActivity exception pkg = ");
            stringBuilder2.append(this.a);
            stringBuilder2.append(" activityName = com.igexin.sdk.GActivity ");
            stringBuilder2.append(e.toString());
            a.b(stringBuilder2.toString());
        }
        if (obj == null) {
            f.a(this.c, this.a, this.b);
        }
    }

    public int b() {
        return 0;
    }
}
