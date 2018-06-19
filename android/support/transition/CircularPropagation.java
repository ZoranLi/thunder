package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        int viewX;
        Rect epicenter;
        int centerX;
        int centerY;
        if (transitionValues2 != null) {
            if (getViewVisibility(transitionValues) != 0) {
                transitionValues = transitionValues2;
                transitionValues2 = 1;
                viewX = getViewX(transitionValues);
                transitionValues = getViewY(transitionValues);
                epicenter = transition.getEpicenter();
                if (epicenter == null) {
                    centerX = epicenter.centerX();
                    centerY = epicenter.centerY();
                } else {
                    int[] iArr = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
                    centerY = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
                    centerX = round;
                }
                transitionValues = distance((float) viewX, (float) transitionValues, (float) centerX, (float) centerY) / distance(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
                viewGroup = transition.getDuration();
                if (viewGroup < null) {
                    viewGroup = 300;
                }
                return (long) Math.round((((float) (viewGroup * ((long) transitionValues2))) / this.mPropagationSpeed) * transitionValues);
            }
        }
        transitionValues2 = -1;
        viewX = getViewX(transitionValues);
        transitionValues = getViewY(transitionValues);
        epicenter = transition.getEpicenter();
        if (epicenter == null) {
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            int round2 = Math.round(((float) (iArr2[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            centerY = Math.round(((float) (iArr2[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            centerX = round2;
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        transitionValues = distance((float) viewX, (float) transitionValues, (float) centerX, (float) centerY) / distance(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        viewGroup = transition.getDuration();
        if (viewGroup < null) {
            viewGroup = 300;
        }
        return (long) Math.round((((float) (viewGroup * ((long) transitionValues2))) / this.mPropagationSpeed) * transitionValues);
    }

    private static float distance(float f, float f2, float f3, float f4) {
        f3 -= f;
        f4 -= f2;
        return (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
    }
}
