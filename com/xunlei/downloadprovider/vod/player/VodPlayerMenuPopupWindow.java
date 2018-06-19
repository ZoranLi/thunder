package com.xunlei.downloadprovider.vod.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public final class VodPlayerMenuPopupWindow extends d {
    public boolean a = true;
    public boolean b = true;
    public View d;
    public RadioGroup e;
    public RadioButton f;
    public RadioButton g;
    public RadioButton h;
    public RadioGroup i;
    public RadioButton j;
    public RadioButton k;
    public RadioButton l;
    public SeekBar m;
    public SeekBar n;
    public a o;

    public enum VideoSize {
        SIZE_100(1.0d),
        SIZE_75(0.75d),
        SIZE_50(0.5d);
        
        double size;

        private VideoSize(double d) {
            this.size = d;
        }

        public final double getValue() {
            return this.size;
        }
    }

    public interface a {
        void a(VideoSize videoSize, boolean z);

        void a(String str, boolean z);
    }

    public VodPlayerMenuPopupWindow(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.vod_player_menu_popuwindow, null);
        setContentView(inflate);
        this.e = (RadioGroup) inflate.findViewById(R.id.vod_player_menu_video_size_parent);
        this.f = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_size_100);
        this.g = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_size_75);
        this.h = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_size_50);
        this.i = (RadioGroup) inflate.findViewById(R.id.vod_player_menu_video_adapter_parent);
        this.j = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_adapter_normal);
        this.k = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_adapter_stretch);
        this.l = (RadioButton) inflate.findViewById(R.id.vod_player_menu_video_adapter_cut);
        this.m = (SeekBar) inflate.findViewById(R.id.vod_player_menu_voice_pbar);
        this.n = (SeekBar) inflate.findViewById(R.id.vod_player_menu_brightness_pbar);
        this.m.getViewTreeObserver().addOnPreDrawListener(new f(this, context));
        this.n.getViewTreeObserver().addOnPreDrawListener(new g(this, context));
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        this.d = inflate;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public final void a(int i) {
        this.m.setMax(100);
        this.m.setProgress(i);
    }
}
