package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.connect.common.Constants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: FeedItemShareLayout */
final class m implements OnClickListener {
    final /* synthetic */ FeedItemShareLayout a;

    m(FeedItemShareLayout feedItemShareLayout) {
        this.a = feedItemShareLayout;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.replay_btn:
                if (this.a.e != null) {
                    this.a.e.onClick(view);
                    return;
                }
                break;
            case R.id.iv_weixin:
                FeedItemShareLayout.a(this.a, ShareOperationType.WEIXIN);
                if (this.a.d != null) {
                    VideoFeedReporter.a(this.a.d.a.getVideoId(), "screen", "wechart");
                    return;
                }
                break;
            case R.id.iv_wxfriend:
                if (this.a.d != null) {
                    FeedItemShareLayout.a(this.a, ShareOperationType.WEIXIN_CIRCLE);
                    VideoFeedReporter.a(this.a.d.a.getVideoId(), "screen", "pengyouquan");
                    return;
                }
                break;
            case R.id.iv_qq:
                if (this.a.d != null) {
                    FeedItemShareLayout.a(this.a, ShareOperationType.QQ);
                    VideoFeedReporter.a(this.a.d.a.getVideoId(), "screen", "qq");
                    return;
                }
                break;
            case R.id.iv_qzone:
                if (this.a.d != null) {
                    FeedItemShareLayout.a(this.a, ShareOperationType.QZONE);
                    VideoFeedReporter.a(this.a.d.a.getVideoId(), "screen", Constants.SOURCE_QZONE);
                    return;
                }
                break;
            case R.id.rl_follow_contain:
                if (this.a.f != null) {
                    this.a.f.onClick(view);
                    break;
                }
                break;
            default:
                break;
        }
    }
}
