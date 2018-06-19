package com.xunlei.downloadprovider.shortvideo.ui;

import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: PlayerViewReportStrategy */
public abstract class r<T> {
    public T b;

    public abstract void a();

    public abstract void a(int i, ShareOperationType shareOperationType, boolean z);

    public abstract void a(ShareOperationType shareOperationType, String str, String str2);

    public abstract void a(String str);

    public abstract void a(String str, String str2, int i);

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void b(boolean z);

    public abstract From c();

    public abstract ShortMovieDetailActivity.From d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract PlayerTag h();

    public abstract LoginFrom i();

    public abstract String j();

    public abstract String k();
}
