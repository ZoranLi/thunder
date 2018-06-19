package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.R;
import android.support.design.widget.BaseTransientBottomBar.ContentViewCallback;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button mActionView;
    private int mMaxInlineActionWidth;
    private int mMaxWidth;
    private TextView mMessageView;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.mMaxWidth = context.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.mMaxInlineActionWidth = context.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        context.recycle();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mMessageView = (TextView) findViewById(R.id.snackbar_text);
        this.mActionView = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.mMessageView;
    }

    public Button getActionView() {
        return this.mActionView;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mMaxWidth > 0 && getMeasuredWidth() > this.mMaxWidth) {
            i = MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        int i3 = 1;
        int i4 = this.mMessageView.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i4 == 0 || this.mMaxInlineActionWidth <= 0 || this.mActionView.getMeasuredWidth() <= this.mMaxInlineActionWidth) {
            if (i4 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                if (i3 == 0) {
                    super.onMeasure(i, i2);
                }
            }
        } else if (updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            if (i3 == 0) {
                super.onMeasure(i, i2);
            }
        }
        i3 = 0;
        if (i3 == 0) {
            super.onMeasure(i, i2);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i3) {
        if (i != getOrientation()) {
            setOrientation(i);
            i = 1;
        } else {
            i = 0;
        }
        if (this.mMessageView.getPaddingTop() == i2 && this.mMessageView.getPaddingBottom() == i3) {
            return i;
        }
        updateTopBottomPadding(this.mMessageView, i2, i3);
        return 1;
    }

    private static void updateTopBottomPadding(View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    public void animateContentIn(int i, int i2) {
        this.mMessageView.setAlpha(0.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.mMessageView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.mActionView.getVisibility() == 0) {
            this.mActionView.setAlpha(0.0f);
            this.mActionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public void animateContentOut(int i, int i2) {
        this.mMessageView.setAlpha(1.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.mMessageView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.mActionView.getVisibility() == 0) {
            this.mActionView.setAlpha(1.0f);
            this.mActionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
