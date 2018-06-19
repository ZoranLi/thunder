package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a;
import com.tencent.bugly.proguard.an;
import java.util.HashMap;

/* compiled from: BUGLY */
final class TraceFileHelper$1 implements TraceFileHelper$b {
    final /* synthetic */ a a;
    final /* synthetic */ boolean b;

    public final boolean a(String str, long j, long j2) {
        return true;
    }

    TraceFileHelper$1(a aVar, boolean z) {
        this.a = aVar;
        this.b = z;
    }

    public final boolean a(String str, int i, String str2, String str3, boolean z) {
        an.c("new thread %s", new Object[]{str});
        if (this.a.a > 0 && this.a.c > 0) {
            if (this.a.b) {
                if (!this.a.d) {
                    this.a.d = new HashMap();
                }
                this.a.d.put(str, new String[]{str2, str3, String.valueOf(i)});
                return true;
            }
        }
        return true;
    }

    public final boolean a(long j, long j2, String str) {
        an.c("new process %s", new Object[]{str});
        if (!str.equals(str)) {
            return true;
        }
        this.a.a = j;
        this.a.b = str;
        this.a.c = j2;
        return this.b != null;
    }

    public final boolean a(long j) {
        an.c("process end %d", new Object[]{Long.valueOf(j)});
        if (this.a.a > 0 && this.a.c > 0) {
            if (this.a.b != null) {
                return false;
            }
        }
        return true;
    }
}
