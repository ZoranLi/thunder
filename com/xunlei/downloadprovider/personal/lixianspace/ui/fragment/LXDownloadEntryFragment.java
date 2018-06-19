package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.frame.BaseCacheViewFragment;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.h;
import com.xunlei.downloadprovider.member.payment.external.i;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.downloadprovider.personal.lixianspace.ui.c.c;
import com.xunlei.downloadprovider.personal.lixianspace.ui.c.k;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.xllib.b.d;
import java.util.List;

public class LXDownloadEntryFragment extends BaseCacheViewFragment {
    private View a;
    private View b;
    private View c;
    private View d;
    private XRecyclerView e;
    private com.xunlei.downloadprovider.personal.lixianspace.ui.b.a f;
    private UnifiedLoadingView g;
    private View h;
    private TextView i;
    private TextView j;
    private ProgressBar k;
    private i l = new a(this);
    private a m;
    private OnClickListener n = new f(this);
    private c o;
    private int p = 0;
    private b q = new g(this);
    private k r;
    private com.xunlei.downloadprovider.personal.lixianspace.ui.c.k.a s = new h(this);
    private XLWaitingDialog t;
    private com.xunlei.downloadprovider.personal.lixianspace.ui.c.i u;
    private com.xunlei.downloadprovider.personal.lixianspace.ui.c.i.a v = new i(this);

    public interface a {
        void a();

        void b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a().addObserver(this.l);
        a.a.a(this.q);
    }

