package com.xunlei.vip_channel_v2;

import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.TrialCommitResult;
import com.xunlei.vip_channel_v2.VipParameter.TrialQueryResult;

public class VipTrialTransClient {
    private static final String TAG = "VipTrialTransClient";
    private VipChannelV2Manager mVipChannelV2Manager = null;
    public long m_TransHandle = 0;
    private int m_nReqStat = 0;
    public String m_sTrialKey = "";
    public String m_sTrialVerifyInfo = "";

    public VipTrialTransClient(VipChannelV2Manager vipChannelV2Manager) {
        this.mVipChannelV2Manager = vipChannelV2Manager;
    }

    protected void finalize() throws Throwable {
        close();
    }

    public void close() {
        if (0 != this.m_TransHandle) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
            stringBuilder.append(String.format("close", new Object[0]));
            XLLog.i(str, stringBuilder.toString());
            this.mVipChannelV2Manager.VipTrial_CloseTrans(this.m_TransHandle);
            this.m_TransHandle = 0;
            this.m_nReqStat = 0;
            this.m_sTrialKey = "";
            this.m_sTrialVerifyInfo = "";
        }
    }

    public int reqQuery(ComUrlFileInfo comUrlFileInfo, int i, String str) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipTrial_ReqQuery(comUrlFileInfo, i, str);
        comUrlFileInfo = TAG;
        i = new StringBuilder();
        i.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        i.append(String.format("request query", new Object[0]));
        XLLog.i(comUrlFileInfo, i.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int getQueryResult(ChannelStatInfo channelStatInfo, TrialQueryResult trialQueryResult) {
        return this.mVipChannelV2Manager.VipTrial_GetQueryResult(this.m_TransHandle, channelStatInfo, trialQueryResult);
    }

    public int reqCommit(ComUrlFileInfo comUrlFileInfo, int i, String str) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipTrial_ReqCommit(comUrlFileInfo, i, str);
        comUrlFileInfo = TAG;
        i = new StringBuilder();
        i.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        i.append(String.format("request commit", new Object[0]));
        XLLog.i(comUrlFileInfo, i.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int getCommitResult(ChannelStatInfo channelStatInfo, TrialCommitResult trialCommitResult) {
        return this.mVipChannelV2Manager.VipTrial_GetCommitResult(this.m_TransHandle, channelStatInfo, trialCommitResult);
    }
}
