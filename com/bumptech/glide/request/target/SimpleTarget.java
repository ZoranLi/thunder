package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(this.width);
        stringBuilder.append(" and height: ");
        stringBuilder.append(this.height);
        stringBuilder.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
