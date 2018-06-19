package com.xunlei.downloadprovidershare.b;

import com.xunlei.downloadprovidershare.R;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.c;

/* compiled from: SharePlatformHelper */
public final class a {
    public static c a() {
        c cVar = new c();
        cVar.a(new b("微信好友", R.drawable.share_weixin_icon_selector, ShareOperationType.WEIXIN));
        cVar.a(new b("微信朋友圈", R.drawable.share_friends_circle_icon_selector, ShareOperationType.WEIXIN_CIRCLE));
        cVar.a(new b("QQ好友", R.drawable.share_qq_icon_selector, ShareOperationType.QQ));
        cVar.a(new b("QQ空间", R.drawable.share_qzone_icon_selector, ShareOperationType.QZONE));
        cVar.a(new b("新浪微博", R.drawable.share_weibo_icon_selector, ShareOperationType.SINA));
        return cVar;
    }

    public static c b() {
        c cVar = new c();
        cVar.a(c());
        cVar.a(d());
        cVar.a(e());
        return cVar;
    }

    public static c a(c cVar, boolean z) {
        c cVar2 = new c();
        cVar2.a(c());
        cVar2.a(d());
        cVar2.a(new b("二维码分享", R.drawable.share_qr_selector, ShareOperationType.QR_SHARE));
        if (z) {
            cVar2.a(new b("迅雷口令", R.drawable.share_thunder_command_selector, ShareOperationType.THUNDER_COMMAND));
        }
        z = cVar.b && cVar.b.a;
        if (z) {
            cVar2.a(cVar.b.a);
        }
        return cVar2;
    }

    public static b c() {
        return new b("复制链接", R.drawable.share_link_selector, ShareOperationType.COPY_URL);
    }

    public static b d() {
        return new b("系统分享", R.drawable.share_system_selector, ShareOperationType.SYSTEM_SHARE);
    }

    public static b e() {
        return new b("举报", R.drawable.share_accuse_selector, ShareOperationType.REPORT);
    }
}
