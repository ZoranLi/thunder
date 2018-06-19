package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import java.util.Arrays;

public class QuickCommentView extends ViewGroup implements OnClickListener {
    int[] a;
    private p[] b;
    private TextPaint c;
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
    private int p;
    private int q;
    private boolean r = true;

    public interface a {
        void a(View view, p pVar);
    }

    public QuickCommentView(Context context) {
        super(context);
        a(context, null);
    }

    public QuickCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public QuickCommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.QuickCommentView);
            this.g = attributeSet.getColorStateList(1);
            this.n = attributeSet.getResourceId(0, R.drawable.bg_quick_comment_item);
            this.o = attributeSet.getBoolean(2, false);
            this.r = attributeSet.getBoolean(3, true);
        } else {
            this.g = ColorStateList.valueOf(Color.parseColor("#aaaaaa"));
            this.n = R.drawable.bg_quick_comment_item;
            this.o = false;
            this.r = true;
        }
        this.b = new p[4];
        this.a = new int[4];
        this.c = new TextPaint();
        this.d = DipPixelUtil.dip2px(10.0f);
        this.e = DipPixelUtil.dip2px(6.0f);
        this.i = DipPixelUtil.dip2px(13.0f);
        this.k = DipPixelUtil.dip2px(13.0f);
        this.j = DipPixelUtil.dip2px(10.0f);
        this.f = 13;
        a(context);
        this.c.setColor(Color.parseColor("#aaaaaa"));
        this.c.setTextSize((float) DipPixelUtil.dip2px((float) this.f));
        this.b[0] = new p("m1", "厉害了word哥");
        this.b[1] = new p("m2", "听说评论了就有女朋友");
        this.b[2] = new p("m3", "滴，老湿基打卡");
        this.b[3] = new p("m4", "一点也不好看，我只看了十几遍");
        b();
        a();
    }

    private void a(Context context) {
        this.h = context.getResources().getDisplayMetrics().widthPixels;
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
            View textView = new TextView(getContext());
            textView.setBackgroundResource(this.n);
            textView.setTextSize((float) this.f);
            textView.setTextColor(this.g);
            textView.setPadding(this.d, this.e, this.d, this.e);
            textView.setText(this.b[i].b);
            textView.setTag(Integer.valueOf(i));
            textView.setOnClickListener(this);
            textView.setEnabled(this.r);
            addView(textView);
        }
        postInvalidate();
    }

    private void b() {
        int i;
        Arrays.sort(this.b, new f(this));
        for (i = 0; i < 4; i++) {
            this.a[i] = (int) (this.c.measureText(this.b[i].b) + ((float) (2 * this.d)));
        }
        int i2 = this.i;
        for (i = 0; i < 4; i++) {
            i2 += this.k + this.a[i];
        }
        if (i2 + (this.i - this.k) <= this.h) {
            this.l = 4;
            return;
        }
        i = (((this.i * 2) + this.k) + this.a[0]) + this.a[1];
        int i3 = (((this.i * 2) + this.k) + this.a[0]) + this.a[2];
        int i4 = (((this.i * 2) + this.k) + this.a[0]) + this.a[3];
        int i5 = (((this.i * 2) + this.k) + this.a[1]) + this.a[2];
        int i6 = (((this.i * 2) + this.k) + this.a[1]) + this.a[3];
        int i7 = (this.k + i) + this.a[2];
        int i8 = (this.i * 2) + this.a[3];
        i -= (((this.i * 2) + this.k) + this.a[2]) + this.a[3];
        int i9 = i3 - i6;
        int i10 = i4 - i5;
        int i11 = i7 - i8;
        i = Math.abs(i);
        if (Math.abs(i9) < i) {
            i = Math.abs(i9);
            i9 = 1;
        } else {
            i9 = 0;
        }
        if (Math.abs(i10) < i) {
            i = Math.abs(i10);
            i9 = 2;
        }
        if (Math.abs(i11) < i) {
            i9 = 3;
        }
        if (i9 == 0) {
            this.l = 2;
        } else if (i9 == 1) {
            this.l = 2;
            if (i3 <= i6) {
                a(1, 2);
            } else {
                a(0, 3);
            }
        } else if (i9 == 2) {
            this.l = 2;
            if (i4 <= i5) {
                a(2, 3);
                a(1, 2);
                return;
            }
            a(0, 1);
            a(1, 2);
        } else {
            this.l = 3;
            if (i7 > i8) {
                a(2, 3);
                a(1, 2);
                a(0, 1);
                this.l = 1;
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
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        a(getContext());
        i2 = this.h;
        for (i3 = 0; i3 < 4; i3++) {
            View childAt = getChildAt(i3);
            measureChild(childAt, MeasureSpec.makeMeasureSpec((int) (1.5d * ((double) this.h)), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
            this.a[i3] = childAt.getMeasuredWidth();
        }
        if (this.o != 0) {
            i3 = this.i;
            for (i2 = 0; i2 < this.l; i2++) {
                i3 += this.k + this.a[i2];
            }
            this.p = (this.h - (i3 + (this.i - this.k))) / 2;
            i2 = this.i;
            for (i3 = this.l; i3 < 4; i3++) {
                i2 += this.k + this.a[i3];
            }
            this.q = (this.h - (i2 + (this.i - this.k))) / 2;
        } else {
            this.p = 0;
            this.q = 0;
        }
        if (this.l < 4) {
            i2 = ((this.i * 2) + this.j) + (getChildAt(0).getMeasuredHeight() * 2);
        } else {
            i2 = (this.i * 2) + getChildAt(0).getMeasuredHeight();
            this.q = 0;
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        i2 = this.i;
        z = false;
        while (z < true) {
            int i5;
            i3 = getChildAt(z);
            i4 = this.i;
            if (z < this.l) {
                if (!z) {
                    i2 = this.i + this.p;
                }
                if (z) {
                    i5 = this.k;
                } else {
                    i5 = 0;
                }
                i2 += i5;
            } else if (z >= this.l) {
                if (z == this.l) {
                    i2 = this.i + this.q;
                }
                i2 += z - this.l == 0 ? 0 : this.k;
                i4 += i3.getMeasuredHeight() + this.j;
            } else {
                i2 = 0;
            }
            i5 = this.a[z] + i2;
            i3.layout(i2, i4, i5, i3.getMeasuredHeight() + i4);
            z++;
            i2 = i5;
        }
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
        if (this.r != z) {
            setChildrenEnabled(z);
        }
        this.r = z;
    }

    private void setChildrenEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }
}
