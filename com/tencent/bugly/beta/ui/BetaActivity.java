package com.tencent.bugly.beta.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.b;

/* compiled from: BUGLY */
public class BetaActivity extends FragmentActivity {
    public Runnable onDestroyRunnable = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            if (Beta.dialogFullScreen) {
                getWindow().setFlags(1024, 1024);
            }
            View findViewById = getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(1, new Object[]{this, findViewById}));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int intExtra = getIntent().getIntExtra("frag", -1);
        Fragment fragment = (b) g.a.get(Integer.valueOf(intExtra));
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(16908290, fragment).commit();
            g.a.remove(Integer.valueOf(intExtra));
            return;
        }
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.onDestroyRunnable != null) {
            this.onDestroyRunnable.run();
        }
    }

    public boolean onKeyDown(int r4, android.view.KeyEvent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.getSupportFragmentManager();
        r1 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;
        r0 = r0.findFragmentById(r1);
        r1 = 0;
        r2 = r0 instanceof com.tencent.bugly.beta.ui.b;	 Catch:{ Exception -> 0x0017 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0017 }
    L_0x0010:
        r0 = (com.tencent.bugly.beta.ui.b) r0;	 Catch:{ Exception -> 0x0017 }
        r0 = r0.a(r4, r5);	 Catch:{ Exception -> 0x0017 }
        r1 = r0;
    L_0x0017:
        if (r1 != 0) goto L_0x001e;
    L_0x0019:
        r4 = super.onKeyDown(r4, r5);
        return r4;
    L_0x001e:
        r4 = 1;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.BetaActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }
}
