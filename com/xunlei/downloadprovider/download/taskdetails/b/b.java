package com.xunlei.downloadprovider.download.taskdetails.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.c;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g;
import com.xunlei.xllib.android.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TaskCommentController */
public class b implements com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a {
    private static final String f = "b";
    private LinearLayout A;
    private int B;
    private int C = 0;
    private aw D;
    private aw E;
    private p F;
    private p G;
    private boolean H = false;
    private int[] I = new int[]{R.string.comment_hint_1, R.string.comment_hint_2, R.string.comment_hint_3};
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    public RecyclerView a;
    public a b;
    public boolean c = false;
    public x d;
    public m e;
    private final Handler g;
    private DownloadTaskInfo h;
    private Context i;
    private a j;
    private com.xunlei.downloadprovider.comment.a k;
    private String l;
    private String m;
    private ArrayList<CommentInfo> n;
    private boolean o = false;
    private boolean p = false;
    private int q = 2;
    private int r = 0;
    private aw s;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a t;
    private i u;
    private g v;
    private com.xunlei.downloadprovider.shortvideo.videodetail.p[] w;
    private aw x;
    private aw y;
    private Object[] z = new Object[]{Boolean.valueOf(true), Boolean.valueOf(true)};

    /* compiled from: TaskCommentController */
    public interface a {
    }

    static /* synthetic */ void f() {
    }

    static /* synthetic */ void g() {
    }

    public b(Context context, a aVar) {
        this.i = context;
        this.g = new c(this);
        this.j = aVar;
        this.j.a.a((com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a) this);
        this.v = new g(this.i);
        this.d = new x();
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        return (downloadTaskInfo == null || com.xunlei.downloadprovider.download.engine.util.b.f(downloadTaskInfo.getResourceGcid()) == null) ? null : true;
    }

    public final void b(DownloadTaskInfo downloadTaskInfo) {
        this.h = downloadTaskInfo;
        if (this.h != null) {
            if (!k.e(downloadTaskInfo)) {
                boolean z = downloadTaskInfo != null && downloadTaskInfo.mTaskType == TaskType.MAGNET;
                if (!z) {
                    this.l = downloadTaskInfo.getResourceGcid();
                    this.m = downloadTaskInfo.getResourceGcid();
                }
            }
            this.l = downloadTaskInfo.getResourceGcid();
            this.m = downloadTaskInfo.getResourceGcid();
        }
        if (TextUtils.isEmpty(this.l)) {
            throw new IllegalArgumentException("resource id is invalid");
        }
        this.n.clear();
        this.j.b();
        this.j.a.d = -1;
        this.o = true;
        k();
        e eVar = new e(4, this.l, this.m);
        this.k.a(eVar);
        this.v.a(eVar);
        this.v.a();
        this.E.b = "评论";
        this.j.a(0, this.E);
        this.A.setVisibility(0);
        j();
        if (!k.e(downloadTaskInfo)) {
            com.xunlei.downloadprovider.download.report.a.e("comment", "normal");
        }
        this.d.c = downloadTaskInfo;
    }

    private void h() {
        new c().a = (long) this.C;
        String decimal2String = ConvertUtil.decimal2String((long) this.C, 10000, 10000, "万");
        if (!decimal2String.trim().contentEquals("0")) {
            aw awVar = this.E;
            StringBuilder stringBuilder = new StringBuilder("评论(");
            stringBuilder.append(decimal2String);
            stringBuilder.append(com.umeng.message.proguard.k.t);
            awVar.b = stringBuilder.toString();
        }
        this.j.b(this.E);
    }

