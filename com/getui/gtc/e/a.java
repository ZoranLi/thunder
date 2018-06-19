package com.getui.gtc.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class a {

    final class a implements IInterface {
        private IBinder a;

        public a(IBinder iBinder) {
            this.a = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.a;
        }

        public final boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public final class c {
        public final String a;
        private final boolean b;

        c(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    public static boolean a(android.content.Context r3, com.getui.gtc.e.a.b r4) {
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
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        r2 = 0;
        if (r0 == r1) goto L_0x0030;
    L_0x000b:
        if (r3 == 0) goto L_0x0030;
    L_0x000d:
        if (r4 != 0) goto L_0x0010;
    L_0x000f:
        return r2;
    L_0x0010:
        r0 = r3.getPackageManager();	 Catch:{ Exception -> 0x0030 }
        r1 = "com.android.vending";	 Catch:{ Exception -> 0x0030 }
        r0.getPackageInfo(r1, r2);	 Catch:{ Exception -> 0x0030 }
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.ads.identifier.service.START";
        r0.<init>(r1);
        r1 = "com.google.android.gms";
        r0.setPackage(r1);
        r1 = new com.getui.gtc.e.c;
        r1.<init>(r4, r3);
        r4 = 1;
        r3 = r3.bindService(r0, r1, r4);
        return r3;
    L_0x0030:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.e.a.a(android.content.Context, com.getui.gtc.e.a$b):boolean");
    }
}
