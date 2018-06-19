package com.xunlei.downloadprovider.ad.recommend;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.NonNull;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.List;

/* compiled from: IRecommendAdContract */
public interface a {

    /* compiled from: IRecommendAdContract */
    public interface a extends com.xunlei.downloadprovider.ad.recommend.b.a<b> {
        void a();

        void a(l lVar, View view, int i);

        void b();
    }

    /* compiled from: IRecommendAdContract */
    public interface b extends com.xunlei.downloadprovider.ad.recommend.view.a {
        void a();

        void a(int i);

        void a(@NonNull OnClickListener onClickListener, @NonNull OnClickListener onClickListener2);

        void a(String str);

        void a(boolean z);

        boolean a(List<l> list);

        int b();

        void c();

        void d();

        boolean e();

        Context getContext();
    }
}
