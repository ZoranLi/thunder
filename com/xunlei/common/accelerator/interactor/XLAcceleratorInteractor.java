package com.xunlei.common.accelerator.interactor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.accelerator.XLAccelerator;
import com.xunlei.common.accelerator.XLOnAccelListener;
import com.xunlei.common.accelerator.XLOnAllCardsListener;
import com.xunlei.common.accelerator.base.BaseInteractor;
import com.xunlei.common.accelerator.base.IAcclHttpListener;
import com.xunlei.common.accelerator.bean.AccelInfoResultBean;
import com.xunlei.common.accelerator.bean.AllExpCardsBean;
import com.xunlei.common.accelerator.bean.KeepResultBean;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.PortalResultBean;
import com.xunlei.common.accelerator.bean.StartAccelResultBean;
import com.xunlei.common.accelerator.bean.StopAccelResultBean;
import com.xunlei.common.accelerator.bean.TimeCardResultBean;
import com.xunlei.common.accelerator.bean.TryInfoResultBean;
import com.xunlei.common.accelerator.bean.XLAccelBackupInfo;
import com.xunlei.common.accelerator.bean.XLAccelBackupInfo.AccelStatus;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.accelerator.bean.XLAccelTryInfo;
import com.xunlei.common.accelerator.bean.XLAccelUser;
import com.xunlei.common.accelerator.controller.XLAccelController;
import com.xunlei.common.accelerator.http.XLAccelHttpReqInfo;
import com.xunlei.common.accelerator.model.XLAccelModel;
import com.xunlei.common.accelerator.utils.ErrorCodeUtils;
import com.xunlei.common.accelerator.utils.LogcatUtil;
import com.xunlei.common.accelerator.utils.UseInfoUtil;
import com.xunlei.common.accelerator.utils.XLNetworkUtils;
import com.xunlei.common.accelerator.utils.XLParameterUtils;
import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XLAcceleratorInteractor extends BaseInteractor implements XLAccelerator, IAcclHttpListener {
    private static final String TAG = "XLAcceleratorInteractor";
    private XLAccelUser alreadyAccelUser = null;
    private String automaticGetAccelErrorMessage = "";
    private boolean bForbidQueryPortal = false;
    private boolean bHasRecoveryCounted;
    private String changeClientType;
    private int changeUserCount = 1;
    private boolean isPaySuccess = false;
    private boolean isReLogin = false;
    private final CountDownLatch latch = new CountDownLatch(1);
    private int mAccelInfoRetry = 0;
    private String mCacheCardId;
    private int mCacheSeconds;
    private String mCacheStartCardId;
    private WeakReference<XLOnAllCardsListener> mCardListener;
    private int mCurrentAccelStatus = 0;
    private int mGetAccelInfoCode = -1;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsReInit = false;
    private KnParams mKnParams;
    private NetworkChangeReceiver mNetworkChangeReceiver = new NetworkChangeReceiver();
    private int mPortalErrorCode = -1;
    private int mStartAccelRetry = 0;
    private StartAccelResultBean mStartInfo;
    private StopAccelResultBean mStopInfo;
    private int mTryAccelInfoRetry = 0;
    private List<XLOnAccelListener> mUserListeners = new LinkedList();
    XLOnUserListener mXLOnUserListener = new XLOnUserListener() {
        public boolean onHighSpeedCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity, Object obj, int i2) {
            return false;
        }

        public boolean onLixianCatched(int i, String str, String str2, XLUserInfo xLUserInfo, XLLixianCapacity xLLixianCapacity, Object obj, int i2) {
            return false;
        }

        public boolean onUserAqBindMobile(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserAqSendMessage(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserBindedOtherAccount(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
            return false;
        }

        public boolean onUserGetBindedOtherAccount(int i, String str, String str2, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, Object obj, int i2) {
            return false;
        }

        public boolean onUserGetCityCodeByIp(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
            return false;
        }

        public boolean onUserGetCityInfo(int i, String str, String str2, JSONObject jSONObject, Object obj, int i2) {
            return false;
        }

        public boolean onUserGetOtherAccountInfo(int i, String str, String str2, int i2, XLThirdUserInfo xLThirdUserInfo, Object obj, int i3) {
            return false;
        }

        public boolean onUserGetQRCode(int i, String str, String str2, String str3, byte[] bArr, Object obj, int i2) {
            return false;
        }

        public boolean onUserGetRecommendAvatars(int i, String str, String str2, XLAvatarItem[] xLAvatarItemArr, Object obj, int i2) {
            return false;
        }

        public boolean onUserMobileLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            return false;
        }

        public boolean onUserMobileRegister(int i, String str, String str2, boolean z, XLUserInfo xLUserInfo, Object obj, int i2) {
            return false;
        }

        public boolean onUserMobileSendMessage(int i, String str, String str2, String str3, Object obj, int i2) {
            return false;
        }

        public boolean onUserModifyPassWord(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserPreVerifyedCode(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserQRCodeLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            return false;
        }

        public boolean onUserQRCodeLoginAuth(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserRecvChannelMessage(int i, JSONArray jSONArray) {
            return false;
        }

        public boolean onUserResumed(int i) {
            return false;
        }

        public boolean onUserSelectRecommendAvatar(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserSessionidLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            return false;
        }

        public boolean onUserSetAvatar(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserSetInfo(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserSuspended(int i) {
            return false;
        }

        public boolean onUserThirdLogin(int i, String str, String str2, XLUserInfo xLUserInfo, int i2, int i3, Object obj, int i4) {
            return false;
        }

        public boolean onUserTokenLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            return false;
        }

        public boolean onUserUnBindeOtherAccount(int i, String str, String str2, int i2, Object obj, int i3) {
            return false;
        }

        public boolean onUserVerifyCodeUpdated(int i, String str, String str2, String str3, int i2, byte[] bArr, Object obj, int i3) {
            return false;
        }

        public boolean onUserVerifyedCode(int i, String str, String str2, Object obj, int i2) {
            return false;
        }

        public boolean onUserLogin(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            XLAcceleratorInteractor.this.isReLogin = true;
            return false;
        }

        public boolean onUserLogout(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            XLAcceleratorInteractor.this.checkUser(i, null);
            return false;
        }

        public boolean onUserInfoCatched(int i, String str, String str2, XLUserInfo xLUserInfo, Object obj, int i2) {
            if (XLAcceleratorInteractor.this.isReLogin != null) {
                XLAcceleratorInteractor.this.isReLogin = false;
                XLAcceleratorInteractor.this.checkUser(i, xLUserInfo);
            }
            return false;
        }
    };
    private String portalUrl = "";
    private Runnable recoverQueryRunnable = new Runnable() {
        public void run() {
            XLAcceleratorInteractor.this.recoverQueryCount();
        }
    };

    private class NetworkChangeReceiver extends BroadcastReceiver {
        private final int MAX_KEEPALIVE_RETRY_TIME;
        private boolean needPortal;
        private int needRetry;

        private NetworkChangeReceiver() {
            this.MAX_KEEPALIVE_RETRY_TIME = 1;
            this.needRetry = 0;
            this.needPortal = false;
        }

        public void setNeedRetry() {
            int i = this.needRetry + 1;
            this.needRetry = i;
            if (i > 1) {
                XLAcceleratorInteractor.this.setAccelStatus(2);
                this.needRetry = 0;
            }
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) != null) {
                if (XLNetworkUtils.isWIFIActive(context) != null) {
                    if (this.needRetry > null) {
                        this.needRetry = 0;
                        XLAcceleratorInteractor.this.restartKeepAlive();
                    }
                    if (this.needPortal != null) {
                        XLAcceleratorInteractor.this.mCurrentStatus = 0;
                        XLAcceleratorInteractor.this.recoverQueryCount();
                        XLAcceleratorInteractor.this.reInitQueryStatus();
                        XLAcceleratorInteractor.this.queryStatus();
                        this.needPortal = false;
                    }
                } else if (XLNetworkUtils.getSpecificNetworkType(XLAcceleratorInteractor.this.mContext) == null) {
                    this.needPortal = true;
                    XLAcceleratorInteractor.this.mCurrentStatus = 12;
                    XLAcceleratorInteractor.this.dispatchCallBack(XLAcceleratorInteractor.this.mCurrentStatus, 10, ErrorCodeUtils.getErrorDesc(10));
                    XLAcceleratorInteractor.this.setAccelStatus(2);
                } else {
                    this.needPortal = true;
                    XLAcceleratorInteractor.this.mCurrentStatus = 11;
                    XLAcceleratorInteractor.this.dispatchCallBack(XLAcceleratorInteractor.this.mCurrentStatus, 11, ErrorCodeUtils.getErrorDesc(11));
                    XLAcceleratorInteractor.this.setAccelStatus(2);
                }
            }
        }
    }

    public String getVersion() {
        return "3.1";
    }

    public boolean init(Context context, String str, String str2) {
        if (!(this.mInited || context == null || str == null)) {
            if (str2 != null) {
                this.mContext = context;
                this.xLAccelController = new XLAccelController(this.mContext, this, new XLParameterUtils(this.mContext, str));
                this.mInited = true;
                restoreState();
                registerNetworkReceiver();
                XLUserUtil.getInstance().attachListener(this.mXLOnUserListener);
                return true;
            }
        }
        return false;
    }

    public boolean uninit() {
        if (!this.mInited) {
            return false;
        }
        this.mInited = false;
        this.mHadPortal = false;
        this.bHasRecoveryCounted = false;
        unRegisterReceiver();
        if (this.xLAccelController != null) {
            this.xLAccelController.unInitTimer();
        }
        this.mCurrentStatus = 0;
        saveAccelState(this.mContext);
        this.mUserListeners.clear();
        XLUserUtil.getInstance().detachListener(this.mXLOnUserListener);
        this.mHandler.removeCallbacks(this.recoverQueryRunnable);
        return true;
    }

    private void checkUser(int i, XLUserInfo xLUserInfo) {
        if (i != 0 || xLUserInfo == null) {
            this.mIsKuaiNiaoVIP = 0;
            changeUser(xLUserInfo, this.mIsKuaiNiaoVIP, i, null);
        } else if (UseInfoUtil.isKnVip(xLUserInfo)) {
            boolean z = true;
            this.mIsKuaiNiaoVIP = 1;
            KnParams knParams = new KnParams();
            knParams.setOther_ExpireDate(xLUserInfo.getStringValue(USERINFOKEY.ExpireDate, 14));
            knParams.setOther_IsVip(xLUserInfo.getIntValue(USERINFOKEY.IsVip, 14));
            if (xLUserInfo.getIntValue(USERINFOKEY.IsYear, 14) != 1) {
                z = false;
            }
            knParams.setOther_IsYear(z);
            changeUser(xLUserInfo, this.mIsKuaiNiaoVIP, i, knParams);
        } else {
            this.mIsKuaiNiaoVIP = 0;
            changeUser(xLUserInfo, this.mIsKuaiNiaoVIP, i, null);
        }
    }

    public void reInit() {
        this.mCurrentStatus = 0;
        recoverQueryCount();
        reInitQueryStatus();
        if (this.mIsLoading) {
            this.mIsReInit = true;
        } else {
            queryStatus();
        }
    }

    private void userQueryPortal() {
        if (this.mIsLoading || !this.mInited) {
            return;
        }
        if (this.bForbidQueryPortal) {
            if (!this.mHadPortal) {
                this.mCurrentStatus = 2;
                dispatchCallBack(this.mCurrentStatus, this.mPortalErrorCode, ErrorCodeUtils.getErrorDesc(this.mPortalErrorCode));
            }
            countTimeToRecoverQuery();
            return;
        }
        this.mStartInfo = null;
        this.mTryInfo = null;
        this.mBandInfo = null;
        this.mStopInfo = null;
        this.mIsLoading = true;
        if (this.mCurrentStatus != 1) {
            this.mCurrentStatus = 1;
            dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
        }
        this.xLAccelController.queryPortal();
    }

    private void userGetAccelInfo() {
        if (!this.mIsLoading) {
            if (this.mAccelInfoRetry > 3) {
                if (this.mBandInfo == null) {
                    this.mCurrentStatus = 2;
                    dispatchCallBack(this.mCurrentStatus, this.mGetAccelInfoCode, this.automaticGetAccelErrorMessage);
                }
                return;
            }
            this.mIsLoading = true;
            this.xLAccelController.getBandInfo(this.mAccelUser);
        }
    }

    private void userGetTryAccelInfo() {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (this.mCurrentStatus != 17) {
                this.mCurrentStatus = 17;
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            }
            this.xLAccelController.getTryAccelInfo(this.mAccelUser);
        }
    }

    private void userCheckUsingCard() {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.xLAccelController.checkTimeCardUsing(this.mAccelUser);
        }
    }

    private void userStartAccel(boolean z) {
        if (!this.mIsLoading) {
            if (z) {
                userCheckUsingCard();
                return;
            }
            this.mIsLoading = true;
            if (!this.mCurrentStatus) {
                this.mCurrentStatus = 8;
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            }
            this.xLAccelController.startAccel(this.mAccelUser, this.mCacheCardId);
        }
    }

    private void userStopAccel() {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            if (this.mCurrentStatus != 15) {
                this.mCurrentStatus = 15;
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            }
            if (this.alreadyAccelUser != null) {
                this.xLAccelController.stopAccel(this.alreadyAccelUser);
            }
        }
    }

    public void saveAccelState(Context context) {
        XLAccelBackupInfo xLAccelBackupInfo = new XLAccelBackupInfo();
        if (this.mAccelUser != null) {
            xLAccelBackupInfo.setAccelerateStatus(this.mCurrentAccelStatus, this.mAccelUser.mUserType);
        } else {
            xLAccelBackupInfo.setAccelerateStatus(this.mCurrentAccelStatus, 0);
        }
        if (this.mCurrentAccelStatus == 1) {
            xLAccelBackupInfo.setBandwidthInfo(this.mStartInfo.getXlAccelBandInfo());
            xLAccelBackupInfo.setUserInfo(this.mAccelUser);
            if (this.mAccelUser.isTryUser()) {
                xLAccelBackupInfo.setTryInfo(this.mTryInfo.getXlAccelTryInfo());
            }
        }
        xLAccelBackupInfo.saveState(context);
    }

    public void attachListener(XLOnAccelListener xLOnAccelListener) {
        this.mUserListeners.add(xLOnAccelListener);
    }

    public void detachListener(XLOnAccelListener xLOnAccelListener) {
        this.mUserListeners.remove(xLOnAccelListener);
    }

    public void onQueryPortal(int i, int i2, PortalResultBean portalResultBean, boolean z) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
            return;
        }
        this.bForbidQueryPortal = z;
        this.latch.countDown();
        this.mPortalErrorCode = i2;
        if (i2 == 0) {
            this.mHadPortal = true;
            this.bForbidQueryPortal = false;
            i = TAG;
            StringBuilder stringBuilder = new StringBuilder("onQueryPortal success ");
            stringBuilder.append(i2);
            stringBuilder.append(h.b);
            stringBuilder.append(portalResultBean.getAddress());
            LogcatUtil.d(i, stringBuilder.toString(), null);
            userGetAccelInfo();
            return;
        }
        i = TAG;
        portalResultBean = new StringBuilder("onQueryPortal failed ");
        portalResultBean.append(i2);
        LogcatUtil.d(i, portalResultBean.toString(), null);
        this.mCurrentStatus = 2;
        dispatchCallBack(this.mCurrentStatus, i2, ErrorCodeUtils.getErrorDesc(i2));
    }

    public void onGetBandInfo(int i, int i2, String str, AccelInfoResultBean accelInfoResultBean) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
            return;
        }
        this.mGetAccelInfoCode = i2;
        if (accelInfoResultBean != null) {
            this.automaticGetAccelErrorMessage = accelInfoResultBean.getRichmessage();
        } else {
            this.automaticGetAccelErrorMessage = ErrorCodeUtils.getErrorDesc(i2);
        }
        if (i2 == ErrorCodeUtils.XLA_REPEATED_PACKAGE) {
            if (getAccelInfoRetry()) {
                return;
            }
        } else if (!(i2 == 0 || i2 == ErrorCodeUtils.XLA_IP_UNLEGAL_ERROR || !getAccelInfoRetry())) {
            return;
        }
        this.mBandInfo = accelInfoResultBean;
        if (i2 == 0) {
            this.mAccelInfoRetry = 0;
            if ((this.mAccelUser == 0 || this.mAccelUser.isTryUser() != 0) && TextUtils.isEmpty(this.mCacheCardId) != 0) {
                this.mCurrentStatus = 3;
                dispatchCallBack(this.mCurrentStatus, i2, str);
                return;
            }
            userStartAccel(true);
            return;
        }
        this.mBandInfo = 0;
        this.mAccelInfoRetry++;
        if (this.mAccelInfoRetry > 3) {
            countTimeToRecoverQuery();
        }
        this.mCurrentStatus = 2;
        dispatchCallBack(this.mCurrentStatus, i2, str);
    }

    public void onGetTryAccelInfo(int i, int i2, String str, TryInfoResultBean tryInfoResultBean) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
            return;
        }
        if (i2 == ErrorCodeUtils.XLA_REPEATED_PACKAGE) {
            if (getTryAccelInfoRetry()) {
                return;
            }
        } else if (!(i2 == 508 || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_FAILED || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_402 || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_403 || i2 == ErrorCodeUtils.XLA_IP_UNLEGAL_ERROR || i2 == 0 || !getTryAccelInfoRetry())) {
            return;
        }
        this.mTryInfo = tryInfoResultBean;
        this.mTryAccelInfoRetry = 0;
        if (i2 == 0) {
            if (this.mTryInfo == null || this.mTryInfo.getXlAccelTryInfo() == null || this.mTryInfo.getXlAccelTryInfo().mNumOfTry <= null) {
                this.mCurrentStatus = 7;
                dispatchCallBack(this.mCurrentStatus, i2, str);
                return;
            }
            userStartAccel(1);
        } else if (this.mTryInfo == null || this.mTryInfo.getXlAccelTryInfo() == null || this.mTryInfo.getXlAccelTryInfo().mNumOfTry >= null) {
            this.mCurrentStatus = 6;
            dispatchCallBack(this.mCurrentStatus, i2, str);
        } else {
            this.mCurrentStatus = 7;
            dispatchCallBack(this.mCurrentStatus, i2, str);
        }
    }

    public void onTimeCardUsing(int i, int i2, String str, TimeCardResultBean timeCardResultBean) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
        } else if (timeCardResultBean == null || TextUtils.isEmpty(timeCardResultBean.expcardid)) {
            this.mCurrentStatus = 3;
            userStartAccel(false);
        } else {
            this.mCurrentStatus = 18;
            this.mCacheStartCardId = timeCardResultBean.expcardid;
            this.mCacheSeconds = timeCardResultBean.leftseconds;
            dispatchCallBack(this.mCurrentStatus, i2, str);
            setAccelStatus(1);
        }
    }

    public void onStartAccel(int i, int i2, String str, StartAccelResultBean startAccelResultBean, String str2) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
            return;
        }
        if (i2 == ErrorCodeUtils.XLA_REPEATED_PACKAGE) {
            if (startAccelRetry()) {
                return;
            }
        } else if (!(i2 == 0 || i2 == ErrorCodeUtils.XLA_ALREADY_UPGRADED || i2 == 508 || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_FAILED || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_402 || i2 == ErrorCodeUtils.XLA_ACCOUNT_CHECK_SESSION_403 || i2 == ErrorCodeUtils.XLA_IP_UNLEGAL_ERROR || i2 == ErrorCodeUtils.XLA_ALREADY_SPEEDUP_IN_ANOTHER_NETWORK || i2 == ErrorCodeUtils.XLA_UNKOWN || i2 == ErrorCodeUtils.XLA_UID_UNLEGAL_ERROR || !startAccelRetry())) {
            return;
        }
        this.mStartAccelRetry = 0;
        this.mCacheStartCardId = str2;
        this.mStartInfo = startAccelResultBean;
        if (i2 == 0) {
            this.alreadyAccelUser = this.mAccelUser;
            if (this.mAccelUser == 0 || this.mAccelUser.isTryUser() != 0) {
                if (TextUtils.isEmpty(str2) == 0) {
                    this.mCurrentStatus = 18;
                } else {
                    this.mCurrentStatus = 4;
                }
                setAccelStatus(1);
                this.mCurrentAccelStatus = 1;
            } else {
                this.mCurrentStatus = 9;
                dispatchCallBack(this.mCurrentStatus, i2, str);
                setAccelStatus(1);
            }
            this.mCacheCardId = null;
        } else if (i2 == ErrorCodeUtils.XLA_ALREADY_UPGRADED) {
            this.mCacheSeconds = 0;
            this.alreadyAccelUser = this.mAccelUser;
            this.mCurrentStatus = 16;
            this.xLAccelController.onceKeepAlive(this.mAccelUser);
            this.xLAccelController.startKeepAlive(this.mAccelUser);
            this.mCurrentAccelStatus = 1;
            this.mCacheCardId = null;
        } else {
            if (!this.mAccelUser.isTryUser()) {
                this.mCurrentStatus = 10;
            } else if (TextUtils.isEmpty(str2) == null) {
                this.mCurrentStatus = 20;
            } else if (this.mTryInfo == null || this.mTryInfo.getXlAccelTryInfo() == null || this.mTryInfo.getXlAccelTryInfo().mNumOfTry > null) {
                this.mCurrentStatus = 6;
            } else {
                this.mCurrentStatus = 7;
            }
            this.mCacheCardId = null;
            this.mCacheSeconds = 0;
            dispatchCallBack(this.mCurrentStatus, i2, str);
        }
    }

    public void onStopAccel(int i, int i2, String str, StopAccelResultBean stopAccelResultBean) {
        this.mIsLoading = false;
        if (this.mIsReInit) {
            this.mIsReInit = false;
            queryStatus();
            return;
        }
        this.mStopInfo = stopAccelResultBean;
        setAccelStatus(2);
        if (i2 == 0) {
            if (this.mAccelUser == 0 || this.mAccelUser.isTryUser() != 0) {
                this.mCurrentStatus = 5;
            } else {
                this.mCurrentStatus = 14;
            }
            dispatchCallBack(this.mCurrentStatus, i2, str);
            this.mCacheStartCardId = 0;
            return;
        }
        if (this.mAccelUser.isTryUser() == 0) {
            this.mCurrentStatus = 9;
        } else if (TextUtils.isEmpty(this.mCacheStartCardId) != 0) {
            this.mCurrentStatus = 4;
        } else {
            this.mCurrentStatus = 18;
        }
        dispatchCallBack(this.mCurrentStatus, i2, str);
    }

    public void onKeepAlive(int i, int i2, String str, KeepResultBean keepResultBean) {
        if (i2 == 513) {
            if (this.mCurrentStatus == 16) {
                int i3 = this.mCurrentStatus;
                StringBuilder stringBuilder = new StringBuilder("aaa");
                stringBuilder.append(str);
                dispatchCallBack(i3, i2, stringBuilder.toString());
            }
            setAccelStatus(2);
            if (this.mAccelUser.isTryUser() != 0) {
                userStopAccel();
            } else {
                userStartAccel(false);
            }
        } else if (i2 == ErrorCodeUtils.XLA_IP_UNLEGAL_ERROR) {
            if (XLNetworkUtils.isWIFIActive(this.mContext) != 0) {
                setAccelStatus(2);
            } else {
                this.mNetworkChangeReceiver.setNeedRetry();
            }
            userStopAccel();
        } else if (i2 == ErrorCodeUtils.XLA_DEVICE_KICKED) {
            setAccelStatus(2);
        } else if (i2 == 704) {
            if (this.mAccelUser.isTryUser() == 0) {
                userStartAccel(false);
                return;
            }
            userStopAccel();
            setAccelStatus(2);
        } else if (i2 == 3) {
            this.mNetworkChangeReceiver.setNeedRetry();
        } else if (this.mKeepAliveRetry <= 0) {
            this.mKeepAliveRetry++;
        } else {
            this.mKeepAliveRetry = 0;
            setAccelStatus(2);
            userStartAccel(false);
        }
    }

    public void onTimeCounterTimerTick(int i, int i2, boolean z) {
        if (z) {
            setAccelStatus(2);
            if (this.mAccelUser != null && this.mAccelUser.isTryUser()) {
                userStopAccel();
            }
            onStopAccel(0, 7, ErrorCodeUtils.getErrorDesc(7), null);
        }
        if (this.mTryInfo == null) {
            this.mTryInfo = new TryInfoResultBean();
            this.mTryInfo.setXlAccelTryInfo(new XLAccelTryInfo());
        }
        this.mTryInfo.getXlAccelTryInfo().mRemainTime = i2;
        if (this.mCurrentStatus == 18) {
            this.mCacheSeconds = i2;
        }
        if (z) {
            this.mCurrentStatus = true;
            this.mCacheSeconds = 0;
        }
        i = this.mCurrentStatus;
        z = new StringBuilder("倒计时");
        z.append(i2);
        z.append("秒");
        dispatchCallBack(i, i2, z.toString());
    }

    public void onAlreadyUpgrade(String str, KeepResultBean keepResultBean) {
        keepResultBean = new StringBuilder();
        keepResultBean.append(ErrorCodeUtils.getChangeClientType(str));
        keepResultBean.append("已经加速");
        this.changeClientType = keepResultBean.toString();
        dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_ALREADY_UPGRADED, this.changeClientType);
    }

    public void changeUser(XLUserInfo xLUserInfo, int i, int i2, KnParams knParams) {
        this.mIsKuaiNiaoVIP = i;
        this.mKnParams = knParams;
        if (xLUserInfo != null) {
            this.mAccelUser = new XLAccelUser(xLUserInfo, i, knParams);
        } else {
            this.mAccelUser = new XLAccelUser();
        }
        if (this.isPaySuccess != null) {
            this.isPaySuccess = false;
            dispatchCallBack(this.mCurrentStatus, -1000, ErrorCodeUtils.getErrorDesc(-1000));
        }
        if (this.mCurrentStatus == 9) {
            if (this.mIsLoading != null) {
                this.mIsReInit = true;
            }
            userStopAccel();
            setAccelStatus(2);
        }
        if (this.mCurrentStatus != 2) {
            if (this.mCurrentStatus != null) {
                if (this.mCurrentStatus != 4) {
                    if (this.mCurrentStatus != 18) {
                        if (this.mCurrentStatus != 18) {
                            this.mCurrentStatus = 3;
                        }
                        if (this.mIsLoading == null) {
                            queryStatus();
                        } else if (this.changeUserCount > 1 && this.mIsLoading != null) {
                            this.mIsReInit = true;
                        }
                        this.changeUserCount += 1;
                    }
                }
                if (this.mAccelUser.isTryUser() == null) {
                    if (this.mIsLoading != null) {
                        this.mIsReInit = true;
                    }
                    setAccelStatus(2);
                    this.mCurrentStatus = 3;
                }
                if (this.mIsLoading == null) {
                    queryStatus();
                } else {
                    this.mIsReInit = true;
                }
                this.changeUserCount += 1;
            }
        }
        this.mCurrentStatus = 0;
        if (this.mIsLoading == null) {
            this.mIsReInit = true;
        } else {
            queryStatus();
        }
        this.changeUserCount += 1;
    }

    private void dispatchCallBack(int i, int i2, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("dispatchCallBack() statusCode=");
        stringBuilder.append(i);
        stringBuilder.append("; errorCode=");
        stringBuilder.append(i2);
        stringBuilder.append("; errorDesc=");
        stringBuilder.append(str);
        LogcatUtil.d(str2, stringBuilder.toString(), null);
        for (int i3 = 0; i3 < this.mUserListeners.size(); i3++) {
            ((XLOnAccelListener) this.mUserListeners.get(i3)).callBack(i, i2, str);
        }
    }

    private boolean getAccelInfoRetry() {
        if (this.mAccelInfoRetry > 3) {
            return false;
        }
        this.mAccelInfoRetry++;
        if (this.mAccelInfoRetry > 3) {
            countTimeToRecoverQuery();
        }
        userGetAccelInfo();
        return true;
    }

    private boolean getTryAccelInfoRetry() {
        if (this.mTryAccelInfoRetry > 0) {
            return false;
        }
        this.mTryAccelInfoRetry++;
        userGetTryAccelInfo();
        return true;
    }

    private boolean startAccelRetry() {
        if (this.mStartAccelRetry > 0) {
            return false;
        }
        this.mStartAccelRetry++;
        userStartAccel(false);
        return true;
    }

    private void setAccelStatus(int i) {
        if (i != this.mCurrentAccelStatus) {
            this.mCurrentAccelStatus = i;
            switch (this.mCurrentAccelStatus) {
                case 1:
                    if (this.mHadPortal != 0 && this.mInited != 0 && this.mAccelUser != 0) {
                        restartKeepAlive();
                        if (this.mAccelUser.isTryUser() != 0) {
                            if (this.mTryInfo == 0) {
                                this.mTryInfo = new TryInfoResultBean();
                                this.mTryInfo.setXlAccelTryInfo(new XLAccelTryInfo());
                                this.mTryInfo.getXlAccelTryInfo().mNumOfTry = 0;
                            }
                            startTimeCount();
                            return;
                        }
                    }
                    return;
                    break;
                case 2:
                    stopKeepAlive();
                    stopTimeCount();
                    break;
                default:
                    break;
            }
        }
    }

    private void stopKeepAlive() {
        this.xLAccelController.stopKeepAlive();
    }

    private void restartKeepAlive() {
        this.xLAccelController.startKeepAlive(this.mAccelUser);
    }

    private void startTimeCount() {
        int i = this.mCacheSeconds > 0 ? this.mCacheSeconds : (this.mTryInfo == null || this.mTryInfo.getXlAccelTryInfo() == null) ? 0 : this.mTryInfo.getXlAccelTryInfo().mRemainTime > 0 ? this.mTryInfo.getXlAccelTryInfo().mRemainTime : this.mTryInfo.getXlAccelTryInfo().mTryDuration * 60;
        this.xLAccelController.startTimeCount(i);
    }

    private void stopTimeCount() {
        this.xLAccelController.stopTimeCount();
    }

    private void restoreState() {
        new Thread() {
            public void run() {
                if (XLAccelBackupInfo.getSaveStateSuccessFlag(XLAcceleratorInteractor.this.mContext)) {
                    XLAccelBackupInfo.setSaveStateSuccessFlag(XLAcceleratorInteractor.this.mContext, false);
                    while (!XLAcceleratorInteractor.this.mHadPortal) {
                        try {
                            XLAcceleratorInteractor.this.latch.await(5, TimeUnit.MINUTES);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!XLAcceleratorInteractor.this.mIsLoading) {
                            return;
                        }
                    }
                    if (XLAcceleratorInteractor.this.mHadPortal) {
                        XLAccelBackupInfo restoreState = XLAccelBackupInfo.restoreState(XLAcceleratorInteractor.this.mContext);
                        if (restoreState != null && restoreState.getAccelerateStatus() != AccelStatus.NOT_ACCELERATE) {
                            long currentTimeMillis = (System.currentTimeMillis() - restoreState.mBackupSystemTime) / 1000;
                            XLAccelUser restoreUserInfo = restoreState.restoreUserInfo(new XLAccelUser());
                            if (XLAcceleratorInteractor.this.mAccelUser == null || XLAcceleratorInteractor.this.mAccelUser.mUserID.equals(restoreUserInfo.mUserID)) {
                                XLAcceleratorInteractor.this.mAccelUser = restoreUserInfo;
                                if (restoreState.getAccelerateStatus() == AccelStatus.IS_ACCELERATE) {
                                    XLAcceleratorInteractor.this.mHandler.post(new Runnable() {
                                        public void run() {
                                            XLAcceleratorInteractor.this.setAccelStatus(1);
                                        }
                                    });
                                    return;
                                }
                                if (restoreState.getAccelerateStatus() == AccelStatus.IS_TRYING) {
                                    if (XLAcceleratorInteractor.this.mTryInfo == null) {
                                        XLAcceleratorInteractor.this.mTryInfo = new TryInfoResultBean();
                                    }
                                    XLAcceleratorInteractor.this.mTryInfo.setXlAccelTryInfo(restoreState.restoreTryInfo(new XLAccelTryInfo()));
                                    long j = restoreState.mTryRemainTime - currentTimeMillis;
                                    if (j <= 0) {
                                        XLAcceleratorInteractor.this.onTimeCounterTimerTick(XLAcceleratorInteractor.this.mTryInfo.getXlAccelTryInfo().mTryDuration * 60, 0, true);
                                        return;
                                    }
                                    XLAcceleratorInteractor.this.mTryInfo.getXlAccelTryInfo().mRemainTime = (int) j;
                                    XLAcceleratorInteractor.this.mHandler.post(new Runnable() {
                                        public void run() {
                                            XLAcceleratorInteractor.this.setAccelStatus(1);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            }
        }.start();
    }

    private void registerNetworkReceiver() {
        if (this.mContext != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            this.mContext.registerReceiver(this.mNetworkChangeReceiver, intentFilter);
        }
    }

    private void unRegisterReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mNetworkChangeReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPortalUrl(String str) {
        this.portalUrl = str;
    }

    public String getPortalUrl() {
        return this.portalUrl;
    }

    public void queryStatus() {
        queryStatus(null);
    }

    private void queryStatus(String str) {
        boolean z = this.mIsLoading;
        int i = ErrorCodeUtils.XLA_STATUS_LOADING;
        if (z) {
            dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            return;
        }
        int i2 = -1;
        String errorDesc = ErrorCodeUtils.getErrorDesc(-1);
        switch (this.mCurrentStatus) {
            case 0:
            case 1:
            case 2:
                str = ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING);
                if (this.mBandInfo != null) {
                    i = this.mBandInfo.getError();
                    str = this.mBandInfo.getRichmessage();
                }
                if (this.mCurrentStatus != 0) {
                    dispatchCallBack(this.mCurrentStatus, i, str);
                }
                restartQueryInfo();
                return;
            case 3:
                if (this.mBandInfo != null) {
                    i2 = this.mBandInfo.getError();
                    errorDesc = this.mBandInfo.getRichmessage();
                    break;
                }
                break;
            case 4:
            case 18:
                if (this.mStartInfo != null) {
                    i2 = this.mStartInfo.getError();
                    errorDesc = this.mStartInfo.getRichmessage();
                }
                dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
                if (this.mBandInfo != null && this.mAccelUser.isTryUser() == null) {
                    userStartAccel(false);
                    return;
                }
            case 5:
            case 20:
                break;
            case 6:
                if (this.mStartInfo != null) {
                    dispatchCallBack(this.mCurrentStatus, this.mStartInfo.getError(), this.mStartInfo.getRichmessage());
                    return;
                } else if (this.mTryInfo != null) {
                    dispatchCallBack(this.mCurrentStatus, this.mTryInfo.getError(), this.mTryInfo.getRichmessage());
                    return;
                } else {
                    dispatchCallBack(this.mCurrentStatus, -1, errorDesc);
                    return;
                }
            case 7:
                if (this.mStartInfo != null) {
                    i2 = this.mStartInfo.getError();
                    errorDesc = this.mStartInfo.getRichmessage();
                }
                dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
                return;
            case 8:
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
                return;
            case 9:
                dispatchCallBack(this.mCurrentStatus, 0, ErrorCodeUtils.getErrorDesc(0));
                return;
            case 10:
                if (this.mStartInfo != null) {
                    i2 = this.mStartInfo.getError();
                    errorDesc = this.mStartInfo.getRichmessage();
                }
                dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
                return;
            case 11:
                dispatchCallBack(this.mCurrentStatus, 11, ErrorCodeUtils.getErrorDesc(11));
                return;
            case 12:
                dispatchCallBack(this.mCurrentStatus, 10, ErrorCodeUtils.getErrorDesc(10));
                return;
            case 13:
                dispatchCallBack(this.mCurrentStatus, -1, ErrorCodeUtils.getErrorDesc(-1));
                return;
            case 14:
                if (this.mStopInfo != null) {
                    i2 = this.mStartInfo.getError();
                    errorDesc = this.mStopInfo.getRichmessage();
                }
                dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
                return;
            case 15:
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
                return;
            case 16:
                if (this.mStartInfo != null) {
                    i2 = this.mStartInfo.getError();
                }
                dispatchCallBack(this.mCurrentStatus, i2, this.changeClientType);
                return;
            case 17:
                dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
                break;
            default:
                break;
        }
        if (this.mStartInfo != null) {
            i2 = this.mStartInfo.getError();
            errorDesc = this.mStartInfo.getRichmessage();
        }
        dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
        if (this.mBandInfo != null) {
            if (this.mAccelUser.isTryUser()) {
                if (TextUtils.isEmpty(str)) {
                    if (this.mCurrentStatus != 5) {
                        this.mCurrentStatus = 3;
                        dispatchCallBack(this.mCurrentStatus, i2, errorDesc);
                        return;
                    }
                }
            }
            this.mCacheCardId = str;
            userStartAccel(false);
        }
    }

    public void startAccel() {
        if (this.mIsLoading) {
            dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            return;
        }
        if (!(this.mCurrentStatus == 3 || this.mCurrentStatus == 10 || this.mCurrentStatus == 14 || this.mCurrentStatus == 5 || this.mCurrentStatus == 6)) {
            if (this.mCurrentStatus != 20) {
                queryStatus();
                return;
            }
        }
        if (this.mAccelUser.isTryUser()) {
            userGetTryAccelInfo();
        } else {
            userStartAccel(false);
        }
    }

    public void stopAccel() {
        if (this.mIsLoading) {
            dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
            return;
        }
        if (this.mCurrentStatus == 9) {
            userStopAccel();
        }
    }

    public void recoverQuery() {
        recoverQueryCount();
        this.mAccelInfoRetry = 2;
        userQueryPortal();
    }

    public String getBandInfo() {
        if (this.mBandInfo == null) {
            return "";
        }
        return XLAccelModel.bandInfoToJson(this.mBandInfo.getSeq(), this.mBandInfo.getError(), this.mBandInfo.getRichmessage(), this.mBandInfo.getXlAccelBandInfo());
    }

    public XLAccelBandInfo getBandInfoObject() {
        if (this.mBandInfo == null) {
            return null;
        }
        return this.mBandInfo.getXlAccelBandInfo();
    }

    public String getTryInfo() {
        if (this.mTryInfo == null) {
            this.mTryInfo = new TryInfoResultBean();
            XLAccelTryInfo xLAccelTryInfo = new XLAccelTryInfo();
            xLAccelTryInfo.mNumOfTry = 1;
            xLAccelTryInfo.mRemainTime = 0;
            xLAccelTryInfo.mTryDuration = 0;
            this.mTryInfo.setXlAccelTryInfo(xLAccelTryInfo);
        }
        return XLAccelModel.tryInfoToJson(this.mTryInfo.getSeq(), this.mTryInfo.getError(), this.mTryInfo.getRichmessage(), this.mTryInfo.getXlAccelTryInfo());
    }

    public String getUserInfo() {
        return XLAccelModel.UserInfoToJsonJ(this.mAccelUser);
    }

    public int getRemainTime() {
        return this.xLAccelController.getRemainTime();
    }

    public KnParams getKnParams() {
        return this.mKnParams;
    }

    public int isKuaiNiao() {
        return this.mIsKuaiNiaoVIP;
    }

    public void updateUserInfo() {
        this.isReLogin = true;
        this.isPaySuccess = true;
        XLUserUtil.getInstance().userGetInfo(this.mXLOnUserListener, 14, "update");
    }

    private void restartQueryInfo() {
        if (this.mHadPortal) {
            if (this.mBandInfo == null) {
                userGetAccelInfo();
            }
            return;
        }
        userQueryPortal();
    }

    private void reInitQueryStatus() {
        this.mHadPortal = false;
        this.mBandInfo = null;
    }

    public void countTimeToRecoverQuery() {
        if (!this.bHasRecoveryCounted) {
            this.mHandler.removeCallbacks(this.recoverQueryRunnable);
            this.mHandler.postDelayed(this.recoverQueryRunnable, XLAccelHttpReqInfo.getRecoverQueryCountTime());
            this.bHasRecoveryCounted = true;
        }
    }

    private void recoverQueryCount() {
        this.mAccelInfoRetry = 0;
        this.bHasRecoveryCounted = false;
        this.bForbidQueryPortal = false;
    }

    public void startAccelWithCard(String str, int i) {
        if (!this.mAccelUser.isTryUser() && this.mAccelUser.mVipType == 5) {
            dispatchCallBack(21, 12, ErrorCodeUtils.getErrorDesc(12));
            queryStatus(str);
        } else if (!this.mAccelUser.isTryUser() && this.mAccelUser.mVipType == 100) {
            dispatchCallBack(21, 13, ErrorCodeUtils.getErrorDesc(13));
            queryStatus(str);
        } else if (this.mIsLoading) {
            dispatchCallBack(this.mCurrentStatus, ErrorCodeUtils.XLA_STATUS_LOADING, ErrorCodeUtils.getErrorDesc(ErrorCodeUtils.XLA_STATUS_LOADING));
        } else {
            this.mCacheCardId = str;
            this.mCacheSeconds = i * 60;
            if (!(this.mCurrentStatus == 3 || this.mCurrentStatus == 10 || this.mCurrentStatus == 14 || this.mCurrentStatus == 5 || this.mCurrentStatus == 6 || this.mCurrentStatus == 20)) {
                if (this.mCurrentStatus != 7) {
                    queryStatus(str);
                    return;
                }
            }
            if (this.mAccelUser.isTryUser() == 0 || TextUtils.isEmpty(str) == null) {
                userStartAccel(true);
            } else {
                userGetTryAccelInfo();
            }
        }
    }

    public void queryAllExpCards(XLOnAllCardsListener xLOnAllCardsListener) {
        if (xLOnAllCardsListener != null) {
            this.mCardListener = new WeakReference(xLOnAllCardsListener);
            this.xLAccelController.getUserAllExpcard(this.mAccelUser);
        }
    }

    public void onGotALlCards(int i, int i2, String str, AllExpCardsBean allExpCardsBean) {
        XLOnAllCardsListener xLOnAllCardsListener = (XLOnAllCardsListener) this.mCardListener.get();
        if (xLOnAllCardsListener != null) {
            xLOnAllCardsListener.onQueryAllCards(allExpCardsBean);
        }
    }

    public String getUsingCardInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cardid", this.mCacheStartCardId);
            jSONObject.put("cardtime", this.mCacheSeconds);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
