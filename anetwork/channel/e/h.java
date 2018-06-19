package anetwork.channel.e;

import android.content.Context;
import android.os.RemoteException;
import anet.channel.a.c;
import anet.channel.util.ALog;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.a.e;
import anetwork.channel.aidl.k;
import anetwork.channel.aidl.n.a;
import anetwork.channel.entity.f;
import anetwork.channel.entity.j;
import anetwork.channel.http.NetworkSdkSetting;
import com.tencent.open.SocialConstants;

/* compiled from: Taobao */
public abstract class h extends a {
    protected int a = 1;

    public h(Context context) {
        NetworkSdkSetting.init(context);
    }

    public final NetworkResponse a(ParcelableRequest parcelableRequest) throws RemoteException {
        return c(parcelableRequest);
    }

    public final anetwork.channel.aidl.h a(ParcelableRequest parcelableRequest, k kVar) throws RemoteException {
        try {
            return a(new j(parcelableRequest, this.a), kVar);
        } catch (k kVar2) {
            ALog.e("anet.UnifiedNetworkDelegate", "asyncSend failed", parcelableRequest.m, kVar2, new Object[0]);
            throw new RemoteException(kVar2.getMessage());
        }
    }

    private static anetwork.channel.aidl.h a(j jVar, k kVar) throws RemoteException {
        i iVar = new i(jVar, new f(kVar, jVar));
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.UnifiedRequestTask", SocialConstants.TYPE_REQUEST, iVar.a.c, new Object[]{"Url", iVar.a.a.b.getUrlString()});
        }
        c.a(new j(iVar), 0);
        return new anetwork.channel.aidl.a.c(new b(iVar));
    }

    public final anetwork.channel.aidl.a b(ParcelableRequest parcelableRequest) throws RemoteException {
        try {
            j jVar = new j(parcelableRequest, this.a);
            anetwork.channel.aidl.a aVar = new anetwork.channel.aidl.a.a(jVar);
            aVar.b = a(jVar, new e(aVar));
            return aVar;
        } catch (Throwable e) {
            ALog.e("anet.UnifiedNetworkDelegate", "asyncSend failed", parcelableRequest.m, e, new Object[0]);
            throw new RemoteException(e.getMessage());
        }
    }

    private anetwork.channel.aidl.NetworkResponse c(anetwork.channel.aidl.ParcelableRequest r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new anetwork.channel.aidl.NetworkResponse;
        r0.<init>();
        r8 = r7.b(r8);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r8 = (anetwork.channel.aidl.a.a) r8;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r1 = r8.b();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r0.a(r1);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r1 = r8.d();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r0.d = r1;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r1 = r8.a();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        if (r1 == 0) goto L_0x0051;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
    L_0x001e:
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r3 = r8.a();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r3 = r3.d();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r2.<init>(r3);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r3 = anet.channel.bytes.a.a.a;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r3 = r3.a(r4);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
    L_0x0033:
        r4 = r3.getBuffer();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r4 = r1.a(r4);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r5 = -1;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        if (r4 == r5) goto L_0x0047;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
    L_0x003e:
        r5 = r3.getBuffer();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r6 = 0;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r2.write(r5, r6, r4);	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        goto L_0x0033;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
    L_0x0047:
        r1 = r2.toByteArray();	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r0.c = r1;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r8 = r8.a;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
        r0.e = r8;	 Catch:{ RemoteException -> 0x0058, Exception -> 0x0052 }
    L_0x0051:
        return r0;
    L_0x0052:
        r8 = -201; // 0xffffffffffffff37 float:NaN double:NaN;
        r0.a(r8);
        goto L_0x0072;
    L_0x0058:
        r8 = move-exception;
        r1 = -103; // 0xffffffffffffff99 float:NaN double:NaN;
        r0.a(r1);
        r8 = r8.getMessage();
        r1 = android.text.TextUtils.isEmpty(r8);
        if (r1 != 0) goto L_0x0072;
    L_0x0068:
        r1 = r0.b;
        r2 = "|";
        r8 = anet.channel.util.StringUtils.concatString(r1, r2, r8);
        r0.b = r8;
    L_0x0072:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.e.h.c(anetwork.channel.aidl.ParcelableRequest):anetwork.channel.aidl.NetworkResponse");
    }
}
