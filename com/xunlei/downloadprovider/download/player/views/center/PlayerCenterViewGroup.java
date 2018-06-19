package com.xunlei.downloadprovider.download.player.views.center;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.player.b;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;
import com.xunlei.downloadprovider.download.player.views.backgroundlayer.PlayerGestureView;
import com.xunlei.downloadprovider.download.player.views.backgroundlayer.PlayerGestureView.a;

public class PlayerCenterViewGroup extends PlayerViewGroupBase {
    private static final String j = "PlayerCenterViewGroup";
    public PlayerGestureCenterPopView a;
    public e b;
    public d c;
    public View d = null;
    public View e;
    public ViewGroup h = null;
    public boolean i = null;
    private PlayerGestureView k;

    public PlayerCenterViewGroup(Context context) {
        super(context);
    }

    public PlayerCenterViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerCenterViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public PlayerCenterViewGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = new d(findViewById(R.id.player_loading_indicator_view));
        this.b = new e((ViewStub) findViewById(R.id.player_error_view_stub));
        this.b.b = new a(this);
        this.e = findViewById(R.id.player_center_play);
        if (this.e != null) {
            this.e.setOnClickListener(new b(this));
        }
        this.h = (ViewGroup) findViewById(R.id.view_center_share_layout);
        this.a = (PlayerGestureCenterPopView) findViewById(R.id.player_center_gesture_pop_view);
        this.k = (PlayerGestureView) findViewById(R.id.player_gesture_view);
        this.k.setPlayerGestureCenterPopView(this.a);
    }

    public final void a(DownloadVodPlayerView downloadVodPlayerView) {
        super.a(downloadVodPlayerView);
        this.d = downloadVodPlayerView.findViewById(R.id.centerShareMaskView);
    }

    public void setErrorText(String str) {
        e eVar = this.b;
        if (eVar.a != null) {
            eVar.a.setText(str);
        }
    }

    public void setLoadingText(CharSequence charSequence) {
        this.c.b.setText(charSequence);
    }

    public final void a() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        this.e.setVisibility(8);
        this.h.setVisibility(8);
    }

    public void setIsShowCenterShare(boolean z) {
        this.i = z;
    }

    public void setShouldDetectorGesture(boolean z) {
        if (this.k != null) {
            this.k.setShouldDetectorGesture(z);
        }
    }

    public void setShouldDetectorGestureMove(boolean z) {
        if (this.k != null) {
            this.k.setShouldDetectorGestureMove(z);
        }
    }

    public void setPlayerController(b bVar) {
        super.setPlayerController(bVar);
        this.k.setPlayController(bVar);
    }

    public void setGestureViewVisible(boolean z) {
        int i = 8;
        this.k.setVisibility(z ? 0 : 8);
        PlayerGestureCenterPopView playerGestureCenterPopView = this.a;
        if (z) {
            i = 0;
        }
        playerGestureCenterPopView.setVisibility(i);
    }

    public void setOnGestureListener(a aVar) {
        this.k.setOnGestureListener(aVar);
    }
}
