package com.xunlei.downloadprovider.member.payment.external;

import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import java.util.Observable;

/* compiled from: PaySuccessChange */
public class h extends Observable {
    private static h a;

    private h() {
    }

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    public final void a(PayResultBean payResultBean) {
        setChanged();
        notifyObservers(payResultBean);
    }
}
