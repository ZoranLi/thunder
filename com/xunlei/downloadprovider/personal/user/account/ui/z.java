package com.xunlei.downloadprovider.personal.user.account.ui;

import android.os.Bundle;
import com.xunlei.downloadprovider.member.login.b.e.f;
import com.xunlei.downloadprovider.personal.user.b;

/* compiled from: UserAccountMemberActivity */
final class z implements f {
    final /* synthetic */ UserAccountMemberActivity a;

    z(UserAccountMemberActivity userAccountMemberActivity) {
        this.a = userAccountMemberActivity;
    }

    public final void a(int i, long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder("UserInfoActivity() query high speed channel flux status >> ");
        stringBuilder.append(i);
        stringBuilder.append("capacity  >>");
        stringBuilder.append(j);
        stringBuilder.append("remain >>");
        stringBuilder.append(j2);
        if (i == 2 || i == 0) {
            b.a().a("flow_total", j);
            long j3 = j - j2;
            b.a().a("flow_used", j3);
            i = this.a.r.obtainMessage(101);
            j2 = new Bundle(2);
            j2.putLong("flowtotal", j);
            j2.putLong("flowused", j3);
            i.setData(j2);
            this.a.r.sendMessage(i);
        }
    }
}
