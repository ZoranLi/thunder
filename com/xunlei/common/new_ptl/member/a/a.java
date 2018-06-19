package com.xunlei.common.new_ptl.member.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLPhoneInfo;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.base.XLStatCommandID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AsyncHttpProxy */
public class a {
    private static final String a = "a";
    private static final a b = new a();
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, List<String>> c = new HashMap();
    private boolean d = false;
    private Context e = null;
    private String f = "unknown-host-ip";
    private String g = "unknown-host-ip";
    private String h = "unknown-host-ip";

    /* compiled from: AsyncHttpProxy */
    public class a {
        private static int A = 100;
        private static String B = "3.0";
        private static int s = 203;
        private static int t = 300;
        private static int u = 101;
        private static int v = 10;
        private static int w = 0;
        private static int x = 200;
        private static int y = 100;
        private static String z = "2";
        final /* synthetic */ a a;
        private int b;
        private byte[] c;
        private Header[] d;
        private int e;
        private int f;
        private b g;
        private int h;
        private boolean i;
        private XLStatPack j;
        private long k;
        private final int l;
        private final int m;
        private final int n;
        private final int o;
        private final int p;
        private final int q;
        private final int r;

        private static boolean i() {
            return false;
        }

        private int b() {
            int i = 5;
            if (this.b == 4) {
                i = 15;
            } else {
                int i2 = 10 - (this.h << 1);
                if (i2 > 5) {
                    i = i2;
                }
            }
            String d = a.a;
            StringBuilder stringBuilder = new StringBuilder("calculate current request timeout:index = ");
            stringBuilder.append(this.h);
            stringBuilder.append("#timout = ");
            stringBuilder.append(i);
            stringBuilder.append("#request = ");
            stringBuilder.append(hashCode());
            XLLog.v(d, stringBuilder.toString());
            return i * 1000;
        }

        private int c() {
            int i = 9;
            if (this.b == 4) {
                i = 15;
            } else {
                int i2 = (this.h << 1) + 5;
                if (i2 < 9) {
                    i = i2;
                }
            }
            if (XLPhoneInfo.getNetworkType(this.a.e) == 2) {
                i += 5;
                XLLog.v(a.a, "net work type is 2G, add 5 seconds timeout!");
            }
            String d = a.a;
            StringBuilder stringBuilder = new StringBuilder("calculate current request timeout:index = ");
            stringBuilder.append(this.h);
            stringBuilder.append("#timout = ");
            stringBuilder.append(i);
            stringBuilder.append("#request = ");
            stringBuilder.append(hashCode());
            XLLog.v(d, stringBuilder.toString());
            return i * 1000;
        }

        private boolean d() {
            if (!(this.b == 1 || this.b == 7 || this.b == 2 || this.b == 6)) {
                if (this.b != 4) {
                    return false;
                }
            }
            return true;
        }

        private int e() {
            switch (this.b) {
                case 1:
                    return XLStatCommandID.XLCID_ACC_LOGIN;
                case 2:
                    return XLStatCommandID.XLCID_SESSION_LOGIN;
                case 4:
                    return XLStatCommandID.XLCID_USER_INFO;
                case 6:
                    return XLStatCommandID.XLCID_TOKEN_LOGIN;
                case 7:
                    return XLStatCommandID.XLCID_KEY_LOGIN;
                default:
                    return XLStatCommandID.XLCID_ACC_LOGIN;
            }
        }

