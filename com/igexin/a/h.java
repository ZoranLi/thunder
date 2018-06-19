package com.igexin.a;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class h {
    protected final Set<String> a;
    protected final e b;
    protected final d c;
    protected boolean d;
    protected boolean e;
    protected g f;

    protected h() {
        this(new j(), new a());
    }

    protected h(e eVar, d dVar) {
        this.a = new HashSet();
        if (eVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (dVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        } else {
            this.b = eVar;
            this.c = dVar;
        }
    }

    private void c(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
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
        r11 = this;
        r0 = r11.a;
        r0 = r0.contains(r13);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0018;
    L_0x000a:
        r0 = r11.d;
        if (r0 != 0) goto L_0x0018;
    L_0x000e:
        r12 = "%s already loaded previously!";
        r14 = new java.lang.Object[r2];
        r14[r1] = r13;
        r11.a(r12, r14);
        return;
    L_0x0018:
        r0 = 2;
        r3 = r11.b;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3.a(r13);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3 = r11.a;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3.add(r13);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r3 = "%s (%s) was loaded normally!";	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4 = new java.lang.Object[r0];	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4[r1] = r13;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r4[r2] = r14;	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        r11.a(r3, r4);	 Catch:{ UnsatisfiedLinkError -> 0x002f }
        return;
    L_0x002f:
        r3 = move-exception;
        r4 = "Loading the library normally failed: %s";
        r5 = new java.lang.Object[r2];
        r3 = android.util.Log.getStackTraceString(r3);
        r5[r1] = r3;
        r11.a(r4, r5);
        r3 = "%s (%s) was not loaded normally, re-linking...";
        r4 = new java.lang.Object[r0];
        r4[r1] = r13;
        r4[r2] = r14;
        r11.a(r3, r4);
        r3 = r11.a(r12, r13, r14);
        r4 = r3.exists();
        if (r4 == 0) goto L_0x0056;
    L_0x0052:
        r4 = r11.d;
        if (r4 == 0) goto L_0x007c;
    L_0x0056:
        r4 = r11.d;
        if (r4 == 0) goto L_0x0065;
    L_0x005a:
        r4 = "Forcing a re-link of %s (%s)...";
        r5 = new java.lang.Object[r0];
        r5[r1] = r13;
        r5[r2] = r14;
        r11.a(r4, r5);
    L_0x0065:
        r11.b(r12, r13, r14);
        r5 = r11.c;
        r4 = r11.b;
        r7 = r4.a();
        r4 = r11.b;
        r8 = r4.c(r13);
        r6 = r12;
        r9 = r3;
        r10 = r11;
        r5.a(r6, r7, r8, r9, r10);
    L_0x007c:
        r4 = r11.e;	 Catch:{ IOException -> 0x00a3 }
        if (r4 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a3 }
    L_0x0080:
        r4 = new com.igexin.a.a.j;	 Catch:{ IOException -> 0x00a3 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x00a3 }
        r4 = r4.b();	 Catch:{ IOException -> 0x00a3 }
        r4 = r4.iterator();	 Catch:{ IOException -> 0x00a3 }
    L_0x008d:
        r5 = r4.hasNext();	 Catch:{ IOException -> 0x00a3 }
        if (r5 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a3 }
    L_0x0093:
        r5 = r4.next();	 Catch:{ IOException -> 0x00a3 }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x00a3 }
        r6 = r11.b;	 Catch:{ IOException -> 0x00a3 }
        r5 = r6.d(r5);	 Catch:{ IOException -> 0x00a3 }
        r11.a(r12, r5);	 Catch:{ IOException -> 0x00a3 }
        goto L_0x008d;
    L_0x00a3:
        r12 = r11.b;
        r3 = r3.getAbsolutePath();
        r12.b(r3);
        r12 = r11.a;
        r12.add(r13);
        r12 = "%s (%s) was re-linked!";
        r0 = new java.lang.Object[r0];
        r0[r1] = r13;
        r0[r2] = r14;
        r11.a(r12, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.h.c(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public h a() {
        this.d = true;
        return this;
    }

    public h a(g gVar) {
        this.f = gVar;
        return this;
    }

    protected File a(Context context) {
        return context.getDir(ShareConstants.SO_PATH, 0);
    }

    protected File a(Context context, String str, String str2) {
        str = this.b.c(str);
        if (k.a(str2)) {
            return new File(a(context), str);
        }
        File a = a(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        return new File(a, stringBuilder.toString());
    }

    public void a(Context context, String str) {
        a(context, str, null, null);
    }

    public void a(Context context, String str, String str2, f fVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (k.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            a("Beginning load of %s...", str);
            if (fVar == null) {
                c(context, str, str2);
                return;
            }
            try {
                c(context, str, str2);
                fVar.a();
            } catch (Throwable e) {
                fVar.a(e);
            }
        }
    }

    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    public void a(String str, Object... objArr) {
        a(String.format(Locale.US, str, objArr));
    }

    public h b() {
        this.e = true;
        return this;
    }

    protected void b(Context context, String str, String str2) {
        File a = a(context);
        File a2 = a(context, str, str2);
        File[] listFiles = a.listFiles(new i(this, this.b.c(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.d || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
