package com.xunlei.vip_channel_v2;

import android.content.Context;
import com.xunlei.downloadlib.android.XLUtil;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResBtInfo;
import com.xunlei.vip_channel_v2.VipParameter.AccResResult;
import com.xunlei.vip_channel_v2.VipParameter.ChannelStatInfo;
import com.xunlei.vip_channel_v2.VipParameter.ComUrlFileInfo;
import com.xunlei.vip_channel_v2.VipParameter.OfflineSubmitResult;
import com.xunlei.vip_channel_v2.VipParameter.TrialCommitResult;
import com.xunlei.vip_channel_v2.VipParameter.TrialQueryResult;

public class VipChannelV2Manager {
    private static final String TAG = "VipChannelV2Manager";
    private static VipChannelV2Manager mInstance;
    private VipChannelV2Loader mVipChannelV2Loader = null;

    public static synchronized VipChannelV2Manager getInstance() {
        VipChannelV2Manager vipChannelV2Manager;
        synchronized (VipChannelV2Manager.class) {
            if (mInstance == null) {
                mInstance = new VipChannelV2Manager();
            }
            vipChannelV2Manager = mInstance;
        }
        return vipChannelV2Manager;
    }

    public static synchronized VipChannelV2Manager getInstance(String str) {
        synchronized (VipChannelV2Manager.class) {
            if (mInstance == null) {
                mInstance = new VipChannelV2Manager(str);
            }
            str = mInstance;
        }
        return str;
    }

    public static synchronized VipChannelV2Manager getInstance(Context context) {
        synchronized (VipChannelV2Manager.class) {
            if (mInstance == null) {
                mInstance = new VipChannelV2Manager(context);
            }
            context = mInstance;
        }
        return context;
    }

    private VipChannelV2Manager() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.mVipChannelV2Loader = r0;
        r0 = new com.xunlei.vip_channel_v2.VipChannelV2Loader;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r0.<init>();	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r2.mVipChannelV2Loader = r0;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        return;
    L_0x000e:
        r0 = "VipChannelV2Manager";
        r1 = "VipChannelV2Manager load lib failed";
        com.xunlei.downloadlib.android.XLLog.w(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.vip_channel_v2.VipChannelV2Manager.<init>():void");
    }

    private VipChannelV2Manager(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = 0;
        r3.mVipChannelV2Loader = r0;
        r0 = new com.xunlei.vip_channel_v2.VipChannelV2Loader;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r0.<init>(r4);	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r3.mVipChannelV2Loader = r0;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        return;
    L_0x000e:
        r0 = "VipChannelV2Manager";
        r1 = new java.lang.StringBuilder;
        r2 = "VipChannelV2Manager load lib failed, path:";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        com.xunlei.downloadlib.android.XLLog.w(r0, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.vip_channel_v2.VipChannelV2Manager.<init>(java.lang.String):void");
    }

    private VipChannelV2Manager(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = 0;
        r3.mVipChannelV2Loader = r0;
        r0 = new com.xunlei.vip_channel_v2.VipChannelV2Loader;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r0.<init>(r4);	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        r3.mVipChannelV2Loader = r0;	 Catch:{ UnsatisfiedLinkError -> 0x000e }
        return;
    L_0x000e:
        r0 = "VipChannelV2Manager";
        r1 = new java.lang.StringBuilder;
        r2 = "VipChannelV2Manager load lib failed,context:";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        com.xunlei.downloadlib.android.XLLog.w(r0, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.vip_channel_v2.VipChannelV2Manager.<init>(android.content.Context):void");
    }

    public int VipChannelInit(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        String str6 = XLUtil.generateGuid(context).b;
        String peerid = XLUtil.getPeerid(context);
        if (peerid == null) {
            peerid = "000000000000000V";
        }
        return this.mVipChannelV2Loader.VipChannelInit(str, i, peerid, str2, str3, str6, str4, str5);
    }

    public int VipChannelUninit() {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipChannelUninit();
    }

    public int VipChannelUpdateUserInfo(long j, String str, String str2, String str3) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipChannelUpdateUserInfo(j, str, str2, str3);
    }

    public long VipTrial_ReqQuery(ComUrlFileInfo comUrlFileInfo, int i, String str) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipTrial_ReqQuery(comUrlFileInfo, i, str);
    }

    public int VipTrial_GetQueryResult(long j, ChannelStatInfo channelStatInfo, TrialQueryResult trialQueryResult) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipTrial_GetQueryResult(j, channelStatInfo, trialQueryResult);
    }

    public long VipTrial_ReqCommit(ComUrlFileInfo comUrlFileInfo, int i, String str) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipTrial_ReqCommit(comUrlFileInfo, i, str);
    }

    public int VipTrial_GetCommitResult(long j, ChannelStatInfo channelStatInfo, TrialCommitResult trialCommitResult) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipTrial_GetCommitResult(j, channelStatInfo, trialCommitResult);
    }

    public int VipTrial_CloseTrans(long j) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipTrial_CloseTrans(j);
    }

    public long VipAccRes_ReqByBt_Mem(AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_ReqByBt_Mem(accResBtInfo, accResBtFileInfoArr);
    }

    public long VipAccRes_ReqByUrl_Mem(ComUrlFileInfo[] comUrlFileInfoArr) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_ReqByUrl_Mem(comUrlFileInfoArr);
    }

    public long VipAccRes_ReqByBt_Trial(String str, AccResBtInfo accResBtInfo, AccResBtFileInfo[] accResBtFileInfoArr) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_ReqByBt_Trial(str, accResBtInfo, accResBtFileInfoArr);
    }

    public long VipAccRes_ReqByUrl_Trial(String str, ComUrlFileInfo[] comUrlFileInfoArr) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_ReqByUrl_Trial(str, comUrlFileInfoArr);
    }

    public int VipAccRes_GetResult(long j, ChannelStatInfo channelStatInfo, AccResResult accResResult) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_GetResult(j, channelStatInfo, accResResult);
    }

    public int VipAccRes_CloseTrans(long j) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipAccRes_CloseTrans(j);
    }

    public long VipOffline_ReqSubmit(ComUrlFileInfo comUrlFileInfo, String str) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return (long) isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipOffline_ReqSubmit(comUrlFileInfo, str);
    }

    public int VipOffline_GetSubmitResult(long j, ChannelStatInfo channelStatInfo, OfflineSubmitResult offlineSubmitResult) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipOffline_GetSubmitResult(j, channelStatInfo, offlineSubmitResult);
    }

    public int VipOffline_CloseTrans(long j) {
        int isVipChannelV2ManagerInit = isVipChannelV2ManagerInit();
        if (isVipChannelV2ManagerInit != 0) {
            return isVipChannelV2ManagerInit;
        }
        return this.mVipChannelV2Loader.VipOffline_CloseTrans(j);
    }

    private int isVipChannelV2ManagerInit() {
        return this.mVipChannelV2Loader == null ? 10001 : 0;
    }
}
