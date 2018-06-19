package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;

/* compiled from: LifecycleRegistry */
final /* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[Event.values().length];
    static final /* synthetic */ int[] b = new int[State.values().length];

    static {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.arch.lifecycle.Lifecycle.State.values();
        r0 = r0.length;
        r0 = new int[r0];
        b = r0;
        r0 = 1;
        r1 = b;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = android.arch.lifecycle.Lifecycle.State.INITIALIZED;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r1 = 2;
        r2 = b;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = android.arch.lifecycle.Lifecycle.State.CREATED;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r2 = 3;
        r3 = b;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = android.arch.lifecycle.Lifecycle.State.STARTED;	 Catch:{ NoSuchFieldError -> 0x002a }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
        r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
    L_0x002a:
        r3 = 4;
        r4 = b;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r5 = android.arch.lifecycle.Lifecycle.State.RESUMED;	 Catch:{ NoSuchFieldError -> 0x0035 }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
        r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
    L_0x0035:
        r4 = 5;
        r5 = b;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r6 = android.arch.lifecycle.Lifecycle.State.DESTROYED;	 Catch:{ NoSuchFieldError -> 0x0040 }
        r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
        r5[r6] = r4;	 Catch:{ NoSuchFieldError -> 0x0040 }
    L_0x0040:
        r5 = android.arch.lifecycle.Lifecycle.Event.values();
        r5 = r5.length;
        r5 = new int[r5];
        a = r5;
        r5 = a;	 Catch:{ NoSuchFieldError -> 0x0053 }
        r6 = android.arch.lifecycle.Lifecycle.Event.ON_CREATE;	 Catch:{ NoSuchFieldError -> 0x0053 }
        r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0053 }
        r5[r6] = r0;	 Catch:{ NoSuchFieldError -> 0x0053 }
    L_0x0053:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x005d }
        r5 = android.arch.lifecycle.Lifecycle.Event.ON_STOP;	 Catch:{ NoSuchFieldError -> 0x005d }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x005d }
        r0[r5] = r1;	 Catch:{ NoSuchFieldError -> 0x005d }
    L_0x005d:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0067 }
        r1 = android.arch.lifecycle.Lifecycle.Event.ON_START;	 Catch:{ NoSuchFieldError -> 0x0067 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0067 }
    L_0x0067:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0071 }
        r1 = android.arch.lifecycle.Lifecycle.Event.ON_PAUSE;	 Catch:{ NoSuchFieldError -> 0x0071 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0071 }
        r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0071 }
    L_0x0071:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x007b }
        r1 = android.arch.lifecycle.Lifecycle.Event.ON_RESUME;	 Catch:{ NoSuchFieldError -> 0x007b }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007b }
        r0[r1] = r4;	 Catch:{ NoSuchFieldError -> 0x007b }
    L_0x007b:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = android.arch.lifecycle.Lifecycle.Event.ON_DESTROY;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
        r2 = 6;	 Catch:{ NoSuchFieldError -> 0x0086 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0086 }
    L_0x0086:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r1 = android.arch.lifecycle.Lifecycle.Event.ON_ANY;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0091 }
        r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0091 }
        r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0091 }
    L_0x0091:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.d.<clinit>():void");
    }
}
