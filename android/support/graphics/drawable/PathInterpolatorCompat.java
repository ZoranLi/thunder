package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.xiaomi.mipush.sdk.Constants;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({Scope.LIBRARY_GROUP})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(resources, xmlPullParser);
        resources.recycle();
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            typedArray = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            xmlPullParser = PathParser.createPathFromPathData(typedArray);
            if (xmlPullParser == null) {
                StringBuilder stringBuilder = new StringBuilder("The path is null, which is created from ");
                stringBuilder.append(typedArray);
                throw new InflateException(stringBuilder.toString());
            }
            initPath(xmlPullParser);
        } else if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
            if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (hasAttribute) {
                initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            } else {
                initQuad(namedFloat, namedFloat2);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    private void initQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        initPath(path);
    }

    private void initCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        path = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (path / PRECISION)) + 1);
        if (min <= 0) {
            StringBuilder stringBuilder = new StringBuilder("The Path has a invalid length ");
            stringBuilder.append(path);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i2;
        this.mX = new float[min];
        this.mY = new float[min];
        float[] fArr = new float[2];
        for (i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * path) / ((float) (min - 1)), fArr, null);
            this.mX[i2] = fArr[0];
            this.mY[i2] = fArr[1];
        }
        if (((double) Math.abs(this.mX[0])) <= EPSILON && ((double) Math.abs(this.mY[0])) <= EPSILON) {
            int i3 = min - 1;
            if (((double) Math.abs(this.mX[i3] - 1065353216)) <= EPSILON) {
                if (((double) Math.abs(this.mY[i3] - 1065353216)) <= EPSILON) {
                    float f = null;
                    path = null;
                    while (i < min) {
                        i2 = path + 1;
                        path = this.mX[path];
                        if (path < f) {
                            stringBuilder = new StringBuilder("The Path cannot loop back on itself, x :");
                            stringBuilder.append(path);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        this.mX[i] = path;
                        i++;
                        f = path;
                        path = i2;
                    }
                    if (pathMeasure.nextContour() != null) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        stringBuilder2.append(this.mX[0]);
        stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder2.append(this.mY[0]);
        stringBuilder2.append(" end:");
        min--;
        stringBuilder2.append(this.mX[min]);
        stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder2.append(this.mY[min]);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.mX.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.mX[length] - this.mX[i];
        if (f2 == 0.0f) {
            return this.mY[i];
        }
        f = (f - this.mX[i]) / f2;
        float f3 = this.mY[i];
        return f3 + (f * (this.mY[length] - f3));
    }
}
