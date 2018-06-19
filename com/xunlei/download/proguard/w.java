package com.xunlei.download.proguard;

import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.proguard.v.b;
import com.xunlei.download.proguard.v.c;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipOfflineTransClient;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.OfflineSubmitResult;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Vip2TransOffline */
public class w extends v {
    static final String a = "Vip2TransOffline";
    VipOfflineTransClient b = null;
    ChannelStatInfo c = null;
    OfflineSubmitResult d = null;

    public w(b bVar) {
        super(bVar, c.TransOffline);
    }

    protected void a() {
        super.a();
        this.c = new ChannelStatInfo();
        this.d = new OfflineSubmitResult();
        this.b = new VipOfflineTransClient(this.l);
    }

    protected int a(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        this.x.a(this.y, i);
        i = new ComUrlFileInfo();
        i = new ComUrlFileInfo();
        i.sUrl = ab.b(this.i, this.j.d);
        i.sFileName = this.j.G;
        i.sGcid = str;
        i.sCid = str2;
        i.nFileSize = xLTaskInfo.mFileSize;
        i.sCookies = this.j.s;
        i.sRefUrl = this.j.u;
        i.fillEmptyString();
        xLTaskInfo = "";
        if (this.o != null) {
            i.sUrl = String.format("bt://%s", new Object[]{this.o.mInfoHash});
            i.sGcid = "";
            i.sCid = "";
            xLTaskInfo = a(this.j.N);
            i.sFileName = this.o.mMultiFileBaseFolder;
            i.nFileSize = 0;
        }
        str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.u);
        stringBuilder.append(String.format("request url:%s", new Object[]{i.sUrl}));
        an.a(str, stringBuilder.toString());
        xLTaskInfo = this.b.reqSubmit(i, xLTaskInfo);
        if (xLTaskInfo != null) {
            str = a;
            str2 = new StringBuilder();
            str2.append(this.u);
            str2.append("m_vipTransClient.reqByUrl_Mem failure, ret:");
            str2.append(xLTaskInfo);
            an.d(str, str2.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        }
        this.v = a.Requested;
        return 190;
    }

    protected int b(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        str = this.b.getSubmitResult(this.c, this.d);
        if (7006 == str) {
            d(xLTaskInfo, i);
            return 190;
        } else if (str != null) {
            i = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append("call getResult failure, call_ret:");
            stringBuilder.append(str);
            an.d(i, stringBuilder.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        } else {
            a(i);
            i = a;
            str = new StringBuilder();
            str.append(this.u);
            str.append(String.format("ChannelStat: m_nResult=%d, m_nRetryCnt=%d, m_nConnErrCode=%d, m_nHttpRespCode=%d", new Object[]{Integer.valueOf(this.c.nResult), Integer.valueOf(this.c.nRetryCnt), Integer.valueOf(this.c.nConnErrCode), Integer.valueOf(this.c.nHttpRespCode)}));
            an.b(i, str.toString());
            if (this.c.nResult != 0) {
                i = a;
                str = new StringBuilder();
                str.append(this.u);
                str.append("channel error");
                an.d(i, str.toString());
                this.v = a.Error;
                this.p = 491;
                return 190;
            }
            i = a;
            str = new StringBuilder();
            str.append(this.u);
            str.append(String.format("OfflineSubmitResult[%d,%s]", new Object[]{Integer.valueOf(this.d.nResult), this.d.sResMsg}));
            an.a(i, str.toString());
            if (this.d.nResult != 0) {
                i = a;
                str = new StringBuilder();
                str.append(this.u);
                str.append(String.format("trans:%d error", new Object[]{Long.valueOf(this.b.m_TransHandle)}));
                an.d(i, str.toString());
                this.v = a.Error;
                this.p = 491;
                return 190;
            }
            this.v = a.HasResulted;
            return 190;
        }
    }

    protected int b() {
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
        String str;
        StringBuilder stringBuilder;
        if (a.HasResulted == this.v) {
            str = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ProcessEnd, transaction finish", new Object[0]));
            an.a(str, stringBuilder.toString());
            this.v = a.Finish;
            return 200;
        } else if (this.q > 0) {
            str = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ProcessEnd, transaction failure, need retry", new Object[0]));
            an.a(str, stringBuilder.toString());
            this.v = a.Init;
            return 190;
        } else {
            str = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ProcessEnd, transaction failure, not retry", new Object[0]));
            an.a(str, stringBuilder.toString());
            this.v = a.Failure;
            return this.p;
        }
    }

    public static String a(HashSet<Long> hashSet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            stringBuilder.append((Long) it.next());
            i++;
            if (i < hashSet.size()) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void a(int i) {
        int i2;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("handleQueryResult idx:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        if (this.c.nResult != 0) {
            i2 = this.c.nResult;
        } else {
            str = a;
            stringBuilder = new StringBuilder("handleQueryResult m_vipOutStat.nResult:");
            stringBuilder.append(this.c.nResult);
            an.b(str, stringBuilder.toString());
            if (this.d.nResult != 0) {
                i2 = this.d.nResult;
            } else {
                str = a;
                stringBuilder = new StringBuilder("handleQueryResult m_vipOutResult.nResult:");
                stringBuilder.append(this.d.nResult);
                an.b(str, stringBuilder.toString());
                i2 = 0;
            }
        }
        this.x.a(this.y, i, i2, this.c.nConnErrCode, this.c.nHttpRespCode);
    }
}
