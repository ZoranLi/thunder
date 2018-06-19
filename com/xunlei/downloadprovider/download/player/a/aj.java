package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vod.manager.PlayerConfigPersistManager;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow.VideoSize;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow.a;

/* compiled from: PlayerMenuController */
final class aj implements a {
    final /* synthetic */ af a;

    aj(af afVar) {
        this.a = afVar;
    }

    public final void a(VideoSize videoSize, boolean z) {
        af.a(this.a, videoSize);
        this.a.a = videoSize;
        if (this.a.a() != null) {
            this.a.a().videoSize = PlayerConfigPersistManager.a(videoSize);
        }
        if (z) {
            z = "size_100";
            if (videoSize == VideoSize.SIZE_75) {
                z = "size_75";
            } else if (videoSize == VideoSize.SIZE_50) {
                z = "size_50";
            }
            com.xunlei.downloadprovider.player.a.b(z);
        }
    }

    public final void a(String str, boolean z) {
        this.a.b = str;
        if (this.a.a() != null) {
            this.a.a().stretchMode = str;
        }
        if (this.a.f() != null) {
            this.a.f().a(202, str);
        }
        if (z) {
            z = "screen_normal";
            if ("2".equals(str)) {
                z = "screen_stretch";
            } else if ("1".equals(str) != null) {
                z = "screen_equal";
            }
            com.xunlei.downloadprovider.player.a.b(z);
        }
    }
}
