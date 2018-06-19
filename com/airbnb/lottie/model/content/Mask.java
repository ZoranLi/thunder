package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.h;

public final class Mask {
    public final MaskMode a;
    public final h b;
    public final d c;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect,
        MaskModeUnknown
    }

    private Mask(MaskMode maskMode, h hVar, d dVar) {
        this.a = maskMode;
        this.b = hVar;
        this.c = dVar;
    }
}