    public final void b() {
        Object trim = this.t.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(this.i, "请填写评论内容");
        } else if (com.xunlei.xllib.android.b.a(this.i)) {
            this.t.a(false);
            String phoneBrand = AndroidConfig.getPhoneBrand();
            CommentInfo commentInfo = this.t.b;
            String c = c(this.h);
            int i = -1;
            if (m() && this.t.h.isChecked()) {
                i = this.e.k_();
            }
            this.v.a(trim, phoneBrand, c, i, commentInfo);
        } else {
            XLToast.showToast(this.i, "无网络连接");
        }
    }

    private static String c(DownloadTaskInfo downloadTaskInfo) {
        String str = "";
        if (downloadTaskInfo == null) {
            new StringBuilder("getAverSpeed--task=").append(downloadTaskInfo);
            return str;
        }
        if (downloadTaskInfo.mDownloadedSize > 0 && downloadTaskInfo.mDownloadDurationTime > 0) {
            long j = (long) (((((float) downloadTaskInfo.mDownloadedSize) * 1.0f) / ((float) downloadTaskInfo.mDownloadDurationTime)) * 1000.0f);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ConvertUtil.byteConvert(j, 2));
            stringBuilder.append("/s");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder("getAverSpeed--mDownloadedSize=");
        stringBuilder2.append(downloadTaskInfo.mDownloadedSize);
        stringBuilder2.append("|mDownloadDurationTime=");
        stringBuilder2.append(downloadTaskInfo.mDownloadDurationTime);
        stringBuilder2.append("|speed=");
        stringBuilder2.append(str);
        return str;
    }

    private String i() {
        if (this.w == null) {
            return "";
        }
        int length = this.w.length;
        if (length == 0) {
            return "";
        }
        int i = 1;
        if (length == 1) {
            return this.w[0].a;
        }
        String str = this.w[0].a;
        while (i < length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("_");
            stringBuilder.append(this.w[i].a);
            str = stringBuilder.toString();
            i++;
        }
        return str;
    }

    private void j() {
        this.j.c(this.D);
        this.j.a(this.y);
        this.r = 0;
        this.k.a(new l(this));
    }

    public final void c() {
        this.v.e();
        this.v.f();
        this.b = null;
        this.d.a();
    }

    public final void a(View view, int i, Object obj) {
        CommentInfo commentInfo;
        if (i == 12) {
            if (obj != null) {
                commentInfo = (CommentInfo) obj;
                if (commentInfo.getBaseCommentInfo().isPreview() != null) {
                    XLToast.showToast(this.i, "此评论暂时无法回复");
                    return;
                }
                view = this.t;
                i = new StringBuilder("回复 ");
                i.append(commentInfo.getBaseCommentInfo().getUserName());
                view.b(i.toString());
                l();
                this.t.a(commentInfo);
                view = this.l;
                i = new StringBuilder();
                i.append(commentInfo.getBaseCommentInfo().getId());
                com.xunlei.downloadprovider.download.report.a.c(view, i.toString(), "comment");
            }
        } else if (i == 9) {
            commentInfo = (CommentInfo) obj;
            this.u.a(commentInfo);
            this.u.show();
            view = this.l;
            i = new StringBuilder();
            i.append(commentInfo.getBaseCommentInfo().getId());
            com.xunlei.downloadprovider.download.report.a.c(view, i.toString(), "long_click");
        } else if (i == 11) {
            if (obj != null) {
                commentInfo = (CommentInfo) obj;
                this.v.a(commentInfo);
                view = this.l;
                i = new StringBuilder();
                i.append(commentInfo.getBaseCommentInfo().getId());
                com.xunlei.downloadprovider.download.report.a.c(view, i.toString(), "comment_like");
            }
        } else if (i == 16) {
            TargetCommentInfo targetCommentInfo = (TargetCommentInfo) obj;
            if (targetCommentInfo != null) {
                com.xunlei.downloadprovider.personal.user.account.m.b(this.i, targetCommentInfo.getUserId(), "per", targetCommentInfo.getUserName(), targetCommentInfo.getUserAvatar(), From.PERSONAL_SPACE);
                view = this.l;
                i = new StringBuilder();
                i.append(targetCommentInfo.getId());
                com.xunlei.downloadprovider.download.report.a.c(view, i.toString(), "head");
            }
        } else {
            if (i != 14) {
                if (i != 15) {
                    if (i == 22) {
                        com.xunlei.downloadprovider.shortvideo.videodetail.p pVar = (com.xunlei.downloadprovider.shortvideo.videodetail.p) obj;
                        if (pVar != null) {
                            this.t.e = pVar;
                            this.t.a(null);
                            com.xunlei.downloadprovider.download.report.a.a(this.l, "comment", pVar.a, "comment");
                            if (r.a().a(this.i, LoginFrom.DL_USER_DISCUSS_DEFAULT, this.G) == null) {
                                a(pVar.b, null);
                            }
                            return;
                        }
                        return;
                    } else if (i == 25) {
                        k();
                        return;
                    } else {
                        if (i == 0) {
                            j();
                        }
                        return;
                    }
                }
            }
            commentInfo = (CommentInfo) obj;
            if (commentInfo != null) {
                this.v.e();
                this.v.f();
                com.xunlei.downloadprovider.personal.user.account.m.a(this.i, commentInfo.getUserId(), "per", commentInfo.getUserName(), commentInfo.getUserAvatar(), From.VIDEO_DETAIL);
                view = this.l;
                i = new StringBuilder();
                i.append(commentInfo.getBaseCommentInfo().getId());
                com.xunlei.downloadprovider.download.report.a.c(view, i.toString(), "head");
            }
        }
    }

    private void k() {
        this.w = com.xunlei.downloadprovider.d.b.a().d("download_resource");
        this.x.b = this.w;
        this.j.b(this.x);
        this.t.a(this.w);
    }

    private void l() {
        if (this.t == null) {
            this.t = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.i);
        }
        if (this.t.isShowing()) {
            this.t.a(this.w);
            return;
        }
        this.t.a(this.w);
        com.xunlei.downloadprovider.download.report.a.b(this.l, "input", i(), m());
        if (m()) {
            this.t.a(0);
        } else {
            this.t.a(8);
        }
        if (!m() || BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).getBoolean("download_showed_edit_comment_guide", false)) {
            this.t.show();
            return;
        }
        BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).edit().putBoolean("download_showed_edit_comment_guide", true).apply();
        View inflate = LayoutInflater.from(this.i).inflate(R.layout.layout_download_detail_guide, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_comment_guide);
        int a = d.a(this.i);
        int b = d.b(this.i);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.i.getResources(), R.drawable.download_detail_show_progress_guide);
        int width = (decodeResource.getWidth() * b) / a;
        imageView.setImageBitmap(Bitmap.createBitmap(decodeResource, 0, decodeResource.getHeight() - width, decodeResource.getWidth(), width));
        Dialog dialog = new Dialog(this.i);
        inflate.setOnClickListener(new o(this, dialog));
        dialog.setOnDismissListener(new p(this));
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setDimAmount(0.0f);
        }
        dialog.show();
    }

    private void a(String str, CommentInfo commentInfo) {
        if (com.xunlei.xllib.android.b.a(this.i)) {
            String phoneBrand = AndroidConfig.getPhoneBrand();
            String c = c(this.h);
            this.g.sendEmptyMessageDelayed(120, 500);
            if (this.t.isShowing()) {
                this.t.dismiss();
            }
            int i = -1;
            if (m() && this.t.h.isChecked()) {
                i = this.e.k_();
            }
            this.v.a(str, phoneBrand, c, i, commentInfo);
            return;
        }
        XLToast.showToast(this.i, "无网络连接");
    }

    private boolean m() {
        return this.e != null && k.c(this.h) && com.xunlei.downloadprovider.d.d.a().d.u() && this.e.k_() != 0;
    }

    public static boolean a(CommentInfo commentInfo) {
        return (!com.xunlei.downloadprovider.d.d.a().d.u() || commentInfo.getPlayPosition() <= null) ? null : true;
    }

    public final void d() {
        this.n.clear();
        this.j.b();
        this.A.setVisibility(8);
        this.o = false;
    }

    public final void a(boolean z) {
        if (this.A != null) {
            if (z) {
                this.A.setVisibility(0);
                this.o = this.p;
                return;
            }
            this.p = this.o;
            this.A.setVisibility(8);
            this.o = false;
        }
    }

    public final void a() {
        this.H = false;
        this.J = false;
        this.K = false;
        this.d.a();
    }

    public final void a(View view, RecyclerView recyclerView) {
        this.a = recyclerView;
        this.A = (LinearLayout) view.findViewById(R.id.lyt_write_comment);
        TextView textView = (TextView) view.findViewById(R.id.tv_write_comment);
        this.B = this.I[(int) (Math.random() * 3.0d)];
        textView.setHint(this.B);
        this.A.setClickable(true);
        textView.setOnClickListener(new q(this));
        this.s = new aw(9);
        this.v.a = new r(this);
        this.a.addOnScrollListener(new s(this));
        this.u = new i(this.i);
        this.u.a(new f(this));
        this.u.b(new g(this));
        this.u.c(new h(this));
        this.u.d(new i(this));
        this.t = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.i);
        view = this.t;
        view.j = null;
        view.g.setVisibility(8);
        view.f.setText("一键评论");
        view.f.setTextColor(Color.parseColor("#b3ffffff"));
        this.t.i = new v(this);
        this.t.a(new w(this));
        this.t.d = new d(this);
        view = this.t;
        view.h.setOnCheckedChangeListener(new e(this));
        this.F = new t(this);
        this.G = new u(this);
        this.k = new com.xunlei.downloadprovider.comment.a();
        this.k.d = 20;
        this.n = new ArrayList();
        this.w = com.xunlei.downloadprovider.d.b.a().d("download_resource");
        this.E = new aw();
        this.E.a = 10;
        this.E.b = "评论";
        this.E.c = "new";
        this.x = new aw();
        this.x.a = 4;
        this.x.b = this.w;
        this.x.c = this.z;
        this.D = new aw();
        this.D.a = 11;
        this.D.b = null;
        this.y = new aw();
        this.y.a = 5;
        this.y.b = null;
    }

    public final void a(boolean z, boolean z2, ag agVar) {
        if (z2) {
            this.K = true;
        }
        if (this.c) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.a.getLayoutManager();
            if (!this.L) {
                if (linearLayoutManager.findLastVisibleItemPosition() > agVar.d() - true) {
                    this.L = true;
                    if (!this.J && this.K) {
                        this.J = true;
                        com.xunlei.downloadprovider.download.report.a.e("comment", "bt");
                    }
                }
            } else if (linearLayoutManager.findLastVisibleItemPosition() < agVar.d()) {
                this.L = false;
            } else if (!(!z || this.J || !z2 || linearLayoutManager.findFirstCompletelyVisibleItemPosition() || this.J)) {
                this.J = true;
                com.xunlei.downloadprovider.download.report.a.e("comment", "bt");
            }
        }
    }

    static /* synthetic */ void d(b bVar) {
        bVar.t.b(bVar.i.getResources().getString(bVar.B));
        bVar.l();
        bVar.t.a(null);
        com.xunlei.downloadprovider.download.report.a.c(bVar.l, "0", "input");
    }

    static /* synthetic */ void a(b bVar, CommentInfo commentInfo) {
        long j;
        String str;
        b bVar2 = bVar;
        CommentInfo commentInfo2 = commentInfo;
        bVar2.g.removeMessages(120);
        bVar2.j.a(bVar2.x);
        bVar2.j.a(bVar2.y);
        bVar2.t.a(false);
        bVar2.t.dismiss();
        bVar2.t.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = 0;
        } else {
            j = targetCommentInfo.getId();
        }
        com.xunlei.downloadprovider.shortvideo.videodetail.p pVar = bVar2.t.e;
        bVar2.t.a(j);
        bVar2.t.e = null;
        String str2 = "success";
        String str3 = ITagManager.SUCCESS;
        String str4 = bVar2.l;
        String valueOf = String.valueOf(j);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commentInfo.getId());
        String stringBuilder2 = stringBuilder.toString();
        String str5 = targetCommentInfo == null ? "comment" : MessageInfo.REPLY;
        boolean z = pVar != null;
        if (pVar != null) {
            str = pVar.a;
        } else {
            str = "";
        }
        com.xunlei.downloadprovider.download.report.a.a(str2, str3, str4, valueOf, stringBuilder2, str5, z, str, bVar2.t.h.isChecked());
        bVar2.j.a(bVar2.y);
        bVar2.j.a(bVar2.x);
        aw awVar = new aw(17, commentInfo2);
        bVar2.n.add(0, commentInfo2);
        bVar2.j.a(1, awVar);
        bVar2.C++;
        bVar.h();
    }

    static /* synthetic */ void a(b bVar, String str) {
        String str2;
        b bVar2 = bVar;
        if (TextUtils.isEmpty(bVar2.t.a())) {
            bVar2.t.a(false);
        } else {
            bVar2.t.a(true);
        }
        bVar2.g.removeMessages(120);
        bVar2.g.sendEmptyMessage(121);
        CommentInfo commentInfo = bVar2.t.b;
        long id = commentInfo == null ? 0 : commentInfo.getId();
        com.xunlei.downloadprovider.shortvideo.videodetail.p pVar = bVar2.t.e;
        bVar2.t.e = null;
        String str3 = "fail";
        String str4 = bVar2.l;
        String valueOf = String.valueOf(id);
        String str5 = "";
        String str6 = commentInfo == null ? "comment" : MessageInfo.REPLY;
        boolean z = pVar != null;
        if (pVar != null) {
            str2 = pVar.a;
        } else {
            str2 = "";
        }
        com.xunlei.downloadprovider.download.report.a.a(str3, str, str4, valueOf, str5, str6, z, str2, bVar2.t.h.isChecked());
    }

    static /* synthetic */ void a(b bVar, long j) {
        List<aw> arrayList = new ArrayList(1);
        for (com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar : bVar.j.b) {
            aw awVar = (aw) aVar.c;
            if (awVar.a == 17) {
                CommentInfo commentInfo = (CommentInfo) awVar.b;
                if (commentInfo.getBaseCommentInfo().getId() == j) {
                    arrayList.add(awVar);
                } else {
                    List targetCommentList = commentInfo.getBaseCommentInfo().getTargetCommentList();
                    if (targetCommentList != null && targetCommentList.size() > 0) {
                        TargetCommentInfo targetCommentInfo = (TargetCommentInfo) targetCommentList.get(0);
                        if (targetCommentInfo.getId() == j) {
                            targetCommentInfo.setId(-1);
                            bVar.j.b(awVar);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > null) {
            for (aw awVar2 : arrayList) {
                bVar.n.remove(awVar2.b);
                bVar.j.a(awVar2);
            }
            if (bVar.n.isEmpty() != null) {
                bVar.j.a(bVar.x);
                bVar.j.a(bVar.y);
                bVar.z[0] = Boolean.valueOf(true);
                bVar.z[1] = Boolean.valueOf(true);
                bVar.j.c(bVar.x);
                com.xunlei.downloadprovider.download.report.a.b(bVar.l, "comment", bVar.i(), bVar.m());
            }
            bVar.C -= arrayList.size();
            bVar.h();
        }
    }

    static /* synthetic */ void j(b bVar) {
        if (bVar.r != 0) {
            if (bVar.q != 0) {
                if (!bVar.n.isEmpty()) {
                    bVar.q = 0;
                    bVar.j.c(bVar.s);
                    bVar.k.b(new m(bVar));
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, List list) {
        b<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> bVar2 = bVar.v.b;
        if (bVar2 != null && bVar2.size() > 0) {
            for (com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a aVar : bVar2) {
                for (CommentInfo commentInfo : list) {
                    if (commentInfo.getBaseCommentInfo().getId() == aVar.a) {
                        commentInfo.getBaseCommentInfo().setLiked(true);
                        if (!aVar.d) {
                            commentInfo.getBaseCommentInfo().setLikeCount(commentInfo.getBaseCommentInfo().getLikeCount() + 1);
                        }
                    }
                }
            }
        }
    }
}
