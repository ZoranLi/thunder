package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        FadeAnimatorListener(View view) {
            this.mView = view;
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.mView) != null && this.mView.getLayerType() == null) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged != null) {
                this.mView.setLayerType(0, null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(context, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        context.recycle();
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha(transitionValues.view)));
    }

    private Animator createAnimation(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.setTransitionAlpha(view, f);
        f = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, new float[]{f2});
        f.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(@NonNull Transition transition) {
                ViewUtils.setTransitionAlpha(view, 1.0f);
                ViewUtils.clearNonTransitionAlpha(view);
                transition.removeListener(this);
            }
        });
        return f;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        viewGroup = null;
        transitionValues = getStartAlpha(transitionValues, 0.0f);
        if (transitionValues != 1065353216) {
            viewGroup = transitionValues;
        }
        return createAnimation(view, viewGroup, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha(view);
        return createAnimation(view, getStartAlpha(transitionValues, 1.0f), null);
    }

    private static float getStartAlpha(TransitionValues transitionValues, float f) {
        if (transitionValues == null) {
            return f;
        }
        Float f2 = (Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA);
        return f2 != null ? f2.floatValue() : f;
    }
}
