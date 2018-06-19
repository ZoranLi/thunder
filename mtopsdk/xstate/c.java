package mtopsdk.xstate;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;

public final class c {
    private static ConcurrentHashMap a = null;
    private static Context b = null;
    private static volatile boolean c = false;
    private static Lock d = new ReentrantLock();

    public static String a(String str) {
        return (a == null || str == null) ? null : (String) a.get(str);
    }

    public static void a() {
        if (c) {
            d.lock();
            try {
                if (c) {
                    if (a != null) {
                        a.clear();
                        a = null;
                    }
                    if (b == null) {
                        j.e("[unInit]static field context in Class XState is null.");
                    } else {
                        c = false;
                        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                            StringBuilder stringBuilder = new StringBuilder("[unInit] uninit XState OK,isInit=");
                            stringBuilder.append(c);
                            j.b(stringBuilder.toString());
                        }
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder2 = new StringBuilder("[unInit] unInit error --");
                stringBuilder2.append(e.toString());
                j.e(stringBuilder2.toString());
            } catch (Throwable th) {
                d.unlock();
            }
            d.unlock();
        }
    }

    public static void a(Context context) {
        if (!c) {
            d.lock();
            try {
                if (!c) {
                    if (context == null) {
                        j.e("[checkInit]parameter context for init(Context context) is null.");
                    } else {
                        if (a == null) {
                            a = new ConcurrentHashMap();
                        }
                        b = context;
                        c = true;
                        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                            StringBuilder stringBuilder = new StringBuilder("[checkInit] init XState OK,isInit=");
                            stringBuilder.append(c);
                            j.b(stringBuilder.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                d.unlock();
            }
            d.unlock();
        }
    }

    public static void a(String str, String str2) {
        StringBuilder stringBuilder;
        if (a != null && str != null && str2 != null) {
            a.put(str, str2);
            if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
                stringBuilder = new StringBuilder("[setValue]set  XstateID succeed,");
                stringBuilder.append(str);
                stringBuilder.append("=");
                stringBuilder.append(str2);
                j.a(stringBuilder.toString());
            }
        } else if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
            stringBuilder = new StringBuilder("[setValue]set  XstateID failed,key=");
            stringBuilder.append(str);
            stringBuilder.append(",value=");
            stringBuilder.append(str2);
            j.a(stringBuilder.toString());
        }
    }

    public static String b(String str) {
        if (a == null || str == null) {
            return null;
        }
        if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
            StringBuilder stringBuilder = new StringBuilder("remove Xstate key=");
            stringBuilder.append(str);
            j.a(stringBuilder.toString());
        }
        return (String) a.remove(str);
    }
}
