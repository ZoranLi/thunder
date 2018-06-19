package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import com.alipay.sdk.util.h;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    static final LayoutInflaterCompatBaseImpl IMPL;
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    static class Factory2Wrapper implements Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append("{");
            stringBuilder.append(this.mDelegateFactory);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    static class LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatBaseImpl() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            setFactory2(layoutInflater, layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null);
        }

        public void setFactory2(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, (Factory2) factory);
            } else {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, factory2);
            }
        }

        public LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
            layoutInflater = layoutInflater.getFactory();
            return layoutInflater instanceof Factory2Wrapper ? ((Factory2Wrapper) layoutInflater).mDelegateFactory : null;
        }
    }

    @RequiresApi(21)
    static class LayoutInflaterCompatApi21Impl extends LayoutInflaterCompatBaseImpl {
        LayoutInflaterCompatApi21Impl() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            layoutInflater.setFactory2(layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null);
        }

        public void setFactory2(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    static void forceSetFactory2(android.view.LayoutInflater r3, android.view.LayoutInflater.Factory2 r4) {
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
        r0 = sCheckedField;
        if (r0 != 0) goto L_0x002a;
    L_0x0004:
        r0 = 1;
        r1 = android.view.LayoutInflater.class;	 Catch:{ NoSuchFieldException -> 0x0013 }
        r2 = "mFactory2";	 Catch:{ NoSuchFieldException -> 0x0013 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0013 }
        sLayoutInflaterFactory2Field = r1;	 Catch:{ NoSuchFieldException -> 0x0013 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0013 }
        goto L_0x0028;
    L_0x0013:
        r1 = new java.lang.StringBuilder;
        r2 = "forceSetFactory2 Could not find field 'mFactory2' on class ";
        r1.<init>(r2);
        r2 = android.view.LayoutInflater.class;
        r2 = r2.getName();
        r1.append(r2);
        r2 = "; inflation may have unexpected results.";
        r1.append(r2);
    L_0x0028:
        sCheckedField = r0;
    L_0x002a:
        r0 = sLayoutInflaterFactory2Field;
        if (r0 == 0) goto L_0x0043;
    L_0x002e:
        r0 = sLayoutInflaterFactory2Field;	 Catch:{ IllegalAccessException -> 0x0034 }
        r0.set(r3, r4);	 Catch:{ IllegalAccessException -> 0x0034 }
        return;
    L_0x0034:
        r4 = new java.lang.StringBuilder;
        r0 = "forceSetFactory2 could not set the Factory2 on LayoutInflater ";
        r4.<init>(r0);
        r4.append(r3);
        r3 = "; inflation may have unexpected results.";
        r4.append(r3);
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.LayoutInflaterCompat.forceSetFactory2(android.view.LayoutInflater, android.view.LayoutInflater$Factory2):void");
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new LayoutInflaterCompatApi21Impl();
        } else {
            IMPL = new LayoutInflaterCompatBaseImpl();
        }
    }

    private LayoutInflaterCompat() {
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        IMPL.setFactory(layoutInflater, layoutInflaterFactory);
    }

    public static void setFactory2(@NonNull LayoutInflater layoutInflater, @NonNull Factory2 factory2) {
        IMPL.setFactory2(layoutInflater, factory2);
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        return IMPL.getFactory(layoutInflater);
    }
}
