package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = (VERSION.SDK_INT < 21);
    private static final String TAG = "AppCompatPopupWindow";
    private boolean mOverlapAnchor;

    final class AnonymousClass1 implements OnScrollChangedListener {
        final /* synthetic */ Field val$fieldAnchor;
        final /* synthetic */ OnScrollChangedListener val$originalListener;
        final /* synthetic */ PopupWindow val$popup;

        AnonymousClass1(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
            this.val$fieldAnchor = field;
            this.val$popup = popupWindow;
            this.val$originalListener = onScrollChangedListener;
        }

        public final void onScrollChanged() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.val$fieldAnchor;	 Catch:{ IllegalAccessException -> 0x001a }
            r1 = r2.val$popup;	 Catch:{ IllegalAccessException -> 0x001a }
            r0 = r0.get(r1);	 Catch:{ IllegalAccessException -> 0x001a }
            r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ IllegalAccessException -> 0x001a }
            if (r0 == 0) goto L_0x0019;	 Catch:{ IllegalAccessException -> 0x001a }
        L_0x000c:
            r0 = r0.get();	 Catch:{ IllegalAccessException -> 0x001a }
            if (r0 != 0) goto L_0x0013;	 Catch:{ IllegalAccessException -> 0x001a }
        L_0x0012:
            goto L_0x0019;	 Catch:{ IllegalAccessException -> 0x001a }
        L_0x0013:
            r0 = r2.val$originalListener;	 Catch:{ IllegalAccessException -> 0x001a }
            r0.onScrollChanged();	 Catch:{ IllegalAccessException -> 0x001a }
            return;
        L_0x0019:
            return;
        L_0x001a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatPopupWindow.1.onScrollChanged():void");
        }
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        context = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (context.hasValue(R.styleable.PopupWindow_overlapAnchor) != null) {
            setSupportOverlapAnchor(context.getBoolean(R.styleable.PopupWindow_overlapAnchor, 0));
        }
        setBackgroundDrawable(context.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        attributeSet = VERSION.SDK_INT;
        if (!(i2 == 0 || attributeSet >= 11 || context.hasValue(R.styleable.PopupWindow_android_popupAnimationStyle) == null)) {
            setAnimationStyle(context.getResourceId(R.styleable.PopupWindow_android_popupAnimationStyle, -1));
        }
        context.recycle();
        if (VERSION.SDK_INT < 14) {
            wrapOnScrollChangedListener(this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private static void wrapOnScrollChangedListener(android.widget.PopupWindow r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x0026 }
        r1 = "mAnchor";	 Catch:{ Exception -> 0x0026 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x0026 }
        r1 = 1;	 Catch:{ Exception -> 0x0026 }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x0026 }
        r2 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x0026 }
        r3 = "mOnScrollChangedListener";	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getDeclaredField(r3);	 Catch:{ Exception -> 0x0026 }
        r2.setAccessible(r1);	 Catch:{ Exception -> 0x0026 }
        r1 = r2.get(r4);	 Catch:{ Exception -> 0x0026 }
        r1 = (android.view.ViewTreeObserver.OnScrollChangedListener) r1;	 Catch:{ Exception -> 0x0026 }
        r3 = new android.support.v7.widget.AppCompatPopupWindow$1;	 Catch:{ Exception -> 0x0026 }
        r3.<init>(r0, r4, r1);	 Catch:{ Exception -> 0x0026 }
        r2.set(r4, r3);	 Catch:{ Exception -> 0x0026 }
        return;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatPopupWindow.wrapOnScrollChangedListener(android.widget.PopupWindow):void");
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSupportOverlapAnchor(boolean z) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean getSupportOverlapAnchor() {
        if (COMPAT_OVERLAP_ANCHOR) {
            return this.mOverlapAnchor;
        }
        return PopupWindowCompat.getOverlapAnchor(this);
    }
}
