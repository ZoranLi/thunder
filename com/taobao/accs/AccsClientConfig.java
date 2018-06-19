package com.taobao.accs;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class AccsClientConfig {
    public static final String[] DEFAULT_CENTER_HOSTS;
    private static String[] DEFAULT_CHANNEL_HOSTS = new String[]{Constants.SERVICE_HOST, "acs.wapa.taobao.com", "acs.waptest.taobao.com"};
    public static final String DEFAULT_CONFIGTAG = "default";
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    public static boolean loadedStaticConfig = false;
    private static Context mContext;
    private static Map<String, AccsClientConfig> mDebugConfigs = new ConcurrentHashMap(1);
    @ENV
    public static int mEnv;
    private static Map<String, AccsClientConfig> mPreviewConfigs = new ConcurrentHashMap(1);
    private static Map<String, AccsClientConfig> mReleaseConfigs = new ConcurrentHashMap(1);
    private String mAppKey;
    private String mAppSecret;
    private String mAuthCode;
    private boolean mAutoUnit;
    private String mChannelHost;
    private int mChannelPubKey;
    private int mConfigEnv;
    private boolean mDisableChannel;
    private String mInappHost;
    private int mInappPubKey;
    private boolean mKeepalive;
    private int mSecurity;
    private String mTag;

    /* compiled from: Taobao */
    public static class Builder {
        private String mAppKey;
        private String mAppSecret;
        private String mAuthCode;
        private boolean mAutoUnit = true;
        private String mChannelHost;
        private int mChannelPubKey = -1;
        private int mConfigEnv = -1;
        private boolean mDisableChannel = false;
        private String mInappHost;
        private int mInappPubKey = -1;
        private boolean mKeepalive = true;
        private String mTag;

        public Builder setAppKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.mAppSecret = str;
            return this;
        }

        public Builder setInappHost(String str) {
            this.mInappHost = str;
            return this;
        }

        public Builder setChannelHost(String str) {
            this.mChannelHost = str;
            return this;
        }

        public Builder setAutoCode(String str) {
            this.mAuthCode = str;
            return this;
        }

        public Builder setInappPubKey(int i) {
            this.mInappPubKey = i;
            return this;
        }

        public Builder setChannelPubKey(int i) {
            this.mChannelPubKey = i;
            return this;
        }

        public Builder setKeepAlive(boolean z) {
            this.mKeepalive = z;
            return this;
        }

        public Builder setAutoUnit(boolean z) {
            this.mAutoUnit = z;
            return this;
        }

        public Builder setConfigEnv(@ENV int i) {
            this.mConfigEnv = i;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setDisableChannel(boolean z) {
            this.mDisableChannel = z;
            return this;
        }

        public AccsClientConfig build() throws AccsException {
            if (TextUtils.isEmpty(this.mAppKey)) {
                throw new AccsException("appkey null");
            }
            Map access$1400;
            AccsClientConfig accsClientConfig = new AccsClientConfig();
            accsClientConfig.mAppKey = this.mAppKey;
            accsClientConfig.mAppSecret = this.mAppSecret;
            accsClientConfig.mAuthCode = this.mAuthCode;
            accsClientConfig.mKeepalive = this.mKeepalive;
            accsClientConfig.mAutoUnit = this.mAutoUnit;
            accsClientConfig.mInappPubKey = this.mInappPubKey;
            accsClientConfig.mChannelPubKey = this.mChannelPubKey;
            accsClientConfig.mInappHost = this.mInappHost;
            accsClientConfig.mChannelHost = this.mChannelHost;
            accsClientConfig.mTag = this.mTag;
            accsClientConfig.mConfigEnv = this.mConfigEnv;
            accsClientConfig.mDisableChannel = this.mDisableChannel;
            if (accsClientConfig.mConfigEnv < 0) {
                accsClientConfig.mConfigEnv = AccsClientConfig.mEnv;
            }
            if (TextUtils.isEmpty(accsClientConfig.mAppSecret)) {
                accsClientConfig.mSecurity = 0;
            } else {
                accsClientConfig.mSecurity = 2;
            }
            if (TextUtils.isEmpty(accsClientConfig.mInappHost)) {
                accsClientConfig.mInappHost = AccsClientConfig.DEFAULT_CENTER_HOSTS[AccsClientConfig.mEnv];
            }
            if (TextUtils.isEmpty(accsClientConfig.mChannelHost)) {
                accsClientConfig.mChannelHost = AccsClientConfig.DEFAULT_CHANNEL_HOSTS[AccsClientConfig.mEnv];
            }
            if (TextUtils.isEmpty(accsClientConfig.mTag)) {
                accsClientConfig.mTag = accsClientConfig.mAppKey;
            }
            switch (accsClientConfig.mConfigEnv) {
                case 1:
                    access$1400 = AccsClientConfig.mPreviewConfigs;
                    break;
                case 2:
                    access$1400 = AccsClientConfig.mDebugConfigs;
                    break;
                default:
                    access$1400 = AccsClientConfig.mReleaseConfigs;
                    break;
            }
            access$1400.put(accsClientConfig.getTag(), accsClientConfig);
            StringBuilder stringBuilder = new StringBuilder("AccsClientConfig_");
            stringBuilder.append(accsClientConfig.getTag());
            ALog.i(stringBuilder.toString(), "build", "config", accsClientConfig.toString());
            return accsClientConfig;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: Taobao */
    public @interface ENV {
    }

    @Retention(RetentionPolicy.CLASS)
    /* compiled from: Taobao */
    public @interface SECURITY_TYPE {
    }

    static {
        r2 = new String[3];
        boolean z = true;
        r2[1] = "msgacs.wapa.taobao.com";
        r2[2] = "msgacs.waptest.taobao.com";
        DEFAULT_CENTER_HOSTS = r2;
        try {
            Bundle f = l.f(getContext());
            if (f != null) {
                String str = null;
                Object string = f.getString("accsConfigTags", null);
                ALog.i("AccsClientConfig", "init config from xml", "configtags", string);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("\\|");
                    if (split == null) {
                        split = new String[]{string};
                    }
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        int i2;
                        String[] strArr;
                        String str2 = split[i];
                        if (TextUtils.isEmpty(str2)) {
                            i2 = length;
                            strArr = split;
                        } else {
                            Object obj;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append("_accsAppkey");
                            int i3 = f.getInt(stringBuilder.toString(), -1);
                            if (i3 < 0) {
                                obj = str;
                            } else {
                                obj = String.valueOf(i3);
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(str2);
                            stringBuilder2.append("_accsAppSecret");
                            String string2 = f.getString(stringBuilder2.toString());
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str2);
                            stringBuilder3.append("_authCode");
                            String string3 = f.getString(stringBuilder3.toString());
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(str2);
                            stringBuilder4.append("_keepAlive");
                            boolean z2 = f.getBoolean(stringBuilder4.toString(), z);
                            StringBuilder stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(str2);
                            stringBuilder5.append("_autoUnit");
                            boolean z3 = f.getBoolean(stringBuilder5.toString(), z);
                            StringBuilder stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str2);
                            stringBuilder6.append("_inappPubkey");
                            int i4 = f.getInt(stringBuilder6.toString(), -1);
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str2);
                            stringBuilder6.append("_channelPubkey");
                            int i5 = f.getInt(stringBuilder6.toString(), -1);
                            StringBuilder stringBuilder7 = new StringBuilder();
                            stringBuilder7.append(str2);
                            stringBuilder7.append("_inappHost");
                            String string4 = f.getString(stringBuilder7.toString());
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str2);
                            stringBuilder6.append("_channelHost");
                            String string5 = f.getString(stringBuilder6.toString());
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str2);
                            i2 = length;
                            stringBuilder6.append("_configEnv");
                            length = f.getInt(stringBuilder6.toString(), 0);
                            stringBuilder6 = new StringBuilder();
                            stringBuilder6.append(str2);
                            strArr = split;
                            stringBuilder6.append("_disableChannel");
                            boolean z4 = f.getBoolean(stringBuilder6.toString());
                            if (!TextUtils.isEmpty(obj)) {
                                new Builder().setTag(str2).setAppKey(obj).setAppSecret(string2).setAutoCode(string3).setKeepAlive(z2).setAutoUnit(z3).setInappPubKey(i4).setChannelPubKey(i5).setInappHost(string4).setChannelHost(string5).setConfigEnv(length).setDisableChannel(z4).build();
                                ALog.i("AccsClientConfig", "init config from xml", new Object[0]);
                            }
                        }
                        i++;
                        length = i2;
                        split = strArr;
                        str = null;
                        z = true;
                    }
                    loadedStaticConfig = z;
                }
            }
        } catch (Throwable th) {
            ALog.e("AccsClientConfig", "init config from xml", th, new Object[0]);
        }
    }

    public static Context getContext() {
        if (mContext != null) {
            return mContext;
        }
        synchronized (AccsClientConfig.class) {
            if (mContext != null) {
                Context context = mContext;
                return context;
            }
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                mContext = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            context = mContext;
            return context;
        }
    }

    protected AccsClientConfig() {
    }

    @Deprecated
    public static AccsClientConfig getConfig(String str) {
        Map map;
        switch (mEnv) {
            case 1:
                map = mPreviewConfigs;
                break;
            case 2:
                map = mDebugConfigs;
                break;
            default:
                map = mReleaseConfigs;
                break;
        }
        for (AccsClientConfig accsClientConfig : r0.values()) {
            if (accsClientConfig.mAppKey.equals(str) && accsClientConfig.mConfigEnv == mEnv) {
                return accsClientConfig;
            }
        }
        ALog.e("AccsClientConfig", "getConfig null!", new Object[0]);
        return null;
    }

    public static AccsClientConfig getConfigByTag(String str) {
        Map map;
        switch (mEnv) {
            case 1:
                map = mPreviewConfigs;
                break;
            case 2:
                map = mDebugConfigs;
                break;
            default:
                map = mReleaseConfigs;
                break;
        }
        AccsClientConfig accsClientConfig = (AccsClientConfig) map.get(str);
        if (accsClientConfig == null) {
            ALog.e("AccsClientConfig", "getConfig null!", new Object[0]);
        }
        return accsClientConfig;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getInappHost() {
        return this.mInappHost;
    }

    public String getChannelHost() {
        return this.mChannelHost;
    }

    public int getSecurity() {
        return this.mSecurity;
    }

    public String getAuthCode() {
        return this.mAuthCode;
    }

    public int getInappPubKey() {
        return this.mInappPubKey;
    }

    public int getChannelPubKey() {
        return this.mChannelPubKey;
    }

    public boolean isKeepalive() {
        return this.mKeepalive;
    }

    public boolean isAutoUnit() {
        return this.mAutoUnit;
    }

    public String getTag() {
        return this.mTag;
    }

    public int getConfigEnv() {
        return this.mConfigEnv;
    }

    public boolean getDisableChannel() {
        return this.mDisableChannel;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AccsClientConfig{mAppKey=");
        stringBuilder.append(this.mAppKey);
        stringBuilder.append(", mAppSecret=");
        stringBuilder.append(this.mAppSecret);
        stringBuilder.append(", mInappHost=");
        stringBuilder.append(this.mInappHost);
        stringBuilder.append(", mChannelHost=");
        stringBuilder.append(this.mChannelHost);
        stringBuilder.append(", mSecurity=");
        stringBuilder.append(this.mSecurity);
        stringBuilder.append(", mAuthCode=");
        stringBuilder.append(this.mAuthCode);
        stringBuilder.append(", mInappPubKey=");
        stringBuilder.append(this.mInappPubKey);
        stringBuilder.append(", mChannelPubKey=");
        stringBuilder.append(this.mChannelPubKey);
        stringBuilder.append(", mKeepalive=");
        stringBuilder.append(this.mKeepalive);
        stringBuilder.append(", mAutoUnit=");
        stringBuilder.append(this.mAutoUnit);
        stringBuilder.append(", mConfigEnv=");
        stringBuilder.append(this.mConfigEnv);
        stringBuilder.append(", mTag=");
        stringBuilder.append(this.mTag);
        stringBuilder.append(", mDisableChannel=");
        stringBuilder.append(this.mDisableChannel);
        return stringBuilder.toString();
    }
}
