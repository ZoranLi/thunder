package com.xunlei.downloadprovider.personal.a.b.c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.personal.a.b;
import com.xunlei.downloadprovider.personal.a.b.h;
import com.xunlei.downloadprovider.personal.a.i;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui.RedEnvelopesActivity;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: UserOneGridViewHolder */
public final class k extends a implements b {
    private ImageView a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private View e;
    private FragmentActivity f;
    private h g;
    private a h = new m(this);
    private g i = new o(this);

    public final void a() {
    }

    public final void b() {
    }

    public k(View view, FragmentActivity fragmentActivity) {
        super(view);
        this.f = fragmentActivity;
        this.e = view;
        this.a = (ImageView) view.findViewById(R.id.iv_one_grid);
        this.b = (TextView) view.findViewById(R.id.tv_one_grid);
        this.c = (TextView) view.findViewById(R.id.tv_one_grid_des);
        this.d = (ImageView) view.findViewById(R.id.iv_score_red_point);
        view.setOnClickListener(new l(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r12) {
        /*
        r11 = this;
        if (r12 == 0) goto L_0x00f7;
    L_0x0002:
        r0 = r12 instanceof com.xunlei.downloadprovider.personal.a.b.h;
        if (r0 == 0) goto L_0x00f7;
    L_0x0006:
        r12 = (com.xunlei.downloadprovider.personal.a.b.h) r12;
        r11.g = r12;
        r12 = r11.g;
        r12 = r12.c;
        r0 = r11.g;
        r0 = r0.d;
        r1 = r11.g;
        r1 = r1.e;
        r2 = r11.g;
        r2 = r2.j;
        r3 = r11.g;
        r3 = r3.f;
        r4 = r11.g;
        r4 = r4.k;
        r5 = r11.g;
        r5 = r5.l;
        r6 = r11.g;
        r6 = r6.m;
        r7 = android.text.TextUtils.isEmpty(r0);
        r8 = 8;
        r9 = 0;
        if (r7 == 0) goto L_0x0047;
    L_0x0033:
        r12 = r11.e;
        r12.setClickable(r9);
        r12 = r11.b;
        r0 = "";
        r12.setText(r0);
        r12 = r11.c;
        r0 = "";
        r12.setText(r0);
        goto L_0x008a;
    L_0x0047:
        r7 = r11.e;
        r10 = 1;
        r7.setClickable(r10);
        r7 = android.text.TextUtils.isEmpty(r3);
        if (r7 != 0) goto L_0x005c;
    L_0x0053:
        r2 = r11.a;
        r7 = 2130838651; // 0x7f02047b float:1.728229E38 double:1.0527741743E-314;
        com.xunlei.downloadprovider.personal.a.f.a.a(r3, r2, r7);
        goto L_0x0061;
    L_0x005c:
        r3 = r11.a;
        r3.setImageResource(r2);
    L_0x0061:
        r2 = r11.b;
        r2.setText(r0);
        r0 = r11.c;
        r0.setText(r1);
        if (r10 != r4) goto L_0x008a;
    L_0x006d:
        r0 = com.xunlei.downloadprovider.personal.a.a.a();
        r0 = r0.a(r12, r5, r6);
        if (r0 == 0) goto L_0x008a;
    L_0x0077:
        r0 = r11.d;
        r0.setVisibility(r9);
        r0 = "offline_space";
        r12 = android.text.TextUtils.equals(r0, r12);
        if (r12 == 0) goto L_0x008f;
    L_0x0084:
        r12 = com.xunlei.downloadprovider.personal.lixianspace.a.a();
        if (r12 != 0) goto L_0x008f;
    L_0x008a:
        r12 = r11.d;
        r12.setVisibility(r8);
    L_0x008f:
        r12 = "my_gift";
        r0 = r11.g;
        r0 = r0.c;
        r12 = android.text.TextUtils.equals(r12, r0);
        if (r12 == 0) goto L_0x00f7;
    L_0x009b:
        r12 = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
        r12 = r12.h();
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
        r0 = r0.i();
        if (r0 == 0) goto L_0x00c0;
    L_0x00ad:
        r0 = r11.g;
        r0.e = r12;
        r12 = r11.c;
        r0 = r11.g;
        r0 = r0.e;
        r12.setText(r0);
        r12 = r11.d;
        r12.setVisibility(r9);
        return;
    L_0x00c0:
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
        r0 = r0.e;
        if (r0 == 0) goto L_0x00db;
    L_0x00c8:
        r0 = r11.g;
        r0.e = r12;
        r12 = r11.c;
        r0 = r11.g;
        r0 = r0.e;
        r12.setText(r0);
        r12 = r11.d;
        r12.setVisibility(r9);
        return;
    L_0x00db:
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
        r0 = r0.f();
        if (r0 == 0) goto L_0x00f7;
    L_0x00e5:
        r0 = r11.g;
        r0.e = r12;
        r12 = r11.c;
        r0 = r11.g;
        r0 = r0.e;
        r12.setText(r0);
        r12 = r11.d;
        r12.setVisibility(r8);
    L_0x00f7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.a.b.c.k.a(java.lang.Object):void");
    }

    public final void c() {
        super.c();
        if (TextUtils.equals("my_gift", this.g.c)) {
            f a = f.a();
            a aVar = this.h;
            if (aVar != null) {
                new StringBuilder("[addRedPaketStateListener] ").append(aVar.toString());
                if (a.f == null) {
                    a.f = new ArrayList();
                }
                if (!a.f.contains(aVar)) {
                    Iterator it = a.f.iterator();
                    while (it.hasNext()) {
                        a aVar2 = (a) it.next();
                        if (aVar2 != null && aVar2.getClass().isAssignableFrom(aVar.getClass())) {
                            a.a(aVar2);
                            break;
                        }
                    }
                    a.f.add(aVar);
                }
            }
            LoginHelper.a().a(this.i);
        }
    }

    public final void d() {
        super.d();
        if (TextUtils.equals("my_gift", this.g.c)) {
            f.a().a(this.h);
            LoginHelper.a().b(this.i);
        }
    }

    static /* synthetic */ void b(k kVar) {
        if (kVar.g != null) {
            String str = kVar.g.c;
            Object obj = kVar.g.g;
            String str2 = kVar.g.i;
            str2 = kVar.g.h;
            str2 = kVar.g.d;
            if (!TextUtils.isEmpty(str)) {
                if (kVar.d.getVisibility() == 0) {
                    kVar.d.setVisibility(8);
                    com.xunlei.downloadprovider.personal.a.a.a().b(str);
                }
                boolean z = true;
                int hashCode = str.hashCode();
                if (hashCode != -1729567037) {
                    if (hashCode != -370265880) {
                        if (hashCode != 1068068921) {
                            if (hashCode == 1508687843) {
                                if (str.equals("my_gift")) {
                                    z = false;
                                }
                            }
                        } else if (str.equals("live_welfare")) {
                            z = true;
                        }
                    } else if (str.equals("share_packet")) {
                        z = true;
                    }
                } else if (str.equals("help_feedback")) {
                    z = true;
                }
                switch (z) {
                    case false:
                        f.a().a(false);
                        if (f.a().e) {
                            f.a().g();
                        }
                        if (f.a().f()) {
                            kVar.g.e = f.a().h();
                            kVar.c.setText(kVar.g.e);
                        } else {
                            kVar.c.setText("");
                            kVar.g.e = "";
                        }
                        kVar.f.startActivity(new XLIntent(kVar.f, RedEnvelopesActivity.class));
                        return;
                    case true:
                        com.xunlei.downloadprovider.launch.b.a.a().openLiveWelfare(kVar.f, "personal");
                        return;
                    case true:
                        if (!TextUtils.isEmpty(obj)) {
                            i.a(kVar.f, obj, "40");
                        }
                        return;
                    case true:
                        j.a();
                        j.a(kVar.f, "personal_entry_red");
                        return;
                    default:
                        i.a(kVar.f, obj, str2, "per_cl");
                        break;
                }
            }
        }
    }

    static /* synthetic */ boolean c(k kVar) {
        kVar = kVar.itemView.getContext();
        if (kVar instanceof Activity) {
            Activity activity = (Activity) kVar;
            if (activity.isFinishing() || (VERSION.SDK_INT >= 17 && activity.isDestroyed() != null)) {
                return true;
            }
        }
        return null;
    }
}
