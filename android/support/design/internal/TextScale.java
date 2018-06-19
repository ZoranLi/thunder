package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.ViewGroup;
import android.widget.TextView;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) transitionValues.view).getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView))) {
            if (transitionValues2.view instanceof TextView) {
                final TextView textView = (TextView) transitionValues2.view;
                transitionValues = transitionValues.values;
                transitionValues2 = transitionValues2.values;
                float f = 1.0f;
                transitionValues = transitionValues.get(PROPNAME_SCALE) != null ? ((Float) transitionValues.get(PROPNAME_SCALE)).floatValue() : 1065353216;
                if (transitionValues2.get(PROPNAME_SCALE) != null) {
                    f = ((Float) transitionValues2.get(PROPNAME_SCALE)).floatValue();
                }
                if (transitionValues == f) {
                    return null;
                }
                viewGroup = ValueAnimator.ofFloat(new float[]{transitionValues, f});
                viewGroup.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        valueAnimator = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        textView.setScaleX(valueAnimator);
                        textView.setScaleY(valueAnimator);
                    }
                });
                return viewGroup;
            }
        }
        return null;
    }
}
