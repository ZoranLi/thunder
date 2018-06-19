package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = new int[]{16843067, 16843068};
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.mView = progressBar;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        attributeSet = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, TINT_ATTRS, i, 0);
        i = attributeSet.getDrawableIfKnown(0);
        if (i != 0) {
            this.mView.setIndeterminateDrawable(tileifyIndeterminate(i));
        }
        i = attributeSet.getDrawableIfKnown(1);
        if (i != 0) {
            this.mView.setProgressDrawable(tileify(i, false));
        }
        attributeSet.recycle();
    }

    private Drawable tileify(Drawable drawable, boolean z) {
        Drawable wrappedDrawable;
        if (drawable instanceof DrawableWrapper) {
            DrawableWrapper drawableWrapper = (DrawableWrapper) drawable;
            wrappedDrawable = drawableWrapper.getWrappedDrawable();
            if (wrappedDrawable != null) {
                drawableWrapper.setWrappedDrawable(tileify(wrappedDrawable, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            z = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[z];
            boolean z2 = false;
            for (boolean z3 = false; z3 < z; z3++) {
                boolean z4;
                int id = layerDrawable.getId(z3);
                Drawable drawable2 = layerDrawable.getDrawable(z3);
                if (id != 16908301) {
                    if (id != 16908303) {
                        z4 = false;
                        drawableArr[z3] = tileify(drawable2, z4);
                    }
                }
                z4 = true;
                drawableArr[z3] = tileify(drawable2, z4);
            }
            wrappedDrawable = new LayerDrawable(drawableArr);
            while (z2 < z) {
                wrappedDrawable.setId(z2, layerDrawable.getId(z2));
                z2++;
            }
            return wrappedDrawable;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, true, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable tileify = tileify(animationDrawable.getFrame(i), true);
            tileify.setLevel(10000);
            animationDrawable2.addFrame(tileify, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap getSampleTime() {
        return this.mSampleTile;
    }
}
