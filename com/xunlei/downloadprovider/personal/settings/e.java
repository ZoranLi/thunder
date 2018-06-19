package com.xunlei.downloadprovider.personal.settings;

import android.content.DialogInterface.OnClickListener;

/* compiled from: AboutBoxActivity */
final class e implements OnClickListener {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onClick(android.content.DialogInterface r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2.dismiss();
        r2 = "tel:4001111000";	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2 = android.net.Uri.parse(r2);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r3 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r0 = "android.intent.action.DIAL";	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r3.<init>(r0, r2);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2 = r1.a;	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2 = r2.a;	 Catch:{ ActivityNotFoundException -> 0x0018 }
        r2.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x0018 }
        return;
    L_0x0018:
        r2 = r1.a;
        r2 = r2.a;
        r2 = r2.getApplicationContext();
        r3 = "拨号失败!";
        com.xunlei.common.commonview.XLToast.showToast(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.settings.e.onClick(android.content.DialogInterface, int):void");
    }
}
