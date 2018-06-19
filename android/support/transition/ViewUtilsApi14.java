package android.support.transition;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@RequiresApi(14)
class ViewUtilsApi14 implements ViewUtilsImpl {
    private float[] mMatrixValues;

    ViewUtilsApi14() {
    }

    public ViewOverlayImpl getOverlay(@NonNull View view) {
        return ViewOverlayApi14.createFrom(view);
    }

    public WindowIdImpl getWindowId(@NonNull View view) {
        return new WindowIdApi14(view.getWindowToken());
    }

    public void setTransitionAlpha(@NonNull View view, float f) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        Float f = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToGlobal(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            matrix.preConcat(view);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToLocal(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            Matrix matrix2 = new Matrix();
            if (view.invert(matrix2) != null) {
                matrix.postConcat(matrix2);
            }
        }
    }

    public void setAnimationMatrix(@NonNull View view, Matrix matrix) {
        if (matrix != null) {
            if (!matrix.isIdentity()) {
                float[] fArr = this.mMatrixValues;
                if (fArr == null) {
                    fArr = new float[9];
                    this.mMatrixValues = fArr;
                }
                matrix.getValues(fArr);
                matrix = fArr[3];
                float sqrt = ((float) Math.sqrt((double) (1.0f - (matrix * matrix)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
                matrix = (float) Math.toDegrees(Math.atan2((double) matrix, (double) sqrt));
                float f = fArr[0] / sqrt;
                float f2 = fArr[4] / sqrt;
                float f3 = fArr[2];
                sqrt = fArr[5];
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                view.setTranslationX(f3);
                view.setTranslationY(sqrt);
                view.setRotation(matrix);
                view.setScaleX(f);
                view.setScaleY(f2);
                return;
            }
        }
        view.setPivotX((float) (view.getWidth() / 2));
        view.setPivotY((float) (view.getHeight() / 2));
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
    }

    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
