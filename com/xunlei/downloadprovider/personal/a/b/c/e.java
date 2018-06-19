package com.xunlei.downloadprovider.personal.a.b.c;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.a;
import com.xunlei.downloadprovider.personal.a.b;
import com.xunlei.downloadprovider.personal.a.b.h;
import com.xunlei.downloadprovider.personal.a.i;
import com.xunlei.downloadprovider.personal.a.j;
import java.util.ArrayList;

/* compiled from: UserOneGridScoreViewHolder */
public final class e extends a implements b {
    private static boolean k = true;
    private static boolean l;
    private static int m;
    private static int n;
    private final int a = 103;
    private final int b = 104;
    private final int c = 105;
    private final int d = 106;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private View j;
    private boolean o;
    private int p;
    private int q;
    private UserCenterFragment r;
    private FragmentActivity s;
    private h t;
    private StaticHandler u;
    private LoginHelper v = LoginHelper.a();
    private ArrayList<h> w;
    private MessageListener x = new g(this);

    public e(View view, FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment, ArrayList<h> arrayList) {
        super(view);
        this.r = userCenterFragment;
        this.s = fragmentActivity;
        this.w = arrayList;
        this.r.a(this, "key_user_grid_view");
        this.u = new StaticHandler(this.x);
        this.j = view;
        this.e = (ImageView) view.findViewById(R.id.iv_one_grid);
        this.f = (TextView) view.findViewById(R.id.tv_one_grid);
        this.g = (TextView) view.findViewById(R.id.tv_one_grid_des);
        this.h = (TextView) view.findViewById(R.id.tv_one_grid_sign);
        this.i = (ImageView) view.findViewById(R.id.iv_score_red_point);
        view.setOnClickListener(new f(this));
    }

    private void c(int i) {
        this.i.setVisibility(8);
        this.g.setVisibility(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("积分");
        this.g.setText(stringBuilder.toString());
    }

    private void d(int i) {
        a a = a.a();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("key_grid_red_point_score");
        stringBuilder.append(LoginHelper.a().g.c());
        if ((DateUtil.isTheSameDay(currentTimeMillis, a.b(stringBuilder.toString(), 0)) ^ 1) != 0) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.g.setVisibility(0);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(i);
        stringBuilder2.append("积分待领取");
        this.g.setText(stringBuilder2.toString());
    }

    private void b(boolean z) {
        if (k) {
            j.a(this.w, z, f.a().j());
            k = false;
        }
    }

    public final void a(Object obj) {
        if (obj != null && (obj instanceof h)) {
            this.t = (h) obj;
            obj = this.t.c;
            CharSequence charSequence = this.t.d;
            CharSequence charSequence2 = this.t.e;
            int i = this.t.j;
            Object obj2 = this.t.f;
            int i2 = this.t.k;
            String str = this.t.l;
            String str2 = this.t.m;
            if (TextUtils.isEmpty(charSequence)) {
                this.j.setClickable(false);
                this.f.setText("");
                this.g.setText("");
            } else {
                this.j.setClickable(true);
                if (TextUtils.isEmpty(obj2)) {
                    this.e.setImageResource(i);
                } else {
                    com.xunlei.downloadprovider.personal.a.f.a.a(obj2, this.e, R.drawable.ic_user_center_default_gray);
                }
                this.f.setText(charSequence);
                this.g.setText(charSequence2);
                if (1 != i2 || a.a().a(obj, str, str2) == null) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                }
            }
            if (l.c() == null) {
                obj = this.t.e;
                if (TextUtils.isEmpty(obj)) {
                    this.g.setText("");
                    this.h.setVisibility(0);
                } else {
                    this.g.setText(obj);
                    this.h.setVisibility(8);
                }
                this.i.setVisibility(8);
                b(false);
            } else if (!(this.t == null || "score_center".equals(this.t.c) == null)) {
                if (TextUtils.isEmpty(this.t.e) != null) {
                    if (l == null) {
                        this.h.setVisibility(0);
                        this.i.setVisibility(8);
                        this.g.setVisibility(8);
                    } else if (n > null) {
                        d(n);
                    } else {
                        c(m);
                    }
                    com.xunlei.downloadprovider.personal.a.e.b.a().a(new i(this));
                    return;
                }
                this.g.setText(this.t.e);
                this.h.setVisibility(8);
            }
        }
    }

    public final void a() {
        k = true;
    }

    public final void b() {
        if (this.u != null) {
            this.u.removeCallbacksAndMessages(null);
        }
    }

    static /* synthetic */ void b(e eVar) {
        if (eVar.t != null) {
            String str = eVar.t.c;
            String str2 = eVar.t.g;
            String str3 = eVar.t.d;
            if (!TextUtils.isEmpty(str)) {
                if (eVar.i.getVisibility() == 0) {
                    eVar.i.setVisibility(8);
                    a.a().b(str);
                    if (eVar.q > 0) {
                        a a = a.a();
                        StringBuilder stringBuilder = new StringBuilder("key_grid_red_point_score");
                        stringBuilder.append(LoginHelper.a().g.c());
                        a.a(stringBuilder.toString(), System.currentTimeMillis());
                    }
                }
                Object obj = -1;
                if (str.hashCode() == 1200186018) {
                    if (str.equals("score_center")) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    i.a(eVar.s, str2, str3, "per_cl");
                } else if (l.c()) {
                    i.a(eVar.s, "per_cl", str2, l, n);
                } else {
                    eVar.v.a(eVar.s, new j(eVar, str2), LoginFrom.TASK_CENTER, null);
                }
            }
        }
    }

    static /* synthetic */ void d(e eVar) {
        if (l) {
            eVar.h.setVisibility(8);
            eVar.g.setVisibility(0);
            com.xunlei.downloadprovider.personal.a.e.b.a().a(new h(eVar));
            return;
        }
        eVar.h.setVisibility(0);
        eVar.g.setVisibility(8);
        eVar.i.setVisibility(8);
    }

    static /* synthetic */ void e(e eVar) {
        if (eVar.q > 0) {
            eVar.d(eVar.q);
            eVar.b(true);
            return;
        }
        eVar.c(eVar.p);
        eVar.b(false);
    }
}
