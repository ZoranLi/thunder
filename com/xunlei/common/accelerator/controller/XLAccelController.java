package com.xunlei.common.accelerator.controller;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.xunlei.common.accelerator.base.BaseController;
import com.xunlei.common.accelerator.base.IAcclHttpListener;
import com.xunlei.common.accelerator.bean.AccelInfoResultBean;
import com.xunlei.common.accelerator.bean.AllExpCardsBean;
import com.xunlei.common.accelerator.bean.KeepResultBean;
import com.xunlei.common.accelerator.bean.StartAccelResultBean;
import com.xunlei.common.accelerator.bean.StopAccelResultBean;
import com.xunlei.common.accelerator.bean.TimeCardResultBean;
import com.xunlei.common.accelerator.bean.TryInfoResultBean;
import com.xunlei.common.accelerator.bean.XLAccelUser;
import com.xunlei.common.accelerator.config.Config;
import com.xunlei.common.accelerator.http.XLAccelHttpReqInfo;
import com.xunlei.common.accelerator.interactor.XLAcceleratorInteractor;
import com.xunlei.common.accelerator.model.XLAccelModel;
import com.xunlei.common.accelerator.utils.ErrorCodeUtils;
import com.xunlei.common.accelerator.utils.LogcatUtil;
import com.xunlei.common.accelerator.utils.XLParameterUtils;
import com.xunlei.common.base.XLAlarmBaseTimer;
import com.xunlei.common.base.XLAlarmBaseTimer.TimerListener;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

public class XLAccelController extends BaseController<IAcclHttpListener, XLAccelModel> implements TimerListener {
    private static final String TAG = "XLAccelController";
    private static int mKeepAliveTimeID = 4112;
    private String XLA_BASE_PREFIX = "http://";
    private CountTimer mCountTimer = null;
    private String mDialAccount;
    private int mErrorCode;
    private String mErrorMessage;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private XLAccelUser mKeepAliveUser;
    private boolean mKeepAliving = false;
    private int mRemainTimerCounter = 0;
    private int mSeq;
    private boolean mTimeCounting = false;
    private int mTotalTimerCounter = 0;
    private XLParameterUtils mXlParameterUtils;

    class CountTimer extends CountDownTimer {
        public CountTimer(long j, long j2) {
            super(j, j2);
        }

        public void onTick(long j) {
            XLAccelController.this.mTimeCounting = true;
            String access$000 = XLAccelController.TAG;
            StringBuilder stringBuilder = new StringBuilder("CountTimer() onTick  ");
            stringBuilder.append(j);
            LogcatUtil.d(access$000, stringBuilder.toString(), null);
            XLAccelController.this.mRemainTimerCounter = (int) (j / 1000);
            ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCounterTimerTick(XLAccelController.this.mTotalTimerCounter, XLAccelController.this.mRemainTimerCounter, false);
        }

        public void onFinish() {
            LogcatUtil.d(XLAccelController.TAG, "CountTimer() onFinish  ", null);
            ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCounterTimerTick(XLAccelController.this.mTotalTimerCounter, XLAccelController.this.mRemainTimerCounter, true);
            XLAccelController.this.mTimeCounting = false;
        }
    }

    public XLAccelController(Context context, IAcclHttpListener iAcclHttpListener, XLParameterUtils xLParameterUtils) {
        super(context, iAcclHttpListener);
        this.mXlParameterUtils = xLParameterUtils;
        this.mModel = new XLAccelModel();
        XLAlarmBaseTimer.init(context);
        if (Config.sCurrentKey != null) {
            mKeepAliveTimeID = Config.sCurrentKey.hashCode();
        }
    }

