package com.xunlei.downloadprovider.personal.settings.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class ScaleTextView extends ViewGroup {
    public static final String a = "ScaleTextView";
    private Context b;
    private String[] c;

    public ScaleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new String[]{"10KB", "200KB", "400KB", "600KB", "800KB", "1024KB"};
        this.b = context;
        a();
    }

    public ScaleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        for (CharSequence charSequence : this.c) {
            View textView = new TextView(this.b);
            textView.setText(charSequence);
            textView.setTextColor(getResources().getColor(R.color.TextAppearanceEntryPrimaryTitle));
            textView.setTextSize(2, 10.0f);
            addView(textView);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        i = getWidth();
        for (boolean z2 = false; z2 < z; z2++) {
            i4 = getChildAt(z2);
            int measuredWidth = i4.getMeasuredWidth();
            int measuredHeight = i4.getMeasuredHeight();
            if (z2) {
                boolean z3 = z - 1;
                if (z2 == z3) {
                    i4.layout(i - measuredWidth, 0, measuredWidth + i, measuredHeight);
                } else {
                    int i5 = (i * z2) / z3;
                    measuredWidth /= 2;
                    i4.layout(i5 - measuredWidth, 0, i5 + measuredWidth, measuredHeight);
                }
            } else {
                i4.layout(0, 0, measuredWidth, measuredHeight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        i2 = getChildCount();
        for (int i3 = 0; i3 < i2; i3++) {
            getChildAt(i3).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(getChildAt(0).getMeasuredHeight(), 1073741824));
    }
}
