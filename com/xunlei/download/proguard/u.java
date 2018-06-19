package com.xunlei.download.proguard;

import android.text.TextUtils;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.download.proguard.v.b;
import com.xunlei.download.proguard.v.c;
import com.xunlei.downloadlib.parameter.DcdnPeerResParam;
import com.xunlei.downloadlib.parameter.PeerResourceParam;
import com.xunlei.downloadlib.parameter.ServerResourceParam;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import com.xunlei.vip_channel_v2.VipAccResTransClient;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResDcdnPeer;
import com.xunlei.vip_channel_v2.VipParameter.AccResDcdnPeerGather;
import com.xunlei.vip_channel_v2.VipParameter.AccResGaosuGather;
import com.xunlei.vip_channel_v2.VipParameter.AccResGaosuPeer;
import com.xunlei.vip_channel_v2.VipParameter.AccResLixianGather;
import com.xunlei.vip_channel_v2.VipParameter.AccResLixianUrl;
import com.xunlei.vip_channel_v2.VipParameter.AccResResult;
import com.xunlei.vip_channel_v2.VipParameter.AccResTaskInfo;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;

/* compiled from: Vip2TransAccRes */
public class u extends v {
    private static final int C = 30000;
    private static final int D = 120000;
    private static final int E = 3;
    private static final String F = "VipLowSpeedRetryCount";
    static final String a = "Vip2TransAccRes";
    private long A = 0;
    private long B = 0;
    public int b = -1;
    public int c = 0;
    public String d = "";
    VipAccResTransClient e = null;
    ChannelStatInfo f = null;
    AccResResult g = null;
    private int z = 0;

    private boolean a(int i) {
        return i >= 61 && i <= 100;
    }

    public u(b bVar) {
        super(bVar, c.TransResQuery);
    }

    protected void a() {
        super.a();
        this.c = 0;
        this.f = new ChannelStatInfo();
        this.g = new AccResResult();
        this.e = new VipAccResTransClient(this.l);
    }

    protected int a(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        if (!this.w) {
            this.x.a(this.y, i);
        }
        an.b(a, "begin query");
        if (this.o == null) {
            return e(xLTaskInfo, i, str, str2);
        }
        return d(xLTaskInfo, i, str, str2);
    }

