package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    static boolean ALLOW_ROOT_GROUP = true;
    private static final int CHAIN_FIRST = 0;
    private static final int CHAIN_FIRST_VISIBLE = 2;
    private static final int CHAIN_LAST = 1;
    private static final int CHAIN_LAST_VISIBLE = 3;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final boolean DEBUG_OPTIMIZE = false;
    private static final int FLAG_CHAIN_DANGLING = 1;
    private static final int FLAG_CHAIN_OPTIMIZE = 0;
    private static final int FLAG_RECOMPUTE_BOUNDS = 2;
    private static final int MAX_ITERATIONS = 8;
    public static final int OPTIMIZATION_ALL = 2;
    public static final int OPTIMIZATION_BASIC = 4;
    public static final int OPTIMIZATION_CHAIN = 8;
    public static final int OPTIMIZATION_NONE = 1;
    private static final boolean USE_SNAPSHOT = true;
    private static final boolean USE_THREAD = false;
    private boolean[] flags;
    protected LinearSystem mBackgroundSystem;
    private ConstraintWidget[] mChainEnds;
    private boolean mHeightMeasuredTooSmall;
    private ConstraintWidget[] mHorizontalChainsArray;
    private int mHorizontalChainsSize;
    private ConstraintWidget[] mMatchConstraintsChainedWidgets;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem;
    private ConstraintWidget[] mVerticalChainsArray;
    private int mVerticalChainsSize;
    private boolean mWidthMeasuredTooSmall;
    int mWrapHeight;
    int mWrapWidth;

    public String getType() {
        return "ConstraintLayout";
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public ConstraintWidgetContainer() {
        this.mSystem = new LinearSystem();
        this.mBackgroundSystem = null;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
        this.mVerticalChainsArray = new ConstraintWidget[4];
        this.mHorizontalChainsArray = new ConstraintWidget[4];
        this.mOptimizationLevel = 2;
        this.flags = new boolean[3];
        this.mChainEnds = new ConstraintWidget[4];
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mSystem = new LinearSystem();
        this.mBackgroundSystem = 0;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
        this.mVerticalChainsArray = new ConstraintWidget[4];
        this.mHorizontalChainsArray = new ConstraintWidget[4];
        this.mOptimizationLevel = 2;
        this.flags = new boolean[3];
        this.mChainEnds = new ConstraintWidget[4];
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mSystem = new LinearSystem();
        this.mBackgroundSystem = 0;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
        this.mVerticalChainsArray = new ConstraintWidget[4];
        this.mHorizontalChainsArray = new ConstraintWidget[4];
        this.mOptimizationLevel = 2;
        this.flags = new boolean[3];
        this.mChainEnds = new ConstraintWidget[4];
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public static ConstraintWidgetContainer createContainer(ConstraintWidgetContainer constraintWidgetContainer, String str, ArrayList<ConstraintWidget> arrayList, int i) {
        Rectangle bounds = WidgetContainer.getBounds(arrayList);
        if (bounds.width != 0) {
            if (bounds.height != 0) {
                int min;
                if (i > 0) {
                    min = Math.min(bounds.x, bounds.y);
                    if (i > min) {
                        i = min;
                    }
                    bounds.grow(i, i);
                }
                constraintWidgetContainer.setOrigin(bounds.x, bounds.y);
                constraintWidgetContainer.setDimension(bounds.width, bounds.height);
                constraintWidgetContainer.setDebugName(str);
                str = null;
                i = ((ConstraintWidget) arrayList.get(0)).getParent();
                min = arrayList.size();
                while (str < min) {
                    ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(str);
                    if (constraintWidget.getParent() == i) {
                        constraintWidgetContainer.add(constraintWidget);
                        constraintWidget.setX(constraintWidget.getX() - bounds.x);
                        constraintWidget.setY(constraintWidget.getY() - bounds.y);
                    }
                    str++;
                }
                return constraintWidgetContainer;
            }
        }
        return null;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem, int i) {
        boolean z;
        ConstraintWidget constraintWidget;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        addToSolver(linearSystem, i);
        int size = this.mChildren.size();
        int i2 = 0;
        if (this.mOptimizationLevel != 2) {
            if (this.mOptimizationLevel != 4) {
                z = true;
                while (i2 < size) {
                    constraintWidget = (ConstraintWidget) this.mChildren.get(i2);
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        if (z) {
                            Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                        }
                        constraintWidget.addToSolver(linearSystem, i);
                    } else {
                        dimensionBehaviour = constraintWidget.mHorizontalDimensionBehaviour;
                        dimensionBehaviour2 = constraintWidget.mVerticalDimensionBehaviour;
                        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                        }
                        if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                        }
                        constraintWidget.addToSolver(linearSystem, i);
                        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                        }
                        if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                            constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                        }
                    }
                    i2++;
                }
                if (this.mHorizontalChainsSize > 0) {
                    applyHorizontalChain(linearSystem);
                }
                if (this.mVerticalChainsSize > 0) {
                    applyVerticalChain(linearSystem);
                }
                return true;
            }
        }
        if (optimize(linearSystem)) {
            return false;
        }
        z = false;
        while (i2 < size) {
            constraintWidget = (ConstraintWidget) this.mChildren.get(i2);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                if (z) {
                    Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                }
                constraintWidget.addToSolver(linearSystem, i);
            } else {
                dimensionBehaviour = constraintWidget.mHorizontalDimensionBehaviour;
                dimensionBehaviour2 = constraintWidget.mVerticalDimensionBehaviour;
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem, i);
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
            i2++;
        }
        if (this.mHorizontalChainsSize > 0) {
            applyHorizontalChain(linearSystem);
        }
        if (this.mVerticalChainsSize > 0) {
            applyVerticalChain(linearSystem);
        }
        return true;
    }

    private boolean optimize(LinearSystem linearSystem) {
        int i;
        int size = this.mChildren.size();
        for (i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.mHorizontalResolution = -1;
            constraintWidget.mVerticalResolution = -1;
            if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidget.mHorizontalResolution = 1;
                constraintWidget.mVerticalResolution = 1;
            }
        }
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        while (!z) {
            int i2 = 0;
            boolean z4 = i2;
            boolean z5 = z4;
            while (i2 < size) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i2);
                if (constraintWidget2.mHorizontalResolution == -1) {
                    if (this.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget2.mHorizontalResolution = 1;
                    } else {
                        Optimizer.checkHorizontalSimpleDependency(this, linearSystem, constraintWidget2);
                    }
                }
                if (constraintWidget2.mVerticalResolution == -1) {
                    if (this.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget2.mVerticalResolution = 1;
                    } else {
                        Optimizer.checkVerticalSimpleDependency(this, linearSystem, constraintWidget2);
                    }
                }
                if (constraintWidget2.mVerticalResolution == -1) {
                    z4++;
                }
                if (constraintWidget2.mHorizontalResolution == -1) {
                    z5++;
                }
                i2++;
            }
            if (z4 || z5) {
                if (z2 == z4 && r6 == z5) {
                }
                z2 = z4;
                z3 = z5;
            }
            z = true;
            z2 = z4;
            z3 = z5;
        }
        linearSystem = null;
        i = linearSystem;
        int i3 = i;
        while (linearSystem < size) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.mChildren.get(linearSystem);
            if (constraintWidget3.mHorizontalResolution == 1 || constraintWidget3.mHorizontalResolution == -1) {
                i++;
            }
            if (constraintWidget3.mVerticalResolution == 1 || constraintWidget3.mVerticalResolution == -1) {
                i3++;
            }
            linearSystem++;
        }
        return i == 0 && i3 == 0;
    }

    private void applyHorizontalChain(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = this;
        LinearSystem linearSystem2 = linearSystem;
        int i = 0;
        int i2 = 0;
        while (i2 < constraintWidgetContainer.mHorizontalChainsSize) {
            int margin;
            LinearSystem linearSystem3;
            int i3;
            ConstraintWidget constraintWidget = constraintWidgetContainer.mHorizontalChainsArray[i2];
            int countMatchConstraintsChainedWidgets = constraintWidgetContainer.countMatchConstraintsChainedWidgets(linearSystem2, constraintWidgetContainer.mChainEnds, constraintWidgetContainer.mHorizontalChainsArray[i2], 0, constraintWidgetContainer.flags);
            ConstraintWidget constraintWidget2 = constraintWidgetContainer.mChainEnds[2];
            if (constraintWidget2 != null) {
                if (constraintWidgetContainer.flags[1]) {
                    countMatchConstraintsChainedWidgets = constraintWidget.getDrawX();
                    while (constraintWidget2 != null) {
                        linearSystem2.addEquality(constraintWidget2.mLeft.mSolverVariable, countMatchConstraintsChainedWidgets);
                        countMatchConstraintsChainedWidgets += (constraintWidget2.mLeft.getMargin() + constraintWidget2.getWidth()) + constraintWidget2.mRight.getMargin();
                        constraintWidget2 = constraintWidget2.mHorizontalNextWidget;
                    }
                } else {
                    int i4 = constraintWidget.mHorizontalChainStyle == 0 ? 1 : i;
                    int i5 = constraintWidget.mHorizontalChainStyle == 2 ? 1 : i;
                    int i6 = constraintWidgetContainer.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT ? 1 : i;
                    if ((constraintWidgetContainer.mOptimizationLevel == 2 || constraintWidgetContainer.mOptimizationLevel == 8) && constraintWidgetContainer.flags[i] && constraintWidget.mHorizontalChainFixedPosition && i5 == 0 && i6 == 0 && constraintWidget.mHorizontalChainStyle == 0) {
                        Optimizer.applyDirectResolutionHorizontalChain(constraintWidgetContainer, linearSystem2, countMatchConstraintsChainedWidgets, constraintWidget);
                    } else {
                        ConstraintWidget constraintWidget3;
                        ConstraintWidget constraintWidget4;
                        SolverVariable solverVariable;
                        ConstraintWidget constraintWidget5;
                        int margin2;
                        SolverVariable solverVariable2;
                        int i7 = 3;
                        if (countMatchConstraintsChainedWidgets != 0) {
                            if (i5 == 0) {
                                float f = 0.0f;
                                constraintWidget3 = null;
                                while (constraintWidget2 != null) {
                                    if (constraintWidget2.mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i6 = constraintWidget2.mLeft.getMargin();
                                        if (constraintWidget3 != null) {
                                            i6 += constraintWidget3.mRight.getMargin();
                                        }
                                        linearSystem2.addGreaterThan(constraintWidget2.mLeft.mSolverVariable, constraintWidget2.mLeft.mTarget.mSolverVariable, i6, constraintWidget2.mLeft.mTarget.mOwner.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT ? 2 : 3);
                                        i4 = constraintWidget2.mRight.getMargin();
                                        if (constraintWidget2.mRight.mTarget.mOwner.mLeft.mTarget != null && constraintWidget2.mRight.mTarget.mOwner.mLeft.mTarget.mOwner == constraintWidget2) {
                                            i4 += constraintWidget2.mRight.mTarget.mOwner.mLeft.getMargin();
                                        }
                                        linearSystem2.addLowerThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mRight.mTarget.mSolverVariable, -i4, constraintWidget2.mRight.mTarget.mOwner.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT ? 2 : 3);
                                    } else {
                                        f += constraintWidget2.mHorizontalWeight;
                                        if (constraintWidget2.mRight.mTarget != null) {
                                            i4 = constraintWidget2.mRight.getMargin();
                                            if (constraintWidget2 != constraintWidgetContainer.mChainEnds[3]) {
                                                i4 += constraintWidget2.mRight.mTarget.mOwner.mLeft.getMargin();
                                            }
                                        } else {
                                            i4 = i;
                                        }
                                        linearSystem2.addGreaterThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mLeft.mSolverVariable, i, 1);
                                        linearSystem2.addLowerThan(constraintWidget2.mRight.mSolverVariable, constraintWidget2.mRight.mTarget.mSolverVariable, -i4, 1);
                                    }
                                    constraintWidget3 = constraintWidget2;
                                    constraintWidget2 = constraintWidget2.mHorizontalNextWidget;
                                }
                                int i8;
                                if (countMatchConstraintsChainedWidgets != 1) {
                                    i8 = i;
                                    while (true) {
                                        i4 = countMatchConstraintsChainedWidgets - 1;
                                        if (i8 >= i4) {
                                            break;
                                        }
                                        ConstraintWidget constraintWidget6 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i8];
                                        i8++;
                                        constraintWidget4 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i8];
                                        solverVariable = constraintWidget6.mLeft.mSolverVariable;
                                        SolverVariable solverVariable3 = constraintWidget6.mRight.mSolverVariable;
                                        SolverVariable solverVariable4 = constraintWidget4.mLeft.mSolverVariable;
                                        SolverVariable solverVariable5 = constraintWidget4.mRight.mSolverVariable;
                                        if (constraintWidget4 == constraintWidgetContainer.mChainEnds[i7]) {
                                            solverVariable5 = constraintWidgetContainer.mChainEnds[1].mRight.mSolverVariable;
                                        }
                                        margin = constraintWidget6.mLeft.getMargin();
                                        if (!(constraintWidget6.mLeft.mTarget == null || constraintWidget6.mLeft.mTarget.mOwner.mRight.mTarget == null || constraintWidget6.mLeft.mTarget.mOwner.mRight.mTarget.mOwner != constraintWidget6)) {
                                            margin += constraintWidget6.mLeft.mTarget.mOwner.mRight.getMargin();
                                        }
                                        int i9 = countMatchConstraintsChainedWidgets;
                                        linearSystem2.addGreaterThan(solverVariable, constraintWidget6.mLeft.mTarget.mSolverVariable, margin, 2);
                                        countMatchConstraintsChainedWidgets = constraintWidget6.mRight.getMargin();
                                        if (!(constraintWidget6.mRight.mTarget == null || constraintWidget6.mHorizontalNextWidget == null)) {
                                            countMatchConstraintsChainedWidgets += constraintWidget6.mHorizontalNextWidget.mLeft.mTarget != null ? constraintWidget6.mHorizontalNextWidget.mLeft.getMargin() : 0;
                                        }
                                        linearSystem2.addLowerThan(solverVariable3, constraintWidget6.mRight.mTarget.mSolverVariable, -countMatchConstraintsChainedWidgets, 2);
                                        if (i8 == i4) {
                                            countMatchConstraintsChainedWidgets = constraintWidget4.mLeft.getMargin();
                                            if (!(constraintWidget4.mLeft.mTarget == null || constraintWidget4.mLeft.mTarget.mOwner.mRight.mTarget == null || constraintWidget4.mLeft.mTarget.mOwner.mRight.mTarget.mOwner != constraintWidget4)) {
                                                countMatchConstraintsChainedWidgets += constraintWidget4.mLeft.mTarget.mOwner.mRight.getMargin();
                                            }
                                            linearSystem2.addGreaterThan(solverVariable4, constraintWidget4.mLeft.mTarget.mSolverVariable, countMatchConstraintsChainedWidgets, 2);
                                            ConstraintAnchor constraintAnchor = constraintWidget4.mRight;
                                            if (constraintWidget4 == constraintWidgetContainer.mChainEnds[3]) {
                                                constraintAnchor = constraintWidgetContainer.mChainEnds[1].mRight;
                                            }
                                            i4 = constraintAnchor.getMargin();
                                            if (!(constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner.mLeft.mTarget == null || constraintAnchor.mTarget.mOwner.mLeft.mTarget.mOwner != constraintWidget4)) {
                                                i4 += constraintAnchor.mTarget.mOwner.mLeft.getMargin();
                                            }
                                            margin = 2;
                                            linearSystem2.addLowerThan(solverVariable5, constraintAnchor.mTarget.mSolverVariable, -i4, 2);
                                        } else {
                                            margin = 2;
                                        }
                                        if (constraintWidget.mMatchConstraintMaxWidth > 0) {
                                            linearSystem2.addLowerThan(solverVariable3, solverVariable, constraintWidget.mMatchConstraintMaxWidth, margin);
                                        }
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualDimension(constraintWidget6.mHorizontalWeight, f, constraintWidget4.mHorizontalWeight, solverVariable, constraintWidget6.mLeft.getMargin(), solverVariable3, constraintWidget6.mRight.getMargin(), solverVariable4, constraintWidget4.mLeft.getMargin(), solverVariable5, constraintWidget4.mRight.getMargin());
                                        linearSystem2.addConstraint(createRow);
                                        countMatchConstraintsChainedWidgets = i9;
                                        i7 = 3;
                                        i = 0;
                                    }
                                } else {
                                    constraintWidget5 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i];
                                    i8 = constraintWidget5.mLeft.getMargin();
                                    if (constraintWidget5.mLeft.mTarget != null) {
                                        i8 += constraintWidget5.mLeft.mTarget.getMargin();
                                    }
                                    i4 = constraintWidget5.mRight.getMargin();
                                    if (constraintWidget5.mRight.mTarget != null) {
                                        i4 += constraintWidget5.mRight.mTarget.getMargin();
                                    }
                                    SolverVariable solverVariable6 = constraintWidget.mRight.mTarget.mSolverVariable;
                                    if (constraintWidget5 == constraintWidgetContainer.mChainEnds[3]) {
                                        solverVariable6 = constraintWidgetContainer.mChainEnds[1].mRight.mTarget.mSolverVariable;
                                    }
                                    if (constraintWidget5.mMatchConstraintDefaultWidth == 1) {
                                        linearSystem2.addGreaterThan(constraintWidget.mLeft.mSolverVariable, constraintWidget.mLeft.mTarget.mSolverVariable, i8, 1);
                                        linearSystem2.addLowerThan(constraintWidget.mRight.mSolverVariable, solverVariable6, -i4, 1);
                                        linearSystem2.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidget.mLeft.mSolverVariable, constraintWidget.getWidth(), 2);
                                    } else {
                                        linearSystem2.addEquality(constraintWidget5.mLeft.mSolverVariable, constraintWidget5.mLeft.mTarget.mSolverVariable, i8, 1);
                                        linearSystem2.addEquality(constraintWidget5.mRight.mSolverVariable, solverVariable6, -i4, 1);
                                    }
                                }
                            }
                        }
                        constraintWidget5 = constraintWidget2;
                        ConstraintWidget constraintWidget7 = null;
                        ConstraintWidget constraintWidget8 = constraintWidget7;
                        Object obj = null;
                        while (constraintWidget5 != null) {
                            ConstraintWidget constraintWidget9;
                            Object obj2;
                            ConstraintWidget constraintWidget10;
                            int i10;
                            ConstraintWidget constraintWidget11;
                            constraintWidget4 = constraintWidget5.mHorizontalNextWidget;
                            if (constraintWidget4 == null) {
                                constraintWidget9 = constraintWidgetContainer.mChainEnds[1];
                                obj2 = 1;
                            } else {
                                constraintWidget9 = constraintWidget7;
                                obj2 = obj;
                            }
                            ConstraintAnchor constraintAnchor2;
                            int margin3;
                            if (i5 != 0) {
                                constraintAnchor2 = constraintWidget5.mLeft;
                                margin3 = constraintAnchor2.getMargin();
                                if (constraintWidget8 != null) {
                                    margin3 += constraintWidget8.mRight.getMargin();
                                }
                                linearSystem2.addGreaterThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, margin3, constraintWidget2 != constraintWidget5 ? 3 : 1);
                                if (constraintWidget5.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    ConstraintAnchor constraintAnchor3 = constraintWidget5.mRight;
                                    if (constraintWidget5.mMatchConstraintDefaultWidth == 1) {
                                        linearSystem2.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor2.mSolverVariable, Math.max(constraintWidget5.mMatchConstraintMinWidth, constraintWidget5.getWidth()), 3);
                                    } else {
                                        linearSystem2.addGreaterThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, constraintAnchor2.mMargin, 3);
                                        linearSystem2.addLowerThan(constraintAnchor3.mSolverVariable, constraintAnchor2.mSolverVariable, constraintWidget5.mMatchConstraintMinWidth, 3);
                                    }
                                }
                            } else if (i4 != 0 || obj2 == null || constraintWidget8 == null) {
                                if (i4 != 0 || obj2 != null || constraintWidget8 != null) {
                                    ConstraintWidget constraintWidget12;
                                    ConstraintAnchor constraintAnchor4 = constraintWidget5.mLeft;
                                    constraintAnchor2 = constraintWidget5.mRight;
                                    margin2 = constraintAnchor4.getMargin();
                                    margin3 = constraintAnchor2.getMargin();
                                    constraintWidget10 = constraintWidget5;
                                    i10 = i4;
                                    linearSystem2.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, margin2, 1);
                                    int i11 = i2;
                                    linearSystem2.addLowerThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, -margin3, 1);
                                    SolverVariable solverVariable7 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                    if (constraintWidget8 == null) {
                                        solverVariable7 = constraintWidget.mLeft.mTarget != null ? constraintWidget.mLeft.mTarget.mSolverVariable : null;
                                    }
                                    if (constraintWidget4 == null) {
                                        constraintWidget4 = constraintWidget9.mRight.mTarget != null ? constraintWidget9.mRight.mTarget.mOwner : null;
                                    }
                                    constraintWidget3 = constraintWidget4;
                                    if (constraintWidget3 != null) {
                                        SolverVariable solverVariable8 = constraintWidget3.mLeft.mSolverVariable;
                                        if (obj2 != null) {
                                            solverVariable8 = constraintWidget9.mRight.mTarget != null ? constraintWidget9.mRight.mTarget.mSolverVariable : null;
                                        }
                                        if (!(solverVariable7 == null || solverVariable8 == null)) {
                                            int i12 = margin3;
                                            solverVariable = solverVariable7;
                                            constraintWidget5 = constraintWidget;
                                            solverVariable2 = solverVariable8;
                                            margin = i11;
                                            constraintWidget11 = constraintWidget9;
                                            constraintWidget12 = constraintWidget3;
                                            linearSystem3 = linearSystem2;
                                            linearSystem2.addCentering(constraintAnchor4.mSolverVariable, solverVariable, margin2, PayBaseConstants.HALF_OF_FLOAT, solverVariable2, constraintAnchor2.mSolverVariable, i12, 4);
                                            constraintWidget4 = constraintWidget12;
                                            if (obj2 == null) {
                                                constraintWidget4 = null;
                                            }
                                            constraintWidget = constraintWidget5;
                                            obj = obj2;
                                            linearSystem2 = linearSystem3;
                                            i2 = margin;
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget7 = constraintWidget11;
                                            constraintWidget8 = constraintWidget10;
                                            i4 = i10;
                                            constraintWidgetContainer = this;
                                        }
                                    }
                                    constraintWidget12 = constraintWidget3;
                                    constraintWidget5 = constraintWidget;
                                    constraintWidget11 = constraintWidget9;
                                    linearSystem3 = linearSystem2;
                                    margin = i11;
                                    constraintWidget4 = constraintWidget12;
                                    if (obj2 == null) {
                                        constraintWidget4 = null;
                                    }
                                    constraintWidget = constraintWidget5;
                                    obj = obj2;
                                    linearSystem2 = linearSystem3;
                                    i2 = margin;
                                    constraintWidget5 = constraintWidget4;
                                    constraintWidget7 = constraintWidget11;
                                    constraintWidget8 = constraintWidget10;
                                    i4 = i10;
                                    constraintWidgetContainer = this;
                                } else if (constraintWidget5.mLeft.mTarget == null) {
                                    linearSystem2.addEquality(constraintWidget5.mLeft.mSolverVariable, constraintWidget5.getDrawX());
                                } else {
                                    linearSystem2.addEquality(constraintWidget5.mLeft.mSolverVariable, constraintWidget.mLeft.mTarget.mSolverVariable, constraintWidget5.mLeft.getMargin(), 5);
                                }
                            } else if (constraintWidget5.mRight.mTarget == null) {
                                linearSystem2.addEquality(constraintWidget5.mRight.mSolverVariable, constraintWidget5.getDrawRight());
                            } else {
                                linearSystem2.addEquality(constraintWidget5.mRight.mSolverVariable, constraintWidget9.mRight.mTarget.mSolverVariable, -constraintWidget5.mRight.getMargin(), 5);
                            }
                            constraintWidget10 = constraintWidget5;
                            i10 = i4;
                            constraintWidget5 = constraintWidget;
                            margin = i2;
                            constraintWidget11 = constraintWidget9;
                            linearSystem3 = linearSystem2;
                            if (obj2 == null) {
                                constraintWidget4 = null;
                            }
                            constraintWidget = constraintWidget5;
                            obj = obj2;
                            linearSystem2 = linearSystem3;
                            i2 = margin;
                            constraintWidget5 = constraintWidget4;
                            constraintWidget7 = constraintWidget11;
                            constraintWidget8 = constraintWidget10;
                            i4 = i10;
                            constraintWidgetContainer = this;
                        }
                        constraintWidget5 = constraintWidget;
                        margin = i2;
                        linearSystem3 = linearSystem2;
                        i3 = 0;
                        if (i5 != 0) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget2.mLeft;
                            ConstraintAnchor constraintAnchor6 = constraintWidget7.mRight;
                            margin2 = constraintAnchor5.getMargin();
                            i = constraintAnchor6.getMargin();
                            solverVariable = constraintWidget5.mLeft.mTarget != null ? constraintWidget5.mLeft.mTarget.mSolverVariable : null;
                            solverVariable2 = constraintWidget7.mRight.mTarget != null ? constraintWidget7.mRight.mTarget.mSolverVariable : null;
                            if (!(solverVariable == null || solverVariable2 == null)) {
                                linearSystem3.addLowerThan(constraintAnchor6.mSolverVariable, solverVariable2, -i, 1);
                                linearSystem3.addCentering(constraintAnchor5.mSolverVariable, solverVariable, margin2, constraintWidget5.mHorizontalBiasPercent, solverVariable2, constraintAnchor6.mSolverVariable, i, 4);
                            }
                        }
                        i2 = margin + 1;
                        linearSystem2 = linearSystem3;
                        i = i3;
                        constraintWidgetContainer = this;
                    }
                }
            }
            margin = i2;
            i3 = i;
            linearSystem3 = linearSystem2;
            i2 = margin + 1;
            linearSystem2 = linearSystem3;
            i = i3;
            constraintWidgetContainer = this;
        }
    }

    private void applyVerticalChain(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = this;
        LinearSystem linearSystem2 = linearSystem;
        int i = 0;
        int i2 = 0;
        while (i2 < constraintWidgetContainer.mVerticalChainsSize) {
            int margin;
            LinearSystem linearSystem3;
            int i3;
            ConstraintWidget constraintWidget = constraintWidgetContainer.mVerticalChainsArray[i2];
            int countMatchConstraintsChainedWidgets = constraintWidgetContainer.countMatchConstraintsChainedWidgets(linearSystem2, constraintWidgetContainer.mChainEnds, constraintWidgetContainer.mVerticalChainsArray[i2], 1, constraintWidgetContainer.flags);
            ConstraintWidget constraintWidget2 = constraintWidgetContainer.mChainEnds[2];
            if (constraintWidget2 != null) {
                if (constraintWidgetContainer.flags[1]) {
                    countMatchConstraintsChainedWidgets = constraintWidget.getDrawY();
                    while (constraintWidget2 != null) {
                        linearSystem2.addEquality(constraintWidget2.mTop.mSolverVariable, countMatchConstraintsChainedWidgets);
                        countMatchConstraintsChainedWidgets += (constraintWidget2.mTop.getMargin() + constraintWidget2.getHeight()) + constraintWidget2.mBottom.getMargin();
                        constraintWidget2 = constraintWidget2.mVerticalNextWidget;
                    }
                } else {
                    int i4 = constraintWidget.mVerticalChainStyle == 0 ? 1 : i;
                    int i5 = constraintWidget.mVerticalChainStyle == 2 ? 1 : i;
                    int i6 = constraintWidgetContainer.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT ? 1 : i;
                    if ((constraintWidgetContainer.mOptimizationLevel == 2 || constraintWidgetContainer.mOptimizationLevel == 8) && constraintWidgetContainer.flags[i] && constraintWidget.mVerticalChainFixedPosition && i5 == 0 && i6 == 0 && constraintWidget.mVerticalChainStyle == 0) {
                        Optimizer.applyDirectResolutionVerticalChain(constraintWidgetContainer, linearSystem2, countMatchConstraintsChainedWidgets, constraintWidget);
                    } else {
                        ConstraintWidget constraintWidget3;
                        ConstraintWidget constraintWidget4;
                        SolverVariable solverVariable;
                        SolverVariable solverVariable2;
                        ConstraintWidget constraintWidget5;
                        int margin2;
                        SolverVariable solverVariable3;
                        int i7 = 3;
                        if (countMatchConstraintsChainedWidgets != 0) {
                            if (i5 == 0) {
                                float f = 0.0f;
                                constraintWidget3 = null;
                                while (constraintWidget2 != null) {
                                    if (constraintWidget2.mVerticalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                                        i6 = constraintWidget2.mTop.getMargin();
                                        if (constraintWidget3 != null) {
                                            i6 += constraintWidget3.mBottom.getMargin();
                                        }
                                        linearSystem2.addGreaterThan(constraintWidget2.mTop.mSolverVariable, constraintWidget2.mTop.mTarget.mSolverVariable, i6, constraintWidget2.mTop.mTarget.mOwner.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT ? 2 : 3);
                                        i4 = constraintWidget2.mBottom.getMargin();
                                        if (constraintWidget2.mBottom.mTarget.mOwner.mTop.mTarget != null && constraintWidget2.mBottom.mTarget.mOwner.mTop.mTarget.mOwner == constraintWidget2) {
                                            i4 += constraintWidget2.mBottom.mTarget.mOwner.mTop.getMargin();
                                        }
                                        linearSystem2.addLowerThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mBottom.mTarget.mSolverVariable, -i4, constraintWidget2.mBottom.mTarget.mOwner.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT ? 2 : 3);
                                    } else {
                                        f += constraintWidget2.mVerticalWeight;
                                        if (constraintWidget2.mBottom.mTarget != null) {
                                            i4 = constraintWidget2.mBottom.getMargin();
                                            if (constraintWidget2 != constraintWidgetContainer.mChainEnds[3]) {
                                                i4 += constraintWidget2.mBottom.mTarget.mOwner.mTop.getMargin();
                                            }
                                        } else {
                                            i4 = i;
                                        }
                                        linearSystem2.addGreaterThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mTop.mSolverVariable, i, 1);
                                        linearSystem2.addLowerThan(constraintWidget2.mBottom.mSolverVariable, constraintWidget2.mBottom.mTarget.mSolverVariable, -i4, 1);
                                    }
                                    constraintWidget3 = constraintWidget2;
                                    constraintWidget2 = constraintWidget2.mVerticalNextWidget;
                                }
                                int i8;
                                if (countMatchConstraintsChainedWidgets != 1) {
                                    i8 = i;
                                    while (true) {
                                        i4 = countMatchConstraintsChainedWidgets - 1;
                                        if (i8 >= i4) {
                                            break;
                                        }
                                        ConstraintWidget constraintWidget6 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i8];
                                        i8++;
                                        constraintWidget4 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i8];
                                        solverVariable = constraintWidget6.mTop.mSolverVariable;
                                        solverVariable2 = constraintWidget6.mBottom.mSolverVariable;
                                        SolverVariable solverVariable4 = constraintWidget4.mTop.mSolverVariable;
                                        SolverVariable solverVariable5 = constraintWidget4.mBottom.mSolverVariable;
                                        if (constraintWidget4 == constraintWidgetContainer.mChainEnds[i7]) {
                                            solverVariable5 = constraintWidgetContainer.mChainEnds[1].mBottom.mSolverVariable;
                                        }
                                        margin = constraintWidget6.mTop.getMargin();
                                        if (!(constraintWidget6.mTop.mTarget == null || constraintWidget6.mTop.mTarget.mOwner.mBottom.mTarget == null || constraintWidget6.mTop.mTarget.mOwner.mBottom.mTarget.mOwner != constraintWidget6)) {
                                            margin += constraintWidget6.mTop.mTarget.mOwner.mBottom.getMargin();
                                        }
                                        int i9 = countMatchConstraintsChainedWidgets;
                                        linearSystem2.addGreaterThan(solverVariable, constraintWidget6.mTop.mTarget.mSolverVariable, margin, 2);
                                        countMatchConstraintsChainedWidgets = constraintWidget6.mBottom.getMargin();
                                        if (!(constraintWidget6.mBottom.mTarget == null || constraintWidget6.mVerticalNextWidget == null)) {
                                            countMatchConstraintsChainedWidgets += constraintWidget6.mVerticalNextWidget.mTop.mTarget != null ? constraintWidget6.mVerticalNextWidget.mTop.getMargin() : 0;
                                        }
                                        linearSystem2.addLowerThan(solverVariable2, constraintWidget6.mBottom.mTarget.mSolverVariable, -countMatchConstraintsChainedWidgets, 2);
                                        if (i8 == i4) {
                                            countMatchConstraintsChainedWidgets = constraintWidget4.mTop.getMargin();
                                            if (!(constraintWidget4.mTop.mTarget == null || constraintWidget4.mTop.mTarget.mOwner.mBottom.mTarget == null || constraintWidget4.mTop.mTarget.mOwner.mBottom.mTarget.mOwner != constraintWidget4)) {
                                                countMatchConstraintsChainedWidgets += constraintWidget4.mTop.mTarget.mOwner.mBottom.getMargin();
                                            }
                                            linearSystem2.addGreaterThan(solverVariable4, constraintWidget4.mTop.mTarget.mSolverVariable, countMatchConstraintsChainedWidgets, 2);
                                            ConstraintAnchor constraintAnchor = constraintWidget4.mBottom;
                                            if (constraintWidget4 == constraintWidgetContainer.mChainEnds[3]) {
                                                constraintAnchor = constraintWidgetContainer.mChainEnds[1].mBottom;
                                            }
                                            i4 = constraintAnchor.getMargin();
                                            if (!(constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner.mTop.mTarget == null || constraintAnchor.mTarget.mOwner.mTop.mTarget.mOwner != constraintWidget4)) {
                                                i4 += constraintAnchor.mTarget.mOwner.mTop.getMargin();
                                            }
                                            margin = 2;
                                            linearSystem2.addLowerThan(solverVariable5, constraintAnchor.mTarget.mSolverVariable, -i4, 2);
                                        } else {
                                            margin = 2;
                                        }
                                        if (constraintWidget.mMatchConstraintMaxHeight > 0) {
                                            linearSystem2.addLowerThan(solverVariable2, solverVariable, constraintWidget.mMatchConstraintMaxHeight, margin);
                                        }
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualDimension(constraintWidget6.mVerticalWeight, f, constraintWidget4.mVerticalWeight, solverVariable, constraintWidget6.mTop.getMargin(), solverVariable2, constraintWidget6.mBottom.getMargin(), solverVariable4, constraintWidget4.mTop.getMargin(), solverVariable5, constraintWidget4.mBottom.getMargin());
                                        linearSystem2.addConstraint(createRow);
                                        countMatchConstraintsChainedWidgets = i9;
                                        i7 = 3;
                                        i = 0;
                                    }
                                } else {
                                    constraintWidget5 = constraintWidgetContainer.mMatchConstraintsChainedWidgets[i];
                                    i8 = constraintWidget5.mTop.getMargin();
                                    if (constraintWidget5.mTop.mTarget != null) {
                                        i8 += constraintWidget5.mTop.mTarget.getMargin();
                                    }
                                    i4 = constraintWidget5.mBottom.getMargin();
                                    if (constraintWidget5.mBottom.mTarget != null) {
                                        i4 += constraintWidget5.mBottom.mTarget.getMargin();
                                    }
                                    SolverVariable solverVariable6 = constraintWidget.mBottom.mTarget.mSolverVariable;
                                    if (constraintWidget5 == constraintWidgetContainer.mChainEnds[3]) {
                                        solverVariable6 = constraintWidgetContainer.mChainEnds[1].mBottom.mTarget.mSolverVariable;
                                    }
                                    if (constraintWidget5.mMatchConstraintDefaultHeight == 1) {
                                        linearSystem2.addGreaterThan(constraintWidget.mTop.mSolverVariable, constraintWidget.mTop.mTarget.mSolverVariable, i8, 1);
                                        linearSystem2.addLowerThan(constraintWidget.mBottom.mSolverVariable, solverVariable6, -i4, 1);
                                        linearSystem2.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidget.mTop.mSolverVariable, constraintWidget.getHeight(), 2);
                                    } else {
                                        linearSystem2.addEquality(constraintWidget5.mTop.mSolverVariable, constraintWidget5.mTop.mTarget.mSolverVariable, i8, 1);
                                        linearSystem2.addEquality(constraintWidget5.mBottom.mSolverVariable, solverVariable6, -i4, 1);
                                    }
                                }
                            }
                        }
                        constraintWidget5 = constraintWidget2;
                        ConstraintWidget constraintWidget7 = null;
                        ConstraintWidget constraintWidget8 = constraintWidget7;
                        Object obj = null;
                        while (constraintWidget5 != null) {
                            ConstraintWidget constraintWidget9;
                            Object obj2;
                            ConstraintWidget constraintWidget10;
                            int i10;
                            ConstraintWidget constraintWidget11;
                            constraintWidget4 = constraintWidget5.mVerticalNextWidget;
                            if (constraintWidget4 == null) {
                                constraintWidget9 = constraintWidgetContainer.mChainEnds[1];
                                obj2 = 1;
                            } else {
                                constraintWidget9 = constraintWidget7;
                                obj2 = obj;
                            }
                            ConstraintAnchor constraintAnchor2;
                            int margin3;
                            if (i5 != 0) {
                                SolverVariable solverVariable7;
                                constraintAnchor2 = constraintWidget5.mTop;
                                margin3 = constraintAnchor2.getMargin();
                                if (constraintWidget8 != null) {
                                    margin3 += constraintWidget8.mBottom.getMargin();
                                }
                                margin = constraintWidget2 != constraintWidget5 ? 3 : 1;
                                if (constraintAnchor2.mTarget != null) {
                                    solverVariable2 = constraintAnchor2.mSolverVariable;
                                    solverVariable7 = constraintAnchor2.mTarget.mSolverVariable;
                                } else if (constraintWidget5.mBaseline.mTarget != null) {
                                    solverVariable2 = constraintWidget5.mBaseline.mSolverVariable;
                                    solverVariable7 = constraintWidget5.mBaseline.mTarget.mSolverVariable;
                                    margin3 -= constraintAnchor2.getMargin();
                                } else {
                                    solverVariable2 = null;
                                    solverVariable7 = solverVariable2;
                                }
                                if (!(solverVariable2 == null || solverVariable7 == null)) {
                                    linearSystem2.addGreaterThan(solverVariable2, solverVariable7, margin3, margin);
                                }
                                if (constraintWidget5.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                                    ConstraintAnchor constraintAnchor3 = constraintWidget5.mBottom;
                                    if (constraintWidget5.mMatchConstraintDefaultHeight == 1) {
                                        linearSystem2.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor2.mSolverVariable, Math.max(constraintWidget5.mMatchConstraintMinHeight, constraintWidget5.getHeight()), 3);
                                    } else {
                                        linearSystem2.addGreaterThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, constraintAnchor2.mMargin, 3);
                                        linearSystem2.addLowerThan(constraintAnchor3.mSolverVariable, constraintAnchor2.mSolverVariable, constraintWidget5.mMatchConstraintMinHeight, 3);
                                    }
                                }
                            } else if (i4 != 0 || obj2 == null || constraintWidget8 == null) {
                                if (i4 != 0 || obj2 != null || constraintWidget8 != null) {
                                    ConstraintWidget constraintWidget12;
                                    ConstraintAnchor constraintAnchor4 = constraintWidget5.mTop;
                                    constraintAnchor2 = constraintWidget5.mBottom;
                                    margin2 = constraintAnchor4.getMargin();
                                    margin3 = constraintAnchor2.getMargin();
                                    constraintWidget10 = constraintWidget5;
                                    i10 = i4;
                                    linearSystem2.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, margin2, 1);
                                    int i11 = i2;
                                    linearSystem2.addLowerThan(constraintAnchor2.mSolverVariable, constraintAnchor2.mTarget.mSolverVariable, -margin3, 1);
                                    SolverVariable solverVariable8 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                    if (constraintWidget8 == null) {
                                        solverVariable8 = constraintWidget.mTop.mTarget != null ? constraintWidget.mTop.mTarget.mSolverVariable : null;
                                    }
                                    if (constraintWidget4 == null) {
                                        constraintWidget4 = constraintWidget9.mBottom.mTarget != null ? constraintWidget9.mBottom.mTarget.mOwner : null;
                                    }
                                    constraintWidget3 = constraintWidget4;
                                    if (constraintWidget3 != null) {
                                        SolverVariable solverVariable9 = constraintWidget3.mTop.mSolverVariable;
                                        if (obj2 != null) {
                                            solverVariable9 = constraintWidget9.mBottom.mTarget != null ? constraintWidget9.mBottom.mTarget.mSolverVariable : null;
                                        }
                                        if (!(solverVariable8 == null || solverVariable9 == null)) {
                                            int i12 = margin3;
                                            solverVariable = solverVariable8;
                                            constraintWidget5 = constraintWidget;
                                            solverVariable3 = solverVariable9;
                                            margin = i11;
                                            constraintWidget11 = constraintWidget9;
                                            constraintWidget12 = constraintWidget3;
                                            linearSystem3 = linearSystem2;
                                            linearSystem2.addCentering(constraintAnchor4.mSolverVariable, solverVariable, margin2, PayBaseConstants.HALF_OF_FLOAT, solverVariable3, constraintAnchor2.mSolverVariable, i12, 4);
                                            constraintWidget4 = constraintWidget12;
                                            if (obj2 == null) {
                                                constraintWidget4 = null;
                                            }
                                            constraintWidget = constraintWidget5;
                                            obj = obj2;
                                            linearSystem2 = linearSystem3;
                                            i2 = margin;
                                            constraintWidget5 = constraintWidget4;
                                            constraintWidget7 = constraintWidget11;
                                            constraintWidget8 = constraintWidget10;
                                            i4 = i10;
                                            constraintWidgetContainer = this;
                                        }
                                    }
                                    constraintWidget12 = constraintWidget3;
                                    constraintWidget5 = constraintWidget;
                                    constraintWidget11 = constraintWidget9;
                                    linearSystem3 = linearSystem2;
                                    margin = i11;
                                    constraintWidget4 = constraintWidget12;
                                    if (obj2 == null) {
                                        constraintWidget4 = null;
                                    }
                                    constraintWidget = constraintWidget5;
                                    obj = obj2;
                                    linearSystem2 = linearSystem3;
                                    i2 = margin;
                                    constraintWidget5 = constraintWidget4;
                                    constraintWidget7 = constraintWidget11;
                                    constraintWidget8 = constraintWidget10;
                                    i4 = i10;
                                    constraintWidgetContainer = this;
                                } else if (constraintWidget5.mTop.mTarget == null) {
                                    linearSystem2.addEquality(constraintWidget5.mTop.mSolverVariable, constraintWidget5.getDrawY());
                                } else {
                                    linearSystem2.addEquality(constraintWidget5.mTop.mSolverVariable, constraintWidget.mTop.mTarget.mSolverVariable, constraintWidget5.mTop.getMargin(), 5);
                                }
                            } else if (constraintWidget5.mBottom.mTarget == null) {
                                linearSystem2.addEquality(constraintWidget5.mBottom.mSolverVariable, constraintWidget5.getDrawBottom());
                            } else {
                                linearSystem2.addEquality(constraintWidget5.mBottom.mSolverVariable, constraintWidget9.mBottom.mTarget.mSolverVariable, -constraintWidget5.mBottom.getMargin(), 5);
                            }
                            constraintWidget10 = constraintWidget5;
                            i10 = i4;
                            constraintWidget5 = constraintWidget;
                            margin = i2;
                            constraintWidget11 = constraintWidget9;
                            linearSystem3 = linearSystem2;
                            if (obj2 == null) {
                                constraintWidget4 = null;
                            }
                            constraintWidget = constraintWidget5;
                            obj = obj2;
                            linearSystem2 = linearSystem3;
                            i2 = margin;
                            constraintWidget5 = constraintWidget4;
                            constraintWidget7 = constraintWidget11;
                            constraintWidget8 = constraintWidget10;
                            i4 = i10;
                            constraintWidgetContainer = this;
                        }
                        constraintWidget5 = constraintWidget;
                        margin = i2;
                        linearSystem3 = linearSystem2;
                        i3 = 0;
                        if (i5 != 0) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget2.mTop;
                            ConstraintAnchor constraintAnchor6 = constraintWidget7.mBottom;
                            margin2 = constraintAnchor5.getMargin();
                            i = constraintAnchor6.getMargin();
                            solverVariable = constraintWidget5.mTop.mTarget != null ? constraintWidget5.mTop.mTarget.mSolverVariable : null;
                            solverVariable3 = constraintWidget7.mBottom.mTarget != null ? constraintWidget7.mBottom.mTarget.mSolverVariable : null;
                            if (!(solverVariable == null || solverVariable3 == null)) {
                                linearSystem3.addLowerThan(constraintAnchor6.mSolverVariable, solverVariable3, -i, 1);
                                linearSystem3.addCentering(constraintAnchor5.mSolverVariable, solverVariable, margin2, constraintWidget5.mVerticalBiasPercent, solverVariable3, constraintAnchor6.mSolverVariable, i, 4);
                            }
                        }
                        i2 = margin + 1;
                        linearSystem2 = linearSystem3;
                        i = i3;
                        constraintWidgetContainer = this;
                    }
                }
            }
            margin = i2;
            i3 = i;
            linearSystem3 = linearSystem2;
            i2 = margin + 1;
            linearSystem2 = linearSystem3;
            i = i3;
            constraintWidgetContainer = this;
        }
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, int i, boolean[] zArr) {
        int i2 = 0;
        zArr[2] = false;
        updateFromSolver(linearSystem, i);
        int size = this.mChildren.size();
        while (i2 < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i2);
            constraintWidget.updateFromSolver(linearSystem, i);
            if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
            i2++;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void layout() {
        boolean z;
        int i;
        Exception e;
        ConstraintWidget constraintWidget;
        int i2 = this.mX;
        int i3 = this.mY;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (this.mParent != null) {
            if (r1.mSnapshot == null) {
                r1.mSnapshot = new Snapshot(r1);
            }
            r1.mSnapshot.updateFrom(r1);
            setX(r1.mPaddingLeft);
            setY(r1.mPaddingTop);
            resetAnchors();
            resetSolverVariables(r1.mSystem.getCache());
        } else {
            r1.mX = 0;
            r1.mY = 0;
        }
        DimensionBehaviour dimensionBehaviour = r1.mVerticalDimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2 = r1.mHorizontalDimensionBehaviour;
        int i4 = 2;
        boolean z2 = true;
        if (r1.mOptimizationLevel == 2 && (r1.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT || r1.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)) {
            findWrapSize(r1.mChildren, r1.flags);
            z = r1.flags[0];
            if (max > 0 && max2 > 0 && (r1.mWrapWidth > max || r1.mWrapHeight > max2)) {
                z = false;
            }
            if (z) {
                if (r1.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                    if (max <= 0 || max >= r1.mWrapWidth) {
                        setWidth(Math.max(r1.mMinWidth, r1.mWrapWidth));
                    } else {
                        r1.mWidthMeasuredTooSmall = true;
                        setWidth(max);
                    }
                }
                if (r1.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
                    r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                    if (max2 <= 0 || max2 >= r1.mWrapHeight) {
                        setHeight(Math.max(r1.mMinHeight, r1.mWrapHeight));
                    } else {
                        r1.mHeightMeasuredTooSmall = true;
                        setHeight(max2);
                    }
                }
            }
        } else {
            z = false;
        }
        resetChains();
        int size = r1.mChildren.size();
        for (i = 0; i < size; i++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) r1.mChildren.get(i);
            if (constraintWidget2 instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget2).layout();
            }
        }
        i = 0;
        boolean z3 = z;
        z = true;
        while (z) {
            boolean addChildrenToSolver;
            int i5;
            int i6;
            i += z2;
            try {
                r1.mSystem.reset();
                addChildrenToSolver = addChildrenToSolver(r1.mSystem, Integer.MAX_VALUE);
                if (addChildrenToSolver) {
                    try {
                        r1.mSystem.minimize();
                    } catch (Exception e2) {
                        e = e2;
                        z = addChildrenToSolver;
                        e.printStackTrace();
                        addChildrenToSolver = z;
                        if (!addChildrenToSolver) {
                            updateChildrenFromSolver(r1.mSystem, Integer.MAX_VALUE, r1.flags);
                        } else {
                            updateFromSolver(r1.mSystem, Integer.MAX_VALUE);
                            i5 = 0;
                            while (i5 < size) {
                                constraintWidget = (ConstraintWidget) r1.mChildren.get(i5);
                                if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                                }
                                if (constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                                }
                                i5++;
                                i4 = 2;
                            }
                        }
                        i6 = i4;
                        if (i < 8) {
                        }
                        z2 = z3;
                        addChildrenToSolver = false;
                        i6 = Math.max(r1.mMinWidth, getWidth());
                        if (i6 > getWidth()) {
                            setWidth(i6);
                            r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                            addChildrenToSolver = true;
                            z2 = true;
                        }
                        i6 = Math.max(r1.mMinHeight, getHeight());
                        if (i6 > getHeight()) {
                            setHeight(i6);
                            r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                            addChildrenToSolver = true;
                            z2 = true;
                        }
                        if (!z2) {
                            r1.mWidthMeasuredTooSmall = true;
                            r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                            setWidth(max);
                            addChildrenToSolver = true;
                            z2 = true;
                            z = true;
                            r1.mHeightMeasuredTooSmall = true;
                            r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                            setHeight(max2);
                            addChildrenToSolver = true;
                            z3 = addChildrenToSolver;
                            z2 = z;
                            i4 = 2;
                            z = addChildrenToSolver;
                        }
                        z = true;
                        z3 = z2;
                        z2 = z;
                        i4 = 2;
                        z = addChildrenToSolver;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                addChildrenToSolver = z;
                if (!addChildrenToSolver) {
                    updateFromSolver(r1.mSystem, Integer.MAX_VALUE);
                    i5 = 0;
                    while (i5 < size) {
                        constraintWidget = (ConstraintWidget) r1.mChildren.get(i5);
                        if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                        if (constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                        }
                        i5++;
                        i4 = 2;
                    }
                } else {
                    updateChildrenFromSolver(r1.mSystem, Integer.MAX_VALUE, r1.flags);
                }
                i6 = i4;
                if (i < 8) {
                }
                z2 = z3;
                addChildrenToSolver = false;
                i6 = Math.max(r1.mMinWidth, getWidth());
                if (i6 > getWidth()) {
                    setWidth(i6);
                    r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                    addChildrenToSolver = true;
                    z2 = true;
                }
                i6 = Math.max(r1.mMinHeight, getHeight());
                if (i6 > getHeight()) {
                    setHeight(i6);
                    r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                    addChildrenToSolver = true;
                    z2 = true;
                }
                if (z2) {
                    r1.mWidthMeasuredTooSmall = true;
                    r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                    setWidth(max);
                    addChildrenToSolver = true;
                    z2 = true;
                    z = true;
                    r1.mHeightMeasuredTooSmall = true;
                    r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                    setHeight(max2);
                    addChildrenToSolver = true;
                    z3 = addChildrenToSolver;
                    z2 = z;
                    i4 = 2;
                    z = addChildrenToSolver;
                }
                z = true;
                z3 = z2;
                z2 = z;
                i4 = 2;
                z = addChildrenToSolver;
            }
            if (!addChildrenToSolver) {
                updateFromSolver(r1.mSystem, Integer.MAX_VALUE);
                i5 = 0;
                while (i5 < size) {
                    constraintWidget = (ConstraintWidget) r1.mChildren.get(i5);
                    if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getWidth() >= constraintWidget.getWrapWidth()) {
                        if (constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                            i6 = 2;
                            r1.flags[2] = z2;
                            break;
                        }
                        i5++;
                        i4 = 2;
                    } else {
                        i4 = 2;
                        r1.flags[2] = z2;
                        break;
                    }
                }
            }
            updateChildrenFromSolver(r1.mSystem, Integer.MAX_VALUE, r1.flags);
            i6 = i4;
            if (i < 8 || !r1.flags[r9]) {
                z2 = z3;
                addChildrenToSolver = false;
            } else {
                i4 = 0;
                int i7 = 0;
                for (i5 = 0; i5 < size; i5++) {
                    constraintWidget = (ConstraintWidget) r1.mChildren.get(i5);
                    i4 = Math.max(i4, constraintWidget.mX + constraintWidget.getWidth());
                    i7 = Math.max(i7, constraintWidget.mY + constraintWidget.getHeight());
                }
                i5 = Math.max(r1.mMinWidth, i4);
                i6 = Math.max(r1.mMinHeight, i7);
                if (dimensionBehaviour2 != DimensionBehaviour.WRAP_CONTENT || getWidth() >= i5) {
                    z2 = z3;
                    addChildrenToSolver = false;
                } else {
                    setWidth(i5);
                    r1.mHorizontalDimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    addChildrenToSolver = true;
                    z2 = true;
                }
                if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && getHeight() < i6) {
                    setHeight(i6);
                    r1.mVerticalDimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    addChildrenToSolver = true;
                    z2 = true;
                }
            }
            i6 = Math.max(r1.mMinWidth, getWidth());
            if (i6 > getWidth()) {
                setWidth(i6);
                r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                addChildrenToSolver = true;
                z2 = true;
            }
            i6 = Math.max(r1.mMinHeight, getHeight());
            if (i6 > getHeight()) {
                setHeight(i6);
                r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                addChildrenToSolver = true;
                z2 = true;
            }
            if (z2) {
                if (r1.mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && max > 0 && getWidth() > max) {
                    r1.mWidthMeasuredTooSmall = true;
                    r1.mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
                    setWidth(max);
                    addChildrenToSolver = true;
                    z2 = true;
                }
                if (r1.mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT && max2 > 0 && getHeight() > max2) {
                    z = true;
                    r1.mHeightMeasuredTooSmall = true;
                    r1.mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
                    setHeight(max2);
                    addChildrenToSolver = true;
                    z3 = addChildrenToSolver;
                    z2 = z;
                    i4 = 2;
                    z = addChildrenToSolver;
                }
            }
            z = true;
            z3 = z2;
            z2 = z;
            i4 = 2;
            z = addChildrenToSolver;
        }
        if (r1.mParent != null) {
            i2 = Math.max(r1.mMinWidth, getWidth());
            i3 = Math.max(r1.mMinHeight, getHeight());
            r1.mSnapshot.applyTo(r1);
            setWidth((i2 + r1.mPaddingLeft) + r1.mPaddingRight);
            setHeight((i3 + r1.mPaddingTop) + r1.mPaddingBottom);
        } else {
            r1.mX = i2;
            r1.mY = i3;
        }
        if (z3) {
            r1.mHorizontalDimensionBehaviour = dimensionBehaviour2;
            r1.mVerticalDimensionBehaviour = dimensionBehaviour;
        }
        resetSolverVariables(r1.mSystem.getCache());
        if (r1 == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    static int setGroup(ConstraintAnchor constraintAnchor, int i) {
        int i2 = constraintAnchor.mGroup;
        if (constraintAnchor.mOwner.getParent() == null) {
            return i;
        }
        if (i2 <= i) {
            return i2;
        }
        constraintAnchor.mGroup = i;
        ConstraintAnchor opposite = constraintAnchor.getOpposite();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (opposite != null) {
            i = setGroup(opposite, i);
        }
        if (constraintAnchor2 != null) {
            i = setGroup(constraintAnchor2, i);
        }
        if (opposite != null) {
            i = setGroup(opposite, i);
        }
        constraintAnchor.mGroup = i;
        return i;
    }

    public int layoutFindGroupsSimple() {
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.mLeft.mGroup = 0;
            constraintWidget.mRight.mGroup = 0;
            constraintWidget.mTop.mGroup = 1;
            constraintWidget.mBottom.mGroup = 1;
            constraintWidget.mBaseline.mGroup = 1;
        }
        return 2;
    }

    public void findHorizontalWrapRecursive(ConstraintWidget constraintWidget, boolean[] zArr) {
        boolean z = false;
        if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mDimensionRatio > 0.0f) {
            zArr[0] = false;
            return;
        }
        int optimizerWrapWidth = constraintWidget.getOptimizerWrapWidth();
        if (constraintWidget.mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mDimensionRatio <= 0.0f) {
            int i;
            boolean z2 = true;
            constraintWidget.mHorizontalWrapVisited = true;
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() != 1) {
                    zArr = optimizerWrapWidth;
                    z = zArr;
                } else if (guideline.getRelativeBegin() != -1) {
                    zArr = guideline.getRelativeBegin();
                } else if (guideline.getRelativeEnd() != -1) {
                    z = guideline.getRelativeEnd();
                    zArr = false;
                } else {
                    zArr = null;
                }
                i = z;
            } else if (!constraintWidget.mRight.isConnected() && !constraintWidget.mLeft.isConnected()) {
                zArr = constraintWidget.getX() + optimizerWrapWidth;
                i = optimizerWrapWidth;
            } else if (constraintWidget.mRight.mTarget == null || constraintWidget.mLeft.mTarget == null || (constraintWidget.mRight.mTarget != constraintWidget.mLeft.mTarget && (constraintWidget.mRight.mTarget.mOwner != constraintWidget.mLeft.mTarget.mOwner || constraintWidget.mRight.mTarget.mOwner == constraintWidget.mParent))) {
                ConstraintWidget constraintWidget2;
                ConstraintWidget constraintWidget3 = null;
                if (constraintWidget.mRight.mTarget != null) {
                    constraintWidget2 = constraintWidget.mRight.mTarget.mOwner;
                    i = constraintWidget.mRight.getMargin() + optimizerWrapWidth;
                    if (!(constraintWidget2.isRoot() || constraintWidget2.mHorizontalWrapVisited)) {
                        findHorizontalWrapRecursive(constraintWidget2, zArr);
                    }
                } else {
                    i = optimizerWrapWidth;
                    constraintWidget2 = null;
                }
                if (constraintWidget.mLeft.mTarget != null) {
                    constraintWidget3 = constraintWidget.mLeft.mTarget.mOwner;
                    optimizerWrapWidth += constraintWidget.mLeft.getMargin();
                    if (!(constraintWidget3.isRoot() || constraintWidget3.mHorizontalWrapVisited)) {
                        findHorizontalWrapRecursive(constraintWidget3, zArr);
                    }
                }
                zArr = optimizerWrapWidth;
                if (!(constraintWidget.mRight.mTarget == null || constraintWidget2.isRoot())) {
                    boolean z3;
                    if (constraintWidget.mRight.mTarget.mType == Type.RIGHT) {
                        i += constraintWidget2.mDistToRight - constraintWidget2.getOptimizerWrapWidth();
                    } else if (constraintWidget.mRight.mTarget.getType() == Type.LEFT) {
                        i += constraintWidget2.mDistToRight;
                    }
                    if (!constraintWidget2.mRightHasCentered) {
                        if (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null || constraintWidget2.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                            z3 = false;
                            constraintWidget.mRightHasCentered = z3;
                            if (constraintWidget.mRightHasCentered && (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mLeft.mTarget.mOwner != constraintWidget)) {
                                i += i - constraintWidget2.mDistToRight;
                            }
                        }
                    }
                    z3 = true;
                    constraintWidget.mRightHasCentered = z3;
                    i += i - constraintWidget2.mDistToRight;
                }
                if (!(constraintWidget.mLeft.mTarget == null || constraintWidget3.isRoot())) {
                    if (constraintWidget.mLeft.mTarget.getType() == Type.LEFT) {
                        zArr += constraintWidget3.mDistToLeft - constraintWidget3.getOptimizerWrapWidth();
                    } else if (constraintWidget.mLeft.mTarget.getType() == Type.RIGHT) {
                        zArr += constraintWidget3.mDistToLeft;
                    }
                    if (!constraintWidget3.mLeftHasCentered) {
                        if (constraintWidget3.mLeft.mTarget == null || constraintWidget3.mRight.mTarget == null || constraintWidget3.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                            z2 = false;
                        }
                    }
                    constraintWidget.mLeftHasCentered = z2;
                    if (constraintWidget.mLeftHasCentered && (constraintWidget3.mRight.mTarget == null || constraintWidget3.mRight.mTarget.mOwner != constraintWidget)) {
                        zArr += zArr - constraintWidget3.mDistToLeft;
                    }
                }
            } else {
                zArr[0] = false;
                return;
            }
            if (constraintWidget.getVisibility() == 8) {
                zArr -= constraintWidget.mWidth;
                i -= constraintWidget.mWidth;
            }
            constraintWidget.mDistToLeft = zArr;
            constraintWidget.mDistToRight = i;
            return;
        }
        zArr[0] = false;
    }

    public void findVerticalWrapRecursive(ConstraintWidget constraintWidget, boolean[] zArr) {
        boolean z = false;
        if (constraintWidget.mVerticalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mDimensionRatio <= 0.0f) {
            int optimizerWrapHeight = constraintWidget.getOptimizerWrapHeight();
            boolean z2 = true;
            constraintWidget.mVerticalWrapVisited = true;
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() != 0) {
                    zArr = optimizerWrapHeight;
                    z = zArr;
                } else if (guideline.getRelativeBegin() != -1) {
                    zArr = guideline.getRelativeBegin();
                } else if (guideline.getRelativeEnd() != -1) {
                    z = guideline.getRelativeEnd();
                    zArr = false;
                } else {
                    zArr = null;
                }
            } else if (constraintWidget.mBaseline.mTarget == null && constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                zArr = constraintWidget.getY() + optimizerWrapHeight;
                if (constraintWidget.getVisibility() == 8) {
                    zArr -= constraintWidget.mHeight;
                    optimizerWrapHeight -= constraintWidget.mHeight;
                }
                constraintWidget.mDistToTop = zArr;
                constraintWidget.mDistToBottom = optimizerWrapHeight;
                return;
            } else if (constraintWidget.mBottom.mTarget != null && constraintWidget.mTop.mTarget != null && (constraintWidget.mBottom.mTarget == constraintWidget.mTop.mTarget || (constraintWidget.mBottom.mTarget.mOwner == constraintWidget.mTop.mTarget.mOwner && constraintWidget.mBottom.mTarget.mOwner != constraintWidget.mParent))) {
                zArr[0] = false;
                return;
            } else if (constraintWidget.mBaseline.isConnected()) {
                ConstraintWidget owner = constraintWidget.mBaseline.mTarget.getOwner();
                if (!owner.mVerticalWrapVisited) {
                    findVerticalWrapRecursive(owner, zArr);
                }
                zArr = Math.max((owner.mDistToTop - owner.mHeight) + optimizerWrapHeight, optimizerWrapHeight);
                optimizerWrapHeight = Math.max((owner.mDistToBottom - owner.mHeight) + optimizerWrapHeight, optimizerWrapHeight);
                if (constraintWidget.getVisibility() == 8) {
                    zArr -= constraintWidget.mHeight;
                    optimizerWrapHeight -= constraintWidget.mHeight;
                }
                constraintWidget.mDistToTop = zArr;
                constraintWidget.mDistToBottom = optimizerWrapHeight;
                return;
            } else {
                ConstraintWidget owner2;
                int margin;
                ConstraintWidget constraintWidget2 = null;
                if (constraintWidget.mTop.isConnected()) {
                    owner2 = constraintWidget.mTop.mTarget.getOwner();
                    margin = constraintWidget.mTop.getMargin() + optimizerWrapHeight;
                    if (!(owner2.isRoot() || owner2.mVerticalWrapVisited)) {
                        findVerticalWrapRecursive(owner2, zArr);
                    }
                } else {
                    margin = optimizerWrapHeight;
                    owner2 = null;
                }
                if (constraintWidget.mBottom.isConnected()) {
                    constraintWidget2 = constraintWidget.mBottom.mTarget.getOwner();
                    optimizerWrapHeight += constraintWidget.mBottom.getMargin();
                    if (!(constraintWidget2.isRoot() || constraintWidget2.mVerticalWrapVisited)) {
                        findVerticalWrapRecursive(constraintWidget2, zArr);
                    }
                }
                if (constraintWidget.mTop.mTarget != null && owner2.isRoot() == null) {
                    if (constraintWidget.mTop.mTarget.getType() == Type.TOP) {
                        margin += owner2.mDistToTop - owner2.getOptimizerWrapHeight();
                    } else if (constraintWidget.mTop.mTarget.getType() == Type.BOTTOM) {
                        margin += owner2.mDistToTop;
                    }
                    if (owner2.mTopHasCentered == null) {
                        if (owner2.mTop.mTarget == null || owner2.mTop.mTarget.mOwner == constraintWidget || owner2.mBottom.mTarget == null || owner2.mBottom.mTarget.mOwner == constraintWidget || owner2.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                            zArr = null;
                            constraintWidget.mTopHasCentered = zArr;
                            if (constraintWidget.mTopHasCentered != null && (owner2.mBottom.mTarget == null || owner2.mBottom.mTarget.mOwner != constraintWidget)) {
                                margin += margin - owner2.mDistToTop;
                            }
                        }
                    }
                    zArr = 1;
                    constraintWidget.mTopHasCentered = zArr;
                    margin += margin - owner2.mDistToTop;
                }
                zArr = margin;
                if (!(constraintWidget.mBottom.mTarget == null || constraintWidget2.isRoot())) {
                    if (constraintWidget.mBottom.mTarget.getType() == Type.BOTTOM) {
                        optimizerWrapHeight += constraintWidget2.mDistToBottom - constraintWidget2.getOptimizerWrapHeight();
                    } else if (constraintWidget.mBottom.mTarget.getType() == Type.TOP) {
                        optimizerWrapHeight += constraintWidget2.mDistToBottom;
                    }
                    if (!constraintWidget2.mBottomHasCentered) {
                        if (constraintWidget2.mTop.mTarget == null || constraintWidget2.mTop.mTarget.mOwner == constraintWidget || constraintWidget2.mBottom.mTarget == null || constraintWidget2.mBottom.mTarget.mOwner == constraintWidget || constraintWidget2.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                            z2 = false;
                        }
                    }
                    constraintWidget.mBottomHasCentered = z2;
                    if (constraintWidget.mBottomHasCentered && (constraintWidget2.mTop.mTarget == null || constraintWidget2.mTop.mTarget.mOwner != constraintWidget)) {
                        z = optimizerWrapHeight + (optimizerWrapHeight - constraintWidget2.mDistToBottom);
                    }
                }
                if (constraintWidget.getVisibility() == 8) {
                    zArr -= constraintWidget.mHeight;
                    optimizerWrapHeight -= constraintWidget.mHeight;
                }
                constraintWidget.mDistToTop = zArr;
                constraintWidget.mDistToBottom = optimizerWrapHeight;
                return;
            }
            optimizerWrapHeight = z;
            if (constraintWidget.getVisibility() == 8) {
                zArr -= constraintWidget.mHeight;
                optimizerWrapHeight -= constraintWidget.mHeight;
            }
            constraintWidget.mDistToTop = zArr;
            constraintWidget.mDistToBottom = optimizerWrapHeight;
            return;
        }
        zArr[0] = false;
    }

    public void findWrapSize(ArrayList<ConstraintWidget> arrayList, boolean[] zArr) {
        ConstraintWidgetContainer constraintWidgetContainer = this;
        ArrayList<ConstraintWidget> arrayList2 = arrayList;
        boolean[] zArr2 = zArr;
        int size = arrayList.size();
        int i = 0;
        zArr2[0] = true;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i2 < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList2.get(i2);
            if (!constraintWidget.isRoot()) {
                if (!constraintWidget.mHorizontalWrapVisited) {
                    findHorizontalWrapRecursive(constraintWidget, zArr2);
                }
                if (!constraintWidget.mVerticalWrapVisited) {
                    findVerticalWrapRecursive(constraintWidget, zArr2);
                }
                if (zArr2[i]) {
                    int height = (constraintWidget.mDistToTop + constraintWidget.mDistToBottom) - constraintWidget.getHeight();
                    i = constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT ? (constraintWidget.getWidth() + constraintWidget.mLeft.mMargin) + constraintWidget.mRight.mMargin : (constraintWidget.mDistToLeft + constraintWidget.mDistToRight) - constraintWidget.getWidth();
                    int height2 = constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT ? (constraintWidget.getHeight() + constraintWidget.mTop.mMargin) + constraintWidget.mBottom.mMargin : height;
                    if (constraintWidget.getVisibility() == 8) {
                        i = 0;
                        height2 = 0;
                    }
                    i3 = Math.max(i3, constraintWidget.mDistToLeft);
                    i4 = Math.max(i4, constraintWidget.mDistToRight);
                    i7 = Math.max(i7, constraintWidget.mDistToBottom);
                    i6 = Math.max(i6, constraintWidget.mDistToTop);
                    i = Math.max(i5, i);
                    i8 = Math.max(i8, height2);
                    i5 = i;
                } else {
                    return;
                }
            }
            i2++;
            i = 0;
        }
        constraintWidgetContainer.mWrapWidth = Math.max(constraintWidgetContainer.mMinWidth, Math.max(Math.max(i3, i4), i5));
        constraintWidgetContainer.mWrapHeight = Math.max(constraintWidgetContainer.mMinHeight, Math.max(Math.max(i6, i7), i8));
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) arrayList2.get(i9);
            constraintWidget2.mHorizontalWrapVisited = false;
            constraintWidget2.mVerticalWrapVisited = false;
            constraintWidget2.mLeftHasCentered = false;
            constraintWidget2.mRightHasCentered = false;
            constraintWidget2.mTopHasCentered = false;
            constraintWidget2.mBottomHasCentered = false;
        }
    }

    public int layoutFindGroups() {
        int i;
        r1 = new Type[5];
        int i2 = 0;
        r1[0] = Type.LEFT;
        r1[1] = Type.RIGHT;
        r1[2] = Type.TOP;
        r1[3] = Type.BASELINE;
        r1[4] = Type.BOTTOM;
        int size = this.mChildren.size();
        int i3 = 1;
        for (i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            if (constraintAnchor.mTarget == null) {
                constraintAnchor.mGroup = Integer.MAX_VALUE;
            } else if (setGroup(constraintAnchor, i3) == i3) {
                i3++;
            }
            constraintAnchor = constraintWidget.mTop;
            if (constraintAnchor.mTarget == null) {
                constraintAnchor.mGroup = Integer.MAX_VALUE;
            } else if (setGroup(constraintAnchor, i3) == i3) {
                i3++;
            }
            constraintAnchor = constraintWidget.mRight;
            if (constraintAnchor.mTarget == null) {
                constraintAnchor.mGroup = Integer.MAX_VALUE;
            } else if (setGroup(constraintAnchor, i3) == i3) {
                i3++;
            }
            constraintAnchor = constraintWidget.mBottom;
            if (constraintAnchor.mTarget == null) {
                constraintAnchor.mGroup = Integer.MAX_VALUE;
            } else if (setGroup(constraintAnchor, i3) == i3) {
                i3++;
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget.mBaseline;
            if (constraintAnchor2.mTarget == null) {
                constraintAnchor2.mGroup = Integer.MAX_VALUE;
            } else if (setGroup(constraintAnchor2, i3) == i3) {
                i3++;
            }
        }
        i = 1;
        while (i != 0) {
            i = 0;
            i3 = i;
            while (i < size) {
                constraintWidget = (ConstraintWidget) this.mChildren.get(i);
                int i4 = i3;
                for (i3 = 0; i3 < 5; i3++) {
                    ConstraintAnchor constraintAnchor3 = null;
                    switch (r1[i3]) {
                        case LEFT:
                            constraintAnchor3 = constraintWidget.mLeft;
                            break;
                        case TOP:
                            constraintAnchor3 = constraintWidget.mTop;
                            break;
                        case RIGHT:
                            constraintAnchor3 = constraintWidget.mRight;
                            break;
                        case BOTTOM:
                            constraintAnchor3 = constraintWidget.mBottom;
                            break;
                        case BASELINE:
                            constraintAnchor3 = constraintWidget.mBaseline;
                            break;
                        default:
                            break;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                    if (constraintAnchor4 != null) {
                        if (!(constraintAnchor4.mOwner.getParent() == null || constraintAnchor4.mGroup == constraintAnchor3.mGroup)) {
                            i4 = constraintAnchor3.mGroup > constraintAnchor4.mGroup ? constraintAnchor4.mGroup : constraintAnchor3.mGroup;
                            constraintAnchor3.mGroup = i4;
                            constraintAnchor4.mGroup = i4;
                            i4 = 1;
                        }
                        constraintAnchor4 = constraintAnchor4.getOpposite();
                        if (!(constraintAnchor4 == null || constraintAnchor4.mGroup == constraintAnchor3.mGroup)) {
                            i4 = constraintAnchor3.mGroup > constraintAnchor4.mGroup ? constraintAnchor4.mGroup : constraintAnchor3.mGroup;
                            constraintAnchor3.mGroup = i4;
                            constraintAnchor4.mGroup = i4;
                            i4 = 1;
                        }
                    }
                }
                i++;
                i3 = i4;
            }
            i = i3;
        }
        int[] iArr = new int[((this.mChildren.size() * 5) + 1)];
        Arrays.fill(iArr, -1);
        int i5 = 0;
        while (i2 < size) {
            int i6;
            ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i2);
            ConstraintAnchor constraintAnchor5 = constraintWidget2.mLeft;
            if (constraintAnchor5.mGroup != Integer.MAX_VALUE) {
                i6 = constraintAnchor5.mGroup;
                if (iArr[i6] == -1) {
                    i4 = i5 + 1;
                    iArr[i6] = i5;
                    i5 = i4;
                }
                constraintAnchor5.mGroup = iArr[i6];
            }
            constraintAnchor5 = constraintWidget2.mTop;
            if (constraintAnchor5.mGroup != Integer.MAX_VALUE) {
                i6 = constraintAnchor5.mGroup;
                if (iArr[i6] == -1) {
                    i4 = i5 + 1;
                    iArr[i6] = i5;
                    i5 = i4;
                }
                constraintAnchor5.mGroup = iArr[i6];
            }
            constraintAnchor5 = constraintWidget2.mRight;
            if (constraintAnchor5.mGroup != Integer.MAX_VALUE) {
                i6 = constraintAnchor5.mGroup;
                if (iArr[i6] == -1) {
                    i4 = i5 + 1;
                    iArr[i6] = i5;
                    i5 = i4;
                }
                constraintAnchor5.mGroup = iArr[i6];
            }
            constraintAnchor5 = constraintWidget2.mBottom;
            if (constraintAnchor5.mGroup != Integer.MAX_VALUE) {
                i6 = constraintAnchor5.mGroup;
                if (iArr[i6] == -1) {
                    i4 = i5 + 1;
                    iArr[i6] = i5;
                    i5 = i4;
                }
                constraintAnchor5.mGroup = iArr[i6];
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget2.mBaseline;
            if (constraintAnchor6.mGroup != Integer.MAX_VALUE) {
                i3 = constraintAnchor6.mGroup;
                if (iArr[i3] == -1) {
                    i6 = i5 + 1;
                    iArr[i3] = i5;
                    i5 = i6;
                }
                constraintAnchor6.mGroup = iArr[i3];
            }
            i2++;
        }
        return i5;
    }

    public void layoutWithGroup(int i) {
        int i2 = this.mX;
        int i3 = this.mY;
        int i4 = 0;
        if (this.mParent != null) {
            if (this.mSnapshot == null) {
                this.mSnapshot = new Snapshot(this);
            }
            this.mSnapshot.updateFrom(this);
            this.mX = 0;
            this.mY = 0;
            resetAnchors();
            resetSolverVariables(this.mSystem.getCache());
        } else {
            this.mX = 0;
            this.mY = 0;
        }
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i5);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
        this.mLeft.mGroup = 0;
        this.mRight.mGroup = 0;
        this.mTop.mGroup = 1;
        this.mBottom.mGroup = 1;
        this.mSystem.reset();
        while (i4 < i) {
            try {
                addToSolver(this.mSystem, i4);
                this.mSystem.minimize();
                updateFromSolver(this.mSystem, i4);
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateFromSolver(this.mSystem, -2);
            i4++;
        }
        if (this.mParent != 0) {
            i = getWidth();
            i2 = getHeight();
            this.mSnapshot.applyTo(this);
            setWidth(i);
            setHeight(i2);
        } else {
            this.mX = i2;
            this.mY = i3;
        }
        if (this == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            while (constraintWidget.mLeft.mTarget != 0 && constraintWidget.mLeft.mTarget.mOwner.mRight.mTarget != 0 && constraintWidget.mLeft.mTarget.mOwner.mRight.mTarget == constraintWidget.mLeft && constraintWidget.mLeft.mTarget.mOwner != constraintWidget) {
                constraintWidget = constraintWidget.mLeft.mTarget.mOwner;
            }
            addHorizontalChain(constraintWidget);
            return;
        }
        if (i == 1) {
            while (constraintWidget.mTop.mTarget != 0 && constraintWidget.mTop.mTarget.mOwner.mBottom.mTarget != 0 && constraintWidget.mTop.mTarget.mOwner.mBottom.mTarget == constraintWidget.mTop && constraintWidget.mTop.mTarget.mOwner != constraintWidget) {
                constraintWidget = constraintWidget.mTop.mTarget.mOwner;
            }
            addVerticalChain(constraintWidget);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.mHorizontalChainsSize) {
            if (this.mHorizontalChainsArray[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = constraintWidget;
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = 0;
        while (i < this.mVerticalChainsSize) {
            if (this.mVerticalChainsArray[i] != constraintWidget) {
                i++;
            } else {
                return;
            }
        }
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = (ConstraintWidget[]) Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = constraintWidget;
        this.mVerticalChainsSize++;
    }

    private int countMatchConstraintsChainedWidgets(LinearSystem linearSystem, ConstraintWidget[] constraintWidgetArr, ConstraintWidget constraintWidget, int i, boolean[] zArr) {
        int i2;
        ConstraintWidget constraintWidget2 = this;
        LinearSystem linearSystem2 = linearSystem;
        ConstraintWidget constraintWidget3 = constraintWidget;
        zArr[0] = true;
        zArr[1] = false;
        ConstraintWidget constraintWidget4 = null;
        constraintWidgetArr[0] = null;
        constraintWidgetArr[2] = null;
        constraintWidgetArr[1] = null;
        constraintWidgetArr[3] = null;
        float f = 0.0f;
        int i3 = 5;
        int i4 = 8;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        int i5;
        int i6;
        if (i == 0) {
            boolean z = constraintWidget3.mLeft.mTarget == null || constraintWidget3.mLeft.mTarget.mOwner == constraintWidget2;
            constraintWidget3.mHorizontalNextWidget = null;
            i2 = 0;
            ConstraintWidget constraintWidget7 = null;
            constraintWidget5 = constraintWidget.getVisibility() != 8 ? constraintWidget3 : null;
            ConstraintWidget constraintWidget8 = constraintWidget5;
            constraintWidget6 = constraintWidget3;
            while (constraintWidget6.mRight.mTarget != null) {
                constraintWidget6.mHorizontalNextWidget = constraintWidget4;
                if (constraintWidget6.getVisibility() != 8) {
                    if (constraintWidget8 == null) {
                        constraintWidget8 = constraintWidget6;
                    }
                    if (!(constraintWidget5 == null || constraintWidget5 == constraintWidget6)) {
                        constraintWidget5.mHorizontalNextWidget = constraintWidget6;
                    }
                    constraintWidget5 = constraintWidget6;
                } else {
                    linearSystem2.addEquality(constraintWidget6.mLeft.mSolverVariable, constraintWidget6.mLeft.mTarget.mSolverVariable, 0, 5);
                    linearSystem2.addEquality(constraintWidget6.mRight.mSolverVariable, constraintWidget6.mLeft.mSolverVariable, 0, 5);
                }
                if (constraintWidget6.getVisibility() != 8 && constraintWidget6.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget6.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget6.mDimensionRatio <= f) {
                        zArr[0] = false;
                        i5 = i2 + 1;
                        if (i5 >= constraintWidget2.mMatchConstraintsChainedWidgets.length) {
                            constraintWidget2.mMatchConstraintsChainedWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidget2.mMatchConstraintsChainedWidgets, constraintWidget2.mMatchConstraintsChainedWidgets.length * 2);
                        }
                        constraintWidget2.mMatchConstraintsChainedWidgets[i2] = constraintWidget6;
                        i2 = i5;
                    }
                }
                if (constraintWidget6.mRight.mTarget.mOwner.mLeft.mTarget == null || constraintWidget6.mRight.mTarget.mOwner.mLeft.mTarget.mOwner != constraintWidget6 || constraintWidget6.mRight.mTarget.mOwner == constraintWidget6) {
                    break;
                }
                constraintWidget7 = constraintWidget6.mRight.mTarget.mOwner;
                constraintWidget6 = constraintWidget7;
                constraintWidget4 = null;
                f = 0.0f;
            }
            if (!(constraintWidget6.mRight.mTarget == null || constraintWidget6.mRight.mTarget.mOwner == constraintWidget2)) {
                z = false;
            }
            if (constraintWidget3.mLeft.mTarget != null) {
                if (constraintWidget7.mRight.mTarget != null) {
                    i6 = 1;
                    constraintWidget3.mHorizontalChainFixedPosition = z;
                    constraintWidget7.mHorizontalNextWidget = null;
                    constraintWidgetArr[0] = constraintWidget3;
                    constraintWidgetArr[2] = constraintWidget8;
                    constraintWidgetArr[i6] = constraintWidget7;
                    constraintWidgetArr[3] = constraintWidget5;
                }
            }
            i6 = 1;
            zArr[1] = true;
            constraintWidget3.mHorizontalChainFixedPosition = z;
            constraintWidget7.mHorizontalNextWidget = null;
            constraintWidgetArr[0] = constraintWidget3;
            constraintWidgetArr[2] = constraintWidget8;
            constraintWidgetArr[i6] = constraintWidget7;
            constraintWidgetArr[3] = constraintWidget5;
        } else {
            boolean z2 = constraintWidget3.mTop.mTarget == null || constraintWidget3.mTop.mTarget.mOwner == constraintWidget2;
            constraintWidget4 = null;
            constraintWidget3.mVerticalNextWidget = null;
            int i7 = 0;
            constraintWidget6 = null;
            constraintWidget5 = constraintWidget.getVisibility() != 8 ? constraintWidget3 : null;
            ConstraintWidget constraintWidget9 = constraintWidget5;
            ConstraintWidget constraintWidget10 = constraintWidget3;
            while (constraintWidget10.mBottom.mTarget != null) {
                constraintWidget10.mVerticalNextWidget = constraintWidget4;
                if (constraintWidget10.getVisibility() != i4) {
                    if (constraintWidget5 == null) {
                        constraintWidget5 = constraintWidget10;
                    }
                    if (!(constraintWidget9 == null || constraintWidget9 == constraintWidget10)) {
                        constraintWidget9.mVerticalNextWidget = constraintWidget10;
                    }
                    constraintWidget9 = constraintWidget10;
                } else {
                    linearSystem2.addEquality(constraintWidget10.mTop.mSolverVariable, constraintWidget10.mTop.mTarget.mSolverVariable, 0, i3);
                    linearSystem2.addEquality(constraintWidget10.mBottom.mSolverVariable, constraintWidget10.mTop.mSolverVariable, 0, i3);
                }
                if (constraintWidget10.getVisibility() != i4 && constraintWidget10.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget10.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                        zArr[0] = false;
                    }
                    if (constraintWidget10.mDimensionRatio <= 0.0f) {
                        zArr[0] = false;
                        i5 = i7 + 1;
                        if (i5 >= constraintWidget2.mMatchConstraintsChainedWidgets.length) {
                            constraintWidget2.mMatchConstraintsChainedWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidget2.mMatchConstraintsChainedWidgets, constraintWidget2.mMatchConstraintsChainedWidgets.length * 2);
                        }
                        constraintWidget2.mMatchConstraintsChainedWidgets[i7] = constraintWidget10;
                        i7 = i5;
                    }
                }
                if (constraintWidget10.mBottom.mTarget.mOwner.mTop.mTarget == null || constraintWidget10.mBottom.mTarget.mOwner.mTop.mTarget.mOwner != constraintWidget10 || constraintWidget10.mBottom.mTarget.mOwner == constraintWidget10) {
                    break;
                }
                constraintWidget6 = constraintWidget10.mBottom.mTarget.mOwner;
                constraintWidget10 = constraintWidget6;
                constraintWidget4 = null;
                i3 = 5;
                i4 = 8;
            }
            i2 = i7;
            if (!(constraintWidget10.mBottom.mTarget == null || constraintWidget10.mBottom.mTarget.mOwner == constraintWidget2)) {
                z2 = false;
            }
            if (constraintWidget3.mTop.mTarget != null) {
                if (constraintWidget6.mBottom.mTarget != null) {
                    i6 = 1;
                    constraintWidget3.mVerticalChainFixedPosition = z2;
                    constraintWidget6.mVerticalNextWidget = null;
                    constraintWidgetArr[0] = constraintWidget3;
                    constraintWidgetArr[2] = constraintWidget5;
                    constraintWidgetArr[i6] = constraintWidget6;
                    constraintWidgetArr[3] = constraintWidget9;
                }
            }
            i6 = 1;
            zArr[1] = true;
            constraintWidget3.mVerticalChainFixedPosition = z2;
            constraintWidget6.mVerticalNextWidget = null;
            constraintWidgetArr[0] = constraintWidget3;
            constraintWidgetArr[2] = constraintWidget5;
            constraintWidgetArr[i6] = constraintWidget6;
            constraintWidgetArr[3] = constraintWidget9;
        }
        return i2;
    }
}
