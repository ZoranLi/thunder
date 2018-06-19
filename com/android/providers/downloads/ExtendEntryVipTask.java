package com.android.providers.downloads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.xunlei.androidvip.XLAndroidVipManager;
import com.xunlei.androidvip.parameter.AndroidVipGetTaskId;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedBillingReqParam;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedBillingResponse;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedTaskReqParam;
import com.xunlei.androidvip.parameter.AndroidVipHighSpeedTaskResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtCommitReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineBtCommitResponse;
import com.xunlei.androidvip.parameter.AndroidVipOfflineCommitReqParam;
import com.xunlei.androidvip.parameter.AndroidVipOfflineCommitResponse;
import com.xunlei.androidvip.parameter.AndroidVipSubOfflineBtCommitTaskInfo;
import com.xunlei.androidvip.parameter.AndroidVipSubOfflineCommitTaskInfo;
import com.xunlei.androidvip.parameter.VipTryCommitResult;
import com.xunlei.androidvip.parameter.VipTryParam;
import com.xunlei.androidvip.parameter.VipTryQueryResult;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.proguard.ab;
import com.xunlei.download.proguard.ad;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.d;
import com.xunlei.download.proguard.h.b;
import com.xunlei.download.proguard.l;
import com.xunlei.download.proguard.l.a;
import com.xunlei.download.proguard.z;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.PeerResourceParam;
import com.xunlei.downloadlib.parameter.ServerResourceParam;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

