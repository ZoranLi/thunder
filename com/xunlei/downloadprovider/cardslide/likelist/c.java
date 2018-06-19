package com.xunlei.downloadprovider.cardslide.likelist;

import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.cardslide.likelist.c.c.a;
import java.util.List;

/* compiled from: CardSlideLikeActivity */
final class c implements a {
    final /* synthetic */ CardSlideLikeActivity a;

    c(CardSlideLikeActivity cardSlideLikeActivity) {
        this.a = cardSlideLikeActivity;
    }

    public final void a(List<com.xunlei.downloadprovider.cardslide.likelist.c.a> list) {
        Message obtain = Message.obtain();
        obtain.what = SecExceptionCode.SEC_ERROE_OPENSDK_DECODE_FAILED;
        obtain.obj = list;
        this.a.g.sendMessage(obtain);
    }

    public final void a() {
        this.a.g.sendEmptyMessage(SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH);
    }
}
