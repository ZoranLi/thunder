package com.xunlei.downloadprovider.vod.player;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.vod.player.VodPlayerMenuPopupWindow.VideoSize;

/* compiled from: VodPlayerMenuPopupWindow */
public final class h implements OnCheckedChangeListener {
    final /* synthetic */ VodPlayerMenuPopupWindow a;

    public h(VodPlayerMenuPopupWindow vodPlayerMenuPopupWindow) {
        this.a = vodPlayerMenuPopupWindow;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.a.o != null) {
            switch (i) {
                case R.id.vod_player_menu_video_size_100:
                    this.a.o.a(VideoSize.SIZE_100, this.a.a);
                    return;
                case R.id.vod_player_menu_video_size_75:
                    this.a.o.a(VideoSize.SIZE_75, this.a.a);
                    return;
                case R.id.vod_player_menu_video_size_50:
                    this.a.o.a(VideoSize.SIZE_50, this.a.a);
                    return;
                case R.id.vod_player_menu_video_adapter_normal:
                    this.a.o.a("0", this.a.b);
                    return;
                case R.id.vod_player_menu_video_adapter_stretch:
                    this.a.o.a("2", this.a.b);
                    return;
                case R.id.vod_player_menu_video_adapter_cut:
                    this.a.o.a("1", this.a.b);
                    break;
                default:
                    break;
            }
        }
    }
}
