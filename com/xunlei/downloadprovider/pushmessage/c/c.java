package com.xunlei.downloadprovider.pushmessage.c;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationsUtils */
public class c {
    private static final String a = "c";
    private static final String[] b = new String[]{"vivo X20A"};
    private static int c = 0;
    private static boolean d = false;
    private static boolean e;

    public static boolean a(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r1 = com.xunlei.common.androidutil.AndroidConfig.getAndroidVersion();	 Catch:{ Exception -> 0x0070 }
        r2 = 19;	 Catch:{ Exception -> 0x0070 }
        if (r1 < r2) goto L_0x0070;	 Catch:{ Exception -> 0x0070 }
    L_0x0009:
        r1 = "appops";	 Catch:{ Exception -> 0x0070 }
        r1 = r10.getSystemService(r1);	 Catch:{ Exception -> 0x0070 }
        r1 = (android.app.AppOpsManager) r1;	 Catch:{ Exception -> 0x0070 }
        r2 = r10.getApplicationInfo();	 Catch:{ Exception -> 0x0070 }
        r10 = r10.getApplicationContext();	 Catch:{ Exception -> 0x0070 }
        r10 = r10.getPackageName();	 Catch:{ Exception -> 0x0070 }
        r2 = r2.uid;	 Catch:{ Exception -> 0x0070 }
        r3 = android.app.AppOpsManager.class;	 Catch:{ Exception -> 0x0070 }
        r3 = r3.getName();	 Catch:{ Exception -> 0x0070 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Exception -> 0x0070 }
        r4 = "checkOpNoThrow";	 Catch:{ Exception -> 0x0070 }
        r5 = 3;	 Catch:{ Exception -> 0x0070 }
        r6 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0070 }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0070 }
        r8 = 0;	 Catch:{ Exception -> 0x0070 }
        r6[r8] = r7;	 Catch:{ Exception -> 0x0070 }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0070 }
        r6[r0] = r7;	 Catch:{ Exception -> 0x0070 }
        r7 = java.lang.String.class;	 Catch:{ Exception -> 0x0070 }
        r9 = 2;	 Catch:{ Exception -> 0x0070 }
        r6[r9] = r7;	 Catch:{ Exception -> 0x0070 }
        r4 = r3.getMethod(r4, r6);	 Catch:{ Exception -> 0x0070 }
        r6 = "OP_POST_NOTIFICATION";	 Catch:{ Exception -> 0x0070 }
        r3 = r3.getDeclaredField(r6);	 Catch:{ Exception -> 0x0070 }
        r6 = java.lang.Integer.class;	 Catch:{ Exception -> 0x0070 }
        r3 = r3.get(r6);	 Catch:{ Exception -> 0x0070 }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x0070 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0070 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0070 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0070 }
        r5[r8] = r3;	 Catch:{ Exception -> 0x0070 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0070 }
        r5[r0] = r2;	 Catch:{ Exception -> 0x0070 }
        r5[r9] = r10;	 Catch:{ Exception -> 0x0070 }
        r10 = r4.invoke(r1, r5);	 Catch:{ Exception -> 0x0070 }
        r10 = (java.lang.Integer) r10;	 Catch:{ Exception -> 0x0070 }
        r10 = r10.intValue();	 Catch:{ Exception -> 0x0070 }
        if (r10 != 0) goto L_0x006f;
    L_0x006e:
        return r0;
    L_0x006f:
        return r8;
    L_0x0070:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.c.c.a(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        if (!d) {
            c(context);
        }
        return e;
    }

    public static void c(Context context) {
        e = d(context);
        d = true;
    }

    private static int e(Context context) {
        try {
            ViewGroup viewGroup;
            TextView textView;
            if (context instanceof AppCompatActivity) {
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(new Builder(context).build().contentView.getLayoutId(), null);
                textView = (TextView) viewGroup.findViewById(16908310);
                if (textView != null) {
                    return textView.getCurrentTextColor();
                }
                List arrayList = new ArrayList();
                a(viewGroup, new e(arrayList));
                int size = arrayList.size();
                int i = 0;
                float f = -2.14748365E9f;
                for (int i2 = i; i2 < size; i2++) {
                    float textSize = ((TextView) arrayList.get(i2)).getTextSize();
                    if (textSize > f) {
                        i = i2;
                        f = textSize;
                    }
                }
                return ((TextView) arrayList.get(i)).getCurrentTextColor();
            }
            Builder builder = new Builder(context);
            builder.setContentText("DUMMY_TITLE");
            viewGroup = (ViewGroup) builder.build().contentView.apply(context, new FrameLayout(context));
            textView = (TextView) viewGroup.findViewById(16908310);
            if (textView != null) {
                return textView.getCurrentTextColor();
            }
            a(viewGroup, new d());
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            context = context.obtainStyledAttributes(R.style.NotificationTitle, new int[]{16842904});
            int color = context.getColor(0, -16777216);
            new StringBuilder("notification's title text: ").append(Integer.toHexString(color));
            context.recycle();
            return color;
        }
    }

    private static void a(View view, a aVar) {
        if (view != null) {
            if (aVar != null) {
                aVar.a(view);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        a(viewGroup.getChildAt(i), aVar);
                    }
                }
            }
        }
    }

    private static boolean d(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r1 = com.xunlei.common.androidutil.AndroidConfig.getPhoneModel();	 Catch:{ Exception -> 0x0059 }
        r2 = b;	 Catch:{ Exception -> 0x0059 }
        r3 = r2.length;	 Catch:{ Exception -> 0x0059 }
        r4 = 0;	 Catch:{ Exception -> 0x0059 }
        r5 = r4;	 Catch:{ Exception -> 0x0059 }
    L_0x000a:
        if (r5 >= r3) goto L_0x0019;	 Catch:{ Exception -> 0x0059 }
    L_0x000c:
        r6 = r2[r5];	 Catch:{ Exception -> 0x0059 }
        r6 = r6.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0059 }
        if (r6 == 0) goto L_0x0016;	 Catch:{ Exception -> 0x0059 }
    L_0x0014:
        r1 = r0;	 Catch:{ Exception -> 0x0059 }
        goto L_0x001a;	 Catch:{ Exception -> 0x0059 }
    L_0x0016:
        r5 = r5 + 1;	 Catch:{ Exception -> 0x0059 }
        goto L_0x000a;	 Catch:{ Exception -> 0x0059 }
    L_0x0019:
        r1 = r4;	 Catch:{ Exception -> 0x0059 }
    L_0x001a:
        if (r1 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x0059 }
    L_0x001c:
        return r4;	 Catch:{ Exception -> 0x0059 }
    L_0x001d:
        r7 = e(r7);	 Catch:{ Exception -> 0x0059 }
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;	 Catch:{ Exception -> 0x0059 }
        r7 = r7 | r1;	 Catch:{ Exception -> 0x0059 }
        r2 = android.graphics.Color.red(r1);	 Catch:{ Exception -> 0x0059 }
        r3 = android.graphics.Color.red(r7);	 Catch:{ Exception -> 0x0059 }
        r2 = r2 - r3;	 Catch:{ Exception -> 0x0059 }
        r3 = android.graphics.Color.green(r1);	 Catch:{ Exception -> 0x0059 }
        r5 = android.graphics.Color.green(r7);	 Catch:{ Exception -> 0x0059 }
        r3 = r3 - r5;	 Catch:{ Exception -> 0x0059 }
        r1 = android.graphics.Color.blue(r1);	 Catch:{ Exception -> 0x0059 }
        r7 = android.graphics.Color.blue(r7);	 Catch:{ Exception -> 0x0059 }
        r1 = r1 - r7;	 Catch:{ Exception -> 0x0059 }
        r2 = r2 * r2;	 Catch:{ Exception -> 0x0059 }
        r3 = r3 * r3;	 Catch:{ Exception -> 0x0059 }
        r2 = r2 + r3;	 Catch:{ Exception -> 0x0059 }
        r1 = r1 * r1;	 Catch:{ Exception -> 0x0059 }
        r2 = r2 + r1;	 Catch:{ Exception -> 0x0059 }
        r1 = (double) r2;	 Catch:{ Exception -> 0x0059 }
        r1 = java.lang.Math.sqrt(r1);	 Catch:{ Exception -> 0x0059 }
        r5 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r7 >= 0) goto L_0x0054;
    L_0x0052:
        r7 = r0;
        goto L_0x0055;
    L_0x0054:
        r7 = r4;
    L_0x0055:
        if (r7 != 0) goto L_0x0058;
    L_0x0057:
        return r0;
    L_0x0058:
        return r4;
    L_0x0059:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.pushmessage.c.c.d(android.content.Context):boolean");
    }
}
