package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.giftdispatch.GiftDispatchingActivity;
import com.xunlei.downloadprovider.download.tasklist.list.a.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.q;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: TaskDownloadRedEnvelopeBanner */
public final class a extends c implements q {
    public DownloadTaskInfo a;
    public p b;
    private Context c;
    private RedPacketConditionsInfo d;
    private a e;
    private String[] f;

    /* compiled from: TaskDownloadRedEnvelopeBanner */
    static class a extends b {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iconImageView);
            this.b = (TextView) view.findViewById(R.id.red_envelope_minite1_tv);
            this.c = (TextView) view.findViewById(R.id.red_envelope_minite2_tv);
            this.d = (TextView) view.findViewById(R.id.red_envelope_second1_tv);
            this.e = (TextView) view.findViewById(R.id.red_envelope_second2_tv);
        }
    }

    public a(Context context, ViewStub viewStub) {
        super(viewStub);
        this.c = context;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, Object obj, boolean z) {
        if (obj instanceof RedPacketConditionsInfo) {
            RedPacketConditionsInfo redPacketConditionsInfo = (RedPacketConditionsInfo) obj;
            if (downloadTaskInfo != null) {
                if (redPacketConditionsInfo != null) {
                    f();
                    this.a = downloadTaskInfo;
                    this.d = redPacketConditionsInfo;
                    if (z) {
                        this.b.a(redPacketConditionsInfo, downloadTaskInfo);
                    }
                }
            }
        }
    }

    public final void f() {
        if (this.b == null) {
            this.b = new com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(this);
        }
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.e = new a(view);
        if (this.d != null) {
            this.e.h.setText(this.d.list_page_title);
            Glide.with(this.e.a.getContext()).load(this.d.list_page_image).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.e.a);
        }
        this.e.f.setOnClickListener(new b(this));
        this.e.g.setOnClickListener(new c(this));
        if (g() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
        } else {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
        }
        if (this.d != null) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
            this.f = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(this.d.redpack_type);
        }
        f();
    }

    public final DownloadTaskInfo a() {
        return this.a;
    }

    public final void a(Object obj) {
        if (obj instanceof com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a aVar = (com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a) obj;
            if (this.e != null && this.e.b != null && this.e.c != null && this.e.d != null && this.e.e != null && aVar != null) {
                this.e.b.setText(aVar.a);
                this.e.c.setText(aVar.b);
                this.e.d.setText(aVar.c);
                this.e.e.setText(aVar.d);
            }
        }
    }

    public final void a(int i) {
        d(i);
    }

    public final Context b() {
        return this.c;
    }

    public final RedPacketConditionsInfo e() {
        return this.d;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, long j, long j2, long j3) {
        if (downloadTaskInfo != null) {
            d(0);
            downloadTaskInfo.mRemainderSeconds = j3 - ((j - j2) / 1000);
            d();
            downloadTaskInfo.mHasShowRedEnvelopeBanner = 1;
        }
    }

    public final void d() {
        if (this.a != null && this.b != null) {
            a(this.b.a(this.a.mRemainderSeconds));
            this.b.a();
        }
    }

    public final void c() {
        if (this.c != null) {
            if (this.d != null) {
                GiftDispatchingActivity.a(this.c, this.f, this.d.detatil_page_image);
            }
        }
    }
}
