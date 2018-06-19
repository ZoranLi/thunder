package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.security.c;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class Config {
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();
    private static final String TAG = "awcn.Config";
    private static Map<String, Config> configMap = new HashMap();
    private String appkey;
    private ENV env = ENV.ONLINE;
    private ISecurity iSecurity;
    private String tag;

    /* compiled from: Taobao */
    public static class Builder {
        private String appSecret;
        private String appkey;
        private String authCode;
        private ENV env = ENV.ONLINE;
        private String tag;

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.appkey = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.env = env;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.authCode = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Config build() {
            if (TextUtils.isEmpty(this.appkey)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            for (Config config : Config.configMap.values()) {
                if (config.env == this.env && config.appkey.equals(this.appkey)) {
                    ALog.w(Config.TAG, "duplicated config exist!", null, "appkey", this.appkey, "env", this.env);
                    if (!TextUtils.isEmpty(this.tag)) {
                        synchronized (Config.configMap) {
                            Config.configMap.put(this.tag, config);
                        }
                    }
                    return config;
                }
            }
            Config config2 = new Config();
            config2.appkey = this.appkey;
            config2.env = this.env;
            if (TextUtils.isEmpty(this.tag)) {
                config2.tag = StringUtils.concatString(this.appkey, "$", this.env.toString());
            } else {
                config2.tag = this.tag;
            }
            if (TextUtils.isEmpty(this.appSecret)) {
                config2.iSecurity = c.a().createSecurity(this.authCode);
            } else {
                config2.iSecurity = c.a().createNonSecurity(this.appSecret);
            }
            synchronized (Config.configMap) {
                Config.configMap.put(config2.tag, config2);
            }
            return config2;
        }
    }

    protected Config() {
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (configMap) {
            config = (Config) configMap.get(str);
        }
        return config;
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (configMap) {
            for (Config config : configMap.values()) {
                if (config.env == env && config.appkey.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getAppkey() {
        return this.appkey;
    }

    public final ENV getEnv() {
        return this.env;
    }

    public final ISecurity getSecurity() {
        return this.iSecurity;
    }

    public final String toString() {
        return this.tag;
    }
}
