package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.FlexboxLayout.LayoutParams;

public class FlexQuickCommentView extends FlexboxLayout implements OnClickListener {
    int[] a;
    private p[] b;
    private TextView[] c;
    private int d;
    private int e;
    private int f;
    private ColorStateList g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private a m;
    private int n;
    private boolean o = true;
    private boolean p = true;
    private LayoutParams q;
    private Drawable r;
    private int s;
    private int t;

    public interface a {
        void a(View view, p pVar);
    }

    public FlexQuickCommentView(Context context) {
        super(context);
        a(context, null);
    }

    public FlexQuickCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FlexQuickCommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int i = 0;
        if (attributeSet != null) {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.QuickCommentView);
            this.g = attributeSet.getColorStateList(1);
            this.n = attributeSet.getResourceId(0, R.drawable.bg_quick_comment_item);
            this.o = attributeSet.getBoolean(2, false);
            this.p = attributeSet.getBoolean(3, true);
        } else {
            this.g = ColorStateList.valueOf(Color.parseColor("#aaaaaa"));
            this.n = R.drawable.bg_quick_comment_item;
            this.o = false;
            this.p = true;
        }
        this.r = context.getResources().getDrawable(R.drawable.flex_divider);
        setFlexDirection(0);
        setFlexWrap(1);
        setJustifyContent(this.o != null ? 2 : null);
        setShowDividerVertical(this.o != null ? 2 : 3);
        setShowDividerHorizontal(7);
        setDividerDrawable(this.r);
        this.b = new p[4];
        this.c = new TextView[4];
        this.a = new int[4];
        this.d = DipPixelUtil.dip2px(10.0f);
        this.e = DipPixelUtil.dip2px(6.0f);
        this.i = DipPixelUtil.dip2px(13.0f);
        this.k = DipPixelUtil.dip2px(13.0f);
        this.j = DipPixelUtil.dip2px(10.0f);
        this.f = 13;
        this.h = context.getResources().getDisplayMetrics().widthPixels;
        this.q = new LayoutParams();
        this.s = MeasureSpec.makeMeasureSpec(32767, Integer.MIN_VALUE);
        this.t = MeasureSpec.makeMeasureSpec(32767, Integer.MIN_VALUE);
        this.b[0] = new p("m1", "厉害了word哥");
        this.b[1] = new p("m2", "听说评论了就有女朋友");
        this.b[2] = new p("m3", "滴，老湿基打卡");
        this.b[3] = new p("m4", "一点也不好看，我只看了十几遍");
        while (i < 4) {
            context = new TextView(getContext());
            context.setBackgroundResource(this.n);
            context.setSingleLine(true);
            context.setTextSize((float) this.f);
            context.setTextColor(this.g);
            context.setPadding(this.d, this.e, this.d, this.e);
            context.setLayoutParams(this.q);
            context.setOnClickListener(this);
            context.setEnabled(this.p);
            this.c[i] = context;
            i++;
        }
        b();
        a();
    }

    public void setContentsArray(p... pVarArr) {
        if (pVarArr != null) {
            if (pVarArr.length == 4) {
                for (int i = 0; i < 4; i++) {
                    this.b[i] = pVarArr[i];
                }
                b();
                a();
            }
        }
    }

    private void a() {
        removeAllViews();
        for (int i = 0; i < 4; i++) {
            View view = this.c[i];
            view.setTag(Integer.valueOf(i));
            addView(view);
        }
        postInvalidate();
    }

    private void b() {
        int i;
        int i2;
        for (i = 0; i < 4; i++) {
            CharSequence charSequence = this.b[i].b;
            this.c[i].setLayoutParams(this.q);
            this.c[i].setText(charSequence);
            this.c[i].measure(this.s, this.t);
            this.a[i] = this.c[i].getMeasuredWidth();
        }
        i = this.a.length;
        for (i2 = 1; i2 < i; i2++) {
            int i3 = this.a[i2];
            p pVar = this.b[i2];
            TextView textView = this.c[i2];
            int i4 = i2 - 1;
            while (i4 >= 0 && i3 < this.a[i4]) {
                int i5 = i4 + 1;
                this.a[i5] = this.a[i4];
                this.b[i5] = this.b[i4];
                this.c[i5] = this.c[i4];
                i4--;
            }
            i4++;
            this.a[i4] = i3;
            this.b[i4] = pVar;
            this.c[i4] = textView;
        }
        i2 = this.o ? 0 : this.i;
        for (i = 0; i < 4; i++) {
            i2 += this.k + this.a[i];
        }
        if (i2 - this.k <= this.h) {
            this.l = 4;
            return;
        }
        i = this.o ? 0 : this.i;
        int i6 = ((this.k + i) + this.a[0]) + this.a[1];
        i2 = ((this.k + i) + this.a[0]) + this.a[2];
        i3 = ((this.k + i) + this.a[0]) + this.a[3];
        int i7 = ((this.k + i) + this.a[1]) + this.a[2];
        int i8 = ((this.k + i) + this.a[1]) + this.a[3];
        i5 = ((this.k + i) + this.a[2]) + this.a[3];
        int i9 = (this.k + i6) + this.a[2];
        i += this.a[3];
        i6 -= i5;
        i5 = i2 - i8;
        int i10 = i3 - i7;
        int i11 = i9 - i;
        i6 = Math.abs(i6);
        if (Math.abs(i5) < i6) {
            i6 = Math.abs(i5);
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (Math.abs(i10) < i6) {
            i6 = Math.abs(i10);
            i5 = 2;
        }
        if (Math.abs(i11) < i6) {
            i5 = 3;
        }
        if (i5 == 0) {
            this.l = 2;
            return;
        }
        if (i5 == 1) {
            this.l = 2;
            if (i2 <= this.h && i8 <= this.h) {
                if (i2 <= i8) {
                    a(1, 2);
                } else {
                    a(0, 3);
                }
            }
        } else if (i5 == 2) {
            this.l = 2;
            if (i3 <= this.h && i7 <= this.h) {
                if (i3 <= i7) {
                    a(2, 3);
                    a(1, 2);
                    return;
                }
                a(0, 1);
                a(1, 2);
            }
        } else {
            this.l = 3;
            if (i9 <= this.h && i <= this.h && i9 > i) {
                a(2, 3);
                a(1, 2);
                a(0, 1);
                this.l = 1;
                ViewGroup.LayoutParams layoutParams = new LayoutParams(this.q);
                layoutParams.j = true;
                this.c[1].setLayoutParams(layoutParams);
            }
        }
    }

    private void a(int i, int i2) {
        p pVar = this.b[i];
        this.b[i] = this.b[i2];
        this.b[i2] = pVar;
        int i3 = this.a[i];
        this.a[i] = this.a[i2];
        this.a[i2] = i3;
        TextView textView = this.c[i];
        this.c[i] = this.c[i2];
        this.c[i2] = textView;
    }

    public void onClick(View view) {
        if (this.m != null) {
            this.m.a(view, this.b[((Integer) view.getTag()).intValue()]);
        }
    }

    public a getOnItemListener() {
        return this.m;
    }

    public void setOnItemListener(a aVar) {
        this.m = aVar;
    }

    public void setClickEnable(boolean z) {
        if (this.p != z) {
            setChildrenEnabled(z);
        }
        this.p = z;
    }

    private void setChildrenEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }
}
