package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM.a;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class GDTAD {
    private static boolean a = false;
    private static InitListener b;
    private static a c = new a() {
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        public final void onLoadSuccess() {
            GDTAD.a = true;
            if (GDTAD.b != null) {
                GDTAD.b.onSuccess();
            }
        }
    };

    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            b = initListener;
            GDTADManager instance = GDTADManager.getInstance();
            instance.setPluginLoadListener$17b1f8f6(c);
            instance.initWith(context.getApplicationContext(), str);
        }
    }
}
