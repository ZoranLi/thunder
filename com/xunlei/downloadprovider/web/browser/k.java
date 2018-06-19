package com.xunlei.downloadprovider.web.browser;

import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: BrowserActivity */
final class k implements a {
    final /* synthetic */ BrowserActivity a;

    k(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void a(String str) {
        String c = this.a.p.c();
        int hashCode = str.hashCode();
        if (hashCode != 671077) {
            if (hashCode != 727753) {
                if (hashCode == 1009311434) {
                    if (str.equals("网页搜索") != null) {
                        str = true;
                        switch (str) {
                            case null:
                                ClipboardUtil.copyToClipboardWithToast(BrothersApplication.getApplicationInstance(), c);
                                aa.a("copy", c);
                                return;
                            case 1:
                                this.a.runOnUiThread(new l(this, c));
                                aa.a("search", c);
                                return;
                            case 2:
                                if (this.a.n != null) {
                                    this.a.runOnUiThread(new m(this));
                                }
                                aa.a("share", c);
                                break;
                            default:
                                break;
                        }
                    }
                }
            } else if (str.equals("复制") != null) {
                str = null;
                switch (str) {
                    case null:
                        ClipboardUtil.copyToClipboardWithToast(BrothersApplication.getApplicationInstance(), c);
                        aa.a("copy", c);
                        return;
                    case 1:
                        this.a.runOnUiThread(new l(this, c));
                        aa.a("search", c);
                        return;
                    case 2:
                        if (this.a.n != null) {
                            this.a.runOnUiThread(new m(this));
                        }
                        aa.a("share", c);
                        break;
                    default:
                        break;
                }
            }
        } else if (str.equals("分享") != null) {
            str = 2;
            switch (str) {
                case null:
                    ClipboardUtil.copyToClipboardWithToast(BrothersApplication.getApplicationInstance(), c);
                    aa.a("copy", c);
                    return;
                case 1:
                    this.a.runOnUiThread(new l(this, c));
                    aa.a("search", c);
                    return;
                case 2:
                    if (this.a.n != null) {
                        this.a.runOnUiThread(new m(this));
                    }
                    aa.a("share", c);
                    break;
                default:
                    break;
            }
        }
        str = -1;
        switch (str) {
            case null:
                ClipboardUtil.copyToClipboardWithToast(BrothersApplication.getApplicationInstance(), c);
                aa.a("copy", c);
                return;
            case 1:
                this.a.runOnUiThread(new l(this, c));
                aa.a("search", c);
                return;
            case 2:
                if (this.a.n != null) {
                    this.a.runOnUiThread(new m(this));
                }
                aa.a("share", c);
                break;
            default:
                break;
        }
    }
}
