package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.download.taskdetails.b.x;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.util.j;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: DownloadDetailsActivityFragment */
final class al extends OnScrollListener {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    al(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.a.b(false, false);
        recyclerView = this.a.v;
        i2 = this.a.d;
        if (recyclerView.a.getScrollState() != 2) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.a.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int d = findFirstVisibleItemPosition - i2.d();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int d2 = findLastVisibleItemPosition - i2.d();
            StringBuilder stringBuilder = new StringBuilder("reportCommentShow. firstPosition: ");
            stringBuilder.append(findFirstVisibleItemPosition);
            stringBuilder.append(" firstCommentPosition: ");
            stringBuilder.append(d);
            stringBuilder.append(" lastPosition: ");
            stringBuilder.append(findLastVisibleItemPosition);
            stringBuilder.append(" lastCommentPosition: ");
            stringBuilder.append(d2);
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                if (findFirstVisibleItemPosition >= 0) {
                    a a = i2.a(findFirstVisibleItemPosition);
                    if (a != null && (a.c instanceof aw)) {
                        aw awVar = (aw) a.c;
                        if (awVar.a == 17 && (awVar.b instanceof CommentInfo)) {
                            new StringBuilder("tryShowCommentId: ").append(((CommentInfo) awVar.b).getId());
                            x xVar = recyclerView.d;
                            CommentInfo commentInfo = (CommentInfo) awVar.b;
                            new StringBuilder("tryShow. commentInfo.id: ").append(commentInfo.getId());
                            if (!xVar.b.contains(commentInfo)) {
                                new StringBuilder("tryShow. addShowList. commentInfo.id: ").append(commentInfo.getId());
                                xVar.b.add(commentInfo);
                                xVar.a.add(commentInfo);
                                if (xVar.a.size() >= 8) {
                                    xVar.b();
                                }
                            }
                        }
                    }
                }
                findFirstVisibleItemPosition++;
            }
        }
        j.a().a = true;
        j.a().b = System.currentTimeMillis();
    }
}
