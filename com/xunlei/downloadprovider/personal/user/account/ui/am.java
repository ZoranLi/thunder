package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.downloadprovider.member.login.b.e.j;
import com.xunlei.downloadprovider.personal.user.account.l;

/* compiled from: UserAccountSecurityActivity */
final class am implements j {
    final /* synthetic */ UserAccountSecurityActivity a;

    am(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void a(XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr) {
        xLBindedOtherAccountItemArr = UserAccountSecurityActivity.a(xLBindedOtherAccountItemArr);
        for (int i = 0; i < 3; i++) {
            XLBindedOtherAccountItem xLBindedOtherAccountItem = xLBindedOtherAccountItemArr[i];
            int i2 = xLBindedOtherAccountItem.mThirdTypeId;
            if (i2 == 1) {
                this.a.o = xLBindedOtherAccountItem.mThirdRelationship;
                this.a.a(this.a.j, this.a.o);
                UserAccountSecurityActivity.a(this.a.g, this.a.o);
            } else if (i2 == 15) {
                this.a.n = xLBindedOtherAccountItem.mThirdRelationship;
                this.a.a(this.a.i, this.a.n);
                UserAccountSecurityActivity.a(this.a.f, this.a.n);
            } else if (i2 == 21) {
                this.a.m = xLBindedOtherAccountItem.mThirdRelationship;
                this.a.a(this.a.h, this.a.m);
                UserAccountSecurityActivity.a(this.a.e, this.a.m);
            }
            if (xLBindedOtherAccountItem.mThirdRelationship != -1) {
                this.a.a(xLBindedOtherAccountItem.mThirdTypeId, l.a().b(xLBindedOtherAccountItem.mThirdTypeId));
            }
            l.a().a(xLBindedOtherAccountItem.mThirdTypeId, xLBindedOtherAccountItem.mThirdRelationship);
        }
    }
}
