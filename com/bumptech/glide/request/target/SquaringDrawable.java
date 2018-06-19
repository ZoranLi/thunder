package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable extends GlideDrawable {
    private boolean mutated;
    private State state;
    private GlideDrawable wrapped;

    static class State extends ConstantState {
        private final int side;
        private final ConstantState wrapped;

        public int getChangingConfigurations() {
            return 0;
        }

        State(State state) {
            this(state.wrapped, state.side);
        }

        State(ConstantState constantState, int i) {
            this.wrapped = constantState;
            this.side = i;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public Drawable newDrawable(Resources resources) {
            return new SquaringDrawable(this, null, resources);
        }
    }

    public SquaringDrawable(GlideDrawable glideDrawable, int i) {
        this(new State(glideDrawable.getConstantState(), i), glideDrawable, 0);
    }

    SquaringDrawable(State state, GlideDrawable glideDrawable, Resources resources) {
        this.state = state;
        if (glideDrawable != null) {
            this.wrapped = glideDrawable;
        } else if (resources != null) {
            this.wrapped = (GlideDrawable) state.wrapped.newDrawable(resources);
        } else {
            this.wrapped = (GlideDrawable) state.wrapped.newDrawable();
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.wrapped.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.wrapped.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.wrapped.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.wrapped.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.wrapped.setFilterBitmap(z);
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.wrapped.getCallback();
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    public void setColorFilter(int i, Mode mode) {
        this.wrapped.setColorFilter(i, mode);
    }

    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.wrapped.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.state.side;
    }

    public int getIntrinsicHeight() {
        return this.state.side;
    }

    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.wrapped.scheduleSelf(runnable, j);
    }

    public void draw(Canvas canvas) {
        this.wrapped.draw(canvas);
    }

    public void setAlpha(int i) {
        this.wrapped.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    public boolean isAnimated() {
        return this.wrapped.isAnimated();
    }

    public void setLoopCount(int i) {
        this.wrapped.setLoopCount(i);
    }

    public void start() {
        this.wrapped.start();
    }

    public void stop() {
        this.wrapped.stop();
    }

    public boolean isRunning() {
        return this.wrapped.isRunning();
    }

    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = (GlideDrawable) this.wrapped.mutate();
            this.state = new State(this.state);
            this.mutated = true;
        }
        return this;
    }

    public ConstantState getConstantState() {
        return this.state;
    }
}
