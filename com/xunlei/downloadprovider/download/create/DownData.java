package com.xunlei.downloadprovider.download.create;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;

public class DownData implements Parcelable {
    public static final Creator<DownData> CREATOR = new ac();
    public String a = "";
    public String b = "";
    public long c = 0;
    @Nullable
    private DownloadAdditionInfo d;
    private String e = "";
    private String f = "";

    public int describeContents() {
        return 0;
    }

    public DownData(@Nullable DownloadAdditionInfo downloadAdditionInfo) {
        this.d = downloadAdditionInfo;
    }

    protected DownData(Parcel parcel) {
        this.d = (DownloadAdditionInfo) parcel.readParcelable(DownloadAdditionInfo.class.getClassLoader());
        this.a = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.a);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
    }

    @NonNull
    public final DownloadAdditionInfo a() {
        if (this.d == null) {
            this.d = new DownloadAdditionInfo();
        }
        return this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DownData [name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", url=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final DownData a(String str) {
        a().e = str;
        return this;
    }

    public final void b() {
        a().h = true;
    }
}
