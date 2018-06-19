package com.xunlei.downloadprovider.pushmessage.umeng;

import com.umeng.message.PushAgent;
import com.umeng.message.common.inter.ITagManager.Result;
import com.umeng.message.tag.TagManager.TCallBack;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.b.b;
import com.xunlei.downloadprovider.pushmessage.report.a;
import com.xunlei.downloadprovider.pushmessage.report.i;

/* compiled from: UmengPushManager */
final class e implements TCallBack {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onMessage(boolean z, Result result) {
        String str = com.xunlei.downloadprovider.pushmessage.e.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PushAgent.getInstance(BrothersApplication.getApplicationInstance()).getRegistrationId());
        stringBuilder.append(" ,version=527");
        str = stringBuilder.toString();
        if (result != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(" status=");
            stringBuilder2.append(result.status);
            stringBuilder2.append(" errors=");
            stringBuilder2.append(result.errors);
            stringBuilder2.append(" jsonString=");
            stringBuilder2.append(result.jsonString);
            str = stringBuilder2.toString();
        }
        if (z) {
            b.a().a(System.currentTimeMillis());
        }
        result = a.a(BrothersApplication.getApplicationInstance());
        if (com.xunlei.xllib.android.b.a(result.b)) {
            XLThreadPool.execute(new i(result.a, z, str));
        }
    }
}
