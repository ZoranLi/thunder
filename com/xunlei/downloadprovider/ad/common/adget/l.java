package com.xunlei.downloadprovider.ad.common.adget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.alipay.sdk.util.h;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.c.a;
import com.xunlei.downloadprovider.ad.common.report.CommonReportInfo;
import com.xunlei.downloadprovider.ad.common.report.ReportComponent;
import com.xunlei.downloadprovider.ad.common.report.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BaseAdapterModel */
public abstract class l<T, E> extends ReportComponent {
    public String A;
    public boolean B;
    protected T C;
    protected boolean D;
    public Map<String, String> E;
    public Map<String, String> F;
    public Map<String, String> G;
    public String H;
    protected long I;
    private float a;
    protected String s;
    public Bitmap t;
    public String u;
    public STYLES_INFO v;
    public ArrayList<String> w;
    public ArrayList<String> x;
    public String y;
    public String z;

    public int D() {
        return 1;
    }

    public double E() {
        return 0.0d;
    }

    public boolean F() {
        return false;
    }

    public long H() {
        return -1;
    }

    public boolean a(l lVar) {
        return false;
    }

    public String b() {
        return "";
    }

    public abstract AD_SYSTEM_TYPE c();

    public int d() {
        return 4;
    }

    public boolean i() {
        return false;
    }

    public String j() {
        return "";
    }

    public String k() {
        return "";
    }

    public String l() {
        return "";
    }

    public String m() {
        return "";
    }

    public long n() {
        return 0;
    }

    public String o() {
        return "";
    }

    public String p() {
        return "";
    }

    public String r() {
        return "";
    }

    public String s() {
        return "";
    }

    public String t() {
        return "";
    }

    public int u() {
        return 7;
    }

    public int v() {
        return 0;
    }

    @Deprecated
    public boolean w() {
        return false;
    }

    public String x() {
        return null;
    }

    public String y() {
        return this.z;
    }

    public String z() {
        return this.y;
    }

    public final void a(String str) {
        this.s = str;
    }

    public final String A() {
        return this.s;
    }

    public final ArrayList<String> B() {
        return this.w;
    }

    public final ArrayList<String> C() {
        return this.x;
    }

    public void a(float f) {
        this.a = f;
    }

    public float q() {
        return this.a;
    }

    public void a(View view) {
        this.D = true;
        M();
    }

    public void onClick(View view) {
        N();
    }

    public String a() {
        return y();
    }

    public String e() {
        return y();
    }

    public final void a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            Method method = Class.forName("com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity").getMethod("startWebViewADActivity", new Class[]{Context.class, String.class, String.class, String.class, Bundle.class});
            if (method != null) {
                bundle.putSerializable("ad_common_report_info", L());
                method.invoke(null, new Object[]{context, a.a(this), str, str2, bundle});
            }
        } catch (Context context2) {
            context2.printStackTrace();
        } catch (Context context22) {
            context22.printStackTrace();
        } catch (Context context222) {
            context222.printStackTrace();
        } catch (Context context2222) {
            context2222.printStackTrace();
        }
    }

    public final void a(T t) {
        if (!this.D) {
            this.C = t;
            this.I = SystemClock.uptimeMillis();
        }
    }

    public final T G() {
        return this.C;
    }

    public final boolean I() {
        long uptimeMillis = SystemClock.uptimeMillis();
        b.b();
        return H() != -1 && uptimeMillis - this.I > H();
    }

    private void a(String str, int i) {
        d.a(str, s(), L(), i);
    }

    @NonNull
    public final CommonReportInfo L() {
        String str;
        CommonReportInfo commonReportInfo = new CommonReportInfo();
        commonReportInfo.setPositionId(this.s);
        if (this.v == null) {
            str = "";
        } else {
            str = this.v.mStyleId;
        }
        commonReportInfo.setStyleId(str);
        commonReportInfo.setAdType(y());
        commonReportInfo.setMaterial(a());
        commonReportInfo.setAdvId(e());
        commonReportInfo.setSearchId(this.H);
        commonReportInfo.setLoadStyle(O());
        commonReportInfo.setDefaultAd(i());
        return commonReportInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseAdapterModel{ sourceType: ");
        stringBuilder.append(c().name());
        stringBuilder.append(" title: ");
        stringBuilder.append(j());
        stringBuilder.append(" desc: ");
        stringBuilder.append(m());
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }

    public final boolean a(Context context, String str) {
        d.a("origin", s(), L());
        if (TextUtils.isEmpty(str)) {
            a("origin", -1000);
            return false;
        }
        try {
            com.xunlei.downloadprovider.ad.common.browser.a.a(context, str);
            return true;
        } catch (Context context2) {
            context2.printStackTrace();
            a("origin", context2.getErrorCode());
            return false;
        }
    }

    public final void J() {
        CommonReportInfo L = L();
        L.setExtras(this.E);
        com.xunlei.downloadprovider.ad.common.report.a.a("ad_show", L.getReportParams(), false);
    }

    public final void K() {
        CommonReportInfo L = L();
        L.setExtras(this.F);
        com.xunlei.downloadprovider.ad.common.report.a.a("ad_click", L.getReportParams(), false);
    }

    public final void a(com.xunlei.downloadprovider.ad.common.b.a aVar) {
        CommonReportInfo L = L();
        L.setExtras(this.G);
        L.putExtra("close_type", aVar.a);
        com.xunlei.downloadprovider.ad.common.report.a.a("ad_close", L.getReportParams(), false);
    }
}
