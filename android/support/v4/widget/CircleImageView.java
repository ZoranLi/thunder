package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private AnimationListener mListener;
    int mShadowRadius;

    private class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();

        OvalShadow(int i) {
            CircleImageView.this.mShadowRadius = i;
            updateRadialGradient((int) rect().width());
        }

        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            updateRadialGradient((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.mShadowPaint);
            canvas.drawCircle(f, height, (float) (width - CircleImageView.this.mShadowRadius), paint);
        }

        private void updateRadialGradient(int i) {
            float f = (float) (i / 2);
            this.mRadialGradient = new RadialGradient(f, f, (float) CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, TileMode.CLAMP);
            this.mShadowPaint.setShader(this.mRadialGradient);
        }
    }

    CircleImageView(Context context, int i) {
        Drawable shapeDrawable;
        super(context);
        context = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (Y_OFFSET * context);
        int i3 = (int) (0.0f * context);
        this.mShadowRadius = (int) (SHADOW_RADIUS * context);
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, 4.0f * context);
        } else {
            Drawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this.mShadowRadius));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.mShadowRadius, (float) i3, (float) i2, KEY_SHADOW_COLOR);
            context = this.mShadowRadius;
            setPadding(context, context, context, context);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (elevationSupported() == 0) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.mListener != null) {
            this.mListener.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.mListener != null) {
            this.mListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
