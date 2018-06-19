package com.xunlei.downloadprovider.web.browser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.contentpublish.website.WebsitePublishActivity;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.contentpublish.website.au;
import com.xunlei.downloadprovider.contentpublish.website.az;
import com.xunlei.downloadprovider.contentpublish.website.bf;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.authphone.p;
import com.xunlei.downloadprovidershare.R;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.c;
import com.xunlei.downloadprovidershare.k;
import com.xunlei.xllib.android.b;

/* compiled from: BrowserShareHelper */
public final class ab {
    Context a;
    String b;
    String c;
    p d = new ac(this);
    private k e;
    private String f;
    private String g;

    /* compiled from: BrowserShareHelper */
    public interface a {
        void a(int i);
    }

    ab(String str, Context context) {
        this.c = str;
        this.a = context;
    }

    final void a(String str, String str2, String str3) {
        this.b = str;
        this.f = str3;
        if (TextUtils.isEmpty(str) != null) {
            XLToast.showToast(this.a, "网页加载中，请稍后再试");
            return;
        }
        if (TextUtils.isEmpty(str2) == null) {
            this.g = str2;
        } else {
            this.g = str;
        }
        if (com.xunlei.downloadprovider.h.k.a.d(str) != null) {
            if (com.xunlei.downloadprovider.h.k.h(str) != 1) {
                if (m.a().d(str) != null) {
                    if (str.length() < 256) {
                        if (b.a(this.a) == null) {
                            XLToast.showToast(this.a, "网络异常，请稍后重试");
                            bf.c("browser_website_share", str, "no_connect");
                            return;
                        }
                        if (this.e == null) {
                            this.e = new ad(this);
                        }
                        str2 = this.b;
                        str3 = this.g;
                        String str4 = this.f;
                        f aVar = new com.xunlei.downloadprovidershare.a.a("browser_website_share", d.a().n.c(), str3, str2);
                        aVar.h = str4;
                        aVar.d = "分享链接";
                        str = new c();
                        str.a(com.xunlei.downloadprovidershare.b.a.c());
                        str.a(com.xunlei.downloadprovidershare.b.a.d());
                        str.a(new com.xunlei.downloadprovidershare.b.b("迅雷主页", R.drawable.share_main_icon_selector, ShareOperationType.MAIN_PAGE));
                        com.xunlei.downloadprovider.f.a.a();
                        com.xunlei.downloadprovider.f.a.b((Activity) this.a, aVar, this.e, str);
                        aa.b(this.c, this.b);
                        return;
                    }
                }
                XLToast.showToast(this.a, "暂不支持分享此网站");
                bf.c("browser_website_share", str, "no_allow");
                return;
            }
        }
        XLToast.showToast(this.a, "链接格式错误");
        bf.c("browser_website_share", str, "type_error");
    }

    static /* synthetic */ void a(ab abVar) {
        au auVar = new au();
        auVar.a = abVar.b;
        auVar.b = abVar.f;
        auVar.c = abVar.g;
        az.a().a = auVar;
        WebsitePublishActivity.a(abVar.a, new ae(abVar));
    }
}
