package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.request.BodyEntry;
import anetwork.channel.aidl.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: Taobao */
public class InputStreamEntry implements BodyEntry {
    public static final Creator<InputStreamEntry> CREATOR = new c();
    private j a;

    /* compiled from: Taobao */
    private static class a extends anetwork.channel.aidl.j.a {
        private InputStream a;

        public final int d() throws RemoteException {
            return 0;
        }

        public final int a() throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.a;	 Catch:{ IOException -> 0x0007 }
            r0 = r0.available();	 Catch:{ IOException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = new android.os.RemoteException;
            r1 = "IO Exception";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.a():int");
        }

        public final void b() throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.a;	 Catch:{ IOException -> 0x0006 }
            r0.close();	 Catch:{ IOException -> 0x0006 }
            return;
        L_0x0006:
            r0 = new android.os.RemoteException;
            r1 = "IO Exception";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.b():void");
        }

        public final int c() throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.a;	 Catch:{ IOException -> 0x0007 }
            r0 = r0.read();	 Catch:{ IOException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = new android.os.RemoteException;
            r1 = "IO Exception";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.c():int");
        }

        public final int a(byte[] r2, int r3, int r4) throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = r1.a;	 Catch:{ IOException -> 0x0007 }
            r2 = r0.read(r2, r3, r4);	 Catch:{ IOException -> 0x0007 }
            return r2;
        L_0x0007:
            r2 = new android.os.RemoteException;
            r3 = "IO Exception";
            r2.<init>(r3);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.a(byte[], int, int):int");
        }

        public final int a(byte[] r2) throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = r1.a;	 Catch:{ IOException -> 0x0007 }
            r2 = r0.read(r2);	 Catch:{ IOException -> 0x0007 }
            return r2;
        L_0x0007:
            r2 = new android.os.RemoteException;
            r0 = "IO Exception";
            r2.<init>(r0);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.a(byte[]):int");
        }

        public final long a(int r4) throws android.os.RemoteException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.a;	 Catch:{ IOException -> 0x0008 }
            r1 = (long) r4;	 Catch:{ IOException -> 0x0008 }
            r0 = r0.skip(r1);	 Catch:{ IOException -> 0x0008 }
            return r0;
        L_0x0008:
            r4 = new android.os.RemoteException;
            r0 = "IO Exception";
            r4.<init>(r0);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.InputStreamEntry.a.a(int):long");
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    private InputStreamEntry() {
        this.a = null;
    }

    public int writeTo(OutputStream outputStream) throws IOException {
        try {
            ByteArray a = a.a.a(2048);
            int i = 0;
            while (true) {
                int a2 = this.a.a(a.getBuffer());
                if (a2 != -1) {
                    a.writeTo(outputStream);
                    i += a2;
                } else {
                    a.recycle();
                    return i;
                }
            }
        } catch (OutputStream outputStream2) {
            throw new IOException("RemoteException", outputStream2);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.a);
    }
}
