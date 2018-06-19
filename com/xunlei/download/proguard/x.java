package com.xunlei.download.proguard;

import com.xunlei.download.proguard.v.b;
import com.xunlei.download.proguard.v.c;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.TrialCommitResult;
import com.xunlei.vip_channel_v2.VipTrialTransClient;

/* compiled from: Vip2TransTrialCommit */
public class x extends v {
    static final String a = "Vip2TransTrialCommit";
    public String b = "";
    public String c = "";
    VipTrialTransClient d = null;
    ChannelStatInfo e = null;
    TrialCommitResult f = null;

    public x(b bVar) {
        super(bVar, c.TrialCommit);
    }

    protected void a() {
        super.a();
        this.e = new ChannelStatInfo();
        this.f = new TrialCommitResult();
        this.d = new VipTrialTransClient(this.l);
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
        if (this.o != null) {
            comUrlFileInfo.sUrl = String.format("bt://%s", new Object[]{this.o.mInfoHash});
            xLTaskInfo = this.o.mSubFileInfo[i].mFileIndex;
            comUrlFileInfo.sFileName = this.o.mSubFileInfo[i].mFileName;
            comUrlFileInfo.nFileSize = this.o.mSubFileInfo[i].mFileSize;
        } else {
            xLTaskInfo = null;
        }
        i = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.u);
        stringBuilder.append(String.format("request url:%s fileIdx:%d, m_sTrialKey:%s", new Object[]{comUrlFileInfo.sUrl, Integer.valueOf(xLTaskInfo), this.b}));
        an.a(i, stringBuilder.toString());
        xLTaskInfo = this.d.reqCommit(comUrlFileInfo, xLTaskInfo, this.b);
        if (xLTaskInfo != null) {
            str = a;
            str2 = new StringBuilder();
            str2.append(this.u);
            str2.append("m_vipTransClient.reqCommit failure, ret:");
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
        str = this.d.getCommitResult(this.e, this.f);
        if (7006 == str) {
            d(xLTaskInfo, i);
            return 190;
        } else if (str != null) {
            i = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append("call GetResult failure, call_ret:");
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
            str.append(String.format("ChannelStat: m_nResult=%d, m_nRetryCnt=%d, m_nConnErrCode=%d, m_nHttpRespCode=%d", new Object[]{Integer.valueOf(this.e.nResult), Integer.valueOf(this.e.nRetryCnt), Integer.valueOf(this.e.nConnErrCode), Integer.valueOf(this.e.nHttpRespCode)}));
            an.b(i, str.toString());
            if (this.e.nResult != 0) {
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
            str.append(String.format("TrialCommitResult[%d,%s], sTrialVerifyInfo:%s", new Object[]{Integer.valueOf(this.f.nResult), this.f.sResMsg, this.f.sTrialVerifyInfo}));
            an.a(i, str.toString());
            if (this.f.nResult == 0) {
                if ("" != this.f.sTrialVerifyInfo) {
                    this.c = this.f.sTrialVerifyInfo;
                    this.v = a.HasResulted;
                    return 190;
                }
            }
            i = a;
            str = new StringBuilder();
            str.append(this.u);
            str.append(String.format("trans:%d error", new Object[]{Long.valueOf(this.d.m_TransHandle)}));
            an.d(i, str.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        }
    }

    protected int b() {
        if (this.d != null) {
            this.d.close();
            this.d = null;
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

    private void a(int i) {
        int i2;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("handleQueryResult idx:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        if (this.e.nResult != 0) {
            i2 = this.e.nResult;
        } else {
            str = a;
            stringBuilder = new StringBuilder("handleQueryResult m_vipOutStat.nResult:");
            stringBuilder.append(this.e.nResult);
            an.b(str, stringBuilder.toString());
            if (this.f.nResult != 0) {
                i2 = this.f.nResult;
            } else {
                str = a;
                stringBuilder = new StringBuilder("handleQueryResult m_vipOutResult.nResult:");
                stringBuilder.append(this.f.nResult);
                an.b(str, stringBuilder.toString());
                i2 = 0;
            }
        }
        this.x.a(this.y, i, i2, this.e.nConnErrCode, this.e.nHttpRespCode);
    }

    public TrialCommitResult c() {
        return this.f;
    }
}
