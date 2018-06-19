package com.tencent.bugly.beta.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.a;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.b;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import java.util.Locale;

/* compiled from: BUGLY */
public class h extends a {
    public static h v = new h();
    DownloadListener A = new a(2, this);
    private d B = null;
    protected TextView n;
    protected TextView o;
    public y p;
    public DownloadTask q;
    public Runnable r;
    public Runnable s;
    protected Bitmap t = null;
    public BitmapDrawable u;
    public UILifecycleListener w;
    OnClickListener x = new b(4, new Object[]{this});
    OnClickListener y = new b(5, new Object[]{this});
    OnClickListener z = new b(6, new Object[]{this});

    public void onStart() {
        super.onStart();
        if (this.w != null) {
            this.w.onStart(this.a, this.b, this.p != null ? new UpgradeInfo(this.p) : null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.l != null) {
            this.n = (TextView) layoutInflater.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.o = (TextView) layoutInflater.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            viewGroup = new LayoutParams(-1, -1);
            View linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(viewGroup);
            linearLayout.setOrientation(1);
            viewGroup = new LayoutParams(-1, -2);
            bundle = ResBean.a;
            if (e.E.T) {
                this.n = new TextView(this.a);
                this.n.setLayoutParams(viewGroup);
                TextView textView = this.n;
                bundle.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                this.n.setTextSize(14.0f);
                this.n.setTag(Beta.TAG_UPGRADE_INFO);
                this.n.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.n);
            }
            View textView2 = new TextView(this.a);
            textView2.setLayoutParams(viewGroup);
            bundle.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            textView2.setTextSize(14.0f);
            textView2.setSingleLine();
            textView2.setEllipsize(TruncateAt.END);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Beta.strUpgradeDialogFeatureLabel);
            stringBuilder.append(": ");
            textView2.setText(String.valueOf(stringBuilder.toString()));
            textView2.setPadding(0, com.tencent.bugly.beta.global.a.a(this.a, 8.0f), 0, 0);
            linearLayout.addView(textView2);
            this.o = new TextView(this.a);
            this.o.setLayoutParams(viewGroup);
            viewGroup = this.o;
            bundle.getClass();
            viewGroup.setTextColor(Color.parseColor("#273238"));
            this.o.setTextSize(14.0f);
            this.o.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.o.setMaxHeight(com.tencent.bugly.beta.global.a.a(this.a, 200.0f));
            this.o.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.o);
            this.i.addView(linearLayout);
        }
        if (this.w != null) {
            this.w.onCreate(getActivity(), layoutInflater, this.p != null ? new UpgradeInfo(this.p) : null);
        }
        return layoutInflater;
    }

    public void onDestroyView() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        super.onDestroyView();	 Catch:{ Exception -> 0x0031 }
        r0 = 0;	 Catch:{ Exception -> 0x0031 }
        r5.n = r0;	 Catch:{ Exception -> 0x0031 }
        r5.o = r0;	 Catch:{ Exception -> 0x0031 }
        monitor-enter(r5);	 Catch:{ Exception -> 0x0031 }
        r5.B = r0;	 Catch:{ all -> 0x002e }
        monitor-exit(r5);	 Catch:{ all -> 0x002e }
        r1 = r5.u;	 Catch:{ Exception -> 0x0031 }
        if (r1 == 0) goto L_0x0015;	 Catch:{ Exception -> 0x0031 }
    L_0x0010:
        r1 = r5.u;	 Catch:{ Exception -> 0x0031 }
        r1.setCallback(r0);	 Catch:{ Exception -> 0x0031 }
    L_0x0015:
        r1 = r5.w;	 Catch:{ Exception -> 0x0031 }
        if (r1 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x0031 }
    L_0x0019:
        r1 = r5.w;	 Catch:{ Exception -> 0x0031 }
        r2 = r5.a;	 Catch:{ Exception -> 0x0031 }
        r3 = r5.b;	 Catch:{ Exception -> 0x0031 }
        r4 = r5.p;	 Catch:{ Exception -> 0x0031 }
        if (r4 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x0031 }
    L_0x0023:
        r0 = new com.tencent.bugly.beta.UpgradeInfo;	 Catch:{ Exception -> 0x0031 }
        r4 = r5.p;	 Catch:{ Exception -> 0x0031 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x0031 }
    L_0x002a:
        r1.onDestroy(r2, r3, r0);	 Catch:{ Exception -> 0x0031 }
    L_0x002d:
        return;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x002e }
        throw r0;	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.h.onDestroyView():void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = e.E.i;
        this.w = e.E.k;
        try {
            this.k = Integer.parseInt(ResBean.a.a("VAL_style"));
        } catch (Bundle bundle2) {
            an.a(bundle2.getMessage(), new Object[0]);
            this.k = 0;
        }
    }

    public void a(DownloadTask downloadTask) {
        String str = "";
        switch (downloadTask.getStatus()) {
            case 0:
            case 4:
                str = Beta.strUpgradeDialogUpgradeBtn;
                downloadTask = this.x;
                break;
            case 1:
                str = Beta.strUpgradeDialogInstallBtn;
                downloadTask = this.x;
                break;
            case 2:
                str = String.format(Locale.getDefault(), "%.1f%%", new Object[]{Float.valueOf((((float) downloadTask.getSavedLength()) / ((float) downloadTask.getTotalLength())) * 100.0f)});
                downloadTask = this.y;
                break;
            case 3:
                str = Beta.strUpgradeDialogContinueBtn;
                downloadTask = this.x;
                break;
            case 5:
                str = Beta.strUpgradeDialogRetryBtn;
                downloadTask = this.x;
                break;
            default:
                downloadTask = null;
                break;
        }
        if (this.p.g != (byte) 2) {
            a(Beta.strUpgradeDialogCancelBtn, this.z, str, downloadTask);
        } else {
            a(null, null, str, downloadTask);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = 0;
        r1 = r7.b;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x01cd;
    L_0x0006:
        r1 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x01cd;
    L_0x000a:
        r1 = r7.q;	 Catch:{ Exception -> 0x01d1 }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        goto L_0x01cd;
    L_0x0010:
        r1 = r7.l;	 Catch:{ Exception -> 0x01d1 }
        r2 = 0;
        r3 = 1;
        if (r1 != 0) goto L_0x0099;
    L_0x0016:
        r1 = r7.k;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x0082;
    L_0x001a:
        r1 = r7.a;	 Catch:{ Exception -> 0x01d1 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r5 = r7.j;	 Catch:{ Exception -> 0x01d1 }
        r6 = "IMG_title";
        r5 = r5.a(r6);	 Catch:{ Exception -> 0x01d1 }
        r4[r0] = r5;	 Catch:{ Exception -> 0x01d1 }
        r1 = com.tencent.bugly.beta.global.a.a(r1, r0, r4);	 Catch:{ Exception -> 0x01d1 }
        r7.t = r1;	 Catch:{ Exception -> 0x01d1 }
        r7.u = r2;	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.t;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r2 = r7.t;	 Catch:{ Exception -> 0x01d1 }
        goto L_0x004f;
    L_0x0037:
        r1 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x01d1 }
        r1 = r1.h;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x004f;
    L_0x003d:
        r1 = r7.a;	 Catch:{ Exception -> 0x01d1 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x01d1 }
        r4 = r4.h;	 Catch:{ Exception -> 0x01d1 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x01d1 }
        r2[r0] = r4;	 Catch:{ Exception -> 0x01d1 }
        r2 = com.tencent.bugly.beta.global.a.a(r1, r3, r2);	 Catch:{ Exception -> 0x01d1 }
    L_0x004f:
        r1 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r1 = r1.getViewTreeObserver();	 Catch:{ Exception -> 0x01d1 }
        r4 = r7.B;	 Catch:{ Exception -> 0x01d1 }
        r1.removeOnPreDrawListener(r4);	 Catch:{ Exception -> 0x01d1 }
        r1 = new com.tencent.bugly.beta.ui.d;	 Catch:{ Exception -> 0x01d1 }
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01d1 }
        r4[r0] = r7;	 Catch:{ Exception -> 0x01d1 }
        r5 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r4[r3] = r5;	 Catch:{ Exception -> 0x01d1 }
        r5 = 2;
        r4[r5] = r2;	 Catch:{ Exception -> 0x01d1 }
        r2 = 3;
        r5 = r7.k;	 Catch:{ Exception -> 0x01d1 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x01d1 }
        r4[r2] = r5;	 Catch:{ Exception -> 0x01d1 }
        r1.<init>(r3, r4);	 Catch:{ Exception -> 0x01d1 }
        r7.B = r1;	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r1 = r1.getViewTreeObserver();	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.B;	 Catch:{ Exception -> 0x01d1 }
        r1.addOnPreDrawListener(r2);	 Catch:{ Exception -> 0x01d1 }
        goto L_0x00e9;
    L_0x0082:
        r1 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.a;	 Catch:{ Exception -> 0x01d1 }
        r4 = 1109917696; // 0x42280000 float:42.0 double:5.483722033E-315;
        r2 = com.tencent.bugly.beta.global.a.a(r2, r4);	 Catch:{ Exception -> 0x01d1 }
        r1.setHeight(r2);	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.a;	 Catch:{ Exception -> 0x01d1 }
        r1.setText(r2);	 Catch:{ Exception -> 0x01d1 }
        goto L_0x00e9;
    L_0x0099:
        r1 = r7.f;	 Catch:{ Exception -> 0x01d1 }
        r4 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r4 = r4.a;	 Catch:{ Exception -> 0x01d1 }
        r1.setText(r4);	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.e;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x00e9;
    L_0x00a6:
        r1 = r7.e;	 Catch:{ Exception -> 0x01d1 }
        r1.setAdjustViewBounds(r3);	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.k;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x00e9;
    L_0x00af:
        r1 = r7.a;	 Catch:{ Exception -> 0x01d1 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r5 = r7.j;	 Catch:{ Exception -> 0x01d1 }
        r6 = "IMG_title";
        r5 = r5.a(r6);	 Catch:{ Exception -> 0x01d1 }
        r4[r0] = r5;	 Catch:{ Exception -> 0x01d1 }
        r1 = com.tencent.bugly.beta.global.a.a(r1, r0, r4);	 Catch:{ Exception -> 0x01d1 }
        r7.t = r1;	 Catch:{ Exception -> 0x01d1 }
        r7.u = r2;	 Catch:{ Exception -> 0x01d1 }
        r1 = r7.t;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x00cc;
    L_0x00c9:
        r2 = r7.t;	 Catch:{ Exception -> 0x01d1 }
        goto L_0x00e4;
    L_0x00cc:
        r1 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x01d1 }
        r1 = r1.h;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x00e4;
    L_0x00d2:
        r1 = r7.a;	 Catch:{ Exception -> 0x01d1 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x01d1 }
        r4 = r4.h;	 Catch:{ Exception -> 0x01d1 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x01d1 }
        r2[r0] = r4;	 Catch:{ Exception -> 0x01d1 }
        r2 = com.tencent.bugly.beta.global.a.a(r1, r3, r2);	 Catch:{ Exception -> 0x01d1 }
    L_0x00e4:
        r1 = r7.e;	 Catch:{ Exception -> 0x01d1 }
        r1.setImageBitmap(r2);	 Catch:{ Exception -> 0x01d1 }
    L_0x00e9:
        r1 = r7.o;	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.b;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.length();	 Catch:{ Exception -> 0x01d1 }
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r2 <= r4) goto L_0x0100;
    L_0x00f7:
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.b;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.substring(r0, r4);	 Catch:{ Exception -> 0x01d1 }
        goto L_0x0104;
    L_0x0100:
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.b;	 Catch:{ Exception -> 0x01d1 }
    L_0x0104:
        r1.setText(r2);	 Catch:{ Exception -> 0x01d1 }
        r1 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x01d1 }
        r1 = r1.T;	 Catch:{ Exception -> 0x01d1 }
        if (r1 == 0) goto L_0x01c6;
    L_0x010d:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d1 }
        r1.<init>();	 Catch:{ Exception -> 0x01d1 }
        r2 = com.tencent.bugly.beta.Beta.strUpgradeDialogVersionLabel;	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = ": ";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.e;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.d;	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = "\n";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = com.tencent.bugly.beta.Beta.strUpgradeDialogFileSizeLabel;	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = ": ";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.f;	 Catch:{ Exception -> 0x01d1 }
        r4 = r2.d;	 Catch:{ Exception -> 0x01d1 }
        r2 = (float) r4;	 Catch:{ Exception -> 0x01d1 }
        r4 = 1233125376; // 0x49800000 float:1048576.0 double:6.092448853E-315;
        r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r5 < 0) goto L_0x015d;
    L_0x0141:
        r5 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x01d1 }
        r6 = "%.1f";
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r2 = r2 / r4;
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x01d1 }
        r3[r0] = r2;	 Catch:{ Exception -> 0x01d1 }
        r2 = java.lang.String.format(r5, r6, r3);	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = "M";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        goto L_0x0199;
    L_0x015d:
        r4 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r5 < 0) goto L_0x017f;
    L_0x0163:
        r5 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x01d1 }
        r6 = "%.1f";
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r2 = r2 / r4;
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x01d1 }
        r3[r0] = r2;	 Catch:{ Exception -> 0x01d1 }
        r2 = java.lang.String.format(r5, r6, r3);	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = "K";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        goto L_0x0199;
    L_0x017f:
        r4 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x01d1 }
        r5 = "%.1f";
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01d1 }
        r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x01d1 }
        r3[r0] = r2;	 Catch:{ Exception -> 0x01d1 }
        r2 = java.lang.String.format(r4, r5, r3);	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = "B";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
    L_0x0199:
        r2 = "\n";
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x01d1 }
        r3 = "yyyy-MM-dd HH:mm";
        r4 = java.util.Locale.CHINA;	 Catch:{ Exception -> 0x01d1 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x01d1 }
        r3 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpdateTimeLabel;	 Catch:{ Exception -> 0x01d1 }
        r1.append(r3);	 Catch:{ Exception -> 0x01d1 }
        r3 = ": ";
        r1.append(r3);	 Catch:{ Exception -> 0x01d1 }
        r3 = new java.util.Date;	 Catch:{ Exception -> 0x01d1 }
        r4 = r7.p;	 Catch:{ Exception -> 0x01d1 }
        r4 = r4.o;	 Catch:{ Exception -> 0x01d1 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x01d1 }
        r2 = r2.format(r3);	 Catch:{ Exception -> 0x01d1 }
        r1.append(r2);	 Catch:{ Exception -> 0x01d1 }
        r2 = r7.n;	 Catch:{ Exception -> 0x01d1 }
        r2.setText(r1);	 Catch:{ Exception -> 0x01d1 }
    L_0x01c6:
        r1 = r7.q;	 Catch:{ Exception -> 0x01d1 }
        r7.a(r1);	 Catch:{ Exception -> 0x01d1 }
        monitor-exit(r7);
        return;
    L_0x01cd:
        monitor-exit(r7);
        return;
    L_0x01cf:
        r0 = move-exception;
        goto L_0x01e8;
    L_0x01d1:
        r1 = move-exception;
        r2 = r7.l;	 Catch:{ all -> 0x01cf }
        if (r2 == 0) goto L_0x01dd;
    L_0x01d6:
        r2 = "please confirm your argument: [Beta.upgradeDialogLayoutId] is correct";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x01cf }
        com.tencent.bugly.proguard.an.e(r2, r0);	 Catch:{ all -> 0x01cf }
    L_0x01dd:
        r0 = com.tencent.bugly.proguard.an.b(r1);	 Catch:{ all -> 0x01cf }
        if (r0 != 0) goto L_0x01e6;
    L_0x01e3:
        r1.printStackTrace();	 Catch:{ all -> 0x01cf }
    L_0x01e6:
        monitor-exit(r7);
        return;
    L_0x01e8:
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.h.c():void");
    }

    public synchronized void a(y yVar, DownloadTask downloadTask) {
        this.p = yVar;
        this.q = downloadTask;
        this.q.addListener(this.A);
        com.tencent.bugly.beta.utils.e.a(new d(7, this));
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.p.g != 2) {
            if (this.s != 0) {
                this.s.run();
            }
            a();
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        if (!(this.A == null || this.q == null)) {
            this.q.removeListener(this.A);
        }
        if (this.w != null) {
            this.w.onPause(this.a, this.b, this.p != null ? new UpgradeInfo(this.p) : null);
        }
    }

    public void onResume() {
        super.onResume();
        if (!(this.A == null || this.q == null)) {
            this.q.addListener(this.A);
        }
        c();
        if (this.k != 0 && this.t == null) {
            f.a.a(new d(7, this));
        }
        if (this.w != null) {
            this.w.onResume(this.a, this.b, this.p != null ? new UpgradeInfo(this.p) : null);
        }
    }

    public void onStop() {
        super.onStop();
        if (this.w != null) {
            this.w.onStop(this.a, this.b, this.p != null ? new UpgradeInfo(this.p) : null);
        }
    }
}
