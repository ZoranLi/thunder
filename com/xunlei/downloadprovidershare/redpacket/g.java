package com.xunlei.downloadprovidershare.redpacket;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.a.b.b;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonutil.DataUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovidershare.R;
import com.xunlei.downloadprovidershare.a.i;

/* compiled from: RedPacketShareDlgView */
public final class g extends AlertDialog {
    int[] a = new int[]{R.drawable.bg_video_poster_blur1, R.drawable.bg_video_poster_blur2, R.drawable.bg_video_poster_blur3};
    private ShareRedPacketView b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private i f;
    private com.xunlei.downloadprovidershare.a.i.a g;
    private Context h;
    private StaticHandler i;
    private a j;
    private MessageListener k = new h(this);

    /* compiled from: RedPacketShareDlgView */
    public interface a {
        void a(boolean z, Bitmap bitmap);
    }

    public g(Context context, i iVar, a aVar) {
        super(context, R.style.RedPacketViewStyle);
        this.h = context;
        this.f = iVar;
        this.g = iVar.m;
        this.j = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dlg_red_envelope_share_view);
        this.i = new StaticHandler(this.k);
        this.b = (ShareRedPacketView) findViewById(R.id.share_red_envelope_view);
        this.b.setVisibility(4);
        bundle = getWindow();
        if (bundle != null) {
            bundle.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = bundle.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            bundle.setAttributes(attributes);
        }
        this.b.setVideoPosterBlur(this.a[(int) (Math.random() * 2.0d)]);
        if (this.g.b == null) {
            this.c = true;
            this.b.setGainCashTvVisible(4);
            a(this.h.getResources().getString(R.string.red_packet_cash_default));
        } else {
            b a = b.a();
            String hubbleDeviceGUID = AndroidConfig.getHubbleDeviceGUID();
            XLThreadPool.execute(new c(a, this.g.k, new j(this), this.g.a, hubbleDeviceGUID));
        }
        if (this.g != null) {
            bundle = this.g.f;
            ShareRedPacketView shareRedPacketView = this.b;
            if (TextUtils.isEmpty(bundle)) {
                bundle = "迅雷用户";
            }
            shareRedPacketView.setUserNickName(bundle);
            this.b.setVideoTitle(this.g.h);
            this.b.setVideoDuration(DateUtil.formatDuration(this.g.j));
            bundle = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DataUtil.formatCount(this.g.i));
            stringBuilder.append("次播放");
            bundle.setVideoPlayCount(stringBuilder.toString());
        }
        if (this.g != null) {
            this.d = true;
            bundle = this.b.getUserPortraitIv();
            if (TextUtils.isEmpty(this.g.e)) {
                bundle.setImageResource(R.drawable.ic_default_avatar_new);
                a();
            } else {
                a(bundle.getContext(), this.g.e, R.drawable.ic_default_avatar_new).into(new k(this, bundle, bundle));
            }
        }
        if (this.g != null && TextUtils.isEmpty(this.g.g) == null) {
            bundle = this.b.getVideoPosterIv();
            bundle.post(new l(this, bundle));
        }
        bundle = this.f.f;
        if (!TextUtils.isEmpty(bundle)) {
            b bVar = new b();
            this.b.setQrCodeIv(b.a(bundle));
        }
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.setGainCashTvVisible(4);
        } else {
            this.b.setGainCashTvVisible(0);
            this.b.setGainCash(str);
        }
        this.b.post(new i(this));
    }

    private void a() {
        StringBuilder stringBuilder = new StringBuilder("shareRedPacket--mHasLoadedUserPortrait=");
        stringBuilder.append(this.d);
        stringBuilder.append("|mHasLoadedVideoPoster=");
        stringBuilder.append(this.e);
        stringBuilder.append("|mHasGetUserGainCash=");
        stringBuilder.append(this.c);
        if (this.d && this.e && this.c) {
            stringBuilder = new StringBuilder("shareViewWidth, ShareViewHeight = ");
            stringBuilder.append(this.b.getWidth());
            stringBuilder.append(", ");
            stringBuilder.append(this.b.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Config.ARGB_8888);
            this.b.draw(new Canvas(createBitmap));
            dismiss();
            if (this.j != null) {
                this.j.a(true, createBitmap);
            }
        }
    }

    static DrawableRequestBuilder<String> a(Context context, String str, int i) {
        return Glide.with(context).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(i).error(i).crossFade(200);
    }

    static /* synthetic */ void a(g gVar, Message message) {
        gVar.c = true;
        message = ((float) message.arg1) / 1000.0f;
        if (message >= 1.0f) {
            gVar.a(gVar.h.getResources().getString(R.string.red_packet_cash).replace("%s", String.valueOf(message)));
        } else {
            gVar.a(gVar.h.getResources().getString(R.string.red_packet_cash_default));
        }
    }

    static /* synthetic */ void a(g gVar) {
        StringBuilder stringBuilder = new StringBuilder("mHasLoadedUserPortrait = ");
        stringBuilder.append(gVar.d);
        stringBuilder.append(", mHasLoadedVideoPoster = ");
        stringBuilder.append(gVar.e);
        stringBuilder.append(", mHasGetUserGainCash = ");
        stringBuilder.append(gVar.c);
        gVar.dismiss();
        if (gVar.j != null) {
            gVar.j.a(false, null);
        }
    }

    static /* synthetic */ void a(g gVar, Bitmap bitmap, ImageView imageView) {
        imageView.setImageBitmap(bitmap);
        gVar.a();
    }

    static /* synthetic */ void a(g gVar, Drawable drawable, ImageView imageView) {
        imageView.setImageDrawable(drawable);
        gVar.a();
    }
}
