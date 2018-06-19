package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class ArrayRow {
    private static final boolean DEBUG = false;
    float constantValue = 0.0f;
    boolean isSimpleDefinition = false;
    boolean used = false;
    SolverVariable variable = null;
    final ArrayLinkedVariables variables;

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    void updateClientEquations() {
        this.variables.updateClientEquations(this);
    }

    boolean hasAtLeastOnePositiveVariable() {
        return this.variables.hasAtLeastOnePositiveVariable();
    }

    boolean hasKeyVariable() {
        return this.variable != null && (this.variable.mType == Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public String toString() {
        return toReadableString();
    }

    String toReadableString() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i;
        String str = "";
        if (this.variable == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("0");
            str = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.variable);
            str = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" = ");
        str = stringBuilder.toString();
        int i2 = 0;
        if (this.constantValue != 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.constantValue);
            stringBuilder2 = stringBuilder.toString();
            i = 1;
        } else {
            stringBuilder2 = str;
            i = 0;
        }
        int i3 = this.variables.currentSize;
        while (i2 < i3) {
            StringBuilder stringBuilder3;
            SolverVariable variable = this.variables.getVariable(i2);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i2);
                String solverVariable = variable.toString();
                if (i == 0) {
                    if (variableValue < 0.0f) {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(stringBuilder2);
                        stringBuilder3.append("- ");
                        stringBuilder2 = stringBuilder3.toString();
                        variableValue *= -1.0f;
                    }
                } else if (variableValue > 0.0f) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(" + ");
                    stringBuilder2 = stringBuilder3.toString();
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(" - ");
                    stringBuilder2 = stringBuilder3.toString();
                    variableValue *= -1.0f;
                }
                if (variableValue == 1.0f) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(solverVariable);
                    str = stringBuilder3.toString();
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append(variableValue);
                    stringBuilder3.append(" ");
                    stringBuilder3.append(solverVariable);
                    str = stringBuilder3.toString();
                }
                stringBuilder2 = str;
                i = 1;
            }
            i2++;
        }
        if (i != 0) {
            return stringBuilder2;
        }
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("0.0");
        return stringBuilder3.toString();
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.containsKey(solverVariable);
    }

    ArrayRow createRowDefinition(SolverVariable solverVariable, int i) {
        this.variable = solverVariable;
        i = (float) i;
        solverVariable.computedValue = i;
        this.constantValue = i;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.constantValue = (float) (-1 * i);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = (float) i;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.constantValue = (float) i;
        }
        if (obj == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    ArrayRow addSingleError(SolverVariable solverVariable, int i) {
        this.variables.put(solverVariable, (float) i);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.constantValue = (float) i;
        }
        if (obj == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.constantValue = (float) i;
        }
        if (obj == null) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 != 0.0f) {
            if (f != f3) {
                f = (f / f2) / (f3 / f2);
                this.constantValue = (((float) ((-i) - i2)) + (((float) i3) * f)) + (((float) i4) * f);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f);
                this.variables.put(solverVariable3, -f);
                return this;
            }
        }
        this.constantValue = (float) ((((-i) - i2) + i3) + i4);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, 1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -1073741824);
            return this;
        }
        if (f == PayBaseConstants.HALF_OF_FLOAT) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.constantValue = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = (float) i;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.constantValue = (float) i2;
        } else {
            float f2 = 1.0f - f;
            this.variables.put(solverVariable, 1.0f * f2);
            this.variables.put(solverVariable2, -1.0f * f2);
            this.variables.put(solverVariable3, -1.0f * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.constantValue = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        return this;
    }

    public ArrayRow addError(SolverVariable solverVariable, SolverVariable solverVariable2) {
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f - f);
        this.variables.put(solverVariable3, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    int sizeInBytes() {
        return (((this.variable != null ? 4 : 0) + 4) + 4) + this.variables.sizeInBytes();
    }

    boolean updateRowWithEquation(ArrayRow arrayRow) {
        this.variables.updateFromRow(this, arrayRow);
        return true;
    }

    void ensurePositiveConstant() {
        if (this.constantValue < 0.0f) {
            this.constantValue *= -1.0f;
            this.variables.invert();
        }
    }

    void pickRowVariable() {
        SolverVariable pickPivotCandidate = this.variables.pickPivotCandidate();
        if (pickPivotCandidate != null) {
            pivot(pickPivotCandidate);
        }
        if (this.variables.currentSize == 0) {
            this.isSimpleDefinition = true;
        }
    }

    void pivot(SolverVariable solverVariable) {
        if (this.variable != null) {
            this.variables.put(this.variable, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable) * -1.0f;
        this.variable = solverVariable;
        if (remove != 1.0f) {
            this.constantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }
}
