package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface n extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements n {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "anetwork.channel.aidl.RemoteNetwork");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                ParcelableRequest parcelableRequest = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
                        if (parcel.readInt() != 0) {
                            parcelableRequest = (ParcelableRequest) ParcelableRequest.CREATOR.createFromParcel(parcel);
                        }
                        i = a(parcelableRequest);
                        parcel2.writeNoException();
                        if (i != 0) {
                            parcel2.writeInt(1);
                            i.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        IBinder asBinder;
                        parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
                        i = parcel.readInt() != 0 ? (ParcelableRequest) ParcelableRequest.CREATOR.createFromParcel(parcel) : 0;
                        parcel = parcel.readStrongBinder();
                        if (parcel == null) {
                            parcel = null;
                        } else {
                            i2 = parcel.queryLocalInterface("anetwork.channel.aidl.ParcelableNetworkListener");
                            if (i2 == 0 || !(i2 instanceof k)) {
                                parcel = new a(parcel);
                            } else {
                                parcel = (k) i2;
                            }
                        }
                        i = a(i, parcel);
                        parcel2.writeNoException();
                        if (i != 0) {
                            asBinder = i.asBinder();
                        }
                        parcel2.writeStrongBinder(asBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface("anetwork.channel.aidl.RemoteNetwork");
                        if (parcel.readInt() != 0) {
                            parcelableRequest = (ParcelableRequest) ParcelableRequest.CREATOR.createFromParcel(parcel);
                        }
                        i = b(parcelableRequest);
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(i.asBinder());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("anetwork.channel.aidl.RemoteNetwork");
            return true;
        }
    }

    NetworkResponse a(ParcelableRequest parcelableRequest) throws RemoteException;

    h a(ParcelableRequest parcelableRequest, k kVar) throws RemoteException;

    a b(ParcelableRequest parcelableRequest) throws RemoteException;
}
