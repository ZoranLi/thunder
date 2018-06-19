package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import anetwork.channel.a;
import anetwork.channel.entity.k;
import anetwork.channel.f;
import anetwork.channel.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ParcelableRequest implements Parcelable {
    public static final Creator<ParcelableRequest> CREATOR = new m();
    public long a;
    public BodyEntry b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public List<a> g = new ArrayList();
    public String h;
    public List<f> i = new ArrayList();
    public int j;
    public int k;
    public String l;
    public String m;
    private g n;
    private Map<String, String> o;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.n != 0) {
            try {
                parcel.writeInt(this.n.d());
                parcel.writeString(this.d.toString());
                parcel.writeString(this.n.f());
                int i2 = 1;
                parcel.writeBooleanArray(new boolean[]{this.n.a()});
                parcel.writeString(this.n.c());
                List arrayList = new ArrayList();
                if (this.n.b() != null) {
                    for (int i3 = 0; i3 < this.n.b().size(); i3++) {
                        if (this.n.b().get(i3) != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(((a) this.n.b().get(i3)).a());
                            stringBuilder.append("&");
                            stringBuilder.append(((a) this.n.b().get(i3)).b());
                            arrayList.add(stringBuilder.toString());
                        }
                    }
                }
                parcel.writeList(arrayList);
                arrayList = this.n.e();
                List arrayList2 = new ArrayList();
                if (arrayList != null) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        f fVar = (f) arrayList.get(i4);
                        if (fVar != null) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(fVar.a());
                            stringBuilder2.append("&");
                            stringBuilder2.append(fVar.b());
                            arrayList2.add(stringBuilder2.toString());
                        }
                    }
                }
                parcel.writeList(arrayList2);
                parcel.writeParcelable(this.b, 0);
                parcel.writeLong(this.a);
                parcel.writeInt(this.n.g());
                parcel.writeInt(this.n.h());
                parcel.writeString(this.n.i());
                parcel.writeString(this.n.j());
                Map k = this.n.k();
                if (k == null) {
                    i2 = 0;
                }
                parcel.writeInt(i2);
                if (k != null) {
                    parcel.writeMap(k);
                }
            } catch (Parcel parcel2) {
                ALog.w("anet.ParcelableRequest", "[writeToParcel]", null, parcel2, new Object[0]);
            }
        }
    }

    public static ParcelableRequest a(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            int i;
            String str;
            int indexOf;
            parcelableRequest.c = parcel.readInt();
            parcelableRequest.d = parcel.readString();
            parcelableRequest.e = parcel.readString();
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            parcelableRequest.f = zArr[0];
            parcelableRequest.h = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, ParcelableRequest.class.getClassLoader());
            for (i = 0; i < arrayList.size(); i++) {
                str = (String) arrayList.get(i);
                if (str != null) {
                    indexOf = str.indexOf("&");
                    if (!(indexOf == -1 || indexOf == str.length() - 1)) {
                        parcelableRequest.g.add(new anetwork.channel.entity.a(str.substring(0, indexOf), str.substring(indexOf + 1)));
                    }
                }
            }
            List readArrayList = parcel.readArrayList(ParcelableRequest.class.getClassLoader());
            if (readArrayList != null) {
                for (i = 0; i < readArrayList.size(); i++) {
                    str = (String) readArrayList.get(i);
                    if (str != null) {
                        indexOf = str.indexOf("&");
                        if (!(indexOf == -1 || indexOf == str.length() - 1)) {
                            parcelableRequest.i.add(new k(str.substring(0, indexOf), str.substring(indexOf + 1)));
                        }
                    }
                }
            }
            parcelableRequest.b = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.a = parcel.readLong();
            parcelableRequest.j = parcel.readInt();
            parcelableRequest.k = parcel.readInt();
            parcelableRequest.l = parcel.readString();
            parcelableRequest.m = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.o = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Parcel parcel2) {
            ALog.w("anet.ParcelableRequest", "[readFromParcel]", null, parcel2, new Object[0]);
        }
        return parcelableRequest;
    }

    public final String a(String str) {
        if (this.o == null) {
            return null;
        }
        return (String) this.o.get(str);
    }
}
