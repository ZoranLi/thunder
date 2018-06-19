package com.xunlei.downloadprovider.download.player.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.f.b;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.d;
import com.xunlei.downloadprovidershare.l;
import java.io.File;

/* compiled from: ShareController */
public class ay extends f implements OnClickListener {
    private static final String b = "ay";
    public OnClickListener a;
    private String c;
    private CooperationItem d;
    private d g = null;
    private String h = "";
    private View i;
    private l j = new az(this);

    public ay(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        this.e.findViewById(R.id.center_share_btn_weixin).setOnClickListener(this);
        this.e.findViewById(R.id.center_share_btn_qq).setOnClickListener(this);
        this.e.findViewById(R.id.center_share_btn_more).setOnClickListener(this);
        this.e.findViewById(R.id.detail_title_share_icon).setOnClickListener(this);
        this.i = this.e.findViewById(R.id.player_top_share_tips_layout);
        this.i.findViewById(R.id.iv_qzone).setOnClickListener(this);
        this.i.findViewById(R.id.iv_wxfriend).setOnClickListener(this);
        this.i.findViewById(R.id.iv_qq).setOnClickListener(this);
        this.i.findViewById(R.id.iv_weixin).setOnClickListener(this);
        this.i.findViewById(R.id.iv_close_share).setOnClickListener(this);
        this.d = c.a().a(22);
    }

    public final void b(boolean z) {
        this.i.setVisibility(z ? false : true);
    }

    private void a(ShareOperationType shareOperationType, String str) {
        if (f() != null) {
            long M = f().M();
            n.a();
            TaskInfo f = n.f(M);
            if (f != null) {
                Activity activity = (n() == null || !(n() instanceof Activity)) ? null : (Activity) n();
                if (activity != null) {
                    f a = com.xunlei.downloadprovider.f.c.a("local_player_share_guide", f, this.d, null, null);
                    this.h = str;
                    com.xunlei.downloadprovider.f.a.a();
                    com.xunlei.downloadprovider.f.a.a(activity, shareOperationType, a, this.j);
                }
            } else if (n() != null) {
                XLToast.showToast(n(), "获取分享信息失败");
            }
        }
    }

    private void a(String str) {
        if (f() != null) {
            this.c = str;
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_player", "player_share_click"));
            long M = f().M();
            n.a();
            str = n.f(M);
            if (str != null) {
                Activity activity = (n() == null || !(n() instanceof Activity)) ? null : (Activity) n();
                if (activity != null) {
                    if (f().E()) {
                        f().C();
                    }
                    this.e.e();
                    f a = com.xunlei.downloadprovider.f.c.a("local_player", str, this.d, null, null);
                    com.xunlei.downloadprovidershare.b.c a2 = com.xunlei.downloadprovidershare.b.a.a(a, com.xunlei.downloadprovider.d.d.a().d.v());
                    a2.a(ShareOperationType.QR_SHARE);
                    this.h = "top_share";
                    str = com.xunlei.downloadprovider.f.a.a();
                    l lVar = this.j;
                    d a3 = com.xunlei.downloadprovidershare.a.a().a(activity, 2, a, lVar, com.xunlei.downloadprovidershare.b.a.a(), a2);
                    a3.setOnDismissListener(new b(str, lVar));
                    this.g = a3;
                    if (this.d != null) {
                        com.xunlei.downloadprovider.cooperation.a.a.a(com.xunlei.downloadprovider.cooperation.l.c(this.d.getDisplayLocation()), this.d.getAppPackageName(), this.d.isShowInstallTip());
                    }
                    com.xunlei.downloadprovider.player.a.a("top_share");
                }
            } else if (n() != null) {
                XLToast.showToast(n(), "获取分享信息失败");
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.detail_title_share_icon) {
            if (id != R.id.iv_close_share) {
                switch (id) {
                    case R.id.iv_weixin:
                        this.i.setVisibility(8);
                        a(ShareOperationType.WEIXIN, "play_end");
                        return;
                    case R.id.iv_wxfriend:
                        this.i.setVisibility(8);
                        a(ShareOperationType.WEIXIN_CIRCLE, "play_end");
                        return;
                    case R.id.iv_qq:
                        this.i.setVisibility(8);
                        a(ShareOperationType.QQ, "play_end");
                        return;
                    case R.id.iv_qzone:
                        this.i.setVisibility(8);
                        a(ShareOperationType.QZONE, "play_end");
                        return;
                    default:
                        switch (id) {
                            case R.id.center_share_btn_weixin:
                                a(ShareOperationType.WEIXIN, "play_pause");
                                return;
                            case R.id.center_share_btn_qq:
                                a(ShareOperationType.QQ, "play_pause");
                                return;
                            case R.id.center_share_btn_more:
                                a("player_pause_more");
                                return;
                            default:
                                break;
                        }
                }
            }
            this.i.setVisibility(8);
            com.xunlei.downloadprovider.player.a.b("share_float", "cancel", "top_share");
        } else if (this.f) {
            a("player_fullscreen");
        } else {
            if (this.a != null) {
                this.a.onClick(view);
            }
        }
    }

    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        if (!z2 && z && !this.i.getVisibility()) {
            this.i.setVisibility(true);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        boolean z2 = true;
        if (z) {
            z = com.xunlei.downloadprovider.d.d.a().i.e();
            long j = -1;
            if (f() != null) {
                j = f().M();
            }
            z = z && j >= 0;
            if (z && this.e.getPlayerCenterViewGroup()) {
                this.e.getPlayerCenterViewGroup().setIsShowCenterShare(true);
            }
        } else {
            if (this.e.getPlayerCenterViewGroup()) {
                this.e.getPlayerCenterViewGroup().setIsShowCenterShare(false);
            }
            if (this.g) {
                this.g.dismiss();
                this.g = false;
            }
            b(false);
        }
        z = this.e.b;
        if (z.e.getVisibility() != 0) {
            if (z.h.getVisibility()) {
                z2 = false;
            }
        }
        if (z2) {
            this.e.a();
        }
    }

    public final void d() {
        if (this.g != null) {
            this.g.dismiss();
            this.g = null;
        }
    }

    static /* synthetic */ void b(ay ayVar) {
        if (ayVar.d != null) {
            if (ayVar.n() != null) {
                if (!(ayVar.f() == null || ayVar.f().N() == null)) {
                    String str = ayVar.f().N().mLocalFileName;
                    com.xunlei.downloadprovider.cooperation.ui.b a = com.xunlei.downloadprovider.cooperation.ui.b.a();
                    Context n = ayVar.n();
                    ayVar = ayVar.d;
                    File file = new File(str);
                    if (file.exists()) {
                        str = ayVar.getAppPackageName();
                        Object fromFile = Uri.fromFile(file);
                        new StringBuilder("file path=>").append(fromFile.toString());
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setPackage(str);
                        intent.putExtra("android.intent.extra.STREAM", fromFile);
                        intent.setDataAndType(fromFile, "video/*");
                        intent.addFlags(268435456);
                        boolean z = true;
                        if (intent.resolveActivity(n.getPackageManager()) == null) {
                            intent = n.getPackageManager().getLaunchIntentForPackage(str);
                            if (intent == null) {
                                z = false;
                            }
                        }
                        com.xunlei.downloadprovider.cooperation.a.a.a(com.xunlei.downloadprovider.cooperation.l.c(ayVar.getDisplayLocation()), str, ayVar.isShowInstallTip(), z, "");
                        if (z) {
                            n.startActivity(intent);
                            return;
                        }
                        a.a(n, ayVar);
                    } else {
                        new StringBuilder("file not exist=>").append(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
