package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.b;
import com.xunlei.downloadprovider.download.report.c;
import com.xunlei.downloadprovider.launch.LaunchActivity;

/* compiled from: ClipDownloadTipViewController */
final class a implements OnKeyListener, OnTouchListener {
    WindowManager a;
    Context b;
    ClipUrlTipView c;
    View d;
    a e;
    String f;
    TextView g;
    OnClickListener h = new b(this);
    OnClickListener i = new c(this);
    View j;
    View k;
    boolean l;
    String m;
    String n;

    public a(Context context, String str, boolean z, String str2, String str3) {
        this.b = context;
        this.f = str;
        this.l = z;
        this.a = (WindowManager) context.getSystemService("window");
        this.m = str2;
        this.n = str3;
    }

    private void a(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.a;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r2.c;
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r2.a;	 Catch:{ IllegalArgumentException -> 0x000f }
        r1 = r2.c;	 Catch:{ IllegalArgumentException -> 0x000f }
        r0.removeView(r1);	 Catch:{ IllegalArgumentException -> 0x000f }
    L_0x000f:
        r0 = r2.e;
        if (r0 == 0) goto L_0x001a;
    L_0x0013:
        r0 = r2.e;
        r1 = r2.m;
        r0.a(r3, r1);
    L_0x001a:
        r3 = r2.d;
        r0 = 0;
        r3.setOnClickListener(r0);
        r3 = r2.c;
        r3.setOnTouchListener(r0);
        r3 = r2.c;
        r3.setKeyEventHandler(r0);
        r3 = r2.j;
        r3.setOnClickListener(r0);
        r3 = r2.k;
        r3.setOnClickListener(r0);
        r3 = r2.n;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x003f;
    L_0x003c:
        r3 = r2.f;
        goto L_0x0041;
    L_0x003f:
        r3 = r2.n;
    L_0x0041:
        r0 = com.xunlei.downloadprovider.download.create.m.a();
        r0.a(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.assistant.clipboardmonitor.a.a(int):void");
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.d.getGlobalVisibleRect(rect);
        if (rect.contains(view, motionEvent) == null) {
            a(-2);
        }
        return null;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            a(-2);
        }
        return null;
    }

    static /* synthetic */ void b(a aVar) {
        String str;
        aVar.a(-1);
        Context context = aVar.b;
        String str2 = aVar.f;
        boolean z = aVar.l;
        if (TextUtils.isEmpty(aVar.n)) {
            str = "out_app/out_app_paste";
        } else {
            StringBuilder stringBuilder = new StringBuilder("out_app/out_app_paste");
            stringBuilder.append(c.d);
            str = stringBuilder.toString();
        }
        if (OSUtil.isAppRunning(BrothersApplication.getApplicationInstance(), BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER)) {
            b.a(context, str2, str, "out_app", z);
            return;
        }
        Intent intent = new Intent(aVar.b, LaunchActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("dispatch_from_key", 1117);
        intent.putExtra("url", str2);
        intent.putExtra("isAutoComplemented", z);
        intent.putExtra("type", 1);
        intent.putExtra("origins", str);
        aVar.b.startActivity(intent);
    }
}
