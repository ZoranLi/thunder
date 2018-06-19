package com.xunlei.downloadprovider.download.player.views.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;

public class PlayerTopViewGroup extends PlayerViewGroupBase implements OnClickListener {
    public RelativeLayout a;
    private View b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private ImageView h;
    private ImageView i;
    private ImageView j;

    public PlayerTopViewGroup(Context context) {
        super(context);
    }

    public PlayerTopViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerTopViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (RelativeLayout) findViewById(R.id.player_top_controller_bar);
        this.b = findViewById(R.id.close_btn);
        this.b.setOnClickListener(this);
        this.d = (ImageView) findViewById(R.id.subtitle_button);
        this.e = (ImageView) findViewById(R.id.btn_dlna);
        this.h = (ImageView) findViewById(R.id.detail_title_share_icon);
        this.c = (TextView) findViewById(R.id.top_bar_title);
        this.i = (ImageView) findViewById(R.id.float_window_btn);
        this.i.setOnClickListener(this);
        if (d.a().i.h()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.j = (ImageView) findViewById(R.id.detail_title_right_icon);
        this.j.setOnClickListener(this);
    }

    public void setTitle(String str) {
        this.c.setText(str);
    }

    public void setTitleVisible(boolean z) {
        this.c.setVisibility(z ? false : true);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.float_window_btn) {
            switch (id) {
                case R.id.close_btn:
                    if (this.f != null) {
                        this.f.a(view);
                        return;
                    }
                    break;
                case R.id.detail_title_right_icon:
                    if (this.f != null) {
                        this.f.b(view);
                        break;
                    }
                    break;
                default:
                    break;
            }
        } else if (this.f != null) {
            this.f.f();
        }
    }

    public final void a(boolean z) {
        super.a(z);
        LayoutParams layoutParams;
        if (z) {
            layoutParams = (LayoutParams) this.d.getLayoutParams();
            layoutParams.rightMargin = DipPixelUtil.dip2px(20.0f);
            this.d.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.rightMargin = DipPixelUtil.dip2px(10.0f);
            this.e.setLayoutParams(layoutParams2);
            layoutParams2 = (FrameLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams2.rightMargin = DipPixelUtil.dip2px(10.0f);
            this.e.setLayoutParams(layoutParams2);
            layoutParams2 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.rightMargin = DipPixelUtil.dip2px(10.0f);
            this.e.setLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) this.d.getLayoutParams();
            layoutParams.rightMargin = DipPixelUtil.dip2px(10.0f);
            this.d.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams3.rightMargin = 0;
            this.e.setLayoutParams(layoutParams3);
            layoutParams3 = (FrameLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams3.rightMargin = 0;
            this.e.setLayoutParams(layoutParams3);
            layoutParams3 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams3.rightMargin = 0;
            this.e.setLayoutParams(layoutParams3);
        }
        if (z) {
            this.a.setBackgroundResource(R.drawable.vod_player_bottom_bar_bg);
            setTitleVisible(true);
            return;
        }
        this.a.setBackgroundResource(R.drawable.downloadvod_player_bg_top_bar);
        setTitleVisible(false);
    }
}
