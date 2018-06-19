package com.xunlei.downloadprovider.personal;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.a.a;
import com.xunlei.downloadprovider.member.b.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.external.i;
import com.xunlei.downloadprovider.personal.a.b;
import com.xunlei.downloadprovider.personal.a.c;
import com.xunlei.downloadprovider.personal.a.j;
import com.xunlei.downloadprovider.personal.a.k;
import java.util.LinkedHashMap;
import java.util.Observer;

public class UserCenterFragment extends BaseFragment implements a {
    public static boolean a = true;
    public static int b;
    public Observer c;
    private LinkedHashMap<String, b> d = new LinkedHashMap();
    private LoginHelper e = LoginHelper.a();
    private com.xunlei.downloadprovider.personal.a.a.a f;
    private com.xunlei.downloadprovider.member.b.a g;
    private StaticHandler h;
    private boolean i;
    private View j;
    private int k;
    private MessageListener l = new a(this);
    private h m = new b(this);
    private final g n = new c(this);
    private c o;
    private i p = new e(this);
    private com.xunlei.downloadprovider.personal.a.g q;

    public final void j() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = false;
        j.a();
        layoutInflater = layoutInflater.inflate(R.layout.user_center_list, viewGroup, false);
        this.j = layoutInflater.findViewById(R.id.status_bar_fix);
        this.j.setLayoutParams(new LayoutParams(-1, com.xunlei.downloadprovider.h.j.a(getActivity())));
        this.k = b();
        this.j.setBackgroundColor(this.k);
        RecyclerView recyclerView = (RecyclerView) layoutInflater.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new k(this.mActivity));
        this.f = new com.xunlei.downloadprovider.personal.a.a.a(getActivity(), this);
        recyclerView.setAdapter(this.f);
        this.h = new StaticHandler(this.l);
        return layoutInflater;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onResume() {
        super.onResume();
        if (this.i && l.c()) {
            this.e.b();
        }
        this.i = true;
        if (this.g == null) {
            this.g = com.xunlei.downloadprovider.member.b.c.a(this);
        }
        this.g.c("5");
        com.xunlei.downloadprovider.d.i.a().a(System.currentTimeMillis(), "user_center");
        ((MainTabActivity) this.mActivity).a();
        ((MainTabActivity) this.mActivity).a(false, null);
        this.e.a(this.m);
        this.e.a(this.n);
        com.xunlei.downloadprovider.member.payment.external.h.a().addObserver(this.p);
        com.xunlei.downloadprovider.personal.settings.a.a.a();
        a(1);
        if (this.j != null) {
            int b = b();
            if (b != this.k) {
                this.j.setBackgroundColor(b);
                this.k = b;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        a(2);
        if (this.d != null) {
            this.d.clear();
        }
        this.e.b(this.m);
        this.e.b(this.n);
        com.xunlei.downloadprovider.member.payment.external.h.a().deleteObserver(this.p);
        if (this.o != null) {
            this.o.dismiss();
        }
        if (this.q != null) {
            this.q.dismiss();
        }
    }

    public final void a(b bVar, String str) {
        if (this.d != null) {
            this.d.put(str, bVar);
        }
    }

    private void a(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.d);
        for (String str : linkedHashMap.keySet()) {
            b bVar = (b) linkedHashMap.get(str);
            switch (i) {
                case 1:
                    bVar.a();
                    break;
                case 2:
                    bVar.b();
                    break;
                default:
                    break;
            }
        }
    }

    public final void i() {
        CharSequence d;
        int e;
        d a = a();
        CharSequence charSequence = null;
        if (a != null) {
            charSequence = a.b();
            d = a.d();
            e = a.e();
        } else {
            e = 0;
            d = null;
        }
        if (!TextUtils.isEmpty(charSequence) && l.b()) {
            StringBuilder stringBuilder = new StringBuilder("key_renewal_userid");
            stringBuilder.append(String.valueOf(this.e.g.c()));
            String stringBuilder2 = stringBuilder.toString();
            if (!DateUtil.isTheSameDay(f.b(this.mActivity, stringBuilder2, 0), System.currentTimeMillis())) {
                String f;
                StringBuilder stringBuilder3;
                if (com.xunlei.downloadprovider.d.d.a().h.j()) {
                    f = a.f();
                    if (((MainTabActivity) this.mActivity).c == this) {
                        com.xunlei.downloadprovider.personal.a.g gVar;
                        if (this.q == null) {
                            this.q = new com.xunlei.downloadprovider.personal.a.g(this.mActivity);
                            gVar = this.q;
                            gVar.c.setOnClickListener(new g(this, f));
                            gVar.b.setOnClickListener(new f(this, f));
                        }
                        gVar = this.q;
                        gVar.a(d);
                        gVar.a();
                        if (e == 0) {
                            d = "今天到期";
                        } else if (e > 0) {
                            d = "已经过期";
                        } else {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(-e);
                            stringBuilder3.append("天后过期");
                            d = stringBuilder3.toString();
                        }
                        gVar.a.setText(d);
                        if (LoginHelper.a().t()) {
                            gVar.a.setTextColor(Color.parseColor("#F8BA30"));
                        } else if (LoginHelper.a().s()) {
                            gVar.a.setTextColor(Color.parseColor("#DCA358"));
                        } else {
                            gVar.a.setTextColor(Color.parseColor("#1AA3FF"));
                        }
                        gVar.d.setText(charSequence);
                        if (!this.q.isShowing()) {
                            this.q.show();
                        }
                        q.a("personal_center_tip", f);
                    }
                } else {
                    f = a.f();
                    if (((MainTabActivity) this.mActivity).c == this) {
                        c cVar;
                        if (this.o == null) {
                            this.o = new c(this.mActivity);
                            this.o.setCanceledOnTouchOutside(false);
                            cVar = this.o;
                            if (!TextUtils.isEmpty(d)) {
                                cVar.b.setText(d);
                            }
                            this.o.a(new d(this, f));
                        }
                        cVar = this.o;
                        if (e == 0) {
                            cVar.c.setText("会员今天到期");
                        } else if (e > 0) {
                            cVar.c.setText("会员已经过期");
                            cVar.d.setBackgroundResource(R.drawable.ic_usercenter_renewal_top_outdate);
                            cVar = this.o;
                            if (charSequence != null) {
                                cVar.a.setText(charSequence);
                            }
                            if (!this.o.isShowing()) {
                                this.o.show();
                            }
                            q.a("personal_center_tip", f);
                        } else {
                            stringBuilder3 = new StringBuilder("会员");
                            stringBuilder3.append(-e);
                            stringBuilder3.append("天后过期");
                            d = stringBuilder3.toString();
                            if (d != null) {
                                CharSequence spannableStringBuilder = new SpannableStringBuilder(d);
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#0097e8")), 2, 3, 33);
                                cVar.c.setText(spannableStringBuilder);
                            }
                        }
                        cVar.d.setBackgroundResource(R.drawable.ic_usercenter_renewal_top);
                        cVar = this.o;
                        if (charSequence != null) {
                            cVar.a.setText(charSequence);
                        }
                        if (this.o.isShowing()) {
                            this.o.show();
                        }
                        q.a("personal_center_tip", f);
                    }
                }
                f.a(this.mActivity, stringBuilder2, System.currentTimeMillis());
            }
        }
    }

    private d a() {
        if (this.g == null) {
            this.g = com.xunlei.downloadprovider.member.b.c.a(this);
        }
        return this.g.b("5");
    }

    private int b() {
        Resources resources = getResources();
        LoginHelper a = LoginHelper.a();
        int color = resources.getColor(R.color.bar_color_normal);
        if (!l.c() || !com.xunlei.downloadprovider.member.payment.a.j.a().c()) {
            return color;
        }
        if (a.s()) {
            color = resources.getColor(R.color.bar_color_platinum);
        }
        return a.t() ? resources.getColor(R.color.bar_color_super) : color;
    }

    static /* synthetic */ String d(UserCenterFragment userCenterFragment) {
        userCenterFragment = userCenterFragment.a();
        return (userCenterFragment == null || userCenterFragment.g() == null) ? "" : userCenterFragment.g().a;
    }
}
