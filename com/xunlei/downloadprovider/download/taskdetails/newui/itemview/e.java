package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailBtSubTaskMoreViewHolder */
public final class e extends b {
    private TextView a;
    private ImageView b;

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.download_details_item_bt_sub_task_more_view, viewGroup, false);
    }

    public e(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_title);
        this.b = (ImageView) view.findViewById(R.id.iv_arrow);
        view.setOnClickListener(new f(this));
    }

    @SuppressLint({"DefaultLocale"})
    public final void a(a aVar) {
        b(aVar);
        if (((Boolean) aVar.a(Boolean.class)).booleanValue() != null) {
            this.a.setText(R.string.task_detail_list_sub_task_more_fold);
            this.b.setImageResource(R.drawable.detail_arrow_up);
        } else {
            this.a.setText(R.string.task_detail_list_sub_task_more);
            this.b.setImageResource(R.drawable.detail_arrow_down);
        }
        if (this.f.g != null) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
        }
    }

    static /* synthetic */ void a(e eVar) {
        boolean booleanValue = ((Boolean) eVar.e.a(Boolean.class)).booleanValue();
        if (eVar.f instanceof com.xunlei.downloadprovider.download.taskdetails.newui.a) {
            ((com.xunlei.downloadprovider.download.taskdetails.newui.a) eVar.f).c(booleanValue ^ 1);
            ((com.xunlei.downloadprovider.download.taskdetails.newui.a) eVar.f).h();
        }
        if (booleanValue) {
            com.xunlei.downloadprovider.download.report.a.a("dl_bt_fold", eVar.e.d);
        } else {
            com.xunlei.downloadprovider.download.report.a.a("dl_bt_expand", eVar.e.d);
        }
    }
}
