package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static int MAX_IMAGE_SIZE = 1048576;
    private Matrix mTempMatrix;

    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
    }

    public void onRejectSharedElements(List<View> list) {
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (drawable != null && background == null) {
                Parcelable createDrawableBitmap = createDrawableBitmap(drawable);
                if (createDrawableBitmap != null) {
                    view = new Bundle();
                    view.putParcelable(BUNDLE_SNAPSHOT_BITMAP, createDrawableBitmap);
                    view.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ScaleType.MATRIX) {
                        rectF = new float[9];
                        imageView.getImageMatrix().getValues(rectF);
                        view.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, rectF);
                    }
                    return view;
                }
            }
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Parcelable parcelable = null;
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, ((float) MAX_IMAGE_SIZE) / ((float) (round * round2)));
            round = (int) (((float) round) * min);
            round2 = (int) (((float) round2) * min);
            if (this.mTempMatrix == null) {
                this.mTempMatrix = new Matrix();
            }
            this.mTempMatrix.set(matrix);
            this.mTempMatrix.postTranslate(-rectF.left, -rectF.top);
            this.mTempMatrix.postScale(min, min);
            parcelable = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
            matrix = new Canvas(parcelable);
            matrix.concat(this.mTempMatrix);
            view.draw(matrix);
        }
        return parcelable;
    }

    private static Bitmap createDrawableBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0) {
            if (intrinsicHeight > 0) {
                float min = Math.min(1.0f, ((float) MAX_IMAGE_SIZE) / ((float) (intrinsicWidth * intrinsicHeight)));
                if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
                    return ((BitmapDrawable) drawable).getBitmap();
                }
                intrinsicWidth = (int) (((float) intrinsicWidth) * min);
                intrinsicHeight = (int) (((float) intrinsicHeight) * min);
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Rect bounds = drawable.getBounds();
                int i = bounds.left;
                int i2 = bounds.top;
                int i3 = bounds.right;
                int i4 = bounds.bottom;
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.draw(canvas);
                drawable.setBounds(i, i2, i3, i4);
                return createBitmap;
            }
        }
        return null;
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        View view = null;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Bitmap bitmap = (Bitmap) bundle.getParcelable(BUNDLE_SNAPSHOT_BITMAP);
            if (bitmap == null) {
                return null;
            }
            view = new ImageView(context);
            view.setImageBitmap(bitmap);
            view.setScaleType(ScaleType.valueOf(bundle.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
            if (view.getScaleType() == ScaleType.MATRIX) {
                context = bundle.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
                parcelable = new Matrix();
                parcelable.setValues(context);
                view.setImageMatrix(parcelable);
            }
        } else if (parcelable instanceof Bitmap) {
            Bitmap bitmap2 = (Bitmap) parcelable;
            view = new ImageView(context);
            view.setImageBitmap(bitmap2);
        }
        return view;
    }

    public void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
        onSharedElementsReadyListener.onSharedElementsReady();
    }
}
