package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.GenderInfo;
import com.xunlei.downloadprovider.publiser.common.PublisherInfo;
import com.xunlei.downloadprovider.publiser.common.h;
import com.xunlei.downloadprovider.shortvideo.entity.VipExtra;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.thunder.commonui.widget.CircleImageView;

/* compiled from: FollowDialog */
public final class b extends XLBaseDialog {
    public OnClickListener a;
    private View b = LayoutInflater.from(this.mCtx).inflate(R.layout.comment_follow_popview, null);
    private CircleImageView c;
    private CircleImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private TextView n;
    private OnClickListener o;
    private View.OnClickListener p = new c(this);
    private boolean q = null;
    private PublisherInfo r;
    private TextView s;
    private LinearLayout t;

    public b(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        setContentView(this.b);
        context = getWindow();
        LayoutParams attributes = context.getAttributes();
        int dip2px = DipPixelUtil.dip2px(315.0f);
        attributes.gravity = 17;
        attributes.width = dip2px;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        context.setAttributes(attributes);
        context = getWindow().getAttributes();
        context.alpha = 1.0f;
        context.dimAmount = 0.6f;
        getWindow().setAttributes(context);
        getWindow().addFlags(2);
        this.r = new PublisherInfo();
        this.c = (CircleImageView) findViewById(R.id.person_info_head);
        this.d = (CircleImageView) findViewById(R.id.person_info_headtype);
        this.e = (TextView) findViewById(R.id.person_info_name);
        this.f = (TextView) findViewById(R.id.person_info_video_count);
        this.g = (TextView) findViewById(R.id.person_info_fans_count);
        this.s = (TextView) findViewById(R.id.publisher_type);
        this.h = (ImageView) findViewById(R.id.img_sex);
        this.i = (TextView) findViewById(R.id.tv_constellation);
        this.j = (TextView) findViewById(R.id.tv_location);
        this.k = (TextView) findViewById(R.id.tv_vip);
        this.l = (ImageView) findViewById(R.id.img_vip_type);
        this.m = (ImageView) findViewById(R.id.follow_cancel_tv);
        this.n = (TextView) findViewById(R.id.follow_tv);
        this.t = (LinearLayout) findViewById(R.id.private_info);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.d.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.f.setText("0视频");
        this.g.setText("0粉丝");
        this.m.setOnClickListener(this.p);
        this.n.setOnClickListener(this.p);
    }

    public final View findViewById(int i) {
        return this.b.findViewById(i);
    }

    public final void a(PublisherInfo publisherInfo) {
        this.q = true;
        this.r = publisherInfo;
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        com.xunlei.downloadprovider.homepage.choiceness.b.a(this.r.a().getPortraitUrl(), this.c, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
        this.e.setText(this.r.a().getNickname());
        long parseLong = this.r != null ? Long.parseLong(this.r.a().getUid()) : 0;
        if (parseLong != 0) {
            new h().a(parseLong, new d(this));
        }
    }

    private static boolean a(View view) {
        return view.getVisibility() == null ? true : null;
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.o == null) {
            bVar.dismiss();
        } else {
            bVar.o.onClick(bVar, -2);
        }
    }

    static /* synthetic */ void b(b bVar) {
        if (bVar.a == null) {
            bVar.dismiss();
        } else {
            bVar.a.onClick(bVar, -1);
        }
    }

