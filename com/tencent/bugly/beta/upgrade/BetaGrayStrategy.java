package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
public class BetaGrayStrategy implements Parcelable, Creator<BetaGrayStrategy> {
    public static final Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();
    public y a;
    public int b = 0;
    public long c = -1;
    public boolean d = false;
    public long e = -1;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public BetaGrayStrategy(Parcel parcel) {
        boolean z = false;
        this.a = (y) ah.a(parcel.createByteArray(), y.class);
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        if ((byte) 1 == parcel.readByte()) {
            z = true;
        }
        this.d = z;
        this.e = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(ah.a(this.a));
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte((byte) this.d);
        parcel.writeLong(this.e);
    }

    public BetaGrayStrategy a(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    public BetaGrayStrategy[] a(int i) {
        return new BetaGrayStrategy[i];
    }
}
