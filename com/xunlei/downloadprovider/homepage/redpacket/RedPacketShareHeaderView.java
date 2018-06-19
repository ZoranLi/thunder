package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

public class RedPacketShareHeaderView extends RelativeLayout {
    private View a;
    private View b;
    private TextView c;
    private String d;
    private Context e;

    public RedPacketShareHeaderView(Context context, String str) {
        super(context);
        this.d = str;
        a(context);
    }

    public RedPacketShareHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.e = context;
        LayoutInflater.from(context).inflate(R.layout.view_share_dlg_header, this);
        this.c = (TextView) findViewById(R.id.tv_red_packet_profit);
        ((TextView) findViewById(R.id.tv_share_title)).setText(d.a().l.h());
        ((TextView) findViewById(R.id.tv_share_header_desc)).setText(d.a().l.g());
        this.a = findViewById(R.id.tv_go_detail);
        this.b = findViewById(R.id.ll_share_profit);
        ((ImageView) findViewById(R.id.iv_share_header)).setOnClickListener(new p(this));
        LoginHelper.a();
        if (l.c() != null) {
            j.a();
            j.a(new q(this));
        }
    }

    static /* synthetic */ void a(RedPacketShareHeaderView redPacketShareHeaderView, boolean z) {
        if (z) {
            redPacketShareHeaderView.a.setVisibility(8);
            redPacketShareHeaderView.b.setVisibility(0);
            return;
        }
        redPacketShareHeaderView.a.setVisibility(0);
        redPacketShareHeaderView.b.setVisibility(8);
    }
}
