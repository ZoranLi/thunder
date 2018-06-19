package mtopsdk.mtop.a;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.taobao.tao.remotebusiness.listener.c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.a.b;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.unit.ApiUnit;
import mtopsdk.mtop.util.e;
import mtopsdk.xstate.a;

public final class d {
    static c a;
    static String b;
    private static final d c = new d();
    private static EnvModeEnum d = EnvModeEnum.ONLINE;
    private static Context e;
    private static int f;
    private static int g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static volatile ApiUnit l;
    private static b n = new b(e.a());
    private Lock m = new ReentrantLock();

    private d() {
    }

    public static d a() {
        return c;
    }

    public static Context b() {
        return e;
    }

    public static c c() {
        return a;
    }

    public static int d() {
        return f;
    }

    public static String e() {
        return b;
    }

    public static String f() {
        return k;
    }

    public static String g() {
        return h;
    }

    public static EnvModeEnum h() {
        return d;
    }

    public static String i() {
        return j;
    }

    public static ApiUnit j() {
        return l;
    }

    public static b k() {
        return n;
    }

    public final d a(Context context) {
        if (context != null) {
            e = context.getApplicationContext();
        }
        return this;
    }

    public final d a(String str) {
        i = str;
        a.a(Constants.KEY_TTID, str);
        return this;
    }

    public final d a(ApiUnit apiUnit) {
        if (apiUnit == null) {
            return this;
        }
        this.m.lock();
        StringBuilder stringBuilder;
        try {
            l = apiUnit;
            if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                stringBuilder = new StringBuilder("[setGlobalApiUnit] set apiUnit succeed,apiUnit=");
                stringBuilder.append(apiUnit.toString());
                j.a(stringBuilder.toString());
            }
        } catch (Exception e) {
            stringBuilder = new StringBuilder("[setGlobalApiUnit] set apiUnit error ---");
            stringBuilder.append(e.toString());
            j.e(stringBuilder.toString());
        } catch (Throwable th) {
            this.m.unlock();
        }
        this.m.unlock();
        return this;
    }
}
