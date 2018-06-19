package com.tencent.tinker.commons.dexpatcher.util;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.instruction.InstructionPromoter;
import com.tencent.tinker.android.dx.instruction.InstructionReader;
import com.tencent.tinker.android.dx.instruction.InstructionVisitor;
import com.tencent.tinker.android.dx.instruction.InstructionWriter;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeInput;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeOutput;

/* compiled from: BUGLY */
public final class InstructionTransformer {
    private final AbstractIndexMap indexMap;

    /* compiled from: BUGLY */
    private final class InstructionTransformVisitor extends InstructionVisitor {
        InstructionTransformVisitor(InstructionVisitor instructionVisitor) {
            super(instructionVisitor);
        }

        public final void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
            super.visitZeroRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j);
        }

        public final void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            int i7 = i4;
            super.visitOneRegisterInsn(i, i2, transformIndexIfNeeded(i3, i7), i7, i5, j, i6);
        }

        public final void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            int i8 = i4;
            super.visitTwoRegisterInsn(i, i2, transformIndexIfNeeded(i3, i8), i8, i5, j, i6, i7);
        }

        public final void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            int i9 = i4;
            super.visitThreeRegisterInsn(i, i2, transformIndexIfNeeded(i3, i9), i9, i5, j, i6, i7, i8);
        }

        public final void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            int i10 = i4;
            super.visitFourRegisterInsn(i, i2, transformIndexIfNeeded(i3, i10), i10, i5, j, i6, i7, i8, i9);
        }

        public final void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            int i11 = i4;
            super.visitFiveRegisterInsn(i, i2, transformIndexIfNeeded(i3, i11), i11, i5, j, i6, i7, i8, i9, i10);
        }

        public final void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            int i8 = i4;
            super.visitRegisterRangeInsn(i, i2, transformIndexIfNeeded(i3, i8), i8, i5, j, i6, i7);
        }

        private int transformIndexIfNeeded(int i, int i2) {
            switch (i2) {
                case 2:
                    return InstructionTransformer.this.indexMap.adjustTypeIdIndex(i);
                case 3:
                    return InstructionTransformer.this.indexMap.adjustStringIndex(i);
                case 4:
                    return InstructionTransformer.this.indexMap.adjustMethodIdIndex(i);
                case 5:
                    return InstructionTransformer.this.indexMap.adjustFieldIdIndex(i);
                default:
                    return i;
            }
        }
    }

    public InstructionTransformer(AbstractIndexMap abstractIndexMap) {
        this.indexMap = abstractIndexMap;
    }

    public final short[] transform(short[] sArr) throws DexException {
        ShortArrayCodeOutput shortArrayCodeOutput = new ShortArrayCodeOutput(sArr.length);
        InstructionVisitor instructionPromoter = new InstructionPromoter();
        InstructionVisitor instructionWriter = new InstructionWriter(shortArrayCodeOutput, instructionPromoter);
        InstructionReader instructionReader = new InstructionReader(new ShortArrayCodeInput(sArr));
        try {
            instructionReader.accept(new InstructionTransformVisitor(instructionPromoter));
            instructionReader.accept(new InstructionTransformVisitor(instructionWriter));
            return shortArrayCodeOutput.getArray();
        } catch (Throwable e) {
            throw new DexException(e);
        }
    }
}
