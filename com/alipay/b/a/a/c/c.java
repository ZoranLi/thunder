package com.alipay.b.a.a.c;

import com.alipay.b.a.a.a.a;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

final class c implements Runnable {
    final /* synthetic */ DeviceDataReportRequest a;
    final /* synthetic */ b b;

    c(b bVar, DeviceDataReportRequest deviceDataReportRequest) {
        this.b = bVar;
        this.a = deviceDataReportRequest;
    }

    public final void run() {
        try {
            b.e = this.b.c.reportStaticData(this.a);
        } catch (Throwable th) {
            b.e = new DeviceDataReportResult();
            b.e.success = false;
            DeviceDataReportResult a = b.e;
            StringBuilder stringBuilder = new StringBuilder("static data rpc upload error, ");
            stringBuilder.append(a.a(th));
            a.resultCode = stringBuilder.toString();
            a.a(th);
        }
    }
}
