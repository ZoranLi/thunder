package android.support.v7.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.util.ArrayMap;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Palette {
    static final int DEFAULT_CALCULATE_NUMBER_COLORS = 16;
    static final Filter DEFAULT_FILTER = new Filter() {
        private static final float BLACK_MAX_LIGHTNESS = 0.05f;
        private static final float WHITE_MIN_LIGHTNESS = 0.95f;

        public final boolean isAllowed(int i, float[] fArr) {
            return isWhite(fArr) == 0 && isBlack(fArr) == 0 && isNearRedILine(fArr) == 0;
        }

        private boolean isBlack(float[] fArr) {
            return fArr[2] <= BLACK_MAX_LIGHTNESS ? 1 : null;
        }

        private boolean isWhite(float[] fArr) {
            return fArr[2] >= WHITE_MIN_LIGHTNESS ? 1 : null;
        }

        private boolean isNearRedILine(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }
    };
    static final int DEFAULT_RESIZE_BITMAP_AREA = 12544;
    static final String LOG_TAG = "Palette";
    static final boolean LOG_TIMINGS = false;
    static final float MIN_CONTRAST_BODY_TEXT = 4.5f;
    static final float MIN_CONTRAST_TITLE_TEXT = 3.0f;
    private final Swatch mDominantSwatch = findDominantSwatch();
    private final Map<Target, Swatch> mSelectedSwatches = new ArrayMap();
    private final List<Swatch> mSwatches;
    private final List<Target> mTargets;
    private final SparseBooleanArray mUsedColors = new SparseBooleanArray();

    public static final class Builder {
        private final Bitmap mBitmap;
        private final List<Filter> mFilters = new ArrayList();
        private int mMaxColors = 16;
        private Rect mRegion;
        private int mResizeArea = Palette.DEFAULT_RESIZE_BITMAP_AREA;
        private int mResizeMaxDimension = -1;
        private final List<Swatch> mSwatches;
        private final List<Target> mTargets = new ArrayList();

        public Builder(Bitmap bitmap) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.mFilters.add(Palette.DEFAULT_FILTER);
                    this.mBitmap = bitmap;
                    this.mSwatches = null;
                    this.mTargets.add(Target.LIGHT_VIBRANT);
                    this.mTargets.add(Target.VIBRANT);
                    this.mTargets.add(Target.DARK_VIBRANT);
                    this.mTargets.add(Target.LIGHT_MUTED);
                    this.mTargets.add(Target.MUTED);
                    this.mTargets.add(Target.DARK_MUTED);
                    return;
                }
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        public Builder(List<Swatch> list) {
            if (list != null) {
                if (!list.isEmpty()) {
                    this.mFilters.add(Palette.DEFAULT_FILTER);
                    this.mSwatches = list;
                    this.mBitmap = null;
                    return;
                }
            }
            throw new IllegalArgumentException("List of Swatches is not valid");
        }

        @NonNull
        public final Builder maximumColorCount(int i) {
            this.mMaxColors = i;
            return this;
        }

        @Deprecated
        @NonNull
        public final Builder resizeBitmapSize(int i) {
            this.mResizeMaxDimension = i;
            this.mResizeArea = -1;
            return this;
        }

        @NonNull
        public final Builder resizeBitmapArea(int i) {
            this.mResizeArea = i;
            this.mResizeMaxDimension = -1;
            return this;
        }

        @NonNull
        public final Builder clearFilters() {
            this.mFilters.clear();
            return this;
        }

        @NonNull
        public final Builder addFilter(Filter filter) {
            if (filter != null) {
                this.mFilters.add(filter);
            }
            return this;
        }

        @NonNull
        public final Builder setRegion(int i, int i2, int i3, int i4) {
            if (this.mBitmap != null) {
                if (this.mRegion == null) {
                    this.mRegion = new Rect();
                }
                this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                if (this.mRegion.intersect(i, i2, i3, i4) == 0) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }

        @NonNull
        public final Builder clearRegion() {
            this.mRegion = null;
            return this;
        }

        @NonNull
        public final Builder addTarget(@NonNull Target target) {
            if (!this.mTargets.contains(target)) {
                this.mTargets.add(target);
            }
            return this;
        }

        @NonNull
        public final Builder clearTargets() {
            if (this.mTargets != null) {
                this.mTargets.clear();
            }
            return this;
        }

        @NonNull
        public final Palette generate() {
            List quantizedColors;
            if (this.mBitmap != null) {
                Bitmap scaleBitmapDown = scaleBitmapDown(this.mBitmap);
                Rect rect = this.mRegion;
                if (!(scaleBitmapDown == this.mBitmap || rect == null)) {
                    double width = ((double) scaleBitmapDown.getWidth()) / ((double) this.mBitmap.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), scaleBitmapDown.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width), scaleBitmapDown.getHeight());
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(getPixelsFromBitmap(scaleBitmapDown), this.mMaxColors, this.mFilters.isEmpty() ? null : (Filter[]) this.mFilters.toArray(new Filter[this.mFilters.size()]));
                if (scaleBitmapDown != this.mBitmap) {
                    scaleBitmapDown.recycle();
                }
                quantizedColors = colorCutQuantizer.getQuantizedColors();
            } else {
                quantizedColors = this.mSwatches;
            }
            Palette palette = new Palette(quantizedColors, this.mTargets);
            palette.generate();
            return palette;
        }

        @NonNull
        public final AsyncTask<Bitmap, Void, Palette> generate(final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener == null) {
                throw new IllegalArgumentException("listener can not be null");
            }
            return new AsyncTask<Bitmap, Void, Palette>() {
                protected android.support.v7.graphics.Palette doInBackground(android.graphics.Bitmap... r1) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r0 = this;
                    r1 = android.support.v7.graphics.Palette.Builder.this;	 Catch:{ Exception -> 0x0007 }
                    r1 = r1.generate();	 Catch:{ Exception -> 0x0007 }
                    return r1;
                L_0x0007:
                    r1 = 0;
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.Palette.Builder.1.doInBackground(android.graphics.Bitmap[]):android.support.v7.graphics.Palette");
                }

                protected void onPostExecute(Palette palette) {
                    paletteAsyncListener.onGenerated(palette);
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.mBitmap});
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Object obj = new int[(width * height)];
            bitmap.getPixels(obj, 0, width, 0, 0, width, height);
            if (this.mRegion == null) {
                return obj;
            }
            bitmap = this.mRegion.width();
            int height2 = this.mRegion.height();
            Object obj2 = new int[(bitmap * height2)];
            for (int i = 0; i < height2; i++) {
                System.arraycopy(obj, ((this.mRegion.top + i) * width) + this.mRegion.left, obj2, i * bitmap, bitmap);
            }
            return obj2;
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            double d = -1.0d;
            int width;
            if (this.mResizeArea > 0) {
                width = bitmap.getWidth() * bitmap.getHeight();
                if (width > this.mResizeArea) {
                    d = Math.sqrt(((double) this.mResizeArea) / ((double) width));
                }
            } else if (this.mResizeMaxDimension > 0) {
                width = Math.max(bitmap.getWidth(), bitmap.getHeight());
                if (width > this.mResizeMaxDimension) {
                    d = ((double) this.mResizeMaxDimension) / ((double) width);
                }
            }
            if (d <= 0.0d) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d), (int) Math.ceil(((double) bitmap.getHeight()) * d), false);
        }
    }

    public interface Filter {
        boolean isAllowed(int i, float[] fArr);
    }

    public interface PaletteAsyncListener {
        void onGenerated(Palette palette);
    }

    public static final class Swatch {
        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        private float[] mHsl;
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        public Swatch(@ColorInt int i, int i2) {
            this.mRed = Color.red(i);
            this.mGreen = Color.green(i);
            this.mBlue = Color.blue(i);
            this.mRgb = i;
            this.mPopulation = i2;
        }

        Swatch(int i, int i2, int i3, int i4) {
            this.mRed = i;
            this.mGreen = i2;
            this.mBlue = i3;
            this.mRgb = Color.rgb(i, i2, i3);
            this.mPopulation = i4;
        }

        Swatch(float[] fArr, int i) {
            this(ColorUtils.HSLToColor(fArr), i);
            this.mHsl = fArr;
        }

        @ColorInt
        public final int getRgb() {
            return this.mRgb;
        }

        public final float[] getHsl() {
            if (this.mHsl == null) {
                this.mHsl = new float[3];
            }
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            return this.mHsl;
        }

        public final int getPopulation() {
            return this.mPopulation;
        }

        @ColorInt
        public final int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        @ColorInt
        public final int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        private void ensureTextColorsGenerated() {
            if (!this.mGeneratedTextColors) {
                int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, Palette.MIN_CONTRAST_BODY_TEXT);
                int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, Palette.MIN_CONTRAST_TITLE_TEXT);
                if (calculateMinimumAlpha == -1 || calculateMinimumAlpha2 == -1) {
                    int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, Palette.MIN_CONTRAST_BODY_TEXT);
                    int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(-16777216, this.mRgb, Palette.MIN_CONTRAST_TITLE_TEXT);
                    if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
                        if (calculateMinimumAlpha != -1) {
                            calculateMinimumAlpha = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                        } else {
                            calculateMinimumAlpha = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                        }
                        this.mBodyTextColor = calculateMinimumAlpha;
                        if (calculateMinimumAlpha2 != -1) {
                            calculateMinimumAlpha = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                        } else {
                            calculateMinimumAlpha = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                        }
                        this.mTitleTextColor = calculateMinimumAlpha;
                        this.mGeneratedTextColors = true;
                    } else {
                        this.mBodyTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha3);
                        this.mTitleTextColor = ColorUtils.setAlphaComponent(-16777216, calculateMinimumAlpha4);
                        this.mGeneratedTextColors = true;
                        return;
                    }
                }
                this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                this.mGeneratedTextColors = true;
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());
            stringBuilder.append(" [RGB: #");
            stringBuilder.append(Integer.toHexString(getRgb()));
            stringBuilder.append(']');
            stringBuilder.append(" [HSL: ");
            stringBuilder.append(Arrays.toString(getHsl()));
            stringBuilder.append(']');
            stringBuilder.append(" [Population: ");
            stringBuilder.append(this.mPopulation);
            stringBuilder.append(']');
            stringBuilder.append(" [Title Text: #");
            stringBuilder.append(Integer.toHexString(getTitleTextColor()));
            stringBuilder.append(']');
            stringBuilder.append(" [Body Text: #");
            stringBuilder.append(Integer.toHexString(getBodyTextColor()));
            stringBuilder.append(']');
            return stringBuilder.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Swatch swatch = (Swatch) obj;
                    return this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * this.mRgb) + this.mPopulation;
        }
    }

    public static Builder from(Bitmap bitmap) {
        return new Builder(bitmap);
    }

    public static Palette from(List<Swatch> list) {
        return new Builder((List) list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i) {
        return from(bitmap).maximumColorCount(i).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i).generate(paletteAsyncListener);
    }

    Palette(List<Swatch> list, List<Target> list2) {
        this.mSwatches = list;
        this.mTargets = list2;
    }

    @NonNull
    public final List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    @NonNull
    public final List<Target> getTargets() {
        return Collections.unmodifiableList(this.mTargets);
    }

    @Nullable
    public final Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }

    @Nullable
    public final Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    @Nullable
    public final Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    @Nullable
    public final Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    @Nullable
    public final Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    @Nullable
    public final Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    @ColorInt
    public final int getVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.VIBRANT, i);
    }

    @ColorInt
    public final int getLightVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i);
    }

    @ColorInt
    public final int getDarkVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_VIBRANT, i);
    }

    @ColorInt
    public final int getMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.MUTED, i);
    }

    @ColorInt
    public final int getLightMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_MUTED, i);
    }

    @ColorInt
    public final int getDarkMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_MUTED, i);
    }

    @Nullable
    public final Swatch getSwatchForTarget(@NonNull Target target) {
        return (Swatch) this.mSelectedSwatches.get(target);
    }

    @ColorInt
    public final int getColorForTarget(@NonNull Target target, @ColorInt int i) {
        target = getSwatchForTarget(target);
        return target != null ? target.getRgb() : i;
    }

    @Nullable
    public final Swatch getDominantSwatch() {
        return this.mDominantSwatch;
    }

    @ColorInt
    public final int getDominantColor(@ColorInt int i) {
        return this.mDominantSwatch != null ? this.mDominantSwatch.getRgb() : i;
    }

    final void generate() {
        int size = this.mTargets.size();
        for (int i = 0; i < size; i++) {
            Target target = (Target) this.mTargets.get(i);
            target.normalizeWeights();
            this.mSelectedSwatches.put(target, generateScoredTarget(target));
        }
        this.mUsedColors.clear();
    }

    private Swatch generateScoredTarget(Target target) {
        Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
        if (!(maxScoredSwatchForTarget == null || target.isExclusive() == null)) {
            this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
        }
        return maxScoredSwatchForTarget;
    }

    private Swatch getMaxScoredSwatchForTarget(Target target) {
        int size = this.mSwatches.size();
        float f = 0.0f;
        Swatch swatch = null;
        for (int i = 0; i < size; i++) {
            Swatch swatch2 = (Swatch) this.mSwatches.get(i);
            if (shouldBeScoredForTarget(swatch2, target)) {
                float generateScore = generateScore(swatch2, target);
                if (swatch == null || generateScore > r1) {
                    swatch = swatch2;
                    f = generateScore;
                }
            }
        }
        return swatch;
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        if (hsl[1] < target.getMinimumSaturation() || hsl[1] > target.getMaximumSaturation() || hsl[2] < target.getMinimumLightness() || hsl[2] > target.getMaximumLightness() || this.mUsedColors.get(swatch.getRgb()) != null) {
            return null;
        }
        return true;
    }

    private float generateScore(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        int population = this.mDominantSwatch != null ? this.mDominantSwatch.getPopulation() : 1;
        float f = 0.0f;
        float abs = target.getSaturationWeight() > 0.0f ? (1.0f - Math.abs(hsl[1] - target.getTargetSaturation())) * target.getSaturationWeight() : 0.0f;
        float lightnessWeight = target.getLightnessWeight() > 0.0f ? target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness())) : 0.0f;
        if (target.getPopulationWeight() > 0.0f) {
            f = target.getPopulationWeight() * (((float) swatch.getPopulation()) / ((float) population));
        }
        return (abs + lightnessWeight) + f;
    }

    private Swatch findDominantSwatch() {
        int size = this.mSwatches.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = (Swatch) this.mSwatches.get(i2);
            if (swatch2.getPopulation() > i) {
                i = swatch2.getPopulation();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    private static float[] copyHslValues(Swatch swatch) {
        Object obj = new float[3];
        System.arraycopy(swatch.getHsl(), 0, obj, 0, 3);
        return obj;
    }
}
