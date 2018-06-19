package com.xunlei.tdlive.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.LevelInfo;
import com.xunlei.tdlive.protocol.XLLiveGetFollowNumberRequest;
import com.xunlei.tdlive.protocol.XLLiveGetUserInfoRequest;
import com.xunlei.tdlive.protocol.XLLiveGetUserInfoRequest.LType;
import com.xunlei.tdlive.protocol.XLLiveRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.protocol.XLLiveRsyncAccountRequest;
import com.xunlei.tdlive.protocol.XLLiveUpdateUserInfoRequest;
import com.xunlei.tdlive.route.XLLiveRouteDispatcher;
import com.xunlei.tdlive.util.XLog;
import com.xunlei.tdlive.util.k;
import com.xunlei.tdlive.util.l;

/* compiled from: UserHelper */
public class b {
    private static final int[] a = new int[]{20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22};
    private static final String[] b = new String[]{"摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    private static b c;
    private k<Object> A = new k();
    private Handler d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private boolean q;
    private JsonWrapper r;
    private JsonWrapper s;
    private JsonWrapper t;
    private XLLiveRequest u;
    private XLLiveRequest v;
    private k<b> w = new k();
    private k<c> x = new k();
    private k<a> y = new k();
    private k<Object> z = new k();

    /* compiled from: UserHelper */
    public interface a {
        void a(boolean z);
    }

    /* compiled from: UserHelper */
    public interface b {
        void a(int i, String str, JsonWrapper jsonWrapper);
    }

    /* compiled from: UserHelper */
    public interface c {
        void a(boolean z, String str, String str2, String str3, String str4);
    }

    private b() {
        a(new a(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void a(boolean z) {
                a.a(this.a.e());
                XLLiveRequest.setLoginParam(this.a.e(), this.a.f(), this.a.g());
                if (z) {
                    this.a.d();
                } else {
                    this.a.r = null;
                    this.a.s = null;
                    this.a.t = null;
                    this.a.g = null;
                    this.a.h = -1;
                    this.a.f = null;
                    this.a.i = null;
                    this.a.j = null;
                    this.a.k = null;
                    this.a.l = null;
                    this.a.m = null;
                    this.a.q = false;
                    this.a.n = null;
                    this.a.o = null;
                    this.a.p = null;
                }
                if (z) {
                    z = a.d("login_start");
                    if (z.b() != null) {
                        a.d("login_return_result").a(z.b()).b("success").a("userid", b.a().e()).a("network", l.b(com.xunlei.tdlive.util.a.a())).a("errorcode", 0).b(new String[0]);
                        z.a();
                    }
                }
            }
        });
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    public void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("app-");
        stringBuilder.append(str);
        this.e = stringBuilder.toString();
        this.d = new Handler(Looper.getMainLooper());
        this.d.post(new Runnable(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a(this.a.b(), this.a.e(), this.a.g(), this.a.f(), this.a.h());
            }
        });
    }

    public void a(b bVar) {
        this.w.a(bVar);
    }

    public void b(b bVar) {
        this.w.b(bVar);
    }

    public void a(a aVar) {
        this.y.a(aVar);
    }

    protected void a(final boolean z, String str, int i, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder("fireLoginStateChangedListener sessionId=");
        stringBuilder.append(str2);
        XLog.d("logininfo-", stringBuilder.toString());
        this.f = str;
        this.h = i;
        this.g = str2;
        this.i = str3;
        this.y.a(new com.xunlei.tdlive.util.k.a<a>(this) {
            final /* synthetic */ b b;

            public void a(a aVar, Object... objArr) {
                aVar.a(z);
            }
        }, new Object[false]);
    }

