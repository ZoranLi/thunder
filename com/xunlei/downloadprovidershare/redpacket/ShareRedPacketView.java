package com.xunlei.downloadprovidershare.redpacket;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovidershare.R;

public class ShareRedPacketView extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;

    public ShareRedPacketView(Context context) {
        super(context);
        a(context);
    }

    public ShareRedPacketView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.red_packet_share_view, this);
        this.a = (ImageView) findViewById(R.id.iv_video_poster_blur);
        this.b = (ImageView) findViewById(R.id.user_portrait_icon);
        this.c = (TextView) findViewById(R.id.tv_user_name);
        this.h = (TextView) findViewById(R.id.tv_gain_cash);
        this.e = (ImageView) findViewById(R.id.iv_video_poster);
        this.f = (TextView) findViewById(R.id.tv_video_duration);
        this.g = (TextView) findViewById(R.id.tv_video_play_count);
        this.d = (TextView) findViewById(R.id.tv_video_title);
        this.i = (ImageView) findViewById(R.id.iv_qr_code);
    }

    public void setUserNickName(String str) {
        this.c.setText(str);
    }

    public void setGainCash(String str) {
        this.h.setText(str);
    }

    public void setGainCashTvVisible(int i) {
        this.h.setVisibility(i);
    }

    public void setVideoDuration(String str) {
        this.f.setText(str);
    }

    public void setVideoPlayCount(String str) {
        this.g.setText(str);
    }

    public void setVideoTitle(String str) {
        this.d.setText(str);
    }

    public ImageView getUserPortraitIv() {
        return this.b;
    }

    public ImageView getVideoPosterIv() {
        return this.e;
    }

    public void setQrCodeIv(Bitmap bitmap) {
        this.i.setImageBitmap(bitmap);
    }

    public void setVideoPosterBlur(int i) {
        this.a.setBackgroundResource(i);
    }
}
