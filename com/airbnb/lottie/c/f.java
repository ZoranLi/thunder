package com.airbnb.lottie.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.content.h;

/* compiled from: MiscUtils */
public final class f {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF pointF = hVar.b;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        for (int i = 0; i < hVar.a.size(); i++) {
            c cVar = (c) hVar.a.get(i);
            PointF pointF3 = cVar.a;
            PointF pointF4 = cVar.b;
            PointF pointF5 = cVar.c;
            if (pointF3.equals(pointF2) && pointF4.equals(pointF5)) {
                path.lineTo(pointF5.x, pointF5.y);
            } else {
                path.cubicTo(pointF3.x, pointF3.y, pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            }
            pointF2.set(pointF5.x, pointF5.y);
        }
        if (hVar.c != null) {
            path.close();
        }
    }

    public static float a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int a(float f, float f2) {
        int i = (int) f;
        f2 = (int) f2;
        int i2 = i / f2;
        if ((i ^ f2) < 0 && i2 * f2 != i) {
            i2--;
        }
        return i - (i2 * f2);
    }
}
