package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.a;
import com.taobao.tao.remotebusiness.listener.c;
import java.lang.reflect.Method;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

public final class DefaultLoginImpl implements IRemoteLogin {
    private static final String MTOP_API_REFERENCE = "apiReferer";
    private static final String TAG = "mtop.rb-DefaultLoginImpl";
    public static volatile DefaultLoginImpl instance;
    private static ThreadLocal threadLocal = new ThreadLocal();
    private Method checkSessionValidMethod;
    private Method getNickMethod;
    private Method getSidMethod;
    private Method getUserIdMethod;
    private Method isLoginingMethod;
    private Class loginBroadcastHelperCls = null;
    private Class loginCls = null;
    private LoginContext loginContext = new LoginContext();
    private Method loginMethod;
    private Class loginStatusCls = null;
    protected BroadcastReceiver receiver = null;
    private Method registerReceiverMethod;

    class SessionInvalidEvent {
        private static final String BUNDLE_KEY = "apiReferer";
        private static final String HEADER_KEY = "S";
        public String S_STATUS;
        public String apiName;
        public String eventName;
        public String long_nick;
        public String msgCode;
        public String v;

        public SessionInvalidEvent(MtopRequest mtopRequest) {
            this.apiName = mtopRequest.getApiName();
            this.v = mtopRequest.getVersion();
        }

        public SessionInvalidEvent(MtopResponse mtopResponse, String str) {
            this.eventName = "SESSION_INVALID";
            this.long_nick = str;
            this.apiName = mtopResponse.getApi();
            this.v = mtopResponse.getV();
            this.msgCode = mtopResponse.getRetCode();
            this.S_STATUS = c.a(mtopResponse.getHeaderFields(), HEADER_KEY);
        }

        public String toJSONString() {
            return a.toJSONString(this);
        }
    }

