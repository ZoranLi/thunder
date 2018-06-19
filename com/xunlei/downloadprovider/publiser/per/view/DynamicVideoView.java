package com.xunlei.downloadprovider.publiser.per.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.xllib.b.j;

public class DynamicVideoView extends LinearLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;

    public DynamicVideoView(Context context) {
        super(context);
        a();
    }

    public DynamicVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DynamicVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_base_layout, this);
        setBackgroundColor(-526345);
        this.a = (ImageView) findViewById(R.id.iv_poster);
        this.b = (TextView) findViewById(R.id.tv_duration);
        this.c = (TextView) findViewById(R.id.tv_title);
        this.d = (TextView) findViewById(R.id.tv_good);
        this.e = (TextView) findViewById(R.id.tv_play);
    }

    public final void a(BaseVideoInfo baseVideoInfo) {
        Object coverUrl = baseVideoInfo.getCoverUrl();
        if (TextUtils.isEmpty(coverUrl)) {
            this.a.setImageResource(R.drawable.publisher_dynamic_video_not_found_poster);
        } else {
            Glide.with(this.a.getContext()).load(coverUrl).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).placeholder(R.drawable.choiceness_icon_default).into(this.a);
        }
        long duration = (long) baseVideoInfo.getDuration();
        if (duration > 0) {
            this.b.setText(j.a(duration * 1000));
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        if (baseVideoInfo.getStatus() == 0) {
            this.c.setText("该视频已下线");
            return;
        }
        if (baseVideoInfo.getStatus() != 2) {
            if (baseVideoInfo.getStatus() != -2) {
                if (TextUtils.isEmpty(baseVideoInfo.getTitle())) {
                    this.c.setText("");
                    return;
                }
                this.c.setText(baseVideoInfo.getTitle());
                int playCount = baseVideoInfo.getPlayCount();
                if (playCount > 0) {
                    TextView textView = this.e;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) playCount));
                    stringBuilder.append("次观看");
                    textView.setText(stringBuilder.toString());
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                }
                baseVideoInfo = baseVideoInfo.getLikeCount();
                if (baseVideoInfo > null) {
                    TextView textView2 = this.d;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(com.xunlei.downloadprovider.homepage.choiceness.j.a((long) baseVideoInfo));
                    stringBuilder2.append("人赞过");
                    textView2.setText(stringBuilder2.toString());
                    this.d.setVisibility(0);
                    return;
                }
                this.d.setVisibility(8);
                return;
            }
        }
        this.c.setText("该视频已删除");
    }
}
