package com.huawei.hms.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.api.internal.IPCTransport;
import com.huawei.hms.c.g;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiClientImpl extends HuaweiApiClient implements ServiceConnection {
    private final Context a;
    private String b;
    private final String c;
    private volatile e d;
    private String e;
    private AtomicInteger f = new AtomicInteger(1);
    private List<Scope> g;
    private List<PermissionInfo> h;
    private Map<Api<?>, ApiOptions> i;
    private SubAppInfo j;
    private ConnectionCallbacks k;
    private OnConnectionFailedListener l;
    private Handler m = null;

    private class a implements ResultCallback<ResolveResult<ConnectResp>> {
        final /* synthetic */ HuaweiApiClientImpl a;

        private a(HuaweiApiClientImpl huaweiApiClientImpl) {
            this.a = huaweiApiClientImpl;
        }

        public /* synthetic */ void onResult(Object obj) {
            a((ResolveResult) obj);
        }

        public void a(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new d(this, resolveResult));
        }
    }

    private class b implements ResultCallback<ResolveResult<DisconnectResp>> {
        final /* synthetic */ HuaweiApiClientImpl a;

        private b(HuaweiApiClientImpl huaweiApiClientImpl) {
            this.a = huaweiApiClientImpl;
        }

        public /* synthetic */ void onResult(Object obj) {
            a((ResolveResult) obj);
        }

        public void a(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new e(this, resolveResult));
        }
    }

    public HuaweiApiClientImpl(Context context) {
        this.a = context;
        this.c = g.a(context);
        this.b = this.c;
    }

    public Context getContext() {
        return this.a;
    }

    public String getPackageName() {
        return this.a.getPackageName();
    }

    public String getAppID() {
        return this.b;
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public final SubAppInfo getSubAppInfo() {
        return this.j;
    }

    public List<Scope> getScopes() {
        return this.g;
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.h;
    }

    public Map<Api<?>, ApiOptions> getApiMap() {
        return this.i;
    }

    public e getService() {
        return this.d;
    }

    public String getSessionId() {
        return this.e;
    }

    public void connect() {
        com.huawei.hms.support.log.a.d("HuaweiApiClientImpl", "====== HMSSDK version: 20502300 ======");
        int i = this.f.get();
        StringBuilder stringBuilder = new StringBuilder("Enter connect, Connection Status: ");
        stringBuilder.append(i);
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", stringBuilder.toString());
        if (!(i == 3 || i == 5 || i == 2)) {
            if (i != 4) {
                this.b = TextUtils.isEmpty(this.c) ? g.a(this.a) : this.c;
                i = com.huawei.hms.api.internal.e.a(this.a);
                StringBuilder stringBuilder2 = new StringBuilder("In connect, isHuaweiMobileServicesAvailable result: ");
                stringBuilder2.append(i);
                com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", stringBuilder2.toString());
                if (i == 0) {
                    a(5);
                    if (a()) {
                        b();
                        return;
                    }
                    a(1);
                    com.huawei.hms.support.log.a.d("HuaweiApiClientImpl", "In connect, bind core service fail");
                    if (this.l != null) {
                        this.l.onConnectionFailed(new ConnectionResult(6));
                    }
                } else if (this.l != null) {
                    this.l.onConnectionFailed(new ConnectionResult(i));
                }
            }
        }
    }

    private void a(int i) {
        this.f.set(i);
    }

    private boolean a() {
        Intent intent = new Intent(HuaweiApiAvailability.SERVICES_ACTION);
        intent.setPackage(HuaweiApiAvailability.SERVICES_PACKAGE);
        return this.a.bindService(intent, this, 1);
    }

    private void b() {
        if (this.m != null) {
            this.m.removeMessages(2);
        } else {
            this.m = new Handler(Looper.getMainLooper(), new b(this));
        }
        this.m.sendEmptyMessageDelayed(2, 3000);
    }

    private void c() {
        if (this.m != null) {
            this.m.removeMessages(2);
            this.m = null;
        }
    }

    public void disconnect() {
        int i = this.f.get();
        StringBuilder stringBuilder = new StringBuilder("Enter disconnect, Connection Status: ");
        stringBuilder.append(i);
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", stringBuilder.toString());
        if (i != 5) {
            switch (i) {
                case 1:
                    return;
                case 2:
                    a(4);
                    return;
                case 3:
                    a(4);
                    d();
                    break;
                default:
                    break;
            }
            return;
        }
        c();
        a(4);
    }

    public boolean isConnected() {
        return this.f.get() == 3;
    }

    public boolean isConnecting() {
        int i = this.f.get();
        if (i != 2) {
            if (i != 5) {
                return false;
            }
        }
        return true;
    }

    public void setApiMap(Map<Api<?>, ApiOptions> map) {
        this.i = map;
    }

    public void setScopes(List<Scope> list) {
        this.g = list;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.h = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo == null) {
            return false;
        }
        Object subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.c) ? g.a(this.a) : this.c)) {
            return false;
        }
        this.j = new SubAppInfo(subAppInfo);
        return true;
    }

    public void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.k = connectionCallbacks;
    }

    public void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.l = onConnectionFailedListener;
    }

    private void d() {
        com.huawei.hms.support.api.a.a.a((ApiClient) this, e()).setResultCallback(new b());
    }

    private DisconnectInfo e() {
        List arrayList = new ArrayList();
        if (this.i != null) {
            for (Api apiName : this.i.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new DisconnectInfo(this.g, arrayList);
    }

    private void a(ResolveResult<DisconnectResp> resolveResult) {
        StringBuilder stringBuilder = new StringBuilder("Enter onDisconnectionResult, disconnect from server result: ");
        stringBuilder.append(resolveResult.getStatus().getStatusCode());
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", stringBuilder.toString());
        h();
        a(1);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", "Enter onServiceConnected.");
        c();
        this.d = com.huawei.hms.core.aidl.e.a.a(iBinder);
        if (this.d == null) {
            com.huawei.hms.support.log.a.d("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            h();
            a(1);
            if (this.l != null) {
                this.l.onConnectionFailed(new ConnectionResult(10));
            }
        } else if (this.f.get() == 5) {
            a(2);
            f();
        } else {
            if (this.f.get() != 3) {
                h();
            }
        }
    }

    private void f() {
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        com.huawei.hms.support.api.a.a.a((ApiClient) this, g()).setResultCallback(new a());
    }

    private ConnectInfo g() {
        String d = new com.huawei.hms.c.e(this.a).d(this.a.getPackageName());
        if (d == null) {
            d = "";
        }
        List arrayList = new ArrayList();
        if (this.i != null) {
            for (Api apiName : this.i.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new ConnectInfo(arrayList, this.g, d, this.j == null ? null : this.j.getSubAppID());
    }

    private void b(ResolveResult<ConnectResp> resolveResult) {
        ConnectResp connectResp = (ConnectResp) resolveResult.getValue();
        if (connectResp != null) {
            this.e = connectResp.sessionId;
        }
        Object subAppID = this.j == null ? null : this.j.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.b = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        StringBuilder stringBuilder = new StringBuilder("Enter onConnectionResult, connect to server result: ");
        stringBuilder.append(statusCode);
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", stringBuilder.toString());
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            if (resolveResult.getValue() != null) {
                com.huawei.hms.api.internal.g.a().a(((ConnectResp) resolveResult.getValue()).protocolVersion);
            }
            a(3);
            if (this.k != null) {
                this.k.onConnected();
            }
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            h();
            a(1);
            if (this.l != null) {
                this.l.onConnectionFailed(new ConnectionResult(statusCode));
            }
        } else {
            h();
            a(1);
            if (this.k != null) {
                this.k.onConnectionSuspended(3);
            }
        }
    }

    private void h() {
        g.a(this.a, (ServiceConnection) this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        com.huawei.hms.support.log.a.b("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.d = null;
        a(1);
        if (this.k != null) {
            this.k.onConnectionSuspended(1);
        }
    }

    public int asyncRequest(android.os.Bundle r5, java.lang.String r6, int r7, com.huawei.hms.support.api.client.ResultCallback<com.huawei.hms.support.api.client.BundleResult> r8) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        if (r8 == 0) goto L_0x0052;
    L_0x0002:
        if (r6 == 0) goto L_0x0052;
    L_0x0004:
        if (r5 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0052;
    L_0x0007:
        r0 = r4.isConnected();
        if (r0 != 0) goto L_0x0011;
    L_0x000d:
        r5 = 907135003; // 0x3611c81b float:2.172316E-6 double:4.48184241E-315;
        return r5;
    L_0x0011:
        r0 = new com.huawei.hms.core.aidl.b;
        r0.<init>(r6, r7);
        r6 = r0.c();
        r6 = com.huawei.hms.core.aidl.a.a(r6);
        r0.a(r5);
        r5 = new com.huawei.hms.core.aidl.RequestHeader;
        r7 = r4.getAppID();
        r1 = r4.getPackageName();
        r2 = 20502300; // 0x138d71c float:3.3949796E-38 double:1.0129482E-316;
        r3 = r4.getSessionId();
        r5.<init>(r7, r1, r2, r3);
        r7 = new android.os.Bundle;
        r7.<init>();
        r5 = r6.a(r5, r7);
        r0.b = r5;
        r5 = r4.getService();	 Catch:{ RemoteException -> 0x004e }
        r6 = new com.huawei.hms.api.c;	 Catch:{ RemoteException -> 0x004e }
        r6.<init>(r4, r8);	 Catch:{ RemoteException -> 0x004e }
        r5.a(r0, r6);	 Catch:{ RemoteException -> 0x004e }
        r5 = 0;
        return r5;
    L_0x004e:
        r5 = 907135001; // 0x3611c819 float:2.1723156E-6 double:4.4818424E-315;
        return r5;
    L_0x0052:
        r5 = 907135000; // 0x3611c818 float:2.1723154E-6 double:4.481842396E-315;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.asyncRequest(android.os.Bundle, java.lang.String, int, com.huawei.hms.support.api.client.ResultCallback):int");
    }
}
