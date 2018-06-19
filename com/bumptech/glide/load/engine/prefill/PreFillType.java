package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;

public final class PreFillType {
    static final Config DEFAULT_CONFIG = Config.RGB_565;
    private final Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i) {
            this(i, i);
        }

        public Builder(int i, int i2) {
            this.weight = 1;
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            } else {
                this.width = i;
                this.height = i2;
            }
        }

        public Builder setConfig(Config config) {
            this.config = config;
            return this;
        }

        Config getConfig() {
            return this.config;
        }

        public Builder setWeight(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = i;
            return this;
        }

        PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
    }

    PreFillType(int i, int i2, Config config, int i3) {
        if (config == null) {
            throw new NullPointerException("Config must not be null");
        }
        this.width = i;
        this.height = i2;
        this.config = config;
        this.weight = i3;
    }

    final int getWidth() {
        return this.width;
    }

    final int getHeight() {
        return this.height;
    }

    final Config getConfig() {
        return this.config;
    }

    final int getWeight() {
        return this.weight;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (31 * ((((this.width * 31) + this.height) * 31) + this.config.hashCode())) + this.weight;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PreFillSize{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", config=");
        stringBuilder.append(this.config);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
