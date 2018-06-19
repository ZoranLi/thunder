package com.xunlei.downloadprovider.homepage.photoarticle;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.homepage.photoarticle.b.b;
import com.xunlei.downloadprovider.homepage.photoarticle.b.d;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aa;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.k;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.m;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.n;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: PhotoArticleAdapter */
public final class a extends Adapter<aq> {
    List<aw> a = new ArrayList();
    List<aw> b = new LinkedList();
    aw c;
    aw d;
    aw e;
    aw f;
    b g;
    PhotoArticleInfo h;
    List<v> i;
    private Context j;
    private LayoutInflater k;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a l;
    private aw m;
    private aw n;
    private aw o;
    private com.xunlei.downloadprovider.homepage.photoarticle.b.b.a p;

    /* compiled from: PhotoArticleAdapter */
    private static class a extends Callback {
        private List<aw> a;
        private List<aw> b;

        a(List<aw> list, List<aw> list2) {
            this.a = list;
            this.b = list2;
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public final int getNewListSize() {
            return this.b.size();
        }

        public final boolean areItemsTheSame(int i, int i2) {
            return ((aw) this.a.get(i)) == ((aw) this.b.get(i2));
        }

        public final boolean areContentsTheSame(int i, int i2) {
            aw awVar = (aw) this.a.get(i);
            aw awVar2 = (aw) this.b.get(i2);
            return awVar.b == awVar2.b && awVar.c == awVar2.c && awVar.a == awVar2.a;
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((aq) viewHolder).a(a(i));
    }

    public final /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        super.onViewAttachedToWindow((aq) viewHolder);
        aq.b();
    }

    public final /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        super.onViewDetachedFromWindow((aq) viewHolder);
        aq.c();
    }

    a(Context context, com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a aVar, com.xunlei.downloadprovider.homepage.photoarticle.b.b.a aVar2) {
        this.j = context;
        this.k = LayoutInflater.from(context);
        this.l = aVar;
        this.p = aVar2;
    }

    private aw a(int i) {
        return (aw) this.a.get(i);
    }

    public final int getItemViewType(int i) {
        return a(i).a;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void a(boolean z) {
        List list = this.a;
        List arrayList = new ArrayList();
        arrayList.add(this.c);
        arrayList.add(this.d);
        arrayList.add(this.f);
        if (z) {
            if (!this.n) {
                this.n = new aw(4);
            }
            arrayList.add(this.n);
        } else {
            if (!this.o) {
                this.o = new aw(2, "最新评论");
            }
            arrayList.add(this.o);
            if (this.b.isEmpty()) {
                z = true;
            } else {
                arrayList.addAll(this.b);
                z = false;
            }
            if (z) {
                if (this.e) {
                    arrayList.add(this.e);
                } else {
                    if (!this.m) {
                        this.m = new aw(5);
                    }
                    arrayList.add(this.m);
                }
            }
        }
        z = DiffUtil.calculateDiff(new a(list, arrayList), true);
        list.clear();
        this.a = arrayList;
        z.dispatchUpdatesTo(this);
    }

    public final int a() {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (this.o == a(i)) {
                return i;
            }
        }
        return -1;
    }

    public final int b() {
        return this.b.size();
    }

    public final void a(f fVar) {
        if (fVar != null) {
            f<CommentInfo> fVar2 = fVar.e;
            if (fVar2 != null && fVar2.size() > 0) {
                for (CommentInfo awVar : fVar2) {
                    this.b.add(new aw(3, awVar));
                }
            }
            this.e = null;
        }
        a((boolean) null);
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 2:
                return new m(this.k.inflate(R.layout.comment_header, viewGroup, false));
            case 3:
                return new n(this.k.inflate(R.layout.comment_item_layout, viewGroup, false), this.l);
            case 4:
                return new aa(this.k.inflate(R.layout.comment_loading_layout, viewGroup, false));
            case 5:
                return new i(this.k.inflate(R.layout.comment_empty_layout, viewGroup, false), null);
            case 6:
                return new k(this.k.inflate(R.layout.comment_error_layout, viewGroup, false), this.l);
            case 7:
                ViewHolder bVar = new b(this.k.inflate(R.layout.article_webview, null));
                this.g = bVar;
                ((b) bVar).c = this.p;
                return bVar;
            case 8:
                return new com.xunlei.downloadprovider.homepage.photoarticle.b.a(this.k.inflate(R.layout.article_detail_title_view, viewGroup, false));
            case 9:
                return new d(this.k.inflate(R.layout.article_like_layout, viewGroup, false));
            default:
                return null;
        }
    }
}