        private void a(String str) {
            if (d()) {
                this.j = null;
                this.k = System.currentTimeMillis();
                this.j = new XLStatPack();
                this.j.mSvrDomain = XLUtilTools.getServerDomain(str);
                this.j.mRetryNum = this.e;
                if (this.j.mSvrDomain.contains("mobile-login.xunlei.com") != null) {
                    this.j.mSvrIp = this.a.f;
                } else if (this.j.mSvrDomain.contains("mobile-login-2.xunlei.com") != null) {
                    this.j.mSvrIp = this.a.g;
                } else if (this.j.mSvrDomain.contains("mobile-login-3.xunlei.com") != null) {
                    this.j.mSvrIp = this.a.h;
                } else {
                    this.j.mSvrIp = this.j.mSvrDomain;
                }
                this.j.mFinal = 0;
                str = this.j;
                int i = this.b;
                int i2 = XLStatCommandID.XLCID_ACC_LOGIN;
                switch (i) {
                    case 1:
                        break;
                    case 2:
                        i2 = XLStatCommandID.XLCID_SESSION_LOGIN;
                        break;
                    case 4:
                        i2 = XLStatCommandID.XLCID_USER_INFO;
                        break;
                    case 6:
                        i2 = XLStatCommandID.XLCID_TOKEN_LOGIN;
                        break;
                    case 7:
                        i2 = XLStatCommandID.XLCID_KEY_LOGIN;
                        break;
                    default:
                        break;
                }
                str.mCommandID = i2;
                this.j.mNetType = p.a().C();
                if (this.j.mNetType.equals("2G") != null || this.j.mNetType.equals("3G") != null || this.j.mNetType.equals("4G") != null) {
                    this.j.mISP = p.a().D();
                }
            }
        }

        private void a(Throwable th) {
            if (d() && this.j != null) {
                if (th == null) {
                    th = new HttpException("unknown http error!");
                }
                this.j.mErrorCode = com.xunlei.common.new_ptl.member.task.a.a(th);
                this.j.mErrorMessage = th.getMessage();
                this.j.mFlowId = System.currentTimeMillis();
                this.j.mRespTime = (double) (System.currentTimeMillis() - this.k);
                p.a().a(this.j);
            }
        }

        public a(a aVar) {
            this.a = aVar;
            this.b = 1;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = 0;
            this.i = false;
        }

        public final void a(byte[] bArr) {
            this.c = bArr;
        }

        public final void a(Header[] headerArr) {
            this.d = headerArr;
        }

        public final void a(int i) {
            this.b = i;
        }

        public final void b(int i) {
            this.f = i;
        }

        public final void a(b bVar) {
            this.g = bVar;
        }

