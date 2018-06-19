package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth.AuthCallback;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.taobao.accs.net.k.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
class p implements RequestCb {
    final /* synthetic */ Session a;
    final /* synthetic */ AuthCallback b;
    final /* synthetic */ a c;

    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    p(a aVar, Session session, AuthCallback authCallback) {
        this.c = aVar;
        this.a = session;
        this.b = authCallback;
    }

    public void onResponseCode(int i, Map<String, List<String>> map) {
        ALog.e(a.a(this.c), "AUTH", new Object[]{"httpStatusCode", Integer.valueOf(i), "seq", this.a.mSeq});
        if (i == 200) {
            this.b.onAuthSuccess();
        } else {
            this.b.onAuthFail(i, "auth fail");
        }
        String str = (String) UtilityImpl.getHeader(map).get("x-at");
        if (TextUtils.isEmpty(str) == null) {
            a.b(this.c).k = str;
        }
    }

    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
        if (i != 0) {
            ALog.e(a.a(this.c), "AUTH onFinish", new Object[]{"statusCode", Integer.valueOf(i), "seq", this.a.mSeq});
            this.b.onAuthFail(i, "onFinish auth fail");
        }
    }
}
