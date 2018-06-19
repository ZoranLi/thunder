package com.xunlei.downloadprovider.cardslide.slide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import anet.channel.util.ErrorConstant;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak", "NewApi", "ClickableViewAccessibility"})
public class CardSlidePanel extends ViewGroup {
    private List<CardItemView> a;
    private List<View> b;
    private final ViewDragHelper c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private a m;
    private int n;
    private boolean o;
    private GestureDetectorCompat p;
    private Point q;
    private a r;
    private Rect s;
    private int t;

    public interface a {
        void a(int i, float f);

        void a(int i, View view);

        void a(boolean z, int i, int i2);
    }

    private class c extends SimpleOnGestureListener {
        final /* synthetic */ CardSlidePanel a;

        private c(CardSlidePanel cardSlidePanel) {
            this.a = cardSlidePanel;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f2) + Math.abs(f) > ((float) this.a.l) ? true : null;
        }
    }

    private class b extends Callback {
        final /* synthetic */ CardSlidePanel a;

        public final int clampViewPositionVertical(View view, int i, int i2) {
            return i;
        }

        public final int getViewHorizontalDragRange(View view) {
            return 255;
        }

        private b(CardSlidePanel cardSlidePanel) {
            this.a = cardSlidePanel;
        }

        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            this.a.a((CardItemView) view);
        }

        public final boolean tryCaptureView(View view, int i) {
            if (!(this.a.r == 0 || this.a.r.b() == 0 || view.getVisibility() != 0)) {
                if (view.getScaleX() > 1064011039) {
                    if (this.a.o != 0 || this.a.a.indexOf(view) > 0) {
                        return false;
                    }
                    CardItemView cardItemView = (CardItemView) view;
                    cardItemView.d.setAtRest();
                    cardItemView.e.setAtRest();
                    if (this.a.s == 0) {
                        this.a.s = this.a.r.a(view);
                    }
                    view = true;
                    if (this.a.s != 0) {
                        view = this.a.s.contains(this.a.q.x, this.a.q.y);
                    }
                    if (view != null) {
                        this.a.getParent().requestDisallowInterceptTouchEvent(view);
                    }
                    return view;
                }
            }
            return false;
        }

        public final void onViewReleased(View view, float f, float f2) {
            CardSlidePanel.a(this.a, (CardItemView) view, (int) f, (int) f2);
        }

        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            if (i < 0) {
                this.a.t = 0;
            } else if (i > 0) {
                this.a.t = 1;
            } else {
                this.a.t = -1;
            }
            return i;
        }
    }

    private static float a(float f) {
        double d = ((double) f) + 0.5d;
        return d > 1.0d ? 1.0f : (float) d;
    }

    public CardSlidePanel(Context context) {
        this(context, null);
    }

    public CardSlidePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardSlidePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = DipPixelUtil.dip2px(68.0f);
        this.j = 40;
        this.k = 20;
        this.l = 50;
        this.n = 0;
        this.o = false;
        this.q = new Point();
        this.t = -1;
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.card);
        this.i = (int) attributeSet.getDimension(0, (float) this.i);
        this.j = (int) attributeSet.getDimension(1, (float) this.j);
        this.k = (int) attributeSet.getDimension(2, (float) this.k);
        this.c = ViewDragHelper.create(this, 10.0f, new b());
        this.c.setEdgeTrackingEnabled(8);
        attributeSet.recycle();
        this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.p = new GestureDetectorCompat(context, new c());
        this.p.setIsLongpressEnabled(false);
        getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
    }

    private void a() {
        if (this.r != null && this.f > 0) {
            if (this.g > 0) {
                int i;
                for (i = 0; i < 4; i++) {
                    View cardItemView = new CardItemView(getContext());
                    View inflate = LayoutInflater.from(cardItemView.getContext()).inflate(this.r.a(), null);
                    cardItemView.b = (ImageView) inflate.findViewById(R.id.iv_love);
                    cardItemView.c = (ImageView) inflate.findViewById(R.id.iv_del);
                    cardItemView.a = (ViewGroup) inflate.findViewById(R.id.card_vod_layout);
                    cardItemView.addView(inflate, new LayoutParams(-1, -2));
                    cardItemView.setParentView(this);
                    addView(cardItemView, new ViewGroup.LayoutParams(-1, -2));
                    if (i == 0) {
                        cardItemView.setAlpha(0.0f);
                    }
                }
                this.a.clear();
                for (i = 0; i < 4; i++) {
                    this.a.add((CardItemView) getChildAt(3 - i));
                }
                i = this.r.b();
                for (int i2 = 0; i2 < 4; i2++) {
                    if (i2 < i) {
                        this.r.a((View) this.a.get(i2), i2);
                    } else {
                        ((CardItemView) this.a.get(i2)).setVisibility(4);
                    }
                    ((CardItemView) this.a.get(0)).setAlpha(1.0f);
                    ((CardItemView) this.a.get(1)).setAlpha(0.9f);
                    ((CardItemView) this.a.get(2)).setAlpha(0.9f);
                    if (i2 == 0 && this.n == 0) {
                        this.m.a(0, (View) this.a.get(0));
                    }
                }
            }
        }
    }

    public final void a(CardItemView cardItemView) {
        if (this.a.indexOf(cardItemView) + 2 <= this.a.size()) {
            float abs = ((float) (Math.abs(cardItemView.getTop() - this.e) + Math.abs(cardItemView.getLeft() - this.d))) / 500.0f;
            float f = abs - 0.1f;
            if (abs > 1.0f) {
                abs = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            a(cardItemView, abs, 1);
            a(cardItemView, f, 2);
            CardItemView cardItemView2 = (CardItemView) this.a.get(this.a.size() - 1);
            float f2 = 0.4f;
            if (f < 0.4f) {
                f2 = f;
            }
            cardItemView2.setAlpha(f2);
            ((CardItemView) this.a.get(0)).setAlpha(1.0f);
            cardItemView = cardItemView;
            StringBuilder stringBuilder = new StringBuilder("mIsSlideLeft rate2 = ");
            stringBuilder.append(this.t);
            stringBuilder.append(", ");
            stringBuilder.append(f);
            ((CardItemView) this.a.get(1)).getIvLove().setAlpha(0.0f);
            ((CardItemView) this.a.get(1)).getIvDel().setAlpha(0.0f);
            ((CardItemView) this.a.get(2)).getIvLove().setAlpha(0.0f);
            ((CardItemView) this.a.get(2)).getIvDel().setAlpha(0.0f);
            cardItemView2.getIvDel().setAlpha(0.0f);
            cardItemView2.getIvLove().setAlpha(0.0f);
            if (this.t == 0) {
                cardItemView.getIvLove().setAlpha(0.0f);
                cardItemView.getIvDel().setAlpha(f);
                abs = a(f);
                cardItemView.getIvDel().setScaleX(abs);
                cardItemView.getIvDel().setScaleY(abs);
            } else if (this.t == 1) {
                cardItemView.getIvDel().setAlpha(0.0f);
                cardItemView.getIvLove().setAlpha(f);
                abs = a(f);
                cardItemView.getIvLove().setScaleX(abs);
                cardItemView.getIvLove().setScaleY(abs);
            }
            this.m.a(this.t, f);
        }
    }

    private void b() {
        if (this.b.size() != 0) {
            CardItemView cardItemView = (CardItemView) this.b.get(0);
            StringBuilder stringBuilder = new StringBuilder("orderViewStack changedView.getLeft(), initCenterViewX = ");
            stringBuilder.append(cardItemView.getLeft());
            stringBuilder.append(", ");
            stringBuilder.append(this.d);
            cardItemView.offsetLeftAndRight(this.d - cardItemView.getLeft());
            cardItemView.offsetTopAndBottom((this.e - cardItemView.getTop()) + (this.k * 2));
            cardItemView.setScaleX(0.84000003f);
            cardItemView.setScaleY(0.84000003f);
            cardItemView.setAlpha(0.0f);
            ViewGroup.LayoutParams layoutParams = cardItemView.getLayoutParams();
            removeViewInLayout(cardItemView);
            addViewInLayout(cardItemView, 0, layoutParams, true);
            int i = this.n + 4;
            if (i < this.r.b()) {
                this.r.a(cardItemView, i);
            } else {
                cardItemView.setVisibility(4);
            }
            this.a.remove(cardItemView);
            this.a.add(cardItemView);
            this.b.remove(0);
            if (this.n + 1 < this.r.b()) {
                this.n++;
            }
            if (this.m != null) {
                this.m.a(this.n, (View) this.a.get(0));
            }
            ((CardItemView) this.a.get(0)).setAlpha(1.0f);
            ((CardItemView) this.a.get(1)).setAlpha(0.9f);
            ((CardItemView) this.a.get(2)).setAlpha(0.4f);
            if (this.n < this.a.size()) {
                cardItemView = (CardItemView) this.a.get(0);
                CardItemView cardItemView2 = (CardItemView) this.a.get(1);
                cardItemView.getIvLove().setAlpha(0.0f);
                cardItemView.getIvDel().setAlpha(0.0f);
                cardItemView2.getIvLove().setAlpha(0.0f);
                cardItemView2.getIvDel().setAlpha(0.0f);
            }
        }
    }

    private void a(View view, float f, int i) {
        int i2 = this.k * i;
        float f2 = 1.0f - (((float) i) * 0.08f);
        int i3 = i - 1;
        f2 += ((1.0f - (0.08f * ((float) i3))) - f2) * f;
        view = (View) this.a.get(this.a.indexOf(view) + i);
        view.offsetTopAndBottom((((int) (((float) i2) + (((float) ((this.k * i3) - i2)) * f))) - view.getTop()) + this.e);
        view.setScaleX(f2);
        view.setScaleY(f2);
        if (i == 1) {
            view.setAlpha(0.9f);
        } else if (i == 2) {
            view.setAlpha(0.4f);
        } else {
            if (i == 0) {
                view.setAlpha(1.0f);
            }
        }
    }

    private void setLoveOrDelAlpha(int i) {
        if (i == 0) {
            this.t = 0;
            ((CardItemView) this.a.get(0)).getIvLove().setAlpha(0.0f);
            ((CardItemView) this.a.get(0)).getIvDel().setAlpha(1.0f);
        } else if (i == 1) {
            this.t = 1;
            ((CardItemView) this.a.get(0)).getIvLove().setAlpha(1.0f);
            ((CardItemView) this.a.get(0)).getIvDel().setAlpha(0.0f);
        } else {
            this.t = -1;
            ((CardItemView) this.a.get(0)).getIvLove().setAlpha(0.0f);
            ((CardItemView) this.a.get(0)).getIvDel().setAlpha(0.0f);
        }
    }

    public final void a(int i) {
        View view = (View) this.a.get(0);
        if (view.getVisibility() == 0) {
            if (!this.b.contains(view)) {
                r2 = i == 0 ? (-this.h) - 100 : i == 1 ? this.f + 100 : 0;
                if (r2 != 0) {
                    this.b.add(view);
                    if (this.c.smoothSlideViewTo(view, r2, this.e)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
                if (i >= 0 && this.m != null) {
                    this.m.a(false, this.n, i);
                }
                setLoveOrDelAlpha(i);
                view.setAlpha(1065353216);
            }
        }
    }

    public void computeScroll() {
        if (this.c.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (this.c.getViewDragState() == 0) {
            b();
            this.o = false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.q.x = (int) motionEvent.getX();
            this.q.y = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean shouldInterceptTouchEvent = this.c.shouldInterceptTouchEvent(motionEvent);
        boolean onTouchEvent = this.p.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 0) {
            if (this.c.getViewDragState() == 2) {
                this.c.abort();
            }
            b();
            this.c.processTouchEvent(motionEvent);
        }
        return (shouldInterceptTouchEvent && onTouchEvent) ? true : null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.c.processTouchEvent(motionEvent);
        } catch (MotionEvent motionEvent2) {
            motionEvent2.printStackTrace();
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        setMeasuredDimension(resolveSizeAndState(MeasureSpec.getSize(i), i, 0), resolveSizeAndState(MeasureSpec.getSize(i2), i2, 0));
        this.f = getMeasuredWidth();
        this.g = getMeasuredHeight();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        for (boolean z2 = false; z2 < z; z2++) {
            View view = (View) this.a.get(z2);
            int width = (getWidth() - view.getMeasuredWidth()) / 2;
            view.layout(width, this.i, view.getMeasuredWidth() + width, this.i + view.getMeasuredHeight());
            i4 = this.k * z2;
            float f = 1.0f - (0.08f * ((float) z2));
            if (z2 > true) {
                i4 = this.k * 2;
                f = 0.84000003f;
            }
            view.offsetTopAndBottom(i4);
            view.setPivotY((float) view.getMeasuredHeight());
            view.setPivotX((float) (view.getMeasuredWidth() / 2));
            view.setScaleX(f);
            view.setScaleY(f);
        }
        if (z <= false) {
            this.d = ((CardItemView) this.a.get(0)).getLeft();
            this.e = ((CardItemView) this.a.get(0)).getTop();
            this.h = ((CardItemView) this.a.get(0)).getMeasuredWidth();
        }
    }

    public void setAdapter(a aVar) {
        this.r = aVar;
        a();
        aVar.b.registerObserver(new e(this, aVar));
    }

    public a getAdapter() {
        return this.r;
    }

    public void setCardSwitchListener(a aVar) {
        this.m = aVar;
    }

    static /* synthetic */ void a(CardSlidePanel cardSlidePanel, CardItemView cardItemView, int i, int i2) {
        int i3;
        int left;
        CardSlidePanel cardSlidePanel2 = cardSlidePanel;
        View view = cardItemView;
        int i4 = i;
        int i5 = cardSlidePanel2.d;
        int i6 = cardSlidePanel2.e;
        int left2 = cardItemView.getLeft() - cardSlidePanel2.d;
        int top = cardItemView.getTop() - cardSlidePanel2.e;
        int i7 = 0;
        if (i4 <= 300 || ((double) Math.abs(i)) >= ((double) i4) * 0.5d) {
            if (i4 < ErrorConstant.ERROR_TNET_EXCEPTION) {
                i4 = -i4;
                if (((double) Math.abs(i)) < ((double) i4) * 0.5d) {
                    i5 = -cardSlidePanel2.h;
                    i6 = ((i2 * (cardSlidePanel2.h + cardItemView.getLeft())) / i4) + cardItemView.getTop();
                    if (i6 <= cardSlidePanel2.g) {
                        i6 = cardSlidePanel2.g;
                    } else if (i6 < (-cardSlidePanel2.g) / 2) {
                        i6 = (-cardSlidePanel2.g) / 2;
                    }
                    if (i5 != cardSlidePanel2.d) {
                        i4 = cardSlidePanel2.d;
                        i3 = cardSlidePanel2.e;
                        left = cardItemView.getLeft();
                        i5 = cardItemView.getTop();
                        view.d.setCurrentValue((double) left);
                        view.e.setCurrentValue((double) i5);
                        view.d.setEndValue((double) i4);
                        view.e.setEndValue((double) i3);
                    }
                    cardSlidePanel2.b.add(view);
                    if (cardSlidePanel2.c.smoothSlideViewTo(view, i5, i6)) {
                        ViewCompat.postInvalidateOnAnimation(cardSlidePanel);
                    }
                    if (i7 >= 0 && cardSlidePanel2.m != null) {
                        cardSlidePanel2.m.a(true, cardSlidePanel2.n, i7);
                    }
                    cardSlidePanel2.setLoveOrDelAlpha(i7);
                    view.setAlpha(1.0f);
                    return;
                }
            }
            if (left2 <= 200 || ((float) Math.abs(top)) >= ((float) left2) * 3.0f) {
                if (left2 < ErrorConstant.ERROR_NO_NETWORK) {
                    left2 = -left2;
                    if (((float) Math.abs(top)) < ((float) left2) * 3.0f) {
                        i5 = -cardSlidePanel2.h;
                        i6 = ((top * (cardSlidePanel2.h + cardSlidePanel2.d)) / left2) + cardSlidePanel2.e;
                        if (i6 <= cardSlidePanel2.g) {
                            i6 = cardSlidePanel2.g;
                        } else if (i6 < (-cardSlidePanel2.g) / 2) {
                            i6 = (-cardSlidePanel2.g) / 2;
                        }
                        if (i5 != cardSlidePanel2.d) {
                            cardSlidePanel2.b.add(view);
                            if (cardSlidePanel2.c.smoothSlideViewTo(view, i5, i6)) {
                                ViewCompat.postInvalidateOnAnimation(cardSlidePanel);
                            }
                            cardSlidePanel2.m.a(true, cardSlidePanel2.n, i7);
                            cardSlidePanel2.setLoveOrDelAlpha(i7);
                            view.setAlpha(1.0f);
                            return;
                        }
                        i4 = cardSlidePanel2.d;
                        i3 = cardSlidePanel2.e;
                        left = cardItemView.getLeft();
                        i5 = cardItemView.getTop();
                        view.d.setCurrentValue((double) left);
                        view.e.setCurrentValue((double) i5);
                        view.d.setEndValue((double) i4);
                        view.e.setEndValue((double) i3);
                    }
                }
                i7 = -1;
                if (i6 <= cardSlidePanel2.g) {
                    i6 = cardSlidePanel2.g;
                } else if (i6 < (-cardSlidePanel2.g) / 2) {
                    i6 = (-cardSlidePanel2.g) / 2;
                }
                if (i5 != cardSlidePanel2.d) {
                    i4 = cardSlidePanel2.d;
                    i3 = cardSlidePanel2.e;
                    left = cardItemView.getLeft();
                    i5 = cardItemView.getTop();
                    view.d.setCurrentValue((double) left);
                    view.e.setCurrentValue((double) i5);
                    view.d.setEndValue((double) i4);
                    view.e.setEndValue((double) i3);
                }
                cardSlidePanel2.b.add(view);
                if (cardSlidePanel2.c.smoothSlideViewTo(view, i5, i6)) {
                    ViewCompat.postInvalidateOnAnimation(cardSlidePanel);
                }
                cardSlidePanel2.m.a(true, cardSlidePanel2.n, i7);
                cardSlidePanel2.setLoveOrDelAlpha(i7);
                view.setAlpha(1.0f);
                return;
            }
            i5 = cardSlidePanel2.f;
            i6 = ((top * (cardSlidePanel2.h + cardSlidePanel2.d)) / left2) + cardSlidePanel2.e;
        } else {
            i5 = cardSlidePanel2.f;
            i6 = ((i2 * (cardSlidePanel2.h + cardItemView.getLeft())) / i4) + cardItemView.getTop();
        }
        i7 = 1;
        if (i6 <= cardSlidePanel2.g) {
            i6 = cardSlidePanel2.g;
        } else if (i6 < (-cardSlidePanel2.g) / 2) {
            i6 = (-cardSlidePanel2.g) / 2;
        }
        if (i5 != cardSlidePanel2.d) {
            cardSlidePanel2.b.add(view);
            if (cardSlidePanel2.c.smoothSlideViewTo(view, i5, i6)) {
                ViewCompat.postInvalidateOnAnimation(cardSlidePanel);
            }
            cardSlidePanel2.m.a(true, cardSlidePanel2.n, i7);
            cardSlidePanel2.setLoveOrDelAlpha(i7);
            view.setAlpha(1.0f);
            return;
        }
        i4 = cardSlidePanel2.d;
        i3 = cardSlidePanel2.e;
        left = cardItemView.getLeft();
        i5 = cardItemView.getTop();
        view.d.setCurrentValue((double) left);
        view.e.setCurrentValue((double) i5);
        view.d.setEndValue((double) i4);
        view.e.setEndValue((double) i3);
    }
}
