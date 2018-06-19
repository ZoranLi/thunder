package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.bean.IPayMeal;
import com.xunlei.downloadprovider.member.payment.ui.a.b;
import com.xunlei.xllib.b.d;
import java.util.List;

public class PayMealAreaView extends LinearLayout {
    public View a;
    private PayRenewLayout b;
    private PayOperateLayout c;
    private View d;
    private RecyclerView e;
    private b f;
    private Context g;
    private IPayMeal h;
    private int i;
    private a j;
    private String k;
    private d l;

    public interface a {
        void a();
    }

    public PayMealAreaView(Context context) {
        this(context, null, 0);
    }

    public PayMealAreaView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PayMealAreaView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = findViewById(R.id.empty_line_view);
        this.d = findViewById(R.id.renew_operate_line_view);
        this.b = (PayRenewLayout) findViewById(R.id.auto_renew_layout);
        this.c = (PayOperateLayout) findViewById(R.id.pay_operate_layout);
        this.e = (RecyclerView) findViewById(R.id.pay_meal_rv);
        this.f = new b(this.g);
        this.f.f = new f(this);
        this.e.setLayoutManager(new LinearLayoutManager(this.g, 0, false));
        this.e.addItemDecoration(((com.xunlei.downloadprovider.xlui.recyclerview.divider.j.a) ((com.xunlei.downloadprovider.xlui.recyclerview.divider.j.a) new com.xunlei.downloadprovider.xlui.recyclerview.divider.j.a(this.g).a(17170445)).b(DipPixelUtil.dip2px(11.0f))).c());
        this.e.setAdapter(this.f);
        this.c.setCheckListener(new g(this));
        a();
    }

    private void a(int i) {
        IPayMeal iPayMeal = (IPayMeal) this.f.c(i);
        if (iPayMeal != null) {
            b bVar = this.f;
            bVar.a = i;
            bVar.notifyDataSetChanged();
            this.h = iPayMeal;
            int i2 = 8;
            if ((iPayMeal instanceof com.xunlei.downloadprovider.member.payment.activity.b) != 0) {
                com.xunlei.downloadprovider.member.payment.activity.b bVar2 = (com.xunlei.downloadprovider.member.payment.activity.b) iPayMeal;
                bVar2.n = this.c.getIsOperate();
                if (TextUtils.isEmpty(bVar2.d) == 0) {
                    this.a.setVisibility(8);
                    this.c.setVisibility(0);
                    i = this.d;
                    if (this.c.getVisibility() == 0 && this.b.getVisibility() == 0) {
                        i2 = 0;
                    }
                    i.setVisibility(i2);
                    if (bVar2.a() != 0) {
                        this.c.setTips("");
                        this.c.setPayOpertateType(bVar2.d);
                        this.c.getPayOpertateTypeTv().setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.ic_problem), null);
                    } else {
                        this.c.getPayOpertateTypeTv().setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        this.c.setTips(bVar2.d);
                        k();
                    }
                }
            }
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            if (h() != 0) {
                i();
            }
        }
        j();
    }

    public final void a(List<IPayMeal> list, int i, int i2) {
        if (d.a(list)) {
            setVisibility(8);
            return;
        }
        this.i = i2;
        k();
        i2 = 0;
        setVisibility(0);
        if (list.size() < 4) {
            this.f.a(list.size());
        }
        b bVar = this.f;
        bVar.b = false;
        if (!d.a(list)) {
            for (IPayMeal iPayMeal : list) {
                if (iPayMeal.getType() == 1 && !TextUtils.isEmpty(((com.xunlei.downloadprovider.member.payment.activity.b) iPayMeal).q)) {
                    bVar.b = true;
                    break;
                }
            }
        }
        bVar.a((List) list);
        int size = list.size();
        while (i2 < size) {
            if (i == ((IPayMeal) list.get(i2)).getLocateMonth()) {
                break;
            }
            i2++;
        }
        i2 = -1;
        a(i2);
    }

    public final void a() {
        PayRenewLayout payRenewLayout = this.b;
        payRenewLayout.setVisibility(8);
        payRenewLayout.a.setChecked(false);
        this.d.setVisibility(8);
        if (h()) {
            i();
        }
    }

    public final void b() {
        if (g() && ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a()) {
            a();
            return;
        }
        int i = 8;
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        View view = this.d;
        if (this.c.getVisibility() == 0 && this.b.getVisibility() == 0) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public final boolean c() {
        return (this.b.getVisibility() == 0 && this.b.a.isChecked()) || (g() && ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a());
    }

    public final boolean d() {
        return g() && ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a();
    }

    public int getRealPayMonth() {
        if (this.h == null) {
            return -1;
        }
        return this.h.getRealPayMonth();
    }

    public float getRealPayPrice() {
        if (this.h == null) {
            return -1.0f;
        }
        return this.h.getRealPayPrice();
    }

    public float getSaveAmount() {
        if (this.h == null) {
            return -1.0f;
        }
        return this.h.getSaveAmount();
    }

    public String getPayWard() {
        return (!e() || ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a()) ? null : ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).e;
    }

    public void setPayMealItemSelectListener(a aVar) {
        this.j = aVar;
    }

    public void setOnClickRenewLayoutListener(com.xunlei.downloadprovider.member.payment.ui.widget.PayRenewLayout.a aVar) {
        this.b.setOnClickRenewLayoutListener(aVar);
    }

    public void setRenewText(CharSequence charSequence) {
        this.b.setRenewText(charSequence);
    }

    public final boolean e() {
        return g() && (this.c.getIsOperate() || ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a());
    }

    public String getExt() {
        return (!e() || ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a()) ? null : ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).f;
    }

    public String getActivityId() {
        return (!e() || ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).a()) ? null : ((com.xunlei.downloadprovider.member.payment.activity.b) this.h).g;
    }

    public final boolean f() {
        if (g()) {
            if (!((com.xunlei.downloadprovider.member.payment.activity.b) this.h).k) {
                return false;
            }
        }
        return true;
    }

    public final boolean g() {
        return this.h != null && this.h.getType() == 1;
    }

    public void setRenewTextSize(int i) {
        this.b.setRenewTextSize(i);
    }

    public final boolean h() {
        return this.c.getVisibility() == 8 && this.b.getVisibility() == 8;
    }

    public final void i() {
        this.a.setVisibility(0);
    }

    private void k() {
        switch (this.i) {
            case 1:
                this.c.setPayOpertateType(this.g.getString(R.string.pay_activity_type_huangou));
                return;
            case 2:
                this.c.setPayOpertateType(this.g.getString(R.string.pay_activity_type_zengsong));
                return;
            case 3:
                this.c.setPayOpertateType(this.g.getString(R.string.pay_activity_type_temai));
                return;
            default:
                this.c.setPayOpertateType("");
                return;
        }
    }

    public void setPayReporter(String str) {
        this.k = str;
    }

    private void j() {
        if (f()) {
            b();
        } else {
            a();
        }
        if (this.j != null) {
            this.j.a();
        }
    }

    static /* synthetic */ void d(PayMealAreaView payMealAreaView) {
        if (payMealAreaView.l == null) {
            payMealAreaView.l = new d(payMealAreaView.getContext());
        }
        payMealAreaView.l.show();
        com.xunlei.downloadprovider.member.payment.d.e(payMealAreaView.k);
    }
}
