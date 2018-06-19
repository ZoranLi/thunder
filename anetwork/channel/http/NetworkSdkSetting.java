package anetwork.channel.http;

import android.app.Application;
import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anetwork.channel.a.b;
import anetwork.channel.monitor.a;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
public class NetworkSdkSetting implements Serializable {
    public static ENV CURRENT_ENV = ENV.ONLINE;
    private static final String TAG = "ANet.NetworkSdkSetting";
    private static Context context;
    private static AtomicBoolean isInit = new AtomicBoolean(false);

    public static void init(Context context) {
        if (context != null) {
            try {
                if (isInit.compareAndSet(false, true)) {
                    context = context;
                    SessionCenter.init(context);
                    a.a();
                    b.a();
                    anetwork.channel.b.a.a(context);
                }
            } catch (Context context2) {
                ALog.e(TAG, "Network SDK initial failed!", null, context2, new Object[0]);
            }
        }
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
        try {
            GlobalAppRuntimeInfo.setTtid((String) hashMap.get(Constants.KEY_TTID));
            init(application.getApplicationContext());
        } catch (Application application2) {
            ALog.e(TAG, "Network SDK initial failed!", null, application2, new Object[0]);
        }
    }

    public static void setTtid(String str) {
        GlobalAppRuntimeInfo.setTtid(str);
    }

    public static Context getContext() {
        return context;
    }
}
