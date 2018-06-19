package com.xunlei.downloadprovider.contentpublish.website;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsitePublishActivity */
final class ax implements c<String> {
    final /* synthetic */ WebsitePublishActivity a;

    ax(WebsitePublishActivity websitePublishActivity) {
        this.a = websitePublishActivity;
    }

    public final void onFail(String str) {
        WebsitePublishActivity.c(this.a);
        if ("more than 50 messages are released".equals(str)) {
            XLToast.showToast(this.a, "发布过于频繁，请稍后再试");
        } else if ("user is baned".equals(str)) {
            XLToast.showToast(this.a, "因多次发布不良内容，已被禁止发布");
        } else if ("site is not in white list".equals(str)) {
            XLToast.showToast(this.a, "暂不支持此链接");
        } else {
            XLToast.showToast(this.a, "发布失败，请重试");
        }
        bf.a(this.a.a, this.a.c.a, this.a.c.d, str);
        this.a.a(1);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        WebsitePublishActivity.c(this.a);
        XLToast.showToast(this.a, "发布成功");
        LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("action_website_publish_success"));
        this.a.finish();
        az.a().a = null;
        bf.a(this.a.a, this.a.c.a, this.a.c.d, "success");
        this.a.a(0);
    }
}
