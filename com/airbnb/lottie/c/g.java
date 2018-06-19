package com.airbnb.lottie.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.s;
import com.airbnb.lottie.d;
import com.airbnb.lottie.i;

/* compiled from: Utils */
public final class g {
    private static final PathMeasure a = new PathMeasure();
    private static final Path b = new Path();
    private static final Path c = new Path();
    private static final float[] d = new float[4];
    private static final float e = ((float) Math.sqrt(2.0d));

    public static int a(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (527.0f * f) : 17;
        if (f2 != 0.0f) {
            i = (int) (((float) (i * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        return f4 != 0.0f ? (int) (((float) (31 * i)) * f4) : i;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.g.a(java.io.Closeable):void");
    }

    public static float a(Matrix matrix) {
        d[0] = 0.0f;
        d[1] = 0.0f;
        d[2] = e;
        d[3] = e;
        matrix.mapPoints(d);
        return ((float) Math.hypot((double) (d[2] - d[0]), (double) (d[3] - d[1]))) / 2.0f;
    }

    public static void a(Path path, float f, float f2, float f3) {
        d.a("applyTrimPathIfNeeded");
        a.setPath(path, false);
        float length = a.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            d.b("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f) {
            if (((double) Math.abs((f2 - f) - 1.0f)) >= 0.01d) {
                f *= length;
                f2 *= length;
                f3 *= length;
                float min = Math.min(f, f2) + f3;
                f = Math.max(f, f2) + f3;
                if (min >= length && f >= length) {
                    min = (float) f.a(min, length);
                    f = (float) f.a(f, length);
                }
                if (min < 0.0f) {
                    min = (float) f.a(min, length);
                }
                if (f < 0.0f) {
                    f = (float) f.a(f, length);
                }
                if (min == f) {
                    path.reset();
                    d.b("applyTrimPathIfNeeded");
                    return;
                }
                if (min >= f) {
                    min -= length;
                }
                b.reset();
                a.getSegment(min, f, b, true);
                if (f > length) {
                    c.reset();
                    a.getSegment(0.0f, f % length, c, true);
                    b.addPath(c);
                } else if (min < 0.0f) {
                    c.reset();
                    a.getSegment(min + length, length, c, true);
                    b.addPath(c);
                }
                path.set(b);
                d.b("applyTrimPathIfNeeded");
                return;
            }
        }
        d.b("applyTrimPathIfNeeded");
    }

    public static float a(Context context) {
        if (VERSION.SDK_INT >= 17) {
            return Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static void a(Path path, @Nullable s sVar) {
        if (sVar != null) {
            a(path, ((Float) sVar.b.a()).floatValue() / 100.0f, ((Float) sVar.c.a()).floatValue() / 100.0f, ((Float) sVar.d.a()).floatValue() / 360.0f);
        }
    }

    public static boolean a(i iVar, int i) {
        if (iVar.l < 4) {
            return false;
        }
        if (iVar.l > 4) {
            return true;
        }
        if (iVar.m < i) {
            return false;
        }
        return iVar.m > i || iVar.n >= null;
    }
}
