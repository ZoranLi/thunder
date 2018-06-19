package com.xunlei.downloadprovider.player.xmp.b;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.text.TextUtils;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.aplayer.aplayerandroid.APlayerAndroid.MediaInfo;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: MediaPlayerUtils */
public final class a {

    /* compiled from: MediaPlayerUtils */
    private static class a {
        private static APlayerAndroid a;

        private a() {
        }

        private static APlayerAndroid a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new APlayerAndroid();
                    }
                }
            }
            return a;
        }

        public static MediaInfo a(String str, long j) {
            a();
            return APlayerAndroid.parseThumbnail(str, j, 0, 0);
        }
    }

    /* compiled from: MediaPlayerUtils */
    public static class b {
        public int a;
        public int b;
        public long c;
        public long d;
        public boolean e;
        public int f;
        public Bitmap g;
    }

    public static boolean a() {
        return ((AudioManager) BrothersApplication.getApplicationInstance().getSystemService("audio")).requestAudioFocus(null, 3, 2) == 1;
    }

    public static String a(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        StringBuilder stringBuilder = new StringBuilder("0");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public static boolean b() {
        String phoneModel = AndroidConfig.getPhoneModel();
        return !TextUtils.isEmpty(phoneModel) && (phoneModel.contains("PAAM00") || phoneModel.contains("PAAT00") || phoneModel.contains("CPH1831") || phoneModel.contains("CPH1833") || phoneModel.contains("PACM00"));
    }
}
