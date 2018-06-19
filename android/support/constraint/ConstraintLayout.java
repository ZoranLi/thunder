package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.util.ArrayList;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean SIMPLE_LAYOUT = true;
    private static final String TAG = "ConstraintLayout";
    public static final String VERSION = "ConstraintLayout-1.0.0";
    SparseArray<View> mChildrenByIds = new SparseArray();
    private ConstraintSet mConstraintSet = null;
    private boolean mDirtyHierarchy = true;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 2;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);

    public static class LayoutParams extends MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1082130432;
        public float horizontalBias = PayBaseConstants.HALF_OF_FLOAT;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = 0.0f;
        boolean isGuideline = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        float resolvedHorizontalBias = PayBaseConstants.HALF_OF_FLOAT;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = PayBaseConstants.HALF_OF_FLOAT;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = 0.0f;
        ConstraintWidget widget = new ConstraintWidget();

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        public LayoutParams(android.content.Context r10, android.util.AttributeSet r11) {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r9 = this;
            r9.<init>(r10, r11);
            r0 = -1;
            r9.guideBegin = r0;
            r9.guideEnd = r0;
            r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r9.guidePercent = r1;
            r9.leftToLeft = r0;
            r9.leftToRight = r0;
            r9.rightToLeft = r0;
            r9.rightToRight = r0;
            r9.topToTop = r0;
            r9.topToBottom = r0;
            r9.bottomToTop = r0;
            r9.bottomToBottom = r0;
            r9.baselineToBaseline = r0;
            r9.startToEnd = r0;
            r9.startToStart = r0;
            r9.endToStart = r0;
            r9.endToEnd = r0;
            r9.goneLeftMargin = r0;
            r9.goneTopMargin = r0;
            r9.goneRightMargin = r0;
            r9.goneBottomMargin = r0;
            r9.goneStartMargin = r0;
            r9.goneEndMargin = r0;
            r1 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
            r9.horizontalBias = r1;
            r9.verticalBias = r1;
            r2 = 0;
            r9.dimensionRatio = r2;
            r2 = 0;
            r9.dimensionRatioValue = r2;
            r3 = 1;
            r9.dimensionRatioSide = r3;
            r9.horizontalWeight = r2;
            r9.verticalWeight = r2;
            r4 = 0;
            r9.horizontalChainStyle = r4;
            r9.verticalChainStyle = r4;
            r9.matchConstraintDefaultWidth = r4;
            r9.matchConstraintDefaultHeight = r4;
            r9.matchConstraintMinWidth = r4;
            r9.matchConstraintMinHeight = r4;
            r9.matchConstraintMaxWidth = r4;
            r9.matchConstraintMaxHeight = r4;
            r9.editorAbsoluteX = r0;
            r9.editorAbsoluteY = r0;
            r9.orientation = r0;
            r9.horizontalDimensionFixed = r3;
            r9.verticalDimensionFixed = r3;
            r9.needsBaseline = r4;
            r9.isGuideline = r4;
            r9.resolvedLeftToLeft = r0;
            r9.resolvedLeftToRight = r0;
            r9.resolvedRightToLeft = r0;
            r9.resolvedRightToRight = r0;
            r9.resolveGoneLeftMargin = r0;
            r9.resolveGoneRightMargin = r0;
            r9.resolvedHorizontalBias = r1;
            r1 = new android.support.constraint.solver.widgets.ConstraintWidget;
            r1.<init>();
            r9.widget = r1;
            r1 = android.support.constraint.R.styleable.ConstraintLayout_Layout;
            r10 = r10.obtainStyledAttributes(r11, r1);
            r11 = r10.getIndexCount();
            r1 = r4;
        L_0x0084:
            if (r1 >= r11) goto L_0x03be;
        L_0x0086:
            r5 = r10.getIndex(r1);
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf;
            if (r5 != r6) goto L_0x00a2;
        L_0x008e:
            r6 = r9.leftToLeft;
            r6 = r10.getResourceId(r5, r6);
            r9.leftToLeft = r6;
            r6 = r9.leftToLeft;
            if (r6 != r0) goto L_0x03ba;
        L_0x009a:
            r5 = r10.getInt(r5, r0);
            r9.leftToLeft = r5;
            goto L_0x03ba;
        L_0x00a2:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf;
            if (r5 != r6) goto L_0x00ba;
        L_0x00a6:
            r6 = r9.leftToRight;
            r6 = r10.getResourceId(r5, r6);
            r9.leftToRight = r6;
            r6 = r9.leftToRight;
            if (r6 != r0) goto L_0x03ba;
        L_0x00b2:
            r5 = r10.getInt(r5, r0);
            r9.leftToRight = r5;
            goto L_0x03ba;
        L_0x00ba:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf;
            if (r5 != r6) goto L_0x00d2;
        L_0x00be:
            r6 = r9.rightToLeft;
            r6 = r10.getResourceId(r5, r6);
            r9.rightToLeft = r6;
            r6 = r9.rightToLeft;
            if (r6 != r0) goto L_0x03ba;
        L_0x00ca:
            r5 = r10.getInt(r5, r0);
            r9.rightToLeft = r5;
            goto L_0x03ba;
        L_0x00d2:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf;
            if (r5 != r6) goto L_0x00ea;
        L_0x00d6:
            r6 = r9.rightToRight;
            r6 = r10.getResourceId(r5, r6);
            r9.rightToRight = r6;
            r6 = r9.rightToRight;
            if (r6 != r0) goto L_0x03ba;
        L_0x00e2:
            r5 = r10.getInt(r5, r0);
            r9.rightToRight = r5;
            goto L_0x03ba;
        L_0x00ea:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf;
            if (r5 != r6) goto L_0x0102;
        L_0x00ee:
            r6 = r9.topToTop;
            r6 = r10.getResourceId(r5, r6);
            r9.topToTop = r6;
            r6 = r9.topToTop;
            if (r6 != r0) goto L_0x03ba;
        L_0x00fa:
            r5 = r10.getInt(r5, r0);
            r9.topToTop = r5;
            goto L_0x03ba;
        L_0x0102:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf;
            if (r5 != r6) goto L_0x011a;
        L_0x0106:
            r6 = r9.topToBottom;
            r6 = r10.getResourceId(r5, r6);
            r9.topToBottom = r6;
            r6 = r9.topToBottom;
            if (r6 != r0) goto L_0x03ba;
        L_0x0112:
            r5 = r10.getInt(r5, r0);
            r9.topToBottom = r5;
            goto L_0x03ba;
        L_0x011a:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf;
            if (r5 != r6) goto L_0x0132;
        L_0x011e:
            r6 = r9.bottomToTop;
            r6 = r10.getResourceId(r5, r6);
            r9.bottomToTop = r6;
            r6 = r9.bottomToTop;
            if (r6 != r0) goto L_0x03ba;
        L_0x012a:
            r5 = r10.getInt(r5, r0);
            r9.bottomToTop = r5;
            goto L_0x03ba;
        L_0x0132:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf;
            if (r5 != r6) goto L_0x014a;
        L_0x0136:
            r6 = r9.bottomToBottom;
            r6 = r10.getResourceId(r5, r6);
            r9.bottomToBottom = r6;
            r6 = r9.bottomToBottom;
            if (r6 != r0) goto L_0x03ba;
        L_0x0142:
            r5 = r10.getInt(r5, r0);
            r9.bottomToBottom = r5;
            goto L_0x03ba;
        L_0x014a:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf;
            if (r5 != r6) goto L_0x0162;
        L_0x014e:
            r6 = r9.baselineToBaseline;
            r6 = r10.getResourceId(r5, r6);
            r9.baselineToBaseline = r6;
            r6 = r9.baselineToBaseline;
            if (r6 != r0) goto L_0x03ba;
        L_0x015a:
            r5 = r10.getInt(r5, r0);
            r9.baselineToBaseline = r5;
            goto L_0x03ba;
        L_0x0162:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX;
            if (r5 != r6) goto L_0x0170;
        L_0x0166:
            r6 = r9.editorAbsoluteX;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.editorAbsoluteX = r5;
            goto L_0x03ba;
        L_0x0170:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY;
            if (r5 != r6) goto L_0x017e;
        L_0x0174:
            r6 = r9.editorAbsoluteY;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.editorAbsoluteY = r5;
            goto L_0x03ba;
        L_0x017e:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin;
            if (r5 != r6) goto L_0x018c;
        L_0x0182:
            r6 = r9.guideBegin;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.guideBegin = r5;
            goto L_0x03ba;
        L_0x018c:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end;
            if (r5 != r6) goto L_0x019a;
        L_0x0190:
            r6 = r9.guideEnd;
            r5 = r10.getDimensionPixelOffset(r5, r6);
            r9.guideEnd = r5;
            goto L_0x03ba;
        L_0x019a:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent;
            if (r5 != r6) goto L_0x01a8;
        L_0x019e:
            r6 = r9.guidePercent;
            r5 = r10.getFloat(r5, r6);
            r9.guidePercent = r5;
            goto L_0x03ba;
        L_0x01a8:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_android_orientation;
            if (r5 != r6) goto L_0x01b6;
        L_0x01ac:
            r6 = r9.orientation;
            r5 = r10.getInt(r5, r6);
            r9.orientation = r5;
            goto L_0x03ba;
        L_0x01b6:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf;
            if (r5 != r6) goto L_0x01ce;
        L_0x01ba:
            r6 = r9.startToEnd;
            r6 = r10.getResourceId(r5, r6);
            r9.startToEnd = r6;
            r6 = r9.startToEnd;
            if (r6 != r0) goto L_0x03ba;
        L_0x01c6:
            r5 = r10.getInt(r5, r0);
            r9.startToEnd = r5;
            goto L_0x03ba;
        L_0x01ce:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf;
            if (r5 != r6) goto L_0x01e6;
        L_0x01d2:
            r6 = r9.startToStart;
            r6 = r10.getResourceId(r5, r6);
            r9.startToStart = r6;
            r6 = r9.startToStart;
            if (r6 != r0) goto L_0x03ba;
        L_0x01de:
            r5 = r10.getInt(r5, r0);
            r9.startToStart = r5;
            goto L_0x03ba;
        L_0x01e6:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf;
            if (r5 != r6) goto L_0x01fe;
        L_0x01ea:
            r6 = r9.endToStart;
            r6 = r10.getResourceId(r5, r6);
            r9.endToStart = r6;
            r6 = r9.endToStart;
            if (r6 != r0) goto L_0x03ba;
        L_0x01f6:
            r5 = r10.getInt(r5, r0);
            r9.endToStart = r5;
            goto L_0x03ba;
        L_0x01fe:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf;
            if (r5 != r6) goto L_0x0216;
        L_0x0202:
            r6 = r9.endToEnd;
            r6 = r10.getResourceId(r5, r6);
            r9.endToEnd = r6;
            r6 = r9.endToEnd;
            if (r6 != r0) goto L_0x03ba;
        L_0x020e:
            r5 = r10.getInt(r5, r0);
            r9.endToEnd = r5;
            goto L_0x03ba;
        L_0x0216:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft;
            if (r5 != r6) goto L_0x0224;
        L_0x021a:
            r6 = r9.goneLeftMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneLeftMargin = r5;
            goto L_0x03ba;
        L_0x0224:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginTop;
            if (r5 != r6) goto L_0x0232;
        L_0x0228:
            r6 = r9.goneTopMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneTopMargin = r5;
            goto L_0x03ba;
        L_0x0232:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginRight;
            if (r5 != r6) goto L_0x0240;
        L_0x0236:
            r6 = r9.goneRightMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneRightMargin = r5;
            goto L_0x03ba;
        L_0x0240:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom;
            if (r5 != r6) goto L_0x024e;
        L_0x0244:
            r6 = r9.goneBottomMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneBottomMargin = r5;
            goto L_0x03ba;
        L_0x024e:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginStart;
            if (r5 != r6) goto L_0x025c;
        L_0x0252:
            r6 = r9.goneStartMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneStartMargin = r5;
            goto L_0x03ba;
        L_0x025c:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd;
            if (r5 != r6) goto L_0x026a;
        L_0x0260:
            r6 = r9.goneEndMargin;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.goneEndMargin = r5;
            goto L_0x03ba;
        L_0x026a:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias;
            if (r5 != r6) goto L_0x0278;
        L_0x026e:
            r6 = r9.horizontalBias;
            r5 = r10.getFloat(r5, r6);
            r9.horizontalBias = r5;
            goto L_0x03ba;
        L_0x0278:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias;
            if (r5 != r6) goto L_0x0286;
        L_0x027c:
            r6 = r9.verticalBias;
            r5 = r10.getFloat(r5, r6);
            r9.verticalBias = r5;
            goto L_0x03ba;
        L_0x0286:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio;
            if (r5 != r6) goto L_0x032f;
        L_0x028a:
            r5 = r10.getString(r5);
            r9.dimensionRatio = r5;
            r5 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
            r9.dimensionRatioValue = r5;
            r9.dimensionRatioSide = r0;
            r5 = r9.dimensionRatio;
            if (r5 == 0) goto L_0x03ba;
        L_0x029a:
            r5 = r9.dimensionRatio;
            r5 = r5.length();
            r6 = r9.dimensionRatio;
            r7 = 44;
            r6 = r6.indexOf(r7);
            if (r6 <= 0) goto L_0x02cc;
        L_0x02aa:
            r7 = r5 + -1;
            if (r6 >= r7) goto L_0x02cc;
        L_0x02ae:
            r7 = r9.dimensionRatio;
            r7 = r7.substring(r4, r6);
            r8 = "W";
            r8 = r7.equalsIgnoreCase(r8);
            if (r8 == 0) goto L_0x02bf;
        L_0x02bc:
            r9.dimensionRatioSide = r4;
            goto L_0x02c9;
        L_0x02bf:
            r8 = "H";
            r7 = r7.equalsIgnoreCase(r8);
            if (r7 == 0) goto L_0x02c9;
        L_0x02c7:
            r9.dimensionRatioSide = r3;
        L_0x02c9:
            r6 = r6 + 1;
            goto L_0x02cd;
        L_0x02cc:
            r6 = r4;
        L_0x02cd:
            r7 = r9.dimensionRatio;
            r8 = 58;
            r7 = r7.indexOf(r8);
            if (r7 < 0) goto L_0x031b;
        L_0x02d7:
            r5 = r5 + -1;
            if (r7 >= r5) goto L_0x031b;
        L_0x02db:
            r5 = r9.dimensionRatio;
            r5 = r5.substring(r6, r7);
            r6 = r9.dimensionRatio;
            r7 = r7 + 1;
            r6 = r6.substring(r7);
            r7 = r5.length();
            if (r7 <= 0) goto L_0x03ba;
        L_0x02ef:
            r7 = r6.length();
            if (r7 <= 0) goto L_0x03ba;
        L_0x02f5:
            r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x03ba }
            r6 = java.lang.Float.parseFloat(r6);	 Catch:{ NumberFormatException -> 0x03ba }
            r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x03ba }
            if (r7 <= 0) goto L_0x03ba;	 Catch:{ NumberFormatException -> 0x03ba }
        L_0x0301:
            r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x03ba }
            if (r7 <= 0) goto L_0x03ba;	 Catch:{ NumberFormatException -> 0x03ba }
        L_0x0305:
            r7 = r9.dimensionRatioSide;	 Catch:{ NumberFormatException -> 0x03ba }
            if (r7 != r3) goto L_0x0312;	 Catch:{ NumberFormatException -> 0x03ba }
        L_0x0309:
            r6 = r6 / r5;	 Catch:{ NumberFormatException -> 0x03ba }
            r5 = java.lang.Math.abs(r6);	 Catch:{ NumberFormatException -> 0x03ba }
            r9.dimensionRatioValue = r5;	 Catch:{ NumberFormatException -> 0x03ba }
            goto L_0x03ba;	 Catch:{ NumberFormatException -> 0x03ba }
        L_0x0312:
            r5 = r5 / r6;	 Catch:{ NumberFormatException -> 0x03ba }
            r5 = java.lang.Math.abs(r5);	 Catch:{ NumberFormatException -> 0x03ba }
            r9.dimensionRatioValue = r5;	 Catch:{ NumberFormatException -> 0x03ba }
            goto L_0x03ba;
        L_0x031b:
            r5 = r9.dimensionRatio;
            r5 = r5.substring(r6);
            r6 = r5.length();
            if (r6 <= 0) goto L_0x03ba;
        L_0x0327:
            r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x03ba }
            r9.dimensionRatioValue = r5;	 Catch:{ NumberFormatException -> 0x03ba }
            goto L_0x03ba;
        L_0x032f:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight;
            if (r5 != r6) goto L_0x033b;
        L_0x0333:
            r5 = r10.getFloat(r5, r2);
            r9.horizontalWeight = r5;
            goto L_0x03ba;
        L_0x033b:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight;
            if (r5 != r6) goto L_0x0347;
        L_0x033f:
            r5 = r10.getFloat(r5, r2);
            r9.verticalWeight = r5;
            goto L_0x03ba;
        L_0x0347:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle;
            if (r5 != r6) goto L_0x0353;
        L_0x034b:
            r5 = r10.getInt(r5, r4);
            r9.horizontalChainStyle = r5;
            goto L_0x03ba;
        L_0x0353:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle;
            if (r5 != r6) goto L_0x035e;
        L_0x0357:
            r5 = r10.getInt(r5, r4);
            r9.verticalChainStyle = r5;
            goto L_0x03ba;
        L_0x035e:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default;
            if (r5 != r6) goto L_0x0369;
        L_0x0362:
            r5 = r10.getInt(r5, r4);
            r9.matchConstraintDefaultWidth = r5;
            goto L_0x03ba;
        L_0x0369:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default;
            if (r5 != r6) goto L_0x0374;
        L_0x036d:
            r5 = r10.getInt(r5, r4);
            r9.matchConstraintDefaultHeight = r5;
            goto L_0x03ba;
        L_0x0374:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min;
            if (r5 != r6) goto L_0x0381;
        L_0x0378:
            r6 = r9.matchConstraintMinWidth;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.matchConstraintMinWidth = r5;
            goto L_0x03ba;
        L_0x0381:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max;
            if (r5 != r6) goto L_0x038e;
        L_0x0385:
            r6 = r9.matchConstraintMaxWidth;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.matchConstraintMaxWidth = r5;
            goto L_0x03ba;
        L_0x038e:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min;
            if (r5 != r6) goto L_0x039b;
        L_0x0392:
            r6 = r9.matchConstraintMinHeight;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.matchConstraintMinHeight = r5;
            goto L_0x03ba;
        L_0x039b:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max;
            if (r5 != r6) goto L_0x03a8;
        L_0x039f:
            r6 = r9.matchConstraintMaxHeight;
            r5 = r10.getDimensionPixelSize(r5, r6);
            r9.matchConstraintMaxHeight = r5;
            goto L_0x03ba;
        L_0x03a8:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator;
            if (r5 == r6) goto L_0x03ba;
        L_0x03ac:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator;
            if (r5 == r6) goto L_0x03ba;
        L_0x03b0:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator;
            if (r5 == r6) goto L_0x03ba;
        L_0x03b4:
            r6 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator;
            if (r5 == r6) goto L_0x03ba;
        L_0x03b8:
            r5 = android.support.constraint.R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator;
        L_0x03ba:
            r1 = r1 + 1;
            goto L_0x0084;
        L_0x03be:
            r10.recycle();
            r9.validate();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            super.resolveLayoutDirection(i);
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            this.resolvedHorizontalBias = this.horizontalBias;
            Object obj = 1;
            if (1 != getLayoutDirection()) {
                obj = null;
            }
            if (obj != null) {
                if (this.startToEnd != -1) {
                    this.resolvedRightToLeft = this.startToEnd;
                } else if (this.startToStart != -1) {
                    this.resolvedRightToRight = this.startToStart;
                }
                if (this.endToStart != -1) {
                    this.resolvedLeftToRight = this.endToStart;
                }
                if (this.endToEnd != -1) {
                    this.resolvedLeftToLeft = this.endToEnd;
                }
                if (this.goneStartMargin != -1) {
                    this.resolveGoneRightMargin = this.goneStartMargin;
                }
                if (this.goneEndMargin != -1) {
                    this.resolveGoneLeftMargin = this.goneEndMargin;
                }
                this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
            } else {
                if (this.startToEnd != -1) {
                    this.resolvedLeftToRight = this.startToEnd;
                }
                if (this.startToStart != -1) {
                    this.resolvedLeftToLeft = this.startToStart;
                }
                if (this.endToStart != -1) {
                    this.resolvedRightToLeft = this.endToStart;
                }
                if (this.endToEnd != -1) {
                    this.resolvedRightToRight = this.endToEnd;
                }
                if (this.goneStartMargin != -1) {
                    this.resolveGoneLeftMargin = this.goneStartMargin;
                }
                if (this.goneEndMargin != -1) {
                    this.resolveGoneRightMargin = this.goneEndMargin;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1) {
                if (this.rightToLeft != -1) {
                    this.resolvedRightToLeft = this.rightToLeft;
                } else if (this.rightToRight != -1) {
                    this.resolvedRightToRight = this.rightToRight;
                }
            }
            if (this.startToStart == -1 && this.startToEnd == -1) {
                if (this.leftToLeft != -1) {
                    this.resolvedLeftToLeft = this.leftToLeft;
                } else if (this.leftToRight != -1) {
                    this.resolvedLeftToRight = this.leftToRight;
                }
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = attributeSet.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = attributeSet.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = attributeSet.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = attributeSet.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = attributeSet.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = attributeSet.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = attributeSet.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    index = attributeSet.getResourceId(index, 0);
                    this.mConstraintSet = new ConstraintSet();
                    this.mConstraintSet.load(getContext(), index);
                }
            }
            attributeSet.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        Object obj = null;
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void setChildrenConstraints() {
        if (this.mConstraintSet != null) {
            r0.mConstraintSet.applyToInternal(r0);
        }
        int childCount = getChildCount();
        r0.mLayoutWidget.removeAllChildren();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ConstraintWidget viewWidget = getViewWidget(childAt);
            if (viewWidget != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                viewWidget.reset();
                viewWidget.setVisibility(childAt.getVisibility());
                viewWidget.setCompanionWidget(childAt);
                r0.mLayoutWidget.add(viewWidget);
                if (!(layoutParams.verticalDimensionFixed && layoutParams.horizontalDimensionFixed)) {
                    r0.mVariableDimensionsWidgets.add(viewWidget);
                }
                if (layoutParams.isGuideline) {
                    Guideline guideline = (Guideline) viewWidget;
                    if (layoutParams.guideBegin != -1) {
                        guideline.setGuideBegin(layoutParams.guideBegin);
                    }
                    if (layoutParams.guideEnd != -1) {
                        guideline.setGuideEnd(layoutParams.guideEnd);
                    }
                    if (layoutParams.guidePercent != -1.0f) {
                        guideline.setGuidePercent(layoutParams.guidePercent);
                    }
                } else if (!(layoutParams.resolvedLeftToLeft == -1 && layoutParams.resolvedLeftToRight == -1 && layoutParams.resolvedRightToLeft == -1 && layoutParams.resolvedRightToRight == -1 && layoutParams.topToTop == -1 && layoutParams.topToBottom == -1 && layoutParams.bottomToTop == -1 && layoutParams.bottomToBottom == -1 && layoutParams.baselineToBaseline == -1 && layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1 && layoutParams.width != -1 && layoutParams.height != -1)) {
                    ConstraintWidget targetWidget;
                    float f;
                    int i2 = layoutParams.resolvedLeftToLeft;
                    int i3 = layoutParams.resolvedLeftToRight;
                    int i4 = layoutParams.resolvedRightToLeft;
                    int i5 = layoutParams.resolvedRightToRight;
                    int i6 = layoutParams.resolveGoneLeftMargin;
                    int i7 = layoutParams.resolveGoneRightMargin;
                    float f2 = layoutParams.resolvedHorizontalBias;
                    if (VERSION.SDK_INT < 17) {
                        i2 = layoutParams.leftToLeft;
                        i3 = layoutParams.leftToRight;
                        i4 = layoutParams.rightToLeft;
                        i5 = layoutParams.rightToRight;
                        i6 = layoutParams.goneLeftMargin;
                        i7 = layoutParams.goneRightMargin;
                        f2 = layoutParams.horizontalBias;
                        if (i2 == -1 && i3 == -1) {
                            if (layoutParams.startToStart != -1) {
                                i2 = layoutParams.startToStart;
                            } else if (layoutParams.startToEnd != -1) {
                                i3 = layoutParams.startToEnd;
                            }
                        }
                        if (i4 == -1 && i5 == -1) {
                            if (layoutParams.endToStart != -1) {
                                i4 = layoutParams.endToStart;
                            } else if (layoutParams.endToEnd != -1) {
                                i5 = layoutParams.endToEnd;
                            }
                        }
                    }
                    int i8 = i4;
                    int i9 = i5;
                    int i10 = i7;
                    float f3 = f2;
                    int i11 = i6;
                    if (i2 != -1) {
                        targetWidget = getTargetWidget(i2);
                        if (targetWidget != null) {
                            f = f3;
                            viewWidget.immediateConnect(Type.LEFT, targetWidget, Type.LEFT, layoutParams.leftMargin, i11);
                        } else {
                            f = f3;
                        }
                    } else {
                        f = f3;
                        if (i3 != -1) {
                            targetWidget = getTargetWidget(i3);
                            if (targetWidget != null) {
                                viewWidget.immediateConnect(Type.LEFT, targetWidget, Type.RIGHT, layoutParams.leftMargin, i11);
                            }
                        }
                    }
                    if (i8 != -1) {
                        targetWidget = getTargetWidget(i8);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.RIGHT, targetWidget, Type.LEFT, layoutParams.rightMargin, i10);
                        }
                    } else if (i9 != -1) {
                        targetWidget = getTargetWidget(i9);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.RIGHT, targetWidget, Type.RIGHT, layoutParams.rightMargin, i10);
                        }
                    }
                    if (layoutParams.topToTop != -1) {
                        targetWidget = getTargetWidget(layoutParams.topToTop);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.TOP, targetWidget, Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                        }
                    } else if (layoutParams.topToBottom != -1) {
                        targetWidget = getTargetWidget(layoutParams.topToBottom);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.TOP, targetWidget, Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                        }
                    }
                    if (layoutParams.bottomToTop != -1) {
                        targetWidget = getTargetWidget(layoutParams.bottomToTop);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.BOTTOM, targetWidget, Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                        }
                    } else if (layoutParams.bottomToBottom != -1) {
                        targetWidget = getTargetWidget(layoutParams.bottomToBottom);
                        if (targetWidget != null) {
                            viewWidget.immediateConnect(Type.BOTTOM, targetWidget, Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                        }
                    }
                    if (layoutParams.baselineToBaseline != -1) {
                        childAt = (View) r0.mChildrenByIds.get(layoutParams.baselineToBaseline);
                        ConstraintWidget targetWidget2 = getTargetWidget(layoutParams.baselineToBaseline);
                        if (!(targetWidget2 == null || childAt == null || !(childAt.getLayoutParams() instanceof LayoutParams))) {
                            LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                            layoutParams.needsBaseline = true;
                            layoutParams2.needsBaseline = true;
                            viewWidget.getAnchor(Type.BASELINE).connect(targetWidget2.getAnchor(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                            viewWidget.getAnchor(Type.TOP).reset();
                            viewWidget.getAnchor(Type.BOTTOM).reset();
                        }
                    }
                    if (f >= 0.0f && f != PayBaseConstants.HALF_OF_FLOAT) {
                        viewWidget.setHorizontalBiasPercent(f);
                    }
                    if (layoutParams.verticalBias >= 0.0f && layoutParams.verticalBias != PayBaseConstants.HALF_OF_FLOAT) {
                        viewWidget.setVerticalBiasPercent(layoutParams.verticalBias);
                    }
                    if (isInEditMode() && !(layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1)) {
                        viewWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                    }
                    if (layoutParams.horizontalDimensionFixed) {
                        viewWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                        viewWidget.setWidth(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        viewWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                        viewWidget.getAnchor(Type.LEFT).mMargin = layoutParams.leftMargin;
                        viewWidget.getAnchor(Type.RIGHT).mMargin = layoutParams.rightMargin;
                    } else {
                        viewWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                        viewWidget.setWidth(0);
                    }
                    if (layoutParams.verticalDimensionFixed) {
                        viewWidget.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                        viewWidget.setHeight(layoutParams.height);
                    } else if (layoutParams.height == -1) {
                        viewWidget.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                        viewWidget.getAnchor(Type.TOP).mMargin = layoutParams.topMargin;
                        viewWidget.getAnchor(Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                    } else {
                        viewWidget.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                        viewWidget.setHeight(0);
                    }
                    if (layoutParams.dimensionRatio != null) {
                        viewWidget.setDimensionRatio(layoutParams.dimensionRatio);
                    }
                    viewWidget.setHorizontalWeight(layoutParams.horizontalWeight);
                    viewWidget.setVerticalWeight(layoutParams.verticalWeight);
                    viewWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                    viewWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
                    viewWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth);
                    viewWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight);
                }
            }
        }
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = (View) this.mChildrenByIds.get(i);
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return 0;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void internalMeasureChildren(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!layoutParams.isGuideline) {
                    Object obj;
                    Object obj2;
                    int baseline;
                    int i6 = layoutParams.width;
                    int i7 = layoutParams.height;
                    Object obj3 = 1;
                    if (!(layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || ((!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1))) {
                        if (!layoutParams.verticalDimensionFixed) {
                            if (layoutParams.matchConstraintDefaultHeight != 1) {
                                if (layoutParams.height == -1) {
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (i6 != 0) {
                                if (i6 == -1) {
                                    i6 = getChildMeasureSpec(i3, paddingLeft, i6);
                                    obj2 = null;
                                    if (i7 != 0) {
                                        if (i7 != -1) {
                                            i7 = getChildMeasureSpec(i4, paddingTop, i7);
                                            obj3 = null;
                                            childAt.measure(i6, i7);
                                            i6 = childAt.getMeasuredWidth();
                                            i7 = childAt.getMeasuredHeight();
                                        }
                                    }
                                    i7 = getChildMeasureSpec(i4, paddingTop, -2);
                                    childAt.measure(i6, i7);
                                    i6 = childAt.getMeasuredWidth();
                                    i7 = childAt.getMeasuredHeight();
                                }
                            }
                            i6 = getChildMeasureSpec(i3, paddingLeft, -2);
                            obj2 = 1;
                            if (i7 != 0) {
                                if (i7 != -1) {
                                    i7 = getChildMeasureSpec(i4, paddingTop, i7);
                                    obj3 = null;
                                    childAt.measure(i6, i7);
                                    i6 = childAt.getMeasuredWidth();
                                    i7 = childAt.getMeasuredHeight();
                                }
                            }
                            i7 = getChildMeasureSpec(i4, paddingTop, -2);
                            childAt.measure(i6, i7);
                            i6 = childAt.getMeasuredWidth();
                            i7 = childAt.getMeasuredHeight();
                        } else {
                            obj3 = null;
                            obj2 = obj3;
                        }
                        constraintWidget.setWidth(i6);
                        constraintWidget.setHeight(i7);
                        if (obj2 != null) {
                            constraintWidget.setWrapWidth(i6);
                        }
                        if (obj3 != null) {
                            constraintWidget.setWrapHeight(i7);
                        }
                        if (layoutParams.needsBaseline) {
                            baseline = childAt.getBaseline();
                            if (baseline != -1) {
                                constraintWidget.setBaselineDistance(baseline);
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        obj3 = null;
                        obj2 = obj3;
                    } else {
                        if (i6 != 0) {
                            if (i6 == -1) {
                                i6 = getChildMeasureSpec(i3, paddingLeft, i6);
                                obj2 = null;
                                if (i7 != 0) {
                                    if (i7 != -1) {
                                        i7 = getChildMeasureSpec(i4, paddingTop, i7);
                                        obj3 = null;
                                        childAt.measure(i6, i7);
                                        i6 = childAt.getMeasuredWidth();
                                        i7 = childAt.getMeasuredHeight();
                                    }
                                }
                                i7 = getChildMeasureSpec(i4, paddingTop, -2);
                                childAt.measure(i6, i7);
                                i6 = childAt.getMeasuredWidth();
                                i7 = childAt.getMeasuredHeight();
                            }
                        }
                        i6 = getChildMeasureSpec(i3, paddingLeft, -2);
                        obj2 = 1;
                        if (i7 != 0) {
                            if (i7 != -1) {
                                i7 = getChildMeasureSpec(i4, paddingTop, i7);
                                obj3 = null;
                                childAt.measure(i6, i7);
                                i6 = childAt.getMeasuredWidth();
                                i7 = childAt.getMeasuredHeight();
                            }
                        }
                        i7 = getChildMeasureSpec(i4, paddingTop, -2);
                        childAt.measure(i6, i7);
                        i6 = childAt.getMeasuredWidth();
                        i7 = childAt.getMeasuredHeight();
                    }
                    constraintWidget.setWidth(i6);
                    constraintWidget.setHeight(i7);
                    if (obj2 != null) {
                        constraintWidget.setWrapWidth(i6);
                    }
                    if (obj3 != null) {
                        constraintWidget.setWrapHeight(i7);
                    }
                    if (layoutParams.needsBaseline) {
                        baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            constraintWidget.setBaselineDistance(baseline);
                        }
                    }
                }
            }
        }
        ConstraintLayout constraintLayout = this;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.mLayoutWidget.setX(paddingLeft);
        this.mLayoutWidget.setY(paddingTop);
        setSelfDimensionBehaviour(i, i2);
        int i6 = 0;
        if (this.mDirtyHierarchy) {
            r0.mDirtyHierarchy = false;
            updateHierarchy();
        }
        internalMeasureChildren(i, i2);
        if (getChildCount() > 0) {
            solveLinearSystem();
        }
        int size = r0.mVariableDimensionsWidgets.size();
        paddingTop += getPaddingBottom();
        paddingLeft += getPaddingRight();
        if (size > 0) {
            int i7 = r0.mLayoutWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            int i8 = r0.mLayoutWidget.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            int i9 = 0;
            i3 = i9;
            while (i6 < size) {
                int i10;
                ConstraintWidget constraintWidget = (ConstraintWidget) r0.mVariableDimensionsWidgets.get(i6);
                if (!(constraintWidget instanceof Guideline)) {
                    View view = (View) constraintWidget.getCompanionWidget();
                    if (!(view == null || view.getVisibility() == 8)) {
                        int childMeasureSpec;
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        if (layoutParams.width == -2) {
                            childMeasureSpec = getChildMeasureSpec(i4, paddingLeft, layoutParams.width);
                        } else {
                            childMeasureSpec = MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                        }
                        i10 = size;
                        if (layoutParams.height == -2) {
                            size = getChildMeasureSpec(i5, paddingTop, layoutParams.height);
                        } else {
                            size = MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                        }
                        view.measure(childMeasureSpec, size);
                        size = view.getMeasuredWidth();
                        int measuredHeight = view.getMeasuredHeight();
                        if (size != constraintWidget.getWidth()) {
                            constraintWidget.setWidth(size);
                            if (i7 != 0 && constraintWidget.getRight() > r0.mLayoutWidget.getWidth()) {
                                r0.mLayoutWidget.setWidth(Math.max(r0.mMinWidth, constraintWidget.getRight() + constraintWidget.getAnchor(Type.RIGHT).getMargin()));
                            }
                            i9 = 1;
                        }
                        if (measuredHeight != constraintWidget.getHeight()) {
                            constraintWidget.setHeight(measuredHeight);
                            if (i8 != 0 && constraintWidget.getBottom() > r0.mLayoutWidget.getHeight()) {
                                r0.mLayoutWidget.setHeight(Math.max(r0.mMinHeight, constraintWidget.getBottom() + constraintWidget.getAnchor(Type.BOTTOM).getMargin()));
                            }
                            i9 = 1;
                        }
                        if (layoutParams.needsBaseline) {
                            size = view.getBaseline();
                            if (!(size == -1 || size == constraintWidget.getBaselineDistance())) {
                                constraintWidget.setBaselineDistance(size);
                                i9 = 1;
                            }
                        }
                        if (VERSION.SDK_INT >= 11) {
                            i3 = combineMeasuredStates(i3, view.getMeasuredState());
                        }
                        i6++;
                        size = i10;
                    }
                }
                i10 = size;
                i6++;
                size = i10;
            }
            if (i9 != 0) {
                solveLinearSystem();
            }
        } else {
            i3 = 0;
        }
        size = r0.mLayoutWidget.getWidth() + paddingLeft;
        paddingLeft = r0.mLayoutWidget.getHeight() + paddingTop;
        if (VERSION.SDK_INT >= 11) {
            i4 = Math.min(r0.mMaxWidth, resolveSizeAndState(size, i4, i3)) & ViewCompat.MEASURED_SIZE_MASK;
            i5 = Math.min(r0.mMaxHeight, resolveSizeAndState(paddingLeft, i5, i3 << 16)) & ViewCompat.MEASURED_SIZE_MASK;
            if (r0.mLayoutWidget.isWidthMeasuredTooSmall()) {
                i4 |= 16777216;
            }
            if (r0.mLayoutWidget.isHeightMeasuredTooSmall()) {
                i5 |= 16777216;
            }
            setMeasuredDimension(i4, i5);
            return;
        }
        setMeasuredDimension(size, paddingLeft);
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                i = Math.min(this.mMaxWidth, i) - paddingLeft;
            }
            i = 0;
        } else {
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                i2 = Math.min(this.mMaxHeight, i2) - paddingTop;
            }
            i2 = 0;
        } else {
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(i);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(i2);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    protected void solveLinearSystem() {
        this.mLayoutWidget.layout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        i = isInEditMode();
        for (boolean z2 = false; z2 < z; z2++) {
            i3 = getChildAt(z2);
            LayoutParams layoutParams = (LayoutParams) i3.getLayoutParams();
            if (i3.getVisibility() != 8 || layoutParams.isGuideline || i != 0) {
                i4 = layoutParams.widget;
                int drawX = i4.getDrawX();
                int drawY = i4.getDrawY();
                i3.layout(drawX, drawY, i4.getWidth() + drawX, i4.getHeight() + drawY);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
    }
}
