package com.xunlei.vip_channel_v2;

import com.tencent.open.SocialConstants;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.OfflineSubmitResult;

public class VipOfflineTransClient {
    private static final String TAG = "VipOfflineTransClient";
    public long m_TransHandle = 0;
    private int m_nReqStat = 0;
    private VipChannelV2Manager mmVipChannelV2Manager = null;

    public VipOfflineTransClient(VipChannelV2Manager vipChannelV2Manager) {
        this.mmVipChannelV2Manager = vipChannelV2Manager;
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
            this.mmVipChannelV2Manager.VipOffline_CloseTrans(this.m_TransHandle);
            this.m_TransHandle = 0;
            this.m_nReqStat = 0;
        }
    }

    public int reqSubmit(ComUrlFileInfo comUrlFileInfo, String str) {
        if (this.m_nReqStat != 0) {
            return -1;
        }
        this.m_nReqStat = 1;
        this.m_TransHandle = this.mmVipChannelV2Manager.VipOffline_ReqSubmit(comUrlFileInfo, str);
        comUrlFileInfo = TAG;
        str = new StringBuilder();
        str.append(String.format("TransId:%d ", new Object[]{Long.valueOf(this.m_TransHandle)}));
        str.append(String.format(SocialConstants.TYPE_REQUEST, new Object[0]));
        XLLog.i(comUrlFileInfo, str.toString());
        if (null == this.m_TransHandle) {
            return -1;
        }
        return 0;
    }

    public int getSubmitResult(ChannelStatInfo channelStatInfo, OfflineSubmitResult offlineSubmitResult) {
        return this.mmVipChannelV2Manager.VipOffline_GetSubmitResult(this.m_TransHandle, channelStatInfo, offlineSubmitResult);
    }
}
