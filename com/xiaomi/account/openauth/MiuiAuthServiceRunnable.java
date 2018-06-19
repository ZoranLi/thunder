package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import miui.net.IXiaomiAuthService;

abstract class MiuiAuthServiceRunnable<V> extends XiaomiOAuthRunnable<V> implements ServiceConnection {
    private static final String ACTION_FOR_AUTH_SERVICE = "android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE";
    private static final String PACKAGE_NAME_FOR_AUTH_SERVICE = "com.xiaomi.account";
    protected final Account account;
    private final Context context;
    protected final Bundle options;

    static class NoMiuiAuthServiceException extends Exception {
        NoMiuiAuthServiceException() {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    protected abstract V talkWithMiuiV5(IXiaomiAuthService iXiaomiAuthService) throws RemoteException;

    protected abstract V talkWithMiuiV6(com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService) throws RemoteException;

    MiuiAuthServiceRunnable(Context context, Account account, Bundle bundle) {
        this.context = context;
        this.account = account;
        this.options = bundle;
    }

    public final void doRun() {
        if (!this.context.bindService(getAuthServiceIntent(), this, 1)) {
            this.context.unbindService(this);
            this.mFuture.setException(new NoMiuiAuthServiceException());
        }
    }

    public final void onServiceConnected(android.content.ComponentName r2, android.os.IBinder r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = com.xiaomi.account.IXiaomiAuthService.Stub.asInterface(r3);	 Catch:{ SecurityException -> 0x0017 }
        r2 = r1.talkWithMiuiV6(r2);	 Catch:{ SecurityException -> 0x0017 }
        r0 = r1.mFuture;	 Catch:{ SecurityException -> 0x0017 }
        r0.set(r2);	 Catch:{ SecurityException -> 0x0017 }
    L_0x000d:
        r2 = r1.context;
        r2.unbindService(r1);
        return;
    L_0x0013:
        r2 = move-exception;
        goto L_0x003b;
    L_0x0015:
        r2 = move-exception;
        goto L_0x0035;
    L_0x0017:
        r2 = miui.net.IXiaomiAuthService.Stub.asInterface(r3);	 Catch:{ SecurityException -> 0x0025 }
        r2 = r1.talkWithMiuiV5(r2);	 Catch:{ SecurityException -> 0x0025 }
        r3 = r1.mFuture;	 Catch:{ SecurityException -> 0x0025 }
        r3.set(r2);	 Catch:{ SecurityException -> 0x0025 }
        goto L_0x000d;
    L_0x0025:
        r2 = r1.mFuture;	 Catch:{ RemoteException -> 0x0015 }
        r3 = new com.xiaomi.account.openauth.MiuiAuthServiceRunnable$NoMiuiAuthServiceException;	 Catch:{ RemoteException -> 0x0015 }
        r3.<init>();	 Catch:{ RemoteException -> 0x0015 }
        r2.setException(r3);	 Catch:{ RemoteException -> 0x0015 }
    L_0x002f:
        r2 = r1.context;
        r2.unbindService(r1);
        return;
    L_0x0035:
        r3 = r1.mFuture;	 Catch:{ all -> 0x0013 }
        r3.setException(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x002f;
    L_0x003b:
        r3 = r1.context;
        r3.unbindService(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.MiuiAuthServiceRunnable.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    private static Intent getAuthServiceIntent() {
        Intent intent = new Intent(ACTION_FOR_AUTH_SERVICE);
        if (VERSION.SDK_INT >= 21) {
            intent.setPackage(PACKAGE_NAME_FOR_AUTH_SERVICE);
        }
        return intent;
    }
}
