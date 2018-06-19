package com.xunlei.downloadprovider.search.ui.search;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.web.BrowserFrom;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiSearchAdapter */
public final class o extends com.xunlei.downloadprovider.c.a.a.a {
    public List<a> a;
    private Context b;
    private String c;
    private af d;

    /* compiled from: MultiSearchAdapter */
    private class a {
        TextView a;
        TextView b;
        final /* synthetic */ o c;

        private a(o oVar) {
            this.c = oVar;
        }
    }

    /* compiled from: MultiSearchAdapter */
    private class b {
        TextView a;
        TextView b;
        final /* synthetic */ o c;

        private b(o oVar) {
            this.c = oVar;
        }
    }

    /* compiled from: MultiSearchAdapter */
    private class c {
        TextView a;
        TextView b;
        TextView c;
        final /* synthetic */ o d;

        private c(o oVar) {
            this.d = oVar;
        }
    }

    /* compiled from: MultiSearchAdapter */
    private static class d {
        TextView a;
        TextView b;

        private d() {
        }
    }

    /* compiled from: MultiSearchAdapter */
    private static class e {
        TextView a;
        TextView b;
        TextView c;
        ImageView d;
        ImageView e;
        ImageView f;

        private e() {
        }
    }

    /* compiled from: MultiSearchAdapter */
    private static class f {
        TextView a;
        TextView b;
        TextView c;
        ImageView d;

        private f() {
        }
    }

    /* compiled from: MultiSearchAdapter */
    private static class g {
        TextView a;
        TextView b;
        TextView c;
        ImageView d;
        ImageView e;

        private g() {
        }
    }

    /* compiled from: MultiSearchAdapter */
    private static class h {
        public TextView a;
        public TextView b;

        private h() {
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 9;
    }

    public o(Context context) {
        this.b = context;
    }

    public o(Context context, af afVar) {
        this.b = context;
        this.d = afVar;
    }

    public final void a(List<a> list, String str) {
        if (this.a != null) {
            this.a.clear();
        } else {
            this.a = new ArrayList();
        }
        this.a.addAll(list);
        this.c = str;
    }

    public final int getCount() {
        return this.a != null ? this.a.size() : 0;
    }

