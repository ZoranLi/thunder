package com.xunlei.common.base.permission;

public final class XLAndroidPermissionOptions {
    private String mDeniedCloseBtn;
    private String mDeniedMessage;
    private String mDeniedSettingBtn;
    private String[] mPermissions;
    private String mRationalBtn;
    private String mRationalMessage;

    public static class Builder {
        private static final String DEF_DENIED_CLOSE_BTN_TEXT = "关闭";
        private static final String DEF_DENIED_MESSAGE = "您拒绝权限申请，此功能将不能正常使用，您可以去设置页面重新授权";
        private static final String DEF_DENIED_SETTINGS_BTN_TEXT = "设置权限";
        private static final String DEF_RATIONAL_BTN_TEXT = "我知道了";
        private static final String DEF_RATIONAL_MESSAGE = "此功能需要您授权，否则将不能正常使用";
        private String mDeniedCloseBtn = DEF_DENIED_CLOSE_BTN_TEXT;
        private String mDeniedMessage = DEF_DENIED_MESSAGE;
        private String mDeniedSettingBtn = DEF_DENIED_SETTINGS_BTN_TEXT;
        private String[] mPermissions;
        private String mRationalBtn = DEF_RATIONAL_BTN_TEXT;
        private String mRationalMessage = DEF_RATIONAL_MESSAGE;

        public Builder setRationalMessage(String str) {
            this.mRationalMessage = str;
            return this;
        }

        public Builder setRationalBtn(String str) {
            this.mRationalBtn = str;
            return this;
        }

        public Builder setDeniedMessage(String str) {
            this.mDeniedMessage = str;
            return this;
        }

        public Builder setDeniedCloseBtn(String str) {
            this.mDeniedCloseBtn = str;
            return this;
        }

        public Builder setDeniedSettingBtn(String str) {
            this.mDeniedSettingBtn = str;
            return this;
        }

        public Builder setPermissions(String... strArr) {
            this.mPermissions = strArr;
            return this;
        }

        public XLAndroidPermissionOptions build() {
            if (this.mPermissions != null) {
                if (this.mPermissions.length != 0) {
                    return new XLAndroidPermissionOptions();
                }
            }
            throw new IllegalArgumentException("mPermissions no found...");
        }
    }

    private XLAndroidPermissionOptions(Builder builder) {
        this.mRationalMessage = builder.mRationalMessage;
        this.mDeniedMessage = builder.mDeniedMessage;
        this.mDeniedCloseBtn = builder.mDeniedCloseBtn;
        this.mDeniedSettingBtn = builder.mDeniedSettingBtn;
        this.mRationalBtn = builder.mRationalBtn;
        this.mPermissions = builder.mPermissions;
    }

    public final String getRationalMessage() {
        return this.mRationalMessage;
    }

    public final String getDeniedMessage() {
        return this.mDeniedMessage;
    }

    public final String getDeniedCloseBtn() {
        return this.mDeniedCloseBtn;
    }

    public final String getDeniedSettingBtn() {
        return this.mDeniedSettingBtn;
    }

    public final String getRationalBtnText() {
        return this.mRationalBtn;
    }

    public final String[] getPermissions() {
        return this.mPermissions;
    }
}
