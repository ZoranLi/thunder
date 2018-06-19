package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
public class c implements OnTouchListener {
    final int a;
    final Object[] b;

    public c(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (this.a != 1) {
                return false;
            }
            motionEvent = motionEvent.getAction();
            if (motionEvent == null || motionEvent == 2) {
                view.setBackgroundDrawable((Drawable) this.b[0]);
            } else {
                view.setBackgroundDrawable((Drawable) this.b[1]);
            }
            return false;
        } catch (View view2) {
            if (an.b(view2) == null) {
                view2.printStackTrace();
            }
        }
    }
}
