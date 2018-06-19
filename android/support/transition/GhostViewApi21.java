package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@RequiresApi(21)
class GhostViewApi21 implements GhostViewImpl {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    static class Creator implements android.support.transition.GhostViewImpl.Creator {
        Creator() {
        }

        public android.support.transition.GhostViewImpl addGhost(android.view.View r6, android.view.ViewGroup r7, android.graphics.Matrix r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            android.support.transition.GhostViewApi21.fetchAddGhostMethod();
            r0 = android.support.transition.GhostViewApi21.sAddGhostMethod;
            r1 = 0;
            if (r0 == 0) goto L_0x0031;
        L_0x000a:
            r0 = new android.support.transition.GhostViewApi21;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r2 = android.support.transition.GhostViewApi21.sAddGhostMethod;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r3 = 3;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r4 = 0;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r3[r4] = r6;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r6 = 1;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r3[r6] = r7;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r6 = 2;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r3[r6] = r8;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r6 = r2.invoke(r1, r3);	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r6 = (android.view.View) r6;	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            r0.<init>(r6);	 Catch:{ IllegalAccessException -> 0x0031, InvocationTargetException -> 0x0026 }
            return r0;
        L_0x0026:
            r6 = move-exception;
            r7 = new java.lang.RuntimeException;
            r6 = r6.getCause();
            r7.<init>(r6);
            throw r7;
        L_0x0031:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.transition.GhostViewApi21.Creator.addGhost(android.view.View, android.view.ViewGroup, android.graphics.Matrix):android.support.transition.GhostViewImpl");
        }

        public void removeGhost(android.view.View r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            android.support.transition.GhostViewApi21.fetchRemoveGhostMethod();
            r0 = android.support.transition.GhostViewApi21.sRemoveGhostMethod;
            if (r0 == 0) goto L_0x0024;
        L_0x0009:
            r0 = android.support.transition.GhostViewApi21.sRemoveGhostMethod;	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r1 = 0;	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r2 = 1;	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r3 = 0;	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x0023, InvocationTargetException -> 0x0018 }
            return;
        L_0x0018:
            r5 = move-exception;
            r0 = new java.lang.RuntimeException;
            r5 = r5.getCause();
            r0.<init>(r5);
            throw r0;
        L_0x0023:
            return;
        L_0x0024:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.transition.GhostViewApi21.Creator.removeGhost(android.view.View):void");
        }
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    private GhostViewApi21(@NonNull View view) {
        this.mGhostView = view;
    }

    public void setVisibility(int i) {
        this.mGhostView.setVisibility(i);
    }

    private static void fetchGhostViewClass() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sGhostViewClassFetched;
        if (r0 != 0) goto L_0x000f;
    L_0x0004:
        r0 = "android.view.GhostView";	 Catch:{ ClassNotFoundException -> 0x000c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000c }
        sGhostViewClass = r0;	 Catch:{ ClassNotFoundException -> 0x000c }
    L_0x000c:
        r0 = 1;
        sGhostViewClassFetched = r0;
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.GhostViewApi21.fetchGhostViewClass():void");
    }

    private static void fetchAddGhostMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sAddGhostMethodFetched;
        if (r0 != 0) goto L_0x0028;
    L_0x0004:
        r0 = 1;
        fetchGhostViewClass();	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = sGhostViewClass;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r2 = "addGhost";	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = 3;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = android.view.ViewGroup.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r4 = 2;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0026 }
        sAddGhostMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0026 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0026 }
    L_0x0026:
        sAddGhostMethodFetched = r0;
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.GhostViewApi21.fetchAddGhostMethod():void");
    }

    private static void fetchRemoveGhostMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sRemoveGhostMethodFetched;
        if (r0 != 0) goto L_0x001e;
    L_0x0004:
        r0 = 1;
        fetchGhostViewClass();	 Catch:{ NoSuchMethodException -> 0x001c }
        r1 = sGhostViewClass;	 Catch:{ NoSuchMethodException -> 0x001c }
        r2 = "removeGhost";	 Catch:{ NoSuchMethodException -> 0x001c }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x001c }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x001c }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x001c }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x001c }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x001c }
        sRemoveGhostMethod = r1;	 Catch:{ NoSuchMethodException -> 0x001c }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x001c }
    L_0x001c:
        sRemoveGhostMethodFetched = r0;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.GhostViewApi21.fetchRemoveGhostMethod():void");
    }
}
