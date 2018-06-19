package com.xunlei.downloadprovider.vod.manager;

import android.content.Context;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow.VideoSize;
import java.io.File;
import java.io.Serializable;

public final class PlayerConfigPersistManager {

    public static class ConfigPersistData implements Serializable {
        private static final long serialVersionUID = 2;
        public int audioTrackIndex = -1;
        public String stretchMode = "0";
        public int videoSize = PlayerConfigPersistManager.a(VideoSize.SIZE_100);

        public ConfigPersistData(VideoSize videoSize, String str) {
            this.videoSize = PlayerConfigPersistManager.a(videoSize);
            this.stretchMode = str;
        }

        public VideoSize getVideoSizeEnum() {
            int i = this.videoSize;
            if (i == 50) {
                return VideoSize.SIZE_50;
            }
            if (i == 75) {
                return VideoSize.SIZE_75;
            }
            if (i != 100) {
                return VideoSize.SIZE_100;
            }
            return VideoSize.SIZE_100;
        }
    }

    public static int a(VideoSize videoSize) {
        switch (i.a[videoSize.ordinal()]) {
            case 1:
                return 100;
            case 2:
                return 75;
            case 3:
                return 50;
            default:
                return 100;
        }
    }

    public static String a(Context context) {
        File file = new File(context.getExternalCacheDir(), "ThunderPlayerConfig");
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
