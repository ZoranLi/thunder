package android.support.v7.graphics;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.graphics.Palette.Filter;
import android.support.v7.graphics.Palette.Swatch;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() {
        public final int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.getVolume() - vbox.getVolume();
        }
    };
    final int[] mColors;
    final Filter[] mFilters;
    final int[] mHistogram;
    final List<Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];
    final TimingLogger mTimingLogger = null;

    private class Vbox {
        private int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        Vbox(int i, int i2) {
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        final int getVolume() {
            return (((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1)) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        final boolean canSplit() {
            return getColorCount() > 1;
        }

        final int getColorCount() {
            return (1 + this.mUpperIndex) - this.mLowerIndex;
        }

        final void fitBox() {
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i3 = 0;
            int i4 = Integer.MAX_VALUE;
            int i5 = i4;
            int i6 = Integer.MIN_VALUE;
            int i7 = i6;
            for (int i8 = this.mLowerIndex; i8 <= this.mUpperIndex; i8++) {
                int i9 = iArr[i8];
                i3 += iArr2[i9];
                int quantizedRed = ColorCutQuantizer.quantizedRed(i9);
                int quantizedGreen = ColorCutQuantizer.quantizedGreen(i9);
                i9 = ColorCutQuantizer.quantizedBlue(i9);
                if (quantizedRed > i2) {
                    i2 = quantizedRed;
                }
                if (quantizedRed < i) {
                    i = quantizedRed;
                }
                if (quantizedGreen > i6) {
                    i6 = quantizedGreen;
                }
                if (quantizedGreen < i4) {
                    i4 = quantizedGreen;
                }
                if (i9 > i7) {
                    i7 = i9;
                }
                if (i9 < i5) {
                    i5 = i9;
                }
            }
            this.mMinRed = i;
            this.mMaxRed = i2;
            this.mMinGreen = i4;
            this.mMaxGreen = i6;
            this.mMinBlue = i5;
            this.mMaxBlue = i7;
            this.mPopulation = i3;
        }

        final Vbox splitBox() {
            if (canSplit()) {
                int findSplitPoint = findSplitPoint();
                Vbox vbox = new Vbox(findSplitPoint + 1, this.mUpperIndex);
                this.mUpperIndex = findSplitPoint;
                fitBox();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        final int getLongestColorDimension() {
            int i = this.mMaxRed - this.mMinRed;
            int i2 = this.mMaxGreen - this.mMinGreen;
            int i3 = this.mMaxBlue - this.mMinBlue;
            if (i < i2 || i < i3) {
                return (i2 < i || i2 < i3) ? -1 : -2;
            } else {
                return -3;
            }
        }

        final int findSplitPoint() {
            int longestColorDimension = getLongestColorDimension();
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(iArr, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(iArr, longestColorDimension, this.mLowerIndex, this.mUpperIndex);
            longestColorDimension = this.mPopulation / 2;
            int i = 0;
            for (int i2 = this.mLowerIndex; i2 <= this.mUpperIndex; i2++) {
                i += iArr2[iArr[i2]];
                if (i >= longestColorDimension) {
                    return Math.min(this.mUpperIndex - 1, i2);
                }
            }
            return this.mLowerIndex;
        }

        final Swatch getAverageColor() {
            int[] iArr = ColorCutQuantizer.this.mColors;
            int[] iArr2 = ColorCutQuantizer.this.mHistogram;
            int i = 0;
            int i2 = 0;
            int i3 = i2;
            int i4 = i3;
            for (int i5 = this.mLowerIndex; i5 <= this.mUpperIndex; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i6];
                i += i7;
                i2 += ColorCutQuantizer.quantizedRed(i6) * i7;
                i3 += ColorCutQuantizer.quantizedGreen(i6) * i7;
                i4 += i7 * ColorCutQuantizer.quantizedBlue(i6);
            }
            float f = (float) i;
            return new Swatch(ColorCutQuantizer.approximateToRgb888(Math.round(((float) i2) / f), Math.round(((float) i3) / f), Math.round(((float) i4) / f)), i);
        }
    }

    private static int modifyWordWidth(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    static int quantizedBlue(int i) {
        return i & 31;
    }

    static int quantizedGreen(int i) {
        return (i >> 5) & 31;
    }

    static int quantizedRed(int i) {
        return (i >> 10) & 31;
    }

    ColorCutQuantizer(int[] iArr, int i, Filter[] filterArr) {
        int i2;
        int quantizeFromRgb888;
        this.mFilters = filterArr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        int i3 = 0;
        for (i2 = 0; i2 < iArr.length; i2++) {
            quantizeFromRgb888 = quantizeFromRgb888(iArr[i2]);
            iArr[i2] = quantizeFromRgb888;
            iArr2[quantizeFromRgb888] = iArr2[quantizeFromRgb888] + 1;
        }
        int i4 = null;
        i2 = i4;
        while (i4 < 32768) {
            if (iArr2[i4] > 0 && shouldIgnoreColor(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i2++;
            }
            i4++;
        }
        iArr = new int[i2];
        this.mColors = iArr;
        quantizeFromRgb888 = 0;
        int i5 = quantizeFromRgb888;
        while (quantizeFromRgb888 < 32768) {
            if (iArr2[quantizeFromRgb888] > 0) {
                int i6 = i5 + 1;
                iArr[i5] = quantizeFromRgb888;
                i5 = i6;
            }
            quantizeFromRgb888++;
        }
        if (i2 <= i) {
            this.mQuantizedColors = new ArrayList();
            i = iArr.length;
            while (i3 < i) {
                filterArr = iArr[i3];
                this.mQuantizedColors.add(new Swatch(approximateToRgb888(filterArr), iArr2[filterArr]));
                i3++;
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(i);
    }

    final List<Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private List<Swatch> quantizePixels(int i) {
        Collection priorityQueue = new PriorityQueue(i, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.mColors.length - 1));
        splitBoxes(priorityQueue, i);
        return generateAverageColors(priorityQueue);
    }

    private void splitBoxes(PriorityQueue<Vbox> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            Vbox vbox = (Vbox) priorityQueue.poll();
            if (vbox != null && vbox.canSplit()) {
                priorityQueue.offer(vbox.splitBox());
                priorityQueue.offer(vbox);
            } else {
                return;
            }
        }
    }

    private List<Swatch> generateAverageColors(Collection<Vbox> collection) {
        List arrayList = new ArrayList(collection.size());
        for (Vbox averageColor : collection) {
            Swatch averageColor2 = averageColor.getAverageColor();
            if (!shouldIgnoreColor(averageColor2)) {
                arrayList.add(averageColor2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void modifySignificantOctet(int[] r2, int r3, int r4, int r5) {
        /*
        switch(r3) {
            case -3: goto L_0x003b;
            case -2: goto L_0x001f;
            case -1: goto L_0x0004;
            default: goto L_0x0003;
        };
    L_0x0003:
        goto L_0x003c;
    L_0x0004:
        if (r4 > r5) goto L_0x003c;
    L_0x0006:
        r3 = r2[r4];
        r0 = quantizedBlue(r3);
        r0 = r0 << 10;
        r1 = quantizedGreen(r3);
        r1 = r1 << 5;
        r0 = r0 | r1;
        r3 = quantizedRed(r3);
        r3 = r3 | r0;
        r2[r4] = r3;
        r4 = r4 + 1;
        goto L_0x0004;
    L_0x001f:
        if (r4 > r5) goto L_0x003a;
    L_0x0021:
        r3 = r2[r4];
        r0 = quantizedGreen(r3);
        r0 = r0 << 10;
        r1 = quantizedRed(r3);
        r1 = r1 << 5;
        r0 = r0 | r1;
        r3 = quantizedBlue(r3);
        r3 = r3 | r0;
        r2[r4] = r3;
        r4 = r4 + 1;
        goto L_0x001f;
    L_0x003a:
        return;
    L_0x003b:
        return;
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.graphics.ColorCutQuantizer.modifySignificantOctet(int[], int, int, int):void");
    }

    private boolean shouldIgnoreColor(int i) {
        i = approximateToRgb888(i);
        ColorUtils.colorToHSL(i, this.mTempHsl);
        return shouldIgnoreColor(i, this.mTempHsl);
    }

    private boolean shouldIgnoreColor(Swatch swatch) {
        return shouldIgnoreColor(swatch.getRgb(), swatch.getHsl());
    }

    private boolean shouldIgnoreColor(int i, float[] fArr) {
        if (this.mFilters != null && this.mFilters.length > 0) {
            for (Filter isAllowed : this.mFilters) {
                if (!isAllowed.isAllowed(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int quantizeFromRgb888(int i) {
        return modifyWordWidth(Color.blue(i), 8, 5) | ((modifyWordWidth(Color.red(i), 8, 5) << 10) | (modifyWordWidth(Color.green(i), 8, 5) << 5));
    }

    static int approximateToRgb888(int i, int i2, int i3) {
        return Color.rgb(modifyWordWidth(i, 5, 8), modifyWordWidth(i2, 5, 8), modifyWordWidth(i3, 5, 8));
    }

    private static int approximateToRgb888(int i) {
        return approximateToRgb888(quantizedRed(i), quantizedGreen(i), quantizedBlue(i));
    }
}
