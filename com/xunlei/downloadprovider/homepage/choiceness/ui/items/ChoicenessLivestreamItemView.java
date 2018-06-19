package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.i;
import com.xunlei.downloadprovider.homepage.choiceness.f;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i$a;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.z;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ui.MediaPlayerLoadingView;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.ui.s;

public class ChoicenessLivestreamItemView extends LinearLayout implements b<i>, i$a, z, com.xunlei.downloadprovider.player.a.b {
    private static Handler g = new Handler();
    private static Runnable h;
    private static Runnable i;
    private static String j;
    private com.xunlei.downloadprovider.player.a.a a;
    private i b;
    private a c;
    private com.xunlei.downloadprovider.homepage.follow.b d;
    private com.xunlei.downloadprovider.homepage.choiceness.ui.i e;
    private BroadcastReceiver f;
    private LoginHelper k;
    private AnimationDrawable l;
    private String m;
    private boolean n;
    private Animation o;

    private static class a {
        int a;
        View b;
        View c;
        ImageView d;
        TextView e;
        TextView f;
        ImageView g;
        ImageView h;
        TextView i;
        FollowBtnView j;
        FrameLayout k;
        FrameLayout l;
        MediaPlayerLoadingView m;
        ImageView n;
        UserInfoTagView o;
        ImageView p;
        TextView q;
        View r;
        View s;
        TextView t;
        TextView u;
        TextView v;
        ImageView w;

        private a() {
        }
    }

    public final boolean d() {
        return false;
    }

    @NonNull
    public String getReportContentType() {
        return "live";
    }

