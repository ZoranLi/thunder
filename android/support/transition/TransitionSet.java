package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition.EpicenterCallback;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mCurrentListeners;
    private boolean mPlayTogether = true;
    private boolean mStarted = false;
    private ArrayList<Transition> mTransitions = new ArrayList();

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        public void onTransitionStart(@NonNull Transition transition) {
            if (this.mTransitionSet.mStarted == null) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet.access$106(this.mTransitionSet);
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transition.removeListener(this);
        }
    }

    static /* synthetic */ int access$106(TransitionSet transitionSet) {
        int i = transitionSet.mCurrentListeners - 1;
        transitionSet.mCurrentListeners = i;
        return i;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(context, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        context.recycle();
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
        switch (i) {
            case 0:
                this.mPlayTogether = true;
                break;
            case 1:
                this.mPlayTogether = false;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder("Invalid parameter for TransitionSet ordering: ");
                stringBuilder.append(i);
                throw new AndroidRuntimeException(stringBuilder.toString());
        }
        return this;
    }

    public int getOrdering() {
        return this.mPlayTogether ? 0 : 1;
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        return this;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public Transition getTransitionAt(int i) {
        if (i >= 0) {
            if (i < this.mTransitions.size()) {
                return (Transition) this.mTransitions.get(i);
            }
        }
        return 0;
    }

    @NonNull
    public TransitionSet setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.mTransitions.get(i)).setDuration(j);
            }
        }
        return this;
    }

    @NonNull
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @NonNull
    public TransitionSet addTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            ((Transition) this.mTransitions.get(i2)).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull Class cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @NonNull
    public TransitionSet addListener(@NonNull TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @NonNull
    public TransitionSet removeTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            ((Transition) this.mTransitions.get(i2)).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull Class cls) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.mTransitions.size(); i2++) {
            ((Transition) this.mTransitions.get(i2)).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class cls, boolean z) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @NonNull
    public TransitionSet removeListener(@NonNull TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).setPathMotion(pathMotion);
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    private void setupStartEndListeners() {
        TransitionListener transitionSetListener = new TransitionSetListener(this);
        Iterator it = this.mTransitions.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        int i = 0;
        while (i < size) {
            Transition transition = (Transition) r0.mTransitions.get(i);
            if (startDelay > 0 && (r0.mPlayTogether || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay + startDelay2);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            i++;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).runAnimators();
            }
            return;
        }
        for (int i = 1; i < this.mTransitions.size(); i++) {
            final Transition transition = (Transition) this.mTransitions.get(i);
            ((Transition) this.mTransitions.get(i - 1)).addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(@NonNull Transition transition) {
                    transition.runAnimators();
                    transition.removeListener(this);
                }
            });
        }
        Transition transition2 = (Transition) this.mTransitions.get(0);
        if (transition2 != null) {
            transition2.runAnimators();
        }
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.isValidTarget(transitionValues.view)) {
                    transition.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.isValidTarget(transitionValues.view)) {
                    transition.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).capturePropagationValues(transitionValues);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).pause(view);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).resume(view);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    protected void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).cancel();
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).forceToEnd(viewGroup);
        }
    }

    TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setSceneRoot(viewGroup);
        }
        return this;
    }

    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setCanRemoveViews(z);
        }
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setEpicenterCallback(epicenterCallback);
        }
    }

    String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(transition);
            stringBuilder.append("\n");
            Transition transition2 = (Transition) this.mTransitions.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("  ");
            stringBuilder.append(transition2.toString(stringBuilder2.toString()));
            transition = stringBuilder.toString();
        }
        return transition;
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.mTransitions = new ArrayList();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSet.addTransition(((Transition) this.mTransitions.get(i)).clone());
        }
        return transitionSet;
    }
}
