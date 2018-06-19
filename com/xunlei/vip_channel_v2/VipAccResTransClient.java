package com.xunlei.vip_channel_v2;

import com.tencent.open.SocialConstants;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResResult;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;

public class VipAccResTransClient {
    private static final String TAG = "VipAccResTransClient";
    private VipChannelV2Manager mVipChannelV2Manager = null;
    public long m_TransHandle = 0;
    private int m_nReqStat = 0;

    public VipAccResTransClient(VipChannelV2Manager vipChannelV2Manager) {
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
            this.mVipChannelV2Manager.VipAccRes_CloseTrans(this.m_TransHandle);
            this.m_TransHandle = 0;
            this.m_nReqStat = 0;
        }
    }

    public int reqByBt_Mem(AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipAccRes_ReqByBt_Mem(accResBtInfo, accResBtFileInfoArr);
        accResBtInfo = TAG;
        accResBtFileInfoArr = new StringBuilder();
        accResBtFileInfoArr.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        accResBtFileInfoArr.append(String.format(SocialConstants.TYPE_REQUEST, new Object[0]));
        XLLog.i(accResBtInfo, accResBtFileInfoArr.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int reqByUrl_Mem(ComUrlFileInfo[] comUrlFileInfoArr) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipAccRes_ReqByUrl_Mem(comUrlFileInfoArr);
        comUrlFileInfoArr = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        stringBuilder.append(String.format(SocialConstants.TYPE_REQUEST, new Object[0]));
        XLLog.i(comUrlFileInfoArr, stringBuilder.toString());
        if (0 == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int reqByBt_Trial(String str, AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipAccRes_ReqByBt_Trial(str, accResBtInfo, accResBtFileInfoArr);
        str = TAG;
        accResBtInfo = new StringBuilder();
        accResBtInfo.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        accResBtInfo.append(String.format(SocialConstants.TYPE_REQUEST, new Object[0]));
        XLLog.i(str, accResBtInfo.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int reqByUrl_Trial(String str, ComUrlFileInfo[] comUrlFileInfoArr) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mVipChannelV2Manager.VipAccRes_ReqByUrl_Trial(str, comUrlFileInfoArr);
        str = TAG;
        comUrlFileInfoArr = new StringBuilder();
        comUrlFileInfoArr.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        comUrlFileInfoArr.append(String.format(SocialConstants.TYPE_REQUEST, new Object[0]));
        XLLog.i(str, comUrlFileInfoArr.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int getResult(ChannelStatInfo channelStatInfo, AccResResult accResResult) {
        return this.mVipChannelV2Manager.VipAccRes_GetResult(this.m_TransHandle, channelStatInfo, accResResult);
    }
}
