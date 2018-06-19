package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.taobao.accs.AccsClientConfig;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.ChoicenessHotCommentView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.ChoicenessQuickCommentView;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChoicenessQuickCommentHelper */
public final class b {
    Context a;
    ChoicenessQuickCommentView b;
    boolean c;
    public boolean d;
    public ChoicenessHotCommentView e;
    public ArrayList<CommentInfo> f;
    public a g;
    private com.xunlei.downloadprovider.comment.a h = new com.xunlei.downloadprovider.comment.a();

    /* compiled from: ChoicenessQuickCommentHelper */
    public interface a {
        void a();

        void b();

        void c();
    }

    public b(Context context) {
        this.a = context;
    }

    public final void a(ViewGroup viewGroup, m mVar, List<CommentInfo> list) {
        if (!this.d) {
            this.d = true;
            a();
            this.e = new ChoicenessHotCommentView(this.a);
            ChoicenessHotCommentView choicenessHotCommentView = this.e;
            if (!(mVar == null || list == null)) {
                if (list.isEmpty() == null) {
                    mVar = Math.min(list.size(), 3);
                    if (mVar == 1) {
                        ChoicenessHotCommentView.a(choicenessHotCommentView.a, (CommentInfo) list.get(0));
                        choicenessHotCommentView.b.setVisibility(8);
                        choicenessHotCommentView.c.setVisibility(8);
                    } else if (mVar == 2) {
                        ChoicenessHotCommentView.a(choicenessHotCommentView.a, (CommentInfo) list.get(0));
                        ChoicenessHotCommentView.a(choicenessHotCommentView.b, (CommentInfo) list.get(1));
                        choicenessHotCommentView.c.setVisibility(8);
                    } else if (mVar == 3) {
                        ChoicenessHotCommentView.a(choicenessHotCommentView.a, (CommentInfo) list.get(0));
                        ChoicenessHotCommentView.a(choicenessHotCommentView.b, (CommentInfo) list.get(1));
                        ChoicenessHotCommentView.a(choicenessHotCommentView.c, (CommentInfo) list.get(2));
                    }
                    if (mVar < list.size()) {
                        choicenessHotCommentView.d.setVisibility(0);
                    } else {
                        choicenessHotCommentView.d.setVisibility(8);
                    }
                }
            }
            this.e.setOnClickListener(new g(this));
            viewGroup.addView(this.e, new LayoutParams(-1, -2));
        }
    }

    public final void a() {
        this.c = false;
        ViewUtil.removeViewFromParent(this.b);
        this.b = null;
    }

    public final void a(m mVar, ViewGroup viewGroup, String str) {
        if (!this.c) {
            if (!this.d) {
                if (com.xunlei.xllib.android.b.a(this.a)) {
                    this.h.a(new e(1, mVar.b.getGcid(), mVar.b()));
                    if (d.a().b.k()) {
                        if (mVar != null) {
                            String str2;
                            if (mVar == null) {
                                str2 = AccsClientConfig.DEFAULT_CONFIGTAG;
                            } else {
                                str2 = mVar.a.getKind();
                                str2 = "yl_nvshen".equals(str2) ? "yl_female" : "yl_nanshen".equals(str2) ? "yl_male" : "rad".equals(str2) ? (mVar.a.getLiveExtra() == null || !"2".equals(mVar.a.getLiveExtra().b)) ? "live_male" : "live_female" : AccsClientConfig.DEFAULT_CONFIGTAG;
                            }
                            p[] d = com.xunlei.downloadprovider.d.b.a().d(str2);
                            if (d != null && d.length > 0) {
                                this.b = new ChoicenessQuickCommentView(this.a);
                                this.b.setOnClickListener(new c(this));
                                this.b.getQuickCommentView().setContentsArray(d);
                                this.b.getQuickCommentView().setOnItemListener(new d(this, viewGroup, mVar, str));
                                viewGroup.addView(this.b, new LayoutParams(-1, -2));
                                this.c = true;
                                LoginHelper.a();
                                ChoicenessReporter.a(l.c(), mVar, d, str);
                            }
                        }
                        this.h.c(new h(this, mVar));
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, ViewGroup viewGroup, m mVar, p pVar) {
        if (com.xunlei.xllib.android.b.a(bVar.a)) {
            bVar.b.getQuickCommentView().setClickEnable(false);
            bVar.h.a(pVar.b, AndroidConfig.getPhoneBrand(), new f(bVar, pVar, mVar, viewGroup));
            return;
        }
        XLToast.showToast(bVar.a, "无网络连接");
    }
}
