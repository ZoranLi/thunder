package com.xunlei.downloadprovider.contentpublish.website;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.android.volley.Request;

/* compiled from: WebsitePublishActivity */
final class ay implements OnDismissListener {
    final /* synthetic */ WebsitePublishActivity a;

    ay(WebsitePublishActivity websitePublishActivity) {
        this.a = websitePublishActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface = az.a();
        CharSequence charSequence = this.a.c.a;
        if (!TextUtils.isEmpty(charSequence)) {
            Request request = (Request) dialogInterface.b.get(charSequence);
            if (request != null) {
                request.cancel();
                dialogInterface.b.remove(charSequence);
            }
        }
    }
}
