package com.igexin.sdk.a;

import android.content.Context;
import java.io.File;

public class d {
    private String a;
    private String b;
    private Context c;

    public d(Context context) {
        if (context != null) {
            this.c = context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/run.pid");
            this.a = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/stop.lock");
            this.b = stringBuilder.toString();
        }
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.c();
        if (r0 != 0) goto L_0x0014;
    L_0x0006:
        r0 = r2.a;
        if (r0 == 0) goto L_0x0014;
    L_0x000a:
        r0 = new java.io.File;
        r1 = r2.a;
        r0.<init>(r1);
        r0.createNewFile();	 Catch:{ IOException -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.a.d.a():void");
    }

    public void b() {
        if (c() && this.a != null) {
            new File(this.a).delete();
        }
    }

    public boolean c() {
        File file = null;
        File file2 = this.a != null ? new File(this.a) : null;
        if (this.b != null) {
            file = new File(this.b);
        }
        if (file2 != null && file2.exists()) {
            if (file != null && file.exists()) {
                file.delete();
            }
            return true;
        } else if (file == null || !file.exists() || !file.renameTo(new File(this.a))) {
            return false;
        } else {
            new c(this.c).a();
            return true;
        }
    }
}
