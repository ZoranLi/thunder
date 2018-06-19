package com.xunlei.downloadprovider.personal.message;

import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.frame.BaseCacheViewFragment;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import com.xunlei.downloadprovider.personal.message.data.c;
import com.xunlei.downloadprovider.personal.message.data.f;
import com.xunlei.downloadprovider.personal.message.data.k;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.t;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

public class MessageItemFragment extends BaseCacheViewFragment implements f, a {
    private static final String c = "MessageItemFragment";
    private LoginHelper A = LoginHelper.a();
    private boolean B;
    private boolean C;
    private BroadcastReceiver D = new f(this);
    private d E = new q(this);
    private p F = new t(this);
    boolean a;
    boolean b = false;
    private Context d;
    private RecyclerView e;
    private e f;
    private long g = -1;
    private UnifiedLoadingView h;
    private ErrorBlankView i;
    private List<MessageInfo> j;
    private boolean k = true;
    private LinearLayoutManager l;
    private int m = 2;
    private int n = 0;
    private MessageInfo o;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a p;
    private ab q;
    private ClipboardManager r;
    private g s;
    private com.xunlei.downloadprovider.personal.message.data.g t;
    private String u = "0";
    private aa v;
    private MessageType w;
    private long x;
    private int y;
    private Handler z = new Handler(Looper.getMainLooper());

