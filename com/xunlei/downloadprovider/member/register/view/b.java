package com.xunlei.downloadprovider.member.register.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: MailBoxAdapter */
public final class b extends BaseAdapter implements Filterable {
    private final String a = getClass().getSimpleName();
    private String[] b;
    private LayoutInflater c;

    /* compiled from: MailBoxAdapter */
    private static class a {
        public final TextView a;

        a(TextView textView) {
            this.a = textView;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public b(Context context, String[] strArr, String str) {
        this.c = LayoutInflater.from(context);
        a(strArr, str);
    }

    public final int getCount() {
        return this.b.length;
    }

    public final Object getItem(int i) {
        return this.b[i];
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.c.inflate(R.layout.mail_domin_item, null);
            aVar = new a((TextView) view.findViewById(R.id.mail_domain_text));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(this.b[i]);
        return view;
    }

    private void a(String[] strArr, String str) {
        this.b = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String[] strArr2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(strArr[i]);
            strArr2[i] = stringBuilder.toString();
        }
    }

    public final Filter getFilter() {
        return new c(this);
    }
}
