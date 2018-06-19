package com.xunlei.downloadprovider.vod.subtitle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.vod.player.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VodPlayerSubtitleAdjustPopupWindow */
public class s extends d implements OnClickListener {
    private static final String d = "s";
    public LoopView a;
    public a b;
    private View e;
    private ImageView f;
    private ImageView g;
    private int h;

    /* compiled from: VodPlayerSubtitleAdjustPopupWindow */
    public interface a extends e {
        void b(int i);
    }

    public s(Context context) {
        super(context);
        context = LayoutInflater.from(context).inflate(R.layout.vod_player_subtitle_adjust_popuwindow, null);
        setContentView(context);
        this.a = (LoopView) context.findViewById(R.id.v_adjust);
        List arrayList = new ArrayList(20);
        for (int i = -10; i <= 10; i++) {
            y yVar = new y();
            yVar.a = String.format("%.1f", new Object[]{Float.valueOf(((float) i) / 2.0f)});
            yVar.b = i * 500;
            new StringBuilder("item value : ").append(yVar.b);
            arrayList.add(yVar);
        }
        this.a.setItems(arrayList);
        this.e = context.findViewById(R.id.tv_title_back);
        this.e.setOnClickListener(new t(this));
        context.findViewById(R.id.white_btn).setOnClickListener(this);
        context.findViewById(R.id.black_btn).setOnClickListener(this);
        this.f = (ImageView) context.findViewById(R.id.white_btn_image);
        this.g = (ImageView) context.findViewById(R.id.black_btn_image);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        context.setFocusable(true);
        context.setFocusableInTouchMode(true);
    }

    public final void a(View view, int i, int i2) {
        super.showAtLocation(view, 5, 0, 0);
        view = this.a.a(String.format("%.1f", new Object[]{Float.valueOf(((float) i) / 1148846080)}));
        if (view >= null) {
            this.a.setCurrentPosition(view);
        }
        this.h = i2;
        if (i2 == this.c.getResources().getColor(R.color.vod_player_subtitle_color_white)) {
            a(true);
        } else {
            a(false);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.black_btn:
            case R.id.black_btn_image:
                a(null);
                view = this.c.getResources().getColor(R.color.vod_player_subtitle_color_black);
                if (!(this.b == null || view == this.h)) {
                    this.b.b(view);
                }
                this.h = view;
                break;
            case R.id.white_btn:
            case R.id.white_btn_image:
                a(true);
                view = this.c.getResources().getColor(R.color.vod_player_subtitle_color_white);
                if (!(this.b == null || view == this.h)) {
                    this.b.b(view);
                }
                this.h = view;
                return;
            default:
                break;
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f.setImageResource(R.drawable.vod_subtitle_checked);
            this.g.setImageResource(R.drawable.vod_subtitle_no_check);
            return;
        }
        this.f.setImageResource(R.drawable.vod_subtitle_no_check);
        this.g.setImageResource(R.drawable.vod_subtitle_checked);
    }
}
