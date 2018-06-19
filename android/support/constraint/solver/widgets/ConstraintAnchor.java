package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;

public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    public static final int ANY_GROUP = Integer.MAX_VALUE;
    public static final int APPLY_GROUP_RESULTS = -2;
    public static final int AUTO_CONSTRAINT_CREATOR = 2;
    public static final int SCOUT_CREATOR = 1;
    private static final int UNSET_GONE_MARGIN = -1;
    public static final int USER_CREATOR = 0;
    public static final boolean USE_CENTER_ANCHOR = false;
    private int mConnectionCreator = 0;
    private ConnectionType mConnectionType = ConnectionType.RELAXED;
    int mGoneMargin = -1;
    int mGroup = Integer.MAX_VALUE;
    public int mMargin = 0;
    final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    private Strength mStrength = Strength.NONE;
    ConstraintAnchor mTarget;
    final Type mType;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public void resetSolverVariable(Cache cache) {
        if (this.mSolverVariable == null) {
            this.mSolverVariable = new SolverVariable(android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED);
        } else {
            this.mSolverVariable.reset();
        }
    }

    public void setGroup(int i) {
        this.mGroup = i;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public Type getType() {
        return this.mType;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin < 0 || this.mTarget == null || this.mTarget.mOwner.getVisibility() != 8) {
            return this.mMargin;
        }
        return this.mGoneMargin;
    }

    public Strength getStrength() {
        return this.mStrength;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public ConnectionType getConnectionType() {
        return this.mConnectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.mConnectionType = connectionType;
    }

    public int getConnectionCreator() {
        return this.mConnectionCreator;
    }

    public void setConnectionCreator(int i) {
        this.mConnectionCreator = i;
    }

    public void reset() {
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mStrength = Strength.STRONG;
        this.mConnectionCreator = 0;
        this.mConnectionType = ConnectionType.RELAXED;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return connect(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.mTarget = null;
            this.mMargin = 0;
            this.mGoneMargin = -1;
            this.mStrength = Strength.NONE;
            this.mConnectionCreator = 2;
            return true;
        } else if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        } else {
            this.mTarget = constraintAnchor;
            if (i > 0) {
                this.mMargin = i;
            } else {
                this.mMargin = 0;
            }
            this.mGoneMargin = i2;
            this.mStrength = strength;
            this.mConnectionCreator = i3;
            return true;
        }
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i, int i2) {
        return connect(constraintAnchor, i, -1, Strength.STRONG, i2, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i) {
        return connect(constraintAnchor, i, -1, Strength.STRONG, 0, false);
    }

    public boolean isConnected() {
        return this.mTarget != null;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        if (type != this.mType) {
            boolean z;
            switch (this.mType) {
                case CENTER:
                    if (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    if (type != Type.LEFT) {
                        if (type != Type.RIGHT) {
                            z = false;
                            if ((constraintAnchor.getOwner() instanceof Guideline) != null) {
                                if (!z) {
                                    if (type == Type.CENTER_X) {
                                        z = false;
                                    }
                                }
                                z = true;
                            }
                            return z;
                        }
                    }
                    z = true;
                    if ((constraintAnchor.getOwner() instanceof Guideline) != null) {
                        if (z) {
                            if (type == Type.CENTER_X) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    return z;
                case TOP:
                case BOTTOM:
                    if (type != Type.TOP) {
                        if (type != Type.BOTTOM) {
                            z = false;
                            if ((constraintAnchor.getOwner() instanceof Guideline) != null) {
                                if (!z) {
                                    if (type == Type.CENTER_Y) {
                                        z = false;
                                    }
                                }
                                z = true;
                            }
                            return z;
                        }
                    }
                    z = true;
                    if ((constraintAnchor.getOwner() instanceof Guideline) != null) {
                        if (z) {
                            if (type == Type.CENTER_Y) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    return z;
                default:
                    return false;
            }
        } else if (this.mType == Type.CENTER) {
            return false;
        } else {
            if (this.mType == Type.BASELINE && (constraintAnchor.getOwner().hasBaseline() == null || getOwner().hasBaseline() == null)) {
                return false;
            }
            return true;
        }
    }

    public boolean isSideAnchor() {
        switch (this.mType) {
            case LEFT:
            case RIGHT:
            case TOP:
            case BOTTOM:
                return true;
            default:
                return false;
        }
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        constraintAnchor = constraintAnchor.getType();
        if (constraintAnchor == this.mType) {
            return true;
        }
        switch (this.mType) {
            case CENTER:
                if (constraintAnchor != Type.BASELINE) {
                    return true;
                }
                return false;
            case LEFT:
            case RIGHT:
            case CENTER_X:
                if (!(constraintAnchor == Type.LEFT || constraintAnchor == Type.RIGHT)) {
                    if (constraintAnchor != Type.CENTER_X) {
                        return false;
                    }
                }
                return true;
            case TOP:
            case BOTTOM:
            case CENTER_Y:
            case BASELINE:
                if (!(constraintAnchor == Type.TOP || constraintAnchor == Type.BOTTOM || constraintAnchor == Type.CENTER_Y)) {
                    if (constraintAnchor != Type.BASELINE) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public void setStrength(Strength strength) {
        if (isConnected()) {
            this.mStrength = strength;
        }
    }

    public void setMargin(int i) {
        if (isConnected()) {
            this.mMargin = i;
        }
    }

    public void setGoneMargin(int i) {
        if (isConnected()) {
            this.mGoneMargin = i;
        }
    }

    public boolean isVerticalAnchor() {
        int i = AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()];
        if (i != 6) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return true;
            }
        }
        return false;
    }

    public String toString() {
        String stringBuilder;
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.mOwner.getDebugName());
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(this.mType.toString());
        if (this.mTarget != null) {
            StringBuilder stringBuilder3 = new StringBuilder(" connected to ");
            stringBuilder3.append(this.mTarget.toString(hashSet));
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }

    private String toString(HashSet<ConstraintAnchor> hashSet) {
        if (!hashSet.add(this)) {
            return "<-";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mOwner.getDebugName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.mType.toString());
        if (this.mTarget != null) {
            StringBuilder stringBuilder2 = new StringBuilder(" connected to ");
            stringBuilder2.append(this.mTarget.toString(hashSet));
            hashSet = stringBuilder2.toString();
        } else {
            hashSet = "";
        }
        stringBuilder.append(hashSet);
        return stringBuilder.toString();
    }

    public int getSnapPriorityLevel() {
        switch (this.mType) {
            case CENTER:
                return 3;
            case LEFT:
                return 1;
            case RIGHT:
                return 1;
            case TOP:
                return 0;
            case BOTTOM:
                return 0;
            case CENTER_X:
                return 0;
            case CENTER_Y:
                return 1;
            case BASELINE:
                return 2;
            default:
                return 0;
        }
    }

    public int getPriorityLevel() {
        switch (this.mType) {
            case CENTER:
                return 2;
            case LEFT:
                return 2;
            case RIGHT:
                return 2;
            case TOP:
                return 2;
            case BOTTOM:
                return 2;
            case CENTER_X:
                return 0;
            case CENTER_Y:
                return 0;
            case BASELINE:
                return 1;
            default:
                return 0;
        }
    }

    public boolean isSnapCompatibleWith(ConstraintAnchor constraintAnchor) {
        if (this.mType == Type.CENTER) {
            return false;
        }
        if (this.mType == constraintAnchor.getType()) {
            return true;
        }
        switch (this.mType) {
            case LEFT:
                constraintAnchor = AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                if (constraintAnchor == 3 || constraintAnchor == 6) {
                    return true;
                }
                return false;
            case RIGHT:
                constraintAnchor = AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                if (constraintAnchor == 2 || constraintAnchor == 6) {
                    return true;
                }
                return false;
            case TOP:
                constraintAnchor = AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                if (constraintAnchor == 5 || constraintAnchor == 7) {
                    return true;
                }
                return false;
            case BOTTOM:
                constraintAnchor = AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[constraintAnchor.getType().ordinal()];
                if (constraintAnchor == 4 || constraintAnchor == 7) {
                    return true;
                }
                return false;
            case CENTER_X:
                switch (constraintAnchor.getType()) {
                    case LEFT:
                        return true;
                    case RIGHT:
                        return true;
                    default:
                        return false;
                }
            case CENTER_Y:
                switch (constraintAnchor.getType()) {
                    case TOP:
                        return true;
                    case BOTTOM:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return isConnectionAllowed(constraintWidget);
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (isConnectionToMe(constraintWidget, new HashSet())) {
            return false;
        }
        ConstraintWidget parent = getOwner().getParent();
        if (parent == constraintWidget || constraintWidget.getParent() == parent) {
            return true;
        }
        return false;
    }

    private boolean isConnectionToMe(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == getOwner()) {
            return true;
        }
        constraintWidget = constraintWidget.getAnchors();
        int size = constraintWidget.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) constraintWidget.get(i);
            if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && isConnectionToMe(constraintAnchor.getTarget().getOwner(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public final ConstraintAnchor getOpposite() {
        switch (this.mType) {
            case LEFT:
                return this.mOwner.mRight;
            case RIGHT:
                return this.mOwner.mLeft;
            case TOP:
                return this.mOwner.mBottom;
            case BOTTOM:
                return this.mOwner.mTop;
            default:
                return null;
        }
    }
}
