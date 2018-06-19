package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;

class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() {
        final void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public final void set(Matrix matrix) {
            oops();
        }

        public final void reset() {
            oops();
        }

        public final void setTranslate(float f, float f2) {
            oops();
        }

        public final void setScale(float f, float f2, float f3, float f4) {
            oops();
        }

        public final void setScale(float f, float f2) {
            oops();
        }

        public final void setRotate(float f, float f2, float f3) {
            oops();
        }

        public final void setRotate(float f) {
            oops();
        }

        public final void setSinCos(float f, float f2, float f3, float f4) {
            oops();
        }

        public final void setSinCos(float f, float f2) {
            oops();
        }

        public final void setSkew(float f, float f2, float f3, float f4) {
            oops();
        }

        public final void setSkew(float f, float f2) {
            oops();
        }

        public final boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return null;
        }

        public final boolean preTranslate(float f, float f2) {
            oops();
            return false;
        }

        public final boolean preScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public final boolean preScale(float f, float f2) {
            oops();
            return false;
        }

        public final boolean preRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        public final boolean preRotate(float f) {
            oops();
            return false;
        }

        public final boolean preSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public final boolean preSkew(float f, float f2) {
            oops();
            return false;
        }

        public final boolean preConcat(Matrix matrix) {
            oops();
            return null;
        }

        public final boolean postTranslate(float f, float f2) {
            oops();
            return false;
        }

        public final boolean postScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public final boolean postScale(float f, float f2) {
            oops();
            return false;
        }

        public final boolean postRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        public final boolean postRotate(float f) {
            oops();
            return false;
        }

        public final boolean postSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public final boolean postSkew(float f, float f2) {
            oops();
            return false;
        }

        public final boolean postConcat(Matrix matrix) {
            oops();
            return null;
        }

        public final boolean setRectToRect(RectF rectF, RectF rectF2, ScaleToFit scaleToFit) {
            oops();
            return null;
        }

        public final boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            return null;
        }

        public final void setValues(float[] fArr) {
            oops();
        }
    };

    MatrixUtils() {
    }
}