        public final void a() {
            String stringBuilder;
            StringBuilder stringBuilder2;
            if (this.b == 5) {
                if ((p.a().z() == 0 ? 1 : 0) == 0) {
                    return;
                }
            }
            StringBuilder stringBuilder3;
            if (this.b == 5) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            } else if (this.b == 8) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                stringBuilder3.append("/channel/put?userid=");
                stringBuilder3.append(p.a().i().getLongValue(USERINFOKEY.UserID));
                stringBuilder = stringBuilder3.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringBuilder);
                stringBuilder2.append("&version=");
                stringBuilder2.append(p.a().w().a());
                stringBuilder = stringBuilder2.toString();
            } else if (this.b == 11) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            }
            final String str = stringBuilder;
            b(str);
            stringBuilder = a.a;
            stringBuilder2 = new StringBuilder("send request use url = ");
            stringBuilder2.append(str);
            stringBuilder2.append("# request = ");
            stringBuilder2.append(hashCode());
            stringBuilder2.append("#taskid = ");
            stringBuilder2.append(this.f);
            XLLog.v(stringBuilder, stringBuilder2.toString());
            if (d()) {
                this.j = null;
                this.k = System.currentTimeMillis();
                this.j = new XLStatPack();
                this.j.mSvrDomain = XLUtilTools.getServerDomain(str);
                this.j.mRetryNum = this.e;
                if (this.j.mSvrDomain.contains("mobile-login.xunlei.com")) {
                    this.j.mSvrIp = this.a.f;
                } else if (this.j.mSvrDomain.contains("mobile-login-2.xunlei.com")) {
                    this.j.mSvrIp = this.a.g;
                } else if (this.j.mSvrDomain.contains("mobile-login-3.xunlei.com")) {
                    this.j.mSvrIp = this.a.h;
                } else {
                    this.j.mSvrIp = this.j.mSvrDomain;
                }
                this.j.mFinal = 0;
                XLStatPack xLStatPack = this.j;
                int i = this.b;
                int i2 = XLStatCommandID.XLCID_ACC_LOGIN;
                switch (i) {
                    case 1:
                        break;
                    case 2:
                        i2 = XLStatCommandID.XLCID_SESSION_LOGIN;
                        break;
                    case 4:
                        i2 = XLStatCommandID.XLCID_USER_INFO;
                        break;
                    case 6:
                        i2 = XLStatCommandID.XLCID_TOKEN_LOGIN;
                        break;
                    case 7:
                        i2 = XLStatCommandID.XLCID_KEY_LOGIN;
                        break;
                    default:
                        break;
                }
                xLStatPack.mCommandID = i2;
                this.j.mNetType = p.a().C();
                if (this.j.mNetType.equals("2G") || this.j.mNetType.equals("3G") || this.j.mNetType.equals("4G")) {
                    this.j.mISP = p.a().D();
                }
            }
            BaseHttpClient l = p.a().l();
            Context a = this.a.e;
            Header[] headerArr = this.d;
            byte[] bArr = this.c;
            BaseHttpClientListener anonymousClass1 = new BaseHttpClientListener(this) {
                private /* synthetic */ a b;

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    bArr = a.b(bArr);
                    Exception exception = new Exception("sdk don't no why, he he.");
                    if (this.b.b == 8) {
                        if (this.b.g != null) {
                            a.a(this.b, str);
                            this.b.g.a(i, headerArr, bArr);
                        }
                        return;
                    }
                    Throwable aVar;
                    try {
                        if (new JSONObject(bArr).optInt("errorIsRetry", 0) == 0) {
                            if (this.b.b == 5) {
                                p.a().d(1);
                            }
                            if (this.b.g != null) {
                                a.a(this.b, str);
                                this.b.g.a(i, headerArr, bArr);
                            }
                            return;
                        }
                        aVar = new com.xunlei.common.new_ptl.member.b.a("server errorIsRetry");
                        a.a(this.b, aVar);
                        if (this.b.e < this.b.a.a(this.b.b) - 1) {
                            this.b.h = (this.b.h + 1) % this.b.a.a(this.b.b);
                            this.b.e = this.b.e + 1;
                            this.b.a();
                            return;
                        }
                        if (this.b.g != null) {
                            a.a(this.b, str);
                            this.b.g.a(aVar);
                        }
                    } catch (JSONException e) {
                        aVar = e;
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    bArr = a.a;
                    StringBuilder stringBuilder = new StringBuilder("http request fail, message = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.v(bArr, stringBuilder.toString());
                    a.a(this.b, th);
                    if (this.b.e < this.b.a.a(this.b.b) - 1) {
                        this.b.h = (this.b.h + 1) % this.b.a.a(this.b.b);
                        this.b.e = this.b.e + 1;
                        this.b.a();
                        return;
                    }
                    if (this.b.g != null) {
                        a.a(this.b, str);
                        this.b.g.a(th);
                    }
                }
            };
            int i3 = 9;
            if (this.b == 4) {
                i3 = 15;
            } else {
                int i4 = (this.h << 1) + 5;
                if (i4 < 9) {
                    i3 = i4;
                }
            }
            if (XLPhoneInfo.getNetworkType(this.a.e) == 2) {
                i3 += 5;
                XLLog.v(a.a, "net work type is 2G, add 5 seconds timeout!");
            }
            stringBuilder = a.a;
            StringBuilder stringBuilder4 = new StringBuilder("calculate current request timeout:index = ");
            stringBuilder4.append(this.h);
            stringBuilder4.append("#timout = ");
            stringBuilder4.append(i3);
            stringBuilder4.append("#request = ");
            stringBuilder4.append(hashCode());
            XLLog.v(stringBuilder, stringBuilder4.toString());
            l.post(a, str, headerArr, bArr, anonymousClass1, i3 * 1000);
        }

        private void b(String str) {
            if (!(this.i || TextUtils.isEmpty(str) || str.contains(".com") != null)) {
                int i = 0;
                if (this.d == null) {
                    this.d = new Header[1];
                } else {
                    str = this.d.length;
                    Header[] headerArr = this.d;
                    this.d = new Header[(str + 1)];
                    int i2 = 0;
                    while (i < str) {
                        int i3 = i2 + 1;
                        this.d[i2] = headerArr[i];
                        i++;
                        i2 = i3;
                    }
                    i = i2;
                }
                this.d[i] = new XLHttpHeader(HttpConstant.HOST, "mobile-login-portal.xunlei.com");
                this.i = true;
            }
        }

        private String g() {
            StringBuilder stringBuilder;
            if (this.b == 5) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder.append(p.e(this.b));
                return stringBuilder.toString();
            } else if (this.b == 8) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(this.a, this.b, this.h));
                stringBuilder.append("/channel/put?userid=");
                stringBuilder.append(p.a().i().getLongValue(USERINFOKEY.UserID));
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append("&version=");
                stringBuilder3.append(p.a().w().a());
                return stringBuilder3.toString();
            } else if (this.b == 11) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder.append(p.e(this.b));
                return stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder.append(p.e(this.b));
                return stringBuilder.toString();
            }
        }

        private static boolean h() {
            return p.a().z() == 0;
        }

        private void c(String str) {
            if (this.f != 0) {
                h hVar = new h();
                hVar.a = XLUtilTools.getServerDomain(str);
                hVar.b = this.e;
                if (hVar.a.contains("mobile-login.xunlei.com") != null) {
                    hVar.c = this.a.f;
                } else if (hVar.a.contains("mobile-login-2.xunlei.com") != null) {
                    hVar.c = this.a.g;
                } else if (hVar.a.contains("mobile-login-3.xunlei.com") != null) {
                    hVar.c = this.a.h;
                } else {
                    hVar.c = hVar.a;
                }
                p.a().a(this.f, hVar);
            }
        }

        private static String b(byte[] bArr) {
            String str = "";
            try {
                return new String(bArr, "ISO-8859-1");
            } catch (byte[] bArr2) {
                bArr2.printStackTrace();
                String d = a.a;
                StringBuilder stringBuilder = new StringBuilder("transformSingleCharString error = ");
                stringBuilder.append(bArr2.getMessage());
                XLLog.v(d, stringBuilder.toString());
                return str;
            }
        }

        private void f() {
            String stringBuilder;
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            if (this.b == 5) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            } else if (this.b == 8) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                stringBuilder3.append("/channel/put?userid=");
                stringBuilder3.append(p.a().i().getLongValue(USERINFOKEY.UserID));
                stringBuilder = stringBuilder3.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringBuilder);
                stringBuilder2.append("&version=");
                stringBuilder2.append(p.a().w().a());
                stringBuilder = stringBuilder2.toString();
            } else if (this.b == 11) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a.a(this.a, this.b, this.h));
                p.a();
                stringBuilder3.append(p.e(this.b));
                stringBuilder = stringBuilder3.toString();
            }
            final String str = stringBuilder;
            b(str);
            stringBuilder = a.a;
            stringBuilder2 = new StringBuilder("send request use url = ");
            stringBuilder2.append(str);
            stringBuilder2.append("# request = ");
            stringBuilder2.append(hashCode());
            stringBuilder2.append("#taskid = ");
            stringBuilder2.append(this.f);
            XLLog.v(stringBuilder, stringBuilder2.toString());
            if (d()) {
                this.j = null;
                this.k = System.currentTimeMillis();
                this.j = new XLStatPack();
                this.j.mSvrDomain = XLUtilTools.getServerDomain(str);
                this.j.mRetryNum = this.e;
                if (this.j.mSvrDomain.contains("mobile-login.xunlei.com")) {
                    this.j.mSvrIp = this.a.f;
                } else if (this.j.mSvrDomain.contains("mobile-login-2.xunlei.com")) {
                    this.j.mSvrIp = this.a.g;
                } else if (this.j.mSvrDomain.contains("mobile-login-3.xunlei.com")) {
                    this.j.mSvrIp = this.a.h;
                } else {
                    this.j.mSvrIp = this.j.mSvrDomain;
                }
                this.j.mFinal = 0;
                XLStatPack xLStatPack = this.j;
                int i = this.b;
                int i2 = XLStatCommandID.XLCID_ACC_LOGIN;
                switch (i) {
                    case 1:
                        break;
                    case 2:
                        i2 = XLStatCommandID.XLCID_SESSION_LOGIN;
                        break;
                    case 4:
                        i2 = XLStatCommandID.XLCID_USER_INFO;
                        break;
                    case 6:
                        i2 = XLStatCommandID.XLCID_TOKEN_LOGIN;
                        break;
                    case 7:
                        i2 = XLStatCommandID.XLCID_KEY_LOGIN;
                        break;
                    default:
                        break;
                }
                xLStatPack.mCommandID = i2;
                this.j.mNetType = p.a().C();
                if (this.j.mNetType.equals("2G") || this.j.mNetType.equals("3G") || this.j.mNetType.equals("4G")) {
                    this.j.mISP = p.a().D();
                }
            }
            BaseHttpClient l = p.a().l();
            Context a = this.a.e;
            Header[] headerArr = this.d;
            byte[] bArr = this.c;
            BaseHttpClientListener anonymousClass1 = /* anonymous class already generated */;
            int i3 = 9;
            if (this.b == 4) {
                i3 = 15;
            } else {
                int i4 = (this.h << 1) + 5;
                if (i4 < 9) {
                    i3 = i4;
                }
            }
            if (XLPhoneInfo.getNetworkType(this.a.e) == 2) {
                i3 += 5;
                XLLog.v(a.a, "net work type is 2G, add 5 seconds timeout!");
            }
            stringBuilder = a.a;
            StringBuilder stringBuilder4 = new StringBuilder("calculate current request timeout:index = ");
            stringBuilder4.append(this.h);
            stringBuilder4.append("#timout = ");
            stringBuilder4.append(i3);
            stringBuilder4.append("#request = ");
            stringBuilder4.append(hashCode());
            XLLog.v(stringBuilder, stringBuilder4.toString());
            l.post(a, str, headerArr, bArr, anonymousClass1, i3 * 1000);
        }

        static /* synthetic */ void a(a aVar, String str) {
            if (aVar.f != 0) {
                h hVar = new h();
                hVar.a = XLUtilTools.getServerDomain(str);
                hVar.b = aVar.e;
                if (hVar.a.contains("mobile-login.xunlei.com") != null) {
                    hVar.c = aVar.a.f;
                } else if (hVar.a.contains("mobile-login-2.xunlei.com") != null) {
                    hVar.c = aVar.a.g;
                } else if (hVar.a.contains("mobile-login-3.xunlei.com") != null) {
                    hVar.c = aVar.a.h;
                } else {
                    hVar.c = hVar.a;
                }
                p.a().a(aVar.f, hVar);
            }
        }

        static /* synthetic */ void a(a aVar, Throwable th) {
            if (aVar.d() && aVar.j != null) {
                if (th == null) {
                    th = new HttpException("unknown http error!");
                }
                aVar.j.mErrorCode = com.xunlei.common.new_ptl.member.task.a.a(th);
                aVar.j.mErrorMessage = th.getMessage();
                aVar.j.mFlowId = System.currentTimeMillis();
                aVar.j.mRespTime = (double) (System.currentTimeMillis() - aVar.k);
                p.a().a(aVar.j);
            }
        }
    }

    private a() {
    }

    public final void a(Context context) {
        if (!this.d) {
            this.d = true;
            this.e = context;
            f();
            context = this.e.getSharedPreferences("xl-acc-portal-cache", 0);
            String string = context.getString("PortalSrvList", "[{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.26\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.76\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.64\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.52\"}],");
            context = context.getString("LoginSrvList", "[{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.36.111\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.64\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.52\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.164\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.76\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.26\"}]");
            try {
                List a = a(new JSONArray(string));
                a.add(0, "https://mobile-login-3.xunlei.com:443");
                a.add(0, "https://mobile-login-2.xunlei.com:443");
                a.add(0, "https://mobile-login.xunlei.com:443");
                this.c.put(Integer.valueOf(5), a);
                context = a(new JSONArray(context));
                context.add(0, "https://mobile-login-3.xunlei.com:443");
                context.add(0, "https://mobile-login-2.xunlei.com:443");
                context.add(0, "https://mobile-login.xunlei.com:443");
                this.c.put(Integer.valueOf(1), context);
                context = new ArrayList();
                context.add(0, "http://channel3-account-ssl.xunlei.com");
                context.add(0, "http://channel2-account-ssl.xunlei.com");
                context.add(0, "http://channel-account-ssl.xunlei.com");
                this.c.put(Integer.valueOf(8), context);
                context = new ArrayList();
                context.add(0, "https://login-i-ssl.xunlei.com");
                context.add(0, "https://login-i-ssl.xunlei.com");
                this.c.put(Integer.valueOf(11), context);
            } catch (Context context2) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder("init server map error = ");
                stringBuilder.append(context2.getMessage());
                XLLog.v(str, stringBuilder.toString());
            }
        }
    }

    public final void a() {
        if (this.d) {
            this.d = false;
        }
    }

    public static a b() {
        return b;
    }

    public final boolean a(String str) {
        boolean z = false;
        for (Entry value : this.c.entrySet()) {
            List list = (List) value.getValue();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    String str2 = (String) list.get(i);
                    if (!TextUtils.isEmpty(str2) && str2.contains(str)) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    public final void a(JSONArray jSONArray, JSONArray jSONArray2) {
        Editor edit = this.e.getSharedPreferences("xl-acc-portal-cache", 0).edit();
        List a = a(jSONArray);
        a.add(0, "https://mobile-login-3.xunlei.com:443");
        a.add(0, "https://mobile-login-2.xunlei.com:443");
        a.add(0, "https://mobile-login.xunlei.com:443");
        if (a.size() > 0) {
            this.c.put(Integer.valueOf(1), a);
            if (jSONArray != null) {
                edit.putString("LoginSrvList", jSONArray.toString());
            }
        }
        jSONArray = a(jSONArray2);
        jSONArray.add(0, "https://mobile-login-3.xunlei.com:443");
        jSONArray.add(0, "https://mobile-login-2.xunlei.com:443");
        jSONArray.add(0, "https://mobile-login.xunlei.com:443");
        if (jSONArray.size() > 0) {
            this.c.put(Integer.valueOf(5), jSONArray);
            if (jSONArray2 != null) {
                edit.putString("PortalSrvList", jSONArray2.toString());
            }
        }
        edit.putLong("PrePortalTime", System.currentTimeMillis());
        edit.apply();
    }

    public final void a(byte[] bArr, int i, b bVar) {
        a aVar = new a(this);
        aVar.a(bArr);
        aVar.a(bVar);
        aVar.a(i);
        aVar.a();
    }

    public final void a(byte[] bArr, int i, b bVar, int i2) {
        a aVar = new a(this);
        aVar.a(bArr);
        aVar.a(bVar);
        aVar.a(i);
        aVar.b(i2);
        aVar.a();
    }

    public final void a(byte[] bArr, Header[] headerArr, int i, b bVar, int i2) {
        headerArr = new a(this);
        headerArr.a(bArr);
        headerArr.a((Header[]) null);
        headerArr.a(bVar);
        headerArr.a((int) 8);
        headerArr.b(i2);
        headerArr.a();
    }

    private static List<String> a(JSONArray jSONArray) {
        List<String> arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jSONObject.optString("type"));
                stringBuilder.append(HttpConstant.SCHEME_SPLIT);
                stringBuilder.append(jSONObject.optString("ip"));
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(jSONObject.optString("port"));
                arrayList.add(stringBuilder.toString());
            }
        }
        return arrayList;
    }

    private void e() {
        SharedPreferences sharedPreferences = this.e.getSharedPreferences("xl-acc-portal-cache", 0);
        String string = sharedPreferences.getString("PortalSrvList", "[{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.26\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.76\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.64\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.52\"}],");
        String string2 = sharedPreferences.getString("LoginSrvList", "[{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.36.111\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.64\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"153.37.208.52\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.164\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.76\"},{\"port\":\"443\",\"type\":\"https\",\"ip\":\"125.39.70.26\"}]");
        try {
            List a = a(new JSONArray(string));
            a.add(0, "https://mobile-login-3.xunlei.com:443");
            a.add(0, "https://mobile-login-2.xunlei.com:443");
            a.add(0, "https://mobile-login.xunlei.com:443");
            this.c.put(Integer.valueOf(5), a);
            List a2 = a(new JSONArray(string2));
            a2.add(0, "https://mobile-login-3.xunlei.com:443");
            a2.add(0, "https://mobile-login-2.xunlei.com:443");
            a2.add(0, "https://mobile-login.xunlei.com:443");
            this.c.put(Integer.valueOf(1), a2);
            a2 = new ArrayList();
            a2.add(0, "http://channel3-account-ssl.xunlei.com");
            a2.add(0, "http://channel2-account-ssl.xunlei.com");
            a2.add(0, "http://channel-account-ssl.xunlei.com");
            this.c.put(Integer.valueOf(8), a2);
            a2 = new ArrayList();
            a2.add(0, "https://login-i-ssl.xunlei.com");
            a2.add(0, "https://login-i-ssl.xunlei.com");
            this.c.put(Integer.valueOf(11), a2);
        } catch (JSONException e) {
            string = a;
            StringBuilder stringBuilder = new StringBuilder("init server map error = ");
            stringBuilder.append(e.getMessage());
            XLLog.v(string, stringBuilder.toString());
        }
    }

    private synchronized int a(int i) {
        if (!(i == 5 || i == 8 || i == 11)) {
            i = 1;
        }
        return ((List) this.c.get(Integer.valueOf(i))).size();
    }

    private String a(int i, int i2) {
        if (!(i == 5 || i == 8 || i == 11)) {
            i = 1;
        }
        List list = (List) this.c.get(Integer.valueOf(i));
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return i == 8 ? "http://channel-account-ssl.xunlei.com" : "https://mobile-login.xunlei.com:443";
        } else {
            return (String) list.get(i2);
        }
    }

    private void f() {
        if ("unknown-host-ip".equals(this.f)) {
            new Thread(new Runnable(this) {
                private /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public final void run() {
                    this.a.f = XLUtilTools.getHostAddress(XLUtilTools.getServerDomain("https://mobile-login.xunlei.com:443"));
                    this.a.g = XLUtilTools.getHostAddress(XLUtilTools.getServerDomain("https://mobile-login-2.xunlei.com:443"));
                    this.a.h = XLUtilTools.getHostAddress(XLUtilTools.getServerDomain("https://mobile-login-3.xunlei.com:443"));
                    String d = a.a;
                    StringBuilder stringBuilder = new StringBuilder("mMainServerHostIp = ");
                    stringBuilder.append(this.a.f);
                    stringBuilder.append("# mMainServerHostIp2 = ");
                    stringBuilder.append(this.a.g);
                    stringBuilder.append("# mMainServerHostIp3 = ");
                    stringBuilder.append(this.a.h);
                    XLLog.v(d, stringBuilder.toString());
                }
            }).start();
        }
    }

    public final void c() {
        f();
    }

    static /* synthetic */ String a(a aVar, int i, int i2) {
        if (!(i == 5 || i == 8 || i == 11)) {
            i = 1;
        }
        List list = (List) aVar.c.get(Integer.valueOf(i));
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return i == 8 ? "http://channel-account-ssl.xunlei.com" : "https://mobile-login.xunlei.com:443";
        } else {
            return (String) list.get(i2);
        }
    }
}
