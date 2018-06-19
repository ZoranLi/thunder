package anetwork.channel.e;

import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.Config.Builder;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.entity.ENV;
import anet.channel.entity.a;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anet.channel.util.c;
import anetwork.channel.a.b;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.Cache.Entry;
import anetwork.channel.entity.j;
import anetwork.channel.http.NetworkSdkSetting;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.push.service.av;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
final class d implements c {
    g a;
    Cache b = null;
    Entry c = null;
    ByteArrayOutputStream d = null;
    String e = DispatchConstants.OTHER;
    volatile Cancelable f = null;
    volatile boolean g = false;
    volatile AtomicBoolean h = null;
    int i = 0;
    int j = 0;
    int k = 0;

    d(g gVar, Cache cache, Entry entry) {
        this.a = gVar;
        this.h = gVar.e;
        this.b = cache;
        this.c = entry;
        this.e = (String) gVar.a.b.getHeaders().get(HttpConstant.F_REFER);
    }

    public final void cancel() {
        this.g = true;
        if (this.f != null) {
            this.f.cancel();
        }
    }

    public final void run() {
        if (!this.g) {
            if (NetworkStatusHelper.g()) {
                if (ALog.isPrintLog(2)) {
                    ALog.i("anet.NetworkTask", "exec request", this.a.c, "retryTimes", Integer.valueOf(this.a.a.c));
                }
                try {
                    SessionCenter instance;
                    String a;
                    Session session;
                    String a2 = this.a.a.a("APPKEY");
                    if (TextUtils.isEmpty(a2)) {
                        instance = SessionCenter.getInstance();
                    } else {
                        ENV env = ENV.ONLINE;
                        a = this.a.a.a("ENVIRONMENT");
                        if ("pre".equalsIgnoreCase(a)) {
                            env = ENV.PREPARE;
                        } else if ("test".equalsIgnoreCase(a)) {
                            env = ENV.TEST;
                        }
                        if (env != NetworkSdkSetting.CURRENT_ENV) {
                            NetworkSdkSetting.CURRENT_ENV = env;
                            SessionCenter.switchEnvironment(env);
                        }
                        Config config = Config.getConfig(a2, env);
                        if (config == null) {
                            config = new Builder().setAppkey(a2).setEnv(env).setAuthCode(this.a.a.a("AuthCode")).build();
                        }
                        instance = SessionCenter.getInstance(config);
                    }
                    c httpUrl = this.a.a.b.getHttpUrl();
                    Request.Builder builder = null;
                    if (this.a.a.h == 1 && b.c() && this.a.a.c == 0) {
                        c a3;
                        a = (String) this.a.a.b.getHeaders().get(HttpConstant.X_HOST_CNAME);
                        if (!TextUtils.isEmpty(a)) {
                            a3 = c.a(httpUrl.e().replace(httpUrl.b(), a));
                            if (a3 != null) {
                                session = instance.get(a3, TypeLevel.SPDY, 5000);
                            }
                        }
                        a3 = httpUrl;
                        session = instance.get(a3, TypeLevel.SPDY, 5000);
                    } else {
                        session = null;
                    }
                    if (session == null) {
                        j jVar = this.a.a;
                        int i = (b.d() && !av.b.equalsIgnoreCase(jVar.a.a("EnableHttpDns")) && (b.e() || jVar.c == 0)) ? 1 : (byte) 0;
                        if (!(i == 0 || NetworkStatusHelper.h())) {
                            session = instance.get(httpUrl, TypeLevel.HTTP, 0);
                        }
                    }
                    if (session == null) {
                        ALog.i("anet.NetworkTask", "create HttpSession with local DNS", this.a.c, new Object[0]);
                        session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new a(httpUrl.d(), this.a.c, null));
                    }
                    this.a.d.connectionType = session.getConnType().toString();
                    this.a.d.isSSL = session.getConnType().isSSL();
                    ALog.i("anet.NetworkTask", "tryGetSession", this.a.c, "Session", session);
                    Request request = this.a.a.b;
                    if (session != null) {
                        if (!this.g) {
                            String str;
                            if ((av.b.equalsIgnoreCase(this.a.a.a.a("EnableCookie")) ^ 1) != 0) {
                                String a4 = anetwork.channel.b.a.a(this.a.a.b.getUrlString());
                                if (!TextUtils.isEmpty(a4)) {
                                    builder = request.newBuilder();
                                    str = (String) request.getHeaders().get(HttpConstant.COOKIE);
                                    if (str != null) {
                                        a4 = StringUtils.concatString(str, "; ", a4);
                                    }
                                    builder.addHeader(HttpConstant.COOKIE, a4);
                                }
                            }
                            if (this.c != null) {
                                if (builder == null) {
                                    builder = request.newBuilder();
                                }
                                if (this.c.etag != null) {
                                    builder.addHeader(HttpRequest.HEADER_IF_NONE_MATCH, this.c.etag);
                                }
                                if (this.c.lastModified > 0) {
                                    builder.addHeader("If-Modified-Since", anetwork.channel.cache.d.a(this.c.lastModified));
                                }
                            }
                            if (builder != null) {
                                request = builder.build();
                            }
                            anetwork.channel.statist.a a5 = anetwork.channel.statist.a.a();
                            c httpUrl2 = request.getHttpUrl();
                            if (a5.a && httpUrl2 != null) {
                                str = httpUrl2.c();
                                if (a5.d.contains(str)) {
                                    if (a5.c.isEmpty()) {
                                        a5.b = System.currentTimeMillis();
                                    }
                                    a5.c.add(str);
                                }
                            }
                            this.f = session.request(request, new e(this, request));
                            return;
                        }
                    }
                    return;
                } catch (Throwable e) {
                    ALog.e("anet.NetworkTask", "send request failed.", this.a.c, e, new Object[0]);
                    return;
                }
            }
            if (ALog.isPrintLog(2)) {
                ALog.i("anet.NetworkTask", NetworkUnavailableException.ERROR_INFO, this.a.c, "NetworkStatus", NetworkStatusHelper.a());
            }
            this.a.b.a(new DefaultFinishEvent((byte) 0));
        }
    }
}
