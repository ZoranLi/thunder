package com.airbnb.lottie;

import android.support.v4.util.Pair;
import java.util.Comparator;

/* compiled from: PerformanceTracker */
final class t implements Comparator<Pair<String, Float>> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Pair pair = (Pair) obj2;
        obj = ((Float) ((Pair) obj).second).floatValue();
        obj2 = ((Float) pair.second).floatValue();
        if (obj2 > obj) {
            return 1;
        }
        return obj > obj2 ? -1 : null;
    }
}
