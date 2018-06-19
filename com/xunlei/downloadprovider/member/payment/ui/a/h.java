package com.xunlei.downloadprovider.member.payment.ui.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;

/* compiled from: ViewHolder */
public final class h {
    public final SparseArray<View> a = new SparseArray();
    public View b;

    h(Context context, ViewGroup viewGroup) {
        this.b = LayoutInflater.from(context).inflate(R.layout.pay_voucher_item, viewGroup, false);
        this.b.setTag(this);
    }
}
