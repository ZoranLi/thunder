package com.xunlei.downloadprovider.publiser.per;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.common.h;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.common.recommendfollow.j;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.f;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.k;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.e;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryPublishItemFragment extends Fragment implements g {
    public static boolean a = false;
    private static final String b = "HistoryPublishItemFragment";
    private long c = -1;
    private String d;
    private String e;
    private UnifiedLoadingView f;
    private ErrorBlankView g;
    private XRecyclerView h;
    private Context i;
    private bp j;
    private bo k;
    private h l;
    private a m;
    private PublisherInfo n;
    private com.xunlei.downloadprovider.player.a.a o;
    private HashMap<String, Integer> p = new HashMap(2);
    private e q;
    private com.xunlei.downloadprovider.publiser.per.a.a r;
    private boolean s = false;
    private long t = 0;
    private int u;
    private BroadcastReceiver v = new aq(this);

    public interface a {
        void b();

        void c(int i);

        void d(int i);
    }

    public static HistoryPublishItemFragment a(long j, String str, String str2, String str3, String str4) {
        HistoryPublishItemFragment historyPublishItemFragment = new HistoryPublishItemFragment();
        Bundle bundle = new Bundle(9);
        bundle.putLong(SocializeConstants.TENCENT_UID, j);
        bundle.putString("user_name", str);
        bundle.putString("user_avatar", str2);
        bundle.putString("kind", str3);
        bundle.putString("from", str4);
        historyPublishItemFragment.setArguments(bundle);
        return historyPublishItemFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.i = context;
        if (context instanceof a) {
            this.m = (a) context;
            return;
        }
        throw new IllegalArgumentException("context should implement PublishFragmentCallback");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.c = bundle.getLong(SocializeConstants.TENCENT_UID, -1);
            this.e = bundle.getString("kind");
            this.d = bundle.getString("from");
        }
        if (this.c == -1) {
            throw new IllegalArgumentException("User ID is INVALID");
        }
        bundle = new IntentFilter();
        bundle.addAction("action_website_publish_success");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.v, bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_history_publish_item_list, viewGroup, false);
        this.h = (XRecyclerView) layoutInflater.findViewById(R.id.list);
        this.h.setLayoutManager(new LinearLayoutManager(this.i));
        viewGroup = new k();
        viewGroup.a = true;
        this.h.setItemAnimator(viewGroup);
        this.h.setPullRefreshEnabled(false);
        this.h.setCheckLoadMoreInAllState(true);
        this.h.setLoadingListener(new ak(this));
        this.h.setOnTouchListener(new as(this));
        this.h.addOnScrollListener(new at(this));
        this.o = new com.xunlei.downloadprovider.player.a.a(getContext());
        this.o.a = this.h;
        this.f = (UnifiedLoadingView) layoutInflater.findViewById(R.id.lv_loading);
        this.f.setType(2);
        this.f.hide();
        this.f.setContentLayoutParams(DipPixelUtil.dip2px(80.0f));
        this.g = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.g.setErrorType(-1);
        this.g.a((int) R.drawable.commonui_bg_page_empty, (int) R.string.commonui_page_empty);
        this.g.a(null, null);
        this.g.setVisibility(8);
        this.g.setContentLayoutParams(DipPixelUtil.dip2px(80.0f));
        this.k = new bo(this, this.o, this.h);
        this.k.c = this.d;
        this.k.d = this.e;
        viewGroup = this.k;
        bundle = new StringBuilder();
        bundle.append(this.c);
        viewGroup.e = bundle.toString();
        this.k.b = 1;
        this.h.setAdapter(this.k);
        this.l = new h();
        this.r = new com.xunlei.downloadprovider.publiser.per.a.a();
        if (this.c < 0) {
            throw new IllegalArgumentException("user id is invalid");
        }
        if (b.a(this.i) != null) {
            b();
        } else {
            d();
        }
        return layoutInflater;
    }

    private void a() {
        com.xunlei.downloadprovider.homepage.follow.b.a().a(this.c, true, new ax(this));
    }

    public void onStart() {
        super.onStart();
        this.k.a();
        a = false;
    }

    public void onStop() {
        super.onStop();
        if (!a) {
            ak.a().c(PlayerTag.PERSONAL);
        }
        bo boVar = this.k;
        if (boVar.b == 1) {
            com.xunlei.downloadprovider.homepage.recommend.a.c(boVar.c, boVar.e, o.a(boVar.d));
            com.xunlei.downloadprovider.homepage.recommend.a.a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        bo boVar = this.k;
        for (bp bpVar : boVar.a) {
            bpVar.e = false;
        }
        boVar.notifyDataSetChanged();
        boVar = this.k;
        if (boVar.a != null) {
            for (bp bpVar2 : boVar.a) {
                bpVar2.f = null;
                bpVar2.d = null;
                bpVar2.c = null;
            }
        }
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.v);
    }

    public final void a(PublisherInfo publisherInfo) {
        if (publisherInfo != null) {
            this.n = publisherInfo;
            if ("rad".equals(publisherInfo.a().getKind())) {
                Object obj = (publisherInfo.a().getLiveExtra() == null || !(publisherInfo.a().getLiveExtra().a() || publisherInfo.c())) ? null : 1;
                if (obj != null) {
                    this.j = new bp(publisherInfo, 100);
                }
            }
            if (this.k != null) {
                for (bp bpVar : this.k.a) {
                    if (bpVar.b != null && (bpVar.b instanceof com.xunlei.downloadprovider.publiser.per.model.g)) {
                        ((com.xunlei.downloadprovider.publiser.per.model.g) bpVar.b).setUserInfo(this.n.a());
                    }
                }
                if (this.j != null) {
                    this.k.a(this.j);
                }
                if (this.k.getItemCount() > null) {
                    this.k.notifyDataSetChanged();
                }
            }
        }
    }

    private void b() {
        if (!this.s) {
            if (this.t == 0) {
                this.f.show();
                this.g.setVisibility(8);
            }
            this.s = true;
            this.r.a(this.c, this.t, new az(this));
        }
    }

    private ArrayList<bp> a(List<PersonalFeedInfo> list) {
        int size = list.size();
        ArrayList<bp> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            PersonalFeedInfo personalFeedInfo = (PersonalFeedInfo) list.get(i);
            if (PersonalFeedInfo.TYPE_PUB_VIDEO.equals(personalFeedInfo.getType())) {
                PublishVideoFeedInfo publishVideoFeedInfo = (PublishVideoFeedInfo) personalFeedInfo.getData();
                if (this.n != null) {
                    publishVideoFeedInfo.setUserInfo(this.n.a());
                }
                arrayList.add(new bp(publishVideoFeedInfo, 2));
            } else if (PersonalFeedInfo.TYPE_PUB_WEBSITE.equals(personalFeedInfo.getType())) {
                com.xunlei.downloadprovider.publiser.per.model.h hVar = (com.xunlei.downloadprovider.publiser.per.model.h) personalFeedInfo.getData();
                if (this.n != null) {
                    hVar.setUserInfo(this.n.a());
                }
                arrayList.add(new bp(hVar, 6));
            } else if (PersonalFeedInfo.TYPE_PUB_CINECISM.equals(personalFeedInfo.getType())) {
                f fVar = (f) personalFeedInfo.getData();
                if (this.n != null) {
                    fVar.setUserInfo(this.n.a());
                }
                arrayList.add(new bp(fVar, 9));
            }
        }
        return arrayList;
    }

    private void c() {
        this.g.setErrorType(-1);
        this.g.a((int) R.drawable.commonui_bg_page_empty, (int) R.string.commonui_page_empty);
        this.g.a(null, null);
        this.g.setVisibility(0);
    }

    private void d() {
        this.g.setErrorType(2);
        this.g.setVisibility(0);
        this.g.a("刷新", new ba(this));
        if (this.m != null) {
            this.m.b();
        }
    }

    public final void a(int i, Object obj) {
        if (i == 5) {
            com.xunlei.downloadprovider.homepage.follow.b.a().e(this.c);
        } else if (i == 7) {
            a = true;
        } else if (i == 8) {
            PublishVideoFeedInfo publishVideoFeedInfo = (PublishVideoFeedInfo) obj;
            com.xunlei.downloadprovider.homepage.recommend.a.e(publishVideoFeedInfo.getRelatedVideoInfo().getVideoId(), o.a(this.e), "shortvideo");
            i = new XLAlertDialog(this.i);
            i.setMessage((int) R.string.tips_to_delete_video);
            i.setConfirmButtonText((int) R.string.confirm);
            i.setCancelButtonText((int) R.string.cancel);
            i.setOnClickConfirmButtonListener(new bb(this, publishVideoFeedInfo));
            i.setOnClickCancelButtonListener(new al(this));
            i.show();
        } else if (i == 9) {
            i = ((com.xunlei.downloadprovider.publiser.per.model.h) obj).a.a;
            com.xunlei.downloadprovider.homepage.recommend.a.e(i, o.a(this.e), "web_url");
            obj = new XLAlertDialog(this.i);
            obj.setMessage((int) R.string.tips_to_delete_video);
            obj.setConfirmButtonText((int) R.string.confirm);
            obj.setCancelButtonText((int) R.string.cancel);
            obj.setOnClickConfirmButtonListener(new am(this, i));
            obj.setOnClickCancelButtonListener(new ao(this));
            obj.show();
        } else {
            if (i == 13) {
                i = this.m;
                obj = this.u - 1;
                this.u = obj;
                i.d(obj);
                if (this.k.getItemCount() < 10 && this.u > 20) {
                    b();
                } else if (this.k.getItemCount() == 0) {
                    c();
                }
            }
        }
    }

    public final void a(String str) {
        if (!com.xunlei.downloadprovider.homepage.follow.b.a().b(this.c) && this.p.size() < 2) {
            this.p.put(str, Integer.valueOf(1));
            if (this.p.size() == 2) {
                e eVar;
                this.q = new e(this.i);
                if (this.n != null) {
                    if (this.n.a() != null) {
                        str = this.n.a();
                        eVar = this.q;
                        eVar.d = str;
                        com.xunlei.downloadprovider.homepage.choiceness.b.a();
                        com.xunlei.downloadprovider.homepage.choiceness.b.a(eVar.d.getPortraitUrl(), eVar.a, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
                        eVar.c.setText(eVar.d.getNickname());
                        if (eVar.d != null) {
                            m.a(eVar.b, eVar.d.isAuthPub(), eVar.d.getKind());
                        }
                        str = this.q;
                        str.e.setOnClickListener(new au(this));
                        this.q.show();
                        j.a("shortvideo_usercenter_auto");
                    }
                }
                str = new VideoUserInfo();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.c);
                str.setUid(stringBuilder.toString());
                str.setNickname("迅雷用户");
                eVar = this.q;
                eVar.d = str;
                com.xunlei.downloadprovider.homepage.choiceness.b.a();
                com.xunlei.downloadprovider.homepage.choiceness.b.a(eVar.d.getPortraitUrl(), eVar.a, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
                eVar.c.setText(eVar.d.getNickname());
                if (eVar.d != null) {
                    m.a(eVar.b, eVar.d.isAuthPub(), eVar.d.getKind());
                }
                str = this.q;
                str.e.setOnClickListener(new au(this));
                this.q.show();
                j.a("shortvideo_usercenter_auto");
            }
        }
    }

    static /* synthetic */ void e(HistoryPublishItemFragment historyPublishItemFragment) {
        LoginHelper.a();
        if (l.c()) {
            historyPublishItemFragment.a();
            return;
        }
        LoginHelper.a().a(historyPublishItemFragment.i, new av(historyPublishItemFragment), LoginFrom.PERSONAL_FOLLOW, null);
        j.a(historyPublishItemFragment.c, "skip_login", "", "shortvideo_usercenter_auto");
    }

    static /* synthetic */ void a(HistoryPublishItemFragment historyPublishItemFragment, String str) {
        for (bp bpVar : historyPublishItemFragment.k.a) {
            if (bpVar.a == 6 && TextUtils.equals(((com.xunlei.downloadprovider.publiser.per.model.h) bpVar.b).a.a, str)) {
                break;
            }
        }
        bp bpVar2 = null;
        if (bpVar2 != null) {
            historyPublishItemFragment.k.b(bpVar2);
        }
        if (historyPublishItemFragment.k.getItemCount() <= null) {
            historyPublishItemFragment.c();
        }
        if (historyPublishItemFragment.m != null) {
            str = historyPublishItemFragment.m;
            int i = historyPublishItemFragment.u - 1;
            historyPublishItemFragment.u = i;
            str.d(i);
        }
    }

    static /* synthetic */ void b(HistoryPublishItemFragment historyPublishItemFragment, String str) {
        for (bp bpVar : historyPublishItemFragment.k.a) {
            if (bpVar.a == 2 && TextUtils.equals(((PublishVideoFeedInfo) bpVar.b).getRelatedVideoInfo().getVideoId(), str)) {
                break;
            }
        }
        bp bpVar2 = null;
        if (bpVar2 != null) {
            historyPublishItemFragment.k.b(bpVar2);
        }
        if (historyPublishItemFragment.k.getItemCount() <= null) {
            historyPublishItemFragment.c();
        }
        if (historyPublishItemFragment.m != null) {
            str = historyPublishItemFragment.m;
            int i = historyPublishItemFragment.u - 1;
            historyPublishItemFragment.u = i;
            str.d(i);
        }
    }

    static /* synthetic */ List a(HistoryPublishItemFragment historyPublishItemFragment, List list, List list2) {
        if (list2 != null) {
            if (!list2.isEmpty()) {
                int i = -1;
                int i2 = 0;
                while (i2 < list.size()) {
                    if (!((com.xunlei.downloadprovider.publiser.per.model.g) ((PersonalFeedInfo) list.get(i2)).getData()).equals((com.xunlei.downloadprovider.publiser.per.model.g) ((bp) list2.get(0)).b)) {
                        i2++;
                    } else if (i2 == 0) {
                        return null;
                    } else {
                        i = i2;
                        return historyPublishItemFragment.a(list.subList(0, i));
                    }
                }
                return historyPublishItemFragment.a(list.subList(0, i));
            }
        }
        return historyPublishItemFragment.a(list);
    }
}
