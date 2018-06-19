package com.xunlei.downloadprovider.member.payment.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: PayProblemAdapter */
public final class c extends Adapter<b> {
    public a a;
    private Context b;
    private String[] c;
    private String[] d;
    private final int e = this.b.getResources().getColor(2131689734);

    /* compiled from: PayProblemAdapter */
    public interface a {
        void a();
    }

    /* compiled from: PayProblemAdapter */
    class b extends ViewHolder {
        TextView a;
        TextView b;
        final /* synthetic */ c c;

        public b(c cVar, View view) {
            this.c = cVar;
            super(view);
            this.a = (TextView) view.findViewById(R.id.pay_problem_title_tv);
            this.b = (TextView) view.findViewById(R.id.pay_problem_content_tv);
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        bVar.a.setText(this.c[i]);
        if (i == 2) {
            a(this.d[2], 11, 17, bVar.b, i);
        } else if (i == this.d.length - 1) {
            a(this.d[this.d.length - 1], 7, 19, bVar.b, i);
        } else {
            bVar.b.setText(this.d[i]);
        }
    }

    public c(String[] strArr, String[] strArr2, Context context) {
        this.c = strArr;
        this.d = strArr2;
        this.b = context;
    }

    public final int getItemCount() {
        return this.c.length;
    }

    private void a(String str, int i, int i2, TextView textView, int i3) {
        CharSequence spannableString = new SpannableString(str);
        if (i3 == 2) {
            spannableString.setSpan(new d(this), i, i2, 33);
        }
        if (i3 == this.d.length - 1) {
            spannableString.setSpan(new e(this), i, i2, 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(this.e), i, i2, 33);
        textView.append(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(this, LayoutInflater.from(this.b).inflate(R.layout.pay_problem_item, viewGroup, false));
    }

    static /* synthetic */ void b(c cVar) {
        com.xunlei.thunder.commonui.dialog.b c = new com.xunlei.thunder.commonui.dialog.b(cVar.b).a((int) R.string.sett_sure_call_xl).b((int) R.string.cancel).c(R.string.sett_dial);
        c.d = new g(cVar);
        c.b = new f(cVar);
        c.setCanceledOnTouchOutside(true);
        c.show();
    }
}
