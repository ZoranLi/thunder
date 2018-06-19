package com.xunlei.downloadprovider.download.player.a;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings.System;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow.VideoSize;
import com.xunlei.downloadprovider.vod.player.h;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: PlayerMenuController */
public class af extends f {
    private static final String c = "af";
    public VideoSize a = null;
    public String b = null;
    private VodPlayerMenuPopupWindow d = new VodPlayerMenuPopupWindow(n());
    private float g = 0.0f;
    private float h = 0.0f;
    private AudioManager i;
    private e j = new ag(this);
    private OnClickListener k = new am(this);

    public af(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        if (n() != null) {
            this.h = (float) a(n());
        }
        if (o() != null) {
            this.i = (AudioManager) o().getSystemService("audio");
            o().setVolumeControlStream(3);
        }
        if (this.i != null) {
            downloadVodPlayerView = this.i.getStreamVolume(3);
            this.g = (float) ((int) ((((float) downloadVodPlayerView) / ((float) this.i.getStreamMaxVolume(3))) * 100.0f));
            StringBuilder stringBuilder = new StringBuilder("curAudio : ");
            stringBuilder.append(downloadVodPlayerView);
            stringBuilder.append(" mCurAudioProgress : ");
            stringBuilder.append(this.g);
        }
        downloadVodPlayerView = new ah(this);
        OnSeekBarChangeListener aiVar = new ai(this);
        VodPlayerMenuPopupWindow.a ajVar = new aj(this);
        OnKeyListener akVar = new ak(this);
        VodPlayerMenuPopupWindow vodPlayerMenuPopupWindow = this.d;
        vodPlayerMenuPopupWindow.o = ajVar;
        OnCheckedChangeListener hVar = new h(vodPlayerMenuPopupWindow);
        vodPlayerMenuPopupWindow.i.setOnCheckedChangeListener(hVar);
        vodPlayerMenuPopupWindow.e.setOnCheckedChangeListener(hVar);
        vodPlayerMenuPopupWindow.m.setOnSeekBarChangeListener(downloadVodPlayerView);
        vodPlayerMenuPopupWindow.n.setOnSeekBarChangeListener(aiVar);
        vodPlayerMenuPopupWindow.d.setOnKeyListener(akVar);
        this.d.setOnDismissListener(new al(this));
        if (aVar != null && aVar.f() != null) {
            aVar.f().a(this.j);
        }
    }

    public final void a(int i) {
        if (this.d != null && this.d.isShowing()) {
            this.d.a(i);
        }
    }

    private static int a(Context context) {
        try {
            return System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Context context2) {
            context2.getMessage();
            context2.printStackTrace();
            return 130;
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (z && f()) {
            f().k = this.k;
        }
        r();
        if (this.d && this.d.isShowing()) {
            this.d.dismiss();
        }
    }

    public final void d() {
        if (this.e != null && this.e.getHandler() != null) {
            this.e.getHandler().removeCallbacksAndMessages(null);
        }
    }

    private void r() {
        if (this.f) {
            if (a() != null) {
                this.b = a().stretchMode;
            } else {
                this.b = "0";
            }
            if (f() != null) {
                f().a(202, this.b);
                new StringBuilder("setStretchModeInFullScreen, mStretchMode : ").append(this.b);
            }
        } else if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.f) {
            this.a = a().getVideoSizeEnum();
            if (this.a == null) {
                this.a = VideoSize.SIZE_100;
            }
            this.e.postDelayed(new ao(this), 30);
        }
    }

    static /* synthetic */ void b(af afVar) {
        if (afVar.g < 0.0f) {
            afVar.g = 0.0f;
        }
        if (afVar.g > 100.0f) {
            afVar.g = 100.0f;
        }
        if (afVar.i != null) {
            afVar.i.setStreamVolume(3, (int) ((afVar.g / 100.0f) * ((float) afVar.i.getStreamMaxVolume(3))), 0);
        }
    }

    static /* synthetic */ void c(af afVar) {
        if (afVar.h < 1.0f) {
            afVar.h = 1.0f;
        }
        if (afVar.h > 255.0f) {
            afVar.h = 255.0f;
        }
        if (afVar.o() != null) {
            int i = (int) afVar.h;
            afVar = afVar.o();
            LayoutParams attributes = afVar.getWindow().getAttributes();
            attributes.screenBrightness = ((float) i) / 255.0f;
            afVar.getWindow().setAttributes(attributes);
        }
    }

