package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.view.o;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailFragment;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShortMovieDetailMultiTypeAdapter */
public final class ap extends Adapter<aq> {
    protected final LayoutInflater a;
    protected List<aw> b;
    protected a c;
    public long d = -1;
    private ShortMovieDetailFragment e;

    /* compiled from: ShortMovieDetailMultiTypeAdapter */
    public interface a {
        void a(View view, int i, Object obj);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        aq aqVar = (aq) viewHolder;
        aw awVar = (aw) this.b.get(i);
        if (awVar == null) {
            throw new IllegalArgumentException("itemData may not be null");
        }
        aqVar.a(awVar);
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public ap(Context context, Fragment fragment) {
        this.a = LayoutInflater.from(context);
        if (fragment != null) {
            if ((fragment instanceof a) != null) {
                this.c = (a) fragment;
            }
            if ((fragment instanceof ShortMovieDetailFragment) != null) {
                this.e = (ShortMovieDetailFragment) fragment;
            }
        }
    }

    public final aq a(ViewGroup viewGroup, int i) {
        View view = null;
        if (i != 180) {
            switch (i) {
                case 0:
                    viewGroup = c.a(this.a, viewGroup, this.c);
                    break;
                case 1:
                    view = this.a.inflate(R.layout.comment_header2, null);
                    viewGroup = new m(view);
                    break;
                case 2:
                    view = this.a.inflate(R.layout.comment_item_layout, null);
                    viewGroup = new n(view, this.c);
                    break;
                default:
                    switch (i) {
                        case 4:
                            view = this.a.inflate(R.layout.comment_empty_layout, null);
                            viewGroup = new i(view, this.c);
                            break;
                        case 5:
                            view = this.a.inflate(R.layout.comment_error_layout, null);
                            viewGroup = new k(view, this.c);
                            break;
                        default:
                            switch (i) {
                                case 9:
                                    view = this.a.inflate(R.layout.common_pull_up_refresh_item, null);
                                    view.setBackgroundColor(Color.parseColor("#ffffff"));
                                    viewGroup = new ac(view);
                                    break;
                                case 10:
                                    view = this.a.inflate(R.layout.comment_header, null);
                                    viewGroup = new m(view);
                                    break;
                                case 11:
                                    view = this.a.inflate(R.layout.comment_loading_layout, null);
                                    viewGroup = new aa(view);
                                    break;
                                case 12:
                                    view = this.a.inflate(R.layout.layout_ad_base_info, null);
                                    viewGroup = new com.xunlei.downloadprovider.ad.d.a(view, this.c);
                                    break;
                                default:
                                    switch (i) {
                                        case 16:
                                            view = this.a.inflate(R.layout.refreshable_comment_empty_layout, null);
                                            viewGroup = new am(view, this.c);
                                            break;
                                        case 17:
                                            if (b.e() == null) {
                                                view = this.a.inflate(R.layout.task_comment_item_layout, null);
                                                viewGroup = new ar(view, this, this.c);
                                                break;
                                            }
                                            view = this.a.inflate(R.layout.task_comment_item_layout_new, null);
                                            viewGroup = new be(view, this, this.c);
                                            break;
                                        case 18:
                                            view = this.a.inflate(R.layout.layout_website_info, null);
                                            viewGroup = new o(view, this.c);
                                            break;
                                        default:
                                            switch (i) {
                                                case 182:
                                                    view = this.a.inflate(R.layout.recommend_video_item_layout, null);
                                                    viewGroup = new ah(view, this.c);
                                                    break;
                                                case 183:
                                                    view = this.a.inflate(R.layout.recommend_footer, null);
                                                    viewGroup = new ae(view, this.c);
                                                    break;
                                                case 184:
                                                    view = this.a.inflate(R.layout.recommend_loading_item_layout, null);
                                                    viewGroup = new aj(view);
                                                    break;
                                                case Opcodes.SHR_INT_2ADDR /*185*/:
                                                    view = this.a.inflate(R.layout.short_movie_detail_recommend_effect_ad, null);
                                                    viewGroup = new ab(view, this.c);
                                                    break;
                                                case Opcodes.USHR_INT_2ADDR /*186*/:
                                                    view = this.a.inflate(R.layout.recommend_website_item_layout, null);
                                                    viewGroup = new ak(view);
                                                    break;
                                                default:
                                                    viewGroup = null;
                                                    break;
                                            }
                                    }
                            }
                    }
            }
        }
        view = this.a.inflate(R.layout.recommend_header, null);
        viewGroup = new f(view, this.c);
        if (view != null) {
            view.setLayoutParams(new LayoutParams(-1, -2));
        }
        return viewGroup;
    }

    public final int getItemCount() {
        return this.b != null ? this.b.size() : 0;
    }