    private DefaultLoginImpl() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r7.<init>();
        r0 = 0;
        r7.loginCls = r0;
        r7.loginBroadcastHelperCls = r0;
        r7.loginStatusCls = r0;
        r1 = new com.taobao.tao.remotebusiness.login.LoginContext;
        r1.<init>();
        r7.loginContext = r1;
        r7.receiver = r0;
        r0 = "com.taobao.login4android.Login";	 Catch:{ ClassNotFoundException -> 0x001c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x001c }
        r7.loginCls = r0;	 Catch:{ ClassNotFoundException -> 0x001c }
        goto L_0x0024;
    L_0x001c:
        r0 = "com.taobao.login4android.api.Login";
        r0 = java.lang.Class.forName(r0);
        r7.loginCls = r0;
    L_0x0024:
        r0 = r7.loginCls;
        r1 = "login";
        r2 = 2;
        r3 = new java.lang.Class[r2];
        r4 = java.lang.Boolean.TYPE;
        r5 = 0;
        r3[r5] = r4;
        r4 = android.os.Bundle.class;
        r6 = 1;
        r3[r6] = r4;
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.loginMethod = r0;
        r0 = r7.loginCls;
        r1 = "checkSessionValid";
        r3 = new java.lang.Class[r5];
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.checkSessionValidMethod = r0;
        r0 = r7.loginCls;
        r1 = "getSid";
        r3 = new java.lang.Class[r5];
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.getSidMethod = r0;
        r0 = r7.loginCls;
        r1 = "getUserId";
        r3 = new java.lang.Class[r5];
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.getUserIdMethod = r0;
        r0 = r7.loginCls;
        r1 = "getNick";
        r3 = new java.lang.Class[r5];
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.getNickMethod = r0;
        r0 = "com.taobao.login4android.constants.LoginStatus";
        r0 = java.lang.Class.forName(r0);
        r7.loginStatusCls = r0;
        r0 = r7.loginStatusCls;
        r1 = "isLogining";
        r3 = new java.lang.Class[r5];
        r0 = r0.getDeclaredMethod(r1, r3);
        r7.isLoginingMethod = r0;
        r0 = "com.taobao.login4android.broadcast.LoginBroadcastHelper";
        r0 = java.lang.Class.forName(r0);
        r7.loginBroadcastHelperCls = r0;
        r0 = r7.loginBroadcastHelperCls;
        r1 = "registerLoginReceiver";
        r2 = new java.lang.Class[r2];
        r3 = android.content.Context.class;
        r2[r5] = r3;
        r3 = android.content.BroadcastReceiver.class;
        r2[r6] = r3;
        r0 = r0.getMethod(r1, r2);
        r7.registerReceiverMethod = r0;
        r7.registerReceiver();
        r0 = "register login event receiver";
        mtopsdk.common.util.j.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.<init>():void");
    }

    public static com.taobao.tao.remotebusiness.login.DefaultLoginImpl getDefaultLoginImpl() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = instance;
        if (r0 != 0) goto L_0x0020;
    L_0x0004:
        r0 = com.taobao.tao.remotebusiness.login.DefaultLoginImpl.class;
        monitor-enter(r0);
        r1 = instance;	 Catch:{ all -> 0x001d }
        if (r1 != 0) goto L_0x001b;
    L_0x000b:
        r1 = new com.taobao.tao.remotebusiness.login.DefaultLoginImpl;	 Catch:{ Exception -> 0x0013 }
        r1.<init>();	 Catch:{ Exception -> 0x0013 }
        instance = r1;	 Catch:{ Exception -> 0x0013 }
        goto L_0x001b;
    L_0x0013:
        r1 = 0;
        instance = r1;	 Catch:{ all -> 0x001d }
        r1 = "DefaultLoginImpl instance error";	 Catch:{ all -> 0x001d }
        mtopsdk.common.util.j.f(r1);	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        goto L_0x0020;
    L_0x001d:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x0020:
        r0 = instance;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.getDefaultLoginImpl():com.taobao.tao.remotebusiness.login.DefaultLoginImpl");
    }

    private java.lang.Object invokeMethod(java.lang.reflect.Method r2, java.lang.Object... r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        if (r2 == 0) goto L_0x000e;
    L_0x0002:
        r0 = r1.loginCls;	 Catch:{ Exception -> 0x0009 }
        r2 = r2.invoke(r0, r3);	 Catch:{ Exception -> 0x0009 }
        return r2;
    L_0x0009:
        r2 = "invokeMethod error";
        mtopsdk.common.util.j.f(r2);
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.invokeMethod(java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    private void registerReceiver() {
        if (this.receiver == null) {
            d.a();
            if (d.b() == null) {
                j.c("Context is null, register receiver fail.");
                return;
            }
            synchronized (DefaultLoginImpl.class) {
                if (this.receiver == null) {
                    this.receiver = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            if (intent != null) {
                                String action = intent.getAction();
                                if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                                    StringBuilder stringBuilder = new StringBuilder("Login Broadcast Received. action=");
                                    stringBuilder.append(action);
                                    j.b(stringBuilder.toString());
                                }
                                if ("NOTIFY_LOGIN_SUCCESS".equals(action)) {
                                    LoginHandler.instance().onLoginSuccess();
                                } else if ("NOTIFY_LOGIN_FAILED".equals(action)) {
                                    LoginHandler.instance().onLoginFail();
                                } else {
                                    if ("NOTIFY_LOGIN_CANCEL".equals(action)) {
                                        LoginHandler.instance().onLoginCancel();
                                    }
                                }
                            }
                        }
                    };
                    invokeMethod(this.registerReceiverMethod, r0, this.receiver);
                }
            }
        }
    }

    public final LoginContext getLoginContext() {
        this.loginContext.sid = (String) invokeMethod(this.getSidMethod, new Object[0]);
        this.loginContext.userId = (String) invokeMethod(this.getUserIdMethod, new Object[0]);
        this.loginContext.nickname = (String) invokeMethod(this.getNickMethod, new Object[0]);
        return this.loginContext;
    }

    public final boolean isLogining() {
        Boolean bool = (Boolean) invokeMethod(this.isLoginingMethod, new Object[0]);
        return bool != null ? bool.booleanValue() : false;
    }

    public final boolean isSessionValid() {
        Boolean bool = (Boolean) invokeMethod(this.checkSessionValidMethod, new Object[0]);
        return bool != null ? bool.booleanValue() : false;
    }

    public final void login(com.taobao.tao.remotebusiness.login.onLoginListener r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = "call login";
        mtopsdk.common.util.j.b(r4);
        r4 = threadLocal;
        r4 = r4.get();
        r4 = (com.taobao.tao.remotebusiness.login.DefaultLoginImpl.SessionInvalidEvent) r4;
        r0 = 0;
        if (r4 == 0) goto L_0x004c;
    L_0x0010:
        r1 = new android.os.Bundle;	 Catch:{ Exception -> 0x0047, all -> 0x0040 }
        r1.<init>();	 Catch:{ Exception -> 0x0047, all -> 0x0040 }
        r4 = r4.toJSONString();	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r0 = mtopsdk.common.util.j.a(r0);	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        if (r0 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
    L_0x0021:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r2 = "apiRefer=";	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r0.append(r4);	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        mtopsdk.common.util.j.b(r0);	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
    L_0x0032:
        r0 = "apiReferer";	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r1.putString(r0, r4);	 Catch:{ Exception -> 0x003e, all -> 0x0040 }
        r4 = threadLocal;
        r4.remove();
        r0 = r1;
        goto L_0x004c;
    L_0x003e:
        r0 = r1;
        goto L_0x0047;
    L_0x0040:
        r4 = move-exception;
        r5 = threadLocal;
        r5.remove();
        throw r4;
    L_0x0047:
        r4 = threadLocal;
        r4.remove();
    L_0x004c:
        r3.registerReceiver();
        r4 = r3.loginMethod;
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        r1[r2] = r5;
        r5 = 1;
        r1[r5] = r0;
        r3.invokeMethod(r4, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.login(com.taobao.tao.remotebusiness.login.onLoginListener, boolean):void");
    }

    public final void setSessionInvalid(Object obj) {
        if (obj instanceof MtopResponse) {
            threadLocal.set(new SessionInvalidEvent((MtopResponse) obj, (String) invokeMethod(this.getNickMethod, new Object[0])));
            return;
        }
        if (obj instanceof MtopRequest) {
            threadLocal.set(new SessionInvalidEvent((MtopRequest) obj));
        }
    }
}
