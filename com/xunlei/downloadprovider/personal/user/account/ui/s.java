package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.downloadprovider.member.login.b.e.j;
import com.xunlei.downloadprovider.personal.user.account.l;

/* compiled from: UserAccountInfoActivity */
final class s implements j {
    final /* synthetic */ UserAccountInfoActivity a;

    s(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void a(XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr) {
        for (XLBindedOtherAccountItem xLBindedOtherAccountItem : xLBindedOtherAccountItemArr) {
            if (xLBindedOtherAccountItem.mThirdTypeId == 21) {
                this.a.s = xLBindedOtherAccountItem.mThirdRelationship;
                this.a.a(this.a.s);
            }
            l.a().a(xLBindedOtherAccountItem.mThirdTypeId, xLBindedOtherAccountItem.mThirdRelationship);
        }
    }
}
