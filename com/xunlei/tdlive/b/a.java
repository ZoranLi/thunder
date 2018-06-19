package com.xunlei.tdlive.b;

import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.tdlive.control.PullToRefreshRecyclerView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.route.XLLiveRouteDispatcher;
import com.xunlei.tdlive.sdk.BasePlugin;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.XLog;
import com.xunlei.tdlive.util.l;
import com.xunlei.tdlive.view.LiveListBannerView;
import com.xunlei.tdlive.view.LiveListPKBannerView;
import com.xunlei.tdlive.view.LiveListPKView;
import org.android.agoo.common.AgooConstants;

/* compiled from: SDKLiveListFragment3 */
public class a extends com.xunlei.tdlive.base.b implements OnClickListener, com.handmark.pulltorefresh.library.PullToRefreshBase.e<RecyclerView>, com.xunlei.tdlive.a.c.a {
    private long A = 0;
    private long B = 0;
    private String C = "down_refresh";
    private Handler D;
    private Runnable E = new Runnable(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void run() {
            RecyclerView recyclerView = (RecyclerView) this.a.m.getRefreshableView();
            if (recyclerView != null) {
                int childCount = recyclerView.getChildCount();
                if (childCount > 0) {
                    StringBuilder stringBuilder;
                    int i = 0;
                    View childAt = recyclerView.getChildAt(0);
                    int i2 = 3;
                    if (childAt != null) {
                        ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                        int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                        if (childViewHolder.getItemViewType() == 2) {
                            i = childAdapterPosition > 6 ? childAdapterPosition - 3 : childAdapterPosition - 2;
                            if (this.a.a(childAt) <= 50) {
                                i += 2;
                            }
                        } else if (childViewHolder.getItemViewType() == 4) {
                            i = childAdapterPosition - 3;
                        }
                    }
                    if (childCount > 1) {
                        View childAt2 = recyclerView.getChildAt(childCount - 1);
                        if (childAt2 != null) {
                            ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(childAt2);
                            int childAdapterPosition2 = recyclerView.getChildAdapterPosition(childAt2);
                            if (childAdapterPosition2 < 6) {
                                i2 = childAdapterPosition2 - 2;
                            } else if (childAdapterPosition2 != 6) {
                                i2 = childAdapterPosition2 - 3;
                                if (childViewHolder2.getItemViewType() == 2 && this.a.a(childAt2) <= 50) {
                                    i2 = i2 % 2 == 0 ? i2 - 1 : i2 - 2;
                                }
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(i);
                            stringBuilder.append("==");
                            stringBuilder.append(i2);
                            XLog.e("onScrollStateChanged", stringBuilder.toString());
                            if (this.a.s != null) {
                                ((com.xunlei.tdlive.a.h) this.a.s).a(i, i2);
                            }
                        }
                    }
                    i2 = i;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("==");
                    stringBuilder.append(i2);
                    XLog.e("onScrollStateChanged", stringBuilder.toString());
                    if (this.a.s != null) {
                        ((com.xunlei.tdlive.a.h) this.a.s).a(i, i2);
                    }
                }
            }
        }
    };
    private View l;
    private PullToRefreshRecyclerView m;
    private View n;
    private View o;
    private ImageView p;
    private ImageView q;
    private com.xunlei.tdlive.a.e r;
    private com.xunlei.tdlive.a.g s;
    private com.xunlei.tdlive.a.a t;
    private h u;
    private GridLayoutManager v;
    private boolean w = true;
    private boolean x = false;
    private boolean y = true;
    private boolean z = false;

    /* compiled from: SDKLiveListFragment3 */
    class a extends ViewHolder implements OnItemClickListener {
        final /* synthetic */ a a;

        public a(a aVar, ViewGroup viewGroup) {
            this.a = aVar;
            super(LayoutInflater.from(aVar.getActivity()).inflate(R.layout.xllive_livelist_banner_view, viewGroup, false));
            LiveListBannerView liveListBannerView = (LiveListBannerView) this.itemView;
            liveListBannerView.setLayoutParams(new LayoutParams(-1, 0));
            liveListBannerView.setOnItemClickListener(this);
            liveListBannerView.autoStep(ReaderCallback.GET_BAR_ANIMATING);
            liveListBannerView.setAdapter(aVar.r);
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (l.a(this.a.getActivity()) == null) {
                if (this.a.D != null) {
                    this.a.D.sendEmptyMessage(BasePlugin.CLIENT_NOFITY_NO_NETWORK_ERROR);
                }
                return;
            }
            adapterView = this.a.r.a(i);
            view = adapterView.getInt("type", (int) -1);
            String string = adapterView.getString("url", "");
            adapterView = adapterView.getString("title", "");
            XLLiveRouteDispatcher.getInstance().compatDispatch(view, adapterView, string);
            com.xunlei.tdlive.sdk.a.d("banner").a(i + 1).a("target", string).a("action", this.a.a((int) view, (String) adapterView, string)).a("contenttag-banner", 0).b("target");
        }

        public void a() {
            int d = (int) (((float) l.d(this.itemView.getContext())) / 3.5f);
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (this.a.r.getCount() <= 0) {
                d = 0;
            }
            layoutParams.height = d;
            this.itemView.setLayoutParams(this.itemView.getLayoutParams());
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class b extends ViewHolder implements com.xunlei.tdlive.a.a.c {
        protected int a = 0;
        final /* synthetic */ a b;

        public b(final a aVar, ViewGroup viewGroup) {
            this.b = aVar;
            super(new RecyclerView(viewGroup.getContext()));
            LayoutManager linearLayoutManager = new LinearLayoutManager(aVar.getContext());
            linearLayoutManager.setOrientation(0);
            this.itemView.setBackgroundColor(0);
            ((RecyclerView) this.itemView).setLayoutManager(linearLayoutManager);
            ((RecyclerView) this.itemView).setAdapter(aVar.t);
            ((RecyclerView) this.itemView).addItemDecoration(new ItemDecoration(this) {
                final /* synthetic */ b b;

                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
                    state = this.b.b.t == null ? null : this.b.b.t.getItemCount();
                    view = recyclerView.getChildPosition(view);
                    float f = 0.0f;
                    if (state < 4) {
                        if (this.b.a == 0) {
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) recyclerView.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            this.b.a = displayMetrics.widthPixels;
                        }
                        recyclerView = (((float) this.b.a) - com.xunlei.tdlive.util.d.a(this.b.b.getContext(), 90.0f * ((float) state))) / ((float) (state + 1));
                        if (view == state - 1) {
                            f = recyclerView;
                        }
                    } else {
                        float a;
                        if (view == null) {
                            a = com.xunlei.tdlive.util.d.a(this.b.b.getContext(), 5.0f);
                        } else {
                            a = com.xunlei.tdlive.util.d.a(this.b.b.getContext(), 9.0f);
                        }
                        if (view == state - 1) {
                            f = com.xunlei.tdlive.util.d.a(this.b.b.getContext(), 5.0f);
                        }
                        recyclerView = a;
                    }
                    rect.set((int) recyclerView, 0, (int) f, 0);
                }
            });
            aVar.t.a((com.xunlei.tdlive.a.a.c) this);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.setMargins(0, (int) com.xunlei.tdlive.util.d.a(aVar.getContext(), 5.0f), 0, 0);
            this.itemView.setLayoutParams(layoutParams);
        }

        public void a(View view, int i) {
            view = this.b.t.a(i);
            if (view != null && TextUtils.isEmpty(view.getString(AgooConstants.MESSAGE_ID, "")) == 0) {
                XLLiveRouteDispatcher.getInstance().categorylist(view.getString(AgooConstants.MESSAGE_ID, ""), view.getString(com.alipay.sdk.cons.c.e, ""));
            }
        }

        public void a() {
            if (this.itemView.getLayoutParams() != null && this.b.t != null) {
                int i = 0;
                ((LayoutParams) this.itemView.getLayoutParams()).setMargins(0, this.b.t.getItemCount() > 0 ? (int) com.xunlei.tdlive.util.d.a(this.b.getContext(), 5.0f) : 0, 0, 0);
                ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
                if (this.b.t.getItemCount() > 0) {
                    i = (int) com.xunlei.tdlive.util.d.a(this.itemView.getContext(), 30.0f);
                }
                layoutParams.height = i;
                this.itemView.setLayoutParams(this.itemView.getLayoutParams());
            }
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class c extends ViewHolder implements OnClickListener {
        int a;
        ViewGroup b;
        final /* synthetic */ a c;

        public c(a aVar, ViewGroup viewGroup) {
            this.c = aVar;
            super(aVar.s.getView(0, null, viewGroup));
            this.b = viewGroup;
            this.itemView.setOnClickListener(this);
        }

        public void a(int i) {
            this.a = i;
            this.c.s.getView(this.a, this.itemView, this.b);
        }

        public void onClick(View view) {
            if (l.a(this.c.getActivity()) == null) {
                if (this.c.D != null) {
                    this.c.D.sendEmptyMessage(BasePlugin.CLIENT_NOFITY_NO_NETWORK_ERROR);
                }
                return;
            }
            this.c.a(this.c.s.a(this.a));
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class d extends ViewHolder implements OnClickListener {
        final /* synthetic */ a a;

        public d(a aVar, ViewGroup viewGroup) {
            this.a = aVar;
            super(aVar.o = LayoutInflater.from(aVar.getActivity()).inflate(R.layout.xllive_livelist_footer_view, viewGroup, false));
            aVar.o.setVisibility(8);
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            this.a.C = "footer_refresh";
            this.a.m.setRefreshing();
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class e extends ViewHolder implements com.xunlei.tdlive.view.LiveListPKBannerView.a {
        final /* synthetic */ a a;

        public void b() {
        }

        public e(a aVar, ViewGroup viewGroup) {
            this.a = aVar;
            super(new LiveListPKBannerView(viewGroup.getContext()));
            ((LiveListPKBannerView) this.itemView).setPKBannerCallback(this);
            aVar = new LayoutParams(-1, 0);
            aVar.height = 0;
            this.itemView.setLayoutParams(aVar);
        }

        public void a() {
            XLLiveRouteDispatcher.getInstance().pklist();
        }

        public void a(JsonWrapper jsonWrapper) {
            this.a.a(jsonWrapper);
        }

        public void a(boolean z) {
            this.itemView.setVisibility(z ? 0 : 8);
            this.itemView.getLayoutParams().height = z ? (int) com.xunlei.tdlive.util.d.a(this.a.getContext(), 63.0f) : 0;
            ((LayoutParams) this.itemView.getLayoutParams()).setMargins(0, z ? (int) com.xunlei.tdlive.util.d.a(this.a.getContext(), 7.0f) : false, 0, 0);
            this.itemView.setLayoutParams(this.itemView.getLayoutParams());
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class f extends ViewHolder implements OnClickListener {
        final /* synthetic */ a a;

        public f(a aVar, ViewGroup viewGroup) {
            this.a = aVar;
            super(LayoutInflater.from(aVar.getActivity()).inflate(R.layout.xllive_live_list_pk_view, viewGroup, false));
        }

        public void a(JsonWrapper jsonWrapper) {
            ((LiveListPKView) this.itemView).mTitleView.setOnClickListener(this);
            ((LiveListPKView) this.itemView).bindData(jsonWrapper, this);
        }

        public void onClick(View view) {
            if (view.getId() == R.id.go_pk_list) {
                XLLiveRouteDispatcher.getInstance().pklist();
                com.xunlei.tdlive.sdk.a.d("micro_connection_click").a("clicarea", "home_pk_all").a("hostid", "").b(new String[0]);
                return;
            }
            this.a.a((JsonWrapper) view.getTag());
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class g extends OnScrollListener {
        int a;
        AbsListView b;
        final /* synthetic */ a c;

        g(a aVar) {
            this.c = aVar;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            a(a(), i);
            if (i == 0) {
                this.c.m.removeCallbacks(this.c.E);
                this.c.m.postDelayed(this.c.E, 500);
            } else {
                this.c.m.removeCallbacks(this.c.E);
                if (this.c.s != null) {
                    ((com.xunlei.tdlive.a.h) this.c.s).g();
                }
            }
            if (this.a == 0 || i != 0) {
                if (this.a == null && i != 0) {
                    this.a = i;
                }
                return;
            }
            this.a = 0;
            onScrolled(recyclerView, 0, 0);
        }

        public void onScrolled(android.support.v7.widget.RecyclerView r7, int r8, int r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r8 = r7.getChildCount();	 Catch:{ Throwable -> 0x003f }
            r9 = 0;	 Catch:{ Throwable -> 0x003f }
            r0 = -1;	 Catch:{ Throwable -> 0x003f }
            r2 = r9;	 Catch:{ Throwable -> 0x003f }
            r1 = r0;	 Catch:{ Throwable -> 0x003f }
        L_0x0008:
            if (r9 >= r8) goto L_0x002b;	 Catch:{ Throwable -> 0x003f }
        L_0x000a:
            r3 = r7.getChildAt(r9);	 Catch:{ Throwable -> 0x003f }
            r4 = r7.getChildViewHolder(r3);	 Catch:{ Throwable -> 0x003f }
            r4 = r4.getItemViewType();	 Catch:{ Throwable -> 0x003f }
            r5 = 2;	 Catch:{ Throwable -> 0x003f }
            if (r4 != r5) goto L_0x0028;	 Catch:{ Throwable -> 0x003f }
        L_0x0019:
            r3 = r7.getChildAdapterPosition(r3);	 Catch:{ Throwable -> 0x003f }
            if (r1 != r0) goto L_0x0026;	 Catch:{ Throwable -> 0x003f }
        L_0x001f:
            r1 = r3 + -1;	 Catch:{ Throwable -> 0x003f }
            r3 = 5;	 Catch:{ Throwable -> 0x003f }
            if (r1 < r3) goto L_0x0026;	 Catch:{ Throwable -> 0x003f }
        L_0x0024:
            r1 = r1 + -1;	 Catch:{ Throwable -> 0x003f }
        L_0x0026:
            r2 = r2 + 1;	 Catch:{ Throwable -> 0x003f }
        L_0x0028:
            r9 = r9 + 1;	 Catch:{ Throwable -> 0x003f }
            goto L_0x0008;	 Catch:{ Throwable -> 0x003f }
        L_0x002b:
            if (r1 == r0) goto L_0x003e;	 Catch:{ Throwable -> 0x003f }
        L_0x002d:
            r7 = r6.a();	 Catch:{ Throwable -> 0x003f }
            r8 = r6.c;	 Catch:{ Throwable -> 0x003f }
            r8 = r8.s;	 Catch:{ Throwable -> 0x003f }
            r8 = r8.getCount();	 Catch:{ Throwable -> 0x003f }
            r6.a(r7, r1, r2, r8);	 Catch:{ Throwable -> 0x003f }
        L_0x003e:
            return;
        L_0x003f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.b.a.g.onScrolled(android.support.v7.widget.RecyclerView, int, int):void");
        }

        private void a(AbsListView absListView, int i) {
            this.c.s.onScrollStateChanged(absListView, i);
            if (i == 0) {
                this.c.a(1000, 10000, 10000);
                return;
            }
            this.c.b(1000);
            this.c.w = 1;
        }

        private void a(AbsListView absListView, int i, int i2, int i3) {
            this.c.s.onScroll(absListView, i, i2, i3);
            if (this.c.s.getCount() != 0 && this.c.w != 0 && this.c.s.e() == 0) {
                this.c.w = false;
                i3 = com.xunlei.tdlive.sdk.a.d("zb_content_read");
                String d = i3.d("contentlist");
                long a = i3.a("contentlist_num", 0);
                if (i > 6) {
                    i--;
                } else if (i + i2 > 6) {
                    i2--;
                }
                long j = a;
                String str = d;
                for (int i4 = 0; i4 < i2; i4++) {
                    JsonWrapper jsonWrapper = (JsonWrapper) ((ListAdapter) absListView.getAdapter()).getItem(i + i4);
                    if (jsonWrapper != null) {
                        Object stringBuilder;
                        if (jsonWrapper.getInt("type", 0) == 1) {
                            StringBuilder stringBuilder2 = new StringBuilder("roomid=,hostid=,hosttype=,recommend=,follow=,sign=,viewernum=,rn=");
                            stringBuilder2.append(jsonWrapper.getInt("position", 0));
                            stringBuilder2.append(",livestat=,is_dl=1;");
                            stringBuilder = stringBuilder2.toString();
                        } else {
                            int i5 = jsonWrapper.getInt("status", 0);
                            StringBuilder stringBuilder3 = new StringBuilder("roomid=");
                            stringBuilder3.append(jsonWrapper.getString("roomid", ""));
                            stringBuilder3.append(",hostid=");
                            stringBuilder3.append(jsonWrapper.getString("userid", ""));
                            stringBuilder3.append(",hosttype=");
                            stringBuilder3.append(jsonWrapper.getObject("seq2", "{}").getInt("hot_level", 0));
                            stringBuilder3.append(",recommend=");
                            stringBuilder3.append(jsonWrapper.getObject("seq2", "{}").getInt("is_recommend", 0));
                            stringBuilder3.append(",follow=");
                            stringBuilder3.append(jsonWrapper.getObject("seq2", "{}").getInt("is_follow", 0));
                            stringBuilder3.append(",sign=");
                            stringBuilder3.append(jsonWrapper.getObject("seq2", "{}").getInt("is_sign", 0));
                            stringBuilder3.append(",viewernum=");
                            stringBuilder3.append(jsonWrapper.getInt("onlinenum", 0));
                            stringBuilder3.append(",rn=");
                            stringBuilder3.append(jsonWrapper.getInt("position", 0));
                            stringBuilder3.append(",livestat=");
                            stringBuilder3.append(i5 == 2 ? "replay" : "live");
                            stringBuilder3.append(",is_dl=0,contenttag=0,ischannel=");
                            stringBuilder3.append(jsonWrapper.getInt("item_type", 0));
                            stringBuilder3.append(",micro_connection=");
                            stringBuilder3.append(jsonWrapper.getInt("item_type", 0) == 0 ? "no" : "yes");
                            stringBuilder3.append(",tag_name=");
                            stringBuilder3.append(jsonWrapper.getString("tag", ""));
                            stringBuilder3.append(com.alipay.sdk.util.h.b);
                            stringBuilder = stringBuilder3.toString();
                        }
                        if (!str.contains(stringBuilder)) {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(str);
                            stringBuilder4.append(stringBuilder);
                            str = stringBuilder4.toString();
                            j++;
                        }
                    }
                }
                i3.a("grayid", this.c.s.d()).a("contentlist", str);
                if (j >= 4) {
                    i3.b("contentlist").a("contentlist", "contentlist_num");
                }
            }
        }

        private AbsListView a() {
            if (this.b == null) {
                this.b = new AbsListView(this, this.c.l.getContext()) {
                    final /* synthetic */ g a;

                    public void setSelection(int i) {
                    }

                    public /* synthetic */ Adapter getAdapter() {
                        return a();
                    }

                    public ListAdapter a() {
                        return this.a.c.s;
                    }
                };
            }
            return this.b;
        }
    }

    /* compiled from: SDKLiveListFragment3 */
    class h extends RecyclerView.Adapter {
        DataSetObserver a = new DataSetObserver(this) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public void onChanged() {
                if (!((RecyclerView) this.a.b.m.getRefreshableView()).isComputingLayout()) {
                    this.a.notifyDataSetChanged();
                }
            }

            public void onInvalidated() {
                onChanged();
            }
        };
        final /* synthetic */ a b;

        h(a aVar) {
            this.b = aVar;
            aVar.r.registerDataSetObserver(this.a);
            aVar.s.registerDataSetObserver(this.a);
        }

        public int getItemViewType(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 5;
            }
            if (i == 6) {
                return 4;
            }
            return i == getItemCount() - 1 ? 6 : 2;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new a(this.b, viewGroup);
            }
            switch (i) {
                case 2:
                    return new c(this.b, viewGroup);
                case 3:
                    return new f(this.b, viewGroup);
                case 4:
                    return new e(this.b, viewGroup);
                case 5:
                    return new b(this.b, viewGroup);
                case 6:
                    return new d(this.b, viewGroup);
                default:
                    return null;
            }
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() != 1) {
                if (viewHolder.getItemViewType() == 0) {
                    ((a) viewHolder).a();
                } else if (viewHolder.getItemViewType() == 2) {
                    if (i > 1 && i < getItemCount() - 1) {
                        i -= 2;
                    }
                    if (i > 4) {
                        i--;
                    }
                    ((c) viewHolder).a(i);
                } else if (viewHolder.getItemViewType() == 3) {
                    ((f) viewHolder).a(this.b.s.f());
                } else if (viewHolder.getItemViewType() == 5) {
                    ((b) viewHolder).a();
                } else if (viewHolder.getItemViewType() == 4) {
                    ((e) viewHolder).b();
                }
            }
        }

        public int getItemCount() {
            if (this.b.s.getCount() <= 0) {
                return 1;
            }
            int i = 4;
            if (this.b.s.getCount() < 4) {
                i = 3;
            }
            return this.b.s.getCount() + i;
        }
    }

    public void a(Handler handler) {
        this.D = handler;
        this.D.obtainMessage(BasePlugin.CLIENT_NOFITY_INIT, 0, 0, new Handler(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void handleMessage(android.os.Message r6) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r5 = this;
                r0 = r6.what;
                r1 = com.xunlei.tdlive.sdk.BasePlugin.HOST_NOFITY_REFRESH_LIST;
                if (r0 != r1) goto L_0x0028;
            L_0x0006:
                r6 = r5.a;
                r6 = r6.m;
                if (r6 == 0) goto L_0x00c2;
            L_0x000e:
                r6 = r5.a;
                r0 = "host_refresh";
                r6.C = r0;
                r6 = r5.a;
                r6 = r6.m;
                r6.onRefreshComplete();
                r6 = r5.a;
                r6 = r6.m;
                r6.setRefreshing();
                return;
            L_0x0028:
                r0 = r6.what;
                r1 = com.xunlei.tdlive.sdk.BasePlugin.HOST_NOFITY_PAGE_SELECTED;
                r2 = 0;
                if (r0 != r1) goto L_0x008b;
            L_0x002f:
                r0 = r5.a;
                r1 = 1;
                r0.x = r1;
                r0 = r5.a;
                r3 = r5.a;
                r3 = r3.y;
                r0.e(r3);
                r0 = r5.a;
                r0.y = r2;
                r0 = "home_page_show";	 Catch:{ Throwable -> 0x006b }
                r0 = com.xunlei.tdlive.sdk.a.d(r0);	 Catch:{ Throwable -> 0x006b }
                r3 = r6.obj;	 Catch:{ Throwable -> 0x006b }
                r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x006b }
                r0 = r0.a(r3);	 Catch:{ Throwable -> 0x006b }
                r3 = "isred";	 Catch:{ Throwable -> 0x006b }
                r4 = r6.arg1;	 Catch:{ Throwable -> 0x006b }
                r0 = r0.a(r3, r4);	 Catch:{ Throwable -> 0x006b }
                r3 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x006b }
                r0.b(r3);	 Catch:{ Throwable -> 0x006b }
                r0 = "zb_content_read";	 Catch:{ Throwable -> 0x006b }
                r0 = com.xunlei.tdlive.sdk.a.d(r0);	 Catch:{ Throwable -> 0x006b }
                r3 = "viewid";	 Catch:{ Throwable -> 0x006b }
                r0.c(r3);	 Catch:{ Throwable -> 0x006b }
            L_0x006b:
                r0 = new android.os.Bundle;
                r0.<init>();
                r3 = "visible";
                r6 = r6.arg2;
                if (r6 == 0) goto L_0x0077;
            L_0x0076:
                goto L_0x0078;
            L_0x0077:
                r1 = r2;
            L_0x0078:
                r0.putBoolean(r3, r1);
                r6 = r5.a;
                r6 = r6.getActivity();
                r6 = com.xunlei.tdlive.util.i.a(r6);
                r1 = "com.xunlei.tdlive.MAIN_PAGE_SELECTED";
                r6.a(r1, r0);
                return;
            L_0x008b:
                r0 = r6.what;
                r1 = com.xunlei.tdlive.sdk.BasePlugin.HOST_NOFITY_PAGE_DESELECTED;
                if (r0 != r1) goto L_0x00c2;
            L_0x0091:
                r0 = r5.a;
                r0.x = r2;
                r0 = r5.a;
                r0.d();
                r0 = new android.os.Bundle;
                r0.<init>();
                r1 = r6.obj;
                r1 = r1 instanceof java.lang.Boolean;
                if (r1 == 0) goto L_0x00b3;
            L_0x00a6:
                r1 = "visible";
                r6 = r6.obj;
                r6 = (java.lang.Boolean) r6;
                r6 = r6.booleanValue();
                r0.putBoolean(r1, r6);
            L_0x00b3:
                r6 = r5.a;
                r6 = r6.getActivity();
                r6 = com.xunlei.tdlive.util.i.a(r6);
                r1 = "com.xunlei.tdlive.MAIN_PAGE_DESELECTED";
                r6.a(r1, r0);
            L_0x00c2:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.b.a.1.handleMessage(android.os.Message):void");
            }
        }).sendToTarget();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.l != null) {
            return this.l;
        }
        return layoutInflater.inflate(R.layout.xllive_fragment_livelist_sdk2, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.l != view) {
            this.l = view;
            bundle = getArguments();
            if (!(bundle == null || bundle.getBoolean("title", false) == null)) {
                a("迅雷直播", 18.0f, -12893620);
                c((int) R.color.white);
                d(-1513240);
                a(true);
                a((OnClickListener) this);
                b(true);
                a(com.xunlei.tdlive.util.g.a(view, R.drawable.xllive_user_center_selector));
                b((OnClickListener) this);
                c(true);
                b((Drawable) com.xunlei.tdlive.util.g.a(view, R.drawable.xllive_sdk_rank_selector));
                c((OnClickListener) this);
                this.z = true;
            }
            this.s = new com.xunlei.tdlive.a.h(com.xunlei.tdlive.modal.c.h(getActivity()), this);
            this.r = new com.xunlei.tdlive.a.e(0, null, 0);
            this.u = new h(this);
            this.t = new com.xunlei.tdlive.a.a();
            this.v = new GridLayoutManager(getActivity(), 2);
            this.v.setSpanSizeLookup(new SpanSizeLookup(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public int getSpanSize(int i) {
                    switch (this.a.u.getItemViewType(i)) {
                        case 0:
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            return 2;
                        default:
                            return 1;
                    }
                }
            });
            this.m = (PullToRefreshRecyclerView) a((Object) "tag_control_live_list");
            this.m.setMode(Mode.PULL_FROM_START);
            this.m.setOnRefreshListener(this);
            ((RecyclerView) this.m.getRefreshableView()).setOnScrollListener(new g(this));
            ((RecyclerView) this.m.getRefreshableView()).setLayoutManager(this.v);
            ((RecyclerView) this.m.getRefreshableView()).setAdapter(this.u);
            this.p = (ImageView) a((int) R.id.check_in_btn);
            this.p.setOnClickListener(this);
            this.q = (ImageView) a((int) R.id.check_in_red_flag);
        }
    }

    public void onResume() {
        super.onResume();
        e(false);
    }

    public void onPause() {
        super.onPause();
        f(true);
        com.xunlei.tdlive.sdk.a.a d = com.xunlei.tdlive.sdk.a.d("zb_content_read");
        if (!TextUtils.isEmpty(d.d("contentlist"))) {
            d.b("contentlist").a("contentlist", "contentlist_num");
        }
    }

    public void e(boolean z) {
        if (this.x) {
            if (z) {
                this.C = "repeat_refresh";
                this.m.setRefreshing();
            } else {
                z = l.a(getActivity());
                if (this.s != null && z) {
                    if (this.s.getCount() > false) {
                        this.s.a(true, "init_refresh");
                    } else {
                        this.B = SystemClock.elapsedRealtime();
                    }
                }
                if (this.r) {
                    this.r.a((Object) "init_refresh");
                }
                if (this.t) {
                    this.t.a("init_refresh");
                }
                a(1000, 10000, 10000);
            }
            com.xunlei.tdlive.modal.d.a().b();
            e();
            if (com.xunlei.tdlive.sdk.b.a().b()) {
                com.xunlei.tdlive.modal.a.a().b();
            } else {
                com.xunlei.tdlive.modal.a.a().d();
            }
            if (this.z && com.xunlei.tdlive.util.c.b(getContext())) {
                com.xunlei.tdlive.util.c.a(getContext(), new com.xunlei.tdlive.util.c.a(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void a() {
                        this.a.p.setVisibility(0);
                    }
                });
            } else {
                this.p.setVisibility(8);
            }
            if (this.z && com.xunlei.tdlive.sdk.b.a().b()) {
                com.xunlei.tdlive.modal.e.a().a(new Runnable(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        if (com.xunlei.tdlive.modal.e.a().a(this.a.getContext())) {
                            this.a.q.setVisibility(0);
                        } else {
                            this.a.q.setVisibility(8);
                        }
                    }
                });
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    public void d() {
        f(false);
        com.xunlei.tdlive.modal.a.a().c();
    }

    private void f(boolean z) {
        b((int) true);
        com.xunlei.tdlive.modal.d.a().c();
    }

    public void onDetach() {
        if (this.m != null) {
            this.m.removeCallbacks(this.E);
        }
        super.onDetach();
    }

    public void e(int i) {
        if (i == 1000) {
            i = l.a(getActivity());
            if (this.s != null) {
                if (SystemClock.elapsedRealtime() - this.B > 60000) {
                    this.B = SystemClock.elapsedRealtime();
                    this.s.a(true, "timer");
                } else if (this.s.getCount() <= 0 || i != 0) {
                    this.s.b("timer");
                }
            }
            if (this.r != null && SystemClock.elapsedRealtime() - this.A > 60000) {
                this.A = SystemClock.elapsedRealtime();
                if (this.r.getCount() <= 0 || i != 0) {
                    this.r.a((Object) "timer");
                }
                if (this.t != 0) {
                    this.t.a("timer");
                }
            }
        }
    }

    public void onPullDownToRefresh(final PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        this.B = SystemClock.elapsedRealtime();
        ((RecyclerView) pullToRefreshBase.getRefreshableView()).scrollToPosition(0);
        if (this.s.getCount() > 0) {
            pullToRefreshBase.postDelayed(new Runnable(this) {
                final /* synthetic */ a b;

                public void run() {
                    pullToRefreshBase.onRefreshComplete();
                }
            }, 500);
        }
        this.s.a(this.C);
        if (this.r != null) {
            this.r.a((Object) this.C);
        }
        if (this.t != null) {
            this.t.a(this.C);
        }
        a(1000, 10000, 10000);
    }

    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
        pullToRefreshBase.onRefreshComplete();
    }

    public <T> void a(T t, boolean z, boolean z2) {
        int count = this.s.getCount();
        if (z) {
            this.m.postDelayed(new Runnable(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.m.onRefreshComplete();
                    this.a.C = "down_refresh";
                }
            }, 200);
            if (this.D) {
                if (!this.n) {
                    this.n = com.xunlei.tdlive.sdk.c.a().a(getActivity(), new OnClickListener(this) {
                        final /* synthetic */ a a;

                        {
                            this.a = r1;
                        }

                        public void onClick(View view) {
                            this.a.D.sendEmptyMessage(BasePlugin.HOST_NOFITY_REFRESH_LIST);
                        }
                    });
                    if (this.n) {
                        this.n.setVisibility(8);
                        this.n.setOnTouchListener(new OnTouchListener(this) {
                            final /* synthetic */ a a;

                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                return true;
                            }

                            {
                                this.a = r1;
                            }
                        });
                        ((FrameLayout) com.xunlei.tdlive.base.d.a((Fragment) this, R.id.container)).addView(this.n, -1, -1);
                    }
                }
                if (this.n) {
                    if (count <= 0) {
                        if (l.a(getActivity())) {
                            com.xunlei.tdlive.sdk.c.a().a(getActivity(), this.n, BasePlugin.ERROR_VIEW_TYPE_EMPTY);
                        } else {
                            com.xunlei.tdlive.sdk.c.a().a(getActivity(), this.n, BasePlugin.ERROR_VIEW_TYPE_INVALID_NETWORK);
                        }
                        this.n.setVisibility(0);
                    } else {
                        this.n.setVisibility(8);
                    }
                }
                if (count > 0 && this.o) {
                    ((TextView) this.o.findViewById(R.id.loading_tip)).setText("到底了哦！回到顶部");
                    this.o.setVisibility(0);
                }
                this.D.obtainMessage(BasePlugin.CLIENT_NOFITY_REFRESH_LIST_END, count, 0).sendToTarget();
            } else if (this.o) {
                ((TextView) this.o.findViewById(R.id.loading_tip)).setText("到底了哦！回到顶部");
                this.o.setVisibility(0);
            }
            if ("down_refresh".equals(t)) {
                z = com.xunlei.tdlive.sdk.a.d("down_refresh");
                int count2 = this.s.getCount() - ((int) z.a("last_count", 0));
                if (count2 >= false) {
                    z.a("last_count").a("num", count2).a("result", count2 == 0 ? "norefresh" : "success").b(new String[0]);
                }
            }
            if ("down_refresh".equals(t) || "init_refresh".equals(t) != null) {
                this.m.removeCallbacks(this.E);
                this.m.postDelayed(this.E, 500);
                return;
            }
        }
        if (this.o != null) {
            if (z2) {
                ((TextView) this.o.findViewById(R.id.loading_tip)).setText("加载中...");
                this.o.setVisibility(0);
            } else if (count <= 0) {
                this.o.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(com.xunlei.tdlive.sdk.a.d("zb_content_read").d("contentlist")) == null) {
            com.xunlei.tdlive.sdk.a.d("zb_content_read").b("contentlist").a("contentlist", "contentlist_num");
        }
        com.xunlei.tdlive.sdk.a.d("down_refresh").a("last_count", this.s.getCount());
    }

    public void onClick(View view) {
        if (view == this.a) {
            ((RecyclerView) this.m.getRefreshableView()).smoothScrollToPosition(0);
        } else if (view == this.d) {
            com.xunlei.tdlive.sdk.a.d("home_attentionbar_click").a("clickid", "bar").a("hostid", com.xunlei.tdlive.sdk.b.a().e()).b(new String[0]);
            com.xunlei.tdlive.sdk.b.a().a(getActivity(), "home_attention", new com.xunlei.tdlive.sdk.b.a(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void a(boolean z) {
                    if (z) {
                        com.xunlei.tdlive.sdk.a.d("zb_home_follow_icon").a("from", "mycenter").b(new String[0]);
                        XLLiveRouteDispatcher.getInstance().webview("http://h5.live.xunlei.com/active/pages/playcenter.html", "我的直播中心", false);
                    }
                }
            });
            this.q.setVisibility(8);
            com.xunlei.tdlive.modal.e.a().b(getContext());
        } else if (view == this.h) {
            XLLiveRouteDispatcher.getInstance().rank(0);
        } else {
            if (view == this.p) {
                XLLiveRouteDispatcher.getInstance().dailyCheckIn(true, "sign_hover");
                this.p.setVisibility(8);
            }
        }
    }

    private String a(int i, String str, String str2) {
        if (i == 1) {
            return "activity";
        }
        if (i == 2) {
            return "live_room";
        }
        if (i == 3) {
            return (str2 == null || str2.startsWith("xllive://rank") == 0) ? DispatchConstants.OTHER : "ranklist";
        } else {
            return "";
        }
    }

    private void e() {
        if (com.xunlei.tdlive.sdk.b.a().b()) {
            com.xunlei.tdlive.sdk.b.a().c(new com.xunlei.tdlive.sdk.b.b(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void a(int i, String str, JsonWrapper jsonWrapper) {
                    i = com.xunlei.tdlive.sdk.b.a().e();
                    int a = com.xunlei.tdlive.sdk.b.a().a(false);
                    String b = com.xunlei.tdlive.sdk.b.a().b(false);
                    a aVar = this.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("_level");
                    int b2 = aVar.b(stringBuilder.toString(), -1);
                    if (b2 == -1) {
                        jsonWrapper = this.a;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(i);
                        stringBuilder2.append("_level");
                        jsonWrapper.a((String) stringBuilder2.toString(), a);
                        return;
                    }
                    if (a > b2) {
                        aVar = this.a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i);
                        stringBuilder.append("_level");
                        aVar.a((String) stringBuilder.toString(), a);
                        XLLiveRouteDispatcher.getInstance().userLevelUp(a, b);
                        com.xunlei.tdlive.sdk.a.d("level_altert_pop").a("level", a).b(new String[0]);
                    }
                }
            });
        }
    }

    private int a(View view) {
        if (view == null) {
            return null;
        }
        int top = view.getTop();
        int bottom = view.getBottom();
        if (top < 0 && bottom > 0) {
            return (bottom * 100) / (bottom - top);
        }
        if (top >= com.xunlei.tdlive.util.d.a(view.getContext()).y || bottom <= com.xunlei.tdlive.util.d.a(view.getContext()).y) {
            return 100;
        }
        return ((com.xunlei.tdlive.util.d.a(view.getContext()).y - top) * 100) / (bottom - top);
    }

    private void a(JsonWrapper jsonWrapper) {
        if (jsonWrapper != null) {
            int i = jsonWrapper.getInt("item_type", 0);
            if (i != 0) {
                if (i != 2) {
                    XLLiveRouteDispatcher.getInstance().channel(jsonWrapper.getInt("channel_id", 0));
                    com.xunlei.tdlive.sdk.a.d("home_label_click").a("viewid", com.xunlei.tdlive.sdk.a.d("zb_content_read").d("viewid")).a("roomid", jsonWrapper.getString("roomid", "")).a("hostid", jsonWrapper.getString("userid", "")).a("viewernum", jsonWrapper.getInt("onlinenum", 0)).a("rn", jsonWrapper.getInt("position", 0)).a("grayid", this.s.d()).a("hosttype", jsonWrapper.getObject("seq2", "{}").getInt("hot_level", 0)).a("follow", jsonWrapper.getObject("seq2", "{}").getInt("is_follow", 0)).a("recommend", jsonWrapper.getObject("seq2", "{}").getInt("is_recommend", 0)).a("sign", jsonWrapper.getObject("seq2", "{}").getInt("is_sign", 0)).a("isdl", jsonWrapper.getInt("type", 0)).a("livestat", jsonWrapper.getInt("status", 0) != 2 ? "replay" : "live").a("tag_name", jsonWrapper.getString("tag", "")).a("micro_connection", jsonWrapper.getInt("item_type", 0) != 0 ? "no" : "yes").a("contenttag", 0).a("ischannel", jsonWrapper.getInt("item_type", 0)).b("tag_name");
                }
            }
            if (jsonWrapper.getInt("type", 0) == 1) {
                String string = jsonWrapper.getString("action", "download");
                CharSequence string2 = jsonWrapper.getString("action_url", "");
                if (string.equals("openurl")) {
                    XLLiveRouteDispatcher.getInstance().compatDispatch(string2);
                } else {
                    if (TextUtils.isEmpty(string2)) {
                        string2 = com.xunlei.tdlive.modal.b.M;
                    }
                    TextUtils.isEmpty(string2);
                }
            } else {
                i = jsonWrapper.getInt("status", 0);
                String string3 = jsonWrapper.getString("roomid", "");
                String string4 = jsonWrapper.getString("userid", "");
                String string5 = jsonWrapper.getObject("userinfo", "{}").getString("avatar", "");
                String string6 = jsonWrapper.getString("image", string5);
                jsonWrapper.getString("onlinenum", "0");
                String string7 = jsonWrapper.getString("stream_pull", "");
                jsonWrapper.getObject("seq2", "{}").getInt("hot_level", 0);
                jsonWrapper.getObject("seq2", "{}").getInt("is_follow", 0);
                if (i != 1) {
                    if (i != 3) {
                        if (i == 2) {
                            XLLiveRouteDispatcher.getInstance().replay(string3, string4, jsonWrapper.getString("play_hls_url", ""), string5, string6, "zb_home_card_item");
                        }
                    }
                }
                XLLiveRouteDispatcher.getInstance().room(string3, string4, string7, string5, string6, "zb_home_card_item");
            }
            if (jsonWrapper.getInt("status", 0) != 2) {
            }
            if (jsonWrapper.getInt("item_type", 0) != 0) {
            }
            com.xunlei.tdlive.sdk.a.d("home_label_click").a("viewid", com.xunlei.tdlive.sdk.a.d("zb_content_read").d("viewid")).a("roomid", jsonWrapper.getString("roomid", "")).a("hostid", jsonWrapper.getString("userid", "")).a("viewernum", jsonWrapper.getInt("onlinenum", 0)).a("rn", jsonWrapper.getInt("position", 0)).a("grayid", this.s.d()).a("hosttype", jsonWrapper.getObject("seq2", "{}").getInt("hot_level", 0)).a("follow", jsonWrapper.getObject("seq2", "{}").getInt("is_follow", 0)).a("recommend", jsonWrapper.getObject("seq2", "{}").getInt("is_recommend", 0)).a("sign", jsonWrapper.getObject("seq2", "{}").getInt("is_sign", 0)).a("isdl", jsonWrapper.getInt("type", 0)).a("livestat", jsonWrapper.getInt("status", 0) != 2 ? "replay" : "live").a("tag_name", jsonWrapper.getString("tag", "")).a("micro_connection", jsonWrapper.getInt("item_type", 0) != 0 ? "no" : "yes").a("contenttag", 0).a("ischannel", jsonWrapper.getInt("item_type", 0)).b("tag_name");
        }
    }
}
