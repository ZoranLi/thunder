package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.layer.a;

public final class MergePaths implements b {
    public final String a;
    public final MergePathsMode b;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        private static MergePathsMode forId(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    private MergePaths(String str, MergePathsMode mergePathsMode) {
        this.a = str;
        this.b = mergePathsMode;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MergePaths{mode=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Nullable
    public final b a(j jVar, a aVar) {
        return jVar.l == null ? null : new com.airbnb.lottie.a.a.j(this);
    }
}