    static /* synthetic */ void a(af afVar, VideoSize videoSize) {
        new StringBuilder("setSurfaceViewScale : ").append(videoSize.name());
        int[] realScreenSize = AndroidConfig.getRealScreenSize();
        int i = 0;
        int i2 = realScreenSize[0];
        int i3 = realScreenSize[1];
        if (afVar.n() != null && afVar.n().getResources().getConfiguration().orientation == 1) {
            i3 = realScreenSize[0];
            i2 = realScreenSize[1];
        }
        switch (ap.a[videoSize.ordinal()]) {
            case 1:
                break;
            case 2:
                i2 = (int) (((double) i2) * VideoSize.SIZE_75.getValue());
                i3 = (int) (((double) i3) * VideoSize.SIZE_75.getValue());
                break;
            case 3:
                i2 = (int) (((double) i2) * VideoSize.SIZE_50.getValue());
                i3 = (int) (((double) i3) * VideoSize.SIZE_50.getValue());
                break;
            default:
                break;
        }
        if (i2 > 0 && i3 > 0 && afVar.e != null && afVar.e.getSurfaceView() != null) {
            videoSize = new StringBuilder("setScreenSize, width : ");
            videoSize.append(i2);
            videoSize.append(" height : ");
            videoSize.append(i3);
            if (i2 > 0 && i3 > 0) {
                if (!(afVar.f() == null || afVar.f().a == null)) {
                    i = afVar.f().a.a(i2, i3);
                }
                if (i == 0) {
                    videoSize = afVar.e.getSurfaceView().getLayoutParams();
                    videoSize.width = i2;
                    videoSize.height = i3;
                    afVar.e.getSurfaceView().requestLayout();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.xunlei.downloadprovider.download.player.a.af r4, int r5, int r6) {
        /*
        r0 = r4.d;
        r0.a(r5);
        r5 = r4.d;
        r0 = r5.n;
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r0.setMax(r1);
        r5 = r5.n;
        r5.setProgress(r6);
        r5 = r4.a();
        r6 = 0;
        r0 = 1;
        if (r5 == 0) goto L_0x004e;
    L_0x001b:
        r5 = r4.a();
        r5 = r5.getVideoSizeEnum();
        r4.a = r5;
        r5 = r4.a;
        if (r5 == 0) goto L_0x004e;
    L_0x0029:
        r5 = r4.d;
        r1 = r4.a;
        r5.a = r6;
        r2 = com.xunlei.downloadprovider.vod.player.i.a;
        r1 = r1.ordinal();
        r1 = r2[r1];
        switch(r1) {
            case 1: goto L_0x0047;
            case 2: goto L_0x0041;
            case 3: goto L_0x003b;
            default: goto L_0x003a;
        };
    L_0x003a:
        goto L_0x004c;
    L_0x003b:
        r1 = r5.h;
        r1.setChecked(r0);
        goto L_0x004c;
    L_0x0041:
        r1 = r5.g;
        r1.setChecked(r0);
        goto L_0x004c;
    L_0x0047:
        r1 = r5.f;
        r1.setChecked(r0);
    L_0x004c:
        r5.a = r0;
    L_0x004e:
        r5 = r4.a();
        if (r5 == 0) goto L_0x00a9;
    L_0x0054:
        r5 = r4.a();
        r5 = r5.stretchMode;
        r4.b = r5;
        r5 = r4.b;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x00a9;
    L_0x0064:
        r5 = r4.d;
        r1 = r4.b;
        r5.b = r6;
        r2 = -1;
        r3 = r1.hashCode();
        switch(r3) {
            case 48: goto L_0x0087;
            case 49: goto L_0x007d;
            case 50: goto L_0x0073;
            default: goto L_0x0072;
        };
    L_0x0072:
        goto L_0x0091;
    L_0x0073:
        r3 = "2";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0091;
    L_0x007b:
        r1 = r0;
        goto L_0x0092;
    L_0x007d:
        r3 = "1";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0091;
    L_0x0085:
        r1 = 2;
        goto L_0x0092;
    L_0x0087:
        r3 = "0";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0091;
    L_0x008f:
        r1 = r6;
        goto L_0x0092;
    L_0x0091:
        r1 = r2;
    L_0x0092:
        switch(r1) {
            case 0: goto L_0x00a2;
            case 1: goto L_0x009c;
            case 2: goto L_0x0096;
            default: goto L_0x0095;
        };
    L_0x0095:
        goto L_0x00a7;
    L_0x0096:
        r1 = r5.l;
        r1.setChecked(r0);
        goto L_0x00a7;
    L_0x009c:
        r1 = r5.k;
        r1.setChecked(r0);
        goto L_0x00a7;
    L_0x00a2:
        r1 = r5.j;
        r1.setChecked(r0);
    L_0x00a7:
        r5.b = r0;
    L_0x00a9:
        r5 = r4.e;
        if (r5 == 0) goto L_0x00b5;
    L_0x00ad:
        r5 = r4.d;
        r4 = r4.e;
        r0 = 5;
        r5.showAtLocation(r4, r0, r6, r6);
    L_0x00b5:
        com.xunlei.downloadprovider.player.a.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.player.a.af.a(com.xunlei.downloadprovider.download.player.a.af, int, int):void");
    }
}
