package com.xunlei.downloadprovider.ad.recommend.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.recommend.RecommendADConst.RecommendSSPAdMapping;
import com.xunlei.downloadprovider.ad.recommend.a.a;
import com.xunlei.downloadprovider.ad.recommend.a.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecommendAdViewHolder */
public class c extends f implements OnClickListener, b {
    private static final String b = "c";
    public int a = 0;
    private Context c = null;
    private LinearLayout d = null;
    private List<l> e = null;
    private List<BaseRecommendAdItemView> f = null;
    private View g = null;
    private View h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private View l = null;
    private View m = null;
    private ImageView n = null;
    private Animation o = null;
    private XLAlertDialog p = null;
    private a q = null;
    private int r;
    private com.xunlei.downloadprovider.download.tasklist.list.a s = null;
    private Handler t = new Handler();
    private List<l> u = null;

    public static c a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.control.a aVar, com.xunlei.downloadprovider.download.tasklist.list.a aVar2, a aVar3, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_task_list_recommend_use_ad_card, viewGroup, false);
        inflate.setTag(R.id.about_user_exps, Integer.valueOf(i));
        return new c(context, inflate, aVar, aVar2, aVar3, i);
    }

    private c(Context context, View view, com.xunlei.downloadprovider.download.control.a aVar, com.xunlei.downloadprovider.download.tasklist.list.a aVar2, a aVar3, int i) {
        super(view);
        this.c = context;
        this.mDownloadCenterControl = aVar;
        this.q = aVar3;
        this.r = i;
        this.s = aVar2;
        this.a = RecommendSSPAdMapping.getPositionCount(i);
        this.e = new ArrayList();
        this.q.a(this);
        this.g = view.findViewById(R.id.root_view);
        this.h = view.findViewById(R.id.game_center_entry_container);
        this.i = (TextView) view.findViewById(R.id.tv_game_entry);
        this.d = (LinearLayout) view.findViewById(R.id.recommend_list_ll);
        this.l = view.findViewById(R.id.change_root_view);
        this.m = view.findViewById(R.id.change_data_btn);
        this.n = (ImageView) view.findViewById(R.id.change_data_icon_iv);
        this.k = (TextView) view.findViewById(R.id.source_tv);
        this.j = (TextView) view.findViewById(R.id.title_tv);
        this.o = AnimationUtils.loadAnimation(getContext(), R.anim.recommend_ad_change_data_rotate_anim);
        this.o.setFillAfter(true);
        this.o.setInterpolator(new LinearInterpolator());
        j();
        context = this.l.getLayoutParams();
        if ((context instanceof MarginLayoutParams) != null) {
            if (h.b() == 3) {
                ((MarginLayoutParams) context).topMargin = DipPixelUtil.dip2px(13.0f);
            } else if (h.b() == 1) {
                ((MarginLayoutParams) context).topMargin = DipPixelUtil.dip2px(5.0f);
            } else {
                ((MarginLayoutParams) context).topMargin = 0;
            }
        }
        this.n.clearAnimation();
        a(true);
        context = 8;
        a(8);
        this.j.setText(this.c.getResources().getString(R.string.task_list_recommend_use_title));
        this.m.setOnClickListener(this);
        this.u = new ArrayList();
        view = this.h;
        aVar = i.a().d("game_center");
        if ("0x10810179".equals(AndroidConfig.getPartnerId()) != null) {
            view.setVisibility(8);
        } else if (d.a().c.a() == null) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            aVar2 = view.findViewById(R.id.iv_red_point_download);
            if (aVar == null) {
                i.a();
                if (i.c() != null) {
                    aVar2.setVisibility(context);
                    if (aVar != null) {
                        context = "游戏中心";
                    } else {
                        context = aVar.j;
                    }
                    this.i.setText(context);
                    aVar3 = com.xunlei.downloadprovider.ad.b.a.a();
                    switch (this.r) {
                        case 0:
                            aVar3.a = new WeakReference(aVar2);
                            break;
                        case 1:
                            aVar3.b = new WeakReference(aVar2);
                            break;
                        case 2:
                            aVar3.c = new WeakReference(aVar2);
                            break;
                        default:
                            break;
                    }
                    view.setOnClickListener(new d(this, aVar, context, aVar2));
                }
            }
            i.a();
            if (i.c() == null || aVar == null || aVar.b() != null) {
                context = null;
            }
            aVar2.setVisibility(context);
            if (aVar != null) {
                context = aVar.j;
            } else {
                context = "游戏中心";
            }
            this.i.setText(context);
            aVar3 = com.xunlei.downloadprovider.ad.b.a.a();
            switch (this.r) {
                case 0:
                    aVar3.a = new WeakReference(aVar2);
                    break;
                case 1:
                    aVar3.b = new WeakReference(aVar2);
                    break;
                case 2:
                    aVar3.c = new WeakReference(aVar2);
                    break;
                default:
                    break;
            }
            view.setOnClickListener(new d(this, aVar, context, aVar2));
        }
    }

    public void fillData(e eVar) {
        super.fillData(eVar);
        new StringBuilder("fillData pageIndex: ").append(this.r);
        eVar = this.r;
        new StringBuilder("RecommendAdViewHolder.this.getLayoutPosition(): ").append(getLayoutPosition());
        if (getLayoutPosition() != -1) {
            com.xunlei.downloadprovider.ad.downloadlist.c.f.a().a(new com.xunlei.downloadprovider.ad.recommend.c.c(eVar));
        }
        this.q.b();
        List arrayList = new ArrayList(this.u.size());
        arrayList.addAll(this.u);
        this.u.clear();
        a(this.r, arrayList);
    }

    public final boolean a(List<l> list) {
        if (list.size() < this.e.size()) {
            if (this.g.getVisibility() != 8) {
                return false;
            }
        }
        this.e = list;
        list = this.e;
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i < this.f.size()) {
                BaseRecommendAdItemView baseRecommendAdItemView = (BaseRecommendAdItemView) this.f.get(i);
                if (i < list.size()) {
                    l lVar = (l) list.get(i);
                    baseRecommendAdItemView.setData(lVar);
                    int i3 = i >= list.size() - 1 ? 1 : 0;
                    if (i < this.a - 1) {
                        i2 = 0;
                    }
                    if ((i2 | i3) != 0) {
                        baseRecommendAdItemView.setDivideLineVisibility(8);
                    } else {
                        baseRecommendAdItemView.setDivideLineVisibility(0);
                    }
                    baseRecommendAdItemView.setOnClickListener(new f(this, lVar, baseRecommendAdItemView, i));
                    baseRecommendAdItemView.setVisibility(0);
                } else {
                    baseRecommendAdItemView.setVisibility(8);
                }
                i++;
            } else {
                a(this.r, this.e);
                return true;
            }
        }
    }

    public final void a(String str) {
        this.k.setText(str);
    }

    public final void a(boolean z) {
        this.m.setEnabled(z);
    }

    public final void a(int i) {
        this.g.setVisibility(i);
    }

    public final void a() {
        this.t.post(new e(this));
    }

    public final int b() {
        return this.r;
    }

    public Context getContext() {
        return this.c;
    }

    public final void a(@NonNull DialogInterface.OnClickListener onClickListener, @NonNull DialogInterface.OnClickListener onClickListener2) {
        if (this.p == null) {
            this.p = new XLAlertDialog(this.c);
            this.p.setTitle((CharSequence) "温馨提示");
            this.p.setMessage((CharSequence) "当前为移动网络，开始下载/安装应用？");
            this.p.setConfirmButtonText((CharSequence) "确认");
            this.p.setCancelButtonText((CharSequence) "取消");
        }
        this.p.setOnClickConfirmButtonListener(onClickListener);
        this.p.setOnClickCancelButtonListener(onClickListener2);
    }

    public final void c() {
        if (this.p != null) {
            this.p.show();
        }
    }

    public final void d() {
        if (this.p != null) {
            this.p.dismiss();
        }
    }

    public final boolean e() {
        return com.xunlei.downloadprovider.ad.common.f.a(this.c);
    }

    public com.xunlei.downloadprovider.download.control.a getDownloadCenterControl() {
        return this.mDownloadCenterControl;
    }

    public final void f() {
        if (this.o != null) {
            this.n.startAnimation(this.o);
        }
    }

    public final void g() {
        this.n.clearAnimation();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.change_data_btn) {
            view = this.r;
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise", "adv_downloadin_change_click").addString("tabid", com.xunlei.downloadprovider.ad.recommend.c.a.a(view)).addString("net_type", com.xunlei.downloadprovider.ad.recommend.c.a.b()));
            this.q.a();
        }
    }

    private void j() {
        this.f = new ArrayList(this.a);
        int i = this.a;
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                View a = BaseRecommendAdItemView.a(this.c);
                this.d.addView(a, layoutParams);
                this.f.add(a);
                i = i2;
            } else {
                return;
            }
        }
    }

    private void a(int i, List<l> list) {
        c cVar = this;
        List<l> list2 = list;
        int i2 = 0;
        int i3 = 1;
        new StringBuilder("reportShow RecommendAdViewHolder.this.getLayoutPosition() != RecyclerView.NO_POSITION: ").append(getLayoutPosition() != -1);
        if (getLayoutPosition() != -1) {
            while (i2 < list.size() && i2 < cVar.a) {
                int i4;
                l lVar = (l) list2.get(i2);
                RecommendSSPAdMapping fromPositionId = RecommendSSPAdMapping.fromPositionId(lVar.A());
                if (fromPositionId != null) {
                    i4 = fromPositionId.position + i3;
                } else {
                    new StringBuilder("can not find mapping by this positionId: ").append(lVar.A());
                    i4 = -1;
                }
                com.xunlei.downloadprovider.ad.downloadlist.c.a a = com.xunlei.downloadprovider.ad.downloadlist.c.f.a();
                com.xunlei.downloadprovider.ad.downloadlist.c.i iVar = r7;
                com.xunlei.downloadprovider.ad.recommend.c.b bVar = new com.xunlei.downloadprovider.ad.recommend.c.b(cVar.d, lVar, lVar.e(), lVar.y(), lVar.a(), i, i4, lVar.H, lVar.A(), lVar);
                a.a(iVar);
                i2++;
                i3 = 1;
            }
            return;
        }
        cVar.u.addAll(list2);
    }

    public static boolean h() {
        return d.a().p.h() && com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) && !com.xunlei.downloadprovider.download.tasklist.list.feed.f.a();
    }
}
