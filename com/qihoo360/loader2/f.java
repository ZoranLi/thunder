package com.qihoo360.loader2;

import android.os.IBinder;
import com.qihoo360.loader2.j.a;
import com.qihoo360.replugin.g;
import java.io.PrintWriter;

/* compiled from: DumpUtils */
public class f {
    private static final String a = (g.a ? f.class.getSimpleName() : "DumpUtils");

    public static void a(PrintWriter printWriter) {
        IBinder a = ag.a(g.a());
        if (a != null) {
            try {
                String f = a.a(a).f();
                boolean z = g.a;
                if (printWriter != null) {
                    printWriter.println(f);
                }
            } catch (PrintWriter printWriter2) {
                printWriter2.printStackTrace();
            }
        }
    }
}
