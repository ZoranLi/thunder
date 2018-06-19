package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.giftdispatch.GiftDispatchingActivity;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.xllib.b.d;
import java.util.List;

/* compiled from: TwiceConsumeBanner */
public final class i extends c implements com.xunlei.downloadprovider.download.tasklist.list.banner.a.a.a {
    public static int b = 25;
    private static RedPacketConditionsInfo f;
    public b a;
    public boolean c;
    public DownloadTaskInfo d;
    public String e = "";
    private String g;
    private Context j;

    /* compiled from: TwiceConsumeBanner */
    public static class a implements Runnable {
        String a;

        public a(String str) {
            this.a = str;
        }

        public final void run() {
            h.b(this.a);
        }
    }

    /* compiled from: TwiceConsumeBanner */
    private class b extends com.xunlei.downloadprovider.download.tasklist.list.a.b implements OnClickListener {
        final /* synthetic */ i a;
        private ImageView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView j;

        private b(i iVar, View view) {
            this.a = iVar;
            super(view);
            this.b = (ImageView) view.findViewById(R.id.iconImageView);
            this.c = (TextView) view.findViewById(R.id.red_envelope_minite1_tv);
            this.d = (TextView) view.findViewById(R.id.red_envelope_minite2_tv);
            this.e = (TextView) view.findViewById(R.id.red_envelope_second1_tv);
            this.j = (TextView) view.findViewById(R.id.red_envelope_second2_tv);
            this.g.setOnClickListener(this);
            this.f.setOnClickListener(this);
        }

        public final void a(int[] iArr) {
            if (iArr != null) {
                if (iArr.length == 4) {
                    TextView textView = this.c;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(iArr[0]);
                    textView.setText(stringBuilder.toString());
                    textView = this.d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(iArr[1]);
                    textView.setText(stringBuilder.toString());
                    textView = this.e;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(iArr[2]);
                    textView.setText(stringBuilder.toString());
                    textView = this.j;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(iArr[3]);
                    textView.setText(stringBuilder.toString());
                }
            }
        }

        public final void onClick(View view) {
            view = view.getId();
            if (view == R.id.container) {
                i.b(this.a);
            } else if (view == R.id.closeButton) {
                this.a.c(this.a.e);
            }
        }
    }

    static {
        a();
    }

    public i(ViewStub viewStub) {
        super(viewStub);
        this.j = viewStub.getContext();
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.a = new b(view);
        if (f != null) {
            this.a.h.setText(f.list_page_title);
            Glide.with(this.j).load(f.list_page_image).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.a.b);
        }
        if (com.xunlei.downloadprovider.download.b.b.f() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
            return;
        }
        viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
        c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
        c.a(view.findViewById(R.id.task_card_banner_content), viewStub);
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
        BannerManager.a().a(z2, BannerManager$BannerType.TYPE_TWICE, j, null);
    }

    public final void a(String str) {
        if (a.a(str, this.e) != null && h() == null) {
            a((boolean) null, this.d);
        }
    }

    public final void b(String str) {
        if (a.a(str, this.e) != null) {
            this.a.a(a.a().a(this.e));
        }
    }

    private void c(String str) {
        this.g = str;
        a a = a.a();
        Runnable aVar = new a(str);
        str = a.b(str);
        int hashCode = str.hashCode();
        a.d.remove(str);
        a.a.remove(hashCode);
        a.c.removeMessages(0, str);
        a.b.remove(hashCode);
        aVar.run();
        if (h() == null) {
            a(false, this.d);
        }
    }

    public static void a() {
        BannerManager.a();
        Object<RedPacketConditionsInfo> d = BannerManager.d();
        if (!d.a(d)) {
            for (RedPacketConditionsInfo redPacketConditionsInfo : d) {
                if (TextUtils.equals(redPacketConditionsInfo.user_type, "8")) {
                    break;
                }
            }
        }
        RedPacketConditionsInfo redPacketConditionsInfo2 = null;
        f = redPacketConditionsInfo2;
        if (redPacketConditionsInfo2 != null) {
            try {
                b = Integer.parseInt(f.count_down);
            } catch (Exception e) {
                e.printStackTrace();
                b = 25;
            }
        }
    }

    static /* synthetic */ void b(i iVar) {
        if (f != null) {
            String str = f.detatil_page_image;
            List list = f.redpack_type;
            String[] strArr = new String[list.size()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = (String) list.get(i);
            }
            GiftDispatchingActivity.b(iVar.j, strArr, str);
            iVar.c(iVar.e);
            com.xunlei.downloadprovider.download.report.a.c("10days_sent");
        }
    }
}
