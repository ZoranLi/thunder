package com.xunlei.downloadprovider.member.register.view;

import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: MailBoxAdapter */
final class c extends Filter {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        this.a.b = (String[]) filterResults.values;
        if (filterResults.count > null) {
            this.a.notifyDataSetChanged();
        } else {
            this.a.notifyDataSetInvalidated();
        }
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        new StringBuilder("constraint:").append(charSequence);
        charSequence = new FilterResults();
        charSequence.values = this.a.b;
        charSequence.count = this.a.b.length;
        return charSequence;
    }
}
