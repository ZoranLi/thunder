package mtopsdk.xstate.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class b extends Binder implements a {
    public b() {
        attachInterface(this, "mtopsdk.xstate.aidl.IXState");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1598968902) {
            String a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                    a = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 2:
                    parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                    a = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 3:
                    parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
                    b();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
        parcel2.writeString("mtopsdk.xstate.aidl.IXState");
        return true;
    }
}
