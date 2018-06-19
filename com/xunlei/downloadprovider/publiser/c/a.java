package com.xunlei.downloadprovider.publiser.c;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.common.commonview.anim.MovingImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.publiser.per.bq;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: RadLivingInfoViewHolder */
public final class a extends bq {
    private String a;
    private String b;
    private String c;
    private Context d;
    private PublisherInfo e = null;
    private TextView f;
    private ZHTextView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private View k;
    private View l;
    private MovingImageView m;
    private ImageView n;

    public static a a(Context context) {
        return new a(LayoutInflater.from(context).inflate(R.layout.layout_rad_living_info, null), context, RePlugin.PROCESS_UI);
    }

    private a(View view, Context context, String str) {
        super(view);
        this.d = context;
        this.a = str;
        this.b = null;
        this.c = null;
        this.k = view.findViewById(R.id.layout_live_living);
        this.k.setOnClickListener(new b(this));
        this.l = view.findViewById(R.id.ly_living_replay);
        this.l.setOnClickListener(new c(this));
        this.f = (TextView) view.findViewById(R.id.tv_replay_num);
        this.g = (ZHTextView) view.findViewById(R.id.tv_replay_name);
        this.h = (ImageView) view.findViewById(R.id.iv_living_icon);
        this.j = (TextView) view.findViewById(R.id.room_num);
        this.m = (MovingImageView) view.findViewById(R.id.bg_living_image);
        this.m.getMovingAnimator().addListener(new d(this));
        this.n = (ImageView) view.findViewById(R.id.living_mask);
        this.i = (TextView) view.findViewById(R.id.rad_living_btn);
    }

    public final void a(bp bpVar) {
        this.e = (PublisherInfo) bpVar.b;
        this.a = this.e.a().getUid();
        this.b = this.e.a().getNickname();
        this.c = this.e.a().getPortraitUrl();
        bpVar = this.e;
        this.e = bpVar;
        String str = this.c;
        if (!TextUtils.isEmpty(bpVar.a().getPortraitUrl())) {
            str = bpVar.a().getPortraitUrl();
        }
        if (bpVar.a().getLiveExtra().a()) {
            ((AnimationDrawable) this.i.getBackground()).start();
            this.k.setVisibility(0);
            this.j.setText(j.a((long) bpVar.a().getLiveExtra().c));
            Glide.with(this.m.getContext()).load(str).asBitmap().dontAnimate().into(new e(this, this.m));
        } else {
            this.k.setVisibility(8);
        }
        if (bpVar.c()) {
            this.l.setVisibility(0);
            TextView textView = this.f;
            StringBuilder stringBuilder = new StringBuilder("共");
            stringBuilder.append(bpVar.a().getLiveExtra().e);
            stringBuilder.append("个回放");
            textView.setText(stringBuilder.toString());
            this.g.setText("历史直播");
            Glide.with(this.h.getContext()).load(str).asBitmap().dontAnimate().into(this.h);
            return;
        }
        this.l.setVisibility(8);
    }

    static /* synthetic */ void b(a aVar) {
        if (aVar.e != null && aVar.e.a().getLiveExtra().a()) {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(aVar.d, aVar.e.a().getLiveExtra().f, XLLiveRoomPlayFrom.CHANNEL_FLOW_RELEASE_ITEM);
        }
    }
}