    public void queryPortal() {
        excuteRequest(XLAccelHttpReqInfo.getPortalAdress(), new BaseHttpClientListener() {
            private int canRetryCount = 2;
            private int portalRetryCount = null;

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Exception e;
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("queryPortal() onSuccess ");
                stringBuilder.append(i);
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i < 200 || i >= 300) {
                    XLAccelController.this.mErrorCode = 2;
                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                    this.canRetryCount = 4;
                    if (this.portalRetryCount >= this.canRetryCount) {
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, null, true);
                        return;
                    }
                    this.portalRetryCount++;
                    if (this.portalRetryCount > 2) {
                        XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdressSecond(), this, 2000);
                        return;
                    } else {
                        XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdress(), this, 2000);
                        return;
                    }
                }
                try {
                    bArr = ((XLAccelModel) XLAccelController.this.mModel).parsePortalData(new String(bArr, "UTF-8"));
                    if (bArr == null) {
                        try {
                            XLAccelController.this.mErrorCode = 5;
                            XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                            XLAccelController.this.mSeq = 0;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            XLAccelController.this.mErrorCode = 4;
                            XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                            XLAccelController.this.mSeq = 0;
                            if (this.portalRetryCount >= this.canRetryCount) {
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, bArr, true);
                                return;
                            }
                            this.portalRetryCount++;
                            XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdress(), this, 2000);
                        }
                    }
                    XLAccelController.this.mErrorCode = bArr.getError();
                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, bArr.getRichmessage());
                    XLAccelController.this.mSeq = bArr.getSeq();
                    if (XLAccelController.this.mErrorCode == 0) {
                        XLAccelController.this.XLA_BASE_PREFIX = bArr.getAddress();
                        if (XLAccelController.this.mInterator instanceof XLAcceleratorInteractor) {
                            ((XLAcceleratorInteractor) XLAccelController.this.mInterator).setPortalUrl(XLAccelController.this.XLA_BASE_PREFIX);
                        }
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, bArr, false);
                        return;
                    }
                    XLAccelController.this.XLA_BASE_PREFIX = "http://";
                } catch (byte[] bArr2) {
                    e = bArr2;
                    bArr2 = null;
                    e.printStackTrace();
                    XLAccelController.this.mErrorCode = 4;
                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                    XLAccelController.this.mSeq = 0;
                    if (this.portalRetryCount >= this.canRetryCount) {
                        this.portalRetryCount++;
                        XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdress(), this, 2000);
                    }
                    ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, bArr2, true);
                    return;
                }
                if (this.portalRetryCount >= this.canRetryCount) {
                    ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, bArr2, true);
                    return;
                }
                this.portalRetryCount++;
                XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdress(), this, 2000);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                bArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("queryPortal() onFailure ");
                stringBuilder.append(th);
                LogcatUtil.d(bArr, stringBuilder.toString(), null);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                this.canRetryCount = 4;
                if (this.portalRetryCount >= this.canRetryCount) {
                    ((IAcclHttpListener) XLAccelController.this.mInterator).onQueryPortal(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, null, true);
                    return;
                }
                this.portalRetryCount += 1;
                if (this.portalRetryCount > 2) {
                    XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdressSecond(), this, 2000);
                } else {
                    XLAccelController.this.excuteRequestDelay(XLAccelHttpReqInfo.getPortalAdress(), this, 2000);
                }
            }
        });
    }

    private void excuteRequestDelay(final String str, final BaseHttpClientListener baseHttpClientListener, long j) {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                XLAccelController.this.excuteRequest(str, baseHttpClientListener);
            }
        }, j);
    }

    public void getBandInfo(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.parameterToHttpAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.GET_ACCELINFO_INTERFACE, xLAccelUser).toString();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("getBandInfo() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("getBandInfo() onSuccess ");
                stringBuilder.append(i);
                AccelInfoResultBean accelInfoResultBean = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i == 200) {
                    try {
                        i = ((XLAccelModel) XLAccelController.this.mModel).parseBandInfoData(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            try {
                                XLAccelController.this.mErrorCode = 5;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                accelInfoResultBean = i;
                                bArr.printStackTrace();
                                XLAccelController.this.mErrorCode = 4;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetBandInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, accelInfoResultBean);
                            }
                        }
                        XLAccelController.this.mErrorCode = i.getError();
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        XLAccelController.this.mSeq = i.getSeq();
                        XLAccelController.this.mDialAccount = i.getDialAccount();
                        XLAccelController.this.mErrorCode;
                        accelInfoResultBean = i;
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        XLAccelController.this.mErrorCode = 4;
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        XLAccelController.this.mSeq = 0;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onGetBandInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, accelInfoResultBean);
                    }
                }
                XLAccelController.this.mErrorCode = 2;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = 0;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetBandInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, accelInfoResultBean);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                bArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("getBandInfo() onFailure ");
                stringBuilder.append(th);
                LogcatUtil.d(bArr, stringBuilder.toString(), null);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = null;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetBandInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null);
            }
        });
    }

    public void getTryAccelInfo(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.parameterToHttpAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.GET_TRY_ACCELINFO_INTERFACE, xLAccelUser).toString();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("getTryAccelInfo() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("getTryAccelInfo() onSuccess ");
                stringBuilder.append(i);
                TryInfoResultBean tryInfoResultBean = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i == 200) {
                    try {
                        i = ((XLAccelModel) XLAccelController.this.mModel).parseTryAccelInfoData(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            try {
                                XLAccelController.this.mErrorCode = 5;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                tryInfoResultBean = i;
                                bArr.printStackTrace();
                                XLAccelController.this.mErrorCode = 4;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetTryAccelInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, tryInfoResultBean);
                            }
                        }
                        XLAccelController.this.mErrorCode = i.getError();
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        XLAccelController.this.mSeq = i.getSeq();
                        tryInfoResultBean = i;
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        XLAccelController.this.mErrorCode = 4;
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        XLAccelController.this.mSeq = 0;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onGetTryAccelInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, tryInfoResultBean);
                    }
                }
                XLAccelController.this.mErrorCode = 2;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = 0;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetTryAccelInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, tryInfoResultBean);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                LogcatUtil.d(XLAccelController.TAG, "getTryAccelInfo() onFailure ", th);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = null;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGetTryAccelInfo(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null);
            }
        });
    }

    public void checkTimeCardUsing(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.getCheckUsingCardAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.URL_PATH_CHECK_CARD, xLAccelUser, this.mDialAccount);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("checkTimeCardUsing() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("checkTimeCardUsing() onSuccess ");
                stringBuilder.append(i);
                TimeCardResultBean timeCardResultBean = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i == 200) {
                    try {
                        i = TimeCardResultBean.parse(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            try {
                                XLAccelController.this.mErrorCode = 5;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                timeCardResultBean = i;
                                bArr.printStackTrace();
                                XLAccelController.this.mErrorCode = 4;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCardUsing(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, timeCardResultBean);
                            }
                        }
                        XLAccelController.this.mErrorCode = i.getError();
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        XLAccelController.this.mSeq = i.getSeq();
                        timeCardResultBean = i;
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        XLAccelController.this.mErrorCode = 4;
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        XLAccelController.this.mSeq = 0;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCardUsing(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, timeCardResultBean);
                    }
                }
                XLAccelController.this.mErrorCode = 2;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = 0;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCardUsing(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, timeCardResultBean);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                LogcatUtil.d(XLAccelController.TAG, "checkTimeCardUsing() onFailure ", th);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = null;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onTimeCardUsing(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null);
            }
        });
    }

    public void startAccel(XLAccelUser xLAccelUser, final String str) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.getStartAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.START_ACCEL, xLAccelUser, this.mDialAccount, str);
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("startAccel() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str2, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                StartAccelResultBean startAccelResultBean;
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("startAccel() onSuccess ");
                stringBuilder.append(i);
                Throwable th = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i == 200) {
                    try {
                        i = ((XLAccelModel) XLAccelController.this.mModel).parseStartAccelData(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            try {
                                XLAccelController.this.mErrorCode = 5;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                th = i;
                                bArr.printStackTrace();
                                XLAccelController.this.mErrorCode = 4;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                                startAccelResultBean = th;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onStartAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, startAccelResultBean, str);
                            }
                        }
                        XLAccelController.this.mErrorCode = i.getError();
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        XLAccelController.this.mSeq = i.getSeq();
                        startAccelResultBean = i;
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        XLAccelController.this.mErrorCode = 4;
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        XLAccelController.this.mSeq = 0;
                        startAccelResultBean = th;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onStartAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, startAccelResultBean, str);
                    }
                }
                XLAccelController.this.mErrorCode = 2;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = 0;
                startAccelResultBean = th;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onStartAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, startAccelResultBean, str);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                LogcatUtil.d(XLAccelController.TAG, "startAccel() onFailure ", th);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = null;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onStartAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null, str);
            }
        });
    }

    public void stopAccel(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.getStopOrAliveAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.STOP_ACCEL, xLAccelUser, this.mDialAccount);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("stopAccel() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("onSuccess() statusCode ");
                stringBuilder.append(i);
                StopAccelResultBean stopAccelResultBean = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                if (i == 200) {
                    try {
                        i = ((XLAccelModel) XLAccelController.this.mModel).parseStopAccelData(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            try {
                                XLAccelController.this.mErrorCode = 5;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                stopAccelResultBean = i;
                                bArr.printStackTrace();
                                XLAccelController.this.mErrorCode = 4;
                                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                XLAccelController.this.mSeq = 0;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onStopAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, stopAccelResultBean);
                            }
                        }
                        XLAccelController.this.mErrorCode = i.getError();
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        XLAccelController.this.mSeq = i.getSeq();
                        stopAccelResultBean = i;
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        XLAccelController.this.mErrorCode = 4;
                        XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        XLAccelController.this.mSeq = 0;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onStopAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, stopAccelResultBean);
                    }
                }
                XLAccelController.this.mErrorCode = 2;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = 0;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onStopAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, stopAccelResultBean);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                LogcatUtil.d(XLAccelController.TAG, "stopAccel() onFailure ", th);
                XLAccelController.this.mErrorCode = 3;
                XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                XLAccelController.this.mSeq = null;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onStopAccel(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null);
            }
        });
    }

    public int getRemainTime() {
        return this.mRemainTimerCounter;
    }

    public void startKeepAlive(XLAccelUser xLAccelUser) {
        if (this.mKeepAliving) {
            stopKeepAlive();
        }
        this.mKeepAliveUser = xLAccelUser;
        XLAlarmBaseTimer.getInstance().registerTimer(mKeepAliveTimeID, XLAccelHttpReqInfo.getXLKeepAliveTime(), true, this);
        this.mKeepAliving = true;
    }

    public void onceKeepAlive(XLAccelUser xLAccelUser) {
        this.mKeepAliveUser = xLAccelUser;
        keepAlive(true);
    }

    public void stopKeepAlive() {
        if (this.mKeepAliving) {
            XLAlarmBaseTimer.getInstance().unRegisterTimer(mKeepAliveTimeID);
            this.mKeepAliving = false;
        }
    }

    public void onTimerTick(int i) {
        if (i == mKeepAliveTimeID) {
            keepAlive(0);
        }
    }

    public void keepAlive(final boolean z) {
        if (this.mKeepAliveUser != null) {
            String stopOrAliveAddress = this.mXlParameterUtils.getStopOrAliveAddress(this.XLA_BASE_PREFIX, XLAccelHttpReqInfo.KEEP_ALIVE, this.mKeepAliveUser, this.mDialAccount);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("keepAlive() ");
            stringBuilder.append(stopOrAliveAddress);
            LogcatUtil.d(str, stringBuilder.toString(), null);
            excuteRequest(stopOrAliveAddress, new BaseHttpClientListener() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    headerArr = XLAccelController.TAG;
                    StringBuilder stringBuilder = new StringBuilder("keepAlive() onSuccess ");
                    stringBuilder.append(i);
                    KeepResultBean keepResultBean = null;
                    LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                    if (i == 200) {
                        try {
                            i = ((XLAccelModel) XLAccelController.this.mModel).parseKeepAliveData(new String(bArr, "UTF-8"));
                            if (i == 0) {
                                try {
                                    XLAccelController.this.mErrorCode = 5;
                                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                    XLAccelController.this.mSeq = 0;
                                } catch (UnsupportedEncodingException e) {
                                    bArr = e;
                                    keepResultBean = i;
                                    bArr.printStackTrace();
                                    XLAccelController.this.mErrorCode = 4;
                                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                    XLAccelController.this.mSeq = 0;
                                    ((IAcclHttpListener) XLAccelController.this.mInterator).onKeepAlive(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, keepResultBean);
                                }
                            }
                            XLAccelController.this.mErrorCode = i.getError();
                            XLAccelController.this.mErrorMessage = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                            i.setRichmessage(XLAccelController.this.mErrorMessage);
                            XLAccelController.this.mSeq = i.getSeq();
                            if (XLAccelController.this.mErrorCode == null) {
                                if (z != null) {
                                    ((IAcclHttpListener) XLAccelController.this.mInterator).onAlreadyUpgrade(i.getClient_type(), i);
                                }
                                return;
                            }
                            keepResultBean = i;
                        } catch (UnsupportedEncodingException e2) {
                            bArr = e2;
                            bArr.printStackTrace();
                            XLAccelController.this.mErrorCode = 4;
                            XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                            XLAccelController.this.mSeq = 0;
                            ((IAcclHttpListener) XLAccelController.this.mInterator).onKeepAlive(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, keepResultBean);
                        }
                    }
                    XLAccelController.this.mErrorCode = 2;
                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                    XLAccelController.this.mSeq = 0;
                    ((IAcclHttpListener) XLAccelController.this.mInterator).onKeepAlive(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, keepResultBean);
                }

                public void onFailure(Throwable th, byte[] bArr) {
                    LogcatUtil.d(XLAccelController.TAG, "keepAlive() onFailure ", th);
                    XLAccelController.this.mErrorCode = 3;
                    XLAccelController.this.mErrorMessage = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                    XLAccelController.this.mSeq = null;
                    ((IAcclHttpListener) XLAccelController.this.mInterator).onKeepAlive(XLAccelController.this.mSeq, XLAccelController.this.mErrorCode, XLAccelController.this.mErrorMessage, null);
                }
            });
        }
    }

    public void startTimeCount(int i) {
        if (!this.mTimeCounting) {
            this.mTimeCounting = true;
            this.mTotalTimerCounter = i;
            this.mRemainTimerCounter = this.mTotalTimerCounter;
            if (this.mCountTimer != 0) {
                this.mCountTimer.cancel();
            }
            createCountTimer();
            this.mCountTimer.start();
        }
    }

    public boolean isTimeCountDowning() {
        return this.mTimeCounting && this.mCountTimer != null;
    }

    public void stopTimeCount() {
        if (this.mTimeCounting) {
            this.mTimeCounting = false;
            cancelCountTimer();
        }
    }

    private void createCountTimer() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mCountTimer = new CountTimer((long) (this.mTotalTimerCounter * 1000), 1000);
        } else {
            this.mHandler.post(new Runnable() {
                public void run() {
                    XLAccelController.this.mCountTimer = new CountTimer((long) (XLAccelController.this.mTotalTimerCounter * 1000), 1000);
                }
            });
        }
    }

    public void unInitTimer() {
        stopKeepAlive();
        cancelCountTimer();
    }

    private void cancelCountTimer() {
        LogcatUtil.d(TAG, "cancelCountTimer()", null);
        if (this.mCountTimer != null) {
            this.mCountTimer.cancel();
            this.mCountTimer = null;
        }
    }

    public void getUserAllExpcard(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            xLAccelUser = new XLAccelUser();
        }
        xLAccelUser = this.mXlParameterUtils.parameterToHttpAddress("", XLAccelHttpReqInfo.getAllCardAddr(), xLAccelUser).toString();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("getUserAllExpcard() ");
        stringBuilder.append(xLAccelUser);
        LogcatUtil.d(str, stringBuilder.toString(), null);
        excuteRequest(xLAccelUser, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                String errorDesc;
                headerArr = XLAccelController.TAG;
                StringBuilder stringBuilder = new StringBuilder("getUserAllExpcard() onSuccess ");
                stringBuilder.append(i);
                Throwable th = null;
                LogcatUtil.d(headerArr, stringBuilder.toString(), null);
                headerArr = null;
                if (i == 200) {
                    try {
                        i = AllExpCardsBean.paraseJson(new String(bArr, "UTF-8"));
                        if (i == 0) {
                            bArr = 5;
                            try {
                                errorDesc = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                            } catch (UnsupportedEncodingException e) {
                                bArr = e;
                                th = i;
                                bArr.printStackTrace();
                                bArr = 4;
                                errorDesc = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                                i = th;
                                ((IAcclHttpListener) XLAccelController.this.mInterator).onGotALlCards(headerArr, bArr, errorDesc, i);
                            }
                        }
                        bArr = i.getError();
                        errorDesc = ErrorCodeUtils.parseLink(XLAccelController.this.mErrorCode, i.getRichmessage());
                        i.setRichmessage(XLAccelController.this.mErrorMessage);
                        headerArr = i.getSeq();
                    } catch (UnsupportedEncodingException e2) {
                        bArr = e2;
                        bArr.printStackTrace();
                        bArr = 4;
                        errorDesc = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                        i = th;
                        ((IAcclHttpListener) XLAccelController.this.mInterator).onGotALlCards(headerArr, bArr, errorDesc, i);
                    }
                }
                bArr = 2;
                errorDesc = ErrorCodeUtils.getErrorDesc(XLAccelController.this.mErrorCode);
                i = th;
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGotALlCards(headerArr, bArr, errorDesc, i);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                LogcatUtil.d(XLAccelController.TAG, "getUserAllExpcard() onFailure ", th);
                ((IAcclHttpListener) XLAccelController.this.mInterator).onGotALlCards(0, 3, ErrorCodeUtils.getErrorDesc(3), null);
            }
        });
    }
}
