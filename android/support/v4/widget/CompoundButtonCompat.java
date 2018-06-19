package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
    private static final CompoundButtonCompatBaseImpl IMPL;

    static class CompoundButtonCompatBaseImpl {
        private static final String TAG = "CompoundButtonCompat";
        private static Field sButtonDrawableField;
        private static boolean sButtonDrawableFieldFetched;

        CompoundButtonCompatBaseImpl() {
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return compoundButton instanceof TintableCompoundButton ? ((TintableCompoundButton) compoundButton).getSupportButtonTintList() : null;
        }

        public void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof TintableCompoundButton) {
                ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
            }
        }

        public Mode getButtonTintMode(CompoundButton compoundButton) {
            return compoundButton instanceof TintableCompoundButton ? ((TintableCompoundButton) compoundButton).getSupportButtonTintMode() : null;
        }

        public android.graphics.drawable.Drawable getButtonDrawable(android.widget.CompoundButton r4) {
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
            r3 = this;
            r0 = sButtonDrawableFieldFetched;
            if (r0 != 0) goto L_0x0014;
        L_0x0004:
            r0 = 1;
            r1 = android.widget.CompoundButton.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r2 = "mButtonDrawable";	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
            sButtonDrawableField = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
        L_0x0012:
            sButtonDrawableFieldFetched = r0;
        L_0x0014:
            r0 = sButtonDrawableField;
            r1 = 0;
            if (r0 == 0) goto L_0x0024;
        L_0x0019:
            r0 = sButtonDrawableField;	 Catch:{ IllegalAccessException -> 0x0022 }
            r4 = r0.get(r4);	 Catch:{ IllegalAccessException -> 0x0022 }
            r4 = (android.graphics.drawable.Drawable) r4;	 Catch:{ IllegalAccessException -> 0x0022 }
            return r4;
        L_0x0022:
            sButtonDrawableField = r1;
        L_0x0024:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatBaseImpl.getButtonDrawable(android.widget.CompoundButton):android.graphics.drawable.Drawable");
        }
    }

    @RequiresApi(21)
    static class CompoundButtonCompatApi21Impl extends CompoundButtonCompatBaseImpl {
        CompoundButtonCompatApi21Impl() {
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        public void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }

        public Mode getButtonTintMode(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }
    }

    @RequiresApi(23)
    static class CompoundButtonCompatApi23Impl extends CompoundButtonCompatApi21Impl {
        CompoundButtonCompatApi23Impl() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            IMPL = new CompoundButtonCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new CompoundButtonCompatApi21Impl();
        } else {
            IMPL = new CompoundButtonCompatBaseImpl();
        }
    }

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        IMPL.setButtonTintList(compoundButton, colorStateList);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintList(compoundButton);
    }

    public static void setButtonTintMode(@NonNull CompoundButton compoundButton, @Nullable Mode mode) {
        IMPL.setButtonTintMode(compoundButton, mode);
    }

    @Nullable
    public static Mode getButtonTintMode(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintMode(compoundButton);
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }
}