    public final int getItemViewType(int i) {
        return i < getItemCount() ? ((aw) this.b.get(i)).a : -1;
    }

    public final aw a(int i) {
        if (i >= 0) {
            if (i < getItemCount()) {
                return (aw) this.b.get(i);
            }
        }
        return 0;
    }

    public final void a(int i, List<aw> list) {
        if (list != null) {
            if (list.size() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                this.b.addAll(i, list);
                notifyItemRangeInserted(i, list.size());
            }
        }
    }

    public final void a(List<aw> list) {
        if (list != null) {
            if (list.size() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                int size = list.size();
                int b = b();
                int c = c();
                if (b < 0) {
                    b = Integer.MAX_VALUE;
                }
                if (c < 0) {
                    c = Integer.MAX_VALUE;
                }
                b = Math.min(b, c);
                for (c = 0; c < size; c++) {
                    int i = c + 2;
                    if (i >= this.b.size() || i >= b) {
                        b++;
                        this.b.add(i, list.get(c));
                    } else {
                        this.b.set(i, list.get(c));
                    }
                }
                notifyItemRangeChanged(2, size);
            }
        }
    }

    public final void b(List<aw> list) {
        if (list != null) {
            if (list.size() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                this.b.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, aw awVar) {
        if (awVar != null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (i >= this.b.size()) {
                this.b.add(awVar);
                notifyItemInserted(this.b.size());
                return;
            }
            this.b.add(i, awVar);
            notifyItemInserted(i);
        }
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(awVar);
            notifyItemInserted(this.b.size() - 1);
        }
    }

    public final void b(int i, aw awVar) {
        if (!(this.b == null || awVar == null)) {
            if (i < this.b.size()) {
                this.b.set(i, awVar);
                notifyItemChanged(i);
            }
        }
    }

    public final void b(aw awVar) {
        if (this.b != null) {
            if (awVar != null) {
                int i = -1;
                int itemCount = getItemCount();
                for (int i2 = 0; i2 < itemCount; i2++) {
                    if (((aw) this.b.get(i2)) == awVar) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    notifyItemChanged(i);
                }
            }
        }
    }

    public final void c(List<aw> list) {
        if (list != null) {
            if (list.size() != 0) {
                if (this.b != null) {
                    if (this.b.size() != 0) {
                        int size = list.size();
                        int i = 0;
                        aw awVar = (aw) list.get(0);
                        int i2 = -1;
                        for (int i3 = 0; i3 < this.b.size(); i3++) {
                            if (this.b.get(i3) == awVar) {
                                i2 = i3;
                                break;
                            }
                        }
                        if (i2 >= 0) {
                            while (i < size) {
                                this.b.remove(i2);
                                i++;
                            }
                            notifyItemRangeRemoved(i2, size);
                        }
                    }
                }
            }
        }
    }

    public final void c(aw awVar) {
        if (this.b != null) {
            if (this.b.size() != 0) {
                int i = -1;
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    if (this.b.get(i2) == awVar) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0 && this.b != null) {
                    if (i <= this.b.size() - 1) {
                        this.b.remove(i);
                        notifyItemRemoved(i);
                    }
                }
            }
        }
    }

    public final void a() {
        if (this.b != null) {
            if (this.b.size() != 0) {
                int i = -1;
                int i2 = 0;
                for (int i3 = 0; i3 < this.b.size(); i3++) {
                    if (((aw) this.b.get(i3)).a == 184) {
                        i = i3;
                        break;
                    }
                }
                if (i >= 0) {
                    do {
                        i2++;
                        this.b.remove(i);
                        if (i >= this.b.size()) {
                            break;
                        }
                    } while (((aw) this.b.get(i)).a == 184);
                    notifyItemRangeRemoved(i, i2);
                }
            }
        }
    }

    public final int b() {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (((aw) this.b.get(i)).c == "new") {
                return i;
            }
        }
        return -1;
    }

    public final int c() {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (((aw) this.b.get(i)).c == "hot") {
                return i;
            }
        }
        return -1;
    }

    public final int d() {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (((aw) this.b.get(i)).a == 180) {
                return i;
            }
        }
        return -1;
    }

    public final boolean a(int i, int i2) {
        while (i <= i2) {
            if (i < this.b.size() && i >= 0 && ((aw) this.b.get(i)).a == 0) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final int d(aw awVar) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (((aw) this.b.get(i)).equals(awVar)) {
                return i;
            }
        }
        return -1;
    }

    public final void a(a aVar) {
        this.c = aVar;
    }

    public final void e() {
        if (this.b != null) {
            if (!this.b.isEmpty()) {
                this.b.clear();
                notifyDataSetChanged();
            }
        }
    }
}
