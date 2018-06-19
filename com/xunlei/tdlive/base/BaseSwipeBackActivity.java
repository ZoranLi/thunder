package com.xunlei.tdlive.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import java.util.Stack;

public class BaseSwipeBackActivity extends FragmentActivity {
    private boolean a = false;
    private d b;

    static class a implements ActivityLifecycleCallbacks {
        private static a a;
        private Application b = null;
        private Stack<Activity> c = null;
        private long d = 0;

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public static synchronized a a(Activity activity) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
                a aVar = a;
                long j = aVar.d;
                aVar.d = j + 1;
                if (j == 0) {
                    a.b = activity.getApplication();
                    a.b.registerActivityLifecycleCallbacks(a);
                    a.onActivityCreated(activity, null);
                }
                activity = a;
            }
            return activity;
        }

        public static synchronized void a() {
            synchronized (a.class) {
                a aVar = a;
                long j = aVar.d - 1;
                aVar.d = j;
                if (j <= 0) {
                    if (a.b != null) {
                        a.b.unregisterActivityLifecycleCallbacks(a);
                        a.b = null;
                    }
                    if (a.c != null) {
                        a.c.clear();
                    }
                }
            }
        }

        public static synchronized Activity b() {
            synchronized (a.class) {
                if (a != null) {
                    int size = a.c.size();
                    if (size < 2) {
                        return null;
                    }
                    Activity activity = (Activity) a.c.elementAt(size - 2);
                    return activity;
                }
                return null;
            }
        }

        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.c == null) {
                this.c = new Stack();
            }
            this.c.add(activity);
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.c != null) {
                this.c.remove(activity);
            }
        }
    }

    class b extends View {
        final /* synthetic */ BaseSwipeBackActivity a;
        private View b;

        public b(BaseSwipeBackActivity baseSwipeBackActivity, Context context) {
            this.a = baseSwipeBackActivity;
            super(context);
        }

        public void a(View view) {
            this.b = view;
            invalidate();
        }

        protected void onDraw(Canvas canvas) {
            if (this.b != null) {
                this.b.draw(canvas);
                this.b = null;
            }
        }
    }

    class c extends View {
        final /* synthetic */ BaseSwipeBackActivity a;
        private Drawable b;

        public c(BaseSwipeBackActivity baseSwipeBackActivity, Context context) {
            this.a = baseSwipeBackActivity;
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.b == null) {
                this.b = new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{0, 385875968, 1124073472});
            }
            this.b.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.b.draw(canvas);
        }
    }

    class d extends Handler {
        final /* synthetic */ BaseSwipeBackActivity a;
        private boolean b;
        private boolean c;
        private boolean d;
        private float e;
        private int f;
        private float g;
        private boolean h;
        private Window i;
        private a j;
        private final FrameLayout k;

        class a {
            final /* synthetic */ d a;
            private Activity b;
            private ViewGroup c;
            private View d;

            a(d dVar) {
                this.a = dVar;
            }

            private boolean a() {
                if (this.a.k.getChildCount() == 0) {
                    this.b = null;
                    this.c = null;
                    return false;
                }
                this.b = a.b();
                if (this.b == null) {
                    this.b = null;
                    this.c = null;
                    return false;
                }
                ViewGroup a = this.a.a(this.b.getWindow());
                if (a.getChildAt(0) instanceof c) {
                    a.removeViewAt(0);
                }
                if (!(a == null || a.getChildCount() == 0)) {
                    if (a.getChildAt(0) instanceof ViewGroup) {
                        this.c = (ViewGroup) a.getChildAt(0);
                        a.removeView(this.c);
                        this.a.k.addView(this.c, 0);
                        return true;
                    }
                }
                this.b = null;
                this.c = null;
                return false;
            }

            private void b() {
                if (this.c != null) {
                    View view = this.c;
                    FrameLayout a = this.a.k;
                    view.setX(0.0f);
                    a.removeView(view);
                    this.c = null;
                    if (this.b != null) {
                        if (!this.b.isFinishing()) {
                            this.a.a(this.b.getWindow()).addView(view, 0);
                            this.b = null;
                        }
                    }
                }
            }

            private void c() {
                if (this.d == null) {
                    this.d = new c(this.a.a, this.a.a());
                    this.d.setX(-50.0f);
                }
                LayoutParams layoutParams = new FrameLayout.LayoutParams(50, -1);
                FrameLayout a = this.a.k;
                if (this.d.getParent() == null) {
                    a.addView(this.d, 1, layoutParams);
                }
            }

            private void d() {
                if (this.d != null) {
                    this.a.a(this.a.i).removeView(this.d);
                    this.d = null;
                }
            }

            private void e() {
                FrameLayout a = this.a.k;
                View view = this.c;
                View bVar = new b(this.a.a, this.a.a());
                a.addView(bVar, 0);
                bVar.a(view);
            }

            private View f() {
                int i = this.a.j.c != null ? 1 : 0;
                if (this.a.j.d != null) {
                    i++;
                }
                return this.a.k.getChildAt(i);
            }
        }

        public d(BaseSwipeBackActivity baseSwipeBackActivity, Window window) {
            this(baseSwipeBackActivity, window, true);
        }

        public d(BaseSwipeBackActivity baseSwipeBackActivity, Window window, boolean z) {
            this.a = baseSwipeBackActivity;
            this.i = window;
            this.h = z;
            this.k = a(this.i);
            this.j = new a(this);
        }

        public boolean a(MotionEvent motionEvent) {
            if (this.k == null || !this.h) {
                return false;
            }
            boolean z = true;
            if (this.d) {
                return true;
            }
            if (this.f == 0) {
                this.f = (int) TypedValue.applyDimension(1, 15.0f, this.i.getContext().getResources().getDisplayMetrics());
            }
            int action = motionEvent.getAction() & 255;
            int actionIndex = motionEvent.getActionIndex();
            switch (action) {
                case 0:
                    if (!this.c) {
                        this.g = motionEvent.getRawX();
                        if (this.g < 0.0f || this.g > ((float) this.f)) {
                            z = false;
                        }
                        this.b = z;
                        break;
                    }
                    return true;
                case 1:
                case 3:
                case 4:
                case 6:
                    if (this.c != null && actionIndex == 0) {
                        this.c = false;
                        this.b = false;
                        sendEmptyMessage(3);
                        return true;
                    } else if (this.c == null || actionIndex == 0) {
                        return false;
                    } else {
                        return true;
                    }
                case 2:
                    action = ViewConfiguration.get(a()).getScaledTouchSlop();
                    if (this.b && !this.c && Math.abs(motionEvent.getRawX() - this.g) >= ((float) action)) {
                        this.c = true;
                        sendEmptyMessage(1);
                    }
                    if (this.c && actionIndex == 0) {
                        Message obtainMessage = obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putFloat("currentPointX", motionEvent.getRawX());
                        obtainMessage.what = 2;
                        obtainMessage.setData(bundle);
                        sendMessage(obtainMessage);
                        return true;
                    } else if (this.c == null || actionIndex == 0) {
                        return false;
                    } else {
                        return true;
                    }
                case 5:
                    if (this.c != null) {
                        return true;
                    }
                    break;
                default:
                    this.b = false;
                    this.c = false;
                    break;
            }
            return false;
        }

        public Context a() {
            return this.i == null ? null : this.i.getContext();
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    InputMethodManager inputMethodManager = (InputMethodManager) a().getSystemService("input_method");
                    View currentFocus = this.i.getCurrentFocus();
                    if (currentFocus != null) {
                        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    }
                    if (this.j.a() != null) {
                        this.j.c();
                        if (this.k.getChildCount() >= 3) {
                            message = this.j.f();
                            if (message.getBackground() == null) {
                                message.setBackgroundColor(b());
                            }
                            return;
                        }
                    }
                    return;
                    break;
                case 2:
                    a(message.getData().getFloat("currentPointX"));
                    return;
                case 3:
                    message = a().getResources().getDisplayMetrics().widthPixels;
                    if (this.e == 0.0f) {
                        if (this.k.getChildCount() >= 3) {
                            this.j.d();
                            this.j.b();
                            return;
                        }
                    } else if (this.e > ((float) (message / 4))) {
                        sendEmptyMessage(6);
                        return;
                    } else {
                        sendEmptyMessage(4);
                        return;
                    }
                    break;
                case 4:
                    a(true);
                    return;
                case 5:
                    this.e = 0.0f;
                    this.c = false;
                    this.j.d();
                    this.j.b();
                    return;
                case 6:
                    a(false);
                    return;
                case 7:
                    this.j.e();
                    this.j.d();
                    this.j.b();
                    Activity activity;
                    if ((a() instanceof Activity) == null) {
                        if ((a() instanceof ContextWrapper) != null) {
                            message = ((ContextWrapper) a()).getBaseContext();
                            if (message instanceof Activity) {
                                activity = (Activity) message;
                                activity.finish();
                                activity.overridePendingTransition(0, 0);
                                break;
                            }
                        }
                    }
                    activity = (Activity) a();
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                    return;
                    break;
                default:
                    break;
            }
        }

        private int b() {
            Throwable th;
            Throwable th2;
            TypedArray typedArray = null;
            try {
                TypedArray obtainStyledAttributes = a().getTheme().obtainStyledAttributes(new int[]{16842836});
                try {
                    int color = obtainStyledAttributes.getColor(0, ContextCompat.getColor(a(), 17170445));
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    return color;
                } catch (Throwable th3) {
                    th2 = th3;
                    typedArray = obtainStyledAttributes;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                th.printStackTrace();
                if (typedArray != null) {
                    typedArray.recycle();
                }
                return 0;
            }
        }

        private synchronized void a(float f) {
            int i = a().getResources().getDisplayMetrics().widthPixels;
            View g = this.j.c;
            View h = this.j.d;
            View c = this.j.f();
            if (!(g == null || c == null)) {
                if (h != null) {
                    float f2 = f - this.g;
                    this.g = f;
                    this.e += f2;
                    if (this.e < 0.0f) {
                        this.e = 0.0f;
                    }
                    g.setX(((float) ((-i) / 3)) + (this.e / 3.0f));
                    h.setX(this.e - 50.0f);
                    c.setX(this.e);
                    return;
                }
            }
            sendEmptyMessage(7.0E-45f);
        }

        private void a(boolean z) {
            final View g = this.j.c;
            final View h = this.j.d;
            final View c = this.j.f();
            if (g != null) {
                if (c != null) {
                    int i = a().getResources().getDisplayMetrics().widthPixels;
                    TimeInterpolator decelerateInterpolator = new DecelerateInterpolator(2.0f);
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    objectAnimator.setInterpolator(decelerateInterpolator);
                    objectAnimator.setProperty(View.TRANSLATION_X);
                    float f = (r6.e / 3.0f) - ((float) (i / 3));
                    float f2 = z ? (float) ((-i) / 3) : 0.0f;
                    objectAnimator.setFloatValues(new float[]{f, f2});
                    objectAnimator.setTarget(g);
                    ObjectAnimator objectAnimator2 = new ObjectAnimator();
                    objectAnimator2.setInterpolator(decelerateInterpolator);
                    objectAnimator2.setProperty(View.TRANSLATION_X);
                    float f3 = 50.0f;
                    float f4 = r6.e - 50.0f;
                    if (!z) {
                        f3 = (float) (i + 50);
                    }
                    objectAnimator2.setFloatValues(new float[]{f4, f3});
                    objectAnimator2.setTarget(h);
                    ObjectAnimator objectAnimator3 = new ObjectAnimator();
                    objectAnimator3.setInterpolator(decelerateInterpolator);
                    objectAnimator3.setProperty(View.TRANSLATION_X);
                    float f5 = r6.e;
                    float f6 = z ? 0.0f : (float) i;
                    objectAnimator3.setFloatValues(new float[]{f5, f6});
                    objectAnimator3.setTarget(c);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(z ? 150 : 300);
                    animatorSet.playTogether(new Animator[]{objectAnimator, objectAnimator2, objectAnimator3});
                    final boolean z2 = z;
                    animatorSet.addListener(new AnimatorListenerAdapter(r6) {
                        final /* synthetic */ d e;

                        public void onAnimationEnd(Animator animator) {
                            if (z2 != null) {
                                this.e.d = false;
                                g.setX(0.0f);
                                h.setX(-50.0f);
                                c.setX(0.0f);
                                this.e.sendEmptyMessage(5);
                                return;
                            }
                            this.e.sendEmptyMessage(7);
                        }
                    });
                    animatorSet.start();
                    r6.d = true;
                }
            }
        }

        private final FrameLayout a(Window window) {
            return window == null ? null : (FrameLayout) window.findViewById(16908290);
        }
    }

    public void onCreate(Bundle bundle) {
        if (com.xunlei.tdlive.modal.c.i(this)) {
            a.a(this);
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (com.xunlei.tdlive.modal.c.i(this)) {
            a.a();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!com.xunlei.tdlive.modal.c.i(this)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!d()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.b == null) {
            this.b = new d(this, getWindow());
        }
        if (!this.b.a(motionEvent)) {
            if (super.dispatchTouchEvent(motionEvent) == null) {
                return null;
            }
        }
        return true;
    }

    protected boolean d() {
        return this.a;
    }
}
