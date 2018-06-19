package com.xunlei.vip_channel_v2;

import android.content.Context;
import com.xunlei.downloadlib.android.ReLinker;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResResult;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.OfflineSubmitResult;
import com.xunlei.vip_channel_v2.VipParameter.TrialCommitResult;
import com.xunlei.vip_channel_v2.VipParameter.TrialQueryResult;

public class VipChannelV2Loader {
    private static final String TAG = "XLVipChannelV2Loader";

    public native int VipAccRes_CloseTrans(long j);

    public native int VipAccRes_GetResult(long j, ChannelStatInfo channelStatInfo, AccResResult accResResult);

    public native long VipAccRes_ReqByBt_Mem(AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr);

    public native long VipAccRes_ReqByBt_Trial(String str, AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr);

    public native long VipAccRes_ReqByUrl_Mem(ComUrlFileInfo[] comUrlFileInfoArr);

    public native long VipAccRes_ReqByUrl_Trial(String str, ComUrlFileInfo[] comUrlFileInfoArr);

    public native int VipChannelInit(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7);

    public native int VipChannelUninit();

    public native int VipChannelUpdateUserInfo(long j, String str, String str2, String str3);

    public native int VipOffline_CloseTrans(long j);

    public native int VipOffline_GetSubmitResult(long j, ChannelStatInfo channelStatInfo, OfflineSubmitResult offlineSubmitResult);

    public native long VipOffline_ReqSubmit(ComUrlFileInfo comUrlFileInfo, String str);

    public native int VipTrial_CloseTrans(long j);

    public native int VipTrial_GetCommitResult(long j, ChannelStatInfo channelStatInfo, TrialCommitResult trialCommitResult);

    public native int VipTrial_GetQueryResult(long j, ChannelStatInfo channelStatInfo, TrialQueryResult trialQueryResult);

    public native long VipTrial_ReqCommit(ComUrlFileInfo comUrlFileInfo, int i, String str);

    public native long VipTrial_ReqQuery(ComUrlFileInfo comUrlFileInfo, int i, String str);

    VipChannelV2Loader() {
        XLLog.i(TAG, "VipChannelV2Loader default");
        System.loadLibrary("xl_stat");
        System.loadLibrary("xl_thunder_sdk");
    }

    VipChannelV2Loader(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("VipChannelV2Loader by path, libPath:");
        stringBuilder.append(str);
        XLLog.i(str2, stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("libxl_stat.so");
        System.load(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("libxl_thunder_sdk.so");
        System.load(stringBuilder2.toString());
    }

    VipChannelV2Loader(Context context) {
        XLLog.i(TAG, "VipChannelV2Loader by context");
        ReLinker.loadLibrary(context, "xl_stat");
        ReLinker.loadLibrary(context, "xl_thunder_sdk");
    }
}
