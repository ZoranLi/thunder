package com.xunlei.downloadprovider.member.payment.voucher;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.ui.a.h;
import java.util.HashSet;

/* compiled from: VoucherListDlg */
final class n extends Dialog {
    b a;
    a b;
    private c c;

    /* compiled from: VoucherListDlg */
    interface a {
        void a(Voucher voucher);

        void onCancel();
    }

    /* compiled from: VoucherListDlg */
    private static class b extends com.xunlei.downloadprovider.member.payment.ui.a.a<Voucher> {
        private HashSet<String> d;
        private String e;
        private c f;

        protected final /* synthetic */ void a(Object obj, h hVar) {
            Voucher voucher = (Voucher) obj;
            View view = (View) hVar.a.get(R.id.pay_voucher_item_layout);
            if (view == null) {
                view = hVar.b.findViewById(R.id.pay_voucher_item_layout);
                hVar.a.put(R.id.pay_voucher_item_layout, view);
            }
            VoucherItemLayout voucherItemLayout = (VoucherItemLayout) view;
            int i = 8;
            if (this.d.contains(voucher.b) != null) {
                voucherItemLayout.f.setVisibility(0);
                voucherItemLayout.b.setVisibility(8);
                voucherItemLayout.d.setVisibility(8);
            } else {
                voucherItemLayout.f.setVisibility(8);
                voucherItemLayout.b.setVisibility(0);
            }
            voucherItemLayout.setChecked(TextUtils.equals(voucher.b, this.e));
            hVar = voucher.a;
            obj = this.f.b(voucher.b);
            voucherItemLayout.e = hVar;
            voucherItemLayout.f.setVisibility(8);
            voucherItemLayout.b.setVisibility(0);
            if (obj == null) {
                voucherItemLayout.a.setText(Html.fromHtml(String.format(voucherItemLayout.getResources().getString(R.string.pay_voucher_format_item), new Object[]{PayUtil.a(voucherItemLayout.e)})));
            } else {
                voucherItemLayout.a.setText(Html.fromHtml(String.format(voucherItemLayout.getResources().getString(R.string.pay_voucher_format_item_lock), new Object[]{PayUtil.a(voucherItemLayout.e)})));
            }
            hVar = voucherItemLayout.d;
            if (obj != null) {
                i = 0;
            }
            hVar.setVisibility(i);
            voucherItemLayout.setEnabled(obj ^ 1);
            if (obj != null) {
                voucherItemLayout.c = false;
            }
            hVar = voucherItemLayout.b;
            obj = obj != null ? R.drawable.ic_pay_unable : voucherItemLayout.c != null ? R.drawable.ic_pay_selected : R.drawable.ic_pay_unselect;
            hVar.setButtonDrawable(obj);
        }

        private b(Context context, c cVar) {
            super(context);
            this.d = new HashSet();
            this.f = cVar;
        }

        static /* synthetic */ void a(b bVar, String str) {
            if (!TextUtils.isEmpty(str)) {
                bVar.d.add(str);
            }
            bVar.notifyDataSetChanged();
        }

        static /* synthetic */ void b(b bVar, String str) {
            if (!TextUtils.isEmpty(str)) {
                for (Voucher voucher : bVar.a) {
                    if (TextUtils.equals(voucher.b, str)) {
                        bVar.e = voucher.b;
                        break;
                    }
                }
            }
            bVar.e = str;
            bVar.notifyDataSetChanged();
        }
    }

    n(Context context, @NonNull c cVar) {
        super(context, R.style.PayVoucherListDlg);
        if (cVar == null) {
            throw new IllegalArgumentException("IVoucherProcessor is null, please check!!!");
        }
        setCanceledOnTouchOutside(false);
        this.c = cVar;
        context = View.inflate(context, R.layout.pay_voucher_list_dlg, null);
        ListView listView = (ListView) context.findViewById(R.id.pay_voucher_lv);
        this.a = new b(getContext(), this.c);
        listView.setAdapter(this.a);
        context.findViewById(R.id.pay_voucher_cancel_tv).setOnClickListener(new o(this));
        listView.setChoiceMode(1);
        listView.setOnItemClickListener(new p(this));
        setContentView(context);
    }

    public final void show() {
        super.show();
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.b != 0) {
            this.b.onCancel();
        }
        dismiss();
        return true;
    }
}
