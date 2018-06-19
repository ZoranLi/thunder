package com.qihoo360.mobilesafe.svcmanager;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

/* compiled from: ServiceChannelCursor */
final class f extends MatrixCursor {
    static final String[] a = new String[]{"s"};
    Bundle b = new Bundle();

    static final f a(IBinder iBinder) {
        return new f(a, iBinder);
    }

    static final IBinder a(Cursor cursor) {
        cursor = cursor.getExtras();
        cursor.setClassLoader(ParcelBinder.class.getClassLoader());
        return ((ParcelBinder) cursor.getParcelable("servicechannel")).a;
    }

    private f(String[] strArr, IBinder iBinder) {
        super(strArr);
        this.b.putParcelable("servicechannel", new ParcelBinder(iBinder));
    }

    public final Bundle getExtras() {
        return this.b;
    }
}
