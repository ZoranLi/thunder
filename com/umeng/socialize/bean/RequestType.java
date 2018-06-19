package com.umeng.socialize.bean;

public enum RequestType {
    SOCIAL {
        public final String toString() {
            return "0";
        }
    },
    ANALYTICS {
        public final String toString() {
            return "1";
        }
    },
    API {
        public final String toString() {
            return "2";
        }
    };
}
