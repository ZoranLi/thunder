package com.xunlei.downloadprovider.personal.redenvelope;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.RedWebViewActivity;

/* compiled from: RedPacketOpenHelper */
public final class g {

    /* compiled from: RedPacketOpenHelper */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(@NonNull Context context, @NonNull PayFrom payFrom, @NonNull String str, @NonNull String str2) {
        StringBuilder stringBuilder = new StringBuilder("[gotoPayPage]  payFrom=");
        stringBuilder.append(payFrom != null ? payFrom : "");
        stringBuilder.append(" ,code=");
        stringBuilder.append(str);
        stringBuilder.append(" ,giftTitle=");
        stringBuilder.append(str2);
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a("voucher_code", str).a("voucher_amount", Integer.valueOf(e.a(str2)));
        PaymentEntryActivity.a(context, payEntryParam);
    }

    public static void a(@NonNull Context context, @NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            RedWebViewActivity.a(context, "", str);
        }
    }

    public static void a(@NonNull Context context, @NonNull PayFrom payFrom, @NonNull String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("[gotoPayPageForVoucher] payFrom=");
        stringBuilder.append(payFrom != null ? payFrom : "");
        stringBuilder.append(" ,code=");
        stringBuilder.append(str);
        stringBuilder.append(" ,redPackType=");
        stringBuilder.append(i);
        if (payFrom == PayFrom.DOWNLOAD_TASK_RED_PACKET) {
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_viphb_pop_click"));
        }
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.a("voucher_code", str);
        if (11 == i) {
            payEntryParam.a("voucher_amount", Integer.valueOf(2)).a("v_an_shoulei_ggong_pay_djq2");
        } else if (12 == i) {
            payEntryParam.a("voucher_amount", Integer.valueOf(5)).a("v_an_shoulei_ggong_pay_djq5");
        } else if (13 == i) {
            payEntryParam.a("voucher_amount", Integer.valueOf(10)).a("v_an_shoulei_ggong_pay_djq10");
        }
        PaymentEntryActivity.a(context, payEntryParam);
    }

    public static void b(Context context, String str) {
        PaymentEntryActivity.a(context, PayFrom.DOWNLOAD_TASK_TEN_DAY_REDPACKET, str);
    }

    public static void a(@NonNull Context context, @NonNull String str, String str2, long j, String str3, c cVar) {
        StringBuilder stringBuilder = new StringBuilder("[createDownloadTask] skipUrl=");
        stringBuilder.append(str);
        stringBuilder.append(" ,giftTitle=");
        stringBuilder.append(str2);
        stringBuilder.append(" ,gameSize=");
        stringBuilder.append(j);
        stringBuilder.append(" ,poster=");
        stringBuilder.append(str3);
        if (!TextUtils.isEmpty(str)) {
            TaskStatInfo taskStatInfo = new TaskStatInfo(str, null);
            taskStatInfo.a = com.xunlei.downloadprovider.download.report.c.c;
            taskStatInfo.h = com.xunlei.downloadprovider.download.engine.report.a.b(str);
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = str3;
            com.xunlei.downloadprovider.download.c.a(context, str, str2, j, "", taskStatInfo, downloadAdditionInfo, cVar);
        }
    }

    public static void a(a aVar) {
        XLThreadPool.execute(new h(aVar));
    }
}
