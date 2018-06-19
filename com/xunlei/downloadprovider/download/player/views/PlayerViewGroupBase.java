package com.xunlei.downloadprovider.download.player.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.xunlei.downloadprovider.download.player.b;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView.d;
import java.lang.ref.WeakReference;

public class PlayerViewGroupBase extends RelativeLayout {
    private b a;
    private WeakReference<DownloadVodPlayerView> b;
    protected d f;
    protected boolean g = null;

    public PlayerViewGroupBase(Context context) {
        super(context);
    }

    public PlayerViewGroupBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerViewGroupBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerViewGroupBase(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @CallSuper
    public void setPlayerController(b bVar) {
        this.a = bVar;
    }

    protected b getPlayerController() {
        return this.a;
    }

    @CallSuper
    public void setViewEventListener(d dVar) {
        this.f = dVar;
    }

    protected d getViewEventListener() {
        return this.f;
    }

    @CallSuper
    public void a(boolean z) {
        this.g = z;
    }

    @CallSuper
    public void a(DownloadVodPlayerView downloadVodPlayerView) {
        this.b = new WeakReference(downloadVodPlayerView);
    }

    public DownloadVodPlayerView getPlayerRootView() {
        return this.b != null ? (DownloadVodPlayerView) this.b.get() : null;
    }
}
