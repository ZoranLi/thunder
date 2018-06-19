package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class CustomDurationLongClickImageView extends AppCompatImageView {
    private a a;
    private boolean b;
    private long c = 2000;
    private OnLongClickListener d = null;

    private final class a implements Runnable {
        final /* synthetic */ CustomDurationLongClickImageView a;

        private a(CustomDurationLongClickImageView customDurationLongClickImageView) {
            this.a = customDurationLongClickImageView;
        }

        public final void run() {
            if (CustomDurationLongClickImageView.b(this.a)) {
                this.a.b = true;
            }
        }
    }

    public CustomDurationLongClickImageView(Context context) {
        super(context);
        setLongClickable(null);
    }

    public CustomDurationLongClickImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLongClickable(null);
    }

    public CustomDurationLongClickImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLongClickable(null);
    }

    public void setLongClickable(boolean z) {
        super.setLongClickable(false);
    }

    public void setOnClickListener(@Nullable OnClickListener onClickListener) {
        super.setOnClickListener(new a(this, onClickListener));
    }

    public void setOnLongClickListener(@Nullable OnLongClickListener onLongClickListener) {
        this.d = onLongClickListener;
    }

    public void setLongClickDurationMillis(long j) {
        this.c = j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    this.b = false;
                    if (this.a == null) {
                        this.a = new a();
                    }
                    postDelayed(this.a, this.c);
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        return super.onTouchEvent(motionEvent);
    }

    static /* synthetic */ boolean b(CustomDurationLongClickImageView customDurationLongClickImageView) {
        if (customDurationLongClickImageView.b) {
            return null;
        }
        if (customDurationLongClickImageView.d != null) {
            customDurationLongClickImageView.d.onLongClick(customDurationLongClickImageView);
        }
        return true;
    }
}
