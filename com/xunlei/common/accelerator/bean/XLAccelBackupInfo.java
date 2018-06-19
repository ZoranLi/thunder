package com.xunlei.common.accelerator.bean;

import android.content.Context;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class XLAccelBackupInfo implements Serializable {
    private static final long serialVersionUID = -6772164363300132399L;
    public int mAccelerateStatus;
    public long mBackupSystemTime;
    public long mCurrentBandwidth;
    public long mMaxBandwidth;
    public int mNumOfTry;
    public String mSessionId;
    public long mTryRemainTime;
    public int mTryTotalTime;
    public String mUserId;
    public int mUserType;

    public enum AccelStatus {
        NOT_ACCELERATE,
        IS_ACCELERATE,
        IS_TRYING
    }

    public void setUserInfo(XLAccelUser xLAccelUser) {
        if (xLAccelUser != null) {
            this.mUserId = xLAccelUser.mUserID;
            this.mUserType = xLAccelUser.mUserType;
            this.mSessionId = xLAccelUser.mSessionID;
        }
    }

    public XLAccelUser restoreUserInfo(XLAccelUser xLAccelUser) {
        if (xLAccelUser == null) {
            return null;
        }
        xLAccelUser.mSessionID = this.mSessionId;
        xLAccelUser.mUserID = this.mUserId;
        xLAccelUser.mUserType = this.mUserType;
        return xLAccelUser;
    }

    public XLAccelTryInfo restoreTryInfo(XLAccelTryInfo xLAccelTryInfo) {
        if (xLAccelTryInfo == null) {
            return null;
        }
        xLAccelTryInfo.mNumOfTry = this.mNumOfTry;
        xLAccelTryInfo.mTryDuration = this.mTryTotalTime;
        return xLAccelTryInfo;
    }

    public void setBandwidthInfo(XLAccelBandInfo xLAccelBandInfo) {
        if (xLAccelBandInfo != null) {
            this.mMaxBandwidth = xLAccelBandInfo.mMaxBandWidth.mDownStream;
            this.mCurrentBandwidth = xLAccelBandInfo.mCurrentBandWidth.mDownStream;
        }
    }

    public void setTryInfo(XLAccelTryInfo xLAccelTryInfo) {
        if (xLAccelTryInfo != null) {
            this.mTryTotalTime = xLAccelTryInfo.mTryDuration;
            this.mTryRemainTime = (long) xLAccelTryInfo.mRemainTime;
            this.mNumOfTry = xLAccelTryInfo.mNumOfTry;
        }
    }

    public void setAccelerateStatus(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                this.mAccelerateStatus = 0;
            } else if (i2 == 2) {
                this.mAccelerateStatus = 1;
            } else {
                this.mAccelerateStatus = -1;
            }
            this.mBackupSystemTime = System.currentTimeMillis();
            return;
        }
        this.mAccelerateStatus = -1;
    }

    public AccelStatus getAccelerateStatus() {
        if (this.mAccelerateStatus == 0) {
            return AccelStatus.IS_ACCELERATE;
        }
        if (this.mAccelerateStatus == 1) {
            return AccelStatus.IS_TRYING;
        }
        return AccelStatus.NOT_ACCELERATE;
    }

    public void saveState(Context context) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput("data.s", 4));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            setSaveStateSuccessFlag(context, true);
            new StringBuilder("-------storeState successfully! \n XLAccelBackupInfo = \n").append(this);
        } catch (Context context2) {
            context2.printStackTrace();
        } catch (Context context22) {
            context22.printStackTrace();
        }
    }

    public static XLAccelBackupInfo restoreState(Context context) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput("data.s"));
            XLAccelBackupInfo xLAccelBackupInfo = (XLAccelBackupInfo) objectInputStream.readObject();
            objectInputStream.close();
            new StringBuilder("-------restoreState successfully! \n XLAccelBackupInfo = \n").append(xLAccelBackupInfo);
            setSaveStateSuccessFlag(context, false);
            return xLAccelBackupInfo;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        } catch (Context context22) {
            context22.printStackTrace();
            return null;
        } catch (Context context222) {
            context222.printStackTrace();
            return null;
        } catch (Context context2222) {
            context2222.printStackTrace();
            return null;
        }
    }

    public static void setSaveStateSuccessFlag(Context context, boolean z) {
        context = context.getSharedPreferences("save_state", 4).edit();
        context.putBoolean("save_state_success", z);
        context.commit();
    }

    public static boolean getSaveStateSuccessFlag(Context context) {
        return context.getSharedPreferences("save_state", 4).getBoolean("save_state_success", false);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("mAccelerateStatus = ");
        stringBuilder.append(this.mAccelerateStatus);
        stringBuilder.append("\nmCurrentBandwidth = ");
        stringBuilder.append(this.mCurrentBandwidth);
        stringBuilder.append("\nmMaxBandwidth = ");
        stringBuilder.append(this.mMaxBandwidth);
        stringBuilder.append("\nmBackupSystemTime = ");
        stringBuilder.append(this.mBackupSystemTime);
        stringBuilder.append("\nmTryRemainTime = ");
        stringBuilder.append(this.mTryRemainTime);
        stringBuilder.append("\nmTryTotalTime = ");
        stringBuilder.append(this.mTryTotalTime);
        stringBuilder.append("\nmNumOfTry = ");
        stringBuilder.append(this.mNumOfTry);
        stringBuilder.append("\nmUserId = ");
        stringBuilder.append(this.mUserId);
        stringBuilder.append("\nmUserType = ");
        stringBuilder.append(this.mUserType);
        stringBuilder.append("\nmSessionId = ");
        stringBuilder.append(this.mSessionId);
        return stringBuilder.toString();
    }
}
