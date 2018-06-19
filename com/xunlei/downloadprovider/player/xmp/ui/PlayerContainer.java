package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.ViewGroup;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;

public interface PlayerContainer {

    public enum ContainerType {
        NORMAL,
        FULL_SCREEN
    }

    void a(ThunderXmpPlayer thunderXmpPlayer);

    void b(ThunderXmpPlayer thunderXmpPlayer);

    ViewGroup getContainerLayout();
}
