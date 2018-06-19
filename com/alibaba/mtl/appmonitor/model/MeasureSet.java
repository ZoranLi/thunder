package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MeasureSet implements Parcelable {
    public static final Creator<MeasureSet> CREATOR = new f();
    public List<Measure> a = new ArrayList(3);

    public int describeContents() {
        return 0;
    }

    public static MeasureSet a() {
        return new MeasureSet();
    }

    private MeasureSet() {
    }

    public final boolean a(MeasureValueSet measureValueSet) {
        if (this.a != null) {
            if (measureValueSet == null) {
                return false;
            }
            for (int i = 0; i < this.a.size(); i++) {
                Measure measure = (Measure) this.a.get(i);
                if (measure != null) {
                    String b = measure.b();
                    if (!measureValueSet.a.containsKey(b) || !measure.a(measureValueSet.a(b))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final MeasureSet a(Measure measure) {
        if (!this.a.contains(measure)) {
            this.a.add(measure);
        }
        return this;
    }

    public final MeasureSet a(String str) {
        return a(new Measure(str));
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a != null) {
            try {
                Object[] toArray = this.a.toArray();
                Parcelable[] parcelableArr = null;
                if (toArray != null) {
                    parcelableArr = new Measure[toArray.length];
                    for (int i2 = 0; i2 < toArray.length; i2++) {
                        parcelableArr[i2] = (Measure) toArray[i2];
                    }
                }
                parcel.writeParcelableArray(parcelableArr, i);
            } catch (Parcel parcel2) {
                parcel2.printStackTrace();
            }
        }
    }

    static MeasureSet a(Parcel parcel) {
        MeasureSet measureSet = new MeasureSet();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (readParcelableArray != null) {
                List arrayList = new ArrayList(readParcelableArray.length);
                for (Parcelable parcelable : readParcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                measureSet.a = arrayList;
            }
        } catch (Parcel parcel2) {
            parcel2.printStackTrace();
        }
        return measureSet;
    }
}