    public static MessageItemFragment a(MessageType messageType) {
        MessageItemFragment messageItemFragment = new MessageItemFragment();
        Bundle bundle = new Bundle(1);
        bundle.putSerializable(PushMessageHelper.MESSAGE_TYPE, messageType);
        messageItemFragment.setArguments(bundle);
        return messageItemFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = this.A.g.c();
        if (this.g == 0) {
            this.g = this.A.g.c();
        }
        this.w = (MessageType) getArguments().getSerializable(PushMessageHelper.MESSAGE_TYPE);
        this.r = (ClipboardManager) this.d.getSystemService("clipboard");
        this.s = new g(this.d);
        this.t = new com.xunlei.downloadprovider.personal.message.data.g();
        this.A.a(this.E);
        bundle = j.b().c();
        switch (t.a[this.w.ordinal()]) {
            case 1:
                bundle = bundle.c;
                break;
            case 2:
                bundle = bundle.d;
                break;
            case 3:
                bundle = bundle.a;
                break;
            case 4:
                bundle = bundle.b;
                break;
            default:
                bundle = null;
                break;
        }
        this.y = bundle;
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.D, new IntentFilter("following_id_list_loaded"));
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_history_message_item_list, viewGroup, false);
        this.e = (RecyclerView) layoutInflater.findViewById(R.id.list);
        this.h = (UnifiedLoadingView) layoutInflater.findViewById(R.id.lv_loading);
        this.i = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.l = new LinearLayoutManager(this.d);
        this.e.setLayoutManager(this.l);
        this.h.setType(2);
        this.h.hide();
        this.i.setErrorType(0);
        this.i.setVisibility(4);
        this.o = new MessageInfo();
        this.o.setType(-1);
        this.e.setLayoutManager(new LinearLayoutManager(this.d));
        this.i.a("刷新", new v(this));
        this.i.setOnTouchListener(new w(this));
        this.h.setOnTouchListener(new x(this));
        this.s.a = new y(this);
        this.e.addOnScrollListener(new z(this));
        this.q = new ab(this.d);
        viewGroup = this.q;
        viewGroup.a.setOnClickListener(new aa(this));
        viewGroup = this.q;
        viewGroup.b.setOnClickListener(new g(this));
        viewGroup = this.q;
        viewGroup.c.setOnClickListener(new h(this));
        viewGroup = this.q;
        viewGroup.d.setOnClickListener(new i(this));
        viewGroup = this.q;
        viewGroup.e.setOnClickListener(new j(this));
        this.p = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.d);
        this.p.a(new k(this));
        this.B = true;
        this.a = true;
        this.f = new e(this);
        this.e.setAdapter(this.f);
        this.j = new ArrayList();
        LoginHelper.a();
        if (l.c() != null) {
            d();
        }
        if (this.v == null) {
            this.v = new u(this);
        }
        ab.a().a(this.v);
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        if (this.f == null) {
            this.f.notifyDataSetChanged();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.B = z;
        if (z) {
            this.a = true;
        }
    }

    public final void a() {
        if (this.f != null && this.f.a != null && this.f.getItemCount() > 0) {
            for (MessageInfo messageInfo : this.f.a) {
                if (!messageInfo.isHasRead()) {
                    messageInfo.setHasRead(true);
                    this.f.notifyItemChanged(this.f.a.indexOf(messageInfo));
                }
            }
        }
    }

    public final void b() {
        String trim = this.p.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(this.d, "请填写评论内容");
        } else if (b.a(this.d)) {
            this.p.a(false);
            String phoneBrand = AndroidConfig.getPhoneBrand();
            CommentInfo commentInfo = (MessageInfo) this.p.b;
            a((MessageInfo) commentInfo);
            this.s.a(trim, phoneBrand, commentInfo);
        } else {
            XLToast.showToast(this.d, "无网络连接");
        }
    }

    private void a(MessageInfo messageInfo) {
        e eVar = new e();
        if (MessageInfo.isWebSiteType(messageInfo.getType())) {
            eVar.c = messageInfo.getWebsiteInfo().a;
            eVar.b = messageInfo.getWebsiteInfo().a;
            eVar.a = 5;
        } else {
            eVar.c = messageInfo.getSourceId();
            eVar.b = messageInfo.getRelateGcid();
            if (messageInfo.getType() != 7) {
                if (messageInfo.getType() != 6) {
                    eVar.a = 1;
                }
            }
            eVar.a = 4;
        }
        this.s.a(eVar);
    }

    private void d() {
        this.h.show();
        this.i.setVisibility(4);
        this.n = 0;
        if (this.t != null) {
            this.t.a(this.g, this.u, true, true, this.w, this);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.d = context;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onDestroy() {
        if (this.g == this.A.g.c() && this.t != null) {
            com.xunlei.downloadprovider.personal.message.data.g gVar = this.t;
            if (gVar.a != null) {
                gVar.a.clear();
            }
        }
        super.onDestroy();
        if (this.v != null) {
            ab.a().b(this.v);
        }
        this.A.b(this.E);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.D);
    }

    private void a(long j) {
        List<MessageInfo> arrayList = new ArrayList(1);
        for (MessageInfo messageInfo : this.f.a) {
            if (MessageInfo.isValidMessageType(messageInfo.getType()) && messageInfo.getMsgid() == j) {
                arrayList.add(messageInfo);
            }
        }
        if (arrayList.size() > null) {
            for (MessageInfo messageInfo2 : arrayList) {
                this.j.remove(messageInfo2);
                this.f.a(messageInfo2);
            }
            if (this.j.isEmpty() != null) {
                this.i.setErrorType(0);
                this.i.a(null, null);
                this.i.setVisibility(0);
            }
        }
    }

    public final void a(int i, Object obj, boolean z) {
        boolean z2 = false;
        MessageInfo messageInfo;
        if (i == 2) {
            if (obj != null) {
                messageInfo = (MessageInfo) obj;
                i = this.q;
                if (messageInfo == null) {
                    throw new IllegalArgumentException("target comment info is NULL");
                }
                i.f = messageInfo;
                i = messageInfo.getType();
                if (i != 7) {
                    switch (i) {
                        case 1:
                            i = this.q;
                            if (i.b) {
                                i.b.setVisibility(0);
                                break;
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            break;
                    }
                }
                i = this.q;
                if (i.b) {
                    i.b.setVisibility(true);
                }
                this.q.show();
                if (messageInfo.isHasRead() == 0) {
                    messageInfo.setHasRead(true);
                    if (this.f != 0) {
                        this.f.notifyDataSetChanged();
                    }
                }
            }
        } else if (i == 1) {
            if (obj != null) {
                messageInfo = (MessageInfo) obj;
                if (messageInfo.getUserId() != 0) {
                    m.a(this.d, messageInfo.getUserId(), "per", messageInfo.getUserName(), messageInfo.getUserAvatar(), From.INFO_CENTER);
                } else {
                    XLToast.showToast(this.d, "该用户未登录");
                }
                if (messageInfo.isHasRead() == 0) {
                    messageInfo.setHasRead(true);
                    if (this.f != 0) {
                        this.f.notifyDataSetChanged();
                    }
                }
            }
        } else if (i == 3) {
            if (obj != null) {
                messageInfo = (MessageInfo) obj;
                if (messageInfo.isHasRead() == 0) {
                    messageInfo.setHasRead(true);
                    if (this.f != 0) {
                        this.f.notifyDataSetChanged();
                    }
                }
                if (messageInfo.getType() != 7) {
                    if (messageInfo.getType() != 6) {
                        if (MessageInfo.isWebSiteType(messageInfo.getType()) == 0) {
                            i = messageInfo.getVideoErrorTextMes();
                            if (TextUtils.isEmpty(i)) {
                                ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
                                aVar.u = ShortMovieDetailActivity.From.MESSAGE_CENTER;
                                aVar.a = messageInfo.getSourceId();
                                aVar.b = messageInfo.getRelateGcid();
                                aVar.s = z;
                                aVar.t = false;
                                ShortMovieDetailActivity.a(getContext(), aVar);
                                return;
                            }
                            XLToast.showToast(this.d, i);
                            return;
                        } else if (messageInfo.isSiteStatusError() != 0) {
                            XLToast.showToast(this.d, messageInfo.getSiteErrorTextMsg());
                            return;
                        } else {
                            i = messageInfo.getWebsiteInfo();
                            if (messageInfo.getType() || messageInfo.getType() == true) {
                                z2 = true;
                            }
                            WebsiteDetailActivity.a(this.d, new VideoUserInfo(), i, z2 ? "personal_community_messagelike" : "personal_community_messagediscuss");
                            return;
                        }
                    }
                }
                i = messageInfo.getRelateGcid();
                n.a();
                i = n.f(i);
                if (i > -1) {
                    com.xunlei.downloadprovider.download.a.b(getContext(), i, "message_center", null);
                } else {
                    XLToast.showToast(this.d, "本地该下载资源已被删除");
                }
            }
        } else if (i == true) {
            if (obj != null) {
                messageInfo = (MessageInfo) obj;
                long userId = messageInfo.getUserId();
                if (com.xunlei.downloadprovider.homepage.follow.b.a().b(messageInfo.getUserId()) == 0) {
                    b(userId);
                } else {
                    c(userId);
                }
                if (messageInfo.isHasRead() == 0) {
                    messageInfo.setHasRead(true);
                    if (this.f != 0) {
                        this.f.notifyDataSetChanged();
                    }
                }
            }
        } else if (i == true && obj != null) {
            CommentInfo commentInfo = (MessageInfo) obj;
            if (commentInfo.isHasRead() == 0) {
                commentInfo.setHasRead(true);
                if (this.f != 0) {
                    this.f.notifyDataSetChanged();
                }
            }
            if (commentInfo.isPreview() != 0) {
                XLToast.showToast(this.d, "此评论暂时无法回复");
                return;
            }
            i = this.p;
            z = new StringBuilder("回复 ");
            z.append(commentInfo.getUserName());
            i.b(z.toString());
            if (this.p == 0) {
                this.p = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.d);
            }
            if (this.p.isShowing() == 0) {
                this.p.show();
            }
            this.p.a(commentInfo);
            q.d();
        }
    }

    private void e() {
        if (!(this.C || this.t == null || this.f == null || this.f.a == null || this.f.a.size() == 0)) {
            com.xunlei.downloadprovider.personal.message.data.a aVar = this.t;
            long j = this.g;
            MessageType messageType = this.w;
            String str = "http://api-shoulei-ssl.xunlei.com/msgcenter/unread_comment?";
            switch (com.xunlei.downloadprovider.personal.message.data.p.a[messageType.ordinal()]) {
                case 1:
                    str = "http://api-shoulei-ssl.xunlei.com/msgcenter/unread_star?";
                    break;
                case 2:
                    str = "http://api-shoulei-ssl.xunlei.com/msgcenter/unread_comment?";
                    break;
                case 3:
                    str = "http://api-shoulei-ssl.xunlei.com/msgcenter/unread_follow?";
                    break;
                default:
                    break;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("user_id=");
            stringBuilder.append(j);
            XLThreadPool.execute(new c(aVar, stringBuilder.toString(), new com.xunlei.downloadprovider.personal.message.data.j(aVar, messageType), new k(aVar)));
            this.C = true;
        }
    }

    public final void a(boolean z) {
        this.b = z;
        this.i.setVisibility(4);
        this.n = false;
        if (this.t) {
            this.t.a(this.g, "0", true, false, this.w, this);
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.data.vo.a aVar, boolean z, MessageType messageType) {
        if (messageType == this.w) {
            this.h.hide();
            this.i.setVisibility(4);
            this.n = 2;
            this.m = 2;
            if (z) {
                this.e.scrollToPosition(0);
                this.C = false;
                this.j.clear();
                this.f.a.clear();
                if (!(aVar == null || aVar.c == null)) {
                    this.x = (long) aVar.c.size();
                    if (this.B) {
                        q.a(this.w, (long) this.y);
                    }
                }
            }
            this.f.a(this.o);
            if ((aVar == null || aVar.c == null || aVar.c.isEmpty()) && this.j.isEmpty()) {
                this.i.setErrorType(0);
                this.i.a(null, null);
                this.i.setVisibility(0);
                return;
            }
            this.u = aVar.b;
            this.j.addAll(aVar.c);
            e eVar = this.f;
            Object obj = aVar.c;
            if (obj != null) {
                if (!obj.isEmpty()) {
                    int size = eVar.a.size();
                    eVar.a.addAll(obj);
                    eVar.notifyItemRangeInserted(size, obj.size());
                }
            }
            if (aVar.c.size() < 20) {
                this.k = false;
            } else {
                messageType = this.f;
                MessageInfo messageInfo = this.o;
                if (messageInfo != null) {
                    messageType.a.add(messageInfo);
                    messageType.notifyItemInserted(messageType.a.size() - 1);
                }
            }
            this.f.notifyDataSetChanged();
            if (!(!z || aVar == null || aVar.c == null || this.a == null || this.t == null)) {
                e();
            }
        }
    }

    public final void a(List<MessageInfo> list, boolean z, MessageType messageType) {
        if (messageType == this.w) {
            if (z) {
                if (this.h) {
                    this.h.hide();
                }
                this.j = list;
                if (this.j == null) {
                    this.j = new ArrayList();
                }
                if (this.j != null) {
                    if (this.j.isEmpty() == null) {
                        this.n = 2;
                        if (this.j.size() < 20) {
                            this.k = false;
                        }
                        list = this.f;
                        z = this.j;
                        if (z) {
                            if (z.isEmpty() == null) {
                                list.a.clear();
                                list.a.addAll(z);
                                list.notifyDataSetChanged();
                            }
                        }
                        if (!(this.a == null || this.t == null)) {
                            e();
                        }
                    }
                }
                this.i.setErrorType(2);
                this.i.setVisibility(0);
                this.i.a("刷新", new l(this));
                this.n = 1;
                e();
            } else if (this.f != null) {
                this.f.a(this.o);
            }
        }
    }

    public final void a(long j, MessageType messageType, boolean z) {
        if (messageType == this.w) {
            if (z) {
                XLToast.showToast(getContext(), "删除消息成功");
                a(j);
                return;
            }
            XLToast.showToast(getContext(), "删除消息失败");
        }
    }

    private void b(long j) {
        if (l.c()) {
            com.xunlei.downloadprovider.homepage.follow.b.a().a(j, true, new m(this));
        } else {
            this.A.a(getContext(), new n(this, j), LoginFrom.CHANNEL_FLOW_FOLLOW, null);
        }
    }

    private void c(long j) {
        if (l.c()) {
            XLAlertDialog xLAlertDialog = new XLAlertDialog(this.d);
            xLAlertDialog.setMessage((CharSequence) "确定取消关注吗?");
            xLAlertDialog.setOnClickConfirmButtonListener(new o(this, j));
            xLAlertDialog.setOnClickCancelButtonListener(new p(this));
            xLAlertDialog.show();
            return;
        }
        this.A.a(getContext(), new r(this, j), LoginFrom.CHANNEL_FLOW_FOLLOW, null);
    }

    static /* synthetic */ void d(MessageItemFragment messageItemFragment) {
        if (messageItemFragment.f != null) {
            messageItemFragment.f.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void k(MessageItemFragment messageItemFragment) {
        if (messageItemFragment.n != 0) {
            if (messageItemFragment.m != 0) {
                if (messageItemFragment.j != null) {
                    if (!messageItemFragment.j.isEmpty()) {
                        messageItemFragment.m = 0;
                        if (messageItemFragment.t != null) {
                            messageItemFragment.t.a(messageItemFragment.g, messageItemFragment.u, false, false, messageItemFragment.w, messageItemFragment);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(CommentInfo commentInfo) {
        if (commentInfo != null) {
            commentInfo.setLikeCount(commentInfo.getLikeCount() + 1);
            commentInfo.setLiked(true);
        }
    }
}
