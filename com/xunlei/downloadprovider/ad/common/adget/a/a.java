package com.xunlei.downloadprovider.ad.common.adget.a;

import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.h;
import com.xunlei.xllib.android.d;
import java.lang.reflect.Field;

/* compiled from: BaiduNavLoader */
public final class a implements h {
    private String a;
    private Context b;

    public a(Context context, String str) {
        this.b = context;
        this.a = str;
    }

    public final void a(com.xunlei.downloadprovider.ad.common.h.a aVar, String str) {
        StringBuilder stringBuilder = new StringBuilder("loadBaiDuAD positionId: ");
        stringBuilder.append(str);
        stringBuilder.append(" baiduId: ");
        stringBuilder.append(this.a);
        boolean z = false;
        try {
            Field field = Class.forName("com.xunlei.downloadprovider.d.e$a$a").getField("baiduBlocked");
            if (field != null) {
                z = field.getBoolean(null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        if (z) {
            aVar.a(-8888, "baidu block close");
            return;
        }
        BaiduNative baiduNative = new BaiduNative(this.b, this.a, new b(this, aVar, str));
        if (THUNDER_AD_INFO.HOME_POS0.mPositionId.equals(str) == null && THUNDER_AD_INFO.HOME_POS1.mPositionId.equals(str) == null && THUNDER_AD_INFO.HOME_POS_EXTRA.mPositionId.equals(str) == null) {
            if (THUNDER_AD_INFO.HOME_RELOAD.mPositionId.equals(str) == null) {
                baiduNative.makeRequest();
                return;
            }
        }
        baiduNative.makeRequest(new Builder().setWidth((int) (1135017984 * d.f(com.xunlei.downloadprovider.ad.a.a()))).setHeight((int) (1127940096 * d.f(com.xunlei.downloadprovider.ad.a.a()))).build());
    }
}
