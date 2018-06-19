package com.xunlei.downloadprovider.discovery.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.discovery.b.b;
import com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoActivity;
import com.xunlei.downloadprovider.personal.redenvelope.f;
import com.xunlei.downloadprovider.web.a;

public class DiscoveryTabItemView extends FrameLayout implements OnClickListener {
    public RelativeLayout a;
    public View b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public ImageView k;
    public String l;
    public o m;
    public boolean n;
    private View o;
    private RelativeLayout p;

    public DiscoveryTabItemView(Context context) {
        super(context);
        a(context);
    }

    public DiscoveryTabItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DiscoveryTabItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.o = LayoutInflater.from(context).inflate(R.layout.discovery_item_tip_layout, this);
        this.b = this.o.findViewById(R.id.top_divider_space);
        this.c = (TextView) this.o.findViewById(R.id.tv_header);
        this.a = (RelativeLayout) this.o.findViewById(R.id.rl_tip_layout);
        this.p = (RelativeLayout) this.o.findViewById(R.id.rl_config_view);
        this.d = (ImageView) this.o.findViewById(R.id.iv_find_item_icon);
        this.e = (TextView) this.o.findViewById(R.id.tv_find_item_name);
        this.f = (TextView) this.o.findViewById(R.id.tv_find_item_tip_text);
        this.g = (ImageView) this.o.findViewById(R.id.iv_find_item_tip_pic);
        this.h = (ImageView) this.o.findViewById(R.id.iv_find_item_tip_red_point);
        this.i = (ImageView) this.o.findViewById(R.id.iv_find_item_go);
        this.j = (LinearLayout) this.o.findViewById(R.id.ll_content);
        this.k = (ImageView) this.o.findViewById(R.id.iv_content);
        this.a.setOnClickListener(this);
        this.k.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        String str = null;
        if (view != R.id.rl_tip_layout) {
            if (view == R.id.iv_content) {
                if ("e_commerce".equals(this.m.a) != null) {
                    a.a();
                    a.a(getContext(), this.m.D, this.m.E, "");
                } else {
                    a.a();
                    a.a(getContext(), this.m.D, this.m.E, "");
                }
                view = "business_pic";
                String str2 = SocializeConstants.KEY_PIC;
                if (this.m != null) {
                    str = this.m.f;
                }
                com.xunlei.downloadprovider.discovery.b.a.a(view, str2, str);
            }
            return;
        }
        if (this.m.a.equals("kuainiao") != null) {
            int i = 0;
            view = BrothersApplication.getApplicationInstance().getSharedPreferences("find_fragment_KuaiNiao_RedPoint", 0).edit();
            view.putBoolean("findNeedShowKuaiNiaoRedPoint", false);
            view.commit();
            this.h.setVisibility(b.b() ? 0 : 8);
            view = this.f;
            if (!b.b()) {
                i = 8;
            }
            view.setVisibility(i);
            if (getContext() != null) {
                getContext().startActivity(KuaiNiaoActivity.a(getContext(), "k_an_shoulei_hytq_fx_kn"));
            }
        } else if ("e_commerce".equals(this.m.a) != null) {
            if ("web".equals(this.m.f) != null) {
                a.a();
                a.a(getContext(), this.m.e, this.m.q, "");
            } else {
                a.a();
                a.a(getContext(), this.m.e, this.m.q, "");
            }
        } else if ("red_packet".equals(this.m.a) != null) {
            view = new StringBuilder();
            view.append(this.m.e);
            view.append("?from=find_hongbao_default");
            view = view.toString();
            a.a();
            a.a(getContext(), view, this.m.q, "find_hongbao_default");
            f.b("find_hongbao_default");
        } else {
            a.a();
            a.a(getContext(), this.m.e, this.m.q, "");
        }
        if (this.l.equals("kuainiao") == null) {
            this.p.setVisibility(8);
        }
        String str3 = this.m.a;
        str2 = str3.equals("caomei_live") ? "caomei_live" : str3.equals("activity_center") ? "activity" : str3.equals("game_center") ? "game_center" : str3.equals("snatch") ? "yiyuan" : str3.equals("finance") ? "finance" : str3.equals("beauty") ? "beauty" : str3.equals("mo_jin") ? "caijing" : str3.equals("kuainiao") ? "kuainiao" : str3.equals("remote_download") ? "remote" : str3.equals("local_service") ? "tongcheng_main" : str3.equals("e_commerce") ? "business_main" : str3.equals("red_packet") ? "hongbao" : str3;
        view = b.a(str3);
        if (this.m != null) {
            str = this.m.f;
        }
        com.xunlei.downloadprovider.discovery.b.a.a(str2, view, str);
        i.a().a(System.currentTimeMillis(), this.l);
    }

    public void setRightTipUIForKuaiNiao(boolean z) {
        if (!(this.p == null || this.p.getVisibility() == 8 || this.m == null)) {
            if (this.l.equals("kuainiao")) {
                this.g.setVisibility(0);
                if (!TextUtils.isEmpty(this.m.d) && b.b()) {
                    b(this.m.d, this.g);
                } else if (z) {
                    this.g.setImageResource(R.drawable.ic_kuainiao_vip);
                    LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    this.g.setLayoutParams(layoutParams);
                } else {
                    this.g.setVisibility(8);
                }
            }
        }
    }

    public final void a(String str, ImageView imageView) {
        Glide.with(getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    public final void b(String str, ImageView imageView) {
        Glide.with(getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).override(Integer.MIN_VALUE, Integer.MIN_VALUE).into(imageView);
    }
}
