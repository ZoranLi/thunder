package com.xunlei.downloadprovider.player.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: AutoPlayHelper */
public final class a {
    public ViewGroup a;
    public int b = 0;
    public b c;
    private Context d;
    private boolean e = true;
    private boolean f;
    private Rect g = new Rect();
    private float h;

    private static boolean b(int i) {
        return i == 2;
    }

    public a(Context context) {
        this.d = context;
    }

    public final void a(int i) {
        if (c()) {
            if (!b(this.b) && b(i)) {
                b();
            } else if (b(this.b) && !b(i)) {
                b();
                if (this.c == null) {
                    a(this.a, this.e);
                }
            }
            this.b = i;
            return;
        }
        this.b = i;
    }

    public final void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            new StringBuilder("onScrollTouchUp--scrollState=").append(this.b);
            this.h = 0.0f;
            if (b(this.b) == null && c() != null) {
                if (this.c == null) {
                    a(this.a, this.e);
                    return;
                }
                if (b() != null) {
                    a(this.a, this.e);
                }
            }
        } else if (motionEvent.getAction() == 2) {
            float rawY = motionEvent.getRawY();
            if (this.h <= 0.0f) {
                this.h = rawY;
                return;
            }
            rawY -= this.h;
            if (Math.abs(rawY) >= 2.0f) {
                if (rawY > 0.0f) {
                    this.e = false;
                } else {
                    this.e = true;
                }
                this.h = motionEvent.getRawY();
            }
        }
    }

    private boolean b() {
        if (this.c == null || a(this.c.getPlayerContainerView()) > 40) {
            return false;
        }
        this.c.c();
        this.c = null;
        return true;
    }

    private int a(View view) {
        Rect rect = this.g;
        if (!view.getLocalVisibleRect(rect)) {
            return null;
        }
        view = view.getHeight();
        int i = 100;
        if (d.a(rect)) {
            i = ((view - rect.top) * 100) / view;
        } else if (d.a(rect, view)) {
            i = (rect.bottom * 100) / view;
        }
        return i;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        if (!this.f && viewGroup.getChildCount() > 0) {
            this.f = true;
            StringBuilder stringBuilder = new StringBuilder("traverse--isScrollUp=");
            stringBuilder.append(this.e);
            stringBuilder.append("|isOrder=");
            stringBuilder.append(z);
            if (z) {
                b(viewGroup);
            } else {
                c(viewGroup);
            }
            this.f = null;
        }
    }

    private void b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount && !a(viewGroup, i)) {
            i++;
        }
    }

    private void c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount() - 1;
        while (childCount >= 0 && !a(viewGroup, childCount)) {
            childCount--;
        }
    }

    public final void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof b) {
                b bVar = (b) childAt;
                if (bVar != null) {
                    bVar.c();
                    this.c = null;
                }
            }
        }
    }

    private boolean a(ViewGroup viewGroup, int i) {
        if (i >= 0) {
            if (i < viewGroup.getChildCount()) {
                i = viewGroup.getChildAt(i);
                if (i instanceof b) {
                    b bVar = (b) i;
                    if (bVar.d() && a(bVar.getPlayerContainerView()) >= 90) {
                        a(viewGroup);
                        bVar.b();
                        this.c = bVar;
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final void a(b bVar) {
        new StringBuilder("setCurrentItem--playItem=").append(bVar);
        this.c = bVar;
    }

    public final boolean a() {
        return this.c != null;
    }

    private static boolean c() {
        if (!b.a(BrothersApplication.getApplicationInstance())) {
            return false;
        }
        boolean z;
        c a = c.a();
        if (a.b != 2) {
            if (a.b != 1) {
                z = false;
                if (!z) {
                    return false;
                }
                if (b.f(BrothersApplication.getApplicationInstance())) {
                    if (a.b != 2) {
                        if (a.b == 1) {
                            z = false;
                            if (z) {
                                return true;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
                if (b.e(BrothersApplication.getApplicationInstance())) {
                    if (!(a.b != 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
        z = true;
        if (!z) {
            return false;
        }
        if (b.f(BrothersApplication.getApplicationInstance())) {
            if (a.b != 2) {
                if (a.b == 1) {
                    z = false;
                    if (z) {
                        return true;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        if (b.e(BrothersApplication.getApplicationInstance())) {
            if (a.b != 1) {
            }
            if (a.b != 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean b(b bVar) {
        return (this.c == null || this.c != bVar) ? null : true;
    }

    public final void a(ViewGroup viewGroup, int i, int i2, int i3) {
        b bVar = this.c;
        int i4 = 0;
        if (!(bVar == null || (viewGroup instanceof ViewGroup) == null)) {
            viewGroup = bVar.getPosition();
            if (viewGroup < i - i3 || viewGroup >= (i + i2) - i3) {
                viewGroup = bVar.c();
                this.c = null;
                if (viewGroup == null && this.c != null) {
                    viewGroup = this.c.getPlayerContainerView();
                    i = this.d;
                    i2 = this.g;
                    if (viewGroup.getLocalVisibleRect(i2) != 0) {
                        viewGroup = viewGroup.getHeight();
                        i = i.getResources().getDimension(R.dimen.main_bottom_tab_height);
                        if (d.a(i2) != 0) {
                            i = (((viewGroup - i2.top) * 100) / viewGroup) - 0;
                        } else if (d.a(i2, viewGroup) != 0) {
                            i = (((int) (((float) i2.bottom) - i)) * 100) / viewGroup;
                        } else {
                            i4 = 100;
                        }
                        i4 = i;
                    }
                    if (i4 <= 40) {
                        this.c.c();
                        this.c = null;
                        return;
                    }
                    return;
                }
            }
        }
        viewGroup = null;
        if (viewGroup == null) {
        }
    }
}
