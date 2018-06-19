package android.support.transition;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath = new Path();
    private final Matrix mTempMatrix = new Matrix();

    public PatternPathMotion() {
        this.mPatternPath.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = this.mPatternPath;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, Styleable.PATTERN_PATH_MOTION);
        try {
            attributeSet = TypedArrayUtils.getNamedString(context, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (attributeSet == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            setPatternPath(PathParser.createPathFromPathData(attributeSet));
        } finally {
            context.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        setPatternPath(path);
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.mTempMatrix.setTranslate(-f3, -f4);
        f -= f3;
        f2 -= f4;
        f4 = 1.0f / distance(f, f2);
        this.mTempMatrix.postScale(f4, f4);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2((double) f2, (double) f)));
        path.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = path;
    }

    public Path getPath(float f, float f2, float f3, float f4) {
        f3 -= f;
        f4 -= f2;
        float distance = distance(f3, f4);
        f3 = Math.atan2((double) f4, (double) f3);
        this.mTempMatrix.setScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(f3));
        this.mTempMatrix.postTranslate(f, f2);
        f = new Path();
        this.mPatternPath.transform(this.mTempMatrix, f);
        return f;
    }

    private static float distance(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
