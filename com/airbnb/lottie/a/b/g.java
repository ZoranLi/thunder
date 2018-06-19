package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation */
public final class g {
    public final List<a<h, Path>> a;
    public final List<a<Integer, Integer>> b;
    public final List<Mask> c;

    public g(List<Mask> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(((Mask) list.get(i)).b.a());
            this.b.add(((Mask) list.get(i)).c.a());
        }
    }
}
