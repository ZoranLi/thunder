package com.xunlei.downloadprovider.discovery;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.d.i.a;
import com.xunlei.downloadprovider.discovery.a.a$a;
import com.xunlei.downloadprovider.discovery.b.b;
import com.xunlei.downloadprovider.discovery.kuainiao.d;
import com.xunlei.downloadprovider.discovery.widgets.DiscoveryLocalServiceView;
import com.xunlei.downloadprovider.discovery.widgets.DiscoveryTabItemView;
import com.xunlei.downloadprovider.frame.BaseCacheViewFragment;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.search.ui.widget.HomeTitleBar;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DiscoveryFragment extends BaseCacheViewFragment implements a, d.a {
    private static final String c = "DiscoveryFragment";
    Handler a = new Handler();
    Runnable b;
    private HomeTitleBar d;
    private ScrollView e;
    private LinearLayout f;
    private ErrorBlankView g;
    private UnifiedLoadingView h;
    private DiscoveryTabItemView i;
    private ArrayList<o> j;
    private ArrayList<View> k = new ArrayList();
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private String s;
    private OnClickListener t = new a(this);
    private com.xunlei.downloadprovider.member.login.b.d u = new e(this);
    private final g v = new g(this);
    private final h w = new i(this);

    public DiscoveryFragment() {
        LoginHelper.a().a(this.u);
        LoginHelper.a().a(this.v);
        LoginHelper.a().a(this.w);
        i.a().a(this);
    }

    private void a(boolean z) {
        if (!com.xunlei.xllib.b.d.a(this.k)) {
            if (this.i != null) {
                if (z) {
                    b.a(true);
                    this.i.setVisibility(0);
                    c();
                    return;
                }
                b.a(false);
                if (this.r > true) {
                    if (!this.i.b.getVisibility()) {
                        z = this.i;
                        z.setVisibility(0);
                        z.b.setVisibility(0);
                        z.a.setVisibility(8);
                        z.c.setVisibility(8);
                        z.j.setVisibility(8);
                        if (com.xunlei.xllib.b.d.a(this.j)) {
                            a(true, false);
                        }
                    }
                }
                this.i.setVisibility(8);
                if (com.xunlei.xllib.b.d.a(this.j)) {
                    a(true, false);
                }
            }
        }
    }

    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        bundle = null;
        layoutInflater = layoutInflater.inflate(R.layout.discovery_tab_view, viewGroup, false);
        this.d = (HomeTitleBar) layoutInflater.findViewById(R.id.search_title_bar);
        this.d.setSearchDownloadEntranceState(false);
        this.d.setOnTitleClickListener(new c(this));
        this.e = (ScrollView) layoutInflater.findViewById(R.id.sv_layout);
        this.f = (LinearLayout) layoutInflater.findViewById(R.id.discovery_tab_item_list_view);
        viewGroup = com.xunlei.downloadprovider.discovery.a.a.a(getActivity()).b();
        if (viewGroup != null && viewGroup.size() >= 6) {
            viewGroup = com.xunlei.downloadprovider.discovery.a.a.a(getActivity());
            ViewGroup viewGroup2 = this.f;
            if (com.xunlei.downloadprovider.d.d.a().c.b() && viewGroup2 != null) {
                List b = viewGroup.b();
                if (b != null && b.size() >= 6) {
                    ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(BrothersApplication.getApplicationInstance()).inflate(R.layout.discovery_hot_topic_container, viewGroup2, false);
                    if (viewGroup3 != null) {
                        ViewGroup viewGroup4 = (ViewGroup) viewGroup3.findViewById(R.id.dis_top_con1);
                        if (viewGroup4.getChildCount() == 3) {
                            if (viewGroup.a(viewGroup4.getChildAt(0), 0) && viewGroup.a(viewGroup4.getChildAt(1), 1)) {
                                if (!viewGroup.a(viewGroup4.getChildAt(2), 2)) {
                                }
                            }
                        }
                        viewGroup4 = (ViewGroup) viewGroup3.findViewById(R.id.dis_top_con2);
                        if (viewGroup4.getChildCount() == 3) {
                            if (viewGroup.a(viewGroup4.getChildAt(0), 3) && viewGroup.a(viewGroup4.getChildAt(1), 4)) {
                                if (viewGroup.a(viewGroup4.getChildAt(2), 5) == null) {
                                }
                            }
                        }
                        viewGroup2.addView(viewGroup3);
                        bundle = 1;
                    }
                }
            }
            this.p = bundle;
        }
        this.g = (ErrorBlankView) layoutInflater.findViewById(R.id.empty_layout);
        this.g.a("刷新", this.t);
        this.h = (UnifiedLoadingView) layoutInflater.findViewById(R.id.ul_loading_view);
        this.b = new d(this);
        layoutInflater.findViewById(R.id.status_bar_fix).setLayoutParams(new LayoutParams(-1, j.a(getActivity())));
        b(true);
        return layoutInflater;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginHelper.a().b();
        d.a().a((d.a) this);
    }

    public void onResume() {
        super.onResume();
        int i = 0;
        if (isAdded()) {
            i.a().a(System.currentTimeMillis(), "find");
            ((MainTabActivity) this.mActivity).b(false);
        }
        if (this.h != null && this.h.getVisibility() == 0) {
            this.h.show();
        }
        a();
        if (this.p) {
            com.xunlei.downloadprovider.discovery.a.a a = com.xunlei.downloadprovider.discovery.a.a.a(getActivity());
            if (!com.xunlei.xllib.b.d.a(a.a)) {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < a.a.size()) {
                    a$a com_xunlei_downloadprovider_discovery_a_a_a = (a$a) a.a.get(i);
                    if (!(com_xunlei_downloadprovider_discovery_a_a_a == null || com_xunlei_downloadprovider_discovery_a_a_a.b == null)) {
                        stringBuilder.append(URLEncoder.encode(com_xunlei_downloadprovider_discovery_a_a_a.b));
                        if (i < a.a.size() - 1) {
                            stringBuilder.append("|");
                        }
                    }
                    i++;
                }
                Map hashMap = new HashMap();
                hashMap.put("tag", stringBuilder.toString());
                com.xunlei.downloadprovider.ad.home.a.a("android_find", "find_tag_show", hashMap);
            }
        }
        this.a.postDelayed(this.b, 300);
    }

    public void onPause() {
        super.onPause();
        this.o = false;
        this.a.removeCallbacks(this.b);
    }

    public void onDestroy() {
        d.a().b((d.a) this);
        i.a().b(this);
        if (this.u != null) {
            LoginHelper.a().b(this.u);
        }
        if (this.v != null) {
            LoginHelper.a().b(this.v);
        }
        if (this.w != null) {
            LoginHelper.a().b(this.w);
        }
        com.xunlei.downloadprovider.discovery.a.a.a(getActivity());
        com.xunlei.downloadprovider.discovery.a.a.a();
        super.onDestroy();
    }

    private void a() {
        if (!com.xunlei.xllib.b.d.a(this.j)) {
            if (!this.o) {
                Object obj = this.j;
                HashMap hashMap = new HashMap();
                if (!com.xunlei.xllib.b.d.a(obj)) {
                    Iterator it = obj.iterator();
                    while (it.hasNext()) {
                        CharSequence charSequence;
                        String str = ((o) it.next()).a;
                        if (str.equals("nearby")) {
                            charSequence = "nearby";
                        } else if (str.equals("caomei_live")) {
                            charSequence = "caomei_live";
                        } else if (str.equals("activity_center")) {
                            charSequence = "activity";
                        } else if (str.equals("game_center")) {
                            charSequence = "game_center";
                        } else if (str.equals("snatch")) {
                            charSequence = "yiyuan";
                        } else if (str.equals("finance")) {
                            charSequence = "finance";
                        } else if (str.equals("beauty")) {
                            charSequence = "beauty";
                        } else if (str.equals("mo_jin")) {
                            charSequence = "caijing";
                        } else if (str.equals("kuainiao")) {
                            charSequence = "kuainiao";
                            hashMap.put("kuainiao_status", d.a().a ? "1" : "0");
                        } else {
                            charSequence = str.equals("remote_download") ? "remote" : str.equals("local_service") ? "tongcheng" : str.equals("e_commerce") ? "business" : str.equals("red_packet") ? "hongbao" : str;
                        }
                        CharSequence a = b.a(str);
                        if (!(TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(a))) {
                            hashMap.put(charSequence, a);
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        com.xunlei.downloadprovider.discovery.b.a.a(hashMap);
                    }
                }
                this.o = true;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(boolean r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.getActivity();	 Catch:{ all -> 0x00f4 }
        if (r0 == 0) goto L_0x00f2;
    L_0x0007:
        r1 = r0.isFinishing();	 Catch:{ all -> 0x00f4 }
        if (r1 != 0) goto L_0x00f2;
    L_0x000d:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00f4 }
        r2 = 17;
        if (r1 < r2) goto L_0x001b;
    L_0x0013:
        r0 = r0.isDestroyed();	 Catch:{ all -> 0x00f4 }
        if (r0 == 0) goto L_0x001b;
    L_0x0019:
        goto L_0x00f2;
    L_0x001b:
        r0 = r8.j;	 Catch:{ all -> 0x00f4 }
        r0 = com.xunlei.xllib.b.d.a(r0);	 Catch:{ all -> 0x00f4 }
        if (r0 != 0) goto L_0x0028;
    L_0x0023:
        r0 = r8.j;	 Catch:{ all -> 0x00f4 }
        r0.clear();	 Catch:{ all -> 0x00f4 }
    L_0x0028:
        r0 = com.xunlei.downloadprovider.d.i.a();	 Catch:{ all -> 0x00f4 }
        r0 = r0.b();	 Catch:{ all -> 0x00f4 }
        if (r0 == 0) goto L_0x0086;
    L_0x0032:
        r0 = com.xunlei.downloadprovider.d.i.a();	 Catch:{ all -> 0x00f4 }
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00f4 }
        r1.<init>();	 Catch:{ all -> 0x00f4 }
        r2 = r0.a;	 Catch:{ all -> 0x00f4 }
        r2 = r2.iterator();	 Catch:{ all -> 0x00f4 }
        r3 = 0;
        r4 = r3;
    L_0x0043:
        r5 = r2.hasNext();	 Catch:{ all -> 0x00f4 }
        if (r5 == 0) goto L_0x0072;
    L_0x0049:
        r5 = r2.next();	 Catch:{ all -> 0x00f4 }
        r5 = (com.xunlei.downloadprovider.d.b.o) r5;	 Catch:{ all -> 0x00f4 }
        if (r5 == 0) goto L_0x0043;
    L_0x0051:
        r6 = r5.s;	 Catch:{ all -> 0x00f4 }
        r7 = 2;
        if (r6 != r7) goto L_0x0043;
    L_0x0056:
        r6 = r5.a;	 Catch:{ all -> 0x00f4 }
        r7 = "local_service";
        r6 = r6.equals(r7);	 Catch:{ all -> 0x00f4 }
        if (r6 == 0) goto L_0x0062;
    L_0x0060:
        r3 = r5;
        goto L_0x0043;
    L_0x0062:
        r6 = r5.a;	 Catch:{ all -> 0x00f4 }
        r7 = "e_commerce";
        r6 = r6.equals(r7);	 Catch:{ all -> 0x00f4 }
        if (r6 == 0) goto L_0x006e;
    L_0x006c:
        r4 = r5;
        goto L_0x0043;
    L_0x006e:
        r1.add(r5);	 Catch:{ all -> 0x00f4 }
        goto L_0x0043;
    L_0x0072:
        r2 = new com.xunlei.downloadprovider.d.k;	 Catch:{ all -> 0x00f4 }
        r2.<init>(r0);	 Catch:{ all -> 0x00f4 }
        java.util.Collections.sort(r1, r2);	 Catch:{ all -> 0x00f4 }
        if (r3 == 0) goto L_0x007f;
    L_0x007c:
        r1.add(r3);	 Catch:{ all -> 0x00f4 }
    L_0x007f:
        if (r4 == 0) goto L_0x0084;
    L_0x0081:
        r1.add(r4);	 Catch:{ all -> 0x00f4 }
    L_0x0084:
        r8.j = r1;	 Catch:{ all -> 0x00f4 }
    L_0x0086:
        r0 = r8.j;	 Catch:{ all -> 0x00f4 }
        r0 = com.xunlei.xllib.b.d.a(r0);	 Catch:{ all -> 0x00f4 }
        r1 = 1;
        if (r0 == 0) goto L_0x0094;
    L_0x008f:
        r8.a(r1, r9);	 Catch:{ all -> 0x00f4 }
        monitor-exit(r8);
        return;
    L_0x0094:
        r0 = 0;
        r8.a(r0, r9);	 Catch:{ all -> 0x00f4 }
        r2 = r8.h;	 Catch:{ all -> 0x00f4 }
        if (r2 == 0) goto L_0x00a1;
    L_0x009c:
        r2 = r8.h;	 Catch:{ all -> 0x00f4 }
        r2.hide();	 Catch:{ all -> 0x00f4 }
    L_0x00a1:
        r8.b();	 Catch:{ all -> 0x00f4 }
        r2 = r8.m;	 Catch:{ all -> 0x00f4 }
        if (r2 != 0) goto L_0x00ad;
    L_0x00a8:
        r8.a(r1, r9);	 Catch:{ all -> 0x00f4 }
        monitor-exit(r8);
        return;
    L_0x00ad:
        r9 = r8.n;	 Catch:{ all -> 0x00f4 }
        if (r9 != 0) goto L_0x00b5;
    L_0x00b1:
        r8.a(r0);	 Catch:{ all -> 0x00f4 }
        goto L_0x00c5;
    L_0x00b5:
        r9 = com.xunlei.downloadprovider.discovery.b.b.a();	 Catch:{ all -> 0x00f4 }
        if (r9 == 0) goto L_0x00bf;
    L_0x00bb:
        r8.a(r1);	 Catch:{ all -> 0x00f4 }
        goto L_0x00c5;
    L_0x00bf:
        com.xunlei.downloadprovider.discovery.kuainiao.d.a();	 Catch:{ all -> 0x00f4 }
        com.xunlei.downloadprovider.discovery.kuainiao.d.e();	 Catch:{ all -> 0x00f4 }
    L_0x00c5:
        r9 = r8.f;	 Catch:{ all -> 0x00f4 }
        if (r9 != 0) goto L_0x00d3;
    L_0x00c9:
        r9 = r8.k;	 Catch:{ all -> 0x00f4 }
        r9 = com.xunlei.xllib.b.d.a(r9);	 Catch:{ all -> 0x00f4 }
        if (r9 == 0) goto L_0x00d3;
    L_0x00d1:
        monitor-exit(r8);
        return;
    L_0x00d3:
        r9 = r8.k;	 Catch:{ all -> 0x00f4 }
        r9 = r9.size();	 Catch:{ all -> 0x00f4 }
        if (r0 >= r9) goto L_0x00ed;
    L_0x00db:
        r9 = r8.k;	 Catch:{ all -> 0x00f4 }
        r9 = r9.get(r0);	 Catch:{ all -> 0x00f4 }
        r9 = (android.view.View) r9;	 Catch:{ all -> 0x00f4 }
        if (r9 == 0) goto L_0x00ea;
    L_0x00e5:
        r1 = r8.f;	 Catch:{ all -> 0x00f4 }
        r1.addView(r9);	 Catch:{ all -> 0x00f4 }
    L_0x00ea:
        r0 = r0 + 1;
        goto L_0x00d3;
    L_0x00ed:
        r8.a();	 Catch:{ all -> 0x00f4 }
        monitor-exit(r8);
        return;
    L_0x00f2:
        monitor-exit(r8);
        return;
    L_0x00f4:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.discovery.DiscoveryFragment.b(boolean):void");
    }

    private void a(boolean z, boolean z2) {
        if (!this.p || !z) {
            int i = 0;
            if (this.e != null) {
                this.e.setVisibility(z ? 8 : 0);
            }
            if (this.h != null) {
                this.h.setVisibility(8);
            }
            if (this.g != null) {
                ErrorBlankView errorBlankView = this.g;
                if (!z) {
                    i = 8;
                }
                errorBlankView.setVisibility(i);
                if (z && !com.xunlei.xllib.android.b.a(getActivity())) {
                    this.g.setErrorType(true);
                } else if (z && z2) {
                    this.g.setErrorType(-1);
                    this.g.a(getResouceDrawable(R.drawable.commonui_bg_page_empty), getResouceString(R.string.commonui_page_empty), null);
                } else if (z) {
                    this.g.setErrorType(-1);
                    this.g.a(getResouceDrawable(R.drawable.commonui_bg_page_empty), getResouceString(R.string.commonui_page_empty), null);
                }
            }
        }
    }

    private void b() {
        if (!com.xunlei.xllib.b.d.a(this.k)) {
            this.k.clear();
        }
        int size = this.j.size();
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            o oVar = (o) this.j.get(i3);
            String str = oVar.a;
            int d = com.xunlei.downloadprovider.d.d.a().c.d(oVar.a);
            if (d != 0 && (oVar == null || oVar.u != 1 || TextUtils.isEmpty(oVar.e) || TextUtils.isEmpty(oVar.q))) {
                d = 0;
            }
            this.m |= d;
            if (d != 0) {
                int i4;
                boolean z;
                DiscoveryTabItemView discoveryTabItemView = new DiscoveryTabItemView(getActivity());
                if (i2 != oVar.A) {
                    i4 = oVar.A;
                    z = true;
                } else {
                    i4 = i2;
                    z = false;
                }
                DiscoveryTabItemView discoveryTabItemView2 = discoveryTabItemView;
                boolean z2 = i3 == 0;
                discoveryTabItemView2.m = oVar;
                discoveryTabItemView2.l = str;
                int i5 = 8;
                discoveryTabItemView2.b.setVisibility(z ? 0 : 8);
                discoveryTabItemView2.c.setVisibility(z2 ? 0 : 8);
                discoveryTabItemView2.a(oVar.b, discoveryTabItemView2.d);
                if ("e_commerce".equals(oVar.a)) {
                    z = (TextUtils.isEmpty(oVar.C) || TextUtils.isEmpty(oVar.D)) ? false : true;
                    discoveryTabItemView2.j.setVisibility(z ? 0 : 8);
                    if (z) {
                        discoveryTabItemView2.n = true;
                        discoveryTabItemView2.a(discoveryTabItemView2.m.C, discoveryTabItemView2.k);
                    }
                }
                discoveryTabItemView2.e.setText(!TextUtils.isEmpty(oVar.q) ? oVar.q : discoveryTabItemView2.m.q);
                discoveryTabItemView2.f.setText(oVar.c);
                discoveryTabItemView2.f.setVisibility(TextUtils.isEmpty(oVar.c) ? 8 : 0);
                i2 = (discoveryTabItemView2.m == null || !discoveryTabItemView2.m.a()) ? 0 : 1;
                if (discoveryTabItemView2.l.equals("kuainiao")) {
                    i2 &= b.b();
                    discoveryTabItemView2.f.setVisibility(i2 != 0 ? 0 : 8);
                } else if (TextUtils.isEmpty(oVar.d)) {
                    discoveryTabItemView2.g.setVisibility(8);
                } else {
                    discoveryTabItemView2.b(oVar.d, discoveryTabItemView2.g);
                }
                ImageView imageView = discoveryTabItemView2.h;
                if (i2 != 0 && discoveryTabItemView2.m.r == 1) {
                    i5 = 0;
                }
                imageView.setVisibility(i5);
                this.k.add(discoveryTabItemView);
                if (str.equals("local_service") || str.equals("game_center")) {
                    discoveryTabItemView = new DiscoveryLocalServiceView(getActivity(), str.equals("game_center"));
                    ((DiscoveryLocalServiceView) discoveryTabItemView).setItemData(oVar.w);
                    this.k.add(discoveryTabItemView);
                }
                if (str.equals("kuainiao")) {
                    this.i = discoveryTabItemView;
                    this.n = true;
                    this.q = oVar.A;
                }
                i2 = i4;
            }
            i3++;
        }
        this.r = 0;
        com.xunlei.downloadprovider.d.b.b bVar = com.xunlei.downloadprovider.d.d.a().c;
        size = this.j.size();
        while (i < size) {
            o oVar2 = (o) this.j.get(i);
            if (oVar2.A == this.q && bVar.d(oVar2.a)) {
                this.r++;
            }
            i++;
        }
    }

    private void c() {
        if (this.i != null) {
            boolean z;
            if (!this.l) {
                LoginHelper.a();
                if (!l.c() || !LoginHelper.a().t() || !LoginHelper.a().l()) {
                    z = false;
                    this.i.setRightTipUIForKuaiNiao(z);
                }
            }
            z = true;
            this.i.setRightTipUIForKuaiNiao(z);
        }
    }

    public final void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        StringBuilder stringBuilder = new StringBuilder("get_band_info: errorCode --> ");
        stringBuilder.append(i);
        stringBuilder.append(", xbi --> ");
        stringBuilder.append(xLAccelBandInfo);
        if (!b.a()) {
            boolean z = i == 0 && xLAccelBandInfo != null;
            a(z);
        }
    }

    public final void a(String str, int i, KnParams knParams) {
        StringBuilder stringBuilder = new StringBuilder("get_user_info: errorCode --> ");
        stringBuilder.append(str);
        stringBuilder.append(", isKuaiNiaoVip --> ");
        stringBuilder.append(knParams);
        str = null;
        if (knParams == null) {
            if (i == 1) {
                str = 1;
            }
            this.l = str;
        } else {
            if (knParams.getOther_IsVip() == 1 && i == 1) {
                str = 1;
            }
            this.l = str;
        }
        c();
    }

    public final void a(i iVar) {
        if (!(iVar == null || getActivity() == null || !isAdded())) {
            if (iVar.b() == null) {
                a(true, true);
            } else if ((VERSION.SDK_INT < 17 || getActivity().isDestroyed() == null) && isVisible() != null) {
                b((boolean) null);
            }
        }
    }

    static /* synthetic */ void a(DiscoveryFragment discoveryFragment) {
        if (!discoveryFragment.p) {
            if (discoveryFragment.h != null) {
                discoveryFragment.h.setVisibility(0);
            }
            if (discoveryFragment.h != null) {
                discoveryFragment.h.show();
            }
            if (discoveryFragment.e != null) {
                discoveryFragment.e.setVisibility(8);
            }
            if (discoveryFragment.g != null) {
                discoveryFragment.g.setVisibility(8);
            }
        }
    }
}
