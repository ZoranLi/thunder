package com.xunlei.downloadprovider.vod.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/* compiled from: SurfaceMediaPlayer */
public class a implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, Callback {
    private static final String f = "a";
    public MediaPlayer a;
    public boolean b = false;
    public boolean c = false;
    public OnVideoSizeChangedListener d;
    public OnErrorListener e;
    private String g;
    private SurfaceView h;
    private SurfaceHolder i;
    private int j;
    private int k;
    private boolean l = false;
    private boolean m = false;

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public a(SurfaceView surfaceView) {
        if (surfaceView != null) {
            if (this.i != null) {
                this.i.removeCallback(this);
            }
            this.h = surfaceView;
            this.i = surfaceView.getHolder();
            this.i.addCallback(this);
        }
    }

    private void e() {
        if (this.a != null && this.b && this.m && this.c) {
            this.a.setDisplay(this.i);
            this.a.start();
        }
    }

    public final void a() {
        this.c = true;
        e();
    }

    public final void b() {
        if (this.a != null) {
            this.a.release();
            this.a = null;
        }
    }

    public final void c() {
        if (this.a != null) {
            this.a.setLooping(true);
        }
    }

    public final boolean d() {
        return this.a != null ? this.a.isPlaying() : false;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.i) {
            if (this.a != null) {
                this.a.setDisplay(surfaceHolder);
                this.a.seekTo(this.a.getCurrentPosition());
            }
            this.m = true;
            e();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null && surfaceHolder == this.i) {
            this.m = null;
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer == this.a) {
            StringBuilder stringBuilder = new StringBuilder("onVideoSizeChanged , width : ");
            stringBuilder.append(i);
            stringBuilder.append(" height : ");
            stringBuilder.append(i2);
            this.l = true;
            this.j = i;
            this.k = i2;
            if (this.d != null) {
                this.d.onVideoSizeChanged(mediaPlayer, i, i2);
            }
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (mediaPlayer == this.a) {
            this.b = true;
            e();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer == this.a) {
            StringBuilder stringBuilder = new StringBuilder("onError, what : ");
            stringBuilder.append(i);
            stringBuilder.append(" extra : ");
            stringBuilder.append(i2);
            if (this.e != null) {
                return this.e.onError(mediaPlayer, i, i2);
            }
        }
        return true;
    }

    public final void a(String str) {
        if (this.a == null) {
            this.a = new MediaPlayer();
            this.a.setScreenOnWhilePlaying(true);
            this.a.setOnBufferingUpdateListener(this);
            this.a.setOnVideoSizeChangedListener(this);
            this.a.setOnCompletionListener(this);
            this.a.setOnPreparedListener(this);
            this.a.setOnSeekCompleteListener(this);
            this.a.setOnErrorListener(this);
        }
        this.g = str;
        this.j = 0;
        this.k = 0;
        this.b = false;
        this.l = false;
        this.a.reset();
        try {
            this.a.setDataSource(str);
            this.a.prepareAsync();
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
