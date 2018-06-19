package com.xunlei.downloadprovider.player.xmp;

import android.os.Message;
import com.aplayer.aplayerandroid.APlayerAndroid.OnPlayStateChangeListener;
import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.android.shortvideo.ShortVideoInterface.PlayerEvent;

/* compiled from: XmpMediaPlayer */
final class ad implements OnPlayStateChangeListener {
    final /* synthetic */ XmpMediaPlayer a;

    ad(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onPlayStateChange(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("onPlayStateChange---currentState=");
        stringBuilder.append(i);
        stringBuilder.append("|preState=");
        stringBuilder.append(i2);
        this.a.a();
        if (!this.a.g) {
            PlayerEvent playerEvent;
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            obtain.arg2 = i2;
            this.a.h.sendMessageDelayed(obtain, 50);
            switch (i) {
                case 0:
                    playerEvent = PlayerEvent.PLAYER_IDLE;
                    break;
                case 1:
                    playerEvent = PlayerEvent.PLAYER_PREPARING;
                    break;
                case 3:
                    playerEvent = PlayerEvent.PLAYER_BUFFERING;
                    break;
                case 4:
                    playerEvent = PlayerEvent.PLAYER_READY;
                    break;
                default:
                    playerEvent = PlayerEvent.PLAYER_ENDED;
                    break;
            }
            ShortVideoInterface.a().a(playerEvent);
        }
    }
}
