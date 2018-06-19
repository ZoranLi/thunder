package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor = this.mTop;
    private Rectangle mHead = new Rectangle();
    private int mHeadSize = 8;
    private boolean mIsPositionRelaxed = false;
    private int mMinimumPosition = 0;
    private int mOrientation = 0;
    protected int mRelativeBegin = -1;
    protected int mRelativeEnd = -1;
    protected float mRelativePercent = -1.0f;

    public String getType() {
        return "Guideline";
    }

    public Guideline() {
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
    }

    public int getRelativeBehaviour() {
        if (this.mRelativePercent != -1.0f) {
            return 0;
        }
        if (this.mRelativeBegin != -1) {
            return 1;
        }
        if (this.mRelativeEnd != -1) {
            return 2;
        }
        return -1;
    }

    public Rectangle getHead() {
        this.mHead.setBounds(getDrawX() - this.mHeadSize, getDrawY() - (this.mHeadSize * 2), this.mHeadSize * 2, this.mHeadSize * 2);
        if (getOrientation() == 0) {
            this.mHead.setBounds(getDrawX() - (this.mHeadSize * 2), getDrawY() - this.mHeadSize, this.mHeadSize * 2, 2 * this.mHeadSize);
        }
        return this.mHead;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            this.mAnchors.clear();
            if (this.mOrientation == 1) {
                this.mAnchor = this.mLeft;
            } else {
                this.mAnchor = this.mTop;
            }
            this.mAnchors.add(this.mAnchor);
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setMinimumPosition(int i) {
        this.mMinimumPosition = i;
    }

    public void setPositionRelaxed(boolean z) {
        if (this.mIsPositionRelaxed != z) {
            this.mIsPositionRelaxed = z;
        }
    }

    public ConstraintAnchor getAnchor(Type type) {
        switch (type) {
            case LEFT:
            case RIGHT:
                if (this.mOrientation == 1) {
                    return this.mAnchor;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.mOrientation == null) {
                    return this.mAnchor;
                }
                break;
            default:
                break;
        }
        return null;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setGuidePercent(int i) {
        setGuidePercent(((float) i) / 1120403456);
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.mRelativePercent = f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuideBegin(int i) {
        if (i >= 0) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = i;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i >= 0) {
            this.mRelativePercent = -1.0f;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = i;
        }
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public void addToSolver(LinearSystem linearSystem, int i) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer != null) {
            Object anchor = constraintWidgetContainer.getAnchor(Type.LEFT);
            Object anchor2 = constraintWidgetContainer.getAnchor(Type.RIGHT);
            if (this.mOrientation == 0) {
                anchor = constraintWidgetContainer.getAnchor(Type.TOP);
                anchor2 = constraintWidgetContainer.getAnchor(Type.BOTTOM);
            }
            if (this.mRelativeBegin != -1) {
                linearSystem.addConstraint(LinearSystem.createRowEquals(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor), this.mRelativeBegin, false));
            } else if (this.mRelativeEnd != -1) {
                linearSystem.addConstraint(LinearSystem.createRowEquals(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor2), -this.mRelativeEnd, false));
            } else {
                if (this.mRelativePercent != -1082130432) {
                    linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.mAnchor), linearSystem.createObjectVariable(anchor), linearSystem.createObjectVariable(anchor2), this.mRelativePercent, this.mIsPositionRelaxed));
                }
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, int i) {
        if (getParent() != 0) {
            linearSystem = linearSystem.getObjectVariableValue(this.mAnchor);
            if (this.mOrientation == 1) {
                setX(linearSystem);
                setY(0);
                setHeight(getParent().getHeight());
                setWidth(0);
                return;
            }
            setX(0);
            setY(linearSystem);
            setWidth(getParent().getWidth());
            setHeight(0);
        }
    }

    public void setDrawOrigin(int i, int i2) {
        if (this.mOrientation == 1) {
            i -= this.mOffsetX;
            if (this.mRelativeBegin != -1) {
                setGuideBegin(i);
                return;
            } else if (this.mRelativeEnd != -1) {
                setGuideEnd(getParent().getWidth() - i);
                return;
            } else {
                if (this.mRelativePercent != -1082130432) {
                    setGuidePercent(((float) i) / ((float) getParent().getWidth()));
                }
                return;
            }
        }
        i2 -= this.mOffsetY;
        if (this.mRelativeBegin != -1) {
            setGuideBegin(i2);
        } else if (this.mRelativeEnd != -1) {
            setGuideEnd(getParent().getHeight() - i2);
        } else {
            if (this.mRelativePercent != -1082130432) {
                setGuidePercent(((float) i2) / ((float) getParent().getHeight()));
            }
        }
    }

    void inferRelativePercentPosition() {
        float x = ((float) getX()) / ((float) getParent().getWidth());
        if (this.mOrientation == 0) {
            x = ((float) getY()) / ((float) getParent().getHeight());
        }
        setGuidePercent(x);
    }

    void inferRelativeBeginPosition() {
        int x = getX();
        if (this.mOrientation == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    void inferRelativeEndPosition() {
        int width = getParent().getWidth() - getX();
        if (this.mOrientation == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    public void cyclePosition() {
        if (this.mRelativeBegin != -1) {
            inferRelativePercentPosition();
        } else if (this.mRelativePercent != -1.0f) {
            inferRelativeEndPosition();
        } else {
            if (this.mRelativeEnd != -1) {
                inferRelativeBeginPosition();
            }
        }
    }
}