    public final /* synthetic */ void a(int i, com.xunlei.downloadprovider.homepage.choiceness.ui.i iVar, int i2, View view, e eVar) {
        i iVar2 = (i) eVar;
        i2 = new q(this, iVar2);
        this.b = iVar2;
        a aVar = (a) getTag();
        this.c = aVar;
        int a = s.a();
        this.n = TextUtils.isEmpty(iVar2.z) ^ 1;
        if (this.n) {
            aVar.g.setVisibility(8);
            a = ((int) (((double) a) / 0.75d)) - (DipPixelUtil.dip2px(13.0f) * 2);
            if (aVar.b.getLayoutParams().width != a) {
                aVar.b.getLayoutParams().width = a;
                aVar.b.getLayoutParams().height = a;
                aVar.b.setLayoutParams(aVar.b.getLayoutParams());
            }
        } else {
            aVar.g.setVisibility(0);
            if (aVar.b.getLayoutParams().width != a) {
                aVar.b.getLayoutParams().width = a;
                aVar.b.getLayoutParams().height = a;
                aVar.b.setLayoutParams(aVar.b.getLayoutParams());
            }
        }
        if (iVar2.a()) {
            aVar.r.setVisibility(0);
            aVar.t.setText(TextUtils.isEmpty(iVar2.A) ? "直播新人专属红包礼物" : iVar2.A);
            aVar.u.setText(TextUtils.isEmpty(iVar2.B) ? "点击即可获得免费礼物" : iVar2.B);
            aVar.v.setText(TextUtils.isEmpty(iVar2.C) ? "领取" : iVar2.C);
            if (!TextUtils.isEmpty(iVar2.D)) {
                com.xunlei.downloadprovider.homepage.choiceness.b.a().a(iVar2.D, aVar.w, null);
            }
            aVar.w.startAnimation(this.o);
        } else {
            aVar.r.setVisibility(8);
        }
        this.m = iVar2.z;
        aVar.a = i;
        aVar.d.setOnClickListener(i2);
        aVar.c.setOnClickListener(i2);
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        com.xunlei.downloadprovider.homepage.choiceness.b.a(iVar2.b, aVar.d);
        aVar.e.setText(iVar2.p);
        i2 = aVar.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(iVar2.v));
        stringBuilder.append("人在看");
        i2.setText(stringBuilder.toString());
        i2 = com.xunlei.downloadprovider.homepage.choiceness.b.a();
        String str = iVar2.r;
        if (!TextUtils.isEmpty(iVar2.s)) {
            str = iVar2.s;
        }
        i2.a(str, aVar.g, null);
        aVar.i.setText(iVar2.t);
        i2 = iVar2.E;
        aVar.o.setUserInfo(i2);
        aVar.j.setUserInfo(i2);
        Long.parseLong(i2.getUid());
        aVar.j.setFollowListener(new r(this));
        this.e = iVar;
        this.e.a(this);
        iVar = new s(this, i, iVar2, aVar);
        view.setOnClickListener(iVar);
        aVar.s.setOnClickListener(iVar);
    }

    public ChoicenessLivestreamItemView(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context);
        this.k = LoginHelper.a();
        this.a = aVar;
        a(context);
    }

    public ChoicenessLivestreamItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicenessLivestreamItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = LoginHelper.a();
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.choiceness_livestream_item, this, true);
        View findViewById = context.findViewById(R.id.item_content);
        a aVar = new a();
        aVar.b = findViewById;
        aVar.c = context.findViewById(R.id.publisher_layout);
        aVar.d = (ImageView) context.findViewById(R.id.publisher_icon);
        aVar.e = (TextView) context.findViewById(R.id.publisher_name);
        aVar.q = (TextView) context.findViewById(R.id.tv_from_youliao_shot);
        aVar.q.setText("来自：迅雷直播");
        setPlatformTextView(aVar.q);
        aVar.f = (TextView) context.findViewById(R.id.tv_live_num);
        aVar.g = (ImageView) context.findViewById(R.id.iv_cover);
        aVar.h = (ImageView) context.findViewById(R.id.iv_live_status_anim);
        ((AnimationDrawable) aVar.h.getDrawable()).start();
        aVar.i = (TextView) context.findViewById(R.id.tv_title);
        aVar.j = (FollowBtnView) context.findViewById(R.id.tv_follow_btn);
        aVar.l = (FrameLayout) context.findViewById(R.id.live_player_container);
        aVar.k = (FrameLayout) context.findViewById(R.id.live_room_container);
        aVar.m = (MediaPlayerLoadingView) context.findViewById(R.id.play_loading_ani);
        aVar.n = (ImageView) context.findViewById(R.id.iv_voice_animation);
        aVar.o = (UserInfoTagView) context.findViewById(R.id.view_user_info_tag);
        aVar.p = (ImageView) context.findViewById(R.id.iv_like_bubble_animation);
        aVar.r = context.findViewById(R.id.new_user_gift_pack_layout);
        aVar.s = context.findViewById(R.id.new_user_gift);
        aVar.t = (TextView) context.findViewById(R.id.title);
        aVar.u = (TextView) context.findViewById(R.id.subtitle);
        aVar.v = (TextView) context.findViewById(R.id.receive);
        aVar.w = (ImageView) context.findViewById(R.id.gift_pack_image);
        this.o = new RotateAnimation(-10.0f, 10.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.o.setRepeatMode(2);
        this.o.setRepeatCount(-1);
        this.o.setDuration(200);
        this.o.setInterpolator(new LinearInterpolator());
        setTag(aVar);
        this.d = com.xunlei.downloadprovider.homepage.follow.b.a();
    }

    private void setPlatformTextView(TextView textView) {
        textView.setText("来自迅雷直播APP");
        textView.setOnClickListener(new t(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == null) {
            IntentFilter intentFilter = new IntentFilter("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN");
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getContext());
            BroadcastReceiver vVar = new v(this);
            this.f = vVar;
            instance.registerReceiver(vVar, intentFilter);
        }
        Drawable drawable = ((a) getTag()).p.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.l = (AnimationDrawable) drawable;
            this.l.start();
        }
        Intent intent = new Intent("live_viewfinder_show");
        intent.putExtra("live_player_image", this.m);
        if (this.n) {
            LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e != null) {
            this.e.b.remove(this);
            this.e = null;
        }
        if (this.f != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f);
            this.f = null;
        }
        if (this.l != null) {
            this.l.stop();
        }
        if (this.n) {
            LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent("live_viewfinder_hide"));
        }
    }

    public View getPlayerContainerView() {
        return this.c.l;
    }

    public final boolean c() {
        a(500);
        return true;
    }

    private static boolean h() {
        return j != null;
    }

    public int getPosition() {
        return this.c.a;
    }

    public final void f() {
        postDelayed(new w(this), 200);
    }

    private void a(int i) {
        if (h != null) {
            g.removeCallbacks(h);
            h = null;
        }
        if (i > 0) {
            Handler handler = g;
            Runnable xVar = new x(this);
            h = xVar;
            handler.postDelayed(xVar, (long) i);
            return;
        }
        if (h() != 0) {
            this.a.a(null);
        }
        com.xunlei.downloadprovider.launch.b.a.a().stopLivePlay(getContext(), this.c.l);
        setAutoPlayState(null);
        if (i != 0) {
            g.removeCallbacks(i);
            i = null;
        }
    }

    private void setAutoPlayState(String str) {
        j = str;
        if (str != null) {
            this.c.m.setVisibility(0);
            this.c.m.a();
            com.xunlei.downloadprovider.launch.b.a.a().showRoomView(getContext(), this.c.k, str, false, true);
            return;
        }
        this.c.m.b();
        this.c.m.setVisibility(8);
        com.xunlei.downloadprovider.launch.b.a.a().showRoomView(getContext(), this.c.k, str, false, false);
    }

    public final void a() {
        new StringBuilder("onItemExposure--pos=").append(this.c.a);
        f.a(this.b.x);
    }

    public final boolean b() {
        if (h != null) {
            g.removeCallbacks(h);
            h = null;
        }
        String str = this.b.u;
        if (j == null || !j.equals(str)) {
            if (i != null) {
                g.removeCallbacks(i);
                i = null;
            }
            setAutoPlayState(str);
            com.xunlei.downloadprovider.launch.b.a.a().startLivePlay(getContext(), this.c.l, 2, ThunderXmpPlayer.c(), str);
        }
        return true;
    }

    static /* synthetic */ void d(ChoicenessLivestreamItemView choicenessLivestreamItemView) {
        Context context = choicenessLivestreamItemView.getContext();
        if (context != null) {
            new com.xunlei.downloadprovider.publiser.campaign.a(context, "", new u(choicenessLivestreamItemView)).show();
        }
    }
}
