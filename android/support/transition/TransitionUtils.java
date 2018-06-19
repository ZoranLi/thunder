package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class TransitionUtils {
    private static final int MAX_IMAGE_SIZE = 1048576;

    static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] mTempEndValues = new float[9];
        final Matrix mTempMatrix = new Matrix();
        final float[] mTempStartValues = new float[9];

        MatrixEvaluator() {
        }

        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (matrix = null; matrix < 9; matrix++) {
                this.mTempEndValues[matrix] = this.mTempStartValues[matrix] + ((this.mTempEndValues[matrix] - this.mTempStartValues[matrix]) * f);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    TransitionUtils() {
    }

    static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        viewGroup = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(viewGroup);
        view2 = Math.round(viewGroup.left);
        int round = Math.round(viewGroup.top);
        int round2 = Math.round(viewGroup.right);
        int round3 = Math.round(viewGroup.bottom);
        View imageView = new ImageView(view.getContext());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        viewGroup = createViewBitmap(view, matrix, viewGroup);
        if (viewGroup != null) {
            imageView.setImageBitmap(viewGroup);
        }
        imageView.measure(MeasureSpec.makeMeasureSpec(round2 - view2, 1073741824), MeasureSpec.makeMeasureSpec(round3 - round, 1073741824));
        imageView.layout(view2, round, round2, round3);
        return imageView;
    }

    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF) {
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
        round = (int) (((float) round) * min);
        round2 = (int) (((float) round2) * min);
        matrix.postTranslate(-rectF.left, -rectF.top);
        matrix.postScale(min, min);
        rectF = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
        Canvas canvas = new Canvas(rectF);
        canvas.concat(matrix);
        view.draw(canvas);
        return rectF;
    }

    static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
