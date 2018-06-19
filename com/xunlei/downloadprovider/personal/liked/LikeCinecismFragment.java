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
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.homepage.recommend.a.b;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.bo;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.downloadprovider.shortvideo.videodetail.k;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.List;

public class LikeCinecismFragment extends Fragment implements g {
    bo a;
    private XRecyclerView b;
    private ErrorBlankView c;
    private boolean d = false;
    private int e = 0;
    private t f;
    private Handler g = new Handler();
    private boolean h = false;

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
        this.a.a();
    }

    public void onStop() {
        super.onStop();
        if (this.h) {
            q.b();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            this.h = true;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_like_short_video, viewGroup, false);
        this.c = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.c.setErrorType(0);
        this.c.a(null, null);
        this.b = (XRecyclerView) layoutInflater.findViewById(R.id.recycler_view_like_list);
        viewGroup = new k();
        viewGroup.a = true;
        this.b.setItemAnimator(viewGroup);
        this.b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.a = new bo(this, null, this.b);
        this.a.b = 2;
        this.b.setAdapter(this.a);
        this.b.setPullRefreshEnabled(false);
        this.b.setLoadingListener(new a(this));
        this.b.addOnScrollListener(new b(this));
        a();
        return layoutInflater;
    }

    final void a() {
        a(0);
        b(0);
    }

    private void a(int i) {
        b.a(i, new c(this, i));
    }

    private void b(int i) {
        this.e = i;
        if (this.d) {
            if (i == 1) {
                this.g.post(new f(this));
            }
            return;
        }
        if (i == 2) {
            this.d = true;
        }
        if (this.f != null) {
            this.f.b(i);
        }
    }

    public final void a(int i, Object obj) {
        if (i == 16) {
            d dVar = (d) obj;
            if (dVar != null) {
                CinecismDetailActivity.a(getContext(), "personal_zan_list", dVar.b, dVar.c, false);
                q.a("cinecism", dVar.b.a, "cinecism");
            }
        }
    }

    static /* synthetic */ void a(LikeCinecismFragment likeCinecismFragment) {
        if (likeCinecismFragment.e != 0) {
            if (likeCinecismFragment.a != null) {
                likeCinecismFragment.e = 0;
                likeCinecismFragment.a(((d) ((bp) likeCinecismFragment.a.a.get(likeCinecismFragment.a.getItemCount() - 1)).b).d);
            }
        }
    }

    static /* synthetic */ List a(LikeCinecismFragment likeCinecismFragment, List list) {
        if (list != null) {
            if (!list.isEmpty()) {
                int size = list.size();
                long j = 0;
                if (likeCinecismFragment.a.getItemCount() > 0) {
                    j = ((d) likeCinecismFragment.a.a(likeCinecismFragment.a.getItemCount() - 1).b).a;
                }
                likeCinecismFragment = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    d dVar = (d) list.get(i);
                    likeCinecismFragment.add(new bp(dVar, 4));
                    if (!DateUtil.isTheSameDay(j * 1000, 1000 * dVar.a)) {
                        dVar.e = true;
                    }
                    j = dVar.a;
                }
                return likeCinecismFragment;
            }
        }
        return null;
    }
}
