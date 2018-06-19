package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    public void setSide(int i) {
        this.mSide = i;
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        SidePropagation sidePropagation = this;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0;
        }
        int i;
        int viewX;
        int viewY;
        int[] iArr;
        View view;
        int round;
        int round2;
        int width;
        int height;
        int centerX;
        int centerY;
        float distance;
        long duration;
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 != null) {
            if (getViewVisibility(transitionValues3) != 0) {
                transitionValues3 = transitionValues2;
                i = 1;
                viewX = getViewX(transitionValues3);
                viewY = getViewY(transitionValues3);
                iArr = new int[2];
                view = viewGroup;
                view.getLocationOnScreen(iArr);
                round = iArr[0] + Math.round(viewGroup.getTranslationX());
                round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
                width = round + viewGroup.getWidth();
                height = round2 + viewGroup.getHeight();
                if (epicenter == null) {
                    centerX = epicenter.centerX();
                    centerY = epicenter.centerY();
                } else {
                    centerX = (round + width) / 2;
                    centerY = (round2 + height) / 2;
                }
                distance = ((float) distance(view, viewX, viewY, centerX, centerY, round, round2, width, height)) / ((float) getMaxDistance(viewGroup));
                duration = transition.getDuration();
                if (duration < 0) {
                    duration = 300;
                }
                return (long) Math.round((((float) (duration * ((long) i))) / sidePropagation.mPropagationSpeed) * distance);
            }
        }
        i = -1;
        viewX = getViewX(transitionValues3);
        viewY = getViewY(transitionValues3);
        iArr = new int[2];
        view = viewGroup;
        view.getLocationOnScreen(iArr);
        round = iArr[0] + Math.round(viewGroup.getTranslationX());
        round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        width = round + viewGroup.getWidth();
        height = round2 + viewGroup.getHeight();
        if (epicenter == null) {
            centerX = (round + width) / 2;
            centerY = (round2 + height) / 2;
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        distance = ((float) distance(view, viewX, viewY, centerX, centerY, round, round2, width, height)) / ((float) getMaxDistance(viewGroup));
        duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i))) / sidePropagation.mPropagationSpeed) * distance);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int distance(android.view.View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
        r6 = this;
        r0 = r6.mSide;
        r1 = 3;
        r2 = 5;
        r3 = 0;
        r4 = 1;
        r5 = 8388611; // 0x800003 float:1.1754948E-38 double:4.1445245E-317;
        if (r0 != r5) goto L_0x0019;
    L_0x000b:
        r7 = android.support.v4.view.ViewCompat.getLayoutDirection(r7);
        if (r7 != r4) goto L_0x0012;
    L_0x0011:
        goto L_0x0013;
    L_0x0012:
        r4 = r3;
    L_0x0013:
        if (r4 == 0) goto L_0x0017;
    L_0x0015:
        r7 = r2;
        goto L_0x002d;
    L_0x0017:
        r7 = r1;
        goto L_0x002d;
    L_0x0019:
        r0 = r6.mSide;
        r5 = 8388613; // 0x800005 float:1.175495E-38 double:4.1445255E-317;
        if (r0 != r5) goto L_0x002b;
    L_0x0020:
        r7 = android.support.v4.view.ViewCompat.getLayoutDirection(r7);
        if (r7 != r4) goto L_0x0027;
    L_0x0026:
        goto L_0x0028;
    L_0x0027:
        r4 = r3;
    L_0x0028:
        if (r4 == 0) goto L_0x0015;
    L_0x002a:
        goto L_0x0017;
    L_0x002b:
        r7 = r6.mSide;
    L_0x002d:
        if (r7 == r1) goto L_0x0055;
    L_0x002f:
        if (r7 == r2) goto L_0x004c;
    L_0x0031:
        r11 = 48;
        if (r7 == r11) goto L_0x0043;
    L_0x0035:
        r11 = 80;
        if (r7 == r11) goto L_0x003a;
    L_0x0039:
        goto L_0x005d;
    L_0x003a:
        r9 = r9 - r13;
        r10 = r10 - r8;
        r7 = java.lang.Math.abs(r10);
        r3 = r9 + r7;
        goto L_0x005d;
    L_0x0043:
        r15 = r15 - r9;
        r10 = r10 - r8;
        r7 = java.lang.Math.abs(r10);
        r3 = r15 + r7;
        goto L_0x005d;
    L_0x004c:
        r8 = r8 - r12;
        r11 = r11 - r9;
        r7 = java.lang.Math.abs(r11);
        r3 = r8 + r7;
        goto L_0x005d;
    L_0x0055:
        r14 = r14 - r8;
        r11 = r11 - r9;
        r7 = java.lang.Math.abs(r11);
        r3 = r14 + r7;
    L_0x005d:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.SidePropagation.distance(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i = this.mSide;
        if (i == 3 || i == 5 || i == GravityCompat.START || i == GravityCompat.END) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }
}
