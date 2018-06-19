package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final Property<PathAnimatorMatrix, float[]> NON_TRANSLATIONS_PROPERTY = new AnonymousClass1(float[].class, "nonTranslations");
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    private static final Property<PathAnimatorMatrix, PointF> TRANSLATIONS_PROPERTY = new AnonymousClass2(PointF.class, "translations");
    private static final String[] sTransitionProperties;
    private boolean mReparent = true;
    private Matrix mTempMatrix = new Matrix();
    private boolean mUseOverlay = true;

    final class AnonymousClass1 extends Property<PathAnimatorMatrix, float[]> {
        public final float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        public final void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.setValues(fArr);
        }
    }

    final class AnonymousClass2 extends Property<PathAnimatorMatrix, PointF> {
        public final PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        public final void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.setTranslation(pointF);
        }
    }

    private static class PathAnimatorMatrix {
        private final Matrix mMatrix = new Matrix();
        private float mTranslationX;
        private float mTranslationY;
        private final float[] mValues;
        private final View mView;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.mView = view;
            this.mValues = (float[]) fArr.clone();
            this.mTranslationX = this.mValues[2];
            this.mTranslationY = this.mValues[5];
            setAnimationMatrix();
        }

        void setValues(float[] fArr) {
            System.arraycopy(fArr, 0, this.mValues, 0, fArr.length);
            setAnimationMatrix();
        }

        void setTranslation(PointF pointF) {
            this.mTranslationX = pointF.x;
            this.mTranslationY = pointF.y;
            setAnimationMatrix();
        }

        private void setAnimationMatrix() {
            this.mValues[2] = this.mTranslationX;
            this.mValues[5] = this.mTranslationY;
            this.mMatrix.setValues(this.mValues);
            ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
        }

        Matrix getMatrix() {
            return this.mMatrix;
        }
    }

    private static class Transforms {
        final float mRotationX;
        final float mRotationY;
        final float mRotationZ;
        final float mScaleX;
        final float mScaleY;
        final float mTranslationX;
        final float mTranslationY;
        final float mTranslationZ;

        Transforms(View view) {
            this.mTranslationX = view.getTranslationX();
            this.mTranslationY = view.getTranslationY();
            this.mTranslationZ = ViewCompat.getTranslationZ(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.mRotationX = view.getRotationX();
            this.mRotationY = view.getRotationY();
            this.mRotationZ = view.getRotation();
        }

        public void restore(View view) {
            ChangeTransform.setTransforms(view, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            if (transforms.mTranslationX == this.mTranslationX && transforms.mTranslationY == this.mTranslationY && transforms.mTranslationZ == this.mTranslationZ && transforms.mScaleX == this.mScaleX && transforms.mScaleY == this.mScaleY && transforms.mRotationX == this.mRotationX && transforms.mRotationY == this.mRotationY && transforms.mRotationZ == this.mRotationZ) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int floatToIntBits = 31 * (((((((((((((this.mTranslationX != 0.0f ? Float.floatToIntBits(this.mTranslationX) : 0) * 31) + (this.mTranslationY != 0.0f ? Float.floatToIntBits(this.mTranslationY) : 0)) * 31) + (this.mTranslationZ != 0.0f ? Float.floatToIntBits(this.mTranslationZ) : 0)) * 31) + (this.mScaleX != 0.0f ? Float.floatToIntBits(this.mScaleX) : 0)) * 31) + (this.mScaleY != 0.0f ? Float.floatToIntBits(this.mScaleY) : 0)) * 31) + (this.mRotationX != 0.0f ? Float.floatToIntBits(this.mRotationX) : 0)) * 31) + (this.mRotationY != 0.0f ? Float.floatToIntBits(this.mRotationY) : 0));
            if (this.mRotationZ != 0.0f) {
                i = Float.floatToIntBits(this.mRotationZ);
            }
            return floatToIntBits + i;
        }
    }

    private static class GhostListener extends TransitionListenerAdapter {
        private GhostViewImpl mGhostView;
        private View mView;

        GhostListener(View view, GhostViewImpl ghostViewImpl) {
            this.mView = view;
            this.mGhostView = ghostViewImpl;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.removeGhost(this.mView);
            this.mView.setTag(R.id.transition_transform, null);
            this.mView.setTag(R.id.parent_matrix, null);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            this.mGhostView.setVisibility(4);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            this.mGhostView.setVisibility(0);
        }
    }

    static {
        r0 = new String[3];
        boolean z = false;
        r0[0] = PROPNAME_MATRIX;
        r0[1] = PROPNAME_TRANSFORMS;
        r0[2] = PROPNAME_PARENT_MATRIX;
        sTransitionProperties = r0;
        if (VERSION.SDK_INT >= 21) {
            z = true;
        }
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = z;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_TRANSFORM);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.mUseOverlay = TypedArrayUtils.getNamedBoolean(context, xmlPullParser, "reparentWithOverlay", 1, true);
        this.mReparent = TypedArrayUtils.getNamedBoolean(context, xmlPullParser, "reparent", 0, true);
        context.recycle();
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public void setReparentWithOverlay(boolean z) {
        this.mUseOverlay = z;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public void setReparent(boolean z) {
        this.mReparent = z;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            Object matrix;
            ViewGroup viewGroup;
            transitionValues.values.put(PROPNAME_PARENT, view.getParent());
            transitionValues.values.put(PROPNAME_TRANSFORMS, new Transforms(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 != null) {
                if (!matrix2.isIdentity()) {
                    matrix = new Matrix(matrix2);
                    transitionValues.values.put(PROPNAME_MATRIX, matrix);
                    if (this.mReparent) {
                        matrix2 = new Matrix();
                        viewGroup = (ViewGroup) view.getParent();
                        ViewUtils.transformMatrixToGlobal(viewGroup, matrix2);
                        matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                        transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
                        transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
                        transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
                    }
                }
            }
            matrix = null;
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
            if (this.mReparent) {
                matrix2 = new Matrix();
                viewGroup = (ViewGroup) view.getParent();
                ViewUtils.transformMatrixToGlobal(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix2);
                transitionValues.values.put(PROPNAME_INTERMEDIATE_MATRIX, view.getTag(R.id.transition_transform));
                transitionValues.values.put(PROPNAME_INTERMEDIATE_PARENT_MATRIX, view.getTag(R.id.parent_matrix));
            }
        }
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!SUPPORTS_VIEW_REMOVAL_SUPPRESSION) {
            ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(PROPNAME_PARENT))) {
            if (transitionValues2.values.containsKey(PROPNAME_PARENT)) {
                ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
                boolean z = this.mReparent && !parentsMatch(viewGroup2, (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT));
                Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_MATRIX);
                if (matrix != null) {
                    transitionValues.values.put(PROPNAME_MATRIX, matrix);
                }
                matrix = (Matrix) transitionValues.values.get(PROPNAME_INTERMEDIATE_PARENT_MATRIX);
                if (matrix != null) {
                    transitionValues.values.put(PROPNAME_PARENT_MATRIX, matrix);
                }
                if (z) {
                    setMatricesForParent(transitionValues, transitionValues2);
                }
                Animator createTransformAnimator = createTransformAnimator(transitionValues, transitionValues2, z);
                if (z && createTransformAnimator != null && this.mUseOverlay) {
                    createGhostView(viewGroup, transitionValues, transitionValues2);
                } else if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION == null) {
                    viewGroup2.endViewTransition(transitionValues.view);
                }
                return createTransformAnimator;
            }
        }
        return null;
    }

    private ObjectAnimator createTransformAnimator(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z) {
        transitionValues = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (transitionValues == null) {
            transitionValues = MatrixUtils.IDENTITY_MATRIX;
        }
        if (matrix == null) {
            matrix = MatrixUtils.IDENTITY_MATRIX;
        }
        final Matrix matrix2 = matrix;
        if (transitionValues.equals(matrix2)) {
            return null;
        }
        final Transforms transforms = (Transforms) transitionValues2.values.get(PROPNAME_TRANSFORMS);
        final View view = transitionValues2.view;
        setIdentityTransforms(view);
        r0 = new float[9];
        transitionValues.getValues(r0);
        transitionValues = new float[9];
        matrix2.getValues(transitionValues);
        final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, r0);
        PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(NON_TRANSLATIONS_PROPERTY, new FloatArrayEvaluator(new float[9]), new float[][]{r0, transitionValues});
        transitionValues = PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, getPathMotion().getPath(r0[2], r0[5], transitionValues[2], transitionValues[5]));
        transitionValues = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, new PropertyValuesHolder[]{ofObject, transitionValues});
        final boolean z2 = z;
        TransitionValues anonymousClass3 = new AnimatorListenerAdapter() {
            private boolean mIsCanceled;
            private Matrix mTempMatrix = new Matrix();

            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (this.mIsCanceled == null) {
                    if (z2 == null || ChangeTransform.this.mUseOverlay == null) {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    } else {
                        setCurrentMatrix(matrix2);
                    }
                }
                ViewUtils.setAnimationMatrix(view, null);
                transforms.restore(view);
            }

            public void onAnimationPause(Animator animator) {
                setCurrentMatrix(pathAnimatorMatrix.getMatrix());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.setIdentityTransforms(view);
            }

            private void setCurrentMatrix(Matrix matrix) {
                this.mTempMatrix.set(matrix);
                view.setTag(R.id.transition_transform, this.mTempMatrix);
                transforms.restore(view);
            }
        };
        transitionValues.addListener(anonymousClass3);
        AnimatorUtils.addPauseListener(transitionValues, anonymousClass3);
        return transitionValues;
    }

    private boolean parentsMatch(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (isValidTarget(viewGroup)) {
            if (isValidTarget(viewGroup2)) {
                viewGroup = getMatchedTransitionValues(viewGroup, true);
                if (viewGroup == null || viewGroup2 != viewGroup.view) {
                    return false;
                }
                return true;
            }
        }
        if (viewGroup == viewGroup2) {
            return true;
        }
        return false;
    }

    private void createGhostView(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX));
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        viewGroup = GhostViewUtils.addGhost(view, viewGroup, matrix);
        if (viewGroup != null) {
            viewGroup.reserveEndViewTransition((ViewGroup) transitionValues.values.get(PROPNAME_PARENT), transitionValues.view);
            Transition transition = this;
            while (transition.mParent != null) {
                transition = transition.mParent;
            }
            transition.addListener(new GhostListener(view, viewGroup));
            if (SUPPORTS_VIEW_REMOVAL_SUPPRESSION != null) {
                if (transitionValues.view != transitionValues2.view) {
                    ViewUtils.setTransitionAlpha(transitionValues.view, null);
                }
                ViewUtils.setTransitionAlpha(view, 1.0f);
            }
        }
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        transitionValues2.view.setTag(R.id.parent_matrix, matrix);
        transitionValues2 = this.mTempMatrix;
        transitionValues2.reset();
        matrix.invert(transitionValues2);
        matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        if (matrix == null) {
            matrix = new Matrix();
            transitionValues.values.put(PROPNAME_MATRIX, matrix);
        }
        matrix.postConcat((Matrix) transitionValues.values.get(PROPNAME_PARENT_MATRIX));
        matrix.postConcat(transitionValues2);
    }

    private static void setIdentityTransforms(View view) {
        setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private static void setTransforms(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.setTranslationZ(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }
}
