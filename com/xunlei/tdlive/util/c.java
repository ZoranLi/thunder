package com.xunlei.tdlive.util;

import android.content.Context;
import android.preference.PreferenceManager;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.XLLiveInquireCheckInRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.sdk.b;
import java.util.Calendar;

/* compiled from: DailyCheckHelper */
public class c {
    private static a a = null;
    private static String b = "show_check_in";

    /* compiled from: DailyCheckHelper */
    public interface a {
        void a();
    }

    /* compiled from: DailyCheckHelper */
    final class AnonymousClass1 implements JsonCallBack {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        public final void onResponse(int i, String str, JsonWrapper jsonWrapper) {
            if (i == 0) {
                if (jsonWrapper.getObject("data", "{}").getInt("today_issign", -1) != 0) {
                    c.a(this.a);
                } else if (c.a != 0) {
                    c.a.a();
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        a = aVar;
        if (b(context) != null) {
            new XLLiveInquireCheckInRequest().send(new AnonymousClass1(context));
        }
    }

    public static void a(Context context) {
        context = PreferenceManager.getDefaultSharedPreferences(context).edit();
        int i = Calendar.getInstance().get(5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(b.a().e());
        context.putInt(stringBuilder.toString(), i);
        context.apply();
    }

    public static boolean b(Context context) {
        if (!b.a().b()) {
            return false;
        }
        context = PreferenceManager.getDefaultSharedPreferences(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(b.a().e());
        context = context.getInt(stringBuilder.toString(), 0);
        int i = Calendar.getInstance().get(5);
        if (context != null) {
            if (context == i) {
                return false;
            }
        }
        return true;
    }
}
