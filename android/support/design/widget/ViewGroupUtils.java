package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

class ViewGroupUtils {
    private static final ThreadLocal<Matrix> sMatrix = new ThreadLocal();
    private static final ThreadLocal<RectF> sRectF = new ThreadLocal();

    ViewGroupUtils() {
    }

    static void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = (Matrix) sMatrix.get();
        if (matrix == null) {
            matrix = new Matrix();
            sMatrix.set(matrix);
        } else {
            matrix.reset();
        }
        offsetDescendantMatrix(viewGroup, view, matrix);
        viewGroup = (RectF) sRectF.get();
        if (viewGroup == null) {
            viewGroup = new RectF();
            sRectF.set(viewGroup);
        }
        viewGroup.set(rect);
        matrix.mapRect(viewGroup);
        rect.set((int) (viewGroup.left + 1056964608), (int) (viewGroup.top + PayBaseConstants.HALF_OF_FLOAT), (int) (viewGroup.right + PayBaseConstants.HALF_OF_FLOAT), (int) (viewGroup.bottom + 1056964608));
    }

    static void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        offsetDescendantRect(viewGroup, view, rect);
    }

    private static void offsetDescendantMatrix(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            offsetDescendantMatrix(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (view.getMatrix().isIdentity() == null) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
