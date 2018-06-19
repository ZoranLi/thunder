package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import com.xunlei.downloadprovider.member.payment.external.i;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.e;
import java.util.Observable;

/* compiled from: RedEnvelopesDetailActivity */
final class j extends i {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    j(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void update(Observable observable, Object obj) {
        PayResultBean payResultBean = (PayResultBean) obj;
        if (payResultBean != null) {
            observable = payResultBean.isSuccess();
            CharSequence obj2 = payResultBean.getExtraParam1() != null ? payResultBean.getExtraParam1().toString() : "";
            new StringBuilder("payResultBean = ").append(payResultBean.toString());
            obj = new StringBuilder("success = ");
            obj.append(observable);
            obj.append(", redCode = ");
            obj.append(obj2);
            if (!(observable == null || this.a.s == null || TextUtils.equals(obj2, this.a.s.l) == null)) {
                this.a.a((e) this.a.s, 2, -1);
                this.a.s.e = 2;
                this.a.a(this.a.s.e);
            }
        }
    }
}
