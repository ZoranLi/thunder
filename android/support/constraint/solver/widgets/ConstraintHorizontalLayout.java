package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment = ContentAlignment.MIDDLE;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public ConstraintHorizontalLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public ConstraintHorizontalLayout(int i, int i2) {
        super(i, i2);
    }

    public void addToSolver(LinearSystem linearSystem, int i) {
        if (this.mChildren.size() != 0) {
            int i2 = 0;
            int size = this.mChildren.size();
            ConstraintWidget constraintWidget = this;
            while (i2 < size) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i2);
                if (constraintWidget != this) {
                    constraintWidget2.connect(Type.LEFT, constraintWidget, Type.RIGHT);
                    constraintWidget.connect(Type.RIGHT, constraintWidget2, Type.LEFT);
                } else {
                    Strength strength = Strength.STRONG;
                    if (this.mAlignment == ContentAlignment.END) {
                        strength = Strength.WEAK;
                    }
                    Strength strength2 = strength;
                    constraintWidget2.connect(Type.LEFT, constraintWidget, Type.LEFT, 0, strength2);
                }
                constraintWidget2.connect(Type.TOP, (ConstraintWidget) this, Type.TOP);
                constraintWidget2.connect(Type.BOTTOM, (ConstraintWidget) this, Type.BOTTOM);
                i2++;
                constraintWidget = constraintWidget2;
            }
            if (constraintWidget != this) {
                Strength strength3 = Strength.STRONG;
                if (this.mAlignment == ContentAlignment.BEGIN) {
                    strength3 = Strength.WEAK;
                }
                ConstraintWidget constraintWidget3 = constraintWidget;
                constraintWidget3.connect(Type.RIGHT, (ConstraintWidget) this, Type.RIGHT, 0, strength3);
            }
        }
        super.addToSolver(linearSystem, i);
    }
}
