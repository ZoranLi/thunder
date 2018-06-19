package com.xunlei.download.proguard;

import com.xunlei.download.proguard.v.b;
import com.xunlei.download.proguard.v.c;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.TrialQueryResult;
import com.xunlei.vip_channel_v2.VipTrialTransClient;

/* compiled from: Vip2TransTrialQuery */
public class y extends v {
    static final String a = "Vip2TransTrialQuery";
    public String b = "";
    VipTrialTransClient c = null;
    ChannelStatInfo d = null;
    TrialQueryResult e = null;

    public y(b bVar) {
        super(bVar, c.TrialQuery);
    }

    protected void a() {
        super.a();
        this.d = new ChannelStatInfo();
        this.e = new TrialQueryResult();
        this.c = new VipTrialTransClient(this.l);
    }

    protected int a(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        this.x.a(this.y, i);
        ComUrlFileInfo comUrlFileInfo = new ComUrlFileInfo();
        comUrlFileInfo = new ComUrlFileInfo();
        comUrlFileInfo.sUrl = ab.b(this.i, this.j.d);
        comUrlFileInfo.sFileName = this.j.G;
        comUrlFileInfo.sGcid = str;
        comUrlFileInfo.sCid = str2;
        comUrlFileInfo.nFileSize = xLTaskInfo.mFileSize;
        comUrlFileInfo.sCookies = this.j.s;
        comUrlFileInfo.sRefUrl = this.j.u;
        comUrlFileInfo.fillEmptyString();
        xLTaskInfo = "";
        if (this.o != null) {
            comUrlFileInfo.sUrl = String.format("bt://%s", new Object[]{this.o.mInfoHash});
            xLTaskInfo = this.o.mMultiFileBaseFolder;
            str = this.o.mSubFileInfo[i].mFileIndex;
            comUrlFileInfo.sFileName = this.o.mSubFileInfo[i].mFileName;
            comUrlFileInfo.nFileSize = this.o.mSubFileInfo[i].mFileSize;
        } else {
            str = null;
        }
        i = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.u);
        stringBuilder.append(String.format("request url:%s fileIdx:%d", new Object[]{comUrlFileInfo.sUrl, Integer.valueOf(str)}));
        an.a(i, stringBuilder.toString());
        xLTaskInfo = this.c.reqQuery(comUrlFileInfo, str, xLTaskInfo);
        if (xLTaskInfo != null) {
            str = a;
            str2 = new StringBuilder();
            str2.append(this.u);
            str2.append("m_vipTransClient.reqQuery failure, ret:");
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
        str = this.c.getQueryResult(this.d, this.e);
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
            str.append(String.format("ChannelStat: m_nResult=%d, m_nRetryCnt=%d, m_nConnErrCode=%d, m_nHttpRespCode=%d", new Object[]{Integer.valueOf(this.d.nResult), Integer.valueOf(this.d.nRetryCnt), Integer.valueOf(this.d.nConnErrCode), Integer.valueOf(this.d.nHttpRespCode)}));
            an.b(i, str.toString());
            if (this.d.nResult != 0) {
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
            str.append(String.format("TrialQueryResult[%d,%s], nTrialUsedTimes:%d, nTrialLeftTimes:%d, nTrialRefreshTime:%d, sTrialKey:%s", new Object[]{Integer.valueOf(this.e.nResult), this.e.sResMsg, Integer.valueOf(this.e.nTrialUsedTimes), Integer.valueOf(this.e.nTrialLeftTimes), Integer.valueOf(this.e.nTrialRefreshTime), this.e.sTrialKey}));
            an.a(i, str.toString());
            if (this.e.nResult == 0) {
                if ("" != this.e.sTrialKey) {
                    this.b = this.e.sTrialKey;
                    this.v = a.HasResulted;
                    return 190;
                }
            }
            i = a;
            str = new StringBuilder();
            str.append(this.u);
            str.append(String.format("trans:%d error", new Object[]{Long.valueOf(this.c.m_TransHandle)}));
            an.d(i, str.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        }
    }

    protected int b() {
        if (this.c != null) {
            this.c.close();
            this.c = null;
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

    public int c() {
        if (this.e == null) {
            return 0;
        }
        return this.e.nTrialLeftTimes;
    }

    private void a(int i) {
        int i2;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("handleQueryResult idx:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        if (this.d.nResult != 0) {
            i2 = this.d.nResult;
        } else {
            str = a;
            stringBuilder = new StringBuilder("handleQueryResult m_vipOutStat.nResult:");
            stringBuilder.append(this.d.nResult);
            an.b(str, stringBuilder.toString());
            if (this.e.nResult != 0) {
                i2 = this.e.nResult;
            } else {
                str = a;
                stringBuilder = new StringBuilder("handleQueryResult m_vipOutResult.nResult:");
                stringBuilder.append(this.e.nResult);
                an.b(str, stringBuilder.toString());
                i2 = 0;
            }
        }
        this.x.a(this.y, i, i2, this.d.nConnErrCode, this.d.nHttpRespCode);
    }

    public TrialQueryResult e() {
        return this.e;
    }
}
