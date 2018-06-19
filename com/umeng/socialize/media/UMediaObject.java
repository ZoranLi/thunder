package com.umeng.socialize.media;

import java.util.Map;

public interface UMediaObject {

    public enum MediaType {
        IMAGE {
            public final String toString() {
                return "0";
            }
        },
        VEDIO {
            public final String toString() {
                return "1";
            }
        },
        MUSIC {
            public final String toString() {
                return "2";
            }
        },
        TEXT {
            public final String toString() {
                return "3";
            }
        },
        TEXT_IMAGE {
            public final String toString() {
                return "4";
            }
        },
        WEBPAGE {
            public final String toString() {
                return "5";
            }
        };
    }

    MediaType getMediaType();

    boolean isUrlMedia();

    byte[] toByte();

    String toUrl();

    Map<String, Object> toUrlExtraParams();
}
