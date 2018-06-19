package com.huawei.hms.support.api.push;

public interface HmsPushConst {
    public static final String NEW_LINE = "\n\t";

    public interface ErrorCode {
        public static final int AGREE_PUSH_TERMS = 907122007;
        public static final int DISAGREE_PUSH_TERMS = 907122008;
        public static final int HAS_NOT_AGREE_PUSH_TERMS = 907122006;
        public static final int NETWORK_INVALID = 907122005;
        public static final int PLUGIN_TOKEN_INVALID = 907122004;
        public static final int REPORT_PARAM_INVALID = 907122003;
        public static final int REPORT_SYSTEM_ERROR = 907122002;
        public static final int REPORT_TAG_SUCCESS = 907122001;
    }
}
