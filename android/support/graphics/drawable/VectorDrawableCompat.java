package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    private static class VGroup {
        int mChangingConfigurations;
        final ArrayList<Object> mChildren = new ArrayList();
        private String mGroupName = null;
        private final Matrix mLocalMatrix = new Matrix();
        private float mPivotX = 0.0f;
        private float mPivotY = 0.0f;
        float mRotate = 0.0f;
        private float mScaleX = 1.0f;
        private float mScaleY = 1.0f;
        private final Matrix mStackedMatrix = new Matrix();
        private int[] mThemeAttrs;
        private float mTranslateX = 0.0f;
        private float mTranslateY = 0.0f;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            this.mGroupName = vGroup.mGroupName;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (this.mGroupName != null) {
                arrayMap.put(this.mGroupName, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            vGroup = vGroup.mChildren;
            for (int i = 0; i < vGroup.size(); i++) {
                Object obj = vGroup.get(i);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    VPath vFullPath;
                    if (obj instanceof VFullPath) {
                        vFullPath = new VFullPath((VFullPath) obj);
                    } else if (obj instanceof VClipPath) {
                        vFullPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vFullPath);
                    if (vFullPath.mPathName != null) {
                        arrayMap.put(vFullPath.mPathName, vFullPath);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(resources, xmlPullParser);
            resources.recycle();
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.mRotate);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
            typedArray = typedArray.getString(null);
            if (typedArray != null) {
                this.mGroupName = typedArray;
            }
            updateLocalMatrix();
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public float getRotation() {
            return this.mRotate;
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }
    }

    private static class VPath {
        int mChangingConfigurations;
        protected PathDataNode[] mNodes = null;
        String mPathName;

        public void applyTheme(Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public boolean isClipPath() {
            return false;
        }

        public void printVPath(int i) {
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("    ");
                str = stringBuilder.toString();
            }
            i = new StringBuilder();
            i.append(str);
            i.append("current path is :");
            i.append(this.mPathName);
            i.append(" pathData is ");
            i.append(nodesToString(this.mNodes));
        }

        public String nodesToString(PathDataNode[] pathDataNodeArr) {
            String str = " ";
            int i = 0;
            while (i < pathDataNodeArr.length) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(pathDataNodeArr[i].mType);
                stringBuilder.append(Constants.COLON_SEPARATOR);
                str = stringBuilder.toString();
                float[] fArr = pathDataNodeArr[i].mParams;
                String str2 = str;
                for (float append : fArr) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(append);
                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    str2 = stringBuilder2.toString();
                }
                i++;
                str = str2;
            }
            return str;
        }

        public VPath(VPath vPath) {
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }

        public void toPath(Path path) {
            path.reset();
            if (this.mNodes != null) {
                PathDataNode.nodesToPath(this.mNodes, path);
            }
        }

        public String getPathName() {
            return this.mPathName;
        }

        public PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public void setPathData(PathDataNode[] pathDataNodeArr) {
            if (PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                PathParser.updateNodes(this.mNodes, pathDataNodeArr);
            } else {
                this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }
    }

    private static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = new Matrix();
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        private Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        private Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        private static float cross(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, this.mVGTargetsMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            if (vPathRenderer.mRootName != null) {
                this.mVGTargetsMap.put(vPathRenderer.mRootName, this);
            }
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.mStackedMatrix.set(matrix);
            vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            for (matrix = null; matrix < vGroup.mChildren.size(); matrix++) {
                Object obj = vGroup.mChildren.get(matrix);
                if (obj instanceof VGroup) {
                    drawGroupTree((VGroup) obj, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                } else if (obj instanceof VPath) {
                    drawPath(vGroup, (VPath) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            i = ((float) i) / this.mViewportWidth;
            i2 = ((float) i2) / this.mViewportHeight;
            float min = Math.min(i, i2);
            vGroup = vGroup.mStackedMatrix;
            this.mFinalPathMatrix.set(vGroup);
            this.mFinalPathMatrix.postScale(i, i2);
            vGroup = getMatrixScale(vGroup);
            if (vGroup != null) {
                vPath.toPath(this.mPath);
                i2 = this.mPath;
                this.mRenderPath.reset();
                if (vPath.isClipPath()) {
                    this.mRenderPath.addPath(i2, this.mFinalPathMatrix);
                    canvas.clipPath(this.mRenderPath);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                if (!(vFullPath.mTrimPathStart == 0.0f && vFullPath.mTrimPathEnd == 1.0f)) {
                    float f = (vFullPath.mTrimPathStart + vFullPath.mTrimPathOffset) % 1.0f;
                    float f2 = (vFullPath.mTrimPathEnd + vFullPath.mTrimPathOffset) % 1.0f;
                    if (this.mPathMeasure == null) {
                        this.mPathMeasure = new PathMeasure();
                    }
                    this.mPathMeasure.setPath(this.mPath, false);
                    float length = this.mPathMeasure.getLength();
                    f *= length;
                    f2 *= length;
                    i2.reset();
                    if (f > f2) {
                        this.mPathMeasure.getSegment(f, length, i2, true);
                        this.mPathMeasure.getSegment(0.0f, f2, i2, true);
                    } else {
                        this.mPathMeasure.getSegment(f, f2, i2, true);
                    }
                    i2.rLineTo(0.0f, 0.0f);
                }
                this.mRenderPath.addPath(i2, this.mFinalPathMatrix);
                if (vFullPath.mFillColor != 0) {
                    if (this.mFillPaint == 0) {
                        this.mFillPaint = new Paint();
                        this.mFillPaint.setStyle(Style.FILL);
                        this.mFillPaint.setAntiAlias(true);
                    }
                    i = this.mFillPaint;
                    i.setColor(VectorDrawableCompat.applyAlpha(vFullPath.mFillColor, vFullPath.mFillAlpha));
                    i.setColorFilter(colorFilter);
                    this.mRenderPath.setFillType(vFullPath.mFillRule == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                    canvas.drawPath(this.mRenderPath, i);
                }
                if (vFullPath.mStrokeColor != 0) {
                    if (this.mStrokePaint == 0) {
                        this.mStrokePaint = new Paint();
                        this.mStrokePaint.setStyle(Style.STROKE);
                        this.mStrokePaint.setAntiAlias(true);
                    }
                    i = this.mStrokePaint;
                    if (vFullPath.mStrokeLineJoin != 0) {
                        i.setStrokeJoin(vFullPath.mStrokeLineJoin);
                    }
                    if (vFullPath.mStrokeLineCap != 0) {
                        i.setStrokeCap(vFullPath.mStrokeLineCap);
                    }
                    i.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                    i.setColor(VectorDrawableCompat.applyAlpha(vFullPath.mStrokeColor, vFullPath.mStrokeAlpha));
                    i.setColorFilter(colorFilter);
                    i.setStrokeWidth(vFullPath.mStrokeWidth * (min * vGroup));
                    canvas.drawPath(this.mRenderPath, i);
                }
            }
        }

        private float getMatrixScale(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            matrix = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(matrix) / max;
            }
            return 0.0f;
        }
    }

    private static class VectorDrawableCompatState extends ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                this.mVPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    this.mVPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.mCachedBitmap, null, rect, getPaint(colorFilter));
        }

        public boolean hasTranslucentRoot() {
            return this.mVPathRenderer.getRootAlpha() < 255;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.mTempPaint == null) {
                this.mTempPaint = new Paint();
                this.mTempPaint.setFilterBitmap(true);
            }
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(colorFilter);
            return this.mTempPaint;
        }

        public void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), i, i2, null);
        }

        public void createCachedBitmapIfNeeded(int i, int i2) {
            if (this.mCachedBitmap == null || !canReuseBitmap(i, i2)) {
                this.mCachedBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.mCacheDirty = true;
            }
        }

        public boolean canReuseBitmap(int i, int i2) {
            return i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight();
        }

        public boolean canReuseCache() {
            return !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha();
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends ConstantState {
        private final ConstantState mDelegateState;

        public VectorDrawableDelegateState(ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public Drawable newDrawable() {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }
    }

    private static class VClipPath extends VPath {
        public boolean isClipPath() {
            return true;
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData") != null) {
                resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                updateStateFromTypedArray(resources);
                resources.recycle();
            }
        }

        private void updateStateFromTypedArray(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mPathName = string;
            }
            typedArray = typedArray.getString(1);
            if (typedArray != null) {
                this.mNodes = PathParser.createNodesFromPathData(typedArray);
            }
        }
    }

    private static class VFullPath extends VPath {
        float mFillAlpha = 1.0f;
        int mFillColor = 0;
        int mFillRule = 0;
        float mStrokeAlpha = 1.0f;
        int mStrokeColor = 0;
        Cap mStrokeLineCap = Cap.BUTT;
        Join mStrokeLineJoin = Join.MITER;
        float mStrokeMiterlimit = 4.0f;
        float mStrokeWidth = 0.0f;
        private int[] mThemeAttrs;
        float mTrimPathEnd = 1.0f;
        float mTrimPathOffset = 0.0f;
        float mTrimPathStart = 0.0f;

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }

        private Cap getStrokeLineCap(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join getStrokeLineJoin(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(resources, xmlPullParser);
            resources.recycle();
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mPathName = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.mNodes = PathParser.createNodesFromPathData(string);
                }
                this.mFillColor = TypedArrayUtils.getNamedColor(typedArray, xmlPullParser, "fillColor", 1, this.mFillColor);
                this.mFillAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
                this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
                this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
                this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
                this.mStrokeColor = TypedArrayUtils.getNamedColor(typedArray, xmlPullParser, "strokeColor", 3, this.mStrokeColor);
                this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
                this.mStrokeWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
                this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
                this.mTrimPathStart = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
                this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
            }
        }

        public void applyTheme(Theme theme) {
            if (this.mThemeAttrs != null) {
            }
        }

        int getStrokeColor() {
            return this.mStrokeColor;
        }

        void setStrokeColor(int i) {
            this.mStrokeColor = i;
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        int getFillColor() {
            return this.mFillColor;
        }

        void setFillColor(int i) {
            this.mFillColor = i;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    public Drawable mutate() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    Object getTargetByName(String str) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str);
    }

    public ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    public void draw(Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0) {
            if (this.mTmpBounds.height() > 0) {
                ColorFilter colorFilter = this.mColorFilter == null ? this.mTintFilter : this.mColorFilter;
                canvas.getMatrix(this.mTmpMatrix);
                this.mTmpMatrix.getValues(this.mTmpFloats);
                float abs = Math.abs(this.mTmpFloats[0]);
                float abs2 = Math.abs(this.mTmpFloats[4]);
                float abs3 = Math.abs(this.mTmpFloats[1]);
                float abs4 = Math.abs(this.mTmpFloats[3]);
                if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                    abs = 1.0f;
                    abs2 = abs;
                }
                int height = (int) (((float) this.mTmpBounds.height()) * abs2);
                int min = Math.min(2048, (int) (((float) this.mTmpBounds.width()) * abs));
                height = Math.min(2048, height);
                if (min > 0) {
                    if (height > 0) {
                        int save = canvas.save();
                        canvas.translate((float) this.mTmpBounds.left, (float) this.mTmpBounds.top);
                        if (needMirroring()) {
                            canvas.translate((float) this.mTmpBounds.width(), 0.0f);
                            canvas.scale(-1.0f, 1.0f);
                        }
                        this.mTmpBounds.offsetTo(0, 0);
                        this.mVectorState.createCachedBitmapIfNeeded(min, height);
                        if (!this.mAllowCaching) {
                            this.mVectorState.updateCachedBitmap(min, height);
                        } else if (!this.mVectorState.canReuseCache()) {
                            this.mVectorState.updateCachedBitmap(min, height);
                            this.mVectorState.updateCacheStates();
                        }
                        this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.mTmpBounds);
                        canvas.restoreToCount(save);
                    }
                }
            }
        }
    }

    public int getAlpha() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public void setAlpha(int i) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(i);
            return;
        }
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }

    public void setTint(int i) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }
        if (!super.isStateful()) {
            if (this.mVectorState == null || this.mVectorState.mTint == null || !this.mVectorState.mTint.isStateful()) {
                return false;
            }
        }
        return true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(iArr);
        }
        iArr = this.mVectorState;
        if (iArr.mTint == null || iArr.mTintMode == null) {
            return null;
        }
        this.mTintFilter = updateTintFilter(this.mTintFilter, iArr.mTint, iArr.mTintMode);
        invalidateSelf();
        return 1;
    }

    public int getOpacity() {
        return this.mDelegateDrawable != null ? this.mDelegateDrawable.getOpacity() : -3;
    }

    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }
        return this.mVectorState.mAutoMirrored;
    }

    public void setAutoMirrored(boolean z) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(this.mDelegateDrawable, z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public float getPixelSize() {
        if (!(this.mVectorState == null || this.mVectorState.mVPathRenderer == null || this.mVectorState.mVPathRenderer.mBaseWidth == 0.0f || this.mVectorState.mVPathRenderer.mBaseHeight == 0.0f || this.mVectorState.mVPathRenderer.mViewportHeight == 0.0f)) {
            if (this.mVectorState.mVPathRenderer.mViewportWidth != 0.0f) {
                float f = this.mVectorState.mVPathRenderer.mBaseWidth;
                float f2 = this.mVectorState.mVPathRenderer.mBaseHeight;
                return Math.min(this.mVectorState.mVPathRenderer.mViewportWidth / f, this.mVectorState.mVPathRenderer.mViewportHeight / f2);
            }
        }
        return 1.0f;
    }

    @android.support.annotation.Nullable
    public static android.support.graphics.drawable.VectorDrawableCompat create(@android.support.annotation.NonNull android.content.res.Resources r4, @android.support.annotation.DrawableRes int r5, @android.support.annotation.Nullable android.content.res.Resources.Theme r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x001f;
    L_0x0006:
        r0 = new android.support.graphics.drawable.VectorDrawableCompat;
        r0.<init>();
        r4 = android.support.v4.content.res.ResourcesCompat.getDrawable(r4, r5, r6);
        r0.mDelegateDrawable = r4;
        r4 = new android.support.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState;
        r5 = r0.mDelegateDrawable;
        r5 = r5.getConstantState();
        r4.<init>(r5);
        r0.mCachedConstantStateDelegate = r4;
        return r0;
    L_0x001f:
        r5 = r4.getXml(r5);	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        r0 = android.util.Xml.asAttributeSet(r5);	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
    L_0x0027:
        r1 = r5.next();	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        r2 = 2;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        if (r1 == r2) goto L_0x0031;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
    L_0x002e:
        r3 = 1;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        if (r1 != r3) goto L_0x0027;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
    L_0x0031:
        if (r1 == r2) goto L_0x003b;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
    L_0x0033:
        r4 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        r5 = "No start tag found";	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        r4.<init>(r5);	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        throw r4;	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
    L_0x003b:
        r4 = createFromXmlInner(r4, r5, r0, r6);	 Catch:{ XmlPullParserException -> 0x0040, XmlPullParserException -> 0x0040 }
        return r4;
    L_0x0040:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    static int applyAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
        vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
        vectorDrawableCompatState.mCacheDirty = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    private static Mode parseTintModeCompat(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.ADD : mode;
            default:
                return mode;
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        vectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            vectorDrawableCompatState.mTint = colorStateList;
        }
        vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
        vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
        vPathRenderer.mViewportHeight = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
        StringBuilder stringBuilder;
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (vPathRenderer.mViewportHeight <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else {
            vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
            vPathRenderer.mBaseHeight = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
            if (vPathRenderer.mBaseWidth <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (vPathRenderer.mBaseHeight <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else {
                vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                typedArray = typedArray.getString(null);
                if (typedArray != null) {
                    vPathRenderer.mRootName = typedArray;
                    vPathRenderer.mVGTargetsMap.put(typedArray, vPathRenderer);
                }
            }
        }
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        Stack stack = new Stack();
        stack.push(vPathRenderer.mRootGroup);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        int i = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) stack.peek();
                if (SHAPE_PATH.equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                    }
                    i = 0;
                    vectorDrawableCompatState.mChangingConfigurations = vFullPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if (SHAPE_CLIP_PATH.equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                } else if (SHAPE_GROUP.equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.mChildren.add(vGroup2);
                    stack.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.mChangingConfigurations = vGroup2.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                }
            } else if (eventType == 3) {
                if (SHAPE_GROUP.equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (i != 0) {
            resources = new StringBuffer();
            if (resources.length() > null) {
                resources.append(" or ");
            }
            resources.append(SHAPE_PATH);
            attributeSet = new StringBuilder("no ");
            attributeSet.append(resources);
            attributeSet.append(" defined");
            throw new XmlPullParserException(attributeSet.toString());
        }
    }

    private void printGroupTree(VGroup vGroup, int i) {
        int i2 = 0;
        String str = "";
        for (int i3 = 0; i3 < i; i3++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("current group is :");
        stringBuilder2.append(vGroup.getGroupName());
        stringBuilder2.append(" rotation is ");
        stringBuilder2.append(vGroup.mRotate);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("matrix is :");
        stringBuilder2.append(vGroup.getLocalMatrix().toString());
        while (i2 < vGroup.mChildren.size()) {
            Object obj = vGroup.mChildren.get(i2);
            if (obj instanceof VGroup) {
                printGroupTree((VGroup) obj, i + 1);
            } else {
                ((VPath) obj).printVPath(i + 1);
            }
            i2++;
        }
    }

    void setAllowCaching(boolean z) {
        this.mAllowCaching = z;
    }

    private boolean needMirroring() {
        if (VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
