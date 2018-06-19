package com.xunlei.downloadprovider.member.payment.voucher;

import java.util.List;

/* compiled from: IVoucherProcessor */
public interface c {
    List<Voucher> a(float f, int i, String str);

    void a(VoucherBizNo voucherBizNo);

    void a(String str);

    void a(String str, a aVar);

    void a(String str, b bVar);

    boolean a(float f, int i, String str, Voucher voucher);

    boolean a(float f, int i, String str, List<Voucher> list);

    void b(String str, a aVar);

    boolean b(String str);
}
