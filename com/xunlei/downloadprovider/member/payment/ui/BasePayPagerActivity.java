package com.xunlei.downloadprovider.member.payment.ui;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.e;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.i;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePayPagerActivity extends BasePayActivity {
    protected ViewPager j;
    ak k;
    protected List<ae> l = new ArrayList();
    SparseArray<e> m;
    private TabHost n;
    private OnPageChangeListener o = new ac(this);
    private OnTabChangeListener p = new ad(this);
    private int q = -1;

    protected void n() {
    }

    protected abstract List<ae> p();

    private void a(List<ae> list) {
        int size = list.size();
        this.n.clearAllTabs();
        for (int i = 0; i < size; i++) {
            ae aeVar = (ae) list.get(i);
            View inflate = LayoutInflater.from(this).inflate(R.layout.tab_spec_view_4_pay, null);
            TextView textView = (TextView) inflate.findViewById(R.id.tab_title);
            textView.setText(aeVar.a);
            Bundle bundle = aeVar.c;
            if (bundle != null) {
                int i2 = bundle.getInt("VasType");
                int i3 = R.drawable.ic_pay_tab_svip;
                if (i2 != 204) {
                    switch (i2) {
                        case 3:
                        case 4:
                            i3 = R.drawable.ic_pay_tab_platimun;
                            break;
                        case 5:
                            break;
                        default:
                            break;
                    }
                }
                i3 = R.drawable.ic_pay_tab_kn;
                textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i3), null, null, null);
                inflate.findViewById(R.id.tab_remomend_tv).setVisibility(i.b(i2) ? 0 : 8);
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            if (i < size - 1) {
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.payment_13_dp), 0);
            }
            inflate.setLayoutParams(layoutParams);
            inflate.setOnClickListener(new ab(this, i));
            this.n.addTab(this.n.newTabSpec(aeVar.a).setIndicator(inflate).setContent(16908305));
        }
        r();
    }

    private void r() {
        int childCount = this.n.getTabWidget().getChildCount();
        int i = 0;
        while (i < childCount) {
            ViewGroup viewGroup = (ViewGroup) this.n.getTabWidget().getChildAt(i);
            boolean z = this.n.getCurrentTab() == i;
            viewGroup.setSelected(z);
            viewGroup.findViewById(R.id.pay_tab_select_flag_iv).setVisibility(z ? 0 : 8);
            i++;
        }
    }

    protected BaseFragment o() {
        return b(this.j.getCurrentItem());
    }

    protected BaseFragment b(int i) {
        return (BaseFragment) this.k.a.get(i);
    }

    protected final void q() {
        this.l = p();
        if (this.m == null) {
            this.m = new SparseArray();
        }
        this.m.clear();
        Object obj = (this.c == null || !(this.c.isFromRedPacket() || this.c == PayFrom.LIXIAN_SPACE)) ? null : 1;
        if (obj == null) {
            e eVar = null;
            for (ae aeVar : this.l) {
                if (!(aeVar.c == null || aeVar.c.isEmpty())) {
                    int i = aeVar.c.getInt("VasType");
                    e a = c.a().a(this.a, i);
                    if (a != null) {
                        this.m.append(i, a);
                        if (eVar == null || eVar.e() > a.e()) {
                            this.q = this.l.indexOf(aeVar);
                        }
                        eVar = a;
                    }
                }
            }
        }
        a(this.l);
        ak akVar = this.k;
        akVar.a.clear();
        if (akVar.b != null) {
            akVar.b.clear();
        }
        this.k.b = this.l;
        this.k.notifyDataSetChanged();
        if (this.q != -1 && this.j != null) {
            this.j.setCurrentItem(this.q);
        }
    }

    @CallSuper
    protected void init(View view) {
        this.n = (TabHost) findViewById(16908306);
        this.n.setup();
        this.n.setOnTabChangedListener(this.p);
        this.n.getTabWidget().setDividerDrawable(null);
        this.j = (ViewPager) findViewById(R.id.viewPager);
        this.j.removeAllViews();
        this.k = new ak(getSupportFragmentManager(), this.l);
        this.j.setAdapter(this.k);
        this.j.setOnPageChangeListener(this.o);
    }
}