    public void onDestroy() {
        h.a().deleteObserver(this.l);
        a.a.b(this.q);
        VolleyRequestManager.getRequestQueue().a("lx_tag:default");
        com.xunlei.downloadprovider.personal.lixianspace.business.c.a.a();
        if (this.r != null) {
            this.r.dismiss();
        }
        d();
        if (this.u != null) {
            this.u.dismiss();
        }
        if (this.o != null) {
            this.o.dismiss();
        }
        super.onDestroy();
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.lx_space_entry_fragment, viewGroup, false);
        this.a = layoutInflater;
        return layoutInflater;
    }

    private void a() {
        if (this.c != null) {
            if (this.d == null) {
                this.d = ((ViewStub) this.c.findViewById(R.id.lx_space_create_task_vs)).inflate();
                this.d.findViewById(R.id.lx_space_create_task_btn).setOnClickListener(new d(this));
            }
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        b();
        m.a().b = true;
    }

    public static LXDownloadEntryFragment a(a aVar) {
        LXDownloadEntryFragment lXDownloadEntryFragment = new LXDownloadEntryFragment();
        lXDownloadEntryFragment.m = aVar;
        return lXDownloadEntryFragment;
    }

    private void b() {
        if (j.a().a.l()) {
            if (this.c == null) {
                this.c = ((ViewStub) this.a.findViewById(R.id.lx_space_download_entry_vs)).inflate();
                this.g = (UnifiedLoadingView) this.c.findViewById(R.id.lx_space_loading_view);
                this.i = (TextView) this.c.findViewById(R.id.lx_space_used_count_tv);
                this.j = (TextView) this.c.findViewById(R.id.lx_space_total_count_tv);
                this.k = (ProgressBar) this.c.findViewById(R.id.lx_space_used_pb);
                this.h = this.c.findViewById(R.id.lx_space_expansion_layout);
                this.c.findViewById(R.id.lx_space_expansion_btn).setOnClickListener(this.n);
                this.h.setOnClickListener(this.n);
                this.h.setVisibility(8);
                this.e = (XRecyclerView) this.c.findViewById(R.id.lx_space_task_list_rv);
                this.e.setPullRefreshEnabled(true);
                this.e.setLoadingMoreEnabled(true);
                this.e.setLoadingListener(new b(this));
                this.e.setLayoutManager(new LinearLayoutManager(getActivity()));
                this.f = new com.xunlei.downloadprovider.personal.lixianspace.ui.b.a(getActivity());
                this.f.f = new c(this);
                this.f.setHasStableIds(false);
                this.e.setItemAnimator(null);
                this.e.addItemDecoration(((com.xunlei.downloadprovider.xlui.recyclerview.divider.g.a) ((com.xunlei.downloadprovider.xlui.recyclerview.divider.g.a) new com.xunlei.downloadprovider.xlui.recyclerview.divider.g.a(getActivity().getApplicationContext()).c().a(R.color.lx_space_task_divider)).a()).d());
                this.e.setAdapter(this.f);
                this.g.show();
                this.e.setVisibility(0);
                this.e.scrollToPosition(0);
                this.e.d();
            }
            this.c.setVisibility(0);
            if (this.b != null) {
                this.b.setVisibility(8);
                return;
            }
        }
        if (this.b == null) {
            this.b = ((ViewStub) this.a.findViewById(R.id.lx_space_no_vip_guide_vs)).inflate();
            this.b.findViewById(R.id.lx_space_open_vip_btn).setOnClickListener(new e(this));
        }
        this.b.setVisibility(0);
        if (this.c != null) {
            this.c.setVisibility(8);
        }
        ThunderReport.reportEvent(com.xunlei.downloadprovider.personal.lixianspace.c.a.d("lx_off_dl_black_pay_botton_show"));
    }

    private void c() {
        if (j.a().a.l()) {
            b();
            this.h.setVisibility(0);
            this.i.setText(getString(R.string.lx_space_count_format, new Object[]{Integer.valueOf(a.a.a())}));
            int b = com.xunlei.downloadprovider.personal.lixianspace.a.b();
            if (b <= 0) {
                com.xunlei.downloadprovider.personal.lixianspace.b.c a = a.a;
                if (j.a().a.l()) {
                    if (a.d <= 0) {
                        a.d = 60;
                    }
                    b = a.d;
                } else {
                    b = 0;
                }
            }
            this.j.setText(getString(R.string.lx_space_count_format, new Object[]{Integer.valueOf(b)}));
            this.k.setProgress((a.a.a() * 100) / b);
        }
    }

    private void d() {
        if (this.t != null) {
            this.t.dismiss();
        }
    }

    private void e() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
        this.e.setVisibility(0);
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment) {
        l.a((Object) "lx_tag:default");
        lXDownloadEntryFragment.b();
        if (lXDownloadEntryFragment.e != null) {
            if (lXDownloadEntryFragment.f.b()) {
                lXDownloadEntryFragment.a();
                return;
            }
            lXDownloadEntryFragment.e();
        }
    }

    static /* synthetic */ void b(LXDownloadEntryFragment lXDownloadEntryFragment) {
        lXDownloadEntryFragment.p = 0;
        lXDownloadEntryFragment.e.setLoadingMoreEnabled(true);
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, LXTaskInfo lXTaskInfo) {
        if (lXDownloadEntryFragment.r == null) {
            lXDownloadEntryFragment.r = new k(lXDownloadEntryFragment.getActivity());
            lXDownloadEntryFragment.r.c = lXDownloadEntryFragment.s;
        }
        k kVar = lXDownloadEntryFragment.r;
        kVar.a = lXTaskInfo;
        if (lXTaskInfo.e <= 0) {
            kVar.b.setEnabled(true);
            kVar.b.setText(R.string.lx_space_task_operate_retry);
        } else {
            kVar.b.setText(R.string.lx_space_task_operate_pull_to_local);
            if (lXTaskInfo.i == CollectState.complete) {
                kVar.b.setEnabled(true);
            } else {
                kVar.b.setEnabled(false);
            }
        }
        lXDownloadEntryFragment.r.show();
    }

    static /* synthetic */ void f(LXDownloadEntryFragment lXDownloadEntryFragment) {
        if (lXDownloadEntryFragment.o == null) {
            lXDownloadEntryFragment.o = new c(lXDownloadEntryFragment.getContext());
        }
        lXDownloadEntryFragment.o.show();
        ThunderReport.reportEvent(com.xunlei.downloadprovider.personal.lixianspace.c.a.d("lx_off_dl_dilatation_pop_show"));
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, LXTaskInfo lXTaskInfo, int i, String str) {
        lXDownloadEntryFragment.d();
        if ((i == 0 ? 1 : 0) == 0 || lXTaskInfo == null) {
            if (lXDownloadEntryFragment.isVisible() != null) {
                XLToast.showToast(lXDownloadEntryFragment.getActivity(), str);
            }
            return;
        }
        XLToast.showToast(lXDownloadEntryFragment.getActivity(), "离线任务创建成功");
        lXDownloadEntryFragment.e();
        lXDownloadEntryFragment.f.a(lXTaskInfo);
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, List list) {
        lXDownloadEntryFragment.g.setVisibility(8);
        if (lXDownloadEntryFragment.e.a) {
            lXDownloadEntryFragment.e.a();
        } else {
            lXDownloadEntryFragment.e.b();
        }
        if (!d.a(list)) {
            lXDownloadEntryFragment.e();
            if (lXDownloadEntryFragment.p <= 0) {
                lXDownloadEntryFragment.f.a(list);
            } else {
                lXDownloadEntryFragment.f.b(list);
            }
            if (list.size() < 20) {
                lXDownloadEntryFragment.e.setLoadingMoreEnabled(false);
            } else {
                lXDownloadEntryFragment.p += 20;
            }
        }
        if (lXDownloadEntryFragment.f.b() != null) {
            lXDownloadEntryFragment.a();
        }
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, long j, int i) {
        lXDownloadEntryFragment.d();
        if ((i == 0 ? 1 : 0) != 0) {
            lXDownloadEntryFragment.f.a(j);
            lXDownloadEntryFragment.c();
            if (lXDownloadEntryFragment.f.b() != null) {
                lXDownloadEntryFragment.a();
            }
        }
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, List list, int i) {
        if (!d.a(list)) {
            if ((i == 0 ? 1 : 0) != 0) {
                lXDownloadEntryFragment.f.c(list);
            }
        }
    }

    static /* synthetic */ void b(LXDownloadEntryFragment lXDownloadEntryFragment, LXTaskInfo lXTaskInfo) {
        if (lXDownloadEntryFragment.u == null) {
            lXDownloadEntryFragment.u = new com.xunlei.downloadprovider.personal.lixianspace.ui.c.i(lXDownloadEntryFragment.getActivity());
            lXDownloadEntryFragment.u.c = lXDownloadEntryFragment.v;
        }
        com.xunlei.downloadprovider.personal.lixianspace.ui.c.i iVar = lXDownloadEntryFragment.u;
        iVar.b = lXTaskInfo;
        if (lXTaskInfo.c == 0 && lXTaskInfo.i == CollectState.downloading) {
            iVar.a.setVisibility(0);
        } else {
            iVar.a.setVisibility(8);
        }
        lXDownloadEntryFragment.u.show();
    }

    static /* synthetic */ void a(LXDownloadEntryFragment lXDownloadEntryFragment, String str) {
        if (lXDownloadEntryFragment.t == null) {
            lXDownloadEntryFragment.t = new XLWaitingDialog(lXDownloadEntryFragment.getActivity());
        }
        lXDownloadEntryFragment.t.setProHintStr(str);
        lXDownloadEntryFragment.t.show();
    }
}
