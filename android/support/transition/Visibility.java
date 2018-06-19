package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        private VisibilityInfo() {
        }
    }

    private static class DisappearListener extends AnimatorListenerAdapter implements AnimatorPauseListenerCompat, TransitionListener {
        boolean mCanceled = false;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        DisappearListener(View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        public void onAnimationPause(Animator animator) {
            if (this.mCanceled == null) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (this.mCanceled == null) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            suppressLayout(null);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                if (this.mParent != null) {
                    this.mParent.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && this.mParent != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(this.mParent, z);
            }
        }
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.VISIBILITY_TRANSITION);
        attributeSet = TypedArrayUtils.getNamedInt(context, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        context.recycle();
        if (attributeSet != null) {
            setMode(attributeSet);
        }
    }

    public void setMode(int i) {
        if ((i & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }

    public int getMode() {
        return this.mMode;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        Object obj = new int[2];
        transitionValues.view.getLocationOnScreen(obj);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, obj);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.values.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        } else {
            visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        } else {
            visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.mEndVisibility == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
            return visibilityInfo;
        } else {
            if (visibilityInfo.mStartVisibility != visibilityInfo.mEndVisibility) {
                if (visibilityInfo.mStartVisibility == null) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (visibilityInfo.mEndVisibility == null) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        }
        return visibilityInfo;
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange || (visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null)) {
            return null;
        }
        if (visibilityChangeInfo.mFadeIn) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.mStartVisibility, transitionValues2, visibilityChangeInfo.mEndVisibility);
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) == 1) {
            if (transitionValues2 != null) {
                if (transitionValues == null) {
                    View view = (View) transitionValues2.view.getParent();
                    if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).mVisibilityChange != 0) {
                        return null;
                    }
                }
                return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r7, android.support.transition.TransitionValues r8, int r9, android.support.transition.TransitionValues r10, int r11) {
        /*
        r6 = this;
        r9 = r6.mMode;
        r0 = 2;
        r9 = r9 & r0;
        r1 = 0;
        if (r9 == r0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        if (r8 == 0) goto L_0x000d;
    L_0x000a:
        r9 = r8.view;
        goto L_0x000e;
    L_0x000d:
        r9 = r1;
    L_0x000e:
        if (r10 == 0) goto L_0x0013;
    L_0x0010:
        r2 = r10.view;
        goto L_0x0014;
    L_0x0013:
        r2 = r1;
    L_0x0014:
        r3 = 1;
        if (r2 == 0) goto L_0x0026;
    L_0x0017:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r4 = 4;
        if (r11 != r4) goto L_0x0022;
    L_0x0021:
        goto L_0x0024;
    L_0x0022:
        if (r9 != r2) goto L_0x0029;
    L_0x0024:
        r9 = r1;
        goto L_0x0072;
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r9 = r2;
    L_0x0029:
        r2 = r1;
        goto L_0x0072;
    L_0x002b:
        if (r9 == 0) goto L_0x0070;
    L_0x002d:
        r2 = r9.getParent();
        if (r2 == 0) goto L_0x0029;
    L_0x0033:
        r2 = r9.getParent();
        r2 = r2 instanceof android.view.View;
        if (r2 == 0) goto L_0x0070;
    L_0x003b:
        r2 = r9.getParent();
        r2 = (android.view.View) r2;
        r4 = r6.getTransitionValues(r2, r3);
        r5 = r6.getMatchedTransitionValues(r2, r3);
        r4 = r6.getVisibilityChangeInfo(r4, r5);
        r4 = r4.mVisibilityChange;
        if (r4 != 0) goto L_0x0056;
    L_0x0051:
        r9 = android.support.transition.TransitionUtils.copyViewImage(r7, r9, r2);
        goto L_0x0029;
    L_0x0056:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x006e;
    L_0x005c:
        r2 = r2.getId();
        r4 = -1;
        if (r2 == r4) goto L_0x006e;
    L_0x0063:
        r2 = r7.findViewById(r2);
        if (r2 == 0) goto L_0x006e;
    L_0x0069:
        r2 = r6.mCanRemoveViews;
        if (r2 == 0) goto L_0x006e;
    L_0x006d:
        goto L_0x0029;
    L_0x006e:
        r9 = r1;
        goto L_0x0029;
    L_0x0070:
        r9 = r1;
        r2 = r9;
    L_0x0072:
        r4 = 0;
        if (r9 == 0) goto L_0x00ba;
    L_0x0075:
        if (r8 == 0) goto L_0x00ba;
    L_0x0077:
        r11 = r8.values;
        r1 = "android:visibility:screenLocation";
        r11 = r11.get(r1);
        r11 = (int[]) r11;
        r1 = r11[r4];
        r11 = r11[r3];
        r0 = new int[r0];
        r7.getLocationOnScreen(r0);
        r2 = r0[r4];
        r1 = r1 - r2;
        r2 = r9.getLeft();
        r1 = r1 - r2;
        r9.offsetLeftAndRight(r1);
        r0 = r0[r3];
        r11 = r11 - r0;
        r0 = r9.getTop();
        r11 = r11 - r0;
        r9.offsetTopAndBottom(r11);
        r11 = android.support.transition.ViewGroupUtils.getOverlay(r7);
        r11.add(r9);
        r7 = r6.onDisappear(r7, r9, r8, r10);
        if (r7 != 0) goto L_0x00b1;
    L_0x00ad:
        r11.remove(r9);
        goto L_0x00b9;
    L_0x00b1:
        r8 = new android.support.transition.Visibility$1;
        r8.<init>(r11, r9);
        r7.addListener(r8);
    L_0x00b9:
        return r7;
    L_0x00ba:
        if (r2 == 0) goto L_0x00dc;
    L_0x00bc:
        r9 = r2.getVisibility();
        android.support.transition.ViewUtils.setTransitionVisibility(r2, r4);
        r7 = r6.onDisappear(r7, r2, r8, r10);
        if (r7 == 0) goto L_0x00d8;
    L_0x00c9:
        r8 = new android.support.transition.Visibility$DisappearListener;
        r8.<init>(r2, r11, r3);
        r7.addListener(r8);
        android.support.transition.AnimatorUtils.addPauseListener(r7, r8);
        r6.addListener(r8);
        goto L_0x00db;
    L_0x00d8:
        android.support.transition.ViewUtils.setTransitionVisibility(r2, r9);
    L_0x00db:
        return r7;
    L_0x00dc:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Visibility.onDisappear(android.view.ViewGroup, android.support.transition.TransitionValues, int, android.support.transition.TransitionValues, int):android.animation.Animator");
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(PROPNAME_VISIBILITY) != transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        transitionValues = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (transitionValues.mVisibilityChange == null || (transitionValues.mStartVisibility != null && transitionValues.mEndVisibility != null)) {
            return false;
        }
        return true;
    }
}
