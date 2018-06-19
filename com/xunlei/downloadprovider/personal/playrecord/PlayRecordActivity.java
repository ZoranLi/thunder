package com.xunlei.downloadprovider.personal.playrecord;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.b.m;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PlayRecordActivity extends BaseActivity implements OnClickListener, com.handmark.pulltorefresh.library.PullToRefreshBase.a, e<ListView>, com.xunlei.downloadprovider.member.b.a.a {
    private static final String a = "PlayRecordActivity";
    private boolean A;
    private boolean B;
    private boolean C;
    private XLAlertDialog D = null;
    private com.xunlei.downloadprovider.member.b.a E;
    private XLWaitingDialog F;
    private m G = new c(this);
    private final d H = new g(this);
    private final g I = new h(this);
    private final h J = new i(this);
    private XLAlertDialog K = null;
    private XLAlertDialog L = null;
    private View c = null;
    private View d = null;
    private Button e = null;
    private Button f = null;
    private TextView g = null;
    private TitleBar h = null;
    private RelativeLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private ErrorBlankView n;
    private View o;
    private View p;
    private Button q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private PullToRefreshListView u;
    private UnifiedLoadingView v;
    private final c w = new c();
    private List<VideoPlayRecord> x = new ArrayList();
    private final Set<Long> y = new HashSet();
    private LoginHelper z = LoginHelper.a();

    private static class a {
        View a;
        ImageView b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        VideoPlayRecord g;

        public a(View view, VideoPlayRecord videoPlayRecord) {
            this.g = videoPlayRecord;
            this.a = view;
        }

        final String a(int i) {
            return this.a.getResources().getString(i);
        }
    }

    private static class b {
        View a;
        b b;
        TextView c;

        public b(View view, b bVar) {
            this.a = view;
            this.b = bVar;
        }
    }

    private final class c extends BaseAdapter {
        final /* synthetic */ PlayRecordActivity a;

        public final long getItemId(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        private c(PlayRecordActivity playRecordActivity) {
            this.a = playRecordActivity;
        }

        public final /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public final int getCount() {
            return this.a.x.size();
        }

        public final int getItemViewType(int i) {
            return (a(i) == null || (a(i) instanceof b) == 0) ? 0 : 1;
        }

        private VideoPlayRecord a(int i) {
            return (i < 0 || i >= this.a.x.size()) ? 0 : (VideoPlayRecord) this.a.x.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            VideoPlayRecord a;
            viewGroup = getItemViewType(i);
            boolean z = true;
            if (view != null) {
                if (view.getTag() != null) {
                    if (viewGroup == 1) {
                        viewGroup = (a) view.getTag();
                    } else {
                        viewGroup = (ag) view.getTag();
                    }
                    a = a(i);
                    if (a != null) {
                        if (i > 0) {
                            i = a(i - 1);
                            i = i != 0 ? "" : i.p;
                            i = (TextUtils.isEmpty(i) || i.equals(a.p) != 0) ? 0 : 1;
                            if (i != 0) {
                                z = false;
                            }
                        }
                        viewGroup.a(a, z, this.a.C, this.a.y.contains(a.b));
                        i = new t(this, a);
                        viewGroup.h.setOnClickListener(i);
                        viewGroup.d.setOnClickListener(i);
                        viewGroup.d.setOnLongClickListener(new u(this, a));
                    }
                    return view;
                }
            }
            if (viewGroup == 1) {
                view = LayoutInflater.from(this.a).inflate(R.layout.play_record_list_item_layout_live, null);
                viewGroup = new a(view);
                view.setTag(viewGroup);
            } else {
                view = LayoutInflater.from(this.a).inflate(R.layout.play_record_list_item_layout, null);
                viewGroup = new ag(view);
                view.setTag(viewGroup);
            }
            a = a(i);
            if (a != null) {
                if (i > 0) {
                    i = a(i - 1);
                    if (i != 0) {
                    }
                    if (!TextUtils.isEmpty(i)) {
                    }
                    if (i != 0) {
                        z = false;
                    }
                }
                viewGroup.a(a, z, this.a.C, this.a.y.contains(a.b));
                i = new t(this, a);
                viewGroup.h.setOnClickListener(i);
                viewGroup.d.setOnClickListener(i);
                viewGroup.d.setOnLongClickListener(new u(this, a));
            }
            return view;
        }
    }

    public final void j() {
    }

    public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
    }

    public PlayRecordActivity() {
        LoginHelper loginHelper = this.z;
        m mVar = this.G;
        com.xunlei.downloadprovider.member.login.c.a aVar = loginHelper.h;
        if (!(mVar == null || aVar.a.contains(mVar))) {
            aVar.a.add(mVar);
        }
        this.z.a(this.I);
        this.z.a(this.H);
    }

    public final void i() {
        b();
    }

    private com.xunlei.downloadprovider.member.b.d d() {
        if (this.E == null) {
            this.E = com.xunlei.downloadprovider.member.b.c.a(this);
        }
        return this.E.b("3");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play_record);
        this.h = new TitleBar((Activity) this);
        this.h.mLeft.setOnClickListener(this);
        this.h.mRightIv.setOnClickListener(this);
        this.h.mRightIv.setVisibility(0);
        this.h.mRightIv.setImageResource(R.drawable.common_menu_delete_icon_black_selector);
        this.h.mTitle.setText(R.string.cloud_list_tab_sync_vod);
        this.h.setTitleBarBottomDividerVisibility(8);
        this.v = (UnifiedLoadingView) findViewById(R.id.progress_load_root);
        this.c = findViewById(R.id.edit_titlebar_ly);
        this.d = findViewById(R.id.play_record_list_bottom_delete_bar);
        this.e = (Button) findViewById(R.id.editbar_right);
        this.e.setTextSize(2, 15.0f);
        this.f = (Button) findViewById(R.id.editbar_left);
        this.f.setTextSize(2, 15.0f);
        this.g = (TextView) findViewById(R.id.editbar_title);
        this.g.setText(R.string.cloud_list_delete_title);
        this.l = (TextView) findViewById(R.id.common_delete_buttom_btn_text);
        this.m = (ImageView) findViewById(R.id.common_delete_buttom_btn_icon);
        this.i = (RelativeLayout) findViewById(R.id.rl_load_or_pay_layout);
        this.j = (TextView) findViewById(R.id.tv_load_or_pay_tip);
        this.k = (TextView) findViewById(R.id.btn_go_to_load_or_pay);
        this.v.show();
        this.v.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p = findViewById(R.id.play_record_list_login_warn);
        this.q = (Button) findViewById(R.id.play_record_list_need_login_btn);
        this.q.setVisibility(0);
        this.r = (TextView) findViewById(R.id.thunder_browser_error_page_title);
        this.s = (TextView) findViewById(R.id.common_error_text_detail);
        this.t = (ImageView) findViewById(R.id.common_icon);
        this.u = (PullToRefreshListView) findViewById(R.id.play_record_list_view);
        this.u.setMode(Mode.PULL_FROM_START);
        this.u.setOnRefreshListener(this);
        this.u.setAdapter(this.w);
        this.u.setOnLastItemVisibleListener(this);
        this.u.setGravity(48);
        this.o = LayoutInflater.from(this).inflate(R.layout.play_record_list_empty_view, null);
        TextView textView = (TextView) this.o.findViewById(R.id.play_record_list_empty_title);
        textView.setText(R.string.cloud_list_vod_empty_vip);
        textView.setVisibility(0);
        this.n = (ErrorBlankView) findViewById(R.id.layout_no_network_error_view);
        this.n.setErrorType(2);
        this.n.setActionButtonListener(this);
    }

    private final void g() {
        if (!this.C) {
            v.a().a(new k(this));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.E == null) {
            this.E = com.xunlei.downloadprovider.member.b.c.a(this);
        }
        this.E.c("3");
        g();
        if (PayUtil.b) {
            this.z.a(this.J);
            this.z.b();
            PayUtil.b = false;
        }
    }

    public void onPause() {
        PayUtil.b = false;
        super.onPause();
    }

    public void onDestroy() {
        this.B = true;
        this.z.b(this.I);
        this.z.b(this.H);
        this.z.b(this.J);
        LoginHelper loginHelper = this.z;
        loginHelper.h.a.remove(this.G);
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.C) {
            h();
        } else {
            finish();
        }
    }

    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.btn_go_to_load_or_pay:
                b(true);
                return;
            case R.id.play_record_list_bottom_delete_bar:
                a(false);
                return;
            case R.id.play_record_list_widget:
                g();
                return;
            case R.id.editbar_left:
                h();
                return;
            case R.id.editbar_right:
                if (!(this.u == null || this.u.getRefreshableView() == null || this.u.isRefreshing() != null)) {
                    if (this.y.size() < this.x.size()) {
                        for (VideoPlayRecord videoPlayRecord : this.x) {
                            this.y.add(videoPlayRecord.b);
                        }
                    } else {
                        this.y.clear();
                    }
                    l();
                    k();
                }
                return;
            case R.id.titlebar_left:
                finish();
                return;
            case R.id.titlebar_right_iv:
                this.C = true;
                a(Mode.DISABLED);
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.d.setOnClickListener(this);
                k();
                return;
            case R.id.btn_action:
                view = this.n;
                if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
                    i = 8;
                }
                view.setVisibility(i);
                break;
            case R.id.play_record_list_need_login_btn:
                b(false);
                return;
            default:
                break;
        }
    }

    public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        g();
    }

    public final void a() {
        this.A = true;
        g();
    }

    private void a(String str, String str2) {
        this.i.setVisibility(0);
        this.k.setText(str);
        this.j.setText(str2);
    }

    public final void b() {
        if (!com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            this.n.setVisibility(0);
        }
        if (l.b()) {
            com.xunlei.downloadprovider.member.b.d d = d();
            if (this.z.l()) {
                if (d != null) {
                    if (d.a()) {
                        if (this.w.getCount() == 0) {
                            this.i.setVisibility(8);
                            a(R.drawable.commonui_bg_list_sync, d.b(), d.d(), R.drawable.common_red_button_selector);
                            return;
                        }
                        this.p.setVisibility(8);
                        a(d.d(), d.b());
                        return;
                    }
                }
                this.i.setVisibility(8);
                this.p.setVisibility(8);
                return;
            } else if (this.w.getCount() == 0) {
                this.i.setVisibility(8);
                this.p.setVisibility(8);
                return;
            } else {
                if (d != null) {
                    if (d.a()) {
                        a(d.d(), d.b());
                        a(R.drawable.commonui_bg_vip_sync, d.b(), d.d(), R.drawable.common_red_button_selector);
                        return;
                    }
                }
                a(a((int) R.string.cloud_list_btn_pay), a((int) R.string.cloud_vod_pay_tip));
                a(R.drawable.commonui_bg_vip_sync, a((int) R.string.cloud_list_vod_empty), a((int) R.string.cloud_list_btn_pay), R.drawable.common_red_button_selector);
                return;
            }
        }
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            if (this.w.getCount() != 0) {
                this.n.setVisibility(8);
                this.p.setVisibility(8);
                a(a((int) R.string.cloud_list_btn_login), a((int) R.string.cloud_vod_load_tip));
                a(R.drawable.commonui_bg_not_login, a((int) R.string.tips_not_login), a((int) R.string.cloud_list_btn_login), R.drawable.commonui_blue_rounded_button_selector);
            }
        }
        this.i.setVisibility(8);
        a(R.drawable.commonui_bg_not_login, a((int) R.string.tips_not_login), a((int) R.string.cloud_list_btn_login), R.drawable.commonui_blue_rounded_button_selector);
    }

    private void a(int i, String str, String str2, int i2) {
        if (this.w.getCount() > 0) {
            this.p.setVisibility(8);
            this.q.setOnClickListener(null);
            return;
        }
        this.p.setVisibility(0);
        this.t.setImageResource(i);
        this.r.setVisibility(8);
        this.s.setText(str);
        this.s.setVisibility(0);
        this.q.setText(str2);
        this.q.setOnClickListener(this);
        if (i2 > 0) {
            this.q.setBackgroundResource(i2);
        }
    }

    private void a(Mode mode) {
        if (mode != null && this.u != null && this.u.getRefreshableView() != null) {
            this.u.setMode(mode);
        }
    }

    private void h() {
        this.C = false;
        a(Mode.PULL_FROM_START);
        this.y.clear();
        this.g.setText(null);
        Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.title_bar_top_out);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.delete_bottom_out);
        loadAnimation.setAnimationListener(new q(this));
        this.c.startAnimation(loadAnimation);
        this.d.startAnimation(loadAnimation2);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
    }

    private void k() {
        int size = this.y.size();
        boolean z = size > 0;
        this.d.setEnabled(z);
        this.l.setEnabled(z);
        this.m.setEnabled(z);
        int i = R.string.batch_oper_select_all;
        if (z) {
            Button button = this.e;
            if (size >= this.w.getCount()) {
                i = R.string.batch_oper_cancle_select_all;
            }
            button.setText(i);
            this.g.setText(String.format(a((int) R.string.edit_title_selected_count), new Object[]{String.valueOf(size)}));
            return;
        }
        this.e.setText(R.string.batch_oper_select_all);
        this.g.setText(R.string.cloud_list_delete_title);
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return com.xunlei.downloadprovider.h.k.a.c(str);
            } catch (String str2) {
                str2.printStackTrace();
            } catch (String str22) {
                str22.printStackTrace();
            }
        }
        return null;
    }

    private void l() {
        List<VideoPlayRecord> list = this.x;
        List arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (VideoPlayRecord videoPlayRecord : list) {
            linkedHashSet.add(videoPlayRecord.d);
        }
        int size = linkedHashSet.size();
        int size2 = list.size();
        for (int i = 0; i < size2 && arrayList.size() != size; i++) {
            VideoPlayRecord videoPlayRecord2 = (VideoPlayRecord) list.get(i);
            String str = videoPlayRecord2.d;
            if (linkedHashSet.contains(str)) {
                linkedHashSet.remove(str);
                arrayList.add(videoPlayRecord2);
            }
        }
        this.x = arrayList;
        if (this.w.getCount() == 0) {
            this.u.setEmptyView(this.o);
            this.h.mRightIv.setImageResource(R.drawable.common_delete_icon_disable);
            this.h.mRightIv.setEnabled(false);
        } else {
            this.h.mRightIv.setImageResource(R.drawable.common_menu_delete_icon_black_selector);
            this.h.mRightIv.setEnabled(true);
            if (this.A) {
                this.A = false;
            } else {
                this.u.setSelection(0);
            }
        }
        this.w.notifyDataSetChanged();
    }

    private static String a(int i) {
        return i < 0 ? "" : BrothersApplication.getApplicationInstance().getString(i);
    }

    private static void b(XLAlertDialog xLAlertDialog) {
        if (xLAlertDialog != null && xLAlertDialog.isShowing()) {
            xLAlertDialog.dismiss();
        }
    }

    public final void a(boolean z) {
        b(this.K);
        if (this.y.size() > 0) {
            this.K = new XLAlertDialog(this);
            this.K.setMessage(String.format(a((int) R.string.cloud_list_dialog_confirm_delete), new Object[]{String.valueOf(r0)}));
            this.K.setConfirmButtonText(a((int) R.string.cloud_list_dialog_confirm));
            this.K.setCancelButtonText(a((int) R.string.cloud_list_dialog_cancel));
            this.K.setOnClickConfirmButtonListener(new s(this));
            this.K.setOnClickCancelButtonListener(new d(this, z));
            this.K.show();
            return;
        }
        XLToast.showToast(getApplicationContext(), a((int) R.string.download_list_must_select_task));
    }

    private void b(boolean z) {
        if (l.b()) {
            com.xunlei.downloadprovider.member.b.d d = d();
            if (d != null) {
                new StringBuilder("goToPay：reportRenewTipClick from --> ").append(z ? "space_play_top" : "space_play_middle");
                q.a(z ? "space_play_top" : "space_play_middle", "renew", d.f(), d.g().a, f.a(PayFrom.PLAY_RECORD_LIST));
            }
            com.xunlei.downloadprovider.member.b.b.a(this, PayFrom.PLAY_RECORD_LIST, "", d != null ? d.f() : "");
            return;
        }
        this.z.a(this, new p(this), LoginFrom.SPACE_PLAY_RECORD, null);
    }

    static /* synthetic */ void c(PlayRecordActivity playRecordActivity) {
        com.xunlei.downloadprovider.member.b.d d = playRecordActivity.d();
        if (l.b() && d != null) {
            String str = "";
            if (playRecordActivity.i != null && playRecordActivity.i.getVisibility() == 0) {
                str = "space_play_top";
            } else if (playRecordActivity.p != null && playRecordActivity.p.getVisibility() == null) {
                str = "space_play_middle";
            }
            q.a(str, (long) d.e(), d.f());
        }
    }

    static /* synthetic */ void a(PlayRecordActivity playRecordActivity, VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null) {
            videoPlayRecord.h();
            if (com.xunlei.xllib.b.d.a(playRecordActivity.x)) {
                playRecordActivity.x.add(videoPlayRecord);
                return;
            }
            int i = 0;
            for (VideoPlayRecord videoPlayRecord2 : playRecordActivity.x) {
                if (videoPlayRecord2 != null && !TextUtils.isEmpty(videoPlayRecord2.l) && videoPlayRecord2.l.equals(videoPlayRecord.l)) {
                    i = playRecordActivity.x.indexOf(videoPlayRecord2);
                    playRecordActivity.x.add(i, videoPlayRecord);
                    playRecordActivity.x.remove(i + 1);
                    i = 1;
                    break;
                }
            }
            if (i == 0) {
                playRecordActivity.x.add(videoPlayRecord);
            }
        }
    }

    static /* synthetic */ void a(PlayRecordActivity playRecordActivity, b bVar) {
        if (bVar.f()) {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(playRecordActivity, bVar.a.toString(), XLLiveRoomPlayFrom.SL_PLAYCENTER_LIST_ITEM);
        } else {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLiveReplayRoom(playRecordActivity, bVar.a.toString(), XLLiveRoomPlayFrom.SL_PLAYCENTER_LIST_ITEM);
        }
    }

    static /* synthetic */ void b(PlayRecordActivity playRecordActivity, VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null) {
            if (videoPlayRecord.g() == RECORD_TYPE.TAG_SHORT_VIDEO) {
                ShortMovieDetailActivity.a(playRecordActivity, From.PLAY_LIST, videoPlayRecord.o, videoPlayRecord.n, videoPlayRecord.d, (int) videoPlayRecord.h, (int) videoPlayRecord.g, TextUtils.isEmpty(videoPlayRecord.e) ? "" : videoPlayRecord.e, videoPlayRecord.f);
                return;
            }
            n.a();
            long e = n.e(videoPlayRecord.e);
            n.a();
            TaskInfo f = n.f(e);
            if (f == null) {
                n.a();
                e = n.g(videoPlayRecord.e);
                n.a();
                f = n.f(e);
            }
            if (f == null) {
                TaskPlayInfo taskPlayInfo = new TaskPlayInfo(videoPlayRecord.e);
                taskPlayInfo.mTitle = videoPlayRecord.d;
                VodPlayerActivityNew.a(playRecordActivity, taskPlayInfo, "space_his", null, true, 0, null);
                return;
            }
            BTSubTaskInfo bTSubTaskInfo = null;
            if (k.e(f)) {
                bTSubTaskInfo = ag.a(f, videoPlayRecord.e);
            }
            com.xunlei.downloadprovider.download.player.a.m.a(playRecordActivity, f, bTSubTaskInfo, "space_his");
        }
    }

    static /* synthetic */ void b(PlayRecordActivity playRecordActivity, b bVar) {
        b(playRecordActivity.L);
        View inflate = LayoutInflater.from(playRecordActivity).inflate(R.layout.play_record_list_item_live_long_click_dialog_layout, null);
        b bVar2 = new b(inflate, bVar);
        ImageView imageView = (ImageView) bVar2.a.findViewById(R.id.play_record_list_item_icon);
        ImageView imageView2 = (ImageView) bVar2.a.findViewById(R.id.live_level);
        TextView textView = (TextView) bVar2.a.findViewById(R.id.long_play_record_list_item_name);
        TextView textView2 = (TextView) bVar2.a.findViewById(R.id.nickname);
        bVar2.c = (TextView) bVar2.a.findViewById(R.id.play_record_list_btn_delete);
        Glide.with(imageView.getContext()).load(bVar2.b.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.color.common_content_bkg_color).fallback(R.color.common_content_bkg_color).error(R.color.common_content_bkg_color).dontAnimate().transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.c(imageView.getContext(), 5)}).into(imageView);
        Glide.with(imageView2.getContext()).load(bVar2.b.e()).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(imageView2);
        textView.setText(bVar2.b.c());
        textView2.setText(bVar2.b.b());
        bVar2.c.setOnClickListener(new f(playRecordActivity, bVar));
        playRecordActivity.L = new XLAlertDialog(playRecordActivity);
        playRecordActivity.L.setContentView(inflate);
        playRecordActivity.L.setConfirmButtonText(a((int) R.string.cloud_list_info_dialog_btn));
        playRecordActivity.L.setCanceledOnTouchOutside(true);
        playRecordActivity.L.show();
    }

    static /* synthetic */ void c(PlayRecordActivity playRecordActivity, VideoPlayRecord videoPlayRecord) {
        b(playRecordActivity.L);
        View inflate = LayoutInflater.from(playRecordActivity).inflate(R.layout.play_record_list_item_long_click_dialog_layout, null);
        a aVar = new a(inflate, videoPlayRecord);
        aVar.b = (ImageView) aVar.a.findViewById(R.id.play_record_list_item_icon);
        aVar.c = (TextView) aVar.a.findViewById(R.id.long_play_record_list_item_name);
        aVar.d = (TextView) aVar.a.findViewById(R.id.long_play_record_list_item_filesize);
        aVar.e = (TextView) aVar.a.findViewById(R.id.play_record_list_btn_download);
        aVar.f = (TextView) aVar.a.findViewById(R.id.play_record_list_btn_delete);
        aVar.f.setVisibility(0);
        if (!TextUtils.isEmpty(aVar.g.d)) {
            aVar.c.setText(aVar.g.d);
            int fileIconResIdForVideo = XLFileTypeUtil.getFileIconResIdForVideo(aVar.g.d);
            ag.a(aVar.g.f, aVar.b, fileIconResIdForVideo, fileIconResIdForVideo, fileIconResIdForVideo);
        }
        String convertFileSize = aVar.g.k > 0 ? ConvertUtil.convertFileSize(aVar.g.k, 2) : aVar.a(R.string.cloud_list_info_dialog_content_size_unkown);
        aVar.d.setText(String.format(aVar.a(R.string.cloud_list_info_dialog_content_size), new Object[]{convertFileSize}));
        if (aVar.g.g() == RECORD_TYPE.TAG_SHORT_VIDEO) {
            aVar.e.setVisibility(0);
        } else {
            aVar.e.setVisibility(8);
        }
        OnClickListener eVar = new e(playRecordActivity, videoPlayRecord);
        aVar.e.setOnClickListener(eVar);
        aVar.f.setOnClickListener(eVar);
        playRecordActivity.L = new XLAlertDialog(playRecordActivity);
        playRecordActivity.L.setContentView(inflate);
        playRecordActivity.L.setConfirmButtonText(a((int) R.string.cloud_list_info_dialog_btn));
        playRecordActivity.L.setCanceledOnTouchOutside(true);
        playRecordActivity.L.show();
    }

    static /* synthetic */ void o(PlayRecordActivity playRecordActivity) {
        if (!com.xunlei.xllib.b.d.a(playRecordActivity.y)) {
            Collection hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            Set hashSet3 = new HashSet();
            List arrayList = new ArrayList();
            for (VideoPlayRecord videoPlayRecord : playRecordActivity.x) {
                long longValue = videoPlayRecord.b.longValue();
                if (playRecordActivity.y.contains(Long.valueOf(longValue))) {
                    if (longValue >= 0 || !(videoPlayRecord instanceof b)) {
                        hashSet.add(videoPlayRecord);
                        hashSet3.add(Long.valueOf(longValue));
                    } else {
                        arrayList.add(((b) videoPlayRecord).d());
                        hashSet2.add(videoPlayRecord);
                    }
                }
            }
            if (!com.xunlei.xllib.b.d.a(arrayList)) {
                playRecordActivity.F = new XLWaitingDialog(playRecordActivity);
                Callback rVar = new r(playRecordActivity, hashSet2);
                playRecordActivity.F.show();
                com.xunlei.downloadprovider.launch.b.a.a().deletePlayRecord(rVar, (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            v.a().a(hashSet3);
            playRecordActivity.x.removeAll(hashSet);
            playRecordActivity.y.clear();
            playRecordActivity.l();
        }
    }

    static /* synthetic */ void d(PlayRecordActivity playRecordActivity, VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null) {
            Object obj = videoPlayRecord.g() == RECORD_TYPE.TAG_SHORT_VIDEO ? 1 : null;
            String a = a(videoPlayRecord.l);
            if (TextUtils.isEmpty(a)) {
                XLToast.showToast(playRecordActivity.getApplicationContext(), "暂不能下载");
                return;
            }
            playRecordActivity = videoPlayRecord.d;
            if (obj != null && TextUtils.isEmpty(playRecordActivity) == null) {
                if (playRecordActivity.contains(".mp4") == null) {
                    videoPlayRecord = new StringBuilder();
                    videoPlayRecord.append(playRecordActivity);
                    videoPlayRecord.append(".mp4");
                    playRecordActivity = videoPlayRecord.toString();
                }
                playRecordActivity = com.xunlei.xllib.b.k.b(playRecordActivity, "UTF-8");
            }
            com.xunlei.downloadprovider.download.c.a(a, playRecordActivity, "", new TaskStatInfo(a, ""));
        }
    }
}
