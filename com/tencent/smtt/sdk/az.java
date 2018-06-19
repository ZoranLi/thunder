package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class az extends FrameLayout implements OnErrorListener {
    private Object a;
    private bb b;
    private VideoView c;
    private Context d = null;
    private String e;

    public az(Context context) {
        super(context.getApplicationContext());
        this.d = context;
    }

    private void b(Bundle bundle, Object obj) {
        boolean a;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            a = this.b.a(this.a, bundle, this, obj);
        } else {
            a = false;
        }
        if (!a) {
            if (this.c != null) {
                this.c.stopPlayback();
            }
            if (this.c == null) {
                this.c = new VideoView(getContext());
            }
            this.e = bundle.getString("videoUrl");
            this.c.setVideoURI(Uri.parse(this.e));
            this.c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            applicationContext.startActivity(intent);
        }
    }

    void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            l.a(true).a(getContext().getApplicationContext(), false, false);
            ba a = l.a(true).a();
            DexLoader dexLoader = null;
            if (a != null) {
                dexLoader = a.b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new bb(dexLoader);
            }
        }
        if (this.b != null && this.a == null) {
            this.a = this.b.a(getContext().getApplicationContext());
        }
    }

    public void a(Activity activity) {
        if (!b() && this.c != null) {
            if (this.c.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(1024);
                window.addFlags(128);
                frameLayout.setBackgroundColor(-16777216);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.c);
                this.c.setMediaController(mediaController);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.c, layoutParams);
            }
            if (VERSION.SDK_INT >= 8) {
                this.c.start();
            }
        }
    }

    void a(Activity activity, int i) {
        if (!(i != 3 || b() || this.c == null)) {
            this.c.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!(b() || this.c == null)) {
                this.c.stopPlayback();
                this.c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.a, activity, i);
        }
    }

    void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    public boolean b() {
        return (this.b == null || this.a == null) ? false : true;
    }

    public void c() {
        if (b()) {
            this.b.a(this.a);
        }
    }

    public boolean onError(android.media.MediaPlayer r3, int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = r2.d;	 Catch:{ Throwable -> 0x0042 }
        r3 = r3 instanceof android.app.Activity;	 Catch:{ Throwable -> 0x0042 }
        if (r3 == 0) goto L_0x0013;	 Catch:{ Throwable -> 0x0042 }
    L_0x0006:
        r3 = r2.d;	 Catch:{ Throwable -> 0x0042 }
        r3 = (android.app.Activity) r3;	 Catch:{ Throwable -> 0x0042 }
        r4 = r3.isFinishing();	 Catch:{ Throwable -> 0x0042 }
        if (r4 != 0) goto L_0x0013;	 Catch:{ Throwable -> 0x0042 }
    L_0x0010:
        r3.finish();	 Catch:{ Throwable -> 0x0042 }
    L_0x0013:
        r3 = r2.getContext();	 Catch:{ Throwable -> 0x0042 }
        r4 = 1;	 Catch:{ Throwable -> 0x0042 }
        if (r3 == 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0042 }
    L_0x001a:
        r5 = "播放失败，请选择其它播放器播放";	 Catch:{ Throwable -> 0x0042 }
        r5 = android.widget.Toast.makeText(r3, r5, r4);	 Catch:{ Throwable -> 0x0042 }
        r5.show();	 Catch:{ Throwable -> 0x0042 }
        r3 = r3.getApplicationContext();	 Catch:{ Throwable -> 0x0042 }
        r5 = new android.content.Intent;	 Catch:{ Throwable -> 0x0042 }
        r0 = "android.intent.action.VIEW";	 Catch:{ Throwable -> 0x0042 }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0042 }
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Throwable -> 0x0042 }
        r5.addFlags(r0);	 Catch:{ Throwable -> 0x0042 }
        r0 = r2.e;	 Catch:{ Throwable -> 0x0042 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Throwable -> 0x0042 }
        r1 = "video/*";	 Catch:{ Throwable -> 0x0042 }
        r5.setDataAndType(r0, r1);	 Catch:{ Throwable -> 0x0042 }
        r3.startActivity(r5);	 Catch:{ Throwable -> 0x0042 }
    L_0x0041:
        return r4;
    L_0x0042:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.az.onError(android.media.MediaPlayer, int, int):boolean");
    }
}
