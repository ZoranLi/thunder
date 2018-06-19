package com.xunlei.downloadprovider.web.website.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.search.SearchOperateActivity;
import com.xunlei.downloadprovider.web.website.activity.BroserCollectionAndHistoryActivity;
import com.xunlei.downloadprovider.web.website.activity.DownloadTabWebsiteActivity;
import com.xunlei.downloadprovider.web.website.b;
import com.xunlei.downloadprovider.web.website.e.e;
import com.xunlei.downloadprovider.web.website.e.f;
import com.xunlei.downloadprovider.web.website.e.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebsiteCardItemViewAdapter */
public class c extends Adapter<e> {
    public int a = 1002;
    public Context b;
    public b c;
    public a<com.xunlei.downloadprovider.web.website.b.e> d = new a();
    public a e;
    public b f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* compiled from: WebsiteCardItemViewAdapter */
    private static class a<E> {
        final ArrayList<E> a;
        public final ArrayList<E> b;
        final ArrayList<E> c;

        private a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
        }

        public final int a() {
            return (this.a.size() + this.b.size()) + this.c.size();
        }
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        e eVar = (e) viewHolder;
        if (this.g && i == 0) {
            this.e.notifyDataSetChanged();
            return;
        }
        if (this.g) {
            i--;
        }
        if (!(this.h && i == this.d.a())) {
            a aVar = this.d;
            int a = aVar.a();
            if (i >= 0) {
                if (i < a) {
                    Object obj;
                    if (aVar.a.size() <= 0 || i >= aVar.a.size()) {
                        a = i - aVar.a.size();
                        if (aVar.b.size() <= 0 || a >= aVar.b.size()) {
                            obj = aVar.c.get(a - aVar.b.size());
                        } else {
                            obj = aVar.b.get(a);
                        }
                    } else {
                        obj = aVar.a.get(i);
                    }
                    com.xunlei.downloadprovider.web.website.b.e eVar2 = (com.xunlei.downloadprovider.web.website.b.e) obj;
                    a = this.a;
                    eVar.o = eVar2;
                    eVar.l = a;
                    int i2 = 8;
                    eVar.a.setVisibility(8);
                    eVar.c.setVisibility(8);
                    eVar.h.setVisibility(8);
                    eVar.k.setVisibility(8);
                    boolean z = false;
                    eVar.a(false);
                    CharSequence b = eVar2.b();
                    if (TextUtils.isEmpty(b)) {
                        b = eVar2.a().replace("http://", "");
                    }
                    if (!TextUtils.isEmpty(b)) {
                        eVar.e.setText(b);
                    }
                    eVar.f.setText(eVar2.a());
                    eVar.g.setImageResource(R.drawable.website_icon_default_square);
                    if (!TextUtils.isEmpty(eVar2.c())) {
                        Glide.with(eVar.m).load(eVar2.c()).asBitmap().dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESULT).error(R.drawable.website_icon_default_square).fallback(R.drawable.website_icon_default_square).placeholder(R.drawable.website_icon_default_square).centerCrop().into(eVar.g);
                    }
                    View view = eVar.h;
                    if (eVar2.i) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                    if (eVar2.i && !TextUtils.isEmpty(eVar2.h)) {
                        eVar.i.setText(eVar2.h);
                    }
                    eVar.a(eVar2);
                    String a2 = eVar2.a();
                    String str = eVar2.g;
                    eVar.b.setOnClickListener(new f(eVar, str, a2));
                    eVar.b.setOnLongClickListener(new g(eVar, eVar2, i, str));
                    if (this.a == 1002 || this.a == 1003) {
                        if (this.d.a.size() > 0 && i == 0) {
                            eVar.a(this.b.getResources().getString(R.string.collection));
                            if (!(this.b instanceof DownloadTabWebsiteActivity)) {
                                eVar.a();
                            }
                            if ((this.b instanceof DownloadTabWebsiteActivity) && this.g) {
                                eVar.a();
                            }
                        } else if (this.d.b.size() > 0 && i == this.d.a.size()) {
                            if (this.b instanceof SearchOperateActivity) {
                                eVar.a(this.b.getResources().getString(R.string.browser_history));
                            } else {
                                eVar.a(this.b.getResources().getString(R.string.download_history));
                            }
                            if (!(this.b instanceof BroserCollectionAndHistoryActivity)) {
                                eVar.a();
                            }
                        }
                    }
                    if ((this.d.a.size() > 0 && i == this.d.a.size() - 1) || (this.d.b.size() > 0 && i == (this.d.a.size() + this.d.b.size()) - 1)) {
                        z = true;
                    }
                    LayoutParams layoutParams = (LayoutParams) eVar.j.getLayoutParams();
                    if (z) {
                        layoutParams.height = 39;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.height = 30;
                        layoutParams.weight = 1.0f;
                    }
                    eVar.j.setLayoutParams(layoutParams);
                }
            }
            StringBuilder stringBuilder = new StringBuilder("size = ");
            stringBuilder.append(a);
            stringBuilder.append("index = ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public c(Context context, int i) {
        this.b = context;
        this.a = i;
    }

    public final void a(List<com.xunlei.downloadprovider.web.website.b.e> list) {
        a aVar = this.d;
        if (list != null) {
            aVar.a.clear();
            aVar.a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public e a(ViewGroup viewGroup, int i) {
        if (this.g && i == 1) {
            return this.e.a(viewGroup);
        }
        if (this.h && i == 2) {
            return b.a(viewGroup);
        }
        i = new e(this.b, LayoutInflater.from(this.b).inflate(R.layout.download_collection_card_list_item_layout, viewGroup, false), this);
        i.n = this.c;
        return i;
    }

    public int getItemCount() {
        if (this.g && this.h) {
            return this.d.a() + 2;
        }
        if (this.g && !this.h) {
            return this.d.a() + 1;
        }
        if (this.g || !this.h) {
            return this.d.a();
        }
        return this.d.a() + 1;
    }

    public int getItemViewType(int i) {
        if (!this.g && !this.h) {
            return 0;
        }
        if (!this.g || this.h) {
            if (!this.g && this.h && i == this.d.a()) {
                return this.f.getItemViewType(i);
            }
            if (!this.g || !this.h) {
                return 0;
            }
            if (i == 0) {
                return this.e.getItemViewType(i);
            }
            if (i == this.d.a() + 1) {
                return this.f.getItemViewType(i);
            }
            return 0;
        } else if (i == 0) {
            return this.e.getItemViewType(i);
        } else {
            return 0;
        }
    }
}
