package com.xunlei.downloadprovider.contentpublish.website;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.a.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: WebsiteDetailFragment */
final class aj implements OnClickListener {
    final /* synthetic */ WebsiteDetailFragment a;

    aj(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i = this.a.al.getKind();
        String str = this.a.i.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.al.getUid());
        String stringBuilder2 = stringBuilder.toString();
        String str2 = (i == 0 || !i.contentEquals("per")) ? "channel" : "personal";
        String str3 = str2;
        String str4 = "discuss_result";
        LoginHelper.a();
        boolean c = l.c();
        boolean z = this.a.j != null && this.a.j.b;
        a.a(str, stringBuilder2, str3, str4, c, z);
        LoginHelper.a();
        if (l.c()) {
            dialogInterface.dismiss();
            this.a.c("discuss_result");
            return;
        }
        str2 = this.a.i.a;
        dialogInterface = new StringBuilder();
        dialogInterface.append(this.a.al.getUid());
        str = dialogInterface.toString();
        dialogInterface = (i == 0 || i.contentEquals("per") == null) ? "channel" : "personal";
        LoginHelper.a();
        a.a(str2, str, (String) dialogInterface, "discuss_result", l.c(), "skip_login", "");
        this.a.Z.a(this.a.mActivity, new ak(this), LoginFrom.VIDEO_DETAIL_FOLLOW, null);
    }
}
