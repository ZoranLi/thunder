package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;

public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    private static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList();
    private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList();
    private int mNumCols = 0;
    private int mNumRows = 0;
    private int mPadding = 8;
    private boolean mVerticalGrowth = true;
    private ArrayList<Guideline> mVerticalGuidelines = new ArrayList();
    private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList();
    private LinearSystem system = null;

    class HorizontalSlice {
        ConstraintWidget bottom;
        int padding;
        ConstraintWidget top;

        HorizontalSlice() {
        }
    }

    class VerticalSlice {
        int alignment = 1;
        ConstraintWidget left;
        int padding;
        ConstraintWidget right;

        VerticalSlice() {
        }
    }

    public String getType() {
        return "ConstraintTableLayout";
    }

    public boolean handlesInternalConstraints() {
        return true;
    }

    public ConstraintTableLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public ConstraintTableLayout(int i, int i2) {
        super(i, i2);
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public int getNumCols() {
        return this.mNumCols;
    }

    public int getPadding() {
        return this.mPadding;
    }

    public String getColumnsAlignmentRepresentation() {
        int size = this.mVerticalSlices.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            VerticalSlice verticalSlice = (VerticalSlice) this.mVerticalSlices.get(i);
            StringBuilder stringBuilder;
            if (verticalSlice.alignment == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("L");
                str = stringBuilder.toString();
            } else if (verticalSlice.alignment == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("C");
                str = stringBuilder.toString();
            } else if (verticalSlice.alignment == 3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("F");
                str = stringBuilder.toString();
            } else if (verticalSlice.alignment == 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("R");
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    public String getColumnAlignmentRepresentation(int i) {
        VerticalSlice verticalSlice = (VerticalSlice) this.mVerticalSlices.get(i);
        if (verticalSlice.alignment == 1) {
            return "L";
        }
        if (verticalSlice.alignment == 0) {
            return "C";
        }
        if (verticalSlice.alignment == 3) {
            return "F";
        }
        return verticalSlice.alignment == 2 ? "R" : "!";
    }

    public void setNumCols(int i) {
        if (this.mVerticalGrowth && this.mNumCols != i) {
            this.mNumCols = i;
            setVerticalSlices();
            setTableDimensions();
        }
    }

    public void setNumRows(int i) {
        if (!this.mVerticalGrowth && this.mNumCols != i) {
            this.mNumRows = i;
            setHorizontalSlices();
            setTableDimensions();
        }
    }

    public boolean isVerticalGrowth() {
        return this.mVerticalGrowth;
    }

    public void setVerticalGrowth(boolean z) {
        this.mVerticalGrowth = z;
    }

    public void setPadding(int i) {
        if (i > 1) {
            this.mPadding = i;
        }
    }

    public void setColumnAlignment(int i, int i2) {
        if (i < this.mVerticalSlices.size()) {
            ((VerticalSlice) this.mVerticalSlices.get(i)).alignment = i2;
            setChildrenConnections();
        }
    }

    public void cycleColumnAlignment(int i) {
        VerticalSlice verticalSlice = (VerticalSlice) this.mVerticalSlices.get(i);
        switch (verticalSlice.alignment) {
            case 0:
                verticalSlice.alignment = 2;
                break;
            case 1:
                verticalSlice.alignment = 0;
                break;
            case 2:
                verticalSlice.alignment = 1;
                break;
            default:
                break;
        }
        setChildrenConnections();
    }

    public void setColumnAlignment(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 'L') {
                setColumnAlignment(i, 1);
            } else {
                if (charAt != 'C') {
                    if (charAt == 'F') {
                        setColumnAlignment(i, 3);
                    } else if (charAt == 'R') {
                        setColumnAlignment(i, 2);
                    }
                }
                setColumnAlignment(i, 0);
            }
        }
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.mVerticalGuidelines;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.mHorizontalGuidelines;
    }

    public void addToSolver(LinearSystem linearSystem, int i) {
        super.addToSolver(linearSystem, i);
        int size = this.mChildren.size();
        if (size != 0) {
            setTableDimensions();
            if (linearSystem == this.mSystem) {
                Guideline guideline;
                int size2 = this.mVerticalGuidelines.size();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    boolean z = true;
                    if (i3 >= size2) {
                        break;
                    }
                    guideline = (Guideline) this.mVerticalGuidelines.get(i3);
                    if (getHorizontalDimensionBehaviour() != DimensionBehaviour.WRAP_CONTENT) {
                        z = false;
                    }
                    guideline.setPositionRelaxed(z);
                    guideline.addToSolver(linearSystem, i);
                    i3++;
                }
                size2 = this.mHorizontalGuidelines.size();
                for (i3 = 0; i3 < size2; i3++) {
                    guideline = (Guideline) this.mHorizontalGuidelines.get(i3);
                    guideline.setPositionRelaxed(getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT);
                    guideline.addToSolver(linearSystem, i);
                }
                while (i2 < size) {
                    ((ConstraintWidget) this.mChildren.get(i2)).addToSolver(linearSystem, i);
                    i2++;
                }
            }
        }
    }

    public void setTableDimensions() {
        int size = this.mChildren.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            i2 += ((ConstraintWidget) this.mChildren.get(i)).getContainerItemSkip();
            i++;
        }
        size += i2;
        if (this.mVerticalGrowth) {
            if (this.mNumCols == 0) {
                setNumCols(1);
            }
            i = size / this.mNumCols;
            if (this.mNumCols * i < size) {
                i++;
            }
            if (this.mNumRows != i || this.mVerticalGuidelines.size() != this.mNumCols - 1) {
                this.mNumRows = i;
                setHorizontalSlices();
            } else {
                return;
            }
        }
        if (this.mNumRows == 0) {
            setNumRows(1);
        }
        i = size / this.mNumRows;
        if (this.mNumRows * i < size) {
            i++;
        }
        if (this.mNumCols != i || this.mHorizontalGuidelines.size() != this.mNumRows - 1) {
            this.mNumCols = i;
            setVerticalSlices();
        } else {
            return;
        }
        setChildrenConnections();
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.system = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        updateDebugSolverNames();
    }

    private void updateDebugSolverNames() {
        if (this.system != null) {
            int size = this.mVerticalGuidelines.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Guideline guideline = (Guideline) this.mVerticalGuidelines.get(i2);
                LinearSystem linearSystem = this.system;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getDebugName());
                stringBuilder.append(".VG");
                stringBuilder.append(i2);
                guideline.setDebugSolverName(linearSystem, stringBuilder.toString());
            }
            size = this.mHorizontalGuidelines.size();
            while (i < size) {
                Guideline guideline2 = (Guideline) this.mHorizontalGuidelines.get(i);
                LinearSystem linearSystem2 = this.system;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(getDebugName());
                stringBuilder2.append(".HG");
                stringBuilder2.append(i);
                guideline2.setDebugSolverName(linearSystem2, stringBuilder2.toString());
                i++;
            }
        }
    }

    private void setVerticalSlices() {
        this.mVerticalSlices.clear();
        float f = 100.0f / ((float) this.mNumCols);
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumCols; i++) {
            VerticalSlice verticalSlice = new VerticalSlice();
            verticalSlice.left = constraintWidget;
            if (i < this.mNumCols - 1) {
                constraintWidget = new Guideline();
                constraintWidget.setOrientation(1);
                constraintWidget.setParent(this);
                constraintWidget.setGuidePercent((int) f2);
                f2 += f;
                verticalSlice.right = constraintWidget;
                this.mVerticalGuidelines.add(constraintWidget);
            } else {
                verticalSlice.right = this;
            }
            constraintWidget = verticalSlice.right;
            this.mVerticalSlices.add(verticalSlice);
        }
        updateDebugSolverNames();
    }

    private void setHorizontalSlices() {
        this.mHorizontalSlices.clear();
        float f = 100.0f / ((float) this.mNumRows);
        ConstraintWidget constraintWidget = this;
        float f2 = f;
        for (int i = 0; i < this.mNumRows; i++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice();
            horizontalSlice.top = constraintWidget;
            if (i < this.mNumRows - 1) {
                constraintWidget = new Guideline();
                constraintWidget.setOrientation(0);
                constraintWidget.setParent(this);
                constraintWidget.setGuidePercent((int) f2);
                f2 += f;
                horizontalSlice.bottom = constraintWidget;
                this.mHorizontalGuidelines.add(constraintWidget);
            } else {
                horizontalSlice.bottom = this;
            }
            constraintWidget = horizontalSlice.bottom;
            this.mHorizontalSlices.add(horizontalSlice);
        }
        updateDebugSolverNames();
    }

    private void setChildrenConnections() {
        int size = this.mChildren.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            i2 += constraintWidget.getContainerItemSkip();
            HorizontalSlice horizontalSlice = (HorizontalSlice) this.mHorizontalSlices.get(i2 / this.mNumCols);
            VerticalSlice verticalSlice = (VerticalSlice) this.mVerticalSlices.get(i2 % this.mNumCols);
            ConstraintWidget constraintWidget2 = verticalSlice.left;
            ConstraintWidget constraintWidget3 = verticalSlice.right;
            ConstraintWidget constraintWidget4 = horizontalSlice.top;
            ConstraintWidget constraintWidget5 = horizontalSlice.bottom;
            constraintWidget.getAnchor(Type.LEFT).connect(constraintWidget2.getAnchor(Type.LEFT), this.mPadding);
            if (constraintWidget3 instanceof Guideline) {
                constraintWidget.getAnchor(Type.RIGHT).connect(constraintWidget3.getAnchor(Type.LEFT), this.mPadding);
            } else {
                constraintWidget.getAnchor(Type.RIGHT).connect(constraintWidget3.getAnchor(Type.RIGHT), this.mPadding);
            }
            switch (verticalSlice.alignment) {
                case 1:
                    constraintWidget.getAnchor(Type.LEFT).setStrength(Strength.STRONG);
                    constraintWidget.getAnchor(Type.RIGHT).setStrength(Strength.WEAK);
                    break;
                case 2:
                    constraintWidget.getAnchor(Type.LEFT).setStrength(Strength.WEAK);
                    constraintWidget.getAnchor(Type.RIGHT).setStrength(Strength.STRONG);
                    break;
                case 3:
                    constraintWidget.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                    break;
                default:
                    break;
            }
            constraintWidget.getAnchor(Type.TOP).connect(constraintWidget4.getAnchor(Type.TOP), this.mPadding);
            if (constraintWidget5 instanceof Guideline) {
                constraintWidget.getAnchor(Type.BOTTOM).connect(constraintWidget5.getAnchor(Type.TOP), this.mPadding);
            } else {
                constraintWidget.getAnchor(Type.BOTTOM).connect(constraintWidget5.getAnchor(Type.BOTTOM), this.mPadding);
            }
            i2++;
            i++;
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, int i) {
        super.updateFromSolver(linearSystem, i);
        if (linearSystem == this.mSystem) {
            int size = this.mVerticalGuidelines.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ((Guideline) this.mVerticalGuidelines.get(i3)).updateFromSolver(linearSystem, i);
            }
            size = this.mHorizontalGuidelines.size();
            while (i2 < size) {
                ((Guideline) this.mHorizontalGuidelines.get(i2)).updateFromSolver(linearSystem, i);
                i2++;
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.mVerticalGuidelines.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ((Guideline) this.mVerticalGuidelines.get(i2)).inferRelativePercentPosition();
        }
        size = this.mHorizontalGuidelines.size();
        while (i < size) {
            ((Guideline) this.mHorizontalGuidelines.get(i)).inferRelativePercentPosition();
            i++;
        }
    }
}