    public final Object getItem(int i) {
        return this.a != null ? this.a.get(i) : 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
        r16 = this;
        r0 = r16;
        r2 = r19;
        r3 = r16.getItemViewType(r17);
        r4 = 2131888341; // 0x7f1208d5 float:1.9411315E38 double:1.05329279E-314;
        r5 = 2131886740; // 0x7f120294 float:1.9408067E38 double:1.053291999E-314;
        r6 = 1;
        r7 = 2131886807; // 0x7f1202d7 float:1.9408203E38 double:1.053292032E-314;
        r8 = 2131887522; // 0x7f1205a2 float:1.9409653E38 double:1.0532923854E-314;
        r9 = 2131886615; // 0x7f120217 float:1.9407814E38 double:1.0532919373E-314;
        r10 = 2130969205; // 0x7f040275 float:1.7547085E38 double:1.0528386765E-314;
        r11 = 2131888336; // 0x7f1208d0 float:1.9411304E38 double:1.0532927876E-314;
        r12 = 2131888352; // 0x7f1208e0 float:1.9411337E38 double:1.0532927955E-314;
        r13 = 8;
        r14 = 0;
        r15 = 0;
        switch(r3) {
            case 0: goto L_0x0440;
            case 1: goto L_0x03e2;
            case 2: goto L_0x037e;
            case 3: goto L_0x02f5;
            case 4: goto L_0x023a;
            case 5: goto L_0x015a;
            case 6: goto L_0x00c5;
            case 7: goto L_0x007c;
            case 8: goto L_0x002c;
            default: goto L_0x0028;
        };
    L_0x0028:
        r14 = r18;
        goto L_0x04dd;
    L_0x002c:
        r3 = r16.getItem(r17);
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.n;
        if (r3 != 0) goto L_0x0035;
    L_0x0034:
        return r14;
    L_0x0035:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.n) r3;
        if (r18 != 0) goto L_0x0060;
    L_0x003d:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r1 = r1.inflate(r10, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$d;
        r2.<init>();
        r4 = r1.findViewById(r9);
        r4 = (android.widget.TextView) r4;
        r2.a = r4;
        r4 = r1.findViewById(r12);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r1.setTag(r2);
        goto L_0x0068;
    L_0x0060:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.d) r2;
        r1 = r18;
    L_0x0068:
        r4 = r1.findViewById(r12);
        r5 = new com.xunlei.downloadprovider.search.ui.search.p;
        r5.<init>(r0, r3);
        r4.setOnClickListener(r5);
        r2 = r2.a;
        r3 = r3.a;
        r2.setText(r3);
        return r1;
    L_0x007c:
        r3 = r16.getItem(r17);
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.f;
        if (r3 != 0) goto L_0x0085;
    L_0x0084:
        return r14;
    L_0x0085:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.f) r3;
        if (r18 != 0) goto L_0x00b0;
    L_0x008d:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r1 = r1.inflate(r10, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$d;
        r2.<init>();
        r4 = r1.findViewById(r9);
        r4 = (android.widget.TextView) r4;
        r2.a = r4;
        r4 = r1.findViewById(r12);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r1.setTag(r2);
        goto L_0x00b8;
    L_0x00b0:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.d) r2;
        r1 = r18;
    L_0x00b8:
        r4 = r2.b;
        r4.setVisibility(r13);
        r2 = r2.a;
        r3 = r3.a;
        r2.setText(r3);
        return r1;
    L_0x00c5:
        r3 = r16.getItem(r17);
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.aj;
        if (r3 != 0) goto L_0x00cf;
    L_0x00cd:
        goto L_0x04dd;
    L_0x00cf:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.aj) r3;
        if (r18 != 0) goto L_0x0116;
    L_0x00d7:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r4 = 2130969207; // 0x7f040277 float:1.754709E38 double:1.0528386775E-314;
        r1 = r1.inflate(r4, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$f;
        r2.<init>();
        r4 = 2131888355; // 0x7f1208e3 float:1.9411343E38 double:1.053292797E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.a = r4;
        r4 = 2131886560; // 0x7f1201e0 float:1.9407702E38 double:1.05329191E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r4 = r1.findViewById(r8);
        r4 = (android.widget.TextView) r4;
        r2.c = r4;
        r4 = 2131886815; // 0x7f1202df float:1.940822E38 double:1.053292036E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.d = r4;
        r1.setTag(r2);
        goto L_0x011e;
    L_0x0116:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.f) r2;
        r1 = r18;
    L_0x011e:
        r4 = new com.xunlei.downloadprovider.search.ui.search.w;
        r4.<init>(r0, r3);
        r1.setOnClickListener(r4);
        if (r3 == 0) goto L_0x0157;
    L_0x0128:
        r4 = r3.a;
        if (r4 == 0) goto L_0x0133;
    L_0x012c:
        r4 = r2.a;
        r5 = r3.a;
        r4.setText(r5);
    L_0x0133:
        r4 = r2.c;
        r5 = r3.d;
        r4.setText(r5);
        r4 = r2.b;
        r5 = java.util.concurrent.TimeUnit.SECONDS;
        r6 = r3.e;
        r6 = (long) r6;
        r5 = r5.toMillis(r6);
        r5 = com.xunlei.xllib.b.j.a(r5);
        r4.setText(r5);
        r4 = com.xunlei.downloadprovider.homepage.choiceness.b.a();
        r3 = r3.b;
        r2 = r2.d;
        r4.a(r3, r2, r14);
    L_0x0157:
        r14 = r1;
        goto L_0x04dd;
    L_0x015a:
        r3 = r16.getItem(r17);
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ai;
        if (r3 != 0) goto L_0x0164;
    L_0x0162:
        goto L_0x04dd;
    L_0x0164:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ai) r3;
        if (r18 != 0) goto L_0x01be;
    L_0x016c:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r4 = 2130969206; // 0x7f040276 float:1.7547087E38 double:1.052838677E-314;
        r1 = r1.inflate(r4, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$e;
        r2.<init>();
        r4 = r1.findViewById(r7);
        r4 = (android.widget.TextView) r4;
        r2.a = r4;
        r4 = r1.findViewById(r8);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r4 = 2131887378; // 0x7f120512 float:1.9409361E38 double:1.0532923143E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.c = r4;
        r4 = 2131886995; // 0x7f120393 float:1.9408585E38 double:1.053292125E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.d = r4;
        r4 = 2131888353; // 0x7f1208e1 float:1.9411339E38 double:1.053292796E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.e = r4;
        r4 = 2131888354; // 0x7f1208e2 float:1.941134E38 double:1.0532927965E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.f = r4;
        r1.setTag(r2);
        goto L_0x01c6;
    L_0x01be:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.e) r2;
        r1 = r18;
    L_0x01c6:
        r4 = new com.xunlei.downloadprovider.search.ui.search.x;
        r4.<init>(r0, r3);
        r1.setOnClickListener(r4);
        if (r3 == 0) goto L_0x0157;
    L_0x01d0:
        r4 = r3.a;
        if (r4 == 0) goto L_0x0157;
    L_0x01d4:
        r4 = r3.b;
        if (r4 == 0) goto L_0x01df;
    L_0x01d8:
        r4 = r2.a;
        r5 = r3.b;
        r4.setText(r5);
    L_0x01df:
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        r4 = r3.f;
        r5 = r2.d;
        com.xunlei.downloadprovider.homepage.choiceness.b.a(r4, r5);
        r4 = r2.b;
        r5 = r3.d;
        r4.setText(r5);
        r4 = r2.c;
        r5 = r3.e;
        r4.setText(r5);
        r4 = r2.f;
        r5 = r3.c;
        if (r5 == 0) goto L_0x01fe;
    L_0x01fd:
        r13 = r15;
    L_0x01fe:
        r4.setVisibility(r13);
        r4 = r3.b();
        if (r4 != 0) goto L_0x020f;
    L_0x0207:
        r2 = r2.e;
        r3 = 4;
        r2.setVisibility(r3);
        goto L_0x0157;
    L_0x020f:
        r4 = r3.b();
        if (r4 != r6) goto L_0x0224;
    L_0x0215:
        r3 = r2.e;
        r3.setVisibility(r15);
        r2 = r2.e;
        r3 = 2130839582; // 0x7f02081e float:1.7284179E38 double:1.0527746343E-314;
        r2.setImageResource(r3);
        goto L_0x0157;
    L_0x0224:
        r3 = r3.b();
        r4 = 2;
        if (r3 != r4) goto L_0x0157;
    L_0x022b:
        r3 = r2.e;
        r3.setVisibility(r15);
        r2 = r2.e;
        r3 = 2130839579; // 0x7f02081b float:1.7284173E38 double:1.052774633E-314;
        r2.setImageResource(r3);
        goto L_0x0157;
    L_0x023a:
        r3 = r16.getItem(r17);
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ak;
        if (r3 != 0) goto L_0x0244;
    L_0x0242:
        goto L_0x04dd;
    L_0x0244:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ak) r3;
        if (r18 != 0) goto L_0x0296;
    L_0x024c:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r4 = 2130969208; // 0x7f040278 float:1.7547091E38 double:1.052838678E-314;
        r1 = r1.inflate(r4, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$g;
        r2.<init>();
        r4 = r1.findViewById(r7);
        r4 = (android.widget.TextView) r4;
        r2.a = r4;
        r4 = 2131887186; // 0x7f120452 float:1.9408972E38 double:1.0532922194E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r4 = 2131887188; // 0x7f120454 float:1.9408976E38 double:1.0532922204E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.c = r4;
        r4 = 2131888356; // 0x7f1208e4 float:1.9411345E38 double:1.0532927975E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.d = r4;
        r4 = 2131887184; // 0x7f120450 float:1.9408968E38 double:1.0532922184E-314;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r2.e = r4;
        r1.setTag(r2);
        goto L_0x029e;
    L_0x0296:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.g) r2;
        r1 = r18;
    L_0x029e:
        r4 = 2131887230; // 0x7f12047e float:1.9409061E38 double:1.053292241E-314;
        r4 = r1.findViewById(r4);
        r5 = new com.xunlei.downloadprovider.search.ui.search.t;
        r5.<init>(r0, r3);
        r4.setOnClickListener(r5);
        r4 = r2.d;
        r5 = new com.xunlei.downloadprovider.search.ui.search.u;
        r5.<init>(r0, r3);
        r4.setOnClickListener(r5);
        r4 = r2.a;
        r5 = new com.xunlei.downloadprovider.search.ui.search.v;
        r5.<init>(r0, r3);
        r4.setOnClickListener(r5);
        r4 = r2.a;
        r5 = r3.b;
        r4.setText(r5);
        r4 = r2.b;
        r5 = r3.f;
        r4.setText(r5);
        r4 = r2.c;
        r5 = r3.e;
        r4.setText(r5);
        r4 = r3.d;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x02e9;
    L_0x02de:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.b.a();
        r5 = r3.d;
        r6 = r2.e;
        r4.a(r5, r6, r14);
    L_0x02e9:
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        r3 = r3.c;
        r2 = r2.d;
        com.xunlei.downloadprovider.homepage.choiceness.b.a(r3, r2);
        goto L_0x0157;
    L_0x02f5:
        if (r18 != 0) goto L_0x0320;
    L_0x02f7:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r3 = 2130968688; // 0x7f040070 float:1.7546037E38 double:1.052838421E-314;
        r1 = r1.inflate(r3, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$h;
        r2.<init>();
        r3 = 2131886739; // 0x7f120293 float:1.9408065E38 double:1.0532919986E-314;
        r3 = r1.findViewById(r3);
        r3 = (android.widget.TextView) r3;
        r2.a = r3;
        r3 = r1.findViewById(r5);
        r3 = (android.widget.TextView) r3;
        r2.b = r3;
        r1.setTag(r2);
        goto L_0x0328;
    L_0x0320:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.h) r2;
        r1 = r18;
    L_0x0328:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.a) r3;
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ah;
        if (r3 != 0) goto L_0x0334;
    L_0x0332:
        goto L_0x04dd;
    L_0x0334:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ah) r3;
        r3 = r3.a;
        r4 = r2.a;
        r5 = r3.b;
        r0.a(r4, r5);
        r4 = r3.m;
        r5 = r2.a;
        r6 = 1132593152; // 0x43820000 float:260.0 double:5.59575367E-315;
        r6 = com.xunlei.common.androidutil.DipPixelUtil.dip2px(r6);
        r5.setMaxWidth(r6);
        r5 = r2.b;
        r6 = android.text.TextUtils.isEmpty(r4);
        if (r6 == 0) goto L_0x0359;
    L_0x0358:
        goto L_0x035a;
    L_0x0359:
        r13 = r15;
    L_0x035a:
        r5.setVisibility(r13);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x0369;
    L_0x0363:
        r2 = r2.b;
        r2.setText(r4);
        goto L_0x0374;
    L_0x0369:
        r2 = r2.a;
        r4 = 1325400064; // 0x4f000000 float:2.14748365E9 double:6.548346386E-315;
        r4 = com.xunlei.common.androidutil.DipPixelUtil.dip2px(r4);
        r2.setMaxWidth(r4);
    L_0x0374:
        r2 = new com.xunlei.downloadprovider.search.ui.search.r;
        r2.<init>(r0, r3);
        r1.setOnClickListener(r2);
        goto L_0x0157;
    L_0x037e:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.a) r3;
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ah;
        if (r3 != 0) goto L_0x038a;
    L_0x0388:
        goto L_0x04dd;
    L_0x038a:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ah) r3;
        r3 = r3.a;
        if (r18 != 0) goto L_0x03ba;
    L_0x0394:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r5 = 2130969194; // 0x7f04026a float:1.7547063E38 double:1.052838671E-314;
        r1 = r1.inflate(r5, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$a;
        r2.<init>();
        r5 = r1.findViewById(r11);
        r5 = (android.widget.TextView) r5;
        r2.a = r5;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r1.setTag(r2);
        goto L_0x03c2;
    L_0x03ba:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.a) r2;
        r1 = r18;
    L_0x03c2:
        r4 = new com.xunlei.downloadprovider.search.ui.search.y;
        r4.<init>(r0, r3);
        r1.setOnClickListener(r4);
        r4 = r2.a;
        r5 = r3.p;
        r5 = r5.b();
        r0.a(r4, r5);
        r2 = r2.b;
        r3 = r3.p;
        r3 = r3.a();
        r0.a(r2, r3);
        goto L_0x0157;
    L_0x03e2:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.a) r3;
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ah;
        if (r3 != 0) goto L_0x03ee;
    L_0x03ec:
        goto L_0x04dd;
    L_0x03ee:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ah) r3;
        r3 = r3.a;
        r3 = r3.o;
        if (r18 != 0) goto L_0x0420;
    L_0x03fa:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r5 = 2130969197; // 0x7f04026d float:1.754707E38 double:1.0528386726E-314;
        r1 = r1.inflate(r5, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$b;
        r2.<init>();
        r5 = r1.findViewById(r11);
        r5 = (android.widget.TextView) r5;
        r2.a = r5;
        r4 = r1.findViewById(r4);
        r4 = (android.widget.TextView) r4;
        r2.b = r4;
        r1.setTag(r2);
        goto L_0x0428;
    L_0x0420:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.b) r2;
        r1 = r18;
    L_0x0428:
        r4 = r2.a;
        r5 = r3.a;
        r0.a(r4, r5);
        r2 = r2.b;
        r4 = r3.b;
        r0.a(r2, r4);
        r2 = new com.xunlei.downloadprovider.search.ui.search.z;
        r2.<init>(r0, r3);
        r1.setOnClickListener(r2);
        goto L_0x0157;
    L_0x0440:
        if (r18 != 0) goto L_0x0473;
    L_0x0442:
        r1 = r0.b;
        r1 = android.view.LayoutInflater.from(r1);
        r3 = 2130969191; // 0x7f040267 float:1.7547057E38 double:1.0528386696E-314;
        r1 = r1.inflate(r3, r2, r15);
        r2 = new com.xunlei.downloadprovider.search.ui.search.o$c;
        r2.<init>();
        r3 = r1.findViewById(r11);
        r3 = (android.widget.TextView) r3;
        r2.a = r3;
        r3 = r1.findViewById(r5);
        r3 = (android.widget.TextView) r3;
        r2.b = r3;
        r3 = 2131888337; // 0x7f1208d1 float:1.9411306E38 double:1.053292788E-314;
        r3 = r1.findViewById(r3);
        r3 = (android.widget.TextView) r3;
        r2.c = r3;
        r1.setTag(r2);
        goto L_0x047b;
    L_0x0473:
        r2 = r18.getTag();
        r2 = (com.xunlei.downloadprovider.search.ui.search.o.c) r2;
        r1 = r18;
    L_0x047b:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.a) r3;
        r3 = r3 instanceof com.xunlei.downloadprovider.search.ui.search.ah;
        if (r3 != 0) goto L_0x0486;
    L_0x0485:
        goto L_0x04dd;
    L_0x0486:
        r3 = r16.getItem(r17);
        r3 = (com.xunlei.downloadprovider.search.ui.search.ah) r3;
        r3 = r3.a;
        r3 = r3.o;
        r4 = new com.xunlei.downloadprovider.search.ui.search.aa;
        r4.<init>(r0, r3);
        r1.setOnClickListener(r4);
        r4 = r3.a;
        if (r4 == 0) goto L_0x04bb;
    L_0x049c:
        r4 = r3.a;
        r5 = "";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x04a7;
    L_0x04a6:
        goto L_0x04bb;
    L_0x04a7:
        r4 = r2.a;
        r5 = r3.a;
        r0.a(r4, r5);
        r4 = r2.b;
        r5 = r3.c;
        r4.setText(r5);
        r4 = r2.b;
        r4.setVisibility(r15);
        goto L_0x04c7;
    L_0x04bb:
        r4 = r2.a;
        r5 = r3.c;
        r0.a(r4, r5);
        r4 = r2.b;
        r4.setVisibility(r13);
    L_0x04c7:
        r3 = r3.e;
        if (r3 != r6) goto L_0x04d4;
    L_0x04cb:
        r2 = r2.c;
        r3 = "应用内搜索";
        r2.setText(r3);
        goto L_0x0157;
    L_0x04d4:
        r2 = r2.c;
        r3 = "全网搜索";
        r2.setText(r3);
        goto L_0x0157;
    L_0x04dd:
        if (r14 != 0) goto L_0x04e6;
    L_0x04df:
        r14 = new android.view.View;
        r1 = r0.b;
        r14.<init>(r1);
    L_0x04e6:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.search.ui.search.o.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final int getItemViewType(int i) {
        a aVar = (a) getItem(i);
        if (aVar != null) {
            return aVar.a();
        }
        return super.getItemViewType(i);
    }

    private void a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else if (TextUtils.isEmpty(this.c)) {
            textView.setText(str);
        } else {
            int indexOf = str.toLowerCase().indexOf(this.c.toLowerCase());
            if (indexOf < 0) {
                textView.setText(str);
                return;
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1aa3ff")), indexOf, this.c.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    static /* synthetic */ void a(o oVar, String str, String str2, BrowserFrom browserFrom) {
        XLThreadPool.execute(new q(oVar, str, str2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(oVar.b, 22, str.trim(), false, browserFrom);
    }
}
