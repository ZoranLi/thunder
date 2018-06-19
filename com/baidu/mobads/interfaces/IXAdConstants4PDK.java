package com.baidu.mobads.interfaces;

public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        
        private final String a;

        private ActivityState(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static ActivityState parse(String str) {
            for (ActivityState activityState : values()) {
                if (activityState.a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }
    }

    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        
        private final String a;

        private ScreenSizeMode(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static ScreenSizeMode parse(String str) {
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }
    }

    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR("error");
        
        private final String a;

        private SlotState(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static SlotState parse(String str) {
            for (SlotState slotState : values()) {
                if (slotState.a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }
    }

    public enum SlotType {
        SLOT_TYPE_JSSDK("jssdk"),
        SLOT_TYPE_CPU("cpu"),
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS("feed"),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll");
        
        private final String a;

        private SlotType(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static SlotType parse(String str) {
            for (SlotType slotType : values()) {
                if (slotType.a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }
    }

    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        
        private final String a;

        private VideoAssetPlayMode(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static VideoAssetPlayMode parse(String str) {
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }
    }

    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        
        private final String a;

        private VideoState(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static VideoState parse(String str) {
            for (VideoState videoState : values()) {
                if (videoState.a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }
    }

    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        
        private final String a;

        private VisitorAction(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static VisitorAction parse(String str) {
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }
    }
}
