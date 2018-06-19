package com.tencent.tinker.android.dx.instruction;

/* compiled from: BUGLY */
public class InstructionVisitor {
    private final InstructionVisitor prevIv;

    public InstructionVisitor(InstructionVisitor instructionVisitor) {
        this.prevIv = instructionVisitor;
    }

    public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.prevIv != null) {
            r0.prevIv.visitZeroRegisterInsn(i, i2, i3, i4, i5, j);
        }
    }

    public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.prevIv != null) {
            r0.prevIv.visitOneRegisterInsn(i, i2, i3, i4, i5, j, i6);
        }
    }

    public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.prevIv != null) {
            r0.prevIv.visitTwoRegisterInsn(i, i2, i3, i4, i5, j, i6, i7);
        }
    }

    public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        if (this.prevIv != null) {
            r0.prevIv.visitThreeRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8);
        }
    }

    public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        if (this.prevIv != null) {
            r0.prevIv.visitFourRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8, i9);
        }
    }

    public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        if (this.prevIv != null) {
            r0.prevIv.visitFiveRegisterInsn(i, i2, i3, i4, i5, j, i6, i7, i8, i9, i10);
        }
    }

    public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.prevIv != null) {
            r0.prevIv.visitRegisterRangeInsn(i, i2, i3, i4, i5, j, i6, i7);
        }
    }

    public void visitSparseSwitchPayloadInsn(int i, int i2, int[] iArr, int[] iArr2) {
        if (this.prevIv != null) {
            this.prevIv.visitSparseSwitchPayloadInsn(i, i2, iArr, iArr2);
        }
    }

    public void visitPackedSwitchPayloadInsn(int i, int i2, int i3, int[] iArr) {
        if (this.prevIv != null) {
            this.prevIv.visitPackedSwitchPayloadInsn(i, i2, i3, iArr);
        }
    }

    public void visitFillArrayDataPayloadInsn(int i, int i2, Object obj, int i3, int i4) {
        if (this.prevIv != null) {
            this.prevIv.visitFillArrayDataPayloadInsn(i, i2, obj, i3, i4);
        }
    }
}
