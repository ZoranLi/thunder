package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class Optimizer {
    static void applyDirectResolutionHorizontalChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, ConstraintWidget constraintWidget) {
        int x;
        float f;
        float f2;
        ConstraintWidget constraintWidget2 = constraintWidgetContainer;
        LinearSystem linearSystem2 = linearSystem;
        int i2 = i;
        ConstraintWidget constraintWidget3 = constraintWidget;
        float f3 = 0.0f;
        int i3 = 0;
        int i4 = i3;
        ConstraintWidget constraintWidget4 = null;
        while (true) {
            int i5 = 1;
            if (constraintWidget3 == null) {
                break;
            }
            if (constraintWidget3.getVisibility() != 8) {
                i5 = 0;
            }
            if (i5 == 0) {
                i3++;
                if (constraintWidget3.mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4 = ((i4 + constraintWidget3.getWidth()) + (constraintWidget3.mLeft.mTarget != null ? constraintWidget3.mLeft.getMargin() : 0)) + (constraintWidget3.mRight.mTarget != null ? constraintWidget3.mRight.getMargin() : 0);
                } else {
                    f3 += constraintWidget3.mHorizontalWeight;
                }
            }
            constraintWidget4 = constraintWidget3.mRight.mTarget != null ? constraintWidget3.mRight.mTarget.mOwner : null;
            if (constraintWidget4 != null && (constraintWidget4.mLeft.mTarget == null || !(constraintWidget4.mLeft.mTarget == null || constraintWidget4.mLeft.mTarget.mOwner == constraintWidget3))) {
                constraintWidget4 = null;
            }
            ConstraintWidget constraintWidget5 = constraintWidget4;
            constraintWidget4 = constraintWidget3;
            constraintWidget3 = constraintWidget5;
        }
        if (constraintWidget4 != null) {
            x = constraintWidget4.mRight.mTarget != null ? constraintWidget4.mRight.mTarget.mOwner.getX() : 0;
            if (constraintWidget4.mRight.mTarget != null && constraintWidget4.mRight.mTarget.mOwner == constraintWidget2) {
                x = constraintWidgetContainer.getRight();
            }
        } else {
            x = 0;
        }
        float f4 = ((float) (x - 0)) - ((float) i4);
        float f5 = f4 / ((float) (i3 + 1));
        if (i2 == 0) {
            f = f5;
            f2 = f;
        } else {
            f = 0.0f;
            f2 = f4 / ((float) i2);
        }
        constraintWidget4 = constraintWidget;
        while (constraintWidget4 != null) {
            i5 = constraintWidget4.mLeft.mTarget != null ? constraintWidget4.mLeft.getMargin() : 0;
            int margin = constraintWidget4.mRight.mTarget != null ? constraintWidget4.mRight.getMargin() : 0;
            if (constraintWidget4.getVisibility() != 8) {
                float f6 = (float) i5;
                f += f6;
                linearSystem2.addEquality(constraintWidget4.mLeft.mSolverVariable, (int) (f + PayBaseConstants.HALF_OF_FLOAT));
                if (constraintWidget4.mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                    f += (float) constraintWidget4.getWidth();
                } else if (f3 == 0.0f) {
                    f += (f2 - f6) - ((float) margin);
                } else {
                    f += (((constraintWidget4.mHorizontalWeight * f4) / f3) - f6) - ((float) margin);
                }
                linearSystem2.addEquality(constraintWidget4.mRight.mSolverVariable, (int) (PayBaseConstants.HALF_OF_FLOAT + f));
                if (i2 == 0) {
                    f += f2;
                }
                f += (float) margin;
            } else {
                int i6 = (int) ((f - (f2 / 2.0f)) + PayBaseConstants.HALF_OF_FLOAT);
                linearSystem2.addEquality(constraintWidget4.mLeft.mSolverVariable, i6);
                linearSystem2.addEquality(constraintWidget4.mRight.mSolverVariable, i6);
            }
            ConstraintWidget constraintWidget6 = constraintWidget4.mRight.mTarget != null ? constraintWidget4.mRight.mTarget.mOwner : null;
            if (!(constraintWidget6 == null || constraintWidget6.mLeft.mTarget == null || constraintWidget6.mLeft.mTarget.mOwner == constraintWidget4)) {
                constraintWidget6 = null;
            }
            constraintWidget4 = constraintWidget6 == constraintWidget2 ? null : constraintWidget6;
        }
    }

    static void applyDirectResolutionVerticalChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, ConstraintWidget constraintWidget) {
        int x;
        float f;
        float f2;
        ConstraintWidget constraintWidget2 = constraintWidgetContainer;
        LinearSystem linearSystem2 = linearSystem;
        int i2 = i;
        ConstraintWidget constraintWidget3 = constraintWidget;
        float f3 = 0.0f;
        int i3 = 0;
        int i4 = i3;
        ConstraintWidget constraintWidget4 = null;
        while (true) {
            int i5 = 1;
            if (constraintWidget3 == null) {
                break;
            }
            if (constraintWidget3.getVisibility() != 8) {
                i5 = 0;
            }
            if (i5 == 0) {
                i3++;
                if (constraintWidget3.mVerticalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4 = ((i4 + constraintWidget3.getHeight()) + (constraintWidget3.mTop.mTarget != null ? constraintWidget3.mTop.getMargin() : 0)) + (constraintWidget3.mBottom.mTarget != null ? constraintWidget3.mBottom.getMargin() : 0);
                } else {
                    f3 += constraintWidget3.mVerticalWeight;
                }
            }
            constraintWidget4 = constraintWidget3.mBottom.mTarget != null ? constraintWidget3.mBottom.mTarget.mOwner : null;
            if (constraintWidget4 != null && (constraintWidget4.mTop.mTarget == null || !(constraintWidget4.mTop.mTarget == null || constraintWidget4.mTop.mTarget.mOwner == constraintWidget3))) {
                constraintWidget4 = null;
            }
            ConstraintWidget constraintWidget5 = constraintWidget4;
            constraintWidget4 = constraintWidget3;
            constraintWidget3 = constraintWidget5;
        }
        if (constraintWidget4 != null) {
            x = constraintWidget4.mBottom.mTarget != null ? constraintWidget4.mBottom.mTarget.mOwner.getX() : 0;
            if (constraintWidget4.mBottom.mTarget != null && constraintWidget4.mBottom.mTarget.mOwner == constraintWidget2) {
                x = constraintWidgetContainer.getBottom();
            }
        } else {
            x = 0;
        }
        float f4 = ((float) (x - 0)) - ((float) i4);
        float f5 = f4 / ((float) (i3 + 1));
        if (i2 == 0) {
            f = f5;
            f2 = f;
        } else {
            f = 0.0f;
            f2 = f4 / ((float) i2);
        }
        constraintWidget4 = constraintWidget;
        while (constraintWidget4 != null) {
            i5 = constraintWidget4.mTop.mTarget != null ? constraintWidget4.mTop.getMargin() : 0;
            int margin = constraintWidget4.mBottom.mTarget != null ? constraintWidget4.mBottom.getMargin() : 0;
            if (constraintWidget4.getVisibility() != 8) {
                float f6 = (float) i5;
                f += f6;
                linearSystem2.addEquality(constraintWidget4.mTop.mSolverVariable, (int) (f + PayBaseConstants.HALF_OF_FLOAT));
                if (constraintWidget4.mVerticalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) {
                    f += (float) constraintWidget4.getHeight();
                } else if (f3 == 0.0f) {
                    f += (f2 - f6) - ((float) margin);
                } else {
                    f += (((constraintWidget4.mVerticalWeight * f4) / f3) - f6) - ((float) margin);
                }
                linearSystem2.addEquality(constraintWidget4.mBottom.mSolverVariable, (int) (PayBaseConstants.HALF_OF_FLOAT + f));
                if (i2 == 0) {
                    f += f2;
                }
                f += (float) margin;
            } else {
                int i6 = (int) ((f - (f2 / 2.0f)) + PayBaseConstants.HALF_OF_FLOAT);
                linearSystem2.addEquality(constraintWidget4.mTop.mSolverVariable, i6);
                linearSystem2.addEquality(constraintWidget4.mBottom.mSolverVariable, i6);
            }
            ConstraintWidget constraintWidget6 = constraintWidget4.mBottom.mTarget != null ? constraintWidget4.mBottom.mTarget.mOwner : null;
            if (!(constraintWidget6 == null || constraintWidget6.mTop.mTarget == null || constraintWidget6.mTop.mTarget.mOwner == constraintWidget4)) {
                constraintWidget6 = null;
            }
            constraintWidget4 = constraintWidget6 == constraintWidget2 ? null : constraintWidget6;
        }
    }

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mHorizontalDimensionBehaviour != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.setHorizontalDimension(i, width);
            constraintWidget.mHorizontalResolution = 2;
        }
        if (constraintWidgetContainer.mVerticalDimensionBehaviour != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            i = constraintWidget.mTop.mMargin;
            constraintWidgetContainer = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidgetContainer);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i);
            }
            constraintWidget.setVerticalDimension(i, constraintWidgetContainer);
            constraintWidget.mVerticalResolution = 2;
        }
    }

    static void checkHorizontalSimpleDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget.mHorizontalResolution = 1;
        } else if (constraintWidgetContainer.mHorizontalDimensionBehaviour != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            r0 = constraintWidget.mLeft.mMargin;
            constraintWidgetContainer = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, r0);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidgetContainer);
            constraintWidget.setHorizontalDimension(r0, constraintWidgetContainer);
            constraintWidget.mHorizontalResolution = 2;
        } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null) {
            if (constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner == constraintWidgetContainer) {
                constraintWidgetContainer = constraintWidget.mLeft.getMargin();
                r0 = constraintWidget.getWidth() + constraintWidgetContainer;
                constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, constraintWidgetContainer);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, r0);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(constraintWidgetContainer, r0);
            } else if (constraintWidget.mRight.mTarget != null && constraintWidget.mRight.mTarget.mOwner == constraintWidgetContainer) {
                constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                constraintWidgetContainer = constraintWidgetContainer.getWidth() - constraintWidget.mRight.getMargin();
                r0 = constraintWidgetContainer - constraintWidget.getWidth();
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, r0);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidgetContainer);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(r0, constraintWidgetContainer);
            } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner.mHorizontalResolution == 2) {
                constraintWidgetContainer = constraintWidget.mLeft.mTarget.mSolverVariable;
                constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                constraintWidgetContainer = (int) ((constraintWidgetContainer.computedValue + ((float) constraintWidget.mLeft.getMargin())) + 1056964608);
                r0 = constraintWidget.getWidth() + constraintWidgetContainer;
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, constraintWidgetContainer);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, r0);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(constraintWidgetContainer, r0);
            } else if (constraintWidget.mRight.mTarget == null || constraintWidget.mRight.mTarget.mOwner.mHorizontalResolution != 2) {
                r0 = constraintWidget.mLeft.mTarget != null ? 1 : 0;
                int i = constraintWidget.mRight.mTarget != null ? 1 : 0;
                if (r0 == 0 && i == 0) {
                    if (constraintWidget instanceof Guideline) {
                        Guideline guideline = (Guideline) constraintWidget;
                        if (guideline.getOrientation() == 1) {
                            float relativeBegin;
                            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                            if (guideline.getRelativeBegin() != -1) {
                                relativeBegin = (float) guideline.getRelativeBegin();
                            } else if (guideline.getRelativeEnd() != -1) {
                                relativeBegin = (float) (constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                            } else {
                                relativeBegin = guideline.getRelativePercent() * ((float) constraintWidgetContainer.getWidth());
                            }
                            r0 = (int) (relativeBegin + PayBaseConstants.HALF_OF_FLOAT);
                            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, r0);
                            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, r0);
                            constraintWidget.mHorizontalResolution = 2;
                            constraintWidget.mVerticalResolution = 2;
                            constraintWidget.setHorizontalDimension(r0, r0);
                            constraintWidget.setVerticalDimension(0, constraintWidgetContainer.getHeight());
                        }
                        return;
                    }
                    constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                    constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                    constraintWidgetContainer = constraintWidget.getX();
                    r0 = constraintWidget.getWidth() + constraintWidgetContainer;
                    linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, constraintWidgetContainer);
                    linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, r0);
                    constraintWidget.mHorizontalResolution = 2;
                }
            } else {
                constraintWidgetContainer = constraintWidget.mRight.mTarget.mSolverVariable;
                constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
                constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
                constraintWidgetContainer = (int) ((constraintWidgetContainer.computedValue - ((float) constraintWidget.mRight.getMargin())) + 1056964608);
                r0 = constraintWidgetContainer - constraintWidget.getWidth();
                linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, r0);
                linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidgetContainer);
                constraintWidget.mHorizontalResolution = 2;
                constraintWidget.setHorizontalDimension(r0, constraintWidgetContainer);
            }
        } else if (constraintWidget.mLeft.mTarget.mOwner == constraintWidgetContainer && constraintWidget.mRight.mTarget.mOwner == constraintWidgetContainer) {
            r0 = constraintWidget.mLeft.getMargin();
            int margin = constraintWidget.mRight.getMargin();
            if (constraintWidgetContainer.mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidgetContainer = constraintWidgetContainer.getWidth() - margin;
            } else {
                r0 += (int) ((((float) (((constraintWidgetContainer.getWidth() - r0) - margin) - constraintWidget.getWidth())) * constraintWidget.mHorizontalBiasPercent) + 1056964608);
                constraintWidgetContainer = constraintWidget.getWidth() + r0;
            }
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, r0);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, constraintWidgetContainer);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(r0, constraintWidgetContainer);
        } else {
            constraintWidget.mHorizontalResolution = 1;
        }
    }

    static void checkVerticalSimpleDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        int i = 1;
        if (constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            constraintWidget.mVerticalResolution = 1;
        } else if (constraintWidgetContainer.mVerticalDimensionBehaviour != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_PARENT) {
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            r0 = constraintWidget.mTop.mMargin;
            constraintWidgetContainer = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, r0);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidgetContainer);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + r0);
            }
            constraintWidget.setVerticalDimension(r0, constraintWidgetContainer);
            constraintWidget.mVerticalResolution = 2;
        } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null) {
            if (constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner == constraintWidgetContainer) {
                constraintWidgetContainer = constraintWidget.mTop.getMargin();
                r0 = constraintWidget.getHeight() + constraintWidgetContainer;
                constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidgetContainer);
                linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, r0);
                if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                    constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                    linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + constraintWidgetContainer);
                }
                constraintWidget.mVerticalResolution = 2;
                constraintWidget.setVerticalDimension(constraintWidgetContainer, r0);
            } else if (constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner == constraintWidgetContainer) {
                constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                constraintWidgetContainer = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.getMargin();
                r0 = constraintWidgetContainer - constraintWidget.getHeight();
                linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, r0);
                linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidgetContainer);
                if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                    constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                    linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + r0);
                }
                constraintWidget.mVerticalResolution = 2;
                constraintWidget.setVerticalDimension(r0, constraintWidgetContainer);
            } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner.mVerticalResolution == 2) {
                constraintWidgetContainer = constraintWidget.mTop.mTarget.mSolverVariable;
                constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                constraintWidgetContainer = (int) ((constraintWidgetContainer.computedValue + ((float) constraintWidget.mTop.getMargin())) + 1056964608);
                r0 = constraintWidget.getHeight() + constraintWidgetContainer;
                linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidgetContainer);
                linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, r0);
                if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                    constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                    linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + constraintWidgetContainer);
                }
                constraintWidget.mVerticalResolution = 2;
                constraintWidget.setVerticalDimension(constraintWidgetContainer, r0);
            } else if (constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner.mVerticalResolution == 2) {
                constraintWidgetContainer = constraintWidget.mBottom.mTarget.mSolverVariable;
                constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                constraintWidgetContainer = (int) ((constraintWidgetContainer.computedValue - ((float) constraintWidget.mBottom.getMargin())) + 1056964608);
                r0 = constraintWidgetContainer - constraintWidget.getHeight();
                linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, r0);
                linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidgetContainer);
                if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                    constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                    linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + r0);
                }
                constraintWidget.mVerticalResolution = 2;
                constraintWidget.setVerticalDimension(r0, constraintWidgetContainer);
            } else if (constraintWidget.mBaseline.mTarget == null || constraintWidget.mBaseline.mTarget.mOwner.mVerticalResolution != 2) {
                r0 = constraintWidget.mBaseline.mTarget != null ? 1 : 0;
                int i2 = constraintWidget.mTop.mTarget != null ? 1 : 0;
                if (constraintWidget.mBottom.mTarget == null) {
                    i = 0;
                }
                if (r0 == 0 && i2 == 0 && r2 == 0) {
                    if (constraintWidget instanceof Guideline) {
                        Guideline guideline = (Guideline) constraintWidget;
                        if (guideline.getOrientation() == 0) {
                            float relativeBegin;
                            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                            if (guideline.getRelativeBegin() != -1) {
                                relativeBegin = (float) guideline.getRelativeBegin();
                            } else if (guideline.getRelativeEnd() != -1) {
                                relativeBegin = (float) (constraintWidgetContainer.getHeight() - guideline.getRelativeEnd());
                            } else {
                                relativeBegin = guideline.getRelativePercent() * ((float) constraintWidgetContainer.getHeight());
                            }
                            r0 = (int) (relativeBegin + PayBaseConstants.HALF_OF_FLOAT);
                            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, r0);
                            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, r0);
                            constraintWidget.mVerticalResolution = 2;
                            constraintWidget.mHorizontalResolution = 2;
                            constraintWidget.setVerticalDimension(r0, r0);
                            constraintWidget.setHorizontalDimension(0, constraintWidgetContainer.getWidth());
                        }
                        return;
                    }
                    constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                    constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                    constraintWidgetContainer = constraintWidget.getY();
                    r0 = constraintWidget.getHeight() + constraintWidgetContainer;
                    linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidgetContainer);
                    linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, r0);
                    if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                        constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                        linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidgetContainer + constraintWidget.mBaselineDistance);
                    }
                    constraintWidget.mVerticalResolution = 2;
                }
            } else {
                constraintWidgetContainer = constraintWidget.mBaseline.mTarget.mSolverVariable;
                constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
                constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
                constraintWidgetContainer = (int) ((constraintWidgetContainer.computedValue - ((float) constraintWidget.mBaselineDistance)) + 1056964608);
                r0 = constraintWidget.getHeight() + constraintWidgetContainer;
                linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, constraintWidgetContainer);
                linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, r0);
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + constraintWidgetContainer);
                constraintWidget.mVerticalResolution = 2;
                constraintWidget.setVerticalDimension(constraintWidgetContainer, r0);
            }
        } else if (constraintWidget.mTop.mTarget.mOwner == constraintWidgetContainer && constraintWidget.mBottom.mTarget.mOwner == constraintWidgetContainer) {
            r0 = constraintWidget.mTop.getMargin();
            i = constraintWidget.mBottom.getMargin();
            if (constraintWidgetContainer.mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidgetContainer = constraintWidget.getHeight() + r0;
            } else {
                r0 = (int) ((((float) r0) + (((float) (((constraintWidgetContainer.getHeight() - r0) - i) - constraintWidget.getHeight())) * constraintWidget.mVerticalBiasPercent)) + PayBaseConstants.HALF_OF_FLOAT);
                constraintWidgetContainer = constraintWidget.getHeight() + r0;
            }
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, r0);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, constraintWidgetContainer);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + r0);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(r0, constraintWidgetContainer);
        } else {
            constraintWidget.mVerticalResolution = 1;
        }
    }
}
