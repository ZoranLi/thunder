package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.giftdispatch.GiftDispatchingActivity;
import com.xunlei.downloadprovider.download.tasklist.list.a.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import java.util.List;

/* compiled from: VoucherPacketBanner */
public final class a extends c {
    public a a;
    public RedPacketConditionsInfo b;
    public Context c;
    public DownloadTaskInfo d;
    public g e = new e(this);

    /* compiled from: VoucherPacketBanner */
    private static class a extends b {
        public ImageView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        private a(View view) {
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
        viewStub.inflate();
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.a = new a(view);
        if (this.b != null) {
            this.a.h.setText(this.b.list_page_title);
            Glide.with(this.c).load(this.b.list_page_image).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.a.a);
        }
        this.a.f.setOnClickListener(new b(this));
        this.a.g.setOnClickListener(new c(this));
        if (com.xunlei.downloadprovider.download.b.b.f() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
        } else {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
        }
        a(false, this.d);
    }

    public final void a(boolean z, DownloadTaskInfo downloadTaskInfo) {
        if (z) {
            d(0);
        } else {
            d(8);
        }
        long j = -1;
        if (downloadTaskInfo != null) {
            j = downloadTaskInfo.getTaskId();
        }
        boolean z2 = z;
        BannerManager.a().a(z2, BannerManager$BannerType.TYPE_VOUCHER_PACKET, j, null);
    }

    public final void a() {
        this.a.b.setText(f.a().i);
        this.a.c.setText(f.a().j);
        this.a.d.setText(f.a().k);
        this.a.e.setText(f.a().l);
    }

    private void b() {
        if (this.b != null) {
            String str = this.b.detatil_page_image;
            List list = this.b.redpack_type;
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = (String) list.get(i);
            }
            GiftDispatchingActivity.c(this.c, strArr, str);
        }
    }

    static /* synthetic */ void a(a aVar) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_viphb_gain_click"));
        LoginHelper.a();
        if (l.c()) {
            aVar.b();
        } else {
            LoginHelper.a().a(aVar.c, new d(aVar), LoginFrom.DLCENTER_DETAIL_PACKET, null);
        }
    }
}
