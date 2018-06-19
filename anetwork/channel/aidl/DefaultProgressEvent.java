package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: Taobao */
public class DefaultProgressEvent implements Parcelable {
    public static final Creator<DefaultProgressEvent> CREATOR = new c();
    public int a;
    public int b;
    public int c;
    public String d;
    public Object e;
    public byte[] f;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DefaultProgressEvent [index=");
        stringBuilder.append(this.a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.b);
        stringBuilder.append(", total=");
        stringBuilder.append(this.c);
        stringBuilder.append(", desc=");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.f != 0 ? this.f.length : 0);
        parcel.writeByteArray(this.f);
    }

    public static anetwork.channel.aidl.DefaultProgressEvent a(android.os.Parcel r2) {
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
        r0 = new anetwork.channel.aidl.DefaultProgressEvent;
        r0.<init>();
        r1 = r2.readInt();	 Catch:{ Exception -> 0x002a }
        r0.a = r1;	 Catch:{ Exception -> 0x002a }
        r1 = r2.readInt();	 Catch:{ Exception -> 0x002a }
        r0.b = r1;	 Catch:{ Exception -> 0x002a }
        r1 = r2.readInt();	 Catch:{ Exception -> 0x002a }
        r0.c = r1;	 Catch:{ Exception -> 0x002a }
        r1 = r2.readString();	 Catch:{ Exception -> 0x002a }
        r0.d = r1;	 Catch:{ Exception -> 0x002a }
        r1 = r2.readInt();	 Catch:{ Exception -> 0x002a }
        if (r1 <= 0) goto L_0x002a;	 Catch:{ Exception -> 0x002a }
    L_0x0023:
        r1 = new byte[r1];	 Catch:{ Exception -> 0x002a }
        r2.readByteArray(r1);	 Catch:{ Exception -> 0x002a }
        r0.f = r1;	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.DefaultProgressEvent.a(android.os.Parcel):anetwork.channel.aidl.DefaultProgressEvent");
    }
}
