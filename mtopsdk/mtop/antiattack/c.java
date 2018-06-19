package mtopsdk.mtop.antiattack;

import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.g;

public final class c {
    private static ConcurrentHashMap a = new ConcurrentHashMap();

    private static long a(String str) {
        g.a();
        long a = g.a(str);
        if (a > 0) {
            return a;
        }
        g.a();
        a = g.d();
        return a > 0 ? a : 10;
    }

    private static String a(long j, f fVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", currentTime=");
        stringBuilder.append(j);
        StringBuilder stringBuilder2 = new StringBuilder(", lockentity=");
        stringBuilder2.append(fVar.toString());
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }

    public static boolean a(String str, long j) {
        boolean z = false;
        if (i.b(str)) {
            return false;
        }
        f fVar = (f) a.get(str);
        if (fVar != null) {
            if (Math.abs(j - fVar.b) < fVar.c) {
                z = true;
            } else {
                a.remove(str);
                if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                    StringBuilder stringBuilder = new StringBuilder("[unLock]apiKey=");
                    stringBuilder.append(str);
                    j.c(stringBuilder.toString());
                }
            }
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder2 = new StringBuilder("[iSApiLocked] isLocked=");
                stringBuilder2.append(z);
                stringBuilder2.append(", ");
                stringBuilder2.append(a(j, fVar));
                j.c(stringBuilder2.toString());
            }
        }
        return z;
    }

    public static void b(String str, long j) {
        if (!i.b(str)) {
            f fVar = (f) a.get(str);
            if (fVar == null) {
                f fVar2 = new f(str, j, a(str));
            } else {
                fVar.b = j;
                fVar.c = a(str);
            }
            a.put(str, fVar);
            if (j.a(TBSdkLog$LogEnable.WarnEnable)) {
                StringBuilder stringBuilder = new StringBuilder("[lock]");
                stringBuilder.append(a(j, fVar));
                j.c(stringBuilder.toString());
            }
        }
    }
}