public class ExtendEntryVipTask implements b {
    static final String PRODUCT_ID_SWJSQ = "1";
    static final String PRODUCT_TYPE = "610";
    static final String PRODUCT_TYPE_TRIAL = "611";
    static final int STAT_ERROR_COMMIT = 50002;
    static final int STAT_ERROR_COMMIT_BILLING = 50005;
    static final int STAT_ERROR_COMMIT_RUNNING = 50003;
    static final int STAT_ERROR_CREATE_FAILED = 50000;
    static final int STAT_ERROR_INIT_TASK = 50001;
    static final int STAT_ERROR_LX_ERROR = 40003;
    static final int STAT_ERROR_LX_RUNNING = 40004;
    static final int STAT_ERROR_NO_LX_RES = 40002;
    static final int STAT_ERROR_NO_VIP_RES = 20002;
    static final int STAT_ERROR_QUERY = 50004;
    static final int STAT_ERROR_QUERY_BILLING = 50006;
    static final int STAT_ERROR_SUCCESS = 0;
    static final String STAT_KEY_BILLING_ERROR = "HighSpeedTaskBillingErrorCode";
    static final String STAT_KEY_LX_BT_ERROR = "OfflineBtTaskRequetErrorCode";
    static final String STAT_KEY_LX_BT_SYNC_ERROR = "OfflineBtTaskRequestSyncErrorCode";
    static final String STAT_KEY_LX_ERROR = "OfflineTaskRequetErrorCode";
    static final String STAT_KEY_LX_SYNC_ERROR = "OfflineTaskRequestSyncErrorCode";
    static final String STAT_KEY_VIP_ERROR = "HighSpeedTaskRequetErrorCode";
    static final int THUNDER_FLAG = 1000;
    static final int VipTaskInfoCell_REASON_CONTINUE = 1;
    static final int VipTaskInfoCell_REASON_GCID = 2;
    static final int VipTaskInfoCell_REASON_NONE = 0;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command = new int[a.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.xunlei.download.proguard.l.a.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command = r0;
            r0 = 1;
            r1 = $SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.xunlei.download.proguard.l.a.a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = $SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = com.xunlei.download.proguard.l.a.b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = $SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = com.xunlei.download.proguard.l.a.c;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.values();
            r3 = r3.length;
            r3 = new int[r3];
            $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State = r3;
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.COMMIT_RUNNING;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.COMMIT;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0047 }
            r3[r4] = r1;	 Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.QUERY;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0051 }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x005c }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.STOP;	 Catch:{ NoSuchFieldError -> 0x005c }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x005c }
            r5 = 4;	 Catch:{ NoSuchFieldError -> 0x005c }
            r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.COMMIT_BILLING;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
            r5 = 5;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$State;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.State.QUERY_BILLING;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0072 }
            r5 = 6;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            r3 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.Retry.values();
            r3 = r3.length;
            r3 = new int[r3];
            $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry = r3;
            r3 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry;	 Catch:{ NoSuchFieldError -> 0x0085 }
            r4 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.Retry.OK;	 Catch:{ NoSuchFieldError -> 0x0085 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0085 }
            r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x0085 }
        L_0x0085:
            r0 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry;	 Catch:{ NoSuchFieldError -> 0x008f }
            r3 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.Retry.PENDING;	 Catch:{ NoSuchFieldError -> 0x008f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x008f }
            r0[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x008f }
        L_0x008f:
            r0 = $SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry;	 Catch:{ NoSuchFieldError -> 0x0099 }
            r1 = com.android.providers.downloads.ExtendEntryVipTask.VipChannelTask2.Retry.TIME_OUT;	 Catch:{ NoSuchFieldError -> 0x0099 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0099 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0099 }
        L_0x0099:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.ExtendEntryVipTask.1.<clinit>():void");
        }
    }

    static class VipChannelTask2 extends z.b {
        static final int HIGH_SOURCE_INVALID = 1;
        static final int MAX_RETRY_TIMES = 3;
        static final int MAX_STEP = 8;
        static final String TAG = "XlDownloadTask2";
        Context mContext;
        HighSpeedTrialChannel mHighSpeedTrialChannel = null;
        d mInfo;
        z.a mInfoDelta;
        TorrentInfo mTorrentInfo;
        HashMap<String, Channel> mVipTaskQueue = new HashMap();
        XLDownloadManager mXLDownloadManager;

        static abstract class Channel {
            private long mRetryStep;
            private long mStartTime;
            protected State mState;
            protected int mTaskStatus;

            abstract State enterChannel(XLTaskInfo xLTaskInfo, int i);

            public void removeResource(long j, int i) {
            }

            abstract void stopChannel();

            protected Channel() {
                init();
            }

            protected final Retry canRetry() {
                if (SystemClock.elapsedRealtime() - this.mStartTime <= (this.mRetryStep - 1) * 10000) {
                    return Retry.PENDING;
                }
                if (this.mRetryStep > 8) {
                    an.b(VipChannelTask2.TAG, "Retry, failed more than 3 times");
                    if (16 != DownloadManager.translateStatus(this.mTaskStatus)) {
                        this.mTaskStatus = 491;
                    }
                    String str = VipChannelTask2.TAG;
                    StringBuilder stringBuilder = new StringBuilder("Retry, failed more than 3 times, mTaskStatus = ");
                    stringBuilder.append(this.mTaskStatus);
                    an.b(str, stringBuilder.toString());
                    return Retry.TIME_OUT;
                }
                str = VipChannelTask2.TAG;
                stringBuilder = new StringBuilder("Retry, mRetryStep=");
                stringBuilder.append(this.mRetryStep - 1);
                an.b(str, stringBuilder.toString());
                this.mRetryStep *= 2;
                return Retry.OK;
            }

            protected final long getStartedTime() {
                return this.mStartTime;
            }

            protected final boolean isOutOfStep() {
                boolean z = this.mRetryStep > 8;
                if (z) {
                    an.b(VipChannelTask2.TAG, "Retry, out of step");
                }
                return z;
            }

            final boolean isStopped() {
                return this.mState == State.STOP;
            }

            final void init() {
                this.mState = State.COMMIT;
                this.mStartTime = SystemClock.elapsedRealtime();
                this.mRetryStep = 2;
                this.mTaskStatus = 190;
            }

            final int getTaskStatus() {
                return this.mTaskStatus;
            }
        }

        static class HighSpeedTrialChannel {
            int mAddResourceStatus = 190;
            private int mCheckTrialFlag = 0;
            long mCheckTrialId = 0;
            VipTryQueryResult mCheckTrialInfo = null;
            HighSpeedRetryObj mCheckTrialRetry = null;
            int mCheckTrialStatus = 190;
            Context mContext;
            private int mEnterTrialFlag = 0;
            long mEnterTrialId = 0;
            VipTryCommitResult mEnterTrialInfo = null;
            HighSpeedRetryObj mEnterTrialRetry = null;
            int mEnterTrialStatus = 190;
            long mFindResourceId = 0;
            HighSpeedRetryObj mFindResourceRetry = null;
            int mFindResourceStatus = 190;
            long mId;
            int mIdx = 0;
            String mJmpKey = "";
            AndroidVipHighSpeedTaskResponse mResourceInfo = null;
            private int mResourceRetryFlag = 0;
            int mTiralTimeOutStamp = 0;
            TorrentInfo mTorrentInfo = null;
            long mTotalBytes = -1;
            XLDownloadManager mXLDownloadManager;
            long mXLTaskId = -1;
            long mlUserId = 0;

            HighSpeedTrialChannel(Context context, long j) {
                this.mContext = context.getApplicationContext();
                this.mId = j;
                this.mXLDownloadManager = XLDownloadManager.getInstance(context);
            }

            void debug(String str) {
                String str2 = VipChannelTask2.TAG;
                StringBuilder stringBuilder = new StringBuilder("id=");
                stringBuilder.append(this.mId);
                stringBuilder.append(", ");
                stringBuilder.append(str);
                an.b(str2, stringBuilder.toString());
            }

            private AndroidVipHighSpeedTaskResponse getResourceInfo(XLTaskInfo xLTaskInfo, z.a aVar) {
                if (this.mResourceInfo != null) {
                    return this.mResourceInfo;
                }
                StringBuilder stringBuilder = new StringBuilder("getResourceInfo mFindResourceStatus=");
                stringBuilder.append(this.mFindResourceStatus);
                debug(stringBuilder.toString());
                if (this.mFindResourceStatus != 190) {
                    return null;
                }
                if (this.mFindResourceId == 0) {
                    if (this.mFindResourceRetry == null) {
                        this.mFindResourceRetry = new HighSpeedRetryObj();
                    }
                    createFindResourceTask(xLTaskInfo, aVar);
                    return null;
                }
                queryFindResourceResult();
                return this.mResourceInfo;
            }

            private VipTryQueryResult getCheckTrialInfo(XLTaskInfo xLTaskInfo, d dVar, z.a aVar) {
                if (this.mCheckTrialInfo != null) {
                    return this.mCheckTrialInfo;
                }
                StringBuilder stringBuilder = new StringBuilder("getCheckTrialInfo mCheckTrialStatus=");
                stringBuilder.append(this.mCheckTrialStatus);
                debug(stringBuilder.toString());
                if (this.mCheckTrialStatus != 190) {
                    return null;
                }
                if (getResourceInfo(xLTaskInfo, aVar) == null) {
                    if (this.mFindResourceStatus != 190) {
                        l.a().a(this.mId, 0);
                        this.mCheckTrialStatus = this.mFindResourceStatus;
                    }
                    return null;
                } else if (this.mCheckTrialId == 0) {
                    if (this.mCheckTrialRetry == null) {
                        this.mCheckTrialRetry = new HighSpeedRetryObj();
                    }
                    createCheckTrialTask(xLTaskInfo, dVar, aVar);
                    return null;
                } else {
                    queryCheckTrialResult();
                    return this.mCheckTrialInfo;
                }
            }

            private VipTryCommitResult getEnterTrialInfo(XLTaskInfo xLTaskInfo, d dVar, z.a aVar) {
                if (this.mEnterTrialInfo != null) {
                    return this.mEnterTrialInfo;
                }
                StringBuilder stringBuilder = new StringBuilder("getEnterTrialInfo mEnterTrialStatus=");
                stringBuilder.append(this.mEnterTrialStatus);
                debug(stringBuilder.toString());
                if (this.mEnterTrialStatus != 190) {
                    return null;
                }
                if (getCheckTrialInfo(xLTaskInfo, dVar, aVar) == null) {
                    if (this.mCheckTrialStatus != 190) {
                        this.mEnterTrialStatus = this.mCheckTrialStatus;
                        l.a().b(this.mId, 0);
                    }
                    return null;
                } else if (this.mEnterTrialId == 0) {
                    if (this.mEnterTrialRetry == null) {
                        this.mEnterTrialRetry = new HighSpeedRetryObj();
                    }
                    createEnterTrialTask(xLTaskInfo, dVar, aVar);
                    return null;
                } else {
                    queryEnterTrialResult(xLTaskInfo);
                    return this.mEnterTrialInfo;
                }
            }

            private int addResource(XLTaskInfo xLTaskInfo, d dVar, z.a aVar, int i) {
                dVar = getEnterTrialInfo(xLTaskInfo, dVar, aVar);
                if (dVar == null) {
                    this.mAddResourceStatus = this.mEnterTrialStatus;
                    return this.mEnterTrialStatus;
                }
                if (this.mXLTaskId != xLTaskInfo.mTaskId) {
                    if (this.mAddResourceStatus != 501) {
                        this.mXLTaskId = xLTaskInfo.mTaskId;
                        aVar = ad.b(this.mContext);
                        if (TextUtils.isEmpty(aVar)) {
                            aVar = "1.0.1";
                        }
                        int i2 = 0;
                        int i3 = i2;
                        while (true) {
                            int i4 = 1;
                            if (i2 >= this.mResourceInfo.mPeerCount) {
                                break;
                            }
                            PeerResourceParam peerResourceParam = new PeerResourceParam();
                            peerResourceParam.mUserId = this.mlUserId;
                            peerResourceParam.mJmpKey = this.mJmpKey;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(dVar.mVerifyInfo);
                            stringBuilder.append("&tm=android&ver=");
                            stringBuilder.append(aVar);
                            peerResourceParam.mVipCdnAuth = stringBuilder.toString();
                            peerResourceParam.mUdpPort = this.mResourceInfo.mPeerRes[i2].mUdpPort;
                            peerResourceParam.mTcpPort = this.mResourceInfo.mPeerRes[i2].mTcpPort;
                            peerResourceParam.mInternalIp = (int) this.mResourceInfo.mPeerRes[i2].mIp;
                            peerResourceParam.mPeerId = this.mResourceInfo.mPeerRes[i2].mPeerId;
                            peerResourceParam.mResLevel = this.mResourceInfo.mPeerRes[i2].mResourceLevel;
                            peerResourceParam.mResPriority = this.mResourceInfo.mPeerRes[i2].mResourceUseLevel;
                            peerResourceParam.mCapabilityFlag = this.mResourceInfo.mPeerRes[i2].mCapability;
                            peerResourceParam.mResType = this.mResourceInfo.mPeerRes[i2].mCdnType;
                            int btAddPeerResource = this.mXLDownloadManager.btAddPeerResource(xLTaskInfo.mTaskId, i, peerResourceParam);
                            if (btAddPeerResource != 9000) {
                                i4 = 0;
                            }
                            i3 |= i4;
                            StringBuilder stringBuilder2 = new StringBuilder("btAddPeerResource ret = ");
                            stringBuilder2.append(btAddPeerResource);
                            stringBuilder2.append(",peerId=");
                            stringBuilder2.append(peerResourceParam.mPeerId);
                            debug(stringBuilder2.toString());
                            i2++;
                        }
                        if (this.mResourceInfo.mDcdnResCount > null) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            this.mAddResourceStatus = 200;
                        } else {
                            this.mAddResourceStatus = 491;
                        }
                        return this.mAddResourceStatus;
                    }
                }
                return this.mAddResourceStatus;
            }

            private void reStartTrialDcdn(XLTaskInfo xLTaskInfo, d dVar) {
                String property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_SESSION_ID, "");
                this.mXLDownloadManager.setTaskGsState(xLTaskInfo.mTaskId, this.mIdx, 2);
                this.mXLDownloadManager.startDcdn(xLTaskInfo.mTaskId, this.mIdx, property, ExtendEntryVipTask.PRODUCT_TYPE_TRIAL, this.mEnterTrialInfo.mVerifyInfo);
            }

            private void removeResource(long j, int i) {
                StringBuilder stringBuilder = new StringBuilder("HispeedTrial remove resource, id=");
                stringBuilder.append(j);
                stringBuilder.append(", idx=");
                stringBuilder.append(i);
                debug(stringBuilder.toString());
                this.mXLDownloadManager.btRemoveAddedResource(j, i, 3);
                this.mXLDownloadManager.stopDcdn(j, i);
            }

            private void createFindResourceTask(XLTaskInfo xLTaskInfo, z.a aVar) {
                aVar = new AndroidVipGetTaskId();
                AndroidVipHighSpeedTaskReqParam androidVipHighSpeedTaskReqParam = new AndroidVipHighSpeedTaskReqParam();
                Object property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                androidVipHighSpeedTaskReqParam.mUserId = !TextUtils.isEmpty(property) ? Long.parseLong(property) : 0;
                androidVipHighSpeedTaskReqParam.mCid = xLTaskInfo.mCid;
                androidVipHighSpeedTaskReqParam.mGcid = xLTaskInfo.mGcid;
                androidVipHighSpeedTaskReqParam.mFileSize = this.mTotalBytes;
                androidVipHighSpeedTaskReqParam.mHighSpeedType = 1;
                int AndroidVipCreateEnterHighSpeedTask = XLAndroidVipManager.getInstance(this.mContext).AndroidVipCreateEnterHighSpeedTask(aVar, androidVipHighSpeedTaskReqParam);
                if (AndroidVipCreateEnterHighSpeedTask == 0) {
                    XLAndroidVipManager.getInstance(this.mContext).vipSetTaskRetryFlag(aVar.getTaskId(), this.mResourceRetryFlag);
                    if (this.mResourceRetryFlag == 0) {
                        this.mResourceRetryFlag = 1;
                    }
                    this.mFindResourceId = aVar.getTaskId();
                    xLTaskInfo = new StringBuilder("createFindResourceTask mFindResourceId= ");
                    xLTaskInfo.append(this.mFindResourceId);
                    debug(xLTaskInfo.toString());
                    return;
                }
                this.mFindResourceStatus = 491;
                xLTaskInfo = new StringBuilder("createFindResourceTask ret= ");
                xLTaskInfo.append(AndroidVipCreateEnterHighSpeedTask);
                debug(xLTaskInfo.toString());
            }

            private void queryFindResourceResult() {
                AndroidVipHighSpeedTaskResponse androidVipHighSpeedTaskResponse = new AndroidVipHighSpeedTaskResponse();
                int AndroidVipGetHighSpeedTaskResp = XLAndroidVipManager.getInstance().AndroidVipGetHighSpeedTaskResp(this.mFindResourceId, androidVipHighSpeedTaskResponse);
                if (AndroidVipGetHighSpeedTaskResp == 0 && androidVipHighSpeedTaskResponse.mResult == 0) {
                    if (androidVipHighSpeedTaskResponse.mPeerCount > 0 || androidVipHighSpeedTaskResponse.mDcdnResCount > 0) {
                        this.mFindResourceStatus = 200;
                        this.mResourceInfo = androidVipHighSpeedTaskResponse;
                        debug(",queryFindResourceResult, success");
                        l.a().a(this.mId, true);
                    } else {
                        this.mFindResourceStatus = 500;
                        l.a().a(this.mId, false);
                        debug(",queryFindResourceResult, have no peer count, entry highspeed error");
                    }
                    stopFindResource();
                } else if (AndroidVipGetHighSpeedTaskResp == XLAndroidVipManager.RUNNING) {
                    debug(",queryFindResourceResult, 7002");
                    int i = AnonymousClass1.$SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry[this.mFindResourceRetry.canRetry().ordinal()];
                    if (i != 1) {
                        if (i == 3) {
                            l.a().a(this.mId, false);
                            this.mFindResourceStatus = 491;
                            stopFindResource();
                        }
                        return;
                    }
                    stopFindResource();
                } else {
                    StringBuilder stringBuilder = new StringBuilder("queryFindResourceResult, error Resp.mResult=");
                    stringBuilder.append(androidVipHighSpeedTaskResponse.mResult);
                    stringBuilder.append(", ret = ");
                    stringBuilder.append(AndroidVipGetHighSpeedTaskResp);
                    debug(stringBuilder.toString());
                    this.mFindResourceStatus = VipChannelTask2.translateErrorCodeToStatus(androidVipHighSpeedTaskResponse.mResult);
                    l.a().a(this.mId, false);
                    stopFindResource();
                }
            }

            private void createCheckTrialTask(XLTaskInfo xLTaskInfo, d dVar, z.a aVar) {
                Object property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                long parseLong = !TextUtils.isEmpty(property) ? Long.parseLong(property) : 0;
                VipTryParam vipTryParam = new VipTryParam();
                vipTryParam.mCurrentSpeed = xLTaskInfo.mDownloadSpeed;
                vipTryParam.mBandwidth = -1;
                vipTryParam.mGcid = xLTaskInfo.mGcid;
                vipTryParam.mCid = xLTaskInfo.mCid;
                vipTryParam.mFileSize = this.mTotalBytes;
                vipTryParam.mFileName = "";
                vipTryParam.mUserId = parseLong;
                if (TextUtils.isEmpty(aVar.b) == null) {
                    vipTryParam.mFileName = aVar.b.substring(aVar.b.lastIndexOf(File.separator) + 1);
                }
                if (dVar.W == TaskType.BT) {
                    xLTaskInfo = getTorrentInfo(dVar);
                    if (xLTaskInfo == null) {
                        this.mCheckTrialStatus = 491;
                        debug("createCheckTrialTask, not find info hash ");
                        return;
                    }
                    vipTryParam.mResId = xLTaskInfo.mInfoHash;
                    vipTryParam.mUrl = "";
                    vipTryParam.mResType = 1;
                    vipTryParam.mFileIndex = this.mIdx;
                } else {
                    vipTryParam.mResId = "";
                    vipTryParam.mUrl = dVar.d;
                    vipTryParam.mResType = 0;
                    vipTryParam.mFileIndex = 0;
                }
                vipTryParam.mTrialKey = "";
                xLTaskInfo = new AndroidVipGetTaskId();
                dVar = XLAndroidVipManager.getInstance(this.mContext).vipCreateHighSpeedTryTask(vipTryParam, xLTaskInfo);
                if (dVar == null) {
                    XLAndroidVipManager.getInstance(this.mContext).vipSetTaskRetryFlag(xLTaskInfo.getTaskId(), this.mCheckTrialFlag);
                    if (this.mCheckTrialFlag == null) {
                        this.mCheckTrialFlag = 1;
                    }
                    this.mCheckTrialId = xLTaskInfo.getTaskId();
                    xLTaskInfo = new StringBuilder("createCheckTrialTask mCheckTrialId= ");
                    xLTaskInfo.append(this.mCheckTrialId);
                    debug(xLTaskInfo.toString());
                    return;
                }
                this.mCheckTrialStatus = 491;
                xLTaskInfo = new StringBuilder("createCheckTrialTask err ,ret= ");
                xLTaskInfo.append(dVar);
                debug(xLTaskInfo.toString());
            }

            private void queryCheckTrialResult() {
                VipTryQueryResult vipTryQueryResult = new VipTryQueryResult();
                int vipGetHighSpeedTryResult = XLAndroidVipManager.getInstance(this.mContext).vipGetHighSpeedTryResult(this.mCheckTrialId, vipTryQueryResult);
                if (vipGetHighSpeedTryResult == 0 && vipTryQueryResult.mResult == 0) {
                    if (vipTryQueryResult.mTrialRemain > 0) {
                        this.mCheckTrialInfo = vipTryQueryResult;
                        this.mCheckTrialStatus = 200;
                        l.a().a(this.mId, vipTryQueryResult.mTrialRemain);
                    } else {
                        this.mCheckTrialStatus = 491;
                        l.a().a(this.mId, 0);
                    }
                    StringBuilder stringBuilder = new StringBuilder("queryCheckTrialResult, mHasTrial=");
                    stringBuilder.append(vipTryQueryResult.mHasTrial);
                    stringBuilder.append(", mTrialKey=");
                    stringBuilder.append(vipTryQueryResult.mTrialKey);
                    stringBuilder.append(", mTrialRemain=");
                    stringBuilder.append(vipTryQueryResult.mTrialRemain);
                    debug(stringBuilder.toString());
                    stopCheckTrial();
                } else if (vipGetHighSpeedTryResult == XLAndroidVipManager.RUNNING) {
                    debug("queryCheckTrialResult,7002");
                    int i = AnonymousClass1.$SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry[this.mCheckTrialRetry.canRetry().ordinal()];
                    if (i != 1) {
                        if (i == 3) {
                            stopCheckTrial();
                            this.mCheckTrialStatus = 491;
                            l.a().a(this.mId, 0);
                        }
                        return;
                    }
                    stopCheckTrial();
                } else {
                    this.mCheckTrialStatus = VipChannelTask2.translateErrorCodeToStatus(vipTryQueryResult.mResult);
                    l.a().a(this.mId, 0);
                    stopCheckTrial();
                    StringBuilder stringBuilder2 = new StringBuilder("queryCheckTrialResult, err Resp.mResult = ");
                    stringBuilder2.append(vipTryQueryResult.mResult);
                    stringBuilder2.append(", ret=");
                    stringBuilder2.append(vipGetHighSpeedTryResult);
                    debug(stringBuilder2.toString());
                }
            }

            void createEnterTrialTask(XLTaskInfo xLTaskInfo, d dVar, z.a aVar) {
                Object property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                long parseLong = !TextUtils.isEmpty(property) ? Long.parseLong(property) : 0;
                AndroidVipGetTaskId androidVipGetTaskId = new AndroidVipGetTaskId();
                VipTryParam vipTryParam = new VipTryParam();
                vipTryParam.mCurrentSpeed = xLTaskInfo.mDownloadSpeed;
                vipTryParam.mBandwidth = -1;
                vipTryParam.mGcid = xLTaskInfo.mGcid;
                vipTryParam.mCid = xLTaskInfo.mCid;
                vipTryParam.mFileSize = this.mTotalBytes;
                vipTryParam.mFileName = "";
                vipTryParam.mUserId = parseLong;
                if (!TextUtils.isEmpty(aVar.b)) {
                    vipTryParam.mFileName = aVar.b.substring(aVar.b.lastIndexOf(File.separator) + 1);
                }
                if (dVar.W == TaskType.BT) {
                    dVar = getTorrentInfo(dVar);
                    if (dVar == null) {
                        this.mEnterTrialStatus = 491;
                        debug("createEnterTrialTask err, not find info hash ");
                        return;
                    }
                    vipTryParam.mResId = dVar.mInfoHash;
                    vipTryParam.mUrl = "";
                    vipTryParam.mResType = 1;
                    vipTryParam.mFileIndex = this.mIdx;
                } else {
                    vipTryParam.mResId = "";
                    vipTryParam.mUrl = dVar.d;
                    vipTryParam.mResType = 0;
                    vipTryParam.mFileIndex = 0;
                }
                vipTryParam.mTrialKey = this.mCheckTrialInfo.mTrialKey;
                this.mXLDownloadManager.setTaskGsState(xLTaskInfo.mTaskId, this.mIdx, 2);
                xLTaskInfo = XLAndroidVipManager.getInstance(this.mContext).vipCreateHighSpeedTryCommitTask(vipTryParam, androidVipGetTaskId);
                if (xLTaskInfo == null) {
                    XLAndroidVipManager.getInstance(this.mContext).vipSetTaskRetryFlag(androidVipGetTaskId.getTaskId(), this.mEnterTrialFlag);
                    if (this.mEnterTrialFlag == null) {
                        this.mEnterTrialFlag = 1;
                    }
                    this.mEnterTrialId = androidVipGetTaskId.getTaskId();
                    xLTaskInfo = new StringBuilder("createEnterTrialTask mEnterTrialId= ");
                    xLTaskInfo.append(this.mEnterTrialId);
                    debug(xLTaskInfo.toString());
                    return;
                }
                this.mEnterTrialStatus = 491;
                dVar = new StringBuilder("createEnterTrialTask err, ret= ");
                dVar.append(xLTaskInfo);
                debug(dVar.toString());
            }

            void queryEnterTrialResult(XLTaskInfo xLTaskInfo) {
                VipTryCommitResult vipTryCommitResult = new VipTryCommitResult();
                int vipGetHighSpeedTryCommitResult = XLAndroidVipManager.getInstance(this.mContext).vipGetHighSpeedTryCommitResult(this.mEnterTrialId, vipTryCommitResult);
                if (vipGetHighSpeedTryCommitResult == 0 && vipTryCommitResult.mResult == 0) {
                    this.mEnterTrialInfo = vipTryCommitResult;
                    this.mEnterTrialStatus = 200;
                    l.a().b(this.mId, vipTryCommitResult.mTrialDuration);
                    this.mTiralTimeOutStamp = ((int) (SystemClock.elapsedRealtime() / 1000)) + vipTryCommitResult.mTrialDuration;
                    l.a().b(this.mId, this.mTiralTimeOutStamp);
                    stopEnterTrial();
                    this.mXLDownloadManager.startDcdn(xLTaskInfo.mTaskId, this.mIdx, DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_SESSION_ID, ""), ExtendEntryVipTask.PRODUCT_TYPE_TRIAL, vipTryCommitResult.mVerifyInfo);
                    xLTaskInfo = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                    long j = 0;
                    if (!TextUtils.isEmpty(xLTaskInfo)) {
                        j = Long.parseLong(xLTaskInfo);
                    }
                    xLTaskInfo = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
                    this.mlUserId = j;
                    this.mJmpKey = xLTaskInfo;
                    xLTaskInfo = new StringBuilder("queryEnterTrialResult success, mTrialDuration = ");
                    xLTaskInfo.append(vipTryCommitResult.mTrialDuration);
                    xLTaskInfo.append(", mVerifyInfo = ");
                    xLTaskInfo.append(vipTryCommitResult.mVerifyInfo);
                    debug(xLTaskInfo.toString());
                } else if (vipGetHighSpeedTryCommitResult == XLAndroidVipManager.RUNNING) {
                    debug("queryEnterTrialResult 7002");
                    xLTaskInfo = AnonymousClass1.$SwitchMap$com$android$providers$downloads$ExtendEntryVipTask$VipChannelTask2$Retry[this.mEnterTrialRetry.canRetry().ordinal()];
                    if (xLTaskInfo != 1) {
                        if (xLTaskInfo == 3) {
                            stopEnterTrial();
                            l.a().b(this.mId, 0);
                            this.mEnterTrialStatus = 491;
                        }
                        return;
                    }
                    stopEnterTrial();
                } else {
                    this.mEnterTrialStatus = VipChannelTask2.translateErrorCodeToStatus(vipTryCommitResult.mResult);
                    l.a().b(this.mId, 0);
                    stopEnterTrial();
                    xLTaskInfo = new StringBuilder("queryEnterTrialResult Resp.mResult=");
                    xLTaskInfo.append(vipTryCommitResult.mResult);
                    xLTaskInfo.append(", ret=");
                    xLTaskInfo.append(vipGetHighSpeedTryCommitResult);
                    debug(xLTaskInfo.toString());
                }
            }

            TorrentInfo getTorrentInfo(d dVar) {
                if (this.mTorrentInfo == null) {
                    this.mTorrentInfo = new TorrentInfo();
                    String path = Uri.parse(dVar.d).getPath();
                    if (!new File(path).exists()) {
                        path = ab.a(dVar.g, dVar.x);
                    }
                    dVar = this.mXLDownloadManager.getTorrentInfo(path, this.mTorrentInfo);
                    if (dVar != 9000) {
                        this.mTorrentInfo = null;
                        String str = VipChannelTask2.TAG;
                        StringBuilder stringBuilder = new StringBuilder("getTorrentInfo ret=");
                        stringBuilder.append(dVar);
                        an.b(str, stringBuilder.toString());
                        return null;
                    }
                }
                return this.mTorrentInfo;
            }

            private final void stopFindResource() {
                if (this.mFindResourceId != 0) {
                    debug("stopFindResource");
                    XLAndroidVipManager.getInstance(this.mContext).AndroidVipDestroyHighSpeedTask(this.mFindResourceId);
                    this.mFindResourceId = 0;
                }
            }

            private final void stopCheckTrial() {
                if (this.mCheckTrialId != 0) {
                    debug("stopCheckTrial");
                    XLAndroidVipManager.getInstance(this.mContext).vipDestoryHighSpeedTryTask(this.mCheckTrialId);
                    this.mCheckTrialId = 0;
                }
            }

            private final void stopEnterTrial() {
                if (this.mEnterTrialId != 0) {
                    debug("stopEnterTrial");
                    XLAndroidVipManager.getInstance(this.mContext).vipDestoryHighSpeedTryCommitTask(this.mEnterTrialId);
                    this.mEnterTrialId = 0;
                    this.mTorrentInfo = null;
                }
            }

            void stopChannel() {
                stopFindResource();
                stopCheckTrial();
                stopEnterTrial();
            }

            int getHighSpeedStatus(XLTaskInfo xLTaskInfo) {
                if (this.mAddResourceStatus != 200 || ((int) (SystemClock.elapsedRealtime() / 1000)) < this.mTiralTimeOutStamp) {
                    return this.mAddResourceStatus;
                }
                removeResource(xLTaskInfo.mTaskId, this.mIdx);
                debug("addResource timeout");
                this.mAddResourceStatus = 501;
                return this.mAddResourceStatus;
            }

            boolean canSpeedUp() {
                if (this.mAddResourceStatus != 200) {
                    return false;
                }
                if (((int) (SystemClock.elapsedRealtime() / 1000)) < this.mTiralTimeOutStamp) {
                    return true;
                }
                this.mAddResourceStatus = 501;
                debug("canSpeedUp timeout");
                return false;
            }
        }

        enum Retry {
            OK,
            PENDING,
            TIME_OUT
        }

        enum State {
            COMMIT,
            COMMIT_RUNNING,
            QUERY,
            COMMIT_BILLING,
            QUERY_BILLING,
            STOP
        }

        static class HighSpeedRetryObj extends Channel {
            State enterChannel(XLTaskInfo xLTaskInfo, int i) {
                return null;
            }

            void stopChannel() {
            }

            HighSpeedRetryObj() {
            }
        }

        class LixianChannel extends Channel {
            private boolean mHasGcid;
            private boolean mIsBtTask;
            private boolean mIsSpeedUpChannel = false;
            private boolean mLixianRunning = false;
            private long mLixianTaskId = 0;
            private long mNextRequeryTimeStamp = 0;
            private int mRequeryTimes = 1;
            private int mRetryFlag = 0;
            long mTotalBytes = 0;

            LixianChannel(boolean z) {
                this.mIsBtTask = z;
                this.mHasGcid = false;
                this.mIsSpeedUpChannel = false;
            }

            LixianChannel(boolean z, boolean z2) {
                this.mIsBtTask = z;
                this.mHasGcid = false;
                this.mIsSpeedUpChannel = z2;
            }

            public void stopChannel() {
                if (this.mLixianTaskId != 0) {
                    if (this.mIsBtTask) {
                        XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipDestroyOfflineBtCommitReq(this.mLixianTaskId);
                    } else {
                        XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipDestroyOfflineCommitReq(this.mLixianTaskId);
                    }
                    VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("LixianChannelTask stopChannel id=");
                    stringBuilder.append(this.mLixianTaskId);
                    vipChannelTask2.debug(stringBuilder.toString());
                    this.mLixianTaskId = 0;
                }
            }

            public State enterChannel(XLTaskInfo xLTaskInfo, int i) {
                State state = this.mState;
                VipChannelTask2 vipChannelTask2;
                StringBuilder stringBuilder;
                switch (this.mState) {
                    case COMMIT_RUNNING:
                        if (this.mRequeryTimes > 4) {
                            stopChannel();
                            this.mState = State.STOP;
                            VipChannelTask2.this.debug("enterChannel retry for pending or running stop for timeout");
                        } else if (this.mNextRequeryTimeStamp == 0) {
                            vipChannelTask2 = VipChannelTask2.this;
                            stringBuilder = new StringBuilder("enterChannel retry for pending or running after ");
                            stringBuilder.append(this.mRequeryTimes);
                            stringBuilder.append(" minutes");
                            vipChannelTask2.debug(stringBuilder.toString());
                            stopChannel();
                            this.mNextRequeryTimeStamp = SystemClock.elapsedRealtime() + ((long) (this.mRequeryTimes * BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                        } else if (SystemClock.elapsedRealtime() > this.mNextRequeryTimeStamp) {
                            init();
                            this.mLixianRunning = true;
                            this.mNextRequeryTimeStamp = 0;
                            this.mRequeryTimes *= 2;
                            VipChannelTask2.this.debug("enterChannel retry for pending or running begin");
                        }
                        if (VipChannelTask2.this.mInfo.W == TaskType.BT) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_BT_ERROR : ExtendEntryVipTask.STAT_KEY_LX_BT_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT_RUNNING);
                            break;
                        }
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_ERROR : ExtendEntryVipTask.STAT_KEY_LX_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT_RUNNING);
                        break;
                    case COMMIT:
                        stopChannel();
                        Object access$100 = VipChannelTask2.this.getCid(xLTaskInfo);
                        Object access$200 = VipChannelTask2.this.getGcid(xLTaskInfo);
                        if (TextUtils.isEmpty(access$100) || TextUtils.isEmpty(access$200)) {
                            if (SystemClock.elapsedRealtime() - getStartedTime() < 1000) {
                                VipChannelTask2.this.debug("wait for cid or gcid");
                                return this.mState;
                            }
                            this.mHasGcid = false;
                        }
                        this.mLixianTaskId = commitLiXian(i, xLTaskInfo, access$100, access$200);
                        if (this.mLixianTaskId > 0) {
                            this.mState = State.QUERY;
                            vipChannelTask2 = VipChannelTask2.this;
                            stringBuilder = new StringBuilder("LixianChannelTask enterChannel mLixianTaskId=");
                            stringBuilder.append(this.mLixianTaskId);
                            vipChannelTask2.debug(stringBuilder.toString());
                        } else {
                            this.mState = State.STOP;
                        }
                        if (VipChannelTask2.this.mInfo.W == TaskType.BT) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_BT_ERROR : ExtendEntryVipTask.STAT_KEY_LX_BT_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT);
                            break;
                        }
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_ERROR : ExtendEntryVipTask.STAT_KEY_LX_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT);
                        break;
                    case QUERY:
                        if (VipChannelTask2.this.mInfo.W != TaskType.BT) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_ERROR : ExtendEntryVipTask.STAT_KEY_LX_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_QUERY);
                        } else {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, this.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_BT_ERROR : ExtendEntryVipTask.STAT_KEY_LX_BT_SYNC_ERROR, ExtendEntryVipTask.STAT_ERROR_QUERY);
                        }
                        switch (canRetry()) {
                            case OK:
                                this.mLixianRunning = false;
                                this.mState = State.COMMIT;
                                enterChannel(xLTaskInfo, i);
                                break;
                            case PENDING:
                                this.mState = queryLixian(xLTaskInfo.mTaskId, i);
                                break;
                            default:
                                stopChannel();
                                this.mState = State.STOP;
                                break;
                        }
                    case STOP:
                        stopChannel();
                        break;
                    default:
                        stopChannel();
                        this.mState = State.STOP;
                        break;
                }
                xLTaskInfo = VipChannelTask2.this;
                i = new StringBuilder("LixianChannelTask enterChannel oldState = ");
                i.append(state);
                i.append(", newState = ");
                i.append(this.mState);
                xLTaskInfo.debug(i.toString());
                return this.mState;
            }

            private long commitLiXian(int i, XLTaskInfo xLTaskInfo, String str, String str2) {
                int AndroidVipOfflineCommitReq;
                int i2 = i;
                XLTaskInfo xLTaskInfo2 = xLTaskInfo;
                String str3 = str;
                String str4 = str2;
                AndroidVipGetTaskId androidVipGetTaskId = new AndroidVipGetTaskId();
                String property = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                String property2 = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
                if (VipChannelTask2.this.mInfo.W != TaskType.BT) {
                    AndroidVipOfflineCommitReqParam androidVipOfflineCommitReqParam = new AndroidVipOfflineCommitReqParam();
                    if (VipChannelTask2.this.mInfo.W != TaskType.CID) {
                        if (str3 == null) {
                            str3 = "";
                        }
                        androidVipOfflineCommitReqParam.mCid = str3;
                        androidVipOfflineCommitReqParam.mGcid = str4 == null ? "" : str4;
                        androidVipOfflineCommitReqParam.mUrl = VipChannelTask2.this.mInfo.d;
                    } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        return 0;
                    } else {
                        androidVipOfflineCommitReqParam.mCid = str3;
                        androidVipOfflineCommitReqParam.mGcid = str4;
                        androidVipOfflineCommitReqParam.mUrl = "";
                    }
                    androidVipOfflineCommitReqParam.mAutoCharge = (byte) 0;
                    androidVipOfflineCommitReqParam.mUserId = Long.valueOf(property).longValue();
                    androidVipOfflineCommitReqParam.mKey = property2;
                    androidVipOfflineCommitReqParam.mRefUrl = VipChannelTask2.this.mInfo.u == null ? "" : VipChannelTask2.this.mInfo.u;
                    androidVipOfflineCommitReqParam.mCookie = VipChannelTask2.this.mInfo.s == null ? "" : VipChannelTask2.this.mInfo.s;
                    str3 = "";
                    if (!TextUtils.isEmpty(VipChannelTask2.this.mInfoDelta.b)) {
                        str3 = VipChannelTask2.this.mInfoDelta.b.substring(VipChannelTask2.this.mInfoDelta.b.lastIndexOf(File.separator) + 1);
                    }
                    androidVipOfflineCommitReqParam.mTaskName = str3;
                    androidVipOfflineCommitReqParam.mFileSize = r0.mTotalBytes;
                    androidVipOfflineCommitReqParam.mFileType = 0;
                    androidVipOfflineCommitReqParam.mVipLevel = (byte) 0;
                    AndroidVipOfflineCommitReq = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipOfflineCommitReq(androidVipGetTaskId, androidVipOfflineCommitReqParam);
                    VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("AndroidVipOfflineCommitReq, ret = ");
                    stringBuilder.append(AndroidVipOfflineCommitReq);
                    stringBuilder.append(", mCid= ");
                    stringBuilder.append(androidVipOfflineCommitReqParam.mCid);
                    stringBuilder.append(", taskParam.mGcid=");
                    stringBuilder.append(androidVipOfflineCommitReqParam.mGcid);
                    stringBuilder.append(", taskName=");
                    stringBuilder.append(str3);
                    vipChannelTask2.debug(stringBuilder.toString());
                } else {
                    if (VipChannelTask2.this.mTorrentInfo == null) {
                        VipChannelTask2.this.mTorrentInfo = new TorrentInfo();
                        str3 = Uri.parse(VipChannelTask2.this.mInfo.d).getPath();
                        if (!new File(str3).exists()) {
                            str3 = ab.a(VipChannelTask2.this.mInfo.g, VipChannelTask2.this.mInfo.x);
                        }
                        int torrentInfo = VipChannelTask2.this.mXLDownloadManager.getTorrentInfo(str3, VipChannelTask2.this.mTorrentInfo);
                        if (torrentInfo != 9000) {
                            VipChannelTask2.this.mTorrentInfo = null;
                            String str5 = VipChannelTask2.TAG;
                            StringBuilder stringBuilder2 = new StringBuilder("getTorrentInfo ret=");
                            stringBuilder2.append(torrentInfo);
                            an.b(str5, stringBuilder2.toString());
                            return 0;
                        }
                    }
                    AndroidVipOfflineBtCommitReqParam androidVipOfflineBtCommitReqParam = new AndroidVipOfflineBtCommitReqParam();
                    androidVipOfflineBtCommitReqParam.mAutoCharge = (byte) 0;
                    androidVipOfflineBtCommitReqParam.mUserId = Long.valueOf(property).longValue();
                    androidVipOfflineBtCommitReqParam.mKey = property2;
                    androidVipOfflineBtCommitReqParam.mInfoHash = VipChannelTask2.this.mTorrentInfo.mInfoHash;
                    androidVipOfflineBtCommitReqParam.mRefUrl = VipChannelTask2.this.mInfo.u == null ? "" : VipChannelTask2.this.mInfo.u;
                    androidVipOfflineBtCommitReqParam.mBtTitle = VipChannelTask2.this.mTorrentInfo.mMultiFileBaseFolder;
                    androidVipOfflineBtCommitReqParam.mVipLevel = (byte) 0;
                    androidVipOfflineBtCommitReqParam.mFilePath = "";
                    androidVipOfflineBtCommitReqParam.mFileListNum = 1;
                    androidVipOfflineBtCommitReqParam.mFileList = new int[1];
                    androidVipOfflineBtCommitReqParam.mFileList[0] = VipChannelTask2.this.mTorrentInfo.mSubFileInfo[i2].mRealIndex;
                    AndroidVipOfflineCommitReq = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipOfflineBtCommitReq(androidVipGetTaskId, androidVipOfflineBtCommitReqParam);
                }
                if (AndroidVipOfflineCommitReq == 0) {
                    if (VipChannelTask2.this.mInfo.P) {
                        VipChannelTask2.this.mXLDownloadManager.setTaskLxState(xLTaskInfo2.mTaskId, i2, 1);
                        VipChannelTask2.this.mXLDownloadManager.startDcdn(xLTaskInfo2.mTaskId, i2, DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_SESSION_ID, ""), ExtendEntryVipTask.PRODUCT_TYPE, "");
                    }
                    VipChannelTask2.this.mTorrentInfo = null;
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).vipSetTaskRetryFlag(androidVipGetTaskId.getTaskId(), r0.mRetryFlag);
                    if (r0.mRetryFlag == 0) {
                        r0.mRetryFlag = 1;
                    }
                    return androidVipGetTaskId.getTaskId();
                }
                r0.mTaskStatus = 491;
                VipChannelTask2 vipChannelTask22 = VipChannelTask2.this;
                StringBuilder stringBuilder3 = new StringBuilder("AndroidVipOfflineCommitReq,error ret=");
                stringBuilder3.append(AndroidVipOfflineCommitReq);
                vipChannelTask22.debug(stringBuilder3.toString());
                VipChannelTask2.this.mTorrentInfo = null;
                return 0;
            }

            State updateLixianStatus(int i) {
                State state = State.STOP;
                switch (i) {
                    case 0:
                    case 1:
                        this.mTaskStatus = 192;
                        return State.COMMIT_RUNNING;
                    case 2:
                        this.mTaskStatus = 200;
                        return State.STOP;
                    case 3:
                    case 4:
                        this.mTaskStatus = VipChannelTask2.translateErrorCodeToStatus(ExtendEntryVipTask.STAT_ERROR_LX_ERROR);
                        return State.STOP;
                    default:
                        return state;
                }
            }

            private State queryLixian(long j, int i) {
                int AndroidVipGetOfflineCommitResp;
                int i2;
                String str;
                VipChannelTask2 vipChannelTask2;
                StringBuilder stringBuilder;
                long j2 = j;
                int i3 = i;
                String str2 = "";
                String str3;
                State updateLixianStatus;
                if (VipChannelTask2.this.mInfo.W != TaskType.BT) {
                    str3 = r0.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_ERROR : ExtendEntryVipTask.STAT_KEY_LX_SYNC_ERROR;
                    AndroidVipOfflineCommitResponse androidVipOfflineCommitResponse = new AndroidVipOfflineCommitResponse();
                    AndroidVipGetOfflineCommitResp = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipGetOfflineCommitResp(r0.mLixianTaskId, androidVipOfflineCommitResponse);
                    if (AndroidVipGetOfflineCommitResp == XLAndroidVipManager.RUNNING) {
                        if (!r0.mLixianRunning) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, AndroidVipGetOfflineCommitResp);
                        }
                        return State.QUERY;
                    }
                    if (AndroidVipGetOfflineCommitResp != 0 || androidVipOfflineCommitResponse.mResult != 0) {
                        i2 = androidVipOfflineCommitResponse.mResult;
                        str = androidVipOfflineCommitResponse.mMessage;
                    } else if (androidVipOfflineCommitResponse.mTaskinfo == null || androidVipOfflineCommitResponse.mTaskinfo.length <= 0) {
                        str = str2;
                        i2 = ExtendEntryVipTask.STAT_ERROR_NO_LX_RES;
                    } else {
                        AndroidVipSubOfflineCommitTaskInfo androidVipSubOfflineCommitTaskInfo = androidVipOfflineCommitResponse.mTaskinfo[0];
                        VipChannelTask2.this.mInfoDelta.y = (long) androidVipSubOfflineCommitTaskInfo.mProgress;
                        updateLixianStatus = updateLixianStatus(androidVipSubOfflineCommitTaskInfo.mDownloadStatus);
                        if (r0.mTaskStatus == 200 && !TextUtils.isEmpty(androidVipSubOfflineCommitTaskInfo.mLixianUrl)) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, 0);
                            if (VipChannelTask2.this.mInfo.P && !addLixianResource(makeLixianResource(androidVipSubOfflineCommitTaskInfo), j2, i3)) {
                                r0.mTaskStatus = 491;
                            }
                        } else if (r0.mTaskStatus == 192) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, ExtendEntryVipTask.STAT_ERROR_LX_RUNNING);
                        } else {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, ExtendEntryVipTask.STAT_ERROR_LX_ERROR);
                        }
                        vipChannelTask2 = VipChannelTask2.this;
                        stringBuilder = new StringBuilder("queryLixian, AndroidVipSubOfflineCommitTaskInfo, progress = ");
                        stringBuilder.append(androidVipSubOfflineCommitTaskInfo.mProgress);
                        stringBuilder.append(", mDownloadStatus=");
                        stringBuilder.append(androidVipSubOfflineCommitTaskInfo.mDownloadStatus);
                        vipChannelTask2.debug(stringBuilder.toString());
                        return updateLixianStatus;
                    }
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, i2);
                } else {
                    str3 = r0.mIsSpeedUpChannel ? ExtendEntryVipTask.STAT_KEY_LX_BT_ERROR : ExtendEntryVipTask.STAT_KEY_LX_BT_SYNC_ERROR;
                    AndroidVipOfflineBtCommitResponse androidVipOfflineBtCommitResponse = new AndroidVipOfflineBtCommitResponse();
                    AndroidVipGetOfflineCommitResp = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipGetOfflineBtCommitResp(r0.mLixianTaskId, androidVipOfflineBtCommitResponse);
                    if (AndroidVipGetOfflineCommitResp == XLAndroidVipManager.RUNNING) {
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, AndroidVipGetOfflineCommitResp);
                        return State.QUERY;
                    }
                    if (AndroidVipGetOfflineCommitResp != 0 || androidVipOfflineBtCommitResponse.mResult != 0) {
                        i2 = androidVipOfflineBtCommitResponse.mResult;
                        str = androidVipOfflineBtCommitResponse.mMessage;
                    } else if (androidVipOfflineBtCommitResponse.mTaskinfo == null || androidVipOfflineBtCommitResponse.mTaskinfo.length <= 0) {
                        str = str2;
                        i2 = ExtendEntryVipTask.STAT_ERROR_NO_LX_RES;
                    } else {
                        AndroidVipSubOfflineBtCommitTaskInfo androidVipSubOfflineBtCommitTaskInfo = androidVipOfflineBtCommitResponse.mTaskinfo[0];
                        VipChannelTask2.this.mInfoDelta.y = (long) androidVipSubOfflineBtCommitTaskInfo.mProgress;
                        updateLixianStatus = updateLixianStatus(androidVipSubOfflineBtCommitTaskInfo.mDownloadStatus);
                        if (r0.mTaskStatus == 200 && !TextUtils.isEmpty(androidVipSubOfflineBtCommitTaskInfo.mLixianUrl)) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, 0);
                            if (VipChannelTask2.this.mInfo.P && !addLixianResource(makeLixianResource(androidVipSubOfflineBtCommitTaskInfo), j2, i3)) {
                                r0.mTaskStatus = 491;
                                vipChannelTask2 = VipChannelTask2.this;
                                stringBuilder = new StringBuilder("queryLixian, addLixianResource Failed, xlTaskId = ");
                                stringBuilder.append(j2);
                                vipChannelTask2.debug(stringBuilder.toString());
                            }
                        } else if (r0.mTaskStatus == 192) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, ExtendEntryVipTask.STAT_ERROR_LX_RUNNING);
                        } else {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, ExtendEntryVipTask.STAT_ERROR_LX_ERROR);
                        }
                        return updateLixianStatus;
                    }
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i3, str3, i2);
                }
                vipChannelTask2 = VipChannelTask2.this;
                stringBuilder = new StringBuilder("queryLixian, result = ");
                stringBuilder.append(i2);
                stringBuilder.append(", Message = ");
                stringBuilder.append(str);
                stringBuilder.append(", ret = ");
                stringBuilder.append(AndroidVipGetOfflineCommitResp);
                vipChannelTask2.debug(stringBuilder.toString());
                r0.mTaskStatus = VipChannelTask2.translateErrorCodeToStatus(i2);
                return State.STOP;
            }

            private ServerResourceParam makeLixianResource(AndroidVipSubOfflineCommitTaskInfo androidVipSubOfflineCommitTaskInfo) {
                ServerResourceParam serverResourceParam = new ServerResourceParam();
                serverResourceParam.mCookie = androidVipSubOfflineCommitTaskInfo.mCookie;
                serverResourceParam.mUrl = androidVipSubOfflineCommitTaskInfo.mLixianUrl;
                serverResourceParam.mRefUrl = androidVipSubOfflineCommitTaskInfo.mRefUrl;
                return serverResourceParam;
            }

            private ServerResourceParam makeLixianResource(AndroidVipSubOfflineBtCommitTaskInfo androidVipSubOfflineBtCommitTaskInfo) {
                ServerResourceParam serverResourceParam = new ServerResourceParam();
                serverResourceParam.mCookie = androidVipSubOfflineBtCommitTaskInfo.mCookie;
                serverResourceParam.mUrl = androidVipSubOfflineBtCommitTaskInfo.mLixianUrl;
                serverResourceParam.mRefUrl = androidVipSubOfflineBtCommitTaskInfo.mRefUrl;
                return serverResourceParam;
            }

            private boolean addLixianResource(ServerResourceParam serverResourceParam, long j, int i) {
                String b = ad.b(VipChannelTask2.this.mContext);
                if (TextUtils.isEmpty(b)) {
                    b = "1.0.1";
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(serverResourceParam.mUrl);
                stringBuilder.append("&tm=android&ver=");
                stringBuilder.append(b);
                serverResourceParam.mUrl = stringBuilder.toString();
                if (VipChannelTask2.this.mInfo.W != TaskType.BT) {
                    serverResourceParam = VipChannelTask2.this.mXLDownloadManager.addServerResource(j, serverResourceParam);
                } else {
                    serverResourceParam = VipChannelTask2.this.mXLDownloadManager.btAddServerResource(j, i, serverResourceParam);
                }
                if (serverResourceParam == 9000) {
                    return true;
                }
                i = VipChannelTask2.this;
                StringBuilder stringBuilder2 = new StringBuilder("queryLixian, addLixianResource Failed, xlTaskId = ");
                stringBuilder2.append(j);
                stringBuilder2.append(", ret = ");
                stringBuilder2.append(serverResourceParam);
                i.debug(stringBuilder2.toString());
                return null;
            }

            public void removeResource(long j, int i) {
                VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                StringBuilder stringBuilder = new StringBuilder("lixian remove resource, id=");
                stringBuilder.append(j);
                stringBuilder.append(", idx=");
                stringBuilder.append(i);
                vipChannelTask2.debug(stringBuilder.toString());
                VipChannelTask2.this.mXLDownloadManager.btRemoveAddedResource(j, i, 4);
                VipChannelTask2.this.mXLDownloadManager.stopDcdn(j, i);
            }
        }

        class VipChannel extends Channel {
            private int mBillingRetryFlag = 0;
            private long mBillingTaskId = 0;
            private int mRequeryResourceTimes = 0;
            long mTotalBytes = -1;
            private long mVipChannelTaskId = 0;
            private int mVipRetryFlag = 0;

            VipChannel() {
            }

            public State enterChannel(XLTaskInfo xLTaskInfo, int i) {
                State state = this.mState;
                switch (this.mState) {
                    case COMMIT:
                        stopChannel();
                        this.mVipChannelTaskId = createVipChannel(xLTaskInfo, i);
                        if (this.mVipChannelTaskId <= 0) {
                            this.mState = State.STOP;
                            break;
                        }
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT);
                        this.mState = State.QUERY;
                        xLTaskInfo = VipChannelTask2.this;
                        i = new StringBuilder("VipChannelTask enterChannel mVipChannelTaskId=");
                        i.append(this.mVipChannelTaskId);
                        xLTaskInfo.debug(i.toString());
                        break;
                    case QUERY:
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, ExtendEntryVipTask.STAT_ERROR_QUERY);
                        switch (canRetry()) {
                            case OK:
                                this.mState = State.COMMIT;
                                enterChannel(xLTaskInfo, i);
                                break;
                            case PENDING:
                                this.mState = queryVipChannel(xLTaskInfo.mTaskId, i);
                                if (this.mState == State.COMMIT_BILLING) {
                                    enterChannel(xLTaskInfo, i);
                                    break;
                                }
                                break;
                            default:
                                stopChannel();
                                this.mState = State.STOP;
                                break;
                        }
                    case STOP:
                        stopChannel();
                        break;
                    case COMMIT_BILLING:
                        stopBillingTask();
                        this.mBillingTaskId = createBillingTask(VipChannelTask2.this.getCid(xLTaskInfo), VipChannelTask2.this.getGcid(xLTaskInfo), this.mTotalBytes);
                        if (this.mBillingTaskId <= 0) {
                            VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, ExtendEntryVipTask.STAT_ERROR_CREATE_FAILED);
                            this.mState = State.STOP;
                            break;
                        }
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, ExtendEntryVipTask.STAT_ERROR_COMMIT_BILLING);
                        init();
                        this.mState = State.QUERY_BILLING;
                        xLTaskInfo = VipChannelTask2.this;
                        i = new StringBuilder("VipChannelTask enterChannel mBillingTaskId=");
                        i.append(this.mBillingTaskId);
                        xLTaskInfo.debug(i.toString());
                        break;
                    case QUERY_BILLING:
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, ExtendEntryVipTask.STAT_ERROR_QUERY_BILLING);
                        switch (canRetry()) {
                            case OK:
                                this.mState = State.COMMIT_BILLING;
                                enterChannel(xLTaskInfo, i);
                                break;
                            case PENDING:
                                this.mState = queryBillingResult(xLTaskInfo.mTaskId, i);
                                break;
                            default:
                                stopChannel();
                                this.mState = State.STOP;
                                break;
                        }
                    default:
                        break;
                }
                xLTaskInfo = VipChannelTask2.this;
                i = new StringBuilder("VipChannelTask enterChannel oldState = ");
                i.append(state);
                i.append(", newState = ");
                i.append(this.mState);
                xLTaskInfo.debug(i.toString());
                return this.mState;
            }

            public void requeryResource(XLTaskInfo xLTaskInfo, int i) {
                if (this.mRequeryResourceTimes < 3 && xLTaskInfo.mAddedHighSourceState == 1) {
                    this.mRequeryResourceTimes++;
                    init();
                    enterChannel(xLTaskInfo, i);
                    xLTaskInfo = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("VipChannelTask requeryResource Times = ");
                    stringBuilder.append(this.mRequeryResourceTimes);
                    stringBuilder.append(" idx=");
                    stringBuilder.append(i);
                    xLTaskInfo.debug(stringBuilder.toString());
                }
            }

            public void stopChannel() {
                if (this.mVipChannelTaskId != 0) {
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipDestroyHighSpeedTask(this.mVipChannelTaskId);
                    this.mVipChannelTaskId = 0;
                    VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("VipChannelTask stopChannel id=");
                    stringBuilder.append(this.mVipChannelTaskId);
                    vipChannelTask2.debug(stringBuilder.toString());
                }
                stopBillingTask();
            }

            private void stopBillingTask() {
                if (this.mBillingTaskId != 0) {
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipDestroyHighSpeedBillingTask(this.mBillingTaskId);
                    this.mBillingTaskId = 0;
                    VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("VipChannelTask stopBillingTask id=");
                    stringBuilder.append(this.mBillingTaskId);
                    vipChannelTask2.debug(stringBuilder.toString());
                }
            }

            private long createVipChannel(XLTaskInfo xLTaskInfo, int i) {
                String property = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                String property2 = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_SESSION_ID, "");
                AndroidVipGetTaskId androidVipGetTaskId = new AndroidVipGetTaskId();
                AndroidVipHighSpeedTaskReqParam androidVipHighSpeedTaskReqParam = new AndroidVipHighSpeedTaskReqParam();
                androidVipHighSpeedTaskReqParam.mUserId = Long.valueOf(property).longValue();
                androidVipHighSpeedTaskReqParam.mCid = xLTaskInfo.mCid;
                androidVipHighSpeedTaskReqParam.mGcid = xLTaskInfo.mGcid;
                androidVipHighSpeedTaskReqParam.mFileSize = this.mTotalBytes;
                androidVipHighSpeedTaskReqParam.mHighSpeedType = 0;
                int AndroidVipCreateEnterHighSpeedTask = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipCreateEnterHighSpeedTask(androidVipGetTaskId, androidVipHighSpeedTaskReqParam);
                if (AndroidVipCreateEnterHighSpeedTask == 0) {
                    if (DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_PRODUCT_ID, "").equals("1")) {
                        VipChannelTask2.this.mXLDownloadManager.setTaskGsState(xLTaskInfo.mTaskId, i, 3);
                    } else {
                        VipChannelTask2.this.mXLDownloadManager.setTaskGsState(xLTaskInfo.mTaskId, i, 1);
                    }
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(xLTaskInfo.mTaskId, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, ExtendEntryVipTask.STAT_ERROR_INIT_TASK);
                    if (true == VipChannelTask2.this.mInfo.Q) {
                        XLDownloadManager xLDownloadManager = VipChannelTask2.this.mXLDownloadManager;
                        xLDownloadManager.startDcdn(xLTaskInfo.mTaskId, i, property2, ExtendEntryVipTask.PRODUCT_TYPE, "");
                    } else {
                        VipChannelTask2.this.mXLDownloadManager.stopDcdn(xLTaskInfo.mTaskId, i);
                    }
                    this.mTaskStatus = 190;
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).vipSetTaskRetryFlag(androidVipGetTaskId.getTaskId(), this.mVipRetryFlag);
                    if (this.mVipRetryFlag == 0) {
                        this.mVipRetryFlag = 1;
                    }
                    return androidVipGetTaskId.getTaskId();
                }
                this.mTaskStatus = 491;
                VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                StringBuilder stringBuilder = new StringBuilder("createVipChannel ret= ");
                stringBuilder.append(AndroidVipCreateEnterHighSpeedTask);
                vipChannelTask2.debug(stringBuilder.toString());
                return 0;
            }

            private State queryVipChannel(long j, int i) {
                AndroidVipHighSpeedTaskResponse androidVipHighSpeedTaskResponse = new AndroidVipHighSpeedTaskResponse();
                int AndroidVipGetHighSpeedTaskResp = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipGetHighSpeedTaskResp(this.mVipChannelTaskId, androidVipHighSpeedTaskResponse);
                if (AndroidVipGetHighSpeedTaskResp == 0 && androidVipHighSpeedTaskResponse.mResult == 0) {
                    if (androidVipHighSpeedTaskResponse.mPeerCount <= 0) {
                        VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, 20002);
                        if (androidVipHighSpeedTaskResponse.mDcdnResCount > null) {
                            this.mTaskStatus = 200;
                        } else {
                            this.mTaskStatus = 500;
                        }
                        VipChannelTask2.this.debug("have no peer count, entry highspeed error");
                        return State.STOP;
                    }
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, 0);
                    return State.COMMIT_BILLING;
                } else if (AndroidVipGetHighSpeedTaskResp == XLAndroidVipManager.RUNNING) {
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, AndroidVipGetHighSpeedTaskResp);
                    return State.QUERY;
                } else {
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j, i, ExtendEntryVipTask.STAT_KEY_VIP_ERROR, androidVipHighSpeedTaskResponse.mResult);
                    this.mTaskStatus = VipChannelTask2.translateErrorCodeToStatus(androidVipHighSpeedTaskResponse.mResult);
                    j = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("queryVipChannel, error Resp.mResult=");
                    stringBuilder.append(androidVipHighSpeedTaskResponse.mResult);
                    stringBuilder.append(", ret = ");
                    stringBuilder.append(AndroidVipGetHighSpeedTaskResp);
                    j.debug(stringBuilder.toString());
                    return State.STOP;
                }
            }

            long createBillingTask(String str, String str2, long j) {
                String property = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                String property2 = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
                AndroidVipGetTaskId androidVipGetTaskId = new AndroidVipGetTaskId();
                AndroidVipHighSpeedBillingReqParam androidVipHighSpeedBillingReqParam = new AndroidVipHighSpeedBillingReqParam();
                androidVipHighSpeedBillingReqParam.mUserId = Long.valueOf(property).longValue();
                androidVipHighSpeedBillingReqParam.mKey = property2;
                androidVipHighSpeedBillingReqParam.mCid = str;
                androidVipHighSpeedBillingReqParam.mGcid = str2;
                androidVipHighSpeedBillingReqParam.mFileSize = j;
                androidVipHighSpeedBillingReqParam.mFileIndex = 0;
                androidVipHighSpeedBillingReqParam.mBussinessFlag = 0;
                androidVipHighSpeedBillingReqParam.mResId = "";
                androidVipHighSpeedBillingReqParam.mResType = 0;
                androidVipHighSpeedBillingReqParam.mFileName = "";
                if (TextUtils.isEmpty(VipChannelTask2.this.mInfoDelta.b) == null) {
                    androidVipHighSpeedBillingReqParam.mFileName = VipChannelTask2.this.mInfoDelta.b.substring(VipChannelTask2.this.mInfoDelta.b.lastIndexOf(File.separator) + 1);
                }
                str = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipCreateHighSpeedBillingTask(androidVipGetTaskId, androidVipHighSpeedBillingReqParam);
                if (str == null) {
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).vipSetTaskRetryFlag(androidVipGetTaskId.getTaskId(), this.mBillingRetryFlag);
                    if (this.mBillingRetryFlag == null) {
                        this.mBillingRetryFlag = 1;
                    }
                    return Long.valueOf(androidVipGetTaskId.getTaskId()).longValue();
                }
                this.mTaskStatus = 491;
                str2 = VipChannelTask2.this;
                j = new StringBuilder("AndroidVipCreateHighSpeedBillingTask, ret = ");
                j.append(str);
                str2.debug(j.toString());
                return null;
            }

            State queryBillingResult(long j, int i) {
                String property = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                String property2 = DownloadManager.getInstanceFor(VipChannelTask2.this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
                AndroidVipHighSpeedBillingResponse androidVipHighSpeedBillingResponse = new AndroidVipHighSpeedBillingResponse();
                int AndroidVipGetHighSpeedBillingTaskResp = XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipGetHighSpeedBillingTaskResp(Long.valueOf(this.mBillingTaskId).longValue(), androidVipHighSpeedBillingResponse);
                if (AndroidVipGetHighSpeedBillingTaskResp == 0 && androidVipHighSpeedBillingResponse.mResult == 0) {
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j, i, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, 0);
                    VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                    StringBuilder stringBuilder = new StringBuilder("queryBillingResult, mCapacity = ");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mCapacity);
                    stringBuilder.append(", Resp.mRemain = ");
                    stringBuilder.append(androidVipHighSpeedBillingResponse.mRemain);
                    vipChannelTask2.debug(stringBuilder.toString());
                    String b = ad.b(VipChannelTask2.this.mContext);
                    if (TextUtils.isEmpty(b)) {
                        b = "1.0.1";
                    }
                    AndroidVipHighSpeedTaskResponse androidVipHighSpeedTaskResponse = new AndroidVipHighSpeedTaskResponse();
                    XLAndroidVipManager.getInstance(VipChannelTask2.this.mContext).AndroidVipGetHighSpeedTaskResp(r0.mVipChannelTaskId, androidVipHighSpeedTaskResponse);
                    int i2 = androidVipHighSpeedTaskResponse.mDcdnResCount > 0 ? 1 : 0;
                    for (int i3 = 0; i3 < androidVipHighSpeedTaskResponse.mPeerCount; i3++) {
                        PeerResourceParam peerResourceParam = new PeerResourceParam();
                        peerResourceParam.mUserId = Long.valueOf(property).longValue();
                        peerResourceParam.mJmpKey = property2;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(androidVipHighSpeedBillingResponse.mVipCdnAuthStr);
                        stringBuilder2.append("&tm=android&ver=");
                        stringBuilder2.append(b);
                        peerResourceParam.mVipCdnAuth = stringBuilder2.toString();
                        peerResourceParam.mUdpPort = androidVipHighSpeedTaskResponse.mPeerRes[i3].mUdpPort;
                        peerResourceParam.mTcpPort = androidVipHighSpeedTaskResponse.mPeerRes[i3].mTcpPort;
                        peerResourceParam.mInternalIp = (int) androidVipHighSpeedTaskResponse.mPeerRes[i3].mIp;
                        peerResourceParam.mPeerId = androidVipHighSpeedTaskResponse.mPeerRes[i3].mPeerId;
                        peerResourceParam.mResLevel = androidVipHighSpeedTaskResponse.mPeerRes[i3].mResourceLevel;
                        peerResourceParam.mResPriority = androidVipHighSpeedTaskResponse.mPeerRes[i3].mResourceUseLevel;
                        peerResourceParam.mCapabilityFlag = androidVipHighSpeedTaskResponse.mPeerRes[i3].mCapability;
                        peerResourceParam.mResType = androidVipHighSpeedTaskResponse.mPeerRes[i3].mCdnType;
                        int btAddPeerResource = VipChannelTask2.this.mXLDownloadManager.btAddPeerResource(j, i, peerResourceParam);
                        i2 |= btAddPeerResource == 9000 ? 1 : 0;
                        VipChannelTask2 vipChannelTask22 = VipChannelTask2.this;
                        StringBuilder stringBuilder3 = new StringBuilder("btAddPeerResource ret = ");
                        stringBuilder3.append(btAddPeerResource);
                        vipChannelTask22.debug(stringBuilder3.toString());
                    }
                    if (i2 != 0) {
                        r0.mTaskStatus = 200;
                    } else {
                        r0.mTaskStatus = 491;
                    }
                    return State.STOP;
                }
                long j2 = j;
                int i4 = i;
                if (AndroidVipGetHighSpeedBillingTaskResp == XLAndroidVipManager.RUNNING) {
                    VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i4, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, AndroidVipGetHighSpeedBillingTaskResp);
                    return State.QUERY_BILLING;
                }
                VipChannelTask2.this.mXLDownloadManager.statExternalInfo(j2, i, ExtendEntryVipTask.STAT_KEY_BILLING_ERROR, androidVipHighSpeedBillingResponse.mResult);
                r0.mTaskStatus = VipChannelTask2.translateErrorCodeToStatus(androidVipHighSpeedBillingResponse.mResult);
                VipChannelTask2 vipChannelTask23 = VipChannelTask2.this;
                StringBuilder stringBuilder4 = new StringBuilder("queryBillingResult ret=");
                stringBuilder4.append(AndroidVipGetHighSpeedBillingTaskResp);
                stringBuilder4.append(", mResult = ");
                stringBuilder4.append(androidVipHighSpeedBillingResponse.mResult);
                stringBuilder4.append(", msg=");
                stringBuilder4.append(androidVipHighSpeedBillingResponse.mMessage);
                vipChannelTask23.debug(stringBuilder4.toString());
                return State.STOP;
            }

            public void removeResource(long j, int i) {
                VipChannelTask2 vipChannelTask2 = VipChannelTask2.this;
                StringBuilder stringBuilder = new StringBuilder("vip remove resource, id=");
                stringBuilder.append(j);
                stringBuilder.append(", idx=");
                stringBuilder.append(i);
                vipChannelTask2.debug(stringBuilder.toString());
                VipChannelTask2.this.mXLDownloadManager.btRemoveAddedResource(j, i, 3);
                VipChannelTask2.this.mXLDownloadManager.stopDcdn(j, i);
            }
        }

        private static int translateErrorCodeToStatus(int i) {
            return 600 + i;
        }

        public int getSubTaskVipErrNo(int i) {
            return -1;
        }

        private void debug(String str) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("id=");
            stringBuilder.append(this.mInfo.c);
            stringBuilder.append(", ");
            stringBuilder.append(str);
            an.b(str2, stringBuilder.toString());
        }

        public VipChannelTask2(Context context, d dVar, z.a aVar) {
            this.mContext = context;
            this.mInfo = dVar;
            this.mInfoDelta = aVar;
            this.mXLDownloadManager = XLDownloadManager.getInstance(context);
        }

        private int trySyncLxTast(XLTaskInfo xLTaskInfo, int i) {
            if (xLTaskInfo == null) {
                debug("info=null");
                return 190;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(xLTaskInfo.mTaskId);
            stringBuilder.append("_LX_SYNC_");
            stringBuilder.append(i);
            String stringBuilder2 = stringBuilder.toString();
            LixianChannel lixianChannel = (LixianChannel) this.mVipTaskQueue.get(stringBuilder2);
            String property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
            DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
            if (!property.equals("") && this.mInfo.R) {
                if (!this.mInfo.P) {
                    if (lixianChannel == null) {
                        lixianChannel = new LixianChannel(this.mInfo.W != TaskType.BT, false);
                        this.mVipTaskQueue.put(stringBuilder2, lixianChannel);
                        debug("new Channel");
                    }
                    if (xLTaskInfo.mFileSize > 0) {
                        lixianChannel.mTotalBytes = xLTaskInfo.mFileSize;
                    }
                    if (!lixianChannel.isStopped()) {
                        lixianChannel.enterChannel(xLTaskInfo, i);
                        i = new StringBuilder("tryEnterLXChannel mTaskId=");
                        i.append(xLTaskInfo.mTaskId);
                        debug(i.toString());
                    }
                    return lixianChannel.getTaskStatus();
                }
            }
            if (lixianChannel != null) {
                lixianChannel.stopChannel();
                this.mVipTaskQueue.remove(stringBuilder2);
            }
            if (this.mInfo.P == null) {
                return 190;
            }
            debug("user start LXSpeedup");
            return -1;
        }

        public int tryEnterLXChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
            if (xLTaskInfo == null) {
                debug("info=null");
                return 190;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(xLTaskInfo.mTaskId);
            stringBuilder.append("_LX_");
            stringBuilder.append(i);
            String stringBuilder2 = stringBuilder.toString();
            LixianChannel lixianChannel = (LixianChannel) this.mVipTaskQueue.get(stringBuilder2);
            if (lixianChannel == null) {
                int trySyncLxTast = trySyncLxTast(xLTaskInfo, i);
                if (trySyncLxTast != -1) {
                    return trySyncLxTast;
                }
            }
            String property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
            String property2 = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
            if (!(property.equals("") || property2.equals(""))) {
                if (this.mInfo.P) {
                    if (lixianChannel == null) {
                        lixianChannel = new LixianChannel(this.mInfo.W != TaskType.BT, true);
                        this.mVipTaskQueue.put(stringBuilder2, lixianChannel);
                        debug("new Channel");
                    }
                    if (xLTaskInfo.mFileSize > 0) {
                        lixianChannel.mTotalBytes = xLTaskInfo.mFileSize;
                    }
                    if (z) {
                        lixianChannel.init();
                        z = new StringBuilder("tryEnterLXChannel reEnter, mTaskId=");
                        z.append(xLTaskInfo.mTaskId);
                        debug(z.toString());
                    }
                    if (!lixianChannel.isStopped()) {
                        lixianChannel.enterChannel(xLTaskInfo, i);
                        i = new StringBuilder("tryEnterLXChannel mTaskId=");
                        i.append(xLTaskInfo.mTaskId);
                        debug(i.toString());
                    }
                    return lixianChannel.getTaskStatus();
                }
            }
            if (lixianChannel != null) {
                lixianChannel.removeResource(xLTaskInfo.mTaskId, i);
                lixianChannel.stopChannel();
                this.mVipTaskQueue.remove(stringBuilder2);
            }
            debug("lx,uid=null or jmpkey=null");
            return 190;
        }

        public int tryEnterVipChannel(XLTaskInfo xLTaskInfo, int i, boolean z) {
            if (!TextUtils.isEmpty(getCid(xLTaskInfo))) {
                if (!TextUtils.isEmpty(getGcid(xLTaskInfo))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(xLTaskInfo.mTaskId);
                    stringBuilder.append("_GS_");
                    stringBuilder.append(i);
                    String stringBuilder2 = stringBuilder.toString();
                    VipChannel vipChannel = (VipChannel) this.mVipTaskQueue.get(stringBuilder2);
                    String property = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                    if (!TextUtils.isEmpty(property)) {
                        Long.parseLong(property);
                    }
                    String property2 = DownloadManager.getInstanceFor(this.mContext).getProperty(DownloadManager$Property.PROP_JUMP_KEY, "");
                    if (vipChannel == null) {
                        int enterHighspeedTrial = enterHighspeedTrial(xLTaskInfo, i);
                        if (enterHighspeedTrial != -1) {
                            return enterHighspeedTrial;
                        }
                    }
                    if (!(property.equals("") || property2.equals(""))) {
                        if (this.mInfo.O) {
                            if (vipChannel == null) {
                                vipChannel = new VipChannel();
                                this.mVipTaskQueue.put(stringBuilder2, vipChannel);
                            }
                            if (xLTaskInfo.mFileSize > 0) {
                                vipChannel.mTotalBytes = xLTaskInfo.mFileSize;
                            }
                            if (vipChannel.mTotalBytes <= 0) {
                                return 190;
                            }
                            stringBuilder = new StringBuilder("channel.mTotalBytes = ");
                            stringBuilder.append(vipChannel.mTotalBytes);
                            debug(stringBuilder.toString());
                            if (z) {
                                vipChannel.init();
                                z = new StringBuilder("tryEnterVipChannel reEnter, mTaskId=");
                                z.append(xLTaskInfo.mTaskId);
                                debug(z.toString());
                            }
                            if (vipChannel.isStopped()) {
                                vipChannel.requeryResource(xLTaskInfo, i);
                            } else {
                                z = new StringBuilder("tryEnterVipChannel mTaskId=");
                                z.append(xLTaskInfo.mTaskId);
                                z.append(", state=");
                                z.append(vipChannel.mState);
                                debug(z.toString());
                                vipChannel.enterChannel(xLTaskInfo, i);
                            }
                            return vipChannel.getTaskStatus();
                        }
                    }
                    debug("vip uid=null or jmpkey=null");
                    if (vipChannel != null) {
                        vipChannel.removeResource(xLTaskInfo.mTaskId, i);
                        vipChannel.stopChannel();
                        this.mVipTaskQueue.remove(stringBuilder2);
                    }
                    return 190;
                }
            }
            debug("info=null or info.cid=null or info.gcid=null");
            return 190;
        }

        public void stopTask() {
            for (Channel stopChannel : this.mVipTaskQueue.values()) {
                stopChannel.stopChannel();
            }
            this.mVipTaskQueue.clear();
            if (this.mHighSpeedTrialChannel != null) {
                this.mHighSpeedTrialChannel.stopChannel();
                if (l.a().f(this.mInfo.c) <= 0) {
                    l.a().i(this.mInfo.c);
                }
            }
        }

        public void removeNotPlayerBtSubTask(XLTaskInfo xLTaskInfo, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(xLTaskInfo.mTaskId);
            stringBuilder.append("_GS_");
            stringBuilder.append(i);
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(xLTaskInfo.mTaskId);
            stringBuilder3.append("_LX_");
            stringBuilder3.append(i);
            String stringBuilder4 = stringBuilder3.toString();
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append(xLTaskInfo.mTaskId);
            stringBuilder5.append("_LX_SYNC_");
            stringBuilder5.append(i);
            xLTaskInfo = stringBuilder5.toString();
            i = this.mVipTaskQueue.entrySet().iterator();
            while (i.hasNext()) {
                Entry entry = (Entry) i.next();
                String str = (String) entry.getKey();
                if (!(str.equals(stringBuilder2) || str.equals(stringBuilder4) || str.equals(xLTaskInfo))) {
                    ((Channel) entry.getValue()).stopChannel();
                    i.remove();
                }
            }
        }

        private int enterHighspeedTrial(XLTaskInfo xLTaskInfo, int i) {
            if (this.mHighSpeedTrialChannel != null && l.a().g(this.mInfo.c) == null) {
                debug("enterHighspeedTrial stop and remove resource");
                i = this.mHighSpeedTrialChannel.mIdx;
                if (this.mHighSpeedTrialChannel.mEnterTrialStatus == 200) {
                    this.mHighSpeedTrialChannel.removeResource(xLTaskInfo.mTaskId, i);
                }
                this.mHighSpeedTrialChannel.stopChannel();
                this.mHighSpeedTrialChannel = null;
            }
            if (!l.a().b()) {
                return -1;
            }
            a h = l.a().h(this.mInfo.c);
            if (h == null || TextUtils.isEmpty(this.mInfoDelta.b)) {
                return 190;
            }
            if (this.mHighSpeedTrialChannel == null) {
                HighSpeedTrialChannel highSpeedTrialChannel = (HighSpeedTrialChannel) l.a().g(this.mInfo.c);
                if (highSpeedTrialChannel == null) {
                    this.mHighSpeedTrialChannel = new HighSpeedTrialChannel(this.mContext, this.mInfo.c);
                    this.mHighSpeedTrialChannel.mIdx = i;
                    l.a().a(this.mInfo.c, this.mHighSpeedTrialChannel);
                    StringBuilder stringBuilder = new StringBuilder("setHiSpeedTrilObject idx=");
                    stringBuilder.append(i);
                    debug(stringBuilder.toString());
                } else {
                    this.mHighSpeedTrialChannel = highSpeedTrialChannel;
                    if (this.mHighSpeedTrialChannel.canSpeedUp() && this.mHighSpeedTrialChannel.getResourceInfo(xLTaskInfo, this.mInfoDelta) != null) {
                        this.mHighSpeedTrialChannel.reStartTrialDcdn(xLTaskInfo, this.mInfo);
                    }
                }
            }
            if (this.mInfo.W == TaskType.BT && this.mHighSpeedTrialChannel.mIdx != i) {
                return 501;
            }
            if (xLTaskInfo.mFileSize > 0) {
                this.mHighSpeedTrialChannel.mTotalBytes = xLTaskInfo.mFileSize;
            }
            if (this.mHighSpeedTrialChannel.mTotalBytes <= 0) {
                return 190;
            }
            switch (AnonymousClass1.$SwitchMap$com$android$providers$downloads$HighSpeedTrialHelper$Command[h.ordinal()]) {
                case 1:
                    debug("get Resource info");
                    this.mHighSpeedTrialChannel.getResourceInfo(xLTaskInfo, this.mInfoDelta);
                    break;
                case 2:
                    this.mHighSpeedTrialChannel.getCheckTrialInfo(xLTaskInfo, this.mInfo, this.mInfoDelta);
                    break;
                case 3:
                    this.mHighSpeedTrialChannel.addResource(xLTaskInfo, this.mInfo, this.mInfoDelta, i);
                    break;
                default:
                    break;
            }
            return this.mHighSpeedTrialChannel.getHighSpeedStatus(xLTaskInfo);
        }

        private String getCid(XLTaskInfo xLTaskInfo) {
            if (this.mInfo.W != TaskType.CID || TextUtils.isEmpty(this.mInfoDelta.n)) {
                return xLTaskInfo.mCid;
            }
            return this.mInfoDelta.n;
        }

        private String getGcid(XLTaskInfo xLTaskInfo) {
            if (this.mInfo.W != TaskType.CID || TextUtils.isEmpty(this.mInfoDelta.o)) {
                return xLTaskInfo.mGcid;
            }
            return this.mInfoDelta.o;
        }
    }

    public z.b newVipChannelTask(Context context, d dVar, z.a aVar) {
        return new VipChannelTask2(context, dVar, aVar);
    }

    public void onInitVipChannel(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        String str = (packageInfo == null || packageInfo.versionName == null) ? "1.0" : packageInfo.versionName;
        context = XLAndroidVipManager.getInstance(context).AndroidVipInit(context, 1000, str);
        StringBuilder stringBuilder = new StringBuilder("AndroidVipInit() ret=");
        stringBuilder.append(context);
        an.b("DownloadManager", stringBuilder.toString());
    }

    public void onUninitVipChannel(Context context) {
        context = XLAndroidVipManager.getInstance(context).AndroidVipUninit();
        StringBuilder stringBuilder = new StringBuilder("AndroidVipUninit() ret=");
        stringBuilder.append(context);
        an.b("DownloadManager", stringBuilder.toString());
    }
}
