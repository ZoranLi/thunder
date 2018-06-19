package com.xunlei.downloadprovider.web.website.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.DownloadCenterTabBaseFragment;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.website.a.c;
import com.xunlei.downloadprovider.web.website.activity.DownloadTabWebsiteActivity;
import com.xunlei.downloadprovider.web.website.b;
import com.xunlei.downloadprovider.web.website.g.j$a;
import com.xunlei.downloadprovider.web.website.view.CollectionUserSyncTipView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;

public class CollectionAndHistoryFragment extends DownloadCenterTabBaseFragment {
    public boolean a;
    public boolean b;
    private int c = 1002;
    private CollectionUserSyncTipView d;
    private ErrorBlankView e;
    private RecyclerView f;
    private c g;
    private boolean h;
    private boolean i = false;
    private a j = new a();
    private boolean k;
    private OnClickListener l = new a(this);
    private com.xunlei.downloadprovider.member.login.b.c m = new b(this);
    private j$a n = new c(this);
    private b o = new d(this);
    private OnClickListener p = new e(this);
    private MessageListener q = new h(this);
    private StaticHandler r = new StaticHandler(this.q);

    private class a extends BroadcastReceiver {
        final /* synthetic */ CollectionAndHistoryFragment a;

        private a(CollectionAndHistoryFragment collectionAndHistoryFragment) {
            this.a = collectionAndHistoryFragment;
        }

        public final void onReceive(Context context, Intent intent) {
            context = intent.getAction();
            if (context != null && "com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment".equals(context) != null) {
                this.a.c();
            }
        }
    }

    public final void b() {
    }

    public static CollectionAndHistoryFragment a(int i) {
        CollectionAndHistoryFragment collectionAndHistoryFragment = new CollectionAndHistoryFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt("page_type", i);
        collectionAndHistoryFragment.setArguments(bundle);
        return collectionAndHistoryFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.c = getArguments().getInt("page_type");
        }
        this.g = new c(getContext(), this.c);
        this.g.c = this.o;
        if ((getActivity() instanceof DownloadTabWebsiteActivity) != null) {
            this.g.i = true;
        }
        if (this.k != null) {
            this.g.i = true;
        }
        if (this.i == null && getContext() != null) {
            this.i = true;
            bundle = new IntentFilter();
            bundle.addAction("com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment");
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.j, bundle);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        bundle = null;
        layoutInflater = layoutInflater.inflate(R.layout.collection_and_history_fragment, viewGroup, false);
        this.f = (RecyclerView) layoutInflater.findViewById(R.id.website_recycler_view);
        this.f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f.setAdapter(this.g);
        this.e = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.d = (CollectionUserSyncTipView) layoutInflater.findViewById(R.id.cloud_sync_page);
        this.e.a("刷新", this.p);
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        this.d.setSyncClickListener(this.l);
        if (this.c == 1002) {
            com.xunlei.downloadprovider.web.website.g.b.a();
            if (com.xunlei.downloadprovider.web.website.g.a.a().a != null && com.xunlei.downloadprovider.web.website.g.b.g() == null) {
                bundle = 1;
            }
            if (bundle != null) {
                viewGroup = this.g;
                viewGroup.e = new com.xunlei.downloadprovider.web.website.a.a(viewGroup);
                viewGroup.g = true;
            }
        }
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        com.xunlei.downloadprovider.web.website.a a = com.xunlei.downloadprovider.web.website.a.a();
        OnClickListener onClickListener = this.l;
        if (a.a != null) {
            a.a.setSyncClickListener(onClickListener);
        }
        c();
    }

    public final void c() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new f(this));
        }
        this.h = false;
        XLThreadPool.execute(new g(this));
    }

    private void d() {
        LoginHelper.a();
        boolean c = l.c();
        int i = 1;
        if (this.h) {
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            a(c ^ true);
            return;
        }
        a(false);
        if (c) {
            LoginHelper.a();
            if (l.b()) {
                if (i != 0) {
                    if (this.d != null) {
                        this.d.setVisibility(0);
                    }
                    if (this.e != null) {
                        this.e.setVisibility(8);
                    }
                }
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(0);
                    this.e.setErrorType(0);
                    this.e.getActionButton().setVisibility(8);
                }
            }
        }
        i = 0;
        if (i != 0) {
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e != null) {
                this.e.setVisibility(0);
                this.e.setErrorType(0);
                this.e.getActionButton().setVisibility(8);
            }
        } else {
            if (this.d != null) {
                this.d.setVisibility(0);
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            z = com.xunlei.downloadprovider.web.website.a.a();
            if (z.a != null && z.b) {
                z.a.setVisibility(0);
            }
            if (this.g) {
                z = this.g;
                z.f = new com.xunlei.downloadprovider.web.website.a.b(z.b, z.a);
                z.h = true;
                this.g.notifyDataSetChanged();
                return;
            }
        }
        com.xunlei.downloadprovider.web.website.a.a().b();
        if (this.g) {
            this.g.h = false;
            this.g.notifyDataSetChanged();
        }
    }

    public final void a() {
        h.e();
        TaskCountsStatistics c = h.c();
        String str = "";
        if (this.a && this.b) {
            str = "collect_his";
        } else if (this.a && !this.b) {
            str = "collect";
        } else if (!this.a && this.b) {
            str = "his";
        }
        com.xunlei.downloadprovider.download.report.a.a("collect", c.getFinishedTaskCount(), 0, str);
        com.xunlei.downloadprovider.web.website.a.a().b = true;
        d();
        if (!this.k) {
            this.k = true;
            if (this.g != null) {
                this.g.i = true;
                this.g.notifyDataSetChanged();
            }
        }
    }

    public void onDestroy() {
        if (this.r != null) {
            this.r.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
        if (getContext() != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.j);
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
    }

    static /* synthetic */ void f(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        Context context = collectionAndHistoryFragment.getContext();
        Object<com.xunlei.downloadprovider.web.website.b.c> a = com.xunlei.downloadprovider.web.website.c.a.a();
        Object arrayList = new ArrayList();
        if (!d.a(a)) {
            if (context != null) {
                for (com.xunlei.downloadprovider.web.website.b.c cVar : a) {
                    cVar.g = "collect";
                    arrayList.add(cVar);
                }
                arrayList = com.xunlei.downloadprovider.web.website.c.a(context, (List) arrayList);
            }
        }
        collectionAndHistoryFragment.r.obtainMessage(1, arrayList).sendToTarget();
    }

    static /* synthetic */ void g(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        if (collectionAndHistoryFragment.getContext() != null && collectionAndHistoryFragment.g != null) {
            Context context = collectionAndHistoryFragment.getContext();
            Object obj = collectionAndHistoryFragment.c == 1002 ? 1 : null;
            Object<com.xunlei.downloadprovider.web.website.b.d> b = com.xunlei.downloadprovider.web.website.c.b.b();
            Object arrayList = new ArrayList();
            if (!d.a(b)) {
                if (context != null) {
                    for (com.xunlei.downloadprovider.web.website.b.d dVar : b) {
                        dVar.g = "history";
                        if (obj == null || dVar.e != 1) {
                            if (obj == null && arrayList.size() < 500) {
                                arrayList.add(dVar);
                            }
                        } else if (arrayList.size() < 500) {
                            arrayList.add(dVar);
                        }
                    }
                    arrayList = com.xunlei.downloadprovider.web.website.c.a(context, (List) arrayList);
                }
            }
            collectionAndHistoryFragment.r.obtainMessage(2, arrayList).sendToTarget();
        }
    }
}
