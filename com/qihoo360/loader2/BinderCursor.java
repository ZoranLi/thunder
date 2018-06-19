package com.qihoo360.loader2;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;

public class BinderCursor extends MatrixCursor {
    Bundle a = new Bundle();

    public static class BinderParcelable implements Parcelable {
        public static final Creator<BinderParcelable> CREATOR = new a();
        IBinder a;

        public int describeContents() {
            return 0;
        }

        BinderParcelable(IBinder iBinder) {
            this.a = iBinder;
        }

        BinderParcelable() {
        }

        BinderParcelable(Parcel parcel) {
            this.a = parcel.readStrongBinder();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStrongBinder(this.a);
        }
    }

    private BinderCursor(String[] strArr, IBinder iBinder) {
        super(strArr);
        if (iBinder != null) {
            this.a.putParcelable("binder", new BinderParcelable(iBinder));
        }
    }

    public Bundle getExtras() {
        return this.a;
    }

    public static final Cursor a(IBinder iBinder) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("query binder = ");
            stringBuilder.append(iBinder);
            c.a("ws001", stringBuilder.toString());
        }
        return new BinderCursor(PluginInfo.QUERY_COLUMNS, iBinder);
    }

    public static final IBinder a(Cursor cursor) {
        cursor = cursor.getExtras();
        cursor.setClassLoader(BinderCursor.class.getClassLoader());
        BinderParcelable binderParcelable = (BinderParcelable) cursor.getParcelable("binder");
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("get binder = ");
            stringBuilder.append(binderParcelable.a);
            c.a("ws001", stringBuilder.toString());
        }
        return binderParcelable.a;
    }
}
