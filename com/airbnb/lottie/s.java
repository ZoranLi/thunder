package com.airbnb.lottie;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import com.airbnb.lottie.c.e;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker */
public final class s {
    public boolean a = false;
    public final Set<Object> b = new ArraySet();
    public Map<String, e> c = new HashMap();
    private final Comparator<Pair<String, Float>> d = new t(this);
}
