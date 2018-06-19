package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovidershare.q;
import com.xunlei.xllib.android.d;
import com.xunlei.xllib.b.k;

/* compiled from: ClipTipViewController */
public class f implements a$a, d$a {
    private static final String b = "f";
    private static f h = new f();
    boolean a = true;
    private String c;
    private a d;
    private d e;
    private Handler f;
    private String g = "";

    public static f b() {
        return h;
    }

    private f() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized void a(java.lang.String r3, boolean r4, int r5, java.lang.String r6) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x007c;
    L_0x0007:
        r0 = r2.g;	 Catch:{ all -> 0x007e }
        r0 = r3.equals(r0);	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x007c;
    L_0x0010:
        r2.g = r3;	 Catch:{ all -> 0x007e }
        r0 = "android_launch";
        r1 = "outapp_copy";
        r0 = com.xunlei.common.report.HubbleEventBuilder.build(r0, r1);	 Catch:{ all -> 0x007e }
        r1 = "content";
        r0.addString(r1, r3);	 Catch:{ all -> 0x007e }
        r1 = "by";
        r0.addString(r1, r6);	 Catch:{ all -> 0x007e }
        com.xunlei.common.report.ThunderReport.reportEvent(r0);	 Catch:{ all -> 0x007e }
        r0 = d();	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x002f;
    L_0x002d:
        monitor-exit(r2);
        return;
    L_0x002f:
        r0 = com.xunlei.downloadprovider.h.l.e();	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x003b;
    L_0x0035:
        r0 = com.xunlei.downloadprovider.h.l.d();	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x004d;
    L_0x003b:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x007e }
        r1 = 23;
        if (r0 < r1) goto L_0x004d;
    L_0x0041:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ all -> 0x007e }
        r0 = android.provider.Settings.canDrawOverlays(r0);	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x004d;
    L_0x004b:
        monitor-exit(r2);
        return;
    L_0x004d:
        r0 = 3;
        if (r5 != r0) goto L_0x0052;
    L_0x0050:
        monitor-exit(r2);
        return;
    L_0x0052:
        r0 = 1;
        if (r5 == r0) goto L_0x0058;
    L_0x0055:
        r0 = 4;
        if (r5 != r0) goto L_0x0066;
    L_0x0058:
        r0 = com.xunlei.downloadprovider.d.d.a();	 Catch:{ all -> 0x007e }
        r0 = r0.d;	 Catch:{ all -> 0x007e }
        r0 = r0.e();	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        monitor-exit(r2);
        return;
    L_0x0066:
        r0 = 2;
        if (r5 != r0) goto L_0x0077;
    L_0x0069:
        r0 = com.xunlei.downloadprovider.d.d.a();	 Catch:{ all -> 0x007e }
        r0 = r0.d;	 Catch:{ all -> 0x007e }
        r0 = r0.p();	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x0077;
    L_0x0075:
        monitor-exit(r2);
        return;
    L_0x0077:
        r2.b(r3, r4, r5, r6);	 Catch:{ all -> 0x007e }
        monitor-exit(r2);
        return;
    L_0x007c:
        monitor-exit(r2);
        return;
    L_0x007e:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.assistant.clipboardmonitor.f.a(java.lang.String, boolean, int, java.lang.String):void");
    }

    final void b(String str, boolean z, int i, String str2) {
        try {
            if (this.f == null) {
                this.f = new Handler(Looper.getMainLooper());
            }
            if (i == 4) {
                q.a(str, new h(this, str, z, str2));
            } else {
                this.f.post(new g(this, i, str, z, str2));
            }
        } catch (String str3) {
            str3.printStackTrace();
            CrashReport.postCatchedException(str3);
        }
    }

    public final void a(int i, String str) {
        if (this.a) {
            if (i == -1) {
                c.a(this.c, 1, str);
            } else {
                c.a(this.c, 0, str);
            }
        }
        this.d = 0;
    }

    public final void a() {
        this.e = null;
    }

    private static boolean d() {
        if (OSUtil.isAppRunning(BrothersApplication.getApplicationInstance(), BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER) && !AppStatusChgObserver.b().a()) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void a(f fVar, String str, boolean z, String str2, String str3) {
        if (str != null) {
            fVar.c = str;
            if (fVar.a) {
                String str4 = fVar.c;
                StatEvent build = HubbleEventBuilder.build("android_launch", "outapp_paste_alert");
                build.addString("url", str4);
                build.addString("by", str2);
                ThunderReport.reportEvent(build);
            }
            if (fVar.d != null) {
                fVar = fVar.d;
                fVar.l = z;
                fVar.f = str;
                fVar.g.setText(fVar.f);
                fVar.m = str2;
                fVar.n = str3;
            } else {
                fVar.d = new a(BrothersApplication.getApplicationInstance(), str, z, str2, str3);
                fVar.d.e = fVar;
                fVar = fVar.d;
                try {
                    ClipUrlTipView clipUrlTipView = (ClipUrlTipView) View.inflate(fVar.b, R.layout.layout_clip_url_tip_view, null);
                    fVar.g = (TextView) clipUrlTipView.findViewById(R.id.clip_url_tip_view_text);
                    fVar.g.setText(fVar.f);
                    fVar.j = clipUrlTipView.findViewById(R.id.clip_url_tip_view_button);
                    fVar.k = clipUrlTipView.findViewById(R.id.clip_url_tip_view_close);
                    fVar.c = clipUrlTipView;
                    fVar.d = clipUrlTipView.findViewById(R.id.clip_url_tip_view_content);
                    fVar.j.setOnClickListener(fVar.i);
                    fVar.k.setOnClickListener(fVar.h);
                    fVar.c.setOnTouchListener(fVar);
                    fVar.c.setKeyEventHandler(fVar);
                    z = (VERSION.SDK_INT < true || VERSION.SDK_INT > true) ? true : true;
                    LayoutParams layoutParams = new LayoutParams(-1, -1, z, 0, -3);
                    layoutParams.gravity = 17;
                    fVar.a.addView(fVar.c, layoutParams);
                } catch (f fVar2) {
                    fVar2.printStackTrace();
                }
            }
            if (!(l.e() == null && l.d() == null) && VERSION.SDK_INT >= 19 && VERSION.SDK_INT < true) {
                if (TextUtils.isEmpty(str3) == null) {
                    str = str3;
                }
                m.a().a(str);
            }
        }
    }

    static /* synthetic */ void a(f fVar, String str, String str2) {
        if (str.contains(" ")) {
            str = a.f(str);
        }
        if (fVar.a) {
            StatEvent build = HubbleEventBuilder.build("android_url_action", "thirdapp_urlcopy_show");
            build.add("content", k.a(str, "UTF-8"));
            build.add("by", str2);
            ThunderReport.reportEvent(build);
        }
        if (fVar.e != null) {
            fVar = fVar.e;
            fVar.f = str;
            fVar.g.setText(fVar.f);
            fVar.h.removeCallbacks(fVar.i);
            fVar.h.postDelayed(fVar.i, 5000);
            return;
        }
        fVar.e = new d(BrothersApplication.getApplicationInstance(), str);
        fVar.e.e = fVar;
        fVar = fVar.e;
        try {
            ClipUrlTipView clipUrlTipView = (ClipUrlTipView) View.inflate(fVar.b, R.layout.layout_clip_open_tip_view, null);
            fVar.g = (TextView) clipUrlTipView.findViewById(R.id.clip_open_tip_view_url);
            fVar.g.setText(fVar.f);
            fVar.c = clipUrlTipView;
            fVar.d = clipUrlTipView.findViewById(R.id.clip_open_tip_view_content);
            fVar.c.setOnTouchListener(fVar);
            fVar.c.setKeyEventHandler(fVar);
            int a = d.a(fVar.b) - DipPixelUtil.dip2px(28.0f);
            int dip2px = DipPixelUtil.dip2px(80.0f);
            str = (VERSION.SDK_INT < 19 || VERSION.SDK_INT > 24) ? PushResult.UNFINISH_DOWNLOAD_NOTICE : 2005;
            String layoutParams = new LayoutParams(a, dip2px, str, 0, -2);
            layoutParams.alpha = 1.0f;
            layoutParams.gravity = 49;
            layoutParams.y = DipPixelUtil.dip2px(85.0f);
            layoutParams.windowAnimations = R.style.PopupTopAnim;
            layoutParams.flags = 40;
            fVar.a.addView(fVar.c, layoutParams);
        } catch (String str3) {
            str3.printStackTrace();
        }
        fVar.h.removeCallbacks(fVar.i);
        fVar.h.postDelayed(fVar.i, 5000);
    }
}
