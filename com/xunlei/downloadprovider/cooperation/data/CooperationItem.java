package com.xunlei.downloadprovider.cooperation.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.cooperation.l;
import java.io.Serializable;

public class CooperationItem implements Serializable {
    private static final long serialVersionUID = 0;
    private String mAppDescription;
    private String mAppDownloadUrl;
    private String mAppIconUrl;
    private String mAppName;
    private String mAppPackageName;
    private String mAppSelfIconUrl;
    private String mBtnDescription;
    private String mCopyWriting;
    private int mDisplayLocation = -1;
    private int mId;
    private boolean mIsPreLoad;
    private boolean mIsShowInstallTip;
    private String mTitle;

    public CooperationItem(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, String str7, String str8, String str9) {
        this.mDisplayLocation = i2;
        this.mAppName = str;
        this.mAppIconUrl = str3;
        setAppDownloadUrl(str4);
        this.mAppPackageName = str5;
        this.mIsShowInstallTip = z;
        this.mTitle = str7;
        this.mAppDescription = str8;
        this.mBtnDescription = str9;
        this.mId = i;
        this.mCopyWriting = str6;
        this.mAppSelfIconUrl = str2;
        this.mIsPreLoad = z2;
    }

    public CooperationItem(int i, String str, String str2, String str3, String str4, boolean z) {
        this.mAppName = str;
        setAppDownloadUrl(str3);
        this.mAppPackageName = str4;
        this.mId = i;
        this.mAppSelfIconUrl = str2;
        this.mIsPreLoad = z;
    }

    public void setPopWindowData(String str, String str2, String str3) {
        this.mTitle = str;
        this.mAppDescription = str2;
        this.mBtnDescription = str3;
    }

    public boolean isPreLoad() {
        return this.mIsPreLoad;
    }

    public void setPreLoad(boolean z) {
        this.mIsPreLoad = z;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public int getDisplayLocation() {
        return this.mDisplayLocation;
    }

    public void setDisplayLocation(int i) {
        this.mDisplayLocation = i;
    }

    public String getDisplayLocationName() {
        return l.c(getDisplayLocation());
    }

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppIconUrl() {
        return this.mAppIconUrl;
    }

    public void setAppIconUrl(String str) {
        this.mAppIconUrl = str;
    }

    public String getAppSelfIconUrl() {
        return this.mAppSelfIconUrl;
    }

    public void setAppSelfIconUrl(String str) {
        this.mAppSelfIconUrl = str;
    }

    public String getAppDownloadUrl() {
        return this.mAppDownloadUrl;
    }

    public void setAppDownloadUrl(String str) {
        this.mAppDownloadUrl = trimDownloadUrlForAvoidDownloadFail(str);
    }

    public String getAppPackageName() {
        return this.mAppPackageName;
    }

    public void setAppPackageName(String str) {
        this.mAppPackageName = str;
    }

    public boolean isShowInstallTip() {
        return this.mIsShowInstallTip;
    }

    public void setShowInstallTip(boolean z) {
        this.mIsShowInstallTip = z;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getAppDescription() {
        return this.mAppDescription;
    }

    public void setAppDescription(String str) {
        this.mAppDescription = str;
    }

    public String getBtnDescription() {
        return this.mBtnDescription;
    }

    public void setBtnDescription(String str) {
        this.mBtnDescription = str;
    }

    public String getCopyWriting() {
        return this.mCopyWriting;
    }

    public void setCopyWriting(String str) {
        this.mCopyWriting = str;
    }

    public CooperationItem clone() {
        return new CooperationItem(this.mId, this.mDisplayLocation, this.mAppName, this.mAppSelfIconUrl, this.mAppIconUrl, this.mAppDownloadUrl, this.mAppPackageName, this.mCopyWriting, this.mIsShowInstallTip, this.mIsPreLoad, this.mTitle, this.mAppDescription, this.mBtnDescription);
    }

    @Nullable
    private String trimDownloadUrlForAvoidDownloadFail(String str) {
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }
}
