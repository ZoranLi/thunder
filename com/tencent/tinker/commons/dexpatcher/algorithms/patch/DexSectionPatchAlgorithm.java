package com.tencent.tinker.commons.dexpatcher.algorithms.patch;

import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.TableOfContents.Section;
import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;
import java.util.Arrays;

/* compiled from: BUGLY */
public abstract class DexSectionPatchAlgorithm<T extends Comparable<T>> {
    protected final Dex oldDex;
    private final SparseIndexMap oldToPatchedIndexMap;
    protected final DexPatchFile patchFile;

    protected T adjustItem(AbstractIndexMap abstractIndexMap, T t) {
        return t;
    }

    protected abstract int getItemSize(T t);

    protected abstract Section getTocSection(Dex dex);

    protected void markDeletedIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2) {
    }

    protected abstract T nextItem(DexDataBuffer dexDataBuffer);

    protected void updateIndexOrOffset(SparseIndexMap sparseIndexMap, int i, int i2, int i3, int i4) {
    }

    protected abstract int writePatchedItem(T t);

    public DexSectionPatchAlgorithm(DexPatchFile dexPatchFile, Dex dex, SparseIndexMap sparseIndexMap) {
        this.patchFile = dexPatchFile;
        this.oldDex = dex;
        this.oldToPatchedIndexMap = sparseIndexMap;
    }

    private int[] readDeltaIndiciesOrOffsets(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i3 += this.patchFile.getBuffer().readSleb128();
            iArr[i2] = i3;
            i2++;
        }
        return iArr;
    }

    private int getItemOffsetOrIndex(int i, T t) {
        return t instanceof Item ? ((Item) t).off : i;
    }

    public void execute() {
        int i;
        Dex.Section section;
        int[] readDeltaIndiciesOrOffsets = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        int[] readDeltaIndiciesOrOffsets2 = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        int[] readDeltaIndiciesOrOffsets3 = readDeltaIndiciesOrOffsets(this.patchFile.getBuffer().readUleb128());
        Section tocSection = getTocSection(this.oldDex);
        if (tocSection.exists()) {
            Dex.Section openSection = this.oldDex.openSection(tocSection);
            i = tocSection.size;
            section = openSection;
        } else {
            section = null;
            i = 0;
        }
        doFullPatch(section, i, readDeltaIndiciesOrOffsets, readDeltaIndiciesOrOffsets2, readDeltaIndiciesOrOffsets3);
    }

    private void doFullPatch(Dex.Section section, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        DexSectionPatchAlgorithm dexSectionPatchAlgorithm = this;
        int i2 = i;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int[] iArr6 = iArr3;
        int i3 = 0;
        int length = iArr4.length;
        int length2 = iArr5.length;
        int length3 = iArr6.length;
        int i4 = (i2 + length2) - length;
        int i5 = 0;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        int i9 = i8;
        while (true) {
            if (i9 >= i2) {
                if (i8 >= i4) {
                    break;
                }
            }
            if (i7 < length2 && iArr5[i7] == i8) {
                writePatchedItem(nextItem(dexSectionPatchAlgorithm.patchFile.getBuffer()));
                i7++;
                i8++;
            } else if (i6 >= length3 || iArr6[i6] != i8) {
                if (Arrays.binarySearch(iArr4, i9) >= 0) {
                    markDeletedIndexOrOffset(dexSectionPatchAlgorithm.oldToPatchedIndexMap, i9, getItemOffsetOrIndex(i9, nextItem(section)));
                    i9++;
                    i5++;
                } else if (Arrays.binarySearch(iArr6, i9) >= 0) {
                    markDeletedIndexOrOffset(dexSectionPatchAlgorithm.oldToPatchedIndexMap, i9, getItemOffsetOrIndex(i9, nextItem(section)));
                    i9++;
                } else if (i9 < i2) {
                    Comparable adjustItem = adjustItem(dexSectionPatchAlgorithm.oldToPatchedIndexMap, nextItem(section));
                    i3 = writePatchedItem(adjustItem);
                    r16 = i5;
                    SparseIndexMap sparseIndexMap = dexSectionPatchAlgorithm.oldToPatchedIndexMap;
                    r18 = i6;
                    r19 = i7;
                    i7 = getItemOffsetOrIndex(i9, adjustItem);
                    r17 = i8;
                    r20 = i9;
                    updateIndexOrOffset(sparseIndexMap, i9, i7, i8, i3);
                    i9 = r20 + 1;
                    i8 = r17 + 1;
                    i5 = r16;
                    i6 = r18;
                    i7 = r19;
                } else {
                    r16 = i5;
                    r18 = i6;
                    r19 = i7;
                    r17 = i8;
                    r20 = i9;
                }
                i3 = 0;
            } else {
                writePatchedItem(nextItem(dexSectionPatchAlgorithm.patchFile.getBuffer()));
                i6++;
                i8++;
            }
        }
        if (i7 == length2 && i5 == length) {
            if (i6 == length3) {
                return;
            }
        }
        throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i7), Integer.valueOf(length2), Integer.valueOf(i5), Integer.valueOf(length), Integer.valueOf(i6), Integer.valueOf(length3)}));
    }
}
