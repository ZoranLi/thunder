package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.umeng.message.entity.UMessage;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.GetuiADPushBiz;
import com.xunlei.downloadprovider.pushmessage.c.a;
import org.json.JSONObject;

/* compiled from: PushResultDispatcher */
public final class h {
    private static SimpleTarget<Bitmap> a;

    public static void a(Context context, String str, String str2) {
        a(context, str, str, 1, str2);
    }

    public static void b(Context context, String str, String str2) {
        try {
            a(context, str, new UMessage(new JSONObject(str)).custom, 2, str2);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void c(Context context, String str, String str2) {
        a(context, str, str, 3, str2);
    }

    private static void a(Context context, String str, String str2, int i, String str3) {
        try {
            b(context, n.a(new PushOriginalInfo(i, str, str2, str3, false)));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        a(context, str, str2, 4, str3);
    }

    private static void b(Context context, BasePushBiz basePushBiz) {
        a.a(context, basePushBiz);
        XLThreadPool.sendCommand(new i(basePushBiz), new j(basePushBiz, context));
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            intent = null;
        } else {
            intent = new GetuiADPushBiz(intent);
        }
        if (intent != null) {
            b(context, intent);
        }
    }

    static /* synthetic */ void a(Context context, BasePushBiz basePushBiz) {
        String validBigPic = basePushBiz.getInfo().getValidBigPic();
        a = new k(context, basePushBiz);
        Glide.with(BrothersApplication.getApplicationInstance()).load(validBigPic).asBitmap().diskCacheStrategy((DiskCacheStrategy) DiskCacheStrategy.ALL).dontAnimate().dontTransform().into((Target) a);
    }
}
