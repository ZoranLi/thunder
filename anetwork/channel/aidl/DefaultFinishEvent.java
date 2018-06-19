package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.util.ErrorConstant;
import anetwork.channel.d.a;
import anetwork.channel.statist.StatisticData;

/* compiled from: Taobao */
public class DefaultFinishEvent implements Parcelable, a {
    public static final Creator<DefaultFinishEvent> CREATOR = new b();
    public Object a;
    int b;
    String c;
    StatisticData d;

    public int describeContents() {
        return 0;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final StatisticData c() {
        return this.d;
    }

    public DefaultFinishEvent(byte b) {
        this(ErrorConstant.ERROR_NO_NETWORK, null, null);
    }

    public DefaultFinishEvent(int i, String str, StatisticData statisticData) {
        this.b = i;
        if (str == null) {
            str = ErrorConstant.getErrMsg(i);
        }
        this.c = str;
        this.d = statisticData;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DefaultFinishEvent [");
        stringBuilder.append("code=");
        stringBuilder.append(this.b);
        stringBuilder.append(", desc=");
        stringBuilder.append(this.c);
        stringBuilder.append(", context=");
        stringBuilder.append(this.a);
        stringBuilder.append(", statisticData=");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        if (this.d != 0) {
            parcel.writeSerializable(this.d);
        }
    }

    static anetwork.channel.aidl.DefaultFinishEvent a(android.os.Parcel r2) {
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
        r0 = new anetwork.channel.aidl.DefaultFinishEvent;
        r0.<init>();
        r1 = r2.readInt();	 Catch:{ Throwable -> 0x0019 }
        r0.b = r1;	 Catch:{ Throwable -> 0x0019 }
        r1 = r2.readString();	 Catch:{ Throwable -> 0x0019 }
        r0.c = r1;	 Catch:{ Throwable -> 0x0019 }
        r2 = r2.readSerializable();	 Catch:{ Throwable -> 0x0019 }
        r2 = (anetwork.channel.statist.StatisticData) r2;	 Catch:{ Throwable -> 0x0019 }
        r0.d = r2;	 Catch:{ Throwable -> 0x0019 }
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.DefaultFinishEvent.a(android.os.Parcel):anetwork.channel.aidl.DefaultFinishEvent");
    }
}
