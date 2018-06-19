package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.model.CommentVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.LikeVideoFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import com.xunlei.downloadprovider.publiser.per.model.c;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.i;
import com.xunlei.downloadprovider.shortvideo.videodetail.k;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

public class HistoryDynamicItemFragment extends Fragment implements g {
    private static final String a = "HistoryDynamicItemFragment";
    private Context b;
    private XRecyclerView c;
    private bo d;
    private long e = -1;
    private UnifiedLoadingView f;
    private ErrorBlankView g;
    private String h;
    private com.xunlei.downloadprovider.shortvideo.videodetail.a i;
    private i j;
    private com.xunlei.downloadprovider.shortvideo.videodetail.model.g k;
    private a l;
    private com.xunlei.downloadprovider.publiser.per.a.a m;
    private boolean n = false;
    private long o = 0;
    private int p;
    private p q = new u(this);

    public interface a {
        void a();

        void a(int i);

        void b(int i);
    }

    public final void a(String str) {
    }

    public static HistoryDynamicItemFragment a(long j, String str) {
        HistoryDynamicItemFragment historyDynamicItemFragment = new HistoryDynamicItemFragment();
        Bundle bundle = new Bundle(2);
        bundle.putLong(SocializeConstants.TENCENT_UID, j);
        bundle.putString("kind", str);
        historyDynamicItemFragment.setArguments(bundle);
        return historyDynamicItemFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.e = bundle.getLong(SocializeConstants.TENCENT_UID, -1);
            this.h = bundle.getString("kind", "");
        }
        if (this.e == -1) {
            throw new IllegalArgumentException("User ID is INVALID");
        }
        this.k = new com.xunlei.downloadprovider.shortvideo.videodetail.model.g(this.b);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_history_publish_item_list, viewGroup, false);
        this.c = (XRecyclerView) layoutInflater.findViewById(R.id.list);
        this.c.setLayoutManager(new LinearLayoutManager(this.b));
        this.c.setPullRefreshEnabled(false);
        this.c.setCheckLoadMoreInAllState(true);
        viewGroup = new k();
        viewGroup.a = true;
        this.c.setItemAnimator(viewGroup);
        this.c.setLoadingListener(new s(this));
        this.c.addItemDecoration(new v(this, (int) getResources().getDimension(R.dimen.recycle_view_divider_height), new ColorDrawable(Color.parseColor("#efeff0"))));
        this.f = (UnifiedLoadingView) layoutInflater.findViewById(R.id.lv_loading);
        this.f.setType(2);
        this.f.hide();
        this.f.setContentLayoutParams(DipPixelUtil.dip2px(80.0f));
        this.g = (ErrorBlankView) layoutInflater.findViewById(R.id.ev_error);
        this.g.setErrorType(-1);
        this.g.a((int) R.drawable.commonui_bg_page_empty, (int) R.string.commonui_page_empty_for_like_and_comment);
        this.g.a(null, null);
        this.g.setVisibility(4);
        this.g.setContentLayoutParams(DipPixelUtil.dip2px(80.0f));
        this.k.a = new w(this);
        this.j = new i(this.b);
        this.j.a(new x(this));
        this.j.b(new y(this));
        this.j.c(new z(this));
        this.j.d(new aa(this));
        this.i = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.b);
        this.i.a(new ab(this));
        this.m = new com.xunlei.downloadprovider.publiser.per.a.a();
        this.d = new bo(this, null, this.c);
        this.c.setAdapter(this.d);
        if (this.e < 0) {
            throw new IllegalArgumentException("user id is invalid");
        }
        if (b.a(this.b) != null) {
            b();
        } else {
            d();
        }
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
    }

    public final void a() {
        String trim = this.i.a().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(this.b, "请填写评论内容");
        } else if (b.a(this.b)) {
            this.i.a(false);
            String phoneBrand = AndroidConfig.getPhoneBrand();
            CommentInfo commentInfo = this.i.b;
            a(commentInfo);
            this.k.a(trim, phoneBrand, commentInfo);
        } else {
            XLToast.showToast(this.b, "无网络连接");
        }
    }

    private void a(CommentInfo commentInfo) {
        if (commentInfo.getType() == CommentInfo.TYPE_VIDEO) {
            com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar = new com.xunlei.downloadprovider.shortvideo.videodetail.model.b();
            bVar.a().setVideoId(commentInfo.getSourceId());
            bVar.a().setGcid(commentInfo.getBaseCommentInfo().getGcid());
            this.k.a(bVar, false);
        } else if (commentInfo.getType() == CommentInfo.TYPE_WEBSITE) {
            r0 = new e(5, commentInfo.getSourceId(), commentInfo.getSourceId());
            this.k.c = Long.parseLong(commentInfo.getRelatedUserInfo().getUid());
            this.k.a(r0);
        } else {
            if (commentInfo.getType() == CommentInfo.TYPE_CINECISM) {
                r0 = new e(8, commentInfo.getSourceId(), commentInfo.getSourceId());
                this.k.c = Long.parseLong(commentInfo.getRelatedUserInfo().getUid());
                this.k.a(r0);
            }
        }
    }

    private void b() {
        if (!this.n) {
            if (this.o == 0) {
                this.f.show();
                this.g.setVisibility(4);
            }
            this.n = true;
            XLThreadPool.execute(new com.xunlei.downloadprovider.publiser.per.a.e(this.m, this.e, this.o, new ac(this)));
        }
    }

    private void c() {
        this.g.setErrorType(-1);
        this.g.a((int) R.drawable.commonui_bg_page_empty, (int) R.string.commonui_page_empty_for_like_and_comment);
        this.g.a(null, null);
        this.g.setVisibility(0);
    }

    private void d() {
        this.g.setErrorType(2);
        this.g.setVisibility(0);
        this.g.a("刷新", new t(this));
        if (this.l != null) {
            this.l.a();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.b = context;
        if (context instanceof a) {
            this.l = (a) context;
            return;
        }
        throw new IllegalArgumentException("context should implement PublishFragmentCallback");
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onDestroy() {
        this.k.e();
        super.onDestroy();
    }

    public final void a(int i, Object obj) {
        CommentVideoFeedInfo commentVideoFeedInfo;
        String str;
        if (i == 0) {
            if (obj != null) {
                String str2;
                StatEvent build;
                this.k.e();
                com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a aVar = new com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a();
                BaseVideoInfo baseVideoInfo = null;
                if (obj instanceof CommentVideoFeedInfo) {
                    commentVideoFeedInfo = (CommentVideoFeedInfo) obj;
                    baseVideoInfo = commentVideoFeedInfo.getRelatedVideoInfo();
                    obj = commentVideoFeedInfo.getRelatedUserInfo();
                    str = "discuss";
                } else if (obj instanceof LikeVideoFeedInfo) {
                    LikeVideoFeedInfo likeVideoFeedInfo = (LikeVideoFeedInfo) obj;
                    baseVideoInfo = likeVideoFeedInfo.getRelatedVideoInfo();
                    obj = likeVideoFeedInfo.getRelatedUserInfo();
                    str = "zan";
                } else {
                    obj = null;
                    str2 = obj;
                    if (!(baseVideoInfo == null || obj == null)) {
                        aVar.j = baseVideoInfo.getPublisherId();
                        aVar.l = obj.getNickname();
                        aVar.u = From.PERSONAL_SPACE;
                        aVar.a = baseVideoInfo.getVideoId();
                        aVar.b = baseVideoInfo.getGcid();
                        aVar.c = baseVideoInfo.getTitle();
                        aVar.d = baseVideoInfo.getPlayUrl();
                        aVar.e = baseVideoInfo.getCoverUrl();
                        aVar.f = baseVideoInfo.getLikeCount();
                        aVar.v = baseVideoInfo;
                        aVar.w = obj;
                        ShortMovieDetailActivity.a(this.b, aVar);
                        i = baseVideoInfo.getVideoId();
                        build = HubbleEventBuilder.build("android_personal_account", "personal_space_movie_click");
                        build.addString("movieid", i);
                        build.add("format_type", "video");
                        ThunderReport.reportEvent(build);
                        com.xunlei.downloadprovider.homepage.recommend.a.a(baseVideoInfo.getVideoId(), 0, "shortvideo", o.a(this.h), "active", str2);
                    }
                }
                str2 = str;
                aVar.j = baseVideoInfo.getPublisherId();
                aVar.l = obj.getNickname();
                aVar.u = From.PERSONAL_SPACE;
                aVar.a = baseVideoInfo.getVideoId();
                aVar.b = baseVideoInfo.getGcid();
                aVar.c = baseVideoInfo.getTitle();
                aVar.d = baseVideoInfo.getPlayUrl();
                aVar.e = baseVideoInfo.getCoverUrl();
                aVar.f = baseVideoInfo.getLikeCount();
                aVar.v = baseVideoInfo;
                aVar.w = obj;
                ShortMovieDetailActivity.a(this.b, aVar);
                i = baseVideoInfo.getVideoId();
                build = HubbleEventBuilder.build("android_personal_account", "personal_space_movie_click");
                build.addString("movieid", i);
                build.add("format_type", "video");
                ThunderReport.reportEvent(build);
                com.xunlei.downloadprovider.homepage.recommend.a.a(baseVideoInfo.getVideoId(), 0, "shortvideo", o.a(this.h), "active", str2);
            }
        } else if (i == 2) {
            if (obj != null) {
                commentVideoFeedInfo = (CommentVideoFeedInfo) obj;
                r9 = new CommentInfo();
                r9.setBaseCommentInfo(commentVideoFeedInfo.getBaseCommentInfo());
                r9.setRelatedUserInfo(commentVideoFeedInfo.getRelatedUserInfo());
                r9.setRelatedVideoInfo(commentVideoFeedInfo.getRelatedVideoInfo());
                r9.setPublishUserInfo(true);
                r9.setGcid(commentVideoFeedInfo.getRelatedVideoInfo().getGcid());
                if (r9.isPreview() != null) {
                    XLToast.showToast(this.b, "此评论暂时无法回复");
                    return;
                }
                obj = this.i;
                StringBuilder stringBuilder = new StringBuilder("回复 ");
                stringBuilder.append(r9.getUserName());
                obj.b(stringBuilder.toString());
                e();
                this.i.a(r9);
                obj = r9.getRelatedVideoInfo();
                str = "";
                if (obj != null) {
                    str = obj.getVideoId();
                }
                com.xunlei.downloadprovider.homepage.recommend.a.a(r9.getId(), str, "shortvideo", o.a(this.h));
            }
        } else if (i == 3) {
            commentVideoFeedInfo = (CommentVideoFeedInfo) obj;
            r9 = new CommentInfo();
            r9.setBaseCommentInfo(commentVideoFeedInfo.getBaseCommentInfo());
            r9.setRelatedUserInfo(commentVideoFeedInfo.getRelatedUserInfo());
            r9.setRelatedVideoInfo(commentVideoFeedInfo.getRelatedVideoInfo());
            r9.setPublishUserInfo(true);
            r9.setGcid(commentVideoFeedInfo.getRelatedVideoInfo().getGcid());
            this.j.a(r9);
            this.j.show();
        } else if (i == 11) {
            if (obj != null) {
                r10 = (c) obj;
                r9 = new CommentInfo();
                r9.setType(CommentInfo.TYPE_WEBSITE);
                r9.setBaseCommentInfo(r10.getBaseCommentInfo());
                r9.setWebsiteInfo(r10.a);
                r9.setPublishUserInfo(true);
                if (r9.isPreview()) {
                    XLToast.showToast(this.b, "此评论暂时无法回复");
                    return;
                }
                r0 = this.i;
                r1 = new StringBuilder("回复 ");
                r1.append(r9.getUserName());
                r0.b(r1.toString());
                e();
                this.i.a(r9);
                com.xunlei.downloadprovider.homepage.recommend.a.a(r9.getId(), r10.a.a, "web_url", o.a(this.h));
            }
        } else if (i == 12) {
            r10 = (c) obj;
            r9 = new CommentInfo();
            r9.setType(CommentInfo.TYPE_WEBSITE);
            r9.setBaseCommentInfo(r10.getBaseCommentInfo());
            r9.setWebsiteInfo(r10.a);
            r9.setPublishUserInfo(true);
            this.j.a(r9);
            this.j.show();
        } else if (i != 14) {
            if (i == 15) {
                r10 = (com.xunlei.downloadprovider.publiser.per.model.a) obj;
                r9 = new CommentInfo();
                r9.setType(CommentInfo.TYPE_CINECISM);
                r9.setBaseCommentInfo(r10.getBaseCommentInfo());
                r9.setCinecismInfo(r10.a);
                r9.setPublishUserInfo(true);
                this.j.a(r9);
                this.j.show();
            }
        } else if (obj != null) {
            r10 = (com.xunlei.downloadprovider.publiser.per.model.a) obj;
            r9 = new CommentInfo();
            r9.setType(CommentInfo.TYPE_CINECISM);
            r9.setBaseCommentInfo(r10.getBaseCommentInfo());
            r9.setCinecismInfo(r10.a);
            r9.setPublishUserInfo(true);
            if (r9.isPreview()) {
                XLToast.showToast(this.b, "此评论暂时无法回复");
                return;
            }
            r0 = this.i;
            r1 = new StringBuilder("回复 ");
            r1.append(r9.getUserName());
            r0.b(r1.toString());
            e();
            this.i.a(r9);
            com.xunlei.downloadprovider.homepage.recommend.a.a(r9.getId(), r10.a.a, "cinecism", o.a(this.h));
        }
    }

    private void e() {
        if (this.i == null) {
            this.i = new com.xunlei.downloadprovider.shortvideo.videodetail.a(this.b);
        }
        if (!this.i.isShowing()) {
            this.i.show();
        }
    }

    static /* synthetic */ String a(int i) {
        if (i == CommentInfo.TYPE_VIDEO) {
            return "shortvideo";
        }
        return i == CommentInfo.TYPE_WEBSITE ? "web_url" : "cinecism";
    }

    static /* synthetic */ void a(HistoryDynamicItemFragment historyDynamicItemFragment, long j) {
        for (bp bpVar : historyDynamicItemFragment.d.a) {
            if ((bpVar.a == 0 || bpVar.a == 7 || bpVar.a == 10) && ((com.xunlei.downloadprovider.publiser.per.model.b) bpVar.b).getBaseCommentInfo().getId() == j) {
                break;
            }
        }
        bp bpVar2 = null;
        if (bpVar2 != null) {
            historyDynamicItemFragment.d.b(bpVar2);
            if (historyDynamicItemFragment.d.getItemCount() <= null) {
                historyDynamicItemFragment.g.setErrorType(-1);
                historyDynamicItemFragment.g.a((int) R.drawable.commonui_bg_page_empty, (int) R.string.commonui_page_empty_for_like_and_comment);
                historyDynamicItemFragment.g.a(null, null);
                historyDynamicItemFragment.g.setVisibility(0);
            }
            if (historyDynamicItemFragment.l != null) {
                j = historyDynamicItemFragment.l;
                int i = historyDynamicItemFragment.p - 1;
                historyDynamicItemFragment.p = i;
                j.b(i);
                if (historyDynamicItemFragment.d.getItemCount() < 10 && historyDynamicItemFragment.p > 20) {
                    historyDynamicItemFragment.b();
                } else if (historyDynamicItemFragment.d.getItemCount() == null) {
                    historyDynamicItemFragment.c();
                }
            }
        }
    }

    static /* synthetic */ List a(List list) {
        List arrayList = new ArrayList();
        for (PersonalFeedInfo personalFeedInfo : list) {
            String type = personalFeedInfo.getType();
            Object obj = null;
            if (PersonalFeedInfo.TYPE_COMMENT_VIDEO.equals(type)) {
                obj = new bp((CommentVideoFeedInfo) personalFeedInfo.getData(), 0);
            } else if (PersonalFeedInfo.TYPE_LIKE_VIDEO.equals(type)) {
                obj = new bp((LikeVideoFeedInfo) personalFeedInfo.getData(), 5);
            } else if (PersonalFeedInfo.TYPE_COMMENT_WEBSITE.equals(type)) {
                obj = new bp((c) personalFeedInfo.getData(), 7);
            } else if (PersonalFeedInfo.TYPE_LIKE_WEBSITE.equals(type)) {
                obj = new bp((com.xunlei.downloadprovider.publiser.per.model.e) personalFeedInfo.getData(), 8);
            } else if (PersonalFeedInfo.TYPE_COMMENT_CINECISM.equals(type)) {
                obj = new bp((com.xunlei.downloadprovider.publiser.per.model.a) personalFeedInfo.getData(), 10);
            } else if (PersonalFeedInfo.TYPE_LIKE_CINECISM.equals(type)) {
                obj = new bp((d) personalFeedInfo.getData(), 11);
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
