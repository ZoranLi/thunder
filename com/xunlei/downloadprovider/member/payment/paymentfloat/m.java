package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.external.l.b;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: MemberPriceHelper */
public class m extends e {
    private static m d;
    public Handler a = new n(this, Looper.getMainLooper());
    public boolean b = false;
    public b c = new o(this);
    private final byte[] f = new byte[0];
    private SparseArray<OpenPriceParam> g = new SparseArray();
    private List<Integer> h = new ArrayList();
    private ArrayList<a> i = new ArrayList(4);

    /* compiled from: MemberPriceHelper */
    public interface a {
        void a(int i, OpenPriceParam openPriceParam);
    }

    private m() {
    }

    public static m a() {
        if (d == null) {
            synchronized (m.class) {
                if (d == null) {
                    d = new m();
                }
            }
        }
        return d;
    }

    private void a(int i, OpenPriceParam openPriceParam) {
        Message obtainMessage = this.a.obtainMessage(4097);
        obtainMessage.arg1 = i;
        obtainMessage.obj = openPriceParam;
        this.a.sendMessage(obtainMessage);
    }

    private void a(JSONObject jSONObject, int i) throws Exception {
        OpenPriceParam openPriceParam = new OpenPriceParam();
        OpenPriceParam.parseData(jSONObject, openPriceParam);
        this.g.append(i, openPriceParam);
    }

    public final void a(int i) {
        if ((System.currentTimeMillis() - new PreferenceHelper(BrothersApplication.getApplicationInstance(), "pf_configuration_param").getLong(b(i), 0) >= 3600000 ? 1 : null) == null) {
            OpenPriceParam openPriceParam = (OpenPriceParam) this.g.get(i);
            if (openPriceParam != null) {
                a(i, openPriceParam);
                return;
            } else {
                XLThreadPool.execute(new q(this, i));
                return;
            }
        }
        if (!this.h.contains(Integer.valueOf(i))) {
            this.h.add(Integer.valueOf(i));
        }
        b();
    }

    public final void b() {
        a((Object) "tag:quest_price_config");
        BaseJsonRequest baseJsonRequest = new BaseJsonRequest(IMethod.GET, "http://act.vip.xunlei.com/payconfig/js/getprice.json");
        baseJsonRequest.a = "tag:quest_price_config";
        baseJsonRequest.a(null, new r(this), new t(this));
    }

    private static String b(int i) {
        StringBuilder stringBuilder = new StringBuilder("all_pr_get_times_");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    private static String c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BrothersApplication.getApplicationInstance().getFilesDir().getPath());
        stringBuilder.append("/");
        stringBuilder.append(i);
        stringBuilder.append("_pr_file.ser");
        return stringBuilder.toString();
    }

    public final void a(a aVar) {
        if (!this.i.contains(aVar)) {
            this.i.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (this.i.contains(aVar)) {
            this.i.remove(aVar);
        }
    }

    static /* synthetic */ void a(m mVar, int i, OpenPriceParam openPriceParam) {
        if (mVar.i != null && !mVar.i.isEmpty()) {
            mVar = mVar.i.iterator();
            while (mVar.hasNext()) {
                a aVar = (a) mVar.next();
                if (aVar != null) {
                    aVar.a(i, openPriceParam);
                }
            }
        }
    }

    static /* synthetic */ void a(m mVar, JSONObject jSONObject, int i) throws Exception {
        mVar.a(jSONObject, i);
        new PreferenceHelper(BrothersApplication.getApplicationInstance(), "pf_configuration_param").setLong(b(i), System.currentTimeMillis());
        mVar = jSONObject.toString();
        jSONObject = new StringBuilder("vasType===");
        jSONObject.append(i);
        jSONObject.append(" ,content=");
        jSONObject.append(mVar);
        try {
            com.xunlei.downloadprovider.h.e.b(c(i), com.xunlei.downloadprovider.member.payment.external.a.a("xlvip.payment.price", mVar));
        } catch (m mVar2) {
            new StringBuilder("serialize faild=").append(mVar2.getLocalizedMessage());
        }
    }

    static /* synthetic */ void a(m mVar, int i) {
        try {
            Object b = com.xunlei.downloadprovider.member.payment.external.a.b("xlvip.payment.price", com.xunlei.downloadprovider.h.e.a(c(i), "UTF-8").toString());
            if (!TextUtils.isEmpty(b)) {
                mVar.a(new JSONObject(b), i);
            }
        } catch (m mVar2) {
            new StringBuilder("deSerialize faild=").append(mVar2.getMessage());
        }
    }

    static /* synthetic */ int c(m mVar, int i) {
        if (!mVar.b) {
            l.a().a(mVar.c);
        }
        return l.a().a(i, 0, "");
    }
}
