package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.util.ErrorConstant;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class NetworkResponse implements Parcelable {
    public static final Creator<NetworkResponse> CREATOR = new e();
    int a;
    public String b;
    public byte[] c;
    public Map<String, List<String>> d;
    public StatisticData e;
    private Throwable f;

    public int describeContents() {
        return 0;
    }

    public final void a(int i) {
        this.a = i;
        this.b = ErrorConstant.getErrMsg(i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkResponse [");
        stringBuilder.append("statusCode=");
        stringBuilder.append(this.a);
        stringBuilder.append(", desc=");
        stringBuilder.append(this.b);
        stringBuilder.append(", connHeadFields=");
        stringBuilder.append(this.d);
        stringBuilder.append(", bytedata=");
        stringBuilder.append(this.c != null ? new String(this.c) : "");
        stringBuilder.append(", error=");
        stringBuilder.append(this.f);
        stringBuilder.append(", statisticData=");
        stringBuilder.append(this.e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public NetworkResponse(byte b) {
        this((char) (byte) 0);
    }

    private NetworkResponse(char c) {
        this.a = ErrorConstant.ERROR_REQUEST_FAIL;
        this.b = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FAIL);
        this.c = null;
        this.d = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        i = this.c != 0 ? this.c.length : 0;
        parcel.writeInt(i);
        if (i > 0) {
            parcel.writeByteArray(this.c);
        }
        parcel.writeMap(this.d);
        if (this.e != 0) {
            parcel.writeSerializable(this.e);
        }
    }

    public static anetwork.channel.aidl.NetworkResponse a(android.os.Parcel r5) {
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
        r0 = new anetwork.channel.aidl.NetworkResponse;
        r0.<init>();
        r1 = 0;
        r2 = 0;
        r3 = r5.readInt();	 Catch:{ Exception -> 0x0041 }
        r0.a = r3;	 Catch:{ Exception -> 0x0041 }
        r3 = r5.readString();	 Catch:{ Exception -> 0x0041 }
        r0.b = r3;	 Catch:{ Exception -> 0x0041 }
        r3 = r5.readInt();	 Catch:{ Exception -> 0x0041 }
        if (r3 <= 0) goto L_0x0022;	 Catch:{ Exception -> 0x0041 }
    L_0x0019:
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0041 }
        r0.c = r3;	 Catch:{ Exception -> 0x0041 }
        r3 = r0.c;	 Catch:{ Exception -> 0x0041 }
        r5.readByteArray(r3);	 Catch:{ Exception -> 0x0041 }
    L_0x0022:
        r3 = anetwork.channel.aidl.NetworkResponse.class;	 Catch:{ Exception -> 0x0041 }
        r3 = r3.getClassLoader();	 Catch:{ Exception -> 0x0041 }
        r3 = r5.readHashMap(r3);	 Catch:{ Exception -> 0x0041 }
        r0.d = r3;	 Catch:{ Exception -> 0x0041 }
        r5 = r5.readSerializable();	 Catch:{ Throwable -> 0x0037 }
        r5 = (anetwork.channel.statist.StatisticData) r5;	 Catch:{ Throwable -> 0x0037 }
        r0.e = r5;	 Catch:{ Throwable -> 0x0037 }
        goto L_0x004b;
    L_0x0037:
        r5 = "anet.NetworkResponse";	 Catch:{ Exception -> 0x0041 }
        r3 = "[readFromParcel] source.readSerializable() error";	 Catch:{ Exception -> 0x0041 }
        r4 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0041 }
        anet.channel.util.ALog.i(r5, r3, r2, r4);	 Catch:{ Exception -> 0x0041 }
        goto L_0x004b;
    L_0x0041:
        r5 = move-exception;
        r3 = "anet.NetworkResponse";
        r4 = "[readFromParcel]";
        r1 = new java.lang.Object[r1];
        anet.channel.util.ALog.w(r3, r4, r2, r5, r1);
    L_0x004b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.NetworkResponse.a(android.os.Parcel):anetwork.channel.aidl.NetworkResponse");
    }
}
