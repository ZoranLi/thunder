package com.xunlei.downloadprovider.vodnew.a.e;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vodnew.a.a.a;
import com.xunlei.downloadprovider.vodnew.a.a.a$a;

/* compiled from: PlayerStateInitialized */
final class h implements a$a {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void a(a aVar, String str) {
        String str2 = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.c);
        stringBuilder.append("onFetchPlayUrlComplete, errorCode : ");
        stringBuilder.append(str);
        if (!"0".equals(str)) {
            aVar = a.a;
            aVar = new StringBuilder();
            aVar.append(e.c);
            aVar.append("prepareAsync, 获取播放地址失败, errorCode : ");
            aVar.append(str);
            this.a.b.c(6);
            if (this.a.b.n != null) {
                this.a.b.n.a(this.a.b, 0, 0);
            }
        } else if (TextUtils.isEmpty(aVar.d()) == null) {
            str = a.a;
            str = new StringBuilder();
            str.append(e.c);
            str.append("开始获取播放历史记录，后面一定要有onGetPlayRecordInfo回调");
            if (aVar.a() == null || TextUtils.isEmpty(aVar.a().mLocalFileName) != null) {
                str = aVar.d();
            } else {
                str = aVar.a().mLocalFileName;
            }
            str2 = a.a;
            v.a().a(str, new i(this, aVar), null, true);
        } else {
            aVar = a.a;
            aVar = new StringBuilder();
            aVar.append(e.c);
            aVar.append("prepareAsync, 获取的地址为空, 应该有errorCode的，不应该进入的逻辑");
            this.a.b.c(6);
            if (this.a.b.n != null) {
                this.a.b.n.a(this.a.b, 0, 0);
            }
        }
    }
}