    protected void a(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        b bVar = this;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        String str13 = str6;
        String str14 = str7;
        if (z) {
            new XLLiveRsyncAccountRequest(z ^ 1).send(new JsonCallBack(bVar) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                    StringBuilder stringBuilder = new StringBuilder("XLLiveRsyncAccountRequest onResponse ret:");
                    stringBuilder.append(i);
                    stringBuilder.append(", msg:");
                    stringBuilder.append(str);
                    XLog.d("UserHelper", stringBuilder.toString());
                }
            });
        } else {
            int i = 1;
            int i2 = (str8 == null || str8.equals(bVar.m)) ? 0 : 1;
            i2 |= 0;
            bVar.m = str8;
            int i3 = (str9 == null || str9.equals(bVar.j)) ? 0 : 1;
            i2 |= i3;
            bVar.j = str9;
            i3 = (str10 == null || str10.equals(bVar.k)) ? 0 : 1;
            i2 |= i3;
            bVar.k = str10;
            i3 = (str11 == null || str11.equals(bVar.l)) ? 0 : 1;
            i2 |= i3;
            bVar.l = str11;
            i3 = (str12 == null || str12.equals(bVar.n)) ? 0 : 1;
            i2 |= i3;
            bVar.n = str12;
            int i4 = (str13 == null || str13.equals(bVar.o)) ? 0 : 1;
            i4 |= i2;
            bVar.o = str13;
            if (str14 == null || str14.equals(bVar.p)) {
                i = 0;
            }
            i4 |= i;
            bVar.p = str14;
            if (i4 != 0) {
                a(str8, str10, str9, "", "", "", null);
            }
        }
        final boolean z2 = z;
        final String str15 = str8;
        final String str16 = str9;
        final String str17 = str10;
        final String str18 = str11;
        bVar.x.a(new com.xunlei.tdlive.util.k.a<c>(bVar) {
            final /* synthetic */ b f;

            public void a(c cVar, Object... objArr) {
                cVar.a(z2, str15, str16, str17, str18);
            }
        }, new Object[0]);
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) ? false : true;
    }

    public void c() {
        this.y.a(new com.xunlei.tdlive.util.k.a<a>(this) {
            final /* synthetic */ b a;

            public void a(a aVar, Object... objArr) {
            }

            {
                this.a = r1;
            }
        }, new Object[0]);
    }

    public void a(Context context, String str, a aVar) {
        a(context, false, str, aVar);
    }

    public void a(Context context, boolean z, String str, a aVar) {
        a(context, false, z, str, aVar);
    }

    public void a(Context context, boolean z, boolean z2, String str, a aVar) {
        if (!z) {
            if (b()) {
                if (aVar != null) {
                    aVar.a(true);
                }
                return;
            }
        }
        this.y.a((Object) aVar, true);
        XLLiveRouteDispatcher.getInstance().login(z2);
        a.d("login_start").a(str).b(new String[false]);
    }

    public void d() {
        c(null);
    }

    public void c(final b bVar) {
        if (bVar != null) {
            a(bVar);
        }
        if (b()) {
            if (this.u == null || this.u.tryLock()) {
                this.u = new XLLiveGetUserInfoRequest(LType.XL);
                this.u.setSendTimeOut(3000);
                this.u.send(new JsonCallBack(this) {
                    final /* synthetic */ b b;

                    public void onResponse(final int i, final String str, JsonWrapper jsonWrapper) {
                        if (i == 0) {
                            this.b.r = jsonWrapper.getObject("data", "{}");
                            this.b.r.putInt("fans_num", 0);
                            this.b.r.putInt("follow_num", 0);
                            this.b.s = this.b.r.getObject("player_info", "{}");
                        }
                        if (!(this.b.r == null || this.b.t == null)) {
                            this.b.r.putInt("fans_num", this.b.t.getInt("fans_count", 0));
                            this.b.r.putInt("follow_num", this.b.t.getInt("follow_count", 0));
                        }
                        this.b.w.a(new com.xunlei.tdlive.util.k.a<b>(this) {
                            final /* synthetic */ AnonymousClass2 c;

                            public void a(b bVar, Object... objArr) {
                                bVar.a(i, str, this.c.b.r);
                            }
                        }, new Object[0]);
                        if (bVar != 0) {
                            this.b.b(bVar);
                        }
                    }
                });
            }
            if (this.v == null || this.v.tryLock()) {
                this.v = new XLLiveGetFollowNumberRequest(e());
                this.v.setSendTimeOut(3000);
                this.v.send(new JsonCallBack(this) {
                    final /* synthetic */ b b;

                    public void onResponse(final int i, final String str, JsonWrapper jsonWrapper) {
                        if (i == 0) {
                            this.b.t = jsonWrapper.getObject("data", "{}");
                        }
                        if (!(this.b.r == null || this.b.t == null)) {
                            this.b.r.putInt("fans_num", this.b.t.getInt("fans_count", 0));
                            this.b.r.putInt("follow_num", this.b.t.getInt("follow_count", 0));
                            this.b.w.a(new com.xunlei.tdlive.util.k.a<b>(this) {
                                final /* synthetic */ AnonymousClass3 c;

                                public void a(b bVar, Object... objArr) {
                                    bVar.a(i, str, this.c.b.r);
                                }
                            }, new Object[0]);
                        }
                        if (bVar != 0) {
                            this.b.b(bVar);
                        }
                    }
                });
                return;
            }
        }
        this.w.a(new com.xunlei.tdlive.util.k.a<b>(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void a(b bVar, Object... objArr) {
                bVar.a(-400, "no login", this.a.r);
            }
        }, new Object[0]);
        if (bVar != null) {
            b(bVar);
        }
    }

    @Deprecated
    public void a(String str, String str2, String str3, String str4, String str5, String str6, final b bVar) {
        new XLLiveUpdateUserInfoRequest(str, str2, str3).send((JsonCallBack) new JsonCallBack(this) {
            final /* synthetic */ b b;

            public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                if (i == 0) {
                    this.b.c(bVar);
                    return;
                }
                if (bVar != null) {
                    bVar.a(i, str, this.b.r);
                }
            }
        });
    }

    public String e() {
        String str;
        if (!TextUtils.isEmpty(this.f)) {
            if (!"0".equals(this.f)) {
                str = this.f;
                return str != null ? "" : str;
            }
        }
        str = this.e;
        if (str != null) {
        }
    }

    public String f() {
        if (b()) {
            return this.g;
        }
        return "";
    }

    public int g() {
        return this.h;
    }

    public String h() {
        if (b()) {
            return this.i;
        }
        return "";
    }

    public String i() {
        if (b()) {
            String str;
            if (this.r == null) {
                str = this.m;
            } else {
                str = this.r.getString("nickname", "");
            }
            if (str != null) {
                return str.trim();
            }
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("游客");
        stringBuilder.append(e().hashCode());
        return stringBuilder.toString();
    }

    public String j() {
        if (!b()) {
            return "";
        }
        if (this.r != null) {
            return this.r.getString("avatar", "");
        }
        StringBuilder stringBuilder = new StringBuilder("http://img.user.kanimg.com/usrimg/");
        stringBuilder.append(e());
        stringBuilder.append("/300x300");
        return stringBuilder.toString();
    }

    public int a(boolean z) {
        if (z) {
            if (this.s) {
                return this.s.getObject("level_info", "{}").getInt("level", 0);
            }
            return 0;
        } else if (this.r) {
            return this.r.getObject("level", "{}").getInt("current", 0);
        } else {
            return 0;
        }
    }

    public String b(boolean z) {
        return z ? this.s ? this.s.getObject("level_info", "{}").getString("image_leve", "") : "" : this.r ? LevelInfo.LEVEL_ICON_URL(this.r.getObject("level", "{}").getString("icon", "")) : "";
    }
}
