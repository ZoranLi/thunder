package android.support.v7.graphics;

import android.support.annotation.FloatRange;

public final class Target {
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    static final int INDEX_MAX = 2;
    static final int INDEX_MIN = 0;
    static final int INDEX_TARGET = 1;
    static final int INDEX_WEIGHT_LUMA = 1;
    static final int INDEX_WEIGHT_POP = 2;
    static final int INDEX_WEIGHT_SAT = 0;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT;
    private static final float MAX_DARK_LUMA = 0.45f;
    private static final float MAX_MUTED_SATURATION = 0.4f;
    private static final float MAX_NORMAL_LUMA = 0.7f;
    private static final float MIN_LIGHT_LUMA = 0.55f;
    private static final float MIN_NORMAL_LUMA = 0.3f;
    private static final float MIN_VIBRANT_SATURATION = 0.35f;
    public static final Target MUTED;
    private static final float TARGET_DARK_LUMA = 0.26f;
    private static final float TARGET_LIGHT_LUMA = 0.74f;
    private static final float TARGET_MUTED_SATURATION = 0.3f;
    private static final float TARGET_NORMAL_LUMA = 0.5f;
    private static final float TARGET_VIBRANT_SATURATION = 1.0f;
    public static final Target VIBRANT;
    private static final float WEIGHT_LUMA = 0.52f;
    private static final float WEIGHT_POPULATION = 0.24f;
    private static final float WEIGHT_SATURATION = 0.24f;
    boolean mIsExclusive;
    final float[] mLightnessTargets;
    final float[] mSaturationTargets;
    final float[] mWeights;

    public static final class Builder {
        private final Target mTarget;

        public Builder() {
            this.mTarget = new Target();
        }

        public Builder(Target target) {
            this.mTarget = new Target(target);
        }

        public final Builder setMinimumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[0] = f;
            return this;
        }

        public final Builder setTargetSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[1] = f;
            return this;
        }

        public final Builder setMaximumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mSaturationTargets[2] = f;
            return this;
        }

        public final Builder setMinimumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[0] = f;
            return this;
        }

        public final Builder setTargetLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[1] = f;
            return this;
        }

        public final Builder setMaximumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.mTarget.mLightnessTargets[2] = f;
            return this;
        }

        public final Builder setSaturationWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[0] = f;
            return this;
        }

        public final Builder setLightnessWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[1] = f;
            return this;
        }

        public final Builder setPopulationWeight(@FloatRange(from = 0.0d) float f) {
            this.mTarget.mWeights[2] = f;
            return this;
        }

        public final Builder setExclusive(boolean z) {
            this.mTarget.mIsExclusive = z;
            return this;
        }

        public final Target build() {
            return this.mTarget;
        }
    }

    static {
        Target target = new Target();
        LIGHT_VIBRANT = target;
        setDefaultLightLightnessValues(target);
        setDefaultVibrantSaturationValues(LIGHT_VIBRANT);
        target = new Target();
        VIBRANT = target;
        setDefaultNormalLightnessValues(target);
        setDefaultVibrantSaturationValues(VIBRANT);
        target = new Target();
        DARK_VIBRANT = target;
        setDefaultDarkLightnessValues(target);
        setDefaultVibrantSaturationValues(DARK_VIBRANT);
        target = new Target();
        LIGHT_MUTED = target;
        setDefaultLightLightnessValues(target);
        setDefaultMutedSaturationValues(LIGHT_MUTED);
        target = new Target();
        MUTED = target;
        setDefaultNormalLightnessValues(target);
        setDefaultMutedSaturationValues(MUTED);
        target = new Target();
        DARK_MUTED = target;
        setDefaultDarkLightnessValues(target);
        setDefaultMutedSaturationValues(DARK_MUTED);
    }

    Target() {
        this.mSaturationTargets = new float[3];
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        setTargetDefaultValues(this.mSaturationTargets);
        setTargetDefaultValues(this.mLightnessTargets);
        setDefaultWeights();
    }

    Target(Target target) {
        this.mSaturationTargets = new float[3];
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        System.arraycopy(target.mSaturationTargets, 0, this.mSaturationTargets, 0, this.mSaturationTargets.length);
        System.arraycopy(target.mLightnessTargets, 0, this.mLightnessTargets, 0, this.mLightnessTargets.length);
        System.arraycopy(target.mWeights, 0, this.mWeights, 0, this.mWeights.length);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getMinimumSaturation() {
        return this.mSaturationTargets[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getTargetSaturation() {
        return this.mSaturationTargets[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getMaximumSaturation() {
        return this.mSaturationTargets[2];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getMinimumLightness() {
        return this.mLightnessTargets[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getTargetLightness() {
        return this.mLightnessTargets[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getMaximumLightness() {
        return this.mLightnessTargets[2];
    }

    public final float getSaturationWeight() {
        return this.mWeights[0];
    }

    public final float getLightnessWeight() {
        return this.mWeights[1];
    }

    public final float getPopulationWeight() {
        return this.mWeights[2];
    }

    public final boolean isExclusive() {
        return this.mIsExclusive;
    }

    private static void setTargetDefaultValues(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = TARGET_VIBRANT_SATURATION;
    }

    private void setDefaultWeights() {
        this.mWeights[0] = 0.24f;
        this.mWeights[1] = WEIGHT_LUMA;
        this.mWeights[2] = 0.24f;
    }

    final void normalizeWeights() {
        int length;
        int i = 0;
        float f = 0.0f;
        for (float f2 : this.mWeights) {
            if (f2 > 0.0f) {
                f += f2;
            }
        }
        if (f != 0.0f) {
            length = this.mWeights.length;
            while (i < length) {
                if (this.mWeights[i] > 0.0f) {
                    float[] fArr = this.mWeights;
                    fArr[i] = fArr[i] / f;
                }
                i++;
            }
        }
    }

    private static void setDefaultDarkLightnessValues(Target target) {
        target.mLightnessTargets[1] = TARGET_DARK_LUMA;
        target.mLightnessTargets[2] = 1055286886;
    }

    private static void setDefaultNormalLightnessValues(Target target) {
        target.mLightnessTargets[0] = 0.3f;
        target.mLightnessTargets[1] = 0.5f;
        target.mLightnessTargets[2] = 1060320051;
    }

    private static void setDefaultLightLightnessValues(Target target) {
        target.mLightnessTargets[0] = MIN_LIGHT_LUMA;
        target.mLightnessTargets[1] = 1060991140;
    }

    private static void setDefaultVibrantSaturationValues(Target target) {
        target.mSaturationTargets[0] = MIN_VIBRANT_SATURATION;
        target.mSaturationTargets[1] = 1065353216;
    }

    private static void setDefaultMutedSaturationValues(Target target) {
        target.mSaturationTargets[1] = 0.3f;
        target.mSaturationTargets[2] = 1053609165;
    }
}
