package com.xunlei.downloadprovider.download.player.views.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskRangeInfo;
import com.xunlei.downloadprovider.download.player.PlayProgressRanges;
import com.xunlei.downloadprovider.download.player.views.PlayerViewGroupBase;
import com.xunlei.downloadprovider.vod.player.PlaySeekBar;
import java.util.ArrayList;
import java.util.List;

public class PlayerBottomViewGroup extends PlayerViewGroupBase implements OnClickListener {
    private static final String b = "PlayerBottomViewGroup";
    public RelativeLayout a;
    private View c;
    private LinearLayout d;
    private ImageButton e;
    private TextView h;
    private TextView i;
    private PlaySeekBar j;
    private View k;
    private int l = 0;
    private View m;
    private boolean n = false;
    private a o;

    public interface a {
        void a(boolean z);
    }

    public PlayerBottomViewGroup(Context context) {
        super(context);
    }

    public PlayerBottomViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerBottomViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (RelativeLayout) findViewById(R.id.player_bottom_controller_bar);
        this.c = findViewById(R.id.layout_player_bottom);
        this.d = (LinearLayout) findViewById(R.id.layout_bottom_bar_center);
        this.e = (ImageButton) findViewById(R.id.bottom_bar_btn_play_pause);
        this.j = (PlaySeekBar) findViewById(R.id.bottom_bar_progress);
        this.h = (TextView) findViewById(R.id.bottom_bar_text_duration);
        this.i = (TextView) findViewById(R.id.bottom_bar_text_played);
        this.k = findViewById(R.id.full_screen_btn);
        this.m = findViewById(R.id.bottom_bar_duration_separate_view);
        Resources resources = getResources();
        PlaySeekBar playSeekBar = this.j;
        int color = resources.getColor(R.color.downloadvod_player_seek_bar_progress);
        int color2 = resources.getColor(R.color.downloadvod_player_seek_bar_secondary_progress);
        int color3 = resources.getColor(R.color.downloadvod_player_seek_bar_background);
        playSeekBar.b = new Paint();
        playSeekBar.b.setColor(color3);
        playSeekBar.a = new Paint();
        playSeekBar.a.setColor(color);
        playSeekBar.c = new Paint();
        playSeekBar.c.setColor(color2);
        playSeekBar.invalidate();
        this.j.setTrackStrokeSize(DipPixelUtil.dip2px(2.0f));
        this.j.setEnabled(false);
        this.e.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.j.setOnSeekBarChangeListener(new a(this));
    }

    public static String a(int i) {
        i /= 1000;
        if (i < 0) {
            return "00:00";
        }
        int i2 = i / DateTimeUtil.HOUR_SECOND;
        int i3 = (i / 60) % 60;
        i %= 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (i2 > 0) {
            stringBuilder.append(i2 < 10 ? "0" : "");
            stringBuilder.append(i2);
            stringBuilder.append(Constants.COLON_SEPARATOR);
        }
        stringBuilder.append(i3 < 10 ? "0" : "");
        stringBuilder.append(i3);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(i < 10 ? "0" : "");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public final void a(int i, int i2, int i3) {
        this.j.setMax(i);
        if (i > 0) {
            this.h.setText(a(i));
        } else {
            this.h.setText("");
        }
        if (i2 > 0) {
            this.i.setText(a(i2));
            if (this.n == 0) {
                this.j.setProgress(i2);
            }
        } else {
            this.i.setText("");
        }
        if (i3 >= 0) {
            this.j.setSecondaryProgress(i3);
        }
        if (this.m != 0) {
            if (this.g != 0) {
                this.m.setVisibility(0);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void setCacheProgress(PlayProgressRanges playProgressRanges) {
        if (playProgressRanges != null) {
            PlaySeekBar playSeekBar = this.j;
            List list = playProgressRanges.mRanges;
            long j = playProgressRanges.mLength;
            if (list == null && j < 0) {
                list = new ArrayList();
                playProgressRanges = new TaskRangeInfo();
                playProgressRanges.setStartPosition(0);
                playProgressRanges.setLength(1);
                list.add(playProgressRanges);
                j = 1;
            }
            if (j > 0) {
                playSeekBar.d = list;
                playSeekBar.e = j;
            }
        }
    }

    public void setPlayPauseButtonType(int i) {
        if (i == 0) {
            this.l = 0;
            this.e.setImageResource(R.drawable.vod_player_btn_play_selector);
            return;
        }
        if (i == 1) {
            this.l = 1;
            this.e.setImageResource(R.drawable.vod_player_btn_pause_selector);
        }
    }

    public void setFullScreenButtonEnabled(boolean z) {
        this.k.setEnabled(z);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.bottom_bar_btn_play_pause) {
            if (view == R.id.full_screen_btn) {
                if (this.f != null) {
                    this.f.e();
                }
            }
        } else if (this.f != null) {
            if (this.l == null) {
                this.f.b();
            } else if (this.l == 1) {
                this.f.c();
            }
        }
    }

    public void setIViewStateChangeListener(a aVar) {
        this.o = aVar;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.o != null) {
            this.o.a(i == 0 ? 1 : 0);
        }
    }

    public void setProgressBarEnabled(boolean z) {
        this.j.setEnabled(z);
    }

    public void setFullScreeBtnVisible(boolean z) {
        if (this.k != null) {
            this.k.setVisibility(z ? true : false);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.d.removeView(this.j);
            this.a.addView(this.j);
            LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.width = -1;
            this.j.setLayoutParams(layoutParams);
            this.c.setBackgroundResource(R.drawable.vod_player_bottom_bar_bg);
            return;
        }
        this.a.removeView(this.j);
        this.d.addView(this.j, 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.setMargins((int) getContext().getResources().getDimension(R.dimen.vod_player_bottom_seek_bar_margin), 0, (int) getContext().getResources().getDimension(R.dimen.vod_player_bottom_seek_bar_margin), 0);
        layoutParams2.width = 0;
        layoutParams2.weight = 1.0f;
        this.j.setLayoutParams(layoutParams2);
        this.c.setBackgroundResource(R.drawable.downloadvod_player_bg_bottom_bar);
        this.m.setVisibility(8);
    }
}
