package com.handmark.pulltorefresh.library;

import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;

/* compiled from: PullToRefreshBase */
final /* synthetic */ class j {
    static final /* synthetic */ int[] a = new int[Orientation.values().length];
    static final /* synthetic */ int[] b = new int[State.values().length];
    static final /* synthetic */ int[] c = new int[Mode.values().length];
    static final /* synthetic */ int[] d = new int[AnimationStyle.values().length];

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle.values();
        r0 = r0.length;
        r0 = new int[r0];
        d = r0;
        r0 = 1;
        r1 = d;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle.ROTATE;	 Catch:{ NoSuchFieldError -> 0x0014 }
        r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
        r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
    L_0x0014:
        r1 = 2;
        r2 = d;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle.FLIP;	 Catch:{ NoSuchFieldError -> 0x001f }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
        r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
    L_0x001f:
        r2 = com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.values();
        r2 = r2.length;
        r2 = new int[r2];
        c = r2;
        r2 = c;	 Catch:{ NoSuchFieldError -> 0x0032 }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_END;	 Catch:{ NoSuchFieldError -> 0x0032 }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0032 }
        r2[r3] = r0;	 Catch:{ NoSuchFieldError -> 0x0032 }
    L_0x0032:
        r2 = c;	 Catch:{ NoSuchFieldError -> 0x003c }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.PULL_FROM_START;	 Catch:{ NoSuchFieldError -> 0x003c }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x003c }
        r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x003c }
    L_0x003c:
        r2 = 3;
        r3 = c;	 Catch:{ NoSuchFieldError -> 0x0047 }
        r4 = com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY;	 Catch:{ NoSuchFieldError -> 0x0047 }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0047 }
        r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x0047 }
    L_0x0047:
        r3 = 4;
        r4 = c;	 Catch:{ NoSuchFieldError -> 0x0052 }
        r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.BOTH;	 Catch:{ NoSuchFieldError -> 0x0052 }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0052 }
        r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0052 }
    L_0x0052:
        r4 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.values();
        r4 = r4.length;
        r4 = new int[r4];
        b = r4;
        r4 = b;	 Catch:{ NoSuchFieldError -> 0x0065 }
        r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.RESET;	 Catch:{ NoSuchFieldError -> 0x0065 }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0065 }
        r4[r5] = r0;	 Catch:{ NoSuchFieldError -> 0x0065 }
    L_0x0065:
        r4 = b;	 Catch:{ NoSuchFieldError -> 0x006f }
        r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.PULL_TO_REFRESH;	 Catch:{ NoSuchFieldError -> 0x006f }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x006f }
        r4[r5] = r1;	 Catch:{ NoSuchFieldError -> 0x006f }
    L_0x006f:
        r4 = b;	 Catch:{ NoSuchFieldError -> 0x0079 }
        r5 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.RELEASE_TO_REFRESH;	 Catch:{ NoSuchFieldError -> 0x0079 }
        r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0079 }
        r4[r5] = r2;	 Catch:{ NoSuchFieldError -> 0x0079 }
    L_0x0079:
        r2 = b;	 Catch:{ NoSuchFieldError -> 0x0083 }
        r4 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.REFRESHING;	 Catch:{ NoSuchFieldError -> 0x0083 }
        r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0083 }
        r2[r4] = r3;	 Catch:{ NoSuchFieldError -> 0x0083 }
    L_0x0083:
        r2 = b;	 Catch:{ NoSuchFieldError -> 0x008e }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.MANUAL_REFRESHING;	 Catch:{ NoSuchFieldError -> 0x008e }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x008e }
        r4 = 5;	 Catch:{ NoSuchFieldError -> 0x008e }
        r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x008e }
    L_0x008e:
        r2 = b;	 Catch:{ NoSuchFieldError -> 0x0099 }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.State.OVERSCROLLING;	 Catch:{ NoSuchFieldError -> 0x0099 }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0099 }
        r4 = 6;	 Catch:{ NoSuchFieldError -> 0x0099 }
        r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x0099 }
    L_0x0099:
        r2 = com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.values();
        r2 = r2.length;
        r2 = new int[r2];
        a = r2;
        r2 = a;	 Catch:{ NoSuchFieldError -> 0x00ac }
        r3 = com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.HORIZONTAL;	 Catch:{ NoSuchFieldError -> 0x00ac }
        r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ac }
        r2[r3] = r0;	 Catch:{ NoSuchFieldError -> 0x00ac }
    L_0x00ac:
        r0 = a;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r2 = com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation.VERTICAL;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b6 }
        r0[r2] = r1;	 Catch:{ NoSuchFieldError -> 0x00b6 }
    L_0x00b6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.handmark.pulltorefresh.library.j.<clinit>():void");
    }
}
