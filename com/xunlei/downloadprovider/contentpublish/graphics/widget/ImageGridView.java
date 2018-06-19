package com.xunlei.downloadprovider.contentpublish.graphics.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

public class ImageGridView extends ViewGroup {
    private int a;
    private int b;
    private int c;
    private a d;
    private b e;
    private OnClickListener f;
    private View g;

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int a;
        public int b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
    }

    public interface b {
    }

    public ImageGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ImageGridView, i, 0);
        attributeSet = DipPixelUtil.dip2px(5.0f);
        this.a = context.getDimensionPixelSize(0, attributeSet);
        this.b = context.getDimensionPixelSize(1, attributeSet);
        context.recycle();
        setImagePaths(new ArrayList());
    }

    public void setImagePaths(List<String> list) {
        if (list != null) {
            removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                View photoView = new PhotoView(getContext());
                Glide.with(getContext()).load((String) list.get(i)).centerCrop().thumbnail(0.1f).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp).into(photoView.getImageView());
                photoView.setOnClickListener(new a(this, photoView, i));
                photoView.setOnDeleteOnClickListener(new b(this, photoView, i));
                addView(photoView);
            }
            if (list.size() < 9) {
                if (this.g == null) {
                    this.g = LayoutInflater.from(getContext()).inflate(R.layout.photo_publish_add_btn_view, null);
                    this.g.setOnClickListener(new c(this));
                }
                addView(this.g);
            }
        }
    }

    public void setOnItemClickListener(a aVar) {
        this.d = aVar;
    }

    public void setOnItemDeletedListener(b bVar) {
        this.e = bVar;
    }

    public void setOnAddBtnClickListener(OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        i = MeasureSpec.getSize(i);
        this.c = (i - (2 * this.a)) / 3;
        i2 = getChildCount();
        int i4 = 0;
        for (i3 = 0; i3 < i2; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.width = this.c;
            layoutParams.height = this.c;
            layoutParams.b = (i3 % 3) * (this.c + this.a);
            layoutParams.a = (i3 / 3) * (this.c + this.b);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.c, 1073741824);
            childAt.measure(makeMeasureSpec, makeMeasureSpec);
        }
        i3 = i2 / 3;
        if (i2 % 3 != 0) {
            i4 = 1;
        }
        setMeasuredDimension(i, ((this.b + this.c) * (i3 + i4)) - this.b);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        for (boolean z2 = false; z2 < z; z2++) {
            i2 = getChildAt(z2);
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            i2.layout(layoutParams.b, layoutParams.a, layoutParams.b + this.c, layoutParams.a + this.c);
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
