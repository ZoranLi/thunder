package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: VideoFeedViewHolder */
public final class t extends f implements c {
    private int a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private m g;
    private BaseVideoInfo h;
    private VideoUserInfo i;
    private e j;

    public final int a() {
        return 2;
    }

    public static t a(Context context, int i, ViewGroup viewGroup, a aVar) {
        context = LayoutInflater.from(context);
        int i2 = i == 306 ? R.layout.layout_task_list_feed_template_short_video_large_poster : com.xunlei.downloadprovider.download.tasklist.list.feed.f.b() ? R.layout.layout_task_list_feed_template_short_video_poster_left : R.layout.layout_task_list_feed_template_short_video_poster_right;
        viewGroup = new t(context.inflate(i2, viewGroup, false), i);
        viewGroup.setAdapter(aVar);
        return viewGroup;
    }

    private t(View view, int i) {
        super(view);
        this.a = i;
        this.b = (TextView) view.findViewById(R.id.tv_title);
        this.d = (ImageView) view.findViewById(R.id.iv_poster);
        this.c = (TextView) view.findViewById(R.id.tv_duration);
        this.f = (TextView) view.findViewById(R.id.tv_publisher_name);
        this.e = (TextView) view.findViewById(R.id.tv_comment_count);
        view.setOnClickListener(new u(this));
    }

    public final void fillData(e eVar) {
        this.j = eVar;
        this.g = (m) eVar.c;
        this.h = this.g.b;
        this.i = this.g.a;
        if (TextUtils.isEmpty(this.h.getTitle()) == null) {
            this.b.setText(this.h.getTitle());
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        b.a().a(this.h.getCoverUrl(), this.d, null);
        this.c.setText(j.a(this.h.getDuration()));
        this.f.setText(this.i.getNickname());
        eVar = new StringBuilder();
        eVar.append(j.a((long) this.h.getCommentCount()));
        eVar.append("评论");
        this.e.setText(eVar.toString());
    }

    static /* synthetic */ void f(t tVar) {
        From from;
        ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
        int a = tVar.mAdapter.a();
        if (!com.xunlei.downloadprovider.download.b.b.c()) {
            switch (a) {
                case 0:
                    from = From.DOWNLOAD_CENTER_ALL;
                    break;
                case 1:
                    from = From.DOWNLOAD_CENTER_DOWNLOADING;
                    break;
                case 2:
                    from = From.DOWNLOAD_CENTER_COMPLETE;
                    break;
                default:
                    from = From.DOWNLOAD_CENTER_ALL;
                    break;
            }
        }
        from = From.DOWNLOAD_CENTER_HOME;
        aVar.u = from;
        aVar.s = false;
        aVar.t = false;
        aVar.r = false;
        aVar.q = tVar.h.getServerExtData();
        aVar.a = tVar.h.getVideoId();
        aVar.b = tVar.h.getGcid();
        aVar.c = tVar.h.getTitle();
        aVar.d = tVar.h.getPlayUrl();
        aVar.e = tVar.h.getCoverUrl();
        aVar.f = tVar.h.getLikeCount();
        aVar.g = tVar.h.hasLike();
        aVar.l = tVar.i.getNickname();
        aVar.n = tVar.i.getPubExtra().a;
        aVar.v = tVar.h;
        aVar.w = tVar.i;
        ShortMovieDetailActivity.a(tVar.getContext(), aVar);
    }
}
