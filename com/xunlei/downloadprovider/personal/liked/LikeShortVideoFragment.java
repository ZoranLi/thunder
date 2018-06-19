package com.xunlei.downloadprovider.personal.liked;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.a.b;
import com.xunlei.downloadprovider.homepage.recommend.a.w;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.bo;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.List;

public class LikeShortVideoFragment extends Fragment implements g {
    private XRecyclerView a;
    private bo b;
    private ErrorBlankView c;
    private boolean d = false;
    private int e = 0;
    private t f;
    private Handler g = new Handler();

    public final void a(String str) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof t) {
            this.f = (t) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement LikedDataLoadListener");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.f = null;
    }

    public void onStart() {
        super.onStart();
        this.b.a();
    }

    public void onStop() {
        super.onStop();
        q.a();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_like_short_video, viewGroup, false);
        this.c = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.c.setErrorType(0);
        this.c.a(null, null);
        this.a = (XRecyclerView) layoutInflater.findViewById(R.id.recycler_view_like_list);
        this.a.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.b = new bo(this, null, this.a);
        this.b.b = 2;
        this.a.setAdapter(this.b);
        this.a.setPullRefreshEnabled(false);
        this.a.setLoadingListener(new k(this));
        this.a.addOnScrollListener(new l(this));
        a();
        return layoutInflater;
    }

    final void a() {
        b(null);
        a(0);
    }

    private void b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        b.a(stringBuilder.toString(), str, new m(this, str), new p(this));
    }

    private void a(int i) {
        this.e = i;
        if (this.d) {
            if (i == 1) {
                this.g.post(new q(this));
            }
            return;
        }
        if (i == 2) {
            this.d = true;
        }
        if (this.f != null) {
            this.f.a(i);
        }
    }

    public final void a(int i, Object obj) {
        if (i == 6) {
            w wVar = (w) obj;
            if (wVar != null) {
                q.a("video", wVar.b, "shortvideo");
                a aVar = new a();
                aVar.j = wVar.h;
                aVar.l = wVar.g;
                aVar.u = From.PER_ZAN_LIST;
                aVar.a = wVar.b;
                aVar.b = wVar.a;
                aVar.c = wVar.c;
                aVar.d = wVar.d;
                aVar.e = wVar.e;
                aVar.f = (int) wVar.k;
                ShortMovieDetailActivity.a(getContext(), aVar);
            }
        }
    }

    static /* synthetic */ void a(LikeShortVideoFragment likeShortVideoFragment) {
        if (likeShortVideoFragment.e != 0) {
            likeShortVideoFragment.e = 0;
            likeShortVideoFragment.b(((w) likeShortVideoFragment.b.a(likeShortVideoFragment.b.getItemCount() - 1).b).l);
        }
    }

    static /* synthetic */ List a(LikeShortVideoFragment likeShortVideoFragment, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                int size = list.size();
                long j = 0;
                if (likeShortVideoFragment.b.getItemCount() > 0) {
                    j = ((w) likeShortVideoFragment.b.a(likeShortVideoFragment.b.getItemCount() - 1).b).m;
                }
                likeShortVideoFragment = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    w wVar = (w) list.get(i);
                    likeShortVideoFragment.add(new bp(wVar, 3));
                    if (!DateUtil.isTheSameDay(j * 1000, 1000 * wVar.m)) {
                        wVar.n = true;
                    }
                    j = wVar.m;
                }
                return likeShortVideoFragment;
            }
        }
        return null;
    }
}