    private int d(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        xLTaskInfo = new AccResBtInfo();
        xLTaskInfo.sInfoHash = this.o.mInfoHash;
        xLTaskInfo.sBtTitle = this.o.mMultiFileBaseFolder;
        AccResBtFileInfo[] accResBtFileInfoArr = new AccResBtFileInfo[]{new AccResBtFileInfo()};
        accResBtFileInfoArr[0].sGcid = str;
        accResBtFileInfoArr[0].sCid = str2;
        accResBtFileInfoArr[0].nBtFileIdx = this.o.mSubFileInfo[i].mFileIndex;
        accResBtFileInfoArr[0].sFileName = this.o.mSubFileInfo[i].mFileName;
        accResBtFileInfoArr[0].nFileSize = this.o.mSubFileInfo[i].mFileSize;
        accResBtFileInfoArr[0].fillEmptyString();
        i = a;
        str = new StringBuilder();
        str.append(this.u);
        str.append(String.format("request bt:%s, fileIdx:%d, TrialVerifyInfo:%s", new Object[]{xLTaskInfo.sInfoHash, Integer.valueOf(accResBtFileInfoArr[0].nBtFileIdx), this.d}));
        an.a(i, str.toString());
        if (TextUtils.isEmpty(this.d) != 0) {
            xLTaskInfo = this.e.reqByBt_Mem(xLTaskInfo, accResBtFileInfoArr);
        } else {
            xLTaskInfo = this.e.reqByBt_Trial(this.d, xLTaskInfo, accResBtFileInfoArr);
        }
        if (xLTaskInfo != null) {
            str = a;
            str2 = new StringBuilder();
            str2.append(this.u);
            str2.append("m_vipTransClient.ReqByBt failure, ret:");
            str2.append(xLTaskInfo);
            an.d(str, str2.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        }
        this.v = a.Requested;
        return 190;
    }

    private int e(XLTaskInfo xLTaskInfo, int i, String str, String str2) {
        ComUrlFileInfo[] comUrlFileInfoArr = new ComUrlFileInfo[]{new ComUrlFileInfo()};
        comUrlFileInfoArr[0].sUrl = ab.b(this.i, this.j.d);
        comUrlFileInfoArr[0].sFileName = this.j.G;
        comUrlFileInfoArr[0].sGcid = str;
        comUrlFileInfoArr[0].sCid = str2;
        comUrlFileInfoArr[0].nFileSize = xLTaskInfo.mFileSize;
        comUrlFileInfoArr[0].sCookies = this.j.s;
        comUrlFileInfoArr[0].sRefUrl = this.j.u;
        comUrlFileInfoArr[0].fillEmptyString();
        xLTaskInfo = a;
        str = new StringBuilder();
        str.append(this.u);
        str.append(String.format("request url:%s TrialVerifyInfo:%s", new Object[]{comUrlFileInfoArr[0].sUrl, this.d}));
        an.a(xLTaskInfo, str.toString());
        if (TextUtils.isEmpty(this.d) != null) {
            xLTaskInfo = this.e.reqByUrl_Mem(comUrlFileInfoArr);
        } else {
            xLTaskInfo = this.e.reqByUrl_Trial(this.d, comUrlFileInfoArr);
        }
        if (xLTaskInfo != null) {
            str = a;
            str2 = new StringBuilder();
            str2.append(this.u);
            str2.append("m_vipTransClient.ReqByUrl failure, ret:");
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
        str = this.e.getResult(this.f, this.g);
        if (7006 == str) {
            d(xLTaskInfo, i);
            return 190;
        } else if (str != null) {
            xLTaskInfo = a;
            i = new StringBuilder();
            i.append(this.u);
            i.append("call VipGetAccResResult failure, call_ret:");
            i.append(str);
            an.d(xLTaskInfo, i.toString());
            this.v = a.Error;
            this.p = 491;
            return 190;
        } else {
            b(i);
            str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ChannelStat: m_nResult=%d, m_nRetryCnt=%d, m_nConnErrCode=%d, m_nHttpRespCode=%d", new Object[]{Integer.valueOf(this.f.nResult), Integer.valueOf(this.f.nRetryCnt), Integer.valueOf(this.f.nConnErrCode), Integer.valueOf(this.f.nHttpRespCode)}));
            an.b(str, stringBuilder.toString());
            if (this.f.nResult != null) {
                xLTaskInfo = a;
                i = new StringBuilder();
                i.append(this.u);
                i.append("channel error");
                an.d(xLTaskInfo, i.toString());
                this.v = a.Error;
                this.p = 491;
                return 190;
            } else if (b(xLTaskInfo, i, this.g) == null) {
                a(xLTaskInfo, i, this.g);
                this.v = a.Error;
                this.p = 491;
                return 190;
            } else {
                xLTaskInfo = a;
                i = new StringBuilder();
                i.append(this.u);
                i.append(String.format("AccResResult[%d,%s], ResouceTotal:%d", new Object[]{Integer.valueOf(this.g.nResult), this.g.sResMsg, Integer.valueOf(this.c)}));
                an.a(xLTaskInfo, i.toString());
                this.v = a.HasResulted;
                return 190;
            }
        }
    }

    protected int b() {
        if (this.e != null) {
            this.e.close();
            this.e = null;
        }
        String str;
        StringBuilder stringBuilder;
        if (a.HasResulted == this.v) {
            str = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ProcessEnd, transaction finish", new Object[0]));
            an.a(str, stringBuilder.toString());
            this.b = 0;
            this.v = a.Finish;
            this.B = (System.currentTimeMillis() + ((long) ((this.z + 1) * D))) - StatisticConfig.MIN_UPLOAD_INTERVAL;
            this.w = false;
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
            this.v = a.Failure;
            if (this.g != null) {
                this.b = this.g.nResult;
                if (this.b == 0 && this.g.szTaskInfoList != null && this.g.szTaskInfoList.length > 0) {
                    this.b = this.g.szTaskInfoList[0].nResult;
                }
                if (this.b == 0) {
                    this.b = -3;
                }
            } else {
                this.b = -2;
            }
            str = a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("ProcessEnd, transaction failure, not retry, VipErrNo:%d", new Object[]{Integer.valueOf(this.b)}));
            an.a(str, stringBuilder.toString());
            return this.p;
        }
    }

    protected void a(XLTaskInfo xLTaskInfo, int i) {
        if (System.currentTimeMillis() >= this.B) {
            if (xLTaskInfo.mAdditionalResDCDNSpeed > 0) {
                this.A = 0;
                return;
            }
            if (this.A == 0) {
                this.A = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis() - this.A;
            xLTaskInfo = a;
            StringBuilder stringBuilder = new StringBuilder("lowSpeedInterval:");
            stringBuilder.append(currentTimeMillis);
            an.b(xLTaskInfo, stringBuilder.toString());
            if (currentTimeMillis > StatisticConfig.MIN_UPLOAD_INTERVAL && this.z < 3) {
                this.z += 1;
                this.q = 0;
                this.v = a.Init;
                this.w = true;
                xLTaskInfo = this.x;
                String str = F;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.z);
                xLTaskInfo.a(i, str, stringBuilder2.toString());
                xLTaskInfo = a;
                i = new StringBuilder("will Retry, m_lowSpeedRetryCount:");
                i.append(this.z);
                an.b(xLTaskInfo, i.toString());
            }
        }
    }

    public boolean c() {
        return this.w;
    }

    private void a(XLTaskInfo xLTaskInfo, int i, AccResResult accResResult) {
        xLTaskInfo = a(accResResult.nResult);
        i = accResResult.szTaskInfoList.length > 0 ? a(accResResult.szTaskInfoList[0].nResult) : 0;
        if (xLTaskInfo == null) {
            if (i == 0) {
                xLTaskInfo = null;
                this.q = 0;
                if (xLTaskInfo != null && this.t < 3) {
                    this.t += 1;
                    if (accResResult.szTaskInfoList.length <= null || accResResult.szTaskInfoList[0].stDcdnPeerGather.nReportTime == null) {
                        this.q = System.currentTimeMillis() + 120000;
                    } else {
                        this.q = System.currentTimeMillis() + ((long) (1000 * accResResult.szTaskInfoList[0].stDcdnPeerGather.nReportTime));
                    }
                    xLTaskInfo = a;
                    accResResult = new StringBuilder();
                    accResResult.append(this.u);
                    accResResult.append(String.format("DetectResultFailureRetry: RetryTime:%d, request:%d/%d", new Object[]{Long.valueOf(this.q), Integer.valueOf(this.t), Integer.valueOf(3)}));
                    an.a(xLTaskInfo, accResResult.toString());
                    return;
                }
            }
        }
        xLTaskInfo = 1;
        this.q = 0;
        if (xLTaskInfo != null) {
        }
    }

    private boolean b(XLTaskInfo xLTaskInfo, int i, AccResResult accResResult) {
        String str;
        StringBuilder stringBuilder;
        XLTaskInfo xLTaskInfo2 = xLTaskInfo;
        int i2 = i;
        AccResResult accResResult2 = accResResult;
        String property = this.n.getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
        CharSequence property2 = this.n.getProperty(DownloadManager$Property.PROP_USER_ID, "0");
        if (TextUtils.isEmpty(property2)) {
            property2 = "0";
        }
        CharSequence charSequence = property2;
        String str2 = a;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(r0.u);
        r6 = new Object[6];
        boolean z = false;
        r6[0] = Integer.valueOf(accResResult2.nResult);
        r6[1] = accResResult2.sResMsg;
        r6[2] = Long.valueOf(accResResult2.nFluxCapacity);
        int i3 = 3;
        r6[3] = Long.valueOf(accResResult2.nFluxRemain);
        int i4 = 4;
        r6[4] = Long.valueOf(accResResult2.nFluxNeed);
        r6[5] = Integer.valueOf(accResResult2.nSpeedDuration);
        stringBuilder2.append(String.format("AccResResult[%d,%s], nFluxCapacity:%d, nFluxRemain:%d, nFluxNeed:%d, nSpeedDuration:%d", r6));
        an.b(str2, stringBuilder2.toString());
        if (accResResult2.nResult == 0) {
            if (accResResult2.szTaskInfoList.length > 0) {
                AccResTaskInfo[] accResTaskInfoArr = accResResult2.szTaskInfoList;
                int length = accResTaskInfoArr.length;
                int i5 = 0;
                while (i5 < length) {
                    AccResTaskInfo accResTaskInfo = accResTaskInfoArr[i5];
                    str2 = a;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(r0.u);
                    Object[] objArr = new Object[i3];
                    objArr[z] = Integer.valueOf(accResTaskInfo.nResult);
                    objArr[1] = accResTaskInfo.sResMsg;
                    objArr[2] = accResTaskInfo.sGcid;
                    stringBuilder2.append(String.format("FileInfoResult[%d,%s], GCID:%s", objArr));
                    an.b(str2, stringBuilder2.toString());
                    if (accResTaskInfo.nResult != 0) {
                        str = a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(r0.u);
                        stringBuilder.append(String.format("FileInfoResult error, GCID:%s", new Object[]{accResTaskInfo.sGcid}));
                        an.d(str, stringBuilder.toString());
                        return z;
                    }
                    String str3;
                    StringBuilder stringBuilder3;
                    int length2;
                    int i6;
                    int i7;
                    if (TextUtils.isEmpty(r0.d)) {
                        AccResLixianGather accResLixianGather = accResTaskInfo.stLixianGather;
                        str3 = a;
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(r0.u);
                        Object[] objArr2 = new Object[i4];
                        objArr2[z] = Integer.valueOf(accResLixianGather.nResult);
                        objArr2[1] = accResLixianGather.sResMsg;
                        objArr2[2] = Integer.valueOf(accResLixianGather.nPriority);
                        objArr2[3] = Integer.valueOf(accResLixianGather.szResList.length);
                        stringBuilder3.append(String.format("LixianResult[%d,%s], nPriority:%d, ResCount:%d", objArr2));
                        an.b(str3, stringBuilder3.toString());
                        AccResLixianUrl[] accResLixianUrlArr = accResLixianGather.szResList;
                        length2 = accResLixianUrlArr.length;
                        i3 = z;
                        while (i3 < length2) {
                            AccResLixianUrl accResLixianUrl = accResLixianUrlArr[i3];
                            ServerResourceParam serverResourceParam = new ServerResourceParam();
                            serverResourceParam.mUrl = accResLixianUrl.sUrl;
                            serverResourceParam.mRefUrl = "";
                            serverResourceParam.mCookie = "";
                            AccResLixianUrl[] accResLixianUrlArr2 = accResLixianUrlArr;
                            int i8 = length2;
                            if (9000 != r0.m.btAddServerResource(xLTaskInfo2.mTaskId, i2, serverResourceParam)) {
                                str3 = a;
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append(r0.u);
                                i6 = i5;
                                stringBuilder4.append(String.format("add lixian res failure, ret:%d, url:%s", new Object[]{Integer.valueOf(i7), serverResourceParam.mUrl}));
                                an.d(str3, stringBuilder4.toString());
                            } else {
                                i6 = i5;
                                r0.c++;
                            }
                            i3++;
                            accResLixianUrlArr = accResLixianUrlArr2;
                            length2 = i8;
                            i5 = i6;
                        }
                    }
                    i6 = i5;
                    AccResGaosuGather accResGaosuGather = accResTaskInfo.stGaosuGather;
                    str3 = ad.b(r0.i);
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "1.0.1";
                    }
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(accResGaosuGather.makeVipAuthStr(accResTaskInfo.sGcid));
                    stringBuilder5.append("&tm=android&ver=");
                    stringBuilder5.append(str3);
                    str3 = stringBuilder5.toString();
                    String str4 = a;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(r0.u);
                    stringBuilder3.append(String.format("GaosuResult[%d,%s], nPriority:%d, ResCount:%d, sVipAuth:%s", new Object[]{Integer.valueOf(accResGaosuGather.nResult), accResGaosuGather.sResMsg, Integer.valueOf(accResGaosuGather.nPriority), Integer.valueOf(accResGaosuGather.szResList.length), str3}));
                    an.b(str4, stringBuilder3.toString());
                    AccResGaosuPeer[] accResGaosuPeerArr = accResGaosuGather.szResList;
                    i5 = accResGaosuPeerArr.length;
                    i3 = 0;
                    while (i3 < i5) {
                        AccResGaosuPeer[] accResGaosuPeerArr2;
                        String str5;
                        int i9;
                        AccResGaosuPeer accResGaosuPeer = accResGaosuPeerArr[i3];
                        PeerResourceParam peerResourceParam = new PeerResourceParam();
                        peerResourceParam.mUserId = Long.valueOf(charSequence).longValue();
                        peerResourceParam.mJmpKey = property;
                        peerResourceParam.mTcpPort = accResGaosuPeer.nTcpPort;
                        peerResourceParam.mUdpPort = accResGaosuPeer.nUdpPort;
                        peerResourceParam.mInternalIp = accResGaosuPeer.nIp;
                        peerResourceParam.mPeerId = accResGaosuPeer.sPeerId;
                        peerResourceParam.mResLevel = accResGaosuPeer.nResLevel;
                        peerResourceParam.mResPriority = accResGaosuPeer.nResPriority;
                        peerResourceParam.mCapabilityFlag = accResGaosuPeer.nPeerAbility;
                        peerResourceParam.mVipCdnAuth = str3;
                        if (9000 != r0.m.btAddPeerResource(xLTaskInfo2.mTaskId, i2, peerResourceParam)) {
                            String str6 = a;
                            StringBuilder stringBuilder6 = new StringBuilder();
                            accResGaosuPeerArr2 = accResGaosuPeerArr;
                            stringBuilder6.append(r0.u);
                            str5 = str3;
                            i9 = i5;
                            stringBuilder6.append(String.format("add gaosu res failure, ret:%d, ip:%d, udp_port:%d", new Object[]{Integer.valueOf(r12), Integer.valueOf(peerResourceParam.mInternalIp), Integer.valueOf(peerResourceParam.mUdpPort)}));
                            an.d(str6, stringBuilder6.toString());
                        } else {
                            accResGaosuPeerArr2 = accResGaosuPeerArr;
                            str5 = str3;
                            i9 = i5;
                            r0.c++;
                        }
                        i3++;
                        accResGaosuPeerArr = accResGaosuPeerArr2;
                        str3 = str5;
                        i5 = i9;
                    }
                    AccResDcdnPeerGather accResDcdnPeerGather = accResTaskInfo.stDcdnPeerGather;
                    str2 = a;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(r0.u);
                    stringBuilder2.append(String.format("DcdnPeerResult[%d,%s], nPriority:%d, nReportTime:%d, nTaskId:%d, ResCount:%d", new Object[]{Integer.valueOf(accResDcdnPeerGather.nResult), accResDcdnPeerGather.sResMsg, Integer.valueOf(accResDcdnPeerGather.nPriority), Integer.valueOf(accResDcdnPeerGather.nReportTime), Long.valueOf(accResDcdnPeerGather.nTaskId), Integer.valueOf(accResDcdnPeerGather.szResList.length)}));
                    an.b(str2, stringBuilder2.toString());
                    if (accResDcdnPeerGather.nResult == 0) {
                        if (accResDcdnPeerGather.szResList.length > 0) {
                            DcdnPeerResParam[] dcdnPeerResParamArr = new DcdnPeerResParam[accResDcdnPeerGather.szResList.length];
                            AccResDcdnPeer[] accResDcdnPeerArr = accResDcdnPeerGather.szResList;
                            length2 = accResDcdnPeerArr.length;
                            i5 = 0;
                            i3 = 0;
                            while (i5 < length2) {
                                AccResDcdnPeer accResDcdnPeer = accResDcdnPeerArr[i5];
                                DcdnPeerResParam dcdnPeerResParam = new DcdnPeerResParam();
                                dcdnPeerResParam.sPeerId = accResDcdnPeer.sPeerId;
                                dcdnPeerResParam.sFileName = "";
                                dcdnPeerResParam.nInternalIp = accResDcdnPeer.nIp;
                                dcdnPeerResParam.nTcpPort = accResDcdnPeer.nTcpPort;
                                dcdnPeerResParam.nUdpPort = accResDcdnPeer.nUdpPort;
                                dcdnPeerResParam.nResLevel = accResDcdnPeer.nResLevel;
                                dcdnPeerResParam.nResPriority = accResDcdnPeer.nResPriority;
                                dcdnPeerResParam.nCapabilityFlag = accResDcdnPeer.nCapabilityFlag;
                                AccResDcdnPeer[] accResDcdnPeerArr2 = accResDcdnPeerArr;
                                int i10 = length2;
                                dcdnPeerResParam.nDownloadPos = accResDcdnPeer.nFilePos;
                                dcdnPeerResParam.nDownloadLength = accResDcdnPeer.nFileBlockSize;
                                i7 = i3 + 1;
                                dcdnPeerResParamArr[i3] = dcdnPeerResParam;
                                i5++;
                                i3 = i7;
                                accResDcdnPeerArr = accResDcdnPeerArr2;
                                length2 = i10;
                            }
                            int i11 = i6;
                            AccResTaskInfo[] accResTaskInfoArr2 = accResTaskInfoArr;
                            int i12 = length;
                            if (9000 != r0.m.addBatchDcdnPeerRes(xLTaskInfo2.mTaskId, i2, accResDcdnPeerGather.nTaskId, dcdnPeerResParamArr)) {
                                str2 = a;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(r0.u);
                                stringBuilder2.append(String.format("addBatchDcdnPeerRes failure, ret:%d", new Object[]{Integer.valueOf(r2)}));
                                an.d(str2, stringBuilder2.toString());
                            } else {
                                r0.c += dcdnPeerResParamArr.length;
                            }
                            i5 = i11 + 1;
                            i3 = 3;
                            accResTaskInfoArr = accResTaskInfoArr2;
                            length = i12;
                            z = false;
                            i4 = 4;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        str = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(r0.u);
        stringBuilder.append(String.format("result error:%d, serverTaskCount:%d", new Object[]{Integer.valueOf(accResResult2.nResult), Integer.valueOf(accResResult2.szTaskInfoList.length)}));
        an.d(str, stringBuilder.toString());
        return false;
    }

    public int b(XLTaskInfo xLTaskInfo, int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.u);
        stringBuilder.append(String.format("RecoverAccelerate", new Object[0]));
        an.a(str, stringBuilder.toString());
        this.c = 0;
        return b(xLTaskInfo, i, this.g) != null ? 200 : 491;
    }

    public void c(XLTaskInfo xLTaskInfo, int i) {
        if (this.c > 0) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.u);
            stringBuilder.append(String.format("StopAccelerate", new Object[0]));
            an.a(str, stringBuilder.toString());
            this.m.btRemoveAddedResource(xLTaskInfo.mTaskId, i, 3);
            this.m.btRemoveAddedResource(xLTaskInfo.mTaskId, i, 4);
            this.m.stopDcdn(xLTaskInfo.mTaskId, i);
            this.c = 0;
        }
    }

    private void b(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("handleQueryResult idx:");
        stringBuilder.append(i);
        an.b(str, stringBuilder.toString());
        int i2 = 0;
        if (this.f.nResult != 0) {
            i2 = this.f.nResult;
        } else {
            str = a;
            StringBuilder stringBuilder2 = new StringBuilder("handleQueryResult m_vipOutStat.nResult:");
            stringBuilder2.append(this.f.nResult);
            an.b(str, stringBuilder2.toString());
            if (this.g.nResult != 0) {
                i2 = this.g.nResult;
            } else {
                str = a;
                stringBuilder2 = new StringBuilder("handleQueryResult m_vipOutResult.nResult:");
                stringBuilder2.append(this.g.nResult);
                an.b(str, stringBuilder2.toString());
                if (this.g.szTaskInfoList.length > 0 && this.g.szTaskInfoList[0].nResult != 0) {
                    i2 = this.g.szTaskInfoList[0].nResult;
                } else if (!(this.g.szTaskInfoList.length <= 0 || this.g.szTaskInfoList[0].stDcdnPeerGather == null || this.g.szTaskInfoList[0].stDcdnPeerGather.nResult == 0)) {
                    i2 = this.g.szTaskInfoList[0].stDcdnPeerGather.nResult;
                }
            }
        }
        int i3 = i2;
        if (!this.w) {
            this.x.a(this.y, i, i3, this.f.nConnErrCode, this.f.nHttpRespCode);
        }
    }
}
