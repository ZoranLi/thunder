package com.qq.e.comm.services;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.packet.d;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Request.Method;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

public class RetCodeService {
    private final Random a;

    static class Holder {
        static final RetCodeService a = new RetCodeService();

        private Holder() {
        }
    }

    public static class RetCodeInfo {
        final String a;
        final String b;
        final String c;
        final int d;
        final int e;
        final int f;
        final int g;
        final int h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("RetCodeInfo [host=");
            stringBuilder.append(this.a);
            stringBuilder.append(", commandid=");
            stringBuilder.append(this.b);
            stringBuilder.append(", releaseversion=");
            stringBuilder.append(this.c);
            stringBuilder.append(", resultcode=");
            stringBuilder.append(this.d);
            stringBuilder.append(", tmcost=");
            stringBuilder.append(this.e);
            stringBuilder.append(", reqsize=");
            stringBuilder.append(this.f);
            stringBuilder.append(", rspsize=");
            stringBuilder.append(this.g);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    class SendTask implements Runnable {
        private RetCodeInfo a;
        private int b = 100;
        private /* synthetic */ RetCodeService c;

        SendTask(RetCodeService retCodeService, RetCodeInfo retCodeInfo) {
            this.c = retCodeService;
            this.a = retCodeInfo;
        }

        public void run() {
            RetCodeService.a(this.c, this.a, this.b);
        }
    }

    private RetCodeService() {
        this.a = new Random(System.currentTimeMillis());
    }

    private static java.lang.String a(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.net.InetAddress.getByName(r0);	 Catch:{ UnknownHostException -> 0x0009 }
        r0 = r0.getHostAddress();	 Catch:{ UnknownHostException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = "0.0.0.0";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.services.RetCodeService.a(java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        if (retCodeService.a(i)) {
            Request plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Method.GET, null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("apn", String.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()));
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                String encode = URLEncoder.encode(GDTADManager.getInstance().getDeviceStatus().model, "utf-8");
                plainRequest.addQuery("deviceinfo", encode);
                plainRequest.addQuery(d.n, encode);
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, Priority.Low);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            Request plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Method.GET, null);
            plainRequest2.addQuery(DispatchConstants.DOMAIN, retCodeInfo.a);
            plainRequest2.addQuery("cgi", retCodeInfo.b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, Priority.Low);
        }
    }

    private boolean a(int i) {
        return this.a.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(this, retCodeInfo)).start();
    }
}
