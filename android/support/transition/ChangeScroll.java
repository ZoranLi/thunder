package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] PROPERTIES = new String[]{PROPNAME_SCROLL_X, PROPNAME_SCROLL_Y};
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Nullable
    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_SCROLL_X, Integer.valueOf(transitionValues.view.getScrollX()));
        transitionValues.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(transitionValues.view.getScrollY()));
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        viewGroup = null;
        if (transitionValues != null) {
            if (transitionValues2 != null) {
                Animator ofInt;
                View view = transitionValues2.view;
                int intValue = ((Integer) transitionValues.values.get(PROPNAME_SCROLL_X)).intValue();
                int intValue2 = ((Integer) transitionValues2.values.get(PROPNAME_SCROLL_X)).intValue();
                transitionValues = ((Integer) transitionValues.values.get(PROPNAME_SCROLL_Y)).intValue();
                transitionValues2 = ((Integer) transitionValues2.values.get(PROPNAME_SCROLL_Y)).intValue();
                if (intValue != intValue2) {
                    view.setScrollX(intValue);
                    ofInt = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
                } else {
                    ofInt = null;
                }
                if (transitionValues != transitionValues2) {
                    view.setScrollY(transitionValues);
                    viewGroup = ObjectAnimator.ofInt(view, "scrollY", new int[]{transitionValues, transitionValues2});
                }
                return TransitionUtils.mergeAnimators(ofInt, viewGroup);
            }
        }
        return null;
    }
}