    static /* synthetic */ void c(b bVar) {
        if (bVar.r != null) {
            VipExtra vipExtra;
            LinearLayout linearLayout;
            TextView textView = bVar.f;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.r.a().getParamsExtra().c);
            stringBuilder.append("视频");
            textView.setText(stringBuilder.toString());
            textView = bVar.g;
            stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.r.b().b);
            stringBuilder.append("粉丝");
            textView.setText(stringBuilder.toString());
            GenderInfo castStringToGenderInfo = GenderInfo.castStringToGenderInfo(bVar.r.a().getSex());
            int i = 8;
            boolean z = true;
            if (castStringToGenderInfo == GenderInfo.FEMALE) {
                bVar.h.setSelected(true);
                bVar.i.setSelected(true);
                bVar.j.setSelected(true);
                bVar.h.setVisibility(0);
            } else if (castStringToGenderInfo == GenderInfo.MALE) {
                bVar.h.setSelected(false);
                bVar.i.setSelected(false);
                bVar.j.setSelected(false);
                bVar.h.setVisibility(0);
            } else {
                bVar.h.setVisibility(8);
                bVar.i.setSelected(false);
                bVar.j.setSelected(false);
            }
            bVar.i.setVisibility(8);
            if (!TextUtils.isEmpty(bVar.r.e())) {
                new StringBuilder("constellation=").append(bVar.r.e());
                bVar.i.setText(bVar.r.e());
                bVar.i.setVisibility(0);
            }
            bVar.j.setVisibility(8);
            if (!TextUtils.isEmpty(bVar.r.d())) {
                if (bVar.r.d().length() > 11) {
                    bVar.j.setText(bVar.r.a().getProvince());
                    bVar.j.setVisibility(0);
                } else if (!TextUtils.isEmpty(bVar.r.a().getProvince())) {
                    bVar.j.setText(bVar.r.d());
                    bVar.j.setVisibility(0);
                }
            }
            bVar.k.setVisibility(8);
            bVar.l.setVisibility(8);
            PublisherInfo publisherInfo = bVar.r;
            String str = null;
            if (publisherInfo.a == null) {
                vipExtra = null;
            } else {
                VipExtra vipExtra2 = (VipExtra) publisherInfo.a.getVipExtras().a().get(2);
                vipExtra = (VipExtra) publisherInfo.a.getVipExtras().a().get(14);
                if (vipExtra2 == null || !vipExtra2.a) {
                    if (vipExtra == null || !vipExtra.a) {
                        if (vipExtra2 == null) {
                        }
                    }
                }
                vipExtra = vipExtra2;
            }
            if (vipExtra != null) {
                if (vipExtra.a) {
                    bVar.k.setVisibility(0);
                    TextView textView2 = bVar.k;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(vipExtra.b);
                    textView2.setText(stringBuilder2.toString());
                }
                if (vipExtra.e) {
                    bVar.l.setVisibility(0);
                }
            }
            if (bVar.r != null) {
                str = bVar.r.a().getKind();
                ImageView imageView = bVar.d;
                PublisherInfo publisherInfo2 = bVar.r;
                boolean z2 = publisherInfo2.a != null && publisherInfo2.a.getPubExtra().a == 1;
                m.a(imageView, z2, str);
            }
            if (!TextUtils.isEmpty(str)) {
                boolean z3;
                bVar.s.setVisibility(0);
                if (!("yl_daren".equals(str) || "yl_nanshen".equals(str))) {
                    if (!"yl_nvshen".equals(str)) {
                        z3 = false;
                        if (z3) {
                            if (str.equals("rad")) {
                                bVar.s.setText("迅雷主播");
                            }
                        } else if (str.equals("yl_nanshen")) {
                            bVar.s.setText("有料男神");
                        } else if (str.equals("yl_nvshen")) {
                            bVar.s.setText("有料达人");
                        } else {
                            bVar.s.setText("有料女神");
                        }
                        linearLayout = bVar.t;
                        if (a(bVar.h)) {
                            if (a(bVar.i)) {
                                if (a(bVar.j)) {
                                    if (a(bVar.s)) {
                                        if (a(bVar.k)) {
                                            if (a(bVar.l) != null) {
                                                z = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (z) {
                            i = 0;
                        }
                        linearLayout.setVisibility(i);
                    }
                }
                z3 = true;
                if (z3) {
                    if (str.equals("rad")) {
                        bVar.s.setText("迅雷主播");
                    }
                } else if (str.equals("yl_nanshen")) {
                    bVar.s.setText("有料男神");
                } else if (str.equals("yl_nvshen")) {
                    bVar.s.setText("有料达人");
                } else {
                    bVar.s.setText("有料女神");
                }
                linearLayout = bVar.t;
                if (a(bVar.h)) {
                    if (a(bVar.i)) {
                        if (a(bVar.j)) {
                            if (a(bVar.s)) {
                                if (a(bVar.k)) {
                                    if (a(bVar.l) != null) {
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    i = 0;
                }
                linearLayout.setVisibility(i);
            }
            bVar.s.setVisibility(8);
            linearLayout = bVar.t;
            if (a(bVar.h)) {
                if (a(bVar.i)) {
                    if (a(bVar.j)) {
                        if (a(bVar.s)) {
                            if (a(bVar.k)) {
                                if (a(bVar.l) != null) {
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                i = 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}
