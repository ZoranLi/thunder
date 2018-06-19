package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.feedvideo.FeedGDTVideoItemView;
import com.xunlei.downloadprovider.ad.feedvideo.h;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.a;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: FeedVideoAdapter */
public final class q extends a<y> {
    boolean c;
    private Context e;
    private ListView f;
    private com.xunlei.downloadprovider.homepage.a g;
    private com.xunlei.downloadprovider.player.a.a h;
    private int i = 0;
    private l j;
    private FeedGDTVideoItemView k;

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public q(Context context, ListView listView, com.xunlei.downloadprovider.homepage.a aVar, com.xunlei.downloadprovider.player.a.a aVar2) {
        super(context);
        this.e = context;
        this.f = listView;
        this.g = aVar;
        this.h = aVar2;
        this.i = d.a().b.a();
    }

    public final int getItemViewType(int i) {
        return ((y) getItem(i)).c() ? a(i) : 1;
    }

    private int a(int i) {
        y yVar = (y) getItem(i);
        if (!yVar.c()) {
            return 1;
        }
        com.xunlei.downloadprovider.ad.feedvideo.a b = com.xunlei.downloadprovider.ad.feedvideo.a.b();
        this.j = b.a != null ? (l) b.a.get(yVar.a.getVideoId()) : 0;
        if (this.j != 0) {
            if (this.j.F() == 0) {
                return 0;
            }
        }
        return 2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        super.getView(i, view, viewGroup);
        y yVar = (y) getItem(i);
        if (view == null) {
            view = getItemViewType(i);
            if (view == null) {
                view = new h(this.e, this.h);
                a(i, view, this.j, yVar, 0);
            } else if (view != 2) {
                if (this.i != 2) {
                    view = new z(this.e, this.g);
                } else {
                    view = new as(this.e, this.g, this.h);
                }
                a(i, view, yVar);
            } else {
                view = new FeedGDTVideoItemView(this.e, this.h);
                FeedGDTVideoItemView feedGDTVideoItemView = (FeedGDTVideoItemView) view;
                this.k = feedGDTVideoItemView;
                a(i, view, this.j, yVar, 2);
                com.xunlei.downloadprovider.ad.feedvideo.a.b().a(feedGDTVideoItemView);
            }
        } else {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                a(i, view, this.j, yVar, a(i));
            } else if (itemViewType != 2) {
                a(i, view, yVar);
            } else {
                a(i, view, this.j, yVar, a(i));
                com.xunlei.downloadprovider.ad.feedvideo.a.b().a((FeedGDTVideoItemView) view);
            }
        }
        view.setLayoutParams(new LayoutParams(-1, -2));
        return view;
    }

    private void a(int i, View view, l lVar, y yVar, int i2) {
        StringBuilder stringBuilder = new StringBuilder("i: ");
        stringBuilder.append(i);
        stringBuilder.append(" adViewType: ");
        stringBuilder.append(i2);
        stringBuilder.append(" view: ");
        stringBuilder.append(view);
        stringBuilder.append(" model: ");
        stringBuilder.append(lVar);
        stringBuilder.append(" feedVideoItemModel: ");
        stringBuilder.append(yVar);
        if (i2 != 2 || (view instanceof FeedGDTVideoItemView) == 0) {
            h hVar = (h) view;
            hVar.setTag(Integer.valueOf(i));
            if (lVar != null) {
                hVar.a(i, lVar, yVar);
            } else {
                a(yVar);
            }
            if (i == 0) {
                hVar.setIsFirstElement(true);
                return;
            } else {
                hVar.setIsFirstElement(false);
                return;
            }
        }
        FeedGDTVideoItemView feedGDTVideoItemView = (FeedGDTVideoItemView) view;
        feedGDTVideoItemView.setTag(Integer.valueOf(i));
        if (lVar != null) {
            feedGDTVideoItemView.a(i, lVar, yVar);
            if (i == 0) {
                feedGDTVideoItemView.setIsFirstElement(true);
                return;
            } else {
                feedGDTVideoItemView.setIsFirstElement(false);
                return;
            }
        }
        a(yVar);
    }

    private void a(int i, View view, y yVar) {
        z zVar = (z) view;
        zVar.setFeedVideoAdapter(this);
        zVar.setTag(Integer.valueOf(i));
        zVar.a(i, yVar);
        if (i == 0) {
            zVar.setIsFirstElement(1);
        } else {
            zVar.setIsFirstElement(0);
        }
        zVar.a();
    }

    public final void a(boolean z) {
        super.a(z);
        this.c = false;
        if (!z) {
            b(false);
        }
    }

    public final void c() {
        super.c();
        if (!this.c) {
            ak.a().c(PlayerTag.FEED);
        }
        VideoFeedReporter.a(this.i);
        VideoFeedReporter.b();
        if (this.k != null) {
            this.k.a();
        }
    }

    protected final void b() {
        b(true);
    }

    protected final void a(int i, boolean z) {
        super.a(i, z);
        y yVar = (y) getItem(i);
        if (yVar != null) {
            VideoFeedReporter.a(z, yVar, this.i);
        }
    }

    private void b(boolean z) {
        int firstVisiblePosition = this.f.getFirstVisiblePosition() - this.f.getHeaderViewsCount();
        int lastVisiblePosition = this.f.getLastVisiblePosition() - this.f.getHeaderViewsCount();
        int count = getCount();
        while (firstVisiblePosition <= lastVisiblePosition) {
            if (firstVisiblePosition >= 0 && firstVisiblePosition < count) {
                VideoFeedReporter.a(z, (y) getItem(firstVisiblePosition), this.i);
            }
            firstVisiblePosition++;
        }
    }

    public final void d() {
        this.b = System.currentTimeMillis();
    }

    private void a(y yVar) {
        this.f.postDelayed(new r(this, yVar), 100);
    }

    private void b(y yVar) {
        a.a().d.remove(yVar);
        a(a.a().d);
        notifyDataSetChanged();
    }
}
