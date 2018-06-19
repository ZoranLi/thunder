package com.xunlei.downloadprovider.web.website.e;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.web.website.a.c;
import com.xunlei.downloadprovider.web.website.b;
import com.xunlei.downloadprovider.web.website.d.h;
import com.xunlei.downloadprovider.web.website.g.a;

/* compiled from: WebsiteCardItemViewHolder */
public class e extends ViewHolder {
    public View a;
    public RelativeLayout b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public View h;
    public TextView i;
    public View j;
    public TextView k;
    public int l;
    public Context m;
    public b n;
    public com.xunlei.downloadprovider.web.website.b.e o;
    private c p;

    public e(View view) {
        super(view);
    }

    public e(Context context, View view, c cVar) {
        super(view);
        this.m = context;
        this.p = cVar;
        this.a = view.findViewById(R.id.collection_card_interval);
        this.b = (RelativeLayout) view.findViewById(R.id.rl_search_website_card_list_item_layout);
        this.c = view.findViewById(R.id.title_container);
        this.d = (TextView) view.findViewById(R.id.tv_card_title);
        this.h = view.findViewById(R.id.ll_history_website_card_data);
        this.i = (TextView) view.findViewById(R.id.tv_history_website_card_data_title);
        this.g = (ImageView) view.findViewById(R.id.website_icon);
        this.e = (TextView) view.findViewById(R.id.tv_search_website_card_list_item_title);
        this.f = (TextView) view.findViewById(R.id.tv_search_website_card_list_item_url);
        this.j = view.findViewById(R.id.card_space);
        this.k = (TextView) view.findViewById(R.id.collect_update_red_point);
    }

    public final void a(com.xunlei.downloadprovider.web.website.b.e eVar) {
        if (this.l == 1002) {
            com.xunlei.downloadprovider.web.website.g.b.a();
            if (com.xunlei.downloadprovider.web.website.g.b.e()) {
                com.xunlei.downloadprovider.web.website.g.b.a();
                if (!com.xunlei.downloadprovider.web.website.g.b.b(eVar.a())) {
                    com.xunlei.downloadprovider.web.website.b.b bVar = a.a().b;
                    if (bVar != null) {
                        for (com.xunlei.downloadprovider.web.website.b.a aVar : bVar.d) {
                            if (eVar.a().equals(aVar.d)) {
                                eVar = aVar.a;
                                this.k.setVisibility(0);
                                a(true);
                                if (eVar >= 100) {
                                    this.k.setText("99+");
                                } else {
                                    this.k.setText(String.valueOf(eVar));
                                }
                                if (f.b(this.m, "collect_update_ppw") == null && this.p.i != null) {
                                    try {
                                        eVar = LayoutInflater.from(this.m).inflate(R.layout.layout_popupwindow, null);
                                        TextView textView = (TextView) eVar.findViewById(R.id.tv_comment);
                                        textView.setText(R.string.collect_update_ppw_text);
                                        textView.setBackgroundResource(R.drawable.collect_update_ppw_bg_blue);
                                        PopupWindow popupWindow = new PopupWindow(eVar, -2, -2);
                                        eVar.measure(1073741824, 1073741824);
                                        popupWindow.setFocusable(true);
                                        popupWindow.setTouchable(true);
                                        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                                        popupWindow.setOutsideTouchable(true);
                                        popupWindow.update();
                                        popupWindow.showAsDropDown(this.k);
                                        f.a(this.m, "collect_update_ppw", true);
                                        return;
                                    } catch (com.xunlei.downloadprovider.web.website.b.e eVar2) {
                                        eVar2.printStackTrace();
                                    }
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        if (z) {
            layoutParams.setMargins(0, DipPixelUtil.dip2px(1.0f), DipPixelUtil.dip2px(25.0f), 0);
        } else {
            layoutParams.setMargins(0, DipPixelUtil.dip2px(1.0f), 0, 0);
        }
        this.f.setLayoutParams(layoutParams);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setVisibility(0);
            this.d.setText(str);
        }
    }

    public final void a() {
        this.a.setVisibility(0);
    }

    static /* synthetic */ void a(e eVar, com.xunlei.downloadprovider.web.website.b.e eVar2, String str) {
        h hVar = new h(eVar.m, new h(eVar));
        eVar = eVar.l;
        hVar.b = str;
        hVar.c = eVar;
        if (hVar.b == "collect") {
            hVar.a();
        }
        hVar.a = eVar2;
        hVar.show();
    }
}
