package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle implements DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = new int[]{16843531};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(android.app.Activity r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = "setHomeAsUpIndicator";	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5 = android.graphics.drawable.Drawable.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r6.mSetHomeAsUpIndicator = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = "setHomeActionContentDescription";	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r6.mSetHomeActionContentDescription = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            return;
        L_0x0026:
            r2 = 16908332; // 0x102002c float:2.3877352E-38 double:8.353826E-317;
            r7 = r7.findViewById(r2);
            if (r7 != 0) goto L_0x0030;
        L_0x002f:
            return;
        L_0x0030:
            r7 = r7.getParent();
            r7 = (android.view.ViewGroup) r7;
            r3 = r7.getChildCount();
            r4 = 2;
            if (r3 == r4) goto L_0x003e;
        L_0x003d:
            return;
        L_0x003e:
            r0 = r7.getChildAt(r0);
            r7 = r7.getChildAt(r1);
            r1 = r0.getId();
            if (r1 != r2) goto L_0x004d;
        L_0x004c:
            goto L_0x004e;
        L_0x004d:
            r7 = r0;
        L_0x004e:
            r0 = r7 instanceof android.widget.ImageView;
            if (r0 == 0) goto L_0x0056;
        L_0x0052:
            r7 = (android.widget.ImageView) r7;
            r6.mUpIndicatorView = r7;
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ActionBarDrawerToggle.SetIndicatorInfo.<init>(android.app.Activity):void");
        }
    }

    private class SlideDrawable extends InsetDrawable implements Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;

        SlideDrawable(Drawable drawable) {
            ActionBarDrawerToggle actionBarDrawerToggle = null;
            super(drawable, 0);
            if (VERSION.SDK_INT > 18) {
                actionBarDrawerToggle = true;
            }
            this.mHasMirroring = actionBarDrawerToggle;
            this.mTmpRect = new Rect();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            invalidateSelf();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        public void draw(@NonNull Canvas canvas) {
            copyBounds(this.mTmpRect);
            canvas.save();
            int i = 1;
            int i2 = ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1 ? 1 : 0;
            if (i2 != 0) {
                i = -1;
            }
            float width = (float) this.mTmpRect.width();
            canvas.translate((((-this.mOffset) * width) * this.mPosition) * ((float) i), 0.0f);
            if (!(i2 == 0 || this.mHasMirroring)) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public void onDrawerStateChanged(int i) {
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this(activity, drawerLayout, assumeMaterial(activity) ^ 1, i, i2, i3);
    }

    private static boolean assumeMaterial(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 21 || VERSION.SDK_INT < 21) ? null : true;
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i;
        this.mOpenDrawerContentDescRes = i2;
        this.mCloseDrawerContentDescRes = i3;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity, i);
        this.mSlider = new SlideDrawable(this.mDrawerImage);
        this.mSlider.setOffset(z ? 1051372203 : null);
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (this.mDrawerIndicatorEnabled == null) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? ContextCompat.getDrawable(this.mActivity, i) : 0);
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.mDrawerIndicatorEnabled) {
            if (z) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z;
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mHasCustomUpIndicator == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != ID_HOME || this.mDrawerIndicatorEnabled == null) {
            return null;
        }
        if (this.mDrawerLayout.isDrawerVisible((int) GravityCompat.START) != null) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        } else {
            this.mDrawerLayout.openDrawer((int) GravityCompat.START);
        }
        return true;
    }

    public void onDrawerSlide(View view, float f) {
        view = this.mSlider.getPosition();
        if (f > PayBaseConstants.HALF_OF_FLOAT) {
            view = Math.max(view, Math.max(0.0f, f - PayBaseConstants.HALF_OF_FLOAT) * 2.0f);
        } else {
            view = Math.min(view, f * 2.0f);
        }
        this.mSlider.setPosition(view);
    }

    public void onDrawerOpened(View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled != null) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerClosed(View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled != null) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    private Drawable getThemeUpIndicator() {
        if (this.mActivityImpl != null) {
            return this.mActivityImpl.getThemeUpIndicator();
        }
        if (VERSION.SDK_INT >= 18) {
            Context themedContext;
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                themedContext = actionBar.getThemedContext();
            } else {
                themedContext = this.mActivity;
            }
            TypedArray obtainStyledAttributes = themedContext.obtainStyledAttributes(null, THEME_ATTRS, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        obtainStyledAttributes = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
        drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void setActionBarUpIndicator(android.graphics.drawable.Drawable r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.mActivityImpl;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r5.mActivityImpl;
        r0.setActionBarUpIndicator(r6, r7);
        return;
    L_0x000a:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x001f;
    L_0x0010:
        r0 = r5.mActivity;
        r0 = r0.getActionBar();
        if (r0 == 0) goto L_0x001e;
    L_0x0018:
        r0.setHomeAsUpIndicator(r6);
        r0.setHomeActionContentDescription(r7);
    L_0x001e:
        return;
    L_0x001f:
        r0 = r5.mSetIndicatorInfo;
        if (r0 != 0) goto L_0x002c;
    L_0x0023:
        r0 = new android.support.v4.app.ActionBarDrawerToggle$SetIndicatorInfo;
        r1 = r5.mActivity;
        r0.<init>(r1);
        r5.mSetIndicatorInfo = r0;
    L_0x002c:
        r0 = r5.mSetIndicatorInfo;
        r0 = r0.mSetHomeAsUpIndicator;
        if (r0 == 0) goto L_0x0055;
    L_0x0032:
        r0 = r5.mActivity;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getActionBar();	 Catch:{ Exception -> 0x0054 }
        r1 = r5.mSetIndicatorInfo;	 Catch:{ Exception -> 0x0054 }
        r1 = r1.mSetHomeAsUpIndicator;	 Catch:{ Exception -> 0x0054 }
        r2 = 1;	 Catch:{ Exception -> 0x0054 }
        r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
        r4 = 0;	 Catch:{ Exception -> 0x0054 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0054 }
        r1.invoke(r0, r3);	 Catch:{ Exception -> 0x0054 }
        r6 = r5.mSetIndicatorInfo;	 Catch:{ Exception -> 0x0054 }
        r6 = r6.mSetHomeActionContentDescription;	 Catch:{ Exception -> 0x0054 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0054 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0054 }
        r1[r4] = r7;	 Catch:{ Exception -> 0x0054 }
        r6.invoke(r0, r1);	 Catch:{ Exception -> 0x0054 }
    L_0x0054:
        return;
    L_0x0055:
        r7 = r5.mSetIndicatorInfo;
        r7 = r7.mUpIndicatorView;
        if (r7 == 0) goto L_0x0062;
    L_0x005b:
        r7 = r5.mSetIndicatorInfo;
        r7 = r7.mUpIndicatorView;
        r7.setImageDrawable(r6);
    L_0x0062:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ActionBarDrawerToggle.setActionBarUpIndicator(android.graphics.drawable.Drawable, int):void");
    }

    private void setActionBarDescription(int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.mActivityImpl;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r4.mActivityImpl;
        r0.setActionBarDescription(r5);
        return;
    L_0x000a:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x001c;
    L_0x0010:
        r0 = r4.mActivity;
        r0 = r0.getActionBar();
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.setHomeActionContentDescription(r5);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r4.mSetIndicatorInfo;
        if (r0 != 0) goto L_0x0029;
    L_0x0020:
        r0 = new android.support.v4.app.ActionBarDrawerToggle$SetIndicatorInfo;
        r1 = r4.mActivity;
        r0.<init>(r1);
        r4.mSetIndicatorInfo = r0;
    L_0x0029:
        r0 = r4.mSetIndicatorInfo;
        r0 = r0.mSetHomeAsUpIndicator;
        if (r0 == 0) goto L_0x004e;
    L_0x002f:
        r0 = r4.mActivity;	 Catch:{ Exception -> 0x004e }
        r0 = r0.getActionBar();	 Catch:{ Exception -> 0x004e }
        r1 = r4.mSetIndicatorInfo;	 Catch:{ Exception -> 0x004e }
        r1 = r1.mSetHomeActionContentDescription;	 Catch:{ Exception -> 0x004e }
        r2 = 1;	 Catch:{ Exception -> 0x004e }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x004e }
        r3 = 0;	 Catch:{ Exception -> 0x004e }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x004e }
        r2[r3] = r5;	 Catch:{ Exception -> 0x004e }
        r1.invoke(r0, r2);	 Catch:{ Exception -> 0x004e }
        r5 = r0.getSubtitle();	 Catch:{ Exception -> 0x004e }
        r0.setSubtitle(r5);	 Catch:{ Exception -> 0x004e }
        return;
    L_0x004e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.ActionBarDrawerToggle.setActionBarDescription(int):void");
    }
}
