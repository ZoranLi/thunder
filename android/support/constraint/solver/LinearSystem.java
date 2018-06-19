package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable.Type;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v4.widget.AutoScrollHelper;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    private static final boolean DEBUG = false;
    private static int POOL_SIZE = 1000;
    private int TABLE_SIZE;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Goal mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    private int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    private ArrayRow[] mRows;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    private ArrayRow[] tempClientsCopy;

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.mGoal = new Goal();
        this.TABLE_SIZE = 32;
        this.mMaxColumns = this.TABLE_SIZE;
        this.mRows = null;
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = this.TABLE_SIZE;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
        this.mRows = new ArrayRow[this.TABLE_SIZE];
        releaseRows();
        this.mCache = new Cache();
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        this.mCache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxColumns = this.TABLE_SIZE;
        this.mMaxRows = this.TABLE_SIZE;
        this.mGoal.variables.clear();
    }

    private void releaseRows() {
        for (int i = 0; i < this.mRows.length; i++) {
            Object obj = this.mRows[i];
            if (obj != null) {
                this.mCache.arrayRowPool.release(obj);
            }
            this.mRows[i] = null;
        }
    }

    public void reset() {
        int i;
        for (SolverVariable solverVariable : this.mCache.mIndexedVariables) {
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.variables.clear();
        this.mNumColumns = 1;
        for (i = 0; i < this.mNumRows; i++) {
            this.mRows[i].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                if (solverVariable.id != -1) {
                    solverVariable.reset();
                }
                this.mVariablesID++;
                this.mNumColumns++;
                solverVariable.id = this.mVariablesID;
                solverVariable.mType = Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow = (ArrayRow) this.mCache.arrayRowPool.acquire();
        if (arrayRow == null) {
            return new ArrayRow(this.mCache);
        }
        arrayRow.reset();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.SLACK);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(createErrorVariable(), createErrorVariable());
    }

    private void addSingleError(ArrayRow arrayRow, int i) {
        arrayRow.addSingleError(createErrorVariable(), i);
    }

    private SolverVariable createVariable(String str, Type type) {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        type = acquireSolverVariable(type);
        type.setName(str);
        this.mVariablesID++;
        this.mNumColumns++;
        type.id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        this.mVariables.put(str, type);
        this.mCache.mIndexedVariables[this.mVariablesID] = type;
        return type;
    }

    public SolverVariable createErrorVariable() {
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(Type.ERROR);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private SolverVariable acquireSolverVariable(Type type) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type);
        } else {
            solverVariable.reset();
            solverVariable.setType(type);
        }
        if (this.mPoolVariablesCount >= POOL_SIZE) {
            POOL_SIZE *= 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, POOL_SIZE);
        }
        type = this.mPoolVariables;
        int i = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i + 1;
        type[i] = solverVariable;
        return solverVariable;
    }

    Goal getGoal() {
        return this.mGoal;
    }

    ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    float getValueFor(String str) {
        str = getVariable(str, Type.UNRESTRICTED);
        if (str == null) {
            return null;
        }
        return str.computedValue;
    }

    public int getObjectVariableValue(Object obj) {
        obj = ((ConstraintAnchor) obj).getSolverVariable();
        return obj != null ? (int) (obj.computedValue + PayBaseConstants.HALF_OF_FLOAT) : null;
    }

    SolverVariable getVariable(String str, Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        SolverVariable solverVariable = (SolverVariable) this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    void rebuildGoalFromErrors() {
        this.mGoal.updateFromSystem(this);
    }

    public void minimize() throws Exception {
        minimizeGoal(this.mGoal);
    }

    void minimizeGoal(Goal goal) throws Exception {
        goal.updateFromSystem(this);
        enforceBFS(goal);
        optimize(goal);
        computeValues();
    }

    private void updateRowFromVariables(ArrayRow arrayRow) {
        if (this.mNumRows > 0) {
            arrayRow.variables.updateFromSystem(arrayRow, this.mRows);
            if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
            }
        }
    }

    public void addConstraint(ArrayRow arrayRow) {
        if (arrayRow != null) {
            if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            if (!arrayRow.isSimpleDefinition) {
                updateRowFromVariables(arrayRow);
                arrayRow.ensurePositiveConstant();
                arrayRow.pickRowVariable();
                if (!arrayRow.hasKeyVariable()) {
                    return;
                }
            }
            if (this.mRows[this.mNumRows] != null) {
                this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
            }
            if (!arrayRow.isSimpleDefinition) {
                arrayRow.updateClientEquations();
            }
            this.mRows[this.mNumRows] = arrayRow;
            arrayRow.variable.definitionId = this.mNumRows;
            this.mNumRows++;
            int i = arrayRow.variable.mClientEquationsCount;
            if (i > 0) {
                while (this.tempClientsCopy.length < i) {
                    this.tempClientsCopy = new ArrayRow[(this.tempClientsCopy.length * 2)];
                }
                ArrayRow[] arrayRowArr = this.tempClientsCopy;
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    arrayRowArr[i3] = arrayRow.variable.mClientEquations[i3];
                }
                while (i2 < i) {
                    ArrayRow arrayRow2 = arrayRowArr[i2];
                    if (arrayRow2 != arrayRow) {
                        arrayRow2.variables.updateFromRow(arrayRow2, arrayRow);
                        arrayRow2.updateClientEquations();
                    }
                    i2++;
                }
            }
        }
    }

    private int optimize(Goal goal) {
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z = false;
        int i2 = z;
        int i3 = i2;
        while (!z) {
            i2++;
            SolverVariable pivotCandidate = goal.getPivotCandidate();
            if (pivotCandidate != null) {
                if (this.mAlreadyTestedCandidates[pivotCandidate.id]) {
                    pivotCandidate = null;
                } else {
                    this.mAlreadyTestedCandidates[pivotCandidate.id] = true;
                    i3++;
                    if (i3 >= this.mNumColumns) {
                        z = true;
                    }
                }
            }
            if (pivotCandidate != null) {
                float f = AutoScrollHelper.NO_MAX;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    ArrayRow arrayRow = this.mRows[i5];
                    if (arrayRow.variable.mType != Type.UNRESTRICTED && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 >= 0) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(pivotCandidate);
                    arrayRow2.variable.definitionId = i4;
                    for (int i6 = 0; i6 < this.mNumRows; i6++) {
                        this.mRows[i6].updateRowWithEquation(arrayRow2);
                    }
                    goal.updateFromSystem(this);
                    try {
                        enforceBFS(goal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            z = true;
        }
        return i2;
    }

    private int enforceBFS(Goal goal) throws Exception {
        Object obj;
        int i;
        int i2;
        LinearSystem linearSystem = this;
        int i3 = 0;
        while (i3 < linearSystem.mNumRows) {
            if (linearSystem.mRows[i3].variable.mType != Type.UNRESTRICTED && linearSystem.mRows[i3].constantValue < 0.0f) {
                obj = 1;
                break;
            }
            i3++;
        }
        obj = null;
        if (obj != null) {
            obj = null;
            i = 0;
            while (obj == null) {
                i++;
                float f = Float.MAX_VALUE;
                int i4 = -1;
                int i5 = i4;
                int i6 = 0;
                for (int i7 = 0; i7 < linearSystem.mNumRows; i7++) {
                    ArrayRow arrayRow = linearSystem.mRows[i7];
                    if (arrayRow.variable.mType != Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                        int i8 = i6;
                        float f2 = f;
                        int i9 = i5;
                        i5 = i4;
                        for (i4 = 1; i4 < linearSystem.mNumColumns; i4++) {
                            SolverVariable solverVariable = linearSystem.mCache.mIndexedVariables[i4];
                            float f3 = arrayRow.variables.get(solverVariable);
                            if (f3 > 0.0f) {
                                i2 = i8;
                                float f4 = f2;
                                i6 = i9;
                                i9 = i5;
                                i5 = 0;
                                while (i5 < 6) {
                                    float f5 = solverVariable.strengthVector[i5] / f3;
                                    if ((f5 < f4 && i5 == i2) || i5 > i2) {
                                        f4 = f5;
                                        i9 = i7;
                                        i6 = i4;
                                        i2 = i5;
                                    }
                                    i5++;
                                }
                                i5 = i9;
                                i9 = i6;
                                f2 = f4;
                                i8 = i2;
                            }
                        }
                        i4 = i5;
                        i5 = i9;
                        f = f2;
                        i6 = i8;
                    }
                }
                if (i4 != -1) {
                    ArrayRow arrayRow2 = linearSystem.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    arrayRow2.pivot(linearSystem.mCache.mIndexedVariables[i5]);
                    arrayRow2.variable.definitionId = i4;
                    for (int i10 = 0; i10 < linearSystem.mNumRows; i10++) {
                        linearSystem.mRows[i10].updateRowWithEquation(arrayRow2);
                    }
                    goal.updateFromSystem(linearSystem);
                } else {
                    Goal goal2 = goal;
                    obj = 1;
                }
            }
        } else {
            i = 0;
        }
        i2 = 0;
        while (i2 < linearSystem.mNumRows && (linearSystem.mRows[i2].variable.mType == Type.UNRESTRICTED || linearSystem.mRows[i2].constantValue >= 0.0f)) {
            i2++;
        }
        return i;
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mRows[i]);
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str = stringBuilder.toString();
        }
        if (this.mGoal.variables.size() != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.mGoal);
            stringBuilder2.append("\n");
            str = stringBuilder2.toString();
        }
        System.out.println(str);
    }

    void displayReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.mRows[i].toReadableString());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str = stringBuilder.toString();
        }
        if (this.mGoal != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.mGoal);
            stringBuilder2.append("\n");
            str = stringBuilder2.toString();
        }
        System.out.println(str);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].variable.mType == Type.UNRESTRICTED) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.mRows[i].toReadableString());
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("\n");
                str = stringBuilder.toString();
            }
        }
        if (this.mGoal.variables.size() != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.mGoal);
            stringBuilder2.append("\n");
            str = stringBuilder2.toString();
        }
        System.out.println(str);
    }

    public int getMemoryUsed() {
        int i = 0;
        int i2 = 0;
        while (i < this.mNumRows) {
            if (this.mRows[i] != null) {
                i2 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        return i2;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    void displaySystemInformations() {
        int i = 0;
        int i2 = i;
        while (i < this.TABLE_SIZE) {
            if (this.mRows[i] != null) {
                i2 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        i = 0;
        int i3 = i;
        while (i < this.mNumRows) {
            if (this.mRows[i] != null) {
                i3 += this.mRows[i].sizeInBytes();
            }
            i++;
        }
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("Linear System -> Table size: ");
        stringBuilder.append(this.TABLE_SIZE);
        stringBuilder.append(" (");
        stringBuilder.append(getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE));
        stringBuilder.append(") -- row sizes: ");
        stringBuilder.append(getDisplaySize(i2));
        stringBuilder.append(", actual size: ");
        stringBuilder.append(getDisplaySize(i3));
        stringBuilder.append(" rows: ");
        stringBuilder.append(this.mNumRows);
        stringBuilder.append("/");
        stringBuilder.append(this.mMaxRows);
        stringBuilder.append(" cols: ");
        stringBuilder.append(this.mNumColumns);
        stringBuilder.append("/");
        stringBuilder.append(this.mMaxColumns);
        stringBuilder.append(" 0 occupied cells, ");
        stringBuilder.append(getDisplaySize(0));
        printStream.println(stringBuilder.toString());
    }

    private void displaySolverVariables() {
        StringBuilder stringBuilder = new StringBuilder("Display Rows (");
        stringBuilder.append(this.mNumRows);
        stringBuilder.append("x");
        stringBuilder.append(this.mNumColumns);
        stringBuilder.append(") :\n\t | C | ");
        String stringBuilder2 = stringBuilder.toString();
        for (int i = 1; i <= this.mNumColumns; i++) {
            Object obj = this.mCache.mIndexedVariables[i];
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(obj);
            stringBuilder2 = stringBuilder3.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(" | ");
            stringBuilder2 = stringBuilder4.toString();
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(stringBuilder2);
        stringBuilder5.append("\n");
        System.out.println(stringBuilder5.toString());
    }

    private String getDisplaySize(int i) {
        i *= 4;
        int i2 = i / 1024;
        int i3 = i2 / 1024;
        if (i3 > 0) {
            i = new StringBuilder();
            i.append(i3);
            i.append(" Mb");
            return i.toString();
        } else if (i2 > 0) {
            i = new StringBuilder();
            i.append(i2);
            i.append(" Kb");
            return i.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" bytes");
            return stringBuilder.toString();
        }
    }

    public Cache getCache() {
        return this.mCache;
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = i2;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = i2;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        int i4 = i3;
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        SolverVariable createErrorVariable = createErrorVariable();
        SolverVariable createErrorVariable2 = createErrorVariable();
        createErrorVariable.strength = i4;
        createErrorVariable2.strength = i4;
        createRow.addError(createErrorVariable, createErrorVariable2);
        addConstraint(createRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        solverVariable = createErrorVariable();
        solverVariable2 = createErrorVariable();
        solverVariable.strength = i2;
        solverVariable2.strength = i2;
        createRow.addError(solverVariable, solverVariable2);
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.definitionId;
        ArrayRow arrayRow;
        if (solverVariable.definitionId != -1) {
            arrayRow = this.mRows[i2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i;
                return;
            }
            arrayRow = createRow();
            arrayRow.createRowEquals(solverVariable, i);
            addConstraint(arrayRow);
            return;
        }
        arrayRow = createRow();
        arrayRow.createRowDefinition(solverVariable, i);
        addConstraint(arrayRow);
    }

    public static ArrayRow createRowEquals(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (z) {
            linearSystem.addSingleError(createRow, 1);
        }
        return createRow;
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        if (z) {
            linearSystem.addError(createRow);
        }
        return createRow.createRowDimensionPercent(solverVariable, solverVariable2, solverVariable3, f);
    }

    public static ArrayRow createRowGreaterThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (-1082130432 * createRow.variables.get(createSlackVariable)));
        }
        return createRow;
    }

    public static ArrayRow createRowLowerThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (-1082130432 * createRow.variables.get(createSlackVariable)));
        }
        return createRow;
    }

    public static ArrayRow createRowCentering(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (z) {
            SolverVariable createErrorVariable = linearSystem.createErrorVariable();
            SolverVariable createErrorVariable2 = linearSystem.createErrorVariable();
            createErrorVariable.strength = 4;
            createErrorVariable2.strength = 4;
            createRow.addError(createErrorVariable, createErrorVariable2);
        }
        return createRow;
    }
}
