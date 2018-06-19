package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: ClipOpenTipViewController */
final class d implements OnKeyListener, OnTouchListener {
    WindowManager a;
    Context b;
    ClipUrlTipView c;
    View d;
    a e;
    String f;
    TextView g;
    Handler h = new Handler();
    Runnable i = new e(this);
    private final long j = 5000;

    public d(Context context, String str) {
        this.b = context;
        this.f = str;
        this.a = (WindowManager) context.getSystemService("window");
    }

    private void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.c;
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0005:
        r0 = r3.c;
        r0.setOnTouchListener(r1);
        r0 = r3.c;
        r0.setKeyEventHandler(r1);
    L_0x000f:
        r0 = r3.a;
        if (r0 == 0) goto L_0x0020;
    L_0x0013:
        r0 = r3.c;
        if (r0 == 0) goto L_0x0020;
    L_0x0017:
        r0 = r3.a;	 Catch:{ IllegalArgumentException -> 0x001e }
        r2 = r3.c;	 Catch:{ IllegalArgumentException -> 0x001e }
        r0.removeView(r2);	 Catch:{ IllegalArgumentException -> 0x001e }
    L_0x001e:
        r3.c = r1;
    L_0x0020:
        r0 = r3.e;
        if (r0 == 0) goto L_0x0029;
    L_0x0024:
        r0 = r3.e;
        r0.a();
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.assistant.clipboardmonitor.d.a():void");
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.d.getGlobalVisibleRect(rect);
        if (rect.contains(view, motionEvent) != null) {
            this.h.removeCallbacks(this.i);
            a();
            view = this.b;
            String str = this.f;
            if (OSUtil.isAppRunning(BrothersApplication.getApplicationInstance(), BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER)) {
                a.a();
                a.a(view, str, false, BrowserFrom.THIRDAPP_URL_INPUT);
            } else {
                Intent intent = new Intent(view, LaunchActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("dispatch_from_key", 1117);
                intent.putExtra("url", str);
                intent.putExtra("type", 2);
                view.startActivity(intent);
            }
        }
        return false;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            this.h.removeCallbacks(this.i);
            a();
        }
        return null;
    }
}
