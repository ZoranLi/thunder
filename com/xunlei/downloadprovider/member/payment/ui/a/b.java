package com.xunlei.downloadprovider.member.payment.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.activity.widget.ActivityItemView;
import com.xunlei.downloadprovider.member.payment.bean.IPayMeal;
import com.xunlei.downloadprovider.member.payment.bean.PayMealItem;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.ui.a.a.d;
import com.xunlei.downloadprovider.member.payment.ui.widget.PayMealItemView;

/* compiled from: PayMealAdapter */
public final class b extends com.xunlei.downloadprovider.member.payment.ui.a.a.a<IPayMeal, d> {
    public int a = -1;
    public boolean b = false;
    private int g;
    private Context h;
    private boolean i;
    private String j;
    private int k;

    /* compiled from: PayMealAdapter */
    private static class a extends d {
        private ActivityItemView d;

        private a(View view) {
            super(view);
            this.d = (ActivityItemView) view.findViewById(R.id.activity_pay_item_view);
        }
    }

    /* compiled from: PayMealAdapter */
    private static class b extends d {
        private PayMealItemView d;

        private b(View view) {
            super(view);
            this.d = (PayMealItemView) view.findViewById(R.id.meal_item_view);
        }
    }

    protected final /* synthetic */ void a(d dVar, Object obj, int i) {
        IPayMeal iPayMeal = (IPayMeal) obj;
        boolean z = true;
        if (dVar instanceof a) {
            ActivityItemView a = ((a) dVar).d;
            com.xunlei.downloadprovider.member.payment.activity.b bVar = (com.xunlei.downloadprovider.member.payment.activity.b) iPayMeal;
            if (bVar != null) {
                a.a = bVar;
                a.a();
                if (TextUtils.isEmpty(a.a.j)) {
                    a.b.setText(a.d.getString(R.string.pay_meal_month, new Object[]{Integer.valueOf(a.a.h)}));
                } else {
                    CharSequence charSequence = a.a.j;
                    if (charSequence.contains("<") && charSequence.contains(">")) {
                        a.b.setText(Html.fromHtml(charSequence.replace("<", "<font color=\"#F15E4A\"").replace(">", "</font>").replace("<font color=\"#F15E4A\"", "<font color=\"#F15E4A\">")));
                    } else {
                        a.b.setText(charSequence);
                    }
                }
                if (TextUtils.isEmpty(bVar.q)) {
                    a.c.setVisibility(8);
                } else {
                    a.c.setText(bVar.q);
                    a.c.setVisibility(0);
                }
            }
            if (this.a != i) {
                z = false;
            }
            a.setChecked(z);
        } else if (dVar instanceof b) {
            PayMealItemView a2 = ((b) dVar).d;
            a2.setIsNeedHideSubscript(this.b ^ true);
            boolean z2 = this.i;
            String str = this.j;
            int i2 = this.k;
            a2.d = z2;
            a2.e = str;
            a2.f = i2;
            PayMealItem payMealItem = (PayMealItem) iPayMeal;
            Context context = a2.getContext();
            a2.a.setText(context.getString(R.string.pay_meal_month, new Object[]{Integer.valueOf(payMealItem.month)}));
            int i3 = payMealItem.month;
            float f = payMealItem.monthUnitPrice;
            float f2 = payMealItem.totalMoney;
            if (payMealItem.isTotalPriceMode) {
                a2.b.setText(context.getString(R.string.pay_meal_total_price, new Object[]{PayUtil.a(f2)}));
            } else {
                a2.b.setText(context.getString(R.string.pay_meal_month_unit_price, new Object[]{PayMealItemView.a(i3, f2)}));
            }
            if (!a2.d) {
                if (a2.g) {
                    obj = payMealItem.month;
                    if (obj == 1) {
                        a2.c.setVisibility(8);
                    } else if (obj == 3) {
                        a2.c.setVisibility(8);
                    } else if (obj == 6) {
                        a2.c.setVisibility(8);
                    } else if (obj == 12) {
                        if (PayMealItemView.a(i3, f, f2) > null) {
                            a2.c.setVisibility(0);
                            a2.c.setBackgroundResource(R.drawable.pay_meal_float_item_save_flag);
                            a2.c.setTranslationY(0.0f);
                            a2.c.setText(context.getString(R.string.pay_meal_year_save, new Object[]{PayUtil.a(obj)}));
                        } else {
                            a2.c.setVisibility(8);
                        }
                    }
                }
                a2.c.setVisibility(8);
            } else if (i3 == a2.f) {
                a2.c.setVisibility(0);
                a2.c.setBackgroundResource(R.drawable.red_package_promote);
                a2.c.setPadding(DipPixelUtil.dip2px(23.0f), 0, 0, 0);
                a2.c.setTranslationY((float) DipPixelUtil.dip2px(-5.0f));
                a2.c.setText(a2.e);
            } else {
                a2.c.setVisibility(8);
            }
            if (this.a != i) {
                z = false;
            }
            a2.setChecked(z);
        }
        LayoutParams layoutParams = (LayoutParams) dVar.itemView.getLayoutParams();
        if (layoutParams == null) {
            dVar.itemView.setLayoutParams(new LayoutParams(this.g, -2));
            return;
        }
        if (layoutParams.width != this.g) {
            layoutParams.width = this.g;
            dVar.itemView.setLayoutParams(layoutParams);
        }
    }

    public b(Context context) {
        super(context);
        this.h = context;
        a(4);
    }

    public final void a(int i) {
        this.g = (this.h.getResources().getDisplayMetrics().widthPixels - (DipPixelUtil.dip2px(13.0f) * 2)) - (DipPixelUtil.dip2px(11.0f) * (i - 1));
        this.g /= i;
    }

    protected final d a(ViewGroup viewGroup, int i) {
        if (1 == i) {
            return new a(this.e.inflate(R.layout.activity_pay_item_view, viewGroup, false));
        }
        return new b(this.e.inflate(R.layout.pay_meal_item_layout, viewGroup, false));
    }

    protected final int b(int i) {
        if (this.c == null || this.c.isEmpty()) {
            return super.getItemViewType(i);
        }
        return ((IPayMeal) this.c.get(i)).getType();
    }
}
