package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.a;

public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        return ax.a(context).a();
    }

    public static boolean canUseYunbo(Context context) {
        return ax.a(context).a() && QbSdk.canUseVideoFeatrue(context, 1);
    }

    public static void openVideo(Context context, String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("videoUrl", str);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.setFlags(268435456);
            intent.setPackage(context.getPackageName());
            intent.putExtra("extraData", bundle);
            context.startActivity(intent);
        }
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, a aVar) {
        return canUseYunbo(context) ? ax.a(context).a(str, bundle, aVar) : false;
    }
}
