package com.alibaba.sdk.android.feedback.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import java.io.IOException;

public class a {
    public static int a = -1;
    public static int b;
    private MediaPlayer c;
    private String d;
    private int e = a;

    public void a() {
        if (this.c != null) {
            this.c.stop();
            this.c.release();
            this.c = null;
            this.d = null;
        }
    }

    public void a(String str, OnCompletionListener onCompletionListener) {
        if (this.c == null) {
            this.c = new MediaPlayer();
        }
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(this.d)) {
                this.c.reset();
                try {
                    this.c.setDataSource(str);
                    if (this.e != a) {
                        this.c.setAudioStreamType(this.e);
                    }
                    this.c.setOnCompletionListener(onCompletionListener);
                    this.c.prepareAsync();
                    this.c.setOnPreparedListener(new b(this));
                } catch (IllegalArgumentException e) {
                    this.c = null;
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    this.c = null;
                    e2.printStackTrace();
                } catch (IOException e3) {
                    this.c = null;
                    e3.printStackTrace();
                }
                this.d = str;
            } else if (this.c != null) {
                this.c.start();
            }
        }
    }

    public boolean b() {
        return this.c != null && this.c.isPlaying();
    }
}
